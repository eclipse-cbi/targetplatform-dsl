package fr.obeo.releng.targetplatform.ui.tests;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

public class Activator extends AbstractUIPlugin {

	public static AbstractUIPlugin getInstance() {
		return INSTANCE;
	}

	private static Activator INSTANCE;

	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		INSTANCE = this;
	}
}