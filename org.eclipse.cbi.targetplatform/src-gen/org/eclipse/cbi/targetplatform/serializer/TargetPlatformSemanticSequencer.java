package org.eclipse.cbi.targetplatform.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.cbi.targetplatform.model.Environment;
import org.eclipse.cbi.targetplatform.model.IU;
import org.eclipse.cbi.targetplatform.model.IncludeDeclaration;
import org.eclipse.cbi.targetplatform.model.Location;
import org.eclipse.cbi.targetplatform.model.Options;
import org.eclipse.cbi.targetplatform.model.TargetPlatform;
import org.eclipse.cbi.targetplatform.model.TargetPlatformPackage;
import org.eclipse.cbi.targetplatform.services.TargetPlatformGrammarAccess;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.diagnostic.ISemanticSequencerDiagnosticProvider;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.GenericSequencer;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService;

@SuppressWarnings("all")
public class TargetPlatformSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private TargetPlatformGrammarAccess grammarAccess;
	
	public void createSequence(EObject context, EObject semanticObject) {
		if(semanticObject.eClass().getEPackage() == TargetPlatformPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case TargetPlatformPackage.ENVIRONMENT:
				if(context == grammarAccess.getEnvironmentRule() ||
				   context == grammarAccess.getTargetContentRule()) {
					sequence_Environment(context, (Environment) semanticObject); 
					return; 
				}
				else break;
			case TargetPlatformPackage.IU:
				if(context == grammarAccess.getIURule()) {
					sequence_IU(context, (IU) semanticObject); 
					return; 
				}
				else break;
			case TargetPlatformPackage.INCLUDE_DECLARATION:
				if(context == grammarAccess.getIncludeDeclarationRule() ||
				   context == grammarAccess.getTargetContentRule()) {
					sequence_IncludeDeclaration(context, (IncludeDeclaration) semanticObject); 
					return; 
				}
				else break;
			case TargetPlatformPackage.LOCATION:
				if(context == grammarAccess.getLocationRule() ||
				   context == grammarAccess.getTargetContentRule()) {
					sequence_Location(context, (Location) semanticObject); 
					return; 
				}
				else break;
			case TargetPlatformPackage.OPTIONS:
				if(context == grammarAccess.getOptionsRule() ||
				   context == grammarAccess.getTargetContentRule()) {
					sequence_Options(context, (Options) semanticObject); 
					return; 
				}
				else break;
			case TargetPlatformPackage.TARGET_PLATFORM:
				if(context == grammarAccess.getTargetPlatformRule()) {
					sequence_TargetPlatform(context, (TargetPlatform) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     (env+=ID env+=ID*)
	 */
	protected void sequence_Environment(EObject context, Environment semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (ID=ID (version=VersionRange | version=STRING)?)
	 */
	protected void sequence_IU(EObject context, IU semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     importURI=STRING
	 */
	protected void sequence_IncludeDeclaration(EObject context, IncludeDeclaration semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (ID=ID? uri=STRING ((options+=Option options+=Option*)? ius+=IU*)?)
	 */
	protected void sequence_Location(EObject context, Location semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (options+=Option options+=Option*)
	 */
	protected void sequence_Options(EObject context, Options semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=STRING contents+=TargetContent*)?
	 */
	protected void sequence_TargetPlatform(EObject context, TargetPlatform semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
}
