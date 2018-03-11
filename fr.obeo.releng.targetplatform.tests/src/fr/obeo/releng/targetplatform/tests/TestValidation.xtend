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
package fr.obeo.releng.targetplatform.tests

import com.google.inject.Inject
import com.google.inject.Provider
import com.google.inject.name.Named
import fr.obeo.releng.targetplatform.Environment
import fr.obeo.releng.targetplatform.IU
import fr.obeo.releng.targetplatform.IncludeDeclaration
import fr.obeo.releng.targetplatform.Location
import fr.obeo.releng.targetplatform.TargetPlatform
import fr.obeo.releng.targetplatform.tests.util.CustomTargetPlatformInjectorProvider
import fr.obeo.releng.targetplatform.validation.TargetPlatformValidator
import java.util.List
import org.eclipse.emf.common.util.Diagnostic
import org.eclipse.emf.common.util.URI
import org.eclipse.xtext.Constants
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.util.ParseHelper
import org.eclipse.xtext.junit4.validation.ValidatorTester
import org.eclipse.xtext.resource.XtextResourceSet
import org.eclipse.xtext.validation.AbstractValidationDiagnostic
import org.eclipse.xtext.validation.EValidatorRegistrar
import org.eclipse.xtext.validation.FeatureBasedDiagnostic
import org.junit.Test
import org.junit.runner.RunWith

import static org.junit.Assert.*
import org.eclipse.xtext.validation.RangeBasedDiagnostic
import fr.obeo.releng.targetplatform.Options
import fr.obeo.releng.targetplatform.Option
import fr.obeo.releng.targetplatform.util.LocationIndexBuilder
import org.junit.Ignore

@InjectWith(typeof(CustomTargetPlatformInjectorProvider))
@RunWith(typeof(XtextRunner))
class TestValidation {
	
	@Inject
	ParseHelper<TargetPlatform> parser
	
	@Inject
	TargetPlatformValidator validator
	
	@Inject
	EValidatorRegistrar validatorRegistrar
	
	@Inject
	Provider<XtextResourceSet> resourceSetProvider;
	
	@Inject
	LocationIndexBuilder indexBuilder
	
	@Inject
	@Named(Constants::LANGUAGE_NAME)
	String languageName
	
	@Test
	def checkAllEnvAndRequiredAreSelfExluding1() {
		val tester = new ValidatorTester(validator, validatorRegistrar, languageName)
		val targetPlatform = parser.parse('''
			target "a target platform"

			location "my location URI" {
				with source, allEnvironments, requirements, configurePhase
				org.eclipse.emf.sdk.feature.group;version="[2.9.0,3.0.0)"
			}
		''')
		assertTrue(targetPlatform.eResource.errors.empty)
		val fisrtLocation = targetPlatform.locations.head
		tester.validator.checkAllEnvAndRequiredAreSelfExluding(fisrtLocation)
		for (diag: tester.diagnose.allDiagnostics.filter(typeof(AbstractValidationDiagnostic))) {
			assertTrue(diag.sourceEObject instanceof Location)
			assertEquals("my location URI", (diag.sourceEObject as Location).uri)
			assertEquals(TargetPlatformValidator::CHECK__OPTIONS_SELF_EXCLUDING_ALL_ENV_REQUIRED, 
				diag.issueCode
			)
		}
	}
	
	@Test
	def checkAllEnvAndRequiredAreSelfExluding2() {
		val tester = new ValidatorTester(validator, validatorRegistrar, languageName)
		val targetPlatform = parser.parse('''
			target "a target platform"
			with source, allEnvironments, requirements, configurePhase

			location "my location URI" {
				org.eclipse.emf.sdk.feature.group;version="[2.9.0,3.0.0)"
			}
		''')
		assertTrue(targetPlatform.eResource.errors.empty)
		tester.validator.checkAllEnvAndRequiredAreSelfExluding(targetPlatform)
		for (diag: tester.diagnose.allDiagnostics.filter(typeof(AbstractValidationDiagnostic))) {
			assertTrue(diag.sourceEObject instanceof Options)
			assertEquals(TargetPlatformValidator::CHECK__OPTIONS_SELF_EXCLUDING_ALL_ENV_REQUIRED, 
				diag.issueCode
			)
		}
	}
	
	@Test
	def checkAllEnvAndRequiredAreSelfExluding3() {
		val tester = new ValidatorTester(validator, validatorRegistrar, languageName)
		val targetPlatform = parser.parse('''
			target "a target platform"
			with requirements allEnvironments
			with source 
		''')
		assertTrue(targetPlatform.eResource.errors.empty)
		tester.validator.checkAllEnvAndRequiredAreSelfExluding(targetPlatform)
		val diag = tester.diagnose.allDiagnostics
		assertEquals(2, diag.size)
		diag.filter(typeof(AbstractValidationDiagnostic)).forEach[
			assertTrue(sourceEObject instanceof Options)
			assertEquals(TargetPlatformValidator::CHECK__OPTIONS_SELF_EXCLUDING_ALL_ENV_REQUIRED, issueCode)
		]
	}
	
	@Test
	def checkNoDuplicateOptionsOptions1() {
		val tester = new ValidatorTester(validator, validatorRegistrar, languageName)
		val targetPlatform = parser.parse('''
			target "a target platform"
			with source configurePhase source
		''')
		assertTrue(targetPlatform.eResource.errors.empty)
		tester.validator.checkNoDuplicateOptions(targetPlatform)
		val diagnostics = tester.diagnose.allDiagnostics.filter(typeof(FeatureBasedDiagnostic)).toList
		assertEquals(diagnostics.join(', '), 2, diagnostics.size)
		assertEquals(Option.INCLUDE_SOURCE, (diagnostics.get(0).sourceEObject.eGet(diagnostics.get(0).feature) as List<?>).get(diagnostics.get(0).index))
		assertEquals(Option.INCLUDE_SOURCE, (diagnostics.get(1).sourceEObject.eGet(diagnostics.get(1).feature) as List<?>).get(diagnostics.get(1).index))
	}
	
	@Test
	def checkNoDuplicateOptionsOptions2() {
		val tester = new ValidatorTester(validator, validatorRegistrar, languageName)
		val targetPlatform = parser.parse('''
			target "a target platform"
			with source configurePhase
			with configurePhase
		''')
		assertTrue(targetPlatform.eResource.errors.empty)
		tester.validator.checkNoDuplicateOptions(targetPlatform)
		val diagnostics = tester.diagnose.allDiagnostics.filter(typeof(FeatureBasedDiagnostic)).toList
		assertEquals(diagnostics.join(', '), 2, diagnostics.size)
		assertEquals(targetPlatform.contents.get(0), diagnostics.get(0).sourceEObject)
		assertEquals(Option.INCLUDE_CONFIGURE_PHASE, (diagnostics.get(0).sourceEObject.eGet(diagnostics.get(0).feature) as List<?>).get(diagnostics.get(0).index))
		assertEquals(targetPlatform.contents.get(1), diagnostics.get(1).sourceEObject)
		assertEquals(Option.INCLUDE_CONFIGURE_PHASE, (diagnostics.get(1).sourceEObject.eGet(diagnostics.get(1).feature) as List<?>).get(diagnostics.get(1).index))
	}
	
	@Test
	def testcheckIDUniqueOnAllLocations1() {
		val tester = new ValidatorTester(validator, validatorRegistrar, languageName)
		val targetPlatform = parser.parse('''
			target "a target platform"
			location "mylocationURI"
			location "mylocationURI2"
		''')
		assertTrue(targetPlatform.eResource.errors.empty)
		tester.validator.checkIDUniqueOnAllLocations(targetPlatform)
		assertTrue(tester.diagnose.allDiagnostics.empty)
	}
	
	@Test
	def testcheckIDUniqueOnAllLocations2() {
		val tester = new ValidatorTester(validator, validatorRegistrar, languageName)
		val targetPlatform = parser.parse('''
			target "a target platform"
			location A "mylocationURI"
			location A "mylocationURI2"
		''')
		assertTrue(targetPlatform.eResource.errors.empty)
		tester.validator.checkIDUniqueOnAllLocations(targetPlatform)
		val diagnotics = tester.diagnose.allDiagnostics.filter(typeof(AbstractValidationDiagnostic)).toList
		assertEquals(2, diagnotics.size)
		assertTrue(diagnotics.forall[sourceEObject instanceof Location])
		diagnotics.forEach[
			assertEquals(TargetPlatformValidator::CHECK__LOCATION_ID_UNIQNESS, issueCode)
		]
		assertEquals("mylocationURI2", (diagnotics.get(0).sourceEObject as Location).uri)
		assertEquals("mylocationURI", (diagnotics.get(1).sourceEObject as Location).uri)
	}
	
	@Test
	def testcheckIDUniqueOnAllLocations3() {
		val tester = new ValidatorTester(validator, validatorRegistrar, languageName)
		val targetPlatform = parser.parse('''
			target "a target platform"
			location A "mylocationURI"
			location A "mylocationURI2"
			location "mylocationURI3"
		''')
		assertTrue(targetPlatform.eResource.errors.empty)
		tester.validator.checkIDUniqueOnAllLocations(targetPlatform)
		val diagnotics = tester.diagnose.allDiagnostics.filter(typeof(AbstractValidationDiagnostic)).toList
		assertEquals(2, diagnotics.size)
		assertTrue(diagnotics.forall[sourceEObject instanceof Location])
		diagnotics.forEach[
			assertEquals(TargetPlatformValidator::CHECK__LOCATION_ID_UNIQNESS, issueCode)
		]
		assertEquals("mylocationURI2", (diagnotics.get(0).sourceEObject as Location).uri)
		assertEquals("mylocationURI", (diagnotics.get(1).sourceEObject as Location).uri)
	}
	
	@Test
	def testcheckIDUniqueOnAllLocations4() {
		val tester = new ValidatorTester(validator, validatorRegistrar, languageName)
		val targetPlatform = parser.parse('''
			target "a target platform"
			location A "mylocationURI"
			location B "mylocationURI"
		''')
		assertTrue(targetPlatform.eResource.errors.empty)
		tester.validator.checkIDUniqueOnAllLocations(targetPlatform)
		val diagnotics = tester.diagnose.allDiagnostics.filter(typeof(AbstractValidationDiagnostic)).toList
		assertEquals(0, diagnotics.size)
	}
	
	@Test
	def testcheckIDUniqueOnAllLocations5() {
		val tester = new ValidatorTester(validator, validatorRegistrar, languageName)
		val targetPlatform = parser.parse('''
			target "a target platform"
			location A "mylocationURI"
			location "mylocationURI"
		''')
		assertTrue(targetPlatform.eResource.errors.empty)
		tester.validator.checkIDUniqueOnAllLocations(targetPlatform)
		val diagnotics = tester.diagnose.allDiagnostics.filter(typeof(AbstractValidationDiagnostic)).toList
		assertEquals(0, diagnotics.size)
	}
	
	@Test
	def testcheckIDUniqueOnAllLocations6() {
		val tester = new ValidatorTester(validator, validatorRegistrar, languageName)
		val targetPlatform = parser.parse('''
			target "a target platform"
			location "mylocationURI"
			location "mylocationURI"
		''')
		assertTrue(targetPlatform.eResource.errors.empty)
		tester.validator.checkIDUniqueOnAllLocations(targetPlatform)
		val diagnotics = tester.diagnose.allDiagnostics.filter(typeof(AbstractValidationDiagnostic)).toList
		assertEquals(0, diagnotics.size)
	}
	
