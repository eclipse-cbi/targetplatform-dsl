/*******************************************************************************
 * Copyright (c) 2012-2014 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Mikael Barbero (Obeo) - initial API and implementation
 *******************************************************************************/
package fr.obeo.releng.targetplatform.util

import com.google.common.collect.LinkedListMultimap
import com.google.common.collect.ListMultimap
import com.google.common.collect.Multimaps
import com.google.inject.Inject
import fr.obeo.releng.targetplatform.IncludeDeclaration
import fr.obeo.releng.targetplatform.Location
import fr.obeo.releng.targetplatform.TargetPlatform
import fr.obeo.releng.targetplatform.TargetPlatformFactory
import fr.obeo.releng.targetplatform.VarDefinition
import java.util.LinkedList
import java.util.List
import java.util.Set
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.EcoreUtil2
import org.eclipse.xtext.scoping.impl.ImportUriResolver

class LocationIndexBuilder {
	
	@Inject
	ImportUriResolver resolver;
	
	def ListMultimap<String, Location> getLocationIndex(TargetPlatform targetPlatform) {
		resolveCompositeElements(targetPlatform)
		
		val locationList = getLocations(
			newLinkedHashSet(targetPlatform), 
			newLinkedList(targetPlatform)
		)
		return LinkedListMultimap.create(Multimaps.index(locationList, [uri]))
	}
	
	def void resolveCompositeElements(TargetPlatform targetPlatform) {
		if (targetPlatform.compositeElementsResolved == true) {
			return
		}
		
		searchAndAppendDefineFromIncludedTpd(targetPlatform)
		resolveLocations(targetPlatform)
		val importedTargetPlatforms = getImportedTargetPlatforms(targetPlatform)
		importedTargetPlatforms.forEach[
			resolveLocations(it)
		]
	}
	
	private def void resolveLocations(TargetPlatform targetPlatform) {
		targetPlatform.locations.forEach[
			it.resolveUri
			it.resolveIUsVersion
		]
		targetPlatform.compositeElementsResolved = true
	}
	
	private def void searchAndAppendDefineFromIncludedTpd(TargetPlatform targetPlatform) {
		val alreadyVisitedTarget = newHashSet()
		searchAndAppendDefineFromIncludedTpd(targetPlatform, alreadyVisitedTarget)
	}
	
	private def void searchAndAppendDefineFromIncludedTpd(TargetPlatform targetPlatform, Set<TargetPlatform> alreadyVisitedTarget) {
		val ImportedDefineFromSubTpd = newHashSet()
		val processedTargetPlatform = newLinkedList()
		
		alreadyVisitedTarget.add(targetPlatform)
		
		var directlyImportedTargetPlatforms = searchDirectlyImportedTpd(targetPlatform)
		
		while(directlyImportedTargetPlatforms.size > processedTargetPlatform.size) {
			directlyImportedTargetPlatforms
				.filter[
					//Prevent of circular include
					!alreadyVisitedTarget.contains(it)
				]
				.filter[
					!processedTargetPlatform.contains(it)
				]
				.forEach[
					var notProcessedTargetPlatform = it
					searchAndAppendDefineFromIncludedTpd(notProcessedTargetPlatform, newHashSet(alreadyVisitedTarget))
					notProcessedTargetPlatform.contents.forEach[
						if (it instanceof VarDefinition) {
							ImportedDefineFromSubTpd.add(it)
						}
					]
				]
			val newlyProcessedTarget = directlyImportedTargetPlatforms
							.filter[
								!processedTargetPlatform.contains(it)
							]
							.toSet
			processedTargetPlatform.addAll(newlyProcessedTarget)
			mergeImportedDefine(targetPlatform, ImportedDefineFromSubTpd)
			directlyImportedTargetPlatforms = searchDirectlyImportedTpd(targetPlatform)
		}
	}
	
	private def List<TargetPlatform> searchDirectlyImportedTpd(TargetPlatform targetPlatform) {
		targetPlatform.includes
			.map[
				getImportedTargetPlatform(targetPlatform.eResource, it)
			]
			.filter[
				it !== null
			]
			.toList
	}
	
	/*
	 * "variable define" of deepest include are override by "define" of lowest level
	 */
	private def void mergeImportedDefine(TargetPlatform targetPlatform, Set<VarDefinition> ImportedDefineFromSubTpd) {
		val toBeAddedDefine = newHashSet()
		val targetContent = targetPlatform.contents
		ImportedDefineFromSubTpd
			.forEach[
				val currentImportedDefine = it
				var boolean toBeAdded = targetContent
				.filter[
					it instanceof VarDefinition
				]
				.forall[
					val alreadyExistingDefine = it as VarDefinition
					val varName = alreadyExistingDefine.name
					!currentImportedDefine.name.equals(varName)
				]
				if (toBeAdded) {
					val currentImportedDefineCopy = TargetPlatformFactory.eINSTANCE.createVarDefinition
					currentImportedDefineCopy.name = currentImportedDefine.name
					currentImportedDefineCopy.value = currentImportedDefine.value
					toBeAddedDefine.add(currentImportedDefineCopy)
				}
			]
		targetContent.addAll(toBeAddedDefine)
	}
	
	private def List<Location> getLocations(Set<TargetPlatform> visited, List<TargetPlatform> toBeVisited) {
		val locations = newArrayList()
		
		toBeVisited.forEach[
			val includes = newLinkedList
			it.contents.reverseView.forEach[content|
				if (content instanceof Location) {
					if (!includes.empty) {
						locations.addAll(getLocationFromVisitedIncludes(it, includes, visited))
						includes.clear
					}
					locations.add(content)
				} else if (content instanceof IncludeDeclaration) {
					includes.add(content)
				}
			]
			
			if (!includes.empty) {
				locations.addAll(getLocationFromVisitedIncludes(it, includes, visited))
				includes.clear
			}
		]
		return locations
	}
	
	private def getLocationFromVisitedIncludes(TargetPlatform parent, List<IncludeDeclaration> includes, Set<TargetPlatform> visited) {
		val importedLocation = includes
			.map[getImportedTargetPlatform(parent.eResource, it)]
			.filterNull
			.filter[!visited.contains(it)].toList
		
		visited.addAll(importedLocation)
		
		return getLocations(visited, importedLocation)
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
		resolveCompositeElements(targetPlatform)
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
		resolveCompositeElements(targetPlatform)
		val acc = newLinkedHashSet();
		val s = newLinkedList();
		
		searchAndAppendDefineFromIncludedTpd(targetPlatform)
		
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
		include.generateImportURI
		val resource = EcoreUtil2.getResource(context, resolver.resolve(include));
		var root = resource?.getContents()?.head;
		if (root instanceof TargetPlatform) {
			ret = root as TargetPlatform;
		}
		return ret;
	}
}