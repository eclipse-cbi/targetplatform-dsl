package fr.obeo.releng.targetplatform.util

import fr.obeo.releng.targetplatform.TargetPlatform
import java.util.List
import fr.obeo.releng.targetplatform.VarDefinition
import fr.obeo.releng.targetplatform.TargetPlatformFactory
import java.util.Set
import com.google.inject.Inject

class CompositeElementResolver {
	
	@Inject
	LocationIndexBuilder locationIndexBuilder
	
	def void resolveCompositeElements(TargetPlatform targetPlatform) {
		if (targetPlatform.compositeElementsResolved == true) {
			return
		}
		
		searchAndAppendDefineFromIncludedTpd(targetPlatform)
		resolveLocations(targetPlatform)
		val importedTargetPlatforms = locationIndexBuilder.getImportedTargetPlatforms(targetPlatform)
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
	
	package def void searchAndAppendDefineFromIncludedTpd(TargetPlatform targetPlatform) {
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
				locationIndexBuilder.getImportedTargetPlatform(targetPlatform.eResource, it)
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
}