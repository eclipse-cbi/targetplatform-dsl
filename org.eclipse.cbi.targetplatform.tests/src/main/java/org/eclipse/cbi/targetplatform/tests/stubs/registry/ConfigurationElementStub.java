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
package org.eclipse.cbi.targetplatform.tests.stubs.registry;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IContributor;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.InvalidRegistryObjectException;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

public class ConfigurationElementStub implements IConfigurationElement {

	private static final IConfigurationElement[] ICONFIGURATION_ELEMENTS__EMPTY_ARRAY = new IConfigurationElement[0];
	private final boolean valid;
	private final String name;
	private final IExtension declaringExtension;
	private final String namespaceIdentifier;
	private final IConfigurationElement parentElement;
	private final ImmutableMap<String, String> attributes;
	private final String value;
	ImmutableList<ConfigurationElementStub> children;

	public ConfigurationElementStub(String name, String namespaceIdentifier, IExtension declaringExtension, IConfigurationElement parentElement, ImmutableMap<String, String> attributes, String value, boolean valid) {
		this.name = name;
		this.namespaceIdentifier = namespaceIdentifier;
		this.declaringExtension = declaringExtension;
		this.parentElement = parentElement;
		this.attributes = attributes;
		this.value = value;
		this.valid = valid;
	}

	@Override
	public Object createExecutableExtension(String propertyName) throws CoreException {
		throw new UnsupportedOperationException();
	}

	@Override
	public String getAttribute(String name) throws InvalidRegistryObjectException {
		return attributes.get(name);
	}

	@Override
	public String getAttribute(String attrName, String locale) throws InvalidRegistryObjectException {
		return attributes.get(name);
	}

	@Override
	public String getAttributeAsIs(String name) throws InvalidRegistryObjectException {
		return attributes.get(name);
	}

	@Override
	public String[] getAttributeNames() throws InvalidRegistryObjectException {
		return attributes.keySet().toArray(new String[0]);
	}

	@Override
	public IConfigurationElement[] getChildren() throws InvalidRegistryObjectException {
		return children.toArray(ICONFIGURATION_ELEMENTS__EMPTY_ARRAY);
	}

	@Override
	public IConfigurationElement[] getChildren(String name) throws InvalidRegistryObjectException {
		return children.stream().filter(c -> c.getName().equals(name)).toArray(s -> new IConfigurationElement[s]);
	}

	@Override
	public IExtension getDeclaringExtension() throws InvalidRegistryObjectException {
		return declaringExtension;
	}

	@Override
	public String getName() throws InvalidRegistryObjectException {
		return name;
	}

	@Override
	public Object getParent() throws InvalidRegistryObjectException {
		return parentElement != null ? parentElement : declaringExtension;
	}

	@Override
	public String getValue() throws InvalidRegistryObjectException {
		return value;
	}

	@Override
	public String getValue(String locale) throws InvalidRegistryObjectException {
		return value;
	}

	@Override
	public String getValueAsIs() throws InvalidRegistryObjectException {
		return value;
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
		return getDeclaringExtension().getContributor();
	}

	@Override
	public boolean isValid() {
		return valid;
	}

	//@Override (since 4.8) 
	public int getHandleId() {
		return 0;
	}
	
	public static Builder builder() {
		return new Builder().valid(true);
	}
	
	public static class Builder {
		private boolean valid;
		private String name;
		private IExtension declaringExtension;
		private String namespaceIdentifier;
		private List<ConfigurationElementStub.Builder> children = new ArrayList<>();
		private ConfigurationElementStub parentElement;
		private ImmutableMap.Builder<String, String> attributes = ImmutableMap.builder();
		private String value;

		public Builder valid(boolean valid) {
			this.valid = valid;
			return this;
		}
		public Builder name(String name) {
			this.name = name;
			return this;
		}
		public Builder declaringExtension(IExtension declaringExtension) {
			this.declaringExtension = declaringExtension;
			return this;
		}
		public Builder namespaceIdentifier(String namespaceIdentifier) {
			this.namespaceIdentifier = namespaceIdentifier;
			return this;
		}
		Builder parent(ConfigurationElementStub parentElement) {
			this.parentElement = parentElement;
			return this;
		}
		public Builder addChild(ConfigurationElementStub.Builder child) {
			children.add(child);
			return this;
		}
		public Builder addAttribute(String name, String value) {
			attributes.put(name, value);
			return this;
		}
		public Builder value(String value) {
			this.value = value;
			return this;
		}
		
		public ConfigurationElementStub build() {
			ConfigurationElementStub stub = new ConfigurationElementStub(name, namespaceIdentifier, declaringExtension, parentElement, attributes.build(), value, valid);
			stub.children = ImmutableList.copyOf(children.stream().map(e -> e.parent(stub).build()).iterator());
			return stub;
		}
	}
}