	@Test
	def testcheckIDUniqueOnAllLocations7() {
		val tester = new ValidatorTester(validator, validatorRegistrar, languageName)
		val resourceSet = resourceSetProvider.get;
		val tpa = parser.parse('''
			target "tp.a"
			include "b.tpd"
			location "locationURI1"
		''', URI.createURI("tmp:/a.tpd"), resourceSet);
		parser.parse('''
			target "tp.b"
			location "locationURI1"
		''', URI.createURI("tmp:/b.tpd"), resourceSet);

		assertTrue(tpa.eResource.errors.empty)
		tester.validator.checkIDUniqueOnAllLocations(tpa)
		var diagnotics = tester.diagnose.allDiagnostics.filter(typeof(AbstractValidationDiagnostic)).toList
		assertEquals(0, diagnotics.size)
	}
	
	@Test
	def testcheckIDUniqueOnAllLocations8() {
		val tester = new ValidatorTester(validator, validatorRegistrar, languageName)
		val resourceSet = resourceSetProvider.get;
		val tpa = parser.parse('''
			target "tp.a"
			include "b.tpd"
			location A "locationURI1"
		''', URI.createURI("tmp:/a.tpd"), resourceSet);
		val tpb = parser.parse('''
			target "tp.b"
			location A "locationURI2"
		''', URI.createURI("tmp:/b.tpd"), resourceSet);

		assertTrue(tpa.eResource.errors.empty)
		tester.validator.checkIDUniqueOnAllLocations(tpa)
		var diagnotics = tester.diagnose.allDiagnostics.filter(typeof(AbstractValidationDiagnostic)).toList
		assertEquals(2, diagnotics.size)
		
		assertTrue(diagnotics.get(0).sourceEObject instanceof Location)
		assertEquals(TargetPlatformValidator::CHECK__LOCATION_ID_UNIQNESS, diagnotics.get(0).issueCode)
		assertEquals("locationURI1", (diagnotics.get(0).sourceEObject as Location).uri)
		
		assertTrue(diagnotics.get(1).sourceEObject instanceof IncludeDeclaration)
		assertEquals(TargetPlatformValidator::CHECK__LOCATION_ID_UNIQNESS, diagnotics.get(1).issueCode)
		assertEquals("b.tpd", (diagnotics.get(1).sourceEObject as IncludeDeclaration).importURI)
		
		assertTrue(tpb.eResource.errors.empty)
		tester.validator.checkIDUniqueOnAllLocations(tpb)
		diagnotics = tester.diagnose.allDiagnostics.filter(typeof(AbstractValidationDiagnostic)).toList
		assertEquals(0, diagnotics.size)
	}
	
	@Test
	def testcheckIDUniqueOnAllLocations9() {
		val tester = new ValidatorTester(validator, validatorRegistrar, languageName)
		val resourceSet = resourceSetProvider.get;
		val tpa = parser.parse('''
			target "tp.a"
			include "b.tpd"
			location A "locationURI1"
		''', URI.createURI("tmp:/a.tpd"), resourceSet);
		val tpb = parser.parse('''
			target "tp.b"
			location A "locationURI1"
		''', URI.createURI("tmp:/b.tpd"), resourceSet);

		assertTrue(tpa.eResource.errors.empty)
		tester.validator.checkIDUniqueOnAllLocations(tpa)
		var diagnotics = tester.diagnose.allDiagnostics.filter(typeof(AbstractValidationDiagnostic)).toList
		assertEquals(0, diagnotics.size)
		
		assertTrue(tpb.eResource.errors.empty)
		tester.validator.checkIDUniqueOnAllLocations(tpb)
		diagnotics = tester.diagnose.allDiagnostics.filter(typeof(AbstractValidationDiagnostic)).toList
		assertEquals(0, diagnotics.size)
	}
	
	@Test
	def testcheckIDUniqueOnAllLocations10() {
		val tester = new ValidatorTester(validator, validatorRegistrar, languageName)
		val targetPlatform = parser.parse('''
			target "a target platform"
			location A "mylocationURI"
			location A "mylocationURI"
		''')
		assertTrue(targetPlatform.eResource.errors.empty)
		tester.validator.checkIDUniqueOnAllLocations(targetPlatform)
		val diagnotics = tester.diagnose.allDiagnostics.filter(typeof(AbstractValidationDiagnostic)).toList
		assertEquals(0, diagnotics.size)
	}

	@Test
	def checkNoLocationOptionIfGlobalOptions1() {
		val tester = new ValidatorTester(validator, validatorRegistrar, languageName)
		val targetPlatform = parser.parse('''
			target "a target platform"
			with source
			location "mylocationURI1" {with source}
		''')
		assertTrue(targetPlatform.eResource.errors.empty)
		tester.validator.checkNoLocationOptionIfGlobalOptions(targetPlatform.locations.head)
		val diagnotics = tester.diagnose.allDiagnostics.filter(typeof(AbstractValidationDiagnostic)).toList
		assertTrue(diagnotics.forall[sourceEObject instanceof Location])
		diagnotics.forEach[
			assertEquals(TargetPlatformValidator::CHECK__NO_OPTIONS_ON_LOCATIONS_IF_GLOBAL_OPTIONS, issueCode)
		]
		assertEquals("mylocationURI1", (diagnotics.get(0).sourceEObject as Location).uri)
	}
	
	@Test
	def checkNoLocationOptionIfGlobalOptions2() {
		val tester = new ValidatorTester(validator, validatorRegistrar, languageName)
		val targetPlatform = parser.parse('''
			target "a target platform"
			with source
			location "mylocationURI1"
		''')
		assertTrue(targetPlatform.eResource.errors.empty)
		tester.validator.checkNoLocationOptionIfGlobalOptions(targetPlatform.locations.head)
		val diagnotics = tester.diagnose.allDiagnostics.filter(typeof(AbstractValidationDiagnostic)).toList
		assertEquals(0, diagnotics.size)
	}
	
	@Test
	def checkNoLocationOptionIfGlobalOptions3() {
		val tester = new ValidatorTester(validator, validatorRegistrar, languageName)
		val targetPlatform = parser.parse('''
			target "a target platform"
			with source
			location "mylocationURI1" {with source}
		''')
		assertTrue(targetPlatform.eResource.errors.empty)
		tester.validator.checkNoLocationOptionIfGlobalOptions(targetPlatform.locations.head)
		val diagnotics = tester.diagnose.allDiagnostics.filter(typeof(AbstractValidationDiagnostic)).toList
		assertTrue(diagnotics.forall[sourceEObject instanceof Location])
		diagnotics.forEach[
			assertEquals(TargetPlatformValidator::CHECK__NO_OPTIONS_ON_LOCATIONS_IF_GLOBAL_OPTIONS, issueCode)
		]
		assertEquals("mylocationURI1", (diagnotics.head.sourceEObject as Location).uri)
	}
	
	@Test
	def checkOptionsOnLocationAreIdentical1() {
		val tester = new ValidatorTester(validator, validatorRegistrar, languageName)
		val targetPlatform = parser.parse('''
			target "a target platform"
			location "mylocationURI1"
			location "mylocationURI1"
		''')
		assertTrue(targetPlatform.eResource.errors.empty)
		tester.validator.checkOptionsOnLocationAreIdentical(targetPlatform)
		val diagnotics = tester.diagnose.allDiagnostics.filter(typeof(AbstractValidationDiagnostic)).toList
		assertEquals(0, diagnotics.size)
	}
	
	@Test
	def checkOptionsOnLocationAreIdentical2() {
		val tester = new ValidatorTester(validator, validatorRegistrar, languageName)
		val targetPlatform = parser.parse('''
			target "a target platform"
			with source
			location "mylocationURI1"
			location "mylocationURI1"
		''')
		assertTrue(targetPlatform.eResource.errors.empty)
		tester.validator.checkOptionsOnLocationAreIdentical(targetPlatform)
		val diagnotics = tester.diagnose.allDiagnostics.filter(typeof(AbstractValidationDiagnostic)).toList
		assertEquals(0, diagnotics.size)
	}
	
	@Test
	def checkOptionsOnLocationAreIdentical3() {
		val tester = new ValidatorTester(validator, validatorRegistrar, languageName)
		val targetPlatform = parser.parse('''
			target "a target platform"
			with source
			location "mylocationURI1" {with source}
			location "mylocationURI1" {with source}
		''')
		assertTrue(targetPlatform.eResource.errors.empty)
		tester.validator.checkOptionsOnLocationAreIdentical(targetPlatform)
		val diagnotics = tester.diagnose.allDiagnostics.filter(typeof(AbstractValidationDiagnostic)).toList
		assertEquals(0, diagnotics.size)
	}
	
	@Test
	def checkOptionsOnLocationAreIdentical4() {
		val tester = new ValidatorTester(validator, validatorRegistrar, languageName)
		val targetPlatform = parser.parse('''
			target "a target platform"
			with source
			location "mylocationURI1" {with source}
			location "mylocationURI1" {with requirements}
		''')
		assertTrue(targetPlatform.eResource.errors.empty)
		tester.validator.checkOptionsOnLocationAreIdentical(targetPlatform)
		val diagnotics = tester.diagnose.allDiagnostics.filter(typeof(AbstractValidationDiagnostic)).toList
		assertEquals(0, diagnotics.size)
	}
	
	@Test
	def checkOptionsOnLocationAreIdentical5() {
		val tester = new ValidatorTester(validator, validatorRegistrar, languageName)
		val targetPlatform = parser.parse('''
			target "a target platform"
			location "mylocationURI1" {with source}
			location "mylocationURI1" {with source}
		''')
		assertTrue(targetPlatform.eResource.errors.empty)
		tester.validator.checkOptionsOnLocationAreIdentical(targetPlatform)
		val diagnotics = tester.diagnose.allDiagnostics.filter(typeof(AbstractValidationDiagnostic)).toList
		assertEquals(0, diagnotics.size)
	}
	
	@Test
	def checkOptionsOnLocationAreIdentical6() {
		val tester = new ValidatorTester(validator, validatorRegistrar, languageName)
		val targetPlatform = parser.parse('''
			target "a target platform"
			location "mylocationURI1" {with source}
			location "mylocationURI2" {with source, requirements}
		''')
		assertTrue(targetPlatform.eResource.errors.empty)
		tester.validator.checkOptionsOnLocationAreIdentical(targetPlatform)
		val diagnotics = tester.diagnose.allDiagnostics.filter(typeof(AbstractValidationDiagnostic)).toList
		assertEquals(2, diagnotics.size)
		assertTrue(diagnotics.forall[sourceEObject instanceof Location])
		diagnotics.forEach[
			assertEquals(TargetPlatformValidator::CHECK__OPTIONS_EQUALS_ALL_LOCATIONS, issueCode)
		]
		assertEquals("mylocationURI1", (diagnotics.get(0).sourceEObject as Location).uri)
		assertEquals("mylocationURI2", (diagnotics.get(1).sourceEObject as Location).uri)
	}
	
	@Test
	def deprecateOptionsOnLocation1() {
		val tester = new ValidatorTester(validator, validatorRegistrar, languageName)
		val targetPlatform = parser.parse('''
			target "a target platform"
			location "mylocationURI1" 
		''')
		assertTrue(targetPlatform.eResource.errors.empty)
		tester.validator.deprecateOptionsOnLocation(targetPlatform.locations.head)
		val diagnotics = tester.diagnose.allDiagnostics.filter(typeof(AbstractValidationDiagnostic)).toList
		assertEquals(0, diagnotics.size)
	}
	
	@Test
	def deprecateOptionsOnLocation2() {
		val tester = new ValidatorTester(validator, validatorRegistrar, languageName)
		val targetPlatform = parser.parse('''
			target "a target platform"
			with requirements
			location "mylocationURI1" {with source}
		''')
		assertTrue(targetPlatform.eResource.errors.empty)
		tester.validator.deprecateOptionsOnLocation(targetPlatform.locations.head)
		val diagnotics = tester.diagnose.allDiagnostics.filter(typeof(AbstractValidationDiagnostic)).toList
		assertEquals(0, diagnotics.size)
	}
	
