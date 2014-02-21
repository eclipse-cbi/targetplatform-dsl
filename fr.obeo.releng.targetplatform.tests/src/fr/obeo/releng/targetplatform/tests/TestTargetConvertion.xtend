package fr.obeo.releng.targetplatform.tests

import com.google.common.collect.Lists
import com.google.common.io.Files
import com.google.inject.Inject
import com.google.inject.name.Named
import fr.obeo.releng.targetplatform.TargetPlatformInjectorProvider
import fr.obeo.releng.targetplatform.pde.IConverter
import fr.obeo.releng.targetplatform.targetplatform.TargetPlatform
import fr.obeo.releng.targetplatform.validation.TargetPlatformValidator
import java.net.URI
import org.eclipse.emf.common.util.BasicMonitor
import org.eclipse.emf.common.util.BasicMonitor.Printing
import org.eclipse.equinox.p2.metadata.Version
import org.eclipse.pde.core.target.ITargetDefinition
import org.eclipse.pde.internal.core.target.IUBundleContainer
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
		val converterClass = typeof (IConverter).classLoader.loadClass("fr.obeo.releng.targetplatform.internal.pde.Converter")
		val converterMethod = converterClass.declaredMethods.findFirst([name == "convertToTargetDefinition"])
		
		val IConverter converter = converterClass.newInstance as IConverter
		val tmpDir = Files::createTempDir()
		val agentUri = URI::create('''file:«tmpDir.absolutePath»''')
		val args = Lists::newArrayList(targetPlatform,agentUri,BasicMonitor::toIProgressMonitor(new Printing(System::out)))
		val targetDef = converterMethod.invoke(converter,  args.toArray) as ITargetDefinition
		
		for(loc : targetDef.targetLocations) {
			if (loc instanceof IUBundleContainer) {
				val getIds = typeof (IUBundleContainer).getDeclaredMethod("getIds")
				val getVersions = typeof (IUBundleContainer).getDeclaredMethod("getVersions")
				getIds.accessible = true;
				getVersions.accessible = true;
				val String[] ids = getIds.invoke(loc) as String[]
				val Version[] versions = getVersions.invoke(loc) as Version[]
				
				assertEquals(ids.head, "com.google.guava")
				assertEquals(0, versions.head.compareTo(Version::parseVersion("11.0.2.v201303041551")))
			}
		}
	}
}