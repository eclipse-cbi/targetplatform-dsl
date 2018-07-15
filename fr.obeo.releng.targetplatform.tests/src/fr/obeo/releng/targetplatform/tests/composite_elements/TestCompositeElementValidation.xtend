package fr.obeo.releng.targetplatform.tests.composite_elements

import com.google.inject.Inject
import com.google.inject.Provider
import com.google.inject.name.Named
import fr.obeo.releng.targetplatform.IncludeDeclaration
import fr.obeo.releng.targetplatform.TargetPlatform
import fr.obeo.releng.targetplatform.VarDefinition
import fr.obeo.releng.targetplatform.tests.util.CustomTargetPlatformInjectorProviderTargetReloader
import fr.obeo.releng.targetplatform.util.ImportVariableManager
import fr.obeo.releng.targetplatform.util.LocationIndexBuilder
import fr.obeo.releng.targetplatform.validation.TargetPlatformValidator
import org.eclipse.emf.common.util.Diagnostic
import org.eclipse.emf.common.util.URI
import org.eclipse.xtext.Constants
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.util.ParseHelper
import org.eclipse.xtext.junit4.validation.ValidatorTester
import org.eclipse.xtext.resource.XtextResourceSet
import org.eclipse.xtext.validation.AbstractValidationDiagnostic
import org.eclipse.xtext.validation.EValidatorRegistrar
import org.eclipse.xtext.validation.FeatureBasedDiagnostic
import org.junit.Test
import org.junit.runner.RunWith

import static org.junit.Assert.*

@InjectWith(typeof(CustomTargetPlatformInjectorProviderTargetReloader))
@RunWith(typeof(XtextRunner))
class TestCompositeElementValidation {
	
	@Inject
	ParseHelper<TargetPlatform> parser
	
	@Inject
	TargetPlatformValidator validator
	
	@Inject
	EValidatorRegistrar validatorRegistrar
	
	@Inject
	Provider<XtextResourceSet> resourceSetProvider
	
	@Inject
	LocationIndexBuilder indexBuilder
	
	@Inject
	ImportVariableManager importVariableManager;
	
	@Inject
	@Named(Constants::LANGUAGE_NAME)
	String languageName
	
	@Test
	def checkImportCycleDueToVariableDefinition() {
		val tester = new ValidatorTester(validator, validatorRegistrar, languageName)
		val resourceSet = resourceSetProvider.get;
		val compositeIncludeTarget = parser.parse('''
			target "compositeIncludeTarget"
			include "subTpd.tpd"
			include ${subDirName} + "/" + "subInclude.tpd"
		''', URI.createURI("tmp:/compositeIncludeTarget.tpd"), resourceSet)
		parser.parse('''
			target "subTpd"
			include "subsubTpd.tpd"
			define subDirName="subdir"
		''', URI.createURI("tmp:/subTpd.tpd"), resourceSet);
		val subIncludeCircular = parser.parse('''
			target "subInclude"
			include "../compositeIncludeTarget.tpd"
		''', URI.createURI("tmp:/subdir/subInclude.tpd"), resourceSet)
		
		assertTrue(compositeIncludeTarget.eResource.errors.empty)
		tester.validator.checkImportCycle(compositeIncludeTarget)
		var diagnotics = tester.diagnose.allDiagnostics.filter(typeof(AbstractValidationDiagnostic)).toList
		assertEquals(1, diagnotics.size)
		assertTrue(diagnotics.forall[sourceEObject instanceof IncludeDeclaration])
		diagnotics.forEach[
			assertEquals(TargetPlatformValidator::CHECK__INCLUDE_CYCLE, issueCode)
			assertEquals("subdir/subInclude.tpd", (it.sourceEObject as IncludeDeclaration).importURI)
		]
		
		assertTrue(subIncludeCircular.eResource.errors.empty)
		tester.validator.checkImportCycle(subIncludeCircular)
		diagnotics = tester.diagnose.allDiagnostics.filter(typeof(AbstractValidationDiagnostic)).toList
		assertEquals(1, diagnotics.size)
		assertTrue(diagnotics.forall[sourceEObject instanceof IncludeDeclaration])
		diagnotics.forEach[
			assertEquals(TargetPlatformValidator::CHECK__INCLUDE_CYCLE, issueCode)
			assertEquals("../compositeIncludeTarget.tpd", (it.sourceEObject as IncludeDeclaration).importURI)
		]
	}
	
