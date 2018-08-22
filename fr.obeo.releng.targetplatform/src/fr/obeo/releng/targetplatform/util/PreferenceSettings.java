package fr.obeo.releng.targetplatform.util;

import com.google.inject.Singleton;

@Singleton
public class PreferenceSettings {
	
	public static final String DUPLICATED_IU_IMPORT_WARN = "warning";
	public static final String DUPLICATED_IU_IMPORT_INFO = "info";
	public static final String DUPLICATED_IU_IMPORT_SILENT = "silent";
	public static final String DUPLICATED_IU_IMPORT_DEFAULT = DUPLICATED_IU_IMPORT_WARN;
	
	private String duplicatedIUWarnPreference = DUPLICATED_IU_IMPORT_DEFAULT;
	
	public static final boolean USE_ENV_DEFAULT_SETTING = false;
	
	/** Under eclipse default behavior is not to use environment variable to override target variables,
	 * if launched through command line or maven it is set to true */
	private boolean useEnv = USE_ENV_DEFAULT_SETTING;

	public boolean isUseEnv() {
		return useEnv;
	}

	public void setUseEnv(boolean useEnv) {
		this.useEnv = useEnv;
	}

	public String getDuplicatedIUWarnPreference() {
		return duplicatedIUWarnPreference;
	}

	public void setDuplicatedIUWarnPreference(String duplicatedIUWarnPreference) {
		this.duplicatedIUWarnPreference = duplicatedIUWarnPreference;
	}

}
