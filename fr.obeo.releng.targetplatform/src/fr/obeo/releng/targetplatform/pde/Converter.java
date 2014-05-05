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

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URISyntaxException;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.equinox.p2.core.IProvisioningAgent;
import org.eclipse.equinox.p2.repository.metadata.IMetadataRepositoryManager;
import org.eclipse.xtext.resource.XtextResourceSet;

import com.google.common.base.Throwables;
import com.google.common.io.Closeables;
import com.google.inject.Inject;
import com.google.inject.Provider;

import fr.obeo.releng.targetplatform.TargetPlatformBundleActivator;
import fr.obeo.releng.targetplatform.resolved.ResolvedTargetPlatform;
import fr.obeo.releng.targetplatform.targetplatform.TargetPlatform;
import fr.obeo.releng.targetplatform.util.LocationIndexBuilder;

/**
 * @author <a href="mailto:mikael.barbero@obeo.fr">Mikael Barbero</a>
 *
 */
public class Converter {

	@Inject
	private Provider<XtextResourceSet> resourceSetProvider;
	
	@Inject
	private LocationIndexBuilder indexBuilder;
	
	public Diagnostic generateTargetDefinitionFile(URI uri, IProgressMonitor monitor) {
		final Diagnostic ret;
		if (!"targetplatform".equals(uri.fileExtension()) && !"tpd".equals(uri.fileExtension())) {
			ret = new BasicDiagnostic(Diagnostic.ERROR, TargetPlatformBundleActivator.PLUGIN_ID, -1, "The target platform file '" + uri + "' must ends with .targetplatform or .tpd extensions.", null);
		} else {
			ret = doGenerateTargetDefinitionFile(uri, monitor);
		}
		return ret;
	}

	private Diagnostic doGenerateTargetDefinitionFile(URI uri, IProgressMonitor monitor) {
		final Diagnostic ret;
		
		SubMonitor subMonitor = SubMonitor.convert(monitor, 100);
		TargetPlatform targetPlatform = loadTargetPlatform(uri);
		subMonitor.worked(2);
		
		if (targetPlatform == null) {
			ret = new BasicDiagnostic(Diagnostic.ERROR, TargetPlatformBundleActivator.PLUGIN_ID, -1, "Error occured while loading the file " + uri + ".", null);
		} else if (!targetPlatform.eResource().getErrors().isEmpty()) {
			ret = new BasicDiagnostic(Diagnostic.ERROR, TargetPlatformBundleActivator.PLUGIN_ID, -1, "Error occured while loading the file " + uri + ".", targetPlatform.eResource().getErrors().toArray());
		} else if (subMonitor.isCanceled()) {
			ret = Diagnostic.CANCEL_INSTANCE;
		} else {
			Diagnostic validation = Diagnostician.INSTANCE.validate(targetPlatform);
			subMonitor.worked(2);
			if (validation.getSeverity() == Diagnostic.ERROR) {
				ret = new BasicDiagnostic(TargetPlatformBundleActivator.PLUGIN_ID, -1, validation.getChildren(), "The file '" + uri + "' can not be converted because it contains errors.", null);
			} else if (subMonitor.isCanceled()) {
				ret = Diagnostic.CANCEL_INSTANCE;
			} else {
				ret = doGenerateTargetDefinitionFile(uri, targetPlatform, subMonitor.newChild(96));
			}
		}
		return ret;
	}

