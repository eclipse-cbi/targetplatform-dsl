/*******************************************************************************
 * Copyright (c) 2012-2020 Obeo and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Mikael Barbero (Obeo) - initial API and implementation
 *******************************************************************************/
package org.eclipse.cbi.targetplatform.ui.quickfix

import com.google.common.collect.Sets
import org.eclipse.cbi.targetplatform.model.Location
import org.eclipse.cbi.targetplatform.model.TargetPlatform
import org.eclipse.cbi.targetplatform.validation.TargetPlatformValidator
import org.eclipse.xtext.ui.editor.quickfix.DefaultQuickfixProvider
import org.eclipse.xtext.ui.editor.quickfix.Fix
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionAcceptor
import org.eclipse.xtext.validation.Issue
import org.eclipse.cbi.targetplatform.model.Option

/**
 * Custom quickfixes.
 *
 * see http://www.eclipse.org/Xtext/documentation.html#quickfixes
 */
class TargetPlatformQuickfixProvider extends DefaultQuickfixProvider {

	@Fix(TargetPlatformValidator::DEPRECATE__STRINGS_ON_IU_VERSION)
	def removeQuotes(Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, 'Remove quotes.', 'Remove quotes.', null) [
			context |
			val xtextDocument = context.xtextDocument
			xtextDocument.replace(issue.offset + issue.length - 1, 1, "")
			xtextDocument.replace(issue.offset, 1, "")
		]
	}
	
	@Fix(TargetPlatformValidator::CHECK__OPTIONS_EQUALS_ALL_LOCATIONS)
	def equalizeOptions(Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, 
	    "Set all options equals to this one.", "Set all options equals to this one.", null) [
	    	element, context |
	    	val location = element as Location
	    	location.targetPlatform.locations.forEach[l |
	    		val elemLoc = element as Location;
	    		val locOptions = elemLoc.options;
	    		if (l != element && !Sets::symmetricDifference(locOptions.toSet, l.options.toSet).empty) {
	    			l.options.clear
	    			l.options.addAll(locOptions)
	    		}
	    	]
	    ]
	}
	
	@Fix(TargetPlatformValidator::CHECK__OPTIONS_SELF_EXCLUDING_ALL_ENV_REQUIRED) 
	def removeRemoveRequirements(Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, 
	    "Remove 'with requirements' option.", "Remove 'with requirements' option.", null) [
	    	element, context |
	    	if (element instanceof TargetPlatform) {
	    		element.options.remove(Option.INCLUDE_REQUIRED)
	    	} else if (element instanceof Location) {
	    		element.options.remove(Option.INCLUDE_REQUIRED)
	    	}
	    ]
	}
	
	@Fix(TargetPlatformValidator::CHECK__OPTIONS_SELF_EXCLUDING_ALL_ENV_REQUIRED) 
	def removeRemoveAllEnvironment(Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, 
	    "Remove 'with allEnvironments' option.", "Remove 'with allEnvironments' option.", null) [
	    	element, context |
	    	if (element instanceof TargetPlatform) {
	    		element.options.remove(Option.INCLUDE_ALL_ENVIRONMENTS)
	    	} else if (element instanceof Location) {
	    		element.options.remove(Option.INCLUDE_ALL_ENVIRONMENTS)
	    	}
	    ]
	}
	
	@Fix(TargetPlatformValidator::DEPRECATE__OPTIONS_ON_LOCATIONS) 
	def moveOptionsToTargetLevel(Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, 
	    "Move options to the target level and remove all location specific options.", 
	    "Move options to the target level and remove all location specific options.", null) [
	    	element, context | 
	    	val location = element as Location
	    		location.targetPlatform.options.clear;
	    		(element as Location).options.forEach[location.targetPlatform.options.add(it)];
	    		location.targetPlatform.locations.forEach[options.clear]
	    		context.xtextDocument
	    ]
	}
	
	@Fix(TargetPlatformValidator::CHECK__NO_OPTIONS_ON_LOCATIONS_IF_GLOBAL_OPTIONS)
	def removeAllLocationSpecificOptions(Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, 
	    "Remove all location specific options.", 
	    "Remove all location specific options.", null) [
	    	element, context | 
	    		val location = element as Location
	    		location.targetPlatform.locations.forEach[options.clear];
	    ]
	}
	
	@Fix(TargetPlatformValidator::CHECK__LOCATION_CONFLICTUAL_ID)
	def setOtherLocationWithSameURIToTheSameID(Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, 
	    "Set other locations with the same URI to the same ID.", 
	    "Set other locations with the same URI to the same ID.", null) [
	    	element, context | 
	    		val id = (element as Location).ID;
	    		val uri = (element as Location).uri;
	    		if (uri !== null) {
	    			val location = element as Location
		    		location.targetPlatform.locations
		    			.filter[uri !== null && uri.equals(it.uri)]
		    			.forEach[setID(id)];
	    		}
	    ]
	}
	
	@Fix(TargetPlatformValidator::CHECK__INCLUDED_LOCATION_CONFLICTUAL_ID)
	def setIDSameValueAsIncludedLocation(Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, 
	    "Set the IDs of all locations with the same URI to the same value as included location.", 
	    "Set the IDs of all locations with the same URI to the same value as included location.", null) [
	    	element, context | 
	    		val id = issue.data.get(0);
	    		val uri = issue.data.get(1);
	    		val location = element as Location
	    		location.targetPlatform.locations
		    			.filter[uri !== null && uri.equals(it.uri)]
		    			.forEach[setID(id)];
	    ]
	}
	
	@Fix(TargetPlatformValidator::CHECK__VERSION_KEYWORDS)
	def removeVersionKeywords(Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, 'Remove deprecated keywords.', 'Remove deprecated keywords.', null) [
			context |
			val xtextDocument = context.xtextDocument
			xtextDocument.replace(issue.offset, issue.length, "")
		]
	}
	
	@Fix(TargetPlatformValidator::CHECK__ESCAPE_CHAR_IU_ID)
	def removeEscapeCharInIUID(Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, 'Remove deprecated escape character.', 'Remove deprecated escape character.', null) [
			context |
			val xtextDocument = context.xtextDocument
			val fullId = xtextDocument.get(issue.offset, issue.length)
			val replaceID = fullId.replaceAll('\\^', '')
			xtextDocument.replace(issue.offset, issue.length, replaceID)
		]
	}
	
}
