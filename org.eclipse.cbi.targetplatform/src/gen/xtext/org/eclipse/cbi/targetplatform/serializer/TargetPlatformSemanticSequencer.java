/*******************************************************************************
 * Copyright (c) 2012-2017 Obeo and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Mikael Barbero (Obeo) - initial API and implementation
 *******************************************************************************/
package org.eclipse.cbi.targetplatform.serializer;

import com.google.inject.Inject;
import java.util.Set;
import org.eclipse.cbi.targetplatform.model.Environment;
import org.eclipse.cbi.targetplatform.model.IU;
import org.eclipse.cbi.targetplatform.model.IncludeDeclaration;
import org.eclipse.cbi.targetplatform.model.Location;
import org.eclipse.cbi.targetplatform.model.Options;
import org.eclipse.cbi.targetplatform.model.TargetPlatform;
import org.eclipse.cbi.targetplatform.model.TargetPlatformPackage;
import org.eclipse.cbi.targetplatform.services.TargetPlatformGrammarAccess;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;

@SuppressWarnings("all")
public class TargetPlatformSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private TargetPlatformGrammarAccess grammarAccess;
	
	@Override
	public void sequence(ISerializationContext context, EObject semanticObject) {
		EPackage epackage = semanticObject.eClass().getEPackage();
		ParserRule rule = context.getParserRule();
		Action action = context.getAssignedAction();
		Set<Parameter> parameters = context.getEnabledBooleanParameters();
		if (epackage == TargetPlatformPackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case TargetPlatformPackage.ENVIRONMENT:
				sequence_Environment(context, (Environment) semanticObject); 
				return; 
			case TargetPlatformPackage.IU:
				sequence_IU(context, (IU) semanticObject); 
				return; 
			case TargetPlatformPackage.INCLUDE_DECLARATION:
				sequence_IncludeDeclaration(context, (IncludeDeclaration) semanticObject); 
				return; 
			case TargetPlatformPackage.LOCATION:
				sequence_Location(context, (Location) semanticObject); 
				return; 
			case TargetPlatformPackage.OPTIONS:
				sequence_Options(context, (Options) semanticObject); 
				return; 
			case TargetPlatformPackage.TARGET_PLATFORM:
				sequence_TargetPlatform(context, (TargetPlatform) semanticObject); 
				return; 
			}
		if (errorAcceptor != null)
			errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Contexts:
	 *     TargetContent returns Environment
	 *     Environment returns Environment
	 *
	 * Constraint:
	 *     (env+=ID env+=ID*)
	 */
	protected void sequence_Environment(ISerializationContext context, Environment semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     IU returns IU
	 *
	 * Constraint:
	 *     (ID=ID (version=VersionRange | version=STRING)?)
	 */
	protected void sequence_IU(ISerializationContext context, IU semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     TargetContent returns IncludeDeclaration
	 *     IncludeDeclaration returns IncludeDeclaration
	 *
	 * Constraint:
	 *     importURI=STRING
	 */
	protected void sequence_IncludeDeclaration(ISerializationContext context, IncludeDeclaration semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, TargetPlatformPackage.Literals.INCLUDE_DECLARATION__IMPORT_URI) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, TargetPlatformPackage.Literals.INCLUDE_DECLARATION__IMPORT_URI));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getIncludeDeclarationAccess().getImportURISTRINGTerminalRuleCall_1_0(), semanticObject.getImportURI());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     TargetContent returns Location
	 *     Location returns Location
	 *
	 * Constraint:
	 *     ((ID=ID | uri=STRING)* (options+=Option options+=Option*)? ius+=IU*)
	 */
	protected void sequence_Location(ISerializationContext context, Location semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     TargetContent returns Options
	 *     Options returns Options
	 *
	 * Constraint:
	 *     (options+=Option options+=Option*)
	 */
	protected void sequence_Options(ISerializationContext context, Options semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     TargetPlatform returns TargetPlatform
	 *
	 * Constraint:
	 *     (name=STRING contents+=TargetContent*)
	 */
	protected void sequence_TargetPlatform(ISerializationContext context, TargetPlatform semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
}
