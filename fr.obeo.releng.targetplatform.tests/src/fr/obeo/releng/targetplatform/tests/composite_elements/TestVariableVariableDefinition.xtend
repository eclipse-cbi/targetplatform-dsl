package fr.obeo.releng.targetplatform.tests.composite_elements

import com.google.inject.Inject
import com.google.inject.Provider
import fr.obeo.releng.targetplatform.TargetPlatform
import fr.obeo.releng.targetplatform.VarDefinition
import fr.obeo.releng.targetplatform.tests.util.CustomTargetPlatformInjectorProviderTargetReloader
import fr.obeo.releng.targetplatform.util.LocationIndexBuilder
import org.eclipse.emf.common.util.URI
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.util.ParseHelper
import org.eclipse.xtext.resource.XtextResourceSet
import org.junit.Test
import org.junit.runner.RunWith

import static org.junit.Assert.*

@InjectWith(typeof(CustomTargetPlatformInjectorProviderTargetReloader))
@RunWith(typeof(XtextRunner))
class TestVariableVariableDefinition {
	
	@Inject
	ParseHelper<TargetPlatform> parser
	
	@Inject
	Provider<XtextResourceSet> resourceSetProvider
	
	@Inject
	LocationIndexBuilder indexBuilder
	
	@Test
	def testDefinitionFromVariableCallSimple1() {
		val resourceSet = resourceSetProvider.get
		val varCallDefTarget = parser.parse('''
			target "varCallDefTarget"
			define var1="val1"
			define var2=${var1}
		''', URI.createURI("tmp:/varCallDefTarget.tpd"), resourceSet)
		
		val varDef = varCallDefTarget.contents.last as VarDefinition
		assertEquals("var2", varDef.name)
		assertEquals("val1", varDef.value.computeActualString)
	}
	
	@Test
	def testDefinitionFromVariableCallSimple2() {
		val resourceSet = resourceSetProvider.get
		val varCallDefTarget = parser.parse('''
			target "varCallDefTarget"
			define var1="val1"
			define var2=${var1}
			define var3=${var2}
		''', URI.createURI("tmp:/varCallDefTarget.tpd"), resourceSet)
		
		val varDef = varCallDefTarget.contents.last as VarDefinition
		assertEquals("var3", varDef.name)
		assertEquals("val1", varDef.value.computeActualString)
	}
	
	@Test
	def testDefinitionFromVariableCallSimple3() {
		val resourceSet = resourceSetProvider.get
		val varCallDefTarget = parser.parse('''
			target "varCallDefTarget"
			define var3=${var2}
			define var2=${var1}
			define var1="val1"
		''', URI.createURI("tmp:/varCallDefTarget.tpd"), resourceSet)
		
		val varDef = varCallDefTarget.contents.head as VarDefinition
		assertEquals("var3", varDef.name)
		assertEquals("val1", varDef.value.computeActualString)
	}
	
	@Test
	def testDefinitionFromVariableCallSimple4() {
		val resourceSet = resourceSetProvider.get
		val varCallDefTarget = parser.parse('''
			target "varCallDefTarget"
			define var1="val1"
			define var2=${var1} + "_str2_"
			define var3=${var2} + "_str3_" + ${var1}
		''', URI.createURI("tmp:/varCallDefTarget.tpd"), resourceSet)
		
		val varDef = varCallDefTarget.contents.last as VarDefinition
		assertEquals("var3", varDef.name)
		assertEquals("val1_str2__str3_val1", varDef.value.computeActualString)
	}
	
	@Test
	def testDefinitionFromNestedVariableCall() {
		val resourceSet = resourceSetProvider.get
		val varCallDefTarget = parser.parse('''
			target "varCallDefTarget"
			include "subTpd.tpd"
			define subDirNameRef = ${subDirName} + "/"
			include ${subDirNameRef} + "subInclude.tpd"
		''', URI.createURI("tmp:/varCallDefTarget.tpd"), resourceSet)
		parser.parse('''
			target "subTpd"
			define subDirName="subdir"
		''', URI.createURI("tmp:/subTpd.tpd"), resourceSet)
		parser.parse('''
			target "subInclude"
			include "subSubInclude.tpd"
			define emfVer = "[" + ${emfVerStart} + "," + ${emfVerEnd} + ")"
			define someLocationUri = ${serverAddress} + "modeling/emf/emf/updates/2.9.x/core/R201402030812/"
			location ${someLocationUri} {
				org.eclipse.emf.sdk.feature.group ${emfVer}
			}
		''', URI.createURI("tmp:/subdir/subInclude.tpd"), resourceSet)
		parser.parse('''
			target "subSubInclude"
			define serverAddress = "http://download.eclipse.org/"
			define emfVerStart = "2.9.2"
			define emfVerEnd = "3.0.0"
		''', URI.createURI("tmp:/subdir/subSubInclude.tpd"), resourceSet)
		
		val locationIndex = indexBuilder.getLocationIndex(varCallDefTarget)
		assertEquals(1, locationIndex.size)
		
		val compositeImportURI = varCallDefTarget.includes.last.compositeImportURI
		assertEquals("subdir/", compositeImportURI.stringParts.head.actualString)
		
		val importedTargetPlatforms = indexBuilder.getImportedTargetPlatforms(varCallDefTarget)
		val targetPlatform = importedTargetPlatforms.first
		assertEquals("subInclude", targetPlatform.name)
		val location = targetPlatform.locations.last
		assertEquals("http://download.eclipse.org/modeling/emf/emf/updates/2.9.x/core/R201402030812/", location.uri)
		assertEquals("[2.9.2,3.0.0)", location.ius.head.version)
	}
	
