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
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.equinox.p2.core.IProvisioningAgent;
import org.eclipse.equinox.p2.repository.metadata.IMetadataRepositoryManager;
import org.eclipse.xtext.resource.XtextResourceSet;

import com.google.common.base.Throwables;
import com.google.common.io.Closeables;
import com.google.inject.Inject;
import com.google.inject.Provider;

import fr.obeo.releng.targetplatform.TargetPlatform;
import fr.obeo.releng.targetplatform.TargetPlatformBundleActivator;
import fr.obeo.releng.targetplatform.TargetPlatformPackage;
import fr.obeo.releng.targetplatform.resolved.ResolvedTargetPlatform;
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
	
	@Inject
	private IProvisioningAgent agent;
	
	public Diagnostic generateTargetDefinitionFile(URI uri, IProgressMonitor monitor) {
		BasicDiagnostic ret = new BasicDiagnostic();
		if (!"targetplatform".equals(uri.fileExtension()) && !"tpd".equals(uri.fileExtension())) {
			ret.merge(new BasicDiagnostic(Diagnostic.ERROR, TargetPlatformBundleActivator.PLUGIN_ID, -1, "The target platform file '" + uri + "' must ends with '.tpd' or '.targetplatform' extensions.", null));
		} else {
			ret.merge(doGenerateTargetDefinitionFile(uri, monitor));
		}
		return ret;
	}

	private Diagnostic doGenerateTargetDefinitionFile(URI uri, IProgressMonitor monitor) {
		BasicDiagnostic ret = new BasicDiagnostic();
		SubMonitor subMonitor = SubMonitor.convert(monitor, 100);
		
		try {
			Resource resource = loadTargetPlatform(uri);
			subMonitor.worked(2);
			
			Diagnostic resourceDiagnostic = EcoreUtil.computeDiagnostic(resource, true);
			ret.merge(resourceDiagnostic);

			if (resourceDiagnostic.getSeverity() < Diagnostic.ERROR) {
				TargetPlatform targetPlatform = null;
				if (resource != null && !resource.getContents().isEmpty()) {
					targetPlatform = (TargetPlatform) resource.getContents().get(0);
				}
				if (targetPlatform == null) {
					ret.merge(new BasicDiagnostic(Diagnostic.ERROR, TargetPlatformBundleActivator.PLUGIN_ID, -1, "Error occured while loading the file " + uri + ".", null));
				} else if (subMonitor.isCanceled()) {
					ret.merge(Diagnostic.CANCEL_INSTANCE);
				} else {
					SubMonitor diagnosticianMonitor = subMonitor.newChild(90).setWorkRemaining(targetPlatform.getLocations().size());
					Diagnostic validation = new CustomDiagnostician(diagnosticianMonitor).validate(targetPlatform);
					if (validation.getSeverity() >= Diagnostic.WARNING) {
						ret.merge(validation);
					} else if (subMonitor.isCanceled()) {
						ret.merge(Diagnostic.CANCEL_INSTANCE);
					} 
					
					if (validation.getSeverity() < Diagnostic.ERROR) {
						ret.merge(doGenerateTargetDefinitionFile(uri, targetPlatform, subMonitor.newChild(8)));
					}
					subMonitor.setWorkRemaining(0);
				}
			}
		} catch (Exception e) {
			ret.merge(BasicDiagnostic.toDiagnostic(e));
		}
		return ret;
	}

	private Diagnostic doGenerateTargetDefinitionFile(URI uri, TargetPlatform targetPlatform, IProgressMonitor monitor)  {
		final BasicDiagnostic ret = new BasicDiagnostic();
		SubMonitor subMonitor = SubMonitor.convert(monitor, 100);
		
		try {
			IMetadataRepositoryManager repositoryManager = (IMetadataRepositoryManager) agent.getService(IMetadataRepositoryManager.SERVICE_NAME);
			ResolvedTargetPlatform resolvedTargetPlatform = ResolvedTargetPlatform.create(targetPlatform, indexBuilder);
			subMonitor.worked(5);
			
			if (subMonitor.isCanceled()) {
				ret.merge(Diagnostic.CANCEL_INSTANCE);
			} else {
				ret.merge(resolvedTargetPlatform.resolve(repositoryManager, subMonitor.newChild(90)));
				if (subMonitor.isCanceled()) {
					ret.merge(Diagnostic.CANCEL_INSTANCE);
				} else if (ret.getSeverity() < Diagnostic.ERROR) {
					ret.merge(doGenerateTargetDefinitionFile(uri, resolvedTargetPlatform));
					subMonitor.worked(5);
				}
			}
		} catch (Exception e) {
			ret.merge(BasicDiagnostic.toDiagnostic(e));
		}
		
		
		return ret;
	}

	private Diagnostic doGenerateTargetDefinitionFile(URI uri, ResolvedTargetPlatform resolvedTargetPlatform) {
		BasicDiagnostic ret = new BasicDiagnostic();
		TargetDefinitionGenerator generator = new TargetDefinitionGenerator();
		String xml = generator.generate(resolvedTargetPlatform, (int)TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis()));
		final URI targetDefinitionLocation = uri.trimFileExtension().appendFileExtension("target");
		try {
			serialize(targetDefinitionLocation, xml);
		} catch (Exception e) {
			ret.merge(BasicDiagnostic.toDiagnostic(e));
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

	private Resource loadTargetPlatform(URI fileLocation) {
		ResourceSet resourceSet = resourceSetProvider.get();
		return resourceSet.getResource(fileLocation, true);
	}
	
	private static class CustomDiagnostician extends Diagnostician {
		
		private final SubMonitor monitor;
		
		public CustomDiagnostician(SubMonitor monitor) {
			this.monitor = monitor;
		}
		
		@Override
		public boolean validate(EClass eClass, EObject eObject, DiagnosticChain diagnostics, Map<Object, Object> context) {
			if (monitor.isCanceled()) {
				return true;
			}
			
			if (eClass == TargetPlatformPackage.Literals.LOCATION) {
				context.put(IProgressMonitor.class, monitor.newChild(1));
			}
			
			return super.validate(eClass, eObject, diagnostics, context);
		}
	}
}
