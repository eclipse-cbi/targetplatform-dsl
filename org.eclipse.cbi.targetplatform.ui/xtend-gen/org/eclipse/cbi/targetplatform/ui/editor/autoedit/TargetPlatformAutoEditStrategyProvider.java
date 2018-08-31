/**
 * Copyright (c) 2012-2014 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 */
package org.eclipse.cbi.targetplatform.ui.editor.autoedit;

import org.eclipse.jface.text.IDocument;
import org.eclipse.xtext.ui.editor.autoedit.AbstractEditStrategyProvider;
import org.eclipse.xtext.ui.editor.autoedit.DefaultAutoEditStrategyProvider;

@SuppressWarnings("all")
public class TargetPlatformAutoEditStrategyProvider extends DefaultAutoEditStrategyProvider {
  @Override
  protected void configureCompoundBracesBlocks(final AbstractEditStrategyProvider.IEditStrategyAcceptor acceptor) {
    acceptor.accept(this.compoundMultiLineTerminals.newInstanceFor("{", "}"), IDocument.DEFAULT_CONTENT_TYPE);
  }
  
  @Override
  protected void configureSquareBrackets(final AbstractEditStrategyProvider.IEditStrategyAcceptor acceptor) {
  }
  
  @Override
  protected void configureParenthesis(final AbstractEditStrategyProvider.IEditStrategyAcceptor acceptor) {
  }
}
