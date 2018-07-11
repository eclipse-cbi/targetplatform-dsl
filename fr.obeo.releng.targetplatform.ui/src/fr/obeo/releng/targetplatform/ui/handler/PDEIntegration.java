/*******************************************************************************
 * Copyright (c) 2014 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Cedric Brun (Obeo) - initial API and implementation
 *******************************************************************************/
package fr.obeo.releng.targetplatform.ui.handler;

import java.io.File;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.SubMonitor;
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
 */
@SuppressWarnings("restriction")
public class PDEIntegration {

	private Optional<ITargetPlatformService> service;

	public PDEIntegration() {
		service = Optional.fromNullable(
			(ITargetPlatformService) PDECore.getDefault().acquireService(ITargetPlatformService.class)
		);
	}

	public void setTargetPlatform(URI targetFileURIToSet, IProgressMonitor monitor) throws CoreException {
		if (service.isPresent()) {
			SubMonitor subMonitor = SubMonitor.convert(monitor, 100);
			ITargetHandle[] targets = service.get().getTargets(subMonitor.newChild(20));

			boolean hasBeenSet = false;
			for (int i = 0; i < targets.length && !hasBeenSet; i++) {
				if (targets[i] instanceof WorkspaceFileTargetHandle) {
					WorkspaceFileTargetHandle fileHandle = (WorkspaceFileTargetHandle) targets[i];
					hasBeenSet = trySetTargetPlatform(targetFileURIToSet, subMonitor, fileHandle);
				}
			}
		}
	}

	private boolean trySetTargetPlatform(URI targetFileURIToSet, SubMonitor subMonitor, WorkspaceFileTargetHandle fileHandle) throws CoreException {
		File targetFile = ((WorkspaceFileTargetHandle) fileHandle).getTargetFile().getLocation().toFile();
		URI targetFileURI = URI.createFileURI(targetFile.getAbsolutePath());
		if (targetFileURI.equals(targetFileURIToSet)) {
			ITargetDefinition targetDefinitionToSet = fileHandle.getTargetDefinition();

			if (!targetDefinitionToSet.isResolved()) {
				targetDefinitionToSet.resolve(subMonitor.newChild(80));
			}
			subMonitor.setWorkRemaining(0);
			
			IStatus compare = service.get().compareWithTargetPlatform(targetDefinitionToSet);
			if (compare != null && !compare.isOK()) {
				org.eclipse.pde.core.target.LoadTargetDefinitionJob.load(targetDefinitionToSet);
			}
			return true;
		}
		return false;
	}

	public Optional<URI> getActiveTargetPlatformFileURI() throws CoreException {
		if (service.isPresent()) {
			ITargetDefinition currentlySelected = service.get().getWorkspaceTargetHandle().getTargetDefinition();
			if (currentlySelected.getHandle() instanceof WorkspaceFileTargetHandle) {
				IFile targetFile = ((WorkspaceFileTargetHandle) currentlySelected.getHandle()).getTargetFile();
				URI targetFileURI = URI.createFileURI(targetFile.getLocation().toFile().getAbsolutePath());
				return Optional.of(targetFileURI);
			}
		}
		return Optional.absent();
	}

}
