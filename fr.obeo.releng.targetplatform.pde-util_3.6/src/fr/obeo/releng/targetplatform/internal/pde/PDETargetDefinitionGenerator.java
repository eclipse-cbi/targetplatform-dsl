/*******************************************************************************
 * Copyright (c) 2012 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package fr.obeo.releng.targetplatform.internal.pde;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.equinox.p2.core.IProvisioningAgent;
import org.eclipse.equinox.p2.core.ProvisionException;
import org.eclipse.equinox.p2.metadata.IInstallableUnit;
import org.eclipse.equinox.p2.repository.metadata.IMetadataRepositoryManager;
import org.eclipse.pde.internal.core.target.IUBundleContainer;
import org.eclipse.pde.internal.core.target.provisional.ITargetDefinition;
import org.eclipse.pde.internal.core.target.provisional.ITargetPlatformService;

import fr.obeo.releng.targetplatform.Option;
import fr.obeo.releng.targetplatform.resolved.ResolvedLocation;
import fr.obeo.releng.targetplatform.resolved.ResolvedTargetPlatform;

/**
 * @author <a href="mailto:mikael.barbero@obeo.fr">Mikael Barbero</a>
 *
 */
public class PDETargetDefinitionGenerator {

	private final ITargetPlatformService targetPlatformService;

	public PDETargetDefinitionGenerator(ITargetPlatformService targetPlatformService) {
		this.targetPlatformService = targetPlatformService;
	}
	
	public ITargetDefinition generate(IProvisioningAgent agent, ResolvedTargetPlatform targetPlatform, IProgressMonitor monitor) throws ProvisionException, OperationCanceledException {
		SubMonitor subMonitor = SubMonitor.convert(monitor, 100);
		IMetadataRepositoryManager metadataRepositoryManager = (IMetadataRepositoryManager) agent.getService(IMetadataRepositoryManager.SERVICE_NAME);
		
		subMonitor.worked(10);
		
		List<ResolvedLocation> locations = targetPlatform.getLocations();
		List<IUBundleContainer> iuLocations = new ArrayList<IUBundleContainer>();
		ITargetDefinition pdeTargetDefinition = targetPlatformService.newTarget();
		
		SubMonitor loopMonitor = subMonitor.newChild(90).setWorkRemaining(locations.size());
		for (ResolvedLocation location : locations) {
			List<IInstallableUnit> toBeInstalled = location.getIUToBeInstalled(metadataRepositoryManager, loopMonitor.newChild(1));
			IUBundleContainer bundleContainaer = (IUBundleContainer) targetPlatformService.newIUContainer(
					toBeInstalled.toArray(new IInstallableUnit[0]), 
					new URI[] {location.getURI()});
			int resolutionFlags = setResolutionFlags(location, bundleContainaer, pdeTargetDefinition);
			
			iuLocations.add(bundleContainaer);
		}
		
		pdeTargetDefinition.setName(targetPlatform.getName());
		pdeTargetDefinition.setBundleContainers(iuLocations.toArray(new IUBundleContainer[0]));
		
		return pdeTargetDefinition;
	}

	private int setResolutionFlags(ResolvedLocation location, IUBundleContainer bundleContainer, ITargetDefinition pdeTargetDefinition) {
		int resolutionFlags = 0;
		for (Option option : location.getOptions()) {
			switch (option) {
				case INCLUDE_ALL_ENVIRONMENTS:
					bundleContainer.setIncludeAllEnvironments(true, pdeTargetDefinition);
					break;
				case INCLUDE_CONFIGURE_PHASE:
					// unsupported
					break;
				case INCLUDE_REQUIRED:
					bundleContainer.setIncludeAllRequired(true, pdeTargetDefinition);
					break;
				case INCLUDE_SOURCE:
					//unsupported
					break;
			}
		}
		return resolutionFlags;
	}
}
