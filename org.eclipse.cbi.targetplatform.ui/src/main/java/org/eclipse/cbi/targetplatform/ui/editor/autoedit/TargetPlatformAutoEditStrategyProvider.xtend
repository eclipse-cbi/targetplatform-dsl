/**
 * Copyright (c) 2012-2014 Obeo and others.
 *
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Mikael Barbero (Obeo) - initial API and implementation
 */
package org.eclipse.cbi.targetplatform.ui.editor.autoedit

import org.eclipse.xtext.ui.editor.autoedit.DefaultAutoEditStrategyProvider
import org.eclipse.xtext.ui.editor.autoedit.AbstractEditStrategyProvider.IEditStrategyAcceptor
import org.eclipse.jface.text.IDocument

class TargetPlatformAutoEditStrategyProvider extends DefaultAutoEditStrategyProvider {
	
	override protected configureCompoundBracesBlocks(IEditStrategyAcceptor acceptor) {
		acceptor.accept(compoundMultiLineTerminals.newInstanceFor("{", "}"), IDocument.DEFAULT_CONTENT_TYPE);
	}
	
	override protected configureSquareBrackets(IEditStrategyAcceptor acceptor) {
	}
	
	override protected configureParenthesis(IEditStrategyAcceptor acceptor) {
	}
	
}
