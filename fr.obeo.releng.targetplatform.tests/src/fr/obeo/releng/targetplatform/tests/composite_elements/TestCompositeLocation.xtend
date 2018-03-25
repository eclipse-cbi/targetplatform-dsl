package fr.obeo.releng.targetplatform.tests.composite_elements

import com.google.inject.Inject
import com.google.inject.Provider
import fr.obeo.releng.targetplatform.TargetPlatform
import fr.obeo.releng.targetplatform.TargetPlatformInjectorProvider
import fr.obeo.releng.targetplatform.util.LocationIndexBuilder
import org.eclipse.emf.common.util.URI
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.util.ParseHelper
import org.eclipse.xtext.resource.XtextResourceSet
import org.junit.Test
import org.junit.runner.RunWith

import static org.junit.Assert.*
import fr.obeo.releng.targetplatform.VarCall
import fr.obeo.releng.targetplatform.VarDefinition

@InjectWith(typeof(TargetPlatformInjectorProvider))
@RunWith(typeof(XtextRunner))
class TestCompositeLocation {
	
	@Inject
	ParseHelper<TargetPlatform> parser
	
	@Inject
	Provider<XtextResourceSet> resourceSetProvider
	
	@Inject
	LocationIndexBuilder indexBuilder
	
	@Test
	def testIncludeWithMultipleStaticString() {
		val resourceSet = resourceSetProvider.get
		val compositeIncludeTarget = parser.parse('''
			target "compositeIncludeTarget"
			include "subdir" + "/" + "subInclude.tpd"
		''', URI.createURI("tmp:/compositeIncludeTarget.tpd"), resourceSet)
		parser.parse('''
			target "subInclude"
			location "http://download.eclipse.org/modeling/emf/emf/updates/2.9.x/core/R201402030812/" {
				org.eclipse.emf.sdk.feature.group
			}
		''', URI.createURI("tmp:/subdir/subInclude.tpd"), resourceSet)
		
		val importedTargetPlatforms = indexBuilder.getImportedTargetPlatforms(compositeIncludeTarget)
		assertEquals(1, importedTargetPlatforms.length)
		
		val targetPlatform = importedTargetPlatforms.first
		assertEquals("subInclude", targetPlatform.name)
		assertEquals("http://download.eclipse.org/modeling/emf/emf/updates/2.9.x/core/R201402030812/", targetPlatform.locations.last.uri)
		assertEquals("org.eclipse.emf.sdk.feature.group", targetPlatform.locations.last.ius.last.ID)
		
		val locationIndex = indexBuilder.getLocationIndex(compositeIncludeTarget)
		assertEquals(1, locationIndex.size)
	}
	
	@Test
	def testIncludeWithVarCall1() {
		val resourceSet = resourceSetProvider.get
		val compositeIncludeTarget = parser.parse('''
			target "compositeIncludeTarget"
			define subDirName="subdir"
			include ${subDirName} + "/" + "subInclude.tpd"
		''', URI.createURI("tmp:/compositeIncludeTarget.tpd"), resourceSet)
		parser.parse('''
			target "subInclude"
			location "http://download.eclipse.org/modeling/emf/emf/updates/2.9.x/core/R201402030812/" {
				org.eclipse.emf.sdk.feature.group
			}
		''', URI.createURI("tmp:/subdir/subInclude.tpd"), resourceSet)
		
		val compositeImportURI = compositeIncludeTarget.includes.last.compositeImportURI
		assertEquals("subdir", compositeImportURI.stringParts.head.actualString)
		
		val importedTargetPlatforms = indexBuilder.getImportedTargetPlatforms(compositeIncludeTarget)
		val targetPlatform = importedTargetPlatforms.first
		assertEquals("http://download.eclipse.org/modeling/emf/emf/updates/2.9.x/core/R201402030812/", targetPlatform.locations.last.uri)
	}
	
