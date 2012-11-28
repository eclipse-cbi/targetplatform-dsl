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
package fr.obeo.releng.ui.handler;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;

import com.google.inject.Injector;

import fr.obeo.releng.targetplatform.pde.Converter;
import fr.obeo.releng.ui.internal.TargetPlatformActivator;

/**
 * @author <a href="mailto:mikael.barbero@obeo.fr">Mikael Barbero</a>
 *
 */
public class ConvertTargetPlatform extends AbstractHandler {

	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.core.commands.IHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 */
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ISelection selection = HandlerUtil.getCurrentSelection(event);
		if (selection instanceof IStructuredSelection) {
			final Object firstElement = ((IStructuredSelection) selection).getFirstElement();
			if (firstElement instanceof IFile) {
				final String path = ((IFile) firstElement).getLocation().toFile().getAbsolutePath();
				Injector injector = TargetPlatformActivator.getInstance().getInjector(TargetPlatformActivator.FR_OBEO_RELENG_TARGETPLATFORM);
				final Converter converter = new Converter();
				injector.injectMembers(converter);
				
				ProgressMonitorDialog progressMonitorDialog = new ProgressMonitorDialog(HandlerUtil.getActiveShell(event));
				try {
					progressMonitorDialog.run(true, true, new IRunnableWithProgress() {
						@Override
						public void run(IProgressMonitor monitor) throws InvocationTargetException,
								InterruptedException {
							SubMonitor subMonitor = SubMonitor.convert(monitor, 100);
							try {
								converter.generateTargetDefinitionFile(URI.createFileURI(path), subMonitor.newChild(95));
							} catch (Exception e) {
								throw new InvocationTargetException(e);
							}
							IContainer container = ((IFile) firstElement).getParent();
							if (container != null) {
								try {
									container.refreshLocal(IResource.DEPTH_ONE, subMonitor.newChild(5));
								} catch (CoreException e) {
									throw new InvocationTargetException(e);
								}
							}
						}
					});
				} catch (InvocationTargetException e) {
					TargetPlatformActivator.getInstance().getLog().log(new Status(IStatus.ERROR, TargetPlatformActivator.getInstance().getBundle().getSymbolicName(), e.getCause().getMessage(), e.getCause()));
				} catch (InterruptedException e) {
					TargetPlatformActivator.getInstance().getLog().log(new Status(IStatus.ERROR, TargetPlatformActivator.getInstance().getBundle().getSymbolicName(), e.getMessage(), e));
				}
			}
		}
		return null;
	}

}
