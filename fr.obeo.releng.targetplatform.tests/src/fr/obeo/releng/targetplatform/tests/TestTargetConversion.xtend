package fr.obeo.releng.targetplatform.tests

import com.google.inject.Inject
import com.google.inject.Provider
import fr.obeo.releng.targetplatform.TargetPlatform
import fr.obeo.releng.targetplatform.TargetPlatformInjectorProvider
import fr.obeo.releng.targetplatform.resolved.ResolvedTargetPlatform
import fr.obeo.releng.targetplatform.util.LocationIndexBuilder
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.core.runtime.NullProgressMonitor
import org.eclipse.core.runtime.OperationCanceledException
import org.eclipse.emf.common.util.Diagnostic
import org.eclipse.emf.common.util.URI
import org.eclipse.equinox.p2.core.ProvisionException
import org.eclipse.equinox.p2.metadata.IInstallableUnit
import org.eclipse.equinox.p2.metadata.Version
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.util.ParseHelper
import org.eclipse.xtext.resource.XtextResourceSet
import org.junit.Test
import org.junit.runner.RunWith

import static org.junit.Assert.*

@InjectWith(typeof(TargetPlatformInjectorProvider))
@RunWith(typeof(XtextRunner))
class TestTargetConversion {

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
		
		val targetDef = ResolvedTargetPlatform.create(targetPlatform, indexBuilder);
		targetDef.resolve(new MockMetadataRepositoryManager(new IQueryResultProvider<IInstallableUnit>() {
			override listIUs(java.net.URI location) {
				if ("http://download.eclipse.org/tools/orbit/downloads/drops/R20130517111416/repository/".equals(location.toString)) {
					newImmutableList(
						new MockIU("com.google.guava", Version.createOSGi(11,0,2, "v201303041551")),
						new MockIU("org.junit", Version.createOSGi(4,10,0, "v4_10_0_v20130308-0414"))
					)
				} else {
					return emptyList
				}
			}
		}), new NullProgressMonitor());
		
		assertEquals(1, targetDef.locations.size)
		val loc = targetDef.locations.head
		
		assertEquals(2, loc.resolvedIUs.size)
		val String[] ids = loc.resolvedIUs.map[id]
		val Version[] versions = loc.resolvedIUs.map[version]
		
		assertEquals("com.google.guava", ids.head)
		assertEquals(0, versions.head.compareTo(Version::parseVersion("11.0.2.v201303041551")))
		
