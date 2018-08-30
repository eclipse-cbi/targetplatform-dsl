package org.eclipse.cbi.targetplatform.tests.stubs.p2;

import java.net.URI;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.equinox.p2.core.IProvisioningAgent;
import org.eclipse.equinox.p2.core.ProvisionException;
import org.eclipse.equinox.p2.metadata.IInstallableUnit;
import org.eclipse.equinox.p2.query.IQuery;
import org.eclipse.equinox.p2.query.IQueryResult;
import org.eclipse.equinox.p2.repository.metadata.IMetadataRepository;
import org.eclipse.equinox.p2.repository.metadata.IMetadataRepositoryManager;

public class MetadataRepositoryManagerStub implements IMetadataRepositoryManager {

	private final IQueryResultProvider<IInstallableUnit> resultProvider;
	
	public MetadataRepositoryManagerStub(IQueryResultProvider<IInstallableUnit> resultProvider) {
		this.resultProvider = resultProvider;
	}
	
	public IMetadataRepository createRepository(URI location, String name, String type, Map<String, String> properties) throws ProvisionException, OperationCanceledException {
		throw new UnsupportedOperationException("TODO: auto-generated method stub");
	}
	
	public IMetadataRepository loadRepository(URI location, IProgressMonitor monitor) throws ProvisionException, OperationCanceledException {
		monitor.subTask("mock loading '" + location + "'");
		if (location.toString().startsWith("bad")) {
			throw new ProvisionException("Bad location uri '" + location.toString() + "'");
		}
		return new MetadataRepositoryStub(location, resultProvider);
	}
	
	
	@Override
	public void addRepository(URI location) {
	}

	@Override
	public boolean contains(URI location) {
		return false;
	}

	@Override
	public IProvisioningAgent getAgent() {
		return null;
	}

	@Override
	public URI[] getKnownRepositories(int flags) {
		return null;
	}

	@Override
	public String getRepositoryProperty(URI location, String key) {
		return null;
	}

	@Override
	public void setRepositoryProperty(URI location, String key, String value) {
	}

	@Override
	public boolean isEnabled(URI location) {
		return false;
	}

	@Override
	public boolean removeRepository(URI location) {
		return false;
	}

	@Override
	public void setEnabled(URI location, boolean enablement) {
	}

	@Override
	public IQueryResult<IInstallableUnit> query(IQuery<IInstallableUnit> query, IProgressMonitor monitor) {
		return null;
	}

	@Override
	public IMetadataRepository loadRepository(URI location, int flags, IProgressMonitor monitor)
			throws ProvisionException, OperationCanceledException {
		return null;
	}

	@Override
	public IMetadataRepository refreshRepository(URI location, IProgressMonitor monitor)
			throws ProvisionException, OperationCanceledException {
		return null;
	}

}
