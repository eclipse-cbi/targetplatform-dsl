package fr.obeo.releng.targetplatform.ui.preferences;

import org.eclipse.jface.preference.FieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.RadioGroupFieldEditor;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import fr.obeo.releng.targetplatform.TargetPlatformBundleActivator;
import fr.obeo.releng.targetplatform.ui.internal.TargetPlatformActivator;
import fr.obeo.releng.targetplatform.util.PreferenceSettings;

/**
 * This class represents a preference page that
 * is contributed to the Preferences dialog. By 
 * subclassing <samp>FieldEditorPreferencePage</samp>, we
 * can use the field support built into JFace that allows
 * us to create a page that is small and knows how to 
 * save, restore and apply itself.
 * <p>
 * This page is used to modify preferences only. They
 * are stored in the preference store that belongs to
 * the main plug-in class. That way, preferences can
 * be accessed directly via the preference store.
 */

public class TPDSamplePreferencePage
	extends FieldEditorPreferencePage
	implements IWorkbenchPreferencePage {
	
	private String duplicatedIUWarnPreference2BeSet;
	
	public TPDSamplePreferencePage() {
		super(GRID);
		setPreferenceStore(TargetPlatformActivator.getInstance().getPreferenceStore());
		setDescription("TPD options preference page");
	}
	
	/**
	 * Creates the field editors. Field editors are abstractions of
	 * the common GUI blocks needed to manipulate various types
	 * of preferences. Each field editor knows how to save and
	 * restore itself.
	 */
	public void createFieldEditors() {
		addField(new RadioGroupFieldEditor(
				TPDPreferenceConstants.P_CHOICE_DUPLICATED_IU_WARNING,
			"Warning behavior of duplicated IU from included target platforms",
			1,
			new String[][] {
					{ "Display &Warning", PreferenceSettings.DUPLICATED_IU_IMPORT_WARN },
					{ "Display &Info", PreferenceSettings.DUPLICATED_IU_IMPORT_INFO },
					{ "&Silent", PreferenceSettings.DUPLICATED_IU_IMPORT_SILENT }
		}, getFieldEditorParent()));
	}
	
	public void propertyChange(PropertyChangeEvent event) {
        super.propertyChange(event);
        
        if (event.getProperty().equals(FieldEditor.VALUE)) {
        	Object source = event.getSource();
        	if (source instanceof RadioGroupFieldEditor) {
        		RadioGroupFieldEditor radioGroup = (RadioGroupFieldEditor) source;
        		if (radioGroup.getPreferenceName().equals(TPDPreferenceConstants.P_CHOICE_DUPLICATED_IU_WARNING)) {
        			duplicatedIUWarnPreference2BeSet = (String) event.getNewValue();
        		}
        	}
        }        
	}
	
	private void updateSettings() {
		TargetPlatformBundleActivator instance = TargetPlatformBundleActivator.getInstance();
		PreferenceSettings preferenceSettings = instance.getPreferenceSettings();
		preferenceSettings.setDuplicatedIUWarnPreference(duplicatedIUWarnPreference2BeSet);
		
	}
	
	@Override
	protected void performApply() {
		super.performApply();
		updateSettings();
	}
	
	@Override
	public boolean performOk() {
		updateSettings();
		return super.performOk();
	}
	
	@Override
	protected void performDefaults() {
		super.performDefaults();
		duplicatedIUWarnPreference2BeSet = PreferenceSettings.DUPLICATED_IU_IMPORT_DEFAULT;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.IWorkbenchPreferencePage#init(org.eclipse.ui.IWorkbench)
	 */
	public void init(IWorkbench workbench) {
		duplicatedIUWarnPreference2BeSet = TargetPlatformActivator.getInstance()
				.getPreferenceStore().getString(TPDPreferenceConstants.P_CHOICE_DUPLICATED_IU_WARNING);
	}
	
}