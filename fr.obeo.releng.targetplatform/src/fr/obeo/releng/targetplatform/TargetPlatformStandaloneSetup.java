
package fr.obeo.releng.targetplatform;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class TargetPlatformStandaloneSetup extends TargetPlatformStandaloneSetupGenerated{

	public static void doSetup() {
		new TargetPlatformStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}

