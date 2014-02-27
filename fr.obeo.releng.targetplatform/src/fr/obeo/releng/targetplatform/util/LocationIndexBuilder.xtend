package fr.obeo.releng.targetplatform.util

import com.google.common.collect.ArrayListMultimap
import com.google.common.collect.Multimaps
import fr.obeo.releng.targetplatform.targetplatform.IncludeDeclaration
import fr.obeo.releng.targetplatform.targetplatform.TargetPlatform
import java.util.LinkedList
import java.util.Set
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.EcoreUtil2
import org.eclipse.xtext.scoping.impl.ImportUriResolver

class LocationIndexBuilder {
	
	val ImportUriResolver resolver;
	
	new(ImportUriResolver resolver) {
		this.resolver = resolver;
	}
	
	def getLocationIndex(TargetPlatform targetPlatform) {
		val locationList = targetPlatform.getLocations()
		val locationIndex = ArrayListMultimap.create(Multimaps.index(locationList, [uri]))
		
		getImportedTargetPlatforms(targetPlatform).map[locations].flatten.forEach[
			locationIndex.put(it.uri, it)
		]
		
		return locationIndex;
	}

	def getImportedTargetPlatforms(TargetPlatform targetPlatform) {
		val acc = newLinkedHashSet();
		val s = newLinkedList();
		return 
			if (checkIncludeCycle(targetPlatform, acc, s)) {
				newImmutableList()
			} else {
				acc
			}
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