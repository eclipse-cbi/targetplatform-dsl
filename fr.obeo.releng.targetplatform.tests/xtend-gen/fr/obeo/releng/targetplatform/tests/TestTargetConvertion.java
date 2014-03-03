package fr.obeo.releng.targetplatform.tests;

import com.google.common.collect.Iterables;
import com.google.common.io.Files;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Provider;
import fr.obeo.releng.targetplatform.TargetPlatformBundleActivator;
import fr.obeo.releng.targetplatform.TargetPlatformInjectorProvider;
import fr.obeo.releng.targetplatform.pde.Converter;
import fr.obeo.releng.targetplatform.resolved.ResolvedLocation;
import fr.obeo.releng.targetplatform.resolved.ResolvedTargetPlatform;
import fr.obeo.releng.targetplatform.targetplatform.TargetPlatform;
import fr.obeo.releng.targetplatform.util.LocationIndexBuilder;
import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.equinox.p2.core.IProvisioningAgent;
import org.eclipse.equinox.p2.core.IProvisioningAgentProvider;
import org.eclipse.equinox.p2.core.ProvisionException;
import org.eclipse.equinox.p2.metadata.IInstallableUnit;
import org.eclipse.equinox.p2.metadata.Version;
import org.eclipse.equinox.p2.repository.metadata.IMetadataRepositoryManager;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.junit4.util.ParseHelper;
import org.eclipse.xtext.resource.XtextResourceSet;
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
  private Provider<XtextResourceSet> resourceSetProvider;
  
  @Inject
  private LocationIndexBuilder indexBuilder;
  
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
      TargetPlatformInjectorProvider _targetPlatformInjectorProvider = new TargetPlatformInjectorProvider();
      Injector _injector = _targetPlatformInjectorProvider.getInjector();
      _injector.injectMembers(converter);
      final File tmpDir = Files.createTempDir();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("file:");
      String _absolutePath = tmpDir.getAbsolutePath();
      _builder_1.append(_absolutePath, "");
      final URI agentUri = URI.create(_builder_1.toString());
      final ResolvedTargetPlatform targetDef = this.getResolvedTargetPlatform(targetPlatform, agentUri);
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
  
  @Test
  public void testCombination() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"TestTarget\"");
      _builder.newLine();
      _builder.append("location \"http://download.eclipse.org/modeling/emf/compare/updates/releases/2.1/R201310031412/\" { ");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("org.eclipse.emf.compare.ide.ui.feature.group");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.append("location \"http://download.eclipse.org/modeling/emf/compare/updates/releases/2.1/R201310031412/\" {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("org.eclipse.emf.compare.rcp.ui.feature.group");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final TargetPlatform targetPlatform = this.parser.parse(_builder);
      final Converter converter = new Converter();
      TargetPlatformInjectorProvider _targetPlatformInjectorProvider = new TargetPlatformInjectorProvider();
      Injector _injector = _targetPlatformInjectorProvider.getInjector();
      _injector.injectMembers(converter);
      final File tmpDir = Files.createTempDir();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("file:");
      String _absolutePath = tmpDir.getAbsolutePath();
      _builder_1.append(_absolutePath, "");
      final URI agentUri = URI.create(_builder_1.toString());
      final ResolvedTargetPlatform targetDef = this.getResolvedTargetPlatform(targetPlatform, agentUri);
      List<ResolvedLocation> _locations = targetDef.getLocations();
      int _size = _locations.size();
      Assert.assertEquals(1, _size);
      List<ResolvedLocation> _locations_1 = targetDef.getLocations();
      final Function1<ResolvedLocation,List<String>> _function = new Function1<ResolvedLocation,List<String>>() {
        public List<String> apply(final ResolvedLocation it) {
          List<IInstallableUnit> _resolvedIUs = it.getResolvedIUs();
          final Function1<IInstallableUnit,String> _function = new Function1<IInstallableUnit,String>() {
            public String apply(final IInstallableUnit it) {
              return it.getId();
            }
          };
          return ListExtensions.<IInstallableUnit, String>map(_resolvedIUs, _function);
        }
      };
      List<List<String>> _map = ListExtensions.<ResolvedLocation, List<String>>map(_locations_1, _function);
      final String[] ids = ((String[])Conversions.unwrapArray(Iterables.<String>concat(_map), String.class));
      int _size_1 = ((List<String>)Conversions.doWrapArray(ids)).size();
      Assert.assertEquals(2, _size_1);
      Object _head = IterableExtensions.<Object>head(((Iterable<Object>)Conversions.doWrapArray(ids)));
      Assert.assertEquals("org.eclipse.emf.compare.rcp.ui.feature.group", _head);
      Object _get = ids[1];
      Assert.assertEquals("org.eclipse.emf.compare.ide.ui.feature.group", _get);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testMultipleLocationsWithInclude() {
    try {
      final XtextResourceSet resourceSet = this.resourceSetProvider.get();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"TP1\"");
      _builder.newLine();
      _builder.append("include \"tp2.tpd\"");
      _builder.newLine();
      _builder.append("location \"http://download.eclipse.org/modeling/emf/compare/updates/releases/2.1/R201310031412/\" { ");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("org.eclipse.emf.compare.ide.ui.feature.group");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      org.eclipse.emf.common.util.URI _createURI = org.eclipse.emf.common.util.URI.createURI("tmp:/tp1.tpd");
      final TargetPlatform tp1 = this.parser.parse(_builder, _createURI, resourceSet);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("target \"TP2\"");
      _builder_1.newLine();
      _builder_1.append("location \"http://download.eclipse.org/modeling/emf/emf/updates/2.9/core/\" {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("org.eclipse.emf.sdk.feature.group");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      org.eclipse.emf.common.util.URI _createURI_1 = org.eclipse.emf.common.util.URI.createURI("tmp:/tp2.tpd");
      this.parser.parse(_builder_1, _createURI_1, resourceSet);
      final Converter converter = new Converter();
      TargetPlatformInjectorProvider _targetPlatformInjectorProvider = new TargetPlatformInjectorProvider();
      Injector _injector = _targetPlatformInjectorProvider.getInjector();
      _injector.injectMembers(converter);
      final File tmpDir = Files.createTempDir();
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("file:");
      String _absolutePath = tmpDir.getAbsolutePath();
      _builder_2.append(_absolutePath, "");
      final URI agentUri = URI.create(_builder_2.toString());
      final ResolvedTargetPlatform targetDef = this.getResolvedTargetPlatform(tp1, agentUri);
      String _name = targetDef.getName();
      Assert.assertEquals("TP1", _name);
      List<ResolvedLocation> _locations = targetDef.getLocations();
      int _size = _locations.size();
      Assert.assertEquals(2, _size);
      List<ResolvedLocation> _locations_1 = targetDef.getLocations();
      ResolvedLocation _head = IterableExtensions.<ResolvedLocation>head(_locations_1);
      URI _uRI = _head.getURI();
      String _string = _uRI.toString();
      Assert.assertEquals("http://download.eclipse.org/modeling/emf/compare/updates/releases/2.1/R201310031412/", _string);
      List<ResolvedLocation> _locations_2 = targetDef.getLocations();
      ResolvedLocation _get = _locations_2.get(1);
      URI _uRI_1 = _get.getURI();
      String _string_1 = _uRI_1.toString();
      Assert.assertEquals("http://download.eclipse.org/modeling/emf/emf/updates/2.9/core/", _string_1);
      List<ResolvedLocation> _locations_3 = targetDef.getLocations();
      final Function1<ResolvedLocation,List<String>> _function = new Function1<ResolvedLocation,List<String>>() {
        public List<String> apply(final ResolvedLocation it) {
          List<IInstallableUnit> _resolvedIUs = it.getResolvedIUs();
          final Function1<IInstallableUnit,String> _function = new Function1<IInstallableUnit,String>() {
            public String apply(final IInstallableUnit it) {
              return it.getId();
            }
          };
          return ListExtensions.<IInstallableUnit, String>map(_resolvedIUs, _function);
        }
      };
      List<List<String>> _map = ListExtensions.<ResolvedLocation, List<String>>map(_locations_3, _function);
      final String[] ids = ((String[])Conversions.unwrapArray(Iterables.<String>concat(_map), String.class));
      int _size_1 = ((List<String>)Conversions.doWrapArray(ids)).size();
      Assert.assertEquals(2, _size_1);
      Object _head_1 = IterableExtensions.<Object>head(((Iterable<Object>)Conversions.doWrapArray(ids)));
      Assert.assertEquals("org.eclipse.emf.compare.ide.ui.feature.group", _head_1);
      Object _get_1 = ids[1];
      Assert.assertEquals("org.eclipse.emf.sdk.feature.group", _get_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testCombinationWithInclude() {
    try {
      final XtextResourceSet resourceSet = this.resourceSetProvider.get();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"TP1\"");
      _builder.newLine();
      _builder.append("include \"tp2.tpd\"");
      _builder.newLine();
      _builder.append("location \"http://download.eclipse.org/modeling/emf/compare/updates/releases/2.1/R201310031412/\" { ");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("org.eclipse.emf.compare.ide.ui.feature.group");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      org.eclipse.emf.common.util.URI _createURI = org.eclipse.emf.common.util.URI.createURI("tmp:/tp1.tpd");
      final TargetPlatform tp1 = this.parser.parse(_builder, _createURI, resourceSet);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("target \"TP2\"");
      _builder_1.newLine();
      _builder_1.append("location \"http://download.eclipse.org/modeling/emf/compare/updates/releases/2.1/R201310031412/\" {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("org.eclipse.emf.compare.rcp.ui.feature.group");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      org.eclipse.emf.common.util.URI _createURI_1 = org.eclipse.emf.common.util.URI.createURI("tmp:/tp2.tpd");
      this.parser.parse(_builder_1, _createURI_1, resourceSet);
      final Converter converter = new Converter();
      TargetPlatformInjectorProvider _targetPlatformInjectorProvider = new TargetPlatformInjectorProvider();
      Injector _injector = _targetPlatformInjectorProvider.getInjector();
      _injector.injectMembers(converter);
      final File tmpDir = Files.createTempDir();
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("file:");
      String _absolutePath = tmpDir.getAbsolutePath();
      _builder_2.append(_absolutePath, "");
      final URI agentUri = URI.create(_builder_2.toString());
      final ResolvedTargetPlatform targetDef = this.getResolvedTargetPlatform(tp1, agentUri);
      String _name = targetDef.getName();
      Assert.assertEquals("TP1", _name);
      List<ResolvedLocation> _locations = targetDef.getLocations();
      int _size = _locations.size();
      Assert.assertEquals(1, _size);
      List<ResolvedLocation> _locations_1 = targetDef.getLocations();
      final Function1<ResolvedLocation,List<String>> _function = new Function1<ResolvedLocation,List<String>>() {
        public List<String> apply(final ResolvedLocation it) {
          List<IInstallableUnit> _resolvedIUs = it.getResolvedIUs();
          final Function1<IInstallableUnit,String> _function = new Function1<IInstallableUnit,String>() {
            public String apply(final IInstallableUnit it) {
              return it.getId();
            }
          };
          return ListExtensions.<IInstallableUnit, String>map(_resolvedIUs, _function);
        }
      };
      List<List<String>> _map = ListExtensions.<ResolvedLocation, List<String>>map(_locations_1, _function);
      final String[] ids = ((String[])Conversions.unwrapArray(Iterables.<String>concat(_map), String.class));
      int _size_1 = ((List<String>)Conversions.doWrapArray(ids)).size();
      Assert.assertEquals(2, _size_1);
      Object _head = IterableExtensions.<Object>head(((Iterable<Object>)Conversions.doWrapArray(ids)));
      Assert.assertEquals("org.eclipse.emf.compare.ide.ui.feature.group", _head);
      Object _get = ids[1];
      Assert.assertEquals("org.eclipse.emf.compare.rcp.ui.feature.group", _get);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testSameIUWithInclude() {
    try {
      final XtextResourceSet resourceSet = this.resourceSetProvider.get();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"TP1\"");
      _builder.newLine();
      _builder.append("include \"tp2.tpd\"");
      _builder.newLine();
      _builder.append("location \"http://download.eclipse.org/modeling/emf/compare/updates/releases/2.1/R201310031412/\" { ");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("org.eclipse.emf.compare.ide.ui.feature.group");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      org.eclipse.emf.common.util.URI _createURI = org.eclipse.emf.common.util.URI.createURI("tmp:/tp1.tpd");
      final TargetPlatform tp1 = this.parser.parse(_builder, _createURI, resourceSet);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("target \"TP2\"");
      _builder_1.newLine();
      _builder_1.append("location \"http://download.eclipse.org/modeling/emf/compare/updates/releases/2.1/R201310031412/\" {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("org.eclipse.emf.compare.ide.ui.feature.group");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      org.eclipse.emf.common.util.URI _createURI_1 = org.eclipse.emf.common.util.URI.createURI("tmp:/tp2.tpd");
      this.parser.parse(_builder_1, _createURI_1, resourceSet);
      final Converter converter = new Converter();
      TargetPlatformInjectorProvider _targetPlatformInjectorProvider = new TargetPlatformInjectorProvider();
      Injector _injector = _targetPlatformInjectorProvider.getInjector();
      _injector.injectMembers(converter);
      final File tmpDir = Files.createTempDir();
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("file:");
      String _absolutePath = tmpDir.getAbsolutePath();
      _builder_2.append(_absolutePath, "");
      final URI agentUri = URI.create(_builder_2.toString());
      final ResolvedTargetPlatform targetDef = this.getResolvedTargetPlatform(tp1, agentUri);
      String _name = targetDef.getName();
      Assert.assertEquals("TP1", _name);
      List<ResolvedLocation> _locations = targetDef.getLocations();
      int _size = _locations.size();
      Assert.assertEquals(1, _size);
      List<ResolvedLocation> _locations_1 = targetDef.getLocations();
      final Function1<ResolvedLocation,List<String>> _function = new Function1<ResolvedLocation,List<String>>() {
        public List<String> apply(final ResolvedLocation it) {
          List<IInstallableUnit> _resolvedIUs = it.getResolvedIUs();
          final Function1<IInstallableUnit,String> _function = new Function1<IInstallableUnit,String>() {
            public String apply(final IInstallableUnit it) {
              return it.getId();
            }
          };
          return ListExtensions.<IInstallableUnit, String>map(_resolvedIUs, _function);
        }
      };
      List<List<String>> _map = ListExtensions.<ResolvedLocation, List<String>>map(_locations_1, _function);
      final String[] ids = ((String[])Conversions.unwrapArray(Iterables.<String>concat(_map), String.class));
      int _size_1 = ((List<String>)Conversions.doWrapArray(ids)).size();
      Assert.assertEquals(1, _size_1);
      Object _head = IterableExtensions.<Object>head(((Iterable<Object>)Conversions.doWrapArray(ids)));
      Assert.assertEquals("org.eclipse.emf.compare.ide.ui.feature.group", _head);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testSameIU() {
    try {
      final XtextResourceSet resourceSet = this.resourceSetProvider.get();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"TP1\"");
      _builder.newLine();
      _builder.append("include \"tp2.tpd\"");
      _builder.newLine();
      _builder.append("location \"http://download.eclipse.org/modeling/emf/compare/updates/releases/2.1/R201310031412/\" { ");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("org.eclipse.emf.compare.ide.ui.feature.group");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.append("location \"http://download.eclipse.org/modeling/emf/compare/updates/releases/2.1/R201310031412/\" {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("org.eclipse.emf.compare.ide.ui.feature.group");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      org.eclipse.emf.common.util.URI _createURI = org.eclipse.emf.common.util.URI.createURI("tmp:/tp1.tpd");
      final TargetPlatform tp1 = this.parser.parse(_builder, _createURI, resourceSet);
      final Converter converter = new Converter();
      TargetPlatformInjectorProvider _targetPlatformInjectorProvider = new TargetPlatformInjectorProvider();
      Injector _injector = _targetPlatformInjectorProvider.getInjector();
      _injector.injectMembers(converter);
      final File tmpDir = Files.createTempDir();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("file:");
      String _absolutePath = tmpDir.getAbsolutePath();
      _builder_1.append(_absolutePath, "");
      final URI agentUri = URI.create(_builder_1.toString());
      final ResolvedTargetPlatform targetDef = this.getResolvedTargetPlatform(tp1, agentUri);
      String _name = targetDef.getName();
      Assert.assertEquals("TP1", _name);
      List<ResolvedLocation> _locations = targetDef.getLocations();
      int _size = _locations.size();
      Assert.assertEquals(1, _size);
      List<ResolvedLocation> _locations_1 = targetDef.getLocations();
      final Function1<ResolvedLocation,List<String>> _function = new Function1<ResolvedLocation,List<String>>() {
        public List<String> apply(final ResolvedLocation it) {
          List<IInstallableUnit> _resolvedIUs = it.getResolvedIUs();
          final Function1<IInstallableUnit,String> _function = new Function1<IInstallableUnit,String>() {
            public String apply(final IInstallableUnit it) {
              return it.getId();
            }
          };
          return ListExtensions.<IInstallableUnit, String>map(_resolvedIUs, _function);
        }
      };
      List<List<String>> _map = ListExtensions.<ResolvedLocation, List<String>>map(_locations_1, _function);
      final String[] ids = ((String[])Conversions.unwrapArray(Iterables.<String>concat(_map), String.class));
      int _size_1 = ((List<String>)Conversions.doWrapArray(ids)).size();
      Assert.assertEquals(1, _size_1);
      Object _head = IterableExtensions.<Object>head(((Iterable<Object>)Conversions.doWrapArray(ids)));
      Assert.assertEquals("org.eclipse.emf.compare.ide.ui.feature.group", _head);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testIUOverrideWithInclude1() {
    try {
      final XtextResourceSet resourceSet = this.resourceSetProvider.get();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"TP1\"");
      _builder.newLine();
      _builder.append("include \"tp2.tpd\"");
      _builder.newLine();
      _builder.append("location \"http://download.eclipse.org/tools/orbit/downloads/drops/R20130517111416/repository/\" { ");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("com.google.guava");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      org.eclipse.emf.common.util.URI _createURI = org.eclipse.emf.common.util.URI.createURI("tmp:/tp1.tpd");
      final TargetPlatform tp1 = this.parser.parse(_builder, _createURI, resourceSet);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("target \"TP2\"");
      _builder_1.newLine();
      _builder_1.append("location \"http://download.eclipse.org/tools/orbit/downloads/drops/R20130517111416/repository/\" {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("com.google.guava;version=\"[11.0.0,12.0.0)\"");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      org.eclipse.emf.common.util.URI _createURI_1 = org.eclipse.emf.common.util.URI.createURI("tmp:/tp2.tpd");
      this.parser.parse(_builder_1, _createURI_1, resourceSet);
      final Converter converter = new Converter();
      TargetPlatformInjectorProvider _targetPlatformInjectorProvider = new TargetPlatformInjectorProvider();
      Injector _injector = _targetPlatformInjectorProvider.getInjector();
      _injector.injectMembers(converter);
      final File tmpDir = Files.createTempDir();
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("file:");
      String _absolutePath = tmpDir.getAbsolutePath();
      _builder_2.append(_absolutePath, "");
      final URI agentUri = URI.create(_builder_2.toString());
      final ResolvedTargetPlatform targetDef = this.getResolvedTargetPlatform(tp1, agentUri);
      String _name = targetDef.getName();
      Assert.assertEquals("TP1", _name);
      List<ResolvedLocation> _locations = targetDef.getLocations();
      int _size = _locations.size();
      Assert.assertEquals(1, _size);
      List<ResolvedLocation> _locations_1 = targetDef.getLocations();
      final Function1<ResolvedLocation,List<String>> _function = new Function1<ResolvedLocation,List<String>>() {
        public List<String> apply(final ResolvedLocation it) {
          List<IInstallableUnit> _resolvedIUs = it.getResolvedIUs();
          final Function1<IInstallableUnit,String> _function = new Function1<IInstallableUnit,String>() {
            public String apply(final IInstallableUnit it) {
              return it.getId();
            }
          };
          return ListExtensions.<IInstallableUnit, String>map(_resolvedIUs, _function);
        }
      };
      List<List<String>> _map = ListExtensions.<ResolvedLocation, List<String>>map(_locations_1, _function);
      final String[] ids = ((String[])Conversions.unwrapArray(Iterables.<String>concat(_map), String.class));
      List<ResolvedLocation> _locations_2 = targetDef.getLocations();
      final Function1<ResolvedLocation,List<Version>> _function_1 = new Function1<ResolvedLocation,List<Version>>() {
        public List<Version> apply(final ResolvedLocation it) {
          List<IInstallableUnit> _resolvedIUs = it.getResolvedIUs();
          final Function1<IInstallableUnit,Version> _function = new Function1<IInstallableUnit,Version>() {
            public Version apply(final IInstallableUnit it) {
              return it.getVersion();
            }
          };
          return ListExtensions.<IInstallableUnit, Version>map(_resolvedIUs, _function);
        }
      };
      List<List<Version>> _map_1 = ListExtensions.<ResolvedLocation, List<Version>>map(_locations_2, _function_1);
      final Version[] versions = ((Version[])Conversions.unwrapArray(Iterables.<Version>concat(_map_1), Version.class));
      int _size_1 = ((List<String>)Conversions.doWrapArray(ids)).size();
      Assert.assertEquals(1, _size_1);
      Object _head = IterableExtensions.<Object>head(((Iterable<Object>)Conversions.doWrapArray(ids)));
      Assert.assertEquals("com.google.guava", _head);
      Version _head_1 = IterableExtensions.<Version>head(((Iterable<Version>)Conversions.doWrapArray(versions)));
      String _string = _head_1.toString();
      Assert.assertEquals("12.0.0.v201212092141", _string);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testIUOverrideWithInclude2() {
    try {
      final XtextResourceSet resourceSet = this.resourceSetProvider.get();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"TP1\"");
      _builder.newLine();
      _builder.append("include \"tp2.tpd\"");
      _builder.newLine();
      _builder.append("include \"tp3.tpd\"");
      _builder.newLine();
      org.eclipse.emf.common.util.URI _createURI = org.eclipse.emf.common.util.URI.createURI("tmp:/tp1.tpd");
      final TargetPlatform tp1 = this.parser.parse(_builder, _createURI, resourceSet);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("target \"TP2\"");
      _builder_1.newLine();
      _builder_1.append("location \"http://download.eclipse.org/tools/orbit/downloads/drops/R20130517111416/repository/\" {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("com.google.guava;version=[11.0.0,12.0.0)");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      org.eclipse.emf.common.util.URI _createURI_1 = org.eclipse.emf.common.util.URI.createURI("tmp:/tp2.tpd");
      this.parser.parse(_builder_1, _createURI_1, resourceSet);
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("target \"TP3\"");
      _builder_2.newLine();
      _builder_2.append("location \"http://download.eclipse.org/tools/orbit/downloads/drops/R20130517111416/repository/\" {");
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("com.google.guava");
      _builder_2.newLine();
      _builder_2.append("}");
      _builder_2.newLine();
      org.eclipse.emf.common.util.URI _createURI_2 = org.eclipse.emf.common.util.URI.createURI("tmp:/tp3.tpd");
      this.parser.parse(_builder_2, _createURI_2, resourceSet);
      final Converter converter = new Converter();
      TargetPlatformInjectorProvider _targetPlatformInjectorProvider = new TargetPlatformInjectorProvider();
      Injector _injector = _targetPlatformInjectorProvider.getInjector();
      _injector.injectMembers(converter);
      final File tmpDir = Files.createTempDir();
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("file:");
      String _absolutePath = tmpDir.getAbsolutePath();
      _builder_3.append(_absolutePath, "");
      final URI agentUri = URI.create(_builder_3.toString());
      final ResolvedTargetPlatform targetDef = this.getResolvedTargetPlatform(tp1, agentUri);
      String _name = targetDef.getName();
      Assert.assertEquals("TP1", _name);
      List<ResolvedLocation> _locations = targetDef.getLocations();
      int _size = _locations.size();
      Assert.assertEquals(1, _size);
      List<ResolvedLocation> _locations_1 = targetDef.getLocations();
      final Function1<ResolvedLocation,List<String>> _function = new Function1<ResolvedLocation,List<String>>() {
        public List<String> apply(final ResolvedLocation it) {
          List<IInstallableUnit> _resolvedIUs = it.getResolvedIUs();
          final Function1<IInstallableUnit,String> _function = new Function1<IInstallableUnit,String>() {
            public String apply(final IInstallableUnit it) {
              return it.getId();
            }
          };
          return ListExtensions.<IInstallableUnit, String>map(_resolvedIUs, _function);
        }
      };
      List<List<String>> _map = ListExtensions.<ResolvedLocation, List<String>>map(_locations_1, _function);
      final String[] ids = ((String[])Conversions.unwrapArray(Iterables.<String>concat(_map), String.class));
      List<ResolvedLocation> _locations_2 = targetDef.getLocations();
      final Function1<ResolvedLocation,List<Version>> _function_1 = new Function1<ResolvedLocation,List<Version>>() {
        public List<Version> apply(final ResolvedLocation it) {
          List<IInstallableUnit> _resolvedIUs = it.getResolvedIUs();
          final Function1<IInstallableUnit,Version> _function = new Function1<IInstallableUnit,Version>() {
            public Version apply(final IInstallableUnit it) {
              return it.getVersion();
            }
          };
          return ListExtensions.<IInstallableUnit, Version>map(_resolvedIUs, _function);
        }
      };
      List<List<Version>> _map_1 = ListExtensions.<ResolvedLocation, List<Version>>map(_locations_2, _function_1);
      final Version[] versions = ((Version[])Conversions.unwrapArray(Iterables.<Version>concat(_map_1), Version.class));
      int _size_1 = ((List<String>)Conversions.doWrapArray(ids)).size();
      Assert.assertEquals(1, _size_1);
      Object _head = IterableExtensions.<Object>head(((Iterable<Object>)Conversions.doWrapArray(ids)));
      Assert.assertEquals("com.google.guava", _head);
      Version _head_1 = IterableExtensions.<Version>head(((Iterable<Version>)Conversions.doWrapArray(versions)));
      String _string = _head_1.toString();
      Assert.assertEquals("12.0.0.v201212092141", _string);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testIUOverrideWithInclude3() {
    try {
      final XtextResourceSet resourceSet = this.resourceSetProvider.get();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"TP1\"");
      _builder.newLine();
      _builder.append("include \"tp3.tpd\"");
      _builder.newLine();
      _builder.append("include \"tp2.tpd\"");
      _builder.newLine();
      org.eclipse.emf.common.util.URI _createURI = org.eclipse.emf.common.util.URI.createURI("tmp:/tp1.tpd");
      final TargetPlatform tp1 = this.parser.parse(_builder, _createURI, resourceSet);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("target \"TP2\"");
      _builder_1.newLine();
      _builder_1.append("location \"http://download.eclipse.org/tools/orbit/downloads/drops/R20130517111416/repository/\" {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("com.google.guava;version=[11.0.0,12.0.0)");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      org.eclipse.emf.common.util.URI _createURI_1 = org.eclipse.emf.common.util.URI.createURI("tmp:/tp2.tpd");
      this.parser.parse(_builder_1, _createURI_1, resourceSet);
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("target \"TP3\"");
      _builder_2.newLine();
      _builder_2.append("location \"http://download.eclipse.org/tools/orbit/downloads/drops/R20130517111416/repository/\" {");
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("com.google.guava");
      _builder_2.newLine();
      _builder_2.append("}");
      _builder_2.newLine();
      org.eclipse.emf.common.util.URI _createURI_2 = org.eclipse.emf.common.util.URI.createURI("tmp:/tp3.tpd");
      this.parser.parse(_builder_2, _createURI_2, resourceSet);
      final Converter converter = new Converter();
      TargetPlatformInjectorProvider _targetPlatformInjectorProvider = new TargetPlatformInjectorProvider();
      Injector _injector = _targetPlatformInjectorProvider.getInjector();
      _injector.injectMembers(converter);
      final File tmpDir = Files.createTempDir();
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("file:");
      String _absolutePath = tmpDir.getAbsolutePath();
      _builder_3.append(_absolutePath, "");
      final URI agentUri = URI.create(_builder_3.toString());
      final ResolvedTargetPlatform targetDef = this.getResolvedTargetPlatform(tp1, agentUri);
      String _name = targetDef.getName();
      Assert.assertEquals("TP1", _name);
      List<ResolvedLocation> _locations = targetDef.getLocations();
      int _size = _locations.size();
      Assert.assertEquals(1, _size);
      List<ResolvedLocation> _locations_1 = targetDef.getLocations();
      final Function1<ResolvedLocation,List<String>> _function = new Function1<ResolvedLocation,List<String>>() {
        public List<String> apply(final ResolvedLocation it) {
          List<IInstallableUnit> _resolvedIUs = it.getResolvedIUs();
          final Function1<IInstallableUnit,String> _function = new Function1<IInstallableUnit,String>() {
            public String apply(final IInstallableUnit it) {
              return it.getId();
            }
          };
          return ListExtensions.<IInstallableUnit, String>map(_resolvedIUs, _function);
        }
      };
      List<List<String>> _map = ListExtensions.<ResolvedLocation, List<String>>map(_locations_1, _function);
      final String[] ids = ((String[])Conversions.unwrapArray(Iterables.<String>concat(_map), String.class));
      List<ResolvedLocation> _locations_2 = targetDef.getLocations();
      final Function1<ResolvedLocation,List<Version>> _function_1 = new Function1<ResolvedLocation,List<Version>>() {
        public List<Version> apply(final ResolvedLocation it) {
          List<IInstallableUnit> _resolvedIUs = it.getResolvedIUs();
          final Function1<IInstallableUnit,Version> _function = new Function1<IInstallableUnit,Version>() {
            public Version apply(final IInstallableUnit it) {
              return it.getVersion();
            }
          };
          return ListExtensions.<IInstallableUnit, Version>map(_resolvedIUs, _function);
        }
      };
      List<List<Version>> _map_1 = ListExtensions.<ResolvedLocation, List<Version>>map(_locations_2, _function_1);
      final Version[] versions = ((Version[])Conversions.unwrapArray(Iterables.<Version>concat(_map_1), Version.class));
      int _size_1 = ((List<String>)Conversions.doWrapArray(ids)).size();
      Assert.assertEquals(1, _size_1);
      Object _head = IterableExtensions.<Object>head(((Iterable<Object>)Conversions.doWrapArray(ids)));
      Assert.assertEquals("com.google.guava", _head);
      Version _head_1 = IterableExtensions.<Version>head(((Iterable<Version>)Conversions.doWrapArray(versions)));
      String _string = _head_1.toString();
      Assert.assertEquals("11.0.2.v201303041551", _string);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testIUOverrideWithInclude4() {
    try {
      final XtextResourceSet resourceSet = this.resourceSetProvider.get();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"TP1\"");
      _builder.newLine();
      _builder.append("include \"tp2.tpd\"");
      _builder.newLine();
      org.eclipse.emf.common.util.URI _createURI = org.eclipse.emf.common.util.URI.createURI("tmp:/tp1.tpd");
      final TargetPlatform tp1 = this.parser.parse(_builder, _createURI, resourceSet);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("target \"TP2\"");
      _builder_1.newLine();
      _builder_1.append("include \"tp3.tpd\"");
      _builder_1.newLine();
      _builder_1.append("location \"http://download.eclipse.org/tools/orbit/downloads/drops/R20130517111416/repository/\" {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("com.google.guava;version=[11.0.0,12.0.0)");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      org.eclipse.emf.common.util.URI _createURI_1 = org.eclipse.emf.common.util.URI.createURI("tmp:/tp2.tpd");
      this.parser.parse(_builder_1, _createURI_1, resourceSet);
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("target \"TP3\"");
      _builder_2.newLine();
      _builder_2.append("location \"http://download.eclipse.org/tools/orbit/downloads/drops/R20130517111416/repository/\" {");
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("com.google.guava");
      _builder_2.newLine();
      _builder_2.append("}");
      _builder_2.newLine();
      org.eclipse.emf.common.util.URI _createURI_2 = org.eclipse.emf.common.util.URI.createURI("tmp:/tp3.tpd");
      this.parser.parse(_builder_2, _createURI_2, resourceSet);
      final Converter converter = new Converter();
      TargetPlatformInjectorProvider _targetPlatformInjectorProvider = new TargetPlatformInjectorProvider();
      Injector _injector = _targetPlatformInjectorProvider.getInjector();
      _injector.injectMembers(converter);
      final File tmpDir = Files.createTempDir();
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("file:");
      String _absolutePath = tmpDir.getAbsolutePath();
      _builder_3.append(_absolutePath, "");
      final URI agentUri = URI.create(_builder_3.toString());
      final ResolvedTargetPlatform targetDef = this.getResolvedTargetPlatform(tp1, agentUri);
      String _name = targetDef.getName();
      Assert.assertEquals("TP1", _name);
      List<ResolvedLocation> _locations = targetDef.getLocations();
      int _size = _locations.size();
      Assert.assertEquals(1, _size);
      List<ResolvedLocation> _locations_1 = targetDef.getLocations();
      final Function1<ResolvedLocation,List<String>> _function = new Function1<ResolvedLocation,List<String>>() {
        public List<String> apply(final ResolvedLocation it) {
          List<IInstallableUnit> _resolvedIUs = it.getResolvedIUs();
          final Function1<IInstallableUnit,String> _function = new Function1<IInstallableUnit,String>() {
            public String apply(final IInstallableUnit it) {
              return it.getId();
            }
          };
          return ListExtensions.<IInstallableUnit, String>map(_resolvedIUs, _function);
        }
      };
      List<List<String>> _map = ListExtensions.<ResolvedLocation, List<String>>map(_locations_1, _function);
      final String[] ids = ((String[])Conversions.unwrapArray(Iterables.<String>concat(_map), String.class));
      List<ResolvedLocation> _locations_2 = targetDef.getLocations();
      final Function1<ResolvedLocation,List<Version>> _function_1 = new Function1<ResolvedLocation,List<Version>>() {
        public List<Version> apply(final ResolvedLocation it) {
          List<IInstallableUnit> _resolvedIUs = it.getResolvedIUs();
          final Function1<IInstallableUnit,Version> _function = new Function1<IInstallableUnit,Version>() {
            public Version apply(final IInstallableUnit it) {
              return it.getVersion();
            }
          };
          return ListExtensions.<IInstallableUnit, Version>map(_resolvedIUs, _function);
        }
      };
      List<List<Version>> _map_1 = ListExtensions.<ResolvedLocation, List<Version>>map(_locations_2, _function_1);
      final Version[] versions = ((Version[])Conversions.unwrapArray(Iterables.<Version>concat(_map_1), Version.class));
      int _size_1 = ((List<String>)Conversions.doWrapArray(ids)).size();
      Assert.assertEquals(1, _size_1);
      Object _head = IterableExtensions.<Object>head(((Iterable<Object>)Conversions.doWrapArray(ids)));
      Assert.assertEquals("com.google.guava", _head);
      Version _head_1 = IterableExtensions.<Version>head(((Iterable<Version>)Conversions.doWrapArray(versions)));
      String _string = _head_1.toString();
      Assert.assertEquals("11.0.2.v201303041551", _string);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testIUOverrideWithInclude5() {
    try {
      final XtextResourceSet resourceSet = this.resourceSetProvider.get();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"TP1\"");
      _builder.newLine();
      _builder.append("include \"tp2.tpd\"");
      _builder.newLine();
      org.eclipse.emf.common.util.URI _createURI = org.eclipse.emf.common.util.URI.createURI("tmp:/tp1.tpd");
      final TargetPlatform tp1 = this.parser.parse(_builder, _createURI, resourceSet);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("target \"TP2\"");
      _builder_1.newLine();
      _builder_1.append("include \"tp3.tpd\"");
      _builder_1.newLine();
      _builder_1.append("location \"http://download.eclipse.org/tools/orbit/downloads/drops/R20130517111416/repository/\" {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("com.google.guava");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      org.eclipse.emf.common.util.URI _createURI_1 = org.eclipse.emf.common.util.URI.createURI("tmp:/tp2.tpd");
      this.parser.parse(_builder_1, _createURI_1, resourceSet);
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("target \"TP3\"");
      _builder_2.newLine();
      _builder_2.append("location \"http://download.eclipse.org/tools/orbit/downloads/drops/R20130517111416/repository/\" {");
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("com.google.guava;version=[11.0.0,12.0.0)");
      _builder_2.newLine();
      _builder_2.append("}");
      _builder_2.newLine();
      org.eclipse.emf.common.util.URI _createURI_2 = org.eclipse.emf.common.util.URI.createURI("tmp:/tp3.tpd");
      this.parser.parse(_builder_2, _createURI_2, resourceSet);
      final Converter converter = new Converter();
      TargetPlatformInjectorProvider _targetPlatformInjectorProvider = new TargetPlatformInjectorProvider();
      Injector _injector = _targetPlatformInjectorProvider.getInjector();
      _injector.injectMembers(converter);
      final File tmpDir = Files.createTempDir();
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("file:");
      String _absolutePath = tmpDir.getAbsolutePath();
      _builder_3.append(_absolutePath, "");
      final URI agentUri = URI.create(_builder_3.toString());
      final ResolvedTargetPlatform targetDef = this.getResolvedTargetPlatform(tp1, agentUri);
      String _name = targetDef.getName();
      Assert.assertEquals("TP1", _name);
      List<ResolvedLocation> _locations = targetDef.getLocations();
      int _size = _locations.size();
      Assert.assertEquals(1, _size);
      List<ResolvedLocation> _locations_1 = targetDef.getLocations();
      final Function1<ResolvedLocation,List<String>> _function = new Function1<ResolvedLocation,List<String>>() {
        public List<String> apply(final ResolvedLocation it) {
          List<IInstallableUnit> _resolvedIUs = it.getResolvedIUs();
          final Function1<IInstallableUnit,String> _function = new Function1<IInstallableUnit,String>() {
            public String apply(final IInstallableUnit it) {
              return it.getId();
            }
          };
          return ListExtensions.<IInstallableUnit, String>map(_resolvedIUs, _function);
        }
      };
      List<List<String>> _map = ListExtensions.<ResolvedLocation, List<String>>map(_locations_1, _function);
      final String[] ids = ((String[])Conversions.unwrapArray(Iterables.<String>concat(_map), String.class));
      List<ResolvedLocation> _locations_2 = targetDef.getLocations();
      final Function1<ResolvedLocation,List<Version>> _function_1 = new Function1<ResolvedLocation,List<Version>>() {
        public List<Version> apply(final ResolvedLocation it) {
          List<IInstallableUnit> _resolvedIUs = it.getResolvedIUs();
          final Function1<IInstallableUnit,Version> _function = new Function1<IInstallableUnit,Version>() {
            public Version apply(final IInstallableUnit it) {
              return it.getVersion();
            }
          };
          return ListExtensions.<IInstallableUnit, Version>map(_resolvedIUs, _function);
        }
      };
      List<List<Version>> _map_1 = ListExtensions.<ResolvedLocation, List<Version>>map(_locations_2, _function_1);
      final Version[] versions = ((Version[])Conversions.unwrapArray(Iterables.<Version>concat(_map_1), Version.class));
      int _size_1 = ((List<String>)Conversions.doWrapArray(ids)).size();
      Assert.assertEquals(1, _size_1);
      Object _head = IterableExtensions.<Object>head(((Iterable<Object>)Conversions.doWrapArray(ids)));
      Assert.assertEquals("com.google.guava", _head);
      Version _head_1 = IterableExtensions.<Version>head(((Iterable<Version>)Conversions.doWrapArray(versions)));
      String _string = _head_1.toString();
      Assert.assertEquals("12.0.0.v201212092141", _string);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testIUOverride1() {
    try {
      final XtextResourceSet resourceSet = this.resourceSetProvider.get();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"TP1\"");
      _builder.newLine();
      _builder.append("include \"tp2.tpd\"");
      _builder.newLine();
      _builder.append("location \"http://download.eclipse.org/tools/orbit/downloads/drops/R20130517111416/repository/\" { ");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("com.google.guava");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.append("location \"http://download.eclipse.org/tools/orbit/downloads/drops/R20130517111416/repository/\" {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("com.google.guava;version=\"[11.0.0,12.0.0)\"");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      org.eclipse.emf.common.util.URI _createURI = org.eclipse.emf.common.util.URI.createURI("tmp:/tp1.tpd");
      final TargetPlatform tp1 = this.parser.parse(_builder, _createURI, resourceSet);
      final Converter converter = new Converter();
      TargetPlatformInjectorProvider _targetPlatformInjectorProvider = new TargetPlatformInjectorProvider();
      Injector _injector = _targetPlatformInjectorProvider.getInjector();
      _injector.injectMembers(converter);
      final File tmpDir = Files.createTempDir();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("file:");
      String _absolutePath = tmpDir.getAbsolutePath();
      _builder_1.append(_absolutePath, "");
      final URI agentUri = URI.create(_builder_1.toString());
      final ResolvedTargetPlatform targetDef = this.getResolvedTargetPlatform(tp1, agentUri);
      String _name = targetDef.getName();
      Assert.assertEquals("TP1", _name);
      List<ResolvedLocation> _locations = targetDef.getLocations();
      int _size = _locations.size();
      Assert.assertEquals(1, _size);
      List<ResolvedLocation> _locations_1 = targetDef.getLocations();
      final Function1<ResolvedLocation,List<String>> _function = new Function1<ResolvedLocation,List<String>>() {
        public List<String> apply(final ResolvedLocation it) {
          List<IInstallableUnit> _resolvedIUs = it.getResolvedIUs();
          final Function1<IInstallableUnit,String> _function = new Function1<IInstallableUnit,String>() {
            public String apply(final IInstallableUnit it) {
              return it.getId();
            }
          };
          return ListExtensions.<IInstallableUnit, String>map(_resolvedIUs, _function);
        }
      };
      List<List<String>> _map = ListExtensions.<ResolvedLocation, List<String>>map(_locations_1, _function);
      final String[] ids = ((String[])Conversions.unwrapArray(Iterables.<String>concat(_map), String.class));
      List<ResolvedLocation> _locations_2 = targetDef.getLocations();
      final Function1<ResolvedLocation,List<Version>> _function_1 = new Function1<ResolvedLocation,List<Version>>() {
        public List<Version> apply(final ResolvedLocation it) {
          List<IInstallableUnit> _resolvedIUs = it.getResolvedIUs();
          final Function1<IInstallableUnit,Version> _function = new Function1<IInstallableUnit,Version>() {
            public Version apply(final IInstallableUnit it) {
              return it.getVersion();
            }
          };
          return ListExtensions.<IInstallableUnit, Version>map(_resolvedIUs, _function);
        }
      };
      List<List<Version>> _map_1 = ListExtensions.<ResolvedLocation, List<Version>>map(_locations_2, _function_1);
      final Version[] versions = ((Version[])Conversions.unwrapArray(Iterables.<Version>concat(_map_1), Version.class));
      int _size_1 = ((List<String>)Conversions.doWrapArray(ids)).size();
      Assert.assertEquals(1, _size_1);
      Object _head = IterableExtensions.<Object>head(((Iterable<Object>)Conversions.doWrapArray(ids)));
      Assert.assertEquals("com.google.guava", _head);
      Version _head_1 = IterableExtensions.<Version>head(((Iterable<Version>)Conversions.doWrapArray(versions)));
      String _string = _head_1.toString();
      Assert.assertEquals("11.0.2.v201303041551", _string);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testIUOverride2() {
    try {
      final XtextResourceSet resourceSet = this.resourceSetProvider.get();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"TP1\"");
      _builder.newLine();
      _builder.append("include \"tp2.tpd\"");
      _builder.newLine();
      _builder.append("location \"http://download.eclipse.org/tools/orbit/downloads/drops/R20130517111416/repository/\" {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("com.google.guava;version=\"[11.0.0,12.0.0)\"");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.append("location \"http://download.eclipse.org/tools/orbit/downloads/drops/R20130517111416/repository/\" { ");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("com.google.guava");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      org.eclipse.emf.common.util.URI _createURI = org.eclipse.emf.common.util.URI.createURI("tmp:/tp1.tpd");
      final TargetPlatform tp1 = this.parser.parse(_builder, _createURI, resourceSet);
      final Converter converter = new Converter();
      TargetPlatformInjectorProvider _targetPlatformInjectorProvider = new TargetPlatformInjectorProvider();
      Injector _injector = _targetPlatformInjectorProvider.getInjector();
      _injector.injectMembers(converter);
      final File tmpDir = Files.createTempDir();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("file:");
      String _absolutePath = tmpDir.getAbsolutePath();
      _builder_1.append(_absolutePath, "");
      final URI agentUri = URI.create(_builder_1.toString());
      final ResolvedTargetPlatform targetDef = this.getResolvedTargetPlatform(tp1, agentUri);
      String _name = targetDef.getName();
      Assert.assertEquals("TP1", _name);
      List<ResolvedLocation> _locations = targetDef.getLocations();
      int _size = _locations.size();
      Assert.assertEquals(1, _size);
      List<ResolvedLocation> _locations_1 = targetDef.getLocations();
      final Function1<ResolvedLocation,List<String>> _function = new Function1<ResolvedLocation,List<String>>() {
        public List<String> apply(final ResolvedLocation it) {
          List<IInstallableUnit> _resolvedIUs = it.getResolvedIUs();
          final Function1<IInstallableUnit,String> _function = new Function1<IInstallableUnit,String>() {
            public String apply(final IInstallableUnit it) {
              return it.getId();
            }
          };
          return ListExtensions.<IInstallableUnit, String>map(_resolvedIUs, _function);
        }
      };
      List<List<String>> _map = ListExtensions.<ResolvedLocation, List<String>>map(_locations_1, _function);
      final String[] ids = ((String[])Conversions.unwrapArray(Iterables.<String>concat(_map), String.class));
      List<ResolvedLocation> _locations_2 = targetDef.getLocations();
      final Function1<ResolvedLocation,List<Version>> _function_1 = new Function1<ResolvedLocation,List<Version>>() {
        public List<Version> apply(final ResolvedLocation it) {
          List<IInstallableUnit> _resolvedIUs = it.getResolvedIUs();
          final Function1<IInstallableUnit,Version> _function = new Function1<IInstallableUnit,Version>() {
            public Version apply(final IInstallableUnit it) {
              return it.getVersion();
            }
          };
          return ListExtensions.<IInstallableUnit, Version>map(_resolvedIUs, _function);
        }
      };
      List<List<Version>> _map_1 = ListExtensions.<ResolvedLocation, List<Version>>map(_locations_2, _function_1);
      final Version[] versions = ((Version[])Conversions.unwrapArray(Iterables.<Version>concat(_map_1), Version.class));
      int _size_1 = ((List<String>)Conversions.doWrapArray(ids)).size();
      Assert.assertEquals(1, _size_1);
      Object _head = IterableExtensions.<Object>head(((Iterable<Object>)Conversions.doWrapArray(ids)));
      Assert.assertEquals("com.google.guava", _head);
      Version _head_1 = IterableExtensions.<Version>head(((Iterable<Version>)Conversions.doWrapArray(versions)));
      String _string = _head_1.toString();
      Assert.assertEquals("12.0.0.v201212092141", _string);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testIUOverride3() {
    try {
      final XtextResourceSet resourceSet = this.resourceSetProvider.get();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"TP1\"");
      _builder.newLine();
      _builder.append("include \"tp2.tpd\"");
      _builder.newLine();
      _builder.append("location \"http://download.eclipse.org/tools/orbit/downloads/drops/R20130517111416/repository/\" {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("com.google.guava;version=\"[11.0.0,12.0.0)\"");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("com.google.guava");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      org.eclipse.emf.common.util.URI _createURI = org.eclipse.emf.common.util.URI.createURI("tmp:/tp1.tpd");
      final TargetPlatform tp1 = this.parser.parse(_builder, _createURI, resourceSet);
      final Converter converter = new Converter();
      TargetPlatformInjectorProvider _targetPlatformInjectorProvider = new TargetPlatformInjectorProvider();
      Injector _injector = _targetPlatformInjectorProvider.getInjector();
      _injector.injectMembers(converter);
      final File tmpDir = Files.createTempDir();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("file:");
      String _absolutePath = tmpDir.getAbsolutePath();
      _builder_1.append(_absolutePath, "");
      final URI agentUri = URI.create(_builder_1.toString());
      final ResolvedTargetPlatform targetDef = this.getResolvedTargetPlatform(tp1, agentUri);
      String _name = targetDef.getName();
      Assert.assertEquals("TP1", _name);
      List<ResolvedLocation> _locations = targetDef.getLocations();
      int _size = _locations.size();
      Assert.assertEquals(1, _size);
      List<ResolvedLocation> _locations_1 = targetDef.getLocations();
      final Function1<ResolvedLocation,List<String>> _function = new Function1<ResolvedLocation,List<String>>() {
        public List<String> apply(final ResolvedLocation it) {
          List<IInstallableUnit> _resolvedIUs = it.getResolvedIUs();
          final Function1<IInstallableUnit,String> _function = new Function1<IInstallableUnit,String>() {
            public String apply(final IInstallableUnit it) {
              return it.getId();
            }
          };
          return ListExtensions.<IInstallableUnit, String>map(_resolvedIUs, _function);
        }
      };
      List<List<String>> _map = ListExtensions.<ResolvedLocation, List<String>>map(_locations_1, _function);
      final String[] ids = ((String[])Conversions.unwrapArray(Iterables.<String>concat(_map), String.class));
      List<ResolvedLocation> _locations_2 = targetDef.getLocations();
      final Function1<ResolvedLocation,List<Version>> _function_1 = new Function1<ResolvedLocation,List<Version>>() {
        public List<Version> apply(final ResolvedLocation it) {
          List<IInstallableUnit> _resolvedIUs = it.getResolvedIUs();
          final Function1<IInstallableUnit,Version> _function = new Function1<IInstallableUnit,Version>() {
            public Version apply(final IInstallableUnit it) {
              return it.getVersion();
            }
          };
          return ListExtensions.<IInstallableUnit, Version>map(_resolvedIUs, _function);
        }
      };
      List<List<Version>> _map_1 = ListExtensions.<ResolvedLocation, List<Version>>map(_locations_2, _function_1);
      final Version[] versions = ((Version[])Conversions.unwrapArray(Iterables.<Version>concat(_map_1), Version.class));
      int _size_1 = ((List<String>)Conversions.doWrapArray(ids)).size();
      Assert.assertEquals(1, _size_1);
      Object _head = IterableExtensions.<Object>head(((Iterable<Object>)Conversions.doWrapArray(ids)));
      Assert.assertEquals("com.google.guava", _head);
      Version _head_1 = IterableExtensions.<Version>head(((Iterable<Version>)Conversions.doWrapArray(versions)));
      String _string = _head_1.toString();
      Assert.assertEquals("11.0.2.v201303041551", _string);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testIUOverride4() {
    try {
      final XtextResourceSet resourceSet = this.resourceSetProvider.get();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"TP1\"");
      _builder.newLine();
      _builder.append("include \"tp2.tpd\"");
      _builder.newLine();
      _builder.append("location \"http://download.eclipse.org/tools/orbit/downloads/drops/R20130517111416/repository/\" {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("com.google.guava");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("com.google.guava;version=\"[11.0.0,12.0.0)\"");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      org.eclipse.emf.common.util.URI _createURI = org.eclipse.emf.common.util.URI.createURI("tmp:/tp1.tpd");
      final TargetPlatform tp1 = this.parser.parse(_builder, _createURI, resourceSet);
      final Converter converter = new Converter();
      TargetPlatformInjectorProvider _targetPlatformInjectorProvider = new TargetPlatformInjectorProvider();
      Injector _injector = _targetPlatformInjectorProvider.getInjector();
      _injector.injectMembers(converter);
      final File tmpDir = Files.createTempDir();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("file:");
      String _absolutePath = tmpDir.getAbsolutePath();
      _builder_1.append(_absolutePath, "");
      final URI agentUri = URI.create(_builder_1.toString());
      final ResolvedTargetPlatform targetDef = this.getResolvedTargetPlatform(tp1, agentUri);
      String _name = targetDef.getName();
      Assert.assertEquals("TP1", _name);
      List<ResolvedLocation> _locations = targetDef.getLocations();
      int _size = _locations.size();
      Assert.assertEquals(1, _size);
      List<ResolvedLocation> _locations_1 = targetDef.getLocations();
      final Function1<ResolvedLocation,List<String>> _function = new Function1<ResolvedLocation,List<String>>() {
        public List<String> apply(final ResolvedLocation it) {
          List<IInstallableUnit> _resolvedIUs = it.getResolvedIUs();
          final Function1<IInstallableUnit,String> _function = new Function1<IInstallableUnit,String>() {
            public String apply(final IInstallableUnit it) {
              return it.getId();
            }
          };
          return ListExtensions.<IInstallableUnit, String>map(_resolvedIUs, _function);
        }
      };
      List<List<String>> _map = ListExtensions.<ResolvedLocation, List<String>>map(_locations_1, _function);
      final String[] ids = ((String[])Conversions.unwrapArray(Iterables.<String>concat(_map), String.class));
      List<ResolvedLocation> _locations_2 = targetDef.getLocations();
      final Function1<ResolvedLocation,List<Version>> _function_1 = new Function1<ResolvedLocation,List<Version>>() {
        public List<Version> apply(final ResolvedLocation it) {
          List<IInstallableUnit> _resolvedIUs = it.getResolvedIUs();
          final Function1<IInstallableUnit,Version> _function = new Function1<IInstallableUnit,Version>() {
            public Version apply(final IInstallableUnit it) {
              return it.getVersion();
            }
          };
          return ListExtensions.<IInstallableUnit, Version>map(_resolvedIUs, _function);
        }
      };
      List<List<Version>> _map_1 = ListExtensions.<ResolvedLocation, List<Version>>map(_locations_2, _function_1);
      final Version[] versions = ((Version[])Conversions.unwrapArray(Iterables.<Version>concat(_map_1), Version.class));
      int _size_1 = ((List<String>)Conversions.doWrapArray(ids)).size();
      Assert.assertEquals(1, _size_1);
      Object _head = IterableExtensions.<Object>head(((Iterable<Object>)Conversions.doWrapArray(ids)));
      Assert.assertEquals("com.google.guava", _head);
      Version _head_1 = IterableExtensions.<Version>head(((Iterable<Version>)Conversions.doWrapArray(versions)));
      String _string = _head_1.toString();
      Assert.assertEquals("12.0.0.v201212092141", _string);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  private ResolvedTargetPlatform getResolvedTargetPlatform(final TargetPlatform targetPlatform, final URI agentLocation) throws URISyntaxException, ProvisionException {
    TargetPlatformBundleActivator _instance = TargetPlatformBundleActivator.getInstance();
    IProvisioningAgentProvider _provisioningAgentProvider = _instance.getProvisioningAgentProvider();
    final IProvisioningAgent agent = _provisioningAgentProvider.createAgent(agentLocation);
    Object _service = agent.getService(IMetadataRepositoryManager.SERVICE_NAME);
    final IMetadataRepositoryManager repositoryManager = ((IMetadataRepositoryManager) _service);
    final ResolvedTargetPlatform resolvedTargetPlatform = ResolvedTargetPlatform.create(targetPlatform, this.indexBuilder);
    BasicMonitor.Printing _printing = new BasicMonitor.Printing(System.out);
    IProgressMonitor _iProgressMonitor = BasicMonitor.toIProgressMonitor(_printing);
    resolvedTargetPlatform.resolve(repositoryManager, _iProgressMonitor);
    agent.stop();
    return resolvedTargetPlatform;
  }
}
