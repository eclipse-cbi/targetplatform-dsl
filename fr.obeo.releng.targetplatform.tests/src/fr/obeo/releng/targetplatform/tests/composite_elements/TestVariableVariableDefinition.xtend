package fr.obeo.releng.targetplatform.tests.composite_elements

import com.google.inject.Inject
import com.google.inject.Provider
import fr.obeo.releng.targetplatform.TargetPlatform
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
		
		val varDef = varCallDefTarget.varDefinition.last
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
		
		val varDef = varCallDefTarget.varDefinition.last
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
		
		val varDef = varCallDefTarget.varDefinition.head
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
		
		val varDef = varCallDefTarget.varDefinition.last
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
		
		val varDef = varCallDefTarget.varDefinition.head
		assertEquals("var1", varDef.name)
		assertEquals("value2", varDef.value.computeActualString)
	}
	
	@Test
	def testDefinitionFromNestedVariableCallOverload1b() {
		val resourceSet = resourceSetProvider.get
		val varCallDefTarget = parser.parse('''
			target "varCallDefTarget"
			include "subTpd.tpd"
			define var1 = ${var2}
			define var2 = ${var2b}
			define var2b = "value2"
		''', URI.createURI("tmp:/varCallDefTarget.tpd"), resourceSet)
		parser.parse('''
			target "subTpd"
			define var2 = ${var2b}
			define var2b = "value2Sub"
		''', URI.createURI("tmp:/subTpd.tpd"), resourceSet)
		
		val locationIndex = indexBuilder.getLocationIndex(varCallDefTarget)
		assertEquals(0, locationIndex.size)
		
		val varDef = varCallDefTarget.varDefinition.head
		assertEquals("var1", varDef.name)
		assertEquals("value2", varDef.value.computeActualString)
	}
	
	@Test
	def testDefinitionFromNestedVariableCallOverload1c() {
		val resourceSet = resourceSetProvider.get
		val varCallDefTarget = parser.parse('''
			target "varCallDefTarget"
			include "subTpd.tpd"
			define var1 = ${var2}
			define var2 = ${var2b} + "_suffix"
		''', URI.createURI("tmp:/varCallDefTarget.tpd"), resourceSet)
		parser.parse('''
			target "subTpd"
			define var2 = ${var2b}
			define var2b = "value2Sub"
		''', URI.createURI("tmp:/subTpd.tpd"), resourceSet)
		
		val locationIndex = indexBuilder.getLocationIndex(varCallDefTarget)
		assertEquals(0, locationIndex.size)
		
		val varDef = varCallDefTarget.varDefinition.head
		assertEquals("var1", varDef.name)
		assertEquals("value2Sub_suffix", varDef.value.computeActualString)
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
		
		val varDef = varCallDefTarget.varDefinition.head
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
		
		val varDef = varCallDefTarget.varDefinition.head
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
		
		val varDef = varCallDefTarget.varDefinition.head
		assertEquals("var1", varDef.name)
		assertEquals("value4_value4_value6", varDef.value.computeActualString)
	}
	
	@Test
	def testSameVariableImportedFrom2SubTpd1() {
		val resourceSet = resourceSetProvider.get
		val mainTpd = parser.parse('''
			target "mainTpd"
			include "subTpd1.tpd"
			include "subTpd2.tpd"
			define var = ${twiceInheritedVar}
		''', URI.createURI("tmp:/mainTpd.tpd"), resourceSet)
		parser.parse('''
			target "subTpd1"
			define twiceInheritedVar = "value"
		''', URI.createURI("tmp:/subTpd1.tpd"), resourceSet)
		parser.parse('''
			target "subTpd2"
			define twiceInheritedVar = "value"
		''', URI.createURI("tmp:/subTpd2.tpd"), resourceSet)
		
		val locationIndex = indexBuilder.getLocationIndex(mainTpd)
		assertEquals(0, locationIndex.size)
		
		val varDef = mainTpd.varDefinition.get(0)
		assertEquals("var", varDef.name)
		assertEquals("value", varDef.value.computeActualString)
		assertFalse(varDef.imported)
		
		val varDef2 = mainTpd.varDefinition.get(1)
		assertEquals("twiceInheritedVar", varDef2.name)
		assertEquals("value", varDef2.value.computeActualString)
		assertTrue(varDef2.imported)
		assertFalse(varDef.diamondInherit)
		
		assertEquals(2, mainTpd.varDefinition.size)
	}
	
	@Test
	def testSameVariableImportedFrom2SubTpd2() {
		val resourceSet = resourceSetProvider.get
		val mainTpd = parser.parse('''
			target "mainTpd"
			include "subTpd1.tpd"
			include "subTpd2.tpd"
			define var = ${twiceInheritedVar}
		''', URI.createURI("tmp:/mainTpd.tpd"), resourceSet)
		parser.parse('''
			target "subTpd1"
			define twiceInheritedVar = "value1"
		''', URI.createURI("tmp:/subTpd1.tpd"), resourceSet)
		parser.parse('''
			target "subTpd2"
			define twiceInheritedVar = "value2"
		''', URI.createURI("tmp:/subTpd2.tpd"), resourceSet)
		
		val locationIndex = indexBuilder.getLocationIndex(mainTpd)
		assertEquals(0, locationIndex.size)
		
		val varDef = mainTpd.varDefinition.get(0)
		assertEquals("var", varDef.name)
		val varDefVal = varDef.value.computeActualString
		assertTrue(varDefVal.equals("value1") || varDefVal.equals("value2")) // Do not expect specially value1 or value2
		assertFalse(varDef.imported)
		
		val varDef2 = mainTpd.varDefinition.get(1)
		assertEquals("twiceInheritedVar", varDef2.name)
		val varDefVal2 = varDef2.value.computeActualString
		assertTrue(varDefVal2.equals("value1") || varDefVal2.equals("value2")) // Do not expect specially value1 or value2
		assertTrue(varDef2.imported)
		assertFalse(varDef.diamondInherit)
		assertEquals(2, varDef2.importedValues.size)
		assertTrue(varDef2.importedValues.contains("value1"))
		assertTrue(varDef2.importedValues.contains("value2"))
		
		assertEquals(2, mainTpd.varDefinition.size)
	}
	
	@Test
	def testSameVariableImportedFrom3SubTpd1() {
		val resourceSet = resourceSetProvider.get
		val mainTpd = parser.parse('''
			target "mainTpd"
			include "subTpd1.tpd"
			include "subTpd2.tpd"
			include "subTpd3.tpd"
			define var = ${twiceInheritedVar}
		''', URI.createURI("tmp:/mainTpd.tpd"), resourceSet)
		parser.parse('''
			target "subTpd1"
			define twiceInheritedVar = "value"
		''', URI.createURI("tmp:/subTpd1.tpd"), resourceSet)
		parser.parse('''
			target "subTpd2"
			define twiceInheritedVar = "value"
		''', URI.createURI("tmp:/subTpd2.tpd"), resourceSet)
		parser.parse('''
			target "subTpd3"
			define twiceInheritedVar = "value"
		''', URI.createURI("tmp:/subTpd3.tpd"), resourceSet)
		
		val locationIndex = indexBuilder.getLocationIndex(mainTpd)
		assertEquals(0, locationIndex.size)
		
		val varDef = mainTpd.varDefinition.get(0)
		assertEquals("var", varDef.name)
		assertEquals("value", varDef.value.computeActualString)
		assertFalse(varDef.imported)
		
		val varDef2 = mainTpd.varDefinition.get(1)
		assertEquals("twiceInheritedVar", varDef2.name)
		assertEquals("value", varDef2.value.computeActualString)
		assertTrue(varDef2.imported)
		assertFalse(varDef.diamondInherit)
		assertEquals(3, varDef2.importedValues.size)
		assertEquals("value", varDef2.importedValues.get(0))
		assertEquals("value", varDef2.importedValues.get(1))
		assertEquals("value", varDef2.importedValues.get(2))
		
		assertEquals(2, mainTpd.varDefinition.size)
	}
	
	@Test
	def testSameVariableImportedFrom3SubTpdAndSubSub() {
		val resourceSet = resourceSetProvider.get
		val mainTpd = parser.parse('''
			target "mainTpd"
			include "subTpd1.tpd"
			include "subTpd2.tpd"
			include "subTpd3.tpd"
			define var = ${twiceInheritedVar}
		''', URI.createURI("tmp:/mainTpd.tpd"), resourceSet)
		parser.parse('''
			target "subTpd1"
			define twiceInheritedVar = "value"
		''', URI.createURI("tmp:/subTpd1.tpd"), resourceSet)
		parser.parse('''
			target "subTpd2"
			define twiceInheritedVar = "value"
		''', URI.createURI("tmp:/subTpd2.tpd"), resourceSet)
		parser.parse('''
			target "subTpd3"
			include "subSubTpd.tpd"
		''', URI.createURI("tmp:/subTpd3.tpd"), resourceSet)
		parser.parse('''
			target "subSubTpd"
			define twiceInheritedVar = "value"
		''', URI.createURI("tmp:/subSubTpd.tpd"), resourceSet)
		
		val locationIndex = indexBuilder.getLocationIndex(mainTpd)
		assertEquals(0, locationIndex.size)
		
		val varDef = mainTpd.varDefinition.get(0)
		assertEquals("var", varDef.name)
		assertEquals("value", varDef.value.computeActualString)
		assertFalse(varDef.imported)
		
		val varDef2 = mainTpd.varDefinition.get(1)
		assertEquals("twiceInheritedVar", varDef2.name)
		assertEquals("value", varDef2.value.computeActualString)
		assertTrue(varDef2.imported)
		assertFalse(varDef.diamondInherit)
		assertEquals(3, varDef2.importedValues.size)
		assertEquals("value", varDef2.importedValues.get(0))
		assertEquals("value", varDef2.importedValues.get(1))
		assertEquals("value", varDef2.importedValues.get(2))
		
		assertEquals(2, mainTpd.varDefinition.size)
	}
	
	@Test
	def testSameVariableImportedDiamond() {
		val resourceSet = resourceSetProvider.get
		val mainTpd = parser.parse('''
			target "mainTpd"
			include "subTpd1.tpd"
			include "subTpd2.tpd"
			define var = ${twiceInheritedVar}
		''', URI.createURI("tmp:/mainTpd.tpd"), resourceSet)
		parser.parse('''
			target "subTpd1"
			include "subSubTpd.tpd"
		''', URI.createURI("tmp:/subTpd1.tpd"), resourceSet)
		parser.parse('''
			target "subTpd2"
			include "subSubTpd.tpd"
		''', URI.createURI("tmp:/subTpd2.tpd"), resourceSet)
		parser.parse('''
			target "subSubTpd"
			define twiceInheritedVar = "value"
		''', URI.createURI("tmp:/subSubTpd.tpd"), resourceSet)
		
		val locationIndex = indexBuilder.getLocationIndex(mainTpd)
		assertEquals(0, locationIndex.size)
		
		val varDef = mainTpd.varDefinition.get(0)
		assertEquals("var", varDef.name)
		assertEquals("value", varDef.value.computeActualString)
		assertFalse(varDef.imported)
		assertFalse(varDef.diamondInherit)
		
		val varDef2 = mainTpd.varDefinition.get(1)
		assertEquals("twiceInheritedVar", varDef2.name)
		assertEquals("value", varDef2.value.computeActualString)
		assertEquals(1, varDef2.importedValues.size)
		assertTrue(varDef2.imported)
		assertTrue(varDef2.diamondInherit)
		
		assertEquals(2, mainTpd.varDefinition.size)
	}
	
	@Test
	def testSameVariableImportedDiamondOverride() {
		val resourceSet = resourceSetProvider.get
		val mainTpd = parser.parse('''
			target "mainTpd"
			include "subTpd1.tpd"
			include "subTpd2.tpd"
			define var = ${twiceInheritedVar}
		''', URI.createURI("tmp:/mainTpd.tpd"), resourceSet)
		parser.parse('''
			target "subTpd1"
			include "subSubTpd.tpd"
		''', URI.createURI("tmp:/subTpd1.tpd"), resourceSet)
		parser.parse('''
			target "subTpd2"
			include "subSubTpd.tpd"
			define twiceInheritedVar = "valueSub2" //Override => error in mainTpd
		''', URI.createURI("tmp:/subTpd2.tpd"), resourceSet)
		parser.parse('''
			target "subSubTpd"
			define twiceInheritedVar = "value"
		''', URI.createURI("tmp:/subSubTpd.tpd"), resourceSet)
		
		val locationIndex = indexBuilder.getLocationIndex(mainTpd)
		assertEquals(0, locationIndex.size)
		
		val varDef = mainTpd.varDefinition.get(0)
		assertEquals("var", varDef.name)
		val varDefVal = varDef.value.computeActualString
		assertTrue("value".equals(varDefVal) || "valueSub2".equals(varDefVal))
		assertFalse(varDef.imported)
		assertFalse(varDef.diamondInherit)
		
		val varDef2 = mainTpd.varDefinition.get(1)
		assertEquals("twiceInheritedVar", varDef2.name)
		val varDef2Val = varDef2.value.computeActualString
		assertTrue(varDef2Val.equals("value") || varDef2Val.equals("valueSub2")) // Do not expect specially value or valueSub2
		assertEquals(2, varDef2.importedValues.size)
		assertTrue(varDef2.importedValues.contains("value"))
		assertTrue(varDef2.importedValues.contains("valueSub2"))
		assertTrue(varDef2.imported)
		assertFalse(varDef2.diamondInherit)
		
		assertEquals(2, mainTpd.varDefinition.size)
	}
	
	@Test
	def testSameVariableImportedDiamondOverride2() {
		val resourceSet = resourceSetProvider.get
		val mainTpd = parser.parse('''
			target "mainTpd"
			include "subTpd1.tpd"
			include "subTpd2.tpd"
			define var = ${twiceInheritedVar}
		''', URI.createURI("tmp:/mainTpd.tpd"), resourceSet)
		parser.parse('''
			target "subTpd1"
			include "subSubTpd.tpd"
		''', URI.createURI("tmp:/subTpd1.tpd"), resourceSet)
		parser.parse('''
			target "subTpd2"
			include "subSubTpd.tpd"
			define twiceInheritedVar = "value"//Override => warning in mainTpd
		''', URI.createURI("tmp:/subTpd2.tpd"), resourceSet)
		parser.parse('''
			target "subSubTpd"
			define twiceInheritedVar = "value"
		''', URI.createURI("tmp:/subSubTpd.tpd"), resourceSet)
		
		val locationIndex = indexBuilder.getLocationIndex(mainTpd)
		assertEquals(0, locationIndex.size)
		
		val varDef = mainTpd.varDefinition.get(0)
		assertEquals("var", varDef.name)
		assertEquals("value", varDef.value.computeActualString)
		assertFalse(varDef.imported)
		assertFalse(varDef.diamondInherit)
		
		val varDef2 = mainTpd.varDefinition.get(1)
		assertEquals("twiceInheritedVar", varDef2.name)
		assertEquals("value", varDef2.value.computeActualString)
		assertEquals(2, varDef2.importedValues.size)
		assertEquals("value", varDef2.importedValues.get(0))
		assertEquals("value", varDef2.importedValues.get(1))
		assertTrue(varDef2.imported)
		assertFalse(varDef2.diamondInherit)
		
		assertEquals(2, mainTpd.varDefinition.size)
	}
	
	@Test
	def testSameVariableImportedDiamond3ways() {
		val resourceSet = resourceSetProvider.get
		val mainTpd = parser.parse('''
			target "mainTpd"
			include "subTpd1.tpd"
			include "subTpd2.tpd"
			include "subTpd3.tpd"
			define var = ${twiceInheritedVar}
		''', URI.createURI("tmp:/mainTpd.tpd"), resourceSet)
		parser.parse('''
			target "subTpd1"
			include "subSubTpd.tpd"
		''', URI.createURI("tmp:/subTpd1.tpd"), resourceSet)
		parser.parse('''
			target "subTpd2"
			include "subSubTpd.tpd"
		''', URI.createURI("tmp:/subTpd2.tpd"), resourceSet)
		parser.parse('''
			target "subTpd3"
			include "subSubTpd.tpd"
		''', URI.createURI("tmp:/subTpd3.tpd"), resourceSet)
		parser.parse('''
			target "subSubTpd"
			define twiceInheritedVar = "value"
		''', URI.createURI("tmp:/subSubTpd.tpd"), resourceSet)
		
		val locationIndex = indexBuilder.getLocationIndex(mainTpd)
		assertEquals(0, locationIndex.size)
		
		val varDef = mainTpd.varDefinition.get(0)
		assertEquals("var", varDef.name)
		assertEquals("value", varDef.value.computeActualString)
		assertFalse(varDef.imported)
		assertFalse(varDef.diamondInherit)
		
		val varDef2 = mainTpd.varDefinition.get(1)
		assertEquals("twiceInheritedVar", varDef2.name)
		assertEquals("value", varDef2.value.computeActualString)
		assertEquals(1, varDef2.importedValues.size)
		assertTrue(varDef2.imported)
		assertTrue(varDef2.diamondInherit)
		
		assertEquals(2, mainTpd.varDefinition.size)
	}
	
	@Test
	def testSameVariableImportedDiamond2waysWithSubSub() {
		val resourceSet = resourceSetProvider.get
		val mainTpd = parser.parse('''
			target "mainTpd"
			include "subTpd1.tpd"
			include "subTpd2.tpd"
			define var = ${twiceInheritedVar}
		''', URI.createURI("tmp:/mainTpd.tpd"), resourceSet)
		parser.parse('''
			target "subTpd1"
			include "subSubTpd.tpd"
		''', URI.createURI("tmp:/subTpd1.tpd"), resourceSet)
		parser.parse('''
			target "subTpd2"
			include "subSubTpd2.tpd"
		''', URI.createURI("tmp:/subTpd2.tpd"), resourceSet)
		parser.parse('''
			target "subSubTpd2"
			include "subSubTpd.tpd"
		''', URI.createURI("tmp:/subSubTpd2.tpd"), resourceSet)
		parser.parse('''
			target "subSubTpd"
			define twiceInheritedVar = "value"
		''', URI.createURI("tmp:/subSubTpd.tpd"), resourceSet)
		
		val locationIndex = indexBuilder.getLocationIndex(mainTpd)
		assertEquals(0, locationIndex.size)
		
		val varDef = mainTpd.varDefinition.get(0)
		assertEquals("var", varDef.name)
		assertEquals("value", varDef.value.computeActualString)
		assertFalse(varDef.imported)
		assertFalse(varDef.diamondInherit)
		
		val varDef2 = mainTpd.varDefinition.get(1)
		assertEquals("twiceInheritedVar", varDef2.name)
		assertEquals("value", varDef2.value.computeActualString)
		assertEquals(1, varDef2.importedValues.size)
		assertTrue(varDef2.imported)
		assertTrue(varDef2.diamondInherit)
		
		assertEquals(2, mainTpd.varDefinition.size)
	}
	
	@Test
	/** see {@link CompositeElementResolver#updateVarCallFromImportedVar} */
	def testExtractVarCallFromOnlyImportedVariable() {
		val resourceSet = resourceSetProvider.get
		val mainTpd = parser.parse('''
			target "mainTpd"
			include "subTpd1.tpd"
			define localVar = "myVar"
			define overrideVar = "overrideVarVal"
			define var1 = ${impVar}
			define var2 = ${impVar1} + ${impVar2}
			define var3 = ${localVar}
			define var4 = ${overrideVar}
			define var5 = ${undefinedVar}
		''', URI.createURI("tmp:/mainTpd.tpd"), resourceSet)
		parser.parse('''
			target "subTpd1"
			include "subSubTpd.tpd"
			define impVar = "value"
			define impVar1 = "value1"
			define overrideVar = "overrideVarValOrig"
		''', URI.createURI("tmp:/subTpd1.tpd"), resourceSet)
		parser.parse('''
			target "subSubTpd"
			define impVar2 = "value2"
		''', URI.createURI("tmp:/subSubTpd.tpd"), resourceSet)
		
		val locationIndex = indexBuilder.getLocationIndex(mainTpd)
		assertEquals(0, locationIndex.size)
		
		assertEquals(3, mainTpd.varCallFromOnlyImportedVariable.split(", ").size)
		
		assertTrue(mainTpd.varCallFromOnlyImportedVariable.contains("impVar"))
		assertTrue(mainTpd.varCallFromOnlyImportedVariable.contains("impVar1"))
		assertTrue(mainTpd.varCallFromOnlyImportedVariable.contains("impVar2"))
	}
	
	@Test
	/** see {@link CompositeElementResolver#updateVarCallFromImportedVar} */
	def testExtractVarCallFromOnlyImportedVariable_WithoutImport() {
		val resourceSet = resourceSetProvider.get
		val mainTpd = parser.parse('''
			target "mainTpd"
			define localVar = "myVar"
			define var1 = ${impVar}
			define var2 = ${localVar}
		''', URI.createURI("tmp:/mainTpd.tpd"), resourceSet)
		
		val locationIndex = indexBuilder.getLocationIndex(mainTpd)
		assertEquals(0, locationIndex.size)
		
		assertEquals("", mainTpd.varCallFromOnlyImportedVariable)
	}
}
