/*******************************************************************************
 * Copyright (c) 2020 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tamas Miklossy (itemis AG) - initial API and implementation
 *******************************************************************************/
package org.eclipse.cbi.targetplatform.formatting2

import com.google.inject.Inject
import org.eclipse.cbi.targetplatform.model.Environment
import org.eclipse.cbi.targetplatform.model.IU
import org.eclipse.cbi.targetplatform.model.IncludeDeclaration
import org.eclipse.cbi.targetplatform.model.Location
import org.eclipse.cbi.targetplatform.model.Options
import org.eclipse.cbi.targetplatform.model.TargetPlatform
import org.eclipse.cbi.targetplatform.services.TargetPlatformGrammarAccess
import org.eclipse.xtext.AbstractRule
import org.eclipse.xtext.formatting2.AbstractFormatter2
import org.eclipse.xtext.formatting2.IFormattableDocument
import org.eclipse.xtext.formatting2.internal.SinglelineDocCommentReplacer
import org.eclipse.xtext.formatting2.regionaccess.IComment

import static org.eclipse.cbi.targetplatform.model.TargetPlatformPackage.Literals.IU__VERSION
import static org.eclipse.cbi.targetplatform.model.TargetPlatformPackage.Literals.LOCATION__ID
import static org.eclipse.cbi.targetplatform.model.TargetPlatformPackage.Literals.TARGET_PLATFORM__NAME
import static org.eclipse.xtext.formatting2.IHiddenRegionFormatter.HIGH_PRIORITY
import static org.eclipse.xtext.formatting2.IHiddenRegionFormatter.LOW_PRIORITY

class TargetPlatformFormatter extends AbstractFormatter2 {

	@Inject extension TargetPlatformGrammarAccess

	def dispatch void format(TargetPlatform it, extension IFormattableDocument document) {
		formatName(document)
		contents.forEach[format]
	}

	def dispatch void format(Options it, extension IFormattableDocument document) {
		formatWithKeyword(document)
		formatOptions(document)
	}

	def dispatch void format(Environment it, extension IFormattableDocument document) {
		formatEnvironmentKeyword(document)
		formatEnvironments(document)
	}

	def dispatch void format(IncludeDeclaration it, extension IFormattableDocument document) {
		val includeKeyword = includeDeclarationAccess.includeKeyword_0
		val includeKeywordRegion = regionFor.keyword(includeKeyword)
		val firstIncludeKeywordRegion = eContainer.allRegionsFor.keywords(includeKeyword).head

		includeKeywordRegion.prepend[
			if (includeKeywordRegion == firstIncludeKeywordRegion) {
				setNewLines(2,2,2)
			} else {
				setNewLines(1,1,1)
			}
		]

		includeKeywordRegion.append[oneSpace]
	}

	def dispatch void format(Location it, extension IFormattableDocument document) {
		val locationKeywordRegion = regionFor.keyword(locationAccess.locationKeyword_0)

		locationKeywordRegion.prepend[setNewLines(2,2,2)]

		locationKeywordRegion.append[oneSpace]

		regionFor.feature(LOCATION__ID).surround[oneSpace]

		val begin = regionFor.keyword("{")
		var end = regionFor.keyword("}")

		begin.prepend[oneSpace]
		begin.append[newLine]
		interior(begin, end)[indent]
		ius.forEach[format]
		end.prepend[newLine]
	}

	def dispatch void format(IU it, extension IFormattableDocument document) {
		regionFor.feature(IU__VERSION).prepend[oneSpace].append[noSpace]
		append[newLine]
	}

	private def formatName(TargetPlatform it, extension IFormattableDocument document) {
		regionFor.feature(TARGET_PLATFORM__NAME).
		prepend[oneSpace].
		append[noSpace priority = LOW_PRIORITY]
	}

	private def formatWithKeyword(Options it, extension IFormattableDocument document) {
		regionFor.keyword(optionsAccess.withKeyword_0).prepend[oneSpace priority = HIGH_PRIORITY]
	}

	private def formatOptions(Options it, extension IFormattableDocument document) {
		allSemanticRegions.forEach[
			if (text == ",") {
				prepend[noSpace].append[oneSpace]
			} else {
				
				prepend[oneSpace priority = HIGH_PRIORITY]
				append[noSpace priority = LOW_PRIORITY]
			}
		]
	}

	private def formatEnvironmentKeyword(Environment it, extension IFormattableDocument document) {
		regionFor.keyword(environmentAccess.environmentKeyword_1).prepend[oneSpace priority = HIGH_PRIORITY]
	}

	private def formatEnvironments(Environment it, extension IFormattableDocument document) {
		allSemanticRegions.forEach[
			if (text == ",") {
				prepend[noSpace].append[oneSpace]
			} else {
				prepend[oneSpace priority = HIGH_PRIORITY]
				append[noSpace priority = LOW_PRIORITY]
			}
		]
	}

	/*
	 * Ensure the single line comments within curly braces are also indented.
	 */
	override createCommentReplacer(IComment comment) {
		val grammarElement = comment.grammarElement
		if (grammarElement instanceof AbstractRule) {
			val ruleName = grammarElement.name
			if (ruleName.startsWith("SL")) {
				return new SinglelineDocCommentReplacer(comment, "//")
			}
		}
		super.createCommentReplacer(comment)
	}
}
