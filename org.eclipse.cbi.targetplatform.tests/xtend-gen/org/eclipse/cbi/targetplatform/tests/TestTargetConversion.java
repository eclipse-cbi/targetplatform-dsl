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

import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import com.google.inject.Provider;
import java.net.URI;
import java.util.List;
import org.eclipse.cbi.targetplatform.model.TargetPlatform;
import org.eclipse.cbi.targetplatform.resolved.ResolvedLocation;
import org.eclipse.cbi.targetplatform.resolved.ResolvedTargetPlatform;
import org.eclipse.cbi.targetplatform.tests.IQueryResultProvider;
import org.eclipse.cbi.targetplatform.tests.MockIU;
import org.eclipse.cbi.targetplatform.tests.MockMetadataRepositoryManager;
import org.eclipse.cbi.targetplatform.tests.TargetPlatformInjectorProvider;
import org.eclipse.cbi.targetplatform.util.LocationIndexBuilder;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.equinox.p2.core.ProvisionException;
import org.eclipse.equinox.p2.metadata.IInstallableUnit;
import org.eclipse.equinox.p2.metadata.Version;
import org.eclipse.equinox.p2.repository.metadata.IMetadataRepository;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.util.ParseHelper;
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
        @Override
        public List<IInstallableUnit> listIUs(final URI location) {
          List<IInstallableUnit> _xifexpression = null;
          boolean _equals = "http://download.eclipse.org/tools/orbit/downloads/drops/R20130517111416/repository/".equals(location.toString());
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
      Assert.assertEquals(1, targetDef.getLocations().size());
      final ResolvedLocation loc = IterableExtensions.<ResolvedLocation>head(targetDef.getLocations());
      Assert.assertEquals(2, loc.getResolvedIUs().size());
      final Function1<IInstallableUnit, String> _function = (IInstallableUnit it) -> {
        return it.getId();
      };
      final String[] ids = ((String[])Conversions.unwrapArray(ListExtensions.<IInstallableUnit, String>map(loc.getResolvedIUs(), _function), String.class));
      final Function1<IInstallableUnit, Version> _function_1 = (IInstallableUnit it) -> {
        return it.getVersion();
      };
      final Version[] versions = ((Version[])Conversions.unwrapArray(ListExtensions.<IInstallableUnit, Version>map(loc.getResolvedIUs(), _function_1), Version.class));
      Assert.assertEquals("com.google.guava", IterableExtensions.<Object>head(((Iterable<Object>)Conversions.doWrapArray(ids))));
      Assert.assertEquals(0, IterableExtensions.<Version>head(((Iterable<Version>)Conversions.doWrapArray(versions))).compareTo(Version.parseVersion("11.0.2.v201303041551")));
      Assert.assertEquals("org.junit", ids[1]);
      Assert.assertEquals(0, versions[1].compareTo(Version.parseVersion("4.10.0.v4_10_0_v20130308-0414")));
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
        @Override
        public IMetadataRepository loadRepository(final URI location, final IProgressMonitor monitor) throws ProvisionException, OperationCanceledException {
          IMetadataRepository _xifexpression = null;
          boolean _equals = "unknownHost".equals(location.toString());
          if (_equals) {
            throw new ProvisionException("Unknown Host");
          } else {
            _xifexpression = super.loadRepository(location, monitor);
          }
          return _xifexpression;
        }
      }, _nullProgressMonitor);
      Assert.assertEquals(Diagnostic.ERROR, d.getSeverity());
      String _message = IterableExtensions.<Diagnostic>head(d.getChildren()).getMessage();
      String _plus = ("Message is " + _message);
      Assert.assertTrue(_plus, IterableExtensions.<Diagnostic>head(d.getChildren()).getMessage().startsWith("Unknown Host"));
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
        @Override
        public List<IInstallableUnit> listIUs(final URI location) {
          List<IInstallableUnit> _xifexpression = null;
          boolean _equals = "http://download.eclipse.org/modeling/emf/compare/updates/releases/2.1/R201310031412/".equals(location.toString());
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
      Assert.assertEquals(1, targetDef.getLocations().size());
      final Function1<ResolvedLocation, List<String>> _function = (ResolvedLocation it) -> {
        final Function1<IInstallableUnit, String> _function_1 = (IInstallableUnit it_1) -> {
          return it_1.getId();
        };
        return ListExtensions.<IInstallableUnit, String>map(it.getResolvedIUs(), _function_1);
      };
      final String[] ids = ((String[])Conversions.unwrapArray(Iterables.<String>concat(ListExtensions.<ResolvedLocation, List<String>>map(targetDef.getLocations(), _function)), String.class));
      Assert.assertEquals(2, ((List<String>)Conversions.doWrapArray(ids)).size());
      Assert.assertEquals("org.eclipse.emf.compare.rcp.ui.feature.group", IterableExtensions.<Object>head(((Iterable<Object>)Conversions.doWrapArray(ids))));
      Assert.assertEquals("org.eclipse.emf.compare.ide.ui.feature.group", ids[1]);
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
      final TargetPlatform tp1 = this.parser.parse(_builder, org.eclipse.emf.common.util.URI.createURI("tmp:/tp1.tpd"), resourceSet);
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
      this.parser.parse(_builder_1, org.eclipse.emf.common.util.URI.createURI("tmp:/tp2.tpd"), resourceSet);
      final ResolvedTargetPlatform targetDef = ResolvedTargetPlatform.create(tp1, this.indexBuilder);
      MockMetadataRepositoryManager _mockMetadataRepositoryManager = new MockMetadataRepositoryManager(new IQueryResultProvider<IInstallableUnit>() {
        @Override
        public List<IInstallableUnit> listIUs(final URI location) {
          List<IInstallableUnit> _xifexpression = null;
          boolean _equals = "http://download.eclipse.org/modeling/emf/compare/updates/releases/2.1/R201310031412/".equals(location.toString());
          if (_equals) {
            Version _createOSGi = Version.createOSGi(1, 0, 0);
            MockIU _mockIU = new MockIU("org.eclipse.emf.compare.rcp.ui.feature.group", _createOSGi);
            Version _createOSGi_1 = Version.createOSGi(1, 0, 0);
            MockIU _mockIU_1 = new MockIU("org.eclipse.emf.compare.ide.ui.feature.group", _createOSGi_1);
            _xifexpression = CollectionLiterals.<IInstallableUnit>newImmutableList(_mockIU, _mockIU_1);
          } else {
            List<IInstallableUnit> _xifexpression_1 = null;
            boolean _equals_1 = "http://download.eclipse.org/modeling/emf/emf/updates/2.9.x/core/R201402030812/".equals(location.toString());
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
      Assert.assertEquals("TP1", targetDef.getName());
      Assert.assertEquals(2, targetDef.getLocations().size());
      Assert.assertEquals("http://download.eclipse.org/modeling/emf/emf/updates/2.9.x/core/R201402030812/", IterableExtensions.<ResolvedLocation>head(targetDef.getLocations()).getURI().toString());
      Assert.assertEquals("http://download.eclipse.org/modeling/emf/compare/updates/releases/2.1/R201310031412/", targetDef.getLocations().get(1).getURI().toString());
      final Function1<ResolvedLocation, List<String>> _function = (ResolvedLocation it) -> {
        final Function1<IInstallableUnit, String> _function_1 = (IInstallableUnit it_1) -> {
          return it_1.getId();
        };
        return ListExtensions.<IInstallableUnit, String>map(it.getResolvedIUs(), _function_1);
      };
      final String[] ids = ((String[])Conversions.unwrapArray(Iterables.<String>concat(ListExtensions.<ResolvedLocation, List<String>>map(targetDef.getLocations(), _function)), String.class));
      Assert.assertEquals(2, ((List<String>)Conversions.doWrapArray(ids)).size());
      Assert.assertEquals("org.eclipse.emf.sdk.feature.group", IterableExtensions.<Object>head(((Iterable<Object>)Conversions.doWrapArray(ids))));
      Assert.assertEquals("org.eclipse.emf.compare.ide.ui.feature.group", ids[1]);
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
      final TargetPlatform tp1 = this.parser.parse(_builder, org.eclipse.emf.common.util.URI.createURI("tmp:/tp1.tpd"), resourceSet);
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
      this.parser.parse(_builder_1, org.eclipse.emf.common.util.URI.createURI("tmp:/tp2.tpd"), resourceSet);
      final ResolvedTargetPlatform targetDef = ResolvedTargetPlatform.create(tp1, this.indexBuilder);
      MockMetadataRepositoryManager _mockMetadataRepositoryManager = new MockMetadataRepositoryManager(new IQueryResultProvider<IInstallableUnit>() {
        @Override
        public List<IInstallableUnit> listIUs(final URI location) {
          List<IInstallableUnit> _xifexpression = null;
          boolean _equals = "http://download.eclipse.org/modeling/emf/compare/updates/releases/2.1/R201310031412/".equals(location.toString());
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
      Assert.assertEquals("TP1", targetDef.getName());
      Assert.assertEquals(1, targetDef.getLocations().size());
      final Function1<ResolvedLocation, List<String>> _function = (ResolvedLocation it) -> {
        final Function1<IInstallableUnit, String> _function_1 = (IInstallableUnit it_1) -> {
          return it_1.getId();
        };
        return ListExtensions.<IInstallableUnit, String>map(it.getResolvedIUs(), _function_1);
      };
      final String[] ids = ((String[])Conversions.unwrapArray(Iterables.<String>concat(ListExtensions.<ResolvedLocation, List<String>>map(targetDef.getLocations(), _function)), String.class));
      Assert.assertEquals(2, ((List<String>)Conversions.doWrapArray(ids)).size());
      Assert.assertEquals("org.eclipse.emf.compare.ide.ui.feature.group", IterableExtensions.<Object>head(((Iterable<Object>)Conversions.doWrapArray(ids))));
      Assert.assertEquals("org.eclipse.emf.compare.rcp.ui.feature.group", ids[1]);
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
      final TargetPlatform tp1 = this.parser.parse(_builder, org.eclipse.emf.common.util.URI.createURI("tmp:/tp1.tpd"), resourceSet);
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
      this.parser.parse(_builder_1, org.eclipse.emf.common.util.URI.createURI("tmp:/tp2.tpd"), resourceSet);
      final ResolvedTargetPlatform targetDef = ResolvedTargetPlatform.create(tp1, this.indexBuilder);
      MockMetadataRepositoryManager _mockMetadataRepositoryManager = new MockMetadataRepositoryManager(new IQueryResultProvider<IInstallableUnit>() {
        @Override
        public List<IInstallableUnit> listIUs(final URI location) {
          List<IInstallableUnit> _xifexpression = null;
          boolean _equals = "http://download.eclipse.org/modeling/emf/compare/updates/releases/2.1/R201310031412/".equals(location.toString());
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
      Assert.assertEquals("TP1", targetDef.getName());
      Assert.assertEquals(1, targetDef.getLocations().size());
      final Function1<ResolvedLocation, List<String>> _function = (ResolvedLocation it) -> {
        final Function1<IInstallableUnit, String> _function_1 = (IInstallableUnit it_1) -> {
          return it_1.getId();
        };
        return ListExtensions.<IInstallableUnit, String>map(it.getResolvedIUs(), _function_1);
      };
      final String[] ids = ((String[])Conversions.unwrapArray(Iterables.<String>concat(ListExtensions.<ResolvedLocation, List<String>>map(targetDef.getLocations(), _function)), String.class));
      Assert.assertEquals(1, ((List<String>)Conversions.doWrapArray(ids)).size());
      Assert.assertEquals("org.eclipse.emf.compare.ide.ui.feature.group", IterableExtensions.<Object>head(((Iterable<Object>)Conversions.doWrapArray(ids))));
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
      final TargetPlatform tp1 = this.parser.parse(_builder, org.eclipse.emf.common.util.URI.createURI("tmp:/tp1.tpd"), resourceSet);
      final ResolvedTargetPlatform targetDef = ResolvedTargetPlatform.create(tp1, this.indexBuilder);
      MockMetadataRepositoryManager _mockMetadataRepositoryManager = new MockMetadataRepositoryManager(new IQueryResultProvider<IInstallableUnit>() {
        @Override
        public List<IInstallableUnit> listIUs(final URI location) {
          List<IInstallableUnit> _xifexpression = null;
          boolean _equals = "http://download.eclipse.org/modeling/emf/compare/updates/releases/2.1/R201310031412/".equals(location.toString());
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
      Assert.assertEquals("TP1", targetDef.getName());
      Assert.assertEquals(1, targetDef.getLocations().size());
      final Function1<ResolvedLocation, List<String>> _function = (ResolvedLocation it) -> {
        final Function1<IInstallableUnit, String> _function_1 = (IInstallableUnit it_1) -> {
          return it_1.getId();
        };
        return ListExtensions.<IInstallableUnit, String>map(it.getResolvedIUs(), _function_1);
      };
      final String[] ids = ((String[])Conversions.unwrapArray(Iterables.<String>concat(ListExtensions.<ResolvedLocation, List<String>>map(targetDef.getLocations(), _function)), String.class));
      Assert.assertEquals(1, ((List<String>)Conversions.doWrapArray(ids)).size());
      Assert.assertEquals("org.eclipse.emf.compare.ide.ui.feature.group", IterableExtensions.<Object>head(((Iterable<Object>)Conversions.doWrapArray(ids))));
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
      final TargetPlatform tp1 = this.parser.parse(_builder, org.eclipse.emf.common.util.URI.createURI("tmp:/tp1.tpd"), resourceSet);
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
      this.parser.parse(_builder_1, org.eclipse.emf.common.util.URI.createURI("tmp:/tp2.tpd"), resourceSet);
      final ResolvedTargetPlatform targetDef = ResolvedTargetPlatform.create(tp1, this.indexBuilder);
      MockMetadataRepositoryManager _mockMetadataRepositoryManager = new MockMetadataRepositoryManager(new IQueryResultProvider<IInstallableUnit>() {
        @Override
        public List<IInstallableUnit> listIUs(final URI location) {
          List<IInstallableUnit> _xifexpression = null;
          boolean _equals = "http://download.eclipse.org/tools/orbit/downloads/drops/R20130517111416/repository/".equals(location.toString());
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
      Assert.assertEquals("TP1", targetDef.getName());
      Assert.assertEquals(1, targetDef.getLocations().size());
      final Function1<ResolvedLocation, List<String>> _function = (ResolvedLocation it) -> {
        final Function1<IInstallableUnit, String> _function_1 = (IInstallableUnit it_1) -> {
          return it_1.getId();
        };
        return ListExtensions.<IInstallableUnit, String>map(it.getResolvedIUs(), _function_1);
      };
      final String[] ids = ((String[])Conversions.unwrapArray(Iterables.<String>concat(ListExtensions.<ResolvedLocation, List<String>>map(targetDef.getLocations(), _function)), String.class));
      final Function1<ResolvedLocation, List<Version>> _function_1 = (ResolvedLocation it) -> {
        final Function1<IInstallableUnit, Version> _function_2 = (IInstallableUnit it_1) -> {
          return it_1.getVersion();
        };
        return ListExtensions.<IInstallableUnit, Version>map(it.getResolvedIUs(), _function_2);
      };
      final Version[] versions = ((Version[])Conversions.unwrapArray(Iterables.<Version>concat(ListExtensions.<ResolvedLocation, List<Version>>map(targetDef.getLocations(), _function_1)), Version.class));
      Assert.assertEquals(1, ((List<String>)Conversions.doWrapArray(ids)).size());
      Assert.assertEquals("com.google.guava", IterableExtensions.<Object>head(((Iterable<Object>)Conversions.doWrapArray(ids))));
      Assert.assertEquals("12.0.0", IterableExtensions.<Version>head(((Iterable<Version>)Conversions.doWrapArray(versions))).toString());
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
      final TargetPlatform tp1 = this.parser.parse(_builder, org.eclipse.emf.common.util.URI.createURI("tmp:/tp1.tpd"), resourceSet);
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
      this.parser.parse(_builder_1, org.eclipse.emf.common.util.URI.createURI("tmp:/tp2.tpd"), resourceSet);
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
      this.parser.parse(_builder_2, org.eclipse.emf.common.util.URI.createURI("tmp:/tp3.tpd"), resourceSet);
      final ResolvedTargetPlatform targetDef = ResolvedTargetPlatform.create(tp1, this.indexBuilder);
      MockMetadataRepositoryManager _mockMetadataRepositoryManager = new MockMetadataRepositoryManager(new IQueryResultProvider<IInstallableUnit>() {
        @Override
        public List<IInstallableUnit> listIUs(final URI location) {
          List<IInstallableUnit> _xifexpression = null;
          boolean _equals = "http://download.eclipse.org/tools/orbit/downloads/drops/R20130517111416/repository/".equals(location.toString());
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
      Assert.assertEquals("TP1", targetDef.getName());
      Assert.assertEquals(1, targetDef.getLocations().size());
      final Function1<ResolvedLocation, List<String>> _function = (ResolvedLocation it) -> {
        final Function1<IInstallableUnit, String> _function_1 = (IInstallableUnit it_1) -> {
          return it_1.getId();
        };
        return ListExtensions.<IInstallableUnit, String>map(it.getResolvedIUs(), _function_1);
      };
      final String[] ids = ((String[])Conversions.unwrapArray(Iterables.<String>concat(ListExtensions.<ResolvedLocation, List<String>>map(targetDef.getLocations(), _function)), String.class));
      final Function1<ResolvedLocation, List<Version>> _function_1 = (ResolvedLocation it) -> {
        final Function1<IInstallableUnit, Version> _function_2 = (IInstallableUnit it_1) -> {
          return it_1.getVersion();
        };
        return ListExtensions.<IInstallableUnit, Version>map(it.getResolvedIUs(), _function_2);
      };
      final Version[] versions = ((Version[])Conversions.unwrapArray(Iterables.<Version>concat(ListExtensions.<ResolvedLocation, List<Version>>map(targetDef.getLocations(), _function_1)), Version.class));
      Assert.assertEquals(1, ((List<String>)Conversions.doWrapArray(ids)).size());
      Assert.assertEquals("com.google.guava", IterableExtensions.<Object>head(((Iterable<Object>)Conversions.doWrapArray(ids))));
      Assert.assertEquals("12.0.0", IterableExtensions.<Version>head(((Iterable<Version>)Conversions.doWrapArray(versions))).toString());
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
      final TargetPlatform tp1 = this.parser.parse(_builder, org.eclipse.emf.common.util.URI.createURI("tmp:/tp1.tpd"), resourceSet);
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
      this.parser.parse(_builder_1, org.eclipse.emf.common.util.URI.createURI("tmp:/tp2.tpd"), resourceSet);
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
      this.parser.parse(_builder_2, org.eclipse.emf.common.util.URI.createURI("tmp:/tp3.tpd"), resourceSet);
      final ResolvedTargetPlatform targetDef = ResolvedTargetPlatform.create(tp1, this.indexBuilder);
      MockMetadataRepositoryManager _mockMetadataRepositoryManager = new MockMetadataRepositoryManager(new IQueryResultProvider<IInstallableUnit>() {
        @Override
        public List<IInstallableUnit> listIUs(final URI location) {
          List<IInstallableUnit> _xifexpression = null;
          boolean _equals = "http://download.eclipse.org/tools/orbit/downloads/drops/R20130517111416/repository/".equals(location.toString());
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
      Assert.assertEquals("TP1", targetDef.getName());
      Assert.assertEquals(1, targetDef.getLocations().size());
      final Function1<ResolvedLocation, List<String>> _function = (ResolvedLocation it) -> {
        final Function1<IInstallableUnit, String> _function_1 = (IInstallableUnit it_1) -> {
          return it_1.getId();
        };
        return ListExtensions.<IInstallableUnit, String>map(it.getResolvedIUs(), _function_1);
      };
      final String[] ids = ((String[])Conversions.unwrapArray(Iterables.<String>concat(ListExtensions.<ResolvedLocation, List<String>>map(targetDef.getLocations(), _function)), String.class));
      final Function1<ResolvedLocation, List<Version>> _function_1 = (ResolvedLocation it) -> {
        final Function1<IInstallableUnit, Version> _function_2 = (IInstallableUnit it_1) -> {
          return it_1.getVersion();
        };
        return ListExtensions.<IInstallableUnit, Version>map(it.getResolvedIUs(), _function_2);
      };
      final Version[] versions = ((Version[])Conversions.unwrapArray(Iterables.<Version>concat(ListExtensions.<ResolvedLocation, List<Version>>map(targetDef.getLocations(), _function_1)), Version.class));
      Assert.assertEquals(1, ((List<String>)Conversions.doWrapArray(ids)).size());
      Assert.assertEquals("com.google.guava", IterableExtensions.<Object>head(((Iterable<Object>)Conversions.doWrapArray(ids))));
      Assert.assertEquals("11.0.2", IterableExtensions.<Version>head(((Iterable<Version>)Conversions.doWrapArray(versions))).toString());
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
      final TargetPlatform tp1 = this.parser.parse(_builder, org.eclipse.emf.common.util.URI.createURI("tmp:/tp1.tpd"), resourceSet);
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
      this.parser.parse(_builder_1, org.eclipse.emf.common.util.URI.createURI("tmp:/tp2.tpd"), resourceSet);
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
      this.parser.parse(_builder_2, org.eclipse.emf.common.util.URI.createURI("tmp:/tp3.tpd"), resourceSet);
      final ResolvedTargetPlatform targetDef = ResolvedTargetPlatform.create(tp1, this.indexBuilder);
      MockMetadataRepositoryManager _mockMetadataRepositoryManager = new MockMetadataRepositoryManager(new IQueryResultProvider<IInstallableUnit>() {
        @Override
        public List<IInstallableUnit> listIUs(final URI location) {
          List<IInstallableUnit> _xifexpression = null;
          boolean _equals = "http://download.eclipse.org/tools/orbit/downloads/drops/R20130517111416/repository/".equals(location.toString());
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
      Assert.assertEquals("TP1", targetDef.getName());
      Assert.assertEquals(1, targetDef.getLocations().size());
      final Function1<ResolvedLocation, List<String>> _function = (ResolvedLocation it) -> {
        final Function1<IInstallableUnit, String> _function_1 = (IInstallableUnit it_1) -> {
          return it_1.getId();
        };
        return ListExtensions.<IInstallableUnit, String>map(it.getResolvedIUs(), _function_1);
      };
      final String[] ids = ((String[])Conversions.unwrapArray(Iterables.<String>concat(ListExtensions.<ResolvedLocation, List<String>>map(targetDef.getLocations(), _function)), String.class));
      final Function1<ResolvedLocation, List<Version>> _function_1 = (ResolvedLocation it) -> {
        final Function1<IInstallableUnit, Version> _function_2 = (IInstallableUnit it_1) -> {
          return it_1.getVersion();
        };
        return ListExtensions.<IInstallableUnit, Version>map(it.getResolvedIUs(), _function_2);
      };
      final Version[] versions = ((Version[])Conversions.unwrapArray(Iterables.<Version>concat(ListExtensions.<ResolvedLocation, List<Version>>map(targetDef.getLocations(), _function_1)), Version.class));
      Assert.assertEquals(1, ((List<String>)Conversions.doWrapArray(ids)).size());
      Assert.assertEquals("com.google.guava", IterableExtensions.<Object>head(((Iterable<Object>)Conversions.doWrapArray(ids))));
      Assert.assertEquals("11.0.2", IterableExtensions.<Version>head(((Iterable<Version>)Conversions.doWrapArray(versions))).toString());
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
      final TargetPlatform tp1 = this.parser.parse(_builder, org.eclipse.emf.common.util.URI.createURI("tmp:/tp1.tpd"), resourceSet);
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
      this.parser.parse(_builder_1, org.eclipse.emf.common.util.URI.createURI("tmp:/tp2.tpd"), resourceSet);
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
      this.parser.parse(_builder_2, org.eclipse.emf.common.util.URI.createURI("tmp:/tp3.tpd"), resourceSet);
      final ResolvedTargetPlatform targetDef = ResolvedTargetPlatform.create(tp1, this.indexBuilder);
      MockMetadataRepositoryManager _mockMetadataRepositoryManager = new MockMetadataRepositoryManager(new IQueryResultProvider<IInstallableUnit>() {
        @Override
        public List<IInstallableUnit> listIUs(final URI location) {
          List<IInstallableUnit> _xifexpression = null;
          boolean _equals = "http://download.eclipse.org/tools/orbit/downloads/drops/R20130517111416/repository/".equals(location.toString());
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
      Assert.assertEquals("TP1", targetDef.getName());
      Assert.assertEquals(1, targetDef.getLocations().size());
      final Function1<ResolvedLocation, List<String>> _function = (ResolvedLocation it) -> {
        final Function1<IInstallableUnit, String> _function_1 = (IInstallableUnit it_1) -> {
          return it_1.getId();
        };
        return ListExtensions.<IInstallableUnit, String>map(it.getResolvedIUs(), _function_1);
      };
      final String[] ids = ((String[])Conversions.unwrapArray(Iterables.<String>concat(ListExtensions.<ResolvedLocation, List<String>>map(targetDef.getLocations(), _function)), String.class));
      final Function1<ResolvedLocation, List<Version>> _function_1 = (ResolvedLocation it) -> {
        final Function1<IInstallableUnit, Version> _function_2 = (IInstallableUnit it_1) -> {
          return it_1.getVersion();
        };
        return ListExtensions.<IInstallableUnit, Version>map(it.getResolvedIUs(), _function_2);
      };
      final Version[] versions = ((Version[])Conversions.unwrapArray(Iterables.<Version>concat(ListExtensions.<ResolvedLocation, List<Version>>map(targetDef.getLocations(), _function_1)), Version.class));
      Assert.assertEquals(1, ((List<String>)Conversions.doWrapArray(ids)).size());
      Assert.assertEquals("com.google.guava", IterableExtensions.<Object>head(((Iterable<Object>)Conversions.doWrapArray(ids))));
      Assert.assertEquals("12.0.0", IterableExtensions.<Version>head(((Iterable<Version>)Conversions.doWrapArray(versions))).toString());
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
      final TargetPlatform tp1 = this.parser.parse(_builder, org.eclipse.emf.common.util.URI.createURI("tmp:/tp1.tpd"), resourceSet);
      final ResolvedTargetPlatform targetDef = ResolvedTargetPlatform.create(tp1, this.indexBuilder);
      MockMetadataRepositoryManager _mockMetadataRepositoryManager = new MockMetadataRepositoryManager(new IQueryResultProvider<IInstallableUnit>() {
        @Override
        public List<IInstallableUnit> listIUs(final URI location) {
          List<IInstallableUnit> _xifexpression = null;
          boolean _equals = "http://download.eclipse.org/tools/orbit/downloads/drops/R20130517111416/repository/".equals(location.toString());
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
      Assert.assertEquals("TP1", targetDef.getName());
      Assert.assertEquals(1, targetDef.getLocations().size());
      final Function1<ResolvedLocation, List<String>> _function = (ResolvedLocation it) -> {
        final Function1<IInstallableUnit, String> _function_1 = (IInstallableUnit it_1) -> {
          return it_1.getId();
        };
        return ListExtensions.<IInstallableUnit, String>map(it.getResolvedIUs(), _function_1);
      };
      final String[] ids = ((String[])Conversions.unwrapArray(Iterables.<String>concat(ListExtensions.<ResolvedLocation, List<String>>map(targetDef.getLocations(), _function)), String.class));
      final Function1<ResolvedLocation, List<Version>> _function_1 = (ResolvedLocation it) -> {
        final Function1<IInstallableUnit, Version> _function_2 = (IInstallableUnit it_1) -> {
          return it_1.getVersion();
        };
        return ListExtensions.<IInstallableUnit, Version>map(it.getResolvedIUs(), _function_2);
      };
      final Version[] versions = ((Version[])Conversions.unwrapArray(Iterables.<Version>concat(ListExtensions.<ResolvedLocation, List<Version>>map(targetDef.getLocations(), _function_1)), Version.class));
      Assert.assertEquals(1, ((List<String>)Conversions.doWrapArray(ids)).size());
      Assert.assertEquals("com.google.guava", IterableExtensions.<Object>head(((Iterable<Object>)Conversions.doWrapArray(ids))));
      Assert.assertEquals("11.0.2", IterableExtensions.<Version>head(((Iterable<Version>)Conversions.doWrapArray(versions))).toString());
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
      final TargetPlatform tp1 = this.parser.parse(_builder, org.eclipse.emf.common.util.URI.createURI("tmp:/tp1.tpd"), resourceSet);
      final ResolvedTargetPlatform targetDef = ResolvedTargetPlatform.create(tp1, this.indexBuilder);
      MockMetadataRepositoryManager _mockMetadataRepositoryManager = new MockMetadataRepositoryManager(new IQueryResultProvider<IInstallableUnit>() {
        @Override
        public List<IInstallableUnit> listIUs(final URI location) {
          List<IInstallableUnit> _xifexpression = null;
          boolean _equals = "http://download.eclipse.org/tools/orbit/downloads/drops/R20130517111416/repository/".equals(location.toString());
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
      Assert.assertEquals("TP1", targetDef.getName());
      Assert.assertEquals(1, targetDef.getLocations().size());
      final Function1<ResolvedLocation, List<String>> _function = (ResolvedLocation it) -> {
        final Function1<IInstallableUnit, String> _function_1 = (IInstallableUnit it_1) -> {
          return it_1.getId();
        };
        return ListExtensions.<IInstallableUnit, String>map(it.getResolvedIUs(), _function_1);
      };
      final String[] ids = ((String[])Conversions.unwrapArray(Iterables.<String>concat(ListExtensions.<ResolvedLocation, List<String>>map(targetDef.getLocations(), _function)), String.class));
      final Function1<ResolvedLocation, List<Version>> _function_1 = (ResolvedLocation it) -> {
        final Function1<IInstallableUnit, Version> _function_2 = (IInstallableUnit it_1) -> {
          return it_1.getVersion();
        };
        return ListExtensions.<IInstallableUnit, Version>map(it.getResolvedIUs(), _function_2);
      };
      final Version[] versions = ((Version[])Conversions.unwrapArray(Iterables.<Version>concat(ListExtensions.<ResolvedLocation, List<Version>>map(targetDef.getLocations(), _function_1)), Version.class));
      Assert.assertEquals(1, ((List<String>)Conversions.doWrapArray(ids)).size());
      Assert.assertEquals("com.google.guava", IterableExtensions.<Object>head(((Iterable<Object>)Conversions.doWrapArray(ids))));
      Assert.assertEquals("12.0.0", IterableExtensions.<Version>head(((Iterable<Version>)Conversions.doWrapArray(versions))).toString());
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
      final TargetPlatform tp1 = this.parser.parse(_builder, org.eclipse.emf.common.util.URI.createURI("tmp:/tp1.tpd"), resourceSet);
      final ResolvedTargetPlatform targetDef = ResolvedTargetPlatform.create(tp1, this.indexBuilder);
      MockMetadataRepositoryManager _mockMetadataRepositoryManager = new MockMetadataRepositoryManager(new IQueryResultProvider<IInstallableUnit>() {
        @Override
        public List<IInstallableUnit> listIUs(final URI location) {
          List<IInstallableUnit> _xifexpression = null;
          boolean _equals = "http://download.eclipse.org/tools/orbit/downloads/drops/R20130517111416/repository/".equals(location.toString());
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
      Assert.assertEquals("TP1", targetDef.getName());
      Assert.assertEquals(1, targetDef.getLocations().size());
      final Function1<ResolvedLocation, List<String>> _function = (ResolvedLocation it) -> {
        final Function1<IInstallableUnit, String> _function_1 = (IInstallableUnit it_1) -> {
          return it_1.getId();
        };
        return ListExtensions.<IInstallableUnit, String>map(it.getResolvedIUs(), _function_1);
      };
      final String[] ids = ((String[])Conversions.unwrapArray(Iterables.<String>concat(ListExtensions.<ResolvedLocation, List<String>>map(targetDef.getLocations(), _function)), String.class));
      final Function1<ResolvedLocation, List<Version>> _function_1 = (ResolvedLocation it) -> {
        final Function1<IInstallableUnit, Version> _function_2 = (IInstallableUnit it_1) -> {
          return it_1.getVersion();
        };
        return ListExtensions.<IInstallableUnit, Version>map(it.getResolvedIUs(), _function_2);
      };
      final Version[] versions = ((Version[])Conversions.unwrapArray(Iterables.<Version>concat(ListExtensions.<ResolvedLocation, List<Version>>map(targetDef.getLocations(), _function_1)), Version.class));
      Assert.assertEquals(1, ((List<String>)Conversions.doWrapArray(ids)).size());
      Assert.assertEquals("com.google.guava", IterableExtensions.<Object>head(((Iterable<Object>)Conversions.doWrapArray(ids))));
      Assert.assertEquals("11.0.2", IterableExtensions.<Version>head(((Iterable<Version>)Conversions.doWrapArray(versions))).toString());
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
      final TargetPlatform tp1 = this.parser.parse(_builder, org.eclipse.emf.common.util.URI.createURI("tmp:/tp1.tpd"), resourceSet);
      final ResolvedTargetPlatform targetDef = ResolvedTargetPlatform.create(tp1, this.indexBuilder);
      MockMetadataRepositoryManager _mockMetadataRepositoryManager = new MockMetadataRepositoryManager(new IQueryResultProvider<IInstallableUnit>() {
        @Override
        public List<IInstallableUnit> listIUs(final URI location) {
          List<IInstallableUnit> _xifexpression = null;
          boolean _equals = "http://download.eclipse.org/tools/orbit/downloads/drops/R20130517111416/repository/".equals(location.toString());
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
      Assert.assertEquals("TP1", targetDef.getName());
      Assert.assertEquals(1, targetDef.getLocations().size());
      final Function1<ResolvedLocation, List<String>> _function = (ResolvedLocation it) -> {
        final Function1<IInstallableUnit, String> _function_1 = (IInstallableUnit it_1) -> {
          return it_1.getId();
        };
        return ListExtensions.<IInstallableUnit, String>map(it.getResolvedIUs(), _function_1);
      };
      final String[] ids = ((String[])Conversions.unwrapArray(Iterables.<String>concat(ListExtensions.<ResolvedLocation, List<String>>map(targetDef.getLocations(), _function)), String.class));
      final Function1<ResolvedLocation, List<Version>> _function_1 = (ResolvedLocation it) -> {
        final Function1<IInstallableUnit, Version> _function_2 = (IInstallableUnit it_1) -> {
          return it_1.getVersion();
        };
        return ListExtensions.<IInstallableUnit, Version>map(it.getResolvedIUs(), _function_2);
      };
      final Version[] versions = ((Version[])Conversions.unwrapArray(Iterables.<Version>concat(ListExtensions.<ResolvedLocation, List<Version>>map(targetDef.getLocations(), _function_1)), Version.class));
      Assert.assertEquals(1, ((List<String>)Conversions.doWrapArray(ids)).size());
      Assert.assertEquals("com.google.guava", IterableExtensions.<Object>head(((Iterable<Object>)Conversions.doWrapArray(ids))));
      Assert.assertEquals("12.0.0", IterableExtensions.<Version>head(((Iterable<Version>)Conversions.doWrapArray(versions))).toString());
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
        @Override
        public List<IInstallableUnit> listIUs(final URI location) {
          List<IInstallableUnit> _xifexpression = null;
          boolean _equals = "http://download.eclipse.org/tools/orbit/downloads/drops/R20130517111416/repository/".equals(location.toString());
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
      Assert.assertEquals("TP1", targetDef.getName());
      Assert.assertEquals(1, targetDef.getLocations().size());
      final Function1<ResolvedLocation, List<String>> _function = (ResolvedLocation it) -> {
        final Function1<IInstallableUnit, String> _function_1 = (IInstallableUnit it_1) -> {
          return it_1.getId();
        };
        return ListExtensions.<IInstallableUnit, String>map(it.getResolvedIUs(), _function_1);
      };
      final String[] ids = ((String[])Conversions.unwrapArray(Iterables.<String>concat(ListExtensions.<ResolvedLocation, List<String>>map(targetDef.getLocations(), _function)), String.class));
      Assert.assertEquals(1, ((List<String>)Conversions.doWrapArray(ids)).size());
      Assert.assertEquals("com.google.guava", IterableExtensions.<Object>head(((Iterable<Object>)Conversions.doWrapArray(ids))));
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
        @Override
        public List<IInstallableUnit> listIUs(final URI location) {
          List<IInstallableUnit> _xifexpression = null;
          boolean _equals = "http://download.eclipse.org/tools/orbit/downloads/drops/R20130517111416/repository/".equals(location.toString());
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
      Assert.assertEquals("TP1", targetDef.getName());
      Assert.assertEquals(1, targetDef.getLocations().size());
      final Function1<ResolvedLocation, List<String>> _function = (ResolvedLocation it) -> {
        final Function1<IInstallableUnit, String> _function_1 = (IInstallableUnit it_1) -> {
          return it_1.getId();
        };
        return ListExtensions.<IInstallableUnit, String>map(it.getResolvedIUs(), _function_1);
      };
      final String[] ids = ((String[])Conversions.unwrapArray(Iterables.<String>concat(ListExtensions.<ResolvedLocation, List<String>>map(targetDef.getLocations(), _function)), String.class));
      Assert.assertEquals(2, ((List<String>)Conversions.doWrapArray(ids)).size());
      Assert.assertEquals("com.google.guava", IterableExtensions.<Object>head(((Iterable<Object>)Conversions.doWrapArray(ids))));
      Assert.assertEquals("com.google.guava.source", ids[1]);
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
        @Override
        public List<IInstallableUnit> listIUs(final URI location) {
          List<IInstallableUnit> _xifexpression = null;
          boolean _equals = "http://download.eclipse.org/modeling/emf/compare/updates/releases/2.1/R201310031412/".equals(location.toString());
          if (_equals) {
            _xifexpression = CollectionLiterals.<IInstallableUnit>newImmutableList(
              MockIU.createFeature("org.eclipse.emf.compare.rcp.ui.feature.group", Version.createOSGi(10, 0, 0)), 
              MockIU.createFeature("org.eclipse.emf.compare.rcp.ui.source.feature.group", Version.createOSGi(10, 0, 0)));
          } else {
            return CollectionLiterals.<IInstallableUnit>emptyList();
          }
          return _xifexpression;
        }
      });
      NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
      targetDef.resolve(_mockMetadataRepositoryManager, _nullProgressMonitor);
      Assert.assertEquals("TP1", targetDef.getName());
      Assert.assertEquals(1, targetDef.getLocations().size());
      final Function1<ResolvedLocation, List<String>> _function = (ResolvedLocation it) -> {
        final Function1<IInstallableUnit, String> _function_1 = (IInstallableUnit it_1) -> {
          return it_1.getId();
        };
        return ListExtensions.<IInstallableUnit, String>map(it.getResolvedIUs(), _function_1);
      };
      final String[] ids = ((String[])Conversions.unwrapArray(Iterables.<String>concat(ListExtensions.<ResolvedLocation, List<String>>map(targetDef.getLocations(), _function)), String.class));
      Assert.assertEquals(1, ((List<String>)Conversions.doWrapArray(ids)).size());
      Assert.assertEquals("org.eclipse.emf.compare.rcp.ui.feature.group", IterableExtensions.<Object>head(((Iterable<Object>)Conversions.doWrapArray(ids))));
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
        @Override
        public List<IInstallableUnit> listIUs(final URI location) {
          List<IInstallableUnit> _xifexpression = null;
          boolean _equals = "http://download.eclipse.org/modeling/emf/compare/updates/releases/2.1/R201310031412/".equals(location.toString());
          if (_equals) {
            _xifexpression = CollectionLiterals.<IInstallableUnit>newImmutableList(
              MockIU.createFeature("org.eclipse.emf.compare.rcp.ui.feature.group", Version.createOSGi(10, 0, 0)), 
              MockIU.createFeature("org.eclipse.emf.compare.rcp.ui.source.feature.group", Version.createOSGi(10, 0, 0)));
          } else {
            return CollectionLiterals.<IInstallableUnit>emptyList();
          }
          return _xifexpression;
        }
      });
      NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
      targetDef.resolve(_mockMetadataRepositoryManager, _nullProgressMonitor);
      Assert.assertEquals("TP1", targetDef.getName());
      Assert.assertEquals(1, targetDef.getLocations().size());
      final Function1<ResolvedLocation, List<String>> _function = (ResolvedLocation it) -> {
        final Function1<IInstallableUnit, String> _function_1 = (IInstallableUnit it_1) -> {
          return it_1.getId();
        };
        return ListExtensions.<IInstallableUnit, String>map(it.getResolvedIUs(), _function_1);
      };
      final String[] ids = ((String[])Conversions.unwrapArray(Iterables.<String>concat(ListExtensions.<ResolvedLocation, List<String>>map(targetDef.getLocations(), _function)), String.class));
      Assert.assertEquals(2, ((List<String>)Conversions.doWrapArray(ids)).size());
      Assert.assertEquals("org.eclipse.emf.compare.rcp.ui.feature.group", IterableExtensions.<Object>head(((Iterable<Object>)Conversions.doWrapArray(ids))));
      Assert.assertEquals("org.eclipse.emf.compare.rcp.ui.source.feature.group", ids[1]);
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
        @Override
        public List<IInstallableUnit> listIUs(final URI location) {
          return CollectionLiterals.<IInstallableUnit>emptyList();
        }
      });
      NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
      targetDef.resolve(_mockMetadataRepositoryManager, _nullProgressMonitor);
      Assert.assertEquals("http://download.eclipse.org/egit/updates-3.3", targetDef.getLocations().get(0).getURI().toString());
      Assert.assertEquals("http://download.eclipse.org/modeling/emf/emf/updates/2.9.x/core/R201402030812/", targetDef.getLocations().get(1).getURI().toString());
      Assert.assertEquals("http://download.eclipse.org/modeling/emf/compare/updates/releases/2.1/R201310031412/", targetDef.getLocations().get(2).getURI().toString());
      Assert.assertEquals("http://download.eclipse.org/tools/orbit/downloads/drops/R20130517111416/repository/", targetDef.getLocations().get(3).getURI().toString());
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
      final TargetPlatform tp1 = this.parser.parse(_builder, org.eclipse.emf.common.util.URI.createURI("tmp:/tp1.tpd"), resourceSet);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("target \"TP2\"");
      _builder_1.newLine();
      _builder_1.append("location \"http://mbarbero.github.io/org.eclipse.cbi.targetplatform/p2/latest/\"");
      _builder_1.newLine();
      _builder_1.append("location \"http://download.eclipse.org/egit/updates-3.3\"");
      _builder_1.newLine();
      _builder_1.append("location \"http://download.eclipse.org/sirius/updates/releases/0.9.0/kepler\"");
      _builder_1.newLine();
      this.parser.parse(_builder_1, org.eclipse.emf.common.util.URI.createURI("tmp:/tp2.tpd"), resourceSet);
      final ResolvedTargetPlatform targetDef = ResolvedTargetPlatform.create(tp1, this.indexBuilder);
      MockMetadataRepositoryManager _mockMetadataRepositoryManager = new MockMetadataRepositoryManager(new IQueryResultProvider<IInstallableUnit>() {
        @Override
        public List<IInstallableUnit> listIUs(final URI location) {
          return CollectionLiterals.<IInstallableUnit>emptyList();
        }
      });
      NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
      targetDef.resolve(_mockMetadataRepositoryManager, _nullProgressMonitor);
      Assert.assertEquals("http://mbarbero.github.io/fr.obeo.releng.targetplatform/p2/latest/", targetDef.getLocations().get(0).getURI().toString());
      Assert.assertEquals("http://download.eclipse.org/egit/updates-3.3", targetDef.getLocations().get(1).getURI().toString());
      Assert.assertEquals("http://download.eclipse.org/sirius/updates/releases/0.9.0/kepler", targetDef.getLocations().get(2).getURI().toString());
      Assert.assertEquals("http://download.eclipse.org/modeling/emf/emf/updates/2.9.x/core/R201402030812/", targetDef.getLocations().get(3).getURI().toString());
      Assert.assertEquals("http://download.eclipse.org/modeling/emf/compare/updates/releases/2.1/R201310031412/", targetDef.getLocations().get(4).getURI().toString());
      Assert.assertEquals("http://download.eclipse.org/tools/orbit/downloads/drops/R20130517111416/repository/", targetDef.getLocations().get(5).getURI().toString());
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
      final TargetPlatform tp1 = this.parser.parse(_builder, org.eclipse.emf.common.util.URI.createURI("tmp:/tp1.tpd"), resourceSet);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("target \"TP2\"");
      _builder_1.newLine();
      _builder_1.append("include \"tp3.tpd\"");
      _builder_1.newLine();
      _builder_1.append("location \"http://mbarbero.github.io/org.eclipse.cbi.targetplatform/p2/latest/\"");
      _builder_1.newLine();
      _builder_1.append("location \"http://download.eclipse.org/egit/updates-3.3\"");
      _builder_1.newLine();
      this.parser.parse(_builder_1, org.eclipse.emf.common.util.URI.createURI("tmp:/tp2.tpd"), resourceSet);
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("target \"TP3\"");
      _builder_2.newLine();
      _builder_2.append("location \"http://download.eclipse.org/tools/orbit/downloads/drops/R20130517111416/repository/\"");
      _builder_2.newLine();
      _builder_2.append("location \"http://download.eclipse.org/sirius/updates/releases/0.9.0/kepler\"");
      _builder_2.newLine();
      this.parser.parse(_builder_2, org.eclipse.emf.common.util.URI.createURI("tmp:/tp3.tpd"), resourceSet);
      final ResolvedTargetPlatform targetDef = ResolvedTargetPlatform.create(tp1, this.indexBuilder);
      MockMetadataRepositoryManager _mockMetadataRepositoryManager = new MockMetadataRepositoryManager(new IQueryResultProvider<IInstallableUnit>() {
        @Override
        public List<IInstallableUnit> listIUs(final URI location) {
          return CollectionLiterals.<IInstallableUnit>emptyList();
        }
      });
      NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
      targetDef.resolve(_mockMetadataRepositoryManager, _nullProgressMonitor);
      Assert.assertEquals("http://download.eclipse.org/tools/orbit/downloads/drops/R20130517111416/repository/", targetDef.getLocations().get(0).getURI().toString());
      Assert.assertEquals("http://download.eclipse.org/sirius/updates/releases/0.9.0/kepler", targetDef.getLocations().get(1).getURI().toString());
      Assert.assertEquals("http://mbarbero.github.io/fr.obeo.releng.targetplatform/p2/latest/", targetDef.getLocations().get(2).getURI().toString());
      Assert.assertEquals("http://download.eclipse.org/egit/updates-3.3", targetDef.getLocations().get(3).getURI().toString());
      Assert.assertEquals("http://download.eclipse.org/modeling/emf/emf/updates/2.9.x/core/R201402030812/", targetDef.getLocations().get(4).getURI().toString());
      Assert.assertEquals("http://download.eclipse.org/modeling/emf/compare/updates/releases/2.1/R201310031412/", targetDef.getLocations().get(5).getURI().toString());
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
      final TargetPlatform tp1 = this.parser.parse(_builder, org.eclipse.emf.common.util.URI.createURI("tmp:/tp1.tpd"), resourceSet);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("target \"TP2\"");
      _builder_1.newLine();
      _builder_1.append("location \"http://mbarbero.github.io/org.eclipse.cbi.targetplatform/p2/latest/\"");
      _builder_1.newLine();
      _builder_1.append("location \"http://download.eclipse.org/egit/updates-3.3\"");
      _builder_1.newLine();
      this.parser.parse(_builder_1, org.eclipse.emf.common.util.URI.createURI("tmp:/tp2.tpd"), resourceSet);
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("target \"TP3\"");
      _builder_2.newLine();
      _builder_2.append("location \"http://download.eclipse.org/tools/orbit/downloads/drops/R20130517111416/repository/\"");
      _builder_2.newLine();
      _builder_2.append("location \"http://download.eclipse.org/sirius/updates/releases/0.9.0/kepler\"");
      _builder_2.newLine();
      this.parser.parse(_builder_2, org.eclipse.emf.common.util.URI.createURI("tmp:/tp3.tpd"), resourceSet);
      final ResolvedTargetPlatform targetDef = ResolvedTargetPlatform.create(tp1, this.indexBuilder);
      MockMetadataRepositoryManager _mockMetadataRepositoryManager = new MockMetadataRepositoryManager(new IQueryResultProvider<IInstallableUnit>() {
        @Override
        public List<IInstallableUnit> listIUs(final URI location) {
          return CollectionLiterals.<IInstallableUnit>emptyList();
        }
      });
      NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
      targetDef.resolve(_mockMetadataRepositoryManager, _nullProgressMonitor);
      Assert.assertEquals("http://download.eclipse.org/tools/orbit/downloads/drops/R20130517111416/repository/", targetDef.getLocations().get(0).getURI().toString());
      Assert.assertEquals("http://download.eclipse.org/sirius/updates/releases/0.9.0/kepler", targetDef.getLocations().get(1).getURI().toString());
      Assert.assertEquals("http://mbarbero.github.io/org.eclipse.cbi.targetplatform/p2/latest/", targetDef.getLocations().get(2).getURI().toString());
      Assert.assertEquals("http://download.eclipse.org/egit/updates-3.3", targetDef.getLocations().get(3).getURI().toString());
      Assert.assertEquals("http://download.eclipse.org/modeling/emf/emf/updates/2.9.x/core/R201402030812/", targetDef.getLocations().get(4).getURI().toString());
      Assert.assertEquals("http://download.eclipse.org/modeling/emf/compare/updates/releases/2.1/R201310031412/", targetDef.getLocations().get(5).getURI().toString());
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
        @Override
        public List<IInstallableUnit> listIUs(final URI location) {
          List<IInstallableUnit> _xifexpression = null;
          boolean _equals = "http://download.eclipse.org/egit/updates-3.3".equals(location.toString());
          if (_equals) {
            _xifexpression = CollectionLiterals.<IInstallableUnit>newImmutableList(
              MockIU.createFeature("org.eclipse.egit.feature.group", Version.createOSGi(3, 3, 2)), 
              MockIU.createFeature("org.eclipse.egit.mylyn.feature.group", Version.createOSGi(3, 3, 2)));
          } else {
            List<IInstallableUnit> _xifexpression_1 = null;
            boolean _equals_1 = "http://download.eclipse.org/tools/orbit/downloads/drops/R20130517111416/repository/".equals(location.toString());
            if (_equals_1) {
              _xifexpression_1 = CollectionLiterals.<IInstallableUnit>newImmutableList(
                MockIU.createFeature("com.google.guava", Version.createOSGi(10, 0, 0)), 
                MockIU.createFeature("com.google.guava", Version.createOSGi(11, 0, 2)), 
                MockIU.createFeature("com.google.guava", Version.createOSGi(12, 0, 0)));
            } else {
              List<IInstallableUnit> _xifexpression_2 = null;
              boolean _equals_2 = "http://download.eclipse.org/modeling/emf/compare/updates/releases/2.1/R201310031412/".equals(location.toString());
              if (_equals_2) {
                _xifexpression_2 = CollectionLiterals.<IInstallableUnit>newImmutableList(
                  MockIU.createFeature("org.eclipse.emf.compare.rcp.ui.feature.group", Version.createOSGi(5, 0, 0)));
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
      Assert.assertEquals(Diagnostic.ERROR, d.getSeverity());
      final Function1<Diagnostic, Boolean> _function = (Diagnostic it) -> {
        int _severity = it.getSeverity();
        return Boolean.valueOf((_severity >= Diagnostic.WARNING));
      };
      Assert.assertEquals(IterableExtensions.join(d.getChildren(), ", "), 1, IterableExtensions.size(IterableExtensions.<Diagnostic>filter(d.getChildren(), _function)));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
