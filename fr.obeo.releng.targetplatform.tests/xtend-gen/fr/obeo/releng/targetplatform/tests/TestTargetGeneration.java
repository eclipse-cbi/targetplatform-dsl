package fr.obeo.releng.targetplatform.tests;

import com.google.common.io.Files;
import com.google.inject.Inject;
import fr.obeo.releng.targetplatform.TargetPlatform;
import fr.obeo.releng.targetplatform.TargetPlatformInjectorProvider;
import fr.obeo.releng.targetplatform.pde.TargetDefinitionGenerator;
import fr.obeo.releng.targetplatform.resolved.ResolvedTargetPlatform;
import fr.obeo.releng.targetplatform.tests.IQueryResultProvider;
import fr.obeo.releng.targetplatform.tests.MockIU;
import fr.obeo.releng.targetplatform.tests.MockMetadataRepositoryManager;
import fr.obeo.releng.targetplatform.util.LocationIndexBuilder;
import java.io.File;
import java.net.URI;
import java.util.List;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.equinox.p2.metadata.IInstallableUnit;
import org.eclipse.equinox.p2.metadata.Version;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.junit4.util.ParseHelper;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

@InjectWith(TargetPlatformInjectorProvider.class)
@RunWith(XtextRunner.class)
@SuppressWarnings("all")
public class TestTargetGeneration {
  @Inject
  private ParseHelper<TargetPlatform> parser;
  
  @Inject
  private LocationIndexBuilder indexBuilder;
  
  private static File tmpDir;
  
  @BeforeClass
  public static void beforeClass() {
    File _createTempDir = Files.createTempDir();
    TestTargetGeneration.tmpDir = _createTempDir;
  }
  
