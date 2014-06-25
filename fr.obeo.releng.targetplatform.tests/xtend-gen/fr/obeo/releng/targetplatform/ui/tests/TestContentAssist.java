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
import org.eclipse.jdt.launching.environments.IExecutionEnvironmentsManager;
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
    public Provider<IProvisioningAgent> provideIProvisioningAgent() {
      return new Provider<IProvisioningAgent>() {
        public IProvisioningAgent get() {
          return new MockProvisioningAgent(new IQueryResultProvider<IInstallableUnit>() {
            public List<IInstallableUnit> listIUs(final URI location) {
              List<IInstallableUnit> _xifexpression = null;
              String _string = location.toString();
              boolean _equals = "location1".equals(_string);
              if (_equals) {
                Version _createOSGi = Version.createOSGi(1, 2, 0);
                MockIU _createFeature = MockIU.createFeature("org.iu1", _createOSGi);
                _xifexpression = CollectionLiterals.<IInstallableUnit>newImmutableList(_createFeature);
              } else {
                List<IInstallableUnit> _xifexpression_1 = null;
                String _string_1 = location.toString();
                boolean _equals_1 = "location2".equals(_string_1);
                if (_equals_1) {
                  Version _createOSGi_1 = Version.createOSGi(1, 2, 0);
                  MockIU _createFeature_1 = MockIU.createFeature("org.iu1", _createOSGi_1);
                  Version _createOSGi_2 = Version.createOSGi(3, 7, 72);
                  MockIU _createFeature_2 = MockIU.createFeature("org.iu2", _createOSGi_2);
                  _xifexpression_1 = CollectionLiterals.<IInstallableUnit>newImmutableList(_createFeature_1, _createFeature_2);
                } else {
                  List<IInstallableUnit> _xifexpression_2 = null;
                  String _string_2 = location.toString();
                  boolean _equals_2 = "location3".equals(_string_2);
                  if (_equals_2) {
                    Version _createOSGi_3 = Version.createOSGi(1, 2, 0);
                    MockIU _createFeature_3 = MockIU.createFeature("org.iu1", _createOSGi_3);
                    Version _createOSGi_4 = Version.createOSGi(1, 2, 5);
                    MockIU _createFeature_4 = MockIU.createFeature("org.iu1", _createOSGi_4);
                    Version _createOSGi_5 = Version.createOSGi(1, 3, 2);
                    MockIU _createFeature_5 = MockIU.createFeature("org.iu1", _createOSGi_5);
                    Version _createOSGi_6 = Version.createOSGi(2, 0, 0);
                    MockIU _createFeature_6 = MockIU.createFeature("org.iu1", _createOSGi_6);
                    Version _createOSGi_7 = Version.createOSGi(2, 3, 0);
                    MockIU _createFeature_7 = MockIU.createFeature("org.iu1", _createOSGi_7);
                    Version _createOSGi_8 = Version.createOSGi(3, 9, 0);
                    MockIU _createFeature_8 = MockIU.createFeature("org.iu1", _createOSGi_8);
                    _xifexpression_2 = CollectionLiterals.<IInstallableUnit>newImmutableList(_createFeature_3, _createFeature_4, _createFeature_5, _createFeature_6, _createFeature_7, _createFeature_8);
                  } else {
                    List<IInstallableUnit> _xifexpression_3 = null;
                    String _string_3 = location.toString();
                    boolean _equals_3 = "location4".equals(_string_3);
                    if (_equals_3) {
                      Version _createOSGi_9 = Version.createOSGi(1, 2, 0);
                      MockIU _createFeature_9 = MockIU.createFeature("org.iu1", _createOSGi_9);
                      Version _createOSGi_10 = Version.createOSGi(3, 7, 72);
                      MockIU _createFeature_10 = MockIU.createFeature("org.iu2", _createOSGi_10);
                      Version _createOSGi_11 = Version.createOSGi(1, 2, 0);
                      MockIU _createFeature_11 = MockIU.createFeature("com.iu1", _createOSGi_11);
                      Version _createOSGi_12 = Version.createOSGi(3, 7, 72);
                      MockIU _createFeature_12 = MockIU.createFeature("com.iu2", _createOSGi_12);
                      Version _createOSGi_13 = Version.createOSGi(3, 7, 72);
                      MockIU _createFeature_13 = MockIU.createFeature("com.iu3", _createOSGi_13);
                      _xifexpression_3 = CollectionLiterals.<IInstallableUnit>newImmutableList(_createFeature_9, _createFeature_10, _createFeature_11, _createFeature_12, _createFeature_13);
                    } else {
                      String _string_4 = location.toString();
                      boolean _equals_4 = "badLocation".equals(_string_4);
                      if (_equals_4) {
                        throw new RuntimeException("bad location");
                      } else {
                        String _string_5 = location.toString();
                        boolean _equals_5 = "emptyRepository".equals(_string_5);
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
  
  protected ISetup doGetSetup() {
    return new TargetPlatformStandaloneSetup() {
      public Injector createInjector() {
        SharedStateModule _sharedStateModule = new SharedStateModule();
        TargetPlatformActivator _instance = TargetPlatformActivator.getInstance();
        TargetPlatformUiModule _targetPlatformUiModule = new TargetPlatformUiModule(_instance);
        Module _mixin = Modules2.mixin(
          TestContentAssist.MOCK_RUNTIME_MODULE, _sharedStateModule, 
          ((Module) _targetPlatformUiModule));
        return Guice.createInjector(_mixin);
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
      ContentAssistProcessorTestBuilder _assertText = _newBuilder.assertText(_builder.toString());
      ContentAssistProcessorTestBuilder _applyProposal = _assertText.applyProposal();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("target \"Target Platform Name\"");
      _builder_1.newLine();
      _applyProposal.expectContent(_builder_1.toString());
      ContentAssistProcessorTestBuilder _newBuilder_1 = this.newBuilder();
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("target \"Target Platform Name\"");
      _builder_2.newLine();
      ContentAssistProcessorTestBuilder _assertText_1 = _newBuilder_1.assertText(_builder_2.toString());
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("target \"Target Platform Name\"");
      _builder_3.newLine();
      ContentAssistProcessorTestBuilder.ProposalTester _assertProposal = _assertText_1.assertProposal(_builder_3.toString());
      _assertProposal.withDisplayString("target \"Target Platform Name\" - create a new target platform");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testTargetPlatform2() {
    try {
      ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
      ContentAssistProcessorTestBuilder _append = _newBuilder.append("target");
      StringConcatenation _builder = new StringConcatenation();
      _builder.append(" ");
      _builder.append("\"Target Platform Name\"");
      _builder.newLine();
      ContentAssistProcessorTestBuilder _assertText = _append.assertText(_builder.toString());
      ContentAssistProcessorTestBuilder _applyProposal = _assertText.applyProposal();
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
      ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
      ContentAssistProcessorTestBuilder _append = _newBuilder.append("target ");
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("\"Target Platform Name\"");
      _builder.newLine();
      ContentAssistProcessorTestBuilder _assertText = _append.assertText(_builder.toString());
      ContentAssistProcessorTestBuilder _applyProposal = _assertText.applyProposal();
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
      ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
      ContentAssistProcessorTestBuilder _append = _newBuilder.append("tar");
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"Target Platform Name\"");
      _builder.newLine();
      ContentAssistProcessorTestBuilder _assertText = _append.assertText(_builder.toString());
      ContentAssistProcessorTestBuilder _applyProposal = _assertText.applyProposal();
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
      ContentAssistProcessorTestBuilder _append = _newBuilder.append(_builder.toString());
      _append.assertText("requirements", "allEnvironments", "source", "configurePhase");
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
      ContentAssistProcessorTestBuilder _append = _newBuilder.append(_builder.toString());
      ContentAssistProcessorTestBuilder _assertText = _append.assertText("requirements", "allEnvironments", "configurePhase");
      ContentAssistProcessorTestBuilder _append_1 = _assertText.append("requirements ");
      _append_1.assertText("allEnvironments", "configurePhase");
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
      ImmutableList.Builder<String> _builder = ImmutableList.<String>builder();
      String[] _knownOSValues = Platform.knownOSValues();
      ImmutableList.Builder<String> _addAll = _builder.addAll(((Iterable<? extends String>)Conversions.doWrapArray(_knownOSValues)));
      String[] _knownWSValues = Platform.knownWSValues();
      ImmutableList.Builder<String> _addAll_1 = _addAll.addAll(((Iterable<? extends String>)Conversions.doWrapArray(_knownWSValues)));
      String[] _knownOSArchValues = Platform.knownOSArchValues();
      ImmutableList.Builder<String> _addAll_2 = _addAll_1.addAll(((Iterable<? extends String>)Conversions.doWrapArray(_knownOSArchValues)));
      IExecutionEnvironmentsManager _executionEnvironmentsManager = JavaRuntime.getExecutionEnvironmentsManager();
      IExecutionEnvironment[] _executionEnvironments = _executionEnvironmentsManager.getExecutionEnvironments();
      final Function1<IExecutionEnvironment, String> _function = new Function1<IExecutionEnvironment, String>() {
        public String apply(final IExecutionEnvironment it) {
          return it.getId();
        }
      };
      List<String> _map = ListExtensions.<IExecutionEnvironment, String>map(((List<IExecutionEnvironment>)Conversions.doWrapArray(_executionEnvironments)), _function);
      ImmutableList.Builder<String> _addAll_3 = _addAll_2.addAll(_map);
      Locale[] _availableLocales = Locale.getAvailableLocales();
      final Function1<Locale, String> _function_1 = new Function1<Locale, String>() {
        public String apply(final Locale it) {
          return it.toString();
        }
      };
      List<String> _map_1 = ListExtensions.<Locale, String>map(((List<Locale>)Conversions.doWrapArray(_availableLocales)), _function_1);
      ImmutableList.Builder<String> _addAll_4 = _addAll_3.addAll(_map_1);
      final ImmutableList<String> p = _addAll_4.build();
      ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("target \"TPName\"");
      _builder_1.newLine();
      _builder_1.append("environment ");
      ContentAssistProcessorTestBuilder _append = _newBuilder.append(_builder_1.toString());
      _append.assertText(((String[])Conversions.unwrapArray(p, String.class)));
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
      ImmutableList.Builder<String> _builder = ImmutableList.<String>builder();
      String[] _knownWSValues = Platform.knownWSValues();
      ImmutableList.Builder<String> _addAll = _builder.addAll(((Iterable<? extends String>)Conversions.doWrapArray(_knownWSValues)));
      String[] _knownOSArchValues = Platform.knownOSArchValues();
      ImmutableList.Builder<String> _addAll_1 = _addAll.addAll(((Iterable<? extends String>)Conversions.doWrapArray(_knownOSArchValues)));
      IExecutionEnvironmentsManager _executionEnvironmentsManager = JavaRuntime.getExecutionEnvironmentsManager();
      IExecutionEnvironment[] _executionEnvironments = _executionEnvironmentsManager.getExecutionEnvironments();
      final Function1<IExecutionEnvironment, String> _function = new Function1<IExecutionEnvironment, String>() {
        public String apply(final IExecutionEnvironment it) {
          return it.getId();
        }
      };
      List<String> _map = ListExtensions.<IExecutionEnvironment, String>map(((List<IExecutionEnvironment>)Conversions.doWrapArray(_executionEnvironments)), _function);
      ImmutableList.Builder<String> _addAll_2 = _addAll_1.addAll(_map);
      Locale[] _availableLocales = Locale.getAvailableLocales();
      final Function1<Locale, String> _function_1 = new Function1<Locale, String>() {
        public String apply(final Locale it) {
          return it.toString();
        }
      };
      List<String> _map_1 = ListExtensions.<Locale, String>map(((List<Locale>)Conversions.doWrapArray(_availableLocales)), _function_1);
      ImmutableList.Builder<String> _addAll_3 = _addAll_2.addAll(_map_1);
      final ImmutableList<String> p = _addAll_3.build();
      ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("target \"TPName\"");
      _builder_1.newLine();
      _builder_1.append("environment macosx ");
      ContentAssistProcessorTestBuilder _append = _newBuilder.append(_builder_1.toString());
      _append.assertText(((String[])Conversions.unwrapArray(p, String.class)));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testTargetContentEnv3() {
    try {
      ImmutableList.Builder<String> _builder = ImmutableList.<String>builder();
      String[] _knownOSValues = Platform.knownOSValues();
      ImmutableList.Builder<String> _addAll = _builder.addAll(((Iterable<? extends String>)Conversions.doWrapArray(_knownOSValues)));
      String[] _knownOSArchValues = Platform.knownOSArchValues();
      ImmutableList.Builder<String> _addAll_1 = _addAll.addAll(((Iterable<? extends String>)Conversions.doWrapArray(_knownOSArchValues)));
      IExecutionEnvironmentsManager _executionEnvironmentsManager = JavaRuntime.getExecutionEnvironmentsManager();
      IExecutionEnvironment[] _executionEnvironments = _executionEnvironmentsManager.getExecutionEnvironments();
      final Function1<IExecutionEnvironment, String> _function = new Function1<IExecutionEnvironment, String>() {
        public String apply(final IExecutionEnvironment it) {
          return it.getId();
        }
      };
      List<String> _map = ListExtensions.<IExecutionEnvironment, String>map(((List<IExecutionEnvironment>)Conversions.doWrapArray(_executionEnvironments)), _function);
      ImmutableList.Builder<String> _addAll_2 = _addAll_1.addAll(_map);
      Locale[] _availableLocales = Locale.getAvailableLocales();
      final Function1<Locale, String> _function_1 = new Function1<Locale, String>() {
        public String apply(final Locale it) {
          return it.toString();
        }
      };
      List<String> _map_1 = ListExtensions.<Locale, String>map(((List<Locale>)Conversions.doWrapArray(_availableLocales)), _function_1);
      ImmutableList.Builder<String> _addAll_3 = _addAll_2.addAll(_map_1);
      final ImmutableList<String> p = _addAll_3.build();
      ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("target \"TPName\"");
      _builder_1.newLine();
      _builder_1.append("environment cocoa ");
      ContentAssistProcessorTestBuilder _append = _newBuilder.append(_builder_1.toString());
      _append.assertText(((String[])Conversions.unwrapArray(p, String.class)));
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
      ContentAssistProcessorTestBuilder _append = _newBuilder.append(_builder.toString());
      ContentAssistProcessorTestBuilder _cursorBack = _append.cursorBack(3);
      _cursorBack.assertText(
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
      ContentAssistProcessorTestBuilder _append = _newBuilder.append(_builder.toString());
      ContentAssistProcessorTestBuilder _cursorBack = _append.cursorBack(3);
      _cursorBack.assertText(
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
      ContentAssistProcessorTestBuilder _append = _newBuilder.append(_builder.toString());
      ContentAssistProcessorTestBuilder _cursorBack = _append.cursorBack(3);
      _cursorBack.assertText(
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
      ContentAssistProcessorTestBuilder _append = _newBuilder.append(_builder.toString());
      ContentAssistProcessorTestBuilder _cursorBack = _append.cursorBack(3);
      _cursorBack.assertText(
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
      ContentAssistProcessorTestBuilder _append = _newBuilder.append(_builder.toString());
      ContentAssistProcessorTestBuilder _cursorBack = _append.cursorBack(3);
      _cursorBack.assertText(
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
      ContentAssistProcessorTestBuilder _append = _newBuilder.append(_builder.toString());
      ContentAssistProcessorTestBuilder _cursorBack = _append.cursorBack(3);
      _cursorBack.assertText(
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
      ContentAssistProcessorTestBuilder _append = _newBuilder.append(_builder.toString());
      ContentAssistProcessorTestBuilder _cursorBack = _append.cursorBack(3);
      _cursorBack.assertText("");
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
      ContentAssistProcessorTestBuilder _append = _newBuilder.append(_builder.toString());
      ContentAssistProcessorTestBuilder _cursorBack = _append.cursorBack(3);
      _cursorBack.assertText("");
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
      ContentAssistProcessorTestBuilder _append = _newBuilder.append(_builder.toString());
      ContentAssistProcessorTestBuilder _cursorBack = _append.cursorBack(3);
      _cursorBack.assertText(
        "[1.2.0,1.2.1)", 
        "[1.2.0,1.3.0)", 
        "[1.2.0,2.0.0)", 
        "[1.2.0,1.2.0]");
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
      ContentAssistProcessorTestBuilder _append = _newBuilder.append(_builder.toString());
      ContentAssistProcessorTestBuilder _cursorBack = _append.cursorBack(3);
      _cursorBack.assertText(
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
        "[3.9.0,3.9.0]");
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
      ContentAssistProcessorTestBuilder _append = _newBuilder.append(_builder.toString());
      ContentAssistProcessorTestBuilder _cursorBack = _append.cursorBack(3);
      _cursorBack.assertText(
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
      ContentAssistProcessorTestBuilder _append = _newBuilder.append(_builder.toString());
      ContentAssistProcessorTestBuilder _cursorBack = _append.cursorBack(3);
      _cursorBack.assertText("");
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
      ContentAssistProcessorTestBuilder _append = _newBuilder.append(_builder.toString());
      ContentAssistProcessorTestBuilder _cursorBack = _append.cursorBack(3);
      _cursorBack.assertText(
        " [1.2.0,1.2.1)", 
        " [1.2.0,1.3.0)", 
        " [1.2.0,2.0.0)", 
        " [1.2.0,1.2.0]");
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
      ContentAssistProcessorTestBuilder _append = _newBuilder.append(_builder.toString());
      _append.assertText(
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
      ContentAssistProcessorTestBuilder _append = _newBuilder.append(_builder.toString());
      _append.assertText(
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
      ContentAssistProcessorTestBuilder _append = _newBuilder.append(_builder.toString());
      _append.assertText(
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
      ContentAssistProcessorTestBuilder _append = _newBuilder.append(_builder.toString());
      ContentAssistProcessorTestBuilder _cursorBack = _append.cursorBack(22);
      _cursorBack.assertText(
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
      ContentAssistProcessorTestBuilder _append = _newBuilder.append(_builder.toString());
      ContentAssistProcessorTestBuilder _cursorBack = _append.cursorBack(23);
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
      ContentAssistProcessorTestBuilder _append = _newBuilder.append(_builder.toString());
      ContentAssistProcessorTestBuilder _cursorBack = _append.cursorBack(22);
      _cursorBack.assertText(
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
      ContentAssistProcessorTestBuilder _append = _newBuilder.append(_builder.toString());
      ContentAssistProcessorTestBuilder _cursorBack = _append.cursorBack(6);
      _cursorBack.assertText(
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
      ContentAssistProcessorTestBuilder _append = _newBuilder.append(_builder.toString());
      ContentAssistProcessorTestBuilder _cursorBack = _append.cursorBack(7);
      _cursorBack.assertText(
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
      ContentAssistProcessorTestBuilder _append = _newBuilder.append(_builder.toString());
      ContentAssistProcessorTestBuilder _cursorBack = _append.cursorBack(6);
      _cursorBack.assertText(
        " locationID ");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
