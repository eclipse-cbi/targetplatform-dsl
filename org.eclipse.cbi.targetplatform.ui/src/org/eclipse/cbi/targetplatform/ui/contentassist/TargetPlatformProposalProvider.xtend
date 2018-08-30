/*******************************************************************************
 * Copyright (c) 2012-2014 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Mikael Barbero (Obeo) - initial API and implementation
 *******************************************************************************/
package org.eclipse.cbi.targetplatform.ui.contentassist

import com.google.inject.Inject
import org.eclipse.cbi.targetplatform.Environment
import org.eclipse.cbi.targetplatform.IU
import org.eclipse.cbi.targetplatform.Location
import org.eclipse.cbi.targetplatform.Option
import org.eclipse.cbi.targetplatform.Options
import org.eclipse.cbi.targetplatform.TargetPlatform
import org.eclipse.cbi.targetplatform.TargetPlatformFactory
import org.eclipse.cbi.targetplatform.services.TargetPlatformGrammarAccess
import org.eclipse.cbi.targetplatform.ui.internal.TargetPlatformActivator
import java.net.URI
import java.util.Locale
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.core.runtime.OperationCanceledException
import org.eclipse.core.runtime.Platform
import org.eclipse.core.runtime.ProgressMonitorWrapper
import org.eclipse.core.runtime.SubMonitor
import org.eclipse.emf.ecore.EObject
import org.eclipse.equinox.p2.core.IProvisioningAgent
import org.eclipse.equinox.p2.core.ProvisionException
import org.eclipse.equinox.p2.metadata.IInstallableUnit
import org.eclipse.equinox.p2.query.IQuery
import org.eclipse.equinox.p2.query.QueryUtil
import org.eclipse.equinox.p2.repository.metadata.IMetadataRepositoryManager
import org.eclipse.jdt.launching.JavaRuntime
import org.eclipse.jface.operation.IRunnableWithProgress
import org.eclipse.jface.viewers.StyledString
import org.eclipse.swt.widgets.Display
import org.eclipse.xtext.Assignment
import org.eclipse.xtext.Keyword
import org.eclipse.xtext.RuleCall
import org.eclipse.xtext.ui.editor.contentassist.ConfigurableCompletionProposal
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor

/**
 * see http://www.eclipse.org/Xtext/documentation.html#contentAssist on how to customize content assistant
 */
class TargetPlatformProposalProvider extends AbstractTargetPlatformProposalProvider {
	
	static val PROP_TYPE_CATEGORY = "org.eclipse.equinox.p2.type.category"; //$NON-NLS-1$
	static val PROP_TYPE_PRODUCT = "org.eclipse.equinox.p2.type.product"; //$NON-NLS-1$

	static val TARGET_PLATFORM__NAME_PLACEHOLDER = "Target Platform Name"
	static val INCLUDE_DECLARATION__URI_PLACEHOLDER = "includedFile.tpd"
	static val LOCATION__URI_PLACEHOLDER = "http://p2.repository.url/"
	static val LOCATION__ID_PLACEHOLDER = "locationID"
	
	static val TARGET_PLATFORM = TargetPlatformFactory.eINSTANCE.createTargetPlatform
	static val INCLUDE_DECLARATION = TargetPlatformFactory.eINSTANCE.createIncludeDeclaration
	static val OPTIONS = TargetPlatformFactory.eINSTANCE.createOptions
	static val ENVIRONMENT = TargetPlatformFactory.eINSTANCE.createEnvironment
	static val LOCATION = TargetPlatformFactory.eINSTANCE.createLocation
	static val IU = TargetPlatformFactory.eINSTANCE.createIU
	
	@Inject
	private TargetPlatformGrammarAccess grammarAccess;
	
	@Inject
	private IProvisioningAgent provisioningAgent
	
	var IQuery<IInstallableUnit> iuAssistQuery
	
