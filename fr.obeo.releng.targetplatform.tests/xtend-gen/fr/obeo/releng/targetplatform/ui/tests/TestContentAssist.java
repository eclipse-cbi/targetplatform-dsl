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
package fr.obeo.releng.targetplatform.ui.tests;

import com.google.common.collect.ImmutableList;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.Provider;
import fr.obeo.releng.targetplatform.TargetPlatformRuntimeModule;
import fr.obeo.releng.targetplatform.TargetPlatformStandaloneSetup;
import fr.obeo.releng.targetplatform.tests.IQueryResultProvider;
import fr.obeo.releng.targetplatform.tests.MockIU;
import fr.obeo.releng.targetplatform.tests.MockProvisioningAgent;
import fr.obeo.releng.targetplatform.ui.TargetPlatformUiModule;
import fr.obeo.releng.targetplatform.ui.internal.TargetPlatformActivator;
import java.net.URI;
import java.util.List;
import java.util.Locale;
import org.eclipse.core.runtime.Platform;
import org.eclipse.equinox.p2.core.IProvisioningAgent;
import org.eclipse.equinox.p2.metadata.IInstallableUnit;
import org.eclipse.equinox.p2.metadata.Version;
import org.eclipse.jdt.launching.JavaRuntime;
import org.eclipse.jdt.launching.environments.IExecutionEnvironment;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.junit4.ui.AbstractContentAssistProcessorTest;
import org.eclipse.xtext.junit4.ui.ContentAssistProcessorTestBuilder;
import org.eclipse.xtext.ui.shared.SharedStateModule;
import org.eclipse.xtext.util.Modules2;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.junit.Test;

@SuppressWarnings("all")
public class TestContentAssist extends AbstractContentAssistProcessorTest {
  private final static TargetPlatformRuntimeModule MOCK_RUNTIME_MODULE = new TargetPlatformRuntimeModule() {
    @Override
    public Provider<IProvisioningAgent> provideIProvisioningAgent() {
      return new Provider<IProvisioningAgent>() {
        @Override
        public IProvisioningAgent get() {
          return new MockProvisioningAgent(new IQueryResultProvider<IInstallableUnit>() {
            @Override
            public List<IInstallableUnit> listIUs(final URI location) {
              List<IInstallableUnit> _xifexpression = null;
              boolean _equals = "location1".equals(location.toString());
              if (_equals) {
                _xifexpression = CollectionLiterals.<IInstallableUnit>newImmutableList(
                  MockIU.createFeature("org.iu1", Version.createOSGi(1, 2, 0)));
              } else {
                List<IInstallableUnit> _xifexpression_1 = null;
                boolean _equals_1 = "location2".equals(location.toString());
                if (_equals_1) {
                  _xifexpression_1 = CollectionLiterals.<IInstallableUnit>newImmutableList(
                    MockIU.createFeature("org.iu1", Version.createOSGi(1, 2, 0)), 
                    MockIU.createFeature("org.iu2", Version.createOSGi(3, 7, 72)));
                } else {
                  List<IInstallableUnit> _xifexpression_2 = null;
                  boolean _equals_2 = "location3".equals(location.toString());
                  if (_equals_2) {
                    _xifexpression_2 = CollectionLiterals.<IInstallableUnit>newImmutableList(
                      MockIU.createFeature("org.iu1", Version.createOSGi(1, 2, 0)), 
                      MockIU.createFeature("org.iu1", Version.createOSGi(1, 2, 5)), 
                      MockIU.createFeature("org.iu1", Version.createOSGi(1, 3, 2)), 
                      MockIU.createFeature("org.iu1", Version.createOSGi(2, 0, 0)), 
                      MockIU.createFeature("org.iu1", Version.createOSGi(2, 3, 0)), 
                      MockIU.createFeature("org.iu1", Version.createOSGi(3, 9, 0)));
                  } else {
                    List<IInstallableUnit> _xifexpression_3 = null;
                    boolean _equals_3 = "location4".equals(location.toString());
                    if (_equals_3) {
                      _xifexpression_3 = CollectionLiterals.<IInstallableUnit>newImmutableList(
                        MockIU.createFeature("org.iu1", Version.createOSGi(1, 2, 0)), 
                        MockIU.createFeature("org.iu2", Version.createOSGi(3, 7, 72)), 
                        MockIU.createFeature("com.iu1", Version.createOSGi(1, 2, 0)), 
                        MockIU.createFeature("com.iu2", Version.createOSGi(3, 7, 72)), 
                        MockIU.createFeature("com.iu3", Version.createOSGi(3, 7, 72)));
                    } else {
                      boolean _equals_4 = "badLocation".equals(location.toString());
                      if (_equals_4) {
                        throw new RuntimeException("bad location");
                      } else {
                        boolean _equals_5 = "emptyRepository".equals(location.toString());
                        if (_equals_5) {
                          return CollectionLiterals.<IInstallableUnit>emptyList();
                        } else {
                          return CollectionLiterals.<IInstallableUnit>emptyList();
                        }
                      }
                    }
                    _xifexpression_2 = _xifexpression_3;
                  }
                  _xifexpression_1 = _xifexpression_2;
                }
                _xifexpression = _xifexpression_1;
              }
              return _xifexpression;
            }
          });
        }
      };
    }
  };
  