	@Test
	def testDefinitionFromNestedVariableCallOverload1() {
		val resourceSet = resourceSetProvider.get
		val varCallDefTarget = parser.parse('''
			target "varCallDefTarget"
			include "subTpd.tpd"
			define var1 = ${var2}
			define var2b = "value2"
		''', URI.createURI("tmp:/varCallDefTarget.tpd"), resourceSet)
		parser.parse('''
			target "subTpd"
			define var2 = ${var2b}
			define var2b = "value2Sub"
		''', URI.createURI("tmp:/subTpd.tpd"), resourceSet)
		
		val locationIndex = indexBuilder.getLocationIndex(varCallDefTarget)
		assertEquals(0, locationIndex.size)
		
		val varDef = varCallDefTarget.contents.get(1) as VarDefinition
		assertEquals("var1", varDef.name)
		assertEquals("value2", varDef.value.computeActualString)
	}
	
	@Test
	def testDefinitionFromNestedVariableCallOverload2() {
		val resourceSet = resourceSetProvider.get
		val varCallDefTarget = parser.parse('''
			target "varCallDefTarget"
			include "subTpd.tpd"
			define var1 = ${var2}
		''', URI.createURI("tmp:/varCallDefTarget.tpd"), resourceSet)
		parser.parse('''
			target "subTpd"
			include "subSubTpd.tpd"
			define var2 = ${var3}
			define var4 = "sub"
		''', URI.createURI("tmp:/subTpd.tpd"), resourceSet)
		parser.parse('''
			target "subSubTpd"
			define var3 = ${var4}
			define var4 = "subSub"
		''', URI.createURI("tmp:/subSubTpd.tpd"), resourceSet)
		
		val locationIndex = indexBuilder.getLocationIndex(varCallDefTarget)
		assertEquals(0, locationIndex.size)
		
		val varDef = varCallDefTarget.contents.get(1) as VarDefinition
		assertEquals("var1", varDef.name)
		assertEquals("sub", varDef.value.computeActualString)
	}
	
	// 2 variables imported in parent tpd and updated inside "varCallDefTarget"
	@Test
	def testDefinitionFromNestedVariableCallOverload3() {
		val resourceSet = resourceSetProvider.get
		val varCallDefTarget = parser.parse('''
			target "varCallDefTarget"
			include "subTpd.tpd"
			define var1 = ${var2}
			define var4 = "value4"
		''', URI.createURI("tmp:/varCallDefTarget.tpd"), resourceSet)
		parser.parse('''
			target "subTpd"
			define var2 = ${var3}
			define var3 = ${var4}
			define var4 = "value4Sub"
		''', URI.createURI("tmp:/subTpd.tpd"), resourceSet)
		
		val locationIndex = indexBuilder.getLocationIndex(varCallDefTarget)
		assertEquals(0, locationIndex.size)
		
		val varDef = varCallDefTarget.contents.get(1) as VarDefinition
		assertEquals("var1", varDef.name)
		assertEquals("value4", varDef.value.computeActualString)
	}
	
	//var1 is composed of many imported variables which have to be updated inside "varCallDefTarget"
	@Test
	def testDefinitionFromNestedVariableCallOverload4() {
		val resourceSet = resourceSetProvider.get
		val varCallDefTarget = parser.parse('''
			target "varCallDefTarget"
			include "subTpd.tpd"
			define var1 = ${var2} + "_" + ${var4} + "_" + ${var5}
			define var4 = "value4"
			define var6 = "value6"
		''', URI.createURI("tmp:/varCallDefTarget.tpd"), resourceSet)
		parser.parse('''
			target "subTpd"
			define var2 = ${var3}
			define var3 = ${var4}
			define var4 = "value4Sub"
			define var5 = ${var6}
			define var6 = "value6Sub"
		''', URI.createURI("tmp:/subTpd.tpd"), resourceSet)
		
		val locationIndex = indexBuilder.getLocationIndex(varCallDefTarget)
		assertEquals(0, locationIndex.size)
		
		val varDef = varCallDefTarget.contents.get(1) as VarDefinition
		assertEquals("var1", varDef.name)
		assertEquals("value4_value4_value6", varDef.value.computeActualString)
	}
}
