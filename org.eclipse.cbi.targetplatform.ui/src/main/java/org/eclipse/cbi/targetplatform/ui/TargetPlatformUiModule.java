/**
 * Copyright (c) 2012-2020 Obeo and others.
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
package org.eclipse.cbi.targetplatform.ui;

import org.eclipse.cbi.targetplatform.ui.editor.autoedit.TargetPlatformAutoEditStrategyProvider;
import org.eclipse.cbi.targetplatform.ui.editor.syntaxcoloring.TargetPlatformHighlightingConfiguration;
import org.eclipse.cbi.targetplatform.ui.editor.syntaxcoloring.TargetPlatformSemanticHighlightingCalculator;
import org.eclipse.cbi.targetplatform.ui.editor.syntaxcoloring.TargetPlatformTokenToAttributeIdMapper;
import org.eclipse.cbi.targetplatform.ui.hover.TargetPlatformHoverProvider;
import org.eclipse.cbi.targetplatform.ui.hyperlinking.TargetPlatformHyperlinkHelper;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtext.ide.editor.syntaxcoloring.ISemanticHighlightingCalculator;
import org.eclipse.xtext.ui.editor.autoedit.AbstractEditStrategyProvider;
import org.eclipse.xtext.ui.editor.hover.IEObjectHoverProvider;
import org.eclipse.xtext.ui.editor.hyperlinking.IHyperlinkHelper;
import org.eclipse.xtext.ui.editor.syntaxcoloring.AbstractAntlrTokenToAttributeIdMapper;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfiguration;

/**
 * Use this class to register components to be used within the IDE.
 */
public class TargetPlatformUiModule extends org.eclipse.cbi.targetplatform.ui.AbstractTargetPlatformUiModule {
	
	public TargetPlatformUiModule(AbstractUIPlugin plugin) {
		super(plugin);
	}
	
	@Override
	public Class<? extends AbstractEditStrategyProvider> bindAbstractEditStrategyProvider() {
		return TargetPlatformAutoEditStrategyProvider.class;
	}
	
	public Class<? extends IHighlightingConfiguration> bindIHighlightingConfiguration() {
		return TargetPlatformHighlightingConfiguration.class;
	}
	
	public Class<? extends ISemanticHighlightingCalculator> bindISemanticHighlightingCalculator() {
		return TargetPlatformSemanticHighlightingCalculator.class;
	}
	
	public Class<? extends AbstractAntlrTokenToAttributeIdMapper> bindAbstractAntlrTokenToAttributeIdMapper() {
		return TargetPlatformTokenToAttributeIdMapper.class;
	}

	public Class<? extends IHyperlinkHelper> bindIHyperlinkHelper() {
		return TargetPlatformHyperlinkHelper.class;
	}

	public Class<? extends IEObjectHoverProvider> bindIEObjectHoverProvider() {
		return TargetPlatformHoverProvider.class;
	}
}
