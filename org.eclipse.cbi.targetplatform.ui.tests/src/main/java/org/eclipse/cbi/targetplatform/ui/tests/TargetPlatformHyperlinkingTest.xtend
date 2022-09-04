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
 */
package org.eclipse.cbi.targetplatform.ui.tests

import com.google.inject.Inject
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.ui.editor.XtextEditorInfo
import org.eclipse.xtext.ui.editor.hyperlinking.XtextHyperlink
import org.junit.Test
import org.junit.runner.RunWith

import static extension org.eclipse.xtext.ui.testing.util.IResourcesSetupUtil.createFile

/**
 * @author miklossy - Initial contribution and API
 */
@RunWith(XtextRunner)
@InjectWith(TargetPlatformUiInjectorProvider)
class TargetPlatformHyperlinkingTest extends AbstractHyperlinkingTest {

	@Inject XtextEditorInfo editorInfo

	@Test def hyperlink_on_include_declaration_on_same_level() {

		createEmptyFile(projectName + "/4.4-luna.tpd")

		'''
			target "Test Target Platform"
			include "«c»4.4-luna.tpd«c»"
		'''.hasHyperlinkTo("platform:/resource/HyperlinkingTestProject/4.4-luna.tpd")
	}

	@Test def hyperlink_on_include_declaration_one_level_below() {

		createEmptyFile(projectName + "/testing/4.4-luna.tpd")

		'''
			target "Test Target Platform"
			include "«c»testing/4.4-luna.tpd«c»"
		'''.hasHyperlinkTo("platform:/resource/HyperlinkingTestProject/testing/4.4-luna.tpd")
	}

	@Test def hyperlink_on_include_declaration_one_level_above() {

		createEmptyFile("inc/xtext-target.tpd")

		'''
			target "Test Target Platform"
			include "«c»../inc/xtext-target.tpd«c»"
		'''.hasHyperlinkTo("platform:/resource/inc/xtext-target.tpd")
	}

	private def createEmptyFile(String workspaceRelativePath) {
		workspaceRelativePath.createFile("")
	}

	override protected dispatch target(XtextHyperlink hyperlink) {
		hyperlink.URI.toString
	}

	override protected getEditorId() {
		editorInfo.editorId
	}

}
