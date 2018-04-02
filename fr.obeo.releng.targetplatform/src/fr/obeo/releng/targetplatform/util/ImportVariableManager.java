package fr.obeo.releng.targetplatform.util;

import java.util.HashMap;
import java.util.Map;

import com.google.inject.Singleton;

@Singleton
public class ImportVariableManager {

	private String fileToProcess;
	private Map<String, String> overrideVarDefMap = new HashMap<String, String>();
	
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
		
		boolean useEnv = false;
		int firstOverrideIndex = 1;
		if (args.length >= 2) {
			if ("useenv".compareToIgnoreCase(args[1]) == 0) {
				useEnv = true;
				firstOverrideIndex = 2;
			}
		}
		
		if (useEnv) {
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
		return overrideVarDefMap.get(variableName);
	}

	/**
	 * @return tpd filename passed in argument
	 */
	public String getFileToProcess() {
		return fileToProcess;
	}
	
	//Only for test: cleanup. Same instance is used across tests
	public void clear() {
		fileToProcess = null;
		overrideVarDefMap.clear();
	}
}
