/**
 * Copyright (c) 2012 Obeo and others.
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
package org.eclipse.cbi.targetplatform.tests.util;

import org.eclipse.cbi.targetplatform.TargetPlatformRuntimeModule;
import org.eclipse.cbi.targetplatform.tests.stubs.p2.IUStub;
import org.eclipse.cbi.targetplatform.tests.stubs.p2.ProvisioningAgentStub;
import org.eclipse.cbi.targetplatform.tests.stubs.registry.ConfigurationElementStub;
import org.eclipse.cbi.targetplatform.tests.stubs.registry.ExtensionPointStub;
import org.eclipse.cbi.targetplatform.tests.stubs.registry.ExtensionRegistryStub;
import org.eclipse.cbi.targetplatform.tests.stubs.registry.ExtensionStub;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.RegistryFactory;
import org.eclipse.equinox.p2.core.IProvisioningAgent;
import org.eclipse.equinox.p2.metadata.IInstallableUnit;
import org.eclipse.equinox.p2.metadata.Version;
import org.eclipse.jdt.launching.JavaRuntime;

import com.google.common.collect.ImmutableList;
import com.google.inject.Binder;
import com.google.inject.Provider;

class TargetPlatformTestRuntimeModule extends TargetPlatformRuntimeModule {
	
	public Provider<IProvisioningAgent> provideIProvisioningAgent() {
		return () -> new ProvisioningAgentStub(location -> {
			switch(location.toString()) {
				case "location1":
					return ImmutableList.<IInstallableUnit>of(
						IUStub.createFeature("org.iu1", Version.createOSGi(1,2,0))
					);
				case "location2":
					return ImmutableList.<IInstallableUnit>of(
							IUStub.createFeature("org.iu1", Version.createOSGi(1,2,0)),
							IUStub.createFeature("org.iu2", Version.createOSGi(3,7,72))
							);
				case "location3":
					return ImmutableList.<IInstallableUnit>of(
							IUStub.createFeature("org.iu1", Version.createOSGi(1,2,0)),
							IUStub.createFeature("org.iu1", Version.createOSGi(1,2,5)),
							IUStub.createFeature("org.iu1", Version.createOSGi(1,3,2)),
							IUStub.createFeature("org.iu1", Version.createOSGi(2,0,0)),
							IUStub.createFeature("org.iu1", Version.createOSGi(2,3,0)),
							IUStub.createFeature("org.iu1", Version.createOSGi(3,9,0))
							);
				case "location4":
					return ImmutableList.<IInstallableUnit>of(
							IUStub.createFeature("org.iu1", Version.createOSGi(1,2,0)),
							IUStub.createFeature("org.iu2", Version.createOSGi(3,7,72)),
							IUStub.createFeature("com.iu1", Version.createOSGi(1,2,0)),
							IUStub.createFeature("com.iu2", Version.createOSGi(3,7,72)),
							IUStub.createFeature("com.iu3", Version.createOSGi(3,7,72))
							);
				case "badLocation":
					throw new RuntimeException("bad location");
				case "emptyRepository":
					return ImmutableList.of();
				default:
					return ImmutableList.of();
			}
		});
	}
	
	@Override
	public void configure(Binder binder) {
		if (RegistryFactory.getRegistry() == null) {
			try {
				RegistryFactory.setDefaultRegistryProvider(() -> new ExtensionRegistryStub(
					ImmutableList.<IExtensionPoint>builder()
					.add(ExtensionPointStub.buidler()
							.namespaceIdentifier(org.eclipse.jdt.internal.launching.LaunchingPlugin.ID_PLUGIN)
							.id(JavaRuntime.EXTENSION_POINT_EXECUTION_ENVIRONMENTS)
							.addExtension(ExtensionStub.builder()
									.addConfigurationElement(ConfigurationElementStub.builder()
											.name("environment")
											.addAttribute("id", "JavaSE-1.5")
										)
									.addConfigurationElement(ConfigurationElementStub.builder()
											.name("environment")
											.addAttribute("id", "JavaSE-1.6")
										)
									.addConfigurationElement(ConfigurationElementStub.builder()
											.name("environment")
											.addAttribute("id", "JavaSE-1.7")
										)
									.addConfigurationElement(ConfigurationElementStub.builder()
											.name("environment")
											.addAttribute("id", "JavaSE-1.8")
										)
									.addConfigurationElement(ConfigurationElementStub.builder()
											.name("environment")
											.addAttribute("id", "JavaSE-1.9")
										)
								)
							.build())
					.build()
				));
			} catch (CoreException exception) {
				exception.printStackTrace();
			}
		}
		super.configure(binder);
	}
}