	@Test
	def testIncludeWithVarCall2() {
		val resourceSet = resourceSetProvider.get
		val compositeIncludeTarget = parser.parse('''
			target "compositeIncludeTarget"
			define subDirName="subdir"
			define tpdFilename="subInclude.tpd"
			include ${subDirName} + "/" + ${tpdFilename}
		''', URI.createURI("tmp:/compositeIncludeTarget.tpd"), resourceSet)
		parser.parse('''
			target "subInclude"
			location "http://download.eclipse.org/modeling/emf/emf/updates/2.9.x/core/R201402030812/" {
				org.eclipse.emf.sdk.feature.group
			}
		''', URI.createURI("tmp:/subdir/subInclude.tpd"), resourceSet)
		
		val compositeImportURI = compositeIncludeTarget.includes.last.compositeImportURI
		assertEquals("subdir", compositeImportURI.stringParts.head.actualString)
		assertEquals("subInclude.tpd", compositeImportURI.stringParts.last.actualString)
		
		val importedTargetPlatforms = indexBuilder.getImportedTargetPlatforms(compositeIncludeTarget)
		val targetPlatform = importedTargetPlatforms.first
		assertEquals("http://download.eclipse.org/modeling/emf/emf/updates/2.9.x/core/R201402030812/", targetPlatform.locations.last.uri)
	}
	
	@Test
	def testIncludeWithVarCallFromSubTpd() {
		val resourceSet = resourceSetProvider.get
		val compositeIncludeTarget = parser.parse('''
			target "compositeIncludeTarget"
			include "subTpd.tpd"
			include ${subDirName} + "/" + "subInclude.tpd"
		''', URI.createURI("tmp:/compositeIncludeTarget.tpd"), resourceSet)
		parser.parse('''
			target "subTpd"
			define subDirName="subdir"
		''', URI.createURI("tmp:/subTpd.tpd"), resourceSet)
		parser.parse('''
			target "subInclude"
			location "http://download.eclipse.org/modeling/emf/emf/updates/2.9.x/core/R201402030812/" {
				org.eclipse.emf.sdk.feature.group
			}
		''', URI.createURI("tmp:/subdir/subInclude.tpd"), resourceSet)
		
		val locationIndex = indexBuilder.getLocationIndex(compositeIncludeTarget)
		assertEquals(1, locationIndex.size)
		
		val compositeImportURI = compositeIncludeTarget.includes.last.compositeImportURI
		assertEquals("subdir", compositeImportURI.stringParts.head.actualString)
		
		val importedTargetPlatforms = indexBuilder.getImportedTargetPlatforms(compositeIncludeTarget)
		val targetPlatform = importedTargetPlatforms.first
		assertEquals("subInclude", targetPlatform.name)
		assertEquals("http://download.eclipse.org/modeling/emf/emf/updates/2.9.x/core/R201402030812/", targetPlatform.locations.last.uri)
	}
	
	@Test
	def testIncludeWithVarCallFromSubTpd2() {
		val resourceSet = resourceSetProvider.get
		val compositeIncludeTarget = parser.parse('''
			target "compositeIncludeTarget"
			define subTpdFile="subTpd.tpd"
			include ${subTpdFile}
			include ${subDirName} + "/" + "subInclude.tpd"
		''', URI.createURI("tmp:/compositeIncludeTarget.tpd"), resourceSet)
		parser.parse('''
			target "subTpd"
			define subDirName="subdir"
		''', URI.createURI("tmp:/subTpd.tpd"), resourceSet)
		parser.parse('''
			target "subInclude"
			location "http://download.eclipse.org/modeling/emf/emf/updates/2.9.x/core/R201402030812/" {
				org.eclipse.emf.sdk.feature.group
			}
		''', URI.createURI("tmp:/subdir/subInclude.tpd"), resourceSet)
		
		val locationIndex = indexBuilder.getLocationIndex(compositeIncludeTarget)
		assertEquals(1, locationIndex.size)
		
		val compositeImportURI = compositeIncludeTarget.includes.last.compositeImportURI
		assertEquals("subdir", compositeImportURI.stringParts.head.actualString)
		
		val importedTargetPlatforms = indexBuilder.getImportedTargetPlatforms(compositeIncludeTarget)
		val targetPlatform = importedTargetPlatforms.first
		assertEquals("subInclude", targetPlatform.name)
		assertEquals("http://download.eclipse.org/modeling/emf/emf/updates/2.9.x/core/R201402030812/", targetPlatform.locations.last.uri)
	}
	
