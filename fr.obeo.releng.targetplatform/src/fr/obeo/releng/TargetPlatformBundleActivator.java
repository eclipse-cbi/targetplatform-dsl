package fr.obeo.releng;

import static com.google.common.collect.Lists.newArrayList;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.equinox.p2.core.IProvisioningAgentProvider;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import com.google.common.collect.Maps;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

/*******************************************************************************
 * Copyright (c) 2012 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/

/**
 * @author <a href="mailto:mikael.barbero@obeo.fr">Mikael Barbero</a>
 *
 */
public class TargetPlatformBundleActivator implements BundleActivator {

public static final String TARGET_PLATFORM_LANGUAGE_NAME = "fr.obeo.releng.TargetPlatform";
	
	private static final Logger logger = Logger.getLogger(TargetPlatformBundleActivator.class);
	
	private static TargetPlatformBundleActivator INSTANCE;
	
	private Map<String, Injector> injectors;

	private BundleContext context;
	
	private List<ServiceReference> serviceReferencesToUnget;

	private IProvisioningAgentProvider provisioningAgentProvider;
	
	@Override
	public void start(BundleContext context) throws Exception {
		INSTANCE = this;
		this.context = context;
		injectors = Collections.synchronizedMap(Maps.<String, Injector> newHashMapWithExpectedSize(1));
		serviceReferencesToUnget = newArrayList();
	}
	
	@Override
	public void stop(BundleContext context) throws Exception {
		for (ServiceReference serviceReference : serviceReferencesToUnget) {
			context.ungetService(serviceReference);
		}
		
		injectors.clear();
		
		context = null;
		INSTANCE = null;
	}
	
	public static TargetPlatformBundleActivator getInstance() {
		return INSTANCE;
	}
	
	public BundleContext getContext() {
		return context;
	}
	
	public Bundle getBundle() {
		return context.getBundle();
	}
	
	public Injector getInjector(String language) {
		synchronized (injectors) {
			Injector injector = injectors.get(language);
			if (injector == null) {
				injectors.put(language, injector = createInjector(language));
			}
			return injector;
		}
	}
	
	protected Injector createInjector(String language) {
		try {
			Module runtimeModule = getRuntimeModule(language);
			return Guice.createInjector(runtimeModule);
		} catch (Exception e) {
			logger.error("Failed to create injector for " + language);
			logger.error(e.getMessage(), e);
			throw new RuntimeException("Failed to create injector for " + language, e);
		}
	}
	
	/**
	 * @return the provisioningAgentProvider
	 */
	public IProvisioningAgentProvider getProvisioningAgentProvider() {
		if (provisioningAgentProvider == null) {
			provisioningAgentProvider = getService(IProvisioningAgentProvider.class);
		}
		return provisioningAgentProvider;
	}
	
	@SuppressWarnings("unchecked")
	public <T> T getService(Class<T> clazz) {
		ServiceReference serviceReference = context.getServiceReference(clazz.getName());
		
		final T service;
		if (serviceReference == null) {
			service = null;
		} else {
			serviceReferencesToUnget.add(serviceReference);
			service = (T) context.getService(serviceReference);  
		}
		
		return service;
	}
	
	protected Module getRuntimeModule(String grammar) {
		if (TARGET_PLATFORM_LANGUAGE_NAME.equals(grammar)) {
			return new fr.obeo.releng.TargetPlatformRuntimeModule();
		}
		
		throw new IllegalArgumentException(grammar);
	}
	
}
