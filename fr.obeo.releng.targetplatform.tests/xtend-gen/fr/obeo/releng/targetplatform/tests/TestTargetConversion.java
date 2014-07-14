package fr.obeo.releng.targetplatform.tests;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import com.google.inject.Provider;
import fr.obeo.releng.targetplatform.TargetPlatform;
import fr.obeo.releng.targetplatform.TargetPlatformInjectorProvider;
import fr.obeo.releng.targetplatform.resolved.ResolvedLocation;
import fr.obeo.releng.targetplatform.resolved.ResolvedTargetPlatform;
import fr.obeo.releng.targetplatform.tests.IQueryResultProvider;
import fr.obeo.releng.targetplatform.tests.MockIU;
import fr.obeo.releng.targetplatform.tests.MockMetadataRepositoryManager;
import fr.obeo.releng.targetplatform.util.LocationIndexBuilder;
import java.net.URI;
import java.util.List;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.equinox.p2.core.ProvisionException;
import org.eclipse.equinox.p2.metadata.IInstallableUnit;
import org.eclipse.equinox.p2.metadata.Version;
import org.eclipse.equinox.p2.repository.metadata.IMetadataRepository;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.junit4.util.ParseHelper;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
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
public class TestTargetConversion {
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
      final ResolvedTargetPlatform targetDef = ResolvedTargetPlatform.create(targetPlatform, this.indexBuilder);
      MockMetadataRepositoryManager _mockMetadataRepositoryManager = new MockMetadataRepositoryManager(new IQueryResultProvider<IInstallableUnit>() {
        public List<IInstallableUnit> listIUs(final URI location) {
          List<IInstallableUnit> _xifexpression = null;
          String _string = location.toString();
          boolean _equals = "http://download.eclipse.org/tools/orbit/downloads/drops/R20130517111416/repository/".equals(_string);
          if (_equals) {
            Version _createOSGi = Version.createOSGi(11, 0, 2, "v201303041551");
            MockIU _mockIU = new MockIU("com.google.guava", _createOSGi);
            Version _createOSGi_1 = Version.createOSGi(4, 10, 0, "v4_10_0_v20130308-0414");
            MockIU _mockIU_1 = new MockIU("org.junit", _createOSGi_1);
            _xifexpression = CollectionLiterals.<IInstallableUnit>newImmutableList(_mockIU, _mockIU_1);
          } else {
            return CollectionLiterals.<IInstallableUnit>emptyList();
          }
          return _xifexpression;
        }
      });
      NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
      targetDef.resolve(_mockMetadataRepositoryManager, _nullProgressMonitor);
      List<ResolvedLocation> _locations = targetDef.getLocations();
      int _size = _locations.size();
      Assert.assertEquals(1, _size);
      List<ResolvedLocation> _locations_1 = targetDef.getLocations();
      final ResolvedLocation loc = IterableExtensions.<ResolvedLocation>head(_locations_1);
      List<IInstallableUnit> _resolvedIUs = loc.getResolvedIUs();
      int _size_1 = _resolvedIUs.size();
      Assert.assertEquals(2, _size_1);
      List<IInstallableUnit> _resolvedIUs_1 = loc.getResolvedIUs();
      final Function1<IInstallableUnit, String> _function = new Function1<IInstallableUnit, String>() {
        public String apply(final IInstallableUnit it) {
          return it.getId();
        }
      };
      final String[] ids = ((String[])Conversions.unwrapArray(ListExtensions.<IInstallableUnit, String>map(_resolvedIUs_1, _function), String.class));
      List<IInstallableUnit> _resolvedIUs_2 = loc.getResolvedIUs();
      final Function1<IInstallableUnit, Version> _function_1 = new Function1<IInstallableUnit, Version>() {
        public Version apply(final IInstallableUnit it) {
          return it.getVersion();
        }
      };
      final Version[] versions = ((Version[])Conversions.unwrapArray(ListExtensions.<IInstallableUnit, Version>map(_resolvedIUs_2, _function_1), Version.class));
      Object _head = IterableExtensions.<Object>head(((Iterable<Object>)Conversions.doWrapArray(ids)));
      Assert.assertEquals("com.google.guava", _head);
      Version _head_1 = IterableExtensions.<Version>head(((Iterable<Version>)Conversions.doWrapArray(versions)));
      Version _parseVersion = Version.parseVersion("11.0.2.v201303041551");
      int _compareTo = _head_1.compareTo(_parseVersion);
      Assert.assertEquals(0, _compareTo);
      Object _get = ids[1];
      Assert.assertEquals("org.junit", _get);
      Version _get_1 = versions[1];
      Version _parseVersion_1 = Version.parseVersion("4.10.0.v4_10_0_v20130308-0414");
      int _compareTo_1 = _get_1.compareTo(_parseVersion_1);
      Assert.assertEquals(0, _compareTo_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testNoRepositoryAtLocation() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"TestTarget\"");
      _builder.newLine();
      _builder.append("location \"unknownHost\" { ");
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
      final ResolvedTargetPlatform resolvedTargetPlatform = ResolvedTargetPlatform.create(targetPlatform, this.indexBuilder);
      NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
      final Diagnostic d = resolvedTargetPlatform.resolve(new MockMetadataRepositoryManager(null) {
        public IMetadataRepository loadRepository(final URI location, final IProgressMonitor monitor) throws ProvisionException, OperationCanceledException {
          IMetadataRepository _xifexpression = null;
          String _string = location.toString();
          boolean _equals = "unknownHost".equals(_string);
          if (_equals) {
            throw new ProvisionException("Unknown Host");
          } else {
            _xifexpression = super.loadRepository(location, monitor);
          }
          return _xifexpression;
        }
      }, _nullProgressMonitor);
      int _severity = d.getSeverity();
      Assert.assertEquals(Diagnostic.ERROR, _severity);
      List<Diagnostic> _children = d.getChildren();
      Diagnostic _head = IterableExtensions.<Diagnostic>head(_children);
      String _message = _head.getMessage();
      String _plus = ("Message is " + _message);
      List<Diagnostic> _children_1 = d.getChildren();
      Diagnostic _head_1 = IterableExtensions.<Diagnostic>head(_children_1);
      String _message_1 = _head_1.getMessage();
      boolean _startsWith = _message_1.startsWith("Unknown Host");
      Assert.assertTrue(_plus, _startsWith);
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
      final ResolvedTargetPlatform targetDef = ResolvedTargetPlatform.create(targetPlatform, this.indexBuilder);
      MockMetadataRepositoryManager _mockMetadataRepositoryManager = new MockMetadataRepositoryManager(new IQueryResultProvider<IInstallableUnit>() {
        public List<IInstallableUnit> listIUs(final URI location) {
          List<IInstallableUnit> _xifexpression = null;
          String _string = location.toString();
          boolean _equals = "http://download.eclipse.org/modeling/emf/compare/updates/releases/2.1/R201310031412/".equals(_string);
          if (_equals) {
            Version _createOSGi = Version.createOSGi(1, 0, 0);
            MockIU _mockIU = new MockIU("org.eclipse.emf.compare.rcp.ui.feature.group", _createOSGi);
            Version _createOSGi_1 = Version.createOSGi(1, 0, 0);
            MockIU _mockIU_1 = new MockIU("org.eclipse.emf.compare.ide.ui.feature.group", _createOSGi_1);
            _xifexpression = CollectionLiterals.<IInstallableUnit>newImmutableList(_mockIU, _mockIU_1);
          } else {
            return CollectionLiterals.<IInstallableUnit>emptyList();
          }
          return _xifexpression;
        }
      });
      NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
      targetDef.resolve(_mockMetadataRepositoryManager, _nullProgressMonitor);
      List<ResolvedLocation> _locations = targetDef.getLocations();
      int _size = _locations.size();
      Assert.assertEquals(1, _size);
      List<ResolvedLocation> _locations_1 = targetDef.getLocations();
      final Function1<ResolvedLocation, List<String>> _function = new Function1<ResolvedLocation, List<String>>() {
        public List<String> apply(final ResolvedLocation it) {
          List<IInstallableUnit> _resolvedIUs = it.getResolvedIUs();
          final Function1<IInstallableUnit, String> _function = new Function1<IInstallableUnit, String>() {
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
      _builder_1.append("location \"http://download.eclipse.org/modeling/emf/emf/updates/2.9.x/core/R201402030812/\" {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("org.eclipse.emf.sdk.feature.group");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      org.eclipse.emf.common.util.URI _createURI_1 = org.eclipse.emf.common.util.URI.createURI("tmp:/tp2.tpd");
      this.parser.parse(_builder_1, _createURI_1, resourceSet);
      final ResolvedTargetPlatform targetDef = ResolvedTargetPlatform.create(tp1, this.indexBuilder);
      MockMetadataRepositoryManager _mockMetadataRepositoryManager = new MockMetadataRepositoryManager(new IQueryResultProvider<IInstallableUnit>() {
        public List<IInstallableUnit> listIUs(final URI location) {
          List<IInstallableUnit> _xifexpression = null;
          String _string = location.toString();
          boolean _equals = "http://download.eclipse.org/modeling/emf/compare/updates/releases/2.1/R201310031412/".equals(_string);
          if (_equals) {
            Version _createOSGi = Version.createOSGi(1, 0, 0);
            MockIU _mockIU = new MockIU("org.eclipse.emf.compare.rcp.ui.feature.group", _createOSGi);
            Version _createOSGi_1 = Version.createOSGi(1, 0, 0);
            MockIU _mockIU_1 = new MockIU("org.eclipse.emf.compare.ide.ui.feature.group", _createOSGi_1);
            _xifexpression = CollectionLiterals.<IInstallableUnit>newImmutableList(_mockIU, _mockIU_1);
          } else {
            List<IInstallableUnit> _xifexpression_1 = null;
            String _string_1 = location.toString();
            boolean _equals_1 = "http://download.eclipse.org/modeling/emf/emf/updates/2.9.x/core/R201402030812/".equals(_string_1);
            if (_equals_1) {
              Version _createOSGi_2 = Version.createOSGi(1, 0, 0);
              MockIU _mockIU_2 = new MockIU("org.eclipse.emf.sdk.feature.group", _createOSGi_2);
              _xifexpression_1 = CollectionLiterals.<IInstallableUnit>newImmutableList(_mockIU_2);
            } else {
              return CollectionLiterals.<IInstallableUnit>emptyList();
            }
            _xifexpression = _xifexpression_1;
          }
          return _xifexpression;
        }
      });
      NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
      targetDef.resolve(_mockMetadataRepositoryManager, _nullProgressMonitor);
      String _name = targetDef.getName();
      Assert.assertEquals("TP1", _name);
      List<ResolvedLocation> _locations = targetDef.getLocations();
      int _size = _locations.size();
      Assert.assertEquals(2, _size);
      List<ResolvedLocation> _locations_1 = targetDef.getLocations();
      ResolvedLocation _head = IterableExtensions.<ResolvedLocation>head(_locations_1);
      URI _uRI = _head.getURI();
      String _string = _uRI.toString();
      Assert.assertEquals("http://download.eclipse.org/modeling/emf/emf/updates/2.9.x/core/R201402030812/", _string);
      List<ResolvedLocation> _locations_2 = targetDef.getLocations();
      ResolvedLocation _get = _locations_2.get(1);
      URI _uRI_1 = _get.getURI();
      String _string_1 = _uRI_1.toString();
      Assert.assertEquals("http://download.eclipse.org/modeling/emf/compare/updates/releases/2.1/R201310031412/", _string_1);
      List<ResolvedLocation> _locations_3 = targetDef.getLocations();
      final Function1<ResolvedLocation, List<String>> _function = new Function1<ResolvedLocation, List<String>>() {
        public List<String> apply(final ResolvedLocation it) {
          List<IInstallableUnit> _resolvedIUs = it.getResolvedIUs();
          final Function1<IInstallableUnit, String> _function = new Function1<IInstallableUnit, String>() {
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
      Assert.assertEquals("org.eclipse.emf.sdk.feature.group", _head_1);
      Object _get_1 = ids[1];
      Assert.assertEquals("org.eclipse.emf.compare.ide.ui.feature.group", _get_1);
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
      final ResolvedTargetPlatform targetDef = ResolvedTargetPlatform.create(tp1, this.indexBuilder);
      MockMetadataRepositoryManager _mockMetadataRepositoryManager = new MockMetadataRepositoryManager(new IQueryResultProvider<IInstallableUnit>() {
        public List<IInstallableUnit> listIUs(final URI location) {
          List<IInstallableUnit> _xifexpression = null;
          String _string = location.toString();
          boolean _equals = "http://download.eclipse.org/modeling/emf/compare/updates/releases/2.1/R201310031412/".equals(_string);
          if (_equals) {
            Version _createOSGi = Version.createOSGi(1, 0, 0);
            MockIU _mockIU = new MockIU("org.eclipse.emf.compare.rcp.ui.feature.group", _createOSGi);
            Version _createOSGi_1 = Version.createOSGi(1, 0, 0);
            MockIU _mockIU_1 = new MockIU("org.eclipse.emf.compare.ide.ui.feature.group", _createOSGi_1);
            _xifexpression = CollectionLiterals.<IInstallableUnit>newImmutableList(_mockIU, _mockIU_1);
          } else {
            return CollectionLiterals.<IInstallableUnit>emptyList();
          }
          return _xifexpression;
        }
      });
      NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
      targetDef.resolve(_mockMetadataRepositoryManager, _nullProgressMonitor);
      String _name = targetDef.getName();
      Assert.assertEquals("TP1", _name);
      List<ResolvedLocation> _locations = targetDef.getLocations();
      int _size = _locations.size();
      Assert.assertEquals(1, _size);
      List<ResolvedLocation> _locations_1 = targetDef.getLocations();
      final Function1<ResolvedLocation, List<String>> _function = new Function1<ResolvedLocation, List<String>>() {
        public List<String> apply(final ResolvedLocation it) {
          List<IInstallableUnit> _resolvedIUs = it.getResolvedIUs();
          final Function1<IInstallableUnit, String> _function = new Function1<IInstallableUnit, String>() {
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
      final ResolvedTargetPlatform targetDef = ResolvedTargetPlatform.create(tp1, this.indexBuilder);
      MockMetadataRepositoryManager _mockMetadataRepositoryManager = new MockMetadataRepositoryManager(new IQueryResultProvider<IInstallableUnit>() {
        public List<IInstallableUnit> listIUs(final URI location) {
          List<IInstallableUnit> _xifexpression = null;
          String _string = location.toString();
          boolean _equals = "http://download.eclipse.org/modeling/emf/compare/updates/releases/2.1/R201310031412/".equals(_string);
          if (_equals) {
            Version _createOSGi = Version.createOSGi(1, 0, 0);
            MockIU _mockIU = new MockIU("org.eclipse.emf.compare.rcp.ui.feature.group", _createOSGi);
            Version _createOSGi_1 = Version.createOSGi(1, 0, 0);
            MockIU _mockIU_1 = new MockIU("org.eclipse.emf.compare.ide.ui.feature.group", _createOSGi_1);
            _xifexpression = CollectionLiterals.<IInstallableUnit>newImmutableList(_mockIU, _mockIU_1);
          } else {
            return CollectionLiterals.<IInstallableUnit>emptyList();
          }
          return _xifexpression;
        }
      });
      NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
      targetDef.resolve(_mockMetadataRepositoryManager, _nullProgressMonitor);
      String _name = targetDef.getName();
      Assert.assertEquals("TP1", _name);
      List<ResolvedLocation> _locations = targetDef.getLocations();
      int _size = _locations.size();
      Assert.assertEquals(1, _size);
      List<ResolvedLocation> _locations_1 = targetDef.getLocations();
      final Function1<ResolvedLocation, List<String>> _function = new Function1<ResolvedLocation, List<String>>() {
        public List<String> apply(final ResolvedLocation it) {
          List<IInstallableUnit> _resolvedIUs = it.getResolvedIUs();
          final Function1<IInstallableUnit, String> _function = new Function1<IInstallableUnit, String>() {
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
      final ResolvedTargetPlatform targetDef = ResolvedTargetPlatform.create(tp1, this.indexBuilder);
      MockMetadataRepositoryManager _mockMetadataRepositoryManager = new MockMetadataRepositoryManager(new IQueryResultProvider<IInstallableUnit>() {
        public List<IInstallableUnit> listIUs(final URI location) {
          List<IInstallableUnit> _xifexpression = null;
          String _string = location.toString();
          boolean _equals = "http://download.eclipse.org/modeling/emf/compare/updates/releases/2.1/R201310031412/".equals(_string);
          if (_equals) {
            Version _createOSGi = Version.createOSGi(1, 0, 0);
            MockIU _mockIU = new MockIU("org.eclipse.emf.compare.rcp.ui.feature.group", _createOSGi);
            Version _createOSGi_1 = Version.createOSGi(1, 0, 0);
            MockIU _mockIU_1 = new MockIU("org.eclipse.emf.compare.ide.ui.feature.group", _createOSGi_1);
            _xifexpression = CollectionLiterals.<IInstallableUnit>newImmutableList(_mockIU, _mockIU_1);
          } else {
            return CollectionLiterals.<IInstallableUnit>emptyList();
          }
          return _xifexpression;
        }
      });
      NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
      targetDef.resolve(_mockMetadataRepositoryManager, _nullProgressMonitor);
      String _name = targetDef.getName();
      Assert.assertEquals("TP1", _name);
      List<ResolvedLocation> _locations = targetDef.getLocations();
      int _size = _locations.size();
      Assert.assertEquals(1, _size);
      List<ResolvedLocation> _locations_1 = targetDef.getLocations();
      final Function1<ResolvedLocation, List<String>> _function = new Function1<ResolvedLocation, List<String>>() {
        public List<String> apply(final ResolvedLocation it) {
          List<IInstallableUnit> _resolvedIUs = it.getResolvedIUs();
          final Function1<IInstallableUnit, String> _function = new Function1<IInstallableUnit, String>() {
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
      final ResolvedTargetPlatform targetDef = ResolvedTargetPlatform.create(tp1, this.indexBuilder);
      MockMetadataRepositoryManager _mockMetadataRepositoryManager = new MockMetadataRepositoryManager(new IQueryResultProvider<IInstallableUnit>() {
        public List<IInstallableUnit> listIUs(final URI location) {
          List<IInstallableUnit> _xifexpression = null;
          String _string = location.toString();
          boolean _equals = "http://download.eclipse.org/tools/orbit/downloads/drops/R20130517111416/repository/".equals(_string);
          if (_equals) {
            Version _createOSGi = Version.createOSGi(10, 0, 0);
            MockIU _mockIU = new MockIU("com.google.guava", _createOSGi);
            Version _createOSGi_1 = Version.createOSGi(11, 0, 2);
            MockIU _mockIU_1 = new MockIU("com.google.guava", _createOSGi_1);
            Version _createOSGi_2 = Version.createOSGi(12, 0, 0);
            MockIU _mockIU_2 = new MockIU("com.google.guava", _createOSGi_2);
            _xifexpression = CollectionLiterals.<IInstallableUnit>newImmutableList(_mockIU, _mockIU_1, _mockIU_2);
          } else {
            return CollectionLiterals.<IInstallableUnit>emptyList();
          }
          return _xifexpression;
        }
      });
      NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
      targetDef.resolve(_mockMetadataRepositoryManager, _nullProgressMonitor);
      String _name = targetDef.getName();
      Assert.assertEquals("TP1", _name);
      List<ResolvedLocation> _locations = targetDef.getLocations();
      int _size = _locations.size();
      Assert.assertEquals(1, _size);
      List<ResolvedLocation> _locations_1 = targetDef.getLocations();
      final Function1<ResolvedLocation, List<String>> _function = new Function1<ResolvedLocation, List<String>>() {
        public List<String> apply(final ResolvedLocation it) {
          List<IInstallableUnit> _resolvedIUs = it.getResolvedIUs();
          final Function1<IInstallableUnit, String> _function = new Function1<IInstallableUnit, String>() {
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
      final Function1<ResolvedLocation, List<Version>> _function_1 = new Function1<ResolvedLocation, List<Version>>() {
        public List<Version> apply(final ResolvedLocation it) {
          List<IInstallableUnit> _resolvedIUs = it.getResolvedIUs();
          final Function1<IInstallableUnit, Version> _function = new Function1<IInstallableUnit, Version>() {
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
      Assert.assertEquals("12.0.0", _string);
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
      final ResolvedTargetPlatform targetDef = ResolvedTargetPlatform.create(tp1, this.indexBuilder);
      MockMetadataRepositoryManager _mockMetadataRepositoryManager = new MockMetadataRepositoryManager(new IQueryResultProvider<IInstallableUnit>() {
        public List<IInstallableUnit> listIUs(final URI location) {
          List<IInstallableUnit> _xifexpression = null;
          String _string = location.toString();
          boolean _equals = "http://download.eclipse.org/tools/orbit/downloads/drops/R20130517111416/repository/".equals(_string);
          if (_equals) {
            Version _createOSGi = Version.createOSGi(10, 0, 0);
            MockIU _mockIU = new MockIU("com.google.guava", _createOSGi);
            Version _createOSGi_1 = Version.createOSGi(11, 0, 2);
            MockIU _mockIU_1 = new MockIU("com.google.guava", _createOSGi_1);
            Version _createOSGi_2 = Version.createOSGi(12, 0, 0);
            MockIU _mockIU_2 = new MockIU("com.google.guava", _createOSGi_2);
            _xifexpression = CollectionLiterals.<IInstallableUnit>newImmutableList(_mockIU, _mockIU_1, _mockIU_2);
          } else {
            return CollectionLiterals.<IInstallableUnit>emptyList();
          }
          return _xifexpression;
        }
      });
      NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
      targetDef.resolve(_mockMetadataRepositoryManager, _nullProgressMonitor);
      String _name = targetDef.getName();
      Assert.assertEquals("TP1", _name);
      List<ResolvedLocation> _locations = targetDef.getLocations();
      int _size = _locations.size();
      Assert.assertEquals(1, _size);
      List<ResolvedLocation> _locations_1 = targetDef.getLocations();
      final Function1<ResolvedLocation, List<String>> _function = new Function1<ResolvedLocation, List<String>>() {
        public List<String> apply(final ResolvedLocation it) {
          List<IInstallableUnit> _resolvedIUs = it.getResolvedIUs();
          final Function1<IInstallableUnit, String> _function = new Function1<IInstallableUnit, String>() {
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
      final Function1<ResolvedLocation, List<Version>> _function_1 = new Function1<ResolvedLocation, List<Version>>() {
        public List<Version> apply(final ResolvedLocation it) {
          List<IInstallableUnit> _resolvedIUs = it.getResolvedIUs();
          final Function1<IInstallableUnit, Version> _function = new Function1<IInstallableUnit, Version>() {
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
      Assert.assertEquals("12.0.0", _string);
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
      final ResolvedTargetPlatform targetDef = ResolvedTargetPlatform.create(tp1, this.indexBuilder);
      MockMetadataRepositoryManager _mockMetadataRepositoryManager = new MockMetadataRepositoryManager(new IQueryResultProvider<IInstallableUnit>() {
        public List<IInstallableUnit> listIUs(final URI location) {
          List<IInstallableUnit> _xifexpression = null;
          String _string = location.toString();
          boolean _equals = "http://download.eclipse.org/tools/orbit/downloads/drops/R20130517111416/repository/".equals(_string);
          if (_equals) {
            Version _createOSGi = Version.createOSGi(10, 0, 0);
            MockIU _mockIU = new MockIU("com.google.guava", _createOSGi);
            Version _createOSGi_1 = Version.createOSGi(11, 0, 2);
            MockIU _mockIU_1 = new MockIU("com.google.guava", _createOSGi_1);
            Version _createOSGi_2 = Version.createOSGi(12, 0, 0);
            MockIU _mockIU_2 = new MockIU("com.google.guava", _createOSGi_2);
            _xifexpression = CollectionLiterals.<IInstallableUnit>newImmutableList(_mockIU, _mockIU_1, _mockIU_2);
          } else {
            return CollectionLiterals.<IInstallableUnit>emptyList();
          }
          return _xifexpression;
        }
      });
      NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
      targetDef.resolve(_mockMetadataRepositoryManager, _nullProgressMonitor);
      String _name = targetDef.getName();
      Assert.assertEquals("TP1", _name);
      List<ResolvedLocation> _locations = targetDef.getLocations();
      int _size = _locations.size();
      Assert.assertEquals(1, _size);
      List<ResolvedLocation> _locations_1 = targetDef.getLocations();
      final Function1<ResolvedLocation, List<String>> _function = new Function1<ResolvedLocation, List<String>>() {
        public List<String> apply(final ResolvedLocation it) {
          List<IInstallableUnit> _resolvedIUs = it.getResolvedIUs();
          final Function1<IInstallableUnit, String> _function = new Function1<IInstallableUnit, String>() {
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
      final Function1<ResolvedLocation, List<Version>> _function_1 = new Function1<ResolvedLocation, List<Version>>() {
        public List<Version> apply(final ResolvedLocation it) {
          List<IInstallableUnit> _resolvedIUs = it.getResolvedIUs();
          final Function1<IInstallableUnit, Version> _function = new Function1<IInstallableUnit, Version>() {
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
      Assert.assertEquals("11.0.2", _string);
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
      final ResolvedTargetPlatform targetDef = ResolvedTargetPlatform.create(tp1, this.indexBuilder);
      MockMetadataRepositoryManager _mockMetadataRepositoryManager = new MockMetadataRepositoryManager(new IQueryResultProvider<IInstallableUnit>() {
        public List<IInstallableUnit> listIUs(final URI location) {
          List<IInstallableUnit> _xifexpression = null;
          String _string = location.toString();
          boolean _equals = "http://download.eclipse.org/tools/orbit/downloads/drops/R20130517111416/repository/".equals(_string);
          if (_equals) {
            Version _createOSGi = Version.createOSGi(10, 0, 0);
            MockIU _mockIU = new MockIU("com.google.guava", _createOSGi);
            Version _createOSGi_1 = Version.createOSGi(11, 0, 2);
            MockIU _mockIU_1 = new MockIU("com.google.guava", _createOSGi_1);
            Version _createOSGi_2 = Version.createOSGi(12, 0, 0);
            MockIU _mockIU_2 = new MockIU("com.google.guava", _createOSGi_2);
            _xifexpression = CollectionLiterals.<IInstallableUnit>newImmutableList(_mockIU, _mockIU_1, _mockIU_2);
          } else {
            return CollectionLiterals.<IInstallableUnit>emptyList();
          }
          return _xifexpression;
        }
      });
      NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
      targetDef.resolve(_mockMetadataRepositoryManager, _nullProgressMonitor);
      String _name = targetDef.getName();
      Assert.assertEquals("TP1", _name);
      List<ResolvedLocation> _locations = targetDef.getLocations();
      int _size = _locations.size();
      Assert.assertEquals(1, _size);
      List<ResolvedLocation> _locations_1 = targetDef.getLocations();
      final Function1<ResolvedLocation, List<String>> _function = new Function1<ResolvedLocation, List<String>>() {
        public List<String> apply(final ResolvedLocation it) {
          List<IInstallableUnit> _resolvedIUs = it.getResolvedIUs();
          final Function1<IInstallableUnit, String> _function = new Function1<IInstallableUnit, String>() {
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
      final Function1<ResolvedLocation, List<Version>> _function_1 = new Function1<ResolvedLocation, List<Version>>() {
        public List<Version> apply(final ResolvedLocation it) {
          List<IInstallableUnit> _resolvedIUs = it.getResolvedIUs();
          final Function1<IInstallableUnit, Version> _function = new Function1<IInstallableUnit, Version>() {
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
      Assert.assertEquals("11.0.2", _string);
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
      final ResolvedTargetPlatform targetDef = ResolvedTargetPlatform.create(tp1, this.indexBuilder);
      MockMetadataRepositoryManager _mockMetadataRepositoryManager = new MockMetadataRepositoryManager(new IQueryResultProvider<IInstallableUnit>() {
        public List<IInstallableUnit> listIUs(final URI location) {
          List<IInstallableUnit> _xifexpression = null;
          String _string = location.toString();
          boolean _equals = "http://download.eclipse.org/tools/orbit/downloads/drops/R20130517111416/repository/".equals(_string);
          if (_equals) {
            Version _createOSGi = Version.createOSGi(10, 0, 0);
            MockIU _mockIU = new MockIU("com.google.guava", _createOSGi);
            Version _createOSGi_1 = Version.createOSGi(11, 0, 2);
            MockIU _mockIU_1 = new MockIU("com.google.guava", _createOSGi_1);
            Version _createOSGi_2 = Version.createOSGi(12, 0, 0);
            MockIU _mockIU_2 = new MockIU("com.google.guava", _createOSGi_2);
            _xifexpression = CollectionLiterals.<IInstallableUnit>newImmutableList(_mockIU, _mockIU_1, _mockIU_2);
          } else {
            return CollectionLiterals.<IInstallableUnit>emptyList();
          }
          return _xifexpression;
        }
      });
      NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
      targetDef.resolve(_mockMetadataRepositoryManager, _nullProgressMonitor);
      String _name = targetDef.getName();
      Assert.assertEquals("TP1", _name);
      List<ResolvedLocation> _locations = targetDef.getLocations();
      int _size = _locations.size();
      Assert.assertEquals(1, _size);
      List<ResolvedLocation> _locations_1 = targetDef.getLocations();
      final Function1<ResolvedLocation, List<String>> _function = new Function1<ResolvedLocation, List<String>>() {
        public List<String> apply(final ResolvedLocation it) {
          List<IInstallableUnit> _resolvedIUs = it.getResolvedIUs();
          final Function1<IInstallableUnit, String> _function = new Function1<IInstallableUnit, String>() {
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
      final Function1<ResolvedLocation, List<Version>> _function_1 = new Function1<ResolvedLocation, List<Version>>() {
        public List<Version> apply(final ResolvedLocation it) {
          List<IInstallableUnit> _resolvedIUs = it.getResolvedIUs();
          final Function1<IInstallableUnit, Version> _function = new Function1<IInstallableUnit, Version>() {
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
      Assert.assertEquals("12.0.0", _string);
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
      final ResolvedTargetPlatform targetDef = ResolvedTargetPlatform.create(tp1, this.indexBuilder);
      MockMetadataRepositoryManager _mockMetadataRepositoryManager = new MockMetadataRepositoryManager(new IQueryResultProvider<IInstallableUnit>() {
        public List<IInstallableUnit> listIUs(final URI location) {
          List<IInstallableUnit> _xifexpression = null;
          String _string = location.toString();
          boolean _equals = "http://download.eclipse.org/tools/orbit/downloads/drops/R20130517111416/repository/".equals(_string);
          if (_equals) {
            Version _createOSGi = Version.createOSGi(10, 0, 0);
            MockIU _mockIU = new MockIU("com.google.guava", _createOSGi);
            Version _createOSGi_1 = Version.createOSGi(11, 0, 2);
            MockIU _mockIU_1 = new MockIU("com.google.guava", _createOSGi_1);
            Version _createOSGi_2 = Version.createOSGi(12, 0, 0);
            MockIU _mockIU_2 = new MockIU("com.google.guava", _createOSGi_2);
            _xifexpression = CollectionLiterals.<IInstallableUnit>newImmutableList(_mockIU, _mockIU_1, _mockIU_2);
          } else {
            return CollectionLiterals.<IInstallableUnit>emptyList();
          }
          return _xifexpression;
        }
      });
      NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
      targetDef.resolve(_mockMetadataRepositoryManager, _nullProgressMonitor);
      String _name = targetDef.getName();
      Assert.assertEquals("TP1", _name);
      List<ResolvedLocation> _locations = targetDef.getLocations();
      int _size = _locations.size();
      Assert.assertEquals(1, _size);
      List<ResolvedLocation> _locations_1 = targetDef.getLocations();
      final Function1<ResolvedLocation, List<String>> _function = new Function1<ResolvedLocation, List<String>>() {
        public List<String> apply(final ResolvedLocation it) {
          List<IInstallableUnit> _resolvedIUs = it.getResolvedIUs();
          final Function1<IInstallableUnit, String> _function = new Function1<IInstallableUnit, String>() {
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
      final Function1<ResolvedLocation, List<Version>> _function_1 = new Function1<ResolvedLocation, List<Version>>() {
        public List<Version> apply(final ResolvedLocation it) {
          List<IInstallableUnit> _resolvedIUs = it.getResolvedIUs();
          final Function1<IInstallableUnit, Version> _function = new Function1<IInstallableUnit, Version>() {
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
      Assert.assertEquals("11.0.2", _string);
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
      final ResolvedTargetPlatform targetDef = ResolvedTargetPlatform.create(tp1, this.indexBuilder);
      MockMetadataRepositoryManager _mockMetadataRepositoryManager = new MockMetadataRepositoryManager(new IQueryResultProvider<IInstallableUnit>() {
        public List<IInstallableUnit> listIUs(final URI location) {
          List<IInstallableUnit> _xifexpression = null;
          String _string = location.toString();
          boolean _equals = "http://download.eclipse.org/tools/orbit/downloads/drops/R20130517111416/repository/".equals(_string);
          if (_equals) {
            Version _createOSGi = Version.createOSGi(10, 0, 0);
            MockIU _mockIU = new MockIU("com.google.guava", _createOSGi);
            Version _createOSGi_1 = Version.createOSGi(11, 0, 2);
            MockIU _mockIU_1 = new MockIU("com.google.guava", _createOSGi_1);
            Version _createOSGi_2 = Version.createOSGi(12, 0, 0);
            MockIU _mockIU_2 = new MockIU("com.google.guava", _createOSGi_2);
            _xifexpression = CollectionLiterals.<IInstallableUnit>newImmutableList(_mockIU, _mockIU_1, _mockIU_2);
          } else {
            return CollectionLiterals.<IInstallableUnit>emptyList();
          }
          return _xifexpression;
        }
      });
      NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
      targetDef.resolve(_mockMetadataRepositoryManager, _nullProgressMonitor);
      String _name = targetDef.getName();
      Assert.assertEquals("TP1", _name);
      List<ResolvedLocation> _locations = targetDef.getLocations();
      int _size = _locations.size();
      Assert.assertEquals(1, _size);
      List<ResolvedLocation> _locations_1 = targetDef.getLocations();
      final Function1<ResolvedLocation, List<String>> _function = new Function1<ResolvedLocation, List<String>>() {
        public List<String> apply(final ResolvedLocation it) {
          List<IInstallableUnit> _resolvedIUs = it.getResolvedIUs();
          final Function1<IInstallableUnit, String> _function = new Function1<IInstallableUnit, String>() {
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
      final Function1<ResolvedLocation, List<Version>> _function_1 = new Function1<ResolvedLocation, List<Version>>() {
        public List<Version> apply(final ResolvedLocation it) {
          List<IInstallableUnit> _resolvedIUs = it.getResolvedIUs();
          final Function1<IInstallableUnit, Version> _function = new Function1<IInstallableUnit, Version>() {
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
      Assert.assertEquals("12.0.0", _string);
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
      final ResolvedTargetPlatform targetDef = ResolvedTargetPlatform.create(tp1, this.indexBuilder);
      MockMetadataRepositoryManager _mockMetadataRepositoryManager = new MockMetadataRepositoryManager(new IQueryResultProvider<IInstallableUnit>() {
        public List<IInstallableUnit> listIUs(final URI location) {
          List<IInstallableUnit> _xifexpression = null;
          String _string = location.toString();
          boolean _equals = "http://download.eclipse.org/tools/orbit/downloads/drops/R20130517111416/repository/".equals(_string);
          if (_equals) {
            Version _createOSGi = Version.createOSGi(10, 0, 0);
            MockIU _mockIU = new MockIU("com.google.guava", _createOSGi);
            Version _createOSGi_1 = Version.createOSGi(11, 0, 2);
            MockIU _mockIU_1 = new MockIU("com.google.guava", _createOSGi_1);
            Version _createOSGi_2 = Version.createOSGi(12, 0, 0);
            MockIU _mockIU_2 = new MockIU("com.google.guava", _createOSGi_2);
            _xifexpression = CollectionLiterals.<IInstallableUnit>newImmutableList(_mockIU, _mockIU_1, _mockIU_2);
          } else {
            return CollectionLiterals.<IInstallableUnit>emptyList();
          }
          return _xifexpression;
        }
      });
      NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
      targetDef.resolve(_mockMetadataRepositoryManager, _nullProgressMonitor);
      String _name = targetDef.getName();
      Assert.assertEquals("TP1", _name);
      List<ResolvedLocation> _locations = targetDef.getLocations();
      int _size = _locations.size();
      Assert.assertEquals(1, _size);
      List<ResolvedLocation> _locations_1 = targetDef.getLocations();
      final Function1<ResolvedLocation, List<String>> _function = new Function1<ResolvedLocation, List<String>>() {
        public List<String> apply(final ResolvedLocation it) {
          List<IInstallableUnit> _resolvedIUs = it.getResolvedIUs();
          final Function1<IInstallableUnit, String> _function = new Function1<IInstallableUnit, String>() {
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
      final Function1<ResolvedLocation, List<Version>> _function_1 = new Function1<ResolvedLocation, List<Version>>() {
        public List<Version> apply(final ResolvedLocation it) {
          List<IInstallableUnit> _resolvedIUs = it.getResolvedIUs();
          final Function1<IInstallableUnit, Version> _function = new Function1<IInstallableUnit, Version>() {
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
      Assert.assertEquals("11.0.2", _string);
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
      final ResolvedTargetPlatform targetDef = ResolvedTargetPlatform.create(tp1, this.indexBuilder);
      MockMetadataRepositoryManager _mockMetadataRepositoryManager = new MockMetadataRepositoryManager(new IQueryResultProvider<IInstallableUnit>() {
        public List<IInstallableUnit> listIUs(final URI location) {
          List<IInstallableUnit> _xifexpression = null;
          String _string = location.toString();
          boolean _equals = "http://download.eclipse.org/tools/orbit/downloads/drops/R20130517111416/repository/".equals(_string);
          if (_equals) {
            Version _createOSGi = Version.createOSGi(10, 0, 0);
            MockIU _mockIU = new MockIU("com.google.guava", _createOSGi);
            Version _createOSGi_1 = Version.createOSGi(11, 0, 2);
            MockIU _mockIU_1 = new MockIU("com.google.guava", _createOSGi_1);
            Version _createOSGi_2 = Version.createOSGi(12, 0, 0);
            MockIU _mockIU_2 = new MockIU("com.google.guava", _createOSGi_2);
            _xifexpression = CollectionLiterals.<IInstallableUnit>newImmutableList(_mockIU, _mockIU_1, _mockIU_2);
          } else {
            return CollectionLiterals.<IInstallableUnit>emptyList();
          }
          return _xifexpression;
        }
      });
      NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
      targetDef.resolve(_mockMetadataRepositoryManager, _nullProgressMonitor);
      String _name = targetDef.getName();
      Assert.assertEquals("TP1", _name);
      List<ResolvedLocation> _locations = targetDef.getLocations();
      int _size = _locations.size();
      Assert.assertEquals(1, _size);
      List<ResolvedLocation> _locations_1 = targetDef.getLocations();
      final Function1<ResolvedLocation, List<String>> _function = new Function1<ResolvedLocation, List<String>>() {
        public List<String> apply(final ResolvedLocation it) {
          List<IInstallableUnit> _resolvedIUs = it.getResolvedIUs();
          final Function1<IInstallableUnit, String> _function = new Function1<IInstallableUnit, String>() {
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
      final Function1<ResolvedLocation, List<Version>> _function_1 = new Function1<ResolvedLocation, List<Version>>() {
        public List<Version> apply(final ResolvedLocation it) {
          List<IInstallableUnit> _resolvedIUs = it.getResolvedIUs();
          final Function1<IInstallableUnit, Version> _function = new Function1<IInstallableUnit, Version>() {
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
      Assert.assertEquals("12.0.0", _string);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testSource1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"TP1\"");
      _builder.newLine();
      _builder.append("with source");
      _builder.newLine();
      _builder.append("location \"http://download.eclipse.org/tools/orbit/downloads/drops/R20130517111416/repository/\" {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("com.google.guava");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final TargetPlatform tp1 = this.parser.parse(_builder);
      final ResolvedTargetPlatform targetDef = ResolvedTargetPlatform.create(tp1, this.indexBuilder);
      MockMetadataRepositoryManager _mockMetadataRepositoryManager = new MockMetadataRepositoryManager(new IQueryResultProvider<IInstallableUnit>() {
        public List<IInstallableUnit> listIUs(final URI location) {
          List<IInstallableUnit> _xifexpression = null;
          String _string = location.toString();
          boolean _equals = "http://download.eclipse.org/tools/orbit/downloads/drops/R20130517111416/repository/".equals(_string);
          if (_equals) {
            Version _createOSGi = Version.createOSGi(10, 0, 0);
            MockIU _mockIU = new MockIU("com.google.guava", _createOSGi);
            Version _createOSGi_1 = Version.createOSGi(10, 0, 0);
            MockIU _mockIU_1 = new MockIU("com.google.guava.source", _createOSGi_1);
            _xifexpression = CollectionLiterals.<IInstallableUnit>newImmutableList(_mockIU, _mockIU_1);
          } else {
            return CollectionLiterals.<IInstallableUnit>emptyList();
          }
          return _xifexpression;
        }
      });
      NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
      targetDef.resolve(_mockMetadataRepositoryManager, _nullProgressMonitor);
      String _name = targetDef.getName();
      Assert.assertEquals("TP1", _name);
      List<ResolvedLocation> _locations = targetDef.getLocations();
      int _size = _locations.size();
      Assert.assertEquals(1, _size);
      List<ResolvedLocation> _locations_1 = targetDef.getLocations();
      final Function1<ResolvedLocation, List<String>> _function = new Function1<ResolvedLocation, List<String>>() {
        public List<String> apply(final ResolvedLocation it) {
          List<IInstallableUnit> _resolvedIUs = it.getResolvedIUs();
          final Function1<IInstallableUnit, String> _function = new Function1<IInstallableUnit, String>() {
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
      Assert.assertEquals("com.google.guava", _head);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testSource2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"TP1\"");
      _builder.newLine();
      _builder.append("with source");
      _builder.newLine();
      _builder.append("location \"http://download.eclipse.org/tools/orbit/downloads/drops/R20130517111416/repository/\" {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("com.google.guava");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("com.google.guava.^source");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final TargetPlatform tp1 = this.parser.parse(_builder);
      final ResolvedTargetPlatform targetDef = ResolvedTargetPlatform.create(tp1, this.indexBuilder);
      MockMetadataRepositoryManager _mockMetadataRepositoryManager = new MockMetadataRepositoryManager(new IQueryResultProvider<IInstallableUnit>() {
        public List<IInstallableUnit> listIUs(final URI location) {
          List<IInstallableUnit> _xifexpression = null;
          String _string = location.toString();
          boolean _equals = "http://download.eclipse.org/tools/orbit/downloads/drops/R20130517111416/repository/".equals(_string);
          if (_equals) {
            Version _createOSGi = Version.createOSGi(10, 0, 0);
            MockIU _mockIU = new MockIU("com.google.guava", _createOSGi);
            Version _createOSGi_1 = Version.createOSGi(10, 0, 0);
            MockIU _mockIU_1 = new MockIU("com.google.guava.source", _createOSGi_1);
            _xifexpression = CollectionLiterals.<IInstallableUnit>newImmutableList(_mockIU, _mockIU_1);
          } else {
            return CollectionLiterals.<IInstallableUnit>emptyList();
          }
          return _xifexpression;
        }
      });
      NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
      targetDef.resolve(_mockMetadataRepositoryManager, _nullProgressMonitor);
      String _name = targetDef.getName();
      Assert.assertEquals("TP1", _name);
      List<ResolvedLocation> _locations = targetDef.getLocations();
      int _size = _locations.size();
      Assert.assertEquals(1, _size);
      List<ResolvedLocation> _locations_1 = targetDef.getLocations();
      final Function1<ResolvedLocation, List<String>> _function = new Function1<ResolvedLocation, List<String>>() {
        public List<String> apply(final ResolvedLocation it) {
          List<IInstallableUnit> _resolvedIUs = it.getResolvedIUs();
          final Function1<IInstallableUnit, String> _function = new Function1<IInstallableUnit, String>() {
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
      Assert.assertEquals("com.google.guava", _head);
      Object _get = ids[1];
      Assert.assertEquals("com.google.guava.source", _get);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testSource3() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"TP1\"");
      _builder.newLine();
      _builder.append("with source");
      _builder.newLine();
      _builder.append("location \"http://download.eclipse.org/modeling/emf/compare/updates/releases/2.1/R201310031412/\" {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("org.eclipse.emf.compare.rcp.ui.feature.group");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final TargetPlatform tp1 = this.parser.parse(_builder);
      final ResolvedTargetPlatform targetDef = ResolvedTargetPlatform.create(tp1, this.indexBuilder);
      MockMetadataRepositoryManager _mockMetadataRepositoryManager = new MockMetadataRepositoryManager(new IQueryResultProvider<IInstallableUnit>() {
        public List<IInstallableUnit> listIUs(final URI location) {
          List<IInstallableUnit> _xifexpression = null;
          String _string = location.toString();
          boolean _equals = "http://download.eclipse.org/modeling/emf/compare/updates/releases/2.1/R201310031412/".equals(_string);
          if (_equals) {
            Version _createOSGi = Version.createOSGi(10, 0, 0);
            MockIU _createFeature = MockIU.createFeature("org.eclipse.emf.compare.rcp.ui.feature.group", _createOSGi);
            Version _createOSGi_1 = Version.createOSGi(10, 0, 0);
            MockIU _createFeature_1 = MockIU.createFeature("org.eclipse.emf.compare.rcp.ui.source.feature.group", _createOSGi_1);
            _xifexpression = CollectionLiterals.<IInstallableUnit>newImmutableList(_createFeature, _createFeature_1);
          } else {
            return CollectionLiterals.<IInstallableUnit>emptyList();
          }
          return _xifexpression;
        }
      });
      NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
      targetDef.resolve(_mockMetadataRepositoryManager, _nullProgressMonitor);
      String _name = targetDef.getName();
      Assert.assertEquals("TP1", _name);
      List<ResolvedLocation> _locations = targetDef.getLocations();
      int _size = _locations.size();
      Assert.assertEquals(1, _size);
      List<ResolvedLocation> _locations_1 = targetDef.getLocations();
      final Function1<ResolvedLocation, List<String>> _function = new Function1<ResolvedLocation, List<String>>() {
        public List<String> apply(final ResolvedLocation it) {
          List<IInstallableUnit> _resolvedIUs = it.getResolvedIUs();
          final Function1<IInstallableUnit, String> _function = new Function1<IInstallableUnit, String>() {
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
      Assert.assertEquals("org.eclipse.emf.compare.rcp.ui.feature.group", _head);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testSource4() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"TP1\"");
      _builder.newLine();
      _builder.append("with source");
      _builder.newLine();
      _builder.append("location \"http://download.eclipse.org/modeling/emf/compare/updates/releases/2.1/R201310031412/\" {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("org.eclipse.emf.compare.rcp.ui.feature.group");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("org.eclipse.emf.compare.rcp.ui.^source.feature.group");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final TargetPlatform tp1 = this.parser.parse(_builder);
      final ResolvedTargetPlatform targetDef = ResolvedTargetPlatform.create(tp1, this.indexBuilder);
      MockMetadataRepositoryManager _mockMetadataRepositoryManager = new MockMetadataRepositoryManager(new IQueryResultProvider<IInstallableUnit>() {
        public List<IInstallableUnit> listIUs(final URI location) {
          List<IInstallableUnit> _xifexpression = null;
          String _string = location.toString();
          boolean _equals = "http://download.eclipse.org/modeling/emf/compare/updates/releases/2.1/R201310031412/".equals(_string);
          if (_equals) {
            Version _createOSGi = Version.createOSGi(10, 0, 0);
            MockIU _createFeature = MockIU.createFeature("org.eclipse.emf.compare.rcp.ui.feature.group", _createOSGi);
            Version _createOSGi_1 = Version.createOSGi(10, 0, 0);
            MockIU _createFeature_1 = MockIU.createFeature("org.eclipse.emf.compare.rcp.ui.source.feature.group", _createOSGi_1);
            _xifexpression = CollectionLiterals.<IInstallableUnit>newImmutableList(_createFeature, _createFeature_1);
          } else {
            return CollectionLiterals.<IInstallableUnit>emptyList();
          }
          return _xifexpression;
        }
      });
      NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
      targetDef.resolve(_mockMetadataRepositoryManager, _nullProgressMonitor);
      String _name = targetDef.getName();
      Assert.assertEquals("TP1", _name);
      List<ResolvedLocation> _locations = targetDef.getLocations();
      int _size = _locations.size();
      Assert.assertEquals(1, _size);
      List<ResolvedLocation> _locations_1 = targetDef.getLocations();
      final Function1<ResolvedLocation, List<String>> _function = new Function1<ResolvedLocation, List<String>>() {
        public List<String> apply(final ResolvedLocation it) {
          List<IInstallableUnit> _resolvedIUs = it.getResolvedIUs();
          final Function1<IInstallableUnit, String> _function = new Function1<IInstallableUnit, String>() {
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
      Assert.assertEquals("org.eclipse.emf.compare.rcp.ui.source.feature.group", _get);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testLocationOrder() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"Kepler 4.3 SDK\"");
      _builder.newLine();
      _builder.append("location \"http://download.eclipse.org/egit/updates-3.3\"");
      _builder.newLine();
      _builder.append("location \"http://download.eclipse.org/modeling/emf/emf/updates/2.9.x/core/R201402030812/\"");
      _builder.newLine();
      _builder.append("location \"http://download.eclipse.org/modeling/emf/compare/updates/releases/2.1/R201310031412/\"");
      _builder.newLine();
      _builder.append("location \"http://download.eclipse.org/tools/orbit/downloads/drops/R20130517111416/repository/\"");
      _builder.newLine();
      final TargetPlatform o = this.parser.parse(_builder);
      final ResolvedTargetPlatform targetDef = ResolvedTargetPlatform.create(o, this.indexBuilder);
      MockMetadataRepositoryManager _mockMetadataRepositoryManager = new MockMetadataRepositoryManager(new IQueryResultProvider<IInstallableUnit>() {
        public List<IInstallableUnit> listIUs(final URI location) {
          return CollectionLiterals.<IInstallableUnit>emptyList();
        }
      });
      NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
      targetDef.resolve(_mockMetadataRepositoryManager, _nullProgressMonitor);
      List<ResolvedLocation> _locations = targetDef.getLocations();
      ResolvedLocation _get = _locations.get(0);
      URI _uRI = _get.getURI();
      String _string = _uRI.toString();
      Assert.assertEquals("http://download.eclipse.org/egit/updates-3.3", _string);
      List<ResolvedLocation> _locations_1 = targetDef.getLocations();
      ResolvedLocation _get_1 = _locations_1.get(1);
      URI _uRI_1 = _get_1.getURI();
      String _string_1 = _uRI_1.toString();
      Assert.assertEquals("http://download.eclipse.org/modeling/emf/emf/updates/2.9.x/core/R201402030812/", _string_1);
      List<ResolvedLocation> _locations_2 = targetDef.getLocations();
      ResolvedLocation _get_2 = _locations_2.get(2);
      URI _uRI_2 = _get_2.getURI();
      String _string_2 = _uRI_2.toString();
      Assert.assertEquals("http://download.eclipse.org/modeling/emf/compare/updates/releases/2.1/R201310031412/", _string_2);
      List<ResolvedLocation> _locations_3 = targetDef.getLocations();
      ResolvedLocation _get_3 = _locations_3.get(3);
      URI _uRI_3 = _get_3.getURI();
      String _string_3 = _uRI_3.toString();
      Assert.assertEquals("http://download.eclipse.org/tools/orbit/downloads/drops/R20130517111416/repository/", _string_3);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testLocationOrderWithIncludes1() {
    try {
      final XtextResourceSet resourceSet = this.resourceSetProvider.get();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"Kepler 4.3 SDK\"");
      _builder.newLine();
      _builder.append("include \"tp2.tpd\"");
      _builder.newLine();
      _builder.append("location \"http://download.eclipse.org/modeling/emf/emf/updates/2.9.x/core/R201402030812/\"");
      _builder.newLine();
      _builder.append("location \"http://download.eclipse.org/modeling/emf/compare/updates/releases/2.1/R201310031412/\"");
      _builder.newLine();
      _builder.append("location \"http://download.eclipse.org/tools/orbit/downloads/drops/R20130517111416/repository/\"");
      _builder.newLine();
      org.eclipse.emf.common.util.URI _createURI = org.eclipse.emf.common.util.URI.createURI("tmp:/tp1.tpd");
      final TargetPlatform tp1 = this.parser.parse(_builder, _createURI, resourceSet);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("target \"TP2\"");
      _builder_1.newLine();
      _builder_1.append("location \"http://mbarbero.github.io/fr.obeo.releng.targetplatform/p2/latest/\"");
      _builder_1.newLine();
      _builder_1.append("location \"http://download.eclipse.org/egit/updates-3.3\"");
      _builder_1.newLine();
      _builder_1.append("location \"http://download.eclipse.org/sirius/updates/releases/0.9.0/kepler\"");
      _builder_1.newLine();
      org.eclipse.emf.common.util.URI _createURI_1 = org.eclipse.emf.common.util.URI.createURI("tmp:/tp2.tpd");
      this.parser.parse(_builder_1, _createURI_1, resourceSet);
      final ResolvedTargetPlatform targetDef = ResolvedTargetPlatform.create(tp1, this.indexBuilder);
      MockMetadataRepositoryManager _mockMetadataRepositoryManager = new MockMetadataRepositoryManager(new IQueryResultProvider<IInstallableUnit>() {
        public List<IInstallableUnit> listIUs(final URI location) {
          return CollectionLiterals.<IInstallableUnit>emptyList();
        }
      });
      NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
      targetDef.resolve(_mockMetadataRepositoryManager, _nullProgressMonitor);
      List<ResolvedLocation> _locations = targetDef.getLocations();
      ResolvedLocation _get = _locations.get(0);
      URI _uRI = _get.getURI();
      String _string = _uRI.toString();
      Assert.assertEquals("http://mbarbero.github.io/fr.obeo.releng.targetplatform/p2/latest/", _string);
      List<ResolvedLocation> _locations_1 = targetDef.getLocations();
      ResolvedLocation _get_1 = _locations_1.get(1);
      URI _uRI_1 = _get_1.getURI();
      String _string_1 = _uRI_1.toString();
      Assert.assertEquals("http://download.eclipse.org/egit/updates-3.3", _string_1);
      List<ResolvedLocation> _locations_2 = targetDef.getLocations();
      ResolvedLocation _get_2 = _locations_2.get(2);
      URI _uRI_2 = _get_2.getURI();
      String _string_2 = _uRI_2.toString();
      Assert.assertEquals("http://download.eclipse.org/sirius/updates/releases/0.9.0/kepler", _string_2);
      List<ResolvedLocation> _locations_3 = targetDef.getLocations();
      ResolvedLocation _get_3 = _locations_3.get(3);
      URI _uRI_3 = _get_3.getURI();
      String _string_3 = _uRI_3.toString();
      Assert.assertEquals("http://download.eclipse.org/modeling/emf/emf/updates/2.9.x/core/R201402030812/", _string_3);
      List<ResolvedLocation> _locations_4 = targetDef.getLocations();
      ResolvedLocation _get_4 = _locations_4.get(4);
      URI _uRI_4 = _get_4.getURI();
      String _string_4 = _uRI_4.toString();
      Assert.assertEquals("http://download.eclipse.org/modeling/emf/compare/updates/releases/2.1/R201310031412/", _string_4);
      List<ResolvedLocation> _locations_5 = targetDef.getLocations();
      ResolvedLocation _get_5 = _locations_5.get(5);
      URI _uRI_5 = _get_5.getURI();
      String _string_5 = _uRI_5.toString();
      Assert.assertEquals("http://download.eclipse.org/tools/orbit/downloads/drops/R20130517111416/repository/", _string_5);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testLocationOrderWithIncludes2() {
    try {
      final XtextResourceSet resourceSet = this.resourceSetProvider.get();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"Kepler 4.3 SDK\"");
      _builder.newLine();
      _builder.append("include \"tp2.tpd\"");
      _builder.newLine();
      _builder.append("location \"http://download.eclipse.org/modeling/emf/emf/updates/2.9.x/core/R201402030812/\"");
      _builder.newLine();
      _builder.append("location \"http://download.eclipse.org/modeling/emf/compare/updates/releases/2.1/R201310031412/\"");
      _builder.newLine();
      org.eclipse.emf.common.util.URI _createURI = org.eclipse.emf.common.util.URI.createURI("tmp:/tp1.tpd");
      final TargetPlatform tp1 = this.parser.parse(_builder, _createURI, resourceSet);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("target \"TP2\"");
      _builder_1.newLine();
      _builder_1.append("include \"tp3.tpd\"");
      _builder_1.newLine();
      _builder_1.append("location \"http://mbarbero.github.io/fr.obeo.releng.targetplatform/p2/latest/\"");
      _builder_1.newLine();
      _builder_1.append("location \"http://download.eclipse.org/egit/updates-3.3\"");
      _builder_1.newLine();
      org.eclipse.emf.common.util.URI _createURI_1 = org.eclipse.emf.common.util.URI.createURI("tmp:/tp2.tpd");
      this.parser.parse(_builder_1, _createURI_1, resourceSet);
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("target \"TP3\"");
      _builder_2.newLine();
      _builder_2.append("location \"http://download.eclipse.org/tools/orbit/downloads/drops/R20130517111416/repository/\"");
      _builder_2.newLine();
      _builder_2.append("location \"http://download.eclipse.org/sirius/updates/releases/0.9.0/kepler\"");
      _builder_2.newLine();
      org.eclipse.emf.common.util.URI _createURI_2 = org.eclipse.emf.common.util.URI.createURI("tmp:/tp3.tpd");
      this.parser.parse(_builder_2, _createURI_2, resourceSet);
      final ResolvedTargetPlatform targetDef = ResolvedTargetPlatform.create(tp1, this.indexBuilder);
      MockMetadataRepositoryManager _mockMetadataRepositoryManager = new MockMetadataRepositoryManager(new IQueryResultProvider<IInstallableUnit>() {
        public List<IInstallableUnit> listIUs(final URI location) {
          return CollectionLiterals.<IInstallableUnit>emptyList();
        }
      });
      NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
      targetDef.resolve(_mockMetadataRepositoryManager, _nullProgressMonitor);
      List<ResolvedLocation> _locations = targetDef.getLocations();
      ResolvedLocation _get = _locations.get(0);
      URI _uRI = _get.getURI();
      String _string = _uRI.toString();
      Assert.assertEquals("http://download.eclipse.org/tools/orbit/downloads/drops/R20130517111416/repository/", _string);
      List<ResolvedLocation> _locations_1 = targetDef.getLocations();
      ResolvedLocation _get_1 = _locations_1.get(1);
      URI _uRI_1 = _get_1.getURI();
      String _string_1 = _uRI_1.toString();
      Assert.assertEquals("http://download.eclipse.org/sirius/updates/releases/0.9.0/kepler", _string_1);
      List<ResolvedLocation> _locations_2 = targetDef.getLocations();
      ResolvedLocation _get_2 = _locations_2.get(2);
      URI _uRI_2 = _get_2.getURI();
      String _string_2 = _uRI_2.toString();
      Assert.assertEquals("http://mbarbero.github.io/fr.obeo.releng.targetplatform/p2/latest/", _string_2);
      List<ResolvedLocation> _locations_3 = targetDef.getLocations();
      ResolvedLocation _get_3 = _locations_3.get(3);
      URI _uRI_3 = _get_3.getURI();
      String _string_3 = _uRI_3.toString();
      Assert.assertEquals("http://download.eclipse.org/egit/updates-3.3", _string_3);
      List<ResolvedLocation> _locations_4 = targetDef.getLocations();
      ResolvedLocation _get_4 = _locations_4.get(4);
      URI _uRI_4 = _get_4.getURI();
      String _string_4 = _uRI_4.toString();
      Assert.assertEquals("http://download.eclipse.org/modeling/emf/emf/updates/2.9.x/core/R201402030812/", _string_4);
      List<ResolvedLocation> _locations_5 = targetDef.getLocations();
      ResolvedLocation _get_5 = _locations_5.get(5);
      URI _uRI_5 = _get_5.getURI();
      String _string_5 = _uRI_5.toString();
      Assert.assertEquals("http://download.eclipse.org/modeling/emf/compare/updates/releases/2.1/R201310031412/", _string_5);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testLocationOrderWithIncludes3() {
    try {
      final XtextResourceSet resourceSet = this.resourceSetProvider.get();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"Kepler 4.3 SDK\"");
      _builder.newLine();
      _builder.append("include \"tp3.tpd\"");
      _builder.newLine();
      _builder.append("include \"tp2.tpd\"");
      _builder.newLine();
      _builder.append("location \"http://download.eclipse.org/modeling/emf/emf/updates/2.9.x/core/R201402030812/\"");
      _builder.newLine();
      _builder.append("location \"http://download.eclipse.org/modeling/emf/compare/updates/releases/2.1/R201310031412/\"");
      _builder.newLine();
      org.eclipse.emf.common.util.URI _createURI = org.eclipse.emf.common.util.URI.createURI("tmp:/tp1.tpd");
      final TargetPlatform tp1 = this.parser.parse(_builder, _createURI, resourceSet);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("target \"TP2\"");
      _builder_1.newLine();
      _builder_1.append("location \"http://mbarbero.github.io/fr.obeo.releng.targetplatform/p2/latest/\"");
      _builder_1.newLine();
      _builder_1.append("location \"http://download.eclipse.org/egit/updates-3.3\"");
      _builder_1.newLine();
      org.eclipse.emf.common.util.URI _createURI_1 = org.eclipse.emf.common.util.URI.createURI("tmp:/tp2.tpd");
      this.parser.parse(_builder_1, _createURI_1, resourceSet);
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("target \"TP3\"");
      _builder_2.newLine();
      _builder_2.append("location \"http://download.eclipse.org/tools/orbit/downloads/drops/R20130517111416/repository/\"");
      _builder_2.newLine();
      _builder_2.append("location \"http://download.eclipse.org/sirius/updates/releases/0.9.0/kepler\"");
      _builder_2.newLine();
      org.eclipse.emf.common.util.URI _createURI_2 = org.eclipse.emf.common.util.URI.createURI("tmp:/tp3.tpd");
      this.parser.parse(_builder_2, _createURI_2, resourceSet);
      final ResolvedTargetPlatform targetDef = ResolvedTargetPlatform.create(tp1, this.indexBuilder);
      MockMetadataRepositoryManager _mockMetadataRepositoryManager = new MockMetadataRepositoryManager(new IQueryResultProvider<IInstallableUnit>() {
        public List<IInstallableUnit> listIUs(final URI location) {
          return CollectionLiterals.<IInstallableUnit>emptyList();
        }
      });
      NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
      targetDef.resolve(_mockMetadataRepositoryManager, _nullProgressMonitor);
      List<ResolvedLocation> _locations = targetDef.getLocations();
      ResolvedLocation _get = _locations.get(0);
      URI _uRI = _get.getURI();
      String _string = _uRI.toString();
      Assert.assertEquals("http://download.eclipse.org/tools/orbit/downloads/drops/R20130517111416/repository/", _string);
      List<ResolvedLocation> _locations_1 = targetDef.getLocations();
      ResolvedLocation _get_1 = _locations_1.get(1);
      URI _uRI_1 = _get_1.getURI();
      String _string_1 = _uRI_1.toString();
      Assert.assertEquals("http://download.eclipse.org/sirius/updates/releases/0.9.0/kepler", _string_1);
      List<ResolvedLocation> _locations_2 = targetDef.getLocations();
      ResolvedLocation _get_2 = _locations_2.get(2);
      URI _uRI_2 = _get_2.getURI();
      String _string_2 = _uRI_2.toString();
      Assert.assertEquals("http://mbarbero.github.io/fr.obeo.releng.targetplatform/p2/latest/", _string_2);
      List<ResolvedLocation> _locations_3 = targetDef.getLocations();
      ResolvedLocation _get_3 = _locations_3.get(3);
      URI _uRI_3 = _get_3.getURI();
      String _string_3 = _uRI_3.toString();
      Assert.assertEquals("http://download.eclipse.org/egit/updates-3.3", _string_3);
      List<ResolvedLocation> _locations_4 = targetDef.getLocations();
      ResolvedLocation _get_4 = _locations_4.get(4);
      URI _uRI_4 = _get_4.getURI();
      String _string_4 = _uRI_4.toString();
      Assert.assertEquals("http://download.eclipse.org/modeling/emf/emf/updates/2.9.x/core/R201402030812/", _string_4);
      List<ResolvedLocation> _locations_5 = targetDef.getLocations();
      ResolvedLocation _get_5 = _locations_5.get(5);
      URI _uRI_5 = _get_5.getURI();
      String _string_5 = _uRI_5.toString();
      Assert.assertEquals("http://download.eclipse.org/modeling/emf/compare/updates/releases/2.1/R201310031412/", _string_5);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testResolutionDiagnosticVerbosity() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"target_with_resolution_pb\"");
      _builder.newLine();
      _builder.newLine();
      _builder.append("location \"http://download.eclipse.org/egit/updates-3.3\" {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("org.eclipse.egit.feature.group;version=[3.3,3.4)");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("org.eclipse.egit.mylyn.feature.group;version=[3.3,3.4)");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("location \"http://download.eclipse.org/tools/orbit/downloads/drops/R20130517111416/repository/\" {");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("com.google.guava;version=[20.0.0,22.0.0)");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("location \"http://download.eclipse.org/modeling/emf/compare/updates/releases/2.1/R201310031412/\" {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("org.eclipse.emf.compare.rcp.ui.feature.group");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final TargetPlatform tp = this.parser.parse(_builder);
      final ResolvedTargetPlatform resolvedTargetPlatform = ResolvedTargetPlatform.create(tp, this.indexBuilder);
      MockMetadataRepositoryManager _mockMetadataRepositoryManager = new MockMetadataRepositoryManager(new IQueryResultProvider<IInstallableUnit>() {
        public List<IInstallableUnit> listIUs(final URI location) {
          List<IInstallableUnit> _xifexpression = null;
          String _string = location.toString();
          boolean _equals = "http://download.eclipse.org/egit/updates-3.3".equals(_string);
          if (_equals) {
            Version _createOSGi = Version.createOSGi(3, 3, 2);
            MockIU _createFeature = MockIU.createFeature("org.eclipse.egit.feature.group", _createOSGi);
            Version _createOSGi_1 = Version.createOSGi(3, 3, 2);
            MockIU _createFeature_1 = MockIU.createFeature("org.eclipse.egit.mylyn.feature.group", _createOSGi_1);
            _xifexpression = CollectionLiterals.<IInstallableUnit>newImmutableList(_createFeature, _createFeature_1);
          } else {
            List<IInstallableUnit> _xifexpression_1 = null;
            String _string_1 = location.toString();
            boolean _equals_1 = "http://download.eclipse.org/tools/orbit/downloads/drops/R20130517111416/repository/".equals(_string_1);
            if (_equals_1) {
              Version _createOSGi_2 = Version.createOSGi(10, 0, 0);
              MockIU _createFeature_2 = MockIU.createFeature("com.google.guava", _createOSGi_2);
              Version _createOSGi_3 = Version.createOSGi(11, 0, 2);
              MockIU _createFeature_3 = MockIU.createFeature("com.google.guava", _createOSGi_3);
              Version _createOSGi_4 = Version.createOSGi(12, 0, 0);
              MockIU _createFeature_4 = MockIU.createFeature("com.google.guava", _createOSGi_4);
              _xifexpression_1 = CollectionLiterals.<IInstallableUnit>newImmutableList(_createFeature_2, _createFeature_3, _createFeature_4);
            } else {
              List<IInstallableUnit> _xifexpression_2 = null;
              String _string_2 = location.toString();
              boolean _equals_2 = "http://download.eclipse.org/modeling/emf/compare/updates/releases/2.1/R201310031412/".equals(_string_2);
              if (_equals_2) {
                Version _createOSGi_5 = Version.createOSGi(5, 0, 0);
                MockIU _createFeature_5 = MockIU.createFeature("org.eclipse.emf.compare.rcp.ui.feature.group", _createOSGi_5);
                _xifexpression_2 = CollectionLiterals.<IInstallableUnit>newImmutableList(_createFeature_5);
              } else {
                return CollectionLiterals.<IInstallableUnit>emptyList();
              }
              _xifexpression_1 = _xifexpression_2;
            }
            _xifexpression = _xifexpression_1;
          }
          return _xifexpression;
        }
      });
      NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
      final Diagnostic d = resolvedTargetPlatform.resolve(_mockMetadataRepositoryManager, _nullProgressMonitor);
      int _severity = d.getSeverity();
      Assert.assertEquals(Diagnostic.ERROR, _severity);
      List<Diagnostic> _children = d.getChildren();
      String _join = IterableExtensions.join(_children, ", ");
      List<Diagnostic> _children_1 = d.getChildren();
      final Function1<Diagnostic, Boolean> _function = new Function1<Diagnostic, Boolean>() {
        public Boolean apply(final Diagnostic it) {
          int _severity = it.getSeverity();
          return Boolean.valueOf((_severity >= Diagnostic.WARNING));
        }
      };
      Iterable<Diagnostic> _filter = IterableExtensions.<Diagnostic>filter(_children_1, _function);
      int _size = IterableExtensions.size(_filter);
      Assert.assertEquals(_join, 1, _size);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
