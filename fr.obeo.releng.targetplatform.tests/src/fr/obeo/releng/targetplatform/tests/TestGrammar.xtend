package fr.obeo.releng.targetplatform.tests

import com.google.inject.Inject
import com.google.inject.name.Named
import fr.obeo.releng.targetplatform.TargetPlatformInjectorProvider
import fr.obeo.releng.targetplatform.targetplatform.Option
import fr.obeo.releng.targetplatform.targetplatform.TargetPlatform
import fr.obeo.releng.targetplatform.validation.TargetPlatformValidator
import org.eclipse.xtext.Constants
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.util.ParseHelper
import org.eclipse.xtext.junit4.validation.ValidatorTester
import org.eclipse.xtext.validation.AbstractValidationDiagnostic
import org.eclipse.xtext.validation.EValidatorRegistrar
import org.junit.Test
import org.junit.runner.RunWith

import static org.junit.Assert.*

@InjectWith(typeof(TargetPlatformInjectorProvider))
@RunWith(typeof(XtextRunner))
class TestGrammar {
	
	@Inject
	ParseHelper<TargetPlatform> parser
	
	@Inject
	TargetPlatformValidator validator
	
	@Inject
	EValidatorRegistrar validatorRegistrar
	
	@Inject
	@Named(Constants::LANGUAGE_NAME)
	String languageName
	
	@Test
	def testEmpty() {
		val targetPlatform = parser.parse("")
		assertNull(targetPlatform)
	}
	
	@Test
	def testStandardFile() {
		val targetPlatform = parser.parse('''
			target "Latest target for EMF Compare based on Kepler interim"

			location "https://hudson.eclipse.org/hudson/view/Modeling/job/emf-core-head/lastSuccessfulBuild/artifact/EMF.p2.repository/" {
				org.eclipse.emf.sdk.feature.group;version="[2.9.0,3.0.0)"
				com.google.common.cache;version="10.0.1"
			}
			
			location "https://hudson.eclipse.org/hudson/view/Modeling/job/mdt-uml2-master/lastSuccessfulBuild/artifact/UML2.p2.repository/" {
				org.eclipse.uml2.sdk.feature.group
			}
		''')
		assertTrue(targetPlatform.eResource.errors.join("\n"), targetPlatform.eResource.errors.empty)
		val fisrtLocation = targetPlatform.locations.head
		assertEquals("https://hudson.eclipse.org/hudson/view/Modeling/job/emf-core-head/lastSuccessfulBuild/artifact/EMF.p2.repository/", fisrtLocation.uri)
		assertEquals(2, fisrtLocation.ius.size)
		val iu0 = fisrtLocation.ius.head
		assertEquals("org.eclipse.emf.sdk.feature.group", iu0.ID)
		assertEquals("[2.9.0,3.0.0)", iu0.version)
		
		val iu1 = fisrtLocation.getIus().last
		assertEquals("com.google.common.cache", iu1.getID)
		assertEquals("10.0.1", iu1.version)
		
		val lastLocation = targetPlatform.locations.last
		assertEquals("https://hudson.eclipse.org/hudson/view/Modeling/job/mdt-uml2-master/lastSuccessfulBuild/artifact/UML2.p2.repository/", lastLocation.uri)
		assertEquals(1, lastLocation.ius.size)
		val uml2iu = lastLocation.ius.head
		assertEquals("org.eclipse.uml2.sdk.feature.group", uml2iu.ID)
		assertEquals(null, uml2iu.version)
	}
	
	@Test
	def testLocationOption() {
		val targetPlatform = parser.parse('''
			target "a target platform"

			location "my location URL" {
				with source, allEnvironments, requirements, configurePhase
				org.eclipse.emf.sdk.feature.group;version="[2.9.0,3.0.0)"
			}
		''')
		assertTrue(targetPlatform.eResource.errors.join("\n"), targetPlatform.eResource.errors.empty)
		val fisrtLocation = targetPlatform.locations.head
		assertTrue(fisrtLocation.options.contains(Option::INCLUDE_SOURCE))
		assertTrue(fisrtLocation.options.contains(Option::INCLUDE_ALL_ENVIRONMENTS))
		assertTrue(fisrtLocation.options.contains(Option::INCLUDE_REQUIRED))
		assertTrue(fisrtLocation.options.contains(Option::INCLUDE_CONFIGURE_PHASE))
	}
	
