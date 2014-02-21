package fr.obeo.releng.targetplatform.validation;

import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.validation.Check;

import fr.obeo.releng.targetplatform.targetplatform.Location;
import fr.obeo.releng.targetplatform.targetplatform.Option;
import fr.obeo.releng.targetplatform.targetplatform.TargetplatformPackage;
 

public class TargetPlatformJavaValidator extends AbstractTargetPlatformJavaValidator {
	
	public static final String CHECK__OPTIONS_SELF_EXCLUDING_ALL_ENV_REQUIRED = "CHECK__OPTIONS_SELF_EXCLUDING_ALL_ENV_REQUIRED";
	
	@Check
	public void checkAllEnvAndRequiredAreSelfExluding(Location location) {
		EList<Option> options = location.getOptions();
		if (options.contains(Option.INCLUDE_ALL_ENVIRONMENTS) && options.contains(Option.INCLUDE_REQUIRED)) {
			error("All environments can not be included along with required artifacts, you must choose one of the two options", 
					location, 
					TargetplatformPackage.Literals.LOCATION__OPTIONS, 
					options.indexOf(Option.INCLUDE_REQUIRED), CHECK__OPTIONS_SELF_EXCLUDING_ALL_ENV_REQUIRED);
			
			error("All environments can not be included along with required artifacts, you must choose one of the two options", 
					location, 
					TargetplatformPackage.Literals.LOCATION__OPTIONS, 
					options.indexOf(Option.INCLUDE_ALL_ENVIRONMENTS), CHECK__OPTIONS_SELF_EXCLUDING_ALL_ENV_REQUIRED);
		}
	}
}