	@Test
	def checkImportCycleDueToVariableDefinitionOverride() {
		val String[] args = #["compositeIncludeTarget.tpd", "urlCyclicInclude=../compositeIncludeTarget.tpd"]
		
		importVariableManager.processCommandLineArguments(args)
		
		val tester = new ValidatorTester(validator, validatorRegistrar, languageName)
		val resourceSet = resourceSetProvider.get;
		val compositeIncludeTarget = parser.parse('''
			target "compositeIncludeTarget"
			include "subTpd.tpd"
			include ${subDirName} + "/" + "subInclude.tpd"
		''', URI.createURI("tmp:/compositeIncludeTarget.tpd"), resourceSet)
		parser.parse('''
			target "subTpd"
			include "subsubTpd.tpd"
			define subDirName="subdir"
		''', URI.createURI("tmp:/subTpd.tpd"), resourceSet);
		val subIncludeCircular = parser.parse('''
			target "subInclude"
			define urlCyclicInclude = "notACycle.tpd"
			include ${urlCyclicInclude}
		''', URI.createURI("tmp:/subdir/subInclude.tpd"), resourceSet)
		
		assertTrue(compositeIncludeTarget.eResource.errors.empty)
		tester.validator.checkImportCycle(compositeIncludeTarget)
		var diagnotics = tester.diagnose.allDiagnostics.filter(typeof(AbstractValidationDiagnostic)).toList
		assertEquals(1, diagnotics.size)
		assertTrue(diagnotics.forall[sourceEObject instanceof IncludeDeclaration])
		diagnotics.forEach[
			assertEquals(TargetPlatformValidator::CHECK__INCLUDE_CYCLE, issueCode)
			assertEquals("subdir/subInclude.tpd", (it.sourceEObject as IncludeDeclaration).importURI)
		]
		
		assertTrue(subIncludeCircular.eResource.errors.empty)
		tester.validator.checkImportCycle(subIncludeCircular)
		diagnotics = tester.diagnose.allDiagnostics.filter(typeof(AbstractValidationDiagnostic)).toList
		assertEquals(1, diagnotics.size)
		assertTrue(diagnotics.forall[sourceEObject instanceof IncludeDeclaration])
		diagnotics.forEach[
			assertEquals(TargetPlatformValidator::CHECK__INCLUDE_CYCLE, issueCode)
			assertEquals("../compositeIncludeTarget.tpd", (it.sourceEObject as IncludeDeclaration).importURI)
		]
		
		importVariableManager.clear
	}
	
	@Test
	def checkVariableDefinitionCycle1() {
		val tester = new ValidatorTester(validator, validatorRegistrar, languageName)
		val resourceSet = resourceSetProvider.get;
		val varDefCycle = parser.parse('''
			target "varDefCycle"
			define var1 = ${var2}
			define var2 = ${var1}
		''', URI.createURI("tmp:/varDefCycle.tpd"), resourceSet)
		
		assertTrue(varDefCycle.eResource.errors.empty)
		tester.validator.checkVarDefinitionCycle(varDefCycle)
		
		var diagnotics = tester.diagnose.allDiagnostics.filter(typeof(AbstractValidationDiagnostic)).toList
		assertEquals(2, diagnotics.size)
		assertTrue(diagnotics.forall[sourceEObject instanceof VarDefinition])
		
		val diag1 = diagnotics.get(0)
		assertEquals(TargetPlatformValidator::CHECK__VARIABLE_CYCLE, diag1.issueCode)
		assertEquals("var1", (diag1.sourceEObject as VarDefinition).name)
		assertEquals("Cycle detected in the defined variables: var1 -> var2 -> var1", diag1.message)
		
		val diag2 = diagnotics.get(1)
		assertEquals(TargetPlatformValidator::CHECK__VARIABLE_CYCLE, diag2.issueCode)
		assertEquals("var2", (diag2.sourceEObject as VarDefinition).name)
		assertEquals("Cycle detected in the defined variables: var2 -> var1 -> var2", diag2.message)
	}
	
