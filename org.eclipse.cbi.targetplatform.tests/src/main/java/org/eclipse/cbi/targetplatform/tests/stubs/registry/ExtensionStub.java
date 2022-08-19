/*******************************************************************************
 * Copyright (c) 2012 Obeo and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Mikael Barbero (Obeo) - initial API and implementation
 *******************************************************************************/
package org.eclipse.cbi.targetplatform.tests.stubs.registry;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IContributor;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.InvalidRegistryObjectException;

import com.google.common.collect.ImmutableList;

public final class ExtensionStub implements IExtension {

	private static final IConfigurationElement[] ICONFIGURATION_ELEMENT__EMPTY_ARRAY = new IConfigurationElement[0];
	private final IExtensionPoint extensionPoint;
	private final String namespaceIdentifier;
	private final IContributor contributor;
	private final String label;
	private final boolean valid;
	private final String id;
	ImmutableList<IConfigurationElement> configurationElements;

	ExtensionStub(IExtensionPoint extensionPoint, String id, String namespaceIdentifier, IContributor contributor, String label, boolean valid) {
		this.extensionPoint = extensionPoint;
		this.id = id;
		this.namespaceIdentifier = namespaceIdentifier;
		this.contributor = contributor;
		this.label = label;
		this.valid = valid;
	}
	
	@Override
	public IConfigurationElement[] getConfigurationElements() throws InvalidRegistryObjectException {
		return configurationElements.toArray(ICONFIGURATION_ELEMENT__EMPTY_ARRAY);
	}

	@Override
	public String getNamespace() throws InvalidRegistryObjectException {
		return getContributor().getName();
	}

	@Override
	public String getNamespaceIdentifier() throws InvalidRegistryObjectException {
		return namespaceIdentifier;
	}

	@Override
	public IContributor getContributor() throws InvalidRegistryObjectException {
		return contributor;
	}

	@Override
	public String getExtensionPointUniqueIdentifier() throws InvalidRegistryObjectException {
		return extensionPoint.getUniqueIdentifier();
	}

	@Override
	public String getLabel() throws InvalidRegistryObjectException {
		return label;
	}

	@Override
	public String getLabel(String locale) throws InvalidRegistryObjectException {
		return label;
	}

	@Override
	public String getSimpleIdentifier() throws InvalidRegistryObjectException {
		return id;
	}

	@Override
	public String getUniqueIdentifier() throws InvalidRegistryObjectException {
		return getNamespaceIdentifier() + "." + getSimpleIdentifier();
	}

	@Override
	public boolean isValid() {
		return valid;
	}
	
	public static Builder builder() {
		return new Builder()
				.valid(true)
				.contributor(ExtensionStub.class.getPackage().getName())
				.label(ExtensionStub.class.getSimpleName());
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(configurationElements, contributor, extensionPoint, id, label, namespaceIdentifier, valid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof ExtensionStub)) {
			return false;
		}
		ExtensionStub other = (ExtensionStub) obj;
		return Objects.equals(configurationElements, other.configurationElements) 
				&& Objects.equals(contributor, other.contributor)
				&& Objects.equals(extensionPoint, other.extensionPoint)
				&& Objects.equals(id, other.id)
				&& Objects.equals(label, other.label)
				&& Objects.equals(namespaceIdentifier, other.namespaceIdentifier)
				&& Objects.equals(valid, other.valid);
	}

	public static class Builder {
		private IExtensionPoint extensionPoint;
		private String namespaceIdentifier;
		private String contributorName;
		private String label;
		private boolean valid;
		private String id;
		private List<ConfigurationElementStub.Builder> configurationElements = new ArrayList<>();
		
		public Builder label(String label) {
			this.label = label;
			return this;
		}
		Builder extensionPoint(IExtensionPoint extensionPoint) {
			this.extensionPoint = extensionPoint;
			return this;
		}
		public Builder namespaceIdentifier(String namespaceIdentifier) {
			this.namespaceIdentifier = namespaceIdentifier;
			return this;
		}
		public Builder contributor(String contributorName) {
			this.contributorName = contributorName;
			return this;
		}
		public Builder valid(boolean valid) {
			this.valid = valid;
			return this;
		}
		public Builder addConfigurationElement(ConfigurationElementStub.Builder configurationElement) {
			configurationElements.add(configurationElement);
			return this;
		}
		public Builder id(String id) {
			this.id = id;
			return this;
		}
		public ExtensionStub build() {
			if (namespaceIdentifier == null || namespaceIdentifier.isEmpty()) {
				namespaceIdentifier = contributorName;
			}
			ExtensionStub stub = new ExtensionStub(extensionPoint, id, namespaceIdentifier, () -> contributorName, label, valid);
			stub.configurationElements = ImmutableList.copyOf(configurationElements.stream().map(e -> e.declaringExtension(stub).build()).iterator());
			return stub;
		}
	}

}
