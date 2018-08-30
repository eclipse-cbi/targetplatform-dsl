/**
 * Copyright (c) 2012-2014 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 */
package org.eclipse.cbi.targetplatform.tests;

import com.google.inject.Inject;
import java.net.URI;
import java.util.List;
import org.eclipse.cbi.targetplatform.model.TargetPlatform;
import org.eclipse.cbi.targetplatform.pde.TargetDefinitionGenerator;
import org.eclipse.cbi.targetplatform.resolved.ResolvedTargetPlatform;
import org.eclipse.cbi.targetplatform.tests.stubs.p2.IQueryResultProvider;
import org.eclipse.cbi.targetplatform.tests.stubs.p2.IUStub;
import org.eclipse.cbi.targetplatform.tests.stubs.p2.MetadataRepositoryManagerStub;
import org.eclipse.cbi.targetplatform.tests.util.CustomTargetPlatformInjectorProvider;
import org.eclipse.cbi.targetplatform.util.LocationIndexBuilder;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.equinox.p2.metadata.IInstallableUnit;
import org.eclipse.equinox.p2.metadata.Version;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@InjectWith(CustomTargetPlatformInjectorProvider.class)
@RunWith(XtextRunner.class)
@SuppressWarnings("all")
public class TestTargetGeneration {
  @Inject
  private ParseHelper<TargetPlatform> parser;
  