  @Override
  protected ISetup doGetSetup() {
    return new TargetPlatformStandaloneSetup() {
      @Override
      public Injector createInjector() {
        SharedStateModule _sharedStateModule = new SharedStateModule();
        TargetPlatformActivator _instance = TargetPlatformActivator.getInstance();
        TargetPlatformUiModule _targetPlatformUiModule = new TargetPlatformUiModule(_instance);
        return Guice.createInjector(
          Modules2.mixin(
            TestContentAssist.MOCK_RUNTIME_MODULE, _sharedStateModule, 
            ((Module) _targetPlatformUiModule)));
      }
    };
  }
  
  @Test
  public void testTargetPlatform1() {
    try {
      ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"Target Platform Name\"");
      _builder.newLine();
      ContentAssistProcessorTestBuilder _applyProposal = _newBuilder.assertText(_builder.toString()).applyProposal();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("target \"Target Platform Name\"");
      _builder_1.newLine();
      _applyProposal.expectContent(_builder_1.toString());
      ContentAssistProcessorTestBuilder _newBuilder_1 = this.newBuilder();
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("target \"Target Platform Name\"");
      _builder_2.newLine();
      ContentAssistProcessorTestBuilder _assertText = _newBuilder_1.assertText(_builder_2.toString());
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("target \"Target Platform Name\"");
      _builder_3.newLine();
      _assertText.assertProposal(_builder_3.toString()).withDisplayString("target \"Target Platform Name\" - create a new target platform");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testTargetPlatform2() {
    try {
      ContentAssistProcessorTestBuilder _append = this.newBuilder().append("target");
      StringConcatenation _builder = new StringConcatenation();
      _builder.append(" ");
      _builder.append("\"Target Platform Name\"");
      _builder.newLine();
      ContentAssistProcessorTestBuilder _applyProposal = _append.assertText(_builder.toString()).applyProposal();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("target \"Target Platform Name\"");
      _builder_1.newLine();
      _applyProposal.expectContent(_builder_1.toString());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testTargetPlatform3() {
    try {
      ContentAssistProcessorTestBuilder _append = this.newBuilder().append("target ");
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("\"Target Platform Name\"");
      _builder.newLine();
      ContentAssistProcessorTestBuilder _applyProposal = _append.assertText(_builder.toString()).applyProposal();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("target \"Target Platform Name\"");
      _builder_1.newLine();
      _applyProposal.expectContent(_builder_1.toString());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testTargetPlatform4() {
    try {
      ContentAssistProcessorTestBuilder _append = this.newBuilder().append("tar");
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"Target Platform Name\"");
      _builder.newLine();
      ContentAssistProcessorTestBuilder _applyProposal = _append.assertText(_builder.toString()).applyProposal();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("target \"Target Platform Name\"");
      _builder_1.newLine();
      _applyProposal.expectContent(_builder_1.toString());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testTargetContent() {
    try {
      ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"TPName\"");
      _builder.newLine();
      ContentAssistProcessorTestBuilder _append = _newBuilder.append(_builder.toString());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("include \"includedFile.tpd\"");
      _builder_1.newLine();
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("location \"http://p2.repository.url/\" {");
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.newLine();
      _builder_2.append("}");
      _append.assertText(
        "environment", "with", _builder_1.toString(), _builder_2.toString());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testTargetContentOptions1() {
    try {
      ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"TPName\"");
      _builder.newLine();
      _builder.append("with ");
      _newBuilder.append(_builder.toString()).assertText("requirements", "allEnvironments", "source", "configurePhase");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testTargetContentOptions2() {
    try {
      ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"TPName\"");
      _builder.newLine();
      _builder.append("with source ");
      _newBuilder.append(_builder.toString()).assertText("requirements", "allEnvironments", "configurePhase").append("requirements ").assertText("allEnvironments", "configurePhase");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testTargetContentOptions3() {
    try {
      ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"TPName\"");
      _builder.newLine();
      _builder.append("with source");
      _builder.newLine();
      ContentAssistProcessorTestBuilder _append = _newBuilder.append(_builder.toString());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("include \"includedFile.tpd\"");
      _builder_1.newLine();
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("location \"http://p2.repository.url/\" {");
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.newLine();
      _builder_2.append("}");
      _append.assertText(
        "environment", _builder_1.toString(), _builder_2.toString());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testTargetContentEnv0() {
    try {
      final Function1<IExecutionEnvironment, String> _function = new Function1<IExecutionEnvironment, String>() {
        @Override
        public String apply(final IExecutionEnvironment it) {
          return it.getId();
        }
      };
      final Function1<Locale, String> _function_1 = new Function1<Locale, String>() {
        @Override
        public String apply(final Locale it) {
          return it.toString();
        }
      };
      final ImmutableList<String> p = ImmutableList.<String>builder().addAll(((Iterable<? extends String>)Conversions.doWrapArray(Platform.knownOSValues()))).addAll(((Iterable<? extends String>)Conversions.doWrapArray(Platform.knownWSValues()))).addAll(((Iterable<? extends String>)Conversions.doWrapArray(Platform.knownOSArchValues()))).addAll(ListExtensions.<IExecutionEnvironment, String>map(((List<IExecutionEnvironment>)Conversions.doWrapArray(JavaRuntime.getExecutionEnvironmentsManager().getExecutionEnvironments())), _function)).addAll(ListExtensions.<Locale, String>map(((List<Locale>)Conversions.doWrapArray(Locale.getAvailableLocales())), _function_1)).build();
      ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"TPName\"");
      _builder.newLine();
      _builder.append("environment ");
      _newBuilder.append(_builder.toString()).assertText(((String[])Conversions.unwrapArray(p, String.class)));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testTargetContentEnv1() {
    try {
      ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"TPName\"");
      _builder.newLine();
      _builder.append("environment win32");
      _builder.newLine();
      ContentAssistProcessorTestBuilder _append = _newBuilder.append(_builder.toString());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("include \"includedFile.tpd\"");
      _builder_1.newLine();
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("location \"http://p2.repository.url/\" {");
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.newLine();
      _builder_2.append("}");
      _append.assertText(
        "with", _builder_1.toString(), _builder_2.toString());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testTargetContentEnv2() {
    try {
      final Function1<IExecutionEnvironment, String> _function = new Function1<IExecutionEnvironment, String>() {
        @Override
        public String apply(final IExecutionEnvironment it) {
          return it.getId();
        }
      };
      final Function1<Locale, String> _function_1 = new Function1<Locale, String>() {
        @Override
        public String apply(final Locale it) {
          return it.toString();
        }
      };
      final ImmutableList<String> p = ImmutableList.<String>builder().addAll(((Iterable<? extends String>)Conversions.doWrapArray(Platform.knownWSValues()))).addAll(((Iterable<? extends String>)Conversions.doWrapArray(Platform.knownOSArchValues()))).addAll(ListExtensions.<IExecutionEnvironment, String>map(((List<IExecutionEnvironment>)Conversions.doWrapArray(JavaRuntime.getExecutionEnvironmentsManager().getExecutionEnvironments())), _function)).addAll(ListExtensions.<Locale, String>map(((List<Locale>)Conversions.doWrapArray(Locale.getAvailableLocales())), _function_1)).build();
      ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"TPName\"");
      _builder.newLine();
      _builder.append("environment macosx ");
      _newBuilder.append(_builder.toString()).assertText(((String[])Conversions.unwrapArray(p, String.class)));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testTargetContentEnv3() {
    try {
      final Function1<IExecutionEnvironment, String> _function = new Function1<IExecutionEnvironment, String>() {
        @Override
        public String apply(final IExecutionEnvironment it) {
          return it.getId();
        }
      };
      final Function1<Locale, String> _function_1 = new Function1<Locale, String>() {
        @Override
        public String apply(final Locale it) {
          return it.toString();
        }
      };
      final ImmutableList<String> p = ImmutableList.<String>builder().addAll(((Iterable<? extends String>)Conversions.doWrapArray(Platform.knownOSValues()))).addAll(((Iterable<? extends String>)Conversions.doWrapArray(Platform.knownOSArchValues()))).addAll(ListExtensions.<IExecutionEnvironment, String>map(((List<IExecutionEnvironment>)Conversions.doWrapArray(JavaRuntime.getExecutionEnvironmentsManager().getExecutionEnvironments())), _function)).addAll(ListExtensions.<Locale, String>map(((List<Locale>)Conversions.doWrapArray(Locale.getAvailableLocales())), _function_1)).build();
      ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"TPName\"");
      _builder.newLine();
      _builder.append("environment cocoa ");
      _newBuilder.append(_builder.toString()).assertText(((String[])Conversions.unwrapArray(p, String.class)));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testTargetContentOptionsAndEnv() {
    try {
      ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"TPName\"");
      _builder.newLine();
      _builder.append("environment win32");
      _builder.newLine();
      _builder.append("with source");
      _builder.newLine();
      ContentAssistProcessorTestBuilder _append = _newBuilder.append(_builder.toString());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("include \"includedFile.tpd\"");
      _builder_1.newLine();
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("location \"http://p2.repository.url/\" {");
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.newLine();
      _builder_2.append("}");
      _append.assertText(_builder_1.toString(), _builder_2.toString());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testIUContentAssist1() {
    try {
      ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"TPName\"");
      _builder.newLine();
      _builder.append("location \"location1\" {");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _newBuilder.append(_builder.toString()).cursorBack(3).assertText(
        "org.iu1");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testIUContentAssist2() {
    try {
      ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"TPName\"");
      _builder.newLine();
      _builder.append("location \"location2\" {");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _newBuilder.append(_builder.toString()).cursorBack(3).assertText(
        "org.iu1", 
        "org.iu2");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testIUContentAssist3() {
    try {
      ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"TPName\"");
      _builder.newLine();
      _builder.append("location \"location3\" {");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _newBuilder.append(_builder.toString()).cursorBack(3).assertText(
        "org.iu1");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testIUContentAssist4() {
    try {
      ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"TPName\"");
      _builder.newLine();
      _builder.append("location \"location4\" {");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _newBuilder.append(_builder.toString()).cursorBack(3).assertText(
        "org.iu1", 
        "org.iu2", 
        "com.iu1", 
        "com.iu2", 
        "com.iu3");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testIUContentAssist5() {
    try {
      ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"TPName\"");
      _builder.newLine();
      _builder.append("location \"location4\" {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("o");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _newBuilder.append(_builder.toString()).cursorBack(3).assertText(
        "org.iu1", 
        "org.iu2");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testIUContentAssist6() {
    try {
      ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"TPName\"");
      _builder.newLine();
      _builder.append("location \"location4\" {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("c");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _newBuilder.append(_builder.toString()).cursorBack(3).assertText(
        "com.iu1", 
        "com.iu2", 
        "com.iu3");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testIUContentAssist7() {
    try {
      ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"TPName\"");
      _builder.newLine();
      _builder.append("location \"emptyLocation\" {");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _newBuilder.append(_builder.toString()).cursorBack(3).assertText("");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testIUContentAssist8() {
    try {
      ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"TPName\"");
      _builder.newLine();
      _builder.append("location \"badLocation\" {");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _newBuilder.append(_builder.toString()).cursorBack(3).assertText("");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testIUVersionContentAssist1() {
    try {
      ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"TPName\"");
      _builder.newLine();
      _builder.append("location \"location1\" {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("org.iu1 ");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _newBuilder.append(_builder.toString()).cursorBack(3).assertText(
        "[1.2.0,1.2.1)", 
        "[1.2.0,1.3.0)", 
        "[1.2.0,2.0.0)", 
        "[1.2.0,1.2.0]", 
        "lazy");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testIUVersionContentAssist2() {
    try {
      ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"TPName\"");
      _builder.newLine();
      _builder.append("location \"location3\" {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("org.iu1 ");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _newBuilder.append(_builder.toString()).cursorBack(3).assertText(
        "[1.2.0,1.2.1)", 
        "[1.2.0,1.3.0)", 
        "[1.2.0,2.0.0)", 
        "[1.2.0,1.2.0]", 
        "[1.2.5,1.2.6)", 
        "[1.2.5,1.3.0)", 
        "[1.2.5,2.0.0)", 
        "[1.2.5,1.2.5]", 
        "[1.3.2,1.3.3)", 
        "[1.3.2,1.4.0)", 
        "[1.3.2,2.0.0)", 
        "[1.3.2,1.3.2]", 
        "[2.0.0,2.0.1)", 
        "[2.0.0,2.1.0)", 
        "[2.0.0,3.0.0)", 
        "[2.0.0,2.0.0]", 
        "[2.3.0,2.3.1)", 
        "[2.3.0,2.4.0)", 
        "[2.3.0,3.0.0)", 
        "[2.3.0,2.3.0]", 
        "[3.9.0,3.9.1)", 
        "[3.9.0,3.10.0)", 
        "[3.9.0,4.0.0)", 
        "[3.9.0,3.9.0]", 
        "lazy");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testIUVersionContentAssist3() {
    try {
      ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"TPName\"");
      _builder.newLine();
      _builder.append("location \"location2\" {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("org.iu1");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _newBuilder.append(_builder.toString()).cursorBack(3).assertText(
        "org.iu2");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testIUVersionContentAssist4() {
    try {
      ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"TPName\"");
      _builder.newLine();
      _builder.append("location \"location2\" {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("org.iu1");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("org.iu2");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _newBuilder.append(_builder.toString()).cursorBack(3).assertText("");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testIUVersionContentAssist5() {
    try {
      ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"TPName\"");
      _builder.newLine();
      _builder.append("location \"location1\" {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("org.iu1");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _newBuilder.append(_builder.toString()).cursorBack(3).assertText(
        " [1.2.0,1.2.1)", 
        " [1.2.0,1.3.0)", 
        " [1.2.0,2.0.0)", 
        " [1.2.0,1.2.0]", 
        " lazy");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testLocationURIAndID1ContentAssist() {
    try {
      ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"TPName\"");
      _builder.newLine();
      _builder.append("location ");
      _newBuilder.append(_builder.toString()).assertText(
        "\"http://p2.repository.url/\" ", 
        "locationID ");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testLocationURIAndID2ContentAssist() {
    try {
      ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"TPName\"");
      _builder.newLine();
      _builder.append("location");
      ContentAssistProcessorTestBuilder _append = _newBuilder.append(_builder.toString());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("location \"http://p2.repository.url/\" {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.newLine();
      _builder_1.append("}");
      _append.assertText(
        " \"http://p2.repository.url/\" ", 
        " locationID ", _builder_1.toString());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testLocationURIAndID3ContentAssist() {
    try {
      ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"TPName\"");
      _builder.newLine();
      _builder.append("location ");
      _builder.newLine();
      _newBuilder.append(_builder.toString()).assertText(
        "\"http://p2.repository.url/\" ", 
        "locationID ");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testLocationURIAndID4ContentAssist() {
    try {
      ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"TPName\"");
      _builder.newLine();
      _builder.append("location");
      _builder.newLine();
      _newBuilder.append(_builder.toString()).assertText(
        "\"http://p2.repository.url/\" ", 
        "locationID ");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testLocationURIAndID5ContentAssist() {
    try {
      ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"TPName\"");
      _builder.newLine();
      _builder.append("location");
      _builder.newLine();
      _builder.newLine();
      _builder.append("location \"uri\" {");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _newBuilder.append(_builder.toString()).cursorBack(22).assertText(
        "\"http://p2.repository.url/\" ", 
        "locationID ");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testLocationURIAndID6ContentAssist() {
    try {
      ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"TPName\"");
      _builder.newLine();
      _builder.append("location");
      _builder.newLine();
      _builder.newLine();
      _builder.append("location \"uri\" {");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      ContentAssistProcessorTestBuilder _cursorBack = _newBuilder.append(_builder.toString()).cursorBack(23);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("location \"http://p2.repository.url/\" {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.newLine();
      _builder_1.append("}");
      _cursorBack.assertText(
        " \"http://p2.repository.url/\" ", 
        " locationID ", _builder_1.toString());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testLocationURIAndID7ContentAssist() {
    try {
      ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"TPName\"");
      _builder.newLine();
      _builder.append("location ");
      _builder.newLine();
      _builder.newLine();
      _builder.append("location \"uri\" {");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _newBuilder.append(_builder.toString()).cursorBack(22).assertText(
        "\"http://p2.repository.url/\" ", 
        "locationID ");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testLocationID1() {
    try {
      ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"TPName\"");
      _builder.newLine();
      _builder.append("location \"locationURI\" {");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _newBuilder.append(_builder.toString()).cursorBack(6).assertText(
        "locationID ");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testLocationID2() {
    try {
      ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"TPName\"");
      _builder.newLine();
      _builder.append("location \"locationURI\" {");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _newBuilder.append(_builder.toString()).cursorBack(7).assertText(
        " locationID");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testLocationID3() {
    try {
      ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"TPName\"");
      _builder.newLine();
      _builder.append("location \"locationURI\"{");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _newBuilder.append(_builder.toString()).cursorBack(6).assertText(
        " locationID ");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
