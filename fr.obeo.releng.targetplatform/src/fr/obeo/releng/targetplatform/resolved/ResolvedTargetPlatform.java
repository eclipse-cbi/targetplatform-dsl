/*******************************************************************************
 * Copyright (c) 2012-2014 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Mikael Barbero (Obeo) - initial API and implementation
 *******************************************************************************/
package fr.obeo.releng.targetplatform.resolved;
import java.net.URISyntaxException;
import java.util.EnumSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

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

import fr.obeo.releng.targetplatform.IU;
import fr.obeo.releng.targetplatform.Location;
import fr.obeo.releng.targetplatform.Option;
import fr.obeo.releng.targetplatform.TargetPlatform;
import fr.obeo.releng.targetplatform.util.LocationIndexBuilder;


public class ResolvedTargetPlatform {
	private final List<ResolvedLocation> locations;
	private final String name;
	private final EnumSet<Option> options;
	private final Environment environment;

	public ResolvedTargetPlatform(String name, List<ResolvedLocation> locations, EnumSet<Option> options, Environment environment) {
		this.name = name;
		this.locations = locations;
		this.options = options;
		this.environment = environment;
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
	
	public Environment getEnvironment() {
		return environment;
	}
	
	public Diagnostic resolve(IMetadataRepositoryManager metadataRepositoryManager, IProgressMonitor monitor) {
		BasicDiagnostic ret = new BasicDiagnostic();
		SubMonitor subMonitor = SubMonitor.convert(monitor, getLocations().size());
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
		return ret;
	}
	
	public static ResolvedTargetPlatform create(TargetPlatform targetPlatform, LocationIndexBuilder indexBuilder) throws URISyntaxException {
		Preconditions.checkArgument(targetPlatform != null);
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
			ResolvedLocation resolvedLocation = new ResolvedLocation(firstLocation.getID(), firstLocation.getCompositeUri().computeActualString(), ius, getOptionSet(firstLocation.getOptions()));
			locations.addFirst(resolvedLocation);
		}
		
		final EnumSet<Option> options = getOptionSet(targetPlatform.getOptions());
		return new ResolvedTargetPlatform(targetPlatform.getName(), locations, options, Environment.create(targetPlatform));
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
			final fr.obeo.releng.targetplatform.Environment env = targetPlatform.getEnvironment();
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