	private Diagnostic doGenerateTargetDefinitionFile(URI uri, TargetPlatform targetPlatform, IProgressMonitor monitor) {
		Diagnostic ret = Diagnostic.OK_INSTANCE;
		IProvisioningAgent agent = null;
		try {
			java.net.URI agentLocation = getAgentLocationURI(uri);
			agent = TargetPlatformBundleActivator.getInstance().getProvisioningAgentProvider().createAgent(agentLocation);
			ret = doGenerateTargetDefinitionFile(uri, targetPlatform, agent, monitor);
		} catch (Exception e) {
			if (e instanceof WrappedException) {
				ret = new BasicDiagnostic(Diagnostic.ERROR, TargetPlatformBundleActivator.PLUGIN_ID, -1, ((WrappedException) e).exception().getMessage(), new Object[] {((WrappedException) e).exception(),});
			} else {
				ret = new BasicDiagnostic(Diagnostic.ERROR, TargetPlatformBundleActivator.PLUGIN_ID, -1, e.getMessage(), new Object[] {e,});
			}
		} finally {
			if (agent != null) {
				agent.stop();
			}
		}
		
		return ret;
	}

	private Diagnostic doGenerateTargetDefinitionFile(URI uri, TargetPlatform targetPlatform, IProvisioningAgent agent, IProgressMonitor monitor) throws URISyntaxException {
		Diagnostic ret;
		SubMonitor subMonitor = SubMonitor.convert(monitor, 100);
		
		IMetadataRepositoryManager repositoryManager = (IMetadataRepositoryManager) agent.getService(IMetadataRepositoryManager.SERVICE_NAME);
		ResolvedTargetPlatform resolvedTargetPlatform = ResolvedTargetPlatform.create(targetPlatform, indexBuilder);
		subMonitor.worked(5);
		
		if (monitor.isCanceled()) {
			return Diagnostic.CANCEL_INSTANCE;
		} else {
			ret = resolvedTargetPlatform.resolve(repositoryManager, subMonitor.newChild(90));
			if (ret.getSeverity() == Diagnostic.ERROR) {
				ret = new BasicDiagnostic(TargetPlatformBundleActivator.PLUGIN_ID, -1, ret.getChildren(), "The file '" + uri + "' can not be resolved.", null);
			} else if (subMonitor.isCanceled()) {
				ret = Diagnostic.CANCEL_INSTANCE;
			} else {
				ret = doGenerateTargetDefinitionFile(uri, resolvedTargetPlatform);
				subMonitor.worked(5);
			}
		}
		return ret;
	}

	private Diagnostic doGenerateTargetDefinitionFile(URI uri, ResolvedTargetPlatform resolvedTargetPlatform) {
		Diagnostic ret;
		TargetDefinitionGenerator generator = new TargetDefinitionGenerator();
		String xml = generator.generate(resolvedTargetPlatform);
		final URI targetDefinitionLocation = uri.trimFileExtension().appendFileExtension("target");
		try {
			serialize(targetDefinitionLocation, xml);
			ret = Diagnostic.OK_INSTANCE;
		} catch (Exception e) {
			ret = new BasicDiagnostic(TargetPlatformBundleActivator.PLUGIN_ID, -1, e.getMessage(), new Object[] {e,});
		}
		return ret;
	}

	private void serialize(URI targetPlatformLocation, String xml) throws IOException {
		URI targetDefinitionLocation = targetPlatformLocation.trimFileExtension().appendFileExtension("target");
		OutputStream outputStream = null;
		try {
			outputStream = new BufferedOutputStream(new FileOutputStream(new File(targetDefinitionLocation.toFileString())));
			outputStream.write(xml.getBytes());
		} catch (Exception e) {
			Throwables.propagate(e);
		} finally {
			Closeables.close(outputStream, false);
		}
	}

	private java.net.URI getAgentLocationURI(URI fileLocation) throws URISyntaxException {
		String fileName = fileLocation.lastSegment();
		java.net.URI agentLocation = new java.net.URI(fileLocation.trimSegments(1).appendSegment("." + fileName).toString());
		return agentLocation;
	}

	private TargetPlatform loadTargetPlatform(URI fileLocation) {
		ResourceSet resourceSet = resourceSetProvider.get();
		Resource resource = resourceSet.getResource(fileLocation, true);
		TargetPlatform targetPlatform = null;
		if (resource != null && !resource.getContents().isEmpty()) {
			targetPlatform = (TargetPlatform) resource.getContents().get(0);
		}
		return targetPlatform;
	}
}
