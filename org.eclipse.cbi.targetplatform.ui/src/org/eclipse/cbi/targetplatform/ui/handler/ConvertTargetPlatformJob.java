/*******************************************************************************
 * Copyright (c) 2014 Obeo and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Cedric Brun (Obeo) - initial API and implementation
 *******************************************************************************/
package org.eclipse.cbi.targetplatform.ui.handler;

import org.eclipse.cbi.targetplatform.pde.Converter;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;

import com.google.inject.Injector;

import org.eclipse.cbi.targetplatform.ui.internal.TargetPlatformActivator;

/**
 * @author <a href="mailto:cedric.brun@obeo.fr">Cedric Brun</a>
 */
public class ConvertTargetPlatformJob extends Job {

	private IFile selectedElement;
	private boolean setTargetPlatform;

	public ConvertTargetPlatformJob(String name, IFile selectedElement, boolean setTargetPlatform) {
		super(name);
		this.selectedElement = selectedElement;
		this.setTargetPlatform = setTargetPlatform;
	}

	@Override
	protected IStatus run(IProgressMonitor monitor) {
		IStatus ret = Status.OK_STATUS;
		SubMonitor subMonitor = SubMonitor.convert(monitor, 100);
		Injector injector = TargetPlatformActivator
				.getInstance()
				.getInjector(
						TargetPlatformActivator.ORG_ECLIPSE_CBI_TARGETPLATFORM_TARGETPLATFORM);
		Converter converter = new Converter();
		injector.injectMembers(converter);
		Diagnostic diagnostic = null;
		final String path = selectedElement.getLocation().toFile().getAbsolutePath();
		URI targetplatformFileURI = URI.createFileURI(path);

		try {
			diagnostic = converter.generateTargetDefinitionFile(targetplatformFileURI, subMonitor.newChild(95));
		} catch (OperationCanceledException cancel) {
			ret = new Status(
					IStatus.CANCEL,
					TargetPlatformActivator.ORG_ECLIPSE_CBI_TARGETPLATFORM_TARGETPLATFORM,
					cancel.getMessage(), cancel);
		} catch (Exception e) {
			ret = new Status(
					IStatus.ERROR,
					TargetPlatformActivator.ORG_ECLIPSE_CBI_TARGETPLATFORM_TARGETPLATFORM,
					e.getMessage(), e);
		}
		IContainer container = selectedElement.getParent();
		if (container != null) {
			try {
				container.refreshLocal(IResource.DEPTH_ONE, subMonitor.newChild(5));
			} catch (CoreException e) {
				return new Status(IStatus.ERROR, TargetPlatformActivator
						.getInstance().getBundle().getSymbolicName(),
						e.getMessage(), e);
			}
		}

		if (setTargetPlatform) {
			PDEIntegration pdeIntegration = new PDEIntegration();

			final URI targetFileURI = targetplatformFileURI.trimFileExtension().appendFileExtension("target");
			try {
				pdeIntegration.setTargetPlatform(targetFileURI, monitor);
			} catch (CoreException e) {
				ret = new Status(
						IStatus.ERROR,
						TargetPlatformActivator.ORG_ECLIPSE_CBI_TARGETPLATFORM_TARGETPLATFORM,
						e.getMessage(), e);
			}
		}

		if (diagnostic != null) {
			return BasicDiagnostic.toIStatus(diagnostic);
		} else {
			return ret;
		}
	}

}
