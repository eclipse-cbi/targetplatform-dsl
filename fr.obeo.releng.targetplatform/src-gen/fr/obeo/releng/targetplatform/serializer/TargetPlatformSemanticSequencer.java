package fr.obeo.releng.targetplatform.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import fr.obeo.releng.targetplatform.services.TargetPlatformGrammarAccess;
import fr.obeo.releng.targetplatform.targetplatform.IU;
import fr.obeo.releng.targetplatform.targetplatform.IncludeDeclaration;
import fr.obeo.releng.targetplatform.targetplatform.Location;
import fr.obeo.releng.targetplatform.targetplatform.TargetPlatform;
import fr.obeo.releng.targetplatform.targetplatform.TargetplatformPackage;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.diagnostic.ISemanticSequencerDiagnosticProvider;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.GenericSequencer;
import org.eclipse.xtext.serializer.sequencer.ISemanticNodeProvider.INodesForEObjectProvider;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;

@SuppressWarnings("all")
public class TargetPlatformSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private TargetPlatformGrammarAccess grammarAccess;
	
	public void createSequence(EObject context, EObject semanticObject) {
		if(semanticObject.eClass().getEPackage() == TargetplatformPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case TargetplatformPackage.IU:
				if(context == grammarAccess.getIURule()) {
					sequence_IU(context, (IU) semanticObject); 
					return; 
				}
				else break;
			case TargetplatformPackage.INCLUDE_DECLARATION:
				if(context == grammarAccess.getIncludeDeclarationRule()) {
					sequence_IncludeDeclaration(context, (IncludeDeclaration) semanticObject); 
					return; 
				}
				else break;
			case TargetplatformPackage.LOCATION:
				if(context == grammarAccess.getLocationRule()) {
					sequence_Location(context, (Location) semanticObject); 
					return; 
				}
				else break;
			case TargetplatformPackage.TARGET_PLATFORM:
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
	 *     (ID=QualifiedName (version=VersionRange | version=STRING)?)
	 */
	protected void sequence_IU(EObject context, IU semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     importURI=STRING
	 */
	protected void sequence_IncludeDeclaration(EObject context, IncludeDeclaration semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, TargetplatformPackage.Literals.INCLUDE_DECLARATION__IMPORT_URI) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, TargetplatformPackage.Literals.INCLUDE_DECLARATION__IMPORT_URI));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getIncludeDeclarationAccess().getImportURISTRINGTerminalRuleCall_1_0(), semanticObject.getImportURI());
		feeder.finish();
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
	 *     (name=STRING includes+=IncludeDeclaration* (options+=Option options+=Option*)? locations+=Location*)?
	 */
	protected void sequence_TargetPlatform(EObject context, TargetPlatform semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
}
