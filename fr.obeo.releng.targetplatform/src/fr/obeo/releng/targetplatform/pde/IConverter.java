package fr.obeo.releng.targetplatform.pde;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;

public interface IConverter {

	void generateTargetDefinitionFile(URI targetPlatformLocation, IProgressMonitor monitor) throws Exception;
	
}
