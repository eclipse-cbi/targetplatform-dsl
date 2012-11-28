package fr.obeo.releng.targetplatform.pde;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.Constants;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.util.StringInputStream;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.name.Named;

class ParseHelper<T extends EObject> {

	@Inject
	private Provider<XtextResourceSet> resourceSetProvider;

	@Inject
	private IResourceFactory resourceFactory;

	@Inject
	@Named(Constants.FILE_EXTENSIONS)
	public String fileExtension;

	public T parse(InputStream in, URI uriToUse, Map<?, ?> options) {
		return parse(in, uriToUse, options, resourceSetProvider.get());
	}
	
	@SuppressWarnings("unchecked")
	public T parse(InputStream in, URI uriToUse, Map<?, ?> options, ResourceSet resourceSet) {
		Resource resource = resourceFactory.createResource(uriToUse);
		resourceSet.getResources().add(resource);
		try {
			resource.load(in, options);
			final T root = (T) (resource.getContents().isEmpty() ? null : resource.getContents().get(0));
			return root;
		} catch (IOException e) {
			throw new WrappedException(e);
		}
	}

	public T parse(CharSequence text) throws Exception {
		return parse(text, resourceSetProvider.get());
	}

	public T parse(CharSequence text, ResourceSet resourceSetToUse) throws Exception {
		return parse(getAsStream(text), computeUnusedUri(resourceSetToUse), null, resourceSetToUse);
	}

	public T parse(CharSequence text, URI uriToUse, ResourceSet resourceSetToUse) throws Exception {
		return parse(getAsStream(text), uriToUse, null, resourceSetToUse);
	}

	protected URI computeUnusedUri(ResourceSet resourceSet) {
		String name = "__synthetic";
		for (int i = 0; i < Integer.MAX_VALUE; i++) {
			URI syntheticUri = URI.createURI(name + i + "." + fileExtension);
			if (resourceSet.getResource(syntheticUri, false) == null)
				return syntheticUri;
		}
		throw new IllegalStateException();
	}

	protected InputStream getAsStream(CharSequence text) {
		return new StringInputStream(text == null ? "" : text.toString());
	}

}