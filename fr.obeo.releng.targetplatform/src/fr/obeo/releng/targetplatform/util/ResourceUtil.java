package fr.obeo.releng.targetplatform.util;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;

public class ResourceUtil {

  private static URI getResolvedImportUri(Resource context, URI uri) {
    URI contextURI = context.getURI();
    if (contextURI.isHierarchical() && !contextURI.isRelative() && (uri.isRelative() && !uri.isEmpty())) {
      uri = uri.resolve(contextURI);
    }
    return uri;
  }

  public static Resource getResource(Resource context, String uri) {

    System.out.println("Retrieve included location:" + uri);
    URI newURI = getResolvedImportUri(context, URI.createURI(uri));
    
    int maxRetries = 10;

    for (int i = 1; i <= maxRetries; i++) {
      try {
        Resource resource = context.getResourceSet().getResource(newURI, true);
        if (!resource.getErrors().isEmpty()) {
          context.getResourceSet().getResources().remove(resource);
          resource = context.getResourceSet().getResource(newURI, true);
        }
        return resource;

      } catch (RuntimeException e) {
        System.out.println("Error while retrieving location:" + uri);
        e.printStackTrace();

        System.out.println("Retry:" + i + "/"+maxRetries);
        try {
          Thread.sleep(500);
        } catch (InterruptedException e2) {
          e2.printStackTrace();
        }
        
      }
    }
    return null;

  }
}
