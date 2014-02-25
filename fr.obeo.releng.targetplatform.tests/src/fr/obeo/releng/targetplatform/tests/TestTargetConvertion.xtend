package fr.obeo.releng.targetplatform.tests

import com.google.common.io.Files
import com.google.inject.Inject
import com.google.inject.name.Named
import fr.obeo.releng.targetplatform.TargetPlatformInjectorProvider
import fr.obeo.releng.targetplatform.pde.Converter
import fr.obeo.releng.targetplatform.targetplatform.TargetPlatform
import fr.obeo.releng.targetplatform.validation.TargetPlatformValidator
import java.net.URI
import org.eclipse.emf.common.util.BasicMonitor
import org.eclipse.emf.common.util.BasicMonitor.Printing
import org.eclipse.equinox.p2.metadata.Version
import org.eclipse.xtext.Constants
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.util.ParseHelper
import org.eclipse.xtext.validation.EValidatorRegistrar
import org.junit.Test
import org.junit.runner.RunWith

import static org.junit.Assert.*

@InjectWith(typeof(TargetPlatformInjectorProvider))
@RunWith(typeof(XtextRunner))
class TestTargetConvertion {

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
	def testBasicBundle() {
		val targetPlatform = parser.parse('''
			target "TestTarget"
			location "http://download.eclipse.org/tools/orbit/downloads/drops/R20130517111416/repository/" { 
				with source, requirements
				com.google.guava;version="[11.0.0,12.0.0)"
				org.junit
			}
			''')
		val converter = new Converter
		val tmpDir = Files::createTempDir()
		val agentUri = URI::create('''file:«tmpDir.absolutePath»''')
		val targetDef = converter.getResolvedTargetPlatform(targetPlatform, agentUri, BasicMonitor::toIProgressMonitor(new Printing(System::out)))
		
		for(loc : targetDef.locations) {
			val String[] ids = loc.resolvedIUs.map[id]
			val Version[] versions = loc.resolvedIUs.map[version]
			
			assertEquals("com.google.guava", ids.head)
			assertEquals(0, versions.head.compareTo(Version::parseVersion("11.0.2.v201303041551")))
		}
	}
}