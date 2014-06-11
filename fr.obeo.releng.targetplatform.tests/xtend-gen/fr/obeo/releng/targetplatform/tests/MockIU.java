package fr.obeo.releng.targetplatform.tests;

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

@SuppressWarnings("all")
public class MockIU implements IInstallableUnit {
  private final String id;
  
  private final Version version;
  
  public MockIU(final String id, final Version version) {
    this.id = id;
    this.version = version;
  }
  
  public Collection<IArtifactKey> getArtifacts() {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  public ICopyright getCopyright() {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  public ICopyright getCopyright(final String locale) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  public IMatchExpression<IInstallableUnit> getFilter() {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  public Collection<IInstallableUnitFragment> getFragments() {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  public Collection<ILicense> getLicenses() {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  public Collection<ILicense> getLicenses(final String locale) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  public Collection<IRequirement> getMetaRequirements() {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  public Map<String, String> getProperties() {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  public String getProperty(final String key) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  public String getProperty(final String key, final String locale) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  public Collection<IProvidedCapability> getProvidedCapabilities() {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  public Collection<IRequirement> getRequirements() {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  public Collection<ITouchpointData> getTouchpointData() {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  public ITouchpointType getTouchpointType() {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  public IUpdateDescriptor getUpdateDescriptor() {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  public boolean isResolved() {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  public boolean isSingleton() {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  public boolean satisfies(final IRequirement candidate) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  public IInstallableUnit unresolved() {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  public String getId() {
    return this.id;
  }
  
  public Version getVersion() {
    return this.version;
  }
  
  public int compareTo(final IInstallableUnit arg0) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
}
