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
package fr.obeo.releng.targetplatform.tests

import org.eclipse.equinox.p2.core.IProvisioningAgent
import org.eclipse.equinox.p2.repository.metadata.IMetadataRepositoryManager
import org.eclipse.equinox.p2.metadata.IInstallableUnit

class MockProvisioningAgent implements IProvisioningAgent {
	
	val IQueryResultProvider<IInstallableUnit> resultProvider;
	
	new(IQueryResultProvider<IInstallableUnit> resultProvider) {
		this.resultProvider = resultProvider;
	}
	
	override getService(String serviceName) {
		if (IMetadataRepositoryManager.SERVICE_NAME.equals(serviceName)) {
			return new MockMetadataRepositoryManager(resultProvider)
		}
	}
	
	override registerService(String serviceName, Object service) {
	}
	
	override stop() {
	}
	
	override unregisterService(String serviceName, Object service) {
	}
	
}