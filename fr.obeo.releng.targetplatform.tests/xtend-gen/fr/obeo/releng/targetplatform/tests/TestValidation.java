/**
 * Copyright (c) 2012-2014 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Mikael Barbero (Obeo) - initial API and implementation
 */
package fr.obeo.releng.targetplatform.tests;

import com.google.common.collect.Iterables;
import com.google.common.collect.ListMultimap;
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
import org.eclipse.xtext.validation.RangeBasedDiagnostic;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
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
  private LocationIndexBuilder indexBuilder;
  
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
      Assert.assertTrue(targetPlatform.eResource().getErrors().isEmpty());
      final Location fisrtLocation = IterableExtensions.<Location>head(targetPlatform.getLocations());
      tester.validator().checkAllEnvAndRequiredAreSelfExluding(fisrtLocation);
      Iterable<AbstractValidationDiagnostic> _filter = Iterables.<AbstractValidationDiagnostic>filter(tester.diagnose().getAllDiagnostics(), AbstractValidationDiagnostic.class);
      for (final AbstractValidationDiagnostic diag : _filter) {
        {
          EObject _sourceEObject = diag.getSourceEObject();
          Assert.assertTrue((_sourceEObject instanceof Location));
          EObject _sourceEObject_1 = diag.getSourceEObject();
          Assert.assertEquals("my location URI", ((Location) _sourceEObject_1).getUri());
          Assert.assertEquals(TargetPlatformValidator.CHECK__OPTIONS_SELF_EXCLUDING_ALL_ENV_REQUIRED, 
            diag.getIssueCode());
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
      Assert.assertTrue(targetPlatform.eResource().getErrors().isEmpty());
      tester.validator().checkAllEnvAndRequiredAreSelfExluding(targetPlatform);
      Iterable<AbstractValidationDiagnostic> _filter = Iterables.<AbstractValidationDiagnostic>filter(tester.diagnose().getAllDiagnostics(), AbstractValidationDiagnostic.class);
      for (final AbstractValidationDiagnostic diag : _filter) {
        {
          EObject _sourceEObject = diag.getSourceEObject();
          Assert.assertTrue((_sourceEObject instanceof Options));
          Assert.assertEquals(TargetPlatformValidator.CHECK__OPTIONS_SELF_EXCLUDING_ALL_ENV_REQUIRED, 
            diag.getIssueCode());
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
      Assert.assertTrue(targetPlatform.eResource().getErrors().isEmpty());
      tester.validator().checkAllEnvAndRequiredAreSelfExluding(targetPlatform);
      final Iterable<Diagnostic> diag = tester.diagnose().getAllDiagnostics();
      Assert.assertEquals(2, IterableExtensions.size(diag));
      final Consumer<AbstractValidationDiagnostic> _function = new Consumer<AbstractValidationDiagnostic>() {
        @Override
        public void accept(final AbstractValidationDiagnostic it) {
          EObject _sourceEObject = it.getSourceEObject();
          Assert.assertTrue((_sourceEObject instanceof Options));
          Assert.assertEquals(TargetPlatformValidator.CHECK__OPTIONS_SELF_EXCLUDING_ALL_ENV_REQUIRED, it.getIssueCode());
        }
      };
      Iterables.<AbstractValidationDiagnostic>filter(diag, AbstractValidationDiagnostic.class).forEach(_function);
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
      Assert.assertTrue(targetPlatform.eResource().getErrors().isEmpty());
      tester.validator().checkNoDuplicateOptions(targetPlatform);
      final List<FeatureBasedDiagnostic> diagnostics = IterableExtensions.<FeatureBasedDiagnostic>toList(Iterables.<FeatureBasedDiagnostic>filter(tester.diagnose().getAllDiagnostics(), FeatureBasedDiagnostic.class));
      Assert.assertEquals(IterableExtensions.join(diagnostics, ", "), 2, diagnostics.size());
      Object _eGet = diagnostics.get(0).getSourceEObject().eGet(diagnostics.get(0).getFeature());
      Assert.assertEquals(Option.INCLUDE_SOURCE, ((List<?>) _eGet).get(diagnostics.get(0).getIndex()));
      Object _eGet_1 = diagnostics.get(1).getSourceEObject().eGet(diagnostics.get(1).getFeature());
      Assert.assertEquals(Option.INCLUDE_SOURCE, ((List<?>) _eGet_1).get(diagnostics.get(1).getIndex()));
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
      Assert.assertTrue(targetPlatform.eResource().getErrors().isEmpty());
      tester.validator().checkNoDuplicateOptions(targetPlatform);
      final List<FeatureBasedDiagnostic> diagnostics = IterableExtensions.<FeatureBasedDiagnostic>toList(Iterables.<FeatureBasedDiagnostic>filter(tester.diagnose().getAllDiagnostics(), FeatureBasedDiagnostic.class));
      Assert.assertEquals(IterableExtensions.join(diagnostics, ", "), 2, diagnostics.size());
      Assert.assertEquals(targetPlatform.getContents().get(0), diagnostics.get(0).getSourceEObject());
      Object _eGet = diagnostics.get(0).getSourceEObject().eGet(diagnostics.get(0).getFeature());
      Assert.assertEquals(Option.INCLUDE_CONFIGURE_PHASE, ((List<?>) _eGet).get(diagnostics.get(0).getIndex()));
      Assert.assertEquals(targetPlatform.getContents().get(1), diagnostics.get(1).getSourceEObject());
      Object _eGet_1 = diagnostics.get(1).getSourceEObject().eGet(diagnostics.get(1).getFeature());
      Assert.assertEquals(Option.INCLUDE_CONFIGURE_PHASE, ((List<?>) _eGet_1).get(diagnostics.get(1).getIndex()));
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
      Assert.assertTrue(targetPlatform.eResource().getErrors().isEmpty());
      tester.validator().checkIDUniqueOnAllLocations(targetPlatform);
      Assert.assertTrue(IterableExtensions.isEmpty(tester.diagnose().getAllDiagnostics()));
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
      Assert.assertTrue(targetPlatform.eResource().getErrors().isEmpty());
      tester.validator().checkIDUniqueOnAllLocations(targetPlatform);
      final List<AbstractValidationDiagnostic> diagnotics = IterableExtensions.<AbstractValidationDiagnostic>toList(Iterables.<AbstractValidationDiagnostic>filter(tester.diagnose().getAllDiagnostics(), AbstractValidationDiagnostic.class));
      Assert.assertEquals(2, diagnotics.size());
      final Function1<AbstractValidationDiagnostic, Boolean> _function = new Function1<AbstractValidationDiagnostic, Boolean>() {
        @Override
        public Boolean apply(final AbstractValidationDiagnostic it) {
          EObject _sourceEObject = it.getSourceEObject();
          return Boolean.valueOf((_sourceEObject instanceof Location));
        }
      };
      Assert.assertTrue(IterableExtensions.<AbstractValidationDiagnostic>forall(diagnotics, _function));
      final Consumer<AbstractValidationDiagnostic> _function_1 = new Consumer<AbstractValidationDiagnostic>() {
        @Override
        public void accept(final AbstractValidationDiagnostic it) {
          Assert.assertEquals(TargetPlatformValidator.CHECK__LOCATION_ID_UNIQNESS, it.getIssueCode());
        }
      };
      diagnotics.forEach(_function_1);
      EObject _sourceEObject = diagnotics.get(0).getSourceEObject();
      Assert.assertEquals("mylocationURI2", ((Location) _sourceEObject).getUri());
      EObject _sourceEObject_1 = diagnotics.get(1).getSourceEObject();
      Assert.assertEquals("mylocationURI", ((Location) _sourceEObject_1).getUri());
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
      Assert.assertTrue(targetPlatform.eResource().getErrors().isEmpty());
      tester.validator().checkIDUniqueOnAllLocations(targetPlatform);
      final List<AbstractValidationDiagnostic> diagnotics = IterableExtensions.<AbstractValidationDiagnostic>toList(Iterables.<AbstractValidationDiagnostic>filter(tester.diagnose().getAllDiagnostics(), AbstractValidationDiagnostic.class));
      Assert.assertEquals(2, diagnotics.size());
      final Function1<AbstractValidationDiagnostic, Boolean> _function = new Function1<AbstractValidationDiagnostic, Boolean>() {
        @Override
        public Boolean apply(final AbstractValidationDiagnostic it) {
          EObject _sourceEObject = it.getSourceEObject();
          return Boolean.valueOf((_sourceEObject instanceof Location));
        }
      };
      Assert.assertTrue(IterableExtensions.<AbstractValidationDiagnostic>forall(diagnotics, _function));
      final Consumer<AbstractValidationDiagnostic> _function_1 = new Consumer<AbstractValidationDiagnostic>() {
        @Override
        public void accept(final AbstractValidationDiagnostic it) {
          Assert.assertEquals(TargetPlatformValidator.CHECK__LOCATION_ID_UNIQNESS, it.getIssueCode());
        }
      };
      diagnotics.forEach(_function_1);
      EObject _sourceEObject = diagnotics.get(0).getSourceEObject();
      Assert.assertEquals("mylocationURI2", ((Location) _sourceEObject).getUri());
      EObject _sourceEObject_1 = diagnotics.get(1).getSourceEObject();
      Assert.assertEquals("mylocationURI", ((Location) _sourceEObject_1).getUri());
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
      Assert.assertTrue(targetPlatform.eResource().getErrors().isEmpty());
      tester.validator().checkIDUniqueOnAllLocations(targetPlatform);
      final List<AbstractValidationDiagnostic> diagnotics = IterableExtensions.<AbstractValidationDiagnostic>toList(Iterables.<AbstractValidationDiagnostic>filter(tester.diagnose().getAllDiagnostics(), AbstractValidationDiagnostic.class));
      Assert.assertEquals(0, diagnotics.size());
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
      Assert.assertTrue(targetPlatform.eResource().getErrors().isEmpty());
      tester.validator().checkIDUniqueOnAllLocations(targetPlatform);
      final List<AbstractValidationDiagnostic> diagnotics = IterableExtensions.<AbstractValidationDiagnostic>toList(Iterables.<AbstractValidationDiagnostic>filter(tester.diagnose().getAllDiagnostics(), AbstractValidationDiagnostic.class));
      Assert.assertEquals(0, diagnotics.size());
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
      Assert.assertTrue(targetPlatform.eResource().getErrors().isEmpty());
      tester.validator().checkIDUniqueOnAllLocations(targetPlatform);
      final List<AbstractValidationDiagnostic> diagnotics = IterableExtensions.<AbstractValidationDiagnostic>toList(Iterables.<AbstractValidationDiagnostic>filter(tester.diagnose().getAllDiagnostics(), AbstractValidationDiagnostic.class));
      Assert.assertEquals(0, diagnotics.size());
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
      final TargetPlatform tpa = this.parser.parse(_builder, URI.createURI("tmp:/a.tpd"), resourceSet);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("target \"tp.b\"");
      _builder_1.newLine();
      _builder_1.append("location \"locationURI1\"");
      _builder_1.newLine();
      this.parser.parse(_builder_1, URI.createURI("tmp:/b.tpd"), resourceSet);
      Assert.assertTrue(tpa.eResource().getErrors().isEmpty());
      tester.validator().checkIDUniqueOnAllLocations(tpa);
      List<AbstractValidationDiagnostic> diagnotics = IterableExtensions.<AbstractValidationDiagnostic>toList(Iterables.<AbstractValidationDiagnostic>filter(tester.diagnose().getAllDiagnostics(), AbstractValidationDiagnostic.class));
      Assert.assertEquals(0, diagnotics.size());
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
      final TargetPlatform tpa = this.parser.parse(_builder, URI.createURI("tmp:/a.tpd"), resourceSet);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("target \"tp.b\"");
      _builder_1.newLine();
      _builder_1.append("location A \"locationURI2\"");
      _builder_1.newLine();
      final TargetPlatform tpb = this.parser.parse(_builder_1, URI.createURI("tmp:/b.tpd"), resourceSet);
      Assert.assertTrue(tpa.eResource().getErrors().isEmpty());
      tester.validator().checkIDUniqueOnAllLocations(tpa);
      List<AbstractValidationDiagnostic> diagnotics = IterableExtensions.<AbstractValidationDiagnostic>toList(Iterables.<AbstractValidationDiagnostic>filter(tester.diagnose().getAllDiagnostics(), AbstractValidationDiagnostic.class));
      Assert.assertEquals(2, diagnotics.size());
      EObject _sourceEObject = diagnotics.get(0).getSourceEObject();
      Assert.assertTrue((_sourceEObject instanceof Location));
      Assert.assertEquals(TargetPlatformValidator.CHECK__LOCATION_ID_UNIQNESS, diagnotics.get(0).getIssueCode());
      EObject _sourceEObject_1 = diagnotics.get(0).getSourceEObject();
      Assert.assertEquals("locationURI1", ((Location) _sourceEObject_1).getUri());
      EObject _sourceEObject_2 = diagnotics.get(1).getSourceEObject();
      Assert.assertTrue((_sourceEObject_2 instanceof IncludeDeclaration));
      Assert.assertEquals(TargetPlatformValidator.CHECK__LOCATION_ID_UNIQNESS, diagnotics.get(1).getIssueCode());
      EObject _sourceEObject_3 = diagnotics.get(1).getSourceEObject();
      Assert.assertEquals("b.tpd", ((IncludeDeclaration) _sourceEObject_3).getImportURI());
      Assert.assertTrue(tpb.eResource().getErrors().isEmpty());
      tester.validator().checkIDUniqueOnAllLocations(tpb);
      diagnotics = IterableExtensions.<AbstractValidationDiagnostic>toList(Iterables.<AbstractValidationDiagnostic>filter(tester.diagnose().getAllDiagnostics(), AbstractValidationDiagnostic.class));
      Assert.assertEquals(0, diagnotics.size());
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
      final TargetPlatform tpa = this.parser.parse(_builder, URI.createURI("tmp:/a.tpd"), resourceSet);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("target \"tp.b\"");
      _builder_1.newLine();
      _builder_1.append("location A \"locationURI1\"");
      _builder_1.newLine();
      final TargetPlatform tpb = this.parser.parse(_builder_1, URI.createURI("tmp:/b.tpd"), resourceSet);
      Assert.assertTrue(tpa.eResource().getErrors().isEmpty());
      tester.validator().checkIDUniqueOnAllLocations(tpa);
      List<AbstractValidationDiagnostic> diagnotics = IterableExtensions.<AbstractValidationDiagnostic>toList(Iterables.<AbstractValidationDiagnostic>filter(tester.diagnose().getAllDiagnostics(), AbstractValidationDiagnostic.class));
      Assert.assertEquals(0, diagnotics.size());
      Assert.assertTrue(tpb.eResource().getErrors().isEmpty());
      tester.validator().checkIDUniqueOnAllLocations(tpb);
      diagnotics = IterableExtensions.<AbstractValidationDiagnostic>toList(Iterables.<AbstractValidationDiagnostic>filter(tester.diagnose().getAllDiagnostics(), AbstractValidationDiagnostic.class));
      Assert.assertEquals(0, diagnotics.size());
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
      Assert.assertTrue(targetPlatform.eResource().getErrors().isEmpty());
      tester.validator().checkIDUniqueOnAllLocations(targetPlatform);
      final List<AbstractValidationDiagnostic> diagnotics = IterableExtensions.<AbstractValidationDiagnostic>toList(Iterables.<AbstractValidationDiagnostic>filter(tester.diagnose().getAllDiagnostics(), AbstractValidationDiagnostic.class));
      Assert.assertEquals(0, diagnotics.size());
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
      Assert.assertTrue(targetPlatform.eResource().getErrors().isEmpty());
      tester.validator().checkNoLocationOptionIfGlobalOptions(IterableExtensions.<Location>head(targetPlatform.getLocations()));
      final List<AbstractValidationDiagnostic> diagnotics = IterableExtensions.<AbstractValidationDiagnostic>toList(Iterables.<AbstractValidationDiagnostic>filter(tester.diagnose().getAllDiagnostics(), AbstractValidationDiagnostic.class));
      final Function1<AbstractValidationDiagnostic, Boolean> _function = new Function1<AbstractValidationDiagnostic, Boolean>() {
        @Override
        public Boolean apply(final AbstractValidationDiagnostic it) {
          EObject _sourceEObject = it.getSourceEObject();
          return Boolean.valueOf((_sourceEObject instanceof Location));
        }
      };
      Assert.assertTrue(IterableExtensions.<AbstractValidationDiagnostic>forall(diagnotics, _function));
      final Consumer<AbstractValidationDiagnostic> _function_1 = new Consumer<AbstractValidationDiagnostic>() {
        @Override
        public void accept(final AbstractValidationDiagnostic it) {
          Assert.assertEquals(TargetPlatformValidator.CHECK__NO_OPTIONS_ON_LOCATIONS_IF_GLOBAL_OPTIONS, it.getIssueCode());
        }
      };
      diagnotics.forEach(_function_1);
      EObject _sourceEObject = diagnotics.get(0).getSourceEObject();
      Assert.assertEquals("mylocationURI1", ((Location) _sourceEObject).getUri());
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
      Assert.assertTrue(targetPlatform.eResource().getErrors().isEmpty());
      tester.validator().checkNoLocationOptionIfGlobalOptions(IterableExtensions.<Location>head(targetPlatform.getLocations()));
      final List<AbstractValidationDiagnostic> diagnotics = IterableExtensions.<AbstractValidationDiagnostic>toList(Iterables.<AbstractValidationDiagnostic>filter(tester.diagnose().getAllDiagnostics(), AbstractValidationDiagnostic.class));
      Assert.assertEquals(0, diagnotics.size());
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
      Assert.assertTrue(targetPlatform.eResource().getErrors().isEmpty());
      tester.validator().checkNoLocationOptionIfGlobalOptions(IterableExtensions.<Location>head(targetPlatform.getLocations()));
      final List<AbstractValidationDiagnostic> diagnotics = IterableExtensions.<AbstractValidationDiagnostic>toList(Iterables.<AbstractValidationDiagnostic>filter(tester.diagnose().getAllDiagnostics(), AbstractValidationDiagnostic.class));
      final Function1<AbstractValidationDiagnostic, Boolean> _function = new Function1<AbstractValidationDiagnostic, Boolean>() {
        @Override
        public Boolean apply(final AbstractValidationDiagnostic it) {
          EObject _sourceEObject = it.getSourceEObject();
          return Boolean.valueOf((_sourceEObject instanceof Location));
        }
      };
      Assert.assertTrue(IterableExtensions.<AbstractValidationDiagnostic>forall(diagnotics, _function));
      final Consumer<AbstractValidationDiagnostic> _function_1 = new Consumer<AbstractValidationDiagnostic>() {
        @Override
        public void accept(final AbstractValidationDiagnostic it) {
          Assert.assertEquals(TargetPlatformValidator.CHECK__NO_OPTIONS_ON_LOCATIONS_IF_GLOBAL_OPTIONS, it.getIssueCode());
        }
      };
      diagnotics.forEach(_function_1);
      EObject _sourceEObject = IterableExtensions.<AbstractValidationDiagnostic>head(diagnotics).getSourceEObject();
      Assert.assertEquals("mylocationURI1", ((Location) _sourceEObject).getUri());
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
      Assert.assertTrue(targetPlatform.eResource().getErrors().isEmpty());
      tester.validator().checkOptionsOnLocationAreIdentical(targetPlatform);
      final List<AbstractValidationDiagnostic> diagnotics = IterableExtensions.<AbstractValidationDiagnostic>toList(Iterables.<AbstractValidationDiagnostic>filter(tester.diagnose().getAllDiagnostics(), AbstractValidationDiagnostic.class));
      Assert.assertEquals(0, diagnotics.size());
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
      Assert.assertTrue(targetPlatform.eResource().getErrors().isEmpty());
      tester.validator().checkOptionsOnLocationAreIdentical(targetPlatform);
      final List<AbstractValidationDiagnostic> diagnotics = IterableExtensions.<AbstractValidationDiagnostic>toList(Iterables.<AbstractValidationDiagnostic>filter(tester.diagnose().getAllDiagnostics(), AbstractValidationDiagnostic.class));
      Assert.assertEquals(0, diagnotics.size());
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
      Assert.assertTrue(targetPlatform.eResource().getErrors().isEmpty());
      tester.validator().checkOptionsOnLocationAreIdentical(targetPlatform);
      final List<AbstractValidationDiagnostic> diagnotics = IterableExtensions.<AbstractValidationDiagnostic>toList(Iterables.<AbstractValidationDiagnostic>filter(tester.diagnose().getAllDiagnostics(), AbstractValidationDiagnostic.class));
      Assert.assertEquals(0, diagnotics.size());
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
      Assert.assertTrue(targetPlatform.eResource().getErrors().isEmpty());
      tester.validator().checkOptionsOnLocationAreIdentical(targetPlatform);
      final List<AbstractValidationDiagnostic> diagnotics = IterableExtensions.<AbstractValidationDiagnostic>toList(Iterables.<AbstractValidationDiagnostic>filter(tester.diagnose().getAllDiagnostics(), AbstractValidationDiagnostic.class));
      Assert.assertEquals(0, diagnotics.size());
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
      Assert.assertTrue(targetPlatform.eResource().getErrors().isEmpty());
      tester.validator().checkOptionsOnLocationAreIdentical(targetPlatform);
      final List<AbstractValidationDiagnostic> diagnotics = IterableExtensions.<AbstractValidationDiagnostic>toList(Iterables.<AbstractValidationDiagnostic>filter(tester.diagnose().getAllDiagnostics(), AbstractValidationDiagnostic.class));
      Assert.assertEquals(0, diagnotics.size());
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
      Assert.assertTrue(targetPlatform.eResource().getErrors().isEmpty());
      tester.validator().checkOptionsOnLocationAreIdentical(targetPlatform);
      final List<AbstractValidationDiagnostic> diagnotics = IterableExtensions.<AbstractValidationDiagnostic>toList(Iterables.<AbstractValidationDiagnostic>filter(tester.diagnose().getAllDiagnostics(), AbstractValidationDiagnostic.class));
      Assert.assertEquals(2, diagnotics.size());
      final Function1<AbstractValidationDiagnostic, Boolean> _function = new Function1<AbstractValidationDiagnostic, Boolean>() {
        @Override
        public Boolean apply(final AbstractValidationDiagnostic it) {
          EObject _sourceEObject = it.getSourceEObject();
          return Boolean.valueOf((_sourceEObject instanceof Location));
        }
      };
      Assert.assertTrue(IterableExtensions.<AbstractValidationDiagnostic>forall(diagnotics, _function));
      final Consumer<AbstractValidationDiagnostic> _function_1 = new Consumer<AbstractValidationDiagnostic>() {
        @Override
        public void accept(final AbstractValidationDiagnostic it) {
          Assert.assertEquals(TargetPlatformValidator.CHECK__OPTIONS_EQUALS_ALL_LOCATIONS, it.getIssueCode());
        }
      };
      diagnotics.forEach(_function_1);
      EObject _sourceEObject = diagnotics.get(0).getSourceEObject();
      Assert.assertEquals("mylocationURI1", ((Location) _sourceEObject).getUri());
      EObject _sourceEObject_1 = diagnotics.get(1).getSourceEObject();
      Assert.assertEquals("mylocationURI2", ((Location) _sourceEObject_1).getUri());
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
      Assert.assertTrue(targetPlatform.eResource().getErrors().isEmpty());
      tester.validator().deprecateOptionsOnLocation(IterableExtensions.<Location>head(targetPlatform.getLocations()));
      final List<AbstractValidationDiagnostic> diagnotics = IterableExtensions.<AbstractValidationDiagnostic>toList(Iterables.<AbstractValidationDiagnostic>filter(tester.diagnose().getAllDiagnostics(), AbstractValidationDiagnostic.class));
      Assert.assertEquals(0, diagnotics.size());
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
      Assert.assertTrue(targetPlatform.eResource().getErrors().isEmpty());
      tester.validator().deprecateOptionsOnLocation(IterableExtensions.<Location>head(targetPlatform.getLocations()));
      final List<AbstractValidationDiagnostic> diagnotics = IterableExtensions.<AbstractValidationDiagnostic>toList(Iterables.<AbstractValidationDiagnostic>filter(tester.diagnose().getAllDiagnostics(), AbstractValidationDiagnostic.class));
      Assert.assertEquals(0, diagnotics.size());
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
      Assert.assertTrue(targetPlatform.eResource().getErrors().isEmpty());
      tester.validator().deprecateOptionsOnLocation(IterableExtensions.<Location>head(targetPlatform.getLocations()));
      final List<AbstractValidationDiagnostic> diagnotics = IterableExtensions.<AbstractValidationDiagnostic>toList(Iterables.<AbstractValidationDiagnostic>filter(tester.diagnose().getAllDiagnostics(), AbstractValidationDiagnostic.class));
      Assert.assertEquals(0, diagnotics.size());
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
      Assert.assertTrue(targetPlatform.eResource().getErrors().isEmpty());
      tester.validator().deprecateOptionsOnLocation(IterableExtensions.<Location>head(targetPlatform.getLocations()));
      final List<AbstractValidationDiagnostic> diagnotics = IterableExtensions.<AbstractValidationDiagnostic>toList(Iterables.<AbstractValidationDiagnostic>filter(tester.diagnose().getAllDiagnostics(), AbstractValidationDiagnostic.class));
      Assert.assertEquals(1, diagnotics.size());
      final Function1<AbstractValidationDiagnostic, Boolean> _function = new Function1<AbstractValidationDiagnostic, Boolean>() {
        @Override
        public Boolean apply(final AbstractValidationDiagnostic it) {
          EObject _sourceEObject = it.getSourceEObject();
          return Boolean.valueOf((_sourceEObject instanceof Location));
        }
      };
      Assert.assertTrue(IterableExtensions.<AbstractValidationDiagnostic>forall(diagnotics, _function));
      final Consumer<AbstractValidationDiagnostic> _function_1 = new Consumer<AbstractValidationDiagnostic>() {
        @Override
        public void accept(final AbstractValidationDiagnostic it) {
          Assert.assertEquals(TargetPlatformValidator.DEPRECATE__OPTIONS_ON_LOCATIONS, it.getIssueCode());
        }
      };
      diagnotics.forEach(_function_1);
      EObject _sourceEObject = diagnotics.get(0).getSourceEObject();
      Assert.assertEquals("mylocationURI1", ((Location) _sourceEObject).getUri());
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
      Assert.assertTrue(targetPlatform.eResource().getErrors().isEmpty());
      tester.validator().deprecateOptionsOnLocation(IterableExtensions.<Location>head(targetPlatform.getLocations()));
      final List<AbstractValidationDiagnostic> diagnotics = IterableExtensions.<AbstractValidationDiagnostic>toList(Iterables.<AbstractValidationDiagnostic>filter(tester.diagnose().getAllDiagnostics(), AbstractValidationDiagnostic.class));
      Assert.assertEquals(1, diagnotics.size());
      final Function1<AbstractValidationDiagnostic, Boolean> _function = new Function1<AbstractValidationDiagnostic, Boolean>() {
        @Override
        public Boolean apply(final AbstractValidationDiagnostic it) {
          EObject _sourceEObject = it.getSourceEObject();
          return Boolean.valueOf((_sourceEObject instanceof Location));
        }
      };
      Assert.assertTrue(IterableExtensions.<AbstractValidationDiagnostic>forall(diagnotics, _function));
      final Consumer<AbstractValidationDiagnostic> _function_1 = new Consumer<AbstractValidationDiagnostic>() {
        @Override
        public void accept(final AbstractValidationDiagnostic it) {
          Assert.assertEquals(TargetPlatformValidator.DEPRECATE__OPTIONS_ON_LOCATIONS, it.getIssueCode());
        }
      };
      diagnotics.forEach(_function_1);
      EObject _sourceEObject = diagnotics.get(0).getSourceEObject();
      Assert.assertEquals("mylocationURI1", ((Location) _sourceEObject).getUri());
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
      Assert.assertTrue(targetPlatform.eResource().getErrors().isEmpty());
      tester.validator().deprecateIUVersionRangeWihString(IterableExtensions.<IU>head(IterableExtensions.<Location>head(targetPlatform.getLocations()).getIus()));
      final List<AbstractValidationDiagnostic> diagnotics = IterableExtensions.<AbstractValidationDiagnostic>toList(Iterables.<AbstractValidationDiagnostic>filter(tester.diagnose().getAllDiagnostics(), AbstractValidationDiagnostic.class));
      Assert.assertEquals(1, diagnotics.size());
      final Function1<AbstractValidationDiagnostic, Boolean> _function = new Function1<AbstractValidationDiagnostic, Boolean>() {
        @Override
        public Boolean apply(final AbstractValidationDiagnostic it) {
          EObject _sourceEObject = it.getSourceEObject();
          return Boolean.valueOf((_sourceEObject instanceof IU));
        }
      };
      Assert.assertTrue(IterableExtensions.<AbstractValidationDiagnostic>forall(diagnotics, _function));
      final Consumer<AbstractValidationDiagnostic> _function_1 = new Consumer<AbstractValidationDiagnostic>() {
        @Override
        public void accept(final AbstractValidationDiagnostic it) {
          Assert.assertEquals(TargetPlatformValidator.DEPRECATE__STRINGS_ON_IU_VERSION, it.getIssueCode());
        }
      };
      diagnotics.forEach(_function_1);
      EObject _sourceEObject = diagnotics.get(0).getSourceEObject();
      Assert.assertEquals("my.iu", ((IU) _sourceEObject).getID());
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
      Assert.assertTrue(targetPlatform.eResource().getErrors().isEmpty());
      tester.validator().deprecateIUVersionRangeWihString(IterableExtensions.<IU>head(IterableExtensions.<Location>head(targetPlatform.getLocations()).getIus()));
      final List<AbstractValidationDiagnostic> diagnotics = IterableExtensions.<AbstractValidationDiagnostic>toList(Iterables.<AbstractValidationDiagnostic>filter(tester.diagnose().getAllDiagnostics(), AbstractValidationDiagnostic.class));
      Assert.assertEquals(0, diagnotics.size());
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
      Assert.assertTrue(targetPlatform.eResource().getErrors().isEmpty());
      tester.validator().deprecateIUVersionRangeWihString(IterableExtensions.<IU>head(IterableExtensions.<Location>head(targetPlatform.getLocations()).getIus()));
      final List<AbstractValidationDiagnostic> diagnotics = IterableExtensions.<AbstractValidationDiagnostic>toList(Iterables.<AbstractValidationDiagnostic>filter(tester.diagnose().getAllDiagnostics(), AbstractValidationDiagnostic.class));
      Assert.assertEquals(0, diagnotics.size());
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
      Assert.assertTrue(targetPlatform.eResource().getErrors().isEmpty());
      tester.validator().checkSameIDForAllLocationWithSameURI(targetPlatform);
      final List<AbstractValidationDiagnostic> diagnotics = IterableExtensions.<AbstractValidationDiagnostic>toList(Iterables.<AbstractValidationDiagnostic>filter(tester.diagnose().getAllDiagnostics(), AbstractValidationDiagnostic.class));
      Assert.assertEquals(0, diagnotics.size());
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
      Assert.assertTrue(targetPlatform.eResource().getErrors().isEmpty());
      tester.validator().checkSameIDForAllLocationWithSameURI(targetPlatform);
      final List<AbstractValidationDiagnostic> diagnotics = IterableExtensions.<AbstractValidationDiagnostic>toList(Iterables.<AbstractValidationDiagnostic>filter(tester.diagnose().getAllDiagnostics(), AbstractValidationDiagnostic.class));
      Assert.assertEquals(0, diagnotics.size());
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
      Assert.assertTrue(targetPlatform.eResource().getErrors().isEmpty());
      tester.validator().checkSameIDForAllLocationWithSameURI(targetPlatform);
      final List<AbstractValidationDiagnostic> diagnotics = IterableExtensions.<AbstractValidationDiagnostic>toList(Iterables.<AbstractValidationDiagnostic>filter(tester.diagnose().getAllDiagnostics(), AbstractValidationDiagnostic.class));
      Assert.assertEquals(0, diagnotics.size());
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
      Assert.assertTrue(targetPlatform.eResource().getErrors().isEmpty());
      tester.validator().checkSameIDForAllLocationWithSameURI(targetPlatform);
      final List<AbstractValidationDiagnostic> diagnotics = IterableExtensions.<AbstractValidationDiagnostic>toList(Iterables.<AbstractValidationDiagnostic>filter(tester.diagnose().getAllDiagnostics(), AbstractValidationDiagnostic.class));
      Assert.assertEquals(0, diagnotics.size());
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
      Assert.assertTrue(targetPlatform.eResource().getErrors().isEmpty());
      tester.validator().checkSameIDForAllLocationWithSameURI(targetPlatform);
      final List<AbstractValidationDiagnostic> diagnotics = IterableExtensions.<AbstractValidationDiagnostic>toList(Iterables.<AbstractValidationDiagnostic>filter(tester.diagnose().getAllDiagnostics(), AbstractValidationDiagnostic.class));
      Assert.assertEquals(0, diagnotics.size());
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
      Assert.assertTrue(targetPlatform.eResource().getErrors().isEmpty());
      tester.validator().checkSameIDForAllLocationWithSameURI(targetPlatform);
      final List<AbstractValidationDiagnostic> diagnotics = IterableExtensions.<AbstractValidationDiagnostic>toList(Iterables.<AbstractValidationDiagnostic>filter(tester.diagnose().getAllDiagnostics(), AbstractValidationDiagnostic.class));
      Assert.assertEquals(2, diagnotics.size());
      final Function1<AbstractValidationDiagnostic, Boolean> _function = new Function1<AbstractValidationDiagnostic, Boolean>() {
        @Override
        public Boolean apply(final AbstractValidationDiagnostic it) {
          EObject _sourceEObject = it.getSourceEObject();
          return Boolean.valueOf((_sourceEObject instanceof Location));
        }
      };
      Assert.assertTrue(IterableExtensions.<AbstractValidationDiagnostic>forall(diagnotics, _function));
      final Consumer<AbstractValidationDiagnostic> _function_1 = new Consumer<AbstractValidationDiagnostic>() {
        @Override
        public void accept(final AbstractValidationDiagnostic it) {
          Assert.assertEquals(TargetPlatformValidator.CHECK__LOCATION_CONFLICTUAL_ID, it.getIssueCode());
          EObject _sourceEObject = it.getSourceEObject();
          Assert.assertEquals("mylocationURI1", ((Location) _sourceEObject).getUri());
        }
      };
      diagnotics.forEach(_function_1);
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
      Assert.assertTrue(targetPlatform.eResource().getErrors().isEmpty());
      tester.validator().checkSameIDForAllLocationWithSameURI(targetPlatform);
      final List<AbstractValidationDiagnostic> diagnotics = IterableExtensions.<AbstractValidationDiagnostic>toList(Iterables.<AbstractValidationDiagnostic>filter(tester.diagnose().getAllDiagnostics(), AbstractValidationDiagnostic.class));
      Assert.assertEquals(2, diagnotics.size());
      final Function1<AbstractValidationDiagnostic, Boolean> _function = new Function1<AbstractValidationDiagnostic, Boolean>() {
        @Override
        public Boolean apply(final AbstractValidationDiagnostic it) {
          EObject _sourceEObject = it.getSourceEObject();
          return Boolean.valueOf((_sourceEObject instanceof Location));
        }
      };
      Assert.assertTrue(IterableExtensions.<AbstractValidationDiagnostic>forall(diagnotics, _function));
      final Consumer<AbstractValidationDiagnostic> _function_1 = new Consumer<AbstractValidationDiagnostic>() {
        @Override
        public void accept(final AbstractValidationDiagnostic it) {
          Assert.assertEquals(TargetPlatformValidator.CHECK__LOCATION_CONFLICTUAL_ID, it.getIssueCode());
          EObject _sourceEObject = it.getSourceEObject();
          Assert.assertEquals("mylocationURI1", ((Location) _sourceEObject).getUri());
        }
      };
      diagnotics.forEach(_function_1);
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
      final TargetPlatform tpa = this.parser.parse(_builder, URI.createURI("tmp:/a.tpd"), resourceSet);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("target \"tp.b\"");
      _builder_1.newLine();
      this.parser.parse(_builder_1, URI.createURI("tmp:/b.tpd"), resourceSet);
      Assert.assertTrue(tpa.eResource().getErrors().isEmpty());
      tester.validator().checkSameIDForAllLocationWithSameURI(tpa);
      final List<AbstractValidationDiagnostic> diagnotics = IterableExtensions.<AbstractValidationDiagnostic>toList(Iterables.<AbstractValidationDiagnostic>filter(tester.diagnose().getAllDiagnostics(), AbstractValidationDiagnostic.class));
      Assert.assertEquals(0, diagnotics.size());
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
      final TargetPlatform tpa = this.parser.parse(_builder, URI.createURI("tmp:/a.tpd"), resourceSet);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("target \"tp.b\"");
      _builder_1.newLine();
      this.parser.parse(_builder_1, URI.createURI("tmp:/b.tpd"), resourceSet);
      Assert.assertTrue(tpa.eResource().getErrors().isEmpty());
      tester.validator().checkSameIDForAllLocationWithSameURI(tpa);
      final List<AbstractValidationDiagnostic> diagnotics = IterableExtensions.<AbstractValidationDiagnostic>toList(Iterables.<AbstractValidationDiagnostic>filter(tester.diagnose().getAllDiagnostics(), AbstractValidationDiagnostic.class));
      Assert.assertEquals(0, diagnotics.size());
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
      final TargetPlatform tpa = this.parser.parse(_builder, URI.createURI("tmp:/a.tpd"), resourceSet);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("target \"tp.b\"");
      _builder_1.newLine();
      _builder_1.append("location \"locationURI1\"");
      _builder_1.newLine();
      this.parser.parse(_builder_1, URI.createURI("tmp:/b.tpd"), resourceSet);
      Assert.assertTrue(tpa.eResource().getErrors().isEmpty());
      tester.validator().checkSameIDForAllLocationWithSameURI(tpa);
      final List<AbstractValidationDiagnostic> diagnotics = IterableExtensions.<AbstractValidationDiagnostic>toList(Iterables.<AbstractValidationDiagnostic>filter(tester.diagnose().getAllDiagnostics(), AbstractValidationDiagnostic.class));
      Assert.assertEquals(0, diagnotics.size());
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
      final TargetPlatform tpa = this.parser.parse(_builder, URI.createURI("tmp:/a.tpd"), resourceSet);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("target \"tp.b\"");
      _builder_1.newLine();
      _builder_1.append("location A \"locationURI1\"");
      _builder_1.newLine();
      this.parser.parse(_builder_1, URI.createURI("tmp:/b.tpd"), resourceSet);
      Assert.assertTrue(tpa.eResource().getErrors().isEmpty());
      tester.validator().checkSameIDForAllLocationWithSameURI(tpa);
      final List<AbstractValidationDiagnostic> diagnotics = IterableExtensions.<AbstractValidationDiagnostic>toList(Iterables.<AbstractValidationDiagnostic>filter(tester.diagnose().getAllDiagnostics(), AbstractValidationDiagnostic.class));
      Assert.assertEquals(0, diagnotics.size());
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
      final TargetPlatform tpa = this.parser.parse(_builder, URI.createURI("tmp:/a.tpd"), resourceSet);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("target \"tp.b\"");
      _builder_1.newLine();
      _builder_1.append("location A \"locationURI1\"");
      _builder_1.newLine();
      this.parser.parse(_builder_1, URI.createURI("tmp:/b.tpd"), resourceSet);
      Assert.assertTrue(tpa.eResource().getErrors().isEmpty());
      tester.validator().checkSameIDForAllLocationWithSameURI(tpa);
      final List<AbstractValidationDiagnostic> diagnotics = IterableExtensions.<AbstractValidationDiagnostic>toList(Iterables.<AbstractValidationDiagnostic>filter(tester.diagnose().getAllDiagnostics(), AbstractValidationDiagnostic.class));
      Assert.assertEquals(1, diagnotics.size());
      final Function1<AbstractValidationDiagnostic, Boolean> _function = new Function1<AbstractValidationDiagnostic, Boolean>() {
        @Override
        public Boolean apply(final AbstractValidationDiagnostic it) {
          EObject _sourceEObject = it.getSourceEObject();
          return Boolean.valueOf((_sourceEObject instanceof Location));
        }
      };
      Assert.assertTrue(IterableExtensions.<AbstractValidationDiagnostic>forall(diagnotics, _function));
      final Consumer<AbstractValidationDiagnostic> _function_1 = new Consumer<AbstractValidationDiagnostic>() {
        @Override
        public void accept(final AbstractValidationDiagnostic it) {
          Assert.assertEquals(TargetPlatformValidator.CHECK__INCLUDED_LOCATION_CONFLICTUAL_ID, it.getIssueCode());
          EObject _sourceEObject = it.getSourceEObject();
          Assert.assertEquals("locationURI1", ((Location) _sourceEObject).getUri());
          EObject _sourceEObject_1 = it.getSourceEObject();
          Assert.assertEquals("tmp:/a.tpd", ((Location) _sourceEObject_1).eResource().getURI().toString());
        }
      };
      diagnotics.forEach(_function_1);
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
      final TargetPlatform tpa = this.parser.parse(_builder, URI.createURI("tmp:/a.tpd"), resourceSet);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("target \"tp.b\"");
      _builder_1.newLine();
      _builder_1.append("location \"locationURI1\"");
      _builder_1.newLine();
      this.parser.parse(_builder_1, URI.createURI("tmp:/b.tpd"), resourceSet);
      Assert.assertTrue(tpa.eResource().getErrors().isEmpty());
      tester.validator().checkSameIDForAllLocationWithSameURI(tpa);
      final List<AbstractValidationDiagnostic> diagnotics = IterableExtensions.<AbstractValidationDiagnostic>toList(Iterables.<AbstractValidationDiagnostic>filter(tester.diagnose().getAllDiagnostics(), AbstractValidationDiagnostic.class));
      Assert.assertEquals(1, diagnotics.size());
      final Function1<AbstractValidationDiagnostic, Boolean> _function = new Function1<AbstractValidationDiagnostic, Boolean>() {
        @Override
        public Boolean apply(final AbstractValidationDiagnostic it) {
          EObject _sourceEObject = it.getSourceEObject();
          return Boolean.valueOf((_sourceEObject instanceof Location));
        }
      };
      Assert.assertTrue(IterableExtensions.<AbstractValidationDiagnostic>forall(diagnotics, _function));
      final Consumer<AbstractValidationDiagnostic> _function_1 = new Consumer<AbstractValidationDiagnostic>() {
        @Override
        public void accept(final AbstractValidationDiagnostic it) {
          Assert.assertEquals(TargetPlatformValidator.CHECK__INCLUDED_LOCATION_CONFLICTUAL_ID, it.getIssueCode());
          EObject _sourceEObject = it.getSourceEObject();
          Assert.assertEquals("locationURI1", ((Location) _sourceEObject).getUri());
          EObject _sourceEObject_1 = it.getSourceEObject();
          Assert.assertEquals("tmp:/a.tpd", ((Location) _sourceEObject_1).eResource().getURI().toString());
        }
      };
      diagnotics.forEach(_function_1);
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
      final TargetPlatform tpa = this.parser.parse(_builder, URI.createURI("tmp:/a.tpd"), resourceSet);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("target \"tp.b\"");
      _builder_1.newLine();
      _builder_1.append("location A \"locationURI2\"");
      _builder_1.newLine();
      this.parser.parse(_builder_1, URI.createURI("tmp:/b.tpd"), resourceSet);
      Assert.assertTrue(tpa.eResource().getErrors().isEmpty());
      tester.validator().checkSameIDForAllLocationWithSameURI(tpa);
      final List<AbstractValidationDiagnostic> diagnotics = IterableExtensions.<AbstractValidationDiagnostic>toList(Iterables.<AbstractValidationDiagnostic>filter(tester.diagnose().getAllDiagnostics(), AbstractValidationDiagnostic.class));
      Assert.assertEquals(0, diagnotics.size());
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
      final TargetPlatform tpa = this.parser.parse(_builder, URI.createURI("tmp:/a.tpd"), resourceSet);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("target \"tp.b\"");
      _builder_1.newLine();
      _builder_1.append("include \"c.tpd\"");
      _builder_1.newLine();
      _builder_1.append("location A \"locationURI1\"");
      _builder_1.newLine();
      this.parser.parse(_builder_1, URI.createURI("tmp:/b.tpd"), resourceSet);
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("target \"tp.c\"");
      _builder_2.newLine();
      _builder_2.append("location A \"locationURI1\"");
      _builder_2.newLine();
      this.parser.parse(_builder_2, URI.createURI("tmp:/c.tpd"), resourceSet);
      Assert.assertTrue(tpa.eResource().getErrors().isEmpty());
      tester.validator().checkSameIDForAllLocationWithSameURI(tpa);
      final List<AbstractValidationDiagnostic> diagnotics = IterableExtensions.<AbstractValidationDiagnostic>toList(Iterables.<AbstractValidationDiagnostic>filter(tester.diagnose().getAllDiagnostics(), AbstractValidationDiagnostic.class));
      Assert.assertEquals(0, diagnotics.size());
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
      final TargetPlatform tpa = this.parser.parse(_builder, URI.createURI("tmp:/a.tpd"), resourceSet);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("target \"tp.b\"");
      _builder_1.newLine();
      _builder_1.append("include \"c.tpd\"");
      _builder_1.newLine();
      _builder_1.append("location A \"locationURI1\"");
      _builder_1.newLine();
      final TargetPlatform tpb = this.parser.parse(_builder_1, URI.createURI("tmp:/b.tpd"), resourceSet);
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("target \"tp.c\"");
      _builder_2.newLine();
      _builder_2.append("location C \"locationURI1\"");
      _builder_2.newLine();
      final TargetPlatform tpc = this.parser.parse(_builder_2, URI.createURI("tmp:/c.tpd"), resourceSet);
      Assert.assertTrue(tpa.eResource().getErrors().isEmpty());
      tester.validator().checkSameIDForAllLocationWithSameURI(tpa);
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
          Assert.assertEquals(TargetPlatformValidator.CHECK__CONFLICTUAL_ID__BETWEEN_INCLUDED_LOCATION, it.getIssueCode());
          EObject _sourceEObject = it.getSourceEObject();
          Assert.assertEquals("b.tpd", ((IncludeDeclaration) _sourceEObject).getImportURI());
          EObject _sourceEObject_1 = it.getSourceEObject();
          Assert.assertEquals("tmp:/a.tpd", ((IncludeDeclaration) _sourceEObject_1).eResource().getURI().toString());
        }
      };
      diagnotics.forEach(_function_1);
      Assert.assertTrue(tpb.eResource().getErrors().isEmpty());
      tester.validator().checkSameIDForAllLocationWithSameURI(tpb);
      diagnotics = IterableExtensions.<AbstractValidationDiagnostic>toList(Iterables.<AbstractValidationDiagnostic>filter(tester.diagnose().getAllDiagnostics(), AbstractValidationDiagnostic.class));
      Assert.assertEquals(1, diagnotics.size());
      final Function1<AbstractValidationDiagnostic, Boolean> _function_2 = new Function1<AbstractValidationDiagnostic, Boolean>() {
        @Override
        public Boolean apply(final AbstractValidationDiagnostic it) {
          EObject _sourceEObject = it.getSourceEObject();
          return Boolean.valueOf((_sourceEObject instanceof Location));
        }
      };
      Assert.assertTrue(IterableExtensions.<AbstractValidationDiagnostic>forall(diagnotics, _function_2));
      final Consumer<AbstractValidationDiagnostic> _function_3 = new Consumer<AbstractValidationDiagnostic>() {
        @Override
        public void accept(final AbstractValidationDiagnostic it) {
          Assert.assertEquals(TargetPlatformValidator.CHECK__INCLUDED_LOCATION_CONFLICTUAL_ID, it.getIssueCode());
          EObject _sourceEObject = it.getSourceEObject();
          Assert.assertEquals("locationURI1", ((Location) _sourceEObject).getUri());
          EObject _sourceEObject_1 = it.getSourceEObject();
          Assert.assertEquals("tmp:/b.tpd", ((Location) _sourceEObject_1).eResource().getURI().toString());
        }
      };
      diagnotics.forEach(_function_3);
      Assert.assertTrue(tpc.eResource().getErrors().isEmpty());
      tester.validator().checkSameIDForAllLocationWithSameURI(tpc);
      diagnotics = IterableExtensions.<AbstractValidationDiagnostic>toList(Iterables.<AbstractValidationDiagnostic>filter(tester.diagnose().getAllDiagnostics(), AbstractValidationDiagnostic.class));
      Assert.assertEquals(0, diagnotics.size());
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
      final TargetPlatform tpa = this.parser.parse(_builder, URI.createURI("tmp:/a.tpd"), resourceSet);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("target \"tp.b\"");
      _builder_1.newLine();
      _builder_1.append("include \"c.tpd\"");
      _builder_1.newLine();
      _builder_1.append("location B \"locationURI1\"");
      _builder_1.newLine();
      final TargetPlatform tpb = this.parser.parse(_builder_1, URI.createURI("tmp:/b.tpd"), resourceSet);
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("target \"tp.c\"");
      _builder_2.newLine();
      _builder_2.append("location A \"locationURI1\"");
      _builder_2.newLine();
      final TargetPlatform tpc = this.parser.parse(_builder_2, URI.createURI("tmp:/c.tpd"), resourceSet);
      Assert.assertTrue(tpa.eResource().getErrors().isEmpty());
      tester.validator().checkSameIDForAllLocationWithSameURI(tpa);
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
          Assert.assertEquals(TargetPlatformValidator.CHECK__CONFLICTUAL_ID__BETWEEN_INCLUDED_LOCATION, it.getIssueCode());
          EObject _sourceEObject = it.getSourceEObject();
          Assert.assertEquals("b.tpd", ((IncludeDeclaration) _sourceEObject).getImportURI());
          EObject _sourceEObject_1 = it.getSourceEObject();
          Assert.assertEquals("tmp:/a.tpd", ((IncludeDeclaration) _sourceEObject_1).eResource().getURI().toString());
        }
      };
      diagnotics.forEach(_function_1);
      Assert.assertTrue(tpb.eResource().getErrors().isEmpty());
      tester.validator().checkSameIDForAllLocationWithSameURI(tpb);
      diagnotics = IterableExtensions.<AbstractValidationDiagnostic>toList(Iterables.<AbstractValidationDiagnostic>filter(tester.diagnose().getAllDiagnostics(), AbstractValidationDiagnostic.class));
      Assert.assertEquals(1, diagnotics.size());
      final Function1<AbstractValidationDiagnostic, Boolean> _function_2 = new Function1<AbstractValidationDiagnostic, Boolean>() {
        @Override
        public Boolean apply(final AbstractValidationDiagnostic it) {
          EObject _sourceEObject = it.getSourceEObject();
          return Boolean.valueOf((_sourceEObject instanceof Location));
        }
      };
      Assert.assertTrue(IterableExtensions.<AbstractValidationDiagnostic>forall(diagnotics, _function_2));
      final Consumer<AbstractValidationDiagnostic> _function_3 = new Consumer<AbstractValidationDiagnostic>() {
        @Override
        public void accept(final AbstractValidationDiagnostic it) {
          Assert.assertEquals(TargetPlatformValidator.CHECK__INCLUDED_LOCATION_CONFLICTUAL_ID, it.getIssueCode());
          EObject _sourceEObject = it.getSourceEObject();
          Assert.assertEquals("locationURI1", ((Location) _sourceEObject).getUri());
          EObject _sourceEObject_1 = it.getSourceEObject();
          Assert.assertEquals("tmp:/b.tpd", ((Location) _sourceEObject_1).eResource().getURI().toString());
        }
      };
      diagnotics.forEach(_function_3);
      Assert.assertTrue(tpc.eResource().getErrors().isEmpty());
      tester.validator().checkSameIDForAllLocationWithSameURI(tpc);
      diagnotics = IterableExtensions.<AbstractValidationDiagnostic>toList(Iterables.<AbstractValidationDiagnostic>filter(tester.diagnose().getAllDiagnostics(), AbstractValidationDiagnostic.class));
      Assert.assertEquals(0, diagnotics.size());
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
      final TargetPlatform tpa = this.parser.parse(_builder, URI.createURI("tmp:/a.tpd"), resourceSet);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("target \"tp.b\"");
      _builder_1.newLine();
      _builder_1.append("include \"c.tpd\"");
      _builder_1.newLine();
      _builder_1.append("location A \"locationURI1\"");
      _builder_1.newLine();
      final TargetPlatform tpb = this.parser.parse(_builder_1, URI.createURI("tmp:/b.tpd"), resourceSet);
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("target \"tp.c\"");
      _builder_2.newLine();
      _builder_2.append("location \"locationURI1\"");
      _builder_2.newLine();
      final TargetPlatform tpc = this.parser.parse(_builder_2, URI.createURI("tmp:/c.tpd"), resourceSet);
      Assert.assertTrue(tpa.eResource().getErrors().isEmpty());
      tester.validator().checkSameIDForAllLocationWithSameURI(tpa);
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
          Assert.assertEquals(TargetPlatformValidator.CHECK__CONFLICTUAL_ID__BETWEEN_INCLUDED_LOCATION, it.getIssueCode());
          EObject _sourceEObject = it.getSourceEObject();
          Assert.assertEquals("b.tpd", ((IncludeDeclaration) _sourceEObject).getImportURI());
          EObject _sourceEObject_1 = it.getSourceEObject();
          Assert.assertEquals("tmp:/a.tpd", ((IncludeDeclaration) _sourceEObject_1).eResource().getURI().toString());
        }
      };
      diagnotics.forEach(_function_1);
      Assert.assertTrue(tpb.eResource().getErrors().isEmpty());
      tester.validator().checkSameIDForAllLocationWithSameURI(tpb);
      diagnotics = IterableExtensions.<AbstractValidationDiagnostic>toList(Iterables.<AbstractValidationDiagnostic>filter(tester.diagnose().getAllDiagnostics(), AbstractValidationDiagnostic.class));
      Assert.assertEquals(1, diagnotics.size());
      final Function1<AbstractValidationDiagnostic, Boolean> _function_2 = new Function1<AbstractValidationDiagnostic, Boolean>() {
        @Override
        public Boolean apply(final AbstractValidationDiagnostic it) {
          EObject _sourceEObject = it.getSourceEObject();
          return Boolean.valueOf((_sourceEObject instanceof Location));
        }
      };
      Assert.assertTrue(IterableExtensions.<AbstractValidationDiagnostic>forall(diagnotics, _function_2));
      final Consumer<AbstractValidationDiagnostic> _function_3 = new Consumer<AbstractValidationDiagnostic>() {
        @Override
        public void accept(final AbstractValidationDiagnostic it) {
          Assert.assertEquals(TargetPlatformValidator.CHECK__INCLUDED_LOCATION_CONFLICTUAL_ID, it.getIssueCode());
          EObject _sourceEObject = it.getSourceEObject();
          Assert.assertEquals("locationURI1", ((Location) _sourceEObject).getUri());
          EObject _sourceEObject_1 = it.getSourceEObject();
          Assert.assertEquals("tmp:/b.tpd", ((Location) _sourceEObject_1).eResource().getURI().toString());
        }
      };
      diagnotics.forEach(_function_3);
      Assert.assertTrue(tpc.eResource().getErrors().isEmpty());
      tester.validator().checkSameIDForAllLocationWithSameURI(tpc);
      diagnotics = IterableExtensions.<AbstractValidationDiagnostic>toList(Iterables.<AbstractValidationDiagnostic>filter(tester.diagnose().getAllDiagnostics(), AbstractValidationDiagnostic.class));
      Assert.assertEquals(0, diagnotics.size());
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
      final TargetPlatform tpa = this.parser.parse(_builder, URI.createURI("tmp:/a.tpd"), resourceSet);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("target \"tp.b\"");
      _builder_1.newLine();
      _builder_1.append("include \"c.tpd\"");
      _builder_1.newLine();
      _builder_1.append("location \"locationURI1\"");
      _builder_1.newLine();
      this.parser.parse(_builder_1, URI.createURI("tmp:/b.tpd"), resourceSet);
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("target \"tp.c\"");
      _builder_2.newLine();
      _builder_2.append("location \"locationURI1\"");
      _builder_2.newLine();
      this.parser.parse(_builder_2, URI.createURI("tmp:/c.tpd"), resourceSet);
      Assert.assertTrue(tpa.eResource().getErrors().isEmpty());
      tester.validator().checkSameIDForAllLocationWithSameURI(tpa);
      final List<AbstractValidationDiagnostic> diagnotics = IterableExtensions.<AbstractValidationDiagnostic>toList(Iterables.<AbstractValidationDiagnostic>filter(tester.diagnose().getAllDiagnostics(), AbstractValidationDiagnostic.class));
      Assert.assertEquals(0, diagnotics.size());
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
      final TargetPlatform tpa = this.parser.parse(_builder, URI.createURI("tmp:/a.tpd"), resourceSet);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("target \"tp.b\"");
      _builder_1.newLine();
      _builder_1.append("include \"c.tpd\"");
      _builder_1.newLine();
      _builder_1.append("location \"locationURI1\"");
      _builder_1.newLine();
      final TargetPlatform tpb = this.parser.parse(_builder_1, URI.createURI("tmp:/b.tpd"), resourceSet);
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("target \"tp.c\"");
      _builder_2.newLine();
      _builder_2.append("location C \"locationURI1\"");
      _builder_2.newLine();
      final TargetPlatform tpc = this.parser.parse(_builder_2, URI.createURI("tmp:/c.tpd"), resourceSet);
      Assert.assertTrue(tpa.eResource().getErrors().isEmpty());
      tester.validator().checkSameIDForAllLocationWithSameURI(tpa);
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
          Assert.assertEquals(TargetPlatformValidator.CHECK__CONFLICTUAL_ID__BETWEEN_INCLUDED_LOCATION, it.getIssueCode());
          EObject _sourceEObject = it.getSourceEObject();
          Assert.assertEquals("b.tpd", ((IncludeDeclaration) _sourceEObject).getImportURI());
          EObject _sourceEObject_1 = it.getSourceEObject();
          Assert.assertEquals("tmp:/a.tpd", ((IncludeDeclaration) _sourceEObject_1).eResource().getURI().toString());
        }
      };
      diagnotics.forEach(_function_1);
      Assert.assertTrue(tpb.eResource().getErrors().isEmpty());
      tester.validator().checkSameIDForAllLocationWithSameURI(tpb);
      diagnotics = IterableExtensions.<AbstractValidationDiagnostic>toList(Iterables.<AbstractValidationDiagnostic>filter(tester.diagnose().getAllDiagnostics(), AbstractValidationDiagnostic.class));
      Assert.assertEquals(1, diagnotics.size());
      final Function1<AbstractValidationDiagnostic, Boolean> _function_2 = new Function1<AbstractValidationDiagnostic, Boolean>() {
        @Override
        public Boolean apply(final AbstractValidationDiagnostic it) {
          EObject _sourceEObject = it.getSourceEObject();
          return Boolean.valueOf((_sourceEObject instanceof Location));
        }
      };
      Assert.assertTrue(IterableExtensions.<AbstractValidationDiagnostic>forall(diagnotics, _function_2));
      final Consumer<AbstractValidationDiagnostic> _function_3 = new Consumer<AbstractValidationDiagnostic>() {
        @Override
        public void accept(final AbstractValidationDiagnostic it) {
          Assert.assertEquals(TargetPlatformValidator.CHECK__INCLUDED_LOCATION_CONFLICTUAL_ID, it.getIssueCode());
          EObject _sourceEObject = it.getSourceEObject();
          Assert.assertEquals("locationURI1", ((Location) _sourceEObject).getUri());
          EObject _sourceEObject_1 = it.getSourceEObject();
          Assert.assertEquals("tmp:/b.tpd", ((Location) _sourceEObject_1).eResource().getURI().toString());
        }
      };
      diagnotics.forEach(_function_3);
      Assert.assertTrue(tpc.eResource().getErrors().isEmpty());
      tester.validator().checkSameIDForAllLocationWithSameURI(tpc);
      diagnotics = IterableExtensions.<AbstractValidationDiagnostic>toList(Iterables.<AbstractValidationDiagnostic>filter(tester.diagnose().getAllDiagnostics(), AbstractValidationDiagnostic.class));
      Assert.assertEquals(0, diagnotics.size());
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
      final TargetPlatform tpa = this.parser.parse(_builder, URI.createURI("tmp:/a.tpd"), resourceSet);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("target \"tp.b\"");
      _builder_1.newLine();
      _builder_1.append("include \"c.tpd\"");
      _builder_1.newLine();
      _builder_1.append("location A \"locationURI1\"");
      _builder_1.newLine();
      final TargetPlatform tpb = this.parser.parse(_builder_1, URI.createURI("tmp:/b.tpd"), resourceSet);
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("target \"tp.c\"");
      _builder_2.newLine();
      _builder_2.append("location \"locationURI1\"");
      _builder_2.newLine();
      final TargetPlatform tpc = this.parser.parse(_builder_2, URI.createURI("tmp:/c.tpd"), resourceSet);
      Assert.assertTrue(tpa.eResource().getErrors().isEmpty());
      tester.validator().checkSameIDForAllLocationWithSameURI(tpa);
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
          Assert.assertEquals(TargetPlatformValidator.CHECK__CONFLICTUAL_ID__BETWEEN_INCLUDED_LOCATION, it.getIssueCode());
          EObject _sourceEObject = it.getSourceEObject();
          Assert.assertEquals("b.tpd", ((IncludeDeclaration) _sourceEObject).getImportURI());
          EObject _sourceEObject_1 = it.getSourceEObject();
          Assert.assertEquals("tmp:/a.tpd", ((IncludeDeclaration) _sourceEObject_1).eResource().getURI().toString());
        }
      };
      diagnotics.forEach(_function_1);
      Assert.assertTrue(tpb.eResource().getErrors().isEmpty());
      tester.validator().checkSameIDForAllLocationWithSameURI(tpb);
      diagnotics = IterableExtensions.<AbstractValidationDiagnostic>toList(Iterables.<AbstractValidationDiagnostic>filter(tester.diagnose().getAllDiagnostics(), AbstractValidationDiagnostic.class));
      Assert.assertEquals(1, diagnotics.size());
      final Function1<AbstractValidationDiagnostic, Boolean> _function_2 = new Function1<AbstractValidationDiagnostic, Boolean>() {
        @Override
        public Boolean apply(final AbstractValidationDiagnostic it) {
          EObject _sourceEObject = it.getSourceEObject();
          return Boolean.valueOf((_sourceEObject instanceof Location));
        }
      };
      Assert.assertTrue(IterableExtensions.<AbstractValidationDiagnostic>forall(diagnotics, _function_2));
      final Consumer<AbstractValidationDiagnostic> _function_3 = new Consumer<AbstractValidationDiagnostic>() {
        @Override
        public void accept(final AbstractValidationDiagnostic it) {
          Assert.assertEquals(TargetPlatformValidator.CHECK__INCLUDED_LOCATION_CONFLICTUAL_ID, it.getIssueCode());
          EObject _sourceEObject = it.getSourceEObject();
          Assert.assertEquals("locationURI1", ((Location) _sourceEObject).getUri());
          EObject _sourceEObject_1 = it.getSourceEObject();
          Assert.assertEquals("tmp:/b.tpd", ((Location) _sourceEObject_1).eResource().getURI().toString());
        }
      };
      diagnotics.forEach(_function_3);
      Assert.assertTrue(tpc.eResource().getErrors().isEmpty());
      tester.validator().checkSameIDForAllLocationWithSameURI(tpc);
      diagnotics = IterableExtensions.<AbstractValidationDiagnostic>toList(Iterables.<AbstractValidationDiagnostic>filter(tester.diagnose().getAllDiagnostics(), AbstractValidationDiagnostic.class));
      Assert.assertEquals(0, diagnotics.size());
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
      final TargetPlatform tpa = this.parser.parse(_builder, URI.createURI("tmp:/a.tpd"), resourceSet);
      Assert.assertTrue(tpa.eResource().getErrors().isEmpty());
      tester.validator().checkImportCycle(tpa);
      final List<AbstractValidationDiagnostic> diagnotics = IterableExtensions.<AbstractValidationDiagnostic>toList(Iterables.<AbstractValidationDiagnostic>filter(tester.diagnose().getAllDiagnostics(), AbstractValidationDiagnostic.class));
      Assert.assertEquals(0, diagnotics.size());
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
      final TargetPlatform tpa = this.parser.parse(_builder, URI.createURI("tmp:/a.tpd"), resourceSet);
      Assert.assertTrue(tpa.eResource().getErrors().isEmpty());
      tester.validator().checkImportCycle(tpa);
      final List<AbstractValidationDiagnostic> diagnotics = IterableExtensions.<AbstractValidationDiagnostic>toList(Iterables.<AbstractValidationDiagnostic>filter(tester.diagnose().getAllDiagnostics(), AbstractValidationDiagnostic.class));
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
          Assert.assertEquals("a.tpd", ((IncludeDeclaration) _sourceEObject).getImportURI());
        }
      };
      diagnotics.forEach(_function_1);
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
      final TargetPlatform tpa = this.parser.parse(_builder, URI.createURI("tmp:/a.tpd"), resourceSet);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("target \"tp.b\"");
      _builder_1.newLine();
      _builder_1.append("include \"a.tpd\"");
      _builder_1.newLine();
      final TargetPlatform tpb = this.parser.parse(_builder_1, URI.createURI("tmp:/b.tpd"), resourceSet);
      Assert.assertTrue(tpa.eResource().getErrors().isEmpty());
      tester.validator().checkImportCycle(tpa);
      final List<AbstractValidationDiagnostic> diagnoticsa = IterableExtensions.<AbstractValidationDiagnostic>toList(Iterables.<AbstractValidationDiagnostic>filter(tester.diagnose().getAllDiagnostics(), AbstractValidationDiagnostic.class));
      Assert.assertEquals(1, diagnoticsa.size());
      final Function1<AbstractValidationDiagnostic, Boolean> _function = new Function1<AbstractValidationDiagnostic, Boolean>() {
        @Override
        public Boolean apply(final AbstractValidationDiagnostic it) {
          EObject _sourceEObject = it.getSourceEObject();
          return Boolean.valueOf((_sourceEObject instanceof IncludeDeclaration));
        }
      };
      Assert.assertTrue(IterableExtensions.<AbstractValidationDiagnostic>forall(diagnoticsa, _function));
      final Consumer<AbstractValidationDiagnostic> _function_1 = new Consumer<AbstractValidationDiagnostic>() {
        @Override
        public void accept(final AbstractValidationDiagnostic it) {
          Assert.assertEquals(TargetPlatformValidator.CHECK__INCLUDE_CYCLE, it.getIssueCode());
          EObject _sourceEObject = it.getSourceEObject();
          Assert.assertEquals("b.tpd", ((IncludeDeclaration) _sourceEObject).getImportURI());
        }
      };
      diagnoticsa.forEach(_function_1);
      Assert.assertTrue(tpb.eResource().getErrors().isEmpty());
      tester.validator().checkImportCycle(tpb);
      final List<AbstractValidationDiagnostic> diagnoticsb = IterableExtensions.<AbstractValidationDiagnostic>toList(Iterables.<AbstractValidationDiagnostic>filter(tester.diagnose().getAllDiagnostics(), AbstractValidationDiagnostic.class));
      Assert.assertEquals(1, diagnoticsb.size());
      final Function1<AbstractValidationDiagnostic, Boolean> _function_2 = new Function1<AbstractValidationDiagnostic, Boolean>() {
        @Override
        public Boolean apply(final AbstractValidationDiagnostic it) {
          EObject _sourceEObject = it.getSourceEObject();
          return Boolean.valueOf((_sourceEObject instanceof IncludeDeclaration));
        }
      };
      Assert.assertTrue(IterableExtensions.<AbstractValidationDiagnostic>forall(diagnoticsb, _function_2));
      final Consumer<AbstractValidationDiagnostic> _function_3 = new Consumer<AbstractValidationDiagnostic>() {
        @Override
        public void accept(final AbstractValidationDiagnostic it) {
          Assert.assertEquals(TargetPlatformValidator.CHECK__INCLUDE_CYCLE, it.getIssueCode());
          EObject _sourceEObject = it.getSourceEObject();
          Assert.assertEquals("a.tpd", ((IncludeDeclaration) _sourceEObject).getImportURI());
        }
      };
      diagnoticsb.forEach(_function_3);
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
      final TargetPlatform tpa = this.parser.parse(_builder, URI.createURI("tmp:/a.tpd"), resourceSet);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("target \"tp.b\"");
      _builder_1.newLine();
      _builder_1.append("include \"c.tpd\"");
      _builder_1.newLine();
      final TargetPlatform tpb = this.parser.parse(_builder_1, URI.createURI("tmp:/b.tpd"), resourceSet);
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("target \"tp.c\"");
      _builder_2.newLine();
      _builder_2.append("include \"a.tpd\"");
      _builder_2.newLine();
      final TargetPlatform tpc = this.parser.parse(_builder_2, URI.createURI("tmp:/c.tpd"), resourceSet);
      Assert.assertTrue(tpa.eResource().getErrors().isEmpty());
      tester.validator().checkImportCycle(tpa);
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
          Assert.assertEquals("b.tpd", ((IncludeDeclaration) _sourceEObject).getImportURI());
        }
      };
      diagnotics.forEach(_function_1);
      Assert.assertTrue(tpb.eResource().getErrors().isEmpty());
      tester.validator().checkImportCycle(tpb);
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
          Assert.assertEquals("c.tpd", ((IncludeDeclaration) _sourceEObject).getImportURI());
        }
      };
      diagnotics.forEach(_function_3);
      Assert.assertTrue(tpb.eResource().getErrors().isEmpty());
      tester.validator().checkImportCycle(tpc);
      diagnotics = IterableExtensions.<AbstractValidationDiagnostic>toList(Iterables.<AbstractValidationDiagnostic>filter(tester.diagnose().getAllDiagnostics(), AbstractValidationDiagnostic.class));
      Assert.assertEquals(1, diagnotics.size());
      final Function1<AbstractValidationDiagnostic, Boolean> _function_4 = new Function1<AbstractValidationDiagnostic, Boolean>() {
        @Override
        public Boolean apply(final AbstractValidationDiagnostic it) {
          EObject _sourceEObject = it.getSourceEObject();
          return Boolean.valueOf((_sourceEObject instanceof IncludeDeclaration));
        }
      };
      Assert.assertTrue(IterableExtensions.<AbstractValidationDiagnostic>forall(diagnotics, _function_4));
      final Consumer<AbstractValidationDiagnostic> _function_5 = new Consumer<AbstractValidationDiagnostic>() {
        @Override
        public void accept(final AbstractValidationDiagnostic it) {
          Assert.assertEquals(TargetPlatformValidator.CHECK__INCLUDE_CYCLE, it.getIssueCode());
          EObject _sourceEObject = it.getSourceEObject();
          Assert.assertEquals("a.tpd", ((IncludeDeclaration) _sourceEObject).getImportURI());
        }
      };
      diagnotics.forEach(_function_5);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
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
      _builder.append("include ${subDirName} \"/\" \"subInclude.tpd\"");
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
      Assert.assertTrue(targetPlatform.eResource().getErrors().isEmpty());
      tester.validator().checkIUIDAndRangeInRepository(IterableExtensions.<IU>head(IterableExtensions.<Location>head(targetPlatform.getLocations()).getIus()));
      final List<AbstractValidationDiagnostic> diagnotics = IterableExtensions.<AbstractValidationDiagnostic>toList(Iterables.<AbstractValidationDiagnostic>filter(tester.diagnose().getAllDiagnostics(), AbstractValidationDiagnostic.class));
      Assert.assertEquals(0, diagnotics.size());
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
      Assert.assertTrue(targetPlatform.eResource().getErrors().isEmpty());
      tester.validator().checkIUIDAndRangeInRepository(IterableExtensions.<IU>head(IterableExtensions.<Location>head(targetPlatform.getLocations()).getIus()));
      final List<AbstractValidationDiagnostic> diagnotics = IterableExtensions.<AbstractValidationDiagnostic>toList(Iterables.<AbstractValidationDiagnostic>filter(tester.diagnose().getAllDiagnostics(), AbstractValidationDiagnostic.class));
      Assert.assertEquals(1, diagnotics.size());
      final Function1<AbstractValidationDiagnostic, Boolean> _function = new Function1<AbstractValidationDiagnostic, Boolean>() {
        @Override
        public Boolean apply(final AbstractValidationDiagnostic it) {
          EObject _sourceEObject = it.getSourceEObject();
          return Boolean.valueOf((_sourceEObject instanceof IU));
        }
      };
      Assert.assertTrue(IterableExtensions.<AbstractValidationDiagnostic>forall(diagnotics, _function));
      final Consumer<AbstractValidationDiagnostic> _function_1 = new Consumer<AbstractValidationDiagnostic>() {
        @Override
        public void accept(final AbstractValidationDiagnostic it) {
          Assert.assertEquals(TargetPlatformValidator.CHECK__IU_IN_LOCATION, it.getIssueCode());
          EObject _sourceEObject = it.getSourceEObject();
          Assert.assertEquals("org.iu2", ((IU) _sourceEObject).getID());
        }
      };
      diagnotics.forEach(_function_1);
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
      Assert.assertTrue(targetPlatform.eResource().getErrors().isEmpty());
      final Consumer<IU> _function = new Consumer<IU>() {
        @Override
        public void accept(final IU it) {
          tester.validator().checkIUIDAndRangeInRepository(it);
        }
      };
      IterableExtensions.<Location>head(targetPlatform.getLocations()).getIus().forEach(_function);
      final List<AbstractValidationDiagnostic> diagnotics = IterableExtensions.<AbstractValidationDiagnostic>toList(Iterables.<AbstractValidationDiagnostic>filter(tester.diagnose().getAllDiagnostics(), AbstractValidationDiagnostic.class));
      Assert.assertEquals(3, diagnotics.size());
      final Function1<AbstractValidationDiagnostic, Boolean> _function_1 = new Function1<AbstractValidationDiagnostic, Boolean>() {
        @Override
        public Boolean apply(final AbstractValidationDiagnostic it) {
          EObject _sourceEObject = it.getSourceEObject();
          return Boolean.valueOf((_sourceEObject instanceof IU));
        }
      };
      Assert.assertTrue(IterableExtensions.<AbstractValidationDiagnostic>forall(diagnotics, _function_1));
      final Consumer<AbstractValidationDiagnostic> _function_2 = new Consumer<AbstractValidationDiagnostic>() {
        @Override
        public void accept(final AbstractValidationDiagnostic it) {
          Assert.assertEquals(TargetPlatformValidator.CHECK__IU_IN_LOCATION, it.getIssueCode());
        }
      };
      diagnotics.forEach(_function_2);
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
      Assert.assertTrue(targetPlatform.eResource().getErrors().isEmpty());
      final Consumer<IU> _function = new Consumer<IU>() {
        @Override
        public void accept(final IU it) {
          tester.validator().checkIUIDAndRangeInRepository(it);
        }
      };
      IterableExtensions.<Location>head(targetPlatform.getLocations()).getIus().forEach(_function);
      final List<AbstractValidationDiagnostic> diagnotics = IterableExtensions.<AbstractValidationDiagnostic>toList(Iterables.<AbstractValidationDiagnostic>filter(tester.diagnose().getAllDiagnostics(), AbstractValidationDiagnostic.class));
      Assert.assertEquals(0, diagnotics.size());
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
      Assert.assertTrue(targetPlatform.eResource().getErrors().isEmpty());
      final Consumer<IU> _function = new Consumer<IU>() {
        @Override
        public void accept(final IU it) {
          tester.validator().checkIUIDAndRangeInRepository(it);
        }
      };
      IterableExtensions.<Location>head(targetPlatform.getLocations()).getIus().forEach(_function);
      final List<AbstractValidationDiagnostic> diagnotics = IterableExtensions.<AbstractValidationDiagnostic>toList(Iterables.<AbstractValidationDiagnostic>filter(tester.diagnose().getAllDiagnostics(), AbstractValidationDiagnostic.class));
      Assert.assertEquals(1, diagnotics.size());
      final Function1<AbstractValidationDiagnostic, Boolean> _function_1 = new Function1<AbstractValidationDiagnostic, Boolean>() {
        @Override
        public Boolean apply(final AbstractValidationDiagnostic it) {
          EObject _sourceEObject = it.getSourceEObject();
          return Boolean.valueOf((_sourceEObject instanceof IU));
        }
      };
      Assert.assertTrue(IterableExtensions.<AbstractValidationDiagnostic>forall(diagnotics, _function_1));
      final Consumer<AbstractValidationDiagnostic> _function_2 = new Consumer<AbstractValidationDiagnostic>() {
        @Override
        public void accept(final AbstractValidationDiagnostic it) {
          Assert.assertEquals(TargetPlatformValidator.CHECK__IU_IN_LOCATION, it.getIssueCode());
          EObject _sourceEObject = it.getSourceEObject();
          Assert.assertEquals("org.iu1", ((IU) _sourceEObject).getID());
        }
      };
      diagnotics.forEach(_function_2);
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
      Assert.assertTrue(targetPlatform.eResource().getErrors().isEmpty());
      final Consumer<Location> _function = new Consumer<Location>() {
        @Override
        public void accept(final Location it) {
          tester.validator().checkLocationURI(it);
        }
      };
      targetPlatform.getLocations().forEach(_function);
      final List<AbstractValidationDiagnostic> diagnotics = IterableExtensions.<AbstractValidationDiagnostic>toList(Iterables.<AbstractValidationDiagnostic>filter(tester.diagnose().getAllDiagnostics(), AbstractValidationDiagnostic.class));
      Assert.assertEquals(0, diagnotics.size());
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
      Assert.assertTrue(targetPlatform.eResource().getErrors().isEmpty());
      final Consumer<Location> _function = new Consumer<Location>() {
        @Override
        public void accept(final Location it) {
          tester.validator().checkLocationURI(it);
        }
      };
      targetPlatform.getLocations().forEach(_function);
      final List<AbstractValidationDiagnostic> diagnotics = IterableExtensions.<AbstractValidationDiagnostic>toList(Iterables.<AbstractValidationDiagnostic>filter(tester.diagnose().getAllDiagnostics(), AbstractValidationDiagnostic.class));
      Assert.assertEquals(0, diagnotics.size());
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
      Assert.assertTrue(targetPlatform.eResource().getErrors().isEmpty());
      final Consumer<Location> _function = new Consumer<Location>() {
        @Override
        public void accept(final Location it) {
          tester.validator().checkLocationURI(it);
        }
      };
      targetPlatform.getLocations().forEach(_function);
      final List<AbstractValidationDiagnostic> diagnotics = IterableExtensions.<AbstractValidationDiagnostic>toList(Iterables.<AbstractValidationDiagnostic>filter(tester.diagnose().getAllDiagnostics(), AbstractValidationDiagnostic.class));
      Assert.assertEquals(1, diagnotics.size());
      final Consumer<AbstractValidationDiagnostic> _function_1 = new Consumer<AbstractValidationDiagnostic>() {
        @Override
        public void accept(final AbstractValidationDiagnostic it) {
          Assert.assertEquals(TargetPlatformValidator.CHECK__LOCATION_URI, it.getIssueCode());
          EObject _sourceEObject = it.getSourceEObject();
          Assert.assertEquals("badLocation", ((Location) _sourceEObject).getUri());
        }
      };
      diagnotics.forEach(_function_1);
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
      Assert.assertTrue(targetPlatform.eResource().getErrors().isEmpty());
      tester.validator().checkEnvironment(targetPlatform.getEnvironment());
      final List<AbstractValidationDiagnostic> diagnotics = IterableExtensions.<AbstractValidationDiagnostic>toList(Iterables.<AbstractValidationDiagnostic>filter(tester.diagnose().getAllDiagnostics(), AbstractValidationDiagnostic.class));
      Assert.assertEquals(0, diagnotics.size());
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
      Assert.assertTrue(targetPlatform.eResource().getErrors().isEmpty());
      tester.validator().checkEnvironment(targetPlatform.getEnvironment());
      final List<AbstractValidationDiagnostic> diagnotics = IterableExtensions.<AbstractValidationDiagnostic>toList(Iterables.<AbstractValidationDiagnostic>filter(tester.diagnose().getAllDiagnostics(), AbstractValidationDiagnostic.class));
      Assert.assertEquals(1, diagnotics.size());
      final Consumer<AbstractValidationDiagnostic> _function = new Consumer<AbstractValidationDiagnostic>() {
        @Override
        public void accept(final AbstractValidationDiagnostic it) {
          Assert.assertEquals(TargetPlatformValidator.CHECK__ENVIRONMENT_VALIDITY, it.getIssueCode());
        }
      };
      diagnotics.forEach(_function);
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
      Assert.assertTrue(targetPlatform.eResource().getErrors().isEmpty());
      tester.validator().checkEnvironment(targetPlatform.getEnvironment());
      final List<AbstractValidationDiagnostic> diagnotics = IterableExtensions.<AbstractValidationDiagnostic>toList(Iterables.<AbstractValidationDiagnostic>filter(tester.diagnose().getAllDiagnostics(), AbstractValidationDiagnostic.class));
      Assert.assertEquals(0, diagnotics.size());
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
      Assert.assertTrue(targetPlatform.eResource().getErrors().isEmpty());
      tester.validator().checkEnvironment(targetPlatform.getEnvironment());
      final List<AbstractValidationDiagnostic> diagnotics = IterableExtensions.<AbstractValidationDiagnostic>toList(Iterables.<AbstractValidationDiagnostic>filter(tester.diagnose().getAllDiagnostics(), AbstractValidationDiagnostic.class));
      Assert.assertEquals(0, diagnotics.size());
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
      Assert.assertTrue(targetPlatform.eResource().getErrors().isEmpty());
      tester.validator().checkOneEnvironment(targetPlatform);
      final List<FeatureBasedDiagnostic> diagnotics = IterableExtensions.<FeatureBasedDiagnostic>toList(Iterables.<FeatureBasedDiagnostic>filter(tester.diagnose().getAllDiagnostics(), FeatureBasedDiagnostic.class));
      Assert.assertEquals(0, diagnotics.size());
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
      Assert.assertTrue(targetPlatform.eResource().getErrors().isEmpty());
      tester.validator().checkOneEnvironment(targetPlatform);
      final List<FeatureBasedDiagnostic> diagnotics = IterableExtensions.<FeatureBasedDiagnostic>toList(Iterables.<FeatureBasedDiagnostic>filter(tester.diagnose().getAllDiagnostics(), FeatureBasedDiagnostic.class));
      Assert.assertEquals(1, diagnotics.size());
      final Consumer<FeatureBasedDiagnostic> _function = new Consumer<FeatureBasedDiagnostic>() {
        @Override
        public void accept(final FeatureBasedDiagnostic it) {
          Assert.assertEquals(TargetPlatformValidator.CHECK__ENVIRONMENT_UNICITY, it.getIssueCode());
          Assert.assertEquals(Diagnostic.WARNING, it.getSeverity());
          Object _eGet = it.getSourceEObject().eGet(it.getFeature());
          Assert.assertEquals(targetPlatform.getContents().get(1), ((List<?>) _eGet).get(it.getIndex()));
        }
      };
      diagnotics.forEach(_function);
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
      Assert.assertTrue(targetPlatform.eResource().getErrors().isEmpty());
      tester.validator().checkOneEnvironment(targetPlatform);
      final List<FeatureBasedDiagnostic> diagnostics = IterableExtensions.<FeatureBasedDiagnostic>toList(Iterables.<FeatureBasedDiagnostic>filter(tester.diagnose().getAllDiagnostics(), FeatureBasedDiagnostic.class));
      Assert.assertEquals(2, diagnostics.size());
      FeatureBasedDiagnostic it = IterableExtensions.<FeatureBasedDiagnostic>head(diagnostics);
      Assert.assertEquals(TargetPlatformValidator.CHECK__ENVIRONMENT_UNICITY, it.getIssueCode());
      Assert.assertEquals(Diagnostic.WARNING, it.getSeverity());
      Object _eGet = it.getSourceEObject().eGet(it.getFeature());
      Assert.assertEquals(targetPlatform.getContents().get(1), ((List<?>) _eGet).get(it.getIndex()));
      it = diagnostics.get(1);
      Assert.assertEquals(TargetPlatformValidator.CHECK__ENVIRONMENT_UNICITY, it.getIssueCode());
      Assert.assertEquals(Diagnostic.WARNING, it.getSeverity());
      Object _eGet_1 = it.getSourceEObject().eGet(it.getFeature());
      Assert.assertEquals(targetPlatform.getContents().get(3), ((List<?>) _eGet_1).get(it.getIndex()));
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
      Assert.assertTrue(targetPlatform.eResource().getErrors().isEmpty());
      tester.validator().checkOneOptions(targetPlatform);
      final List<FeatureBasedDiagnostic> diagnotics = IterableExtensions.<FeatureBasedDiagnostic>toList(Iterables.<FeatureBasedDiagnostic>filter(tester.diagnose().getAllDiagnostics(), FeatureBasedDiagnostic.class));
      Assert.assertEquals(0, diagnotics.size());
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
      Assert.assertTrue(targetPlatform.eResource().getErrors().isEmpty());
      tester.validator().checkOneOptions(targetPlatform);
      final List<FeatureBasedDiagnostic> diagnotics = IterableExtensions.<FeatureBasedDiagnostic>toList(Iterables.<FeatureBasedDiagnostic>filter(tester.diagnose().getAllDiagnostics(), FeatureBasedDiagnostic.class));
      Assert.assertEquals(1, diagnotics.size());
      final Consumer<FeatureBasedDiagnostic> _function = new Consumer<FeatureBasedDiagnostic>() {
        @Override
        public void accept(final FeatureBasedDiagnostic it) {
          Assert.assertEquals(TargetPlatformValidator.CHECK__OPTIONS_UNICITY, it.getIssueCode());
          Assert.assertEquals(Diagnostic.WARNING, it.getSeverity());
          Object _eGet = it.getSourceEObject().eGet(it.getFeature());
          Assert.assertEquals(targetPlatform.getContents().get(1), ((List<?>) _eGet).get(it.getIndex()));
        }
      };
      diagnotics.forEach(_function);
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
      Assert.assertTrue(targetPlatform.eResource().getErrors().isEmpty());
      tester.validator().checkOneOptions(targetPlatform);
      final List<FeatureBasedDiagnostic> diagnostics = IterableExtensions.<FeatureBasedDiagnostic>toList(Iterables.<FeatureBasedDiagnostic>filter(tester.diagnose().getAllDiagnostics(), FeatureBasedDiagnostic.class));
      Assert.assertEquals(2, diagnostics.size());
      FeatureBasedDiagnostic it = IterableExtensions.<FeatureBasedDiagnostic>head(diagnostics);
      Assert.assertEquals(TargetPlatformValidator.CHECK__OPTIONS_UNICITY, it.getIssueCode());
      Assert.assertEquals(Diagnostic.WARNING, it.getSeverity());
      Object _eGet = it.getSourceEObject().eGet(it.getFeature());
      Assert.assertEquals(targetPlatform.getContents().get(1), ((List<?>) _eGet).get(it.getIndex()));
      it = diagnostics.get(1);
      Assert.assertEquals(TargetPlatformValidator.CHECK__OPTIONS_UNICITY, it.getIssueCode());
      Assert.assertEquals(Diagnostic.WARNING, it.getSeverity());
      Object _eGet_1 = it.getSourceEObject().eGet(it.getFeature());
      Assert.assertEquals(targetPlatform.getContents().get(3), ((List<?>) _eGet_1).get(it.getIndex()));
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
      Assert.assertTrue(targetPlatform.eResource().getErrors().isEmpty());
      tester.validator().checkNoDuplicateEnvironmentOptions(targetPlatform);
      final List<FeatureBasedDiagnostic> diagnostics = IterableExtensions.<FeatureBasedDiagnostic>toList(Iterables.<FeatureBasedDiagnostic>filter(tester.diagnose().getAllDiagnostics(), FeatureBasedDiagnostic.class));
      Assert.assertEquals(IterableExtensions.join(diagnostics, ", "), 2, diagnostics.size());
      FeatureBasedDiagnostic it = IterableExtensions.<FeatureBasedDiagnostic>head(diagnostics);
      Assert.assertEquals(TargetPlatformValidator.CHECK__NO_DUPLICATE_ENVIRONMENT_OPTIONS, it.getIssueCode());
      Assert.assertEquals(Diagnostic.ERROR, it.getSeverity());
      Object _eGet = it.getSourceEObject().eGet(it.getFeature());
      Assert.assertEquals(targetPlatform.getEnvironment().getEnv().get(1), ((List<?>) _eGet).get(it.getIndex()));
      FeatureBasedDiagnostic it_1 = diagnostics.get(1);
      Assert.assertEquals(TargetPlatformValidator.CHECK__NO_DUPLICATE_ENVIRONMENT_OPTIONS, it_1.getIssueCode());
      Assert.assertEquals(Diagnostic.ERROR, it_1.getSeverity());
      Object _eGet_1 = it_1.getSourceEObject().eGet(it_1.getFeature());
      Assert.assertEquals(targetPlatform.getEnvironment().getEnv().get(2), ((List<?>) _eGet_1).get(it_1.getIndex()));
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
      Assert.assertTrue(targetPlatform.eResource().getErrors().isEmpty());
      tester.validator().checkNoDuplicateEnvironmentOptions(targetPlatform);
      final List<FeatureBasedDiagnostic> diagnostics = IterableExtensions.<FeatureBasedDiagnostic>toList(Iterables.<FeatureBasedDiagnostic>filter(tester.diagnose().getAllDiagnostics(), FeatureBasedDiagnostic.class));
      Assert.assertEquals(2, diagnostics.size());
      FeatureBasedDiagnostic it = IterableExtensions.<FeatureBasedDiagnostic>head(diagnostics);
      Assert.assertEquals(TargetPlatformValidator.CHECK__NO_DUPLICATE_ENVIRONMENT_OPTIONS, it.getIssueCode());
      Assert.assertEquals(Diagnostic.ERROR, it.getSeverity());
      TargetContent _get = targetPlatform.getContents().get(0);
      Object _eGet = it.getSourceEObject().eGet(it.getFeature());
      Assert.assertEquals(((Environment) _get).getEnv().get(1), ((List<?>) _eGet).get(it.getIndex()));
      FeatureBasedDiagnostic it_1 = diagnostics.get(1);
      Assert.assertEquals(TargetPlatformValidator.CHECK__NO_DUPLICATE_ENVIRONMENT_OPTIONS, it_1.getIssueCode());
      Assert.assertEquals(Diagnostic.ERROR, it_1.getSeverity());
      TargetContent _get_1 = targetPlatform.getContents().get(1);
      Object _eGet_1 = it_1.getSourceEObject().eGet(it_1.getFeature());
      Assert.assertEquals(IterableExtensions.<String>head(((Environment) _get_1).getEnv()), ((List<?>) _eGet_1).get(it_1.getIndex()));
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
      Assert.assertTrue(targetPlatform.eResource().getErrors().isEmpty());
      tester.validator().checkNoDuplicateEnvironmentOptions(targetPlatform);
      final List<FeatureBasedDiagnostic> diagnostics = IterableExtensions.<FeatureBasedDiagnostic>toList(Iterables.<FeatureBasedDiagnostic>filter(tester.diagnose().getAllDiagnostics(), FeatureBasedDiagnostic.class));
      Assert.assertEquals(0, diagnostics.size());
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
      Assert.assertTrue(targetPlatform.eResource().getErrors().isEmpty());
      tester.validator().checkNoDuplicateEnvironmentOptions(targetPlatform);
      final List<FeatureBasedDiagnostic> diagnostics = IterableExtensions.<FeatureBasedDiagnostic>toList(Iterables.<FeatureBasedDiagnostic>filter(tester.diagnose().getAllDiagnostics(), FeatureBasedDiagnostic.class));
      Assert.assertEquals(0, diagnostics.size());
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
      Assert.assertTrue(targetPlatform.eResource().getErrors().isEmpty());
      tester.validator().checkNoDuplicateEnvironmentOptions(targetPlatform);
      final List<FeatureBasedDiagnostic> diagnostics = IterableExtensions.<FeatureBasedDiagnostic>toList(Iterables.<FeatureBasedDiagnostic>filter(tester.diagnose().getAllDiagnostics(), FeatureBasedDiagnostic.class));
      Assert.assertEquals(0, diagnostics.size());
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
      Assert.assertTrue(targetPlatform.eResource().getErrors().isEmpty());
      tester.validator().checkNoDuplicateEnvironmentOptions(targetPlatform);
      final List<FeatureBasedDiagnostic> diagnostics = IterableExtensions.<FeatureBasedDiagnostic>toList(Iterables.<FeatureBasedDiagnostic>filter(tester.diagnose().getAllDiagnostics(), FeatureBasedDiagnostic.class));
      Assert.assertEquals(IterableExtensions.join(diagnostics, ", "), 0, diagnostics.size());
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
      Assert.assertTrue(targetPlatform.eResource().getErrors().isEmpty());
      tester.validator().checkNoDuplicateEnvironmentOptions(targetPlatform);
      final List<FeatureBasedDiagnostic> diagnostics = IterableExtensions.<FeatureBasedDiagnostic>toList(Iterables.<FeatureBasedDiagnostic>filter(tester.diagnose().getAllDiagnostics(), FeatureBasedDiagnostic.class));
      Assert.assertEquals(IterableExtensions.join(diagnostics, ", "), 2, diagnostics.size());
      Object _eGet = diagnostics.get(0).getSourceEObject().eGet(diagnostics.get(0).getFeature());
      Assert.assertEquals("cocoa", ((List<?>) _eGet).get(diagnostics.get(0).getIndex()));
      Object _eGet_1 = diagnostics.get(1).getSourceEObject().eGet(diagnostics.get(1).getFeature());
      Assert.assertEquals("cocoa", ((List<?>) _eGet_1).get(diagnostics.get(1).getIndex()));
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
      Assert.assertTrue(targetPlatform.eResource().getErrors().isEmpty());
      tester.validator().checkNoEscapeCharacterInIUID(IterableExtensions.<Location>head(targetPlatform.getLocations()).getIus().get(0));
      List<FeatureBasedDiagnostic> diagnostics = IterableExtensions.<FeatureBasedDiagnostic>toList(Iterables.<FeatureBasedDiagnostic>filter(tester.diagnose().getAllDiagnostics(), FeatureBasedDiagnostic.class));
      Assert.assertEquals(IterableExtensions.join(diagnostics, ", "), 0, diagnostics.size());
      tester.validator().checkNoEscapeCharacterInIUID(IterableExtensions.<Location>head(targetPlatform.getLocations()).getIus().get(1));
      diagnostics = IterableExtensions.<FeatureBasedDiagnostic>toList(Iterables.<FeatureBasedDiagnostic>filter(tester.diagnose().getAllDiagnostics(), FeatureBasedDiagnostic.class));
      Assert.assertEquals(IterableExtensions.join(diagnostics, ", "), 0, diagnostics.size());
      tester.validator().checkNoEscapeCharacterInIUID(IterableExtensions.<Location>head(targetPlatform.getLocations()).getIus().get(2));
      diagnostics = IterableExtensions.<FeatureBasedDiagnostic>toList(Iterables.<FeatureBasedDiagnostic>filter(tester.diagnose().getAllDiagnostics(), FeatureBasedDiagnostic.class));
      Assert.assertEquals(IterableExtensions.join(diagnostics, ", "), 1, diagnostics.size());
      Assert.assertEquals(TargetPlatformValidator.CHECK__ESCAPE_CHAR_IU_ID, IterableExtensions.<FeatureBasedDiagnostic>head(diagnostics).getIssueCode());
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
      Assert.assertTrue(targetPlatform.eResource().getErrors().isEmpty());
      tester.validator().checkVersionKeywords(IterableExtensions.<Location>head(targetPlatform.getLocations()).getIus().get(0));
      List<RangeBasedDiagnostic> diagnostics = IterableExtensions.<RangeBasedDiagnostic>toList(Iterables.<RangeBasedDiagnostic>filter(tester.diagnose().getAllDiagnostics(), RangeBasedDiagnostic.class));
      Assert.assertEquals(IterableExtensions.join(diagnostics, ", "), 0, diagnostics.size());
      tester.validator().checkVersionKeywords(IterableExtensions.<Location>head(targetPlatform.getLocations()).getIus().get(1));
      diagnostics = IterableExtensions.<RangeBasedDiagnostic>toList(Iterables.<RangeBasedDiagnostic>filter(tester.diagnose().getAllDiagnostics(), RangeBasedDiagnostic.class));
      Assert.assertEquals(IterableExtensions.join(diagnostics, ", "), 0, diagnostics.size());
      tester.validator().checkVersionKeywords(IterableExtensions.<Location>head(targetPlatform.getLocations()).getIus().get(2));
      diagnostics = IterableExtensions.<RangeBasedDiagnostic>toList(Iterables.<RangeBasedDiagnostic>filter(tester.diagnose().getAllDiagnostics(), RangeBasedDiagnostic.class));
      Assert.assertEquals(IterableExtensions.join(diagnostics, ", "), 1, diagnostics.size());
      Assert.assertEquals(TargetPlatformValidator.CHECK__VERSION_KEYWORDS, IterableExtensions.<RangeBasedDiagnostic>head(diagnostics).getIssueCode());
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
      Assert.assertTrue(targetPlatform.eResource().getErrors().isEmpty());
      tester.validator().checkNoDuplicatedIU(targetPlatform);
      List<FeatureBasedDiagnostic> diagnostics = IterableExtensions.<FeatureBasedDiagnostic>toList(Iterables.<FeatureBasedDiagnostic>filter(tester.diagnose().getAllDiagnostics(), FeatureBasedDiagnostic.class));
      Assert.assertEquals(IterableExtensions.join(diagnostics, ", "), 2, diagnostics.size());
      Assert.assertEquals(TargetPlatformValidator.CHECK__NO_DUPLICATED_IU, IterableExtensions.<FeatureBasedDiagnostic>head(diagnostics).getIssueCode());
      Object _eGet = diagnostics.get(0).getSourceEObject().eGet(diagnostics.get(0).getFeature());
      Assert.assertEquals(IterableExtensions.<IU>head(IterableExtensions.<Location>head(targetPlatform.getLocations()).getIus()), ((List<?>) _eGet).get(0));
      Assert.assertEquals(Diagnostic.WARNING, diagnostics.get(0).getSeverity());
      Object _eGet_1 = diagnostics.get(1).getSourceEObject().eGet(diagnostics.get(1).getFeature());
      Assert.assertEquals(IterableExtensions.<IU>head(targetPlatform.getLocations().get(1).getIus()), ((List<?>) _eGet_1).get(0));
      Assert.assertEquals(Diagnostic.WARNING, diagnostics.get(1).getSeverity());
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
      Assert.assertTrue(targetPlatform.eResource().getErrors().isEmpty());
      tester.validator().checkNoDuplicatedIU(targetPlatform);
      List<FeatureBasedDiagnostic> diagnostics = IterableExtensions.<FeatureBasedDiagnostic>toList(Iterables.<FeatureBasedDiagnostic>filter(tester.diagnose().getAllDiagnostics(), FeatureBasedDiagnostic.class));
      Assert.assertEquals(IterableExtensions.join(diagnostics, ", "), 2, diagnostics.size());
      Assert.assertEquals(TargetPlatformValidator.CHECK__NO_DUPLICATED_IU, IterableExtensions.<FeatureBasedDiagnostic>head(diagnostics).getIssueCode());
      Object _eGet = diagnostics.get(0).getSourceEObject().eGet(diagnostics.get(0).getFeature());
      Assert.assertEquals(IterableExtensions.<IU>head(IterableExtensions.<Location>head(targetPlatform.getLocations()).getIus()), ((List<?>) _eGet).get(0));
      Assert.assertEquals(Diagnostic.WARNING, diagnostics.get(0).getSeverity());
      Object _eGet_1 = diagnostics.get(1).getSourceEObject().eGet(diagnostics.get(1).getFeature());
      Assert.assertEquals(IterableExtensions.<IU>head(IterableExtensions.<Location>head(targetPlatform.getLocations()).getIus()), ((List<?>) _eGet_1).get(0));
      Assert.assertEquals(Diagnostic.WARNING, diagnostics.get(1).getSeverity());
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
      Assert.assertTrue(targetPlatform.eResource().getErrors().isEmpty());
      tester.validator().checkNoDuplicatedIU(targetPlatform);
      List<FeatureBasedDiagnostic> diagnostics = IterableExtensions.<FeatureBasedDiagnostic>toList(Iterables.<FeatureBasedDiagnostic>filter(tester.diagnose().getAllDiagnostics(), FeatureBasedDiagnostic.class));
      Assert.assertEquals(IterableExtensions.join(diagnostics, ", "), 2, diagnostics.size());
      Assert.assertEquals(TargetPlatformValidator.CHECK__NO_DUPLICATED_IU, IterableExtensions.<FeatureBasedDiagnostic>head(diagnostics).getIssueCode());
      Object _eGet = diagnostics.get(0).getSourceEObject().eGet(diagnostics.get(0).getFeature());
      Assert.assertEquals(IterableExtensions.<IU>head(IterableExtensions.<Location>head(targetPlatform.getLocations()).getIus()), ((List<?>) _eGet).get(0));
      Assert.assertEquals(Diagnostic.WARNING, diagnostics.get(0).getSeverity());
      Object _eGet_1 = diagnostics.get(1).getSourceEObject().eGet(diagnostics.get(1).getFeature());
      Assert.assertEquals(IterableExtensions.<IU>head(targetPlatform.getLocations().get(1).getIus()), ((List<?>) _eGet_1).get(0));
      Assert.assertEquals(Diagnostic.WARNING, diagnostics.get(1).getSeverity());
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
      final TargetPlatform tpa = this.parser.parse(_builder, URI.createURI("tmp:/a.tpd"), resourceSet);
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
      this.parser.parse(_builder_1, URI.createURI("tmp:/b.tpd"), resourceSet);
      Assert.assertTrue(tpa.eResource().getErrors().isEmpty());
      tester.validator().checkNoDuplicatedIU(tpa);
      final List<FeatureBasedDiagnostic> diagnostics = IterableExtensions.<FeatureBasedDiagnostic>toList(Iterables.<FeatureBasedDiagnostic>filter(tester.diagnose().getAllDiagnostics(), FeatureBasedDiagnostic.class));
      Assert.assertEquals(1, diagnostics.size());
      Assert.assertEquals(TargetPlatformValidator.CHECK__NO_DUPLICATED_IU, IterableExtensions.<FeatureBasedDiagnostic>head(diagnostics).getIssueCode());
      Object _eGet = diagnostics.get(0).getSourceEObject().eGet(diagnostics.get(0).getFeature());
      Assert.assertEquals(IterableExtensions.<IU>head(IterableExtensions.<Location>head(tpa.getLocations()).getIus()), ((List<?>) _eGet).get(0));
      Assert.assertEquals(Diagnostic.WARNING, diagnostics.get(0).getSeverity());
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
      final TargetPlatform tpa = this.parser.parse(_builder, URI.createURI("tmp:/a.tpd"), resourceSet);
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
      this.parser.parse(_builder_1, URI.createURI("tmp:/b.tpd"), resourceSet);
      Assert.assertTrue(tpa.eResource().getErrors().isEmpty());
      tester.validator().checkNoDuplicatedIU(tpa);
      final List<FeatureBasedDiagnostic> diagnostics = IterableExtensions.<FeatureBasedDiagnostic>toList(Iterables.<FeatureBasedDiagnostic>filter(tester.diagnose().getAllDiagnostics(), FeatureBasedDiagnostic.class));
      Assert.assertEquals(1, diagnostics.size());
      Assert.assertEquals(TargetPlatformValidator.CHECK__NO_DUPLICATED_IU, IterableExtensions.<FeatureBasedDiagnostic>head(diagnostics).getIssueCode());
      Object _eGet = diagnostics.get(0).getSourceEObject().eGet(diagnostics.get(0).getFeature());
      Assert.assertEquals(IterableExtensions.<IU>head(IterableExtensions.<Location>head(tpa.getLocations()).getIus()), ((List<?>) _eGet).get(0));
      Assert.assertEquals(Diagnostic.WARNING, diagnostics.get(0).getSeverity());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
