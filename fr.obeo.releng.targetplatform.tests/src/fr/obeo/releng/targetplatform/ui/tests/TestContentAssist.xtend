package fr.obeo.releng.targetplatform.ui.tests

import fr.obeo.releng.targetplatform.TargetPlatformStandaloneSetup
import fr.obeo.releng.targetplatform.TargetPlatformUiInjectorProvider
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.ui.AbstractContentAssistProcessorTest
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(TargetPlatformUiInjectorProvider))
class TestContentAssist extends AbstractContentAssistProcessorTest {
	
	override protected doGetSetup() {
		return new TargetPlatformStandaloneSetup() {
			override createInjector() {
				new TargetPlatformUiInjectorProvider().injector
			}
		};
	}
	
	@Test
	def void testTargetPlatform1() {
		newBuilder
			.assertText('''target "Target Platform Name"
			''')
			.applyProposal
			.expectContent('''target "Target Platform Name"
			''')
		
		
		newBuilder
			.assertText('''target "Target Platform Name"
			''')
			.assertProposal('''target "Target Platform Name"
			''')
			.withDisplayString('target "Target Platform Name" - create a new target platform')
	}
	
	@Test
	def void testTargetPlatform2() {
		newBuilder.append("target").assertText(''' "Target Platform Name"
		''')
		.applyProposal
			.expectContent('''target "Target Platform Name"
			''')
	}
	
	@Test
	def void testTargetPlatform3() {
		newBuilder.append("target ").assertText('''"Target Platform Name"
		''')
		.applyProposal
			.expectContent('''target "Target Platform Name"
			''')
	}
	
	@Test
	def void testTargetPlatform4() {
		newBuilder.append("tar").assertText('''target "Target Platform Name"
			''')
			.applyProposal
			.expectContent('''target "Target Platform Name"
			''')
	}
	
	@Test
	def void testTargetContent() {
		newBuilder.append('''
			target "TPName"
		''').assertText("include", "with", "environment", "location")
	}
	
	@Test
	def void testTargetContentOptions1() {
		newBuilder.append('''
			target "TPName"
			with 
		''').assertText("requirements", "allEnvironments", "source", "configurePhase")
	}
	
	@Test
	def void testTargetContentOptions2() {
		newBuilder.append('''
			target "TPName"
			with source
		''').assertText(
			"requirements", "allEnvironments", "configurePhase",
			"include", "environment", "location")
	}
	
	@Test
	def void testTargetContentEnv() {
		newBuilder.append('''
			target "TPName"
			environment win32
		''').assertText("include", "with", "location")
	}
	
	@Test
	def void testTargetContentOptionsAndEnv() {
		newBuilder.append('''
			target "TPName"
			environment win32
			with source
		''').assertText("requirements", "allEnvironments", "configurePhase",
			"include", "location")
	}
}