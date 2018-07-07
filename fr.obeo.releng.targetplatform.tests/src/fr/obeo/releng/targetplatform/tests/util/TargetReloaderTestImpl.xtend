package fr.obeo.releng.targetplatform.tests.util

import fr.obeo.releng.targetplatform.util.TargetReloader
import fr.obeo.releng.targetplatform.TargetPlatform
import org.eclipse.xtext.linking.lazy.LazyLinkingResource
import org.eclipse.xtext.util.LazyStringInputStream

/*
 * We implement a special target reloader for test because:
 * After the call of unload on the resource, the method "EcoreUtil2.getResource" used in
 * production code of TargetReloader: "TargetReloaderImpl" return null.
 * 
 * In test, ParseHelper is used. It generates target in ResourceSet not the same way
 * as in normal code. Hence target unload / reload does not work the same.
 */
class TargetReloaderTestImpl implements TargetReloader {
	
	override forceReloadTarget(TargetPlatform targetPlatformBase, TargetPlatform importedTargetPlatform) {
		var TargetPlatform ret = null;
		
		val xTextLazyResource = importedTargetPlatform.eResource as LazyLinkingResource
		val targetFileContent = xTextLazyResource.parseResult.rootNode.text
		
		xTextLazyResource.unload
		xTextLazyResource.load(new LazyStringInputStream(targetFileContent), null)
		
		var root = xTextLazyResource?.getContents()?.head;
		if (root instanceof TargetPlatform) {
			ret = root as TargetPlatform;
		}
		
		return ret
	}
	
}
