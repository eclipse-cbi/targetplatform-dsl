package fr.obeo.releng.targetplatform.ui.preferences;

import java.util.Map;

import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.FieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.RadioGroupFieldEditor;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import fr.obeo.releng.targetplatform.TargetPlatformBundleActivator;
import fr.obeo.releng.targetplatform.ui.internal.TargetPlatformActivator;
import fr.obeo.releng.targetplatform.util.ImportVariableManager;
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
	private boolean useEnvSetting2BeSet;
	
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
		
		addField(new BooleanFieldEditor(
				TPDPreferenceConstants.P_CHOICE_USE_ENV,
				"Use &environment variables to override variable values in tpd files\n(need restart only if environment change)",
				getFieldEditorParent()));
		
		showLoadedEnvironmentVariables();
	}

	private void showLoadedEnvironmentVariables() {
		Composite parent= getFieldEditorParent();
		Label label1 = new Label(parent,SWT.BORDER);
		label1.setText("Environment variables found at startup for TPD");
		Text labelLoadedTPDEnvVar = new Text(parent, SWT.READ_ONLY | SWT.BORDER | SWT.WRAP | SWT.V_SCROLL);
		GridData gridData = new GridData(SWT.FILL, SWT.CENTER, true, false);
		gridData.heightHint = 10 * labelLoadedTPDEnvVar.getLineHeight();
		gridData.widthHint = (3*gridData.heightHint)/2;
		labelLoadedTPDEnvVar.setLayoutData(gridData);
		
		String varEnvList = "";
		TargetPlatformBundleActivator instance = TargetPlatformBundleActivator.getInstance();
		ImportVariableManager importVariableManager = instance.getImportVariableManager();
		Map<String, String> overrideVarDefMap = importVariableManager.getOverrideVarDefMap();
		for (String varName : overrideVarDefMap.keySet()) {
			String varValue = overrideVarDefMap.get(varName);
			varEnvList += varName + " = " + varValue + "\n";
		}
		
		labelLoadedTPDEnvVar.setText(varEnvList);
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
        	else if (source instanceof BooleanFieldEditor) {
        		BooleanFieldEditor boolField = (BooleanFieldEditor) source;
        		if (boolField.getPreferenceName().equals(TPDPreferenceConstants.P_CHOICE_USE_ENV)) {
        			useEnvSetting2BeSet = (Boolean) event.getNewValue();
        		}
        	}
        }        
	}
	
	private void updateSettings() {
		TargetPlatformBundleActivator instance = TargetPlatformBundleActivator.getInstance();
		PreferenceSettings preferenceSettings = instance.getPreferenceSettings();
		preferenceSettings.setDuplicatedIUWarnPreference(duplicatedIUWarnPreference2BeSet);
		preferenceSettings.setUseEnv(useEnvSetting2BeSet);
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
		useEnvSetting2BeSet = PreferenceSettings.USE_ENV_DEFAULT_SETTING;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.IWorkbenchPreferencePage#init(org.eclipse.ui.IWorkbench)
	 */
	public void init(IWorkbench workbench) {
		duplicatedIUWarnPreference2BeSet = TargetPlatformActivator.getInstance()
				.getPreferenceStore().getString(TPDPreferenceConstants.P_CHOICE_DUPLICATED_IU_WARNING);
		useEnvSetting2BeSet = TargetPlatformActivator.getInstance()
				.getPreferenceStore().getBoolean(TPDPreferenceConstants.P_CHOICE_USE_ENV);
	}
	
}