package fr.obeo.releng.targetplatform.tests;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.name.Named;
import fr.obeo.releng.targetplatform.Environment;
import fr.obeo.releng.targetplatform.IU;
import fr.obeo.releng.targetplatform.IncludeDeclaration;
import fr.obeo.releng.targetplatform.Location;
import fr.obeo.releng.targetplatform.Option;
import fr.obeo.releng.targetplatform.Options;
import fr.obeo.releng.targetplatform.TargetContent;
import fr.obeo.releng.targetplatform.TargetPlatform;
import fr.obeo.releng.targetplatform.tests.util.CustomTargetPlatformInjectorProvider;
import fr.obeo.releng.targetplatform.validation.TargetPlatformValidator;
import java.util.List;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.Constants;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.junit4.util.ParseHelper;
import org.eclipse.xtext.junit4.validation.AssertableDiagnostics;
import org.eclipse.xtext.junit4.validation.ValidatorTester;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.validation.AbstractValidationDiagnostic;
import org.eclipse.xtext.validation.EValidatorRegistrar;
import org.eclipse.xtext.validation.FeatureBasedDiagnostic;
import org.eclipse.xtext.validation.RangeBasedDiagnostic;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@InjectWith(CustomTargetPlatformInjectorProvider.class)
@RunWith(XtextRunner.class)
@SuppressWarnings("all")
public class TestValidation {
  @Inject
  private ParseHelper<TargetPlatform> parser;
  
  @Inject
  private TargetPlatformValidator validator;
  
  @Inject
  private EValidatorRegistrar validatorRegistrar;
  
  @Inject
  private Provider<XtextResourceSet> resourceSetProvider;
  
  @Inject
  @Named(Constants.LANGUAGE_NAME)
  private String languageName;
  
