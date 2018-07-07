/*******************************************************************************
 * Copyright (c) 2012-2014 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Mikael Barbero (Obeo) - initial API and implementation
 *******************************************************************************/
package fr.obeo.releng.targetplatform.tests.util;

import com.google.inject.Guice;
import com.google.inject.Injector;

import fr.obeo.releng.targetplatform.TargetPlatformInjectorProvider;
import fr.obeo.releng.targetplatform.TargetPlatformStandaloneSetup;
import fr.obeo.releng.targetplatform.util.TargetReloader;

public class CustomTargetPlatformInjectorProviderTargetReloader extends TargetPlatformInjectorProvider {
	
	protected Injector internalCreateInjector() {
	    return new TargetPlatformStandaloneSetup() {
	    	public Injector createInjector() {
	    		return Guice.createInjector(new fr.obeo.releng.targetplatform.TargetPlatformRuntimeModule() {
	    			public Class<? extends TargetReloader> bindTargetReloader() {
	    				return TargetReloaderTestImpl.class;
	    			}
	    		});
	    	}
	    }.createInjectorAndDoEMFRegistration();
	}
}
