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