	@Test
	def checkVariableDefinitionCycle2() {
		val tester = new ValidatorTester(validator, validatorRegistrar, languageName)
		val resourceSet = resourceSetProvider.get;
		val varDefCycle = parser.parse('''
			target "varDefCycle"
			define var1 = ${var2}
			define var2 = ${var3}
			define var3 = ${var1}
			include ${var1}
			location ${var2} {
				xyz ${var3}
			}
		''', URI.createURI("tmp:/varDefCycle.tpd"), resourceSet)
		
		assertTrue(varDefCycle.eResource.errors.empty)
		tester.validator.checkVarDefinitionCycle(varDefCycle)
		
		var diagnotics = tester.diagnose.allDiagnostics.filter(typeof(AbstractValidationDiagnostic)).toList
		assertEquals(3, diagnotics.size)
		assertTrue(diagnotics.forall[sourceEObject instanceof VarDefinition])
		
		val diag1 = diagnotics.get(0)
		assertEquals(TargetPlatformValidator::CHECK__VARIABLE_CYCLE, diag1.issueCode)
		assertEquals("var1", (diag1.sourceEObject as VarDefinition).name)
		assertEquals("Cycle detected in the defined variables: var1 -> var2 -> var3 -> var1", diag1.message)
		
		val diag2 = diagnotics.get(1)
		assertEquals(TargetPlatformValidator::CHECK__VARIABLE_CYCLE, diag2.issueCode)
		assertEquals("var2", (diag2.sourceEObject as VarDefinition).name)
		assertEquals("Cycle detected in the defined variables: var2 -> var3 -> var1 -> var2", diag2.message)
		
		val diag3 = diagnotics.get(2)
		assertEquals(TargetPlatformValidator::CHECK__VARIABLE_CYCLE, diag3.issueCode)
		assertEquals("var3", (diag3.sourceEObject as VarDefinition).name)
		assertEquals("Cycle detected in the defined variables: var3 -> var1 -> var2 -> var3", diag3.message)
	}
	
	@Test
	def checkVariableDefinitionCycle3() { // with composite elements
		val tester = new ValidatorTester(validator, validatorRegistrar, languageName)
		val resourceSet = resourceSetProvider.get;
		val varDefCycle = parser.parse('''
			target "varDefCycle"
			define var1 = ${var2} + "abc" + ${var3}
			define var2 = "aaa" + ${var3}
			define var3 = ${var2} + ${var1}
		''', URI.createURI("tmp:/varDefCycle.tpd"), resourceSet)
		
		assertTrue(varDefCycle.eResource.errors.empty)
		tester.validator.checkVarDefinitionCycle(varDefCycle)
		
		var diagnotics = tester.diagnose.allDiagnostics.filter(typeof(AbstractValidationDiagnostic)).toList
		assertEquals(3, diagnotics.size)
		assertTrue(diagnotics.forall[sourceEObject instanceof VarDefinition])
		
		val diag1 = diagnotics.get(0)
		assertEquals(TargetPlatformValidator::CHECK__VARIABLE_CYCLE, diag1.issueCode)
		assertEquals("var1", (diag1.sourceEObject as VarDefinition).name)
		assertEquals("Cycle detected in the defined variables: var1 -> var2 -> var3 -> var2", diag1.message)
		
		val diag2 = diagnotics.get(1)
		assertEquals(TargetPlatformValidator::CHECK__VARIABLE_CYCLE, diag2.issueCode)
		assertEquals("var2", (diag2.sourceEObject as VarDefinition).name)
		assertEquals("Cycle detected in the defined variables: var2 -> var3 -> var2", diag2.message)
		
		val diag3 = diagnotics.get(2)
		assertEquals(TargetPlatformValidator::CHECK__VARIABLE_CYCLE, diag3.issueCode)
		assertEquals("var3", (diag3.sourceEObject as VarDefinition).name)
		assertEquals("Cycle detected in the defined variables: var3 -> var2 -> var3", diag3.message)
	}
	
	@Test
	def checkVariableDefinitionCycle4() {
		val tester = new ValidatorTester(validator, validatorRegistrar, languageName)
		val resourceSet = resourceSetProvider.get;
		val varDefCycle = parser.parse('''
			target "varDefCycle"
			define var1 = ${var1}
		''', URI.createURI("tmp:/varDefCycle.tpd"), resourceSet)
		
		assertTrue(varDefCycle.eResource.errors.empty)
		tester.validator.checkVarDefinitionCycle(varDefCycle)
		
		var diagnotics = tester.diagnose.allDiagnostics.filter(typeof(AbstractValidationDiagnostic)).toList
		assertEquals(1, diagnotics.size)
		assertTrue(diagnotics.forall[sourceEObject instanceof VarDefinition])
		
		val diag1 = diagnotics.get(0)
		assertEquals(TargetPlatformValidator::CHECK__VARIABLE_CYCLE, diag1.issueCode)
		assertEquals("var1", (diag1.sourceEObject as VarDefinition).name)
		assertEquals("Cycle detected in the defined variables: var1 -> var1", diag1.message)
	}
	
