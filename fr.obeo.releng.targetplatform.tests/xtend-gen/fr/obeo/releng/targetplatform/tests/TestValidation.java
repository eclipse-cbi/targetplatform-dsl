package fr.obeo.releng.targetplatform.tests;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import fr.obeo.releng.targetplatform.TargetPlatformInjectorProvider;
import fr.obeo.releng.targetplatform.targetplatform.Location;
import fr.obeo.releng.targetplatform.targetplatform.TargetPlatform;
import fr.obeo.releng.targetplatform.validation.TargetPlatformValidator;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.Constants;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.junit4.util.ParseHelper;
import org.eclipse.xtext.junit4.validation.AssertableDiagnostics;
import org.eclipse.xtext.junit4.validation.ValidatorTester;
import org.eclipse.xtext.validation.AbstractValidationDiagnostic;
import org.eclipse.xtext.validation.EValidatorRegistrar;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@InjectWith(TargetPlatformInjectorProvider.class)
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
  @Named(Constants.LANGUAGE_NAME)
  private String languageName;
  
  @Test
  public void testLocationOptionCheck() {
    try {
      final ValidatorTester<TargetPlatformValidator> tester = new ValidatorTester<TargetPlatformValidator>(this.validator, this.validatorRegistrar, this.languageName);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"a target platform\"");
      _builder.newLine();
      _builder.newLine();
      _builder.append("location \"my location URL\" {");
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
      String _join = IterableExtensions.join(_errors, "\n");
      Resource _eResource_1 = targetPlatform.eResource();
      EList<Resource.Diagnostic> _errors_1 = _eResource_1.getErrors();
      boolean _isEmpty = _errors_1.isEmpty();
      Assert.assertTrue(_join, _isEmpty);
      EList<Location> _locations = targetPlatform.getLocations();
      final Location fisrtLocation = IterableExtensions.<Location>head(_locations);
      TargetPlatformValidator _validator = tester.validator();
      _validator.checkAllEnvAndRequiredAreSelfExluding(fisrtLocation);
      AssertableDiagnostics _diagnose = tester.diagnose();
      Iterable<Diagnostic> _allDiagnostics = _diagnose.getAllDiagnostics();
      Iterable<AbstractValidationDiagnostic> _filter = Iterables.<AbstractValidationDiagnostic>filter(_allDiagnostics, AbstractValidationDiagnostic.class);
      for (final AbstractValidationDiagnostic diag : _filter) {
        String _issueCode = diag.getIssueCode();
        Assert.assertEquals(TargetPlatformValidator.CHECK__OPTIONS_SELF_EXCLUDING_ALL_ENV_REQUIRED, _issueCode);
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
