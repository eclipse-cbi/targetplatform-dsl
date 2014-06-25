package fr.obeo.releng.targetplatform.tests;

import fr.obeo.releng.targetplatform.tests.IQueryResultProvider;
import fr.obeo.releng.targetplatform.tests.MockMetadataRepositoryManager;
import org.eclipse.equinox.p2.core.IProvisioningAgent;
import org.eclipse.equinox.p2.metadata.IInstallableUnit;
import org.eclipse.equinox.p2.repository.metadata.IMetadataRepositoryManager;

@SuppressWarnings("all")
public class MockProvisioningAgent implements IProvisioningAgent {
  private final IQueryResultProvider<IInstallableUnit> resultProvider;
  
  public MockProvisioningAgent(final IQueryResultProvider<IInstallableUnit> resultProvider) {
    this.resultProvider = resultProvider;
  }
  
  public Object getService(final String serviceName) {
    boolean _equals = IMetadataRepositoryManager.SERVICE_NAME.equals(serviceName);
    if (_equals) {
      return new MockMetadataRepositoryManager(this.resultProvider);
    }
    return null;
  }
  
  public void registerService(final String serviceName, final Object service) {
  }
  
  public void stop() {
  }
  
  public void unregisterService(final String serviceName, final Object service) {
  }
}
