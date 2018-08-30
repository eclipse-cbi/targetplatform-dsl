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
package org.eclipse.cbi.targetplatform.parser.antlr;

import com.google.inject.Inject;
import org.eclipse.cbi.targetplatform.parser.antlr.internal.InternalTargetPlatformParser;
import org.eclipse.cbi.targetplatform.services.TargetPlatformGrammarAccess;
import org.eclipse.xtext.parser.antlr.AbstractAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;

public class TargetPlatformParser extends AbstractAntlrParser {

	@Inject
	private TargetPlatformGrammarAccess grammarAccess;

	@Override
	protected void setInitialHiddenTokens(XtextTokenStream tokenStream) {
		tokenStream.setInitialHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");
	}
	

	@Override
	protected InternalTargetPlatformParser createParser(XtextTokenStream stream) {
		return new InternalTargetPlatformParser(stream, getGrammarAccess());
	}

	@Override 
	protected String getDefaultRuleName() {
		return "TargetPlatform";
	}

	public TargetPlatformGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(TargetPlatformGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}