	@Test
	def deprecateOptionsOnLocation3() {
		val tester = new ValidatorTester(validator, validatorRegistrar, languageName)
		val targetPlatform = parser.parse('''
			target "a target platform"
			with requirements
			location "mylocationURI1"
		''')
		assertTrue(targetPlatform.eResource.errors.empty)
		tester.validator.deprecateOptionsOnLocation(targetPlatform.locations.head)
		val diagnotics = tester.diagnose.allDiagnostics.filter(typeof(AbstractValidationDiagnostic)).toList
		assertEquals(0, diagnotics.size)
	}
	
	@Test
	def deprecateOptionsOnLocation4() {
		val tester = new ValidatorTester(validator, validatorRegistrar, languageName)
		val targetPlatform = parser.parse('''
			target "a target platform"
			location "mylocationURI1" {with source}
		''')
		assertTrue(targetPlatform.eResource.errors.empty)
		tester.validator.deprecateOptionsOnLocation(targetPlatform.locations.head)
		val diagnotics = tester.diagnose.allDiagnostics.filter(typeof(AbstractValidationDiagnostic)).toList
		assertEquals(1, diagnotics.size)
		assertTrue(diagnotics.forall[sourceEObject instanceof Location])
		diagnotics.forEach[
			assertEquals(TargetPlatformValidator::DEPRECATE__OPTIONS_ON_LOCATIONS, issueCode)
		]
		assertEquals("mylocationURI1", (diagnotics.get(0).sourceEObject as Location).uri)
	}
	
	@Test
	def deprecateOptionsOnLocation5() {
		val tester = new ValidatorTester(validator, validatorRegistrar, languageName)
		val targetPlatform = parser.parse('''
			target "a target platform"
			location "mylocationURI1" {with source, requirements}
		''')
		assertTrue(targetPlatform.eResource.errors.empty)
		tester.validator.deprecateOptionsOnLocation(targetPlatform.locations.head)
		val diagnotics = tester.diagnose.allDiagnostics.filter(typeof(AbstractValidationDiagnostic)).toList
		assertEquals(1, diagnotics.size)
		assertTrue(diagnotics.forall[sourceEObject instanceof Location])
		diagnotics.forEach[
			assertEquals(TargetPlatformValidator::DEPRECATE__OPTIONS_ON_LOCATIONS, issueCode)
		]
		assertEquals("mylocationURI1", (diagnotics.get(0).sourceEObject as Location).uri)
	}
	
	@Test
	def deprecateIUVersionRangeWihString1() {
		val tester = new ValidatorTester(validator, validatorRegistrar, languageName)
		val targetPlatform = parser.parse('''
			target "a target platform"
			location "mylocationURI1" {
				my.iu;version="12"
			}
		''')
		assertTrue(targetPlatform.eResource.errors.empty)
		tester.validator.deprecateIUVersionRangeWihString(targetPlatform.locations.head.ius.head)
		val diagnotics = tester.diagnose.allDiagnostics.filter(typeof(AbstractValidationDiagnostic)).toList
		assertEquals(1, diagnotics.size)
		assertTrue(diagnotics.forall[sourceEObject instanceof IU])
		diagnotics.forEach[
			assertEquals(TargetPlatformValidator::DEPRECATE__STRINGS_ON_IU_VERSION, issueCode)
		]
		assertEquals("my.iu", (diagnotics.get(0).sourceEObject as IU).ID)
	}
	
	@Test
	def deprecateIUVersionRangeWihString2() {
		val tester = new ValidatorTester(validator, validatorRegistrar, languageName)
		val targetPlatform = parser.parse('''
			target "a target platform"
			location "mylocationURI1" {
				my.iu;version=12
			}
		''')
		assertTrue(targetPlatform.eResource.errors.empty)
		tester.validator.deprecateIUVersionRangeWihString(targetPlatform.locations.head.ius.head)
		val diagnotics = tester.diagnose.allDiagnostics.filter(typeof(AbstractValidationDiagnostic)).toList
		assertEquals(0, diagnotics.size)
	}
	
	@Test
	def deprecateIUVersionRangeWihString3() {
		val tester = new ValidatorTester(validator, validatorRegistrar, languageName)
		val targetPlatform = parser.parse('''
			target "a target platform"
			location "mylocationURI1" {
				my.iu
			}
		''')
		assertTrue(targetPlatform.eResource.errors.empty)
		tester.validator.deprecateIUVersionRangeWihString(targetPlatform.locations.head.ius.head)
		val diagnotics = tester.diagnose.allDiagnostics.filter(typeof(AbstractValidationDiagnostic)).toList
		assertEquals(0, diagnotics.size)
	}
	
	@Test
	def checkSameIDForAllLocationWithSameURI1() {
		val tester = new ValidatorTester(validator, validatorRegistrar, languageName)
		val targetPlatform = parser.parse('''
			target "a target platform"
			location "mylocationURI1"
		''')
		assertTrue(targetPlatform.eResource.errors.empty)
		tester.validator.checkSameIDForAllLocationWithSameURI(targetPlatform)
		val diagnotics = tester.diagnose.allDiagnostics.filter(typeof(AbstractValidationDiagnostic)).toList
		assertEquals(0, diagnotics.size)
	}
	
	@Test
	def checkSameIDForAllLocationWithSameURI2() {
		val tester = new ValidatorTester(validator, validatorRegistrar, languageName)
		val targetPlatform = parser.parse('''
			target "a target platform"
			location "mylocationURI1"
			location "mylocationURI2"
		''')
		assertTrue(targetPlatform.eResource.errors.empty)
		tester.validator.checkSameIDForAllLocationWithSameURI(targetPlatform)
		val diagnotics = tester.diagnose.allDiagnostics.filter(typeof(AbstractValidationDiagnostic)).toList
		assertEquals(0, diagnotics.size)
	}
	
	@Test
	def checkSameIDForAllLocationWithSameURI3() {
		val tester = new ValidatorTester(validator, validatorRegistrar, languageName)
		val targetPlatform = parser.parse('''
			target "a target platform"
			location "mylocationURI1"
			location "mylocationURI1"
		''')
		assertTrue(targetPlatform.eResource.errors.empty)
		tester.validator.checkSameIDForAllLocationWithSameURI(targetPlatform)
		val diagnotics = tester.diagnose.allDiagnostics.filter(typeof(AbstractValidationDiagnostic)).toList
		assertEquals(0, diagnotics.size)
	}
	
	@Test
	def checkSameIDForAllLocationWithSameURI4() {
		val tester = new ValidatorTester(validator, validatorRegistrar, languageName)
		val targetPlatform = parser.parse('''
			target "a target platform"
			location A "mylocationURI1"
			location A "mylocationURI1"
		''')
		assertTrue(targetPlatform.eResource.errors.empty)
		tester.validator.checkSameIDForAllLocationWithSameURI(targetPlatform)
		val diagnotics = tester.diagnose.allDiagnostics.filter(typeof(AbstractValidationDiagnostic)).toList
		assertEquals(0, diagnotics.size)
	}
	
	@Test
	def checkSameIDForAllLocationWithSameURI5() {
		val tester = new ValidatorTester(validator, validatorRegistrar, languageName)
		val targetPlatform = parser.parse('''
			target "a target platform"
			location A "mylocationURI"
			location A "mylocationURI1"
		''')
		assertTrue(targetPlatform.eResource.errors.empty)
		tester.validator.checkSameIDForAllLocationWithSameURI(targetPlatform)
		val diagnotics = tester.diagnose.allDiagnostics.filter(typeof(AbstractValidationDiagnostic)).toList
		assertEquals(0, diagnotics.size)
	}
	
	@Test
	def checkSameIDForAllLocationWithSameURI6() {
		val tester = new ValidatorTester(validator, validatorRegistrar, languageName)
		val targetPlatform = parser.parse('''
			target "a target platform"
			location A "mylocationURI1"
			location   "mylocationURI1"
		''')
		assertTrue(targetPlatform.eResource.errors.empty)
		tester.validator.checkSameIDForAllLocationWithSameURI(targetPlatform)
		val diagnotics = tester.diagnose.allDiagnostics.filter(typeof(AbstractValidationDiagnostic)).toList
		assertEquals(2, diagnotics.size)
		assertTrue(diagnotics.forall[sourceEObject instanceof Location])
		diagnotics.forEach[
			assertEquals(TargetPlatformValidator::CHECK__LOCATION_CONFLICTUAL_ID, issueCode)
			assertEquals("mylocationURI1", (it.sourceEObject as Location).uri)
		]
	}
	
	@Test
	def checkSameIDForAllLocationWithSameURI7() {
		val tester = new ValidatorTester(validator, validatorRegistrar, languageName)
		val targetPlatform = parser.parse('''
			target "a target platform"
			location A "mylocationURI1"
			location B "mylocationURI1"
		''')
		assertTrue(targetPlatform.eResource.errors.empty)
		tester.validator.checkSameIDForAllLocationWithSameURI(targetPlatform)
		val diagnotics = tester.diagnose.allDiagnostics.filter(typeof(AbstractValidationDiagnostic)).toList
		assertEquals(2, diagnotics.size)
		assertTrue(diagnotics.forall[sourceEObject instanceof Location])
		diagnotics.forEach[
			assertEquals(TargetPlatformValidator::CHECK__LOCATION_CONFLICTUAL_ID, issueCode)
			assertEquals("mylocationURI1", (it.sourceEObject as Location).uri)
		]
	}
	
	@Test
	def checkSameIDForAllLocationWithSameURI8() {
		val tester = new ValidatorTester(validator, validatorRegistrar, languageName)
		val resourceSet = resourceSetProvider.get;
		val tpa = parser.parse('''
			target "tp.a"
			include "b.tpd"
		''', URI.createURI("tmp:/a.tpd"), resourceSet);
		parser.parse('''
			target "tp.b"
		''', URI.createURI("tmp:/b.tpd"), resourceSet);

		assertTrue(tpa.eResource.errors.empty)
		tester.validator.checkSameIDForAllLocationWithSameURI(tpa)
		val diagnotics = tester.diagnose.allDiagnostics.filter(typeof(AbstractValidationDiagnostic)).toList
		assertEquals(0, diagnotics.size)
	}
	
	@Test
	def checkSameIDForAllLocationWithSameURI9() {
		val tester = new ValidatorTester(validator, validatorRegistrar, languageName)
		val resourceSet = resourceSetProvider.get;
		val tpa = parser.parse('''
			target "tp.a"
			include "b.tpd"
			
			location "locationURI1"
		''', URI.createURI("tmp:/a.tpd"), resourceSet);
		parser.parse('''
			target "tp.b"
		''', URI.createURI("tmp:/b.tpd"), resourceSet);

		assertTrue(tpa.eResource.errors.empty)
		tester.validator.checkSameIDForAllLocationWithSameURI(tpa)
		val diagnotics = tester.diagnose.allDiagnostics.filter(typeof(AbstractValidationDiagnostic)).toList
		assertEquals(0, diagnotics.size)
	}
	
	@Test
	def checkSameIDForAllLocationWithSameURI10() {
		val tester = new ValidatorTester(validator, validatorRegistrar, languageName)
		val resourceSet = resourceSetProvider.get;
		val tpa = parser.parse('''
			target "tp.a"
			include "b.tpd"
			location "locationURI1"
		''', URI.createURI("tmp:/a.tpd"), resourceSet);
		parser.parse('''
			target "tp.b"
			location "locationURI1"
		''', URI.createURI("tmp:/b.tpd"), resourceSet);

		assertTrue(tpa.eResource.errors.empty)
		tester.validator.checkSameIDForAllLocationWithSameURI(tpa)
		val diagnotics = tester.diagnose.allDiagnostics.filter(typeof(AbstractValidationDiagnostic)).toList
		assertEquals(0, diagnotics.size)
	}
	