	new() {
	}
	
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
				p.setSelectionStart(p.getReplacementOffset() + proposalPrefix.length);
				p.setSelectionLength(TargetPlatformProposalProvider.TARGET_PLATFORM__NAME_PLACEHOLDER.length);
				p.setSimpleLinkedMode(context.getViewer(), '\t');
			}
			acceptor.accept(p);
		}
	}
	
	private def getIUAssistQuery() {
		if (iuAssistQuery === null) {
		  iuAssistQuery = QueryUtil.createQuery("latest(x | x.properties[$0] != true && x.properties[$1] != true)", 
							PROP_TYPE_CATEGORY, PROP_TYPE_PRODUCT)
		}
		return iuAssistQuery
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
			p.setSelectionStart(p.getReplacementOffset() + offset);
			p.setSelectionLength(TARGET_PLATFORM__NAME_PLACEHOLDER.length);
			p.setSimpleLinkedMode(context.getViewer(), '\t');
		}
		acceptor.accept(p)
	}

	override completeTargetPlatform_Contents(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		val currentNodeSizeToCursor = context.offset - context.lastCompleteNode.endOffset;
		val text = 
			if (context.currentNode.text.length >= currentNodeSizeToCursor) 
				context.currentNode.text.substring(0, currentNodeSizeToCursor)
			else
				''
		if (text.contains("\n") || context.currentNode.text.length < currentNodeSizeToCursor) {
			// only propose TP Contents assist if on a new line, the UX is better
			
			val tp = model as TargetPlatform
			if (tp.options.empty) {
				acceptor.accept(createCompletionProposal("with", "describe how the set of elements to add to this target is determined", OPTIONS, 520, context));
			}
			if (tp.environment === null) {
				acceptor.accept(createCompletionProposal("environment", "describe the system that this target is built for", ENVIRONMENT, 510, context));
			}
			
			templateLocation(context, acceptor)
			templateIncludeDeclaration(context, acceptor)
		}
	}
	
	private def templateLocation(ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		val proposalPrefix = grammarAccess.locationAccess.locationKeyword_0.value + ' "'
		val proposalText = proposalPrefix + TargetPlatformProposalProvider.LOCATION__URI_PLACEHOLDER + '"'
		val middleText = ' {' + context.viewer.textWidget.lineDelimiter + '\t'
		val p = createCompletionProposal(
			proposalText + middleText + context.viewer.textWidget.lineDelimiter + '}', 
			new StyledString(proposalText).append(" - add a new location to this target platform", StyledString.QUALIFIER_STYLER), 
			getImage(LOCATION), 
			context
		)
		
		if (p instanceof ConfigurableCompletionProposal) {
			p.priority = priorityHelper.defaultPriority + 540
			p.cursorPosition = proposalText.length + middleText.length
			p.setSelectionStart(p.getReplacementOffset() + proposalPrefix.length);
			p.setSelectionLength(TargetPlatformProposalProvider.LOCATION__URI_PLACEHOLDER.length);
			p.setSimpleLinkedMode(context.getViewer(), '\t');
		}
		acceptor.accept(p);
	}
	
	private def templateIncludeDeclaration(ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		val proposalPrefix = grammarAccess.includeDeclarationAccess.includeKeyword_0.value + ' "'
		val proposalText = proposalPrefix +TargetPlatformProposalProvider.INCLUDE_DECLARATION__URI_PLACEHOLDER+ '"'
		val p = createCompletionProposal(
			proposalText + context.viewer.textWidget.lineDelimiter, 
			new StyledString(proposalText).append(" - include another target platform to this file", StyledString.QUALIFIER_STYLER), 
			getImage(INCLUDE_DECLARATION), 
			context
		)
		
		if (p instanceof ConfigurableCompletionProposal) {
			p.priority = priorityHelper.defaultPriority + 530
			p.setSelectionStart(p.getReplacementOffset() + proposalPrefix.length);
			p.setSelectionLength(TargetPlatformProposalProvider.INCLUDE_DECLARATION__URI_PLACEHOLDER.length);
			p.setSimpleLinkedMode(context.getViewer(), '\t');
		}
		acceptor.accept(p);
	}
	
	override completeOptions_Options(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		val currentNodeSizeToCursor = context.offset - context.lastCompleteNode.endOffset;
		val text =
			if (context.currentNode.text.length >= currentNodeSizeToCursor)  
				context.currentNode.text.substring(0, currentNodeSizeToCursor)
			else 
				''
		if (!text.contains("\n") || context.currentNode.text.length < currentNodeSizeToCursor) {
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
		val currentNodeSizeToCursor = context.offset - context.lastCompleteNode.endOffset;
		val text =
			if (context.currentNode.text.length >= currentNodeSizeToCursor)  
				context.currentNode.text.substring(0, currentNodeSizeToCursor)
			else 
				''
		if (!text.contains("\n") || context.currentNode.text.length < currentNodeSizeToCursor) {
			val env = model as Environment
			if (env.operatingSystem === null) {
				Platform.knownOSValues.forEach[
					acceptor.accept(createCompletionProposal(it, 'operating system', env, 340, context))
				]
			}
			
			if (env.windowingSystem === null) {
				Platform.knownWSValues.forEach[
					acceptor.accept(createCompletionProposal(it, 'windowing system', env, 330, context))
				]
			}
			
			if (env.architecture === null) {
				Platform.knownOSArchValues.forEach[
					acceptor.accept(createCompletionProposal(it, 'architecture', env, 320, context))
				]
			}
			
			if (env.executionEnvironment === null) {
				val eeManager = JavaRuntime.executionEnvironmentsManager
				if (eeManager !== null) {
					eeManager.executionEnvironments.forEach[
						acceptor.accept(createCompletionProposal(it.id, it.description, env, 310, context))
					]
				}
			}
			
			if (env.localization === null) {
				Locale.getAvailableLocales.forEach[
					acceptor.accept(createCompletionProposal(it.toString, it.displayName, env, 300, context))
				]
			}
		}
	}
	
	override completeIU_ID(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		val currentNodeSizeToCursor = context.offset - context.lastCompleteNode.endOffset;
		val text = 
			if (context.currentNode.text.length >= currentNodeSizeToCursor) 
				context.currentNode.text.substring(0, currentNodeSizeToCursor)
			else
				''
		if (text.contains("\n") || context.currentNode.text.length < currentNodeSizeToCursor) {
			val location = model as Location
			val uri = location.uri 
			val window = TargetPlatformActivator.getInstance.workbench.activeWorkbenchWindow
			val IRunnableWithProgress op = [monitor|
				val wpm = SubMonitor.convert(new ReadAndDispatchProgressMonitorWrapper(monitor, window.shell.display), "Creating content assist for " + uri, 100)
				try {
					val repositoryManager = provisioningAgent.getService(IMetadataRepositoryManager.SERVICE_NAME) as IMetadataRepositoryManager
					val metadataRepository = repositoryManager.loadRepository(new URI(uri), wpm.newChild(90))
					val results = metadataRepository.query(getIUAssistQuery, wpm.newChild(5)).toUnmodifiableSet()
					results.filter[!location.ius.map[ID].contains(it.id)].forEach[
						val allVersions = metadataRepository.query(QueryUtil.createIUQuery(id), wpm.newChild(5))
						acceptor.accept(createCompletionProposal(id, allVersions.iterator.map[version.toString].join(', '), IU, 0, context))
					]
				} catch (Exception e) {
					// a lot of thing can happen while trying to load arbitrary string as a p2 url. Ignore all errors, and do not provide
					// any feedback, validation should attach an error to the location.
				}
			]
			window.run(false, true, op)
		}
	}
	
	override completeIU_Version(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		val docText = context.viewer.document.get
		val offset = context.offset
		
		val charBefore = 
			if (docText.length >= 1) {
				docText.substring(offset-1,offset)
			} else {
				''
			}
		
		val prefix = 
			if (!charBefore.equals(' ') && !charBefore.equals('\n')) {
				' '
			} else {
				''
			}
		
		val currentNodeSizeToCursor = context.offset - context.lastCompleteNode.endOffset;
		val text = 
			if (context.currentNode.text.length >= currentNodeSizeToCursor) 
				context.currentNode.text.substring(0, currentNodeSizeToCursor)
			else
				''
		if (!text.contains("\n") || context.currentNode.text.length < currentNodeSizeToCursor) {
			val iu = model as IU
			val uri = iu.location.uri 
			val window = TargetPlatformActivator.getInstance.workbench.activeWorkbenchWindow
			val op = versionProposalRunnable(uri, iu, prefix, window.shell.display, context, acceptor)
			window.run(false, true, op)
		}
	}
	
	
	override completeLocation_ID(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		val docText = context.viewer.document.get
		val offset = context.offset
		
		val charBefore = 
			if (docText.length >= 1) {
				docText.substring(offset-1,offset)
			} else {
				''
			}
		val charAfter =
			if (docText.length > offset) { 
				docText.substring(offset,offset+1)
			} else {
				''
			}
		
		val prefix = 
			if (!charBefore.equals(' ') && !charBefore.equals('\n')) {
				' '
			} else {
				''
			}
		
		val suffix =
			if (!charAfter.equals(' ')) {
				' '
			} else {
				''
			}
		
		val proposal =  prefix + LOCATION__ID_PLACEHOLDER + suffix
		 
		val p = createCompletionProposal(
			proposal, 
			new StyledString(LOCATION__ID_PLACEHOLDER).append(" - ID of this location ", StyledString.QUALIFIER_STYLER), 
			getImage(LOCATION), 
			context
		)
		
		if (p instanceof ConfigurableCompletionProposal) {
			p.setSelectionStart(p.getReplacementOffset() + prefix.length);
			p.setSelectionLength(LOCATION__ID_PLACEHOLDER.length);
			p.setSimpleLinkedMode(context.getViewer(), '\t');
		}
		acceptor.accept(p);
	}
	
	override completeLocation_Uri(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		val docText = context.viewer.document.get
		val offset = context.offset
		
		val charBefore = 
			if (docText.length >= 1) {
				docText.substring(offset-1,offset)
			} else {
				''
			}
		val charAfter =
			if (docText.length > offset) { 
				docText.substring(offset,offset+1)
			} else {
				''
			}
		
		val prefix = 
			if (!charBefore.equals(' ') && !charBefore.equals('\n')) {
				' "'
			} else {
				'"'
			}
		
		val suffix =
			if (!charAfter.equals(' ')) {
				'" '
			} else {
				'"'
			}
		
		val proposal =  prefix + LOCATION__URI_PLACEHOLDER + suffix
		
		val p = createCompletionProposal(
			proposal,
			new StyledString(LOCATION__URI_PLACEHOLDER).append(" - URI of the location", StyledString.QUALIFIER_STYLER),
			getImage(LOCATION),
			context)
			
		if (p instanceof ConfigurableCompletionProposal) {
			p.setSelectionStart(p.getReplacementOffset() + prefix.length);
			p.setSelectionLength(LOCATION__URI_PLACEHOLDER.length);
			p.setSimpleLinkedMode(context.getViewer(), '\t');
		}
		acceptor.accept(p)
	}
	
	override completeKeyword(Keyword keyword, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
	}
	
	override complete_STRING(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
	}
	
	private def IRunnableWithProgress versionProposalRunnable(String uri, IU iu, String prefix, Display display, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		return [monitor|
			val wpm = SubMonitor.convert(new ReadAndDispatchProgressMonitorWrapper(monitor, display), "Creating content assist for " + uri, 100)
			try {
				val repositoryManager = provisioningAgent.getService(IMetadataRepositoryManager.SERVICE_NAME) as IMetadataRepositoryManager
				val metadataRepository = repositoryManager.loadRepository(new URI(uri), wpm.newChild(95))
				val results = metadataRepository.query(QueryUtil.createIUQuery(iu.ID), wpm.newChild(5)).toUnmodifiableSet()
				results.forEach[
					val major = version.getSegment(0) as Integer
					val minor = version.getSegment(1) as Integer
					val micro = version.getSegment(2) as Integer
					
					acceptor.accept(createCompletionProposal('''«prefix»[«major».«minor».«micro»,«major+1».0.0)''', '''[«major».«minor».«micro»,«major+1».0.0)''', getImage(IU), context))
					acceptor.accept(createCompletionProposal('''«prefix»[«major».«minor».«micro»,«major».«minor+1».0)''', '''[«major».«minor».«micro»,«major».«minor+1».0)''', getImage(IU), context))
					acceptor.accept(createCompletionProposal('''«prefix»[«major».«minor».«micro»,«major».«minor».«micro+1»)''', '''[«major».«minor».«micro»,«major».«minor».«micro+1»)''', getImage(IU), context))
					acceptor.accept(createCompletionProposal('''«prefix»[«version»,«version»]''', '''[«version»,«version»]''', getImage(IU), context))
				]
				if (!results.empty) {
					acceptor.accept(createCompletionProposal('''«prefix»lazy''', '''lazy''', getImage(IU), context))
				}
			} catch (IllegalStateException e) {
			} catch (ProvisionException e) {
			} catch (OperationCanceledException e) {
			}
		]
	}
}

