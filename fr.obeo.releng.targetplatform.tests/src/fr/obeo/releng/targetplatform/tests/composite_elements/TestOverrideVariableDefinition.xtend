package fr.obeo.releng.targetplatform.tests.composite_elements

import com.google.inject.Inject
import com.google.inject.Provider
import fr.obeo.releng.targetplatform.TargetPlatform
import fr.obeo.releng.targetplatform.TargetPlatformInjectorProvider
import fr.obeo.releng.targetplatform.util.ImportVariableManager
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
class TestOverrideVariableDefinition {

	@Inject
	ParseHelper<TargetPlatform> parser
	
	@Inject
	Provider<XtextResourceSet> resourceSetProvider
	
	@Inject
	LocationIndexBuilder indexBuilder
	
	@Inject
	ImportVariableManager importVariableManager;
	
	@Test
	def testVarDefinitionOverride1() {
		val String[] args = #["overrideDefTarget.tpd", "var1=overrideVal1", "var3=override val 3"]
		
		importVariableManager.processCommandLineArguments(args)
		
		val resourceSet = resourceSetProvider.get
		val overrideDefTarget = parser.parse('''
			target "overrideDefTarget"
			define var1="val1"
			define var2="val2"
			define var3="val3"
			include ${var1} + ${var2} + ${var3}
		''', URI.createURI("tmp:/overrideDefTarget.tpd"), resourceSet)
		
		val locationIndex = indexBuilder.getLocationIndex(overrideDefTarget)
		assertEquals(0, locationIndex.size)
		
		val include = overrideDefTarget.includes.head
		assertEquals("overrideVal1val2override val 3", include.importURI)
		
		importVariableManager.clear
	}
	
	@Test
	def testVarDefinitionOverride2() {
		val String[] args = #["overrideDefTarget.tpd", "subDirName=subdir", "emfVer=[2.9.2,3.0.0)"]
		
		importVariableManager.processCommandLineArguments(args)
		
		val resourceSet = resourceSetProvider.get
		val overrideDefTarget = parser.parse('''
			target "overrideDefTarget"
			include "subTpd.tpd"
			include ${subDirName} + "/" + "subInclude.tpd"
		''', URI.createURI("tmp:/compositeIncludeTarget.tpd"), resourceSet)
		parser.parse('''
			target "subTpd"
			define subDirName="subdirNotOverride"
		''', URI.createURI("tmp:/subTpd.tpd"), resourceSet)
		parser.parse('''
			target "subInclude"
			define emfVer = "[2.9.2,2.9.3)"
			location "http://download.eclipse.org/modeling/emf/emf/updates/2.9.x/core/R201402030812/" {
				org.eclipse.emf.sdk.feature.group ${emfVer}
			}
		''', URI.createURI("tmp:/subdir/subInclude.tpd"), resourceSet)
		
		val locationIndex = indexBuilder.getLocationIndex(overrideDefTarget)
		assertEquals(1, locationIndex.size)
		
		val compositeImportURI = overrideDefTarget.includes.last.compositeImportURI
		assertEquals("subdir", compositeImportURI.stringParts.head.actualString)
		
		val importedTargetPlatforms = indexBuilder.getImportedTargetPlatforms(overrideDefTarget)
		val targetPlatform = importedTargetPlatforms.first
		assertEquals("subInclude", targetPlatform.name)
		val location = targetPlatform.locations.last
		assertEquals("[2.9.2,3.0.0)", location.ius.head.version)
		
		importVariableManager.clear
	}
	
	@Test
	def testDefinitionFromVariableCallOverride() {
		val String[] args = #["overrideDefTarget.tpd", "subDirName=subdir", "emfVerEnd=3.0.0)"]
		
		importVariableManager.processCommandLineArguments(args)
		
		val resourceSet = resourceSetProvider.get
		val overrideDefTarget = parser.parse('''
			target "overrideDefTarget"
			include "subTpd.tpd"
			define subDirNameRef = ${subDirName} + "/"
			define subIncludeUrl = ${subDirNameRef} + "subInclude.tpd"
			include ${subIncludeUrl}
		''', URI.createURI("tmp:/overrideDefTarget.tpd"), resourceSet)
		parser.parse('''
			target "subTpd"
			define subDirName="subdirNotOverride"
		''', URI.createURI("tmp:/subTpd.tpd"), resourceSet)
		parser.parse('''
			target "subInclude"
			include "subSubInclude.tpd"
			location "http://download.eclipse.org/modeling/emf/emf/updates/2.9.x/core/R201402030812/" {
				org.eclipse.emf.sdk.feature.group ${emfVer}
			}
		''', URI.createURI("tmp:/subdir/subInclude.tpd"), resourceSet)
		parser.parse('''
			target "subSubInclude"
			define emfVer = ${emfVerStart} + "," + ${emfVerEnd}
			define emfVerStart = "[" + ${emfVerStartNum}
			define emfVerEnd = ${emfVerEndNum} + ")-normallyWrongButWillBeReplaced"
			define emfVerStartNum = "2.9.2"
			define emfVerEndNum = "4.0.0"
		''', URI.createURI("tmp:/subdir/subSubInclude.tpd"), resourceSet)
		
		val locationIndex = indexBuilder.getLocationIndex(overrideDefTarget)
		assertEquals(1, locationIndex.size)
		
		val compositeImportURI = overrideDefTarget.includes.last.compositeImportURI
		assertEquals("subdir/subInclude.tpd", compositeImportURI.stringParts.head.actualString)
		
		val importedTargetPlatforms = indexBuilder.getImportedTargetPlatforms(overrideDefTarget)
		val targetPlatform = importedTargetPlatforms.first
		assertEquals("subInclude", targetPlatform.name)
		val location = targetPlatform.locations.last
		assertEquals("[2.9.2,3.0.0)", location.ius.head.version)
		
		importVariableManager.clear
	}
}
