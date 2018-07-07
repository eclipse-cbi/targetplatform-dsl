package fr.obeo.releng.targetplatform.util

import fr.obeo.releng.targetplatform.util.TargetReloader
import fr.obeo.releng.targetplatform.TargetPlatform
import org.eclipse.xtext.EcoreUtil2

class TargetReloaderImpl implements TargetReloader {
	
	//URI prefix from tests: tmp:/
	//URI prefix from eclipse: platform:/
	//URI prefix from command line: file:/
	override forceReloadTarget(TargetPlatform targetPlatformBase, TargetPlatform importedTargetPlatform) {
		var TargetPlatform ret = null;
		
		val context	= targetPlatformBase.eResource
		val importTargetUri = importedTargetPlatform.eResource.URI.toString
		
		val resource = EcoreUtil2.getResource(context, importTargetUri);
		resource.unload
		val resourceUpdated = EcoreUtil2.getResource(context, importTargetUri);
		var root = resourceUpdated?.getContents()?.head;
		if (root instanceof TargetPlatform) {
			ret = root as TargetPlatform;
		}
		
		return ret
	}
	
}
