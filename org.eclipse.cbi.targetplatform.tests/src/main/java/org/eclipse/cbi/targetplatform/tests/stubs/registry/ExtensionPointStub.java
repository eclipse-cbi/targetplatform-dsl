package org.eclipse.cbi.targetplatform.tests.stubs.registry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IContributor;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IPluginDescriptor;
import org.eclipse.core.runtime.InvalidRegistryObjectException;

import com.google.common.collect.ImmutableList;

public final class ExtensionPointStub implements IExtensionPoint {

	private static final IExtension[] IEXTENSION__EMPTY_ARRAY = new IExtension[0];
	private final String namespaceIdentifier;
	private final IContributor contributor;
	private final String id;
	private final String schemaReference;
	private final String label;
	private final boolean valid;
	ImmutableList<IExtension> extensions;

	public ExtensionPointStub(String namespaceIdentifier, String id, IContributor contributor, String schemaReference, String label, boolean valid) {
		this.namespaceIdentifier = namespaceIdentifier;
		this.id = id;
		this.contributor = contributor;
		this.schemaReference = schemaReference;
		this.label = label;
		this.valid = valid;
	}

	@Override
	public IConfigurationElement[] getConfigurationElements() throws InvalidRegistryObjectException {
		return extensions.stream()
				.flatMap(e -> Arrays.stream(e.getConfigurationElements()))
				.toArray(s -> new IConfigurationElement[s]);
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
	public IExtension getExtension(String extensionId) throws InvalidRegistryObjectException {
		return extensions.stream().filter(e -> e.getUniqueIdentifier().equals(extensionId)).findFirst().orElse(null);
	}

	@Override
	public IExtension[] getExtensions() throws InvalidRegistryObjectException {
		return extensions.toArray(IEXTENSION__EMPTY_ARRAY);
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
	public String getSchemaReference() throws InvalidRegistryObjectException {
		return schemaReference;
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
	
	@Override
	public int hashCode() {
		return Objects.hash(id, namespaceIdentifier, schemaReference, valid, contributor, extensions, label);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof ExtensionPointStub)) {
			return false;
		}
		ExtensionPointStub other = (ExtensionPointStub) obj;
		return Objects.equals(id, other.id) 
				&& Objects.equals(contributor, other.contributor)
				&& Objects.equals(schemaReference, other.schemaReference)
				&& Objects.equals(id, other.id)
				&& Objects.equals(extensions, other.extensions)
				&& Objects.equals(label, other.label)
				&& Objects.equals(namespaceIdentifier, other.namespaceIdentifier)
				&& Objects.equals(valid, other.valid);
	}
	
	public static Builder buidler() {
		return new Builder()
				.valid(true)
				.contributor(ExtensionPointStub.class.getPackage().getName())
				.label(ExtensionPointStub.class.getSimpleName());
	}
	
	public static class Builder {
		private String namespaceIdentifier;
		private String id;
		private String contributorName;
		private String schemaReference;
		private String label;
		private boolean valid;
		private List<ExtensionStub.Builder> extensions = new ArrayList<>();
		
		public Builder label(String label) {
			this.label = label;
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
		public Builder schemaReference(String schemaReference) {
			this.schemaReference = schemaReference;
			return this;
		}
		public Builder valid(boolean valid) {
			this.valid = valid;
			return this;
		}
		public Builder addExtension(ExtensionStub.Builder extension) {
			extensions.add(extension);
			return this;
		}
		public Builder id(String id) {
			this.id = id;
			return this;
		}
		public ExtensionPointStub build() {
			if (namespaceIdentifier == null || namespaceIdentifier.isEmpty()) {
				namespaceIdentifier = contributorName;
			}
			ExtensionPointStub stub = new ExtensionPointStub(namespaceIdentifier, id, () -> contributorName, schemaReference, label, valid);
			stub.extensions = ImmutableList.copyOf(extensions.stream().map(e -> e.extensionPoint(stub).build()).iterator());
			return stub;
		}
	}

	public IPluginDescriptor getDeclaringPluginDescriptor() throws InvalidRegistryObjectException {
		return null;
	}

}
