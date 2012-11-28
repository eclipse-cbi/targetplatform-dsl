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

import java.io.FileOutputStream;
import java.net.URI;
import java.net.URISyntaxException;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ExtensibleURIConverterImpl;
import org.eclipse.equinox.p2.core.IProvisioningAgent;
import org.eclipse.equinox.p2.core.ProvisionException;
import org.eclipse.pde.core.target.ITargetDefinition;
import org.eclipse.pde.internal.core.target.TargetDefinitionPersistenceHelper;
import org.eclipse.xtext.resource.XtextResourceSet;

import com.google.inject.Inject;
import com.google.inject.Provider;

import fr.obeo.releng.TargetPlatformBundleActivator;
import fr.obeo.releng.targetplatform.TargetPlatform;
import fr.obeo.releng.targetplatform.resolved.ResolvedTargetPlatform;

/**
 * @author <a href="mailto:mikael.barbero@obeo.fr">Mikael Barbero</a>
 *
 */
public class Converter {

	@Inject
	private Provider<XtextResourceSet> resourceSetProvider;
	
	public void generateTargetDefinitionFile(org.eclipse.emf.common.util.URI targetPlatformLocation, IProgressMonitor monitor) throws Exception {
		SubMonitor subMonitor = SubMonitor.convert(monitor, 100);
		if (!"targetplatform".equals(targetPlatformLocation.fileExtension())) {
			System.err.println("The target platform file must ends with .targetplatform extension");
			return;
		}
		
		TargetPlatform targetPlatform = loadTargetPlatform(targetPlatformLocation);
		if (targetPlatform == null) {
			return;
		}
		
		ResolvedTargetPlatform resolvedTargetPlatform = ResolvedTargetPlatform.resolve(targetPlatform, subMonitor.newChild(20));
		
		ITargetDefinition targetDefinition = generateTargetDefinition(getAgentLocationURI(targetPlatformLocation), resolvedTargetPlatform, subMonitor.newChild(60));

		org.eclipse.emf.common.util.URI targetDefinitionLocation = targetPlatformLocation.trimFileExtension().appendFileExtension("target");
		TargetDefinitionPersistenceHelper.persistXML(targetDefinition, new FileOutputStream(targetDefinitionLocation.toFileString()));
		subMonitor.worked(20);
	}

	private ITargetDefinition generateTargetDefinition(URI agentLocation, ResolvedTargetPlatform resolvedTargetPlatform, IProgressMonitor monitor) throws ProvisionException, URISyntaxException {
		IProvisioningAgent agent = TargetPlatformBundleActivator.getInstance().getProvisioningAgentProvider().createAgent(agentLocation);
		PDETargetDefinitionGenerator targetDefinitionGenerator = new PDETargetDefinitionGenerator(TargetPlatformBundleActivator.getInstance().getTargetPlatformService());
		ITargetDefinition targetDefinition = targetDefinitionGenerator.generate(agent, resolvedTargetPlatform, SubMonitor.convert(monitor, 10).newChild(10));
		agent.stop();
		return targetDefinition;
	}

	private URI getAgentLocationURI(org.eclipse.emf.common.util.URI fileLocation) throws URISyntaxException {
		String fileName = fileLocation.lastSegment();
		URI agentLocation = new URI(fileLocation.trimSegments(1).appendSegment("." + fileName).toString());
		return agentLocation;
	}

	private TargetPlatform loadTargetPlatform(org.eclipse.emf.common.util.URI fileLocation) {
		ResourceSet resourceSet = resourceSetProvider.get();
		Resource resource = resourceSet.getResource(fileLocation, true);
		EList<Diagnostic> errors = resource.getErrors();
		if (!errors.isEmpty()) {
			for (Diagnostic diagnostic : errors) {
				System.err.println(diagnostic);
			}
			return null;
		}
		
		TargetPlatform targetPlatform = (TargetPlatform) resource.getContents().get(0);
		return targetPlatform;
	}
}
