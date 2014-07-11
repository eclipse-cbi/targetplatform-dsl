/*******************************************************************************
 * Copyright (c) 2014 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package fr.obeo.releng.targetplatform.ui.handler;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.URI;
import org.eclipse.pde.core.target.ITargetDefinition;
import org.eclipse.pde.core.target.ITargetHandle;
import org.eclipse.pde.core.target.ITargetPlatformService;
import org.eclipse.pde.internal.core.PDECore;
import org.eclipse.pde.internal.core.target.WorkspaceFileTargetHandle;

import com.google.common.base.Optional;

/**
 * Class wrapping PDE Targetplatform API calls. If the TargetPlatform service
 * can't be acquired, calls will have no effects and will not throw any error.
 * 
 * @author <a href="mailto:cedric.brun@obeo.fr">Cedric Brun</a>
 *
 */
public class PDEIntegration {

	private Optional<ITargetPlatformService> service;

	public PDEIntegration() {
		service = Optional.fromNullable((ITargetPlatformService) PDECore
				.getDefault().acquireService(
						ITargetPlatformService.class.getName()));
	}

	public void setTargetPlatform(URI targetFileURI, IProgressMonitor monitor)
			throws CoreException {

		if (service.isPresent()) {
			ITargetHandle[] targets = service.get().getTargets(monitor);

			for (int i = 0; i < targets.length; i++) {
				if (targets[i] instanceof WorkspaceFileTargetHandle) {
					WorkspaceFileTargetHandle fileHandle = (WorkspaceFileTargetHandle) targets[i];
					URI targetFile = URI
							.createFileURI(((WorkspaceFileTargetHandle) fileHandle)
									.getTargetFile().getLocation().toFile()
									.getAbsolutePath());
					if (targetFile.equals(targetFileURI)) {

						ITargetDefinition targetDefinitionToSet = fileHandle
								.getTargetDefinition();

						if (!targetDefinitionToSet.isResolved()) {
							targetDefinitionToSet.resolve(monitor);
						}
						IStatus compare = service.get()
								.compareWithTargetPlatform(
										targetDefinitionToSet);
						if (compare != null && !compare.isOK()) {
							org.eclipse.pde.core.target.LoadTargetDefinitionJob
									.load(targetDefinitionToSet);
						}

					}
				}
			}
		}
	}

	public Optional<URI> getActiveTargetPlatformFileURI() throws CoreException {
		if (service.isPresent()) {
			ITargetDefinition currentlySelected = service.get()
					.getWorkspaceTargetHandle().getTargetDefinition();
			if (currentlySelected.getHandle() instanceof WorkspaceFileTargetHandle) {
				URI targetFile = URI
						.createFileURI(((WorkspaceFileTargetHandle) currentlySelected
								.getHandle()).getTargetFile().getLocation()
								.toFile().getAbsolutePath());
				return Optional.of(targetFile);

			}
		}
		return Optional.absent();

	}

}
