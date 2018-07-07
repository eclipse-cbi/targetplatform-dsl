/*******************************************************************************
 * Copyright (c) 2012 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Mikael Barbero (Obeo) - initial API and implementation
 *******************************************************************************/
package fr.obeo.releng.targetplatform.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import fr.obeo.releng.targetplatform.tests.composite_elements.TestCompositeElementValidation;
import fr.obeo.releng.targetplatform.tests.composite_elements.TestCompositeLocation;
import fr.obeo.releng.targetplatform.tests.composite_elements.TestOverrideVariableDefinition;
import fr.obeo.releng.targetplatform.tests.composite_elements.TestVariableVariableDefinition;
import fr.obeo.releng.targetplatform.ui.tests.TestContentAssist;

/**
 * @author <a href="mailto:mikael.barbero@obeo.fr">Mikael Barbero</a>
 *
 */
@RunWith(Suite.class)
@SuiteClasses({
	// core
	TestGrammar.class, 
	TestTargetConversion.class,
	TestTargetGeneration.class,
	TestTargetPlatformIndexer.class,
	TestValidation.class,
	TestCompositeLocation.class,
	TestOverrideVariableDefinition.class,
	TestVariableVariableDefinition.class,
	TestCompositeElementValidation.class,
	TestContentAssist.class
})
public class AllTests {
	
	@RunWith(Suite.class)
	@SuiteClasses({
	})
	public static class UI {
	}
}