	@Test
	def checkSameIDForAllLocationWithSameURI11() {
		val tester = new ValidatorTester(validator, validatorRegistrar, languageName)
		val resourceSet = resourceSetProvider.get;
		val tpa = parser.parse('''
			target "tp.a"
			include "b.tpd"
			location A "locationURI1"
		''', URI.createURI("tmp:/a.tpd"), resourceSet);
		parser.parse('''
			target "tp.b"
			location A "locationURI1"
		''', URI.createURI("tmp:/b.tpd"), resourceSet);

		assertTrue(tpa.eResource.errors.empty)
		tester.validator.checkSameIDForAllLocationWithSameURI(tpa)
		val diagnotics = tester.diagnose.allDiagnostics.filter(typeof(AbstractValidationDiagnostic)).toList
		assertEquals(0, diagnotics.size)
	}
	
	@Test
	def checkSameIDForAllLocationWithSameURI12() {
		val tester = new ValidatorTester(validator, validatorRegistrar, languageName)
		val resourceSet = resourceSetProvider.get;
		val tpa = parser.parse('''
			target "tp.a"
			include "b.tpd"
			location "locationURI1"
		''', URI.createURI("tmp:/a.tpd"), resourceSet);
		parser.parse('''
			target "tp.b"
			location A "locationURI1"
		''', URI.createURI("tmp:/b.tpd"), resourceSet);

		assertTrue(tpa.eResource.errors.empty)
		tester.validator.checkSameIDForAllLocationWithSameURI(tpa)
		val diagnotics = tester.diagnose.allDiagnostics.filter(typeof(AbstractValidationDiagnostic)).toList
		assertEquals(1, diagnotics.size)
		assertTrue(diagnotics.forall[sourceEObject instanceof Location])
		diagnotics.forEach[
			assertEquals(TargetPlatformValidator::CHECK__INCLUDED_LOCATION_CONFLICTUAL_ID, issueCode)
			assertEquals("locationURI1", (it.sourceEObject as Location).uri)
			assertEquals("tmp:/a.tpd", (it.sourceEObject as Location).eResource.URI.toString)
		]
	}
	
	@Test
	def checkSameIDForAllLocationWithSameURI13() {
		val tester = new ValidatorTester(validator, validatorRegistrar, languageName)
		val resourceSet = resourceSetProvider.get;
		val tpa = parser.parse('''
			target "tp.a"
			include "b.tpd"
			location A "locationURI1"
		''', URI.createURI("tmp:/a.tpd"), resourceSet);
		parser.parse('''
			target "tp.b"
			location "locationURI1"
		''', URI.createURI("tmp:/b.tpd"), resourceSet);

		assertTrue(tpa.eResource.errors.empty)
		tester.validator.checkSameIDForAllLocationWithSameURI(tpa)
		val diagnotics = tester.diagnose.allDiagnostics.filter(typeof(AbstractValidationDiagnostic)).toList
		assertEquals(1, diagnotics.size)
		assertTrue(diagnotics.forall[sourceEObject instanceof Location])
		diagnotics.forEach[
			assertEquals(TargetPlatformValidator::CHECK__INCLUDED_LOCATION_CONFLICTUAL_ID, issueCode)
			assertEquals("locationURI1", (it.sourceEObject as Location).uri)
			assertEquals("tmp:/a.tpd", (it.sourceEObject as Location).eResource.URI.toString)
		]
	}
	
	@Test
	def checkSameIDForAllLocationWithSameURI14() {
		val tester = new ValidatorTester(validator, validatorRegistrar, languageName)
		val resourceSet = resourceSetProvider.get;
		val tpa = parser.parse('''
			target "tp.a"
			include "b.tpd"
			location A "locationURI1"
		''', URI.createURI("tmp:/a.tpd"), resourceSet);
		parser.parse('''
			target "tp.b"
			location A "locationURI2"
		''', URI.createURI("tmp:/b.tpd"), resourceSet);

		assertTrue(tpa.eResource.errors.empty)
		tester.validator.checkSameIDForAllLocationWithSameURI(tpa)
		val diagnotics = tester.diagnose.allDiagnostics.filter(typeof(AbstractValidationDiagnostic)).toList
		assertEquals(0, diagnotics.size)
	}
	
	@Test
	def checkSameIDForAllLocationWithSameURI15() {
		val tester = new ValidatorTester(validator, validatorRegistrar, languageName)
		val resourceSet = resourceSetProvider.get;
		val tpa = parser.parse('''
			target "tp.a"
			include "b.tpd"
			location A "locationURI1"
		''', URI.createURI("tmp:/a.tpd"), resourceSet);
		parser.parse('''
			target "tp.b"
			include "c.tpd"
			location A "locationURI1"
		''', URI.createURI("tmp:/b.tpd"), resourceSet);
		parser.parse('''
			target "tp.c"
			location A "locationURI1"
		''', URI.createURI("tmp:/c.tpd"), resourceSet);

		assertTrue(tpa.eResource.errors.empty)
		tester.validator.checkSameIDForAllLocationWithSameURI(tpa)
		val diagnotics = tester.diagnose.allDiagnostics.filter(typeof(AbstractValidationDiagnostic)).toList
		assertEquals(0, diagnotics.size)
	}
	
	@Test
	def checkSameIDForAllLocationWithSameURI16() {
		val tester = new ValidatorTester(validator, validatorRegistrar, languageName)
		val resourceSet = resourceSetProvider.get;
		val tpa = parser.parse('''
			target "tp.a"
			include "b.tpd"
			location A "locationURI1"
		''', URI.createURI("tmp:/a.tpd"), resourceSet);
		val tpb = parser.parse('''
			target "tp.b"
			include "c.tpd"
			location A "locationURI1"
		''', URI.createURI("tmp:/b.tpd"), resourceSet);
		val tpc = parser.parse('''
			target "tp.c"
			location C "locationURI1"
		''', URI.createURI("tmp:/c.tpd"), resourceSet);

		assertTrue(tpa.eResource.errors.empty)
		tester.validator.checkSameIDForAllLocationWithSameURI(tpa)
		var diagnotics = tester.diagnose.allDiagnostics.filter(typeof(AbstractValidationDiagnostic)).toList
		assertEquals(1, diagnotics.size)
		assertTrue(diagnotics.forall[sourceEObject instanceof IncludeDeclaration])
		diagnotics.forEach[
			assertEquals(TargetPlatformValidator::CHECK__CONFLICTUAL_ID__BETWEEN_INCLUDED_LOCATION, issueCode)
			assertEquals("b.tpd", (it.sourceEObject as IncludeDeclaration).importURI)
			assertEquals("tmp:/a.tpd", (it.sourceEObject as IncludeDeclaration).eResource.URI.toString)
		]
		
		assertTrue(tpb.eResource.errors.empty)
		tester.validator.checkSameIDForAllLocationWithSameURI(tpb)
		diagnotics = tester.diagnose.allDiagnostics.filter(typeof(AbstractValidationDiagnostic)).toList
		assertEquals(1, diagnotics.size)
		assertTrue(diagnotics.forall[sourceEObject instanceof Location])
		diagnotics.forEach[
			assertEquals(TargetPlatformValidator::CHECK__INCLUDED_LOCATION_CONFLICTUAL_ID, issueCode)
			assertEquals("locationURI1", (it.sourceEObject as Location).uri)
			assertEquals("tmp:/b.tpd", (it.sourceEObject as Location).eResource.URI.toString)
		]
		
		assertTrue(tpc.eResource.errors.empty)
		tester.validator.checkSameIDForAllLocationWithSameURI(tpc)
		diagnotics = tester.diagnose.allDiagnostics.filter(typeof(AbstractValidationDiagnostic)).toList
		assertEquals(0, diagnotics.size)
	}
	
	@Test
	def checkSameIDForAllLocationWithSameURI17() {
		val tester = new ValidatorTester(validator, validatorRegistrar, languageName)
		val resourceSet = resourceSetProvider.get;
		val tpa = parser.parse('''
			target "tp.a"
			include "b.tpd"
			location A "locationURI1"
		''', URI.createURI("tmp:/a.tpd"), resourceSet);
		val tpb = parser.parse('''
			target "tp.b"
			include "c.tpd"
			location B "locationURI1"
		''', URI.createURI("tmp:/b.tpd"), resourceSet);
		val tpc = parser.parse('''
			target "tp.c"
			location A "locationURI1"
		''', URI.createURI("tmp:/c.tpd"), resourceSet);

		assertTrue(tpa.eResource.errors.empty)
		tester.validator.checkSameIDForAllLocationWithSameURI(tpa)
		var diagnotics = tester.diagnose.allDiagnostics.filter(typeof(AbstractValidationDiagnostic)).toList
		assertEquals(1, diagnotics.size)
		assertTrue(diagnotics.forall[sourceEObject instanceof IncludeDeclaration])
		diagnotics.forEach[
			assertEquals(TargetPlatformValidator::CHECK__CONFLICTUAL_ID__BETWEEN_INCLUDED_LOCATION, issueCode)
			assertEquals("b.tpd", (it.sourceEObject as IncludeDeclaration).importURI)
			assertEquals("tmp:/a.tpd", (it.sourceEObject as IncludeDeclaration).eResource.URI.toString)
		]
		
		assertTrue(tpb.eResource.errors.empty)
		tester.validator.checkSameIDForAllLocationWithSameURI(tpb)
		diagnotics = tester.diagnose.allDiagnostics.filter(typeof(AbstractValidationDiagnostic)).toList
		assertEquals(1, diagnotics.size)
		assertTrue(diagnotics.forall[sourceEObject instanceof Location])
		diagnotics.forEach[
			assertEquals(TargetPlatformValidator::CHECK__INCLUDED_LOCATION_CONFLICTUAL_ID, issueCode)
			assertEquals("locationURI1", (it.sourceEObject as Location).uri)
			assertEquals("tmp:/b.tpd", (it.sourceEObject as Location).eResource.URI.toString)
		]
		
		assertTrue(tpc.eResource.errors.empty)
		tester.validator.checkSameIDForAllLocationWithSameURI(tpc)
		diagnotics = tester.diagnose.allDiagnostics.filter(typeof(AbstractValidationDiagnostic)).toList
		assertEquals(0, diagnotics.size)
	}
	
	@Test
	def checkSameIDForAllLocationWithSameURI18() {
		val tester = new ValidatorTester(validator, validatorRegistrar, languageName)
		val resourceSet = resourceSetProvider.get;
		val tpa = parser.parse('''
			target "tp.a"
			include "b.tpd"
			location A "locationURI1"
		''', URI.createURI("tmp:/a.tpd"), resourceSet);
		val tpb = parser.parse('''
			target "tp.b"
			include "c.tpd"
			location A "locationURI1"
		''', URI.createURI("tmp:/b.tpd"), resourceSet);
		val tpc = parser.parse('''
			target "tp.c"
			location "locationURI1"
		''', URI.createURI("tmp:/c.tpd"), resourceSet);

		assertTrue(tpa.eResource.errors.empty)
		tester.validator.checkSameIDForAllLocationWithSameURI(tpa)
		var diagnotics = tester.diagnose.allDiagnostics.filter(typeof(AbstractValidationDiagnostic)).toList
		assertEquals(1, diagnotics.size)
		assertTrue(diagnotics.forall[sourceEObject instanceof IncludeDeclaration])
		diagnotics.forEach[
			assertEquals(TargetPlatformValidator::CHECK__CONFLICTUAL_ID__BETWEEN_INCLUDED_LOCATION, issueCode)
			assertEquals("b.tpd", (it.sourceEObject as IncludeDeclaration).importURI)
			assertEquals("tmp:/a.tpd", (it.sourceEObject as IncludeDeclaration).eResource.URI.toString)
		]
		
		assertTrue(tpb.eResource.errors.empty)
		tester.validator.checkSameIDForAllLocationWithSameURI(tpb)
		diagnotics = tester.diagnose.allDiagnostics.filter(typeof(AbstractValidationDiagnostic)).toList
		assertEquals(1, diagnotics.size)
		assertTrue(diagnotics.forall[sourceEObject instanceof Location])
		diagnotics.forEach[
			assertEquals(TargetPlatformValidator::CHECK__INCLUDED_LOCATION_CONFLICTUAL_ID, issueCode)
			assertEquals("locationURI1", (it.sourceEObject as Location).uri)
			assertEquals("tmp:/b.tpd", (it.sourceEObject as Location).eResource.URI.toString)
		]
		
		assertTrue(tpc.eResource.errors.empty)
		tester.validator.checkSameIDForAllLocationWithSameURI(tpc)
		diagnotics = tester.diagnose.allDiagnostics.filter(typeof(AbstractValidationDiagnostic)).toList
		assertEquals(0, diagnotics.size)
	}
	
