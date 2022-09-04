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
 */
package org.eclipse.cbi.targetplatform;

import org.eclipse.cbi.targetplatform.conversion.TargetPlatformConverter;
import org.eclipse.cbi.targetplatform.conversion.TargetPlatformIDValueConverter;
import org.eclipse.cbi.targetplatform.util.LocationIndexBuilder;
import org.eclipse.core.runtime.RegistryFactory;
import org.eclipse.equinox.p2.core.IProvisioningAgent;
import org.eclipse.jdt.launching.JavaRuntime;
import org.eclipse.jdt.launching.environments.IExecutionEnvironmentsManager;
import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.conversion.impl.AbstractIDValueConverter;

import com.google.inject.Provider;

/**
 * Use this class to register components to be used at runtime / without the Equinox extension registry.
 */
public class TargetPlatformRuntimeModule extends org.eclipse.cbi.targetplatform.AbstractTargetPlatformRuntimeModule {

	@Override
	public Class<? extends IValueConverterService> bindIValueConverterService() {
		return TargetPlatformConverter.class;
	}
	
	public Class<? extends AbstractIDValueConverter> bindAbstractIDValueConverter() {
		return TargetPlatformIDValueConverter.class;
	}
	
	public Class<? extends LocationIndexBuilder> bindLocationIndexBuilder() {
		return LocationIndexBuilder.class;
	}
	
	public Provider<IProvisioningAgent> provideIProvisioningAgent() {
		return () -> {
			TargetPlatformBundleActivator bundleActivator = TargetPlatformBundleActivator.getInstance();
			final IProvisioningAgent provisioningAgent;
			if (bundleActivator != null) {
				provisioningAgent = bundleActivator.getProvisioningAgent();
			} else {
				provisioningAgent = null;
			}
			return provisioningAgent;
		};
	}
	
	public Provider<IExecutionEnvironmentsManager> provideIExecutionEnvironmentsManager() {
		return () -> {
			final IExecutionEnvironmentsManager eeManager;
			// EEManager will eventually call the extension registry to get all available env.
			// Don't provider the JavaRuntime.getExecutionEnvironmentsManager() if we don't have
			// an extension registry
			if (RegistryFactory.getRegistry() != null) {
				eeManager = JavaRuntime.getExecutionEnvironmentsManager();
			} else {
				eeManager = null;
			}
			return eeManager;
		};
	}
}
