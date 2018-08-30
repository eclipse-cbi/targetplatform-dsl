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
package org.eclipse.cbi.targetplatform.ui;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtext.ui.editor.autoedit.AbstractEditStrategyProvider;
import org.eclipse.xtext.ui.editor.syntaxcoloring.AbstractAntlrTokenToAttributeIdMapper;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfiguration;
import org.eclipse.xtext.ide.editor.syntaxcoloring.ISemanticHighlightingCalculator;

import org.eclipse.cbi.targetplatform.ui.editor.autoedit.TargetPlatformAutoEditStrategyProvider;
import org.eclipse.cbi.targetplatform.ui.editor.syntaxcoloring.TargetPlatformHighlightingConfiguration;
import org.eclipse.cbi.targetplatform.ui.editor.syntaxcoloring.TargetPlatformSemanticHighlightingCalculator;
import org.eclipse.cbi.targetplatform.ui.editor.syntaxcoloring.TargetPlatformTokenToAttributeIdMapper;

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
}
