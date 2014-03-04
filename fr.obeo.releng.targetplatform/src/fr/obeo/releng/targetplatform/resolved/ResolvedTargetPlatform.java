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
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.EList;
import org.eclipse.equinox.p2.core.ProvisionException;
import org.eclipse.equinox.p2.repository.metadata.IMetadataRepositoryManager;

import com.google.common.base.Strings;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import fr.obeo.releng.targetplatform.TargetPlatformBundleActivator;
import fr.obeo.releng.targetplatform.targetplatform.IU;
import fr.obeo.releng.targetplatform.targetplatform.Location;
import fr.obeo.releng.targetplatform.targetplatform.Option;
import fr.obeo.releng.targetplatform.targetplatform.TargetPlatform;
import fr.obeo.releng.targetplatform.util.LocationIndexBuilder;


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
	
	public Diagnostic resolve(IMetadataRepositoryManager metadataRepositoryManager, IProgressMonitor monitor) throws ProvisionException {
		BasicDiagnostic ret = new BasicDiagnostic(TargetPlatformBundleActivator.PLUGIN_ID, -1, "Diagnostic of resolution of '" + name + "'", null);
		SubMonitor subMonitor = SubMonitor.convert(monitor, getLocations().size());
		for (ResolvedLocation location : getLocations()) {
			if(subMonitor.isCanceled()) {
				break;
			}
			Diagnostic d = location.resolve(metadataRepositoryManager, subMonitor);
			ret.add(d);
			subMonitor.worked(1);
		}
		return ret;
	}
	
	public static ResolvedTargetPlatform create(TargetPlatform targetPlatform, LocationIndexBuilder indexBuilder) throws URISyntaxException {
		LinkedList<ResolvedLocation> locations = Lists.newLinkedList();
		
		ListMultimap<String, Location> locationIndex = indexBuilder.getLocationIndex(targetPlatform);
		
		for (String locationUri : locationIndex.keySet()) {
			List<UnresolvedIU> ius = Lists.newArrayList();
			Set<String> ids = Sets.newHashSet();
			List<Location> list = locationIndex.get(locationUri);
			for (Location location : list) {
				EList<IU> iuList = location.getIus();
				for (IU iu : iuList) {
					if (!ids.contains(iu.getID())) {
						ids.add(iu.getID());
						ius.add(new UnresolvedIU(iu.getID(), Strings.emptyToNull(iu.getVersion())));
					}
				}
			}
			Location firstLocation = locationIndex.get(locationUri).get(0);
			ResolvedLocation resolvedLocation = new ResolvedLocation(firstLocation.getID(), firstLocation.getUri(), ius, getOptionSet(firstLocation.getOptions()));
			locations.addFirst(resolvedLocation);
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