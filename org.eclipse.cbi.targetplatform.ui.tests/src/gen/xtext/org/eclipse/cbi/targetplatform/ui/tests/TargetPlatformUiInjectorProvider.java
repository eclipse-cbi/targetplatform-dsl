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
package org.eclipse.cbi.targetplatform.ui.tests;

import com.google.inject.Injector;
import org.eclipse.cbi.targetplatform.ui.internal.TargetplatformActivator;
import org.eclipse.xtext.testing.IInjectorProvider;

public class TargetPlatformUiInjectorProvider implements IInjectorProvider {

	@Override
	public Injector getInjector() {
		return TargetplatformActivator.getInstance().getInjector("org.eclipse.cbi.targetplatform.TargetPlatform");
	}

}