  @Test(expected = IllegalArgumentException.class)
  public void testEmptyTP() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      final TargetPlatform tp1 = this.parser.parse(_builder);
      ResolvedTargetPlatform.create(tp1, this.indexBuilder);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testNamedTP() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"TP1\"");
      _builder.newLine();
      final TargetPlatform tp1 = this.parser.parse(_builder);
      final ResolvedTargetPlatform resolvedTargetPlatform = ResolvedTargetPlatform.create(tp1, this.indexBuilder);
      final TargetDefinitionGenerator gen = new TargetDefinitionGenerator();
      final String content = gen.generate(resolvedTargetPlatform, 1);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>");
      _builder_1.newLine();
      _builder_1.append("<?pde?>");
      _builder_1.newLine();
      _builder_1.append("<!-- generated with https://github.com/mbarbero/fr.obeo.releng.targetplatform -->");
      _builder_1.newLine();
      _builder_1.append("<target name=\"TP1\" sequenceNumber=\"1\">");
      _builder_1.newLine();
      _builder_1.append("</target>");
      _builder_1.newLine();
      String _string = _builder_1.toString();
      Assert.assertEquals(_string, content);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testSingleLocationSingleIU() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"TP1\"");
      _builder.newLine();
      _builder.newLine();
      _builder.append("location \"http://location.org/p2\" {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("an.iu");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final TargetPlatform tp1 = this.parser.parse(_builder);
      final ResolvedTargetPlatform resolvedTargetPlatform = ResolvedTargetPlatform.create(tp1, this.indexBuilder);
      MockMetadataRepositoryManager _mockMetadataRepositoryManager = new MockMetadataRepositoryManager(new IQueryResultProvider<IInstallableUnit>() {
        public List<IInstallableUnit> listIUs(final URI location) {
          List<IInstallableUnit> _xifexpression = null;
          String _string = location.toString();
          boolean _equals = "http://location.org/p2".equals(_string);
          if (_equals) {
            Version _createOSGi = Version.createOSGi(1, 0, 0, "thequalifier");
            MockIU _mockIU = new MockIU("an.iu", _createOSGi);
            _xifexpression = CollectionLiterals.<IInstallableUnit>newImmutableList(_mockIU);
          } else {
            return CollectionLiterals.<IInstallableUnit>emptyList();
          }
          return _xifexpression;
        }
      });
      NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
      resolvedTargetPlatform.resolve(_mockMetadataRepositoryManager, _nullProgressMonitor);
      final TargetDefinitionGenerator gen = new TargetDefinitionGenerator();
      final String content = gen.generate(resolvedTargetPlatform, 1);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>");
      _builder_1.newLine();
      _builder_1.append("<?pde?>");
      _builder_1.newLine();
      _builder_1.append("<!-- generated with https://github.com/mbarbero/fr.obeo.releng.targetplatform -->");
      _builder_1.newLine();
      _builder_1.append("<target name=\"TP1\" sequenceNumber=\"1\">");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("<locations>");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("<location includeMode=\"slicer\" includeAllPlatforms=\"false\" includeSource=\"false\" includeConfigurePhase=\"false\" type=\"InstallableUnit\">");
      _builder_1.newLine();
      _builder_1.append("      ");
      _builder_1.append("<unit id=\"an.iu\" version=\"1.0.0.thequalifier\"/>");
      _builder_1.newLine();
      _builder_1.append("      ");
      _builder_1.append("<repository location=\"http://location.org/p2\"/>");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("</location>");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("</locations>");
      _builder_1.newLine();
      _builder_1.append("</target>");
      _builder_1.newLine();
      String _string = _builder_1.toString();
      Assert.assertEquals(_string, content);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testSingleLocationManyIU() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"TP1\"");
      _builder.newLine();
      _builder.newLine();
      _builder.append("location \"http://location.org/p2\" {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("an.iu");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("an.iu2;version=[1.2.0,2.0.0)");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final TargetPlatform tp1 = this.parser.parse(_builder);
      final ResolvedTargetPlatform resolvedTargetPlatform = ResolvedTargetPlatform.create(tp1, this.indexBuilder);
      MockMetadataRepositoryManager _mockMetadataRepositoryManager = new MockMetadataRepositoryManager(new IQueryResultProvider<IInstallableUnit>() {
        public List<IInstallableUnit> listIUs(final URI location) {
          List<IInstallableUnit> ret = null;
          String _string = location.toString();
          boolean _equals = "http://location.org/p2".equals(_string);
          if (_equals) {
            Version _createOSGi = Version.createOSGi(1, 0, 0, "thequalifier");
            MockIU _mockIU = new MockIU("an.iu", _createOSGi);
            Version _createOSGi_1 = Version.createOSGi(1, 3, 74, null);
            MockIU _mockIU_1 = new MockIU("an.iu2", _createOSGi_1);
            List<IInstallableUnit> _newImmutableList = CollectionLiterals.<IInstallableUnit>newImmutableList(_mockIU, _mockIU_1);
            ret = _newImmutableList;
          } else {
            List<IInstallableUnit> _emptyList = CollectionLiterals.<IInstallableUnit>emptyList();
            ret = _emptyList;
          }
          return ret;
        }
      });
      NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
      resolvedTargetPlatform.resolve(_mockMetadataRepositoryManager, _nullProgressMonitor);
      final TargetDefinitionGenerator gen = new TargetDefinitionGenerator();
      final String content = gen.generate(resolvedTargetPlatform, 1);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>");
      _builder_1.newLine();
      _builder_1.append("<?pde?>");
      _builder_1.newLine();
      _builder_1.append("<!-- generated with https://github.com/mbarbero/fr.obeo.releng.targetplatform -->");
      _builder_1.newLine();
      _builder_1.append("<target name=\"TP1\" sequenceNumber=\"1\">");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("<locations>");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("<location includeMode=\"slicer\" includeAllPlatforms=\"false\" includeSource=\"false\" includeConfigurePhase=\"false\" type=\"InstallableUnit\">");
      _builder_1.newLine();
      _builder_1.append("      ");
      _builder_1.append("<unit id=\"an.iu\" version=\"1.0.0.thequalifier\"/>");
      _builder_1.newLine();
      _builder_1.append("      ");
      _builder_1.append("<unit id=\"an.iu2\" version=\"1.3.74\"/>");
      _builder_1.newLine();
      _builder_1.append("      ");
      _builder_1.append("<repository location=\"http://location.org/p2\"/>");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("</location>");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("</locations>");
      _builder_1.newLine();
      _builder_1.append("</target>");
      _builder_1.newLine();
      String _string = _builder_1.toString();
      Assert.assertEquals(_string, content);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testManyLocationManyIU() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"TP1\"");
      _builder.newLine();
      _builder.newLine();
      _builder.append("location \"http://location.org/p2\" {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("an.iu");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("location \"http://location2.org/p2\" {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("an.iu2");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final TargetPlatform tp1 = this.parser.parse(_builder);
      final ResolvedTargetPlatform resolvedTargetPlatform = ResolvedTargetPlatform.create(tp1, this.indexBuilder);
      MockMetadataRepositoryManager _mockMetadataRepositoryManager = new MockMetadataRepositoryManager(new IQueryResultProvider<IInstallableUnit>() {
        public List<IInstallableUnit> listIUs(final URI location) {
          List<IInstallableUnit> ret = null;
          String _string = location.toString();
          boolean _equals = "http://location.org/p2".equals(_string);
          if (_equals) {
            Version _createOSGi = Version.createOSGi(1, 0, 0);
            MockIU _mockIU = new MockIU("an.iu", _createOSGi);
            List<IInstallableUnit> _newImmutableList = CollectionLiterals.<IInstallableUnit>newImmutableList(_mockIU);
            ret = _newImmutableList;
          } else {
            String _string_1 = location.toString();
            boolean _equals_1 = "http://location2.org/p2".equals(_string_1);
            if (_equals_1) {
              Version _createOSGi_1 = Version.createOSGi(1, 3, 74, null);
              MockIU _mockIU_1 = new MockIU("an.iu2", _createOSGi_1);
              List<IInstallableUnit> _newImmutableList_1 = CollectionLiterals.<IInstallableUnit>newImmutableList(_mockIU_1);
              ret = _newImmutableList_1;
            } else {
              List<IInstallableUnit> _emptyList = CollectionLiterals.<IInstallableUnit>emptyList();
              ret = _emptyList;
            }
          }
          return ret;
        }
      });
      NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
      resolvedTargetPlatform.resolve(_mockMetadataRepositoryManager, _nullProgressMonitor);
      final TargetDefinitionGenerator gen = new TargetDefinitionGenerator();
      final String content = gen.generate(resolvedTargetPlatform, 1);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>");
      _builder_1.newLine();
      _builder_1.append("<?pde?>");
      _builder_1.newLine();
      _builder_1.append("<!-- generated with https://github.com/mbarbero/fr.obeo.releng.targetplatform -->");
      _builder_1.newLine();
      _builder_1.append("<target name=\"TP1\" sequenceNumber=\"1\">");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("<locations>");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("<location includeMode=\"slicer\" includeAllPlatforms=\"false\" includeSource=\"false\" includeConfigurePhase=\"false\" type=\"InstallableUnit\">");
      _builder_1.newLine();
      _builder_1.append("      ");
      _builder_1.append("<unit id=\"an.iu\" version=\"1.0.0\"/>");
      _builder_1.newLine();
      _builder_1.append("      ");
      _builder_1.append("<repository location=\"http://location.org/p2\"/>");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("</location>");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("<location includeMode=\"slicer\" includeAllPlatforms=\"false\" includeSource=\"false\" includeConfigurePhase=\"false\" type=\"InstallableUnit\">");
      _builder_1.newLine();
      _builder_1.append("      ");
      _builder_1.append("<unit id=\"an.iu2\" version=\"1.3.74\"/>");
      _builder_1.newLine();
      _builder_1.append("      ");
      _builder_1.append("<repository location=\"http://location2.org/p2\"/>");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("</location>");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("</locations>");
      _builder_1.newLine();
      _builder_1.append("</target>");
      _builder_1.newLine();
      String _string = _builder_1.toString();
      Assert.assertEquals(_string, content);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testOptionSource() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"TP1\"");
      _builder.newLine();
      _builder.newLine();
      _builder.append("with source");
      _builder.newLine();
      _builder.newLine();
      _builder.append("location \"http://location.org/p2\" {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("an.iu");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final TargetPlatform tp1 = this.parser.parse(_builder);
      final ResolvedTargetPlatform resolvedTargetPlatform = ResolvedTargetPlatform.create(tp1, this.indexBuilder);
      MockMetadataRepositoryManager _mockMetadataRepositoryManager = new MockMetadataRepositoryManager(new IQueryResultProvider<IInstallableUnit>() {
        public List<IInstallableUnit> listIUs(final URI location) {
          List<IInstallableUnit> _xifexpression = null;
          String _string = location.toString();
          boolean _equals = "http://location.org/p2".equals(_string);
          if (_equals) {
            Version _createOSGi = Version.createOSGi(1, 0, 0, "thequalifier");
            MockIU _mockIU = new MockIU("an.iu", _createOSGi);
            _xifexpression = CollectionLiterals.<IInstallableUnit>newImmutableList(_mockIU);
          } else {
            return CollectionLiterals.<IInstallableUnit>emptyList();
          }
          return _xifexpression;
        }
      });
      NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
      resolvedTargetPlatform.resolve(_mockMetadataRepositoryManager, _nullProgressMonitor);
      final TargetDefinitionGenerator gen = new TargetDefinitionGenerator();
      final String content = gen.generate(resolvedTargetPlatform, 1);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>");
      _builder_1.newLine();
      _builder_1.append("<?pde?>");
      _builder_1.newLine();
      _builder_1.append("<!-- generated with https://github.com/mbarbero/fr.obeo.releng.targetplatform -->");
      _builder_1.newLine();
      _builder_1.append("<target name=\"TP1\" sequenceNumber=\"1\">");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("<locations>");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("<location includeMode=\"slicer\" includeAllPlatforms=\"false\" includeSource=\"true\" includeConfigurePhase=\"false\" type=\"InstallableUnit\">");
      _builder_1.newLine();
      _builder_1.append("      ");
      _builder_1.append("<unit id=\"an.iu\" version=\"1.0.0.thequalifier\"/>");
      _builder_1.newLine();
      _builder_1.append("      ");
      _builder_1.append("<repository location=\"http://location.org/p2\"/>");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("</location>");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("</locations>");
      _builder_1.newLine();
      _builder_1.append("</target>");
      _builder_1.newLine();
      String _string = _builder_1.toString();
      Assert.assertEquals(_string, content);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testOptionRequirement() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"TP1\"");
      _builder.newLine();
      _builder.newLine();
      _builder.append("with requirements");
      _builder.newLine();
      _builder.newLine();
      _builder.append("location \"http://location.org/p2\" {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("an.iu");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final TargetPlatform tp1 = this.parser.parse(_builder);
      final ResolvedTargetPlatform resolvedTargetPlatform = ResolvedTargetPlatform.create(tp1, this.indexBuilder);
      MockMetadataRepositoryManager _mockMetadataRepositoryManager = new MockMetadataRepositoryManager(new IQueryResultProvider<IInstallableUnit>() {
        public List<IInstallableUnit> listIUs(final URI location) {
          List<IInstallableUnit> _xifexpression = null;
          String _string = location.toString();
          boolean _equals = "http://location.org/p2".equals(_string);
          if (_equals) {
            Version _createOSGi = Version.createOSGi(1, 0, 0, "thequalifier");
            MockIU _mockIU = new MockIU("an.iu", _createOSGi);
            _xifexpression = CollectionLiterals.<IInstallableUnit>newImmutableList(_mockIU);
          } else {
            return CollectionLiterals.<IInstallableUnit>emptyList();
          }
          return _xifexpression;
        }
      });
      NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
      resolvedTargetPlatform.resolve(_mockMetadataRepositoryManager, _nullProgressMonitor);
      final TargetDefinitionGenerator gen = new TargetDefinitionGenerator();
      final String content = gen.generate(resolvedTargetPlatform, 1);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>");
      _builder_1.newLine();
      _builder_1.append("<?pde?>");
      _builder_1.newLine();
      _builder_1.append("<!-- generated with https://github.com/mbarbero/fr.obeo.releng.targetplatform -->");
      _builder_1.newLine();
      _builder_1.append("<target name=\"TP1\" sequenceNumber=\"1\">");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("<locations>");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("<location includeMode=\"planner\" includeAllPlatforms=\"false\" includeSource=\"false\" includeConfigurePhase=\"false\" type=\"InstallableUnit\">");
      _builder_1.newLine();
      _builder_1.append("      ");
      _builder_1.append("<unit id=\"an.iu\" version=\"1.0.0.thequalifier\"/>");
      _builder_1.newLine();
      _builder_1.append("      ");
      _builder_1.append("<repository location=\"http://location.org/p2\"/>");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("</location>");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("</locations>");
      _builder_1.newLine();
      _builder_1.append("</target>");
      _builder_1.newLine();
      String _string = _builder_1.toString();
      Assert.assertEquals(_string, content);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testOptionIncludeAllPlatforms() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"TP1\"");
      _builder.newLine();
      _builder.newLine();
      _builder.append("with allEnvironments");
      _builder.newLine();
      _builder.newLine();
      _builder.append("location \"http://location.org/p2\" {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("an.iu");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final TargetPlatform tp1 = this.parser.parse(_builder);
      final ResolvedTargetPlatform resolvedTargetPlatform = ResolvedTargetPlatform.create(tp1, this.indexBuilder);
      MockMetadataRepositoryManager _mockMetadataRepositoryManager = new MockMetadataRepositoryManager(new IQueryResultProvider<IInstallableUnit>() {
        public List<IInstallableUnit> listIUs(final URI location) {
          List<IInstallableUnit> _xifexpression = null;
          String _string = location.toString();
          boolean _equals = "http://location.org/p2".equals(_string);
          if (_equals) {
            Version _createOSGi = Version.createOSGi(1, 0, 0, "thequalifier");
            MockIU _mockIU = new MockIU("an.iu", _createOSGi);
            _xifexpression = CollectionLiterals.<IInstallableUnit>newImmutableList(_mockIU);
          } else {
            return CollectionLiterals.<IInstallableUnit>emptyList();
          }
          return _xifexpression;
        }
      });
      NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
      resolvedTargetPlatform.resolve(_mockMetadataRepositoryManager, _nullProgressMonitor);
      final TargetDefinitionGenerator gen = new TargetDefinitionGenerator();
      final String content = gen.generate(resolvedTargetPlatform, 1);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>");
      _builder_1.newLine();
      _builder_1.append("<?pde?>");
      _builder_1.newLine();
      _builder_1.append("<!-- generated with https://github.com/mbarbero/fr.obeo.releng.targetplatform -->");
      _builder_1.newLine();
      _builder_1.append("<target name=\"TP1\" sequenceNumber=\"1\">");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("<locations>");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("<location includeMode=\"slicer\" includeAllPlatforms=\"true\" includeSource=\"false\" includeConfigurePhase=\"false\" type=\"InstallableUnit\">");
      _builder_1.newLine();
      _builder_1.append("      ");
      _builder_1.append("<unit id=\"an.iu\" version=\"1.0.0.thequalifier\"/>");
      _builder_1.newLine();
      _builder_1.append("      ");
      _builder_1.append("<repository location=\"http://location.org/p2\"/>");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("</location>");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("</locations>");
      _builder_1.newLine();
      _builder_1.append("</target>");
      _builder_1.newLine();
      String _string = _builder_1.toString();
      Assert.assertEquals(_string, content);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testOptionConfigurePhase() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"TP1\"");
      _builder.newLine();
      _builder.newLine();
      _builder.append("with configurePhase");
      _builder.newLine();
      _builder.newLine();
      _builder.append("location \"http://location.org/p2\" {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("an.iu");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final TargetPlatform tp1 = this.parser.parse(_builder);
      final ResolvedTargetPlatform resolvedTargetPlatform = ResolvedTargetPlatform.create(tp1, this.indexBuilder);
      MockMetadataRepositoryManager _mockMetadataRepositoryManager = new MockMetadataRepositoryManager(new IQueryResultProvider<IInstallableUnit>() {
        public List<IInstallableUnit> listIUs(final URI location) {
          List<IInstallableUnit> _xifexpression = null;
          String _string = location.toString();
          boolean _equals = "http://location.org/p2".equals(_string);
          if (_equals) {
            Version _createOSGi = Version.createOSGi(1, 0, 0, "thequalifier");
            MockIU _mockIU = new MockIU("an.iu", _createOSGi);
            _xifexpression = CollectionLiterals.<IInstallableUnit>newImmutableList(_mockIU);
          } else {
            return CollectionLiterals.<IInstallableUnit>emptyList();
          }
          return _xifexpression;
        }
      });
      NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
      resolvedTargetPlatform.resolve(_mockMetadataRepositoryManager, _nullProgressMonitor);
      final TargetDefinitionGenerator gen = new TargetDefinitionGenerator();
      final String content = gen.generate(resolvedTargetPlatform, 1);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>");
      _builder_1.newLine();
      _builder_1.append("<?pde?>");
      _builder_1.newLine();
      _builder_1.append("<!-- generated with https://github.com/mbarbero/fr.obeo.releng.targetplatform -->");
      _builder_1.newLine();
      _builder_1.append("<target name=\"TP1\" sequenceNumber=\"1\">");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("<locations>");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("<location includeMode=\"slicer\" includeAllPlatforms=\"false\" includeSource=\"false\" includeConfigurePhase=\"true\" type=\"InstallableUnit\">");
      _builder_1.newLine();
      _builder_1.append("      ");
      _builder_1.append("<unit id=\"an.iu\" version=\"1.0.0.thequalifier\"/>");
      _builder_1.newLine();
      _builder_1.append("      ");
      _builder_1.append("<repository location=\"http://location.org/p2\"/>");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("</location>");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("</locations>");
      _builder_1.newLine();
      _builder_1.append("</target>");
      _builder_1.newLine();
      String _string = _builder_1.toString();
      Assert.assertEquals(_string, content);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testEnvOS() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"TP1\"");
      _builder.newLine();
      _builder.newLine();
      _builder.append("environment Win32");
      _builder.newLine();
      final TargetPlatform tp1 = this.parser.parse(_builder);
      final ResolvedTargetPlatform resolvedTargetPlatform = ResolvedTargetPlatform.create(tp1, this.indexBuilder);
      final TargetDefinitionGenerator gen = new TargetDefinitionGenerator();
      final String content = gen.generate(resolvedTargetPlatform, 1);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>");
      _builder_1.newLine();
      _builder_1.append("<?pde?>");
      _builder_1.newLine();
      _builder_1.append("<!-- generated with https://github.com/mbarbero/fr.obeo.releng.targetplatform -->");
      _builder_1.newLine();
      _builder_1.append("<target name=\"TP1\" sequenceNumber=\"1\">");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("<environment>");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("<os>win32</os>");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("</environment>");
      _builder_1.newLine();
      _builder_1.append("</target>");
      _builder_1.newLine();
      String _string = _builder_1.toString();
      Assert.assertEquals(_string, content);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testEnvOSWin32WSWin32() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"TP1\"");
      _builder.newLine();
      _builder.newLine();
      _builder.append("environment Win32 wiN32");
      _builder.newLine();
      final TargetPlatform tp1 = this.parser.parse(_builder);
      final ResolvedTargetPlatform resolvedTargetPlatform = ResolvedTargetPlatform.create(tp1, this.indexBuilder);
      final TargetDefinitionGenerator gen = new TargetDefinitionGenerator();
      final String content = gen.generate(resolvedTargetPlatform, 1);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>");
      _builder_1.newLine();
      _builder_1.append("<?pde?>");
      _builder_1.newLine();
      _builder_1.append("<!-- generated with https://github.com/mbarbero/fr.obeo.releng.targetplatform -->");
      _builder_1.newLine();
      _builder_1.append("<target name=\"TP1\" sequenceNumber=\"1\">");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("<environment>");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("<os>win32</os>");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("<ws>win32</ws>");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("</environment>");
      _builder_1.newLine();
      _builder_1.append("</target>");
      _builder_1.newLine();
      String _string = _builder_1.toString();
      Assert.assertEquals(_string, content);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testEnvWS() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"TP1\"");
      _builder.newLine();
      _builder.newLine();
      _builder.append("environment cocoa");
      _builder.newLine();
      final TargetPlatform tp1 = this.parser.parse(_builder);
      final ResolvedTargetPlatform resolvedTargetPlatform = ResolvedTargetPlatform.create(tp1, this.indexBuilder);
      final TargetDefinitionGenerator gen = new TargetDefinitionGenerator();
      final String content = gen.generate(resolvedTargetPlatform, 1);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>");
      _builder_1.newLine();
      _builder_1.append("<?pde?>");
      _builder_1.newLine();
      _builder_1.append("<!-- generated with https://github.com/mbarbero/fr.obeo.releng.targetplatform -->");
      _builder_1.newLine();
      _builder_1.append("<target name=\"TP1\" sequenceNumber=\"1\">");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("<environment>");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("<ws>cocoa</ws>");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("</environment>");
      _builder_1.newLine();
      _builder_1.append("</target>");
      _builder_1.newLine();
      String _string = _builder_1.toString();
      Assert.assertEquals(_string, content);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testEnvArch() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"TP1\"");
      _builder.newLine();
      _builder.newLine();
      _builder.append("environment x86_64");
      _builder.newLine();
      final TargetPlatform tp1 = this.parser.parse(_builder);
      final ResolvedTargetPlatform resolvedTargetPlatform = ResolvedTargetPlatform.create(tp1, this.indexBuilder);
      final TargetDefinitionGenerator gen = new TargetDefinitionGenerator();
      final String content = gen.generate(resolvedTargetPlatform, 1);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>");
      _builder_1.newLine();
      _builder_1.append("<?pde?>");
      _builder_1.newLine();
      _builder_1.append("<!-- generated with https://github.com/mbarbero/fr.obeo.releng.targetplatform -->");
      _builder_1.newLine();
      _builder_1.append("<target name=\"TP1\" sequenceNumber=\"1\">");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("<environment>");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("<arch>x86_64</arch>");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("</environment>");
      _builder_1.newLine();
      _builder_1.append("</target>");
      _builder_1.newLine();
      String _string = _builder_1.toString();
      Assert.assertEquals(_string, content);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testEnvLocale() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"TP1\"");
      _builder.newLine();
      _builder.newLine();
      _builder.append("environment fr_fr");
      _builder.newLine();
      final TargetPlatform tp1 = this.parser.parse(_builder);
      final ResolvedTargetPlatform resolvedTargetPlatform = ResolvedTargetPlatform.create(tp1, this.indexBuilder);
      final TargetDefinitionGenerator gen = new TargetDefinitionGenerator();
      final String content = gen.generate(resolvedTargetPlatform, 1);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>");
      _builder_1.newLine();
      _builder_1.append("<?pde?>");
      _builder_1.newLine();
      _builder_1.append("<!-- generated with https://github.com/mbarbero/fr.obeo.releng.targetplatform -->");
      _builder_1.newLine();
      _builder_1.append("<target name=\"TP1\" sequenceNumber=\"1\">");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("<environment>");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("<nl>fr_FR</nl>");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("</environment>");
      _builder_1.newLine();
      _builder_1.append("</target>");
      _builder_1.newLine();
      String _string = _builder_1.toString();
      Assert.assertEquals(_string, content);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testEnvEE() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"TP1\"");
      _builder.newLine();
      _builder.newLine();
      _builder.append("environment JavaSE-1.7");
      _builder.newLine();
      final TargetPlatform tp1 = this.parser.parse(_builder);
      final ResolvedTargetPlatform resolvedTargetPlatform = ResolvedTargetPlatform.create(tp1, this.indexBuilder);
      final TargetDefinitionGenerator gen = new TargetDefinitionGenerator();
      final String content = gen.generate(resolvedTargetPlatform, 1);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>");
      _builder_1.newLine();
      _builder_1.append("<?pde?>");
      _builder_1.newLine();
      _builder_1.append("<!-- generated with https://github.com/mbarbero/fr.obeo.releng.targetplatform -->");
      _builder_1.newLine();
      _builder_1.append("<target name=\"TP1\" sequenceNumber=\"1\">");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("<targetJRE path=\"org.eclipse.jdt.launching.JRE_CONTAINER/org.eclipse.jdt.internal.debug.ui.launcher.StandardVMType/JavaSE-1.7\"/>");
      _builder_1.newLine();
      _builder_1.append("</target>");
      _builder_1.newLine();
      String _string = _builder_1.toString();
      Assert.assertEquals(_string, content);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testEnv1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"TP1\"");
      _builder.newLine();
      _builder.newLine();
      _builder.append("environment JavaSE-1.7 win32 cocoa x86 en_us");
      _builder.newLine();
      final TargetPlatform tp1 = this.parser.parse(_builder);
      final ResolvedTargetPlatform resolvedTargetPlatform = ResolvedTargetPlatform.create(tp1, this.indexBuilder);
      final TargetDefinitionGenerator gen = new TargetDefinitionGenerator();
      final String content = gen.generate(resolvedTargetPlatform, 1);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>");
      _builder_1.newLine();
      _builder_1.append("<?pde?>");
      _builder_1.newLine();
      _builder_1.append("<!-- generated with https://github.com/mbarbero/fr.obeo.releng.targetplatform -->");
      _builder_1.newLine();
      _builder_1.append("<target name=\"TP1\" sequenceNumber=\"1\">");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("<environment>");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("<os>win32</os>");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("<ws>cocoa</ws>");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("<arch>x86</arch>");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("<nl>en_US</nl>");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("</environment>");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("<targetJRE path=\"org.eclipse.jdt.launching.JRE_CONTAINER/org.eclipse.jdt.internal.debug.ui.launcher.StandardVMType/JavaSE-1.7\"/>");
      _builder_1.newLine();
      _builder_1.append("</target>");
      _builder_1.newLine();
      String _string = _builder_1.toString();
      Assert.assertEquals(_string, content);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testEnv2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"TP1\"");
      _builder.newLine();
      _builder.newLine();
      _builder.append("environment win32 linux");
      _builder.newLine();
      final TargetPlatform tp1 = this.parser.parse(_builder);
      final ResolvedTargetPlatform resolvedTargetPlatform = ResolvedTargetPlatform.create(tp1, this.indexBuilder);
      final TargetDefinitionGenerator gen = new TargetDefinitionGenerator();
      final String content = gen.generate(resolvedTargetPlatform, 1);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>");
      _builder_1.newLine();
      _builder_1.append("<?pde?>");
      _builder_1.newLine();
      _builder_1.append("<!-- generated with https://github.com/mbarbero/fr.obeo.releng.targetplatform -->");
      _builder_1.newLine();
      _builder_1.append("<target name=\"TP1\" sequenceNumber=\"1\">");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("<environment>");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("<os>linux</os>");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("<ws>win32</ws>");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("</environment>");
      _builder_1.newLine();
      _builder_1.append("</target>");
      _builder_1.newLine();
      String _string = _builder_1.toString();
      Assert.assertEquals(_string, content);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
