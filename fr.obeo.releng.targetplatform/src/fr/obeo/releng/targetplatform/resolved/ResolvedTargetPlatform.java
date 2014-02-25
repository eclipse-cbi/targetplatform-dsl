/*******************************************************************************
 * Copyright (c) 2012-2014 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package fr.obeo.releng.targetplatform.resolved;
import java.net.URISyntaxException;
import java.util.EnumSet;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.equinox.p2.core.ProvisionException;
import org.eclipse.equinox.p2.repository.metadata.IMetadataRepositoryManager;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;

import fr.obeo.releng.targetplatform.targetplatform.IU;
import fr.obeo.releng.targetplatform.targetplatform.Location;
import fr.obeo.releng.targetplatform.targetplatform.Option;
import fr.obeo.releng.targetplatform.targetplatform.TargetPlatform;


public class ResolvedTargetPlatform {
	private final List<ResolvedLocation> locations;
	private final String name;
	private final EnumSet<Option> options;

	public ResolvedTargetPlatform(String name, List<ResolvedLocation> locations, EnumSet<Option> options) {
		this.name = name;
		this.locations = locations;
		this.options = options;
	}
	
	public List<ResolvedLocation> getLocations() {
		return locations;
	}
	
	public String getName() {
		return name;
	}
	
	public EnumSet<Option> getOptions() {
		return options;
	}
	
	public void resolve(IMetadataRepositoryManager metadataRepositoryManager, IProgressMonitor monitor) throws ProvisionException {
		SubMonitor subMonitor = SubMonitor.convert(monitor, getLocations().size());
		for (ResolvedLocation location : getLocations()) {
			location.resolve(metadataRepositoryManager, subMonitor);
			subMonitor.worked(1);
		}
	}
	
	public static ResolvedTargetPlatform create(TargetPlatform targetPlatform) throws URISyntaxException {
		List<ResolvedLocation> locations = Lists.newArrayList();
		EList<Location> locationList = targetPlatform.getLocations();
		
		for (Location location : locationList) {
			List<UnresolvedIU> ius = Lists.newArrayList();
			EList<IU> iuList = location.getIus();
			for (IU iu : iuList) {
				ius.add(new UnresolvedIU(iu.getID(), Strings.emptyToNull(iu.getVersion())));
			}
			
			EnumSet<Option> locOptions = getOptionSet(location.getOptions());
			ResolvedLocation resolvedLocation = new ResolvedLocation(location.getID(), location.getUri(), ius, locOptions);
			locations.add(resolvedLocation);
		}
		
		final EnumSet<Option> options = getOptionSet(targetPlatform.getOptions());
		return new ResolvedTargetPlatform(targetPlatform.getName(), locations, options);
	}

	public static EnumSet<Option> getOptionSet(EList<Option> optionsList) {
		final EnumSet<Option> optionSet;
		if (optionsList.isEmpty()) {
			optionSet = EnumSet.noneOf(Option.class);
		} else {
			optionSet = EnumSet.copyOf(optionsList);
		}
		return optionSet;
	}
}