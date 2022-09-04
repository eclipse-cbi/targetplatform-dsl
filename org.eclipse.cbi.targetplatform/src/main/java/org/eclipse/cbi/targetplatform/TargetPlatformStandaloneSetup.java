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

import org.eclipse.cbi.targetplatform.model.TargetPlatformPackage;
import org.eclipse.emf.ecore.EPackage;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class TargetPlatformStandaloneSetup extends TargetPlatformStandaloneSetupGenerated{

	public static void doSetup() {
		if (!EPackage.Registry.INSTANCE.containsKey(TargetPlatformPackage.eNS_URI)) {
			EPackage.Registry.INSTANCE.put(TargetPlatformPackage.eNS_URI, TargetPlatformPackage.eINSTANCE);
		}
		new TargetPlatformStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
	
}
