package fr.obeo.releng.targetplatform.util

import com.google.inject.Inject
import fr.obeo.releng.targetplatform.TargetContent
import fr.obeo.releng.targetplatform.TargetPlatform
import fr.obeo.releng.targetplatform.TargetPlatformFactory
import fr.obeo.releng.targetplatform.VarCall
import fr.obeo.releng.targetplatform.VarDefinition
import java.util.List
import java.util.Set
import org.eclipse.emf.common.util.EList

class CompositeElementResolver {
	
	@Inject
	LocationIndexBuilder locationIndexBuilder
	
	@Inject
	ImportVariableManager importVariableManager;
	
	/* Composite elements are string defined by a concatenation of static string and variable call:
	 * "string1" + ${var1} + "aaa" + ${var2} +... */ 
	def void resolveCompositeElements(TargetPlatform targetPlatform) {
		if (targetPlatform.compositeElementsResolved == true) {
			return
		}
		
		overrideVariableDefinition(targetPlatform)
		
		searchAndAppendDefineFromIncludedTpd(targetPlatform)
		resolveLocations(targetPlatform)
		val importedTargetPlatforms = locationIndexBuilder.getImportedTargetPlatformsDoNotResolveCompositeElement(targetPlatform)
		importedTargetPlatforms.forEach[
			resolveLocations(it)
		]
	}
	
	private def void overrideVariableDefinition(TargetPlatform targetPlatform) {
		val alreadyVisitedTarget = newHashSet()
		overrideVariableDefinition(targetPlatform, alreadyVisitedTarget)
	}
	
	/* Override value of variable definition with command line or environment variable */
	private def void overrideVariableDefinition(TargetPlatform targetPlatform, Set<TargetPlatform> alreadyVisitedTarget) {
		
		alreadyVisitedTarget.add(targetPlatform)
		
		targetPlatform.contents
			.filter[
				it instanceof VarDefinition
			].forEach[
				val varDef = it as VarDefinition
				val varDefName = varDef.name
				
				val variableValue = importVariableManager.getVariableValue(varDefName)
				if (variableValue !== null) {
					varDef.overrideValue = variableValue
				}
			]

		val directlyImportedTargetPlatforms = searchDirectlyImportedTpd(targetPlatform)
		directlyImportedTargetPlatforms
			.filter[
				//Prevent from circular include
				!alreadyVisitedTarget.contains(it)
			]
			.forEach[
				overrideVariableDefinition(it, newHashSet(alreadyVisitedTarget))
			]
	}
	
	/* Resolve location ("location" directive) means resolve variable call used in location declaration */
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
	
	/* Search and append to the list of "define": variable definition of the current tpd file (targetPlatform)
	 * the list of "define" found in sub tpd: imported with "include" directive */
	private def void searchAndAppendDefineFromIncludedTpd(TargetPlatform targetPlatform, Set<TargetPlatform> alreadyVisitedTarget) {
		val ImportedDefineFromSubTpd = newHashSet()
		val processedTargetPlatform = newLinkedList()
		
		alreadyVisitedTarget.add(targetPlatform)
		
		var directlyImportedTargetPlatforms = searchDirectlyImportedTpd(targetPlatform)
		
		while(directlyImportedTargetPlatforms.size > processedTargetPlatform.size) {
			directlyImportedTargetPlatforms
				.filter[
					//Prevent from circular include
					!alreadyVisitedTarget.contains(it)
				]
				.filter[
					!processedTargetPlatform.contains(it)
				]
				.forEach[
					var notProcessedTargetPlatform = it
					notProcessedTargetPlatform.reset
					overrideVariableDefinition(notProcessedTargetPlatform)
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
	
	/* Targets that are directly imported, with an "include" directive present in the current
	 * target: "targetPlatform". Do not look for target imported through an imported target */
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
					currentImportedDefineCopy.value = currentImportedDefine.value.copy
					currentImportedDefineCopy.overrideValue = currentImportedDefine.overrideValue
					currentImportedDefineCopy.imported = true
					toBeAddedDefine.add(currentImportedDefineCopy)
				}
			]
		targetContent.addAll(toBeAddedDefine)
		updateVariableDefinition(targetContent)
	}
	
	/*
	 * @param targetContent Elements contained in the target, we only processed variable definition.
	 * 
	 * This method "updateVariableDefinition" is called after we have imported each variable definition from subtarget
	 * 
	 * When a variable definition is copied into another target, if it contains some variable calls,
	 * we eventually need to update them
	 * 
	 * target "mainTpd"
	 * include "subTpd.tpd"
	 * define var1 = ${var2}
	 * define var2b = "value2"
	 * 
	 * target "subTpd"
	 * define var2 = ${var2b}
	 * define var2b = "value2Sub"
	 * 
	 * Only var2 is copied in "mainTpd" (var2b is overloaded in "mainTpd"). But (before import)
	 * var2 refers to var2b of "subTpd", hence if we simply copy it into "mainTpd", var1 will take
	 * the value "value2Sub" instead of "value2" => We have to update the newly created var2 in
	 * "mainTpd" to make it refer to var2b of "mainTpd"
	 */
	private def void updateVariableDefinition(EList<TargetContent> targetContent) {
		for (varDef : targetContent) {
			if (varDef instanceof VarDefinition) {
				for (stringPart : varDef.value.stringParts) {
					if (stringPart instanceof VarCall) {
						var varCall = stringPart as VarCall
						updateVariableCall(varCall, targetContent)
					}
				}
			}
		}
	}
	
	private def void updateVariableCall(VarCall varCall, EList<TargetContent> targetContent) {
		for (varDef : targetContent) {
			if (varDef instanceof VarDefinition) {
				if (varCall.varName.name == varDef.name) {
					varCall.originalVarName = varCall.varName
					varCall.varName = varDef
					varCall.updated = true
				}
			}
		}
	}
	
	def List<VarDefinition> checkVariableDefinitionCycle(VarDefinition varDef) {
		varDef.checkVarCycle
		return varDef.varDefCycle
	}
}