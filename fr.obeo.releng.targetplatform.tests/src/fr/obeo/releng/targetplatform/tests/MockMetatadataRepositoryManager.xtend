package fr.obeo.releng.targetplatform.tests

import java.net.URI
import java.util.Collection
import java.util.List
import java.util.Map
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.core.runtime.OperationCanceledException
import org.eclipse.equinox.p2.core.IPool
import org.eclipse.equinox.p2.core.ProvisionException
import org.eclipse.equinox.p2.metadata.IInstallableUnit
import org.eclipse.equinox.p2.metadata.IRequirement
import org.eclipse.equinox.p2.metadata.Version
import org.eclipse.equinox.p2.query.IQuery
import org.eclipse.equinox.p2.repository.IRepositoryReference
import org.eclipse.equinox.p2.repository.IRunnableWithProgress
import org.eclipse.equinox.p2.repository.metadata.IMetadataRepository
import org.eclipse.equinox.p2.repository.metadata.IMetadataRepositoryManager

class MockMetadataRepositoryManager implements IMetadataRepositoryManager {
	
	val IQueryResultProvider<IInstallableUnit> resultProvider;
	
	new(IQueryResultProvider<IInstallableUnit> resultProvider) {
		this.resultProvider = resultProvider;
	}
	
	override createRepository(URI location, String name, String type, Map<String, String> properties) throws ProvisionException, OperationCanceledException {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override loadRepository(URI location, IProgressMonitor monitor) throws ProvisionException, OperationCanceledException {
		monitor.subTask('''mock loading '«location»''')
		if (location.toString.startsWith("bad")) {
			throw new ProvisionException("Bad location uri '" + location.toString + "'")
		}
		return new MockMetadataRepository(location, resultProvider)
	}
	
	override loadRepository(URI location, int flags, IProgressMonitor monitor) throws ProvisionException, OperationCanceledException {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override refreshRepository(URI location, IProgressMonitor monitor) throws ProvisionException, OperationCanceledException {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override addRepository(URI location) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override contains(URI location) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override getAgent() {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override getKnownRepositories(int flags) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override getRepositoryProperty(URI location, String key) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override isEnabled(URI location) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override removeRepository(URI location) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override setEnabled(URI location, boolean enablement) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override setRepositoryProperty(URI location, String key, String value) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override query(IQuery<IInstallableUnit> query, IProgressMonitor monitor) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}

}

class MockMetadataRepository implements IMetadataRepository {
	
	val IQueryResultProvider<IInstallableUnit> resultProvider;
	val URI location;
	
	new(URI location, IQueryResultProvider<IInstallableUnit> resultProvider) {
		this.location = location;
		this.resultProvider = resultProvider;
	}
	
	override addInstallableUnits(Collection<IInstallableUnit> installableUnits) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override addReferences(Collection<? extends IRepositoryReference> references) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override compress(IPool<IInstallableUnit> iuPool) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override executeBatch(IRunnableWithProgress runnable, IProgressMonitor monitor) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override getReferences() {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override removeAll() {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override removeInstallableUnits(Collection<IInstallableUnit> installableUnits) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override getDescription() {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override getLocation() {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override getName() {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override getProperties() {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override getProperty(String key) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override getProvider() {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override getProvisioningAgent() {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override getType() {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override getVersion() {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override isModifiable() {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override setProperty(String key, String value) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override setProperty(String key, String value, IProgressMonitor monitor) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override getAdapter(Class adapter) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override query(IQuery<IInstallableUnit> query, IProgressMonitor monitor) {
		return query.perform(resultProvider.listIUs(location).iterator)
	}
	
}

interface IQueryResultProvider<T> {
	def List<T> listIUs(URI location)
}

class MockIU implements IInstallableUnit {
	
	val String id
	val Version version
	val Map<String, String> properties
	
	new(String id, Version version) {
		this(id, version, null)
	}
	
	new(String id, Version version, Map<String, String> properties) {
		this.id = id
		this.version = version
		this.properties = properties
	}
	
	def static createBundle(String id, Version version) {
		return new MockIU(id, version)
	}
	
	def static createFeature(String id, Version version) {
		return new MockIU(id, version, #{'org.eclipse.equinox.p2.type.group' -> 'true'})
	}
	
	override getArtifacts() {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override getCopyright() {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override getCopyright(String locale) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override getFilter() {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override getFragments() {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override getLicenses() {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override getLicenses(String locale) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override getMetaRequirements() {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override getProperties() {
		return properties
	}
	
	override getProperty(String key) {
		return properties.get(key)
	}
	
	override getProperty(String key, String locale) {
		return getProperty(key)
	}
	
	override getProvidedCapabilities() {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override getRequirements() {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override getTouchpointData() {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override getTouchpointType() {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override getUpdateDescriptor() {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override isResolved() {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override isSingleton() {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override satisfies(IRequirement candidate) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override unresolved() {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override getId() {
		return id;
	}
	
	override getVersion() {
		return version
	}
	
	override compareTo(IInstallableUnit arg0) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
}

