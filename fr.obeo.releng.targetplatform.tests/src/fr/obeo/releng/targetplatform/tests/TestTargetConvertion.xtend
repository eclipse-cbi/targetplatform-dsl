package fr.obeo.releng.targetplatform.tests

import com.google.common.io.Files
import com.google.inject.Inject
import com.google.inject.Provider
import fr.obeo.releng.targetplatform.TargetPlatformBundleActivator
import fr.obeo.releng.targetplatform.TargetPlatformInjectorProvider
import fr.obeo.releng.targetplatform.pde.Converter
import fr.obeo.releng.targetplatform.resolved.ResolvedTargetPlatform
import fr.obeo.releng.targetplatform.targetplatform.TargetPlatform
import java.net.URISyntaxException
import org.eclipse.emf.common.util.BasicMonitor
import org.eclipse.emf.common.util.BasicMonitor.Printing
import org.eclipse.emf.common.util.URI
import org.eclipse.equinox.p2.core.ProvisionException
import org.eclipse.equinox.p2.metadata.Version
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.util.ParseHelper
import org.eclipse.xtext.resource.XtextResourceSet
import org.junit.Test
import org.junit.runner.RunWith

import static org.junit.Assert.*
import fr.obeo.releng.targetplatform.util.LocationIndexBuilder
import org.eclipse.equinox.p2.repository.metadata.IMetadataRepositoryManager

@InjectWith(typeof(TargetPlatformInjectorProvider))
@RunWith(typeof(XtextRunner))
class TestTargetConvertion {

	@Inject
	ParseHelper<TargetPlatform> parser
	
	@Inject
	Provider<XtextResourceSet> resourceSetProvider
	
	@Inject
	LocationIndexBuilder indexBuilder;

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
		new TargetPlatformInjectorProvider().injector.injectMembers(converter)
		
		val tmpDir = Files::createTempDir()
		val agentUri = java.net.URI::create('''file:«tmpDir.absolutePath»''')
		val targetDef = getResolvedTargetPlatform(targetPlatform, agentUri)
		
