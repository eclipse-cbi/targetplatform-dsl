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
package org.eclipse.cbi.targetplatform.ui;

import com.google.inject.Injector;
import org.eclipse.cbi.targetplatform.ui.internal.TargetplatformActivator;
import org.eclipse.xtext.ui.guice.AbstractGuiceAwareExecutableExtensionFactory;
import org.osgi.framework.Bundle;

/**
 * This class was generated. Customizations should only happen in a newly
 * introduced subclass. 
 */
public class TargetPlatformExecutableExtensionFactory extends AbstractGuiceAwareExecutableExtensionFactory {

	@Override
	protected Bundle getBundle() {
		return TargetplatformActivator.getInstance().getBundle();
	}
	
	@Override
	protected Injector getInjector() {
		return TargetplatformActivator.getInstance().getInjector(TargetplatformActivator.ORG_ECLIPSE_CBI_TARGETPLATFORM_TARGETPLATFORM);
	}
	
}
