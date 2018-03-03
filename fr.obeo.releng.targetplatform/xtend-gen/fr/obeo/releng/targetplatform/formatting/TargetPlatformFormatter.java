/**
 * Copyright (c) 2012-2014 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Mikael Barbero (Obeo) - initial API and implementation
 */
package fr.obeo.releng.targetplatform.formatting;

import com.google.inject.Inject;
import fr.obeo.releng.targetplatform.services.TargetPlatformGrammarAccess;
import java.util.List;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.formatting.impl.AbstractDeclarativeFormatter;
import org.eclipse.xtext.formatting.impl.FormattingConfig;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.xbase.lib.Extension;

/**
 * This class contains custom formatting description.
 * 
 * see : http://www.eclipse.org/Xtext/documentation.html#formatting
 * on how and when to use it
 * 
 * Also see {@link org.eclipse.xtext.xtext.XtextFormattingTokenSerializer} as an example
 */
@SuppressWarnings("all")
public class TargetPlatformFormatter extends AbstractDeclarativeFormatter {
  @Inject
  @Extension
  private TargetPlatformGrammarAccess _targetPlatformGrammarAccess;
  
  @Override
  protected void configureFormatting(final FormattingConfig c) {
    List<Pair<Keyword, Keyword>> _findKeywordPairs = this._targetPlatformGrammarAccess.findKeywordPairs("{", "}");
    for (final Pair<Keyword, Keyword> pair : _findKeywordPairs) {
      {
        c.setIndentationIncrement().after(pair.getFirst());
        c.setIndentationDecrement().before(pair.getSecond());
        c.setLinewrap(1, 1, 2).after(pair.getFirst());
        c.setLinewrap(1, 1, 2).before(pair.getSecond());
        c.setLinewrap(1, 2, 2).after(pair.getSecond());
      }
    }
    List<Keyword> _findKeywords = this._targetPlatformGrammarAccess.findKeywords(",");
    for (final Keyword comma : _findKeywords) {
      {
        c.setNoSpace().before(comma);
        c.setSpace(" ").after(comma);
      }
    }
    c.setNoLinewrap().around(this._targetPlatformGrammarAccess.getLocationAccess().getIDAssignment_1_0());
    c.setNoLinewrap().around(this._targetPlatformGrammarAccess.getLocationAccess().getUriAssignment_1_1());
    c.setLinewrap(1, 1, 2).before(this._targetPlatformGrammarAccess.getIncludeDeclarationAccess().getIncludeKeyword_0());
    c.setLinewrap(1, 2, 2).before(this._targetPlatformGrammarAccess.getLocationAccess().getLocationKeyword_0());
    c.setLinewrap(1, 1, 2).before(this._targetPlatformGrammarAccess.getLocationAccess().getWithKeyword_2_1_0());
    c.setLinewrap(1, 1, 2).after(this._targetPlatformGrammarAccess.getTargetPlatformAccess().getContentsAssignment_2());
    c.setLinewrap().before(this._targetPlatformGrammarAccess.getIUAccess().getIDAssignment_0());
    c.setNoLinewrap().before(this._targetPlatformGrammarAccess.getIUAccess().getVersionAssignment_1_1_0());
    c.setNoLinewrap().before(this._targetPlatformGrammarAccess.getIUAccess().getVersionAssignment_1_1_1());
    c.setNoSpace().around(this._targetPlatformGrammarAccess.getIUAccess().getSemicolonKeyword_1_0_0());
    c.setNoSpace().around(this._targetPlatformGrammarAccess.getIUAccess().getEqualsSignKeyword_1_0_2());
    c.setNoSpace().around(this._targetPlatformGrammarAccess.getVersionRangeAccess().getLeftParenthesisKeyword_0_0_0());
    c.setNoSpace().around(this._targetPlatformGrammarAccess.getVersionRangeAccess().getLeftSquareBracketKeyword_0_0_1());
    c.setNoSpace().around(this._targetPlatformGrammarAccess.getVersionRangeAccess().getRightParenthesisKeyword_0_4_0());
    c.setNoSpace().around(this._targetPlatformGrammarAccess.getVersionRangeAccess().getRightSquareBracketKeyword_0_4_1());
    c.setLinewrap(0, 1, 2).before(this._targetPlatformGrammarAccess.getSL_COMMENTRule());
    c.setLinewrap(0, 1, 2).before(this._targetPlatformGrammarAccess.getML_COMMENTRule());
    c.setLinewrap(0, 1, 1).after(this._targetPlatformGrammarAccess.getML_COMMENTRule());
  }
}
