/**
 * Copyright (c) 2012 Obeo and others.
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
 */
package org.eclipse.cbi.targetplatform.tests.stubs.p2;

import java.util.Collection;
import java.util.Map;

import org.eclipse.equinox.p2.metadata.IArtifactKey;
import org.eclipse.equinox.p2.metadata.ICopyright;
import org.eclipse.equinox.p2.metadata.IInstallableUnit;
import org.eclipse.equinox.p2.metadata.IInstallableUnitFragment;
import org.eclipse.equinox.p2.metadata.ILicense;
import org.eclipse.equinox.p2.metadata.IProvidedCapability;
import org.eclipse.equinox.p2.metadata.IRequirement;
import org.eclipse.equinox.p2.metadata.ITouchpointData;
import org.eclipse.equinox.p2.metadata.ITouchpointType;
import org.eclipse.equinox.p2.metadata.IUpdateDescriptor;
import org.eclipse.equinox.p2.metadata.Version;
import org.eclipse.equinox.p2.metadata.expression.IMatchExpression;

import com.google.common.collect.ImmutableMap;

public class IUStub implements IInstallableUnit {

	private final String id;
	private final Version version;
	private final Map<String, String> properties;
	
	IUStub(String id, Version version) {
		this(id, version, null);
	}
	
	IUStub(String id, Version version, Map<String, String> properties) {
		this.id = id;
		this.version = version;
		this.properties = properties;
	}
	
	public static IInstallableUnit createBundle(String id, Version version) {
		return new IUStub(id, version);
	}
	
	public static IInstallableUnit createFeature(String id, Version version) {
		return new IUStub(id, version, ImmutableMap.of("org.eclipse.equinox.p2.type.group", "true"));
	}
	
	@Override
	public String getId() {
		return id;
	}

	@Override
	public Version getVersion() {
		return version;
	}

	@Override
	public int compareTo(IInstallableUnit o) {
		return 0;
	}

	@Override
	public Collection<IArtifactKey> getArtifacts() {
		return null;
	}

	@Override
	public IMatchExpression<IInstallableUnit> getFilter() {
		return null;
	}

	@Override
	public Collection<IInstallableUnitFragment> getFragments() {
		return null;
	}

	@Override
	public Map<String, String> getProperties() {
		return properties;
	}

	@Override
	public String getProperty(String key) {
		return properties.get(key);
	}

	@Override
	public String getProperty(String key, String locale) {
		return getProperty(key);
	}

	@Override
	public Collection<IProvidedCapability> getProvidedCapabilities() {
		return null;
	}

	@Override
	public Collection<IRequirement> getRequirements() {
		return null;
	}

	@Override
	public Collection<IRequirement> getMetaRequirements() {
		return null;
	}

	@Override
	public Collection<ITouchpointData> getTouchpointData() {
		return null;
	}

	@Override
	public ITouchpointType getTouchpointType() {
		return null;
	}

	@Override
	public boolean isResolved() {
		return false;
	}

	@Override
	public boolean isSingleton() {
		return false;
	}

	@Override
	public boolean satisfies(IRequirement candidate) {
		return false;
	}

	@Override
	public IInstallableUnit unresolved() {
		return null;
	}

	@Override
	public IUpdateDescriptor getUpdateDescriptor() {
		return null;
	}

	@Override
	public Collection<ILicense> getLicenses() {
		return null;
	}

	@Override
	public Collection<ILicense> getLicenses(String locale) {
		return null;
	}

	@Override
	public ICopyright getCopyright() {
		return null;
	}

	@Override
	public ICopyright getCopyright(String locale) {
		return null;
	}

}
