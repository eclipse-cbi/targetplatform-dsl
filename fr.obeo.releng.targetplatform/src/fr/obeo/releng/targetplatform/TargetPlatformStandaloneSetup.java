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
package fr.obeo.releng.targetplatform;

import org.eclipse.emf.ecore.EPackage;

import com.google.inject.Injector;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class TargetPlatformStandaloneSetup extends TargetPlatformStandaloneSetupGenerated{

	public static void doSetup() {
		new TargetPlatformStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
	
	@Override
	public void register(Injector injector) {
		if (!EPackage.Registry.INSTANCE.containsKey(TargetPlatformPackage.eNS_URI)) {
			EPackage.Registry.INSTANCE.put(TargetPlatformPackage.eNS_URI, TargetPlatformPackage.eINSTANCE);
		}
		super.register(injector);
	}
}

