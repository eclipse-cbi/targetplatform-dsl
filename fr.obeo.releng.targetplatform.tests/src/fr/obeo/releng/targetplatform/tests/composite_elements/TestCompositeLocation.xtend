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
	def testLocationWithMultipleStaticString() {
		val resourceSet = resourceSetProvider.get
		val compositeIncludeTarget = parser.parse('''
			target "compositeIncludeTarget"
			include "subdir" "/" "subInclude.tpd"
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
	def testLocationWithVarCall1() {
		val resourceSet = resourceSetProvider.get
		val compositeIncludeTarget = parser.parse('''
			target "compositeIncludeTarget"
			define subDirName="subdir"
			include ${subDirName} "/" "subInclude.tpd"
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
	def testLocationWithVarCall2() {
		val resourceSet = resourceSetProvider.get
		val compositeIncludeTarget = parser.parse('''
			target "compositeIncludeTarget"
			define subDirName="subdir"
			define tpdFilename="subInclude.tpd"
			include ${subDirName} "/" ${tpdFilename}
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
	def testLocationWithVarCallFromSubTpd() {
		val resourceSet = resourceSetProvider.get
		val compositeIncludeTarget = parser.parse('''
			target "compositeIncludeTarget"
			include "subTpd.tpd"
			include ${subDirName} "/" "subInclude.tpd"
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
	def testLocationWithVarCallFromSubTpd2() {
		val resourceSet = resourceSetProvider.get
		val compositeIncludeTarget = parser.parse('''
			target "compositeIncludeTarget"
			define subTpdFile="subTpd.tpd"
			include ${subTpdFile}
			include ${subDirName} "/" "subInclude.tpd"
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
	def testLocationWithVarCallFromSubSubTpd() {
		val resourceSet = resourceSetProvider.get
		val compositeIncludeTarget = parser.parse('''
			target "compositeIncludeTarget"
			include "subTpd.tpd"
			include ${subDirName} "/" "subInclude.tpd"
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
	def testLocationWithVarDefintionOverride1() {
		val resourceSet = resourceSetProvider.get
		val compositeIncludeTarget = parser.parse('''
			target "compositeIncludeTarget"
			include "subTpd.tpd"
			include ${subDirName} "/" "subInclude.tpd"
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
	}
	
	@Test
	def testLocationWithVarDefintionOverride2() {
		val resourceSet = resourceSetProvider.get
		val compositeIncludeTarget = parser.parse('''
			target "compositeIncludeTarget"
			include "subTpd.tpd"
			include ${subDirName} "/" "subInclude.tpd"
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
	def testLocationGetLocationIndexCallmanyTimes() {
		val resourceSet = resourceSetProvider.get
		val compositeIncludeTarget = parser.parse('''
			target "compositeIncludeTarget"
			include "subTpd.tpd"
			include ${subDirName} "/" "subInclude.tpd"
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
		
		indexBuilder.getLocationIndex(compositeIncludeTarget)
		val locationIndex = indexBuilder.getLocationIndex(compositeIncludeTarget)
		assertEquals(0, locationIndex.size)
		
		val compositeImportURI = compositeIncludeTarget.includes.last.compositeImportURI
		assertEquals("wrongSubdir", compositeImportURI.stringParts.head.actualString)
	}
}
