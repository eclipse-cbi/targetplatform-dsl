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