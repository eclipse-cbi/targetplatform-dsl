package fr.obeo.releng.targetplatform.util;

import fr.obeo.releng.targetplatform.TargetPlatform;

@SuppressWarnings("all")
public interface TargetReloader {
  /**
   * The need to reload the target platform comes from the following case under eclipse:
   * Let the 3 nested targets:
   * 
   * -------------------------------------------------------------------------------------
   * target "mainTarget"
   * include "subTpd.tpd"
   * -------------------------------------------------------------------------------------
   * target "subTpd"
   * include "subSubTpd.tpd"
   * -------------------------------------------------------------------------------------
   * target "subSubTpd"
   * define var1="val1"
   * -------------------------------------------------------------------------------------
   * 
   * var1 is defined in "subSubTpd", so it is imported inside "subTpd" and "mainTarget".
   * In the outline view of eclipse, we can visualize that.
   * 
   * If we remove var1 from "subSubTpd", it is removed from "subTpd". If we edit/modify
   * "mainTarget", XTEXT will launch the rebuild of "mainTarget". In this rebuild, it will
   * reimport "subTpd" from its cache and do not rebuild "subTpd". Since "subTpd" still has
   * a var1 variable, "mainTarget" will also import a var1 variable. So we need to reload
   * any imported target when we do a build.
   * 
   * The same consideration applies with other declarations like "include" as with "define"
   */
  public abstract TargetPlatform forceReloadTarget(final TargetPlatform targetPlatformBase, final TargetPlatform importedTargetPlatform);
}
