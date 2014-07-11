package fr.obeo.releng.targetplatform.resource;

import org.eclipse.xtext.resource.XtextResourceSet;

public class XtextResourceSetWithB3aggrSupport extends XtextResourceSet {

	public XtextResourceSetWithB3aggrSupport() {
		super();
		/*
		 * add support for b3aggr models
		 */
		getResourceFactoryRegistry().getExtensionToFactoryMap().put(
				"b3aggrcon", new B3AggrConResourceFactory());
		getResourceFactoryRegistry().getExtensionToFactoryMap().put("b3aggr",
				new B3AggrConResourceFactory());
	}
}
