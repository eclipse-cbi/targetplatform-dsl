package fr.obeo.releng.targetplatform.tests.composite_elements;

import com.google.common.collect.Iterables;
import com.google.common.collect.ListMultimap;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.name.Named;
import fr.obeo.releng.targetplatform.IncludeDeclaration;
import fr.obeo.releng.targetplatform.Location;
import fr.obeo.releng.targetplatform.TargetPlatform;
import fr.obeo.releng.targetplatform.TargetPlatformInjectorProvider;
import fr.obeo.releng.targetplatform.VarDefinition;
import fr.obeo.releng.targetplatform.util.ImportVariableManager;
import fr.obeo.releng.targetplatform.util.LocationIndexBuilder;
import fr.obeo.releng.targetplatform.validation.TargetPlatformValidator;
import java.util.List;
import java.util.function.Consumer;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.Constants;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.junit4.util.ParseHelper;
import org.eclipse.xtext.junit4.validation.ValidatorTester;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.validation.AbstractValidationDiagnostic;
import org.eclipse.xtext.validation.EValidatorRegistrar;
import org.eclipse.xtext.validation.FeatureBasedDiagnostic;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@InjectWith(TargetPlatformInjectorProvider.class)
@RunWith(XtextRunner.class)
@SuppressWarnings("all")
public class TestCompositeElementValidation {
  @Inject
  private ParseHelper<TargetPlatform> parser;
  
  @Inject
  private TargetPlatformValidator validator;
  
  @Inject
  private EValidatorRegistrar validatorRegistrar;
  
  @Inject
  private Provider<XtextResourceSet> resourceSetProvider;
  
  @Inject
  private LocationIndexBuilder indexBuilder;
  
  @Inject
  private ImportVariableManager importVariableManager;
  
  @Inject
  @Named(Constants.LANGUAGE_NAME)
  private String languageName;
  
