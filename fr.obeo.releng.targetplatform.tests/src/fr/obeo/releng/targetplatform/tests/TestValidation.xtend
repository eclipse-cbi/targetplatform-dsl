package fr.obeo.releng.targetplatform.tests

import com.google.inject.Inject
import com.google.inject.name.Named
import fr.obeo.releng.targetplatform.TargetPlatformInjectorProvider
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
class TestValidation {
	
	
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
	def testLocationOptionCheck() {
		val tester = new ValidatorTester(validator, validatorRegistrar, languageName)
		val targetPlatform = parser.parse('''
			target "a target platform"

			location "my location URL" {
				with source, allEnvironments, requirements, configurePhase
				org.eclipse.emf.sdk.feature.group;version="[2.9.0,3.0.0)"
			}
		''')
		assertTrue(targetPlatform.eResource.errors.join("\n"), targetPlatform.eResource.errors.empty)
		val fisrtLocation = targetPlatform.locations.head
		tester.validator.checkAllEnvAndRequiredAreSelfExluding(fisrtLocation)
		for (diag: tester.diagnose.allDiagnostics.filter(typeof(AbstractValidationDiagnostic))) {
			assertEquals(TargetPlatformValidator::CHECK__OPTIONS_SELF_EXCLUDING_ALL_ENV_REQUIRED, 
				diag.issueCode
			)
		}
	}
}