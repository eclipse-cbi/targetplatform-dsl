/**
 * Copyright (c) 2020 itemis AG (http://www.itemis.eu) and others.
 * 
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 * 
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 *     Tamas Miklossy (itemis AG) - initial API and implementation
 *     Hannes Niederhausen (itemis AG) - formatting of maven related elements
 */
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
import org.eclipse.cbi.targetplatform.model.MavenLocation
import org.eclipse.cbi.targetplatform.model.GeneratedFeature
import org.eclipse.cbi.targetplatform.model.MavenRepository
import org.eclipse.cbi.targetplatform.model.MavenDependency

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

		includeKeywordRegion.prepend [
			if (includeKeywordRegion == firstIncludeKeywordRegion) {
				setNewLines(2, 2, 2)
			} else {
				setNewLines(1, 1, 1)
			}
		]

		includeKeywordRegion.append[oneSpace]
	}

	def dispatch void format(Location it, extension IFormattableDocument document) {
		val locationKeywordRegion = regionFor.keyword(locationAccess.locationKeyword_0)

		locationKeywordRegion.prepend[setNewLines(2, 2, 2)]

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

	def dispatch void format(MavenLocation it, extension IFormattableDocument document) {
		regionFor.keyword(mavenLocationAccess.mavenKeyword_0)?.prepend[newLines = 2].append[oneSpace]

		regionFor.keyword(mavenLocationAccess.scopeKeyword_2)?.prepend[oneSpace].append[noSpace]
		regionFor.ruleCall(mavenLocationAccess.scopesMavenScopeEnumRuleCall_4_0)?.prepend[noSpace]
		// the calls after the first scope with the leading comma
		regionFor.ruleCalls(mavenLocationAccess.scopesMavenScopeEnumRuleCall_5_1_0)?.forEach[prepend[noSpace]]
		regionFor.keywords(mavenLocationAccess.commaKeyword_5_0)?.forEach[surround[noSpace]]

		regionFor.keyword(mavenLocationAccess.dependencyDepthKeyword_6)?.prepend[oneSpace].append[noSpace]
		regionFor.ruleCall(mavenLocationAccess.dependencyDepthMavenDependencyDepthEnumRuleCall_8_0)?.prepend[noSpace]

		regionFor.keyword(mavenLocationAccess.missingManifestKeyword_9)?.prepend[oneSpace].append[noSpace]
		regionFor.ruleCall(mavenLocationAccess.missingManifestMavenMissingManifestEnumRuleCall_11_0)?.prepend[noSpace]

		regionFor.keyword(mavenLocationAccess.includeSourcesIncludeSourcesKeyword_12_0)?.prepend[oneSpace].append [
			oneSpace
		]

		val leftCurly = regionFor.keyword(mavenLocationAccess.leftCurlyBracketKeyword_13)
		val rightCurly = regionFor.keyword(mavenLocationAccess.rightCurlyBracketKeyword_17)
		leftCurly?.prepend[oneSpace].append[newLine]
		rightCurly?.surround[newLine]

		interior(leftCurly, rightCurly)[indent]

		generatedFeature?.format
		dependencies?.forEach[format]
		repositories?.forEach[format]
	}

	def dispatch void format(GeneratedFeature it, extension IFormattableDocument document) {
		regionFor.keyword(generatedFeatureAccess.featureKeyword_0).prepend[noSpace].append[oneSpace]

		val leftCurly = regionFor.keyword(generatedFeatureAccess.leftCurlyBracketKeyword_1)
		val rightCurly = regionFor.keyword(generatedFeatureAccess.rightCurlyBracketKeyword_14)
		leftCurly.prepend[oneSpace].append[newLine]
		rightCurly.surround[newLine]

		interior(leftCurly, rightCurly)[indent]

		regionFor.keyword(generatedFeatureAccess.idKeyword_2)?.prepend[newLine].append[noSpace]
		regionFor.ruleCall(generatedFeatureAccess.idSTRINGTerminalRuleCall_4_0)?.prepend[noSpace].append[newLine]

		regionFor.keyword(generatedFeatureAccess.nameKeyword_5)?.prepend[newLine].append[noSpace]
		regionFor.ruleCall(generatedFeatureAccess.nameSTRINGTerminalRuleCall_7_0)?.prepend[noSpace].append[newLine]

		regionFor.keyword(generatedFeatureAccess.versionKeyword_8)?.prepend[newLine].append[noSpace]
		regionFor.ruleCall(generatedFeatureAccess.versionSTRINGTerminalRuleCall_10_0)?.prepend[noSpace].append[newLine]

		regionFor.keyword(generatedFeatureAccess.additionalBundlesKeyword_13_0)?.prepend[newLine].append[oneSpace]
		val bundlesLeftCurly = regionFor.keyword(generatedFeatureAccess.leftCurlyBracketKeyword_13_1)?.
			prepend[oneSpace].append[newLine]
		val bundlesRightCurly = regionFor.keyword(generatedFeatureAccess.rightCurlyBracketKeyword_13_3)?.surround [
			newLine
		]
		interior(bundlesLeftCurly, bundlesRightCurly)[indent]

		additionalBundles?.forEach[format]
	}

	def dispatch void format(MavenDependency it, extension IFormattableDocument document) {
		regionFor.keyword(mavenDependencyAccess.dependencyKeyword_0).prepend[noSpace].append[oneSpace]

		val leftCurly = regionFor.keyword(mavenDependencyAccess.leftCurlyBracketKeyword_1)
		val rightCurly = regionFor.keyword(mavenDependencyAccess.rightCurlyBracketKeyword_13)
		leftCurly.prepend[oneSpace].append[newLine]
		rightCurly.surround[newLine]
		interior(leftCurly, rightCurly)[indent]

		regionFor.keyword(mavenDependencyAccess.groupIdKeyword_2)?.prepend[newLine].append[noSpace]
		regionFor.ruleCall(mavenDependencyAccess.groupIdSTRINGTerminalRuleCall_4_0)?.prepend[noSpace].append[newLine]

		regionFor.keyword(mavenDependencyAccess.artifactIdKeyword_5)?.prepend[newLine].append[noSpace]
		regionFor.ruleCall(mavenDependencyAccess.artifactIdSTRINGTerminalRuleCall_7_0)?.prepend[noSpace].append[newLine]

		regionFor.keyword(mavenDependencyAccess.versionKeyword_8)?.prepend[newLine].append[noSpace]
		regionFor.ruleCall(mavenDependencyAccess.versionSTRINGTerminalRuleCall_10_0)?.prepend[noSpace].append[newLine]

		regionFor.keyword(mavenDependencyAccess.classifierKeyword_11_0)?.prepend[newLine].append[noSpace]
		regionFor.ruleCall(mavenDependencyAccess.classifierSTRINGTerminalRuleCall_11_2_0)?.prepend[noSpace].append [
			newLine
		]

		regionFor.keyword(mavenDependencyAccess.typeKeyword_12_0)?.prepend[newLine].append[noSpace]
		regionFor.ruleCall(mavenDependencyAccess.typeSTRINGTerminalRuleCall_12_2_0)?.prepend[noSpace].append[newLine]
	}

	def dispatch void format(MavenRepository it, extension IFormattableDocument document) {
		regionFor.keyword(mavenRepositoryAccess.repositoryKeyword_0)?.prepend[newLine].append[oneSpace]

		regionFor.keyword(mavenRepositoryAccess.idKeyword_1)?.append[noSpace]
		regionFor.ruleCall(mavenRepositoryAccess.idSTRINGTerminalRuleCall_3_0)?.prepend[noSpace]

		regionFor.keyword(mavenRepositoryAccess.urlKeyword_4)?.append[noSpace].prepend[oneSpace]
		regionFor.ruleCall(mavenRepositoryAccess.urlSTRINGTerminalRuleCall_6_0)?.prepend[noSpace]
	}

	private def formatName(TargetPlatform it, extension IFormattableDocument document) {
		regionFor.feature(TARGET_PLATFORM__NAME).prepend[oneSpace].append[noSpace priority = LOW_PRIORITY]
	}

	private def formatWithKeyword(Options it, extension IFormattableDocument document) {
		regionFor.keyword(optionsAccess.withKeyword_0).prepend[oneSpace priority = HIGH_PRIORITY]
	}

	private def formatOptions(Options it, extension IFormattableDocument document) {
		allSemanticRegions.forEach [
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
		allSemanticRegions.forEach [
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
