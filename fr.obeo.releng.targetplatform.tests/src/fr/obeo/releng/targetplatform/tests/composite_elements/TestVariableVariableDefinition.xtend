package fr.obeo.releng.targetplatform.tests.composite_elements

import com.google.inject.Inject
import com.google.inject.Provider
import fr.obeo.releng.targetplatform.TargetPlatform
import fr.obeo.releng.targetplatform.TargetPlatformInjectorProvider
import fr.obeo.releng.targetplatform.VarDefinition
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
}
