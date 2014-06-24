package fr.obeo.releng.targetplatform.ui.internal;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.equinox.p2.core.IProvisioningAgent;
import org.eclipse.equinox.p2.core.IProvisioningAgentProvider;
import org.eclipse.equinox.p2.core.ProvisionException;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import fr.obeo.releng.targetplatform.ui.internal.TargetPlatformActivator;

public class CustomTargetPlatformActivator extends TargetPlatformActivator {
	
	private BundleContext context;

	private IProvisioningAgent agent;

	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		this.context = context;
	}
	
	@Override
	public void stop(BundleContext context) throws Exception {
		IProvisioningAgent oldAgent = agent;
		agent = null;
		if (oldAgent != null) {
			oldAgent.stop();
		}
		
		this.context = null;
		super.stop(context);
	}
	
	public static CustomTargetPlatformActivator getInstance() {
		return (CustomTargetPlatformActivator) TargetPlatformActivator.getInstance();
	}
	
	public IProvisioningAgent getProvisioningAgent() {
		ServiceReference<IProvisioningAgentProvider> agentProviderReference = context.getServiceReference(IProvisioningAgentProvider.class);
		final IProvisioningAgentProvider agentProvider;
		if (agentProviderReference != null) {
			agentProvider = context.getService(agentProviderReference);
			try {
				agent = agentProvider.createAgent(getStateLocation().toFile().toURI());
			} catch (ProvisionException e) {
				getLog().log(new Status(IStatus.ERROR, FR_OBEO_RELENG_TARGETPLATFORM_TARGETPLATFORM, e.getMessage(), e));
			} catch (IllegalStateException e) {
				getLog().log(new Status(IStatus.ERROR, FR_OBEO_RELENG_TARGETPLATFORM_TARGETPLATFORM, e.getMessage(), e));
			}
			
			context.ungetService(agentProviderReference);
		} else {
			agentProvider = null;
		}
		
		return agent;
	}
}
