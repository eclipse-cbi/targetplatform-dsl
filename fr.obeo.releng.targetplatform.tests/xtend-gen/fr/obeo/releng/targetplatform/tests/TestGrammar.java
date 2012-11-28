package fr.obeo.releng.targetplatform.tests;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import fr.obeo.releng.TargetPlatformInjectorProvider;
import fr.obeo.releng.targetplatform.IU;
import fr.obeo.releng.targetplatform.Location;
import fr.obeo.releng.targetplatform.Option;
import fr.obeo.releng.targetplatform.TargetPlatform;
import fr.obeo.releng.validation.TargetPlatformJavaValidator;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.EList;
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

@InjectWith(value = TargetPlatformInjectorProvider.class)
@RunWith(value = XtextRunner.class)
@SuppressWarnings("all")
public class TestGrammar {
  @Inject
  private ParseHelper<TargetPlatform> parser;
  
  @Inject
  private TargetPlatformJavaValidator validator;
  
  @Inject
  private EValidatorRegistrar validatorRegistrar;
  
  @Inject
  @Named(value = Constants.LANGUAGE_NAME)
  private String languageName;
  
  @Test
  public void testStandardFile() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"Latest target for EMF Compare based on Kepler interim\"");
      _builder.newLine();
      _builder.newLine();
      _builder.append("location \"https://hudson.eclipse.org/hudson/view/Modeling/job/emf-core-head/lastSuccessfulBuild/artifact/EMF.p2.repository/\" {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("org.eclipse.emf.sdk.feature.group;version=\"[2.9.0,3.0.0)\"");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("com.google.common.cache;version=\"10.0.1\"");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("location \"https://hudson.eclipse.org/hudson/view/Modeling/job/mdt-uml2-master/lastSuccessfulBuild/artifact/UML2.p2.repository/\" {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("org.eclipse.uml2.sdk.feature.group");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final TargetPlatform targetPlatform = this.parser.parse(_builder);
      EList<Location> _locations = targetPlatform.getLocations();
      final Location fisrtLocation = IterableExtensions.<Location>head(_locations);
      String _uri = fisrtLocation.getUri();
      Assert.assertEquals("https://hudson.eclipse.org/hudson/view/Modeling/job/emf-core-head/lastSuccessfulBuild/artifact/EMF.p2.repository/", _uri);
      EList<IU> _ius = fisrtLocation.getIus();
      int _size = _ius.size();
      Assert.assertEquals(2, _size);
      EList<IU> _ius_1 = fisrtLocation.getIus();
      final IU iu0 = IterableExtensions.<IU>head(_ius_1);
      String _iD = iu0.getID();
      Assert.assertEquals("org.eclipse.emf.sdk.feature.group", _iD);
      String _version = iu0.getVersion();
      Assert.assertEquals("[2.9.0,3.0.0)", _version);
      EList<IU> _ius_2 = fisrtLocation.getIus();
      final IU iu1 = IterableExtensions.<IU>last(_ius_2);
      String _iD_1 = iu1.getID();
      Assert.assertEquals("com.google.common.cache", _iD_1);
      String _version_1 = iu1.getVersion();
      Assert.assertEquals("10.0.1", _version_1);
      EList<Location> _locations_1 = targetPlatform.getLocations();
      final Location lastLocation = IterableExtensions.<Location>last(_locations_1);
      String _uri_1 = lastLocation.getUri();
      Assert.assertEquals("https://hudson.eclipse.org/hudson/view/Modeling/job/mdt-uml2-master/lastSuccessfulBuild/artifact/UML2.p2.repository/", _uri_1);
      EList<IU> _ius_3 = lastLocation.getIus();
      int _size_1 = _ius_3.size();
      Assert.assertEquals(1, _size_1);
      EList<IU> _ius_4 = lastLocation.getIus();
      final IU uml2iu = IterableExtensions.<IU>head(_ius_4);
      String _iD_2 = uml2iu.getID();
      Assert.assertEquals("org.eclipse.uml2.sdk.feature.group", _iD_2);
      String _version_2 = uml2iu.getVersion();
      Assert.assertEquals(null, _version_2);
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testLocationOption() {
    try {
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
      EList<Location> _locations = targetPlatform.getLocations();
      final Location fisrtLocation = IterableExtensions.<Location>head(_locations);
      EList<Option> _options = fisrtLocation.getOptions();
      boolean _contains = _options.contains(Option.INCLUDE_SOURCE);
      Assert.assertTrue(_contains);
      EList<Option> _options_1 = fisrtLocation.getOptions();
      boolean _contains_1 = _options_1.contains(Option.INCLUDE_ALL_ENVIRONMENTS);
      Assert.assertTrue(_contains_1);
      EList<Option> _options_2 = fisrtLocation.getOptions();
      boolean _contains_2 = _options_2.contains(Option.INCLUDE_REQUIRED);
      Assert.assertTrue(_contains_2);
      EList<Option> _options_3 = fisrtLocation.getOptions();
      boolean _contains_3 = _options_3.contains(Option.INCLUDE_CONFIGURE_PHASE);
      Assert.assertTrue(_contains_3);
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testLocationOptionCheck() {
    try {
      ValidatorTester<TargetPlatformJavaValidator> _validatorTester = new ValidatorTester<TargetPlatformJavaValidator>(this.validator, this.validatorRegistrar, this.languageName);
      final ValidatorTester<TargetPlatformJavaValidator> tester = _validatorTester;
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
      EList<Location> _locations = targetPlatform.getLocations();
      final Location fisrtLocation = IterableExtensions.<Location>head(_locations);
      TargetPlatformJavaValidator _validator = tester.validator();
      _validator.checkAllEnvAndRequiredAreSelfExluding(fisrtLocation);
      AssertableDiagnostics _diagnose = tester.diagnose();
      Iterable<Diagnostic> _allDiagnostics = _diagnose.getAllDiagnostics();
      Iterable<AbstractValidationDiagnostic> _filter = Iterables.<AbstractValidationDiagnostic>filter(_allDiagnostics, AbstractValidationDiagnostic.class);
      for (final AbstractValidationDiagnostic diag : _filter) {
        String _issueCode = diag.getIssueCode();
        Assert.assertEquals(TargetPlatformJavaValidator.CHECK__OPTIONS_SELF_EXCLUDING_ALL_ENV_REQUIRED, _issueCode);
      }
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
