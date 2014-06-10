package fr.obeo.releng.targetplatform.tests

import com.google.inject.Inject
import com.google.inject.Provider
import com.google.inject.name.Named
import fr.obeo.releng.targetplatform.IU
import fr.obeo.releng.targetplatform.IncludeDeclaration
import fr.obeo.releng.targetplatform.Location
import fr.obeo.releng.targetplatform.TargetPlatform
import fr.obeo.releng.targetplatform.TargetPlatformInjectorProvider
import fr.obeo.releng.targetplatform.validation.TargetPlatformValidator
import org.eclipse.emf.common.util.URI
import org.eclipse.xtext.Constants
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.util.ParseHelper
import org.eclipse.xtext.junit4.validation.ValidatorTester
import org.eclipse.xtext.resource.XtextResourceSet
import org.eclipse.xtext.validation.AbstractValidationDiagnostic
import org.eclipse.xtext.validation.EValidatorRegistrar
import org.junit.Test
import org.junit.runner.RunWith

import static org.junit.Assert.*

@InjectWith(typeof(TargetPlatformInjectorProvider))
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
			assertTrue(diag.sourceEObject instanceof TargetPlatform)
			assertEquals("a target platform", (diag.sourceEObject as TargetPlatform).name)
			assertEquals(TargetPlatformValidator::CHECK__OPTIONS_SELF_EXCLUDING_ALL_ENV_REQUIRED, 
				diag.issueCode
			)
		}
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
}
