/**
 * Copyright (c) 2012-2014 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 */
package fr.obeo.releng.targetplatform.tests;

import java.util.Collection;
import java.util.Collections;
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
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Pair;

@SuppressWarnings("all")
public class MockIU implements IInstallableUnit {
  private final String id;
  
  private final Version version;
  
  private final Map<String, String> properties;
  
  public MockIU(final String id, final Version version) {
    this(id, version, null);
  }
  
  public MockIU(final String id, final Version version, final Map<String, String> properties) {
    this.id = id;
    this.version = version;
    this.properties = properties;
  }
  
  public static MockIU createBundle(final String id, final Version version) {
    return new MockIU(id, version);
  }
  
  public static MockIU createFeature(final String id, final Version version) {
    Pair<String, String> _mappedTo = Pair.<String, String>of("org.eclipse.equinox.p2.type.group", "true");
    return new MockIU(id, version, Collections.<String, String>unmodifiableMap(CollectionLiterals.<String, String>newHashMap(_mappedTo)));
  }
  
  @Override
  public Collection<IArtifactKey> getArtifacts() {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  public ICopyright getCopyright() {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  public ICopyright getCopyright(final String locale) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  public IMatchExpression<IInstallableUnit> getFilter() {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  public Collection<IInstallableUnitFragment> getFragments() {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  public Collection<ILicense> getLicenses() {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  public Collection<ILicense> getLicenses(final String locale) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  public Collection<IRequirement> getMetaRequirements() {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  public Map<String, String> getProperties() {
    return this.properties;
  }
  
  @Override
  public String getProperty(final String key) {
    return this.properties.get(key);
  }
  
  @Override
  public String getProperty(final String key, final String locale) {
    return this.getProperty(key);
  }
  
  @Override
  public Collection<IProvidedCapability> getProvidedCapabilities() {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  public Collection<IRequirement> getRequirements() {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  public Collection<ITouchpointData> getTouchpointData() {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  public ITouchpointType getTouchpointType() {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  public IUpdateDescriptor getUpdateDescriptor() {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  public boolean isResolved() {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  public boolean isSingleton() {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  public boolean satisfies(final IRequirement candidate) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  public IInstallableUnit unresolved() {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  public String getId() {
    return this.id;
  }
  
  @Override
  public Version getVersion() {
    return this.version;
  }
  
  @Override
  public int compareTo(final IInstallableUnit arg0) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
}
