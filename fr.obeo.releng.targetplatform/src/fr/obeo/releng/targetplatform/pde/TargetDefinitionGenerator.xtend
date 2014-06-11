package fr.obeo.releng.targetplatform.pde

import fr.obeo.releng.targetplatform.Option
import fr.obeo.releng.targetplatform.resolved.ResolvedLocation
import fr.obeo.releng.targetplatform.resolved.ResolvedTargetPlatform

import static com.google.common.base.Preconditions.*

class TargetDefinitionGenerator {
	
	
	def String generate(ResolvedTargetPlatform targetPlatform, int sequenceNumber) {
		checkNotNull(targetPlatform)
		
		'''
		<?xml version="1.0" encoding="UTF-8" standalone="no"?>
		<?pde?>
		<!-- generated with https://github.com/mbarbero/fr.obeo.releng.targetplatform -->
		<target name="«targetPlatform.name»" sequenceNumber="«sequenceNumber»">
		  «IF targetPlatform.locations != null && !targetPlatform.locations.empty»
		  <locations>
		    «FOR location : targetPlatform.locations»
		    «generateLocation(targetPlatform, location)»
		    «ENDFOR»
		  </locations>
		  «ENDIF»
		  «IF (targetPlatform.environment != null && 
			  	(!targetPlatform.environment.os.nullOrEmpty || 
			  	 !targetPlatform.environment.ws.nullOrEmpty || 
			  	 !targetPlatform.environment.arch.nullOrEmpty || 
			  	 !targetPlatform.environment.nl.nullOrEmpty)
		  )»
		  <environment>
		    «IF (!targetPlatform.environment.os.nullOrEmpty)»
		    <os>«targetPlatform.environment.os»</os>
		    «ENDIF»
		    «IF (!targetPlatform.environment.ws.nullOrEmpty)»
		    <ws>«targetPlatform.environment.ws»</ws>
		    «ENDIF»
		    «IF (!targetPlatform.environment.arch.nullOrEmpty)»
		    <arch>«targetPlatform.environment.arch»</arch>
		    «ENDIF»
		    «IF (!targetPlatform.environment.nl.nullOrEmpty)»
		    <nl>«targetPlatform.environment.nl»</nl>
		    «ENDIF»
		  </environment>
		  «ENDIF»
		  «IF (targetPlatform.environment != null && !targetPlatform.environment.targetJRE.nullOrEmpty)»
		  <targetJRE path="«targetPlatform.environment.targetJRE»"/>
		  «ENDIF»
		</target>
		'''
	}
	
	private def String generateLocation(ResolvedTargetPlatform targetPlatform, ResolvedLocation location) {
		val options =
			if (!targetPlatform.options.empty) {
				targetPlatform.options
			} else {
				location.options
			}
		
		val includeMode = 'includeMode="' + (if (options.contains(Option.INCLUDE_REQUIRED)) 'planner' else 'slicer') + '"'
		val includeAllPlatforms = 'includeAllPlatforms="' + options.contains(Option.INCLUDE_ALL_ENVIRONMENTS) + '"'
		val includeSource = 'includeSource="' + options.contains(Option.INCLUDE_SOURCE) + '"'
		val includeConfigurePhase = 'includeConfigurePhase="' + options.contains(Option.INCLUDE_CONFIGURE_PHASE) + '"'
		val locationAttributes = 
				includeMode + ' ' + includeAllPlatforms +  ' ' + 
				includeSource + ' ' + includeConfigurePhase 
		 
		val repositoryAttributes = 
			'''«IF !location.ID.nullOrEmpty»id="«location.ID»" «ENDIF»location="«location.URI»"'''
			
		'''
		<location «locationAttributes» type="InstallableUnit">
		  «FOR iu : location.resolvedIUs»
		  <unit id="«iu.id»" version="«iu.version»"/>
		  «ENDFOR»
		  <repository «repositoryAttributes»/>
		</location>
		'''
	}
}