class ReadAndDispatchProgressMonitorWrapper extends ProgressMonitorWrapper {
	
	val Display display
	
	protected new(IProgressMonitor monitor, Display display) {
		super(monitor)
		this.display = display
	}
	
	override internalWorked(double work) {
		if (Thread.currentThread == display.thread) {
			display.readAndDispatch
			super.internalWorked(work)
			display.readAndDispatch
		} else {
			display.asyncExec([|super.internalWorked(work)])
		}
	}
	
	override subTask(String name) {
		if (Thread.currentThread == display.thread) {
			display.readAndDispatch
			super.subTask(name)
			display.readAndDispatch
		} else {
			display.asyncExec([|super.subTask(name)])
		}
	}
	
	override worked(int work) {
		if (Thread.currentThread == display.thread) {
			display.readAndDispatch
			super.worked(work)
			display.readAndDispatch
		} else {
			display.asyncExec([|])
		}
	}
	
	override beginTask(String name, int totalWork) {
		if (Thread.currentThread == display.thread) {
			display.readAndDispatch
			super.beginTask(name, totalWork)
			display.readAndDispatch
		} else {
			display.asyncExec([|super.beginTask(name, totalWork)])
		}
	}
	
	override setTaskName(String name) {
		if (Thread.currentThread == display.thread) {
			display.readAndDispatch
			super.setTaskName(name)
			display.readAndDispatch
		} else {
			display.asyncExec([|super.setTaskName(name)])
		}
	}
}