		for(loc : targetDef.locations) {
			val String[] ids = loc.resolvedIUs.map[id]
			val Version[] versions = loc.resolvedIUs.map[version]
			
			assertEquals("com.google.guava", ids.head)
			assertEquals(0, versions.head.compareTo(Version::parseVersion("11.0.2.v201303041551")))
		}
	}
	
	//http://download.eclipse.org/modeling/emf/compare/updates/releases/2.1/R201310031412/
	@Test
	def testCombination() {
		val targetPlatform = parser.parse('''
			target "TestTarget"
			location "http://download.eclipse.org/modeling/emf/compare/updates/releases/2.1/R201310031412/" { 
				org.eclipse.emf.compare.ide.ui.feature.group
			}
			location "http://download.eclipse.org/modeling/emf/compare/updates/releases/2.1/R201310031412/" {
				org.eclipse.emf.compare.rcp.ui.feature.group
			}
		''')
		val converter = new Converter
		new TargetPlatformInjectorProvider().injector.injectMembers(converter)
		
		val tmpDir = Files::createTempDir()
		val agentUri = java.net.URI::create('''file:«tmpDir.absolutePath»''')
		val targetDef = getResolvedTargetPlatform(targetPlatform, agentUri)
		
		assertEquals(1, targetDef.locations.size)
		
		val String[] ids = targetDef.locations.map[resolvedIUs.map[id]].flatten
			
		assertEquals(2, ids.size)
		assertEquals("org.eclipse.emf.compare.ide.ui.feature.group", ids.head)
		assertEquals("org.eclipse.emf.compare.rcp.ui.feature.group", ids.get(1))
	}
	
	@Test
	def testMultipleLocationsWithInclude() {
		val resourceSet = resourceSetProvider.get
		val tp1 = parser.parse('''
			target "TP1"
			include "tp2.tpd"
			location "http://download.eclipse.org/modeling/emf/compare/updates/releases/2.1/R201310031412/" { 
				org.eclipse.emf.compare.ide.ui.feature.group
			}
		''', URI.createURI("tmp:/tp1.tpd"), resourceSet)
		parser.parse('''
			target "TP2"
			location "http://download.eclipse.org/modeling/emf/emf/updates/2.9/core/" {
				org.eclipse.emf.sdk.feature.group
			}
		''', URI.createURI("tmp:/tp2.tpd"), resourceSet)
		val converter = new Converter
		new TargetPlatformInjectorProvider().injector.injectMembers(converter)
		
		val tmpDir = Files::createTempDir()
		val agentUri = java.net.URI::create('''file:«tmpDir.absolutePath»''')
		val targetDef = getResolvedTargetPlatform(tp1, agentUri)
		
		assertEquals("TP1", targetDef.name)
		assertEquals(2, targetDef.locations.size)
		assertEquals("http://download.eclipse.org/modeling/emf/compare/updates/releases/2.1/R201310031412/", targetDef.locations.head.URI.toString)
		assertEquals("http://download.eclipse.org/modeling/emf/emf/updates/2.9/core/", targetDef.locations.get(1).URI.toString)
		
		val String[] ids = targetDef.locations.map[resolvedIUs.map[id]].flatten
			
		assertEquals(2, ids.size)
		assertEquals("org.eclipse.emf.compare.ide.ui.feature.group", ids.head)
		assertEquals("org.eclipse.emf.sdk.feature.group", ids.get(1))
	}
	
	@Test
	def testCombinationWithInclude() {
		val resourceSet = resourceSetProvider.get
		val tp1 = parser.parse('''
			target "TP1"
			include "tp2.tpd"
			location "http://download.eclipse.org/modeling/emf/compare/updates/releases/2.1/R201310031412/" { 
				org.eclipse.emf.compare.ide.ui.feature.group
			}
		''', URI.createURI("tmp:/tp1.tpd"), resourceSet)
		parser.parse('''
			target "TP2"
			location "http://download.eclipse.org/modeling/emf/compare/updates/releases/2.1/R201310031412/" {
				org.eclipse.emf.compare.rcp.ui.feature.group
			}
		''', URI.createURI("tmp:/tp2.tpd"), resourceSet)
		val converter = new Converter
		new TargetPlatformInjectorProvider().injector.injectMembers(converter)
		
		val tmpDir = Files::createTempDir()
		val agentUri = java.net.URI::create('''file:«tmpDir.absolutePath»''')
		val targetDef = getResolvedTargetPlatform(tp1, agentUri)
		
		assertEquals("TP1", targetDef.name)
		assertEquals(1, targetDef.locations.size)
		
		val String[] ids = targetDef.locations.map[resolvedIUs.map[id]].flatten
		//val Version[] versions = targetDef.locations.map[resolvedIUs.map[version]].flatten
			
		assertEquals(2, ids.size)
		assertEquals("org.eclipse.emf.compare.ide.ui.feature.group", ids.head)
		assertEquals("org.eclipse.emf.compare.rcp.ui.feature.group", ids.get(1))
	}
	
	@Test
	def testSameIUWithInclude() {
		val resourceSet = resourceSetProvider.get
		val tp1 = parser.parse('''
			target "TP1"
			include "tp2.tpd"
			location "http://download.eclipse.org/modeling/emf/compare/updates/releases/2.1/R201310031412/" { 
				org.eclipse.emf.compare.ide.ui.feature.group
			}
		''', URI.createURI("tmp:/tp1.tpd"), resourceSet)
		parser.parse('''
			target "TP2"
			location "http://download.eclipse.org/modeling/emf/compare/updates/releases/2.1/R201310031412/" {
				org.eclipse.emf.compare.ide.ui.feature.group
			}
		''', URI.createURI("tmp:/tp2.tpd"), resourceSet)
		val converter = new Converter
		new TargetPlatformInjectorProvider().injector.injectMembers(converter)
		
		val tmpDir = Files::createTempDir()
		val agentUri = java.net.URI::create('''file:«tmpDir.absolutePath»''')
		val targetDef = getResolvedTargetPlatform(tp1, agentUri)
		
		assertEquals("TP1", targetDef.name)
		assertEquals(1, targetDef.locations.size)
		
		val String[] ids = targetDef.locations.map[resolvedIUs.map[id]].flatten
		//val Version[] versions = targetDef.locations.map[resolvedIUs.map[version]].flatten
			
		assertEquals(1, ids.size)
		assertEquals("org.eclipse.emf.compare.ide.ui.feature.group", ids.head)
	}
	
	@Test
	def testSameIU() {
		val resourceSet = resourceSetProvider.get
		val tp1 = parser.parse('''
			target "TP1"
			include "tp2.tpd"
			location "http://download.eclipse.org/modeling/emf/compare/updates/releases/2.1/R201310031412/" { 
				org.eclipse.emf.compare.ide.ui.feature.group
			}
			location "http://download.eclipse.org/modeling/emf/compare/updates/releases/2.1/R201310031412/" {
				org.eclipse.emf.compare.ide.ui.feature.group
			}
		''', URI.createURI("tmp:/tp1.tpd"), resourceSet)

		val converter = new Converter
		new TargetPlatformInjectorProvider().injector.injectMembers(converter)
		
		val tmpDir = Files::createTempDir()
		val agentUri = java.net.URI::create('''file:«tmpDir.absolutePath»''')
		val targetDef = getResolvedTargetPlatform(tp1, agentUri)
		
		assertEquals("TP1", targetDef.name)
		assertEquals(1, targetDef.locations.size)
		
		val String[] ids = targetDef.locations.map[resolvedIUs.map[id]].flatten
		//val Version[] versions = targetDef.locations.map[resolvedIUs.map[version]].flatten
			
		assertEquals(1, ids.size)
		assertEquals("org.eclipse.emf.compare.ide.ui.feature.group", ids.head)
	}
	
	@Test
	def testIUOverrideWithInclude1() {
		val resourceSet = resourceSetProvider.get
		val tp1 = parser.parse('''
			target "TP1"
			include "tp2.tpd"
			location "http://download.eclipse.org/tools/orbit/downloads/drops/R20130517111416/repository/" { 
				com.google.guava
			}
		''', URI.createURI("tmp:/tp1.tpd"), resourceSet)
		parser.parse('''
			target "TP2"
			location "http://download.eclipse.org/tools/orbit/downloads/drops/R20130517111416/repository/" {
				com.google.guava;version="[11.0.0,12.0.0)"
			}
		''', URI.createURI("tmp:/tp2.tpd"), resourceSet)
		val converter = new Converter
		new TargetPlatformInjectorProvider().injector.injectMembers(converter)
		
		val tmpDir = Files::createTempDir()
		val agentUri = java.net.URI::create('''file:«tmpDir.absolutePath»''')
		val targetDef = getResolvedTargetPlatform(tp1, agentUri)
		
		assertEquals("TP1", targetDef.name)
		assertEquals(1, targetDef.locations.size)
		
		val String[] ids = targetDef.locations.map[resolvedIUs.map[id]].flatten
		val Version[] versions = targetDef.locations.map[resolvedIUs.map[version]].flatten
		assertEquals(1, ids.size)
		assertEquals("com.google.guava", ids.head)
		assertEquals("12.0.0.v201212092141", versions.head.toString)
	}
	
	@Test
	def testIUOverrideWithInclude2() {
		val resourceSet = resourceSetProvider.get
		val tp1 = parser.parse('''
			target "TP1"
			include "tp2.tpd"
			include "tp3.tpd"
		''', URI.createURI("tmp:/tp1.tpd"), resourceSet)
		parser.parse('''
			target "TP2"
			location "http://download.eclipse.org/tools/orbit/downloads/drops/R20130517111416/repository/" {
				com.google.guava;version=[11.0.0,12.0.0)
			}
		''', URI.createURI("tmp:/tp2.tpd"), resourceSet)
		parser.parse('''
			target "TP3"
			location "http://download.eclipse.org/tools/orbit/downloads/drops/R20130517111416/repository/" {
				com.google.guava
			}
		''', URI.createURI("tmp:/tp3.tpd"), resourceSet)
		val converter = new Converter
		new TargetPlatformInjectorProvider().injector.injectMembers(converter)
		
		val tmpDir = Files::createTempDir()
		val agentUri = java.net.URI::create('''file:«tmpDir.absolutePath»''')
		val targetDef = getResolvedTargetPlatform(tp1, agentUri)
		
		assertEquals("TP1", targetDef.name)
		assertEquals(1, targetDef.locations.size)
		
		val String[] ids = targetDef.locations.map[resolvedIUs.map[id]].flatten
		val Version[] versions = targetDef.locations.map[resolvedIUs.map[version]].flatten
		assertEquals(1, ids.size)
		assertEquals("com.google.guava", ids.head)
		assertEquals("12.0.0.v201212092141", versions.head.toString)
	}
	
	@Test
	def testIUOverrideWithInclude3() {
		val resourceSet = resourceSetProvider.get
		val tp1 = parser.parse('''
			target "TP1"
			include "tp3.tpd"
			include "tp2.tpd"
		''', URI.createURI("tmp:/tp1.tpd"), resourceSet)
		parser.parse('''
			target "TP2"
			location "http://download.eclipse.org/tools/orbit/downloads/drops/R20130517111416/repository/" {
				com.google.guava;version=[11.0.0,12.0.0)
			}
		''', URI.createURI("tmp:/tp2.tpd"), resourceSet)
		parser.parse('''
			target "TP3"
			location "http://download.eclipse.org/tools/orbit/downloads/drops/R20130517111416/repository/" {
				com.google.guava
			}
		''', URI.createURI("tmp:/tp3.tpd"), resourceSet)
		val converter = new Converter
		new TargetPlatformInjectorProvider().injector.injectMembers(converter)
		
		val tmpDir = Files::createTempDir()
		val agentUri = java.net.URI::create('''file:«tmpDir.absolutePath»''')
		val targetDef = getResolvedTargetPlatform(tp1, agentUri)
		
		assertEquals("TP1", targetDef.name)
		assertEquals(1, targetDef.locations.size)
		
		val String[] ids = targetDef.locations.map[resolvedIUs.map[id]].flatten
		val Version[] versions = targetDef.locations.map[resolvedIUs.map[version]].flatten
		assertEquals(1, ids.size)
		assertEquals("com.google.guava", ids.head)
		assertEquals("11.0.2.v201303041551", versions.head.toString)
	}
	
	@Test
	def testIUOverrideWithInclude4() {
		val resourceSet = resourceSetProvider.get
		val tp1 = parser.parse('''
			target "TP1"
			include "tp2.tpd"
		''', URI.createURI("tmp:/tp1.tpd"), resourceSet)
		parser.parse('''
			target "TP2"
			include "tp3.tpd"
			location "http://download.eclipse.org/tools/orbit/downloads/drops/R20130517111416/repository/" {
				com.google.guava;version=[11.0.0,12.0.0)
			}
		''', URI.createURI("tmp:/tp2.tpd"), resourceSet)
		parser.parse('''
			target "TP3"
			location "http://download.eclipse.org/tools/orbit/downloads/drops/R20130517111416/repository/" {
				com.google.guava
			}
		''', URI.createURI("tmp:/tp3.tpd"), resourceSet)
		val converter = new Converter
		new TargetPlatformInjectorProvider().injector.injectMembers(converter)
		
		val tmpDir = Files::createTempDir()
		val agentUri = java.net.URI::create('''file:«tmpDir.absolutePath»''')
		val targetDef = getResolvedTargetPlatform(tp1, agentUri)
		
		assertEquals("TP1", targetDef.name)
		assertEquals(1, targetDef.locations.size)
		
		val String[] ids = targetDef.locations.map[resolvedIUs.map[id]].flatten
		val Version[] versions = targetDef.locations.map[resolvedIUs.map[version]].flatten
		assertEquals(1, ids.size)
		assertEquals("com.google.guava", ids.head)
		assertEquals("11.0.2.v201303041551", versions.head.toString)
	}
	
	@Test
	def testIUOverrideWithInclude5() {
		val resourceSet = resourceSetProvider.get
		val tp1 = parser.parse('''
			target "TP1"
			include "tp2.tpd"
		''', URI.createURI("tmp:/tp1.tpd"), resourceSet)
		parser.parse('''
			target "TP2"
			include "tp3.tpd"
			location "http://download.eclipse.org/tools/orbit/downloads/drops/R20130517111416/repository/" {
				com.google.guava
			}
		''', URI.createURI("tmp:/tp2.tpd"), resourceSet)
		parser.parse('''
			target "TP3"
			location "http://download.eclipse.org/tools/orbit/downloads/drops/R20130517111416/repository/" {
				com.google.guava;version=[11.0.0,12.0.0)
			}
		''', URI.createURI("tmp:/tp3.tpd"), resourceSet)
		val converter = new Converter
		new TargetPlatformInjectorProvider().injector.injectMembers(converter)
		
		val tmpDir = Files::createTempDir()
		val agentUri = java.net.URI::create('''file:«tmpDir.absolutePath»''')
		val targetDef = getResolvedTargetPlatform(tp1, agentUri)
		
		assertEquals("TP1", targetDef.name)
		assertEquals(1, targetDef.locations.size)
		
		val String[] ids = targetDef.locations.map[resolvedIUs.map[id]].flatten
		val Version[] versions = targetDef.locations.map[resolvedIUs.map[version]].flatten
		assertEquals(1, ids.size)
		assertEquals("com.google.guava", ids.head)
		assertEquals("12.0.0.v201212092141", versions.head.toString)
	}
	
	@Test
	def testIUOverride1() {
		val resourceSet = resourceSetProvider.get
		val tp1 = parser.parse('''
			target "TP1"
			include "tp2.tpd"
			location "http://download.eclipse.org/tools/orbit/downloads/drops/R20130517111416/repository/" { 
				com.google.guava
			}
			location "http://download.eclipse.org/tools/orbit/downloads/drops/R20130517111416/repository/" {
				com.google.guava;version="[11.0.0,12.0.0)"
			}
		''', URI.createURI("tmp:/tp1.tpd"), resourceSet)
		val converter = new Converter
		new TargetPlatformInjectorProvider().injector.injectMembers(converter)
		
		val tmpDir = Files::createTempDir()
		val agentUri = java.net.URI::create('''file:«tmpDir.absolutePath»''')
		val targetDef = getResolvedTargetPlatform(tp1, agentUri)
		
		assertEquals("TP1", targetDef.name)
		assertEquals(1, targetDef.locations.size)
		
		val String[] ids = targetDef.locations.map[resolvedIUs.map[id]].flatten
		val Version[] versions = targetDef.locations.map[resolvedIUs.map[version]].flatten
		assertEquals(1, ids.size)
		assertEquals("com.google.guava", ids.head)
		assertEquals("12.0.0.v201212092141", versions.head.toString)
	}
	
	@Test
	def testIUOverride2() {
		val resourceSet = resourceSetProvider.get
		val tp1 = parser.parse('''
			target "TP1"
			include "tp2.tpd"
			location "http://download.eclipse.org/tools/orbit/downloads/drops/R20130517111416/repository/" {
				com.google.guava;version="[11.0.0,12.0.0)"
			}
			location "http://download.eclipse.org/tools/orbit/downloads/drops/R20130517111416/repository/" { 
				com.google.guava
			}
		''', URI.createURI("tmp:/tp1.tpd"), resourceSet)
		val converter = new Converter
		new TargetPlatformInjectorProvider().injector.injectMembers(converter)
		
		val tmpDir = Files::createTempDir()
		val agentUri = java.net.URI::create('''file:«tmpDir.absolutePath»''')
		val targetDef = getResolvedTargetPlatform(tp1, agentUri)
		
		assertEquals("TP1", targetDef.name)
		assertEquals(1, targetDef.locations.size)
		
		val String[] ids = targetDef.locations.map[resolvedIUs.map[id]].flatten
		val Version[] versions = targetDef.locations.map[resolvedIUs.map[version]].flatten
		assertEquals(1, ids.size)
		assertEquals("com.google.guava", ids.head)
		assertEquals("11.0.2.v201303041551", versions.head.toString)
	}
	
	@Test
	def testIUOverride3() {
		val resourceSet = resourceSetProvider.get
		val tp1 = parser.parse('''
			target "TP1"
			include "tp2.tpd"
			location "http://download.eclipse.org/tools/orbit/downloads/drops/R20130517111416/repository/" {
				com.google.guava;version="[11.0.0,12.0.0)"
				com.google.guava
			}
		''', URI.createURI("tmp:/tp1.tpd"), resourceSet)
		val converter = new Converter
		new TargetPlatformInjectorProvider().injector.injectMembers(converter)
		
		val tmpDir = Files::createTempDir()
		val agentUri = java.net.URI::create('''file:«tmpDir.absolutePath»''')
		val targetDef = getResolvedTargetPlatform(tp1, agentUri)
		
		assertEquals("TP1", targetDef.name)
		assertEquals(1, targetDef.locations.size)
		
		val String[] ids = targetDef.locations.map[resolvedIUs.map[id]].flatten
		val Version[] versions = targetDef.locations.map[resolvedIUs.map[version]].flatten
		assertEquals(1, ids.size)
		assertEquals("com.google.guava", ids.head)
		assertEquals("11.0.2.v201303041551", versions.head.toString)
	}
	
	@Test
	def testIUOverride4() {
		val resourceSet = resourceSetProvider.get
		val tp1 = parser.parse('''
			target "TP1"
			include "tp2.tpd"
			location "http://download.eclipse.org/tools/orbit/downloads/drops/R20130517111416/repository/" {
				com.google.guava
				com.google.guava;version="[11.0.0,12.0.0)"
			}
		''', URI.createURI("tmp:/tp1.tpd"), resourceSet)
		val converter = new Converter
		new TargetPlatformInjectorProvider().injector.injectMembers(converter)
		
		val tmpDir = Files::createTempDir()
		val agentUri = java.net.URI::create('''file:«tmpDir.absolutePath»''')
		val targetDef = getResolvedTargetPlatform(tp1, agentUri)
		
		assertEquals("TP1", targetDef.name)
		assertEquals(1, targetDef.locations.size)
		
		val String[] ids = targetDef.locations.map[resolvedIUs.map[id]].flatten
		val Version[] versions = targetDef.locations.map[resolvedIUs.map[version]].flatten
		assertEquals(1, ids.size)
		assertEquals("com.google.guava", ids.head)
		assertEquals("12.0.0.v201212092141", versions.head.toString)
	}
	
	private def getResolvedTargetPlatform(TargetPlatform targetPlatform, java.net.URI agentLocation) throws URISyntaxException, ProvisionException {
		val agent = TargetPlatformBundleActivator.getInstance().getProvisioningAgentProvider().createAgent(agentLocation);
		val repositoryManager = agent.getService(IMetadataRepositoryManager.SERVICE_NAME) as IMetadataRepositoryManager;

		val resolvedTargetPlatform = ResolvedTargetPlatform.create(targetPlatform, indexBuilder);
		resolvedTargetPlatform.resolve(repositoryManager, BasicMonitor::toIProgressMonitor(new Printing(System::out)));
		
		agent.stop();
		return resolvedTargetPlatform;
	}
}