	@Test
	def checkSameIDForAllLocationWithSameURI19() {
		val tester = new ValidatorTester(validator, validatorRegistrar, languageName)
		val resourceSet = resourceSetProvider.get;
		val tpa = parser.parse('''
			target "tp.a"
			include "b.tpd"
			location "locationURI1"
		''', URI.createURI("tmp:/a.tpd"), resourceSet);
		parser.parse('''
			target "tp.b"
			include "c.tpd"
			location "locationURI1"
		''', URI.createURI("tmp:/b.tpd"), resourceSet);
		parser.parse('''
			target "tp.c"
			location "locationURI1"
		''', URI.createURI("tmp:/c.tpd"), resourceSet);

		assertTrue(tpa.eResource.errors.empty)
		tester.validator.checkSameIDForAllLocationWithSameURI(tpa)
		val diagnotics = tester.diagnose.allDiagnostics.filter(typeof(AbstractValidationDiagnostic)).toList
		assertEquals(0, diagnotics.size)
	}
	
	@Test
	def checkSameIDForAllLocationWithSameURI20() {
		val tester = new ValidatorTester(validator, validatorRegistrar, languageName)
		val resourceSet = resourceSetProvider.get;
		val tpa = parser.parse('''
			target "tp.a"
			include "b.tpd"
			location "locationURI1"
		''', URI.createURI("tmp:/a.tpd"), resourceSet);
		val tpb = parser.parse('''
			target "tp.b"
			include "c.tpd"
			location "locationURI1"
		''', URI.createURI("tmp:/b.tpd"), resourceSet);
		val tpc = parser.parse('''
			target "tp.c"
			location C "locationURI1"
		''', URI.createURI("tmp:/c.tpd"), resourceSet);

		assertTrue(tpa.eResource.errors.empty)
		tester.validator.checkSameIDForAllLocationWithSameURI(tpa)
		var diagnotics = tester.diagnose.allDiagnostics.filter(typeof(AbstractValidationDiagnostic)).toList
		assertEquals(1, diagnotics.size)
		assertTrue(diagnotics.forall[sourceEObject instanceof IncludeDeclaration])
		diagnotics.forEach[
			assertEquals(TargetPlatformValidator::CHECK__CONFLICTUAL_ID__BETWEEN_INCLUDED_LOCATION, issueCode)
			assertEquals("b.tpd", (it.sourceEObject as IncludeDeclaration).importURI)
			assertEquals("tmp:/a.tpd", (it.sourceEObject as IncludeDeclaration).eResource.URI.toString)
		]
		
		assertTrue(tpb.eResource.errors.empty)
		tester.validator.checkSameIDForAllLocationWithSameURI(tpb)
		diagnotics = tester.diagnose.allDiagnostics.filter(typeof(AbstractValidationDiagnostic)).toList
		assertEquals(1, diagnotics.size)
		assertTrue(diagnotics.forall[sourceEObject instanceof Location])
		diagnotics.forEach[
			assertEquals(TargetPlatformValidator::CHECK__INCLUDED_LOCATION_CONFLICTUAL_ID, issueCode)
			assertEquals("locationURI1", (it.sourceEObject as Location).uri)
			assertEquals("tmp:/b.tpd", (it.sourceEObject as Location).eResource.URI.toString)
		]
		
		assertTrue(tpc.eResource.errors.empty)
		tester.validator.checkSameIDForAllLocationWithSameURI(tpc)
		diagnotics = tester.diagnose.allDiagnostics.filter(typeof(AbstractValidationDiagnostic)).toList
		assertEquals(0, diagnotics.size)
	}
	
	@Test
	def checkSameIDForAllLocationWithSameURI21() {
		val tester = new ValidatorTester(validator, validatorRegistrar, languageName)
		val resourceSet = resourceSetProvider.get;
		val tpa = parser.parse('''
			target "tp.a"
			include "b.tpd"
			location "locationURI1"
		''', URI.createURI("tmp:/a.tpd"), resourceSet);
		val tpb = parser.parse('''
			target "tp.b"
			include "c.tpd"
			location A "locationURI1"
		''', URI.createURI("tmp:/b.tpd"), resourceSet);
		val tpc = parser.parse('''
			target "tp.c"
			location "locationURI1"
		''', URI.createURI("tmp:/c.tpd"), resourceSet);

		assertTrue(tpa.eResource.errors.empty)
		tester.validator.checkSameIDForAllLocationWithSameURI(tpa)
		var diagnotics = tester.diagnose.allDiagnostics.filter(typeof(AbstractValidationDiagnostic)).toList
		assertEquals(1, diagnotics.size)
		assertTrue(diagnotics.forall[sourceEObject instanceof IncludeDeclaration])
		diagnotics.forEach[
			assertEquals(TargetPlatformValidator::CHECK__CONFLICTUAL_ID__BETWEEN_INCLUDED_LOCATION, issueCode)
			assertEquals("b.tpd", (it.sourceEObject as IncludeDeclaration).importURI)
			assertEquals("tmp:/a.tpd", (it.sourceEObject as IncludeDeclaration).eResource.URI.toString)
		]
		
		assertTrue(tpb.eResource.errors.empty)
		tester.validator.checkSameIDForAllLocationWithSameURI(tpb)
		diagnotics = tester.diagnose.allDiagnostics.filter(typeof(AbstractValidationDiagnostic)).toList
		assertEquals(1, diagnotics.size)
		assertTrue(diagnotics.forall[sourceEObject instanceof Location])
		diagnotics.forEach[
			assertEquals(TargetPlatformValidator::CHECK__INCLUDED_LOCATION_CONFLICTUAL_ID, issueCode)
			assertEquals("locationURI1", (it.sourceEObject as Location).uri)
			assertEquals("tmp:/b.tpd", (it.sourceEObject as Location).eResource.URI.toString)
		]
		
		assertTrue(tpc.eResource.errors.empty)
		tester.validator.checkSameIDForAllLocationWithSameURI(tpc)
		diagnotics = tester.diagnose.allDiagnostics.filter(typeof(AbstractValidationDiagnostic)).toList
		assertEquals(0, diagnotics.size)
	}
	
	@Test
	def checkImportCycle1() {
		val tester = new ValidatorTester(validator, validatorRegistrar, languageName)
		val resourceSet = resourceSetProvider.get;
		val tpa = parser.parse('''
			target "tp.a"
		''', URI.createURI("tmp:/a.tpd"), resourceSet);
		assertTrue(tpa.eResource.errors.empty)
		tester.validator.checkImportCycle(tpa)
		val diagnotics = tester.diagnose.allDiagnostics.filter(typeof(AbstractValidationDiagnostic)).toList
		assertEquals(0, diagnotics.size)
	}
	
	@Test
	def checkImportCycle2() {
		val tester = new ValidatorTester(validator, validatorRegistrar, languageName)
		val resourceSet = resourceSetProvider.get;
		val tpa = parser.parse('''
			target "tp.a"
			include "a.tpd"
		''', URI.createURI("tmp:/a.tpd"), resourceSet);
		assertTrue(tpa.eResource.errors.empty)
		tester.validator.checkImportCycle(tpa)
		val diagnotics = tester.diagnose.allDiagnostics.filter(typeof(AbstractValidationDiagnostic)).toList
		assertEquals(1, diagnotics.size)
		assertTrue(diagnotics.forall[sourceEObject instanceof IncludeDeclaration])
		diagnotics.forEach[
			assertEquals(TargetPlatformValidator::CHECK__INCLUDE_CYCLE, issueCode)
			assertEquals("a.tpd", (it.sourceEObject as IncludeDeclaration).importURI)
		]
	}
	
	@Test
	def checkImportCycle3() {
		val tester = new ValidatorTester(validator, validatorRegistrar, languageName)
		val resourceSet = resourceSetProvider.get;
		val tpa = parser.parse('''
			target "tp.a"
			include "b.tpd"
		''', URI.createURI("tmp:/a.tpd"), resourceSet);
		val tpb = parser.parse('''
			target "tp.b"
			include "a.tpd"
		''', URI.createURI("tmp:/b.tpd"), resourceSet);

		assertTrue(tpa.eResource.errors.empty)
		tester.validator.checkImportCycle(tpa)
		val diagnoticsa = tester.diagnose.allDiagnostics.filter(typeof(AbstractValidationDiagnostic)).toList
		assertEquals(1, diagnoticsa.size)
		assertTrue(diagnoticsa.forall[sourceEObject instanceof IncludeDeclaration])
		diagnoticsa.forEach[
			assertEquals(TargetPlatformValidator::CHECK__INCLUDE_CYCLE, issueCode)
			assertEquals("b.tpd", (it.sourceEObject as IncludeDeclaration).importURI)
		]
		
		assertTrue(tpb.eResource.errors.empty)
		tester.validator.checkImportCycle(tpb)
		val diagnoticsb = tester.diagnose.allDiagnostics.filter(typeof(AbstractValidationDiagnostic)).toList
		assertEquals(1, diagnoticsb.size)
		assertTrue(diagnoticsb.forall[sourceEObject instanceof IncludeDeclaration])
		diagnoticsb.forEach[
			assertEquals(TargetPlatformValidator::CHECK__INCLUDE_CYCLE, issueCode)
			assertEquals("a.tpd", (it.sourceEObject as IncludeDeclaration).importURI)
		]
	}
	
	@Test
	def checkImportCycle4() {
		val tester = new ValidatorTester(validator, validatorRegistrar, languageName)
		val resourceSet = resourceSetProvider.get;
		val tpa = parser.parse('''
			target "tp.a"
			include "b.tpd"
		''', URI.createURI("tmp:/a.tpd"), resourceSet);
		val tpb = parser.parse('''
			target "tp.b"
			include "c.tpd"
		''', URI.createURI("tmp:/b.tpd"), resourceSet);
		val tpc = parser.parse('''
			target "tp.c"
			include "a.tpd"
		''', URI.createURI("tmp:/c.tpd"), resourceSet);
		
		assertTrue(tpa.eResource.errors.empty)
		tester.validator.checkImportCycle(tpa)
		var diagnotics = tester.diagnose.allDiagnostics.filter(typeof(AbstractValidationDiagnostic)).toList
		assertEquals(1, diagnotics.size)
		assertTrue(diagnotics.forall[sourceEObject instanceof IncludeDeclaration])
		diagnotics.forEach[
			assertEquals(TargetPlatformValidator::CHECK__INCLUDE_CYCLE, issueCode)
			assertEquals("b.tpd", (it.sourceEObject as IncludeDeclaration).importURI)
		]
		
		assertTrue(tpb.eResource.errors.empty)
		tester.validator.checkImportCycle(tpb)
		diagnotics = tester.diagnose.allDiagnostics.filter(typeof(AbstractValidationDiagnostic)).toList
		assertEquals(1, diagnotics.size)
		assertTrue(diagnotics.forall[sourceEObject instanceof IncludeDeclaration])
		diagnotics.forEach[
			assertEquals(TargetPlatformValidator::CHECK__INCLUDE_CYCLE, issueCode)
			assertEquals("c.tpd", (it.sourceEObject as IncludeDeclaration).importURI)
		]
		
		assertTrue(tpb.eResource.errors.empty)
		tester.validator.checkImportCycle(tpc)
		diagnotics = tester.diagnose.allDiagnostics.filter(typeof(AbstractValidationDiagnostic)).toList
		assertEquals(1, diagnotics.size)
		assertTrue(diagnotics.forall[sourceEObject instanceof IncludeDeclaration])
		diagnotics.forEach[
			assertEquals(TargetPlatformValidator::CHECK__INCLUDE_CYCLE, issueCode)
			assertEquals("a.tpd", (it.sourceEObject as IncludeDeclaration).importURI)
		]
	}
	
