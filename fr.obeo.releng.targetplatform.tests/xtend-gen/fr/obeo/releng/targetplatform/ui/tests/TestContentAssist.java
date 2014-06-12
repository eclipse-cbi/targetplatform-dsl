package fr.obeo.releng.targetplatform.ui.tests;

import com.google.inject.Injector;
import fr.obeo.releng.targetplatform.TargetPlatformStandaloneSetup;
import fr.obeo.releng.targetplatform.TargetPlatformUiInjectorProvider;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.junit4.ui.AbstractContentAssistProcessorTest;
import org.eclipse.xtext.junit4.ui.ContentAssistProcessorTestBuilder;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(XtextRunner.class)
@InjectWith(TargetPlatformUiInjectorProvider.class)
@SuppressWarnings("all")
public class TestContentAssist extends AbstractContentAssistProcessorTest {
  protected ISetup doGetSetup() {
    return new TargetPlatformStandaloneSetup() {
      public Injector createInjector() {
        TargetPlatformUiInjectorProvider _targetPlatformUiInjectorProvider = new TargetPlatformUiInjectorProvider();
        return _targetPlatformUiInjectorProvider.getInjector();
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
      _append.assertText("include", "with", "environment", "location");
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
      _builder.newLine();
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
      _builder.append("with source");
      _builder.newLine();
      ContentAssistProcessorTestBuilder _append = _newBuilder.append(_builder.toString());
      _append.assertText(
        "requirements", "allEnvironments", "configurePhase", 
        "include", "environment", "location");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testTargetContentEnv() {
    try {
      ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("target \"TPName\"");
      _builder.newLine();
      _builder.append("environment win32");
      _builder.newLine();
      ContentAssistProcessorTestBuilder _append = _newBuilder.append(_builder.toString());
      _append.assertText("include", "with", "location");
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
      _append.assertText("requirements", "allEnvironments", "configurePhase", 
        "include", "location");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
