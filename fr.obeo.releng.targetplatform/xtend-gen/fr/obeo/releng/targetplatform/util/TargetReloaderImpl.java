package fr.obeo.releng.targetplatform.util;

import fr.obeo.releng.targetplatform.TargetPlatform;
import fr.obeo.releng.targetplatform.util.TargetReloader;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class TargetReloaderImpl implements TargetReloader {
  @Override
  public TargetPlatform forceReloadTarget(final TargetPlatform targetPlatformBase, final TargetPlatform importedTargetPlatform) {
    TargetPlatform ret = null;
    final Resource context = targetPlatformBase.eResource();
    final String importTargetUri = importedTargetPlatform.eResource().getURI().toString();
    final Resource resource = EcoreUtil2.getResource(context, importTargetUri);
    resource.unload();
    final Resource resourceUpdated = EcoreUtil2.getResource(context, importTargetUri);
    EList<EObject> _contents = null;
    if (resourceUpdated!=null) {
      _contents=resourceUpdated.getContents();
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
  }
}
