package fr.obeo.releng.targetplatform.pde

import fr.obeo.releng.targetplatform.Option
import fr.obeo.releng.targetplatform.resolved.ResolvedLocation
import fr.obeo.releng.targetplatform.resolved.ResolvedTargetPlatform
import java.util.concurrent.TimeUnit

import static com.google.common.base.Preconditions.*

class TargetDefinitionGenerator {
	
	
	def String generate(ResolvedTargetPlatform targetPlatform) {
		checkNotNull(targetPlatform)
		
		val sequenceNumber = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis) as int
		
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