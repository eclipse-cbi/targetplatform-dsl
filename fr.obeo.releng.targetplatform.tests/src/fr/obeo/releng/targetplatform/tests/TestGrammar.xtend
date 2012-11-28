package fr.obeo.releng.targetplatform.tests

import com.google.inject.Inject
import fr.obeo.releng.TargetPlatformInjectorProvider
import fr.obeo.releng.targetplatform.TargetPlatform
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.util.ParseHelper
import org.eclipse.xtext.junit4.validation.ValidatorTester
import org.junit.Test
import org.junit.runner.RunWith

import fr.obeo.releng.targetplatform.Option
import static org.junit.Assert.*
import fr.obeo.releng.validation.TargetPlatformJavaValidator
import org.eclipse.xtext.validation.EValidatorRegistrar
import com.google.inject.name.Named
import org.eclipse.xtext.Constants
import org.eclipse.xtext.validation.AbstractValidationDiagnostic

@InjectWith(typeof(TargetPlatformInjectorProvider))
@RunWith(typeof(XtextRunner))
class TestGrammar {
	
	@Inject
	ParseHelper<TargetPlatform> parser
	
	@Inject
	TargetPlatformJavaValidator validator
	
	@Inject
	EValidatorRegistrar validatorRegistrar
	
	@Inject
	@Named(Constants::LANGUAGE_NAME)
	String languageName
	
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
		val fisrtLocation = targetPlatform.locations.head
		assertTrue(fisrtLocation.options.contains(Option::INCLUDE_SOURCE))
		assertTrue(fisrtLocation.options.contains(Option::INCLUDE_ALL_ENVIRONMENTS))
		assertTrue(fisrtLocation.options.contains(Option::INCLUDE_REQUIRED))
		assertTrue(fisrtLocation.options.contains(Option::INCLUDE_CONFIGURE_PHASE))
	}
	
	@Test
	def testLocationOptionCheck() {
		val tester = new ValidatorTester(validator, validatorRegistrar, languageName)
		val targetPlatform = parser.parse('''
			target "a target platform"

			location "my location URL" {
				with source, allEnvironments, requirements, configurePhase
				org.eclipse.emf.sdk.feature.group;version="[2.9.0,3.0.0)"
			}
		''')
		val fisrtLocation = targetPlatform.locations.head
		tester.validator.checkAllEnvAndRequiredAreSelfExluding(fisrtLocation)
		for (diag: tester.diagnose.allDiagnostics.filter(typeof(AbstractValidationDiagnostic))) {
			assertEquals(TargetPlatformJavaValidator::CHECK__OPTIONS_SELF_EXCLUDING_ALL_ENV_REQUIRED, 
				diag.issueCode
			)
		}
	}
	
}