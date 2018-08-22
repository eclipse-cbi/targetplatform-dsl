package fr.obeo.releng.targetplatform.ui;

import org.osgi.framework.BundleContext;

import fr.obeo.releng.targetplatform.TargetPlatformBundleActivator;
import fr.obeo.releng.targetplatform.ui.internal.TargetPlatformActivator;
import fr.obeo.releng.targetplatform.ui.preferences.TPDPreferenceConstants;
import fr.obeo.releng.targetplatform.util.PreferenceSettings;

public class TargetPlatformActivatorUI extends TargetPlatformActivator {

	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		loadTPDPreferenceSettings();
	}
	
	private void loadTPDPreferenceSettings() {
		TargetPlatformBundleActivator instance = TargetPlatformBundleActivator.getInstance();
		PreferenceSettings preferenceSettings = instance.getPreferenceSettings();
		
		String duplicatedIUWarnPreference = this.getPreferenceStore().getString(TPDPreferenceConstants.P_CHOICE_DUPLICATED_IU_WARNING);
		preferenceSettings.setDuplicatedIUWarnPreference(duplicatedIUWarnPreference);
		
		boolean useEnvSetting = this.getPreferenceStore().getBoolean(TPDPreferenceConstants.P_CHOICE_USE_ENV);
		preferenceSettings.setUseEnv(useEnvSetting);
	}
}
