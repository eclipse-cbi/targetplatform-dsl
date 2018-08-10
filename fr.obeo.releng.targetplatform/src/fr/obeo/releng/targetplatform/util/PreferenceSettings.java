package fr.obeo.releng.targetplatform.util;

import com.google.inject.Singleton;

@Singleton
public class PreferenceSettings {
	
	public static final String DUPLICATED_IU_IMPORT_WARN = "warning";
	public static final String DUPLICATED_IU_IMPORT_INFO = "info";
	public static final String DUPLICATED_IU_IMPORT_SILENT = "silent";
	public static final String DUPLICATED_IU_IMPORT_DEFAULT = DUPLICATED_IU_IMPORT_WARN;
	
	private String duplicatedIUWarnPreference = DUPLICATED_IU_IMPORT_DEFAULT;

	public String getDuplicatedIUWarnPreference() {
		return duplicatedIUWarnPreference;
	}

	public void setDuplicatedIUWarnPreference(String duplicatedIUWarnPreference) {
		this.duplicatedIUWarnPreference = duplicatedIUWarnPreference;
	}

}
