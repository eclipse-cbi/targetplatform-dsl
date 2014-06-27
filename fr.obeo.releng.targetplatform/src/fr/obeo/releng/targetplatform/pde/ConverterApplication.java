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
import java.util.Iterator;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;

import com.google.inject.Injector;

import fr.obeo.releng.targetplatform.TargetPlatformBundleActivator;
import fr.obeo.releng.targetplatform.TargetPlatformStandaloneSetup;


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
			System.out.println("Must provide path to a target form file");
			return -256;
		} else {
			path = args[0];
		}
		
		TargetPlatformStandaloneSetup.doSetup();
		Injector injector = TargetPlatformBundleActivator.getInstance().getInjector(TargetPlatformBundleActivator.TARGET_PLATFORM_LANGUAGE_NAME);
		Converter converter = new Converter();
		injector.injectMembers(converter);

		URI uri = normalize(org.eclipse.emf.common.util.URI.createURI(path));
		
		Diagnostic diagnostic = converter.generateTargetDefinitionFile(uri, createPrintingMonitor());
		
		if (diagnostic.getSeverity() >= Diagnostic.WARNING) {
			for (Diagnostic child : diagnostic.getChildren()) {
				printDiagnostic(child, "");
			}
		}
		
		if (diagnostic.getSeverity() == Diagnostic.ERROR) {
			System.out.println("Problems occurred during generation of target platform definition file.");
			return -1;
		} else if (diagnostic.getSeverity() == Diagnostic.CANCEL) {
			System.out.println("Operation cancelled.");
			return -2;
		} else {
			System.out.println("The target platform definition file has been successfully generated.");
			return 0;
		}
	}

	private static IProgressMonitor createPrintingMonitor() {
		return BasicMonitor.toIProgressMonitor(new BasicMonitor.Printing(System.out));
	}
	
	private static void printDiagnostic(Diagnostic diagnostic, String indent) {
		if (diagnostic.getSeverity() > Diagnostic.OK) {
			System.out.print(indent);
			final String severity = getSeverityString(diagnostic);
			System.out.println(severity + " " + diagnostic.getMessage());
			for (Iterator<Diagnostic> i = diagnostic.getChildren().iterator(); i.hasNext();) {
				printDiagnostic((Diagnostic) i.next(), indent + "  ");
			}
		}
	}

	private static String getSeverityString(Diagnostic diagnostic) {
		final String severity;
		switch (diagnostic.getSeverity()) {
			case Diagnostic.OK:
				severity = "[OK]     ";
				break;
			case Diagnostic.INFO:
				severity = "[INFO]   ";
				break;
			case Diagnostic.WARNING:
				severity = "[WARNING]";
				break;
			case Diagnostic.ERROR:
				severity = "[ERROR]  ";
				break;
			case Diagnostic.CANCEL:
				severity = "[CANCEL] ";
				break;
			default:
				severity = Integer.toHexString(diagnostic.getSeverity());
				break;
		}
		return severity;
	}
	
	private static URI normalize(URI uri) {
		String fragment = uri.fragment();
		String query = uri.query();
		URI trimmedURI = uri.trimFragment().trimQuery();
		URI result = trimmedURI;
		String scheme = result.scheme();
		if (scheme == null) {
			if (result.hasAbsolutePath()) {
				result = URI.createURI("file:" + result);
			} else {
				result = URI.createFileURI(new File(result.toString())
						.getAbsolutePath());
			}
		}

		if (result == trimmedURI) {
			return uri;
		}

		if (query != null) {
			result = result.appendQuery(query);
		}
		if (fragment != null) {
			result = result.appendFragment(fragment);
		}

		return result;
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
