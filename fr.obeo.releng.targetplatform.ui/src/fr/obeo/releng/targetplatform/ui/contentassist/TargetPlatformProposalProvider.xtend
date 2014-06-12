package fr.obeo.releng.targetplatform.ui.contentassist

import com.google.inject.Inject
import fr.obeo.releng.targetplatform.Option
import fr.obeo.releng.targetplatform.Options
import fr.obeo.releng.targetplatform.TargetPlatform
import fr.obeo.releng.targetplatform.TargetPlatformFactory
import fr.obeo.releng.targetplatform.services.TargetPlatformGrammarAccess
import org.eclipse.emf.ecore.EObject
import org.eclipse.jface.viewers.StyledString
import org.eclipse.xtext.Assignment
import org.eclipse.xtext.Keyword
import org.eclipse.xtext.RuleCall
import org.eclipse.xtext.ui.editor.contentassist.ConfigurableCompletionProposal
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor
import org.eclipse.jface.text.contentassist.ICompletionProposal
import fr.obeo.releng.targetplatform.Environment
import org.eclipse.core.runtime.Platform
import java.util.Locale
import org.eclipse.jdt.launching.JavaRuntime

/**
 * see http://www.eclipse.org/Xtext/documentation.html#contentAssist on how to customize content assistant
 */
class TargetPlatformProposalProvider extends AbstractTargetPlatformProposalProvider {
	
	static val TARGET_PLATFORM = TargetPlatformFactory.eINSTANCE.createTargetPlatform
	
	@Inject
	private TargetPlatformGrammarAccess grammarAccess;
	
	static val TARGET_PLATFORM__NAME_PLACEHOLDER = "Target Platform Name"
	
	override complete_TargetPlatform(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		if (context.currentNode.grammarElement != grammarAccess.targetPlatformAccess.targetKeyword_0) {
			val proposalPrefix = grammarAccess.targetPlatformAccess.targetKeyword_0.value + ' "'
			val proposalText = proposalPrefix +TargetPlatformProposalProvider.TARGET_PLATFORM__NAME_PLACEHOLDER+ '"'
			val p = createCompletionProposal(
				proposalText + context.viewer.textWidget.lineDelimiter, 
				new StyledString(proposalText).append(" - create a new target platform", StyledString.QUALIFIER_STYLER), 
				getImage(TARGET_PLATFORM), 
				context
			)
			
			if (p instanceof ConfigurableCompletionProposal) {
				p.autoInsertable = true
				p.setSelectionStart(p.getReplacementOffset() + proposalPrefix.length);
				p.setSelectionLength(TargetPlatformProposalProvider.TARGET_PLATFORM__NAME_PLACEHOLDER.length);
				p.setSimpleLinkedMode(context.getViewer(), '\t');
			}
			acceptor.accept(p);
		}
	}
	
	override completeTargetPlatform_Name(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		var String textProposal
		var int offset 
		if (context.currentNode.grammarElement == grammarAccess.targetPlatformAccess.targetKeyword_0) {
			textProposal = ''' "«TARGET_PLATFORM__NAME_PLACEHOLDER»"«context.viewer.textWidget.lineDelimiter»'''
			offset = 2
		} else {
			textProposal = '''"«TARGET_PLATFORM__NAME_PLACEHOLDER»"«context.viewer.textWidget.lineDelimiter»'''
			offset = 1
		}
		
		val p = createCompletionProposal(
			textProposal,
			new StyledString('''"«TARGET_PLATFORM__NAME_PLACEHOLDER»"''').append(" - name of the target", StyledString.QUALIFIER_STYLER),
			getImage(TARGET_PLATFORM),
			context)
			
		if (p instanceof ConfigurableCompletionProposal) {
			p.autoInsertable = true
			p.setSelectionStart(p.getReplacementOffset() + offset);
			p.setSelectionLength(TARGET_PLATFORM__NAME_PLACEHOLDER.length);
			p.setSimpleLinkedMode(context.getViewer(), '\t');
		}
		acceptor.accept(p)
	}

