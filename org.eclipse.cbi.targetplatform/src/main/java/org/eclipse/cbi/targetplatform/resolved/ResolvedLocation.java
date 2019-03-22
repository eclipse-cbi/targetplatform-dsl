/*******************************************************************************
 * Copyright (c) 2012-2014 Obeo and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Mikael Barbero (Obeo) - initial API and implementation
 *******************************************************************************/
package org.eclipse.cbi.targetplatform.resolved;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;

import org.eclipse.cbi.targetplatform.TargetPlatformBundleActivator;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.equinox.internal.p2.metadata.InstallableUnit;
import org.eclipse.equinox.p2.core.ProvisionException;
import org.eclipse.equinox.p2.metadata.IInstallableUnit;
import org.eclipse.equinox.p2.metadata.Version;
import org.eclipse.equinox.p2.repository.metadata.IMetadataRepository;
import org.eclipse.equinox.p2.repository.metadata.IMetadataRepositoryManager;

import com.google.common.collect.Lists;

import org.eclipse.cbi.targetplatform.model.Option;


@SuppressWarnings("restriction")
public class ResolvedLocation {
	private final String id;
	private final URI uri;
	private final List<UnresolvedIU> unresolvedIUs;
	private final List<IInstallableUnit> resolvedIUs;
	private final EnumSet<Option> options;

	public ResolvedLocation(String id, String uri, List<UnresolvedIU> unresolvedIUs, EnumSet<Option> options) throws URISyntaxException {
		this(id, new URI(uri), unresolvedIUs, options);
	}

	public ResolvedLocation(String id, URI uri, List<UnresolvedIU> unresolvedIUs, EnumSet<Option> options) {
		this.id = id;
		this.uri = uri;
		this.unresolvedIUs = unresolvedIUs;
		this.resolvedIUs = Lists.newArrayList();
		this.options = options;
	}
	
	public Diagnostic resolve(IMetadataRepositoryManager metadataRepositoryManager, IProgressMonitor monitor) {
		BasicDiagnostic diag = new BasicDiagnostic();
		SubMonitor subMonitor = SubMonitor.convert(monitor, 100);
		
		IMetadataRepository metadataRepository;
		try {
			metadataRepository = metadataRepositoryManager.loadRepository(uri, subMonitor.newChild(80));
			SubMonitor loopMonitor = subMonitor.newChild(20).setWorkRemaining(unresolvedIUs.size());
			for (UnresolvedIU iu : unresolvedIUs) {
				if (monitor.isCanceled()) {
					break;
				}
				Set<IInstallableUnit> results = metadataRepository.query(iu.getQuery(), loopMonitor.newChild(1)).toUnmodifiableSet();
				if (!results.isEmpty()) {
					IInstallableUnit unit =  results.iterator().next();
					if (iu.isLazyRange() && unit instanceof InstallableUnit) {
						((InstallableUnit)unit).setVersion(Version.create("0.0.0"));
					}
					resolvedIUs.add(unit);
				} else {
					String msg = "Error occurred during resolution of '" + uri.toString() + "'. The IU '" + iu.getID() + "' with range constraint '" + iu.getVersionRange() + "' cannot be found.";
					diag.merge(new BasicDiagnostic(Diagnostic.ERROR, TargetPlatformBundleActivator.PLUGIN_ID, -1, msg, new Object[]{this, iu,}));
				}
			}
		} catch (ProvisionException e) {
			diag.merge(BasicDiagnostic.toDiagnostic(e));
		}
		
		return diag;
	}
	
	public URI getURI() {
		return uri;
	}
	
	public String getID() {
		return id;
	}
	
	public List<UnresolvedIU> getUnresolvedIUs() {
		return unresolvedIUs;
	}
	
	public List<IInstallableUnit> getResolvedIUs() {
		return resolvedIUs;
	}
	
	public EnumSet<Option> getOptions() {
		return options;
	}
}