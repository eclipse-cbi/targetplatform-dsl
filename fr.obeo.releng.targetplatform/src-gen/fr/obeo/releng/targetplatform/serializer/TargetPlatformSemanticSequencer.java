package fr.obeo.releng.targetplatform.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import fr.obeo.releng.targetplatform.Environment;
import fr.obeo.releng.targetplatform.IU;
import fr.obeo.releng.targetplatform.IncludeDeclaration;
import fr.obeo.releng.targetplatform.Location;
import fr.obeo.releng.targetplatform.Options;
import fr.obeo.releng.targetplatform.TargetPlatform;
import fr.obeo.releng.targetplatform.TargetPlatformPackage;
import fr.obeo.releng.targetplatform.services.TargetPlatformGrammarAccess;
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
	 *     (operatingSystem=ID windowingSystem=ID architecture=ID localization=Locale executionEnvironment=ExecutionEnvironment)
	 */
	protected void sequence_Environment(EObject context, Environment semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
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
			if(transientValues.isValueTransient(semanticObject, TargetPlatformPackage.Literals.INCLUDE_DECLARATION__IMPORT_URI) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, TargetPlatformPackage.Literals.INCLUDE_DECLARATION__IMPORT_URI));
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
