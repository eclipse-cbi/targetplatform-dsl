/**
 * Copyright (c) 2012-2014 Obeo and others.
 *
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Mikael Barbero (Obeo) - initial API and implementation
 *     Hannes Niederhausen (itemis AG) - added maven related code
 */
package org.eclipse.cbi.targetplatform.resolved;
import java.net.URISyntaxException;
import java.util.Collections;
import java.util.EnumSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.cbi.targetplatform.model.IU;
import org.eclipse.cbi.targetplatform.model.Location;
import org.eclipse.cbi.targetplatform.model.Option;
import org.eclipse.cbi.targetplatform.model.TargetPlatform;
import org.eclipse.cbi.targetplatform.util.LocationIndexBuilder;
import org.eclipse.cbi.targetplatform.util.MavenLocationIndexBuilder;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.EList;
import org.eclipse.equinox.p2.repository.metadata.IMetadataRepositoryManager;
import org.eclipse.jdt.launching.JavaRuntime;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;


public class ResolvedTargetPlatform {
	private final List<ResolvedLocation> locations;
	private final List<ResolvedMavenLocation> mavenLocations;
	private final String name;
	private final EnumSet<Option> options;
	private final Environment environment;

	public ResolvedTargetPlatform(String name, List<ResolvedLocation> locations, List<ResolvedMavenLocation> mavenLocations, EnumSet<Option> options, Environment environment) {
		this.name = name;
		this.locations = locations;
		this.options = options;
		this.environment = environment;
		this.mavenLocations=mavenLocations;
	}
	
	public List<ResolvedLocation> getLocations() {
		if (locations==null) {
			return Collections.emptyList();
		}
		return locations;
	}
	
	public String getName() {
		return name;
	}
	
	public List<ResolvedMavenLocation> getMavenLocations() {
		if (mavenLocations==null) {
			return Collections.emptyList();
		}
		return mavenLocations;
	}
	
	public EnumSet<Option> getOptions() {
		return options;
	}
	
	public Environment getEnvironment() {
		return environment;
	}
	
	public Diagnostic resolve(IMetadataRepositoryManager metadataRepositoryManager, IProgressMonitor monitor) {
		BasicDiagnostic ret = new BasicDiagnostic();
		int numOfLocations = getLocations().size()+getMavenLocations().size();
		SubMonitor subMonitor = SubMonitor.convert(monitor, numOfLocations);
		for (ResolvedLocation location : getLocations()) {
			if(subMonitor.isCanceled()) {
				ret.merge(BasicDiagnostic.CANCEL_INSTANCE);
				break;
			}
			Diagnostic diagnostic = location.resolve(metadataRepositoryManager, subMonitor);
			if (diagnostic.getSeverity() >= Diagnostic.WARNING) {
				ret.merge(diagnostic);
			}
			subMonitor.worked(1);
		}
		
		for (ResolvedMavenLocation location : getMavenLocations()) {
			if(subMonitor.isCanceled()) {
				ret.merge(BasicDiagnostic.CANCEL_INSTANCE);
				break;
			}
			Diagnostic diagnostic = location.resolve(subMonitor);
			if (diagnostic.getSeverity() >= Diagnostic.WARNING) {
				ret.merge(diagnostic);
			}
			subMonitor.worked(1);
		}
		
		return ret;
	}
	
	public static ResolvedTargetPlatform create(TargetPlatform targetPlatform, LocationIndexBuilder indexBuilder, MavenLocationIndexBuilder mavenIndexBuilder) throws URISyntaxException {
		Preconditions.checkArgument(targetPlatform != null);
		LinkedList<ResolvedLocation> locations = Lists.newLinkedList();
		
		ListMultimap<String, Location> locationIndex = indexBuilder.getLocationIndex(targetPlatform);
		
		for (String locationUri : locationIndex.keySet()) {
			ResolvedLocation resolvedLocation = resolveLocation(locationIndex, locationUri);
			locations.addFirst(resolvedLocation);
		}
		
		List<ResolvedMavenLocation> mavenLocations = mavenIndexBuilder.getLocationIndex(targetPlatform).values().stream() // 
				.map(ResolvedMavenLocation::new)
				.collect(Collectors.toList());
				
		final EnumSet<Option> options = getOptionSet(targetPlatform.getOptions());
		return new ResolvedTargetPlatform(targetPlatform.getName(), locations, mavenLocations, options, Environment.create(targetPlatform));
	}

	private static ResolvedLocation resolveLocation(ListMultimap<String, Location> locationIndex, String locationUri)
			throws URISyntaxException {
		List<UnresolvedIU> ius = Lists.newArrayList();
		Set<String> ids = Sets.newHashSet();
		List<Location> list = locationIndex.get(locationUri);
		for (Location location : list) { // in reverse order of declaration: overrides seen first
			EList<IU> iuList = location.getIus();
			for (IU iu : iuList) { // in order of declaration
				String idv = iu.getID() + ":" + Strings.nullToEmpty(iu.getVersion());
				if (!ids.contains(idv)) { // neither duplicates (same location), nor redundant overrides (across locations)
					if (iu.getVersion() != null || !ids.contains(iu.getID())) { // can override the unversioned only
						ids.add(idv);
						ids.add(iu.getID());
						ius.add(new UnresolvedIU(iu.getID(), Strings.emptyToNull(iu.getVersion())));
					}
				}
			}
		}
		Location firstLocation = locationIndex.get(locationUri).get(0);
		ResolvedLocation resolvedLocation = new ResolvedLocation(firstLocation.getID(), firstLocation.getUri(), ius, getOptionSet(firstLocation.getOptions()));
		return resolvedLocation;
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
	
	public static class Environment {
		private final String os;
		private final String ws;
		private final String arch;
		private final String nl;
		private final String targetJRE;
		
		public Environment(String os, String ws, String arch, String nl, String targetJRE) {
			this.os = os;
			this.ws = ws;
			this.arch = arch;
			this.nl = nl;
			this.targetJRE = targetJRE;
		}
		
		public static Environment create(TargetPlatform targetPlatform) {
			final org.eclipse.cbi.targetplatform.model.Environment env = targetPlatform.getEnvironment();
			if (env != null) {
				final String os = Strings.emptyToNull(env.getOperatingSystem());
				final String ws = Strings.emptyToNull(env.getWindowingSystem());
				final String arch = Strings.emptyToNull(env.getArchitecture());
				final String jrePath;
				final String nl;
				
				if (env.getLocalization() != null) {
					nl = env.getLocalization().toString();
				} else {
					nl = null;
				}
				
				if (env.getExecutionEnvironment() != null) {
					IPath path = JavaRuntime.newJREContainerPath(env.getExecutionEnvironment());
					if (path != null) {
						jrePath = path.toString();
					} else {
						jrePath = null;
					}
				} else {
					jrePath = null;
				}
				
				return new Environment(os, ws, arch, nl, jrePath);
			} else {
				return null;
			}
		}
		
		public String getOs() {
			return os;
		}

		public String getWs() {
			return ws;
		}

		public String getArch() {
			return arch;
		}

		public String getNl() {
			return nl;
		}

		public String getTargetJRE() {
			return targetJRE;
		}
	}
}
