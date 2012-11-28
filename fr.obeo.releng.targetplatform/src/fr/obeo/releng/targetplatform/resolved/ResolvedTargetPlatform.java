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
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.common.util.EList;

import com.google.common.base.Strings;

import fr.obeo.releng.targetplatform.IU;
import fr.obeo.releng.targetplatform.Location;
import fr.obeo.releng.targetplatform.Option;
import fr.obeo.releng.targetplatform.TargetPlatform;


public class ResolvedTargetPlatform {
	private final List<ResolvedLocation> locations;
	private final String name;

	public ResolvedTargetPlatform(String name, List<ResolvedLocation> locations) {
		this.name = name;
		this.locations = locations;
	}
	
	public List<ResolvedLocation> getLocations() {
		return locations;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	public static ResolvedTargetPlatform resolve(TargetPlatform targetPlatform, IProgressMonitor monitor) throws URISyntaxException {
		List<ResolvedLocation> locations = new ArrayList<ResolvedLocation>();
		EList<Location> locationList = targetPlatform.getLocations();
		SubMonitor subMonitor = SubMonitor.convert(monitor, locationList.size());
		for (Location location : locationList) {
			List<ResolvedIU> ius = new ArrayList<ResolvedIU>();
			EList<IU> iuList = location.getIus();
			for (IU iu : iuList) {
				ius.add(new ResolvedIU(iu.getID(), Strings.emptyToNull(iu.getVersion())));
			}
			
			final EnumSet<Option> optionSet;
			if (location.getOptions().isEmpty()) {
				optionSet = EnumSet.noneOf(Option.class);
			} else {
				optionSet = EnumSet.copyOf(location.getOptions());
			}
			
			locations.add(new ResolvedLocation(location.getUri(), ius, optionSet));
			subMonitor.worked(1);
		}
		return new ResolvedTargetPlatform(targetPlatform.getName(), locations);
	}
}