	@Test
	def testIncludeWithVarCallFromSubSubTpd() {
		val resourceSet = resourceSetProvider.get
		val compositeIncludeTarget = parser.parse('''
			target "compositeIncludeTarget"
			include "subTpd.tpd"
			include ${subDirName} + "/" + "subInclude.tpd"
		''', URI.createURI("tmp:/compositeIncludeTarget.tpd"), resourceSet)
		parser.parse('''
			target "subTpd"
			include "subsubTpd.tpd"
		''', URI.createURI("tmp:/subTpd.tpd"), resourceSet)
		parser.parse('''
			target "subsubTpd"
			define subDirName="subdir"
		''', URI.createURI("tmp:/subsubTpd.tpd"), resourceSet)
		parser.parse('''
			target "subInclude"
			location "http://download.eclipse.org/modeling/emf/emf/updates/2.9.x/core/R201402030812/" {
				org.eclipse.emf.sdk.feature.group
			}
		''', URI.createURI("tmp:/subdir/subInclude.tpd"), resourceSet)
		
		val locationIndex = indexBuilder.getLocationIndex(compositeIncludeTarget)
		assertEquals(1, locationIndex.size)
		
		val compositeImportURI = compositeIncludeTarget.includes.last.compositeImportURI
		assertEquals("subdir", compositeImportURI.stringParts.head.actualString)
		
		val importedTargetPlatforms = indexBuilder.getImportedTargetPlatforms(compositeIncludeTarget)
		assertEquals(3, importedTargetPlatforms.size)
		val targetPlatform = importedTargetPlatforms.first
		assertEquals("subInclude", targetPlatform.name)
		assertEquals("http://download.eclipse.org/modeling/emf/emf/updates/2.9.x/core/R201402030812/", targetPlatform.locations.last.uri)
	}
	
	@Test
	def testIncludeWithVarDefintionOverride1() {
		val resourceSet = resourceSetProvider.get
		val compositeIncludeTarget = parser.parse('''
			target "compositeIncludeTarget"
			include "subTpd.tpd"
			include ${subDirName} + "/" + "subInclude.tpd"
		''', URI.createURI("tmp:/compositeIncludeTarget.tpd"), resourceSet)
		parser.parse('''
			target "subTpd"
			include "subsubTpd.tpd"
			define subDirName="subdir"
		''', URI.createURI("tmp:/subTpd.tpd"), resourceSet)
		parser.parse('''
			target "subsubTpd"
			define subDirName="wrongSubdir"
		''', URI.createURI("tmp:/subsubTpd.tpd"), resourceSet)
		parser.parse('''
			target "subInclude"
			location "http://download.eclipse.org/modeling/emf/emf/updates/2.9.x/core/R201402030812/" {
				org.eclipse.emf.sdk.feature.group
			}
		''', URI.createURI("tmp:/subdir/subInclude.tpd"), resourceSet)
		
		val locationIndex = indexBuilder.getLocationIndex(compositeIncludeTarget)
		assertEquals(1, locationIndex.size)
		
		val compositeImportURI = compositeIncludeTarget.includes.last.compositeImportURI
		assertEquals("subdir", compositeImportURI.stringParts.head.actualString)
		
		val importedTargetPlatforms = indexBuilder.getImportedTargetPlatforms(compositeIncludeTarget)
		val targetPlatform = importedTargetPlatforms.first
		assertEquals("subInclude", targetPlatform.name)
		assertEquals("http://download.eclipse.org/modeling/emf/emf/updates/2.9.x/core/R201402030812/", targetPlatform.locations.last.uri)
		assertEquals("org.eclipse.emf.sdk.feature.group", targetPlatform.locations.last.ius.head.ID)
	}
	
	@Test
	def testIncludeWithVarDefintionOverride2() {
		val resourceSet = resourceSetProvider.get
		val compositeIncludeTarget = parser.parse('''
			target "compositeIncludeTarget"
			include "subTpd.tpd"
			include ${subDirName} + "/" + "subInclude.tpd"
		''', URI.createURI("tmp:/compositeIncludeTarget.tpd"), resourceSet)
		parser.parse('''
			target "subTpd"
			include "subsubTpd.tpd"
			define subDirName="wrongSubdir"
		''', URI.createURI("tmp:/subTpd.tpd"), resourceSet)
		parser.parse('''
			target "subsubTpd"
			define subDirName="subdir"
		''', URI.createURI("tmp:/subsubTpd.tpd"), resourceSet)
		parser.parse('''
			target "subInclude"
			location "http://download.eclipse.org/modeling/emf/emf/updates/2.9.x/core/R201402030812/" {
				org.eclipse.emf.sdk.feature.group
			}
		''', URI.createURI("tmp:/subdir/subInclude.tpd"), resourceSet)
		
		val locationIndex = indexBuilder.getLocationIndex(compositeIncludeTarget)
		assertEquals(0, locationIndex.size)
		
		val compositeImportURI = compositeIncludeTarget.includes.last.compositeImportURI
		assertEquals("wrongSubdir", compositeImportURI.stringParts.head.actualString)
		val varCall = compositeImportURI.stringParts.head as VarCall
		assertEquals("subDirName", varCall.varName.name)
		
		val importedTargetPlatforms = indexBuilder.getImportedTargetPlatforms(compositeIncludeTarget)
		val varDef = importedTargetPlatforms.last.contents.head as VarDefinition
		assertEquals("subdir", varDef.value)
	}
	
