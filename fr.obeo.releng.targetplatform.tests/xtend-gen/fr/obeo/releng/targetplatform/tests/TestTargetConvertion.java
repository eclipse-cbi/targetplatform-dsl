package fr.obeo.releng.targetplatform.tests;

import com.google.common.io.Files;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import fr.obeo.releng.targetplatform.TargetPlatformInjectorProvider;
import fr.obeo.releng.targetplatform.pde.Converter;
import fr.obeo.releng.targetplatform.resolved.ResolvedLocation;
import fr.obeo.releng.targetplatform.resolved.ResolvedTargetPlatform;
import fr.obeo.releng.targetplatform.targetplatform.TargetPlatform;
import fr.obeo.releng.targetplatform.validation.TargetPlatformValidator;
import java.io.File;
import java.net.URI;
import java.util.List;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.equinox.p2.metadata.IInstallableUnit;
import org.eclipse.equinox.p2.metadata.Version;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.Constants;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.junit4.util.ParseHelper;
import org.eclipse.xtext.validation.EValidatorRegistrar;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@InjectWith(TargetPlatformInjectorProvider.class)
@RunWith(XtextRunner.class)
@SuppressWarnings("all")
public class TestTargetConvertion {
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
  public void testBasicBundle() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"TestTarget\"");
      _builder.newLine();
      _builder.append("location \"http://download.eclipse.org/tools/orbit/downloads/drops/R20130517111416/repository/\" { ");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("with source, requirements");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("com.google.guava;version=\"[11.0.0,12.0.0)\"");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("org.junit");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final TargetPlatform targetPlatform = this.parser.parse(_builder);
      final Converter converter = new Converter();
      final File tmpDir = Files.createTempDir();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("file:");
      String _absolutePath = tmpDir.getAbsolutePath();
      _builder_1.append(_absolutePath, "");
      final URI agentUri = URI.create(_builder_1.toString());
      BasicMonitor.Printing _printing = new BasicMonitor.Printing(System.out);
      IProgressMonitor _iProgressMonitor = BasicMonitor.toIProgressMonitor(_printing);
      final ResolvedTargetPlatform targetDef = converter.getResolvedTargetPlatform(targetPlatform, agentUri, _iProgressMonitor);
      List<ResolvedLocation> _locations = targetDef.getLocations();
      for (final ResolvedLocation loc : _locations) {
        {
          List<IInstallableUnit> _resolvedIUs = loc.getResolvedIUs();
          final Function1<IInstallableUnit,String> _function = new Function1<IInstallableUnit,String>() {
            public String apply(final IInstallableUnit it) {
              return it.getId();
            }
          };
          final String[] ids = ((String[])Conversions.unwrapArray(ListExtensions.<IInstallableUnit, String>map(_resolvedIUs, _function), String.class));
          List<IInstallableUnit> _resolvedIUs_1 = loc.getResolvedIUs();
          final Function1<IInstallableUnit,Version> _function_1 = new Function1<IInstallableUnit,Version>() {
            public Version apply(final IInstallableUnit it) {
              return it.getVersion();
            }
          };
          final Version[] versions = ((Version[])Conversions.unwrapArray(ListExtensions.<IInstallableUnit, Version>map(_resolvedIUs_1, _function_1), Version.class));
          Object _head = IterableExtensions.<Object>head(((Iterable<Object>)Conversions.doWrapArray(ids)));
          Assert.assertEquals("com.google.guava", _head);
          Version _head_1 = IterableExtensions.<Version>head(((Iterable<Version>)Conversions.doWrapArray(versions)));
          Version _parseVersion = Version.parseVersion("11.0.2.v201303041551");
          int _compareTo = _head_1.compareTo(_parseVersion);
          Assert.assertEquals(0, _compareTo);
        }
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
