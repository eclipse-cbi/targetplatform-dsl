package fr.obeo.releng.targetplatform.ui.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;

import fr.obeo.releng.targetplatform.ui.internal.TargetPlatformActivator;
import fr.obeo.releng.targetplatform.util.PreferenceSettings;

/**
 * Class used to initialize default preference values.
 */
public class TPDPreferenceInitializer extends AbstractPreferenceInitializer {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer#initializeDefaultPreferences()
	 */
	public void initializeDefaultPreferences() {
		IPreferenceStore store = TargetPlatformActivator.getInstance().getPreferenceStore();
		store.setDefault(TPDPreferenceConstants.P_CHOICE_DUPLICATED_IU_WARNING, PreferenceSettings.DUPLICATED_IU_IMPORT_DEFAULT);
	}

}