	@Test
	def testIncludeGetLocationIndexCallmanyTimes() {
		val resourceSet = resourceSetProvider.get
		val compositeIncludeTarget = parser.parse('''
			target "compositeIncludeTarget"
			include "subTpd.tpd"
			include ${subDirName} + "/" + "subInclude.tpd"
		''', URI.createURI("tmp:/compositeIncludeTarget.tpd"), resourceSet)
		parser.parse('''
			target "subTpd"
			include "subsubTpd.tpd"
			define subDirName="wrongSubdir"
		''', URI.createURI("tmp:/subTpd.tpd"), resourceSet)
		parser.parse('''
			target "subsubTpd"
			define subDirName="subdir"
		''', URI.createURI("tmp:/subsubTpd.tpd"), resourceSet)
		parser.parse('''
			target "subInclude"
			location "http://download.eclipse.org/modeling/emf/emf/updates/2.9.x/core/R201402030812/" {
				org.eclipse.emf.sdk.feature.group
			}
		''', URI.createURI("tmp:/subdir/subInclude.tpd"), resourceSet)
		
		val locationIndex = indexBuilder.getLocationIndex(compositeIncludeTarget)
		assertEquals(0, locationIndex.size)
		
		val compositeImportURI = compositeIncludeTarget.includes.last.compositeImportURI
		assertEquals("wrongSubdir", compositeImportURI.stringParts.head.actualString)
	}
	
	@Test
	def testCompositeLocation() {
		val resourceSet = resourceSetProvider.get
		val compositeLocationTarget = parser.parse('''
			target "compositeLocationTarget"
			define locationUrl="http://download.eclipse.org/modeling/emf/emf/updates/2.9.x/core/R201402030812/"
			location ${locationUrl} {
				org.eclipse.emf.sdk.feature.group
			}
		''', URI.createURI("tmp:/compositeLocationTarget.tpd"), resourceSet)
		
		val locationIndex = indexBuilder.getLocationIndex(compositeLocationTarget)
		assertEquals(1, locationIndex.size)
		
		assertEquals("http://download.eclipse.org/modeling/emf/emf/updates/2.9.x/core/R201402030812/", compositeLocationTarget.locations.head.uri)
		assertEquals("org.eclipse.emf.sdk.feature.group", compositeLocationTarget.locations.last.ius.head.ID)
	}
	
	@Test
	def testCompositeLocation2() {
		val resourceSet = resourceSetProvider.get
		val compositeLocationTarget = parser.parse('''
			target "compositeLocationTarget"
			define locationUrlBase="http://download.eclipse.org/"
			define locationUrlVersion="R201402030812/"
			location ${locationUrlBase} + "modeling/emf/emf/updates/2.9.x/core/" + ${locationUrlVersion} {
				org.eclipse.emf.sdk.feature.group
			}
		''', URI.createURI("tmp:/compositeLocationTarget.tpd"), resourceSet)
		
		val locationIndex = indexBuilder.getLocationIndex(compositeLocationTarget)
		assertEquals(1, locationIndex.size)
		
		assertEquals("http://download.eclipse.org/modeling/emf/emf/updates/2.9.x/core/R201402030812/", compositeLocationTarget.locations.head.uri)
		assertEquals("org.eclipse.emf.sdk.feature.group", compositeLocationTarget.locations.last.ius.head.ID)
	}
	