	@Test
	def testIdWithSpaceInIt() {
		val targetPlatform = parser.parse('''
			target "a target platform"

			location "my location URL" {
				my. iu
			}
		''')
		assertFalse(targetPlatform.eResource.errors.empty)
	}
	
	@Test
	def testIdWithSpaceInIt2() {
		val targetPlatform = parser.parse('''
			target "a target platform"

			location "my location URL" {
				my .iu
			}
		''')
		assertFalse(targetPlatform.eResource.errors.empty)
	}
	
	@Test
	def testIdWithDash() {
		val targetPlatform = parser.parse('''
			target "a target platform"

			location "my location URL" {
				my.iu.with-dash
			}
		''')
		assertTrue(targetPlatform.eResource.errors.join("\n"), targetPlatform.eResource.errors.empty)
		val fisrtLocation = targetPlatform.locations.head
		val iu0 = fisrtLocation.ius.head
		assertEquals("my.iu.with-dash", iu0.ID)
	}
	
	@Test
	def testIdWithVersionNonString() {
		val targetPlatform = parser.parse('''
			target "a target platform"

			location "my location URL" {
				my.iu;version=3
			}
		''')
		assertTrue(targetPlatform.eResource.errors.join("\n"), targetPlatform.eResource.errors.empty)
		val fisrtLocation = targetPlatform.locations.head
		val iu0 = fisrtLocation.ius.head
		assertEquals("my.iu", iu0.ID)
		assertEquals("3.0.0", iu0.version)
	}
	
	@Test
	def testIdWithVersionNonString2() {
		val targetPlatform = parser.parse('''
			target "a target platform"

			location "my location URL" {
				myu;version=3.2.1
			}
		''')
		assertTrue(targetPlatform.eResource.errors.join("\n"), targetPlatform.eResource.errors.empty)
		val fisrtLocation = targetPlatform.locations.head
		val iu0 = fisrtLocation.ius.head
		assertEquals("myu", iu0.ID)
		assertEquals("3.2.1", iu0.version)
	}
	
	@Test
	def testIdWithVersionNonString3() {
		val targetPlatform = parser.parse('''
			target "a target platform" version 3.8

			location "my location URL" {
				myu;version=[3.2.1,10.0)
			}
		''')
		assertTrue(targetPlatform.eResource.errors.join("\n"), targetPlatform.eResource.errors.empty)
		val fisrtLocation = targetPlatform.locations.head
		val iu0 = fisrtLocation.ius.head
		assertEquals("myu", iu0.ID)
		assertEquals("[3.2.1,10.0.0)", iu0.version)
	}
	
	@Test
	def testIdWithVersionNonString4() {
		val targetPlatform = parser.parse('''
			target "a target platform"

			location "my location URL" {
				myu;version=[ 3 , 5 )
			}
		''')
		assertTrue(targetPlatform.eResource.errors.join("\n"), targetPlatform.eResource.errors.empty)
		val fisrtLocation = targetPlatform.locations.head
		val iu0 = fisrtLocation.ius.head
		assertEquals("myu", iu0.ID)
		assertEquals("[3.0.0,5.0.0)", iu0.version)
	}

	@Test
	def testIUWithIntQualifier() {
		val targetPlatform = parser.parse('''
			target "a target platform"

			location "my location URL" {
				myu;version=1.2.3.201404071200
			}
		''')
		assertTrue(targetPlatform.eResource.errors.join("\n"), targetPlatform.eResource.errors.empty)
		val fisrtLocation = targetPlatform.locations.head
		val iu0 = fisrtLocation.ius.head
		assertEquals("myu", iu0.ID)
		assertEquals("1.2.3.201404071200", iu0.version)
	}	
}