	@Test
	def checkVariableDefinitionCycleInterleave() {
		val tester = new ValidatorTester(validator, validatorRegistrar, languageName)
		val resourceSet = resourceSetProvider.get;
		val varDefCycle = parser.parse('''
			target "varDefCycle"
			define var1 = ${var2}
			define var2 = ${var3} + ${var4}
			define var3 = ${var1}
			define var4 = ${var5}
			define var5 = ${var2}
		''', URI.createURI("tmp:/varDefCycle.tpd"), resourceSet)
		
		assertTrue(varDefCycle.eResource.errors.empty)
		tester.validator.checkVarDefinitionCycle(varDefCycle)
		
		var diagnotics = tester.diagnose.allDiagnostics.filter(typeof(AbstractValidationDiagnostic)).toList
		assertEquals(5, diagnotics.size)
		assertTrue(diagnotics.forall[sourceEObject instanceof VarDefinition])
		
		val diag1 = diagnotics.get(0)
		assertEquals(TargetPlatformValidator::CHECK__VARIABLE_CYCLE, diag1.issueCode)
		assertEquals("var1", (diag1.sourceEObject as VarDefinition).name)
		assertEquals("Cycle detected in the defined variables: var1 -> var2 -> var3 -> var1", diag1.message)
		
		val diag2 = diagnotics.get(1)
		assertEquals(TargetPlatformValidator::CHECK__VARIABLE_CYCLE, diag2.issueCode)
		assertEquals("var2", (diag2.sourceEObject as VarDefinition).name)
		assertEquals("Cycle detected in the defined variables: var2 -> var3 -> var1 -> var2", diag2.message)
		
		val diag3 = diagnotics.get(2)
		assertEquals(TargetPlatformValidator::CHECK__VARIABLE_CYCLE, diag3.issueCode)
		assertEquals("var3", (diag3.sourceEObject as VarDefinition).name)
		assertEquals("Cycle detected in the defined variables: var3 -> var1 -> var2 -> var3", diag3.message)
		
		val diag4 = diagnotics.get(3)
		assertEquals(TargetPlatformValidator::CHECK__VARIABLE_CYCLE, diag4.issueCode)
		assertEquals("var4", (diag4.sourceEObject as VarDefinition).name)
		assertEquals("Cycle detected in the defined variables: var4 -> var5 -> var2 -> var3 -> var1 -> var2", diag4.message)
		
		val diag5 = diagnotics.get(4)
		assertEquals(TargetPlatformValidator::CHECK__VARIABLE_CYCLE, diag5.issueCode)
		assertEquals("var5", (diag5.sourceEObject as VarDefinition).name)
		assertEquals("Cycle detected in the defined variables: var5 -> var2 -> var3 -> var1 -> var2", diag5.message)
	}
	
	@Test
	def checkVariableDefinitionCycleFromSubTpd() {
		val tester = new ValidatorTester(validator, validatorRegistrar, languageName)
		val resourceSet = resourceSetProvider.get;
		val varDefCycle = parser.parse('''
			target "varDefCycle"
			include "subTpd.tpd"
			define var1 = ${var2}
		''', URI.createURI("tmp:/varDefCycle.tpd"), resourceSet)
		parser.parse('''
			target "subTpd"
			define var1 = "xyz"
			define var2 = ${var1}
		''', URI.createURI("tmp:/subTpd.tpd"), resourceSet)
		
		assertTrue(varDefCycle.eResource.errors.empty)
		tester.validator.checkVarDefinitionCycle(varDefCycle)
		
		var diagnotics = tester.diagnose.allDiagnostics.filter(typeof(AbstractValidationDiagnostic)).toList
		assertEquals(2, diagnotics.size)
		assertTrue(diagnotics.forall[sourceEObject instanceof VarDefinition])
		
		val diag1 = diagnotics.get(0)
		assertEquals(TargetPlatformValidator::CHECK__VARIABLE_CYCLE, diag1.issueCode)
		assertEquals("var1", (diag1.sourceEObject as VarDefinition).name)
		assertEquals("Cycle detected in the defined variables: var1 -> var2 -> var1", diag1.message)
		
		val diag2 = diagnotics.get(1)
		assertEquals(TargetPlatformValidator::CHECK__VARIABLE_CYCLE, diag2.issueCode)
		assertEquals("var2", (diag2.sourceEObject as VarDefinition).name)
		assertEquals("Cycle detected in the defined variables: var2 -> var1 -> var2", diag2.message)
	}
	