	@Test
	def checkImportCycleDueToVariableDefinition() {
		val tester = new ValidatorTester(validator, validatorRegistrar, languageName)
		val resourceSet = resourceSetProvider.get;
		val compositeIncludeTarget = parser.parse('''
			target "compositeIncludeTarget"
			include "subTpd.tpd"
			include ${subDirName} "/" "subInclude.tpd"
		''', URI.createURI("tmp:/compositeIncludeTarget.tpd"), resourceSet)
		parser.parse('''
			target "subTpd"
			include "subsubTpd.tpd"
			define subDirName="subdir"
		''', URI.createURI("tmp:/subTpd.tpd"), resourceSet);
		val subIncludeCircular = parser.parse('''
			target "subInclude"
			include "../compositeIncludeTarget.tpd"
		''', URI.createURI("tmp:/subdir/subInclude.tpd"), resourceSet)
		
		assertTrue(compositeIncludeTarget.eResource.errors.empty)
		tester.validator.checkImportCycle(compositeIncludeTarget)
		var diagnotics = tester.diagnose.allDiagnostics.filter(typeof(AbstractValidationDiagnostic)).toList
		assertEquals(1, diagnotics.size)
		assertTrue(diagnotics.forall[sourceEObject instanceof IncludeDeclaration])
		diagnotics.forEach[
			assertEquals(TargetPlatformValidator::CHECK__INCLUDE_CYCLE, issueCode)
			assertEquals("subdir/subInclude.tpd", (it.sourceEObject as IncludeDeclaration).importURI)
		]
		
		assertTrue(subIncludeCircular.eResource.errors.empty)
		tester.validator.checkImportCycle(subIncludeCircular)
		diagnotics = tester.diagnose.allDiagnostics.filter(typeof(AbstractValidationDiagnostic)).toList
		assertEquals(1, diagnotics.size)
		assertTrue(diagnotics.forall[sourceEObject instanceof IncludeDeclaration])
		diagnotics.forEach[
			assertEquals(TargetPlatformValidator::CHECK__INCLUDE_CYCLE, issueCode)
			assertEquals("../compositeIncludeTarget.tpd", (it.sourceEObject as IncludeDeclaration).importURI)
		]
	}
	
	@Test
	def checkIUIDAndRange1() {
		val tester = new ValidatorTester(validator, validatorRegistrar, languageName)
		val targetPlatform = parser.parse('''
			target "a target platform"
			location "location1" {
				org.iu1
			}
		''')
		assertTrue(targetPlatform.eResource.errors.empty)
		tester.validator.checkIUIDAndRangeInRepository(targetPlatform.locations.head.ius.head)
		val diagnotics = tester.diagnose.allDiagnostics.filter(typeof(AbstractValidationDiagnostic)).toList
		assertEquals(0, diagnotics.size)
	}
	
	@Test
	def checkIUIDAndRange2() {
		val tester = new ValidatorTester(validator, validatorRegistrar, languageName)
		val targetPlatform = parser.parse('''
			target "a target platform"
			location "location1" {
				org.iu2
			}
		''')
		assertTrue(targetPlatform.eResource.errors.empty)
		tester.validator.checkIUIDAndRangeInRepository(targetPlatform.locations.head.ius.head)
		val diagnotics = tester.diagnose.allDiagnostics.filter(typeof(AbstractValidationDiagnostic)).toList
		assertEquals(1, diagnotics.size)
		assertTrue(diagnotics.forall[sourceEObject instanceof IU])
		diagnotics.forEach[
			assertEquals(TargetPlatformValidator::CHECK__IU_IN_LOCATION, issueCode)
			assertEquals("org.iu2", (it.sourceEObject as IU).ID)
		]
	}
	
	@Test
	def checkIUIDAndRange3() {
		val tester = new ValidatorTester(validator, validatorRegistrar, languageName)
		val targetPlatform = parser.parse('''
			target "a target platform"
			location "location2" {
				org.iu4
				org.iu2
				org.iu5
				org.iu1
				org.iu3
			}
		''')
		assertTrue(targetPlatform.eResource.errors.empty)
		targetPlatform.locations.head.ius.forEach[tester.validator.checkIUIDAndRangeInRepository(it)]
		val diagnotics = tester.diagnose.allDiagnostics.filter(typeof(AbstractValidationDiagnostic)).toList
		assertEquals(3, diagnotics.size)
		assertTrue(diagnotics.forall[sourceEObject instanceof IU])
		diagnotics.forEach[
			assertEquals(TargetPlatformValidator::CHECK__IU_IN_LOCATION, issueCode)
		]
	}
	
	@Test
	def checkIUIDAndRange4() {
		val tester = new ValidatorTester(validator, validatorRegistrar, languageName)
		val targetPlatform = parser.parse('''
			target "a target platform"
			location "location2" {
				org.iu1 [1.0.0,2)
			}
		''')
		assertTrue(targetPlatform.eResource.errors.empty)
		targetPlatform.locations.head.ius.forEach[tester.validator.checkIUIDAndRangeInRepository(it)]
		val diagnotics = tester.diagnose.allDiagnostics.filter(typeof(AbstractValidationDiagnostic)).toList
		assertEquals(0, diagnotics.size)
	}
	
	@Test
	def checkIUIDAndRange5() {
		val tester = new ValidatorTester(validator, validatorRegistrar, languageName)
		val targetPlatform = parser.parse('''
			target "a target platform"
			location "location2" {
				org.iu1 [1.2.1,1.2.3)
			}
		''')
		assertTrue(targetPlatform.eResource.errors.empty)
		targetPlatform.locations.head.ius.forEach[tester.validator.checkIUIDAndRangeInRepository(it)]
		val diagnotics = tester.diagnose.allDiagnostics.filter(typeof(AbstractValidationDiagnostic)).toList
		assertEquals(1, diagnotics.size)
		assertTrue(diagnotics.forall[sourceEObject instanceof IU])
		diagnotics.forEach[
			assertEquals(TargetPlatformValidator::CHECK__IU_IN_LOCATION, issueCode)
			assertEquals("org.iu1", (it.sourceEObject as IU).ID)
		]
	}
	
	@Test
	def checkLocationURI1() {
		val tester = new ValidatorTester(validator, validatorRegistrar, languageName)
		val targetPlatform = parser.parse('''
			target "a target platform"
			location "location2" {
			}
		''')
		assertTrue(targetPlatform.eResource.errors.empty)
		targetPlatform.locations.forEach[tester.validator.checkLocationURI(it)]
		val diagnotics = tester.diagnose.allDiagnostics.filter(typeof(AbstractValidationDiagnostic)).toList
		assertEquals(0, diagnotics.size)
	}
	
	@Test
	def checkLocationURI2() {
		val tester = new ValidatorTester(validator, validatorRegistrar, languageName)
		val targetPlatform = parser.parse('''
			target "a target platform"
			location "emptyRepository" {
			}
		''')
		assertTrue(targetPlatform.eResource.errors.empty)
		targetPlatform.locations.forEach[tester.validator.checkLocationURI(it)]
		val diagnotics = tester.diagnose.allDiagnostics.filter(typeof(AbstractValidationDiagnostic)).toList
		assertEquals(0, diagnotics.size)
	}
	
	@Test
	def checkLocationURI3() {
		val tester = new ValidatorTester(validator, validatorRegistrar, languageName)
		val targetPlatform = parser.parse('''
			target "a target platform"
			location "badLocation" {
			}
		''')
		assertTrue(targetPlatform.eResource.errors.empty)
		targetPlatform.locations.forEach[tester.validator.checkLocationURI(it)]
		val diagnotics = tester.diagnose.allDiagnostics.filter(typeof(AbstractValidationDiagnostic)).toList
		assertEquals(1, diagnotics.size)
		diagnotics.forEach[
			assertEquals(TargetPlatformValidator::CHECK__LOCATION_URI, issueCode)
			assertEquals("badLocation", (it.sourceEObject as Location).uri)
		]
	}
	
	@Test
	def checkEnvironmentValidity1() {
		val tester = new ValidatorTester(validator, validatorRegistrar, languageName)
		val targetPlatform = parser.parse('''
			target "a target platform"
			environment macosx COCOA x86_64 JavaSE-1.6 fr_FR
		''')
		assertTrue(targetPlatform.eResource.errors.empty)
		tester.validator.checkEnvironment(targetPlatform.environment)
		val diagnotics = tester.diagnose.allDiagnostics.filter(typeof(AbstractValidationDiagnostic)).toList
		assertEquals(0, diagnotics.size)
	}
	
	@Test
	def checkEnvironmentValidity2() {
		val tester = new ValidatorTester(validator, validatorRegistrar, languageName)
		val targetPlatform = parser.parse('''
			target "a target platform"
			environment macosx COCOA qsdf x86_64
		''')
		assertTrue(targetPlatform.eResource.errors.empty)
		tester.validator.checkEnvironment(targetPlatform.environment)
		val diagnotics = tester.diagnose.allDiagnostics.filter(typeof(AbstractValidationDiagnostic)).toList
		assertEquals(1, diagnotics.size)
		diagnotics.forEach[
			assertEquals(TargetPlatformValidator::CHECK__ENVIRONMENT_VALIDITY, issueCode)
		]
	}
	
	@Test
	def checkEnvironmentValidity3() {
		val tester = new ValidatorTester(validator, validatorRegistrar, languageName)
		val targetPlatform = parser.parse('''
			target "a target platform"
			environment macosx linux
		''')
		assertTrue(targetPlatform.eResource.errors.empty)
		tester.validator.checkEnvironment(targetPlatform.environment)
		val diagnotics = tester.diagnose.allDiagnostics.filter(typeof(AbstractValidationDiagnostic)).toList
		assertEquals(0, diagnotics.size)
	}
	
	@Test
	def checkEnvironmentValidity4() {
		val tester = new ValidatorTester(validator, validatorRegistrar, languageName)
		val targetPlatform = parser.parse('''
			target "a target platform"
			environment macosx macosx
		''')
		assertTrue(targetPlatform.eResource.errors.empty)
		tester.validator.checkEnvironment(targetPlatform.environment)
		val diagnotics = tester.diagnose.allDiagnostics.filter(typeof(AbstractValidationDiagnostic)).toList
		assertEquals(0, diagnotics.size)
	}
	
	@Test
	def checkUniqueEnvironment0() {
		val tester = new ValidatorTester(validator, validatorRegistrar, languageName)
		val targetPlatform = parser.parse('''
			target "a target platform"
			environment macosx COCOA x86_64
			
			location "location" {
				
			}
		''')
		assertTrue(targetPlatform.eResource.errors.empty)
		tester.validator.checkOneEnvironment(targetPlatform)
		val diagnotics = tester.diagnose.allDiagnostics.filter(typeof(FeatureBasedDiagnostic)).toList
		assertEquals(0, diagnotics.size)
	}
	
