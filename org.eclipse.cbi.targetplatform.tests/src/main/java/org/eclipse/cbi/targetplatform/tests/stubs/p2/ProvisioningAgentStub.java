/*******************************************************************************
 * Copyright (c) 2012 Obeo and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Mikael Barbero (Obeo) - initial API and implementation
 *******************************************************************************/
package org.eclipse.cbi.targetplatform.tests.stubs.p2;

import org.eclipse.equinox.p2.core.IProvisioningAgent;
import org.eclipse.equinox.p2.metadata.IInstallableUnit;
import org.eclipse.equinox.p2.repository.metadata.IMetadataRepositoryManager;

public class ProvisioningAgentStub implements IProvisioningAgent {
	
	private final IQueryResultProvider<IInstallableUnit> resultProvider;

	public ProvisioningAgentStub(IQueryResultProvider<IInstallableUnit> resultProvider) {
		this.resultProvider = resultProvider;
	}

	@Override
	public Object getService(String serviceName) {
		if (IMetadataRepositoryManager.SERVICE_NAME.equals(serviceName)) {
			return new MetadataRepositoryManagerStub(resultProvider);
		}
		return null;
	}
	
	@Override
	public void registerService(String serviceName, Object service) {
	}
	
	@Override
	public void stop() {
	}
	
	@Override
	public void unregisterService(String serviceName, Object service) {
	}
	
}