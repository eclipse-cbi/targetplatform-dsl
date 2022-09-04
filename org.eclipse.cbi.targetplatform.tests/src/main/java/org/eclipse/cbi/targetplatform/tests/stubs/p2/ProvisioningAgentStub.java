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