	@Test
	def checkUniqueEnvironment1() {
		val tester = new ValidatorTester(validator, validatorRegistrar, languageName)
		val targetPlatform = parser.parse('''
			target "a target platform"
			environment macosx COCOA x86_64
			
			environment win32
			
			location "location" {
				
			}
		''')
		assertTrue(targetPlatform.eResource.errors.empty)
		tester.validator.checkOneEnvironment(targetPlatform)
		val diagnotics = tester.diagnose.allDiagnostics.filter(typeof(FeatureBasedDiagnostic)).toList
		assertEquals(1, diagnotics.size)
		diagnotics.forEach[
			assertEquals(TargetPlatformValidator::CHECK__ENVIRONMENT_UNICITY, issueCode)
			assertEquals(Diagnostic.WARNING, it.severity)
			assertEquals(targetPlatform.contents.get(1), (it.sourceEObject.eGet(it.feature) as List<?>).get(it.index))
		]
	}
	
	@Test
	def checkUniqueEnvironment2() {
		val tester = new ValidatorTester(validator, validatorRegistrar, languageName)
		val targetPlatform = parser.parse('''
			target "a target platform"
			environment macosx COCOA x86_64
			
			environment win32
			
			location "location" {
				
			}
			
			environment gtk
		''')
		assertTrue(targetPlatform.eResource.errors.empty)
		tester.validator.checkOneEnvironment(targetPlatform)
		val diagnostics = tester.diagnose.allDiagnostics.filter(typeof(FeatureBasedDiagnostic)).toList
		assertEquals(2, diagnostics.size)
		var it = diagnostics.head
			assertEquals(TargetPlatformValidator::CHECK__ENVIRONMENT_UNICITY, it.issueCode)
			assertEquals(Diagnostic.WARNING, it.severity)
			assertEquals(targetPlatform.contents.get(1), (it.sourceEObject.eGet(it.feature) as List<?>).get(it.index))
		it = diagnostics.get(1)
			assertEquals(TargetPlatformValidator::CHECK__ENVIRONMENT_UNICITY, it.issueCode)
			assertEquals(Diagnostic.WARNING, it.severity)
			assertEquals(targetPlatform.contents.get(3), (it.sourceEObject.eGet(it.feature) as List<?>).get(it.index))
	}
	
	@Test
	def checkUniqueOptions0() {
		val tester = new ValidatorTester(validator, validatorRegistrar, languageName)
		val targetPlatform = parser.parse('''
			target "a target platform"
			with requirements
			
			location "location" {
				
			}
		''')
		assertTrue(targetPlatform.eResource.errors.empty)
		tester.validator.checkOneOptions(targetPlatform)
		val diagnotics = tester.diagnose.allDiagnostics.filter(typeof(FeatureBasedDiagnostic)).toList
		assertEquals(0, diagnotics.size)
	}
	
	@Test
	def checkUniqueOptions1() {
		val tester = new ValidatorTester(validator, validatorRegistrar, languageName)
		val targetPlatform = parser.parse('''
			target "a target platform"
			with requirements
			
			with source
			
			location "location" {
				
			}
		''')
		assertTrue(targetPlatform.eResource.errors.empty)
		tester.validator.checkOneOptions(targetPlatform)
		val diagnotics = tester.diagnose.allDiagnostics.filter(typeof(FeatureBasedDiagnostic)).toList
		assertEquals(1, diagnotics.size)
		diagnotics.forEach[
			assertEquals(TargetPlatformValidator::CHECK__OPTIONS_UNICITY, issueCode)
			assertEquals(Diagnostic.WARNING, it.severity)
			assertEquals(targetPlatform.contents.get(1), (it.sourceEObject.eGet(it.feature) as List<?>).get(it.index))
		]
	}
	
	@Test
	def checkUniqueOptions2() {
		val tester = new ValidatorTester(validator, validatorRegistrar, languageName)
		val targetPlatform = parser.parse('''
			target "a target platform"
			with requirements
			
			with source
			
			location "location" {
				
			}
			
			with configurePhase
		''')
		assertTrue(targetPlatform.eResource.errors.empty)
		tester.validator.checkOneOptions(targetPlatform)
		val diagnostics = tester.diagnose.allDiagnostics.filter(typeof(FeatureBasedDiagnostic)).toList
		assertEquals(2, diagnostics.size)
		var it = diagnostics.head
			assertEquals(TargetPlatformValidator::CHECK__OPTIONS_UNICITY, it.issueCode)
			assertEquals(Diagnostic.WARNING, it.severity)
			assertEquals(targetPlatform.contents.get(1), (it.sourceEObject.eGet(it.feature) as List<?>).get(it.index))
		it = diagnostics.get(1)
			assertEquals(TargetPlatformValidator::CHECK__OPTIONS_UNICITY, it.issueCode)
			assertEquals(Diagnostic.WARNING, it.severity)
			assertEquals(targetPlatform.contents.get(3), (it.sourceEObject.eGet(it.feature) as List<?>).get(it.index))
	}
	
	@Test
	def checkEnvironmentCohesion1() {
		val tester = new ValidatorTester(validator, validatorRegistrar, languageName)
		val targetPlatform = parser.parse('''
			target "a target platform"
			environment linux gtk cocoa
		''')
		assertTrue(targetPlatform.eResource.errors.empty)
		tester.validator.checkNoDuplicateEnvironmentOptions(targetPlatform)
		val diagnostics = tester.diagnose.allDiagnostics.filter(typeof(FeatureBasedDiagnostic)).toList
		assertEquals(diagnostics.join(', '), 2, diagnostics.size)
		var it = diagnostics.head
			assertEquals(TargetPlatformValidator::CHECK__NO_DUPLICATE_ENVIRONMENT_OPTIONS, it.issueCode)
			assertEquals(Diagnostic.ERROR, it.severity)
			assertEquals(targetPlatform.environment.env.get(1), (it.sourceEObject.eGet(it.feature) as List<?>).get(it.index))
		var it = diagnostics.get(1)
			assertEquals(TargetPlatformValidator::CHECK__NO_DUPLICATE_ENVIRONMENT_OPTIONS, it.issueCode)
			assertEquals(Diagnostic.ERROR, it.severity)
			assertEquals(targetPlatform.environment.env.get(2), (it.sourceEObject.eGet(it.feature) as List<?>).get(it.index))
	}
	
	@Test
	def checkEnvironmentCohesion2() {
		val tester = new ValidatorTester(validator, validatorRegistrar, languageName)
		val targetPlatform = parser.parse('''
			target "a target platform"
			environment linux gtk
			
			environment cocoa
		''')
		assertTrue(targetPlatform.eResource.errors.empty)
		tester.validator.checkNoDuplicateEnvironmentOptions(targetPlatform)
		val diagnostics = tester.diagnose.allDiagnostics.filter(typeof(FeatureBasedDiagnostic)).toList
		assertEquals(2, diagnostics.size)
		var it = diagnostics.head
			assertEquals(TargetPlatformValidator::CHECK__NO_DUPLICATE_ENVIRONMENT_OPTIONS, it.issueCode)
			assertEquals(Diagnostic.ERROR, it.severity)
			assertEquals((targetPlatform.contents.get(0) as Environment).env.get(1), (it.sourceEObject.eGet(it.feature) as List<?>).get(it.index))
		var it = diagnostics.get(1)
			assertEquals(TargetPlatformValidator::CHECK__NO_DUPLICATE_ENVIRONMENT_OPTIONS, it.issueCode)
			assertEquals(Diagnostic.ERROR, it.severity)
			assertEquals((targetPlatform.contents.get(1) as Environment).env.head, (it.sourceEObject.eGet(it.feature) as List<?>).get(it.index))
	}
	
	@Test
	def checkEnvironmentCohesion3() {
		val tester = new ValidatorTester(validator, validatorRegistrar, languageName)
		val targetPlatform = parser.parse('''
			target "a target platform"
			environment win32 cocoa
		''')
		assertTrue(targetPlatform.eResource.errors.empty)
		tester.validator.checkNoDuplicateEnvironmentOptions(targetPlatform)
		val diagnostics = tester.diagnose.allDiagnostics.filter(typeof(FeatureBasedDiagnostic)).toList
		assertEquals(0, diagnostics.size)
	}
	
	@Test
	def checkEnvironmentCohesion4() {
		val tester = new ValidatorTester(validator, validatorRegistrar, languageName)
		val targetPlatform = parser.parse('''
			target "a target platform"
			environment win32 linux
		''')
		assertTrue(targetPlatform.eResource.errors.empty)
		tester.validator.checkNoDuplicateEnvironmentOptions(targetPlatform)
		val diagnostics = tester.diagnose.allDiagnostics.filter(typeof(FeatureBasedDiagnostic)).toList
		assertEquals(0, diagnostics.size)
	}
	
	@Test
	def checkEnvironmentCohesion5() {
		val tester = new ValidatorTester(validator, validatorRegistrar, languageName)
		val targetPlatform = parser.parse('''
			target "a target platform"
			environment win32 win32
		''')
		assertTrue(targetPlatform.eResource.errors.empty)
		tester.validator.checkNoDuplicateEnvironmentOptions(targetPlatform)
		val diagnostics = tester.diagnose.allDiagnostics.filter(typeof(FeatureBasedDiagnostic)).toList
		assertEquals(0, diagnostics.size)
	}
	
	@Test
	def checkEnvironmentCohesion6() {
		val tester = new ValidatorTester(validator, validatorRegistrar, languageName)
		val targetPlatform = parser.parse('''
			target "a target platform"
			environment win32 
			environment win32
		''')
		assertTrue(targetPlatform.eResource.errors.empty)
		tester.validator.checkNoDuplicateEnvironmentOptions(targetPlatform)
		val diagnostics = tester.diagnose.allDiagnostics.filter(typeof(FeatureBasedDiagnostic)).toList
		assertEquals(diagnostics.join(', '), 0, diagnostics.size)
	}
	
	@Test
	def checkEnvironmentCohesion7() {
		val tester = new ValidatorTester(validator, validatorRegistrar, languageName)
		val targetPlatform = parser.parse('''
			target "a target platform"
			environment cocoa linux cocoa 
		''')
		assertTrue(targetPlatform.eResource.errors.empty)
		tester.validator.checkNoDuplicateEnvironmentOptions(targetPlatform)
		val diagnostics = tester.diagnose.allDiagnostics.filter(typeof(FeatureBasedDiagnostic)).toList
		assertEquals(diagnostics.join(', '), 2, diagnostics.size)
		assertEquals('cocoa', (diagnostics.get(0).sourceEObject.eGet(diagnostics.get(0).feature) as List<?>).get(diagnostics.get(0).index))
		assertEquals('cocoa', (diagnostics.get(1).sourceEObject.eGet(diagnostics.get(1).feature) as List<?>).get(diagnostics.get(1).index))
	}
	
	@Test
	def testNoEscapeCharInIUID() {
		val tester = new ValidatorTester(validator, validatorRegistrar, languageName)
		val targetPlatform = parser.parse('''
			target "a target platform"
			location "locationURI" {
				org.iu1
				^source
				org.iu1.^source.feature.group
			}
		''')
		assertTrue(targetPlatform.eResource.errors.empty)
		tester.validator.checkNoEscapeCharacterInIUID(targetPlatform.locations.head.ius.get(0))
		var diagnostics = tester.diagnose.allDiagnostics.filter(typeof(FeatureBasedDiagnostic)).toList
		assertEquals(diagnostics.join(', '), 0, diagnostics.size)
		
		tester.validator.checkNoEscapeCharacterInIUID(targetPlatform.locations.head.ius.get(1))
		diagnostics = tester.diagnose.allDiagnostics.filter(typeof(FeatureBasedDiagnostic)).toList
		assertEquals(diagnostics.join(', '), 0, diagnostics.size)
		
		tester.validator.checkNoEscapeCharacterInIUID(targetPlatform.locations.head.ius.get(2))
		diagnostics = tester.diagnose.allDiagnostics.filter(typeof(FeatureBasedDiagnostic)).toList
		assertEquals(diagnostics.join(', '), 1, diagnostics.size)
		assertEquals(TargetPlatformValidator::CHECK__ESCAPE_CHAR_IU_ID, diagnostics.head.issueCode)
	}
	
