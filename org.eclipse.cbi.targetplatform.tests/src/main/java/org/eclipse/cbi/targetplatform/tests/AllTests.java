/**
 * Copyright (c) 2012, 2020 Obeo and others.
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
package org.eclipse.cbi.targetplatform.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * @author <a href="mailto:mikael.barbero@gmail.com">Mikael Barbero</a>
 *
 */
@RunWith(Suite.class)
@SuiteClasses({
	// core
	FormatterTest.class,
	TestGrammar.class, 
	TestTargetConversion.class,
	TestTargetGeneration.class,
	TestTargetPlatformIndexer.class,
	TestValidation.class,
})
public class AllTests {
	
}