		assertEquals("org.junit", ids.get(1))
		assertEquals(0, versions.get(1).compareTo(Version::parseVersion("4.10.0.v4_10_0_v20130308-0414")))
	}
	
	@Test
	def testNoRepositoryAtLocation() {
		val targetPlatform = parser.parse('''
			target "TestTarget"
			location "unknownHost" { 
				with source, requirements
				com.google.guava;version="[11.0.0,12.0.0)"
				org.junit
			}
			''')
		
		val resolvedTargetPlatform = ResolvedTargetPlatform.create(targetPlatform, indexBuilder);
		val d = resolvedTargetPlatform.resolve(new MockMetadataRepositoryManager(null) {
			override loadRepository(java.net.URI location, IProgressMonitor monitor) throws ProvisionException, OperationCanceledException {
				if ("unknownHost".equals(location.toString)) {
					throw new ProvisionException("Unknown Host")
				} else {
					super.loadRepository(location, monitor)
				}
			}
			
		}, new NullProgressMonitor());
		
		assertEquals(Diagnostic.ERROR, d.severity)
		assertTrue("Message is "+d.children.head.message,d.children.head.message.startsWith("Unknown Host"))
	}
	
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

		val targetDef = ResolvedTargetPlatform.create(targetPlatform, indexBuilder);
		targetDef.resolve(new MockMetadataRepositoryManager(new IQueryResultProvider<IInstallableUnit>() {
			override listIUs(java.net.URI location) {
				if ("http://download.eclipse.org/modeling/emf/compare/updates/releases/2.1/R201310031412/".equals(location.toString)) {
					newImmutableList(
						new MockIU("org.eclipse.emf.compare.rcp.ui.feature.group", Version.createOSGi(1,0,0)),
						new MockIU("org.eclipse.emf.compare.ide.ui.feature.group", Version.createOSGi(1,0,0))
					)
				} else {
					return emptyList
				}
			}
		}), new NullProgressMonitor());
		
		assertEquals(1, targetDef.locations.size)
		
		val String[] ids = targetDef.locations.map[resolvedIUs.map[id]].flatten
			
		assertEquals(2, ids.size)
		assertEquals("org.eclipse.emf.compare.rcp.ui.feature.group", ids.head)
		assertEquals("org.eclipse.emf.compare.ide.ui.feature.group", ids.get(1))
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
			location "http://download.eclipse.org/modeling/emf/emf/updates/2.9.x/core/R201402030812/" {
				org.eclipse.emf.sdk.feature.group
			}
		''', URI.createURI("tmp:/tp2.tpd"), resourceSet)
		
		val targetDef = ResolvedTargetPlatform.create(tp1, indexBuilder);
		targetDef.resolve(new MockMetadataRepositoryManager(new IQueryResultProvider<IInstallableUnit>() {
			override listIUs(java.net.URI location) {
				if ("http://download.eclipse.org/modeling/emf/compare/updates/releases/2.1/R201310031412/".equals(location.toString)) {
					newImmutableList(
						new MockIU("org.eclipse.emf.compare.rcp.ui.feature.group", Version.createOSGi(1,0,0)),
						new MockIU("org.eclipse.emf.compare.ide.ui.feature.group", Version.createOSGi(1,0,0))
					)
				} else if ("http://download.eclipse.org/modeling/emf/emf/updates/2.9.x/core/R201402030812/".equals(location.toString)) {
					newImmutableList(
						new MockIU("org.eclipse.emf.sdk.feature.group", Version.createOSGi(1,0,0))
					)
				} else {
					return emptyList
				}
			}
		}), new NullProgressMonitor());
		
		assertEquals("TP1", targetDef.name)
		assertEquals(2, targetDef.locations.size)
		assertEquals("http://download.eclipse.org/modeling/emf/emf/updates/2.9.x/core/R201402030812/", targetDef.locations.head.URI.toString)
		assertEquals("http://download.eclipse.org/modeling/emf/compare/updates/releases/2.1/R201310031412/", targetDef.locations.get(1).URI.toString)
		
		val String[] ids = targetDef.locations.map[resolvedIUs.map[id]].flatten
			
		assertEquals(2, ids.size)
		assertEquals("org.eclipse.emf.sdk.feature.group", ids.head)
		assertEquals("org.eclipse.emf.compare.ide.ui.feature.group", ids.get(1))
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
		
		val targetDef = ResolvedTargetPlatform.create(tp1, indexBuilder);
		targetDef.resolve(new MockMetadataRepositoryManager(new IQueryResultProvider<IInstallableUnit>() {
			override listIUs(java.net.URI location) {
				if ("http://download.eclipse.org/modeling/emf/compare/updates/releases/2.1/R201310031412/".equals(location.toString)) {
					newImmutableList(
						new MockIU("org.eclipse.emf.compare.rcp.ui.feature.group", Version.createOSGi(1,0,0)),
						new MockIU("org.eclipse.emf.compare.ide.ui.feature.group", Version.createOSGi(1,0,0))
					)
				} else {
					return emptyList
				}
			}
		}), new NullProgressMonitor());
		
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
		
		val targetDef = ResolvedTargetPlatform.create(tp1, indexBuilder);
		targetDef.resolve(new MockMetadataRepositoryManager(new IQueryResultProvider<IInstallableUnit>() {
			override listIUs(java.net.URI location) {
				if ("http://download.eclipse.org/modeling/emf/compare/updates/releases/2.1/R201310031412/".equals(location.toString)) {
					newImmutableList(
						new MockIU("org.eclipse.emf.compare.rcp.ui.feature.group", Version.createOSGi(1,0,0)),
						new MockIU("org.eclipse.emf.compare.ide.ui.feature.group", Version.createOSGi(1,0,0))
					)
				} else {
					return emptyList
				}
			}
		}), new NullProgressMonitor());
		
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

		val targetDef = ResolvedTargetPlatform.create(tp1, indexBuilder);
		targetDef.resolve(new MockMetadataRepositoryManager(new IQueryResultProvider<IInstallableUnit>() {
			override listIUs(java.net.URI location) {
				if ("http://download.eclipse.org/modeling/emf/compare/updates/releases/2.1/R201310031412/".equals(location.toString)) {
					newImmutableList(
						new MockIU("org.eclipse.emf.compare.rcp.ui.feature.group", Version.createOSGi(1,0,0)),
						new MockIU("org.eclipse.emf.compare.ide.ui.feature.group", Version.createOSGi(1,0,0))
					)
				} else {
					return emptyList
				}
			}
		}), new NullProgressMonitor());
		
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

		val targetDef = ResolvedTargetPlatform.create(tp1, indexBuilder);
		targetDef.resolve(new MockMetadataRepositoryManager(new IQueryResultProvider<IInstallableUnit>() {
			override listIUs(java.net.URI location) {
				if ("http://download.eclipse.org/tools/orbit/downloads/drops/R20130517111416/repository/".equals(location.toString)) {
					newImmutableList(
						new MockIU("com.google.guava", Version.createOSGi(10,0,0)),
						new MockIU("com.google.guava", Version.createOSGi(11,0,2)),
						new MockIU("com.google.guava", Version.createOSGi(12,0,0))
					)
				} else {
					return emptyList
				}
			}
		}), new NullProgressMonitor());
		
		assertEquals("TP1", targetDef.name)
		assertEquals(1, targetDef.locations.size)
		
		val String[] ids = targetDef.locations.map[resolvedIUs.map[id]].flatten
		val Version[] versions = targetDef.locations.map[resolvedIUs.map[version]].flatten
		assertEquals(1, ids.size)
		assertEquals("com.google.guava", ids.head)
		assertEquals("12.0.0", versions.head.toString)
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
		
		val targetDef = ResolvedTargetPlatform.create(tp1, indexBuilder);
		targetDef.resolve(new MockMetadataRepositoryManager(new IQueryResultProvider<IInstallableUnit>() {
			override listIUs(java.net.URI location) {
				if ("http://download.eclipse.org/tools/orbit/downloads/drops/R20130517111416/repository/".equals(location.toString)) {
					newImmutableList(
						new MockIU("com.google.guava", Version.createOSGi(10,0,0)),
						new MockIU("com.google.guava", Version.createOSGi(11,0,2)),
						new MockIU("com.google.guava", Version.createOSGi(12,0,0))
					)
				} else {
					return emptyList
				}
			}
		}), new NullProgressMonitor());
		
		assertEquals("TP1", targetDef.name)
		assertEquals(1, targetDef.locations.size)
		
		val String[] ids = targetDef.locations.map[resolvedIUs.map[id]].flatten
		val Version[] versions = targetDef.locations.map[resolvedIUs.map[version]].flatten
		assertEquals(1, ids.size)
		assertEquals("com.google.guava", ids.head)
		assertEquals("12.0.0", versions.head.toString)
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
		
		val targetDef = ResolvedTargetPlatform.create(tp1, indexBuilder);
		targetDef.resolve(new MockMetadataRepositoryManager(new IQueryResultProvider<IInstallableUnit>() {
			override listIUs(java.net.URI location) {
				if ("http://download.eclipse.org/tools/orbit/downloads/drops/R20130517111416/repository/".equals(location.toString)) {
					newImmutableList(
						new MockIU("com.google.guava", Version.createOSGi(10,0,0)),
						new MockIU("com.google.guava", Version.createOSGi(11,0,2)),
						new MockIU("com.google.guava", Version.createOSGi(12,0,0))
					)
				} else {
					return emptyList
				}
			}
		}), new NullProgressMonitor());
		
		assertEquals("TP1", targetDef.name)
		assertEquals(1, targetDef.locations.size)
		
		val String[] ids = targetDef.locations.map[resolvedIUs.map[id]].flatten
		val Version[] versions = targetDef.locations.map[resolvedIUs.map[version]].flatten
		assertEquals(1, ids.size)
		assertEquals("com.google.guava", ids.head)
		assertEquals("11.0.2", versions.head.toString)
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
		
		val targetDef = ResolvedTargetPlatform.create(tp1, indexBuilder);
		targetDef.resolve(new MockMetadataRepositoryManager(new IQueryResultProvider<IInstallableUnit>() {
			override listIUs(java.net.URI location) {
				if ("http://download.eclipse.org/tools/orbit/downloads/drops/R20130517111416/repository/".equals(location.toString)) {
					newImmutableList(
						new MockIU("com.google.guava", Version.createOSGi(10,0,0)),
						new MockIU("com.google.guava", Version.createOSGi(11,0,2)),
						new MockIU("com.google.guava", Version.createOSGi(12,0,0))
					)
				} else {
					return emptyList
				}
			}
		}), new NullProgressMonitor());
		
		assertEquals("TP1", targetDef.name)
		assertEquals(1, targetDef.locations.size)
		
		val String[] ids = targetDef.locations.map[resolvedIUs.map[id]].flatten
		val Version[] versions = targetDef.locations.map[resolvedIUs.map[version]].flatten
		assertEquals(1, ids.size)
		assertEquals("com.google.guava", ids.head)
		assertEquals("11.0.2", versions.head.toString)
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
		
		val targetDef = ResolvedTargetPlatform.create(tp1, indexBuilder);
		targetDef.resolve(new MockMetadataRepositoryManager(new IQueryResultProvider<IInstallableUnit>() {
			override listIUs(java.net.URI location) {
				if ("http://download.eclipse.org/tools/orbit/downloads/drops/R20130517111416/repository/".equals(location.toString)) {
					newImmutableList(
						new MockIU("com.google.guava", Version.createOSGi(10,0,0)),
						new MockIU("com.google.guava", Version.createOSGi(11,0,2)),
						new MockIU("com.google.guava", Version.createOSGi(12,0,0))
					)
				} else {
					return emptyList
				}
			}
		}), new NullProgressMonitor());
		
		assertEquals("TP1", targetDef.name)
		assertEquals(1, targetDef.locations.size)
		
		val String[] ids = targetDef.locations.map[resolvedIUs.map[id]].flatten
		val Version[] versions = targetDef.locations.map[resolvedIUs.map[version]].flatten
		assertEquals(1, ids.size)
		assertEquals("com.google.guava", ids.head)
		assertEquals("12.0.0", versions.head.toString)
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
		
		val targetDef = ResolvedTargetPlatform.create(tp1, indexBuilder);
		targetDef.resolve(new MockMetadataRepositoryManager(new IQueryResultProvider<IInstallableUnit>() {
			override listIUs(java.net.URI location) {
				if ("http://download.eclipse.org/tools/orbit/downloads/drops/R20130517111416/repository/".equals(location.toString)) {
					newImmutableList(
						new MockIU("com.google.guava", Version.createOSGi(10,0,0)),
						new MockIU("com.google.guava", Version.createOSGi(11,0,2)),
						new MockIU("com.google.guava", Version.createOSGi(12,0,0))
					)
				} else {
					return emptyList
				}
			}
		}), new NullProgressMonitor());
		
		assertEquals("TP1", targetDef.name)
		assertEquals(1, targetDef.locations.size)
		
		val String[] ids = targetDef.locations.map[resolvedIUs.map[id]].flatten
		val Version[] versions = targetDef.locations.map[resolvedIUs.map[version]].flatten
		assertEquals(1, ids.size)
		assertEquals("com.google.guava", ids.head)
		assertEquals("11.0.2", versions.head.toString)
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
		
		val targetDef = ResolvedTargetPlatform.create(tp1, indexBuilder);
		targetDef.resolve(new MockMetadataRepositoryManager(new IQueryResultProvider<IInstallableUnit>() {
			override listIUs(java.net.URI location) {
				if ("http://download.eclipse.org/tools/orbit/downloads/drops/R20130517111416/repository/".equals(location.toString)) {
					newImmutableList(
						new MockIU("com.google.guava", Version.createOSGi(10,0,0)),
						new MockIU("com.google.guava", Version.createOSGi(11,0,2)),
						new MockIU("com.google.guava", Version.createOSGi(12,0,0))
					)
				} else {
					return emptyList
				}
			}
		}), new NullProgressMonitor());
		
		assertEquals("TP1", targetDef.name)
		assertEquals(1, targetDef.locations.size)
		
		val String[] ids = targetDef.locations.map[resolvedIUs.map[id]].flatten
		val Version[] versions = targetDef.locations.map[resolvedIUs.map[version]].flatten
		assertEquals(1, ids.size)
		assertEquals("com.google.guava", ids.head)
		assertEquals("12.0.0", versions.head.toString)
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
		
		val targetDef = ResolvedTargetPlatform.create(tp1, indexBuilder);
		targetDef.resolve(new MockMetadataRepositoryManager(new IQueryResultProvider<IInstallableUnit>() {
			override listIUs(java.net.URI location) {
				if ("http://download.eclipse.org/tools/orbit/downloads/drops/R20130517111416/repository/".equals(location.toString)) {
					newImmutableList(
						new MockIU("com.google.guava", Version.createOSGi(10,0,0)),
						new MockIU("com.google.guava", Version.createOSGi(11,0,2)),
						new MockIU("com.google.guava", Version.createOSGi(12,0,0))
					)
				} else {
					return emptyList
				}
			}
		}), new NullProgressMonitor());
		
		assertEquals("TP1", targetDef.name)
		assertEquals(1, targetDef.locations.size)
		
		val String[] ids = targetDef.locations.map[resolvedIUs.map[id]].flatten
		val Version[] versions = targetDef.locations.map[resolvedIUs.map[version]].flatten
		assertEquals(1, ids.size)
		assertEquals("com.google.guava", ids.head)
		assertEquals("11.0.2", versions.head.toString)
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
		
		val targetDef = ResolvedTargetPlatform.create(tp1, indexBuilder);
		targetDef.resolve(new MockMetadataRepositoryManager(new IQueryResultProvider<IInstallableUnit>() {
			override listIUs(java.net.URI location) {
				if ("http://download.eclipse.org/tools/orbit/downloads/drops/R20130517111416/repository/".equals(location.toString)) {
					newImmutableList(
						new MockIU("com.google.guava", Version.createOSGi(10,0,0)),
						new MockIU("com.google.guava", Version.createOSGi(11,0,2)),
						new MockIU("com.google.guava", Version.createOSGi(12,0,0))
					)
				} else {
					return emptyList
				}
			}
		}), new NullProgressMonitor());
		
		assertEquals("TP1", targetDef.name)
		assertEquals(1, targetDef.locations.size)
		
		val String[] ids = targetDef.locations.map[resolvedIUs.map[id]].flatten
		val Version[] versions = targetDef.locations.map[resolvedIUs.map[version]].flatten
		assertEquals(1, ids.size)
		assertEquals("com.google.guava", ids.head)
		assertEquals("12.0.0", versions.head.toString)
	}
	
	@Test
	def testSource1() {
		val tp1 = parser.parse('''
			target "TP1"
			with source
			location "http://download.eclipse.org/tools/orbit/downloads/drops/R20130517111416/repository/" {
				com.google.guava
			}
		''')
		
		val targetDef = ResolvedTargetPlatform.create(tp1, indexBuilder);
		targetDef.resolve(new MockMetadataRepositoryManager(new IQueryResultProvider<IInstallableUnit>() {
			override listIUs(java.net.URI location) {
				if ("http://download.eclipse.org/tools/orbit/downloads/drops/R20130517111416/repository/".equals(location.toString)) {
					newImmutableList(
						new MockIU("com.google.guava", Version.createOSGi(10,0,0)),
						new MockIU("com.google.guava.source", Version.createOSGi(10,0,0))
					)
				} else {
					return emptyList
				}
			}
		}), new NullProgressMonitor());
		
		assertEquals("TP1", targetDef.name)
		assertEquals(1, targetDef.locations.size)
		
		val String[] ids = targetDef.locations.map[resolvedIUs.map[id]].flatten
		assertEquals(1, ids.size)
		assertEquals("com.google.guava", ids.head)
	}
	
	@Test
	def testSource2() {
		val tp1 = parser.parse('''
			target "TP1"
			with source
			location "http://download.eclipse.org/tools/orbit/downloads/drops/R20130517111416/repository/" {
				com.google.guava
				com.google.guava.^source
			}
		''')
		
		val targetDef = ResolvedTargetPlatform.create(tp1, indexBuilder);
		targetDef.resolve(new MockMetadataRepositoryManager(new IQueryResultProvider<IInstallableUnit>() {
			override listIUs(java.net.URI location) {
				if ("http://download.eclipse.org/tools/orbit/downloads/drops/R20130517111416/repository/".equals(location.toString)) {
					newImmutableList(
						new MockIU("com.google.guava", Version.createOSGi(10,0,0)),
						new MockIU("com.google.guava.source", Version.createOSGi(10,0,0))
					)
				} else {
					return emptyList
				}
			}
		}), new NullProgressMonitor());
		
		assertEquals("TP1", targetDef.name)
		assertEquals(1, targetDef.locations.size)
		
		val String[] ids = targetDef.locations.map[resolvedIUs.map[id]].flatten
		assertEquals(2, ids.size)
		assertEquals("com.google.guava", ids.head)
		assertEquals("com.google.guava.source", ids.get(1))
	}
	
	@Test
	def testSource3() {
		val tp1 = parser.parse('''
			target "TP1"
			with source
			location "http://download.eclipse.org/modeling/emf/compare/updates/releases/2.1/R201310031412/" {
				org.eclipse.emf.compare.rcp.ui.feature.group
			}
		''')
		
		val targetDef = ResolvedTargetPlatform.create(tp1, indexBuilder);
		targetDef.resolve(new MockMetadataRepositoryManager(new IQueryResultProvider<IInstallableUnit>() {
			override listIUs(java.net.URI location) {
				if ("http://download.eclipse.org/modeling/emf/compare/updates/releases/2.1/R201310031412/".equals(location.toString)) {
					newImmutableList(
						MockIU::createFeature("org.eclipse.emf.compare.rcp.ui.feature.group", Version.createOSGi(10,0,0)),
						MockIU::createFeature("org.eclipse.emf.compare.rcp.ui.source.feature.group", Version.createOSGi(10,0,0))
					)
				} else {
					return emptyList
				}
			}
		}), new NullProgressMonitor());
		
		assertEquals("TP1", targetDef.name)
		assertEquals(1, targetDef.locations.size)
		
		val String[] ids = targetDef.locations.map[resolvedIUs.map[id]].flatten
		assertEquals(1, ids.size)
		assertEquals("org.eclipse.emf.compare.rcp.ui.feature.group", ids.head)
	}
	
	@Test
	def testSource4() {
		val tp1 = parser.parse('''
			target "TP1"
			with source
			location "http://download.eclipse.org/modeling/emf/compare/updates/releases/2.1/R201310031412/" {
				org.eclipse.emf.compare.rcp.ui.feature.group
				org.eclipse.emf.compare.rcp.ui.^source.feature.group
			}
		''')
		
		val targetDef = ResolvedTargetPlatform.create(tp1, indexBuilder);
		targetDef.resolve(new MockMetadataRepositoryManager(new IQueryResultProvider<IInstallableUnit>() {
			override listIUs(java.net.URI location) {
				if ("http://download.eclipse.org/modeling/emf/compare/updates/releases/2.1/R201310031412/".equals(location.toString)) {
					newImmutableList(
						MockIU::createFeature("org.eclipse.emf.compare.rcp.ui.feature.group", Version.createOSGi(10,0,0)),
						MockIU::createFeature("org.eclipse.emf.compare.rcp.ui.source.feature.group", Version.createOSGi(10,0,0))
					)
				} else {
					return emptyList
				}
			}
		}), new NullProgressMonitor());
		
		assertEquals("TP1", targetDef.name)
		assertEquals(1, targetDef.locations.size)
		
		val String[] ids = targetDef.locations.map[resolvedIUs.map[id]].flatten
		assertEquals(2, ids.size)
		assertEquals("org.eclipse.emf.compare.rcp.ui.feature.group", ids.head)
		assertEquals("org.eclipse.emf.compare.rcp.ui.source.feature.group", ids.get(1))
	}
	
	@Test
	def testLocationOrder() {
		val o = parser.parse('''
			target "Kepler 4.3 SDK"
			location "http://download.eclipse.org/egit/updates-3.3"
			location "http://download.eclipse.org/modeling/emf/emf/updates/2.9.x/core/R201402030812/"
			location "http://download.eclipse.org/modeling/emf/compare/updates/releases/2.1/R201310031412/"
			location "http://download.eclipse.org/tools/orbit/downloads/drops/R20130517111416/repository/"
		''')
		
		val targetDef = ResolvedTargetPlatform.create(o, indexBuilder);
		targetDef.resolve(new MockMetadataRepositoryManager(new IQueryResultProvider<IInstallableUnit>() {
			override listIUs(java.net.URI location) {
				return emptyList
			}
		}), new NullProgressMonitor());
		
		assertEquals("http://download.eclipse.org/egit/updates-3.3", targetDef.locations.get(0).URI.toString)
		assertEquals("http://download.eclipse.org/modeling/emf/emf/updates/2.9.x/core/R201402030812/", targetDef.locations.get(1).URI.toString)
		assertEquals("http://download.eclipse.org/modeling/emf/compare/updates/releases/2.1/R201310031412/", targetDef.locations.get(2).URI.toString)
		assertEquals("http://download.eclipse.org/tools/orbit/downloads/drops/R20130517111416/repository/", targetDef.locations.get(3).URI.toString)
	}
	
	@Test
	def testLocationOrderWithIncludes1() {
		val resourceSet = resourceSetProvider.get
		val tp1 = parser.parse('''
			target "Kepler 4.3 SDK"
			include "tp2.tpd"
			location "http://download.eclipse.org/modeling/emf/emf/updates/2.9.x/core/R201402030812/"
			location "http://download.eclipse.org/modeling/emf/compare/updates/releases/2.1/R201310031412/"
			location "http://download.eclipse.org/tools/orbit/downloads/drops/R20130517111416/repository/"
		''', URI.createURI("tmp:/tp1.tpd"), resourceSet)
		val tp2 = parser.parse('''
			target "TP2"
			location "http://mbarbero.github.io/fr.obeo.releng.targetplatform/p2/latest/"
			location "http://download.eclipse.org/egit/updates-3.3"
			location "http://download.eclipse.org/sirius/updates/releases/0.9.0/kepler"
		''', URI.createURI("tmp:/tp2.tpd"), resourceSet)
		
		val targetDef = ResolvedTargetPlatform.create(tp1, indexBuilder);
		targetDef.resolve(new MockMetadataRepositoryManager(new IQueryResultProvider<IInstallableUnit>() {
			override listIUs(java.net.URI location) {
				return emptyList
			}
		}), new NullProgressMonitor());
		
		assertEquals("http://mbarbero.github.io/fr.obeo.releng.targetplatform/p2/latest/", targetDef.locations.get(0).URI.toString)
		assertEquals("http://download.eclipse.org/egit/updates-3.3", targetDef.locations.get(1).URI.toString)
		assertEquals("http://download.eclipse.org/sirius/updates/releases/0.9.0/kepler", targetDef.locations.get(2).URI.toString)
		assertEquals("http://download.eclipse.org/modeling/emf/emf/updates/2.9.x/core/R201402030812/", targetDef.locations.get(3).URI.toString)
		assertEquals("http://download.eclipse.org/modeling/emf/compare/updates/releases/2.1/R201310031412/", targetDef.locations.get(4).URI.toString)
		assertEquals("http://download.eclipse.org/tools/orbit/downloads/drops/R20130517111416/repository/", targetDef.locations.get(5).URI.toString)
	}
	
	@Test
	def testLocationOrderWithIncludes2() {
		val resourceSet = resourceSetProvider.get
		val tp1 = parser.parse('''
			target "Kepler 4.3 SDK"
			include "tp2.tpd"
			location "http://download.eclipse.org/modeling/emf/emf/updates/2.9.x/core/R201402030812/"
			location "http://download.eclipse.org/modeling/emf/compare/updates/releases/2.1/R201310031412/"
		''', URI.createURI("tmp:/tp1.tpd"), resourceSet)
		val tp2 = parser.parse('''
			target "TP2"
			include "tp3.tpd"
			location "http://mbarbero.github.io/fr.obeo.releng.targetplatform/p2/latest/"
			location "http://download.eclipse.org/egit/updates-3.3"
		''', URI.createURI("tmp:/tp2.tpd"), resourceSet)
		val tp3 = parser.parse('''
			target "TP3"
			location "http://download.eclipse.org/tools/orbit/downloads/drops/R20130517111416/repository/"
			location "http://download.eclipse.org/sirius/updates/releases/0.9.0/kepler"
		''', URI.createURI("tmp:/tp3.tpd"), resourceSet)
		
		val targetDef = ResolvedTargetPlatform.create(tp1, indexBuilder);
		targetDef.resolve(new MockMetadataRepositoryManager(new IQueryResultProvider<IInstallableUnit>() {
			override listIUs(java.net.URI location) {
				return emptyList
			}
		}), new NullProgressMonitor());
		
		assertEquals("http://download.eclipse.org/tools/orbit/downloads/drops/R20130517111416/repository/", targetDef.locations.get(0).URI.toString)
		assertEquals("http://download.eclipse.org/sirius/updates/releases/0.9.0/kepler", targetDef.locations.get(1).URI.toString)
		assertEquals("http://mbarbero.github.io/fr.obeo.releng.targetplatform/p2/latest/", targetDef.locations.get(2).URI.toString)
		assertEquals("http://download.eclipse.org/egit/updates-3.3", targetDef.locations.get(3).URI.toString)
		assertEquals("http://download.eclipse.org/modeling/emf/emf/updates/2.9.x/core/R201402030812/", targetDef.locations.get(4).URI.toString)
		assertEquals("http://download.eclipse.org/modeling/emf/compare/updates/releases/2.1/R201310031412/", targetDef.locations.get(5).URI.toString)
	}
	
	@Test
	def testLocationOrderWithIncludes3() {
		val resourceSet = resourceSetProvider.get
		val tp1 = parser.parse('''
			target "Kepler 4.3 SDK"
			include "tp3.tpd"
			include "tp2.tpd"
			location "http://download.eclipse.org/modeling/emf/emf/updates/2.9.x/core/R201402030812/"
			location "http://download.eclipse.org/modeling/emf/compare/updates/releases/2.1/R201310031412/"
		''', URI.createURI("tmp:/tp1.tpd"), resourceSet)
		val tp2 = parser.parse('''
			target "TP2"
			location "http://mbarbero.github.io/fr.obeo.releng.targetplatform/p2/latest/"
			location "http://download.eclipse.org/egit/updates-3.3"
		''', URI.createURI("tmp:/tp2.tpd"), resourceSet)
		val tp3 = parser.parse('''
			target "TP3"
			location "http://download.eclipse.org/tools/orbit/downloads/drops/R20130517111416/repository/"
			location "http://download.eclipse.org/sirius/updates/releases/0.9.0/kepler"
		''', URI.createURI("tmp:/tp3.tpd"), resourceSet)
		
		val targetDef = ResolvedTargetPlatform.create(tp1, indexBuilder);
		targetDef.resolve(new MockMetadataRepositoryManager(new IQueryResultProvider<IInstallableUnit>() {
			override listIUs(java.net.URI location) {
				return emptyList
			}
		}), new NullProgressMonitor());
		
		assertEquals("http://download.eclipse.org/tools/orbit/downloads/drops/R20130517111416/repository/", targetDef.locations.get(0).URI.toString)
		assertEquals("http://download.eclipse.org/sirius/updates/releases/0.9.0/kepler", targetDef.locations.get(1).URI.toString)
		assertEquals("http://mbarbero.github.io/fr.obeo.releng.targetplatform/p2/latest/", targetDef.locations.get(2).URI.toString)
		assertEquals("http://download.eclipse.org/egit/updates-3.3", targetDef.locations.get(3).URI.toString)
		assertEquals("http://download.eclipse.org/modeling/emf/emf/updates/2.9.x/core/R201402030812/", targetDef.locations.get(4).URI.toString)
		assertEquals("http://download.eclipse.org/modeling/emf/compare/updates/releases/2.1/R201310031412/", targetDef.locations.get(5).URI.toString)
	}
	
	@Test
	def testResolutionDiagnosticVerbosity() {
		val tp = parser.parse('''
			target "target_with_resolution_pb"

			location "http://download.eclipse.org/egit/updates-3.3" {
				org.eclipse.egit.feature.group;version=[3.3,3.4)
				org.eclipse.egit.mylyn.feature.group;version=[3.3,3.4)
			}
			
			location "http://download.eclipse.org/tools/orbit/downloads/drops/R20130517111416/repository/" {
			    com.google.guava;version=[20.0.0,22.0.0)
			}
			
			location "http://download.eclipse.org/modeling/emf/compare/updates/releases/2.1/R201310031412/" {
				org.eclipse.emf.compare.rcp.ui.feature.group
			}
		''')
		
		val resolvedTargetPlatform = ResolvedTargetPlatform.create(tp, indexBuilder);
		val d = resolvedTargetPlatform.resolve(new MockMetadataRepositoryManager(new IQueryResultProvider<IInstallableUnit>() {
			override listIUs(java.net.URI location) {
				if ("http://download.eclipse.org/egit/updates-3.3".equals(location.toString)) {
					newImmutableList(
						MockIU::createFeature("org.eclipse.egit.feature.group", Version.createOSGi(3,3,2)),
						MockIU::createFeature("org.eclipse.egit.mylyn.feature.group", Version.createOSGi(3,3,2))
					)
				} else if ("http://download.eclipse.org/tools/orbit/downloads/drops/R20130517111416/repository/".equals(location.toString)) {
					newImmutableList(
						MockIU::createFeature("com.google.guava", Version.createOSGi(10,0,0)),
						MockIU::createFeature("com.google.guava", Version.createOSGi(11,0,2)),
						MockIU::createFeature("com.google.guava", Version.createOSGi(12,0,0))
					)
				} else if ("http://download.eclipse.org/modeling/emf/compare/updates/releases/2.1/R201310031412/".equals(location.toString)) {
					newImmutableList(
						MockIU::createFeature("org.eclipse.emf.compare.rcp.ui.feature.group", Version.createOSGi(5,0,0))
					)
				} else {
					return emptyList
				}
			}
		}), new NullProgressMonitor());
		
		assertEquals(Diagnostic.ERROR, d.severity);
		assertEquals(1, d.children.size)
		assertEquals(Diagnostic.ERROR, d.children.head.severity);
	}
}