	@Test
	def checkVariableDefinitionCycleFromSubSubTpd() {
		val tester = new ValidatorTester(validator, validatorRegistrar, languageName)
		val resourceSet = resourceSetProvider.get;
		val varDefCycle = parser.parse('''
			target "varDefCycle"
			include "subTpd.tpd"
			define var1 = ${var2}
			define var4 = ${var1}
		''', URI.createURI("tmp:/varDefCycle.tpd"), resourceSet)
		parser.parse('''
			target "subTpd"
			include "subSubTpd.tpd"
			define var2 = ${var3}
			define var4 = "xyz"
		''', URI.createURI("tmp:/subTpd.tpd"), resourceSet)
		parser.parse('''
			target "subSubTpd"
			define var3 = ${var4}
			define var4 = "abc"
		''', URI.createURI("tmp:/subSubTpd.tpd"), resourceSet)
		
		assertTrue(varDefCycle.eResource.errors.empty)
		tester.validator.checkVarDefinitionCycle(varDefCycle)
		
		var diagnotics = tester.diagnose.allDiagnostics.filter(typeof(AbstractValidationDiagnostic)).toList
		assertEquals(4, diagnotics.size)
		assertTrue(diagnotics.forall[sourceEObject instanceof VarDefinition])
		
		val diag1 = diagnotics.get(0)
		assertEquals(TargetPlatformValidator::CHECK__VARIABLE_CYCLE, diag1.issueCode)
		assertEquals("var1", (diag1.sourceEObject as VarDefinition).name)
		assertEquals("Cycle detected in the defined variables: var1 -> var2 -> var3 -> var4 -> var1", diag1.message)
		
		val diag2 = diagnotics.get(1)
		assertEquals(TargetPlatformValidator::CHECK__VARIABLE_CYCLE, diag2.issueCode)
		assertEquals("var4", (diag2.sourceEObject as VarDefinition).name)
		assertEquals("Cycle detected in the defined variables: var4 -> var1 -> var2 -> var3 -> var4", diag2.message)
	}
	
	@Test
	def testNoDuplicatedVarDefinition() {
		val tester = new ValidatorTester(validator, validatorRegistrar, languageName)
		val compositeIncludeTarget = parser.parse('''
			target "compositeIncludeTarget"
			define twiceVar = "val1"
			define otherVar = "val"
			define twiceVar = "val2"
		''')
		assertTrue(compositeIncludeTarget.eResource.errors.empty)
		tester.validator.checkNoDuplicatedDefine(compositeIncludeTarget)
		var diagnostics = tester.diagnose.allDiagnostics.filter(typeof(FeatureBasedDiagnostic)).toList
		assertEquals(diagnostics.join(', '), 1, diagnostics.size)
		assertEquals(TargetPlatformValidator::CHECK__NO_DUPLICATED_DEFINE, diagnostics.head.issueCode)
		assertEquals(Diagnostic.ERROR, diagnostics.get(0).severity)
		assertEquals("\"twiceVar\" is defined many times", diagnostics.get(0).message)
	}
	
	@Test
	def testNoDuplicatedVarDefinitionFromIncludeDifferentValues() {
		val resourceSet = resourceSetProvider.get
		val tester = new ValidatorTester(validator, validatorRegistrar, languageName)
		val compositeIncludeTarget = parser.parse('''
			target "compositeIncludeTarget"
			include "subTpd1.tpd"
			include "subTpd2.tpd"
		''', URI.createURI("tmp:/compositeIncludeTarget.tpd"), resourceSet)
		parser.parse('''
			target "subTpd1"
			define twiceVar = "val1"
		''', URI.createURI("tmp:/subTpd1.tpd"), resourceSet)
		parser.parse('''
			target "subTpd2"
			define twiceVar = "val2"
		''', URI.createURI("tmp:/subTpd2.tpd"), resourceSet)
		
		val locationIndex = indexBuilder.getLocationIndex(compositeIncludeTarget)
		assertEquals(0, locationIndex.size)
		
		assertTrue(compositeIncludeTarget.eResource.errors.empty)
		tester.validator.checkNoDuplicatedDefine(compositeIncludeTarget)
		var diagnostics = tester.diagnose.allDiagnostics.filter(typeof(FeatureBasedDiagnostic)).toList
		assertEquals(diagnostics.join(', '), 1, diagnostics.size)
		assertEquals(TargetPlatformValidator::CHECK__NO_DUPLICATED_DEFINE, diagnostics.head.issueCode)
		assertEquals(Diagnostic.ERROR, diagnostics.get(0).severity)
		val messageErr = diagnostics.get(0).message
		assertTrue("\"twiceVar\" is imported many time with different values: [val1, val2]".equals(messageErr) ||
			"\"twiceVar\" is imported many time with different values: [val2, val1]".equals(messageErr)
		)
	}
	
