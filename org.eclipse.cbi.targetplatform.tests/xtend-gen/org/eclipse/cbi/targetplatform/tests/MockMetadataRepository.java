/**
 * Copyright (c) 2012-2014 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 */
package org.eclipse.cbi.targetplatform.tests;

import org.eclipse.cbi.targetplatform.tests.IQueryResultProvider;
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

@SuppressWarnings("all")
public class MockMetadataRepository implements IMetadataRepository {
  private final IQueryResultProvider<IInstallableUnit> resultProvider;
  
  private final URI location;
  
  public MockMetadataRepository(final URI location, final IQueryResultProvider<IInstallableUnit> resultProvider) {
    this.location = location;
    this.resultProvider = resultProvider;
  }
  
  @Override
  public void addInstallableUnits(final Collection<IInstallableUnit> installableUnits) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  public void addReferences(final Collection<? extends IRepositoryReference> references) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  public void compress(final IPool<IInstallableUnit> iuPool) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  public IStatus executeBatch(final IRunnableWithProgress runnable, final IProgressMonitor monitor) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  public Collection<IRepositoryReference> getReferences() {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  public void removeAll() {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  public boolean removeInstallableUnits(final Collection<IInstallableUnit> installableUnits) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  public String getDescription() {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  public URI getLocation() {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  public String getName() {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  public Map<String, String> getProperties() {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  public String getProperty(final String key) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  public String getProvider() {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  public IProvisioningAgent getProvisioningAgent() {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  public String getType() {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  public String getVersion() {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  public boolean isModifiable() {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  public String setProperty(final String key, final String value) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  public String setProperty(final String key, final String value, final IProgressMonitor monitor) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  public Object getAdapter(final Class adapter) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  public IQueryResult<IInstallableUnit> query(final IQuery<IInstallableUnit> query, final IProgressMonitor monitor) {
    return query.perform(this.resultProvider.listIUs(this.location).iterator());
  }
}
