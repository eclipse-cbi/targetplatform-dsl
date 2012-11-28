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
package fr.obeo.releng.targetplatform.resolved;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.equinox.p2.core.ProvisionException;
import org.eclipse.equinox.p2.metadata.IInstallableUnit;
import org.eclipse.equinox.p2.repository.metadata.IMetadataRepository;
import org.eclipse.equinox.p2.repository.metadata.IMetadataRepositoryManager;

import fr.obeo.releng.targetplatform.Option;


public class ResolvedLocation {
	private final URI uri;
	private final List<ResolvedIU> latestIUs;
	private final EnumSet<Option> options;

	public ResolvedLocation(String uri, List<ResolvedIU> latestIUs, EnumSet<Option> options) throws URISyntaxException {
		this(new URI(uri), latestIUs, options);
	}

	public ResolvedLocation(URI uri, List<ResolvedIU> latestIUs, EnumSet<Option> options) {
		this.uri = uri;
		this.latestIUs = latestIUs;
		this.options = options;
	}
	
	public List<IInstallableUnit>  getIUToBeInstalled(IMetadataRepositoryManager metadataRepositoryManager, IProgressMonitor monitor) throws ProvisionException, OperationCanceledException {
		SubMonitor subMonitor = SubMonitor.convert(monitor, 100);
		final List<IInstallableUnit> ret = new ArrayList<IInstallableUnit>();
		final IMetadataRepository metadataRepository = metadataRepositoryManager.loadRepository(uri, subMonitor.newChild(60));
		
		SubMonitor loopMonitor = subMonitor.newChild(40).setWorkRemaining(latestIUs.size());
		for (ResolvedIU iu : latestIUs) {
			Set<IInstallableUnit> results = metadataRepository.query(iu.getQuery(), loopMonitor.newChild(1)).toUnmodifiableSet();
			if (!results.isEmpty()) {
				ret.add(results.iterator().next());
			} else {
				System.err.println("No IU found for " + iu.getID() + ";version=\"" + iu.getVersionRange() +"\"");
			}
		}
		
		return ret;
	}
	
	public URI getURI() {
		return uri;
	}
	
	public List<ResolvedIU> getLatestIUs() {
		return latestIUs;
	}
	
	/**
	 * @return the options
	 */
	public EnumSet<Option> getOptions() {
		return options;
	}
}