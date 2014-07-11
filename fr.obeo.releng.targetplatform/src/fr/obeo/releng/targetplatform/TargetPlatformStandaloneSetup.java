
package fr.obeo.releng.targetplatform;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;

import com.google.inject.Injector;

import fr.obeo.releng.targetplatform.resource.B3AggrConResourceFactory;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class TargetPlatformStandaloneSetup extends TargetPlatformStandaloneSetupGenerated{

	public static void doSetup() {
		new TargetPlatformStandaloneSetup().createInjectorAndDoEMFRegistration();
		/*
		 * add support for b3aggr models
		 */
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("b3aggrcon", new B3AggrConResourceFactory());
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("b3aggr", new B3AggrConResourceFactory());
	}
	
	@Override
	public void register(Injector injector) {
		if (!EPackage.Registry.INSTANCE.containsKey(TargetPlatformPackage.eNS_URI)) {
			EPackage.Registry.INSTANCE.put(TargetPlatformPackage.eNS_URI, TargetPlatformPackage.eINSTANCE);
		}
		super.register(injector);
	}
}

