package fr.obeo.releng.targetplatform.tests.util;

import java.net.URI;
import java.util.List;

import org.eclipse.equinox.p2.core.IProvisioningAgent;
import org.eclipse.equinox.p2.metadata.IInstallableUnit;
import org.eclipse.equinox.p2.metadata.Version;

import com.google.common.collect.ImmutableList;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Provider;

import fr.obeo.releng.targetplatform.TargetPlatformInjectorProvider;
import fr.obeo.releng.targetplatform.TargetPlatformStandaloneSetup;
import fr.obeo.releng.targetplatform.tests.IQueryResultProvider;
import fr.obeo.releng.targetplatform.tests.MockIU;
import fr.obeo.releng.targetplatform.tests.MockProvisioningAgent;

public class CustomTargetPlatformInjectorProvider extends TargetPlatformInjectorProvider {
	
	protected Injector internalCreateInjector() {
	    return new TargetPlatformStandaloneSetup() {
	    	public Injector createInjector() {
	    		return Guice.createInjector(new fr.obeo.releng.targetplatform.TargetPlatformRuntimeModule() {
	    			public Provider<org.eclipse.equinox.p2.core.IProvisioningAgent> provideIProvisioningAgent() {
	    				return new Provider<IProvisioningAgent>() {
	    					public IProvisioningAgent get() {
	    						return new MockProvisioningAgent(new IQueryResultProvider<IInstallableUnit>() {
	    							public List<IInstallableUnit> listIUs(URI location) {
	    								if ("location1".equals(location.toString())) {
	    									return ImmutableList.<IInstallableUnit>of(
	    										MockIU.createFeature("org.iu1", Version.createOSGi(1,2,0))
	    									);
	    								} else if ("location2".equals(location.toString())) {
	    									return ImmutableList.<IInstallableUnit>of(
	    										MockIU.createFeature("org.iu1", Version.createOSGi(1,2,0)),
	    										MockIU.createFeature("org.iu2", Version.createOSGi(3,7,72))
	    									);
	    								} else if ("location3".equals(location.toString())) {
	    									return ImmutableList.<IInstallableUnit>of(
	    										MockIU.createFeature("org.iu1", Version.createOSGi(1,2,0)),
	    										MockIU.createFeature("org.iu1", Version.createOSGi(1,2,5)),
	    										MockIU.createFeature("org.iu1", Version.createOSGi(1,3,2)),
	    										MockIU.createFeature("org.iu1", Version.createOSGi(2,0,0)),
	    										MockIU.createFeature("org.iu1", Version.createOSGi(2,3,0)),
	    										MockIU.createFeature("org.iu1", Version.createOSGi(3,9,0))
	    									);
	    								} else if ("location4".equals(location.toString())) {
	    									return ImmutableList.<IInstallableUnit>of(
	    										MockIU.createFeature("org.iu1", Version.createOSGi(1,2,0)),
	    										MockIU.createFeature("org.iu2", Version.createOSGi(3,7,72)),
	    										MockIU.createFeature("com.iu1", Version.createOSGi(1,2,0)),
	    										MockIU.createFeature("com.iu2", Version.createOSGi(3,7,72)),
	    										MockIU.createFeature("com.iu3", Version.createOSGi(3,7,72))
	    									);
	    								} else if ("badLocation".equals(location.toString())) {
	    									throw new RuntimeException("bad location");
	    								} else if ("emptyRepository".equals(location.toString())) {
	    									return ImmutableList.<IInstallableUnit>of();
	    								} else {
	    									return ImmutableList.<IInstallableUnit>of();
	    								}
	    							}
	    						});
	    					}
	    				};
	    			};
	    		});
	    	}
	    }.createInjectorAndDoEMFRegistration();
	}
}
