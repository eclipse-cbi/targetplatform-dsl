package fr.obeo.releng.targetplatform.util;

import java.util.HashMap;
import java.util.Map;

import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class ImportVariableManager {

	private String fileToProcess;
	private Map<String, String> overrideVarDefMap = new HashMap<String, String>();

	@Inject
	private PreferenceSettings preferenceSettings;
	
	private boolean isLoaded = false;

	/**
	 * @param args - tpd filename to process must be first
	 * 			   - optional "useenv" (case incensitive), if present look in environment for
	 * 			     variable override. Environment variable name = TPD_VAR_XXX, environment variable
	 * 			     value = varname=varvalue
	 * 			   - list of pair "variable definition name", "variable value" varname=varvalue
	 */
	public void processCommandLineArguments(String[] args) {
		if (args.length >= 1) {
			fileToProcess = args[0];
		}
		
		boolean scanEnv = false;
		int firstOverrideIndex = 1;
		if (args.length >= 2) {
			if ("useenv".compareToIgnoreCase(args[1]) == 0) {
				scanEnv = true;
				firstOverrideIndex = 2;
			}
		}
		
		if (scanEnv) {
			// We scan environment variables to extract those for TPD
			//
			// Remark: if unit tests are launched with environment variables for TPD defined
			// it may leads to error
			Map<String, String> env = System.getenv();
			for (String envName : env.keySet()) {
				if (envName.startsWith("TPD_VAR_")) {
					String tpdOverrideVar = env.get(envName);
					importOverridingVariable(tpdOverrideVar, "environment");
				}
			}
		}

		for (int i = firstOverrideIndex ; i < args.length ; i++) {
			String curImport = args[i];
			importOverridingVariable(curImport, "command line");
		}
		
		isLoaded = true;
	}

	private void importOverridingVariable(String curImport, String source) {
		String[] varImport = curImport.split("=");
		if (varImport.length != 2) {
			System.out.println("[WARNING] - TPD - Wrong variable definition from " + source + ": " + curImport
					+ " (format: varName=varValue or varName=\"varValue with space\")");
			return;
		}
		System.out.println("[INFO] - TPD - Imported variable from " + source + ": " + curImport);
		overrideVarDefMap.put(varImport[0], varImport[1]);
	}
	
	/**
	 * @param variableName 	name of variable existing in tpd file or included tpd file
	 * 						which will be override by variable passed through command line
	 * 						or environment variable (imported variable).
	 * 						Command line variables have higher priority than environment variables
	 * @return Variable value or null if variable does not exist in imported variable
	 */
	public String getVariableValue(String variableName) {
		checkLoad();
		if (!preferenceSettings.isUseEnv()) {
			return null;
		}
		return overrideVarDefMap.get(variableName);
	}

	/**
	 * @return tpd filename passed in argument
	 */
	public String getFileToProcess() {
		checkLoad();
		return fileToProcess;
	}
	
	private void checkLoad() {
		if (isLoaded) {
			return;
		}
		//If not already loaded => we are under eclipse otherwise if launched from
		//command line/maven, command line arguments are already processed at startup
		String[] args = {null, "useenv"};
		processCommandLineArguments(args);
	}
	
	public Map<String, String> getOverrideVarDefMap() {
		checkLoad();
		HashMap<String, String> out = new HashMap<String, String>();
		out.putAll(overrideVarDefMap);
		return out;
	}
	
	//Only for test: cleanup. Same instance is used across tests
	public void clear() {
		fileToProcess = null;
		overrideVarDefMap.clear();
	}
}
