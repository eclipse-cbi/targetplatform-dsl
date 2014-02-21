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
package fr.obeo.releng.targetplatform.pde;

import java.io.File;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;

import com.google.inject.Injector;

import fr.obeo.releng.targetplatform.TargetPlatformBundleActivator;


/**
 * @author <a href="mailto:mikael.barbero@obeo.fr">Mikael Barbero</a>
 *
 */
public class ConverterApplication implements IApplication {

	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.equinox.app.IApplication#start(org.eclipse.equinox.app.IApplicationContext)
	 */
	@Override
	public Object start(IApplicationContext context) throws Exception {
		Map<?,?> arguments = context.getArguments();
		String[] args = (String[]) arguments.get(IApplicationContext.APPLICATION_ARGS);
		String path;
		if (args.length <= 0) {
			System.err.println("Must provide path to a a target form file");
			return null;
		} else {
			path = args[0];
		}
		
		Injector injector = TargetPlatformBundleActivator.getInstance().getInjector(TargetPlatformBundleActivator.TARGET_PLATFORM_LANGUAGE_NAME);
		Class<?> converterClass = ConverterApplication.class.getClassLoader().loadClass("fr.obeo.releng.targetplatform.internal.pde.Converter");
		IConverter converter = (IConverter) converterClass.newInstance();
		injector.injectMembers(converter);

		URI fileURI = org.eclipse.emf.common.util.URI.createFileURI(path);
		if (fileURI.isRelative()) {
			fileURI = org.eclipse.emf.common.util.URI.createFileURI(new File(".").getAbsolutePath() + File.separator + path);
		}
		
		converter.generateTargetDefinitionFile(fileURI, createPrintingMonitor());
			
		return null;
	}

	private static IProgressMonitor createPrintingMonitor() {
		return BasicMonitor.toIProgressMonitor(new BasicMonitor.Printing(System.out));
	}
	
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.equinox.app.IApplication#stop()
	 */
	@Override
	public void stop() {
	}
}
