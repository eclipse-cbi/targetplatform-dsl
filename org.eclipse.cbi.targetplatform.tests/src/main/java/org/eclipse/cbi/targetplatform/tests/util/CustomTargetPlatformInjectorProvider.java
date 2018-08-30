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
package org.eclipse.cbi.targetplatform.tests.util;

import org.eclipse.cbi.targetplatform.TargetPlatformStandaloneSetup;
import org.eclipse.cbi.targetplatform.model.TargetPlatformPackage;
import org.eclipse.cbi.targetplatform.tests.TargetPlatformInjectorProvider;
import org.eclipse.emf.ecore.EPackage;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class CustomTargetPlatformInjectorProvider extends TargetPlatformInjectorProvider {
	
	protected Injector internalCreateInjector() {
		if (!EPackage.Registry.INSTANCE.containsKey(TargetPlatformPackage.eNS_URI)) {
			EPackage.Registry.INSTANCE.put(TargetPlatformPackage.eNS_URI, TargetPlatformPackage.eINSTANCE);
		}
	    return new TargetPlatformStandaloneSetup() {
	    	public Injector createInjector() {
	    		return Guice.createInjector(new TargetPlatformTestRuntimeModule());
	    	}
	    }.createInjectorAndDoEMFRegistration();
	}
}
