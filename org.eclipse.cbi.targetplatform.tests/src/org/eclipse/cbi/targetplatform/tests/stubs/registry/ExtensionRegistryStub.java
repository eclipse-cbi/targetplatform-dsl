package org.eclipse.cbi.targetplatform.tests.stubs.registry;

import java.io.InputStream;
import java.util.Arrays;
import java.util.ResourceBundle;
import java.util.stream.Stream;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IContributor;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.IRegistryChangeListener;
import org.eclipse.core.runtime.IRegistryEventListener;

import com.google.common.collect.ImmutableList;

public class ExtensionRegistryStub implements IExtensionRegistry {

	private final ImmutableList<IExtensionPoint> extensionPoints;

	public ExtensionRegistryStub(ImmutableList<IExtensionPoint> extensionPoints) {
		this.extensionPoints = extensionPoints;
	}

	@Override
	public void addRegistryChangeListener(IRegistryChangeListener listener, String namespace) {
	}

	@Override
	public void addRegistryChangeListener(IRegistryChangeListener listener) {
	}

	@Override
	public IConfigurationElement[] getConfigurationElementsFor(String extensionPointId) {
		return extensionPoints.stream()
			.filter(e -> e.getUniqueIdentifier().equals(extensionPointId))
			.map(IExtensionPoint::getConfigurationElements)
			.toArray(s -> new IConfigurationElement[s]);
	}

	@Override
	public IConfigurationElement[] getConfigurationElementsFor(String namespace, String extensionPointName) {
		return getConfigurationElementsFor(namespace + "." + extensionPointName);
	}

	@Override
	public IConfigurationElement[] getConfigurationElementsFor(String namespace, String extensionPointName, String extensionId) {
		return extensionPoints.stream()
				.filter(e -> e.getUniqueIdentifier().equals(namespace + "." + extensionPointName))
				.map(e -> e.getExtension(extensionId))
				.map(IExtension::getConfigurationElements)
				.toArray(s -> new IConfigurationElement[s]);
	}

	@Override
	public IExtension getExtension(String extensionId) {
		return extensionPoints.stream()
				.flatMap(e -> Arrays.stream(e.getExtensions()))
				.filter(e -> e.getUniqueIdentifier().equals(extensionId))
				.findFirst()
				.orElse(null);
	}

	@Override
	public IExtension getExtension(String extensionPointId, String extensionId) {
		return extensionPoints.stream()
				.filter(e -> e.getUniqueIdentifier().equals(extensionPointId))
				.map(e -> e.getExtension(extensionId))
				.findFirst()
				.orElse(null);
	}

	@Override
	public IExtension getExtension(String namespace, String extensionPointName, String extensionId) {
		return getExtension(namespace + "." + extensionPointName, extensionId);
	}

	@Override
	public IExtensionPoint getExtensionPoint(String extensionPointId) {
		return extensionPoints.stream()
				.filter(e -> e.getUniqueIdentifier().equals(extensionPointId))
				.findFirst()
				.orElse(null);
	}

	@Override
	public IExtensionPoint getExtensionPoint(String namespace, String extensionPointName) {
		return getExtensionPoint(namespace + "." + extensionPointName);
	}

	@Override
	public IExtensionPoint[] getExtensionPoints() {
		return extensionPoints.toArray(new IExtensionPoint[0]);
	}

	@Override
	public IExtensionPoint[] getExtensionPoints(String namespace) {
		return extensionPoints.stream()
				.filter(e -> e.getNamespaceIdentifier().equals(namespace))
				.toArray(s -> new IExtensionPoint[s]);
	}

	@Override
	public IExtensionPoint[] getExtensionPoints(IContributor contributor) {
		return extensionPoints.stream()
				.filter(e -> e.getContributor().getName().equals(contributor.getName()))
				.toArray(s -> new IExtensionPoint[s]);
	}

	@Override
	public IExtension[] getExtensions(String namespace) {
		return extensionPoints.stream()
				.flatMap(e -> Arrays.stream(e.getExtensions()))
				.filter(e -> e.getNamespaceIdentifier().equals(namespace))
				.toArray(s -> new IExtension[s]);
	}

	@Override
	public IExtension[] getExtensions(IContributor contributor) {
		return extensionPoints.stream()
				.flatMap(e -> Arrays.stream(e.getExtensions()))
				.filter(e -> e.getContributor().getName().equals(contributor.getName()))
				.toArray(s -> new IExtension[s]);
	}

	@Override
	public String[] getNamespaces() {
		return Stream.concat(
				extensionPoints.stream()
					.map(IExtensionPoint::getNamespaceIdentifier), 
				extensionPoints.stream()
					.flatMap(e -> Arrays.stream(e.getExtensions()))
					.map(IExtension::getNamespaceIdentifier)
			).distinct()
		.toArray(s -> new String[s]);
	}

	@Override
	public void removeRegistryChangeListener(IRegistryChangeListener listener) {
	}

	@Override
	public boolean addContribution(InputStream is, IContributor contributor, boolean persist, String name, ResourceBundle translationBundle, Object token) throws IllegalArgumentException {
		return false;
	}

	@Override
	public boolean removeExtension(IExtension extension, Object token) throws IllegalArgumentException {
		return false;
	}

	@Override
	public boolean removeExtensionPoint(IExtensionPoint extensionPoint, Object token) throws IllegalArgumentException {
		return false;
	}

	@Override
	public void stop(Object token) throws IllegalArgumentException {
	}

	@Override
	public void addListener(IRegistryEventListener listener) {
	}

	@Override
	public void addListener(IRegistryEventListener listener, String extensionPointId) {
	}

	@Override
	public void removeListener(IRegistryEventListener listener) {
	}

	@Override
	public boolean isMultiLanguage() {
		return false;
	}

}
