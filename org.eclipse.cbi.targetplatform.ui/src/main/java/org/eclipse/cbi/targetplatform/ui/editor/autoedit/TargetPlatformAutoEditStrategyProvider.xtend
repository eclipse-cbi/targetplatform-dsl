/*******************************************************************************
 * Copyright (c) 2012-2014 Obeo and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Mikael Barbero (Obeo) - initial API and implementation
 *******************************************************************************/
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