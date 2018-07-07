package fr.obeo.releng.targetplatform.tests.util;

import fr.obeo.releng.targetplatform.TargetPlatform;
import fr.obeo.releng.targetplatform.util.TargetReloader;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.linking.lazy.LazyLinkingResource;
import org.eclipse.xtext.util.LazyStringInputStream;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * We implement a special target reloader for test because:
 * After the call of unload on the resource, the method "EcoreUtil2.getResource" used in
 * production code of TargetReloader: "TargetReloaderImpl" return null.
 * 
 * In test, ParseHelper is used. It generates target in ResourceSet not the same way
 * as in normal code. Hence target unload / reload does not work the same.
 */
@SuppressWarnings("all")
public class TargetReloaderTestImpl implements TargetReloader {
  @Override
  public TargetPlatform forceReloadTarget(final TargetPlatform targetPlatformBase, final TargetPlatform importedTargetPlatform) {
    try {
      TargetPlatform ret = null;
      Resource _eResource = importedTargetPlatform.eResource();
      final LazyLinkingResource xTextLazyResource = ((LazyLinkingResource) _eResource);
      final String targetFileContent = xTextLazyResource.getParseResult().getRootNode().getText();
      xTextLazyResource.unload();
      LazyStringInputStream _lazyStringInputStream = new LazyStringInputStream(targetFileContent);
      xTextLazyResource.load(_lazyStringInputStream, null);
      EList<EObject> _contents = null;
      if (xTextLazyResource!=null) {
        _contents=xTextLazyResource.getContents();
      }
      EObject _head = null;
      if (_contents!=null) {
        _head=IterableExtensions.<EObject>head(_contents);
      }
      EObject root = _head;
      if ((root instanceof TargetPlatform)) {
        ret = ((TargetPlatform) root);
      }
      return ret;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