	override completeTargetPlatform_Contents(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		val tp = model as TargetPlatform
		acceptor.accept(createCompletionProposal("include", "extend another target platform", TargetPlatformFactory.eINSTANCE.createIncludeDeclaration, 540, context));
		if (tp.options.empty) {
			acceptor.accept(createCompletionProposal("with", "describe how the set of elements to add to this target is determined", TargetPlatformFactory.eINSTANCE.createOptions, 530, context));
		}
		if (tp.environment == null) {
			acceptor.accept(createCompletionProposal("environment", "describe the system that this target is built for", TargetPlatformFactory.eINSTANCE.createEnvironment, 520, context));
		}
		acceptor.accept(createCompletionProposal("location", "add a p2 repository location", TargetPlatformFactory.eINSTANCE.createLocation, 510, context));
	}
	
	override completeOptions_Options(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		val options = model as Options
		
		if (!options.options.contains(Option.INCLUDE_REQUIRED)) {
			acceptor.accept(createCompletionProposal(Option.INCLUDE_REQUIRED.literal, 'all required software will be added to the target platform', options, 440, context))
		}
		
		if (!options.options.contains(Option.INCLUDE_SOURCE)) {
			acceptor.accept(createCompletionProposal(Option.INCLUDE_SOURCE.literal, 'sources (if available) of the content will be added to the target platform', options, 430, context))
		}
		
		if (!options.options.contains(Option.INCLUDE_ALL_ENVIRONMENTS)) {
			acceptor.accept(createCompletionProposal(Option.INCLUDE_ALL_ENVIRONMENTS.literal, 'all available environment specific plug-ins will be added to the target platform', options, 420, context))
		}
		
		if (!options.options.contains(Option.INCLUDE_CONFIGURE_PHASE)) {
			acceptor.accept(createCompletionProposal(Option.INCLUDE_CONFIGURE_PHASE.literal, 'the configure phase will be run during the download operation of the target platform', options, 410, context))
		}
	}
	
	private def createCompletionProposal(String proposal, String desc, EObject imageFor, int priority, ContentAssistContext context) {
		val p = createCompletionProposal(
			proposal, 
			new StyledString(proposal).append(''' - «desc»''', StyledString.QUALIFIER_STYLER), 
			getImage(imageFor), 
			context
		)
		if (p instanceof ConfigurableCompletionProposal) {
			p.priority = priorityHelper.defaultPriority + priority;
		}
		return p
	}
	
	override completeEnvironment_Env(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		val env = model as Environment
		
		if (env.operatingSystem == null) {
			Platform.knownOSValues.forEach[
				acceptor.accept(createCompletionProposal(it, 'operating system', env, 340, context))
			]
		}
		
		if (env.windowingSystem == null) {
			Platform.knownWSValues.forEach[
				acceptor.accept(createCompletionProposal(it, 'windowing system', env, 330, context))
			]
		}
		
		if (env.architecture == null) {
			Platform.knownOSArchValues.forEach[
				acceptor.accept(createCompletionProposal(it, 'architecture', env, 320, context))
			]
		}
		
		if (env.localization == null) {
			Locale.getAvailableLocales.forEach[
				acceptor.accept(createCompletionProposal(it.toString, it.displayName, env, 310, context))
			]
		}
		
		if (env.executionEnvironment == null) {
			val eeManager = JavaRuntime.executionEnvironmentsManager
			if (eeManager != null) {
				eeManager.executionEnvironments.forEach[
					acceptor.accept(createCompletionProposal(it.id, it.description, env, 300, context))
				]
			}
		}
	}
	
	override complete_IncludeDeclaration(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		acceptor.accept(createCompletionProposal("DUMMY", context))
	}	
	
	override completeKeyword(Keyword keyword, ContentAssistContext contentAssistContext, ICompletionProposalAcceptor acceptor) {
		
	}
	
}
