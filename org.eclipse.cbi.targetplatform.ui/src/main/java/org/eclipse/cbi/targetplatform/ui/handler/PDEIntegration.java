/**
 * Copyright (c) 2014 Obeo and others.
 *
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Cedric Brun (Obeo) - initial API and implementation
 */
package org.eclipse.cbi.targetplatform.ui.handler;

import java.io.File;
import java.lang.reflect.Method;

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

	private static final String ACQUIRE_SERVICE = "acquireService";
	
	private Optional<ITargetPlatformService> service;
	
	public PDEIntegration() {
		this.service = Optional.fromNullable(acquireTargetPlatformService());
	}

	private static ITargetPlatformService acquireTargetPlatformService() {
		RuntimeException toBeThrown = new RuntimeException("Method " + PDECore.class.getName() + ".acquireService(String|Class) cannot be found");
		try {
			Method acquireService = PDECore.getDefault().getClass().getMethod(ACQUIRE_SERVICE, String.class);
			return (ITargetPlatformService) acquireService.invoke(PDECore.getDefault(), ITargetPlatformService.class.getName());
		} catch (ReflectiveOperationException e1) {
			toBeThrown.addSuppressed(e1);
			try {
				Method acquireService = PDECore.getDefault().getClass().getMethod(ACQUIRE_SERVICE, Class.class);
				return (ITargetPlatformService) acquireService.invoke(PDECore.getDefault(), ITargetPlatformService.class);
			} catch (ReflectiveOperationException e2) {
				toBeThrown.addSuppressed(e2);
			}
		}
		
		throw toBeThrown;
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
