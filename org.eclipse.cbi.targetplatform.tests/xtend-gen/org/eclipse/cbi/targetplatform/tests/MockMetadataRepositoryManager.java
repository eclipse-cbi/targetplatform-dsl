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
import org.eclipse.cbi.targetplatform.tests.MockMetadataRepository;
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
import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class MockMetadataRepositoryManager implements IMetadataRepositoryManager {
  private final IQueryResultProvider<IInstallableUnit> resultProvider;
  
  public MockMetadataRepositoryManager(final IQueryResultProvider<IInstallableUnit> resultProvider) {
    this.resultProvider = resultProvider;
  }
  
  @Override
  public IMetadataRepository createRepository(final URI location, final String name, final String type, final Map<String, String> properties) throws ProvisionException, OperationCanceledException {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  public IMetadataRepository loadRepository(final URI location, final IProgressMonitor monitor) throws ProvisionException, OperationCanceledException {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("mock loading \'");
    _builder.append(location);
    monitor.subTask(_builder.toString());
    boolean _startsWith = location.toString().startsWith("bad");
    if (_startsWith) {
      String _string = location.toString();
      String _plus = ("Bad location uri \'" + _string);
      String _plus_1 = (_plus + "\'");
      throw new ProvisionException(_plus_1);
    }
    return new MockMetadataRepository(location, this.resultProvider);
  }
  
  @Override
  public IMetadataRepository loadRepository(final URI location, final int flags, final IProgressMonitor monitor) throws ProvisionException, OperationCanceledException {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  public IMetadataRepository refreshRepository(final URI location, final IProgressMonitor monitor) throws ProvisionException, OperationCanceledException {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  public void addRepository(final URI location) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  public boolean contains(final URI location) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  public IProvisioningAgent getAgent() {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  public URI[] getKnownRepositories(final int flags) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  public String getRepositoryProperty(final URI location, final String key) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  public boolean isEnabled(final URI location) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  public boolean removeRepository(final URI location) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  public void setEnabled(final URI location, final boolean enablement) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  public void setRepositoryProperty(final URI location, final String key, final String value) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  public IQueryResult<IInstallableUnit> query(final IQuery<IInstallableUnit> query, final IProgressMonitor monitor) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
}
