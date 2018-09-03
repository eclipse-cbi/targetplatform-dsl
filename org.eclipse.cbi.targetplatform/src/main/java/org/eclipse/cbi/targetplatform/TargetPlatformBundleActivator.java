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
package org.eclipse.cbi.targetplatform;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.core.runtime.Status;
import org.eclipse.equinox.p2.core.IProvisioningAgent;
import org.eclipse.equinox.p2.core.IProvisioningAgentProvider;
import org.eclipse.equinox.p2.core.ProvisionException;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;


/**
 * @author <a href="mailto:mikael.barbero@gmail.com">Mikael Barbero</a>
 *
 */
public class TargetPlatformBundleActivator extends Plugin {

	public static final String PLUGIN_ID = "org.eclipse.cbi.targetplatform";
	
	public static final String TARGET_PLATFORM_LANGUAGE_NAME = "org.eclipse.cbi.TargetPlatform";
	
	private static TargetPlatformBundleActivator INSTANCE;
	
	private BundleContext context;
	
	private ServiceReference<IProvisioningAgentProvider> agentProviderRef;
	
	private IProvisioningAgent agent;
	
	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		
		INSTANCE = this;
		this.context = context;
	}
	
	@Override
	public void stop(BundleContext context) throws Exception {
		IProvisioningAgent oldAgent = agent;
		agent = null;
		if (oldAgent != null) {
			oldAgent.stop();
		}
		
		if (agentProviderRef != null) {
			context.ungetService(agentProviderRef);
		}
		agentProviderRef = null;
		
		this.context = null;
		INSTANCE = null;
		
		super.stop(context);
	}
	
	public static TargetPlatformBundleActivator getInstance() {
		return INSTANCE;
	}

	public IProvisioningAgent getProvisioningAgent() {
		if (agent == null) {
			agentProviderRef = context.getServiceReference(IProvisioningAgentProvider.class);
			if (agentProviderRef != null) {
				IProvisioningAgentProvider agentProvider = context.getService(agentProviderRef);
				if (agentProvider != null) {
					try {
						agent = agentProvider.createAgent(getStateLocation().toFile().toURI());
					} catch (ProvisionException e) {
						getLog().log(new Status(IStatus.ERROR, PLUGIN_ID, e.getMessage(), e));
					} catch (IllegalStateException e) {
						getLog().log(new Status(IStatus.ERROR, PLUGIN_ID, e.getMessage(), e));
					}
				}
			} else {
				getLog().log(new Status(IStatus.ERROR, PLUGIN_ID, "Cannot find a service reference to " + IProvisioningAgentProvider.class.getName()));
			}
		}
		return agent;
	}
	
}
