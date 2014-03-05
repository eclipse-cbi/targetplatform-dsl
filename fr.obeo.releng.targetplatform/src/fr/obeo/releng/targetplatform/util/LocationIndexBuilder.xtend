package fr.obeo.releng.targetplatform.util

import com.google.common.collect.LinkedListMultimap
import com.google.common.collect.Lists
import com.google.common.collect.Multimaps
import com.google.inject.Inject
import fr.obeo.releng.targetplatform.targetplatform.IncludeDeclaration
import fr.obeo.releng.targetplatform.targetplatform.TargetPlatform
import java.util.LinkedList
import java.util.Set
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.EcoreUtil2
import org.eclipse.xtext.scoping.impl.ImportUriResolver

class LocationIndexBuilder {
	
	@Inject
	ImportUriResolver resolver;
	
	def getLocationIndex(TargetPlatform targetPlatform) {
		val locationList = Lists.newArrayList(targetPlatform.locations).reverse
		val locationIndex = LinkedListMultimap.create(Multimaps.index(locationList, [uri]))
		
		getImportedTargetPlatforms(targetPlatform).map[
			Lists.newArrayList(locations).reverse
		].flatten.forEach[
			locationIndex.put(it.uri, it)
		]
		
		return locationIndex;
	}

	/**
	 * Returns all imported target platforms in a BSF fashion. The returned collection has 
	 * an iteration order reflecting the import overriding: the last import override precedent ones
	 * and the deepest import is of least importance. E.g.
	 * A includes B, C and D
	 * B includes E, F and G
	 * C includes H, I and J
	 * D includes K, L and M
	 * 
	 * The returned collection for A is : D, C, B, M, L, K, J, I, H, G, F, E 
	 */
	def getImportedTargetPlatforms(TargetPlatform targetPlatform) {
		val visited = newLinkedHashSet();
		val queue = newLinkedList();
		val includeRet = newLinkedList();
		queue.addLast(targetPlatform)
		visited.add(targetPlatform)
		while(!queue.empty) {
			val tr = newLinkedList();
			val t = queue.removeLast
			for(unvisited : t.includes.map[getImportedTargetPlatform(t.eResource, it)].filterNull) {
				if (!visited.contains(unvisited)) {
					visited.add(unvisited)
					queue.addLast(unvisited)
					tr.addFirst(unvisited)
				}
			}
			includeRet.addAll(tr)
		}
		return includeRet
	}

	def checkIncludeCycle(TargetPlatform targetPlatform) {
		val acc = newLinkedHashSet();
		val s = newLinkedList();
		return 
			if (checkIncludeCycle(targetPlatform, acc, s)) {
				s.reverse
			} else {
				newImmutableList()
			}
	}
	
	private def boolean checkIncludeCycle(TargetPlatform targetPlatform, Set<TargetPlatform> visited, LinkedList<TargetPlatform> s) {
		s.addFirst(targetPlatform)
		val context = targetPlatform.eResource
		val includedTPs = targetPlatform.includes.map[getImportedTargetPlatform(context, it)].filterNull.toSet
		for(includedTP : includedTPs) {
			if (s.contains(includedTP)) {
				s.addFirst(includedTP)
				return true
			}
			
			visited.add(includedTP)
			
			if (checkIncludeCycle(includedTP, visited, s)) {
				return true;
			}
		}
		
		s.removeFirst
		return false
	}

	def TargetPlatform getImportedTargetPlatform(Resource context, IncludeDeclaration include) {
		var TargetPlatform ret = null;
		val resource = EcoreUtil2.getResource(context, resolver.resolve(include));
		var root = resource?.getContents()?.head;
		if (root instanceof TargetPlatform) {
			ret = root as TargetPlatform;
		}
		return ret;
	}
}