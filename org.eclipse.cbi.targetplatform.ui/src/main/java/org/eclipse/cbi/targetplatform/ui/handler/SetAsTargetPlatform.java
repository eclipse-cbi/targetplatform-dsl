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

import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;

/**
 * @author <a href="mailto:cedric.brun@obeo.fr">Cedric Brun</a>
 */
public class SetAsTargetPlatform extends AbstractHandler {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.core.commands.IHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 */
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ISelection selection = HandlerUtil.getCurrentSelection(event);
		if (selection instanceof IStructuredSelection) {
			List<?> selectedObjects = ((IStructuredSelection) selection).toList();
			for (Object selectedObject : selectedObjects) {
				if (selectedObject instanceof IFile) {
					scheduleJob((IFile) selectedObject, selectedObjects.size() <= 1);
				}
			}
		}
		return null;
	}

	private void scheduleJob(final IFile selectedElement, boolean userJob) {
		Job job = new ConvertTargetPlatformJob("Setting target platform definition file", selectedElement, true);
		job.setUser(userJob);
		job.schedule();
	}
}
