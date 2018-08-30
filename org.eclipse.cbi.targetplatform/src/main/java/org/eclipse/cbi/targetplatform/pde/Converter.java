/*******************************************************************************
 * Copyright (c) 2012 Obeo and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Mikael Barbero (Obeo) - initial API and implementation
 *******************************************************************************/
package org.eclipse.cbi.targetplatform.pde;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

import org.eclipse.cbi.targetplatform.TargetPlatformBundleActivator;
import org.eclipse.cbi.targetplatform.resolved.ResolvedTargetPlatform;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
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

import com.google.common.base.Charsets;
import com.google.common.io.Closeables;
import com.google.common.io.Files;
import com.google.inject.Inject;
import com.google.inject.Provider;

import org.eclipse.cbi.targetplatform.model.TargetPlatform;
import org.eclipse.cbi.targetplatform.model.TargetPlatformPackage;
import org.eclipse.cbi.targetplatform.pde.TargetDefinitionGenerator;
import org.eclipse.cbi.targetplatform.util.LocationIndexBuilder;

/**
 * @author <a href="mailto:mikael.barbero@gmail.com">Mikael Barbero</a>
 *
 */
public class Converter {

	private static final Pattern SEQUENCE_NUMBER__PATTERN = Pattern.compile("sequenceNumber\\s*=\\s*\"[0-9]+\"");

	@Inject
	private Provider<XtextResourceSet> resourceSetProvider;
	
	@Inject
	private LocationIndexBuilder indexBuilder;
	
	@Inject
	private IProvisioningAgent agent;
	
	public Diagnostic generateTargetDefinitionFile(URI uri, IProgressMonitor monitor) {
		BasicDiagnostic ret = new BasicDiagnostic(TargetPlatformBundleActivator.PLUGIN_ID, 0, "Diagnostic of the generation of the target platform.", null);
		if (!"targetplatform".equals(uri.fileExtension()) && !"tpd".equals(uri.fileExtension())) {
			ret.merge(new BasicDiagnostic(Diagnostic.ERROR, TargetPlatformBundleActivator.PLUGIN_ID, -1, "The target platform file '" + uri + "' must ends with '.tpd' or '.targetplatform' extensions.", null));
		} else {
			Diagnostic diagnostic = doGenerateTargetDefinitionFile(uri, monitor);
			if (diagnostic.getSeverity() >= Diagnostic.WARNING) {
				ret.merge(diagnostic);
			}
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
			if (resourceDiagnostic.getSeverity() >= Diagnostic.WARNING) {
				ret.merge(resourceDiagnostic);
			}

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
						Diagnostic diagnostic = doGenerateTargetDefinitionFile(uri, targetPlatform, subMonitor.newChild(8));
						if (diagnostic.getSeverity() >= Diagnostic.WARNING) {
							ret.merge(diagnostic);
						}
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
				Diagnostic diagnostic = resolvedTargetPlatform.resolve(repositoryManager, subMonitor.newChild(90));
				if (diagnostic.getSeverity() >= Diagnostic.WARNING) {
					ret.merge(diagnostic);
				}
				if (subMonitor.isCanceled()) {
					ret.merge(Diagnostic.CANCEL_INSTANCE);
				} else if (ret.getSeverity() < Diagnostic.ERROR) {
					diagnostic = doGenerateTargetDefinitionFile(uri, resolvedTargetPlatform);
					if (diagnostic.getSeverity() >= Diagnostic.WARNING) {
						ret.merge(diagnostic);
					}
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
		
		Diagnostic diagnostic = serialize(targetDefinitionLocation, xml);
		if (diagnostic.getSeverity() >= Diagnostic.WARNING) {
			ret.merge(diagnostic);
		}
		
		return ret;
	}

	private Diagnostic serialize(URI targetPlatformLocation, String xml) {
		BasicDiagnostic ret = new BasicDiagnostic();
		URI targetDefinitionLocation = targetPlatformLocation.trimFileExtension().appendFileExtension("target");
		
		if (hasContentDifferencesOtherThanSequenceNumber(targetDefinitionLocation, xml)) {
			OutputStream outputStream = null;
			try {
				outputStream = new BufferedOutputStream(new FileOutputStream(new File(targetDefinitionLocation.toFileString())));
				outputStream.write(xml.getBytes());
			} catch (Exception e) {
				ret.merge(BasicDiagnostic.toDiagnostic(e));
			} finally {
				try {
					Closeables.close(outputStream, true);
				} catch (IOException e) {
					// swallowed
				}
			}
		} else {
			ret.merge(new BasicDiagnostic(Diagnostic.INFO, TargetPlatformBundleActivator.PLUGIN_ID, -1, "The target definition '"+targetDefinitionLocation+"' did not changed since previous generation, we did not overwrote it.", null));
		}
		
		return ret;
	}

	private boolean hasContentDifferencesOtherThanSequenceNumber(URI targetDefinitionLocation, String xml) {
		try {
			File targetDefinition = new File(targetDefinitionLocation.toFileString());
			if (targetDefinition.exists()) {
				String oldXml = Files.toString(targetDefinition, Charsets.UTF_8);
				oldXml = SEQUENCE_NUMBER__PATTERN.matcher(oldXml).replaceFirst("");
				String newXml = SEQUENCE_NUMBER__PATTERN.matcher(xml).replaceFirst("");
				return !oldXml.equals(newXml);
			}
		} catch (IOException e) {
			TargetPlatformBundleActivator.getInstance().getLog().log(new Status(IStatus.ERROR, TargetPlatformBundleActivator.PLUGIN_ID, e.getMessage()));
		}
		return true;
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
