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
package org.eclipse.cbi.targetplatform.ide.contentassist.antlr;

import com.google.inject.Inject;
import java.util.HashMap;
import java.util.Map;
import org.eclipse.cbi.targetplatform.ide.contentassist.antlr.internal.InternalTargetPlatformParser;
import org.eclipse.cbi.targetplatform.services.TargetPlatformGrammarAccess;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ide.editor.contentassist.antlr.AbstractContentAssistParser;

public class TargetPlatformParser extends AbstractContentAssistParser {

	@Inject
	private TargetPlatformGrammarAccess grammarAccess;

	private Map<AbstractElement, String> nameMappings;

	@Override
	protected InternalTargetPlatformParser createParser() {
		InternalTargetPlatformParser result = new InternalTargetPlatformParser(null);
		result.setGrammarAccess(grammarAccess);
		return result;
	}

	@Override
	protected String getRuleName(AbstractElement element) {
		if (nameMappings == null) {
			nameMappings = new HashMap<AbstractElement, String>() {
				private static final long serialVersionUID = 1L;
				{
					put(grammarAccess.getTargetContentAccess().getAlternatives(), "rule__TargetContent__Alternatives");
					put(grammarAccess.getIUAccess().getAlternatives_1_1(), "rule__IU__Alternatives_1_1");
					put(grammarAccess.getVersionAccess().getAlternatives_1_2_2_1(), "rule__Version__Alternatives_1_2_2_1");
					put(grammarAccess.getVersionRangeAccess().getAlternatives(), "rule__VersionRange__Alternatives");
					put(grammarAccess.getVersionRangeAccess().getAlternatives_0_0(), "rule__VersionRange__Alternatives_0_0");
					put(grammarAccess.getVersionRangeAccess().getAlternatives_0_4(), "rule__VersionRange__Alternatives_0_4");
					put(grammarAccess.getOptionAccess().getAlternatives(), "rule__Option__Alternatives");
					put(grammarAccess.getTargetPlatformAccess().getGroup(), "rule__TargetPlatform__Group__0");
					put(grammarAccess.getOptionsAccess().getGroup(), "rule__Options__Group__0");
					put(grammarAccess.getOptionsAccess().getGroup_2(), "rule__Options__Group_2__0");
					put(grammarAccess.getEnvironmentAccess().getGroup(), "rule__Environment__Group__0");
					put(grammarAccess.getEnvironmentAccess().getGroup_3(), "rule__Environment__Group_3__0");
					put(grammarAccess.getIncludeDeclarationAccess().getGroup(), "rule__IncludeDeclaration__Group__0");
					put(grammarAccess.getLocationAccess().getGroup(), "rule__Location__Group__0");
					put(grammarAccess.getLocationAccess().getGroup_2(), "rule__Location__Group_2__0");
					put(grammarAccess.getLocationAccess().getGroup_2_1(), "rule__Location__Group_2_1__0");
					put(grammarAccess.getLocationAccess().getGroup_2_1_2(), "rule__Location__Group_2_1_2__0");
					put(grammarAccess.getIUAccess().getGroup(), "rule__IU__Group__0");
					put(grammarAccess.getIUAccess().getGroup_1(), "rule__IU__Group_1__0");
					put(grammarAccess.getIUAccess().getGroup_1_0(), "rule__IU__Group_1_0__0");
					put(grammarAccess.getVersionAccess().getGroup(), "rule__Version__Group__0");
					put(grammarAccess.getVersionAccess().getGroup_1(), "rule__Version__Group_1__0");
					put(grammarAccess.getVersionAccess().getGroup_1_2(), "rule__Version__Group_1_2__0");
					put(grammarAccess.getVersionAccess().getGroup_1_2_2(), "rule__Version__Group_1_2_2__0");
					put(grammarAccess.getVersionRangeAccess().getGroup_0(), "rule__VersionRange__Group_0__0");
					put(grammarAccess.getTargetPlatformAccess().getNameAssignment_1(), "rule__TargetPlatform__NameAssignment_1");
					put(grammarAccess.getTargetPlatformAccess().getContentsAssignment_2(), "rule__TargetPlatform__ContentsAssignment_2");
					put(grammarAccess.getOptionsAccess().getOptionsAssignment_1(), "rule__Options__OptionsAssignment_1");
					put(grammarAccess.getOptionsAccess().getOptionsAssignment_2_1(), "rule__Options__OptionsAssignment_2_1");
					put(grammarAccess.getEnvironmentAccess().getEnvAssignment_2(), "rule__Environment__EnvAssignment_2");
					put(grammarAccess.getEnvironmentAccess().getEnvAssignment_3_1(), "rule__Environment__EnvAssignment_3_1");
					put(grammarAccess.getIncludeDeclarationAccess().getImportURIAssignment_1(), "rule__IncludeDeclaration__ImportURIAssignment_1");
					put(grammarAccess.getLocationAccess().getIDAssignment_1_0(), "rule__Location__IDAssignment_1_0");
					put(grammarAccess.getLocationAccess().getUriAssignment_1_1(), "rule__Location__UriAssignment_1_1");
					put(grammarAccess.getLocationAccess().getOptionsAssignment_2_1_1(), "rule__Location__OptionsAssignment_2_1_1");
					put(grammarAccess.getLocationAccess().getOptionsAssignment_2_1_2_1(), "rule__Location__OptionsAssignment_2_1_2_1");
					put(grammarAccess.getLocationAccess().getIusAssignment_2_2(), "rule__Location__IusAssignment_2_2");
					put(grammarAccess.getIUAccess().getIDAssignment_0(), "rule__IU__IDAssignment_0");
					put(grammarAccess.getIUAccess().getVersionAssignment_1_1_0(), "rule__IU__VersionAssignment_1_1_0");
					put(grammarAccess.getIUAccess().getVersionAssignment_1_1_1(), "rule__IU__VersionAssignment_1_1_1");
					put(grammarAccess.getLocationAccess().getUnorderedGroup_1(), "rule__Location__UnorderedGroup_1");
				}
			};
		}
		return nameMappings.get(element);
	}
			
	@Override
	protected String[] getInitialHiddenTokens() {
		return new String[] { "RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT" };
	}

	public TargetPlatformGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(TargetPlatformGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}