	@Test
	def testCompositeLocationFromCompositeInclude() {
		val resourceSet = resourceSetProvider.get
		val compositeIncludeTarget = parser.parse('''
			target "compositeIncludeTarget"
			include "subInclude.tpd"
		''', URI.createURI("tmp:/compositeIncludeTarget.tpd"), resourceSet)
		parser.parse('''
			target "subTpd"
			define locationUrlBase="http://download.eclipse.org/"
		''', URI.createURI("tmp:/subTpd.tpd"), resourceSet)
		parser.parse('''
			target "subInclude"
			include "subTpd.tpd"
			define locationUrlVersion="R201402030812/"
			location ${locationUrlBase} + "modeling/emf/emf/updates/2.9.x/core/" + ${locationUrlVersion} {
				org.eclipse.emf.sdk.feature.group
			}
		''', URI.createURI("tmp:/subInclude.tpd"), resourceSet)
		
		val locationIndex = indexBuilder.getLocationIndex(compositeIncludeTarget)
		assertEquals(1, locationIndex.size)
		
		val importedTargetPlatforms = indexBuilder.getImportedTargetPlatforms(compositeIncludeTarget)
		val targetPlatform = importedTargetPlatforms.first
		assertEquals("subInclude", targetPlatform.name)
		assertEquals("http://download.eclipse.org/modeling/emf/emf/updates/2.9.x/core/R201402030812/", targetPlatform.locations.last.uri)
		assertEquals("org.eclipse.emf.sdk.feature.group", targetPlatform.locations.last.ius.head.ID)
	}
	
	@Test
	def testIUVersionFromVariable() {
		val resourceSet = resourceSetProvider.get
		val uiVersionTarget = parser.parse('''
			target "uiVersionTarget"
			define emf.version.a="[2.10.0,3.0.0)"
			define emf.version.b = "2.10.2"
			define emf.version.c = "[1.2.0,2.0.0)"
			define emf.version.d = "[1.2.1.v20140909-0808,1.2.1.v20140909-0808]"
			define emf.version.e = "lazy"
			define emf.version.f = "erroneousVersion"
			location "http://download.eclipse.org/modeling/emf/emf/updates/2.10.x/" {
				org.eclipse.emf.sdk.feature.group ${emf.version.a}
				org.eclipse.emf.sdk.source.feature.group ; version = ${emf.version.b}
				org.eclipse.emf.ecore.xcore.feature.group ${emf.version.c}
				org.eclipse.emf.ecore.xcore.source.feature.group ${emf.version.d}
				org.eclipse.emf.codegen.ecore.feature.group ${emf.version.e}
				org.eclipse.emf.codegen.ecore.xtext.source ${emf.version.f}
			}
		''', URI.createURI("tmp:/uiVersionTarget.tpd"), resourceSet)
		
		val locationIndex = indexBuilder.getLocationIndex(uiVersionTarget)
		assertEquals(1, locationIndex.size)
		assertEquals("http://download.eclipse.org/modeling/emf/emf/updates/2.10.x/", uiVersionTarget.locations.head.uri)
		
		val location = locationIndex.values.head
		val firstIU = location.ius.get(0)
		assertEquals("org.eclipse.emf.sdk.feature.group", firstIU.ID);
		assertEquals("[2.10.0,3.0.0)", firstIU.version);
		
		val secondIU = location.ius.get(1)
		assertEquals("org.eclipse.emf.sdk.source.feature.group", secondIU.ID);
		assertEquals("2.10.2", secondIU.version);
		
		val thirdIU = location.ius.get(2)
		assertEquals("org.eclipse.emf.ecore.xcore.feature.group", thirdIU.ID);
		assertEquals("[1.2.0,2.0.0)", thirdIU.version);
		
		val fourthIU = location.ius.get(3)
		assertEquals("org.eclipse.emf.ecore.xcore.source.feature.group", fourthIU.ID);
		assertEquals("[1.2.1.v20140909-0808,1.2.1.v20140909-0808]", fourthIU.version);
		
		val fifthIU = location.ius.get(4)
		assertEquals("org.eclipse.emf.codegen.ecore.feature.group", fifthIU.ID);
		assertEquals("lazy", fifthIU.version);
		
		// An error is raised only on target generation (with all necessary information to solve it)
		val sixthIU = location.ius.get(5)
		assertEquals("org.eclipse.emf.codegen.ecore.xtext.source", sixthIU.ID);
		assertEquals("erroneousVersion", sixthIU.version);
	}
}