  @Test
  public void checkImportCycleDueToVariableDefinition() {
    try {
      final ValidatorTester<TargetPlatformValidator> tester = new ValidatorTester<TargetPlatformValidator>(this.validator, this.validatorRegistrar, this.languageName);
      final XtextResourceSet resourceSet = this.resourceSetProvider.get();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"compositeIncludeTarget\"");
      _builder.newLine();
      _builder.append("include \"subTpd.tpd\"");
      _builder.newLine();
      _builder.append("include ${subDirName} + \"/\" + \"subInclude.tpd\"");
      _builder.newLine();
      final TargetPlatform compositeIncludeTarget = this.parser.parse(_builder, URI.createURI("tmp:/compositeIncludeTarget.tpd"), resourceSet);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("target \"subTpd\"");
      _builder_1.newLine();
      _builder_1.append("include \"subsubTpd.tpd\"");
      _builder_1.newLine();
      _builder_1.append("define subDirName=\"subdir\"");
      _builder_1.newLine();
      this.parser.parse(_builder_1, URI.createURI("tmp:/subTpd.tpd"), resourceSet);
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("target \"subInclude\"");
      _builder_2.newLine();
      _builder_2.append("include \"../compositeIncludeTarget.tpd\"");
      _builder_2.newLine();
      final TargetPlatform subIncludeCircular = this.parser.parse(_builder_2, URI.createURI("tmp:/subdir/subInclude.tpd"), resourceSet);
      Assert.assertTrue(compositeIncludeTarget.eResource().getErrors().isEmpty());
      tester.validator().checkImportCycle(compositeIncludeTarget);
      List<AbstractValidationDiagnostic> diagnotics = IterableExtensions.<AbstractValidationDiagnostic>toList(Iterables.<AbstractValidationDiagnostic>filter(tester.diagnose().getAllDiagnostics(), AbstractValidationDiagnostic.class));
      Assert.assertEquals(1, diagnotics.size());
      final Function1<AbstractValidationDiagnostic, Boolean> _function = new Function1<AbstractValidationDiagnostic, Boolean>() {
        @Override
        public Boolean apply(final AbstractValidationDiagnostic it) {
          EObject _sourceEObject = it.getSourceEObject();
          return Boolean.valueOf((_sourceEObject instanceof IncludeDeclaration));
        }
      };
      Assert.assertTrue(IterableExtensions.<AbstractValidationDiagnostic>forall(diagnotics, _function));
      final Consumer<AbstractValidationDiagnostic> _function_1 = new Consumer<AbstractValidationDiagnostic>() {
        @Override
        public void accept(final AbstractValidationDiagnostic it) {
          Assert.assertEquals(TargetPlatformValidator.CHECK__INCLUDE_CYCLE, it.getIssueCode());
          EObject _sourceEObject = it.getSourceEObject();
          Assert.assertEquals("subdir/subInclude.tpd", ((IncludeDeclaration) _sourceEObject).getImportURI());
        }
      };
      diagnotics.forEach(_function_1);
      Assert.assertTrue(subIncludeCircular.eResource().getErrors().isEmpty());
      tester.validator().checkImportCycle(subIncludeCircular);
      diagnotics = IterableExtensions.<AbstractValidationDiagnostic>toList(Iterables.<AbstractValidationDiagnostic>filter(tester.diagnose().getAllDiagnostics(), AbstractValidationDiagnostic.class));
      Assert.assertEquals(1, diagnotics.size());
      final Function1<AbstractValidationDiagnostic, Boolean> _function_2 = new Function1<AbstractValidationDiagnostic, Boolean>() {
        @Override
        public Boolean apply(final AbstractValidationDiagnostic it) {
          EObject _sourceEObject = it.getSourceEObject();
          return Boolean.valueOf((_sourceEObject instanceof IncludeDeclaration));
        }
      };
      Assert.assertTrue(IterableExtensions.<AbstractValidationDiagnostic>forall(diagnotics, _function_2));
      final Consumer<AbstractValidationDiagnostic> _function_3 = new Consumer<AbstractValidationDiagnostic>() {
        @Override
        public void accept(final AbstractValidationDiagnostic it) {
          Assert.assertEquals(TargetPlatformValidator.CHECK__INCLUDE_CYCLE, it.getIssueCode());
          EObject _sourceEObject = it.getSourceEObject();
          Assert.assertEquals("../compositeIncludeTarget.tpd", ((IncludeDeclaration) _sourceEObject).getImportURI());
        }
      };
      diagnotics.forEach(_function_3);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void checkImportCycleDueToVariableDefinitionOverride() {
    try {
      final String[] args = { "compositeIncludeTarget.tpd", "urlCyclicInclude=../compositeIncludeTarget.tpd" };
      this.importVariableManager.processCommandLineArguments(args);
      final ValidatorTester<TargetPlatformValidator> tester = new ValidatorTester<TargetPlatformValidator>(this.validator, this.validatorRegistrar, this.languageName);
      final XtextResourceSet resourceSet = this.resourceSetProvider.get();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"compositeIncludeTarget\"");
      _builder.newLine();
      _builder.append("include \"subTpd.tpd\"");
      _builder.newLine();
      _builder.append("include ${subDirName} + \"/\" + \"subInclude.tpd\"");
      _builder.newLine();
      final TargetPlatform compositeIncludeTarget = this.parser.parse(_builder, URI.createURI("tmp:/compositeIncludeTarget.tpd"), resourceSet);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("target \"subTpd\"");
      _builder_1.newLine();
      _builder_1.append("include \"subsubTpd.tpd\"");
      _builder_1.newLine();
      _builder_1.append("define subDirName=\"subdir\"");
      _builder_1.newLine();
      this.parser.parse(_builder_1, URI.createURI("tmp:/subTpd.tpd"), resourceSet);
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("target \"subInclude\"");
      _builder_2.newLine();
      _builder_2.append("define urlCyclicInclude = \"notACycle.tpd\"");
      _builder_2.newLine();
      _builder_2.append("include ${urlCyclicInclude}");
      _builder_2.newLine();
      final TargetPlatform subIncludeCircular = this.parser.parse(_builder_2, URI.createURI("tmp:/subdir/subInclude.tpd"), resourceSet);
      Assert.assertTrue(compositeIncludeTarget.eResource().getErrors().isEmpty());
      tester.validator().checkImportCycle(compositeIncludeTarget);
      List<AbstractValidationDiagnostic> diagnotics = IterableExtensions.<AbstractValidationDiagnostic>toList(Iterables.<AbstractValidationDiagnostic>filter(tester.diagnose().getAllDiagnostics(), AbstractValidationDiagnostic.class));
      Assert.assertEquals(1, diagnotics.size());
      final Function1<AbstractValidationDiagnostic, Boolean> _function = new Function1<AbstractValidationDiagnostic, Boolean>() {
        @Override
        public Boolean apply(final AbstractValidationDiagnostic it) {
          EObject _sourceEObject = it.getSourceEObject();
          return Boolean.valueOf((_sourceEObject instanceof IncludeDeclaration));
        }
      };
      Assert.assertTrue(IterableExtensions.<AbstractValidationDiagnostic>forall(diagnotics, _function));
      final Consumer<AbstractValidationDiagnostic> _function_1 = new Consumer<AbstractValidationDiagnostic>() {
        @Override
        public void accept(final AbstractValidationDiagnostic it) {
          Assert.assertEquals(TargetPlatformValidator.CHECK__INCLUDE_CYCLE, it.getIssueCode());
          EObject _sourceEObject = it.getSourceEObject();
          Assert.assertEquals("subdir/subInclude.tpd", ((IncludeDeclaration) _sourceEObject).getImportURI());
        }
      };
      diagnotics.forEach(_function_1);
      Assert.assertTrue(subIncludeCircular.eResource().getErrors().isEmpty());
      tester.validator().checkImportCycle(subIncludeCircular);
      diagnotics = IterableExtensions.<AbstractValidationDiagnostic>toList(Iterables.<AbstractValidationDiagnostic>filter(tester.diagnose().getAllDiagnostics(), AbstractValidationDiagnostic.class));
      Assert.assertEquals(1, diagnotics.size());
      final Function1<AbstractValidationDiagnostic, Boolean> _function_2 = new Function1<AbstractValidationDiagnostic, Boolean>() {
        @Override
        public Boolean apply(final AbstractValidationDiagnostic it) {
          EObject _sourceEObject = it.getSourceEObject();
          return Boolean.valueOf((_sourceEObject instanceof IncludeDeclaration));
        }
      };
      Assert.assertTrue(IterableExtensions.<AbstractValidationDiagnostic>forall(diagnotics, _function_2));
      final Consumer<AbstractValidationDiagnostic> _function_3 = new Consumer<AbstractValidationDiagnostic>() {
        @Override
        public void accept(final AbstractValidationDiagnostic it) {
          Assert.assertEquals(TargetPlatformValidator.CHECK__INCLUDE_CYCLE, it.getIssueCode());
          EObject _sourceEObject = it.getSourceEObject();
          Assert.assertEquals("../compositeIncludeTarget.tpd", ((IncludeDeclaration) _sourceEObject).getImportURI());
        }
      };
      diagnotics.forEach(_function_3);
      this.importVariableManager.clear();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void checkVariableDefinitionCycle1() {
    try {
      final ValidatorTester<TargetPlatformValidator> tester = new ValidatorTester<TargetPlatformValidator>(this.validator, this.validatorRegistrar, this.languageName);
      final XtextResourceSet resourceSet = this.resourceSetProvider.get();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"varDefCycle\"");
      _builder.newLine();
      _builder.append("define var1 = ${var2}");
      _builder.newLine();
      _builder.append("define var2 = ${var1}");
      _builder.newLine();
      final TargetPlatform varDefCycle = this.parser.parse(_builder, URI.createURI("tmp:/varDefCycle.tpd"), resourceSet);
      Assert.assertTrue(varDefCycle.eResource().getErrors().isEmpty());
      tester.validator().checkVarDefinitionCycle(varDefCycle);
      List<AbstractValidationDiagnostic> diagnotics = IterableExtensions.<AbstractValidationDiagnostic>toList(Iterables.<AbstractValidationDiagnostic>filter(tester.diagnose().getAllDiagnostics(), AbstractValidationDiagnostic.class));
      Assert.assertEquals(2, diagnotics.size());
      final Function1<AbstractValidationDiagnostic, Boolean> _function = new Function1<AbstractValidationDiagnostic, Boolean>() {
        @Override
        public Boolean apply(final AbstractValidationDiagnostic it) {
          EObject _sourceEObject = it.getSourceEObject();
          return Boolean.valueOf((_sourceEObject instanceof VarDefinition));
        }
      };
      Assert.assertTrue(IterableExtensions.<AbstractValidationDiagnostic>forall(diagnotics, _function));
      final AbstractValidationDiagnostic diag1 = diagnotics.get(0);
      Assert.assertEquals(TargetPlatformValidator.CHECK__VARIABLE_CYCLE, diag1.getIssueCode());
      EObject _sourceEObject = diag1.getSourceEObject();
      Assert.assertEquals("var1", ((VarDefinition) _sourceEObject).getName());
      Assert.assertEquals("Cycle detected in the defined variables: var1 -> var2 -> var1", diag1.getMessage());
      final AbstractValidationDiagnostic diag2 = diagnotics.get(1);
      Assert.assertEquals(TargetPlatformValidator.CHECK__VARIABLE_CYCLE, diag2.getIssueCode());
      EObject _sourceEObject_1 = diag2.getSourceEObject();
      Assert.assertEquals("var2", ((VarDefinition) _sourceEObject_1).getName());
      Assert.assertEquals("Cycle detected in the defined variables: var2 -> var1 -> var2", diag2.getMessage());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void checkVariableDefinitionCycle2() {
    try {
      final ValidatorTester<TargetPlatformValidator> tester = new ValidatorTester<TargetPlatformValidator>(this.validator, this.validatorRegistrar, this.languageName);
      final XtextResourceSet resourceSet = this.resourceSetProvider.get();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"varDefCycle\"");
      _builder.newLine();
      _builder.append("define var1 = ${var2}");
      _builder.newLine();
      _builder.append("define var2 = ${var3}");
      _builder.newLine();
      _builder.append("define var3 = ${var1}");
      _builder.newLine();
      _builder.append("include ${var1}");
      _builder.newLine();
      _builder.append("location ${var2} {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("xyz ${var3}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final TargetPlatform varDefCycle = this.parser.parse(_builder, URI.createURI("tmp:/varDefCycle.tpd"), resourceSet);
      Assert.assertTrue(varDefCycle.eResource().getErrors().isEmpty());
      tester.validator().checkVarDefinitionCycle(varDefCycle);
      List<AbstractValidationDiagnostic> diagnotics = IterableExtensions.<AbstractValidationDiagnostic>toList(Iterables.<AbstractValidationDiagnostic>filter(tester.diagnose().getAllDiagnostics(), AbstractValidationDiagnostic.class));
      Assert.assertEquals(3, diagnotics.size());
      final Function1<AbstractValidationDiagnostic, Boolean> _function = new Function1<AbstractValidationDiagnostic, Boolean>() {
        @Override
        public Boolean apply(final AbstractValidationDiagnostic it) {
          EObject _sourceEObject = it.getSourceEObject();
          return Boolean.valueOf((_sourceEObject instanceof VarDefinition));
        }
      };
      Assert.assertTrue(IterableExtensions.<AbstractValidationDiagnostic>forall(diagnotics, _function));
      final AbstractValidationDiagnostic diag1 = diagnotics.get(0);
      Assert.assertEquals(TargetPlatformValidator.CHECK__VARIABLE_CYCLE, diag1.getIssueCode());
      EObject _sourceEObject = diag1.getSourceEObject();
      Assert.assertEquals("var1", ((VarDefinition) _sourceEObject).getName());
      Assert.assertEquals("Cycle detected in the defined variables: var1 -> var2 -> var3 -> var1", diag1.getMessage());
      final AbstractValidationDiagnostic diag2 = diagnotics.get(1);
      Assert.assertEquals(TargetPlatformValidator.CHECK__VARIABLE_CYCLE, diag2.getIssueCode());
      EObject _sourceEObject_1 = diag2.getSourceEObject();
      Assert.assertEquals("var2", ((VarDefinition) _sourceEObject_1).getName());
      Assert.assertEquals("Cycle detected in the defined variables: var2 -> var3 -> var1 -> var2", diag2.getMessage());
      final AbstractValidationDiagnostic diag3 = diagnotics.get(2);
      Assert.assertEquals(TargetPlatformValidator.CHECK__VARIABLE_CYCLE, diag3.getIssueCode());
      EObject _sourceEObject_2 = diag3.getSourceEObject();
      Assert.assertEquals("var3", ((VarDefinition) _sourceEObject_2).getName());
      Assert.assertEquals("Cycle detected in the defined variables: var3 -> var1 -> var2 -> var3", diag3.getMessage());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void checkVariableDefinitionCycle3() {
    try {
      final ValidatorTester<TargetPlatformValidator> tester = new ValidatorTester<TargetPlatformValidator>(this.validator, this.validatorRegistrar, this.languageName);
      final XtextResourceSet resourceSet = this.resourceSetProvider.get();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"varDefCycle\"");
      _builder.newLine();
      _builder.append("define var1 = ${var2} + \"abc\" + ${var3}");
      _builder.newLine();
      _builder.append("define var2 = \"aaa\" + ${var3}");
      _builder.newLine();
      _builder.append("define var3 = ${var2} + ${var1}");
      _builder.newLine();
      final TargetPlatform varDefCycle = this.parser.parse(_builder, URI.createURI("tmp:/varDefCycle.tpd"), resourceSet);
      Assert.assertTrue(varDefCycle.eResource().getErrors().isEmpty());
      tester.validator().checkVarDefinitionCycle(varDefCycle);
      List<AbstractValidationDiagnostic> diagnotics = IterableExtensions.<AbstractValidationDiagnostic>toList(Iterables.<AbstractValidationDiagnostic>filter(tester.diagnose().getAllDiagnostics(), AbstractValidationDiagnostic.class));
      Assert.assertEquals(3, diagnotics.size());
      final Function1<AbstractValidationDiagnostic, Boolean> _function = new Function1<AbstractValidationDiagnostic, Boolean>() {
        @Override
        public Boolean apply(final AbstractValidationDiagnostic it) {
          EObject _sourceEObject = it.getSourceEObject();
          return Boolean.valueOf((_sourceEObject instanceof VarDefinition));
        }
      };
      Assert.assertTrue(IterableExtensions.<AbstractValidationDiagnostic>forall(diagnotics, _function));
      final AbstractValidationDiagnostic diag1 = diagnotics.get(0);
      Assert.assertEquals(TargetPlatformValidator.CHECK__VARIABLE_CYCLE, diag1.getIssueCode());
      EObject _sourceEObject = diag1.getSourceEObject();
      Assert.assertEquals("var1", ((VarDefinition) _sourceEObject).getName());
      Assert.assertEquals("Cycle detected in the defined variables: var1 -> var2 -> var3 -> var2", diag1.getMessage());
      final AbstractValidationDiagnostic diag2 = diagnotics.get(1);
      Assert.assertEquals(TargetPlatformValidator.CHECK__VARIABLE_CYCLE, diag2.getIssueCode());
      EObject _sourceEObject_1 = diag2.getSourceEObject();
      Assert.assertEquals("var2", ((VarDefinition) _sourceEObject_1).getName());
      Assert.assertEquals("Cycle detected in the defined variables: var2 -> var3 -> var2", diag2.getMessage());
      final AbstractValidationDiagnostic diag3 = diagnotics.get(2);
      Assert.assertEquals(TargetPlatformValidator.CHECK__VARIABLE_CYCLE, diag3.getIssueCode());
      EObject _sourceEObject_2 = diag3.getSourceEObject();
      Assert.assertEquals("var3", ((VarDefinition) _sourceEObject_2).getName());
      Assert.assertEquals("Cycle detected in the defined variables: var3 -> var2 -> var3", diag3.getMessage());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void checkVariableDefinitionCycle4() {
    try {
      final ValidatorTester<TargetPlatformValidator> tester = new ValidatorTester<TargetPlatformValidator>(this.validator, this.validatorRegistrar, this.languageName);
      final XtextResourceSet resourceSet = this.resourceSetProvider.get();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"varDefCycle\"");
      _builder.newLine();
      _builder.append("define var1 = ${var1}");
      _builder.newLine();
      final TargetPlatform varDefCycle = this.parser.parse(_builder, URI.createURI("tmp:/varDefCycle.tpd"), resourceSet);
      Assert.assertTrue(varDefCycle.eResource().getErrors().isEmpty());
      tester.validator().checkVarDefinitionCycle(varDefCycle);
      List<AbstractValidationDiagnostic> diagnotics = IterableExtensions.<AbstractValidationDiagnostic>toList(Iterables.<AbstractValidationDiagnostic>filter(tester.diagnose().getAllDiagnostics(), AbstractValidationDiagnostic.class));
      Assert.assertEquals(1, diagnotics.size());
      final Function1<AbstractValidationDiagnostic, Boolean> _function = new Function1<AbstractValidationDiagnostic, Boolean>() {
        @Override
        public Boolean apply(final AbstractValidationDiagnostic it) {
          EObject _sourceEObject = it.getSourceEObject();
          return Boolean.valueOf((_sourceEObject instanceof VarDefinition));
        }
      };
      Assert.assertTrue(IterableExtensions.<AbstractValidationDiagnostic>forall(diagnotics, _function));
      final AbstractValidationDiagnostic diag1 = diagnotics.get(0);
      Assert.assertEquals(TargetPlatformValidator.CHECK__VARIABLE_CYCLE, diag1.getIssueCode());
      EObject _sourceEObject = diag1.getSourceEObject();
      Assert.assertEquals("var1", ((VarDefinition) _sourceEObject).getName());
      Assert.assertEquals("Cycle detected in the defined variables: var1 -> var1", diag1.getMessage());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void checkVariableDefinitionCycleInterleave() {
    try {
      final ValidatorTester<TargetPlatformValidator> tester = new ValidatorTester<TargetPlatformValidator>(this.validator, this.validatorRegistrar, this.languageName);
      final XtextResourceSet resourceSet = this.resourceSetProvider.get();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"varDefCycle\"");
      _builder.newLine();
      _builder.append("define var1 = ${var2}");
      _builder.newLine();
      _builder.append("define var2 = ${var3} + ${var4}");
      _builder.newLine();
      _builder.append("define var3 = ${var1}");
      _builder.newLine();
      _builder.append("define var4 = ${var5}");
      _builder.newLine();
      _builder.append("define var5 = ${var2}");
      _builder.newLine();
      final TargetPlatform varDefCycle = this.parser.parse(_builder, URI.createURI("tmp:/varDefCycle.tpd"), resourceSet);
      Assert.assertTrue(varDefCycle.eResource().getErrors().isEmpty());
      tester.validator().checkVarDefinitionCycle(varDefCycle);
      List<AbstractValidationDiagnostic> diagnotics = IterableExtensions.<AbstractValidationDiagnostic>toList(Iterables.<AbstractValidationDiagnostic>filter(tester.diagnose().getAllDiagnostics(), AbstractValidationDiagnostic.class));
      Assert.assertEquals(5, diagnotics.size());
      final Function1<AbstractValidationDiagnostic, Boolean> _function = new Function1<AbstractValidationDiagnostic, Boolean>() {
        @Override
        public Boolean apply(final AbstractValidationDiagnostic it) {
          EObject _sourceEObject = it.getSourceEObject();
          return Boolean.valueOf((_sourceEObject instanceof VarDefinition));
        }
      };
      Assert.assertTrue(IterableExtensions.<AbstractValidationDiagnostic>forall(diagnotics, _function));
      final AbstractValidationDiagnostic diag1 = diagnotics.get(0);
      Assert.assertEquals(TargetPlatformValidator.CHECK__VARIABLE_CYCLE, diag1.getIssueCode());
      EObject _sourceEObject = diag1.getSourceEObject();
      Assert.assertEquals("var1", ((VarDefinition) _sourceEObject).getName());
      Assert.assertEquals("Cycle detected in the defined variables: var1 -> var2 -> var3 -> var1", diag1.getMessage());
      final AbstractValidationDiagnostic diag2 = diagnotics.get(1);
      Assert.assertEquals(TargetPlatformValidator.CHECK__VARIABLE_CYCLE, diag2.getIssueCode());
      EObject _sourceEObject_1 = diag2.getSourceEObject();
      Assert.assertEquals("var2", ((VarDefinition) _sourceEObject_1).getName());
      Assert.assertEquals("Cycle detected in the defined variables: var2 -> var3 -> var1 -> var2", diag2.getMessage());
      final AbstractValidationDiagnostic diag3 = diagnotics.get(2);
      Assert.assertEquals(TargetPlatformValidator.CHECK__VARIABLE_CYCLE, diag3.getIssueCode());
      EObject _sourceEObject_2 = diag3.getSourceEObject();
      Assert.assertEquals("var3", ((VarDefinition) _sourceEObject_2).getName());
      Assert.assertEquals("Cycle detected in the defined variables: var3 -> var1 -> var2 -> var3", diag3.getMessage());
      final AbstractValidationDiagnostic diag4 = diagnotics.get(3);
      Assert.assertEquals(TargetPlatformValidator.CHECK__VARIABLE_CYCLE, diag4.getIssueCode());
      EObject _sourceEObject_3 = diag4.getSourceEObject();
      Assert.assertEquals("var4", ((VarDefinition) _sourceEObject_3).getName());
      Assert.assertEquals("Cycle detected in the defined variables: var4 -> var5 -> var2 -> var3 -> var1 -> var2", diag4.getMessage());
      final AbstractValidationDiagnostic diag5 = diagnotics.get(4);
      Assert.assertEquals(TargetPlatformValidator.CHECK__VARIABLE_CYCLE, diag5.getIssueCode());
      EObject _sourceEObject_4 = diag5.getSourceEObject();
      Assert.assertEquals("var5", ((VarDefinition) _sourceEObject_4).getName());
      Assert.assertEquals("Cycle detected in the defined variables: var5 -> var2 -> var3 -> var1 -> var2", diag5.getMessage());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void checkVariableDefinitionCycleFromSubTpd() {
    try {
      final ValidatorTester<TargetPlatformValidator> tester = new ValidatorTester<TargetPlatformValidator>(this.validator, this.validatorRegistrar, this.languageName);
      final XtextResourceSet resourceSet = this.resourceSetProvider.get();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"varDefCycle\"");
      _builder.newLine();
      _builder.append("include \"subTpd.tpd\"");
      _builder.newLine();
      _builder.append("define var1 = ${var2}");
      _builder.newLine();
      final TargetPlatform varDefCycle = this.parser.parse(_builder, URI.createURI("tmp:/varDefCycle.tpd"), resourceSet);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("target \"subTpd\"");
      _builder_1.newLine();
      _builder_1.append("define var1 = \"xyz\"");
      _builder_1.newLine();
      _builder_1.append("define var2 = ${var1}");
      _builder_1.newLine();
      this.parser.parse(_builder_1, URI.createURI("tmp:/subTpd.tpd"), resourceSet);
      Assert.assertTrue(varDefCycle.eResource().getErrors().isEmpty());
      tester.validator().checkVarDefinitionCycle(varDefCycle);
      List<AbstractValidationDiagnostic> diagnotics = IterableExtensions.<AbstractValidationDiagnostic>toList(Iterables.<AbstractValidationDiagnostic>filter(tester.diagnose().getAllDiagnostics(), AbstractValidationDiagnostic.class));
      Assert.assertEquals(2, diagnotics.size());
      final Function1<AbstractValidationDiagnostic, Boolean> _function = new Function1<AbstractValidationDiagnostic, Boolean>() {
        @Override
        public Boolean apply(final AbstractValidationDiagnostic it) {
          EObject _sourceEObject = it.getSourceEObject();
          return Boolean.valueOf((_sourceEObject instanceof VarDefinition));
        }
      };
      Assert.assertTrue(IterableExtensions.<AbstractValidationDiagnostic>forall(diagnotics, _function));
      final AbstractValidationDiagnostic diag1 = diagnotics.get(0);
      Assert.assertEquals(TargetPlatformValidator.CHECK__VARIABLE_CYCLE, diag1.getIssueCode());
      EObject _sourceEObject = diag1.getSourceEObject();
      Assert.assertEquals("var1", ((VarDefinition) _sourceEObject).getName());
      Assert.assertEquals("Cycle detected in the defined variables: var1 -> var2 -> var1", diag1.getMessage());
      final AbstractValidationDiagnostic diag2 = diagnotics.get(1);
      Assert.assertEquals(TargetPlatformValidator.CHECK__VARIABLE_CYCLE, diag2.getIssueCode());
      EObject _sourceEObject_1 = diag2.getSourceEObject();
      Assert.assertEquals("var2", ((VarDefinition) _sourceEObject_1).getName());
      Assert.assertEquals("Cycle detected in the defined variables: var2 -> var1 -> var2", diag2.getMessage());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void checkVariableDefinitionCycleFromSubSubTpd() {
    try {
      final ValidatorTester<TargetPlatformValidator> tester = new ValidatorTester<TargetPlatformValidator>(this.validator, this.validatorRegistrar, this.languageName);
      final XtextResourceSet resourceSet = this.resourceSetProvider.get();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"varDefCycle\"");
      _builder.newLine();
      _builder.append("include \"subTpd.tpd\"");
      _builder.newLine();
      _builder.append("define var1 = ${var2}");
      _builder.newLine();
      _builder.append("define var4 = ${var1}");
      _builder.newLine();
      final TargetPlatform varDefCycle = this.parser.parse(_builder, URI.createURI("tmp:/varDefCycle.tpd"), resourceSet);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("target \"subTpd\"");
      _builder_1.newLine();
      _builder_1.append("include \"subSubTpd.tpd\"");
      _builder_1.newLine();
      _builder_1.append("define var2 = ${var3}");
      _builder_1.newLine();
      _builder_1.append("define var4 = \"xyz\"");
      _builder_1.newLine();
      this.parser.parse(_builder_1, URI.createURI("tmp:/subTpd.tpd"), resourceSet);
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("target \"subSubTpd\"");
      _builder_2.newLine();
      _builder_2.append("define var3 = ${var4}");
      _builder_2.newLine();
      _builder_2.append("define var4 = \"abc\"");
      _builder_2.newLine();
      this.parser.parse(_builder_2, URI.createURI("tmp:/subSubTpd.tpd"), resourceSet);
      Assert.assertTrue(varDefCycle.eResource().getErrors().isEmpty());
      tester.validator().checkVarDefinitionCycle(varDefCycle);
      List<AbstractValidationDiagnostic> diagnotics = IterableExtensions.<AbstractValidationDiagnostic>toList(Iterables.<AbstractValidationDiagnostic>filter(tester.diagnose().getAllDiagnostics(), AbstractValidationDiagnostic.class));
      Assert.assertEquals(4, diagnotics.size());
      final Function1<AbstractValidationDiagnostic, Boolean> _function = new Function1<AbstractValidationDiagnostic, Boolean>() {
        @Override
        public Boolean apply(final AbstractValidationDiagnostic it) {
          EObject _sourceEObject = it.getSourceEObject();
          return Boolean.valueOf((_sourceEObject instanceof VarDefinition));
        }
      };
      Assert.assertTrue(IterableExtensions.<AbstractValidationDiagnostic>forall(diagnotics, _function));
      final AbstractValidationDiagnostic diag1 = diagnotics.get(0);
      Assert.assertEquals(TargetPlatformValidator.CHECK__VARIABLE_CYCLE, diag1.getIssueCode());
      EObject _sourceEObject = diag1.getSourceEObject();
      Assert.assertEquals("var1", ((VarDefinition) _sourceEObject).getName());
      Assert.assertEquals("Cycle detected in the defined variables: var1 -> var2 -> var3 -> var4 -> var1", diag1.getMessage());
      final AbstractValidationDiagnostic diag2 = diagnotics.get(1);
      Assert.assertEquals(TargetPlatformValidator.CHECK__VARIABLE_CYCLE, diag2.getIssueCode());
      EObject _sourceEObject_1 = diag2.getSourceEObject();
      Assert.assertEquals("var4", ((VarDefinition) _sourceEObject_1).getName());
      Assert.assertEquals("Cycle detected in the defined variables: var4 -> var1 -> var2 -> var3 -> var4", diag2.getMessage());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testNoDuplicatedVarDefinition() {
    try {
      final ValidatorTester<TargetPlatformValidator> tester = new ValidatorTester<TargetPlatformValidator>(this.validator, this.validatorRegistrar, this.languageName);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"compositeIncludeTarget\"");
      _builder.newLine();
      _builder.append("define twiceVar = \"val1\"");
      _builder.newLine();
      _builder.append("define otherVar = \"val\"");
      _builder.newLine();
      _builder.append("define twiceVar = \"val2\"");
      _builder.newLine();
      final TargetPlatform compositeIncludeTarget = this.parser.parse(_builder);
      Assert.assertTrue(compositeIncludeTarget.eResource().getErrors().isEmpty());
      tester.validator().checkNoDuplicatedDefine(compositeIncludeTarget);
      List<FeatureBasedDiagnostic> diagnostics = IterableExtensions.<FeatureBasedDiagnostic>toList(Iterables.<FeatureBasedDiagnostic>filter(tester.diagnose().getAllDiagnostics(), FeatureBasedDiagnostic.class));
      Assert.assertEquals(IterableExtensions.join(diagnostics, ", "), 1, diagnostics.size());
      Assert.assertEquals(TargetPlatformValidator.CHECK__NO_DUPLICATED_DEFINE, IterableExtensions.<FeatureBasedDiagnostic>head(diagnostics).getIssueCode());
      Assert.assertEquals(Diagnostic.WARNING, diagnostics.get(0).getSeverity());
      Assert.assertEquals("\"twiceVar\" is defined many times (it may be imported through many includes)", diagnostics.get(0).getMessage());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testNoDuplicatedVarDefinitionFromInclude() {
    try {
      final XtextResourceSet resourceSet = this.resourceSetProvider.get();
      final ValidatorTester<TargetPlatformValidator> tester = new ValidatorTester<TargetPlatformValidator>(this.validator, this.validatorRegistrar, this.languageName);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"compositeIncludeTarget\"");
      _builder.newLine();
      _builder.append("include \"subTpd1.tpd\"");
      _builder.newLine();
      _builder.append("include \"subTpd2.tpd\"");
      _builder.newLine();
      final TargetPlatform compositeIncludeTarget = this.parser.parse(_builder, URI.createURI("tmp:/compositeIncludeTarget.tpd"), resourceSet);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("target \"subTpd1\"");
      _builder_1.newLine();
      _builder_1.append("define twiceVar = \"val1\"");
      _builder_1.newLine();
      this.parser.parse(_builder_1, URI.createURI("tmp:/subTpd1.tpd"), resourceSet);
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("target \"subTpd2\"");
      _builder_2.newLine();
      _builder_2.append("define twiceVar = \"val2\"");
      _builder_2.newLine();
      this.parser.parse(_builder_2, URI.createURI("tmp:/subTpd2.tpd"), resourceSet);
      final ListMultimap<String, Location> locationIndex = this.indexBuilder.getLocationIndex(compositeIncludeTarget);
      Assert.assertEquals(0, locationIndex.size());
      Assert.assertTrue(compositeIncludeTarget.eResource().getErrors().isEmpty());
      tester.validator().checkNoDuplicatedDefine(compositeIncludeTarget);
      List<FeatureBasedDiagnostic> diagnostics = IterableExtensions.<FeatureBasedDiagnostic>toList(Iterables.<FeatureBasedDiagnostic>filter(tester.diagnose().getAllDiagnostics(), FeatureBasedDiagnostic.class));
      Assert.assertEquals(IterableExtensions.join(diagnostics, ", "), 1, diagnostics.size());
      Assert.assertEquals(TargetPlatformValidator.CHECK__NO_DUPLICATED_DEFINE, IterableExtensions.<FeatureBasedDiagnostic>head(diagnostics).getIssueCode());
      Assert.assertEquals(Diagnostic.WARNING, diagnostics.get(0).getSeverity());
      Assert.assertEquals("\"twiceVar\" is defined many times (it may be imported through many includes)", diagnostics.get(0).getMessage());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testNoDuplicatedVarDefinitionFromIncludeValueOverloaded() {
    try {
      final XtextResourceSet resourceSet = this.resourceSetProvider.get();
      final ValidatorTester<TargetPlatformValidator> tester = new ValidatorTester<TargetPlatformValidator>(this.validator, this.validatorRegistrar, this.languageName);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"compositeIncludeTarget\"");
      _builder.newLine();
      _builder.append("include \"subTpd1.tpd\"");
      _builder.newLine();
      _builder.append("define twiceVar = \"val\"");
      _builder.newLine();
      final TargetPlatform compositeIncludeTarget = this.parser.parse(_builder, URI.createURI("tmp:/compositeIncludeTarget.tpd"), resourceSet);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("target \"subTpd1\"");
      _builder_1.newLine();
      _builder_1.append("define twiceVar = \"val1\"");
      _builder_1.newLine();
      this.parser.parse(_builder_1, URI.createURI("tmp:/subTpd1.tpd"), resourceSet);
      final ListMultimap<String, Location> locationIndex = this.indexBuilder.getLocationIndex(compositeIncludeTarget);
      Assert.assertEquals(0, locationIndex.size());
      Assert.assertTrue(compositeIncludeTarget.eResource().getErrors().isEmpty());
      tester.validator().checkNoDuplicatedDefine(compositeIncludeTarget);
      List<FeatureBasedDiagnostic> diagnostics = IterableExtensions.<FeatureBasedDiagnostic>toList(Iterables.<FeatureBasedDiagnostic>filter(tester.diagnose().getAllDiagnostics(), FeatureBasedDiagnostic.class));
      Assert.assertEquals(IterableExtensions.join(diagnostics, ", "), 0, diagnostics.size());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
