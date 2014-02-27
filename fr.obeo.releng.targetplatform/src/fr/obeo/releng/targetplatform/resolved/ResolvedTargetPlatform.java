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
import java.util.Set;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.equinox.p2.core.ProvisionException;
import org.eclipse.equinox.p2.repository.metadata.IMetadataRepositoryManager;

import com.google.common.base.Function;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimaps;
import com.google.common.collect.Sets;

import fr.obeo.releng.targetplatform.targetplatform.IU;
import fr.obeo.releng.targetplatform.targetplatform.IncludeDeclaration;
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
		
		ImmutableListMultimap<String, Location> locationIndex = getLocationIndex(targetPlatform);
		
		for (String locationUri : locationIndex.keySet()) {
			for (Location location : locationIndex.get(locationUri)) {
				List<UnresolvedIU> ius = Lists.newArrayList();
				EList<IU> iuList = location.getIus();
				for (IU iu : iuList) {
					ius.add(new UnresolvedIU(iu.getID(), Strings.emptyToNull(iu.getVersion())));
				}
				
				EnumSet<Option> locOptions = getOptionSet(location.getOptions());
				ResolvedLocation resolvedLocation = new ResolvedLocation(location.getID(), location.getUri(), ius, locOptions);
				locations.add(resolvedLocation);
			}
		}
		
		final EnumSet<Option> options = getOptionSet(targetPlatform.getOptions());
		return new ResolvedTargetPlatform(targetPlatform.getName(), locations, options);
	}

	private static ImmutableListMultimap<String, Location> getLocationIndex(TargetPlatform targetPlatform) {
		List<Location> locationList = targetPlatform.getLocations();
		ImmutableListMultimap<String, Location> locationIndex = Multimaps.index(locationList, new Function<Location, String>() {
			@Override
			public String apply(Location input) {
				return input.getUri();
			}
		});
		
		Set<TargetPlatform> importedTargetPlatforms = getImportedTargetPlatforms(targetPlatform);
		
		for (TargetPlatform importedTargetPlatform : importedTargetPlatforms) {
			for (Location location : importedTargetPlatform.getLocations()) {
				locationIndex.put(location.getUri(), location);
			}
		}
		return locationIndex;
	}

	private static Set<TargetPlatform> getImportedTargetPlatforms(TargetPlatform targetPlatform) {
		Set<TargetPlatform> ret = Sets.newLinkedHashSet();
		getImportedTargetPlatforms(targetPlatform, targetPlatform, ret);
		return ret;
	}
	
	private static Set<TargetPlatform> getImportedTargetPlatforms(TargetPlatform initialTargetPlatform, TargetPlatform targetPlatform, Set<TargetPlatform> visited) {
		ResourceSet resourceSet = getResourceSet(targetPlatform);
		if (resourceSet != null) {
			for (IncludeDeclaration include : targetPlatform.getIncludes()) {
				visitIncludeDeclaration(initialTargetPlatform, resourceSet, include, visited);
			}
		}
		return visited;
	}

	private static void visitIncludeDeclaration(TargetPlatform initialTargetPlatform, ResourceSet resourceSet, IncludeDeclaration include, Set<TargetPlatform> visited) {
		TargetPlatform importedTargetPlatform = getImportedTargetPlatform(resourceSet, include);
		if (visited.contains(importedTargetPlatform)) {
			throw new IllegalStateException("There is a dependency cycle between imported target platform from " + initialTargetPlatform.eResource().getURI());
		}
		if (importedTargetPlatform != null) {
			visited.add(importedTargetPlatform);
			getImportedTargetPlatforms(initialTargetPlatform, importedTargetPlatform, visited);
		}
	}

	private static ResourceSet getResourceSet(TargetPlatform targetPlatform) {
		ResourceSet resourceSet = null;
		
		Resource eResource = targetPlatform.eResource();
		if (eResource != null) {
			resourceSet = eResource.getResourceSet();
		}
		return resourceSet;
	}

	private static TargetPlatform getImportedTargetPlatform(ResourceSet resourceSet, IncludeDeclaration include) {
		TargetPlatform ret = null;
		URI importURI = URI.createURI(include.getImportURI());
		Resource resource = resourceSet.getResource(importURI, true);
		if (resource != null && !resource.getContents().isEmpty()) {
			EObject root = resource.getContents().get(0);
			if (root instanceof TargetPlatform) {
				ret = (TargetPlatform) root;
			}
		}
		return ret;
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