	@Test
	def testNoDuplicatedVarDefinitionFromIncludeSameValues() {
		val resourceSet = resourceSetProvider.get
		val tester = new ValidatorTester(validator, validatorRegistrar, languageName)
		val compositeIncludeTarget = parser.parse('''
			target "compositeIncludeTarget"
			include "subTpd1.tpd"
			include "subTpd2.tpd"
		''', URI.createURI("tmp:/compositeIncludeTarget.tpd"), resourceSet)
		parser.parse('''
			target "subTpd1"
			define twiceVar = "val"
		''', URI.createURI("tmp:/subTpd1.tpd"), resourceSet)
		parser.parse('''
			target "subTpd2"
			define twiceVar = "val"
		''', URI.createURI("tmp:/subTpd2.tpd"), resourceSet)
		
		val locationIndex = indexBuilder.getLocationIndex(compositeIncludeTarget)
		assertEquals(0, locationIndex.size)
		
		assertTrue(compositeIncludeTarget.eResource.errors.empty)
		tester.validator.checkNoDuplicatedDefine(compositeIncludeTarget)
		var diagnostics = tester.diagnose.allDiagnostics.filter(typeof(FeatureBasedDiagnostic)).toList
		assertEquals(diagnostics.join(', '), 1, diagnostics.size)
		assertEquals(TargetPlatformValidator::CHECK__NO_DUPLICATED_DEFINE, diagnostics.head.issueCode)
		assertEquals(Diagnostic.INFO, diagnostics.get(0).severity)
		assertEquals("\"twiceVar\" is imported many time", diagnostics.get(0).message)
	}
	
	@Test
	def testDuplicatedVarDefinitionFromIncludeButOverride() {
		val resourceSet = resourceSetProvider.get
		val tester = new ValidatorTester(validator, validatorRegistrar, languageName)
		val compositeIncludeTarget = parser.parse('''
			target "compositeIncludeTarget"
			include "subTpd1.tpd"
			include "subTpd2.tpd"
			define twiceVar = "newVal"
		''', URI.createURI("tmp:/compositeIncludeTarget.tpd"), resourceSet)
		parser.parse('''
			target "subTpd1"
			define twiceVar = "val1"
		''', URI.createURI("tmp:/subTpd1.tpd"), resourceSet)
		parser.parse('''
			target "subTpd2"
			define twiceVar = "val2"
		''', URI.createURI("tmp:/subTpd2.tpd"), resourceSet)
		
		val locationIndex = indexBuilder.getLocationIndex(compositeIncludeTarget)
		assertEquals(0, locationIndex.size)
		
		assertTrue(compositeIncludeTarget.eResource.errors.empty)
		tester.validator.checkNoDuplicatedDefine(compositeIncludeTarget)
		var diagnostics = tester.diagnose.allDiagnostics.filter(typeof(FeatureBasedDiagnostic)).toList
		assertEquals(diagnostics.join(', '), 0, diagnostics.size)
	}
	
	@Test
	def testNoDuplicatedVarDefinitionFromIncludeValueOverloaded() {
		val resourceSet = resourceSetProvider.get
		val tester = new ValidatorTester(validator, validatorRegistrar, languageName)
		val compositeIncludeTarget = parser.parse('''
			target "compositeIncludeTarget"
			include "subTpd1.tpd"
			define twiceVar = "val"
		''', URI.createURI("tmp:/compositeIncludeTarget.tpd"), resourceSet)
		parser.parse('''
			target "subTpd1"
			define twiceVar = "val1"
		''', URI.createURI("tmp:/subTpd1.tpd"), resourceSet)
		
		val locationIndex = indexBuilder.getLocationIndex(compositeIncludeTarget)
		assertEquals(0, locationIndex.size)
		
		assertTrue(compositeIncludeTarget.eResource.errors.empty)
		tester.validator.checkNoDuplicatedDefine(compositeIncludeTarget)
		var diagnostics = tester.diagnose.allDiagnostics.filter(typeof(FeatureBasedDiagnostic)).toList
		assertEquals(diagnostics.join(', '), 0, diagnostics.size)
	}
}