  @Test
  public void checkAllEnvAndRequiredAreSelfExluding1() {
    try {
      final ValidatorTester<TargetPlatformValidator> tester = new ValidatorTester<TargetPlatformValidator>(this.validator, this.validatorRegistrar, this.languageName);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"a target platform\"");
      _builder.newLine();
      _builder.newLine();
      _builder.append("location \"my location URI\" {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("with source, allEnvironments, requirements, configurePhase");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("org.eclipse.emf.sdk.feature.group;version=\"[2.9.0,3.0.0)\"");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final TargetPlatform targetPlatform = this.parser.parse(_builder);
      Resource _eResource = targetPlatform.eResource();
      EList<Resource.Diagnostic> _errors = _eResource.getErrors();
      boolean _isEmpty = _errors.isEmpty();
      Assert.assertTrue(_isEmpty);
      EList<Location> _locations = targetPlatform.getLocations();
      final Location fisrtLocation = IterableExtensions.<Location>head(_locations);
      TargetPlatformValidator _validator = tester.validator();
      _validator.checkAllEnvAndRequiredAreSelfExluding(fisrtLocation);
      AssertableDiagnostics _diagnose = tester.diagnose();
      Iterable<Diagnostic> _allDiagnostics = _diagnose.getAllDiagnostics();
      Iterable<AbstractValidationDiagnostic> _filter = Iterables.<AbstractValidationDiagnostic>filter(_allDiagnostics, AbstractValidationDiagnostic.class);
      for (final AbstractValidationDiagnostic diag : _filter) {
        {
          EObject _sourceEObject = diag.getSourceEObject();
          Assert.assertTrue((_sourceEObject instanceof Location));
          EObject _sourceEObject_1 = diag.getSourceEObject();
          String _uri = ((Location) _sourceEObject_1).getUri();
          Assert.assertEquals("my location URI", _uri);
          String _issueCode = diag.getIssueCode();
          Assert.assertEquals(TargetPlatformValidator.CHECK__OPTIONS_SELF_EXCLUDING_ALL_ENV_REQUIRED, _issueCode);
        }
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void checkAllEnvAndRequiredAreSelfExluding2() {
    try {
      final ValidatorTester<TargetPlatformValidator> tester = new ValidatorTester<TargetPlatformValidator>(this.validator, this.validatorRegistrar, this.languageName);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"a target platform\"");
      _builder.newLine();
      _builder.append("with source, allEnvironments, requirements, configurePhase");
      _builder.newLine();
      _builder.newLine();
      _builder.append("location \"my location URI\" {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("org.eclipse.emf.sdk.feature.group;version=\"[2.9.0,3.0.0)\"");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final TargetPlatform targetPlatform = this.parser.parse(_builder);
      Resource _eResource = targetPlatform.eResource();
      EList<Resource.Diagnostic> _errors = _eResource.getErrors();
      boolean _isEmpty = _errors.isEmpty();
      Assert.assertTrue(_isEmpty);
      TargetPlatformValidator _validator = tester.validator();
      _validator.checkAllEnvAndRequiredAreSelfExluding(targetPlatform);
      AssertableDiagnostics _diagnose = tester.diagnose();
      Iterable<Diagnostic> _allDiagnostics = _diagnose.getAllDiagnostics();
      Iterable<AbstractValidationDiagnostic> _filter = Iterables.<AbstractValidationDiagnostic>filter(_allDiagnostics, AbstractValidationDiagnostic.class);
      for (final AbstractValidationDiagnostic diag : _filter) {
        {
          EObject _sourceEObject = diag.getSourceEObject();
          Assert.assertTrue((_sourceEObject instanceof Options));
          String _issueCode = diag.getIssueCode();
          Assert.assertEquals(TargetPlatformValidator.CHECK__OPTIONS_SELF_EXCLUDING_ALL_ENV_REQUIRED, _issueCode);
        }
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void checkAllEnvAndRequiredAreSelfExluding3() {
    try {
      final ValidatorTester<TargetPlatformValidator> tester = new ValidatorTester<TargetPlatformValidator>(this.validator, this.validatorRegistrar, this.languageName);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"a target platform\"");
      _builder.newLine();
      _builder.append("with requirements allEnvironments");
      _builder.newLine();
      _builder.append("with source ");
      _builder.newLine();
      final TargetPlatform targetPlatform = this.parser.parse(_builder);
      Resource _eResource = targetPlatform.eResource();
      EList<Resource.Diagnostic> _errors = _eResource.getErrors();
      boolean _isEmpty = _errors.isEmpty();
      Assert.assertTrue(_isEmpty);
      TargetPlatformValidator _validator = tester.validator();
      _validator.checkAllEnvAndRequiredAreSelfExluding(targetPlatform);
      AssertableDiagnostics _diagnose = tester.diagnose();
      final Iterable<Diagnostic> diag = _diagnose.getAllDiagnostics();
      int _size = IterableExtensions.size(diag);
      Assert.assertEquals(2, _size);
      Iterable<AbstractValidationDiagnostic> _filter = Iterables.<AbstractValidationDiagnostic>filter(diag, AbstractValidationDiagnostic.class);
      final Procedure1<AbstractValidationDiagnostic> _function = new Procedure1<AbstractValidationDiagnostic>() {
        public void apply(final AbstractValidationDiagnostic it) {
          EObject _sourceEObject = it.getSourceEObject();
          Assert.assertTrue((_sourceEObject instanceof Options));
          String _issueCode = it.getIssueCode();
          Assert.assertEquals(TargetPlatformValidator.CHECK__OPTIONS_SELF_EXCLUDING_ALL_ENV_REQUIRED, _issueCode);
        }
      };
      IterableExtensions.<AbstractValidationDiagnostic>forEach(_filter, _function);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void checkNoDuplicateOptionsOptions1() {
    try {
      final ValidatorTester<TargetPlatformValidator> tester = new ValidatorTester<TargetPlatformValidator>(this.validator, this.validatorRegistrar, this.languageName);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"a target platform\"");
      _builder.newLine();
      _builder.append("with source configurePhase source");
      _builder.newLine();
      final TargetPlatform targetPlatform = this.parser.parse(_builder);
      Resource _eResource = targetPlatform.eResource();
      EList<Resource.Diagnostic> _errors = _eResource.getErrors();
      boolean _isEmpty = _errors.isEmpty();
      Assert.assertTrue(_isEmpty);
      TargetPlatformValidator _validator = tester.validator();
      _validator.checkNoDuplicateOptions(targetPlatform);
      AssertableDiagnostics _diagnose = tester.diagnose();
      Iterable<Diagnostic> _allDiagnostics = _diagnose.getAllDiagnostics();
      Iterable<FeatureBasedDiagnostic> _filter = Iterables.<FeatureBasedDiagnostic>filter(_allDiagnostics, FeatureBasedDiagnostic.class);
      final List<FeatureBasedDiagnostic> diagnostics = IterableExtensions.<FeatureBasedDiagnostic>toList(_filter);
      String _join = IterableExtensions.join(diagnostics, ", ");
      int _size = diagnostics.size();
      Assert.assertEquals(_join, 2, _size);
      FeatureBasedDiagnostic _get = diagnostics.get(0);
      EObject _sourceEObject = _get.getSourceEObject();
      FeatureBasedDiagnostic _get_1 = diagnostics.get(0);
      EStructuralFeature _feature = _get_1.getFeature();
      Object _eGet = _sourceEObject.eGet(_feature);
      FeatureBasedDiagnostic _get_2 = diagnostics.get(0);
      int _index = _get_2.getIndex();
      Object _get_3 = ((List<?>) _eGet).get(_index);
      Assert.assertEquals(Option.INCLUDE_SOURCE, _get_3);
      FeatureBasedDiagnostic _get_4 = diagnostics.get(1);
      EObject _sourceEObject_1 = _get_4.getSourceEObject();
      FeatureBasedDiagnostic _get_5 = diagnostics.get(1);
      EStructuralFeature _feature_1 = _get_5.getFeature();
      Object _eGet_1 = _sourceEObject_1.eGet(_feature_1);
      FeatureBasedDiagnostic _get_6 = diagnostics.get(1);
      int _index_1 = _get_6.getIndex();
      Object _get_7 = ((List<?>) _eGet_1).get(_index_1);
      Assert.assertEquals(Option.INCLUDE_SOURCE, _get_7);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void checkNoDuplicateOptionsOptions2() {
    try {
      final ValidatorTester<TargetPlatformValidator> tester = new ValidatorTester<TargetPlatformValidator>(this.validator, this.validatorRegistrar, this.languageName);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"a target platform\"");
      _builder.newLine();
      _builder.append("with source configurePhase");
      _builder.newLine();
      _builder.append("with configurePhase");
      _builder.newLine();
      final TargetPlatform targetPlatform = this.parser.parse(_builder);
      Resource _eResource = targetPlatform.eResource();
      EList<Resource.Diagnostic> _errors = _eResource.getErrors();
      boolean _isEmpty = _errors.isEmpty();
      Assert.assertTrue(_isEmpty);
      TargetPlatformValidator _validator = tester.validator();
      _validator.checkNoDuplicateOptions(targetPlatform);
      AssertableDiagnostics _diagnose = tester.diagnose();
      Iterable<Diagnostic> _allDiagnostics = _diagnose.getAllDiagnostics();
      Iterable<FeatureBasedDiagnostic> _filter = Iterables.<FeatureBasedDiagnostic>filter(_allDiagnostics, FeatureBasedDiagnostic.class);
      final List<FeatureBasedDiagnostic> diagnostics = IterableExtensions.<FeatureBasedDiagnostic>toList(_filter);
      String _join = IterableExtensions.join(diagnostics, ", ");
      int _size = diagnostics.size();
      Assert.assertEquals(_join, 2, _size);
      EList<TargetContent> _contents = targetPlatform.getContents();
      TargetContent _get = _contents.get(0);
      FeatureBasedDiagnostic _get_1 = diagnostics.get(0);
      EObject _sourceEObject = _get_1.getSourceEObject();
      Assert.assertEquals(_get, _sourceEObject);
      FeatureBasedDiagnostic _get_2 = diagnostics.get(0);
      EObject _sourceEObject_1 = _get_2.getSourceEObject();
      FeatureBasedDiagnostic _get_3 = diagnostics.get(0);
      EStructuralFeature _feature = _get_3.getFeature();
      Object _eGet = _sourceEObject_1.eGet(_feature);
      FeatureBasedDiagnostic _get_4 = diagnostics.get(0);
      int _index = _get_4.getIndex();
      Object _get_5 = ((List<?>) _eGet).get(_index);
      Assert.assertEquals(Option.INCLUDE_CONFIGURE_PHASE, _get_5);
      EList<TargetContent> _contents_1 = targetPlatform.getContents();
      TargetContent _get_6 = _contents_1.get(1);
      FeatureBasedDiagnostic _get_7 = diagnostics.get(1);
      EObject _sourceEObject_2 = _get_7.getSourceEObject();
      Assert.assertEquals(_get_6, _sourceEObject_2);
      FeatureBasedDiagnostic _get_8 = diagnostics.get(1);
      EObject _sourceEObject_3 = _get_8.getSourceEObject();
      FeatureBasedDiagnostic _get_9 = diagnostics.get(1);
      EStructuralFeature _feature_1 = _get_9.getFeature();
      Object _eGet_1 = _sourceEObject_3.eGet(_feature_1);
      FeatureBasedDiagnostic _get_10 = diagnostics.get(1);
      int _index_1 = _get_10.getIndex();
      Object _get_11 = ((List<?>) _eGet_1).get(_index_1);
      Assert.assertEquals(Option.INCLUDE_CONFIGURE_PHASE, _get_11);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testcheckIDUniqueOnAllLocations1() {
    try {
      final ValidatorTester<TargetPlatformValidator> tester = new ValidatorTester<TargetPlatformValidator>(this.validator, this.validatorRegistrar, this.languageName);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"a target platform\"");
      _builder.newLine();
      _builder.append("location \"mylocationURI\"");
      _builder.newLine();
      _builder.append("location \"mylocationURI2\"");
      _builder.newLine();
      final TargetPlatform targetPlatform = this.parser.parse(_builder);
      Resource _eResource = targetPlatform.eResource();
      EList<Resource.Diagnostic> _errors = _eResource.getErrors();
      boolean _isEmpty = _errors.isEmpty();
      Assert.assertTrue(_isEmpty);
      TargetPlatformValidator _validator = tester.validator();
      _validator.checkIDUniqueOnAllLocations(targetPlatform);
      AssertableDiagnostics _diagnose = tester.diagnose();
      Iterable<Diagnostic> _allDiagnostics = _diagnose.getAllDiagnostics();
      boolean _isEmpty_1 = IterableExtensions.isEmpty(_allDiagnostics);
      Assert.assertTrue(_isEmpty_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testcheckIDUniqueOnAllLocations2() {
    try {
      final ValidatorTester<TargetPlatformValidator> tester = new ValidatorTester<TargetPlatformValidator>(this.validator, this.validatorRegistrar, this.languageName);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"a target platform\"");
      _builder.newLine();
      _builder.append("location A \"mylocationURI\"");
      _builder.newLine();
      _builder.append("location A \"mylocationURI2\"");
      _builder.newLine();
      final TargetPlatform targetPlatform = this.parser.parse(_builder);
      Resource _eResource = targetPlatform.eResource();
      EList<Resource.Diagnostic> _errors = _eResource.getErrors();
      boolean _isEmpty = _errors.isEmpty();
      Assert.assertTrue(_isEmpty);
      TargetPlatformValidator _validator = tester.validator();
      _validator.checkIDUniqueOnAllLocations(targetPlatform);
      AssertableDiagnostics _diagnose = tester.diagnose();
      Iterable<Diagnostic> _allDiagnostics = _diagnose.getAllDiagnostics();
      Iterable<AbstractValidationDiagnostic> _filter = Iterables.<AbstractValidationDiagnostic>filter(_allDiagnostics, AbstractValidationDiagnostic.class);
      final List<AbstractValidationDiagnostic> diagnotics = IterableExtensions.<AbstractValidationDiagnostic>toList(_filter);
      int _size = diagnotics.size();
      Assert.assertEquals(2, _size);
      final Function1<AbstractValidationDiagnostic, Boolean> _function = new Function1<AbstractValidationDiagnostic, Boolean>() {
        public Boolean apply(final AbstractValidationDiagnostic it) {
          EObject _sourceEObject = it.getSourceEObject();
          return Boolean.valueOf((_sourceEObject instanceof Location));
        }
      };
      boolean _forall = IterableExtensions.<AbstractValidationDiagnostic>forall(diagnotics, _function);
      Assert.assertTrue(_forall);
      final Procedure1<AbstractValidationDiagnostic> _function_1 = new Procedure1<AbstractValidationDiagnostic>() {
        public void apply(final AbstractValidationDiagnostic it) {
          String _issueCode = it.getIssueCode();
          Assert.assertEquals(TargetPlatformValidator.CHECK__LOCATION_ID_UNIQNESS, _issueCode);
        }
      };
      IterableExtensions.<AbstractValidationDiagnostic>forEach(diagnotics, _function_1);
      AbstractValidationDiagnostic _get = diagnotics.get(0);
      EObject _sourceEObject = _get.getSourceEObject();
      String _uri = ((Location) _sourceEObject).getUri();
      Assert.assertEquals("mylocationURI2", _uri);
      AbstractValidationDiagnostic _get_1 = diagnotics.get(1);
      EObject _sourceEObject_1 = _get_1.getSourceEObject();
      String _uri_1 = ((Location) _sourceEObject_1).getUri();
      Assert.assertEquals("mylocationURI", _uri_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testcheckIDUniqueOnAllLocations3() {
    try {
      final ValidatorTester<TargetPlatformValidator> tester = new ValidatorTester<TargetPlatformValidator>(this.validator, this.validatorRegistrar, this.languageName);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"a target platform\"");
      _builder.newLine();
      _builder.append("location A \"mylocationURI\"");
      _builder.newLine();
      _builder.append("location A \"mylocationURI2\"");
      _builder.newLine();
      _builder.append("location \"mylocationURI3\"");
      _builder.newLine();
      final TargetPlatform targetPlatform = this.parser.parse(_builder);
      Resource _eResource = targetPlatform.eResource();
      EList<Resource.Diagnostic> _errors = _eResource.getErrors();
      boolean _isEmpty = _errors.isEmpty();
      Assert.assertTrue(_isEmpty);
      TargetPlatformValidator _validator = tester.validator();
      _validator.checkIDUniqueOnAllLocations(targetPlatform);
      AssertableDiagnostics _diagnose = tester.diagnose();
      Iterable<Diagnostic> _allDiagnostics = _diagnose.getAllDiagnostics();
      Iterable<AbstractValidationDiagnostic> _filter = Iterables.<AbstractValidationDiagnostic>filter(_allDiagnostics, AbstractValidationDiagnostic.class);
      final List<AbstractValidationDiagnostic> diagnotics = IterableExtensions.<AbstractValidationDiagnostic>toList(_filter);
      int _size = diagnotics.size();
      Assert.assertEquals(2, _size);
      final Function1<AbstractValidationDiagnostic, Boolean> _function = new Function1<AbstractValidationDiagnostic, Boolean>() {
        public Boolean apply(final AbstractValidationDiagnostic it) {
          EObject _sourceEObject = it.getSourceEObject();
          return Boolean.valueOf((_sourceEObject instanceof Location));
        }
      };
      boolean _forall = IterableExtensions.<AbstractValidationDiagnostic>forall(diagnotics, _function);
      Assert.assertTrue(_forall);
      final Procedure1<AbstractValidationDiagnostic> _function_1 = new Procedure1<AbstractValidationDiagnostic>() {
        public void apply(final AbstractValidationDiagnostic it) {
          String _issueCode = it.getIssueCode();
          Assert.assertEquals(TargetPlatformValidator.CHECK__LOCATION_ID_UNIQNESS, _issueCode);
        }
      };
      IterableExtensions.<AbstractValidationDiagnostic>forEach(diagnotics, _function_1);
      AbstractValidationDiagnostic _get = diagnotics.get(0);
      EObject _sourceEObject = _get.getSourceEObject();
      String _uri = ((Location) _sourceEObject).getUri();
      Assert.assertEquals("mylocationURI2", _uri);
      AbstractValidationDiagnostic _get_1 = diagnotics.get(1);
      EObject _sourceEObject_1 = _get_1.getSourceEObject();
      String _uri_1 = ((Location) _sourceEObject_1).getUri();
      Assert.assertEquals("mylocationURI", _uri_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testcheckIDUniqueOnAllLocations4() {
    try {
      final ValidatorTester<TargetPlatformValidator> tester = new ValidatorTester<TargetPlatformValidator>(this.validator, this.validatorRegistrar, this.languageName);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"a target platform\"");
      _builder.newLine();
      _builder.append("location A \"mylocationURI\"");
      _builder.newLine();
      _builder.append("location B \"mylocationURI\"");
      _builder.newLine();
      final TargetPlatform targetPlatform = this.parser.parse(_builder);
      Resource _eResource = targetPlatform.eResource();
      EList<Resource.Diagnostic> _errors = _eResource.getErrors();
      boolean _isEmpty = _errors.isEmpty();
      Assert.assertTrue(_isEmpty);
      TargetPlatformValidator _validator = tester.validator();
      _validator.checkIDUniqueOnAllLocations(targetPlatform);
      AssertableDiagnostics _diagnose = tester.diagnose();
      Iterable<Diagnostic> _allDiagnostics = _diagnose.getAllDiagnostics();
      Iterable<AbstractValidationDiagnostic> _filter = Iterables.<AbstractValidationDiagnostic>filter(_allDiagnostics, AbstractValidationDiagnostic.class);
      final List<AbstractValidationDiagnostic> diagnotics = IterableExtensions.<AbstractValidationDiagnostic>toList(_filter);
      int _size = diagnotics.size();
      Assert.assertEquals(0, _size);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testcheckIDUniqueOnAllLocations5() {
    try {
      final ValidatorTester<TargetPlatformValidator> tester = new ValidatorTester<TargetPlatformValidator>(this.validator, this.validatorRegistrar, this.languageName);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"a target platform\"");
      _builder.newLine();
      _builder.append("location A \"mylocationURI\"");
      _builder.newLine();
      _builder.append("location \"mylocationURI\"");
      _builder.newLine();
      final TargetPlatform targetPlatform = this.parser.parse(_builder);
      Resource _eResource = targetPlatform.eResource();
      EList<Resource.Diagnostic> _errors = _eResource.getErrors();
      boolean _isEmpty = _errors.isEmpty();
      Assert.assertTrue(_isEmpty);
      TargetPlatformValidator _validator = tester.validator();
      _validator.checkIDUniqueOnAllLocations(targetPlatform);
      AssertableDiagnostics _diagnose = tester.diagnose();
      Iterable<Diagnostic> _allDiagnostics = _diagnose.getAllDiagnostics();
      Iterable<AbstractValidationDiagnostic> _filter = Iterables.<AbstractValidationDiagnostic>filter(_allDiagnostics, AbstractValidationDiagnostic.class);
      final List<AbstractValidationDiagnostic> diagnotics = IterableExtensions.<AbstractValidationDiagnostic>toList(_filter);
      int _size = diagnotics.size();
      Assert.assertEquals(0, _size);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testcheckIDUniqueOnAllLocations6() {
    try {
      final ValidatorTester<TargetPlatformValidator> tester = new ValidatorTester<TargetPlatformValidator>(this.validator, this.validatorRegistrar, this.languageName);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"a target platform\"");
      _builder.newLine();
      _builder.append("location \"mylocationURI\"");
      _builder.newLine();
      _builder.append("location \"mylocationURI\"");
      _builder.newLine();
      final TargetPlatform targetPlatform = this.parser.parse(_builder);
      Resource _eResource = targetPlatform.eResource();
      EList<Resource.Diagnostic> _errors = _eResource.getErrors();
      boolean _isEmpty = _errors.isEmpty();
      Assert.assertTrue(_isEmpty);
      TargetPlatformValidator _validator = tester.validator();
      _validator.checkIDUniqueOnAllLocations(targetPlatform);
      AssertableDiagnostics _diagnose = tester.diagnose();
      Iterable<Diagnostic> _allDiagnostics = _diagnose.getAllDiagnostics();
      Iterable<AbstractValidationDiagnostic> _filter = Iterables.<AbstractValidationDiagnostic>filter(_allDiagnostics, AbstractValidationDiagnostic.class);
      final List<AbstractValidationDiagnostic> diagnotics = IterableExtensions.<AbstractValidationDiagnostic>toList(_filter);
      int _size = diagnotics.size();
      Assert.assertEquals(0, _size);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testcheckIDUniqueOnAllLocations7() {
    try {
      final ValidatorTester<TargetPlatformValidator> tester = new ValidatorTester<TargetPlatformValidator>(this.validator, this.validatorRegistrar, this.languageName);
      final XtextResourceSet resourceSet = this.resourceSetProvider.get();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"tp.a\"");
      _builder.newLine();
      _builder.append("include \"b.tpd\"");
      _builder.newLine();
      _builder.append("location \"locationURI1\"");
      _builder.newLine();
      URI _createURI = URI.createURI("tmp:/a.tpd");
      final TargetPlatform tpa = this.parser.parse(_builder, _createURI, resourceSet);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("target \"tp.b\"");
      _builder_1.newLine();
      _builder_1.append("location \"locationURI1\"");
      _builder_1.newLine();
      URI _createURI_1 = URI.createURI("tmp:/b.tpd");
      this.parser.parse(_builder_1, _createURI_1, resourceSet);
      Resource _eResource = tpa.eResource();
      EList<Resource.Diagnostic> _errors = _eResource.getErrors();
      boolean _isEmpty = _errors.isEmpty();
      Assert.assertTrue(_isEmpty);
      TargetPlatformValidator _validator = tester.validator();
      _validator.checkIDUniqueOnAllLocations(tpa);
      AssertableDiagnostics _diagnose = tester.diagnose();
      Iterable<Diagnostic> _allDiagnostics = _diagnose.getAllDiagnostics();
      Iterable<AbstractValidationDiagnostic> _filter = Iterables.<AbstractValidationDiagnostic>filter(_allDiagnostics, AbstractValidationDiagnostic.class);
      List<AbstractValidationDiagnostic> diagnotics = IterableExtensions.<AbstractValidationDiagnostic>toList(_filter);
      int _size = diagnotics.size();
      Assert.assertEquals(0, _size);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testcheckIDUniqueOnAllLocations8() {
    try {
      final ValidatorTester<TargetPlatformValidator> tester = new ValidatorTester<TargetPlatformValidator>(this.validator, this.validatorRegistrar, this.languageName);
      final XtextResourceSet resourceSet = this.resourceSetProvider.get();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"tp.a\"");
      _builder.newLine();
      _builder.append("include \"b.tpd\"");
      _builder.newLine();
      _builder.append("location A \"locationURI1\"");
      _builder.newLine();
      URI _createURI = URI.createURI("tmp:/a.tpd");
      final TargetPlatform tpa = this.parser.parse(_builder, _createURI, resourceSet);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("target \"tp.b\"");
      _builder_1.newLine();
      _builder_1.append("location A \"locationURI2\"");
      _builder_1.newLine();
      URI _createURI_1 = URI.createURI("tmp:/b.tpd");
      final TargetPlatform tpb = this.parser.parse(_builder_1, _createURI_1, resourceSet);
      Resource _eResource = tpa.eResource();
      EList<Resource.Diagnostic> _errors = _eResource.getErrors();
      boolean _isEmpty = _errors.isEmpty();
      Assert.assertTrue(_isEmpty);
      TargetPlatformValidator _validator = tester.validator();
      _validator.checkIDUniqueOnAllLocations(tpa);
      AssertableDiagnostics _diagnose = tester.diagnose();
      Iterable<Diagnostic> _allDiagnostics = _diagnose.getAllDiagnostics();
      Iterable<AbstractValidationDiagnostic> _filter = Iterables.<AbstractValidationDiagnostic>filter(_allDiagnostics, AbstractValidationDiagnostic.class);
      List<AbstractValidationDiagnostic> diagnotics = IterableExtensions.<AbstractValidationDiagnostic>toList(_filter);
      int _size = diagnotics.size();
      Assert.assertEquals(2, _size);
      AbstractValidationDiagnostic _get = diagnotics.get(0);
      EObject _sourceEObject = _get.getSourceEObject();
      Assert.assertTrue((_sourceEObject instanceof Location));
      AbstractValidationDiagnostic _get_1 = diagnotics.get(0);
      String _issueCode = _get_1.getIssueCode();
      Assert.assertEquals(TargetPlatformValidator.CHECK__LOCATION_ID_UNIQNESS, _issueCode);
      AbstractValidationDiagnostic _get_2 = diagnotics.get(0);
      EObject _sourceEObject_1 = _get_2.getSourceEObject();
      String _uri = ((Location) _sourceEObject_1).getUri();
      Assert.assertEquals("locationURI1", _uri);
      AbstractValidationDiagnostic _get_3 = diagnotics.get(1);
      EObject _sourceEObject_2 = _get_3.getSourceEObject();
      Assert.assertTrue((_sourceEObject_2 instanceof IncludeDeclaration));
      AbstractValidationDiagnostic _get_4 = diagnotics.get(1);
      String _issueCode_1 = _get_4.getIssueCode();
      Assert.assertEquals(TargetPlatformValidator.CHECK__LOCATION_ID_UNIQNESS, _issueCode_1);
      AbstractValidationDiagnostic _get_5 = diagnotics.get(1);
      EObject _sourceEObject_3 = _get_5.getSourceEObject();
      String _importURI = ((IncludeDeclaration) _sourceEObject_3).getImportURI();
      Assert.assertEquals("b.tpd", _importURI);
      Resource _eResource_1 = tpb.eResource();
      EList<Resource.Diagnostic> _errors_1 = _eResource_1.getErrors();
      boolean _isEmpty_1 = _errors_1.isEmpty();
      Assert.assertTrue(_isEmpty_1);
      TargetPlatformValidator _validator_1 = tester.validator();
      _validator_1.checkIDUniqueOnAllLocations(tpb);
      AssertableDiagnostics _diagnose_1 = tester.diagnose();
      Iterable<Diagnostic> _allDiagnostics_1 = _diagnose_1.getAllDiagnostics();
      Iterable<AbstractValidationDiagnostic> _filter_1 = Iterables.<AbstractValidationDiagnostic>filter(_allDiagnostics_1, AbstractValidationDiagnostic.class);
      List<AbstractValidationDiagnostic> _list = IterableExtensions.<AbstractValidationDiagnostic>toList(_filter_1);
      diagnotics = _list;
      int _size_1 = diagnotics.size();
      Assert.assertEquals(0, _size_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testcheckIDUniqueOnAllLocations9() {
    try {
      final ValidatorTester<TargetPlatformValidator> tester = new ValidatorTester<TargetPlatformValidator>(this.validator, this.validatorRegistrar, this.languageName);
      final XtextResourceSet resourceSet = this.resourceSetProvider.get();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"tp.a\"");
      _builder.newLine();
      _builder.append("include \"b.tpd\"");
      _builder.newLine();
      _builder.append("location A \"locationURI1\"");
      _builder.newLine();
      URI _createURI = URI.createURI("tmp:/a.tpd");
      final TargetPlatform tpa = this.parser.parse(_builder, _createURI, resourceSet);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("target \"tp.b\"");
      _builder_1.newLine();
      _builder_1.append("location A \"locationURI1\"");
      _builder_1.newLine();
      URI _createURI_1 = URI.createURI("tmp:/b.tpd");
      final TargetPlatform tpb = this.parser.parse(_builder_1, _createURI_1, resourceSet);
      Resource _eResource = tpa.eResource();
      EList<Resource.Diagnostic> _errors = _eResource.getErrors();
      boolean _isEmpty = _errors.isEmpty();
      Assert.assertTrue(_isEmpty);
      TargetPlatformValidator _validator = tester.validator();
      _validator.checkIDUniqueOnAllLocations(tpa);
      AssertableDiagnostics _diagnose = tester.diagnose();
      Iterable<Diagnostic> _allDiagnostics = _diagnose.getAllDiagnostics();
      Iterable<AbstractValidationDiagnostic> _filter = Iterables.<AbstractValidationDiagnostic>filter(_allDiagnostics, AbstractValidationDiagnostic.class);
      List<AbstractValidationDiagnostic> diagnotics = IterableExtensions.<AbstractValidationDiagnostic>toList(_filter);
      int _size = diagnotics.size();
      Assert.assertEquals(0, _size);
      Resource _eResource_1 = tpb.eResource();
      EList<Resource.Diagnostic> _errors_1 = _eResource_1.getErrors();
      boolean _isEmpty_1 = _errors_1.isEmpty();
      Assert.assertTrue(_isEmpty_1);
      TargetPlatformValidator _validator_1 = tester.validator();
      _validator_1.checkIDUniqueOnAllLocations(tpb);
      AssertableDiagnostics _diagnose_1 = tester.diagnose();
      Iterable<Diagnostic> _allDiagnostics_1 = _diagnose_1.getAllDiagnostics();
      Iterable<AbstractValidationDiagnostic> _filter_1 = Iterables.<AbstractValidationDiagnostic>filter(_allDiagnostics_1, AbstractValidationDiagnostic.class);
      List<AbstractValidationDiagnostic> _list = IterableExtensions.<AbstractValidationDiagnostic>toList(_filter_1);
      diagnotics = _list;
      int _size_1 = diagnotics.size();
      Assert.assertEquals(0, _size_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testcheckIDUniqueOnAllLocations10() {
    try {
      final ValidatorTester<TargetPlatformValidator> tester = new ValidatorTester<TargetPlatformValidator>(this.validator, this.validatorRegistrar, this.languageName);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"a target platform\"");
      _builder.newLine();
      _builder.append("location A \"mylocationURI\"");
      _builder.newLine();
      _builder.append("location A \"mylocationURI\"");
      _builder.newLine();
      final TargetPlatform targetPlatform = this.parser.parse(_builder);
      Resource _eResource = targetPlatform.eResource();
      EList<Resource.Diagnostic> _errors = _eResource.getErrors();
      boolean _isEmpty = _errors.isEmpty();
      Assert.assertTrue(_isEmpty);
      TargetPlatformValidator _validator = tester.validator();
      _validator.checkIDUniqueOnAllLocations(targetPlatform);
      AssertableDiagnostics _diagnose = tester.diagnose();
      Iterable<Diagnostic> _allDiagnostics = _diagnose.getAllDiagnostics();
      Iterable<AbstractValidationDiagnostic> _filter = Iterables.<AbstractValidationDiagnostic>filter(_allDiagnostics, AbstractValidationDiagnostic.class);
      final List<AbstractValidationDiagnostic> diagnotics = IterableExtensions.<AbstractValidationDiagnostic>toList(_filter);
      int _size = diagnotics.size();
      Assert.assertEquals(0, _size);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void checkNoLocationOptionIfGlobalOptions1() {
    try {
      final ValidatorTester<TargetPlatformValidator> tester = new ValidatorTester<TargetPlatformValidator>(this.validator, this.validatorRegistrar, this.languageName);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"a target platform\"");
      _builder.newLine();
      _builder.append("with source");
      _builder.newLine();
      _builder.append("location \"mylocationURI1\" {with source}");
      _builder.newLine();
      final TargetPlatform targetPlatform = this.parser.parse(_builder);
      Resource _eResource = targetPlatform.eResource();
      EList<Resource.Diagnostic> _errors = _eResource.getErrors();
      boolean _isEmpty = _errors.isEmpty();
      Assert.assertTrue(_isEmpty);
      TargetPlatformValidator _validator = tester.validator();
      EList<Location> _locations = targetPlatform.getLocations();
      Location _head = IterableExtensions.<Location>head(_locations);
      _validator.checkNoLocationOptionIfGlobalOptions(_head);
      AssertableDiagnostics _diagnose = tester.diagnose();
      Iterable<Diagnostic> _allDiagnostics = _diagnose.getAllDiagnostics();
      Iterable<AbstractValidationDiagnostic> _filter = Iterables.<AbstractValidationDiagnostic>filter(_allDiagnostics, AbstractValidationDiagnostic.class);
      final List<AbstractValidationDiagnostic> diagnotics = IterableExtensions.<AbstractValidationDiagnostic>toList(_filter);
      final Function1<AbstractValidationDiagnostic, Boolean> _function = new Function1<AbstractValidationDiagnostic, Boolean>() {
        public Boolean apply(final AbstractValidationDiagnostic it) {
          EObject _sourceEObject = it.getSourceEObject();
          return Boolean.valueOf((_sourceEObject instanceof Location));
        }
      };
      boolean _forall = IterableExtensions.<AbstractValidationDiagnostic>forall(diagnotics, _function);
      Assert.assertTrue(_forall);
      final Procedure1<AbstractValidationDiagnostic> _function_1 = new Procedure1<AbstractValidationDiagnostic>() {
        public void apply(final AbstractValidationDiagnostic it) {
          String _issueCode = it.getIssueCode();
          Assert.assertEquals(TargetPlatformValidator.CHECK__NO_OPTIONS_ON_LOCATIONS_IF_GLOBAL_OPTIONS, _issueCode);
        }
      };
      IterableExtensions.<AbstractValidationDiagnostic>forEach(diagnotics, _function_1);
      AbstractValidationDiagnostic _get = diagnotics.get(0);
      EObject _sourceEObject = _get.getSourceEObject();
      String _uri = ((Location) _sourceEObject).getUri();
      Assert.assertEquals("mylocationURI1", _uri);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void checkNoLocationOptionIfGlobalOptions2() {
    try {
      final ValidatorTester<TargetPlatformValidator> tester = new ValidatorTester<TargetPlatformValidator>(this.validator, this.validatorRegistrar, this.languageName);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"a target platform\"");
      _builder.newLine();
      _builder.append("with source");
      _builder.newLine();
      _builder.append("location \"mylocationURI1\"");
      _builder.newLine();
      final TargetPlatform targetPlatform = this.parser.parse(_builder);
      Resource _eResource = targetPlatform.eResource();
      EList<Resource.Diagnostic> _errors = _eResource.getErrors();
      boolean _isEmpty = _errors.isEmpty();
      Assert.assertTrue(_isEmpty);
      TargetPlatformValidator _validator = tester.validator();
      EList<Location> _locations = targetPlatform.getLocations();
      Location _head = IterableExtensions.<Location>head(_locations);
      _validator.checkNoLocationOptionIfGlobalOptions(_head);
      AssertableDiagnostics _diagnose = tester.diagnose();
      Iterable<Diagnostic> _allDiagnostics = _diagnose.getAllDiagnostics();
      Iterable<AbstractValidationDiagnostic> _filter = Iterables.<AbstractValidationDiagnostic>filter(_allDiagnostics, AbstractValidationDiagnostic.class);
      final List<AbstractValidationDiagnostic> diagnotics = IterableExtensions.<AbstractValidationDiagnostic>toList(_filter);
      int _size = diagnotics.size();
      Assert.assertEquals(0, _size);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void checkNoLocationOptionIfGlobalOptions3() {
    try {
      final ValidatorTester<TargetPlatformValidator> tester = new ValidatorTester<TargetPlatformValidator>(this.validator, this.validatorRegistrar, this.languageName);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"a target platform\"");
      _builder.newLine();
      _builder.append("with source");
      _builder.newLine();
      _builder.append("location \"mylocationURI1\" {with source}");
      _builder.newLine();
      final TargetPlatform targetPlatform = this.parser.parse(_builder);
      Resource _eResource = targetPlatform.eResource();
      EList<Resource.Diagnostic> _errors = _eResource.getErrors();
      boolean _isEmpty = _errors.isEmpty();
      Assert.assertTrue(_isEmpty);
      TargetPlatformValidator _validator = tester.validator();
      EList<Location> _locations = targetPlatform.getLocations();
      Location _head = IterableExtensions.<Location>head(_locations);
      _validator.checkNoLocationOptionIfGlobalOptions(_head);
      AssertableDiagnostics _diagnose = tester.diagnose();
      Iterable<Diagnostic> _allDiagnostics = _diagnose.getAllDiagnostics();
      Iterable<AbstractValidationDiagnostic> _filter = Iterables.<AbstractValidationDiagnostic>filter(_allDiagnostics, AbstractValidationDiagnostic.class);
      final List<AbstractValidationDiagnostic> diagnotics = IterableExtensions.<AbstractValidationDiagnostic>toList(_filter);
      final Function1<AbstractValidationDiagnostic, Boolean> _function = new Function1<AbstractValidationDiagnostic, Boolean>() {
        public Boolean apply(final AbstractValidationDiagnostic it) {
          EObject _sourceEObject = it.getSourceEObject();
          return Boolean.valueOf((_sourceEObject instanceof Location));
        }
      };
      boolean _forall = IterableExtensions.<AbstractValidationDiagnostic>forall(diagnotics, _function);
      Assert.assertTrue(_forall);
      final Procedure1<AbstractValidationDiagnostic> _function_1 = new Procedure1<AbstractValidationDiagnostic>() {
        public void apply(final AbstractValidationDiagnostic it) {
          String _issueCode = it.getIssueCode();
          Assert.assertEquals(TargetPlatformValidator.CHECK__NO_OPTIONS_ON_LOCATIONS_IF_GLOBAL_OPTIONS, _issueCode);
        }
      };
      IterableExtensions.<AbstractValidationDiagnostic>forEach(diagnotics, _function_1);
      AbstractValidationDiagnostic _head_1 = IterableExtensions.<AbstractValidationDiagnostic>head(diagnotics);
      EObject _sourceEObject = _head_1.getSourceEObject();
      String _uri = ((Location) _sourceEObject).getUri();
      Assert.assertEquals("mylocationURI1", _uri);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void checkOptionsOnLocationAreIdentical1() {
    try {
      final ValidatorTester<TargetPlatformValidator> tester = new ValidatorTester<TargetPlatformValidator>(this.validator, this.validatorRegistrar, this.languageName);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"a target platform\"");
      _builder.newLine();
      _builder.append("location \"mylocationURI1\"");
      _builder.newLine();
      _builder.append("location \"mylocationURI1\"");
      _builder.newLine();
      final TargetPlatform targetPlatform = this.parser.parse(_builder);
      Resource _eResource = targetPlatform.eResource();
      EList<Resource.Diagnostic> _errors = _eResource.getErrors();
      boolean _isEmpty = _errors.isEmpty();
      Assert.assertTrue(_isEmpty);
      TargetPlatformValidator _validator = tester.validator();
      _validator.checkOptionsOnLocationAreIdentical(targetPlatform);
      AssertableDiagnostics _diagnose = tester.diagnose();
      Iterable<Diagnostic> _allDiagnostics = _diagnose.getAllDiagnostics();
      Iterable<AbstractValidationDiagnostic> _filter = Iterables.<AbstractValidationDiagnostic>filter(_allDiagnostics, AbstractValidationDiagnostic.class);
      final List<AbstractValidationDiagnostic> diagnotics = IterableExtensions.<AbstractValidationDiagnostic>toList(_filter);
      int _size = diagnotics.size();
      Assert.assertEquals(0, _size);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void checkOptionsOnLocationAreIdentical2() {
    try {
      final ValidatorTester<TargetPlatformValidator> tester = new ValidatorTester<TargetPlatformValidator>(this.validator, this.validatorRegistrar, this.languageName);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"a target platform\"");
      _builder.newLine();
      _builder.append("with source");
      _builder.newLine();
      _builder.append("location \"mylocationURI1\"");
      _builder.newLine();
      _builder.append("location \"mylocationURI1\"");
      _builder.newLine();
      final TargetPlatform targetPlatform = this.parser.parse(_builder);
      Resource _eResource = targetPlatform.eResource();
      EList<Resource.Diagnostic> _errors = _eResource.getErrors();
      boolean _isEmpty = _errors.isEmpty();
      Assert.assertTrue(_isEmpty);
      TargetPlatformValidator _validator = tester.validator();
      _validator.checkOptionsOnLocationAreIdentical(targetPlatform);
      AssertableDiagnostics _diagnose = tester.diagnose();
      Iterable<Diagnostic> _allDiagnostics = _diagnose.getAllDiagnostics();
      Iterable<AbstractValidationDiagnostic> _filter = Iterables.<AbstractValidationDiagnostic>filter(_allDiagnostics, AbstractValidationDiagnostic.class);
      final List<AbstractValidationDiagnostic> diagnotics = IterableExtensions.<AbstractValidationDiagnostic>toList(_filter);
      int _size = diagnotics.size();
      Assert.assertEquals(0, _size);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void checkOptionsOnLocationAreIdentical3() {
    try {
      final ValidatorTester<TargetPlatformValidator> tester = new ValidatorTester<TargetPlatformValidator>(this.validator, this.validatorRegistrar, this.languageName);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"a target platform\"");
      _builder.newLine();
      _builder.append("with source");
      _builder.newLine();
      _builder.append("location \"mylocationURI1\" {with source}");
      _builder.newLine();
      _builder.append("location \"mylocationURI1\" {with source}");
      _builder.newLine();
      final TargetPlatform targetPlatform = this.parser.parse(_builder);
      Resource _eResource = targetPlatform.eResource();
      EList<Resource.Diagnostic> _errors = _eResource.getErrors();
      boolean _isEmpty = _errors.isEmpty();
      Assert.assertTrue(_isEmpty);
      TargetPlatformValidator _validator = tester.validator();
      _validator.checkOptionsOnLocationAreIdentical(targetPlatform);
      AssertableDiagnostics _diagnose = tester.diagnose();
      Iterable<Diagnostic> _allDiagnostics = _diagnose.getAllDiagnostics();
      Iterable<AbstractValidationDiagnostic> _filter = Iterables.<AbstractValidationDiagnostic>filter(_allDiagnostics, AbstractValidationDiagnostic.class);
      final List<AbstractValidationDiagnostic> diagnotics = IterableExtensions.<AbstractValidationDiagnostic>toList(_filter);
      int _size = diagnotics.size();
      Assert.assertEquals(0, _size);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void checkOptionsOnLocationAreIdentical4() {
    try {
      final ValidatorTester<TargetPlatformValidator> tester = new ValidatorTester<TargetPlatformValidator>(this.validator, this.validatorRegistrar, this.languageName);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"a target platform\"");
      _builder.newLine();
      _builder.append("with source");
      _builder.newLine();
      _builder.append("location \"mylocationURI1\" {with source}");
      _builder.newLine();
      _builder.append("location \"mylocationURI1\" {with requirements}");
      _builder.newLine();
      final TargetPlatform targetPlatform = this.parser.parse(_builder);
      Resource _eResource = targetPlatform.eResource();
      EList<Resource.Diagnostic> _errors = _eResource.getErrors();
      boolean _isEmpty = _errors.isEmpty();
      Assert.assertTrue(_isEmpty);
      TargetPlatformValidator _validator = tester.validator();
      _validator.checkOptionsOnLocationAreIdentical(targetPlatform);
      AssertableDiagnostics _diagnose = tester.diagnose();
      Iterable<Diagnostic> _allDiagnostics = _diagnose.getAllDiagnostics();
      Iterable<AbstractValidationDiagnostic> _filter = Iterables.<AbstractValidationDiagnostic>filter(_allDiagnostics, AbstractValidationDiagnostic.class);
      final List<AbstractValidationDiagnostic> diagnotics = IterableExtensions.<AbstractValidationDiagnostic>toList(_filter);
      int _size = diagnotics.size();
      Assert.assertEquals(0, _size);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void checkOptionsOnLocationAreIdentical5() {
    try {
      final ValidatorTester<TargetPlatformValidator> tester = new ValidatorTester<TargetPlatformValidator>(this.validator, this.validatorRegistrar, this.languageName);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"a target platform\"");
      _builder.newLine();
      _builder.append("location \"mylocationURI1\" {with source}");
      _builder.newLine();
      _builder.append("location \"mylocationURI1\" {with source}");
      _builder.newLine();
      final TargetPlatform targetPlatform = this.parser.parse(_builder);
      Resource _eResource = targetPlatform.eResource();
      EList<Resource.Diagnostic> _errors = _eResource.getErrors();
      boolean _isEmpty = _errors.isEmpty();
      Assert.assertTrue(_isEmpty);
      TargetPlatformValidator _validator = tester.validator();
      _validator.checkOptionsOnLocationAreIdentical(targetPlatform);
      AssertableDiagnostics _diagnose = tester.diagnose();
      Iterable<Diagnostic> _allDiagnostics = _diagnose.getAllDiagnostics();
      Iterable<AbstractValidationDiagnostic> _filter = Iterables.<AbstractValidationDiagnostic>filter(_allDiagnostics, AbstractValidationDiagnostic.class);
      final List<AbstractValidationDiagnostic> diagnotics = IterableExtensions.<AbstractValidationDiagnostic>toList(_filter);
      int _size = diagnotics.size();
      Assert.assertEquals(0, _size);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void checkOptionsOnLocationAreIdentical6() {
    try {
      final ValidatorTester<TargetPlatformValidator> tester = new ValidatorTester<TargetPlatformValidator>(this.validator, this.validatorRegistrar, this.languageName);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"a target platform\"");
      _builder.newLine();
      _builder.append("location \"mylocationURI1\" {with source}");
      _builder.newLine();
      _builder.append("location \"mylocationURI2\" {with source, requirements}");
      _builder.newLine();
      final TargetPlatform targetPlatform = this.parser.parse(_builder);
      Resource _eResource = targetPlatform.eResource();
      EList<Resource.Diagnostic> _errors = _eResource.getErrors();
      boolean _isEmpty = _errors.isEmpty();
      Assert.assertTrue(_isEmpty);
      TargetPlatformValidator _validator = tester.validator();
      _validator.checkOptionsOnLocationAreIdentical(targetPlatform);
      AssertableDiagnostics _diagnose = tester.diagnose();
      Iterable<Diagnostic> _allDiagnostics = _diagnose.getAllDiagnostics();
      Iterable<AbstractValidationDiagnostic> _filter = Iterables.<AbstractValidationDiagnostic>filter(_allDiagnostics, AbstractValidationDiagnostic.class);
      final List<AbstractValidationDiagnostic> diagnotics = IterableExtensions.<AbstractValidationDiagnostic>toList(_filter);
      int _size = diagnotics.size();
      Assert.assertEquals(2, _size);
      final Function1<AbstractValidationDiagnostic, Boolean> _function = new Function1<AbstractValidationDiagnostic, Boolean>() {
        public Boolean apply(final AbstractValidationDiagnostic it) {
          EObject _sourceEObject = it.getSourceEObject();
          return Boolean.valueOf((_sourceEObject instanceof Location));
        }
      };
      boolean _forall = IterableExtensions.<AbstractValidationDiagnostic>forall(diagnotics, _function);
      Assert.assertTrue(_forall);
      final Procedure1<AbstractValidationDiagnostic> _function_1 = new Procedure1<AbstractValidationDiagnostic>() {
        public void apply(final AbstractValidationDiagnostic it) {
          String _issueCode = it.getIssueCode();
          Assert.assertEquals(TargetPlatformValidator.CHECK__OPTIONS_EQUALS_ALL_LOCATIONS, _issueCode);
        }
      };
      IterableExtensions.<AbstractValidationDiagnostic>forEach(diagnotics, _function_1);
      AbstractValidationDiagnostic _get = diagnotics.get(0);
      EObject _sourceEObject = _get.getSourceEObject();
      String _uri = ((Location) _sourceEObject).getUri();
      Assert.assertEquals("mylocationURI1", _uri);
      AbstractValidationDiagnostic _get_1 = diagnotics.get(1);
      EObject _sourceEObject_1 = _get_1.getSourceEObject();
      String _uri_1 = ((Location) _sourceEObject_1).getUri();
      Assert.assertEquals("mylocationURI2", _uri_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void deprecateOptionsOnLocation1() {
    try {
      final ValidatorTester<TargetPlatformValidator> tester = new ValidatorTester<TargetPlatformValidator>(this.validator, this.validatorRegistrar, this.languageName);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"a target platform\"");
      _builder.newLine();
      _builder.append("location \"mylocationURI1\" ");
      _builder.newLine();
      final TargetPlatform targetPlatform = this.parser.parse(_builder);
      Resource _eResource = targetPlatform.eResource();
      EList<Resource.Diagnostic> _errors = _eResource.getErrors();
      boolean _isEmpty = _errors.isEmpty();
      Assert.assertTrue(_isEmpty);
      TargetPlatformValidator _validator = tester.validator();
      EList<Location> _locations = targetPlatform.getLocations();
      Location _head = IterableExtensions.<Location>head(_locations);
      _validator.deprecateOptionsOnLocation(_head);
      AssertableDiagnostics _diagnose = tester.diagnose();
      Iterable<Diagnostic> _allDiagnostics = _diagnose.getAllDiagnostics();
      Iterable<AbstractValidationDiagnostic> _filter = Iterables.<AbstractValidationDiagnostic>filter(_allDiagnostics, AbstractValidationDiagnostic.class);
      final List<AbstractValidationDiagnostic> diagnotics = IterableExtensions.<AbstractValidationDiagnostic>toList(_filter);
      int _size = diagnotics.size();
      Assert.assertEquals(0, _size);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void deprecateOptionsOnLocation2() {
    try {
      final ValidatorTester<TargetPlatformValidator> tester = new ValidatorTester<TargetPlatformValidator>(this.validator, this.validatorRegistrar, this.languageName);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"a target platform\"");
      _builder.newLine();
      _builder.append("with requirements");
      _builder.newLine();
      _builder.append("location \"mylocationURI1\" {with source}");
      _builder.newLine();
      final TargetPlatform targetPlatform = this.parser.parse(_builder);
      Resource _eResource = targetPlatform.eResource();
      EList<Resource.Diagnostic> _errors = _eResource.getErrors();
      boolean _isEmpty = _errors.isEmpty();
      Assert.assertTrue(_isEmpty);
      TargetPlatformValidator _validator = tester.validator();
      EList<Location> _locations = targetPlatform.getLocations();
      Location _head = IterableExtensions.<Location>head(_locations);
      _validator.deprecateOptionsOnLocation(_head);
      AssertableDiagnostics _diagnose = tester.diagnose();
      Iterable<Diagnostic> _allDiagnostics = _diagnose.getAllDiagnostics();
      Iterable<AbstractValidationDiagnostic> _filter = Iterables.<AbstractValidationDiagnostic>filter(_allDiagnostics, AbstractValidationDiagnostic.class);
      final List<AbstractValidationDiagnostic> diagnotics = IterableExtensions.<AbstractValidationDiagnostic>toList(_filter);
      int _size = diagnotics.size();
      Assert.assertEquals(0, _size);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void deprecateOptionsOnLocation3() {
    try {
      final ValidatorTester<TargetPlatformValidator> tester = new ValidatorTester<TargetPlatformValidator>(this.validator, this.validatorRegistrar, this.languageName);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"a target platform\"");
      _builder.newLine();
      _builder.append("with requirements");
      _builder.newLine();
      _builder.append("location \"mylocationURI1\"");
      _builder.newLine();
      final TargetPlatform targetPlatform = this.parser.parse(_builder);
      Resource _eResource = targetPlatform.eResource();
      EList<Resource.Diagnostic> _errors = _eResource.getErrors();
      boolean _isEmpty = _errors.isEmpty();
      Assert.assertTrue(_isEmpty);
      TargetPlatformValidator _validator = tester.validator();
      EList<Location> _locations = targetPlatform.getLocations();
      Location _head = IterableExtensions.<Location>head(_locations);
      _validator.deprecateOptionsOnLocation(_head);
      AssertableDiagnostics _diagnose = tester.diagnose();
      Iterable<Diagnostic> _allDiagnostics = _diagnose.getAllDiagnostics();
      Iterable<AbstractValidationDiagnostic> _filter = Iterables.<AbstractValidationDiagnostic>filter(_allDiagnostics, AbstractValidationDiagnostic.class);
      final List<AbstractValidationDiagnostic> diagnotics = IterableExtensions.<AbstractValidationDiagnostic>toList(_filter);
      int _size = diagnotics.size();
      Assert.assertEquals(0, _size);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void deprecateOptionsOnLocation4() {
    try {
      final ValidatorTester<TargetPlatformValidator> tester = new ValidatorTester<TargetPlatformValidator>(this.validator, this.validatorRegistrar, this.languageName);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"a target platform\"");
      _builder.newLine();
      _builder.append("location \"mylocationURI1\" {with source}");
      _builder.newLine();
      final TargetPlatform targetPlatform = this.parser.parse(_builder);
      Resource _eResource = targetPlatform.eResource();
      EList<Resource.Diagnostic> _errors = _eResource.getErrors();
      boolean _isEmpty = _errors.isEmpty();
      Assert.assertTrue(_isEmpty);
      TargetPlatformValidator _validator = tester.validator();
      EList<Location> _locations = targetPlatform.getLocations();
      Location _head = IterableExtensions.<Location>head(_locations);
      _validator.deprecateOptionsOnLocation(_head);
      AssertableDiagnostics _diagnose = tester.diagnose();
      Iterable<Diagnostic> _allDiagnostics = _diagnose.getAllDiagnostics();
      Iterable<AbstractValidationDiagnostic> _filter = Iterables.<AbstractValidationDiagnostic>filter(_allDiagnostics, AbstractValidationDiagnostic.class);
      final List<AbstractValidationDiagnostic> diagnotics = IterableExtensions.<AbstractValidationDiagnostic>toList(_filter);
      int _size = diagnotics.size();
      Assert.assertEquals(1, _size);
      final Function1<AbstractValidationDiagnostic, Boolean> _function = new Function1<AbstractValidationDiagnostic, Boolean>() {
        public Boolean apply(final AbstractValidationDiagnostic it) {
          EObject _sourceEObject = it.getSourceEObject();
          return Boolean.valueOf((_sourceEObject instanceof Location));
        }
      };
      boolean _forall = IterableExtensions.<AbstractValidationDiagnostic>forall(diagnotics, _function);
      Assert.assertTrue(_forall);
      final Procedure1<AbstractValidationDiagnostic> _function_1 = new Procedure1<AbstractValidationDiagnostic>() {
        public void apply(final AbstractValidationDiagnostic it) {
          String _issueCode = it.getIssueCode();
          Assert.assertEquals(TargetPlatformValidator.DEPRECATE__OPTIONS_ON_LOCATIONS, _issueCode);
        }
      };
      IterableExtensions.<AbstractValidationDiagnostic>forEach(diagnotics, _function_1);
      AbstractValidationDiagnostic _get = diagnotics.get(0);
      EObject _sourceEObject = _get.getSourceEObject();
      String _uri = ((Location) _sourceEObject).getUri();
      Assert.assertEquals("mylocationURI1", _uri);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void deprecateOptionsOnLocation5() {
    try {
      final ValidatorTester<TargetPlatformValidator> tester = new ValidatorTester<TargetPlatformValidator>(this.validator, this.validatorRegistrar, this.languageName);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"a target platform\"");
      _builder.newLine();
      _builder.append("location \"mylocationURI1\" {with source, requirements}");
      _builder.newLine();
      final TargetPlatform targetPlatform = this.parser.parse(_builder);
      Resource _eResource = targetPlatform.eResource();
      EList<Resource.Diagnostic> _errors = _eResource.getErrors();
      boolean _isEmpty = _errors.isEmpty();
      Assert.assertTrue(_isEmpty);
      TargetPlatformValidator _validator = tester.validator();
      EList<Location> _locations = targetPlatform.getLocations();
      Location _head = IterableExtensions.<Location>head(_locations);
      _validator.deprecateOptionsOnLocation(_head);
      AssertableDiagnostics _diagnose = tester.diagnose();
      Iterable<Diagnostic> _allDiagnostics = _diagnose.getAllDiagnostics();
      Iterable<AbstractValidationDiagnostic> _filter = Iterables.<AbstractValidationDiagnostic>filter(_allDiagnostics, AbstractValidationDiagnostic.class);
      final List<AbstractValidationDiagnostic> diagnotics = IterableExtensions.<AbstractValidationDiagnostic>toList(_filter);
      int _size = diagnotics.size();
      Assert.assertEquals(1, _size);
      final Function1<AbstractValidationDiagnostic, Boolean> _function = new Function1<AbstractValidationDiagnostic, Boolean>() {
        public Boolean apply(final AbstractValidationDiagnostic it) {
          EObject _sourceEObject = it.getSourceEObject();
          return Boolean.valueOf((_sourceEObject instanceof Location));
        }
      };
      boolean _forall = IterableExtensions.<AbstractValidationDiagnostic>forall(diagnotics, _function);
      Assert.assertTrue(_forall);
      final Procedure1<AbstractValidationDiagnostic> _function_1 = new Procedure1<AbstractValidationDiagnostic>() {
        public void apply(final AbstractValidationDiagnostic it) {
          String _issueCode = it.getIssueCode();
          Assert.assertEquals(TargetPlatformValidator.DEPRECATE__OPTIONS_ON_LOCATIONS, _issueCode);
        }
      };
      IterableExtensions.<AbstractValidationDiagnostic>forEach(diagnotics, _function_1);
      AbstractValidationDiagnostic _get = diagnotics.get(0);
      EObject _sourceEObject = _get.getSourceEObject();
      String _uri = ((Location) _sourceEObject).getUri();
      Assert.assertEquals("mylocationURI1", _uri);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void deprecateIUVersionRangeWihString1() {
    try {
      final ValidatorTester<TargetPlatformValidator> tester = new ValidatorTester<TargetPlatformValidator>(this.validator, this.validatorRegistrar, this.languageName);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"a target platform\"");
      _builder.newLine();
      _builder.append("location \"mylocationURI1\" {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("my.iu;version=\"12\"");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final TargetPlatform targetPlatform = this.parser.parse(_builder);
      Resource _eResource = targetPlatform.eResource();
      EList<Resource.Diagnostic> _errors = _eResource.getErrors();
      boolean _isEmpty = _errors.isEmpty();
      Assert.assertTrue(_isEmpty);
      TargetPlatformValidator _validator = tester.validator();
      EList<Location> _locations = targetPlatform.getLocations();
      Location _head = IterableExtensions.<Location>head(_locations);
      EList<IU> _ius = _head.getIus();
      IU _head_1 = IterableExtensions.<IU>head(_ius);
      _validator.deprecateIUVersionRangeWihString(_head_1);
      AssertableDiagnostics _diagnose = tester.diagnose();
      Iterable<Diagnostic> _allDiagnostics = _diagnose.getAllDiagnostics();
      Iterable<AbstractValidationDiagnostic> _filter = Iterables.<AbstractValidationDiagnostic>filter(_allDiagnostics, AbstractValidationDiagnostic.class);
      final List<AbstractValidationDiagnostic> diagnotics = IterableExtensions.<AbstractValidationDiagnostic>toList(_filter);
      int _size = diagnotics.size();
      Assert.assertEquals(1, _size);
      final Function1<AbstractValidationDiagnostic, Boolean> _function = new Function1<AbstractValidationDiagnostic, Boolean>() {
        public Boolean apply(final AbstractValidationDiagnostic it) {
          EObject _sourceEObject = it.getSourceEObject();
          return Boolean.valueOf((_sourceEObject instanceof IU));
        }
      };
      boolean _forall = IterableExtensions.<AbstractValidationDiagnostic>forall(diagnotics, _function);
      Assert.assertTrue(_forall);
      final Procedure1<AbstractValidationDiagnostic> _function_1 = new Procedure1<AbstractValidationDiagnostic>() {
        public void apply(final AbstractValidationDiagnostic it) {
          String _issueCode = it.getIssueCode();
          Assert.assertEquals(TargetPlatformValidator.DEPRECATE__STRINGS_ON_IU_VERSION, _issueCode);
        }
      };
      IterableExtensions.<AbstractValidationDiagnostic>forEach(diagnotics, _function_1);
      AbstractValidationDiagnostic _get = diagnotics.get(0);
      EObject _sourceEObject = _get.getSourceEObject();
      String _iD = ((IU) _sourceEObject).getID();
      Assert.assertEquals("my.iu", _iD);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void deprecateIUVersionRangeWihString2() {
    try {
      final ValidatorTester<TargetPlatformValidator> tester = new ValidatorTester<TargetPlatformValidator>(this.validator, this.validatorRegistrar, this.languageName);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"a target platform\"");
      _builder.newLine();
      _builder.append("location \"mylocationURI1\" {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("my.iu;version=12");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final TargetPlatform targetPlatform = this.parser.parse(_builder);
      Resource _eResource = targetPlatform.eResource();
      EList<Resource.Diagnostic> _errors = _eResource.getErrors();
      boolean _isEmpty = _errors.isEmpty();
      Assert.assertTrue(_isEmpty);
      TargetPlatformValidator _validator = tester.validator();
      EList<Location> _locations = targetPlatform.getLocations();
      Location _head = IterableExtensions.<Location>head(_locations);
      EList<IU> _ius = _head.getIus();
      IU _head_1 = IterableExtensions.<IU>head(_ius);
      _validator.deprecateIUVersionRangeWihString(_head_1);
      AssertableDiagnostics _diagnose = tester.diagnose();
      Iterable<Diagnostic> _allDiagnostics = _diagnose.getAllDiagnostics();
      Iterable<AbstractValidationDiagnostic> _filter = Iterables.<AbstractValidationDiagnostic>filter(_allDiagnostics, AbstractValidationDiagnostic.class);
      final List<AbstractValidationDiagnostic> diagnotics = IterableExtensions.<AbstractValidationDiagnostic>toList(_filter);
      int _size = diagnotics.size();
      Assert.assertEquals(0, _size);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void deprecateIUVersionRangeWihString3() {
    try {
      final ValidatorTester<TargetPlatformValidator> tester = new ValidatorTester<TargetPlatformValidator>(this.validator, this.validatorRegistrar, this.languageName);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"a target platform\"");
      _builder.newLine();
      _builder.append("location \"mylocationURI1\" {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("my.iu");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final TargetPlatform targetPlatform = this.parser.parse(_builder);
      Resource _eResource = targetPlatform.eResource();
      EList<Resource.Diagnostic> _errors = _eResource.getErrors();
      boolean _isEmpty = _errors.isEmpty();
      Assert.assertTrue(_isEmpty);
      TargetPlatformValidator _validator = tester.validator();
      EList<Location> _locations = targetPlatform.getLocations();
      Location _head = IterableExtensions.<Location>head(_locations);
      EList<IU> _ius = _head.getIus();
      IU _head_1 = IterableExtensions.<IU>head(_ius);
      _validator.deprecateIUVersionRangeWihString(_head_1);
      AssertableDiagnostics _diagnose = tester.diagnose();
      Iterable<Diagnostic> _allDiagnostics = _diagnose.getAllDiagnostics();
      Iterable<AbstractValidationDiagnostic> _filter = Iterables.<AbstractValidationDiagnostic>filter(_allDiagnostics, AbstractValidationDiagnostic.class);
      final List<AbstractValidationDiagnostic> diagnotics = IterableExtensions.<AbstractValidationDiagnostic>toList(_filter);
      int _size = diagnotics.size();
      Assert.assertEquals(0, _size);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void checkSameIDForAllLocationWithSameURI1() {
    try {
      final ValidatorTester<TargetPlatformValidator> tester = new ValidatorTester<TargetPlatformValidator>(this.validator, this.validatorRegistrar, this.languageName);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"a target platform\"");
      _builder.newLine();
      _builder.append("location \"mylocationURI1\"");
      _builder.newLine();
      final TargetPlatform targetPlatform = this.parser.parse(_builder);
      Resource _eResource = targetPlatform.eResource();
      EList<Resource.Diagnostic> _errors = _eResource.getErrors();
      boolean _isEmpty = _errors.isEmpty();
      Assert.assertTrue(_isEmpty);
      TargetPlatformValidator _validator = tester.validator();
      _validator.checkSameIDForAllLocationWithSameURI(targetPlatform);
      AssertableDiagnostics _diagnose = tester.diagnose();
      Iterable<Diagnostic> _allDiagnostics = _diagnose.getAllDiagnostics();
      Iterable<AbstractValidationDiagnostic> _filter = Iterables.<AbstractValidationDiagnostic>filter(_allDiagnostics, AbstractValidationDiagnostic.class);
      final List<AbstractValidationDiagnostic> diagnotics = IterableExtensions.<AbstractValidationDiagnostic>toList(_filter);
      int _size = diagnotics.size();
      Assert.assertEquals(0, _size);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void checkSameIDForAllLocationWithSameURI2() {
    try {
      final ValidatorTester<TargetPlatformValidator> tester = new ValidatorTester<TargetPlatformValidator>(this.validator, this.validatorRegistrar, this.languageName);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"a target platform\"");
      _builder.newLine();
      _builder.append("location \"mylocationURI1\"");
      _builder.newLine();
      _builder.append("location \"mylocationURI2\"");
      _builder.newLine();
      final TargetPlatform targetPlatform = this.parser.parse(_builder);
      Resource _eResource = targetPlatform.eResource();
      EList<Resource.Diagnostic> _errors = _eResource.getErrors();
      boolean _isEmpty = _errors.isEmpty();
      Assert.assertTrue(_isEmpty);
      TargetPlatformValidator _validator = tester.validator();
      _validator.checkSameIDForAllLocationWithSameURI(targetPlatform);
      AssertableDiagnostics _diagnose = tester.diagnose();
      Iterable<Diagnostic> _allDiagnostics = _diagnose.getAllDiagnostics();
      Iterable<AbstractValidationDiagnostic> _filter = Iterables.<AbstractValidationDiagnostic>filter(_allDiagnostics, AbstractValidationDiagnostic.class);
      final List<AbstractValidationDiagnostic> diagnotics = IterableExtensions.<AbstractValidationDiagnostic>toList(_filter);
      int _size = diagnotics.size();
      Assert.assertEquals(0, _size);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void checkSameIDForAllLocationWithSameURI3() {
    try {
      final ValidatorTester<TargetPlatformValidator> tester = new ValidatorTester<TargetPlatformValidator>(this.validator, this.validatorRegistrar, this.languageName);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"a target platform\"");
      _builder.newLine();
      _builder.append("location \"mylocationURI1\"");
      _builder.newLine();
      _builder.append("location \"mylocationURI1\"");
      _builder.newLine();
      final TargetPlatform targetPlatform = this.parser.parse(_builder);
      Resource _eResource = targetPlatform.eResource();
      EList<Resource.Diagnostic> _errors = _eResource.getErrors();
      boolean _isEmpty = _errors.isEmpty();
      Assert.assertTrue(_isEmpty);
      TargetPlatformValidator _validator = tester.validator();
      _validator.checkSameIDForAllLocationWithSameURI(targetPlatform);
      AssertableDiagnostics _diagnose = tester.diagnose();
      Iterable<Diagnostic> _allDiagnostics = _diagnose.getAllDiagnostics();
      Iterable<AbstractValidationDiagnostic> _filter = Iterables.<AbstractValidationDiagnostic>filter(_allDiagnostics, AbstractValidationDiagnostic.class);
      final List<AbstractValidationDiagnostic> diagnotics = IterableExtensions.<AbstractValidationDiagnostic>toList(_filter);
      int _size = diagnotics.size();
      Assert.assertEquals(0, _size);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void checkSameIDForAllLocationWithSameURI4() {
    try {
      final ValidatorTester<TargetPlatformValidator> tester = new ValidatorTester<TargetPlatformValidator>(this.validator, this.validatorRegistrar, this.languageName);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"a target platform\"");
      _builder.newLine();
      _builder.append("location A \"mylocationURI1\"");
      _builder.newLine();
      _builder.append("location A \"mylocationURI1\"");
      _builder.newLine();
      final TargetPlatform targetPlatform = this.parser.parse(_builder);
      Resource _eResource = targetPlatform.eResource();
      EList<Resource.Diagnostic> _errors = _eResource.getErrors();
      boolean _isEmpty = _errors.isEmpty();
      Assert.assertTrue(_isEmpty);
      TargetPlatformValidator _validator = tester.validator();
      _validator.checkSameIDForAllLocationWithSameURI(targetPlatform);
      AssertableDiagnostics _diagnose = tester.diagnose();
      Iterable<Diagnostic> _allDiagnostics = _diagnose.getAllDiagnostics();
      Iterable<AbstractValidationDiagnostic> _filter = Iterables.<AbstractValidationDiagnostic>filter(_allDiagnostics, AbstractValidationDiagnostic.class);
      final List<AbstractValidationDiagnostic> diagnotics = IterableExtensions.<AbstractValidationDiagnostic>toList(_filter);
      int _size = diagnotics.size();
      Assert.assertEquals(0, _size);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void checkSameIDForAllLocationWithSameURI5() {
    try {
      final ValidatorTester<TargetPlatformValidator> tester = new ValidatorTester<TargetPlatformValidator>(this.validator, this.validatorRegistrar, this.languageName);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"a target platform\"");
      _builder.newLine();
      _builder.append("location A \"mylocationURI\"");
      _builder.newLine();
      _builder.append("location A \"mylocationURI1\"");
      _builder.newLine();
      final TargetPlatform targetPlatform = this.parser.parse(_builder);
      Resource _eResource = targetPlatform.eResource();
      EList<Resource.Diagnostic> _errors = _eResource.getErrors();
      boolean _isEmpty = _errors.isEmpty();
      Assert.assertTrue(_isEmpty);
      TargetPlatformValidator _validator = tester.validator();
      _validator.checkSameIDForAllLocationWithSameURI(targetPlatform);
      AssertableDiagnostics _diagnose = tester.diagnose();
      Iterable<Diagnostic> _allDiagnostics = _diagnose.getAllDiagnostics();
      Iterable<AbstractValidationDiagnostic> _filter = Iterables.<AbstractValidationDiagnostic>filter(_allDiagnostics, AbstractValidationDiagnostic.class);
      final List<AbstractValidationDiagnostic> diagnotics = IterableExtensions.<AbstractValidationDiagnostic>toList(_filter);
      int _size = diagnotics.size();
      Assert.assertEquals(0, _size);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void checkSameIDForAllLocationWithSameURI6() {
    try {
      final ValidatorTester<TargetPlatformValidator> tester = new ValidatorTester<TargetPlatformValidator>(this.validator, this.validatorRegistrar, this.languageName);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"a target platform\"");
      _builder.newLine();
      _builder.append("location A \"mylocationURI1\"");
      _builder.newLine();
      _builder.append("location   \"mylocationURI1\"");
      _builder.newLine();
      final TargetPlatform targetPlatform = this.parser.parse(_builder);
      Resource _eResource = targetPlatform.eResource();
      EList<Resource.Diagnostic> _errors = _eResource.getErrors();
      boolean _isEmpty = _errors.isEmpty();
      Assert.assertTrue(_isEmpty);
      TargetPlatformValidator _validator = tester.validator();
      _validator.checkSameIDForAllLocationWithSameURI(targetPlatform);
      AssertableDiagnostics _diagnose = tester.diagnose();
      Iterable<Diagnostic> _allDiagnostics = _diagnose.getAllDiagnostics();
      Iterable<AbstractValidationDiagnostic> _filter = Iterables.<AbstractValidationDiagnostic>filter(_allDiagnostics, AbstractValidationDiagnostic.class);
      final List<AbstractValidationDiagnostic> diagnotics = IterableExtensions.<AbstractValidationDiagnostic>toList(_filter);
      int _size = diagnotics.size();
      Assert.assertEquals(2, _size);
      final Function1<AbstractValidationDiagnostic, Boolean> _function = new Function1<AbstractValidationDiagnostic, Boolean>() {
        public Boolean apply(final AbstractValidationDiagnostic it) {
          EObject _sourceEObject = it.getSourceEObject();
          return Boolean.valueOf((_sourceEObject instanceof Location));
        }
      };
      boolean _forall = IterableExtensions.<AbstractValidationDiagnostic>forall(diagnotics, _function);
      Assert.assertTrue(_forall);
      final Procedure1<AbstractValidationDiagnostic> _function_1 = new Procedure1<AbstractValidationDiagnostic>() {
        public void apply(final AbstractValidationDiagnostic it) {
          String _issueCode = it.getIssueCode();
          Assert.assertEquals(TargetPlatformValidator.CHECK__LOCATION_CONFLICTUAL_ID, _issueCode);
          EObject _sourceEObject = it.getSourceEObject();
          String _uri = ((Location) _sourceEObject).getUri();
          Assert.assertEquals("mylocationURI1", _uri);
        }
      };
      IterableExtensions.<AbstractValidationDiagnostic>forEach(diagnotics, _function_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void checkSameIDForAllLocationWithSameURI7() {
    try {
      final ValidatorTester<TargetPlatformValidator> tester = new ValidatorTester<TargetPlatformValidator>(this.validator, this.validatorRegistrar, this.languageName);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"a target platform\"");
      _builder.newLine();
      _builder.append("location A \"mylocationURI1\"");
      _builder.newLine();
      _builder.append("location B \"mylocationURI1\"");
      _builder.newLine();
      final TargetPlatform targetPlatform = this.parser.parse(_builder);
      Resource _eResource = targetPlatform.eResource();
      EList<Resource.Diagnostic> _errors = _eResource.getErrors();
      boolean _isEmpty = _errors.isEmpty();
      Assert.assertTrue(_isEmpty);
      TargetPlatformValidator _validator = tester.validator();
      _validator.checkSameIDForAllLocationWithSameURI(targetPlatform);
      AssertableDiagnostics _diagnose = tester.diagnose();
      Iterable<Diagnostic> _allDiagnostics = _diagnose.getAllDiagnostics();
      Iterable<AbstractValidationDiagnostic> _filter = Iterables.<AbstractValidationDiagnostic>filter(_allDiagnostics, AbstractValidationDiagnostic.class);
      final List<AbstractValidationDiagnostic> diagnotics = IterableExtensions.<AbstractValidationDiagnostic>toList(_filter);
      int _size = diagnotics.size();
      Assert.assertEquals(2, _size);
      final Function1<AbstractValidationDiagnostic, Boolean> _function = new Function1<AbstractValidationDiagnostic, Boolean>() {
        public Boolean apply(final AbstractValidationDiagnostic it) {
          EObject _sourceEObject = it.getSourceEObject();
          return Boolean.valueOf((_sourceEObject instanceof Location));
        }
      };
      boolean _forall = IterableExtensions.<AbstractValidationDiagnostic>forall(diagnotics, _function);
      Assert.assertTrue(_forall);
      final Procedure1<AbstractValidationDiagnostic> _function_1 = new Procedure1<AbstractValidationDiagnostic>() {
        public void apply(final AbstractValidationDiagnostic it) {
          String _issueCode = it.getIssueCode();
          Assert.assertEquals(TargetPlatformValidator.CHECK__LOCATION_CONFLICTUAL_ID, _issueCode);
          EObject _sourceEObject = it.getSourceEObject();
          String _uri = ((Location) _sourceEObject).getUri();
          Assert.assertEquals("mylocationURI1", _uri);
        }
      };
      IterableExtensions.<AbstractValidationDiagnostic>forEach(diagnotics, _function_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void checkSameIDForAllLocationWithSameURI8() {
    try {
      final ValidatorTester<TargetPlatformValidator> tester = new ValidatorTester<TargetPlatformValidator>(this.validator, this.validatorRegistrar, this.languageName);
      final XtextResourceSet resourceSet = this.resourceSetProvider.get();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"tp.a\"");
      _builder.newLine();
      _builder.append("include \"b.tpd\"");
      _builder.newLine();
      URI _createURI = URI.createURI("tmp:/a.tpd");
      final TargetPlatform tpa = this.parser.parse(_builder, _createURI, resourceSet);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("target \"tp.b\"");
      _builder_1.newLine();
      URI _createURI_1 = URI.createURI("tmp:/b.tpd");
      this.parser.parse(_builder_1, _createURI_1, resourceSet);
      Resource _eResource = tpa.eResource();
      EList<Resource.Diagnostic> _errors = _eResource.getErrors();
      boolean _isEmpty = _errors.isEmpty();
      Assert.assertTrue(_isEmpty);
      TargetPlatformValidator _validator = tester.validator();
      _validator.checkSameIDForAllLocationWithSameURI(tpa);
      AssertableDiagnostics _diagnose = tester.diagnose();
      Iterable<Diagnostic> _allDiagnostics = _diagnose.getAllDiagnostics();
      Iterable<AbstractValidationDiagnostic> _filter = Iterables.<AbstractValidationDiagnostic>filter(_allDiagnostics, AbstractValidationDiagnostic.class);
      final List<AbstractValidationDiagnostic> diagnotics = IterableExtensions.<AbstractValidationDiagnostic>toList(_filter);
      int _size = diagnotics.size();
      Assert.assertEquals(0, _size);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void checkSameIDForAllLocationWithSameURI9() {
    try {
      final ValidatorTester<TargetPlatformValidator> tester = new ValidatorTester<TargetPlatformValidator>(this.validator, this.validatorRegistrar, this.languageName);
      final XtextResourceSet resourceSet = this.resourceSetProvider.get();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"tp.a\"");
      _builder.newLine();
      _builder.append("include \"b.tpd\"");
      _builder.newLine();
      _builder.newLine();
      _builder.append("location \"locationURI1\"");
      _builder.newLine();
      URI _createURI = URI.createURI("tmp:/a.tpd");
      final TargetPlatform tpa = this.parser.parse(_builder, _createURI, resourceSet);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("target \"tp.b\"");
      _builder_1.newLine();
      URI _createURI_1 = URI.createURI("tmp:/b.tpd");
      this.parser.parse(_builder_1, _createURI_1, resourceSet);
      Resource _eResource = tpa.eResource();
      EList<Resource.Diagnostic> _errors = _eResource.getErrors();
      boolean _isEmpty = _errors.isEmpty();
      Assert.assertTrue(_isEmpty);
      TargetPlatformValidator _validator = tester.validator();
      _validator.checkSameIDForAllLocationWithSameURI(tpa);
      AssertableDiagnostics _diagnose = tester.diagnose();
      Iterable<Diagnostic> _allDiagnostics = _diagnose.getAllDiagnostics();
      Iterable<AbstractValidationDiagnostic> _filter = Iterables.<AbstractValidationDiagnostic>filter(_allDiagnostics, AbstractValidationDiagnostic.class);
      final List<AbstractValidationDiagnostic> diagnotics = IterableExtensions.<AbstractValidationDiagnostic>toList(_filter);
      int _size = diagnotics.size();
      Assert.assertEquals(0, _size);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void checkSameIDForAllLocationWithSameURI10() {
    try {
      final ValidatorTester<TargetPlatformValidator> tester = new ValidatorTester<TargetPlatformValidator>(this.validator, this.validatorRegistrar, this.languageName);
      final XtextResourceSet resourceSet = this.resourceSetProvider.get();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"tp.a\"");
      _builder.newLine();
      _builder.append("include \"b.tpd\"");
      _builder.newLine();
      _builder.append("location \"locationURI1\"");
      _builder.newLine();
      URI _createURI = URI.createURI("tmp:/a.tpd");
      final TargetPlatform tpa = this.parser.parse(_builder, _createURI, resourceSet);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("target \"tp.b\"");
      _builder_1.newLine();
      _builder_1.append("location \"locationURI1\"");
      _builder_1.newLine();
      URI _createURI_1 = URI.createURI("tmp:/b.tpd");
      this.parser.parse(_builder_1, _createURI_1, resourceSet);
      Resource _eResource = tpa.eResource();
      EList<Resource.Diagnostic> _errors = _eResource.getErrors();
      boolean _isEmpty = _errors.isEmpty();
      Assert.assertTrue(_isEmpty);
      TargetPlatformValidator _validator = tester.validator();
      _validator.checkSameIDForAllLocationWithSameURI(tpa);
      AssertableDiagnostics _diagnose = tester.diagnose();
      Iterable<Diagnostic> _allDiagnostics = _diagnose.getAllDiagnostics();
      Iterable<AbstractValidationDiagnostic> _filter = Iterables.<AbstractValidationDiagnostic>filter(_allDiagnostics, AbstractValidationDiagnostic.class);
      final List<AbstractValidationDiagnostic> diagnotics = IterableExtensions.<AbstractValidationDiagnostic>toList(_filter);
      int _size = diagnotics.size();
      Assert.assertEquals(0, _size);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void checkSameIDForAllLocationWithSameURI11() {
    try {
      final ValidatorTester<TargetPlatformValidator> tester = new ValidatorTester<TargetPlatformValidator>(this.validator, this.validatorRegistrar, this.languageName);
      final XtextResourceSet resourceSet = this.resourceSetProvider.get();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"tp.a\"");
      _builder.newLine();
      _builder.append("include \"b.tpd\"");
      _builder.newLine();
      _builder.append("location A \"locationURI1\"");
      _builder.newLine();
      URI _createURI = URI.createURI("tmp:/a.tpd");
      final TargetPlatform tpa = this.parser.parse(_builder, _createURI, resourceSet);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("target \"tp.b\"");
      _builder_1.newLine();
      _builder_1.append("location A \"locationURI1\"");
      _builder_1.newLine();
      URI _createURI_1 = URI.createURI("tmp:/b.tpd");
      this.parser.parse(_builder_1, _createURI_1, resourceSet);
      Resource _eResource = tpa.eResource();
      EList<Resource.Diagnostic> _errors = _eResource.getErrors();
      boolean _isEmpty = _errors.isEmpty();
      Assert.assertTrue(_isEmpty);
      TargetPlatformValidator _validator = tester.validator();
      _validator.checkSameIDForAllLocationWithSameURI(tpa);
      AssertableDiagnostics _diagnose = tester.diagnose();
      Iterable<Diagnostic> _allDiagnostics = _diagnose.getAllDiagnostics();
      Iterable<AbstractValidationDiagnostic> _filter = Iterables.<AbstractValidationDiagnostic>filter(_allDiagnostics, AbstractValidationDiagnostic.class);
      final List<AbstractValidationDiagnostic> diagnotics = IterableExtensions.<AbstractValidationDiagnostic>toList(_filter);
      int _size = diagnotics.size();
      Assert.assertEquals(0, _size);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void checkSameIDForAllLocationWithSameURI12() {
    try {
      final ValidatorTester<TargetPlatformValidator> tester = new ValidatorTester<TargetPlatformValidator>(this.validator, this.validatorRegistrar, this.languageName);
      final XtextResourceSet resourceSet = this.resourceSetProvider.get();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"tp.a\"");
      _builder.newLine();
      _builder.append("include \"b.tpd\"");
      _builder.newLine();
      _builder.append("location \"locationURI1\"");
      _builder.newLine();
      URI _createURI = URI.createURI("tmp:/a.tpd");
      final TargetPlatform tpa = this.parser.parse(_builder, _createURI, resourceSet);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("target \"tp.b\"");
      _builder_1.newLine();
      _builder_1.append("location A \"locationURI1\"");
      _builder_1.newLine();
      URI _createURI_1 = URI.createURI("tmp:/b.tpd");
      this.parser.parse(_builder_1, _createURI_1, resourceSet);
      Resource _eResource = tpa.eResource();
      EList<Resource.Diagnostic> _errors = _eResource.getErrors();
      boolean _isEmpty = _errors.isEmpty();
      Assert.assertTrue(_isEmpty);
      TargetPlatformValidator _validator = tester.validator();
      _validator.checkSameIDForAllLocationWithSameURI(tpa);
      AssertableDiagnostics _diagnose = tester.diagnose();
      Iterable<Diagnostic> _allDiagnostics = _diagnose.getAllDiagnostics();
      Iterable<AbstractValidationDiagnostic> _filter = Iterables.<AbstractValidationDiagnostic>filter(_allDiagnostics, AbstractValidationDiagnostic.class);
      final List<AbstractValidationDiagnostic> diagnotics = IterableExtensions.<AbstractValidationDiagnostic>toList(_filter);
      int _size = diagnotics.size();
      Assert.assertEquals(1, _size);
      final Function1<AbstractValidationDiagnostic, Boolean> _function = new Function1<AbstractValidationDiagnostic, Boolean>() {
        public Boolean apply(final AbstractValidationDiagnostic it) {
          EObject _sourceEObject = it.getSourceEObject();
          return Boolean.valueOf((_sourceEObject instanceof Location));
        }
      };
      boolean _forall = IterableExtensions.<AbstractValidationDiagnostic>forall(diagnotics, _function);
      Assert.assertTrue(_forall);
      final Procedure1<AbstractValidationDiagnostic> _function_1 = new Procedure1<AbstractValidationDiagnostic>() {
        public void apply(final AbstractValidationDiagnostic it) {
          String _issueCode = it.getIssueCode();
          Assert.assertEquals(TargetPlatformValidator.CHECK__INCLUDED_LOCATION_CONFLICTUAL_ID, _issueCode);
          EObject _sourceEObject = it.getSourceEObject();
          String _uri = ((Location) _sourceEObject).getUri();
          Assert.assertEquals("locationURI1", _uri);
          EObject _sourceEObject_1 = it.getSourceEObject();
          Resource _eResource = ((Location) _sourceEObject_1).eResource();
          URI _uRI = _eResource.getURI();
          String _string = _uRI.toString();
          Assert.assertEquals("tmp:/a.tpd", _string);
        }
      };
      IterableExtensions.<AbstractValidationDiagnostic>forEach(diagnotics, _function_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void checkSameIDForAllLocationWithSameURI13() {
    try {
      final ValidatorTester<TargetPlatformValidator> tester = new ValidatorTester<TargetPlatformValidator>(this.validator, this.validatorRegistrar, this.languageName);
      final XtextResourceSet resourceSet = this.resourceSetProvider.get();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"tp.a\"");
      _builder.newLine();
      _builder.append("include \"b.tpd\"");
      _builder.newLine();
      _builder.append("location A \"locationURI1\"");
      _builder.newLine();
      URI _createURI = URI.createURI("tmp:/a.tpd");
      final TargetPlatform tpa = this.parser.parse(_builder, _createURI, resourceSet);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("target \"tp.b\"");
      _builder_1.newLine();
      _builder_1.append("location \"locationURI1\"");
      _builder_1.newLine();
      URI _createURI_1 = URI.createURI("tmp:/b.tpd");
      this.parser.parse(_builder_1, _createURI_1, resourceSet);
      Resource _eResource = tpa.eResource();
      EList<Resource.Diagnostic> _errors = _eResource.getErrors();
      boolean _isEmpty = _errors.isEmpty();
      Assert.assertTrue(_isEmpty);
      TargetPlatformValidator _validator = tester.validator();
      _validator.checkSameIDForAllLocationWithSameURI(tpa);
      AssertableDiagnostics _diagnose = tester.diagnose();
      Iterable<Diagnostic> _allDiagnostics = _diagnose.getAllDiagnostics();
      Iterable<AbstractValidationDiagnostic> _filter = Iterables.<AbstractValidationDiagnostic>filter(_allDiagnostics, AbstractValidationDiagnostic.class);
      final List<AbstractValidationDiagnostic> diagnotics = IterableExtensions.<AbstractValidationDiagnostic>toList(_filter);
      int _size = diagnotics.size();
      Assert.assertEquals(1, _size);
      final Function1<AbstractValidationDiagnostic, Boolean> _function = new Function1<AbstractValidationDiagnostic, Boolean>() {
        public Boolean apply(final AbstractValidationDiagnostic it) {
          EObject _sourceEObject = it.getSourceEObject();
          return Boolean.valueOf((_sourceEObject instanceof Location));
        }
      };
      boolean _forall = IterableExtensions.<AbstractValidationDiagnostic>forall(diagnotics, _function);
      Assert.assertTrue(_forall);
      final Procedure1<AbstractValidationDiagnostic> _function_1 = new Procedure1<AbstractValidationDiagnostic>() {
        public void apply(final AbstractValidationDiagnostic it) {
          String _issueCode = it.getIssueCode();
          Assert.assertEquals(TargetPlatformValidator.CHECK__INCLUDED_LOCATION_CONFLICTUAL_ID, _issueCode);
          EObject _sourceEObject = it.getSourceEObject();
          String _uri = ((Location) _sourceEObject).getUri();
          Assert.assertEquals("locationURI1", _uri);
          EObject _sourceEObject_1 = it.getSourceEObject();
          Resource _eResource = ((Location) _sourceEObject_1).eResource();
          URI _uRI = _eResource.getURI();
          String _string = _uRI.toString();
          Assert.assertEquals("tmp:/a.tpd", _string);
        }
      };
      IterableExtensions.<AbstractValidationDiagnostic>forEach(diagnotics, _function_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void checkSameIDForAllLocationWithSameURI14() {
    try {
      final ValidatorTester<TargetPlatformValidator> tester = new ValidatorTester<TargetPlatformValidator>(this.validator, this.validatorRegistrar, this.languageName);
      final XtextResourceSet resourceSet = this.resourceSetProvider.get();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"tp.a\"");
      _builder.newLine();
      _builder.append("include \"b.tpd\"");
      _builder.newLine();
      _builder.append("location A \"locationURI1\"");
      _builder.newLine();
      URI _createURI = URI.createURI("tmp:/a.tpd");
      final TargetPlatform tpa = this.parser.parse(_builder, _createURI, resourceSet);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("target \"tp.b\"");
      _builder_1.newLine();
      _builder_1.append("location A \"locationURI2\"");
      _builder_1.newLine();
      URI _createURI_1 = URI.createURI("tmp:/b.tpd");
      this.parser.parse(_builder_1, _createURI_1, resourceSet);
      Resource _eResource = tpa.eResource();
      EList<Resource.Diagnostic> _errors = _eResource.getErrors();
      boolean _isEmpty = _errors.isEmpty();
      Assert.assertTrue(_isEmpty);
      TargetPlatformValidator _validator = tester.validator();
      _validator.checkSameIDForAllLocationWithSameURI(tpa);
      AssertableDiagnostics _diagnose = tester.diagnose();
      Iterable<Diagnostic> _allDiagnostics = _diagnose.getAllDiagnostics();
      Iterable<AbstractValidationDiagnostic> _filter = Iterables.<AbstractValidationDiagnostic>filter(_allDiagnostics, AbstractValidationDiagnostic.class);
      final List<AbstractValidationDiagnostic> diagnotics = IterableExtensions.<AbstractValidationDiagnostic>toList(_filter);
      int _size = diagnotics.size();
      Assert.assertEquals(0, _size);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void checkSameIDForAllLocationWithSameURI15() {
    try {
      final ValidatorTester<TargetPlatformValidator> tester = new ValidatorTester<TargetPlatformValidator>(this.validator, this.validatorRegistrar, this.languageName);
      final XtextResourceSet resourceSet = this.resourceSetProvider.get();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"tp.a\"");
      _builder.newLine();
      _builder.append("include \"b.tpd\"");
      _builder.newLine();
      _builder.append("location A \"locationURI1\"");
      _builder.newLine();
      URI _createURI = URI.createURI("tmp:/a.tpd");
      final TargetPlatform tpa = this.parser.parse(_builder, _createURI, resourceSet);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("target \"tp.b\"");
      _builder_1.newLine();
      _builder_1.append("include \"c.tpd\"");
      _builder_1.newLine();
      _builder_1.append("location A \"locationURI1\"");
      _builder_1.newLine();
      URI _createURI_1 = URI.createURI("tmp:/b.tpd");
      this.parser.parse(_builder_1, _createURI_1, resourceSet);
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("target \"tp.c\"");
      _builder_2.newLine();
      _builder_2.append("location A \"locationURI1\"");
      _builder_2.newLine();
      URI _createURI_2 = URI.createURI("tmp:/c.tpd");
      this.parser.parse(_builder_2, _createURI_2, resourceSet);
      Resource _eResource = tpa.eResource();
      EList<Resource.Diagnostic> _errors = _eResource.getErrors();
      boolean _isEmpty = _errors.isEmpty();
      Assert.assertTrue(_isEmpty);
      TargetPlatformValidator _validator = tester.validator();
      _validator.checkSameIDForAllLocationWithSameURI(tpa);
      AssertableDiagnostics _diagnose = tester.diagnose();
      Iterable<Diagnostic> _allDiagnostics = _diagnose.getAllDiagnostics();
      Iterable<AbstractValidationDiagnostic> _filter = Iterables.<AbstractValidationDiagnostic>filter(_allDiagnostics, AbstractValidationDiagnostic.class);
      final List<AbstractValidationDiagnostic> diagnotics = IterableExtensions.<AbstractValidationDiagnostic>toList(_filter);
      int _size = diagnotics.size();
      Assert.assertEquals(0, _size);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void checkSameIDForAllLocationWithSameURI16() {
    try {
      final ValidatorTester<TargetPlatformValidator> tester = new ValidatorTester<TargetPlatformValidator>(this.validator, this.validatorRegistrar, this.languageName);
      final XtextResourceSet resourceSet = this.resourceSetProvider.get();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"tp.a\"");
      _builder.newLine();
      _builder.append("include \"b.tpd\"");
      _builder.newLine();
      _builder.append("location A \"locationURI1\"");
      _builder.newLine();
      URI _createURI = URI.createURI("tmp:/a.tpd");
      final TargetPlatform tpa = this.parser.parse(_builder, _createURI, resourceSet);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("target \"tp.b\"");
      _builder_1.newLine();
      _builder_1.append("include \"c.tpd\"");
      _builder_1.newLine();
      _builder_1.append("location A \"locationURI1\"");
      _builder_1.newLine();
      URI _createURI_1 = URI.createURI("tmp:/b.tpd");
      final TargetPlatform tpb = this.parser.parse(_builder_1, _createURI_1, resourceSet);
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("target \"tp.c\"");
      _builder_2.newLine();
      _builder_2.append("location C \"locationURI1\"");
      _builder_2.newLine();
      URI _createURI_2 = URI.createURI("tmp:/c.tpd");
      final TargetPlatform tpc = this.parser.parse(_builder_2, _createURI_2, resourceSet);
      Resource _eResource = tpa.eResource();
      EList<Resource.Diagnostic> _errors = _eResource.getErrors();
      boolean _isEmpty = _errors.isEmpty();
      Assert.assertTrue(_isEmpty);
      TargetPlatformValidator _validator = tester.validator();
      _validator.checkSameIDForAllLocationWithSameURI(tpa);
      AssertableDiagnostics _diagnose = tester.diagnose();
      Iterable<Diagnostic> _allDiagnostics = _diagnose.getAllDiagnostics();
      Iterable<AbstractValidationDiagnostic> _filter = Iterables.<AbstractValidationDiagnostic>filter(_allDiagnostics, AbstractValidationDiagnostic.class);
      List<AbstractValidationDiagnostic> diagnotics = IterableExtensions.<AbstractValidationDiagnostic>toList(_filter);
      int _size = diagnotics.size();
      Assert.assertEquals(1, _size);
      final Function1<AbstractValidationDiagnostic, Boolean> _function = new Function1<AbstractValidationDiagnostic, Boolean>() {
        public Boolean apply(final AbstractValidationDiagnostic it) {
          EObject _sourceEObject = it.getSourceEObject();
          return Boolean.valueOf((_sourceEObject instanceof IncludeDeclaration));
        }
      };
      boolean _forall = IterableExtensions.<AbstractValidationDiagnostic>forall(diagnotics, _function);
      Assert.assertTrue(_forall);
      final Procedure1<AbstractValidationDiagnostic> _function_1 = new Procedure1<AbstractValidationDiagnostic>() {
        public void apply(final AbstractValidationDiagnostic it) {
          String _issueCode = it.getIssueCode();
          Assert.assertEquals(TargetPlatformValidator.CHECK__CONFLICTUAL_ID__BETWEEN_INCLUDED_LOCATION, _issueCode);
          EObject _sourceEObject = it.getSourceEObject();
          String _importURI = ((IncludeDeclaration) _sourceEObject).getImportURI();
          Assert.assertEquals("b.tpd", _importURI);
          EObject _sourceEObject_1 = it.getSourceEObject();
          Resource _eResource = ((IncludeDeclaration) _sourceEObject_1).eResource();
          URI _uRI = _eResource.getURI();
          String _string = _uRI.toString();
          Assert.assertEquals("tmp:/a.tpd", _string);
        }
      };
      IterableExtensions.<AbstractValidationDiagnostic>forEach(diagnotics, _function_1);
      Resource _eResource_1 = tpb.eResource();
      EList<Resource.Diagnostic> _errors_1 = _eResource_1.getErrors();
      boolean _isEmpty_1 = _errors_1.isEmpty();
      Assert.assertTrue(_isEmpty_1);
      TargetPlatformValidator _validator_1 = tester.validator();
      _validator_1.checkSameIDForAllLocationWithSameURI(tpb);
      AssertableDiagnostics _diagnose_1 = tester.diagnose();
      Iterable<Diagnostic> _allDiagnostics_1 = _diagnose_1.getAllDiagnostics();
      Iterable<AbstractValidationDiagnostic> _filter_1 = Iterables.<AbstractValidationDiagnostic>filter(_allDiagnostics_1, AbstractValidationDiagnostic.class);
      List<AbstractValidationDiagnostic> _list = IterableExtensions.<AbstractValidationDiagnostic>toList(_filter_1);
      diagnotics = _list;
      int _size_1 = diagnotics.size();
      Assert.assertEquals(1, _size_1);
      final Function1<AbstractValidationDiagnostic, Boolean> _function_2 = new Function1<AbstractValidationDiagnostic, Boolean>() {
        public Boolean apply(final AbstractValidationDiagnostic it) {
          EObject _sourceEObject = it.getSourceEObject();
          return Boolean.valueOf((_sourceEObject instanceof Location));
        }
      };
      boolean _forall_1 = IterableExtensions.<AbstractValidationDiagnostic>forall(diagnotics, _function_2);
      Assert.assertTrue(_forall_1);
      final Procedure1<AbstractValidationDiagnostic> _function_3 = new Procedure1<AbstractValidationDiagnostic>() {
        public void apply(final AbstractValidationDiagnostic it) {
          String _issueCode = it.getIssueCode();
          Assert.assertEquals(TargetPlatformValidator.CHECK__INCLUDED_LOCATION_CONFLICTUAL_ID, _issueCode);
          EObject _sourceEObject = it.getSourceEObject();
          String _uri = ((Location) _sourceEObject).getUri();
          Assert.assertEquals("locationURI1", _uri);
          EObject _sourceEObject_1 = it.getSourceEObject();
          Resource _eResource = ((Location) _sourceEObject_1).eResource();
          URI _uRI = _eResource.getURI();
          String _string = _uRI.toString();
          Assert.assertEquals("tmp:/b.tpd", _string);
        }
      };
      IterableExtensions.<AbstractValidationDiagnostic>forEach(diagnotics, _function_3);
      Resource _eResource_2 = tpc.eResource();
      EList<Resource.Diagnostic> _errors_2 = _eResource_2.getErrors();
      boolean _isEmpty_2 = _errors_2.isEmpty();
      Assert.assertTrue(_isEmpty_2);
      TargetPlatformValidator _validator_2 = tester.validator();
      _validator_2.checkSameIDForAllLocationWithSameURI(tpc);
      AssertableDiagnostics _diagnose_2 = tester.diagnose();
      Iterable<Diagnostic> _allDiagnostics_2 = _diagnose_2.getAllDiagnostics();
      Iterable<AbstractValidationDiagnostic> _filter_2 = Iterables.<AbstractValidationDiagnostic>filter(_allDiagnostics_2, AbstractValidationDiagnostic.class);
      List<AbstractValidationDiagnostic> _list_1 = IterableExtensions.<AbstractValidationDiagnostic>toList(_filter_2);
      diagnotics = _list_1;
      int _size_2 = diagnotics.size();
      Assert.assertEquals(0, _size_2);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void checkSameIDForAllLocationWithSameURI17() {
    try {
      final ValidatorTester<TargetPlatformValidator> tester = new ValidatorTester<TargetPlatformValidator>(this.validator, this.validatorRegistrar, this.languageName);
      final XtextResourceSet resourceSet = this.resourceSetProvider.get();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"tp.a\"");
      _builder.newLine();
      _builder.append("include \"b.tpd\"");
      _builder.newLine();
      _builder.append("location A \"locationURI1\"");
      _builder.newLine();
      URI _createURI = URI.createURI("tmp:/a.tpd");
      final TargetPlatform tpa = this.parser.parse(_builder, _createURI, resourceSet);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("target \"tp.b\"");
      _builder_1.newLine();
      _builder_1.append("include \"c.tpd\"");
      _builder_1.newLine();
      _builder_1.append("location B \"locationURI1\"");
      _builder_1.newLine();
      URI _createURI_1 = URI.createURI("tmp:/b.tpd");
      final TargetPlatform tpb = this.parser.parse(_builder_1, _createURI_1, resourceSet);
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("target \"tp.c\"");
      _builder_2.newLine();
      _builder_2.append("location A \"locationURI1\"");
      _builder_2.newLine();
      URI _createURI_2 = URI.createURI("tmp:/c.tpd");
      final TargetPlatform tpc = this.parser.parse(_builder_2, _createURI_2, resourceSet);
      Resource _eResource = tpa.eResource();
      EList<Resource.Diagnostic> _errors = _eResource.getErrors();
      boolean _isEmpty = _errors.isEmpty();
      Assert.assertTrue(_isEmpty);
      TargetPlatformValidator _validator = tester.validator();
      _validator.checkSameIDForAllLocationWithSameURI(tpa);
      AssertableDiagnostics _diagnose = tester.diagnose();
      Iterable<Diagnostic> _allDiagnostics = _diagnose.getAllDiagnostics();
      Iterable<AbstractValidationDiagnostic> _filter = Iterables.<AbstractValidationDiagnostic>filter(_allDiagnostics, AbstractValidationDiagnostic.class);
      List<AbstractValidationDiagnostic> diagnotics = IterableExtensions.<AbstractValidationDiagnostic>toList(_filter);
      int _size = diagnotics.size();
      Assert.assertEquals(1, _size);
      final Function1<AbstractValidationDiagnostic, Boolean> _function = new Function1<AbstractValidationDiagnostic, Boolean>() {
        public Boolean apply(final AbstractValidationDiagnostic it) {
          EObject _sourceEObject = it.getSourceEObject();
          return Boolean.valueOf((_sourceEObject instanceof IncludeDeclaration));
        }
      };
      boolean _forall = IterableExtensions.<AbstractValidationDiagnostic>forall(diagnotics, _function);
      Assert.assertTrue(_forall);
      final Procedure1<AbstractValidationDiagnostic> _function_1 = new Procedure1<AbstractValidationDiagnostic>() {
        public void apply(final AbstractValidationDiagnostic it) {
          String _issueCode = it.getIssueCode();
          Assert.assertEquals(TargetPlatformValidator.CHECK__CONFLICTUAL_ID__BETWEEN_INCLUDED_LOCATION, _issueCode);
          EObject _sourceEObject = it.getSourceEObject();
          String _importURI = ((IncludeDeclaration) _sourceEObject).getImportURI();
          Assert.assertEquals("b.tpd", _importURI);
          EObject _sourceEObject_1 = it.getSourceEObject();
          Resource _eResource = ((IncludeDeclaration) _sourceEObject_1).eResource();
          URI _uRI = _eResource.getURI();
          String _string = _uRI.toString();
          Assert.assertEquals("tmp:/a.tpd", _string);
        }
      };
      IterableExtensions.<AbstractValidationDiagnostic>forEach(diagnotics, _function_1);
      Resource _eResource_1 = tpb.eResource();
      EList<Resource.Diagnostic> _errors_1 = _eResource_1.getErrors();
      boolean _isEmpty_1 = _errors_1.isEmpty();
      Assert.assertTrue(_isEmpty_1);
      TargetPlatformValidator _validator_1 = tester.validator();
      _validator_1.checkSameIDForAllLocationWithSameURI(tpb);
      AssertableDiagnostics _diagnose_1 = tester.diagnose();
      Iterable<Diagnostic> _allDiagnostics_1 = _diagnose_1.getAllDiagnostics();
      Iterable<AbstractValidationDiagnostic> _filter_1 = Iterables.<AbstractValidationDiagnostic>filter(_allDiagnostics_1, AbstractValidationDiagnostic.class);
      List<AbstractValidationDiagnostic> _list = IterableExtensions.<AbstractValidationDiagnostic>toList(_filter_1);
      diagnotics = _list;
      int _size_1 = diagnotics.size();
      Assert.assertEquals(1, _size_1);
      final Function1<AbstractValidationDiagnostic, Boolean> _function_2 = new Function1<AbstractValidationDiagnostic, Boolean>() {
        public Boolean apply(final AbstractValidationDiagnostic it) {
          EObject _sourceEObject = it.getSourceEObject();
          return Boolean.valueOf((_sourceEObject instanceof Location));
        }
      };
      boolean _forall_1 = IterableExtensions.<AbstractValidationDiagnostic>forall(diagnotics, _function_2);
      Assert.assertTrue(_forall_1);
      final Procedure1<AbstractValidationDiagnostic> _function_3 = new Procedure1<AbstractValidationDiagnostic>() {
        public void apply(final AbstractValidationDiagnostic it) {
          String _issueCode = it.getIssueCode();
          Assert.assertEquals(TargetPlatformValidator.CHECK__INCLUDED_LOCATION_CONFLICTUAL_ID, _issueCode);
          EObject _sourceEObject = it.getSourceEObject();
          String _uri = ((Location) _sourceEObject).getUri();
          Assert.assertEquals("locationURI1", _uri);
          EObject _sourceEObject_1 = it.getSourceEObject();
          Resource _eResource = ((Location) _sourceEObject_1).eResource();
          URI _uRI = _eResource.getURI();
          String _string = _uRI.toString();
          Assert.assertEquals("tmp:/b.tpd", _string);
        }
      };
      IterableExtensions.<AbstractValidationDiagnostic>forEach(diagnotics, _function_3);
      Resource _eResource_2 = tpc.eResource();
      EList<Resource.Diagnostic> _errors_2 = _eResource_2.getErrors();
      boolean _isEmpty_2 = _errors_2.isEmpty();
      Assert.assertTrue(_isEmpty_2);
      TargetPlatformValidator _validator_2 = tester.validator();
      _validator_2.checkSameIDForAllLocationWithSameURI(tpc);
      AssertableDiagnostics _diagnose_2 = tester.diagnose();
      Iterable<Diagnostic> _allDiagnostics_2 = _diagnose_2.getAllDiagnostics();
      Iterable<AbstractValidationDiagnostic> _filter_2 = Iterables.<AbstractValidationDiagnostic>filter(_allDiagnostics_2, AbstractValidationDiagnostic.class);
      List<AbstractValidationDiagnostic> _list_1 = IterableExtensions.<AbstractValidationDiagnostic>toList(_filter_2);
      diagnotics = _list_1;
      int _size_2 = diagnotics.size();
      Assert.assertEquals(0, _size_2);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void checkSameIDForAllLocationWithSameURI18() {
    try {
      final ValidatorTester<TargetPlatformValidator> tester = new ValidatorTester<TargetPlatformValidator>(this.validator, this.validatorRegistrar, this.languageName);
      final XtextResourceSet resourceSet = this.resourceSetProvider.get();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"tp.a\"");
      _builder.newLine();
      _builder.append("include \"b.tpd\"");
      _builder.newLine();
      _builder.append("location A \"locationURI1\"");
      _builder.newLine();
      URI _createURI = URI.createURI("tmp:/a.tpd");
      final TargetPlatform tpa = this.parser.parse(_builder, _createURI, resourceSet);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("target \"tp.b\"");
      _builder_1.newLine();
      _builder_1.append("include \"c.tpd\"");
      _builder_1.newLine();
      _builder_1.append("location A \"locationURI1\"");
      _builder_1.newLine();
      URI _createURI_1 = URI.createURI("tmp:/b.tpd");
      final TargetPlatform tpb = this.parser.parse(_builder_1, _createURI_1, resourceSet);
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("target \"tp.c\"");
      _builder_2.newLine();
      _builder_2.append("location \"locationURI1\"");
      _builder_2.newLine();
      URI _createURI_2 = URI.createURI("tmp:/c.tpd");
      final TargetPlatform tpc = this.parser.parse(_builder_2, _createURI_2, resourceSet);
      Resource _eResource = tpa.eResource();
      EList<Resource.Diagnostic> _errors = _eResource.getErrors();
      boolean _isEmpty = _errors.isEmpty();
      Assert.assertTrue(_isEmpty);
      TargetPlatformValidator _validator = tester.validator();
      _validator.checkSameIDForAllLocationWithSameURI(tpa);
      AssertableDiagnostics _diagnose = tester.diagnose();
      Iterable<Diagnostic> _allDiagnostics = _diagnose.getAllDiagnostics();
      Iterable<AbstractValidationDiagnostic> _filter = Iterables.<AbstractValidationDiagnostic>filter(_allDiagnostics, AbstractValidationDiagnostic.class);
      List<AbstractValidationDiagnostic> diagnotics = IterableExtensions.<AbstractValidationDiagnostic>toList(_filter);
      int _size = diagnotics.size();
      Assert.assertEquals(1, _size);
      final Function1<AbstractValidationDiagnostic, Boolean> _function = new Function1<AbstractValidationDiagnostic, Boolean>() {
        public Boolean apply(final AbstractValidationDiagnostic it) {
          EObject _sourceEObject = it.getSourceEObject();
          return Boolean.valueOf((_sourceEObject instanceof IncludeDeclaration));
        }
      };
      boolean _forall = IterableExtensions.<AbstractValidationDiagnostic>forall(diagnotics, _function);
      Assert.assertTrue(_forall);
      final Procedure1<AbstractValidationDiagnostic> _function_1 = new Procedure1<AbstractValidationDiagnostic>() {
        public void apply(final AbstractValidationDiagnostic it) {
          String _issueCode = it.getIssueCode();
          Assert.assertEquals(TargetPlatformValidator.CHECK__CONFLICTUAL_ID__BETWEEN_INCLUDED_LOCATION, _issueCode);
          EObject _sourceEObject = it.getSourceEObject();
          String _importURI = ((IncludeDeclaration) _sourceEObject).getImportURI();
          Assert.assertEquals("b.tpd", _importURI);
          EObject _sourceEObject_1 = it.getSourceEObject();
          Resource _eResource = ((IncludeDeclaration) _sourceEObject_1).eResource();
          URI _uRI = _eResource.getURI();
          String _string = _uRI.toString();
          Assert.assertEquals("tmp:/a.tpd", _string);
        }
      };
      IterableExtensions.<AbstractValidationDiagnostic>forEach(diagnotics, _function_1);
      Resource _eResource_1 = tpb.eResource();
      EList<Resource.Diagnostic> _errors_1 = _eResource_1.getErrors();
      boolean _isEmpty_1 = _errors_1.isEmpty();
      Assert.assertTrue(_isEmpty_1);
      TargetPlatformValidator _validator_1 = tester.validator();
      _validator_1.checkSameIDForAllLocationWithSameURI(tpb);
      AssertableDiagnostics _diagnose_1 = tester.diagnose();
      Iterable<Diagnostic> _allDiagnostics_1 = _diagnose_1.getAllDiagnostics();
      Iterable<AbstractValidationDiagnostic> _filter_1 = Iterables.<AbstractValidationDiagnostic>filter(_allDiagnostics_1, AbstractValidationDiagnostic.class);
      List<AbstractValidationDiagnostic> _list = IterableExtensions.<AbstractValidationDiagnostic>toList(_filter_1);
      diagnotics = _list;
      int _size_1 = diagnotics.size();
      Assert.assertEquals(1, _size_1);
      final Function1<AbstractValidationDiagnostic, Boolean> _function_2 = new Function1<AbstractValidationDiagnostic, Boolean>() {
        public Boolean apply(final AbstractValidationDiagnostic it) {
          EObject _sourceEObject = it.getSourceEObject();
          return Boolean.valueOf((_sourceEObject instanceof Location));
        }
      };
      boolean _forall_1 = IterableExtensions.<AbstractValidationDiagnostic>forall(diagnotics, _function_2);
      Assert.assertTrue(_forall_1);
      final Procedure1<AbstractValidationDiagnostic> _function_3 = new Procedure1<AbstractValidationDiagnostic>() {
        public void apply(final AbstractValidationDiagnostic it) {
          String _issueCode = it.getIssueCode();
          Assert.assertEquals(TargetPlatformValidator.CHECK__INCLUDED_LOCATION_CONFLICTUAL_ID, _issueCode);
          EObject _sourceEObject = it.getSourceEObject();
          String _uri = ((Location) _sourceEObject).getUri();
          Assert.assertEquals("locationURI1", _uri);
          EObject _sourceEObject_1 = it.getSourceEObject();
          Resource _eResource = ((Location) _sourceEObject_1).eResource();
          URI _uRI = _eResource.getURI();
          String _string = _uRI.toString();
          Assert.assertEquals("tmp:/b.tpd", _string);
        }
      };
      IterableExtensions.<AbstractValidationDiagnostic>forEach(diagnotics, _function_3);
      Resource _eResource_2 = tpc.eResource();
      EList<Resource.Diagnostic> _errors_2 = _eResource_2.getErrors();
      boolean _isEmpty_2 = _errors_2.isEmpty();
      Assert.assertTrue(_isEmpty_2);
      TargetPlatformValidator _validator_2 = tester.validator();
      _validator_2.checkSameIDForAllLocationWithSameURI(tpc);
      AssertableDiagnostics _diagnose_2 = tester.diagnose();
      Iterable<Diagnostic> _allDiagnostics_2 = _diagnose_2.getAllDiagnostics();
      Iterable<AbstractValidationDiagnostic> _filter_2 = Iterables.<AbstractValidationDiagnostic>filter(_allDiagnostics_2, AbstractValidationDiagnostic.class);
      List<AbstractValidationDiagnostic> _list_1 = IterableExtensions.<AbstractValidationDiagnostic>toList(_filter_2);
      diagnotics = _list_1;
      int _size_2 = diagnotics.size();
      Assert.assertEquals(0, _size_2);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void checkSameIDForAllLocationWithSameURI19() {
    try {
      final ValidatorTester<TargetPlatformValidator> tester = new ValidatorTester<TargetPlatformValidator>(this.validator, this.validatorRegistrar, this.languageName);
      final XtextResourceSet resourceSet = this.resourceSetProvider.get();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"tp.a\"");
      _builder.newLine();
      _builder.append("include \"b.tpd\"");
      _builder.newLine();
      _builder.append("location \"locationURI1\"");
      _builder.newLine();
      URI _createURI = URI.createURI("tmp:/a.tpd");
      final TargetPlatform tpa = this.parser.parse(_builder, _createURI, resourceSet);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("target \"tp.b\"");
      _builder_1.newLine();
      _builder_1.append("include \"c.tpd\"");
      _builder_1.newLine();
      _builder_1.append("location \"locationURI1\"");
      _builder_1.newLine();
      URI _createURI_1 = URI.createURI("tmp:/b.tpd");
      this.parser.parse(_builder_1, _createURI_1, resourceSet);
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("target \"tp.c\"");
      _builder_2.newLine();
      _builder_2.append("location \"locationURI1\"");
      _builder_2.newLine();
      URI _createURI_2 = URI.createURI("tmp:/c.tpd");
      this.parser.parse(_builder_2, _createURI_2, resourceSet);
      Resource _eResource = tpa.eResource();
      EList<Resource.Diagnostic> _errors = _eResource.getErrors();
      boolean _isEmpty = _errors.isEmpty();
      Assert.assertTrue(_isEmpty);
      TargetPlatformValidator _validator = tester.validator();
      _validator.checkSameIDForAllLocationWithSameURI(tpa);
      AssertableDiagnostics _diagnose = tester.diagnose();
      Iterable<Diagnostic> _allDiagnostics = _diagnose.getAllDiagnostics();
      Iterable<AbstractValidationDiagnostic> _filter = Iterables.<AbstractValidationDiagnostic>filter(_allDiagnostics, AbstractValidationDiagnostic.class);
      final List<AbstractValidationDiagnostic> diagnotics = IterableExtensions.<AbstractValidationDiagnostic>toList(_filter);
      int _size = diagnotics.size();
      Assert.assertEquals(0, _size);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void checkSameIDForAllLocationWithSameURI20() {
    try {
      final ValidatorTester<TargetPlatformValidator> tester = new ValidatorTester<TargetPlatformValidator>(this.validator, this.validatorRegistrar, this.languageName);
      final XtextResourceSet resourceSet = this.resourceSetProvider.get();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"tp.a\"");
      _builder.newLine();
      _builder.append("include \"b.tpd\"");
      _builder.newLine();
      _builder.append("location \"locationURI1\"");
      _builder.newLine();
      URI _createURI = URI.createURI("tmp:/a.tpd");
      final TargetPlatform tpa = this.parser.parse(_builder, _createURI, resourceSet);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("target \"tp.b\"");
      _builder_1.newLine();
      _builder_1.append("include \"c.tpd\"");
      _builder_1.newLine();
      _builder_1.append("location \"locationURI1\"");
      _builder_1.newLine();
      URI _createURI_1 = URI.createURI("tmp:/b.tpd");
      final TargetPlatform tpb = this.parser.parse(_builder_1, _createURI_1, resourceSet);
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("target \"tp.c\"");
      _builder_2.newLine();
      _builder_2.append("location C \"locationURI1\"");
      _builder_2.newLine();
      URI _createURI_2 = URI.createURI("tmp:/c.tpd");
      final TargetPlatform tpc = this.parser.parse(_builder_2, _createURI_2, resourceSet);
      Resource _eResource = tpa.eResource();
      EList<Resource.Diagnostic> _errors = _eResource.getErrors();
      boolean _isEmpty = _errors.isEmpty();
      Assert.assertTrue(_isEmpty);
      TargetPlatformValidator _validator = tester.validator();
      _validator.checkSameIDForAllLocationWithSameURI(tpa);
      AssertableDiagnostics _diagnose = tester.diagnose();
      Iterable<Diagnostic> _allDiagnostics = _diagnose.getAllDiagnostics();
      Iterable<AbstractValidationDiagnostic> _filter = Iterables.<AbstractValidationDiagnostic>filter(_allDiagnostics, AbstractValidationDiagnostic.class);
      List<AbstractValidationDiagnostic> diagnotics = IterableExtensions.<AbstractValidationDiagnostic>toList(_filter);
      int _size = diagnotics.size();
      Assert.assertEquals(1, _size);
      final Function1<AbstractValidationDiagnostic, Boolean> _function = new Function1<AbstractValidationDiagnostic, Boolean>() {
        public Boolean apply(final AbstractValidationDiagnostic it) {
          EObject _sourceEObject = it.getSourceEObject();
          return Boolean.valueOf((_sourceEObject instanceof IncludeDeclaration));
        }
      };
      boolean _forall = IterableExtensions.<AbstractValidationDiagnostic>forall(diagnotics, _function);
      Assert.assertTrue(_forall);
      final Procedure1<AbstractValidationDiagnostic> _function_1 = new Procedure1<AbstractValidationDiagnostic>() {
        public void apply(final AbstractValidationDiagnostic it) {
          String _issueCode = it.getIssueCode();
          Assert.assertEquals(TargetPlatformValidator.CHECK__CONFLICTUAL_ID__BETWEEN_INCLUDED_LOCATION, _issueCode);
          EObject _sourceEObject = it.getSourceEObject();
          String _importURI = ((IncludeDeclaration) _sourceEObject).getImportURI();
          Assert.assertEquals("b.tpd", _importURI);
          EObject _sourceEObject_1 = it.getSourceEObject();
          Resource _eResource = ((IncludeDeclaration) _sourceEObject_1).eResource();
          URI _uRI = _eResource.getURI();
          String _string = _uRI.toString();
          Assert.assertEquals("tmp:/a.tpd", _string);
        }
      };
      IterableExtensions.<AbstractValidationDiagnostic>forEach(diagnotics, _function_1);
      Resource _eResource_1 = tpb.eResource();
      EList<Resource.Diagnostic> _errors_1 = _eResource_1.getErrors();
      boolean _isEmpty_1 = _errors_1.isEmpty();
      Assert.assertTrue(_isEmpty_1);
      TargetPlatformValidator _validator_1 = tester.validator();
      _validator_1.checkSameIDForAllLocationWithSameURI(tpb);
      AssertableDiagnostics _diagnose_1 = tester.diagnose();
      Iterable<Diagnostic> _allDiagnostics_1 = _diagnose_1.getAllDiagnostics();
      Iterable<AbstractValidationDiagnostic> _filter_1 = Iterables.<AbstractValidationDiagnostic>filter(_allDiagnostics_1, AbstractValidationDiagnostic.class);
      List<AbstractValidationDiagnostic> _list = IterableExtensions.<AbstractValidationDiagnostic>toList(_filter_1);
      diagnotics = _list;
      int _size_1 = diagnotics.size();
      Assert.assertEquals(1, _size_1);
      final Function1<AbstractValidationDiagnostic, Boolean> _function_2 = new Function1<AbstractValidationDiagnostic, Boolean>() {
        public Boolean apply(final AbstractValidationDiagnostic it) {
          EObject _sourceEObject = it.getSourceEObject();
          return Boolean.valueOf((_sourceEObject instanceof Location));
        }
      };
      boolean _forall_1 = IterableExtensions.<AbstractValidationDiagnostic>forall(diagnotics, _function_2);
      Assert.assertTrue(_forall_1);
      final Procedure1<AbstractValidationDiagnostic> _function_3 = new Procedure1<AbstractValidationDiagnostic>() {
        public void apply(final AbstractValidationDiagnostic it) {
          String _issueCode = it.getIssueCode();
          Assert.assertEquals(TargetPlatformValidator.CHECK__INCLUDED_LOCATION_CONFLICTUAL_ID, _issueCode);
          EObject _sourceEObject = it.getSourceEObject();
          String _uri = ((Location) _sourceEObject).getUri();
          Assert.assertEquals("locationURI1", _uri);
          EObject _sourceEObject_1 = it.getSourceEObject();
          Resource _eResource = ((Location) _sourceEObject_1).eResource();
          URI _uRI = _eResource.getURI();
          String _string = _uRI.toString();
          Assert.assertEquals("tmp:/b.tpd", _string);
        }
      };
      IterableExtensions.<AbstractValidationDiagnostic>forEach(diagnotics, _function_3);
      Resource _eResource_2 = tpc.eResource();
      EList<Resource.Diagnostic> _errors_2 = _eResource_2.getErrors();
      boolean _isEmpty_2 = _errors_2.isEmpty();
      Assert.assertTrue(_isEmpty_2);
      TargetPlatformValidator _validator_2 = tester.validator();
      _validator_2.checkSameIDForAllLocationWithSameURI(tpc);
      AssertableDiagnostics _diagnose_2 = tester.diagnose();
      Iterable<Diagnostic> _allDiagnostics_2 = _diagnose_2.getAllDiagnostics();
      Iterable<AbstractValidationDiagnostic> _filter_2 = Iterables.<AbstractValidationDiagnostic>filter(_allDiagnostics_2, AbstractValidationDiagnostic.class);
      List<AbstractValidationDiagnostic> _list_1 = IterableExtensions.<AbstractValidationDiagnostic>toList(_filter_2);
      diagnotics = _list_1;
      int _size_2 = diagnotics.size();
      Assert.assertEquals(0, _size_2);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void checkSameIDForAllLocationWithSameURI21() {
    try {
      final ValidatorTester<TargetPlatformValidator> tester = new ValidatorTester<TargetPlatformValidator>(this.validator, this.validatorRegistrar, this.languageName);
      final XtextResourceSet resourceSet = this.resourceSetProvider.get();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"tp.a\"");
      _builder.newLine();
      _builder.append("include \"b.tpd\"");
      _builder.newLine();
      _builder.append("location \"locationURI1\"");
      _builder.newLine();
      URI _createURI = URI.createURI("tmp:/a.tpd");
      final TargetPlatform tpa = this.parser.parse(_builder, _createURI, resourceSet);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("target \"tp.b\"");
      _builder_1.newLine();
      _builder_1.append("include \"c.tpd\"");
      _builder_1.newLine();
      _builder_1.append("location A \"locationURI1\"");
      _builder_1.newLine();
      URI _createURI_1 = URI.createURI("tmp:/b.tpd");
      final TargetPlatform tpb = this.parser.parse(_builder_1, _createURI_1, resourceSet);
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("target \"tp.c\"");
      _builder_2.newLine();
      _builder_2.append("location \"locationURI1\"");
      _builder_2.newLine();
      URI _createURI_2 = URI.createURI("tmp:/c.tpd");
      final TargetPlatform tpc = this.parser.parse(_builder_2, _createURI_2, resourceSet);
      Resource _eResource = tpa.eResource();
      EList<Resource.Diagnostic> _errors = _eResource.getErrors();
      boolean _isEmpty = _errors.isEmpty();
      Assert.assertTrue(_isEmpty);
      TargetPlatformValidator _validator = tester.validator();
      _validator.checkSameIDForAllLocationWithSameURI(tpa);
      AssertableDiagnostics _diagnose = tester.diagnose();
      Iterable<Diagnostic> _allDiagnostics = _diagnose.getAllDiagnostics();
      Iterable<AbstractValidationDiagnostic> _filter = Iterables.<AbstractValidationDiagnostic>filter(_allDiagnostics, AbstractValidationDiagnostic.class);
      List<AbstractValidationDiagnostic> diagnotics = IterableExtensions.<AbstractValidationDiagnostic>toList(_filter);
      int _size = diagnotics.size();
      Assert.assertEquals(1, _size);
      final Function1<AbstractValidationDiagnostic, Boolean> _function = new Function1<AbstractValidationDiagnostic, Boolean>() {
        public Boolean apply(final AbstractValidationDiagnostic it) {
          EObject _sourceEObject = it.getSourceEObject();
          return Boolean.valueOf((_sourceEObject instanceof IncludeDeclaration));
        }
      };
      boolean _forall = IterableExtensions.<AbstractValidationDiagnostic>forall(diagnotics, _function);
      Assert.assertTrue(_forall);
      final Procedure1<AbstractValidationDiagnostic> _function_1 = new Procedure1<AbstractValidationDiagnostic>() {
        public void apply(final AbstractValidationDiagnostic it) {
          String _issueCode = it.getIssueCode();
          Assert.assertEquals(TargetPlatformValidator.CHECK__CONFLICTUAL_ID__BETWEEN_INCLUDED_LOCATION, _issueCode);
          EObject _sourceEObject = it.getSourceEObject();
          String _importURI = ((IncludeDeclaration) _sourceEObject).getImportURI();
          Assert.assertEquals("b.tpd", _importURI);
          EObject _sourceEObject_1 = it.getSourceEObject();
          Resource _eResource = ((IncludeDeclaration) _sourceEObject_1).eResource();
          URI _uRI = _eResource.getURI();
          String _string = _uRI.toString();
          Assert.assertEquals("tmp:/a.tpd", _string);
        }
      };
      IterableExtensions.<AbstractValidationDiagnostic>forEach(diagnotics, _function_1);
      Resource _eResource_1 = tpb.eResource();
      EList<Resource.Diagnostic> _errors_1 = _eResource_1.getErrors();
      boolean _isEmpty_1 = _errors_1.isEmpty();
      Assert.assertTrue(_isEmpty_1);
      TargetPlatformValidator _validator_1 = tester.validator();
      _validator_1.checkSameIDForAllLocationWithSameURI(tpb);
      AssertableDiagnostics _diagnose_1 = tester.diagnose();
      Iterable<Diagnostic> _allDiagnostics_1 = _diagnose_1.getAllDiagnostics();
      Iterable<AbstractValidationDiagnostic> _filter_1 = Iterables.<AbstractValidationDiagnostic>filter(_allDiagnostics_1, AbstractValidationDiagnostic.class);
      List<AbstractValidationDiagnostic> _list = IterableExtensions.<AbstractValidationDiagnostic>toList(_filter_1);
      diagnotics = _list;
      int _size_1 = diagnotics.size();
      Assert.assertEquals(1, _size_1);
      final Function1<AbstractValidationDiagnostic, Boolean> _function_2 = new Function1<AbstractValidationDiagnostic, Boolean>() {
        public Boolean apply(final AbstractValidationDiagnostic it) {
          EObject _sourceEObject = it.getSourceEObject();
          return Boolean.valueOf((_sourceEObject instanceof Location));
        }
      };
      boolean _forall_1 = IterableExtensions.<AbstractValidationDiagnostic>forall(diagnotics, _function_2);
      Assert.assertTrue(_forall_1);
      final Procedure1<AbstractValidationDiagnostic> _function_3 = new Procedure1<AbstractValidationDiagnostic>() {
        public void apply(final AbstractValidationDiagnostic it) {
          String _issueCode = it.getIssueCode();
          Assert.assertEquals(TargetPlatformValidator.CHECK__INCLUDED_LOCATION_CONFLICTUAL_ID, _issueCode);
          EObject _sourceEObject = it.getSourceEObject();
          String _uri = ((Location) _sourceEObject).getUri();
          Assert.assertEquals("locationURI1", _uri);
          EObject _sourceEObject_1 = it.getSourceEObject();
          Resource _eResource = ((Location) _sourceEObject_1).eResource();
          URI _uRI = _eResource.getURI();
          String _string = _uRI.toString();
          Assert.assertEquals("tmp:/b.tpd", _string);
        }
      };
      IterableExtensions.<AbstractValidationDiagnostic>forEach(diagnotics, _function_3);
      Resource _eResource_2 = tpc.eResource();
      EList<Resource.Diagnostic> _errors_2 = _eResource_2.getErrors();
      boolean _isEmpty_2 = _errors_2.isEmpty();
      Assert.assertTrue(_isEmpty_2);
      TargetPlatformValidator _validator_2 = tester.validator();
      _validator_2.checkSameIDForAllLocationWithSameURI(tpc);
      AssertableDiagnostics _diagnose_2 = tester.diagnose();
      Iterable<Diagnostic> _allDiagnostics_2 = _diagnose_2.getAllDiagnostics();
      Iterable<AbstractValidationDiagnostic> _filter_2 = Iterables.<AbstractValidationDiagnostic>filter(_allDiagnostics_2, AbstractValidationDiagnostic.class);
      List<AbstractValidationDiagnostic> _list_1 = IterableExtensions.<AbstractValidationDiagnostic>toList(_filter_2);
      diagnotics = _list_1;
      int _size_2 = diagnotics.size();
      Assert.assertEquals(0, _size_2);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void checkImportCycle1() {
    try {
      final ValidatorTester<TargetPlatformValidator> tester = new ValidatorTester<TargetPlatformValidator>(this.validator, this.validatorRegistrar, this.languageName);
      final XtextResourceSet resourceSet = this.resourceSetProvider.get();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"tp.a\"");
      _builder.newLine();
      URI _createURI = URI.createURI("tmp:/a.tpd");
      final TargetPlatform tpa = this.parser.parse(_builder, _createURI, resourceSet);
      Resource _eResource = tpa.eResource();
      EList<Resource.Diagnostic> _errors = _eResource.getErrors();
      boolean _isEmpty = _errors.isEmpty();
      Assert.assertTrue(_isEmpty);
      TargetPlatformValidator _validator = tester.validator();
      _validator.checkImportCycle(tpa);
      AssertableDiagnostics _diagnose = tester.diagnose();
      Iterable<Diagnostic> _allDiagnostics = _diagnose.getAllDiagnostics();
      Iterable<AbstractValidationDiagnostic> _filter = Iterables.<AbstractValidationDiagnostic>filter(_allDiagnostics, AbstractValidationDiagnostic.class);
      final List<AbstractValidationDiagnostic> diagnotics = IterableExtensions.<AbstractValidationDiagnostic>toList(_filter);
      int _size = diagnotics.size();
      Assert.assertEquals(0, _size);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void checkImportCycle2() {
    try {
      final ValidatorTester<TargetPlatformValidator> tester = new ValidatorTester<TargetPlatformValidator>(this.validator, this.validatorRegistrar, this.languageName);
      final XtextResourceSet resourceSet = this.resourceSetProvider.get();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"tp.a\"");
      _builder.newLine();
      _builder.append("include \"a.tpd\"");
      _builder.newLine();
      URI _createURI = URI.createURI("tmp:/a.tpd");
      final TargetPlatform tpa = this.parser.parse(_builder, _createURI, resourceSet);
      Resource _eResource = tpa.eResource();
      EList<Resource.Diagnostic> _errors = _eResource.getErrors();
      boolean _isEmpty = _errors.isEmpty();
      Assert.assertTrue(_isEmpty);
      TargetPlatformValidator _validator = tester.validator();
      _validator.checkImportCycle(tpa);
      AssertableDiagnostics _diagnose = tester.diagnose();
      Iterable<Diagnostic> _allDiagnostics = _diagnose.getAllDiagnostics();
      Iterable<AbstractValidationDiagnostic> _filter = Iterables.<AbstractValidationDiagnostic>filter(_allDiagnostics, AbstractValidationDiagnostic.class);
      final List<AbstractValidationDiagnostic> diagnotics = IterableExtensions.<AbstractValidationDiagnostic>toList(_filter);
      int _size = diagnotics.size();
      Assert.assertEquals(1, _size);
      final Function1<AbstractValidationDiagnostic, Boolean> _function = new Function1<AbstractValidationDiagnostic, Boolean>() {
        public Boolean apply(final AbstractValidationDiagnostic it) {
          EObject _sourceEObject = it.getSourceEObject();
          return Boolean.valueOf((_sourceEObject instanceof IncludeDeclaration));
        }
      };
      boolean _forall = IterableExtensions.<AbstractValidationDiagnostic>forall(diagnotics, _function);
      Assert.assertTrue(_forall);
      final Procedure1<AbstractValidationDiagnostic> _function_1 = new Procedure1<AbstractValidationDiagnostic>() {
        public void apply(final AbstractValidationDiagnostic it) {
          String _issueCode = it.getIssueCode();
          Assert.assertEquals(TargetPlatformValidator.CHECK__INCLUDE_CYCLE, _issueCode);
          EObject _sourceEObject = it.getSourceEObject();
          String _importURI = ((IncludeDeclaration) _sourceEObject).getImportURI();
          Assert.assertEquals("a.tpd", _importURI);
        }
      };
      IterableExtensions.<AbstractValidationDiagnostic>forEach(diagnotics, _function_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void checkImportCycle3() {
    try {
      final ValidatorTester<TargetPlatformValidator> tester = new ValidatorTester<TargetPlatformValidator>(this.validator, this.validatorRegistrar, this.languageName);
      final XtextResourceSet resourceSet = this.resourceSetProvider.get();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"tp.a\"");
      _builder.newLine();
      _builder.append("include \"b.tpd\"");
      _builder.newLine();
      URI _createURI = URI.createURI("tmp:/a.tpd");
      final TargetPlatform tpa = this.parser.parse(_builder, _createURI, resourceSet);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("target \"tp.b\"");
      _builder_1.newLine();
      _builder_1.append("include \"a.tpd\"");
      _builder_1.newLine();
      URI _createURI_1 = URI.createURI("tmp:/b.tpd");
      final TargetPlatform tpb = this.parser.parse(_builder_1, _createURI_1, resourceSet);
      Resource _eResource = tpa.eResource();
      EList<Resource.Diagnostic> _errors = _eResource.getErrors();
      boolean _isEmpty = _errors.isEmpty();
      Assert.assertTrue(_isEmpty);
      TargetPlatformValidator _validator = tester.validator();
      _validator.checkImportCycle(tpa);
      AssertableDiagnostics _diagnose = tester.diagnose();
      Iterable<Diagnostic> _allDiagnostics = _diagnose.getAllDiagnostics();
      Iterable<AbstractValidationDiagnostic> _filter = Iterables.<AbstractValidationDiagnostic>filter(_allDiagnostics, AbstractValidationDiagnostic.class);
      final List<AbstractValidationDiagnostic> diagnoticsa = IterableExtensions.<AbstractValidationDiagnostic>toList(_filter);
      int _size = diagnoticsa.size();
      Assert.assertEquals(1, _size);
      final Function1<AbstractValidationDiagnostic, Boolean> _function = new Function1<AbstractValidationDiagnostic, Boolean>() {
        public Boolean apply(final AbstractValidationDiagnostic it) {
          EObject _sourceEObject = it.getSourceEObject();
          return Boolean.valueOf((_sourceEObject instanceof IncludeDeclaration));
        }
      };
      boolean _forall = IterableExtensions.<AbstractValidationDiagnostic>forall(diagnoticsa, _function);
      Assert.assertTrue(_forall);
      final Procedure1<AbstractValidationDiagnostic> _function_1 = new Procedure1<AbstractValidationDiagnostic>() {
        public void apply(final AbstractValidationDiagnostic it) {
          String _issueCode = it.getIssueCode();
          Assert.assertEquals(TargetPlatformValidator.CHECK__INCLUDE_CYCLE, _issueCode);
          EObject _sourceEObject = it.getSourceEObject();
          String _importURI = ((IncludeDeclaration) _sourceEObject).getImportURI();
          Assert.assertEquals("b.tpd", _importURI);
        }
      };
      IterableExtensions.<AbstractValidationDiagnostic>forEach(diagnoticsa, _function_1);
      Resource _eResource_1 = tpb.eResource();
      EList<Resource.Diagnostic> _errors_1 = _eResource_1.getErrors();
      boolean _isEmpty_1 = _errors_1.isEmpty();
      Assert.assertTrue(_isEmpty_1);
      TargetPlatformValidator _validator_1 = tester.validator();
      _validator_1.checkImportCycle(tpb);
      AssertableDiagnostics _diagnose_1 = tester.diagnose();
      Iterable<Diagnostic> _allDiagnostics_1 = _diagnose_1.getAllDiagnostics();
      Iterable<AbstractValidationDiagnostic> _filter_1 = Iterables.<AbstractValidationDiagnostic>filter(_allDiagnostics_1, AbstractValidationDiagnostic.class);
      final List<AbstractValidationDiagnostic> diagnoticsb = IterableExtensions.<AbstractValidationDiagnostic>toList(_filter_1);
      int _size_1 = diagnoticsb.size();
      Assert.assertEquals(1, _size_1);
      final Function1<AbstractValidationDiagnostic, Boolean> _function_2 = new Function1<AbstractValidationDiagnostic, Boolean>() {
        public Boolean apply(final AbstractValidationDiagnostic it) {
          EObject _sourceEObject = it.getSourceEObject();
          return Boolean.valueOf((_sourceEObject instanceof IncludeDeclaration));
        }
      };
      boolean _forall_1 = IterableExtensions.<AbstractValidationDiagnostic>forall(diagnoticsb, _function_2);
      Assert.assertTrue(_forall_1);
      final Procedure1<AbstractValidationDiagnostic> _function_3 = new Procedure1<AbstractValidationDiagnostic>() {
        public void apply(final AbstractValidationDiagnostic it) {
          String _issueCode = it.getIssueCode();
          Assert.assertEquals(TargetPlatformValidator.CHECK__INCLUDE_CYCLE, _issueCode);
          EObject _sourceEObject = it.getSourceEObject();
          String _importURI = ((IncludeDeclaration) _sourceEObject).getImportURI();
          Assert.assertEquals("a.tpd", _importURI);
        }
      };
      IterableExtensions.<AbstractValidationDiagnostic>forEach(diagnoticsb, _function_3);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void checkImportCycle4() {
    try {
      final ValidatorTester<TargetPlatformValidator> tester = new ValidatorTester<TargetPlatformValidator>(this.validator, this.validatorRegistrar, this.languageName);
      final XtextResourceSet resourceSet = this.resourceSetProvider.get();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"tp.a\"");
      _builder.newLine();
      _builder.append("include \"b.tpd\"");
      _builder.newLine();
      URI _createURI = URI.createURI("tmp:/a.tpd");
      final TargetPlatform tpa = this.parser.parse(_builder, _createURI, resourceSet);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("target \"tp.b\"");
      _builder_1.newLine();
      _builder_1.append("include \"c.tpd\"");
      _builder_1.newLine();
      URI _createURI_1 = URI.createURI("tmp:/b.tpd");
      final TargetPlatform tpb = this.parser.parse(_builder_1, _createURI_1, resourceSet);
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("target \"tp.c\"");
      _builder_2.newLine();
      _builder_2.append("include \"a.tpd\"");
      _builder_2.newLine();
      URI _createURI_2 = URI.createURI("tmp:/c.tpd");
      final TargetPlatform tpc = this.parser.parse(_builder_2, _createURI_2, resourceSet);
      Resource _eResource = tpa.eResource();
      EList<Resource.Diagnostic> _errors = _eResource.getErrors();
      boolean _isEmpty = _errors.isEmpty();
      Assert.assertTrue(_isEmpty);
      TargetPlatformValidator _validator = tester.validator();
      _validator.checkImportCycle(tpa);
      AssertableDiagnostics _diagnose = tester.diagnose();
      Iterable<Diagnostic> _allDiagnostics = _diagnose.getAllDiagnostics();
      Iterable<AbstractValidationDiagnostic> _filter = Iterables.<AbstractValidationDiagnostic>filter(_allDiagnostics, AbstractValidationDiagnostic.class);
      List<AbstractValidationDiagnostic> diagnotics = IterableExtensions.<AbstractValidationDiagnostic>toList(_filter);
      int _size = diagnotics.size();
      Assert.assertEquals(1, _size);
      final Function1<AbstractValidationDiagnostic, Boolean> _function = new Function1<AbstractValidationDiagnostic, Boolean>() {
        public Boolean apply(final AbstractValidationDiagnostic it) {
          EObject _sourceEObject = it.getSourceEObject();
          return Boolean.valueOf((_sourceEObject instanceof IncludeDeclaration));
        }
      };
      boolean _forall = IterableExtensions.<AbstractValidationDiagnostic>forall(diagnotics, _function);
      Assert.assertTrue(_forall);
      final Procedure1<AbstractValidationDiagnostic> _function_1 = new Procedure1<AbstractValidationDiagnostic>() {
        public void apply(final AbstractValidationDiagnostic it) {
          String _issueCode = it.getIssueCode();
          Assert.assertEquals(TargetPlatformValidator.CHECK__INCLUDE_CYCLE, _issueCode);
          EObject _sourceEObject = it.getSourceEObject();
          String _importURI = ((IncludeDeclaration) _sourceEObject).getImportURI();
          Assert.assertEquals("b.tpd", _importURI);
        }
      };
      IterableExtensions.<AbstractValidationDiagnostic>forEach(diagnotics, _function_1);
      Resource _eResource_1 = tpb.eResource();
      EList<Resource.Diagnostic> _errors_1 = _eResource_1.getErrors();
      boolean _isEmpty_1 = _errors_1.isEmpty();
      Assert.assertTrue(_isEmpty_1);
      TargetPlatformValidator _validator_1 = tester.validator();
      _validator_1.checkImportCycle(tpb);
      AssertableDiagnostics _diagnose_1 = tester.diagnose();
      Iterable<Diagnostic> _allDiagnostics_1 = _diagnose_1.getAllDiagnostics();
      Iterable<AbstractValidationDiagnostic> _filter_1 = Iterables.<AbstractValidationDiagnostic>filter(_allDiagnostics_1, AbstractValidationDiagnostic.class);
      List<AbstractValidationDiagnostic> _list = IterableExtensions.<AbstractValidationDiagnostic>toList(_filter_1);
      diagnotics = _list;
      int _size_1 = diagnotics.size();
      Assert.assertEquals(1, _size_1);
      final Function1<AbstractValidationDiagnostic, Boolean> _function_2 = new Function1<AbstractValidationDiagnostic, Boolean>() {
        public Boolean apply(final AbstractValidationDiagnostic it) {
          EObject _sourceEObject = it.getSourceEObject();
          return Boolean.valueOf((_sourceEObject instanceof IncludeDeclaration));
        }
      };
      boolean _forall_1 = IterableExtensions.<AbstractValidationDiagnostic>forall(diagnotics, _function_2);
      Assert.assertTrue(_forall_1);
      final Procedure1<AbstractValidationDiagnostic> _function_3 = new Procedure1<AbstractValidationDiagnostic>() {
        public void apply(final AbstractValidationDiagnostic it) {
          String _issueCode = it.getIssueCode();
          Assert.assertEquals(TargetPlatformValidator.CHECK__INCLUDE_CYCLE, _issueCode);
          EObject _sourceEObject = it.getSourceEObject();
          String _importURI = ((IncludeDeclaration) _sourceEObject).getImportURI();
          Assert.assertEquals("c.tpd", _importURI);
        }
      };
      IterableExtensions.<AbstractValidationDiagnostic>forEach(diagnotics, _function_3);
      Resource _eResource_2 = tpb.eResource();
      EList<Resource.Diagnostic> _errors_2 = _eResource_2.getErrors();
      boolean _isEmpty_2 = _errors_2.isEmpty();
      Assert.assertTrue(_isEmpty_2);
      TargetPlatformValidator _validator_2 = tester.validator();
      _validator_2.checkImportCycle(tpc);
      AssertableDiagnostics _diagnose_2 = tester.diagnose();
      Iterable<Diagnostic> _allDiagnostics_2 = _diagnose_2.getAllDiagnostics();
      Iterable<AbstractValidationDiagnostic> _filter_2 = Iterables.<AbstractValidationDiagnostic>filter(_allDiagnostics_2, AbstractValidationDiagnostic.class);
      List<AbstractValidationDiagnostic> _list_1 = IterableExtensions.<AbstractValidationDiagnostic>toList(_filter_2);
      diagnotics = _list_1;
      int _size_2 = diagnotics.size();
      Assert.assertEquals(1, _size_2);
      final Function1<AbstractValidationDiagnostic, Boolean> _function_4 = new Function1<AbstractValidationDiagnostic, Boolean>() {
        public Boolean apply(final AbstractValidationDiagnostic it) {
          EObject _sourceEObject = it.getSourceEObject();
          return Boolean.valueOf((_sourceEObject instanceof IncludeDeclaration));
        }
      };
      boolean _forall_2 = IterableExtensions.<AbstractValidationDiagnostic>forall(diagnotics, _function_4);
      Assert.assertTrue(_forall_2);
      final Procedure1<AbstractValidationDiagnostic> _function_5 = new Procedure1<AbstractValidationDiagnostic>() {
        public void apply(final AbstractValidationDiagnostic it) {
          String _issueCode = it.getIssueCode();
          Assert.assertEquals(TargetPlatformValidator.CHECK__INCLUDE_CYCLE, _issueCode);
          EObject _sourceEObject = it.getSourceEObject();
          String _importURI = ((IncludeDeclaration) _sourceEObject).getImportURI();
          Assert.assertEquals("a.tpd", _importURI);
        }
      };
      IterableExtensions.<AbstractValidationDiagnostic>forEach(diagnotics, _function_5);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void checkIUIDAndRange1() {
    try {
      final ValidatorTester<TargetPlatformValidator> tester = new ValidatorTester<TargetPlatformValidator>(this.validator, this.validatorRegistrar, this.languageName);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"a target platform\"");
      _builder.newLine();
      _builder.append("location \"location1\" {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("org.iu1");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final TargetPlatform targetPlatform = this.parser.parse(_builder);
      Resource _eResource = targetPlatform.eResource();
      EList<Resource.Diagnostic> _errors = _eResource.getErrors();
      boolean _isEmpty = _errors.isEmpty();
      Assert.assertTrue(_isEmpty);
      TargetPlatformValidator _validator = tester.validator();
      EList<Location> _locations = targetPlatform.getLocations();
      Location _head = IterableExtensions.<Location>head(_locations);
      EList<IU> _ius = _head.getIus();
      IU _head_1 = IterableExtensions.<IU>head(_ius);
      _validator.checkIUIDAndRangeInRepository(_head_1);
      AssertableDiagnostics _diagnose = tester.diagnose();
      Iterable<Diagnostic> _allDiagnostics = _diagnose.getAllDiagnostics();
      Iterable<AbstractValidationDiagnostic> _filter = Iterables.<AbstractValidationDiagnostic>filter(_allDiagnostics, AbstractValidationDiagnostic.class);
      final List<AbstractValidationDiagnostic> diagnotics = IterableExtensions.<AbstractValidationDiagnostic>toList(_filter);
      int _size = diagnotics.size();
      Assert.assertEquals(0, _size);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void checkIUIDAndRange2() {
    try {
      final ValidatorTester<TargetPlatformValidator> tester = new ValidatorTester<TargetPlatformValidator>(this.validator, this.validatorRegistrar, this.languageName);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"a target platform\"");
      _builder.newLine();
      _builder.append("location \"location1\" {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("org.iu2");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final TargetPlatform targetPlatform = this.parser.parse(_builder);
      Resource _eResource = targetPlatform.eResource();
      EList<Resource.Diagnostic> _errors = _eResource.getErrors();
      boolean _isEmpty = _errors.isEmpty();
      Assert.assertTrue(_isEmpty);
      TargetPlatformValidator _validator = tester.validator();
      EList<Location> _locations = targetPlatform.getLocations();
      Location _head = IterableExtensions.<Location>head(_locations);
      EList<IU> _ius = _head.getIus();
      IU _head_1 = IterableExtensions.<IU>head(_ius);
      _validator.checkIUIDAndRangeInRepository(_head_1);
      AssertableDiagnostics _diagnose = tester.diagnose();
      Iterable<Diagnostic> _allDiagnostics = _diagnose.getAllDiagnostics();
      Iterable<AbstractValidationDiagnostic> _filter = Iterables.<AbstractValidationDiagnostic>filter(_allDiagnostics, AbstractValidationDiagnostic.class);
      final List<AbstractValidationDiagnostic> diagnotics = IterableExtensions.<AbstractValidationDiagnostic>toList(_filter);
      int _size = diagnotics.size();
      Assert.assertEquals(1, _size);
      final Function1<AbstractValidationDiagnostic, Boolean> _function = new Function1<AbstractValidationDiagnostic, Boolean>() {
        public Boolean apply(final AbstractValidationDiagnostic it) {
          EObject _sourceEObject = it.getSourceEObject();
          return Boolean.valueOf((_sourceEObject instanceof IU));
        }
      };
      boolean _forall = IterableExtensions.<AbstractValidationDiagnostic>forall(diagnotics, _function);
      Assert.assertTrue(_forall);
      final Procedure1<AbstractValidationDiagnostic> _function_1 = new Procedure1<AbstractValidationDiagnostic>() {
        public void apply(final AbstractValidationDiagnostic it) {
          String _issueCode = it.getIssueCode();
          Assert.assertEquals(TargetPlatformValidator.CHECK__IU_IN_LOCATION, _issueCode);
          EObject _sourceEObject = it.getSourceEObject();
          String _iD = ((IU) _sourceEObject).getID();
          Assert.assertEquals("org.iu2", _iD);
        }
      };
      IterableExtensions.<AbstractValidationDiagnostic>forEach(diagnotics, _function_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void checkIUIDAndRange3() {
    try {
      final ValidatorTester<TargetPlatformValidator> tester = new ValidatorTester<TargetPlatformValidator>(this.validator, this.validatorRegistrar, this.languageName);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"a target platform\"");
      _builder.newLine();
      _builder.append("location \"location2\" {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("org.iu4");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("org.iu2");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("org.iu5");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("org.iu1");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("org.iu3");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final TargetPlatform targetPlatform = this.parser.parse(_builder);
      Resource _eResource = targetPlatform.eResource();
      EList<Resource.Diagnostic> _errors = _eResource.getErrors();
      boolean _isEmpty = _errors.isEmpty();
      Assert.assertTrue(_isEmpty);
      EList<Location> _locations = targetPlatform.getLocations();
      Location _head = IterableExtensions.<Location>head(_locations);
      EList<IU> _ius = _head.getIus();
      final Procedure1<IU> _function = new Procedure1<IU>() {
        public void apply(final IU it) {
          TargetPlatformValidator _validator = tester.validator();
          _validator.checkIUIDAndRangeInRepository(it);
        }
      };
      IterableExtensions.<IU>forEach(_ius, _function);
      AssertableDiagnostics _diagnose = tester.diagnose();
      Iterable<Diagnostic> _allDiagnostics = _diagnose.getAllDiagnostics();
      Iterable<AbstractValidationDiagnostic> _filter = Iterables.<AbstractValidationDiagnostic>filter(_allDiagnostics, AbstractValidationDiagnostic.class);
      final List<AbstractValidationDiagnostic> diagnotics = IterableExtensions.<AbstractValidationDiagnostic>toList(_filter);
      int _size = diagnotics.size();
      Assert.assertEquals(3, _size);
      final Function1<AbstractValidationDiagnostic, Boolean> _function_1 = new Function1<AbstractValidationDiagnostic, Boolean>() {
        public Boolean apply(final AbstractValidationDiagnostic it) {
          EObject _sourceEObject = it.getSourceEObject();
          return Boolean.valueOf((_sourceEObject instanceof IU));
        }
      };
      boolean _forall = IterableExtensions.<AbstractValidationDiagnostic>forall(diagnotics, _function_1);
      Assert.assertTrue(_forall);
      final Procedure1<AbstractValidationDiagnostic> _function_2 = new Procedure1<AbstractValidationDiagnostic>() {
        public void apply(final AbstractValidationDiagnostic it) {
          String _issueCode = it.getIssueCode();
          Assert.assertEquals(TargetPlatformValidator.CHECK__IU_IN_LOCATION, _issueCode);
        }
      };
      IterableExtensions.<AbstractValidationDiagnostic>forEach(diagnotics, _function_2);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void checkIUIDAndRange4() {
    try {
      final ValidatorTester<TargetPlatformValidator> tester = new ValidatorTester<TargetPlatformValidator>(this.validator, this.validatorRegistrar, this.languageName);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"a target platform\"");
      _builder.newLine();
      _builder.append("location \"location2\" {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("org.iu1 [1.0.0,2)");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final TargetPlatform targetPlatform = this.parser.parse(_builder);
      Resource _eResource = targetPlatform.eResource();
      EList<Resource.Diagnostic> _errors = _eResource.getErrors();
      boolean _isEmpty = _errors.isEmpty();
      Assert.assertTrue(_isEmpty);
      EList<Location> _locations = targetPlatform.getLocations();
      Location _head = IterableExtensions.<Location>head(_locations);
      EList<IU> _ius = _head.getIus();
      final Procedure1<IU> _function = new Procedure1<IU>() {
        public void apply(final IU it) {
          TargetPlatformValidator _validator = tester.validator();
          _validator.checkIUIDAndRangeInRepository(it);
        }
      };
      IterableExtensions.<IU>forEach(_ius, _function);
      AssertableDiagnostics _diagnose = tester.diagnose();
      Iterable<Diagnostic> _allDiagnostics = _diagnose.getAllDiagnostics();
      Iterable<AbstractValidationDiagnostic> _filter = Iterables.<AbstractValidationDiagnostic>filter(_allDiagnostics, AbstractValidationDiagnostic.class);
      final List<AbstractValidationDiagnostic> diagnotics = IterableExtensions.<AbstractValidationDiagnostic>toList(_filter);
      int _size = diagnotics.size();
      Assert.assertEquals(0, _size);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void checkIUIDAndRange5() {
    try {
      final ValidatorTester<TargetPlatformValidator> tester = new ValidatorTester<TargetPlatformValidator>(this.validator, this.validatorRegistrar, this.languageName);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"a target platform\"");
      _builder.newLine();
      _builder.append("location \"location2\" {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("org.iu1 [1.2.1,1.2.3)");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final TargetPlatform targetPlatform = this.parser.parse(_builder);
      Resource _eResource = targetPlatform.eResource();
      EList<Resource.Diagnostic> _errors = _eResource.getErrors();
      boolean _isEmpty = _errors.isEmpty();
      Assert.assertTrue(_isEmpty);
      EList<Location> _locations = targetPlatform.getLocations();
      Location _head = IterableExtensions.<Location>head(_locations);
      EList<IU> _ius = _head.getIus();
      final Procedure1<IU> _function = new Procedure1<IU>() {
        public void apply(final IU it) {
          TargetPlatformValidator _validator = tester.validator();
          _validator.checkIUIDAndRangeInRepository(it);
        }
      };
      IterableExtensions.<IU>forEach(_ius, _function);
      AssertableDiagnostics _diagnose = tester.diagnose();
      Iterable<Diagnostic> _allDiagnostics = _diagnose.getAllDiagnostics();
      Iterable<AbstractValidationDiagnostic> _filter = Iterables.<AbstractValidationDiagnostic>filter(_allDiagnostics, AbstractValidationDiagnostic.class);
      final List<AbstractValidationDiagnostic> diagnotics = IterableExtensions.<AbstractValidationDiagnostic>toList(_filter);
      int _size = diagnotics.size();
      Assert.assertEquals(1, _size);
      final Function1<AbstractValidationDiagnostic, Boolean> _function_1 = new Function1<AbstractValidationDiagnostic, Boolean>() {
        public Boolean apply(final AbstractValidationDiagnostic it) {
          EObject _sourceEObject = it.getSourceEObject();
          return Boolean.valueOf((_sourceEObject instanceof IU));
        }
      };
      boolean _forall = IterableExtensions.<AbstractValidationDiagnostic>forall(diagnotics, _function_1);
      Assert.assertTrue(_forall);
      final Procedure1<AbstractValidationDiagnostic> _function_2 = new Procedure1<AbstractValidationDiagnostic>() {
        public void apply(final AbstractValidationDiagnostic it) {
          String _issueCode = it.getIssueCode();
          Assert.assertEquals(TargetPlatformValidator.CHECK__IU_IN_LOCATION, _issueCode);
          EObject _sourceEObject = it.getSourceEObject();
          String _iD = ((IU) _sourceEObject).getID();
          Assert.assertEquals("org.iu1", _iD);
        }
      };
      IterableExtensions.<AbstractValidationDiagnostic>forEach(diagnotics, _function_2);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void checkLocationURI1() {
    try {
      final ValidatorTester<TargetPlatformValidator> tester = new ValidatorTester<TargetPlatformValidator>(this.validator, this.validatorRegistrar, this.languageName);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"a target platform\"");
      _builder.newLine();
      _builder.append("location \"location2\" {");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final TargetPlatform targetPlatform = this.parser.parse(_builder);
      Resource _eResource = targetPlatform.eResource();
      EList<Resource.Diagnostic> _errors = _eResource.getErrors();
      boolean _isEmpty = _errors.isEmpty();
      Assert.assertTrue(_isEmpty);
      EList<Location> _locations = targetPlatform.getLocations();
      final Procedure1<Location> _function = new Procedure1<Location>() {
        public void apply(final Location it) {
          TargetPlatformValidator _validator = tester.validator();
          _validator.checkLocationURI(it);
        }
      };
      IterableExtensions.<Location>forEach(_locations, _function);
      AssertableDiagnostics _diagnose = tester.diagnose();
      Iterable<Diagnostic> _allDiagnostics = _diagnose.getAllDiagnostics();
      Iterable<AbstractValidationDiagnostic> _filter = Iterables.<AbstractValidationDiagnostic>filter(_allDiagnostics, AbstractValidationDiagnostic.class);
      final List<AbstractValidationDiagnostic> diagnotics = IterableExtensions.<AbstractValidationDiagnostic>toList(_filter);
      int _size = diagnotics.size();
      Assert.assertEquals(0, _size);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void checkLocationURI2() {
    try {
      final ValidatorTester<TargetPlatformValidator> tester = new ValidatorTester<TargetPlatformValidator>(this.validator, this.validatorRegistrar, this.languageName);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"a target platform\"");
      _builder.newLine();
      _builder.append("location \"emptyRepository\" {");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final TargetPlatform targetPlatform = this.parser.parse(_builder);
      Resource _eResource = targetPlatform.eResource();
      EList<Resource.Diagnostic> _errors = _eResource.getErrors();
      boolean _isEmpty = _errors.isEmpty();
      Assert.assertTrue(_isEmpty);
      EList<Location> _locations = targetPlatform.getLocations();
      final Procedure1<Location> _function = new Procedure1<Location>() {
        public void apply(final Location it) {
          TargetPlatformValidator _validator = tester.validator();
          _validator.checkLocationURI(it);
        }
      };
      IterableExtensions.<Location>forEach(_locations, _function);
      AssertableDiagnostics _diagnose = tester.diagnose();
      Iterable<Diagnostic> _allDiagnostics = _diagnose.getAllDiagnostics();
      Iterable<AbstractValidationDiagnostic> _filter = Iterables.<AbstractValidationDiagnostic>filter(_allDiagnostics, AbstractValidationDiagnostic.class);
      final List<AbstractValidationDiagnostic> diagnotics = IterableExtensions.<AbstractValidationDiagnostic>toList(_filter);
      int _size = diagnotics.size();
      Assert.assertEquals(0, _size);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void checkLocationURI3() {
    try {
      final ValidatorTester<TargetPlatformValidator> tester = new ValidatorTester<TargetPlatformValidator>(this.validator, this.validatorRegistrar, this.languageName);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"a target platform\"");
      _builder.newLine();
      _builder.append("location \"badLocation\" {");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final TargetPlatform targetPlatform = this.parser.parse(_builder);
      Resource _eResource = targetPlatform.eResource();
      EList<Resource.Diagnostic> _errors = _eResource.getErrors();
      boolean _isEmpty = _errors.isEmpty();
      Assert.assertTrue(_isEmpty);
      EList<Location> _locations = targetPlatform.getLocations();
      final Procedure1<Location> _function = new Procedure1<Location>() {
        public void apply(final Location it) {
          TargetPlatformValidator _validator = tester.validator();
          _validator.checkLocationURI(it);
        }
      };
      IterableExtensions.<Location>forEach(_locations, _function);
      AssertableDiagnostics _diagnose = tester.diagnose();
      Iterable<Diagnostic> _allDiagnostics = _diagnose.getAllDiagnostics();
      Iterable<AbstractValidationDiagnostic> _filter = Iterables.<AbstractValidationDiagnostic>filter(_allDiagnostics, AbstractValidationDiagnostic.class);
      final List<AbstractValidationDiagnostic> diagnotics = IterableExtensions.<AbstractValidationDiagnostic>toList(_filter);
      int _size = diagnotics.size();
      Assert.assertEquals(1, _size);
      final Procedure1<AbstractValidationDiagnostic> _function_1 = new Procedure1<AbstractValidationDiagnostic>() {
        public void apply(final AbstractValidationDiagnostic it) {
          String _issueCode = it.getIssueCode();
          Assert.assertEquals(TargetPlatformValidator.CHECK__LOCATION_URI, _issueCode);
          EObject _sourceEObject = it.getSourceEObject();
          String _uri = ((Location) _sourceEObject).getUri();
          Assert.assertEquals("badLocation", _uri);
        }
      };
      IterableExtensions.<AbstractValidationDiagnostic>forEach(diagnotics, _function_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void checkEnvironmentValidity1() {
    try {
      final ValidatorTester<TargetPlatformValidator> tester = new ValidatorTester<TargetPlatformValidator>(this.validator, this.validatorRegistrar, this.languageName);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"a target platform\"");
      _builder.newLine();
      _builder.append("environment macosx COCOA x86_64 JavaSE-1.6 fr_FR");
      _builder.newLine();
      final TargetPlatform targetPlatform = this.parser.parse(_builder);
      Resource _eResource = targetPlatform.eResource();
      EList<Resource.Diagnostic> _errors = _eResource.getErrors();
      boolean _isEmpty = _errors.isEmpty();
      Assert.assertTrue(_isEmpty);
      TargetPlatformValidator _validator = tester.validator();
      Environment _environment = targetPlatform.getEnvironment();
      _validator.checkEnvironment(_environment);
      AssertableDiagnostics _diagnose = tester.diagnose();
      Iterable<Diagnostic> _allDiagnostics = _diagnose.getAllDiagnostics();
      Iterable<AbstractValidationDiagnostic> _filter = Iterables.<AbstractValidationDiagnostic>filter(_allDiagnostics, AbstractValidationDiagnostic.class);
      final List<AbstractValidationDiagnostic> diagnotics = IterableExtensions.<AbstractValidationDiagnostic>toList(_filter);
      int _size = diagnotics.size();
      Assert.assertEquals(0, _size);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void checkEnvironmentValidity2() {
    try {
      final ValidatorTester<TargetPlatformValidator> tester = new ValidatorTester<TargetPlatformValidator>(this.validator, this.validatorRegistrar, this.languageName);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"a target platform\"");
      _builder.newLine();
      _builder.append("environment macosx COCOA qsdf x86_64");
      _builder.newLine();
      final TargetPlatform targetPlatform = this.parser.parse(_builder);
      Resource _eResource = targetPlatform.eResource();
      EList<Resource.Diagnostic> _errors = _eResource.getErrors();
      boolean _isEmpty = _errors.isEmpty();
      Assert.assertTrue(_isEmpty);
      TargetPlatformValidator _validator = tester.validator();
      Environment _environment = targetPlatform.getEnvironment();
      _validator.checkEnvironment(_environment);
      AssertableDiagnostics _diagnose = tester.diagnose();
      Iterable<Diagnostic> _allDiagnostics = _diagnose.getAllDiagnostics();
      Iterable<AbstractValidationDiagnostic> _filter = Iterables.<AbstractValidationDiagnostic>filter(_allDiagnostics, AbstractValidationDiagnostic.class);
      final List<AbstractValidationDiagnostic> diagnotics = IterableExtensions.<AbstractValidationDiagnostic>toList(_filter);
      int _size = diagnotics.size();
      Assert.assertEquals(1, _size);
      final Procedure1<AbstractValidationDiagnostic> _function = new Procedure1<AbstractValidationDiagnostic>() {
        public void apply(final AbstractValidationDiagnostic it) {
          String _issueCode = it.getIssueCode();
          Assert.assertEquals(TargetPlatformValidator.CHECK__ENVIRONMENT_VALIDITY, _issueCode);
        }
      };
      IterableExtensions.<AbstractValidationDiagnostic>forEach(diagnotics, _function);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void checkEnvironmentValidity3() {
    try {
      final ValidatorTester<TargetPlatformValidator> tester = new ValidatorTester<TargetPlatformValidator>(this.validator, this.validatorRegistrar, this.languageName);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"a target platform\"");
      _builder.newLine();
      _builder.append("environment macosx linux");
      _builder.newLine();
      final TargetPlatform targetPlatform = this.parser.parse(_builder);
      Resource _eResource = targetPlatform.eResource();
      EList<Resource.Diagnostic> _errors = _eResource.getErrors();
      boolean _isEmpty = _errors.isEmpty();
      Assert.assertTrue(_isEmpty);
      TargetPlatformValidator _validator = tester.validator();
      Environment _environment = targetPlatform.getEnvironment();
      _validator.checkEnvironment(_environment);
      AssertableDiagnostics _diagnose = tester.diagnose();
      Iterable<Diagnostic> _allDiagnostics = _diagnose.getAllDiagnostics();
      Iterable<AbstractValidationDiagnostic> _filter = Iterables.<AbstractValidationDiagnostic>filter(_allDiagnostics, AbstractValidationDiagnostic.class);
      final List<AbstractValidationDiagnostic> diagnotics = IterableExtensions.<AbstractValidationDiagnostic>toList(_filter);
      int _size = diagnotics.size();
      Assert.assertEquals(0, _size);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void checkEnvironmentValidity4() {
    try {
      final ValidatorTester<TargetPlatformValidator> tester = new ValidatorTester<TargetPlatformValidator>(this.validator, this.validatorRegistrar, this.languageName);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"a target platform\"");
      _builder.newLine();
      _builder.append("environment macosx macosx");
      _builder.newLine();
      final TargetPlatform targetPlatform = this.parser.parse(_builder);
      Resource _eResource = targetPlatform.eResource();
      EList<Resource.Diagnostic> _errors = _eResource.getErrors();
      boolean _isEmpty = _errors.isEmpty();
      Assert.assertTrue(_isEmpty);
      TargetPlatformValidator _validator = tester.validator();
      Environment _environment = targetPlatform.getEnvironment();
      _validator.checkEnvironment(_environment);
      AssertableDiagnostics _diagnose = tester.diagnose();
      Iterable<Diagnostic> _allDiagnostics = _diagnose.getAllDiagnostics();
      Iterable<AbstractValidationDiagnostic> _filter = Iterables.<AbstractValidationDiagnostic>filter(_allDiagnostics, AbstractValidationDiagnostic.class);
      final List<AbstractValidationDiagnostic> diagnotics = IterableExtensions.<AbstractValidationDiagnostic>toList(_filter);
      int _size = diagnotics.size();
      Assert.assertEquals(0, _size);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void checkUniqueEnvironment0() {
    try {
      final ValidatorTester<TargetPlatformValidator> tester = new ValidatorTester<TargetPlatformValidator>(this.validator, this.validatorRegistrar, this.languageName);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"a target platform\"");
      _builder.newLine();
      _builder.append("environment macosx COCOA x86_64");
      _builder.newLine();
      _builder.newLine();
      _builder.append("location \"location\" {");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final TargetPlatform targetPlatform = this.parser.parse(_builder);
      Resource _eResource = targetPlatform.eResource();
      EList<Resource.Diagnostic> _errors = _eResource.getErrors();
      boolean _isEmpty = _errors.isEmpty();
      Assert.assertTrue(_isEmpty);
      TargetPlatformValidator _validator = tester.validator();
      _validator.checkOneEnvironment(targetPlatform);
      AssertableDiagnostics _diagnose = tester.diagnose();
      Iterable<Diagnostic> _allDiagnostics = _diagnose.getAllDiagnostics();
      Iterable<FeatureBasedDiagnostic> _filter = Iterables.<FeatureBasedDiagnostic>filter(_allDiagnostics, FeatureBasedDiagnostic.class);
      final List<FeatureBasedDiagnostic> diagnotics = IterableExtensions.<FeatureBasedDiagnostic>toList(_filter);
      int _size = diagnotics.size();
      Assert.assertEquals(0, _size);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void checkUniqueEnvironment1() {
    try {
      final ValidatorTester<TargetPlatformValidator> tester = new ValidatorTester<TargetPlatformValidator>(this.validator, this.validatorRegistrar, this.languageName);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"a target platform\"");
      _builder.newLine();
      _builder.append("environment macosx COCOA x86_64");
      _builder.newLine();
      _builder.newLine();
      _builder.append("environment win32");
      _builder.newLine();
      _builder.newLine();
      _builder.append("location \"location\" {");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final TargetPlatform targetPlatform = this.parser.parse(_builder);
      Resource _eResource = targetPlatform.eResource();
      EList<Resource.Diagnostic> _errors = _eResource.getErrors();
      boolean _isEmpty = _errors.isEmpty();
      Assert.assertTrue(_isEmpty);
      TargetPlatformValidator _validator = tester.validator();
      _validator.checkOneEnvironment(targetPlatform);
      AssertableDiagnostics _diagnose = tester.diagnose();
      Iterable<Diagnostic> _allDiagnostics = _diagnose.getAllDiagnostics();
      Iterable<FeatureBasedDiagnostic> _filter = Iterables.<FeatureBasedDiagnostic>filter(_allDiagnostics, FeatureBasedDiagnostic.class);
      final List<FeatureBasedDiagnostic> diagnotics = IterableExtensions.<FeatureBasedDiagnostic>toList(_filter);
      int _size = diagnotics.size();
      Assert.assertEquals(1, _size);
      final Procedure1<FeatureBasedDiagnostic> _function = new Procedure1<FeatureBasedDiagnostic>() {
        public void apply(final FeatureBasedDiagnostic it) {
          String _issueCode = it.getIssueCode();
          Assert.assertEquals(TargetPlatformValidator.CHECK__ENVIRONMENT_UNICITY, _issueCode);
          int _severity = it.getSeverity();
          Assert.assertEquals(Diagnostic.WARNING, _severity);
          EList<TargetContent> _contents = targetPlatform.getContents();
          TargetContent _get = _contents.get(1);
          EObject _sourceEObject = it.getSourceEObject();
          EStructuralFeature _feature = it.getFeature();
          Object _eGet = _sourceEObject.eGet(_feature);
          int _index = it.getIndex();
          Object _get_1 = ((List<?>) _eGet).get(_index);
          Assert.assertEquals(_get, _get_1);
        }
      };
      IterableExtensions.<FeatureBasedDiagnostic>forEach(diagnotics, _function);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void checkUniqueEnvironment2() {
    try {
      final ValidatorTester<TargetPlatformValidator> tester = new ValidatorTester<TargetPlatformValidator>(this.validator, this.validatorRegistrar, this.languageName);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"a target platform\"");
      _builder.newLine();
      _builder.append("environment macosx COCOA x86_64");
      _builder.newLine();
      _builder.newLine();
      _builder.append("environment win32");
      _builder.newLine();
      _builder.newLine();
      _builder.append("location \"location\" {");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("environment gtk");
      _builder.newLine();
      final TargetPlatform targetPlatform = this.parser.parse(_builder);
      Resource _eResource = targetPlatform.eResource();
      EList<Resource.Diagnostic> _errors = _eResource.getErrors();
      boolean _isEmpty = _errors.isEmpty();
      Assert.assertTrue(_isEmpty);
      TargetPlatformValidator _validator = tester.validator();
      _validator.checkOneEnvironment(targetPlatform);
      AssertableDiagnostics _diagnose = tester.diagnose();
      Iterable<Diagnostic> _allDiagnostics = _diagnose.getAllDiagnostics();
      Iterable<FeatureBasedDiagnostic> _filter = Iterables.<FeatureBasedDiagnostic>filter(_allDiagnostics, FeatureBasedDiagnostic.class);
      final List<FeatureBasedDiagnostic> diagnostics = IterableExtensions.<FeatureBasedDiagnostic>toList(_filter);
      int _size = diagnostics.size();
      Assert.assertEquals(2, _size);
      FeatureBasedDiagnostic it = IterableExtensions.<FeatureBasedDiagnostic>head(diagnostics);
      String _issueCode = it.getIssueCode();
      Assert.assertEquals(TargetPlatformValidator.CHECK__ENVIRONMENT_UNICITY, _issueCode);
      int _severity = it.getSeverity();
      Assert.assertEquals(Diagnostic.WARNING, _severity);
      EList<TargetContent> _contents = targetPlatform.getContents();
      TargetContent _get = _contents.get(1);
      EObject _sourceEObject = it.getSourceEObject();
      EStructuralFeature _feature = it.getFeature();
      Object _eGet = _sourceEObject.eGet(_feature);
      int _index = it.getIndex();
      Object _get_1 = ((List<?>) _eGet).get(_index);
      Assert.assertEquals(_get, _get_1);
      FeatureBasedDiagnostic _get_2 = diagnostics.get(1);
      it = _get_2;
      String _issueCode_1 = it.getIssueCode();
      Assert.assertEquals(TargetPlatformValidator.CHECK__ENVIRONMENT_UNICITY, _issueCode_1);
      int _severity_1 = it.getSeverity();
      Assert.assertEquals(Diagnostic.WARNING, _severity_1);
      EList<TargetContent> _contents_1 = targetPlatform.getContents();
      TargetContent _get_3 = _contents_1.get(3);
      EObject _sourceEObject_1 = it.getSourceEObject();
      EStructuralFeature _feature_1 = it.getFeature();
      Object _eGet_1 = _sourceEObject_1.eGet(_feature_1);
      int _index_1 = it.getIndex();
      Object _get_4 = ((List<?>) _eGet_1).get(_index_1);
      Assert.assertEquals(_get_3, _get_4);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void checkUniqueOptions0() {
    try {
      final ValidatorTester<TargetPlatformValidator> tester = new ValidatorTester<TargetPlatformValidator>(this.validator, this.validatorRegistrar, this.languageName);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"a target platform\"");
      _builder.newLine();
      _builder.append("with requirements");
      _builder.newLine();
      _builder.newLine();
      _builder.append("location \"location\" {");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final TargetPlatform targetPlatform = this.parser.parse(_builder);
      Resource _eResource = targetPlatform.eResource();
      EList<Resource.Diagnostic> _errors = _eResource.getErrors();
      boolean _isEmpty = _errors.isEmpty();
      Assert.assertTrue(_isEmpty);
      TargetPlatformValidator _validator = tester.validator();
      _validator.checkOneOptions(targetPlatform);
      AssertableDiagnostics _diagnose = tester.diagnose();
      Iterable<Diagnostic> _allDiagnostics = _diagnose.getAllDiagnostics();
      Iterable<FeatureBasedDiagnostic> _filter = Iterables.<FeatureBasedDiagnostic>filter(_allDiagnostics, FeatureBasedDiagnostic.class);
      final List<FeatureBasedDiagnostic> diagnotics = IterableExtensions.<FeatureBasedDiagnostic>toList(_filter);
      int _size = diagnotics.size();
      Assert.assertEquals(0, _size);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void checkUniqueOptions1() {
    try {
      final ValidatorTester<TargetPlatformValidator> tester = new ValidatorTester<TargetPlatformValidator>(this.validator, this.validatorRegistrar, this.languageName);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"a target platform\"");
      _builder.newLine();
      _builder.append("with requirements");
      _builder.newLine();
      _builder.newLine();
      _builder.append("with source");
      _builder.newLine();
      _builder.newLine();
      _builder.append("location \"location\" {");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final TargetPlatform targetPlatform = this.parser.parse(_builder);
      Resource _eResource = targetPlatform.eResource();
      EList<Resource.Diagnostic> _errors = _eResource.getErrors();
      boolean _isEmpty = _errors.isEmpty();
      Assert.assertTrue(_isEmpty);
      TargetPlatformValidator _validator = tester.validator();
      _validator.checkOneOptions(targetPlatform);
      AssertableDiagnostics _diagnose = tester.diagnose();
      Iterable<Diagnostic> _allDiagnostics = _diagnose.getAllDiagnostics();
      Iterable<FeatureBasedDiagnostic> _filter = Iterables.<FeatureBasedDiagnostic>filter(_allDiagnostics, FeatureBasedDiagnostic.class);
      final List<FeatureBasedDiagnostic> diagnotics = IterableExtensions.<FeatureBasedDiagnostic>toList(_filter);
      int _size = diagnotics.size();
      Assert.assertEquals(1, _size);
      final Procedure1<FeatureBasedDiagnostic> _function = new Procedure1<FeatureBasedDiagnostic>() {
        public void apply(final FeatureBasedDiagnostic it) {
          String _issueCode = it.getIssueCode();
          Assert.assertEquals(TargetPlatformValidator.CHECK__OPTIONS_UNICITY, _issueCode);
          int _severity = it.getSeverity();
          Assert.assertEquals(Diagnostic.WARNING, _severity);
          EList<TargetContent> _contents = targetPlatform.getContents();
          TargetContent _get = _contents.get(1);
          EObject _sourceEObject = it.getSourceEObject();
          EStructuralFeature _feature = it.getFeature();
          Object _eGet = _sourceEObject.eGet(_feature);
          int _index = it.getIndex();
          Object _get_1 = ((List<?>) _eGet).get(_index);
          Assert.assertEquals(_get, _get_1);
        }
      };
      IterableExtensions.<FeatureBasedDiagnostic>forEach(diagnotics, _function);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void checkUniqueOptions2() {
    try {
      final ValidatorTester<TargetPlatformValidator> tester = new ValidatorTester<TargetPlatformValidator>(this.validator, this.validatorRegistrar, this.languageName);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"a target platform\"");
      _builder.newLine();
      _builder.append("with requirements");
      _builder.newLine();
      _builder.newLine();
      _builder.append("with source");
      _builder.newLine();
      _builder.newLine();
      _builder.append("location \"location\" {");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("with configurePhase");
      _builder.newLine();
      final TargetPlatform targetPlatform = this.parser.parse(_builder);
      Resource _eResource = targetPlatform.eResource();
      EList<Resource.Diagnostic> _errors = _eResource.getErrors();
      boolean _isEmpty = _errors.isEmpty();
      Assert.assertTrue(_isEmpty);
      TargetPlatformValidator _validator = tester.validator();
      _validator.checkOneOptions(targetPlatform);
      AssertableDiagnostics _diagnose = tester.diagnose();
      Iterable<Diagnostic> _allDiagnostics = _diagnose.getAllDiagnostics();
      Iterable<FeatureBasedDiagnostic> _filter = Iterables.<FeatureBasedDiagnostic>filter(_allDiagnostics, FeatureBasedDiagnostic.class);
      final List<FeatureBasedDiagnostic> diagnostics = IterableExtensions.<FeatureBasedDiagnostic>toList(_filter);
      int _size = diagnostics.size();
      Assert.assertEquals(2, _size);
      FeatureBasedDiagnostic it = IterableExtensions.<FeatureBasedDiagnostic>head(diagnostics);
      String _issueCode = it.getIssueCode();
      Assert.assertEquals(TargetPlatformValidator.CHECK__OPTIONS_UNICITY, _issueCode);
      int _severity = it.getSeverity();
      Assert.assertEquals(Diagnostic.WARNING, _severity);
      EList<TargetContent> _contents = targetPlatform.getContents();
      TargetContent _get = _contents.get(1);
      EObject _sourceEObject = it.getSourceEObject();
      EStructuralFeature _feature = it.getFeature();
      Object _eGet = _sourceEObject.eGet(_feature);
      int _index = it.getIndex();
      Object _get_1 = ((List<?>) _eGet).get(_index);
      Assert.assertEquals(_get, _get_1);
      FeatureBasedDiagnostic _get_2 = diagnostics.get(1);
      it = _get_2;
      String _issueCode_1 = it.getIssueCode();
      Assert.assertEquals(TargetPlatformValidator.CHECK__OPTIONS_UNICITY, _issueCode_1);
      int _severity_1 = it.getSeverity();
      Assert.assertEquals(Diagnostic.WARNING, _severity_1);
      EList<TargetContent> _contents_1 = targetPlatform.getContents();
      TargetContent _get_3 = _contents_1.get(3);
      EObject _sourceEObject_1 = it.getSourceEObject();
      EStructuralFeature _feature_1 = it.getFeature();
      Object _eGet_1 = _sourceEObject_1.eGet(_feature_1);
      int _index_1 = it.getIndex();
      Object _get_4 = ((List<?>) _eGet_1).get(_index_1);
      Assert.assertEquals(_get_3, _get_4);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void checkEnvironmentCohesion1() {
    try {
      final ValidatorTester<TargetPlatformValidator> tester = new ValidatorTester<TargetPlatformValidator>(this.validator, this.validatorRegistrar, this.languageName);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"a target platform\"");
      _builder.newLine();
      _builder.append("environment linux gtk cocoa");
      _builder.newLine();
      final TargetPlatform targetPlatform = this.parser.parse(_builder);
      Resource _eResource = targetPlatform.eResource();
      EList<Resource.Diagnostic> _errors = _eResource.getErrors();
      boolean _isEmpty = _errors.isEmpty();
      Assert.assertTrue(_isEmpty);
      TargetPlatformValidator _validator = tester.validator();
      _validator.checkNoDuplicateEnvironmentOptions(targetPlatform);
      AssertableDiagnostics _diagnose = tester.diagnose();
      Iterable<Diagnostic> _allDiagnostics = _diagnose.getAllDiagnostics();
      Iterable<FeatureBasedDiagnostic> _filter = Iterables.<FeatureBasedDiagnostic>filter(_allDiagnostics, FeatureBasedDiagnostic.class);
      final List<FeatureBasedDiagnostic> diagnostics = IterableExtensions.<FeatureBasedDiagnostic>toList(_filter);
      String _join = IterableExtensions.join(diagnostics, ", ");
      int _size = diagnostics.size();
      Assert.assertEquals(_join, 2, _size);
      FeatureBasedDiagnostic it = IterableExtensions.<FeatureBasedDiagnostic>head(diagnostics);
      String _issueCode = it.getIssueCode();
      Assert.assertEquals(TargetPlatformValidator.CHECK__NO_DUPLICATE_ENVIRONMENT_OPTIONS, _issueCode);
      int _severity = it.getSeverity();
      Assert.assertEquals(Diagnostic.ERROR, _severity);
      Environment _environment = targetPlatform.getEnvironment();
      EList<String> _env = _environment.getEnv();
      String _get = _env.get(1);
      EObject _sourceEObject = it.getSourceEObject();
      EStructuralFeature _feature = it.getFeature();
      Object _eGet = _sourceEObject.eGet(_feature);
      int _index = it.getIndex();
      Object _get_1 = ((List<?>) _eGet).get(_index);
      Assert.assertEquals(_get, _get_1);
      FeatureBasedDiagnostic it_1 = diagnostics.get(1);
      String _issueCode_1 = it_1.getIssueCode();
      Assert.assertEquals(TargetPlatformValidator.CHECK__NO_DUPLICATE_ENVIRONMENT_OPTIONS, _issueCode_1);
      int _severity_1 = it_1.getSeverity();
      Assert.assertEquals(Diagnostic.ERROR, _severity_1);
      Environment _environment_1 = targetPlatform.getEnvironment();
      EList<String> _env_1 = _environment_1.getEnv();
      String _get_2 = _env_1.get(2);
      EObject _sourceEObject_1 = it_1.getSourceEObject();
      EStructuralFeature _feature_1 = it_1.getFeature();
      Object _eGet_1 = _sourceEObject_1.eGet(_feature_1);
      int _index_1 = it_1.getIndex();
      Object _get_3 = ((List<?>) _eGet_1).get(_index_1);
      Assert.assertEquals(_get_2, _get_3);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void checkEnvironmentCohesion2() {
    try {
      final ValidatorTester<TargetPlatformValidator> tester = new ValidatorTester<TargetPlatformValidator>(this.validator, this.validatorRegistrar, this.languageName);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"a target platform\"");
      _builder.newLine();
      _builder.append("environment linux gtk");
      _builder.newLine();
      _builder.newLine();
      _builder.append("environment cocoa");
      _builder.newLine();
      final TargetPlatform targetPlatform = this.parser.parse(_builder);
      Resource _eResource = targetPlatform.eResource();
      EList<Resource.Diagnostic> _errors = _eResource.getErrors();
      boolean _isEmpty = _errors.isEmpty();
      Assert.assertTrue(_isEmpty);
      TargetPlatformValidator _validator = tester.validator();
      _validator.checkNoDuplicateEnvironmentOptions(targetPlatform);
      AssertableDiagnostics _diagnose = tester.diagnose();
      Iterable<Diagnostic> _allDiagnostics = _diagnose.getAllDiagnostics();
      Iterable<FeatureBasedDiagnostic> _filter = Iterables.<FeatureBasedDiagnostic>filter(_allDiagnostics, FeatureBasedDiagnostic.class);
      final List<FeatureBasedDiagnostic> diagnostics = IterableExtensions.<FeatureBasedDiagnostic>toList(_filter);
      int _size = diagnostics.size();
      Assert.assertEquals(2, _size);
      FeatureBasedDiagnostic it = IterableExtensions.<FeatureBasedDiagnostic>head(diagnostics);
      String _issueCode = it.getIssueCode();
      Assert.assertEquals(TargetPlatformValidator.CHECK__NO_DUPLICATE_ENVIRONMENT_OPTIONS, _issueCode);
      int _severity = it.getSeverity();
      Assert.assertEquals(Diagnostic.ERROR, _severity);
      EList<TargetContent> _contents = targetPlatform.getContents();
      TargetContent _get = _contents.get(0);
      EList<String> _env = ((Environment) _get).getEnv();
      String _get_1 = _env.get(1);
      EObject _sourceEObject = it.getSourceEObject();
      EStructuralFeature _feature = it.getFeature();
      Object _eGet = _sourceEObject.eGet(_feature);
      int _index = it.getIndex();
      Object _get_2 = ((List<?>) _eGet).get(_index);
      Assert.assertEquals(_get_1, _get_2);
      FeatureBasedDiagnostic it_1 = diagnostics.get(1);
      String _issueCode_1 = it_1.getIssueCode();
      Assert.assertEquals(TargetPlatformValidator.CHECK__NO_DUPLICATE_ENVIRONMENT_OPTIONS, _issueCode_1);
      int _severity_1 = it_1.getSeverity();
      Assert.assertEquals(Diagnostic.ERROR, _severity_1);
      EList<TargetContent> _contents_1 = targetPlatform.getContents();
      TargetContent _get_3 = _contents_1.get(1);
      EList<String> _env_1 = ((Environment) _get_3).getEnv();
      String _head = IterableExtensions.<String>head(_env_1);
      EObject _sourceEObject_1 = it_1.getSourceEObject();
      EStructuralFeature _feature_1 = it_1.getFeature();
      Object _eGet_1 = _sourceEObject_1.eGet(_feature_1);
      int _index_1 = it_1.getIndex();
      Object _get_4 = ((List<?>) _eGet_1).get(_index_1);
      Assert.assertEquals(_head, _get_4);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void checkEnvironmentCohesion3() {
    try {
      final ValidatorTester<TargetPlatformValidator> tester = new ValidatorTester<TargetPlatformValidator>(this.validator, this.validatorRegistrar, this.languageName);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"a target platform\"");
      _builder.newLine();
      _builder.append("environment win32 cocoa");
      _builder.newLine();
      final TargetPlatform targetPlatform = this.parser.parse(_builder);
      Resource _eResource = targetPlatform.eResource();
      EList<Resource.Diagnostic> _errors = _eResource.getErrors();
      boolean _isEmpty = _errors.isEmpty();
      Assert.assertTrue(_isEmpty);
      TargetPlatformValidator _validator = tester.validator();
      _validator.checkNoDuplicateEnvironmentOptions(targetPlatform);
      AssertableDiagnostics _diagnose = tester.diagnose();
      Iterable<Diagnostic> _allDiagnostics = _diagnose.getAllDiagnostics();
      Iterable<FeatureBasedDiagnostic> _filter = Iterables.<FeatureBasedDiagnostic>filter(_allDiagnostics, FeatureBasedDiagnostic.class);
      final List<FeatureBasedDiagnostic> diagnostics = IterableExtensions.<FeatureBasedDiagnostic>toList(_filter);
      int _size = diagnostics.size();
      Assert.assertEquals(0, _size);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void checkEnvironmentCohesion4() {
    try {
      final ValidatorTester<TargetPlatformValidator> tester = new ValidatorTester<TargetPlatformValidator>(this.validator, this.validatorRegistrar, this.languageName);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"a target platform\"");
      _builder.newLine();
      _builder.append("environment win32 linux");
      _builder.newLine();
      final TargetPlatform targetPlatform = this.parser.parse(_builder);
      Resource _eResource = targetPlatform.eResource();
      EList<Resource.Diagnostic> _errors = _eResource.getErrors();
      boolean _isEmpty = _errors.isEmpty();
      Assert.assertTrue(_isEmpty);
      TargetPlatformValidator _validator = tester.validator();
      _validator.checkNoDuplicateEnvironmentOptions(targetPlatform);
      AssertableDiagnostics _diagnose = tester.diagnose();
      Iterable<Diagnostic> _allDiagnostics = _diagnose.getAllDiagnostics();
      Iterable<FeatureBasedDiagnostic> _filter = Iterables.<FeatureBasedDiagnostic>filter(_allDiagnostics, FeatureBasedDiagnostic.class);
      final List<FeatureBasedDiagnostic> diagnostics = IterableExtensions.<FeatureBasedDiagnostic>toList(_filter);
      int _size = diagnostics.size();
      Assert.assertEquals(0, _size);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void checkEnvironmentCohesion5() {
    try {
      final ValidatorTester<TargetPlatformValidator> tester = new ValidatorTester<TargetPlatformValidator>(this.validator, this.validatorRegistrar, this.languageName);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"a target platform\"");
      _builder.newLine();
      _builder.append("environment win32 win32");
      _builder.newLine();
      final TargetPlatform targetPlatform = this.parser.parse(_builder);
      Resource _eResource = targetPlatform.eResource();
      EList<Resource.Diagnostic> _errors = _eResource.getErrors();
      boolean _isEmpty = _errors.isEmpty();
      Assert.assertTrue(_isEmpty);
      TargetPlatformValidator _validator = tester.validator();
      _validator.checkNoDuplicateEnvironmentOptions(targetPlatform);
      AssertableDiagnostics _diagnose = tester.diagnose();
      Iterable<Diagnostic> _allDiagnostics = _diagnose.getAllDiagnostics();
      Iterable<FeatureBasedDiagnostic> _filter = Iterables.<FeatureBasedDiagnostic>filter(_allDiagnostics, FeatureBasedDiagnostic.class);
      final List<FeatureBasedDiagnostic> diagnostics = IterableExtensions.<FeatureBasedDiagnostic>toList(_filter);
      int _size = diagnostics.size();
      Assert.assertEquals(0, _size);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void checkEnvironmentCohesion6() {
    try {
      final ValidatorTester<TargetPlatformValidator> tester = new ValidatorTester<TargetPlatformValidator>(this.validator, this.validatorRegistrar, this.languageName);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"a target platform\"");
      _builder.newLine();
      _builder.append("environment win32 ");
      _builder.newLine();
      _builder.append("environment win32");
      _builder.newLine();
      final TargetPlatform targetPlatform = this.parser.parse(_builder);
      Resource _eResource = targetPlatform.eResource();
      EList<Resource.Diagnostic> _errors = _eResource.getErrors();
      boolean _isEmpty = _errors.isEmpty();
      Assert.assertTrue(_isEmpty);
      TargetPlatformValidator _validator = tester.validator();
      _validator.checkNoDuplicateEnvironmentOptions(targetPlatform);
      AssertableDiagnostics _diagnose = tester.diagnose();
      Iterable<Diagnostic> _allDiagnostics = _diagnose.getAllDiagnostics();
      Iterable<FeatureBasedDiagnostic> _filter = Iterables.<FeatureBasedDiagnostic>filter(_allDiagnostics, FeatureBasedDiagnostic.class);
      final List<FeatureBasedDiagnostic> diagnostics = IterableExtensions.<FeatureBasedDiagnostic>toList(_filter);
      String _join = IterableExtensions.join(diagnostics, ", ");
      int _size = diagnostics.size();
      Assert.assertEquals(_join, 0, _size);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void checkEnvironmentCohesion7() {
    try {
      final ValidatorTester<TargetPlatformValidator> tester = new ValidatorTester<TargetPlatformValidator>(this.validator, this.validatorRegistrar, this.languageName);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"a target platform\"");
      _builder.newLine();
      _builder.append("environment cocoa linux cocoa ");
      _builder.newLine();
      final TargetPlatform targetPlatform = this.parser.parse(_builder);
      Resource _eResource = targetPlatform.eResource();
      EList<Resource.Diagnostic> _errors = _eResource.getErrors();
      boolean _isEmpty = _errors.isEmpty();
      Assert.assertTrue(_isEmpty);
      TargetPlatformValidator _validator = tester.validator();
      _validator.checkNoDuplicateEnvironmentOptions(targetPlatform);
      AssertableDiagnostics _diagnose = tester.diagnose();
      Iterable<Diagnostic> _allDiagnostics = _diagnose.getAllDiagnostics();
      Iterable<FeatureBasedDiagnostic> _filter = Iterables.<FeatureBasedDiagnostic>filter(_allDiagnostics, FeatureBasedDiagnostic.class);
      final List<FeatureBasedDiagnostic> diagnostics = IterableExtensions.<FeatureBasedDiagnostic>toList(_filter);
      String _join = IterableExtensions.join(diagnostics, ", ");
      int _size = diagnostics.size();
      Assert.assertEquals(_join, 2, _size);
      FeatureBasedDiagnostic _get = diagnostics.get(0);
      EObject _sourceEObject = _get.getSourceEObject();
      FeatureBasedDiagnostic _get_1 = diagnostics.get(0);
      EStructuralFeature _feature = _get_1.getFeature();
      Object _eGet = _sourceEObject.eGet(_feature);
      FeatureBasedDiagnostic _get_2 = diagnostics.get(0);
      int _index = _get_2.getIndex();
      Object _get_3 = ((List<?>) _eGet).get(_index);
      Assert.assertEquals("cocoa", _get_3);
      FeatureBasedDiagnostic _get_4 = diagnostics.get(1);
      EObject _sourceEObject_1 = _get_4.getSourceEObject();
      FeatureBasedDiagnostic _get_5 = diagnostics.get(1);
      EStructuralFeature _feature_1 = _get_5.getFeature();
      Object _eGet_1 = _sourceEObject_1.eGet(_feature_1);
      FeatureBasedDiagnostic _get_6 = diagnostics.get(1);
      int _index_1 = _get_6.getIndex();
      Object _get_7 = ((List<?>) _eGet_1).get(_index_1);
      Assert.assertEquals("cocoa", _get_7);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testNoEscapeCharInIUID() {
    try {
      final ValidatorTester<TargetPlatformValidator> tester = new ValidatorTester<TargetPlatformValidator>(this.validator, this.validatorRegistrar, this.languageName);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"a target platform\"");
      _builder.newLine();
      _builder.append("location \"locationURI\" {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("org.iu1");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("^source");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("org.iu1.^source.feature.group");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final TargetPlatform targetPlatform = this.parser.parse(_builder);
      Resource _eResource = targetPlatform.eResource();
      EList<Resource.Diagnostic> _errors = _eResource.getErrors();
      boolean _isEmpty = _errors.isEmpty();
      Assert.assertTrue(_isEmpty);
      TargetPlatformValidator _validator = tester.validator();
      EList<Location> _locations = targetPlatform.getLocations();
      Location _head = IterableExtensions.<Location>head(_locations);
      EList<IU> _ius = _head.getIus();
      IU _get = _ius.get(0);
      _validator.checkNoEscapeCharacterInIUID(_get);
      AssertableDiagnostics _diagnose = tester.diagnose();
      Iterable<Diagnostic> _allDiagnostics = _diagnose.getAllDiagnostics();
      Iterable<FeatureBasedDiagnostic> _filter = Iterables.<FeatureBasedDiagnostic>filter(_allDiagnostics, FeatureBasedDiagnostic.class);
      List<FeatureBasedDiagnostic> diagnostics = IterableExtensions.<FeatureBasedDiagnostic>toList(_filter);
      String _join = IterableExtensions.join(diagnostics, ", ");
      int _size = diagnostics.size();
      Assert.assertEquals(_join, 0, _size);
      TargetPlatformValidator _validator_1 = tester.validator();
      EList<Location> _locations_1 = targetPlatform.getLocations();
      Location _head_1 = IterableExtensions.<Location>head(_locations_1);
      EList<IU> _ius_1 = _head_1.getIus();
      IU _get_1 = _ius_1.get(1);
      _validator_1.checkNoEscapeCharacterInIUID(_get_1);
      AssertableDiagnostics _diagnose_1 = tester.diagnose();
      Iterable<Diagnostic> _allDiagnostics_1 = _diagnose_1.getAllDiagnostics();
      Iterable<FeatureBasedDiagnostic> _filter_1 = Iterables.<FeatureBasedDiagnostic>filter(_allDiagnostics_1, FeatureBasedDiagnostic.class);
      List<FeatureBasedDiagnostic> _list = IterableExtensions.<FeatureBasedDiagnostic>toList(_filter_1);
      diagnostics = _list;
      String _join_1 = IterableExtensions.join(diagnostics, ", ");
      int _size_1 = diagnostics.size();
      Assert.assertEquals(_join_1, 0, _size_1);
      TargetPlatformValidator _validator_2 = tester.validator();
      EList<Location> _locations_2 = targetPlatform.getLocations();
      Location _head_2 = IterableExtensions.<Location>head(_locations_2);
      EList<IU> _ius_2 = _head_2.getIus();
      IU _get_2 = _ius_2.get(2);
      _validator_2.checkNoEscapeCharacterInIUID(_get_2);
      AssertableDiagnostics _diagnose_2 = tester.diagnose();
      Iterable<Diagnostic> _allDiagnostics_2 = _diagnose_2.getAllDiagnostics();
      Iterable<FeatureBasedDiagnostic> _filter_2 = Iterables.<FeatureBasedDiagnostic>filter(_allDiagnostics_2, FeatureBasedDiagnostic.class);
      List<FeatureBasedDiagnostic> _list_1 = IterableExtensions.<FeatureBasedDiagnostic>toList(_filter_2);
      diagnostics = _list_1;
      String _join_2 = IterableExtensions.join(diagnostics, ", ");
      int _size_2 = diagnostics.size();
      Assert.assertEquals(_join_2, 1, _size_2);
      FeatureBasedDiagnostic _head_3 = IterableExtensions.<FeatureBasedDiagnostic>head(diagnostics);
      String _issueCode = _head_3.getIssueCode();
      Assert.assertEquals(TargetPlatformValidator.CHECK__ESCAPE_CHAR_IU_ID, _issueCode);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testNoVersionKeywords() {
    try {
      final ValidatorTester<TargetPlatformValidator> tester = new ValidatorTester<TargetPlatformValidator>(this.validator, this.validatorRegistrar, this.languageName);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"a target platform\"");
      _builder.newLine();
      _builder.append("location \"locationURI\" {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("org.iu1");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("org.iu2 [2,3)");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("org.iu3; version  =   [10,25)");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final TargetPlatform targetPlatform = this.parser.parse(_builder);
      Resource _eResource = targetPlatform.eResource();
      EList<Resource.Diagnostic> _errors = _eResource.getErrors();
      boolean _isEmpty = _errors.isEmpty();
      Assert.assertTrue(_isEmpty);
      TargetPlatformValidator _validator = tester.validator();
      EList<Location> _locations = targetPlatform.getLocations();
      Location _head = IterableExtensions.<Location>head(_locations);
      EList<IU> _ius = _head.getIus();
      IU _get = _ius.get(0);
      _validator.checkVersionKeywords(_get);
      AssertableDiagnostics _diagnose = tester.diagnose();
      Iterable<Diagnostic> _allDiagnostics = _diagnose.getAllDiagnostics();
      Iterable<RangeBasedDiagnostic> _filter = Iterables.<RangeBasedDiagnostic>filter(_allDiagnostics, RangeBasedDiagnostic.class);
      List<RangeBasedDiagnostic> diagnostics = IterableExtensions.<RangeBasedDiagnostic>toList(_filter);
      String _join = IterableExtensions.join(diagnostics, ", ");
      int _size = diagnostics.size();
      Assert.assertEquals(_join, 0, _size);
      TargetPlatformValidator _validator_1 = tester.validator();
      EList<Location> _locations_1 = targetPlatform.getLocations();
      Location _head_1 = IterableExtensions.<Location>head(_locations_1);
      EList<IU> _ius_1 = _head_1.getIus();
      IU _get_1 = _ius_1.get(1);
      _validator_1.checkVersionKeywords(_get_1);
      AssertableDiagnostics _diagnose_1 = tester.diagnose();
      Iterable<Diagnostic> _allDiagnostics_1 = _diagnose_1.getAllDiagnostics();
      Iterable<RangeBasedDiagnostic> _filter_1 = Iterables.<RangeBasedDiagnostic>filter(_allDiagnostics_1, RangeBasedDiagnostic.class);
      List<RangeBasedDiagnostic> _list = IterableExtensions.<RangeBasedDiagnostic>toList(_filter_1);
      diagnostics = _list;
      String _join_1 = IterableExtensions.join(diagnostics, ", ");
      int _size_1 = diagnostics.size();
      Assert.assertEquals(_join_1, 0, _size_1);
      TargetPlatformValidator _validator_2 = tester.validator();
      EList<Location> _locations_2 = targetPlatform.getLocations();
      Location _head_2 = IterableExtensions.<Location>head(_locations_2);
      EList<IU> _ius_2 = _head_2.getIus();
      IU _get_2 = _ius_2.get(2);
      _validator_2.checkVersionKeywords(_get_2);
      AssertableDiagnostics _diagnose_2 = tester.diagnose();
      Iterable<Diagnostic> _allDiagnostics_2 = _diagnose_2.getAllDiagnostics();
      Iterable<RangeBasedDiagnostic> _filter_2 = Iterables.<RangeBasedDiagnostic>filter(_allDiagnostics_2, RangeBasedDiagnostic.class);
      List<RangeBasedDiagnostic> _list_1 = IterableExtensions.<RangeBasedDiagnostic>toList(_filter_2);
      diagnostics = _list_1;
      String _join_2 = IterableExtensions.join(diagnostics, ", ");
      int _size_2 = diagnostics.size();
      Assert.assertEquals(_join_2, 1, _size_2);
      RangeBasedDiagnostic _head_3 = IterableExtensions.<RangeBasedDiagnostic>head(diagnostics);
      String _issueCode = _head_3.getIssueCode();
      Assert.assertEquals(TargetPlatformValidator.CHECK__VERSION_KEYWORDS, _issueCode);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testNoDuplicatedIU1() {
    try {
      final ValidatorTester<TargetPlatformValidator> tester = new ValidatorTester<TargetPlatformValidator>(this.validator, this.validatorRegistrar, this.languageName);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"a target platform\"");
      _builder.newLine();
      _builder.append("location \"locationURI\" {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("org.iu1");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("location \"locationURI2\" {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("org.iu1");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final TargetPlatform targetPlatform = this.parser.parse(_builder);
      Resource _eResource = targetPlatform.eResource();
      EList<Resource.Diagnostic> _errors = _eResource.getErrors();
      boolean _isEmpty = _errors.isEmpty();
      Assert.assertTrue(_isEmpty);
      TargetPlatformValidator _validator = tester.validator();
      _validator.checkNoDuplicatedIU(targetPlatform);
      AssertableDiagnostics _diagnose = tester.diagnose();
      Iterable<Diagnostic> _allDiagnostics = _diagnose.getAllDiagnostics();
      Iterable<FeatureBasedDiagnostic> _filter = Iterables.<FeatureBasedDiagnostic>filter(_allDiagnostics, FeatureBasedDiagnostic.class);
      List<FeatureBasedDiagnostic> diagnostics = IterableExtensions.<FeatureBasedDiagnostic>toList(_filter);
      String _join = IterableExtensions.join(diagnostics, ", ");
      int _size = diagnostics.size();
      Assert.assertEquals(_join, 2, _size);
      FeatureBasedDiagnostic _head = IterableExtensions.<FeatureBasedDiagnostic>head(diagnostics);
      String _issueCode = _head.getIssueCode();
      Assert.assertEquals(TargetPlatformValidator.CHECK__NO_DUPLICATED_IU, _issueCode);
      EList<Location> _locations = targetPlatform.getLocations();
      Location _head_1 = IterableExtensions.<Location>head(_locations);
      EList<IU> _ius = _head_1.getIus();
      IU _head_2 = IterableExtensions.<IU>head(_ius);
      FeatureBasedDiagnostic _get = diagnostics.get(0);
      EObject _sourceEObject = _get.getSourceEObject();
      FeatureBasedDiagnostic _get_1 = diagnostics.get(0);
      EStructuralFeature _feature = _get_1.getFeature();
      Object _eGet = _sourceEObject.eGet(_feature);
      Object _get_2 = ((List<?>) _eGet).get(0);
      Assert.assertEquals(_head_2, _get_2);
      FeatureBasedDiagnostic _get_3 = diagnostics.get(0);
      int _severity = _get_3.getSeverity();
      Assert.assertEquals(Diagnostic.WARNING, _severity);
      EList<Location> _locations_1 = targetPlatform.getLocations();
      Location _get_4 = _locations_1.get(1);
      EList<IU> _ius_1 = _get_4.getIus();
      IU _head_3 = IterableExtensions.<IU>head(_ius_1);
      FeatureBasedDiagnostic _get_5 = diagnostics.get(1);
      EObject _sourceEObject_1 = _get_5.getSourceEObject();
      FeatureBasedDiagnostic _get_6 = diagnostics.get(1);
      EStructuralFeature _feature_1 = _get_6.getFeature();
      Object _eGet_1 = _sourceEObject_1.eGet(_feature_1);
      Object _get_7 = ((List<?>) _eGet_1).get(0);
      Assert.assertEquals(_head_3, _get_7);
      FeatureBasedDiagnostic _get_8 = diagnostics.get(1);
      int _severity_1 = _get_8.getSeverity();
      Assert.assertEquals(Diagnostic.WARNING, _severity_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testNoDuplicatedIU2() {
    try {
      final ValidatorTester<TargetPlatformValidator> tester = new ValidatorTester<TargetPlatformValidator>(this.validator, this.validatorRegistrar, this.languageName);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"a target platform\"");
      _builder.newLine();
      _builder.append("location \"locationURI\" {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("org.iu1");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("org.iu1");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final TargetPlatform targetPlatform = this.parser.parse(_builder);
      Resource _eResource = targetPlatform.eResource();
      EList<Resource.Diagnostic> _errors = _eResource.getErrors();
      boolean _isEmpty = _errors.isEmpty();
      Assert.assertTrue(_isEmpty);
      TargetPlatformValidator _validator = tester.validator();
      _validator.checkNoDuplicatedIU(targetPlatform);
      AssertableDiagnostics _diagnose = tester.diagnose();
      Iterable<Diagnostic> _allDiagnostics = _diagnose.getAllDiagnostics();
      Iterable<FeatureBasedDiagnostic> _filter = Iterables.<FeatureBasedDiagnostic>filter(_allDiagnostics, FeatureBasedDiagnostic.class);
      List<FeatureBasedDiagnostic> diagnostics = IterableExtensions.<FeatureBasedDiagnostic>toList(_filter);
      String _join = IterableExtensions.join(diagnostics, ", ");
      int _size = diagnostics.size();
      Assert.assertEquals(_join, 2, _size);
      FeatureBasedDiagnostic _head = IterableExtensions.<FeatureBasedDiagnostic>head(diagnostics);
      String _issueCode = _head.getIssueCode();
      Assert.assertEquals(TargetPlatformValidator.CHECK__NO_DUPLICATED_IU, _issueCode);
      EList<Location> _locations = targetPlatform.getLocations();
      Location _head_1 = IterableExtensions.<Location>head(_locations);
      EList<IU> _ius = _head_1.getIus();
      IU _head_2 = IterableExtensions.<IU>head(_ius);
      FeatureBasedDiagnostic _get = diagnostics.get(0);
      EObject _sourceEObject = _get.getSourceEObject();
      FeatureBasedDiagnostic _get_1 = diagnostics.get(0);
      EStructuralFeature _feature = _get_1.getFeature();
      Object _eGet = _sourceEObject.eGet(_feature);
      Object _get_2 = ((List<?>) _eGet).get(0);
      Assert.assertEquals(_head_2, _get_2);
      FeatureBasedDiagnostic _get_3 = diagnostics.get(0);
      int _severity = _get_3.getSeverity();
      Assert.assertEquals(Diagnostic.WARNING, _severity);
      EList<Location> _locations_1 = targetPlatform.getLocations();
      Location _head_3 = IterableExtensions.<Location>head(_locations_1);
      EList<IU> _ius_1 = _head_3.getIus();
      IU _head_4 = IterableExtensions.<IU>head(_ius_1);
      FeatureBasedDiagnostic _get_4 = diagnostics.get(1);
      EObject _sourceEObject_1 = _get_4.getSourceEObject();
      FeatureBasedDiagnostic _get_5 = diagnostics.get(1);
      EStructuralFeature _feature_1 = _get_5.getFeature();
      Object _eGet_1 = _sourceEObject_1.eGet(_feature_1);
      Object _get_6 = ((List<?>) _eGet_1).get(0);
      Assert.assertEquals(_head_4, _get_6);
      FeatureBasedDiagnostic _get_7 = diagnostics.get(1);
      int _severity_1 = _get_7.getSeverity();
      Assert.assertEquals(Diagnostic.WARNING, _severity_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testNoDuplicatedIU3() {
    try {
      final ValidatorTester<TargetPlatformValidator> tester = new ValidatorTester<TargetPlatformValidator>(this.validator, this.validatorRegistrar, this.languageName);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"a target platform\"");
      _builder.newLine();
      _builder.append("location \"locationURI\" {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("org.iu1");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("location \"locationURI\" {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("org.iu1");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final TargetPlatform targetPlatform = this.parser.parse(_builder);
      Resource _eResource = targetPlatform.eResource();
      EList<Resource.Diagnostic> _errors = _eResource.getErrors();
      boolean _isEmpty = _errors.isEmpty();
      Assert.assertTrue(_isEmpty);
      TargetPlatformValidator _validator = tester.validator();
      _validator.checkNoDuplicatedIU(targetPlatform);
      AssertableDiagnostics _diagnose = tester.diagnose();
      Iterable<Diagnostic> _allDiagnostics = _diagnose.getAllDiagnostics();
      Iterable<FeatureBasedDiagnostic> _filter = Iterables.<FeatureBasedDiagnostic>filter(_allDiagnostics, FeatureBasedDiagnostic.class);
      List<FeatureBasedDiagnostic> diagnostics = IterableExtensions.<FeatureBasedDiagnostic>toList(_filter);
      String _join = IterableExtensions.join(diagnostics, ", ");
      int _size = diagnostics.size();
      Assert.assertEquals(_join, 2, _size);
      FeatureBasedDiagnostic _head = IterableExtensions.<FeatureBasedDiagnostic>head(diagnostics);
      String _issueCode = _head.getIssueCode();
      Assert.assertEquals(TargetPlatformValidator.CHECK__NO_DUPLICATED_IU, _issueCode);
      EList<Location> _locations = targetPlatform.getLocations();
      Location _head_1 = IterableExtensions.<Location>head(_locations);
      EList<IU> _ius = _head_1.getIus();
      IU _head_2 = IterableExtensions.<IU>head(_ius);
      FeatureBasedDiagnostic _get = diagnostics.get(0);
      EObject _sourceEObject = _get.getSourceEObject();
      FeatureBasedDiagnostic _get_1 = diagnostics.get(0);
      EStructuralFeature _feature = _get_1.getFeature();
      Object _eGet = _sourceEObject.eGet(_feature);
      Object _get_2 = ((List<?>) _eGet).get(0);
      Assert.assertEquals(_head_2, _get_2);
      FeatureBasedDiagnostic _get_3 = diagnostics.get(0);
      int _severity = _get_3.getSeverity();
      Assert.assertEquals(Diagnostic.WARNING, _severity);
      EList<Location> _locations_1 = targetPlatform.getLocations();
      Location _get_4 = _locations_1.get(1);
      EList<IU> _ius_1 = _get_4.getIus();
      IU _head_3 = IterableExtensions.<IU>head(_ius_1);
      FeatureBasedDiagnostic _get_5 = diagnostics.get(1);
      EObject _sourceEObject_1 = _get_5.getSourceEObject();
      FeatureBasedDiagnostic _get_6 = diagnostics.get(1);
      EStructuralFeature _feature_1 = _get_6.getFeature();
      Object _eGet_1 = _sourceEObject_1.eGet(_feature_1);
      Object _get_7 = ((List<?>) _eGet_1).get(0);
      Assert.assertEquals(_head_3, _get_7);
      FeatureBasedDiagnostic _get_8 = diagnostics.get(1);
      int _severity_1 = _get_8.getSeverity();
      Assert.assertEquals(Diagnostic.WARNING, _severity_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testNoDuplicatedIU4() {
    try {
      final ValidatorTester<TargetPlatformValidator> tester = new ValidatorTester<TargetPlatformValidator>(this.validator, this.validatorRegistrar, this.languageName);
      final XtextResourceSet resourceSet = this.resourceSetProvider.get();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"tp.a\"");
      _builder.newLine();
      _builder.append("include \"b.tpd\"");
      _builder.newLine();
      _builder.newLine();
      _builder.append("location \"locationURI1\" {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("org.iu1");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      URI _createURI = URI.createURI("tmp:/a.tpd");
      final TargetPlatform tpa = this.parser.parse(_builder, _createURI, resourceSet);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("target \"tp.b\"");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("location \"locationURI2\" {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("org.iu1");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      URI _createURI_1 = URI.createURI("tmp:/b.tpd");
      this.parser.parse(_builder_1, _createURI_1, resourceSet);
      Resource _eResource = tpa.eResource();
      EList<Resource.Diagnostic> _errors = _eResource.getErrors();
      boolean _isEmpty = _errors.isEmpty();
      Assert.assertTrue(_isEmpty);
      TargetPlatformValidator _validator = tester.validator();
      _validator.checkNoDuplicatedIU(tpa);
      AssertableDiagnostics _diagnose = tester.diagnose();
      Iterable<Diagnostic> _allDiagnostics = _diagnose.getAllDiagnostics();
      Iterable<FeatureBasedDiagnostic> _filter = Iterables.<FeatureBasedDiagnostic>filter(_allDiagnostics, FeatureBasedDiagnostic.class);
      final List<FeatureBasedDiagnostic> diagnostics = IterableExtensions.<FeatureBasedDiagnostic>toList(_filter);
      int _size = diagnostics.size();
      Assert.assertEquals(1, _size);
      FeatureBasedDiagnostic _head = IterableExtensions.<FeatureBasedDiagnostic>head(diagnostics);
      String _issueCode = _head.getIssueCode();
      Assert.assertEquals(TargetPlatformValidator.CHECK__NO_DUPLICATED_IU, _issueCode);
      EList<Location> _locations = tpa.getLocations();
      Location _head_1 = IterableExtensions.<Location>head(_locations);
      EList<IU> _ius = _head_1.getIus();
      IU _head_2 = IterableExtensions.<IU>head(_ius);
      FeatureBasedDiagnostic _get = diagnostics.get(0);
      EObject _sourceEObject = _get.getSourceEObject();
      FeatureBasedDiagnostic _get_1 = diagnostics.get(0);
      EStructuralFeature _feature = _get_1.getFeature();
      Object _eGet = _sourceEObject.eGet(_feature);
      Object _get_2 = ((List<?>) _eGet).get(0);
      Assert.assertEquals(_head_2, _get_2);
      FeatureBasedDiagnostic _get_3 = diagnostics.get(0);
      int _severity = _get_3.getSeverity();
      Assert.assertEquals(Diagnostic.WARNING, _severity);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testNoDuplicatedIU5() {
    try {
      final ValidatorTester<TargetPlatformValidator> tester = new ValidatorTester<TargetPlatformValidator>(this.validator, this.validatorRegistrar, this.languageName);
      final XtextResourceSet resourceSet = this.resourceSetProvider.get();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"tp.a\"");
      _builder.newLine();
      _builder.append("include \"b.tpd\"");
      _builder.newLine();
      _builder.newLine();
      _builder.append("location \"locationURI1\" {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("org.iu1");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      URI _createURI = URI.createURI("tmp:/a.tpd");
      final TargetPlatform tpa = this.parser.parse(_builder, _createURI, resourceSet);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("target \"tp.b\"");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("location \"locationURI1\" {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("org.iu1");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      URI _createURI_1 = URI.createURI("tmp:/b.tpd");
      this.parser.parse(_builder_1, _createURI_1, resourceSet);
      Resource _eResource = tpa.eResource();
      EList<Resource.Diagnostic> _errors = _eResource.getErrors();
      boolean _isEmpty = _errors.isEmpty();
      Assert.assertTrue(_isEmpty);
      TargetPlatformValidator _validator = tester.validator();
      _validator.checkNoDuplicatedIU(tpa);
      AssertableDiagnostics _diagnose = tester.diagnose();
      Iterable<Diagnostic> _allDiagnostics = _diagnose.getAllDiagnostics();
      Iterable<FeatureBasedDiagnostic> _filter = Iterables.<FeatureBasedDiagnostic>filter(_allDiagnostics, FeatureBasedDiagnostic.class);
      final List<FeatureBasedDiagnostic> diagnostics = IterableExtensions.<FeatureBasedDiagnostic>toList(_filter);
      int _size = diagnostics.size();
      Assert.assertEquals(1, _size);
      FeatureBasedDiagnostic _head = IterableExtensions.<FeatureBasedDiagnostic>head(diagnostics);
      String _issueCode = _head.getIssueCode();
      Assert.assertEquals(TargetPlatformValidator.CHECK__NO_DUPLICATED_IU, _issueCode);
      EList<Location> _locations = tpa.getLocations();
      Location _head_1 = IterableExtensions.<Location>head(_locations);
      EList<IU> _ius = _head_1.getIus();
      IU _head_2 = IterableExtensions.<IU>head(_ius);
      FeatureBasedDiagnostic _get = diagnostics.get(0);
      EObject _sourceEObject = _get.getSourceEObject();
      FeatureBasedDiagnostic _get_1 = diagnostics.get(0);
      EStructuralFeature _feature = _get_1.getFeature();
      Object _eGet = _sourceEObject.eGet(_feature);
      Object _get_2 = ((List<?>) _eGet).get(0);
      Assert.assertEquals(_head_2, _get_2);
      FeatureBasedDiagnostic _get_3 = diagnostics.get(0);
      int _severity = _get_3.getSeverity();
      Assert.assertEquals(Diagnostic.WARNING, _severity);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
