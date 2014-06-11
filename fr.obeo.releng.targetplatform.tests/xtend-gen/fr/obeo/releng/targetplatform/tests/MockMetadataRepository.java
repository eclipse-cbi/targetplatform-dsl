package fr.obeo.releng.targetplatform.tests;

import fr.obeo.releng.targetplatform.tests.IQueryResultProvider;
import java.net.URI;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.equinox.p2.core.IPool;
import org.eclipse.equinox.p2.core.IProvisioningAgent;
import org.eclipse.equinox.p2.metadata.IInstallableUnit;
import org.eclipse.equinox.p2.query.IQuery;
import org.eclipse.equinox.p2.query.IQueryResult;
import org.eclipse.equinox.p2.repository.IRepositoryReference;
import org.eclipse.equinox.p2.repository.IRunnableWithProgress;
import org.eclipse.equinox.p2.repository.metadata.IMetadataRepository;

@SuppressWarnings("all")
public class MockMetadataRepository implements IMetadataRepository {
  private final IQueryResultProvider<IInstallableUnit> resultProvider;
  
  private final URI location;
  
  public MockMetadataRepository(final URI location, final IQueryResultProvider<IInstallableUnit> resultProvider) {
    this.location = location;
    this.resultProvider = resultProvider;
  }
  
  public void addInstallableUnits(final Collection<IInstallableUnit> installableUnits) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  public void addReferences(final Collection<? extends IRepositoryReference> references) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  public void compress(final IPool<IInstallableUnit> iuPool) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  public IStatus executeBatch(final IRunnableWithProgress runnable, final IProgressMonitor monitor) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  public Collection<IRepositoryReference> getReferences() {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  public void removeAll() {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  public boolean removeInstallableUnits(final Collection<IInstallableUnit> installableUnits) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  public String getDescription() {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  public URI getLocation() {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  public String getName() {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  public Map<String, String> getProperties() {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  public String getProperty(final String key) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  public String getProvider() {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  public IProvisioningAgent getProvisioningAgent() {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  public String getType() {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  public String getVersion() {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  public boolean isModifiable() {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  public String setProperty(final String key, final String value) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  public String setProperty(final String key, final String value, final IProgressMonitor monitor) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  public Object getAdapter(final Class adapter) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  public IQueryResult<IInstallableUnit> query(final IQuery<IInstallableUnit> query, final IProgressMonitor monitor) {
    List<IInstallableUnit> _listIUs = this.resultProvider.listIUs(this.location);
    Iterator<IInstallableUnit> _iterator = _listIUs.iterator();
    return query.perform(_iterator);
  }
}
