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

import java.net.URI;
import java.util.Collection;
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

public class MetadataRepositoryStub implements IMetadataRepository {

	private final IQueryResultProvider<IInstallableUnit> resultProvider;
	private final URI location;
	
	MetadataRepositoryStub(URI location, IQueryResultProvider<IInstallableUnit> resultProvider) {
		this.location = location;
		this.resultProvider = resultProvider;
	}
	
	@Override
	public URI getLocation() {
		return location;
	}

	@Override
	public String getName() {
		return null;
	}

	@Override
	public String getType() {
		return null;
	}

	@Override
	public String getVersion() {
		return null;
	}

	@Override
	public String getDescription() {
		return null;
	}

	@Override
	public String getProvider() {
		return null;
	}

	@Override
	public Map<String, String> getProperties() {
		return null;
	}

	@Override
	public String getProperty(String key) {
		return null;
	}

	@Override
	public IProvisioningAgent getProvisioningAgent() {
		return null;
	}

	@Override
	public boolean isModifiable() {
		return false;
	}

	@Override
	public String setProperty(String key, String value) {
		return null;
	}

	@Override
	public String setProperty(String key, String value, IProgressMonitor monitor) {
		return null;
	}

	@Override
	public Object getAdapter(Class adapter) {
		return null;
	}

	@Override
	public IQueryResult<IInstallableUnit> query(IQuery<IInstallableUnit> query, IProgressMonitor monitor) {
		return query.perform(resultProvider.listIUs(location).iterator());
	}

	@Override
	public void addInstallableUnits(Collection<IInstallableUnit> installableUnits) {
	}

	@Override
	public void addReferences(Collection<? extends IRepositoryReference> references) {
	}

	@Override
	public Collection<IRepositoryReference> getReferences() {
		return null;
	}

	@Override
	public boolean removeInstallableUnits(Collection<IInstallableUnit> installableUnits) {
		return false;
	}

	@Override
	public void removeAll() {
	}

	@Override
	public IStatus executeBatch(IRunnableWithProgress runnable, IProgressMonitor monitor) {
		return null;
	}

	@Override
	public void compress(IPool<IInstallableUnit> iuPool) {
	}

}