  @Inject
  private LocationIndexBuilder indexBuilder;
  
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
      _builder_1.append("<!-- generated with https://github.com/mbarbero/org.eclipse.cbi.targetplatform -->");
      _builder_1.newLine();
      _builder_1.append("<target name=\"TP1\" sequenceNumber=\"1\">");
      _builder_1.newLine();
      _builder_1.append("</target>");
      _builder_1.newLine();
      Assert.assertEquals(_builder_1.toString(), content);
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
      MetadataRepositoryManagerStub _metadataRepositoryManagerStub = new MetadataRepositoryManagerStub(new IQueryResultProvider<IInstallableUnit>() {
        @Override
        public List<IInstallableUnit> listIUs(final URI location) {
          List<IInstallableUnit> _xifexpression = null;
          boolean _equals = "http://location.org/p2".equals(location.toString());
          if (_equals) {
            _xifexpression = CollectionLiterals.<IInstallableUnit>newImmutableList(
              IUStub.createBundle("an.iu", Version.createOSGi(1, 0, 0, "thequalifier")));
          } else {
            return CollectionLiterals.<IInstallableUnit>emptyList();
          }
          return _xifexpression;
        }
      });
      NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
      resolvedTargetPlatform.resolve(_metadataRepositoryManagerStub, _nullProgressMonitor);
      final TargetDefinitionGenerator gen = new TargetDefinitionGenerator();
      final String content = gen.generate(resolvedTargetPlatform, 1);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>");
      _builder_1.newLine();
      _builder_1.append("<?pde?>");
      _builder_1.newLine();
      _builder_1.append("<!-- generated with https://github.com/mbarbero/org.eclipse.cbi.targetplatform -->");
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
      Assert.assertEquals(_builder_1.toString(), content);
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
      MetadataRepositoryManagerStub _metadataRepositoryManagerStub = new MetadataRepositoryManagerStub(new IQueryResultProvider<IInstallableUnit>() {
        @Override
        public List<IInstallableUnit> listIUs(final URI location) {
          List<IInstallableUnit> ret = null;
          boolean _equals = "http://location.org/p2".equals(location.toString());
          if (_equals) {
            ret = CollectionLiterals.<IInstallableUnit>newImmutableList(
              IUStub.createBundle("an.iu", Version.createOSGi(1, 0, 0, "thequalifier")), 
              IUStub.createBundle("an.iu2", Version.createOSGi(1, 3, 74, null)));
          } else {
            ret = CollectionLiterals.<IInstallableUnit>emptyList();
          }
          return ret;
        }
      });
      NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
      resolvedTargetPlatform.resolve(_metadataRepositoryManagerStub, _nullProgressMonitor);
      final TargetDefinitionGenerator gen = new TargetDefinitionGenerator();
      final String content = gen.generate(resolvedTargetPlatform, 1);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>");
      _builder_1.newLine();
      _builder_1.append("<?pde?>");
      _builder_1.newLine();
      _builder_1.append("<!-- generated with https://github.com/mbarbero/org.eclipse.cbi.targetplatform -->");
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
      Assert.assertEquals(_builder_1.toString(), content);
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
      MetadataRepositoryManagerStub _metadataRepositoryManagerStub = new MetadataRepositoryManagerStub(new IQueryResultProvider<IInstallableUnit>() {
        @Override
        public List<IInstallableUnit> listIUs(final URI location) {
          List<IInstallableUnit> ret = null;
          boolean _equals = "http://location.org/p2".equals(location.toString());
          if (_equals) {
            ret = CollectionLiterals.<IInstallableUnit>newImmutableList(
              IUStub.createBundle("an.iu", Version.createOSGi(1, 0, 0)));
          } else {
            boolean _equals_1 = "http://location2.org/p2".equals(location.toString());
            if (_equals_1) {
              ret = CollectionLiterals.<IInstallableUnit>newImmutableList(
                IUStub.createBundle("an.iu2", Version.createOSGi(1, 3, 74, null)));
            } else {
              ret = CollectionLiterals.<IInstallableUnit>emptyList();
            }
          }
          return ret;
        }
      });
      NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
      resolvedTargetPlatform.resolve(_metadataRepositoryManagerStub, _nullProgressMonitor);
      final TargetDefinitionGenerator gen = new TargetDefinitionGenerator();
      final String content = gen.generate(resolvedTargetPlatform, 1);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>");
      _builder_1.newLine();
      _builder_1.append("<?pde?>");
      _builder_1.newLine();
      _builder_1.append("<!-- generated with https://github.com/mbarbero/org.eclipse.cbi.targetplatform -->");
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
      Assert.assertEquals(_builder_1.toString(), content);
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
      MetadataRepositoryManagerStub _metadataRepositoryManagerStub = new MetadataRepositoryManagerStub(new IQueryResultProvider<IInstallableUnit>() {
        @Override
        public List<IInstallableUnit> listIUs(final URI location) {
          List<IInstallableUnit> _xifexpression = null;
          boolean _equals = "http://location.org/p2".equals(location.toString());
          if (_equals) {
            _xifexpression = CollectionLiterals.<IInstallableUnit>newImmutableList(
              IUStub.createBundle("an.iu", Version.createOSGi(1, 0, 0, "thequalifier")));
          } else {
            return CollectionLiterals.<IInstallableUnit>emptyList();
          }
          return _xifexpression;
        }
      });
      NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
      resolvedTargetPlatform.resolve(_metadataRepositoryManagerStub, _nullProgressMonitor);
      final TargetDefinitionGenerator gen = new TargetDefinitionGenerator();
      final String content = gen.generate(resolvedTargetPlatform, 1);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>");
      _builder_1.newLine();
      _builder_1.append("<?pde?>");
      _builder_1.newLine();
      _builder_1.append("<!-- generated with https://github.com/mbarbero/org.eclipse.cbi.targetplatform -->");
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
      Assert.assertEquals(_builder_1.toString(), content);
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
      MetadataRepositoryManagerStub _metadataRepositoryManagerStub = new MetadataRepositoryManagerStub(new IQueryResultProvider<IInstallableUnit>() {
        @Override
        public List<IInstallableUnit> listIUs(final URI location) {
          List<IInstallableUnit> _xifexpression = null;
          boolean _equals = "http://location.org/p2".equals(location.toString());
          if (_equals) {
            _xifexpression = CollectionLiterals.<IInstallableUnit>newImmutableList(
              IUStub.createBundle("an.iu", Version.createOSGi(1, 0, 0, "thequalifier")));
          } else {
            return CollectionLiterals.<IInstallableUnit>emptyList();
          }
          return _xifexpression;
        }
      });
      NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
      resolvedTargetPlatform.resolve(_metadataRepositoryManagerStub, _nullProgressMonitor);
      final TargetDefinitionGenerator gen = new TargetDefinitionGenerator();
      final String content = gen.generate(resolvedTargetPlatform, 1);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>");
      _builder_1.newLine();
      _builder_1.append("<?pde?>");
      _builder_1.newLine();
      _builder_1.append("<!-- generated with https://github.com/mbarbero/org.eclipse.cbi.targetplatform -->");
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
      Assert.assertEquals(_builder_1.toString(), content);
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
      MetadataRepositoryManagerStub _metadataRepositoryManagerStub = new MetadataRepositoryManagerStub(new IQueryResultProvider<IInstallableUnit>() {
        @Override
        public List<IInstallableUnit> listIUs(final URI location) {
          List<IInstallableUnit> _xifexpression = null;
          boolean _equals = "http://location.org/p2".equals(location.toString());
          if (_equals) {
            _xifexpression = CollectionLiterals.<IInstallableUnit>newImmutableList(
              IUStub.createBundle("an.iu", Version.createOSGi(1, 0, 0, "thequalifier")));
          } else {
            return CollectionLiterals.<IInstallableUnit>emptyList();
          }
          return _xifexpression;
        }
      });
      NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
      resolvedTargetPlatform.resolve(_metadataRepositoryManagerStub, _nullProgressMonitor);
      final TargetDefinitionGenerator gen = new TargetDefinitionGenerator();
      final String content = gen.generate(resolvedTargetPlatform, 1);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>");
      _builder_1.newLine();
      _builder_1.append("<?pde?>");
      _builder_1.newLine();
      _builder_1.append("<!-- generated with https://github.com/mbarbero/org.eclipse.cbi.targetplatform -->");
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
      Assert.assertEquals(_builder_1.toString(), content);
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
      MetadataRepositoryManagerStub _metadataRepositoryManagerStub = new MetadataRepositoryManagerStub(new IQueryResultProvider<IInstallableUnit>() {
        @Override
        public List<IInstallableUnit> listIUs(final URI location) {
          List<IInstallableUnit> _xifexpression = null;
          boolean _equals = "http://location.org/p2".equals(location.toString());
          if (_equals) {
            _xifexpression = CollectionLiterals.<IInstallableUnit>newImmutableList(
              IUStub.createBundle("an.iu", Version.createOSGi(1, 0, 0, "thequalifier")));
          } else {
            return CollectionLiterals.<IInstallableUnit>emptyList();
          }
          return _xifexpression;
        }
      });
      NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
      resolvedTargetPlatform.resolve(_metadataRepositoryManagerStub, _nullProgressMonitor);
      final TargetDefinitionGenerator gen = new TargetDefinitionGenerator();
      final String content = gen.generate(resolvedTargetPlatform, 1);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>");
      _builder_1.newLine();
      _builder_1.append("<?pde?>");
      _builder_1.newLine();
      _builder_1.append("<!-- generated with https://github.com/mbarbero/org.eclipse.cbi.targetplatform -->");
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
      Assert.assertEquals(_builder_1.toString(), content);
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
      _builder_1.append("<!-- generated with https://github.com/mbarbero/org.eclipse.cbi.targetplatform -->");
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
      Assert.assertEquals(_builder_1.toString(), content);
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
      _builder_1.append("<!-- generated with https://github.com/mbarbero/org.eclipse.cbi.targetplatform -->");
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
      Assert.assertEquals(_builder_1.toString(), content);
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
      _builder_1.append("<!-- generated with https://github.com/mbarbero/org.eclipse.cbi.targetplatform -->");
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
      Assert.assertEquals(_builder_1.toString(), content);
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
      _builder_1.append("<!-- generated with https://github.com/mbarbero/org.eclipse.cbi.targetplatform -->");
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
      Assert.assertEquals(_builder_1.toString(), content);
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
      _builder_1.append("<!-- generated with https://github.com/mbarbero/org.eclipse.cbi.targetplatform -->");
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
      Assert.assertEquals(_builder_1.toString(), content);
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
      _builder_1.append("<!-- generated with https://github.com/mbarbero/org.eclipse.cbi.targetplatform -->");
      _builder_1.newLine();
      _builder_1.append("<target name=\"TP1\" sequenceNumber=\"1\">");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("<targetJRE path=\"org.eclipse.jdt.launching.JRE_CONTAINER/org.eclipse.jdt.internal.debug.ui.launcher.StandardVMType/JavaSE-1.7\"/>");
      _builder_1.newLine();
      _builder_1.append("</target>");
      _builder_1.newLine();
      Assert.assertEquals(_builder_1.toString(), content);
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
      _builder_1.append("<!-- generated with https://github.com/mbarbero/org.eclipse.cbi.targetplatform -->");
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
      Assert.assertEquals(_builder_1.toString(), content);
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
      _builder_1.append("<!-- generated with https://github.com/mbarbero/org.eclipse.cbi.targetplatform -->");
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
      Assert.assertEquals(_builder_1.toString(), content);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