	@Test
	def testNoVersionKeywords() {
		val tester = new ValidatorTester(validator, validatorRegistrar, languageName)
		val targetPlatform = parser.parse('''
			target "a target platform"
			location "locationURI" {
				org.iu1
				org.iu2 [2,3)
				org.iu3; version  =   [10,25)
			}
		''')
		assertTrue(targetPlatform.eResource.errors.empty)
		tester.validator.checkVersionKeywords(targetPlatform.locations.head.ius.get(0))
		var diagnostics = tester.diagnose.allDiagnostics.filter(typeof(RangeBasedDiagnostic)).toList
		assertEquals(diagnostics.join(', '), 0, diagnostics.size)
		
		tester.validator.checkVersionKeywords(targetPlatform.locations.head.ius.get(1))
		diagnostics = tester.diagnose.allDiagnostics.filter(typeof(RangeBasedDiagnostic)).toList
		assertEquals(diagnostics.join(', '), 0, diagnostics.size)
		
		tester.validator.checkVersionKeywords(targetPlatform.locations.head.ius.get(2))
		diagnostics = tester.diagnose.allDiagnostics.filter(typeof(RangeBasedDiagnostic)).toList
		assertEquals(diagnostics.join(', '), 1, diagnostics.size)
		assertEquals(TargetPlatformValidator::CHECK__VERSION_KEYWORDS, diagnostics.head.issueCode)
	}
	
	@Test
	def testNoDuplicatedVarDefinition() {
		val tester = new ValidatorTester(validator, validatorRegistrar, languageName)
		val compositeIncludeTarget = parser.parse('''
			target "compositeIncludeTarget"
			define twiceVar = "val1"
			define otherVar = "val"
			define twiceVar = "val2"
		''')
		assertTrue(compositeIncludeTarget.eResource.errors.empty)
		tester.validator.checkNoDuplicatedDefine(compositeIncludeTarget)
		var diagnostics = tester.diagnose.allDiagnostics.filter(typeof(FeatureBasedDiagnostic)).toList
		assertEquals(diagnostics.join(', '), 1, diagnostics.size)
		assertEquals(TargetPlatformValidator::CHECK__NO_DUPLICATED_DEFINE, diagnostics.head.issueCode)
		assertEquals(Diagnostic.WARNING, diagnostics.get(0).severity)
		assertEquals("\"twiceVar\" is defined many times (it may be imported through many includes)", diagnostics.get(0).message)
	}
	
	@Test
	def testNoDuplicatedVarDefinitionFromInclude() {
		val resourceSet = resourceSetProvider.get
		val tester = new ValidatorTester(validator, validatorRegistrar, languageName)
		val compositeIncludeTarget = parser.parse('''
			target "compositeIncludeTarget"
			include "subTpd1.tpd"
			include "subTpd2.tpd"
		''', URI.createURI("tmp:/compositeIncludeTarget.tpd"), resourceSet)
		parser.parse('''
			target "subTpd1"
			define twiceVar = "val1"
		''', URI.createURI("tmp:/subTpd1.tpd"), resourceSet)
		parser.parse('''
			target "subTpd2"
			define twiceVar = "val2"
		''', URI.createURI("tmp:/subTpd2.tpd"), resourceSet)
		
		val locationIndex = indexBuilder.getLocationIndex(compositeIncludeTarget)
		assertEquals(0, locationIndex.size)
		
		assertTrue(compositeIncludeTarget.eResource.errors.empty)
		tester.validator.checkNoDuplicatedDefine(compositeIncludeTarget)
		var diagnostics = tester.diagnose.allDiagnostics.filter(typeof(FeatureBasedDiagnostic)).toList
		assertEquals(diagnostics.join(', '), 1, diagnostics.size)
		assertEquals(TargetPlatformValidator::CHECK__NO_DUPLICATED_DEFINE, diagnostics.head.issueCode)
		assertEquals(Diagnostic.WARNING, diagnostics.get(0).severity)
		assertEquals("\"twiceVar\" is defined many times (it may be imported through many includes)", diagnostics.get(0).message)
	}
	
	@Test
	def testNoDuplicatedVarDefinitionFromIncludeValueOverloaded() {
		val resourceSet = resourceSetProvider.get
		val tester = new ValidatorTester(validator, validatorRegistrar, languageName)
		val compositeIncludeTarget = parser.parse('''
			target "compositeIncludeTarget"
			include "subTpd1.tpd"
			define twiceVar = "val"
		''', URI.createURI("tmp:/compositeIncludeTarget.tpd"), resourceSet)
		parser.parse('''
			target "subTpd1"
			define twiceVar = "val1"
		''', URI.createURI("tmp:/subTpd1.tpd"), resourceSet)
		
		val locationIndex = indexBuilder.getLocationIndex(compositeIncludeTarget)
		assertEquals(0, locationIndex.size)
		
		assertTrue(compositeIncludeTarget.eResource.errors.empty)
		tester.validator.checkNoDuplicatedDefine(compositeIncludeTarget)
		var diagnostics = tester.diagnose.allDiagnostics.filter(typeof(FeatureBasedDiagnostic)).toList
		assertEquals(diagnostics.join(', '), 0, diagnostics.size)
	}
	
	@Test
	def testNoDuplicatedIU1() {
		val tester = new ValidatorTester(validator, validatorRegistrar, languageName)
		val targetPlatform = parser.parse('''
			target "a target platform"
			location "locationURI" {
				org.iu1
			}
			
			location "locationURI2" {
				org.iu1
			}
		''')
		assertTrue(targetPlatform.eResource.errors.empty)
		tester.validator.checkNoDuplicatedIU(targetPlatform)
		var diagnostics = tester.diagnose.allDiagnostics.filter(typeof(FeatureBasedDiagnostic)).toList
		assertEquals(diagnostics.join(', '), 2, diagnostics.size)
		assertEquals(TargetPlatformValidator::CHECK__NO_DUPLICATED_IU, diagnostics.head.issueCode)
		assertEquals(targetPlatform.locations.head.ius.head, (diagnostics.get(0).sourceEObject.eGet(diagnostics.get(0).feature) as List<?>).get(0))
		assertEquals(Diagnostic.WARNING, diagnostics.get(0).severity)
		assertEquals(targetPlatform.locations.get(1).ius.head, (diagnostics.get(1).sourceEObject.eGet(diagnostics.get(1).feature) as List<?>).get(0))
		assertEquals(Diagnostic.WARNING, diagnostics.get(1).severity)
	}
	
	@Test
	def testNoDuplicatedIU2() {
		val tester = new ValidatorTester(validator, validatorRegistrar, languageName)
		val targetPlatform = parser.parse('''
			target "a target platform"
			location "locationURI" {
				org.iu1
				org.iu1
			}
		''')
		assertTrue(targetPlatform.eResource.errors.empty)
		tester.validator.checkNoDuplicatedIU(targetPlatform)
		var diagnostics = tester.diagnose.allDiagnostics.filter(typeof(FeatureBasedDiagnostic)).toList
		assertEquals(diagnostics.join(', '), 2, diagnostics.size)
		assertEquals(TargetPlatformValidator::CHECK__NO_DUPLICATED_IU, diagnostics.head.issueCode)
		assertEquals(targetPlatform.locations.head.ius.head, (diagnostics.get(0).sourceEObject.eGet(diagnostics.get(0).feature) as List<?>).get(0))
		assertEquals(Diagnostic.WARNING, diagnostics.get(0).severity)
		assertEquals(targetPlatform.locations.head.ius.head, (diagnostics.get(1).sourceEObject.eGet(diagnostics.get(1).feature) as List<?>).get(0))
		assertEquals(Diagnostic.WARNING, diagnostics.get(1).severity)
	}
	
	@Test
	def testNoDuplicatedIU3() {
		val tester = new ValidatorTester(validator, validatorRegistrar, languageName)
		val targetPlatform = parser.parse('''
			target "a target platform"
			location "locationURI" {
				org.iu1
			}
			
			location "locationURI" {
				org.iu1
			}
		''')
		assertTrue(targetPlatform.eResource.errors.empty)
		tester.validator.checkNoDuplicatedIU(targetPlatform)
		var diagnostics = tester.diagnose.allDiagnostics.filter(typeof(FeatureBasedDiagnostic)).toList
		assertEquals(diagnostics.join(', '), 2, diagnostics.size)
		assertEquals(TargetPlatformValidator::CHECK__NO_DUPLICATED_IU, diagnostics.head.issueCode)
		assertEquals(targetPlatform.locations.head.ius.head, (diagnostics.get(0).sourceEObject.eGet(diagnostics.get(0).feature) as List<?>).get(0))
		assertEquals(Diagnostic.WARNING, diagnostics.get(0).severity)
		assertEquals(targetPlatform.locations.get(1).ius.head, (diagnostics.get(1).sourceEObject.eGet(diagnostics.get(1).feature) as List<?>).get(0))
		assertEquals(Diagnostic.WARNING, diagnostics.get(1).severity)
	}
	
	@Test
	def testNoDuplicatedIU4() {
		val tester = new ValidatorTester(validator, validatorRegistrar, languageName)
		val resourceSet = resourceSetProvider.get;
		val tpa = parser.parse('''
			target "tp.a"
			include "b.tpd"
			
			location "locationURI1" {
				org.iu1
			}
		''', URI.createURI("tmp:/a.tpd"), resourceSet);
		parser.parse('''
			target "tp.b"
			
			location "locationURI2" {
				org.iu1
			}
		''', URI.createURI("tmp:/b.tpd"), resourceSet);

		assertTrue(tpa.eResource.errors.empty)
		tester.validator.checkNoDuplicatedIU(tpa)
		val diagnostics = tester.diagnose.allDiagnostics.filter(typeof(FeatureBasedDiagnostic)).toList
		assertEquals(1, diagnostics.size)
		assertEquals(TargetPlatformValidator::CHECK__NO_DUPLICATED_IU, diagnostics.head.issueCode)
		assertEquals(tpa.locations.head.ius.head, (diagnostics.get(0).sourceEObject.eGet(diagnostics.get(0).feature) as List<?>).get(0))
		assertEquals(Diagnostic.WARNING, diagnostics.get(0).severity)
	}
	
	@Test
	def testNoDuplicatedIU5() {
		val tester = new ValidatorTester(validator, validatorRegistrar, languageName)
		val resourceSet = resourceSetProvider.get;
		val tpa = parser.parse('''
			target "tp.a"
			include "b.tpd"
			
			location "locationURI1" {
				org.iu1
			}
		''', URI.createURI("tmp:/a.tpd"), resourceSet);
		parser.parse('''
			target "tp.b"
			
			location "locationURI1" {
				org.iu1
			}
		''', URI.createURI("tmp:/b.tpd"), resourceSet);

		assertTrue(tpa.eResource.errors.empty)
		tester.validator.checkNoDuplicatedIU(tpa)
		val diagnostics = tester.diagnose.allDiagnostics.filter(typeof(FeatureBasedDiagnostic)).toList
		assertEquals(1, diagnostics.size)
		assertEquals(TargetPlatformValidator::CHECK__NO_DUPLICATED_IU, diagnostics.head.issueCode)
		assertEquals(tpa.locations.head.ius.head, (diagnostics.get(0).sourceEObject.eGet(diagnostics.get(0).feature) as List<?>).get(0))
		assertEquals(Diagnostic.WARNING, diagnostics.get(0).severity)
	}
}
