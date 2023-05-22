/**
 * Copyright (c) 2012-2014 Obeo and others.
 *
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Mikael Barbero (Obeo) - initial API and implementation
 *     Hannes Niederhausen (itemis AG) - added generation of maven locations
 */
package org.eclipse.cbi.targetplatform.pde

import org.eclipse.cbi.targetplatform.model.Option
import org.eclipse.cbi.targetplatform.resolved.ResolvedLocation
import org.eclipse.cbi.targetplatform.resolved.ResolvedMavenLocation
import org.eclipse.cbi.targetplatform.resolved.ResolvedTargetPlatform

import static com.google.common.base.Preconditions.*

class TargetDefinitionGenerator {


	def String generate(ResolvedTargetPlatform targetPlatform, int sequenceNumber) {
		checkNotNull(targetPlatform)
		val numLocations = targetPlatform.locations.size+targetPlatform.mavenLocations.size
		'''
		<?xml version="1.0" encoding="UTF-8" standalone="no"?>
		<?pde?>
		<!-- generated with https://github.com/eclipse-cbi/targetplatform-dsl -->
		<target name="«targetPlatform.name»" sequenceNumber="«sequenceNumber»">
		  «IF numLocations>0»
		  <locations>
		    «FOR location : targetPlatform.locations»
		    «generateLocation(targetPlatform, location)»
		    «ENDFOR»
		    «FOR mvnLocation : targetPlatform.mavenLocations»
		    «generateMavenLocation(targetPlatform, mvnLocation)»
		    «ENDFOR»
		  </locations>
		  «ENDIF»
		  «IF (targetPlatform.environment !== null &&
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
		  «IF (targetPlatform.environment !== null && !targetPlatform.environment.targetJRE.nullOrEmpty)»
		  <targetJRE path="«targetPlatform.environment.targetJRE»"/>
		  «ENDIF»
		</target>
		'''
	}

	def generateMavenLocation(ResolvedTargetPlatform platform, ResolvedMavenLocation mavenLocation) {

		val scopeValue = mavenLocation.scope
		val inclSource = mavenLocation.includeSources
		val missingManifest = mavenLocation.missingManifest
		val depDepth = mavenLocation.dependencyDepth
		val label = mavenLocation.label
		val genFeature = mavenLocation.generatedFeature

		'''
		<location includeDependencyDepth="«depDepth»" includeDependencyScopes="«scopeValue»" includeSource="«inclSource»" missingManifest="«missingManifest»" type="Maven" label="«label»">
		  «IF genFeature!==null»
		  <feature id="«genFeature.id»" label="«genFeature.name»" provider-name="«genFeature.vendor»" version="«genFeature.version»">
		    «FOR iu:genFeature.additionalBundles»
		    <plugin download-size="0" id="«iu.ID»" install-size="0" unpack="false" version="0.0.0"/>
		    «ENDFOR»
		  </feature>
		  «ENDIF»
		  <dependencies>
		    «FOR dep:mavenLocation.mavenDependencies»
		    <dependency>
		      <groupId>«dep.groupId»</groupId>
		      <artifactId>«dep.artifactId»</artifactId>
		      <version>«dep.version»</version>
		      «IF dep.hasClassifier»
		      <classifier>«dep.classifier»</classifier>
		      «ENDIF»
		      <type>«dep.type»</type>
		    </dependency>
		    «ENDFOR»
		  </dependencies>
		  «IF mavenLocation.hasAdditionalRepositories»
		  <repositories>
		    «FOR repEntry : mavenLocation.repositoryMap.entrySet»
		    <repository>
		      <id>«repEntry.key»</id>
		      <url>«repEntry.value»</url>
		    </repository>
		    «ENDFOR»
		  </repositories>
		  «ENDIF»
		</location>
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
