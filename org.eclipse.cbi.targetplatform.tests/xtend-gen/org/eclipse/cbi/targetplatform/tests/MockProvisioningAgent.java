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
import org.eclipse.cbi.targetplatform.tests.MockMetadataRepositoryManager;
import org.eclipse.equinox.p2.core.IProvisioningAgent;
import org.eclipse.equinox.p2.metadata.IInstallableUnit;
import org.eclipse.equinox.p2.repository.metadata.IMetadataRepositoryManager;

@SuppressWarnings("all")
public class MockProvisioningAgent implements IProvisioningAgent {
  private final IQueryResultProvider<IInstallableUnit> resultProvider;
  
  public MockProvisioningAgent(final IQueryResultProvider<IInstallableUnit> resultProvider) {
    this.resultProvider = resultProvider;
  }
  
  @Override
  public Object getService(final String serviceName) {
    boolean _equals = IMetadataRepositoryManager.SERVICE_NAME.equals(serviceName);
    if (_equals) {
      return new MockMetadataRepositoryManager(this.resultProvider);
    }
    return null;
  }
  
  @Override
  public void registerService(final String serviceName, final Object service) {
  }
  
  @Override
  public void stop() {
  }
  
  @Override
  public void unregisterService(final String serviceName, final Object service) {
  }
}
