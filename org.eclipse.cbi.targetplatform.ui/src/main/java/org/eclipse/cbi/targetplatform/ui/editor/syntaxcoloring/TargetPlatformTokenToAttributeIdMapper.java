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
 *     Hannes Niederhausen (itemis AG) - removed default highlighting for maven keyword; it's used in the maven elements as well
 */
package org.eclipse.cbi.targetplatform.ui.editor.syntaxcoloring;

import java.util.regex.Pattern;

import org.eclipse.xtext.ui.editor.syntaxcoloring.AbstractAntlrTokenToAttributeIdMapper;
import org.eclipse.xtext.ui.editor.syntaxcoloring.DefaultHighlightingConfiguration;

import com.google.inject.Singleton;

@Singleton
public class TargetPlatformTokenToAttributeIdMapper extends AbstractAntlrTokenToAttributeIdMapper {

	private static final Pattern PUNCTUATION = Pattern.compile("\\p{Punct}*");
	
	private static final Pattern QUOTED = Pattern.compile("(?:^'([^']*)'$)|(?:^\"([^\"]*)\")$", Pattern.MULTILINE);
	
	@Override
	protected String calculateId(String tokenName, int tokenType) {
		if(PUNCTUATION.matcher(tokenName).matches()) {
			return DefaultHighlightingConfiguration.DEFAULT_ID;
		}
		
		if ("'requirements'".equals(tokenName) ||
			"'allEnvironments'".equals(tokenName) ||
			"'source'".equals(tokenName) ||
			"'configurePhase'".equals(tokenName)) {
			return TargetPlatformHighlightingConfiguration.OPTION_ID;
		}
		
		if ("'='".equals(tokenName) ||
			"';'".equals(tokenName)) {
			return DefaultHighlightingConfiguration.DEFAULT_ID;
		}
		
		if(QUOTED.matcher(tokenName).matches()) {
			return DefaultHighlightingConfiguration.KEYWORD_ID;
		}
		if("RULE_STRING".equals(tokenName)) {
			return DefaultHighlightingConfiguration.STRING_ID;
		}
		if("RULE_ML_COMMENT".equals(tokenName) || "RULE_SL_COMMENT".equals(tokenName)) {
			return DefaultHighlightingConfiguration.COMMENT_ID;
		}
		return DefaultHighlightingConfiguration.DEFAULT_ID;
	}

}
