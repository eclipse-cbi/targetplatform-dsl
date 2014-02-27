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
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URISyntaxException;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.equinox.p2.core.IProvisioningAgent;
import org.eclipse.equinox.p2.core.ProvisionException;
import org.eclipse.equinox.p2.repository.metadata.IMetadataRepositoryManager;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.scoping.impl.ImportUriResolver;

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
	private ImportUriResolver resolver;
	
	public void generateTargetDefinitionFile(URI targetPlatformLocation, IProgressMonitor monitor) throws Exception {
		SubMonitor subMonitor = SubMonitor.convert(monitor, 100);
		if (!"targetplatform".equals(targetPlatformLocation.fileExtension()) && !"tpd".equals(targetPlatformLocation.fileExtension())) {
			throw new IllegalStateException("The target platform file '" + targetPlatformLocation + "' must ends with .targetplatform or .tpd extensions.");
		}
		
		TargetPlatform targetPlatform = loadTargetPlatform(targetPlatformLocation);
		
		Diagnostic diagnostic = Diagnostician.INSTANCE.validate(targetPlatform);
		if (diagnostic.getSeverity() == Diagnostic.ERROR) {
			throw new IllegalStateException("The file '" + targetPlatformLocation + "' can not be converted. It contains errors.");
		}
		
		subMonitor.worked(5);
		if (targetPlatform == null) {
			return;
		}
		java.net.URI agentLocation = getAgentLocationURI(targetPlatformLocation);
		ResolvedTargetPlatform resolvedTargetPlatform = getResolvedTargetPlatform(targetPlatform, agentLocation, subMonitor.newChild(90));
		
		TargetDefinitionGenerator generator = new TargetDefinitionGenerator();
		
		String xml = generator.generate(resolvedTargetPlatform);
		final URI targetDefinitionLocation = targetPlatformLocation.trimFileExtension().appendFileExtension("target");
		serialize(targetDefinitionLocation, xml);
		subMonitor.worked(5);
	}

	private void serialize(URI targetPlatformLocation, String xml) throws FileNotFoundException, IOException {
		URI targetDefinitionLocation = targetPlatformLocation.trimFileExtension().appendFileExtension("target");
		OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(new File(targetDefinitionLocation.toFileString())));
		try {
			outputStream.write(xml.getBytes());
		} catch (IOException e) {
			handleError(e.getMessage(), e);
		} finally {
			Closeables.close(outputStream, true);
		}
	}

	public ResolvedTargetPlatform getResolvedTargetPlatform(TargetPlatform targetPlatform, java.net.URI agentLocation, IProgressMonitor monitor) throws URISyntaxException, ProvisionException {
		IProvisioningAgent agent = TargetPlatformBundleActivator.getInstance().getProvisioningAgentProvider().createAgent(agentLocation);
		IMetadataRepositoryManager repositoryManager = (IMetadataRepositoryManager) agent.getService(IMetadataRepositoryManager.SERVICE_NAME);

		ResolvedTargetPlatform resolvedTargetPlatform = ResolvedTargetPlatform.create(targetPlatform, new LocationIndexBuilder(resolver));
		resolvedTargetPlatform.resolve(repositoryManager, monitor);
		
		agent.stop();
		return resolvedTargetPlatform;
	}

	protected void handleError(String message, IOException e) {
		e.printStackTrace();
		
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
