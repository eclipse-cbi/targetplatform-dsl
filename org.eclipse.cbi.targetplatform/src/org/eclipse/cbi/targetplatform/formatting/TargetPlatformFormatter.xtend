/*******************************************************************************
 * Copyright (c) 2012-2014 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Mikael Barbero (Obeo) - initial API and implementation
 *******************************************************************************/
package org.eclipse.cbi.targetplatform.formatting

import com.google.inject.Inject
import org.eclipse.cbi.targetplatform.services.TargetPlatformGrammarAccess
import org.eclipse.xtext.formatting.impl.AbstractDeclarativeFormatter
import org.eclipse.xtext.formatting.impl.FormattingConfig

/**
 * This class contains custom formatting description.
 * 
 * see : http://www.eclipse.org/Xtext/documentation.html#formatting
 * on how and when to use it 
 * 
 * Also see {@link org.eclipse.xtext.xtext.XtextFormattingTokenSerializer} as an example
 */
class TargetPlatformFormatter extends AbstractDeclarativeFormatter {

	@Inject extension TargetPlatformGrammarAccess
	
	override protected void configureFormatting(FormattingConfig c) {
		for (pair : findKeywordPairs("{", "}")) {
			c.setIndentationIncrement.after(pair.first)
			c.setIndentationDecrement.before(pair.second)
			c.setLinewrap(1, 1, 2).after(pair.first);
			c.setLinewrap(1, 1, 2).before(pair.second);
			c.setLinewrap(1, 2, 2).after(pair.second);
		}
		
		for (comma : findKeywords(",")) {
      		c.setNoSpace.before(comma);
      		c.setSpace(" ").after(comma);
    	}
    	
    	c.setNoLinewrap.around(locationAccess.IDAssignment_1_0)
    	c.setNoLinewrap.around(locationAccess.uriAssignment_1_1)
		
		c.setLinewrap(1, 1, 2).before(includeDeclarationAccess.includeKeyword_0)
		
		c.setLinewrap(1, 2, 2).before(locationAccess.locationKeyword_0)
		c.setLinewrap(1, 1, 2).before(locationAccess.withKeyword_2_1_0)
		c.setLinewrap(1, 1, 2).after(targetPlatformAccess.contentsAssignment_2)
		
		c.setLinewrap.before(IUAccess.IDAssignment_0)
		c.setNoLinewrap.before(IUAccess.versionAssignment_1_1_0)
		c.setNoLinewrap.before(IUAccess.versionAssignment_1_1_1)
		c.setNoSpace.around(IUAccess.semicolonKeyword_1_0_0)
		c.setNoSpace.around(IUAccess.equalsSignKeyword_1_0_2)
		
		c.setNoSpace.around(versionRangeAccess.leftParenthesisKeyword_0_0_0)
		c.setNoSpace.around(versionRangeAccess.leftSquareBracketKeyword_0_0_1)
		c.setNoSpace.around(versionRangeAccess.rightParenthesisKeyword_0_4_0)
		c.setNoSpace.around(versionRangeAccess.rightSquareBracketKeyword_0_4_1)
		
		// It's usually a good idea to activate the following three statements.
		// They will add and preserve newlines around comments
		c.setLinewrap(0, 1, 2).before(SL_COMMENTRule)
		c.setLinewrap(0, 1, 2).before(ML_COMMENTRule)
		c.setLinewrap(0, 1, 1).after(ML_COMMENTRule)
	}
}
