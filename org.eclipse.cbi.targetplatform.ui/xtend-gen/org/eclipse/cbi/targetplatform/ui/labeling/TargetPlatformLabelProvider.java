/**
 * Copyright (c) 2012-2014 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 */
package org.eclipse.cbi.targetplatform.ui.labeling;

import com.google.inject.Inject;
import org.eclipse.cbi.targetplatform.model.Environment;
import org.eclipse.cbi.targetplatform.model.IU;
import org.eclipse.cbi.targetplatform.model.IncludeDeclaration;
import org.eclipse.cbi.targetplatform.model.Location;
import org.eclipse.cbi.targetplatform.model.Option;
import org.eclipse.cbi.targetplatform.model.Options;
import org.eclipse.cbi.targetplatform.model.TargetPlatform;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.xtext.ui.label.DefaultEObjectLabelProvider;

/**
 * Provides labels for a EObjects.
 * 
 * see http://www.eclipse.org/Xtext/documentation.html#labelProvider
 */
@SuppressWarnings("all")
public class TargetPlatformLabelProvider extends DefaultEObjectLabelProvider {
  @Inject
  public TargetPlatformLabelProvider(final AdapterFactoryLabelProvider delegate) {
    super(delegate);
  }
  
  public StyledString text(final Location object) {
    StyledString _xblockexpression = null;
    {
      final StyledString ss = new StyledString();
      ss.append(object.getUri());
      String _iD = object.getID();
      boolean _tripleNotEquals = (_iD != null);
      if (_tripleNotEquals) {
        String _iD_1 = object.getID();
        String _plus = (" " + _iD_1);
        ss.append(_plus, StyledString.DECORATIONS_STYLER);
      }
      _xblockexpression = ss;
    }
    return _xblockexpression;
  }
  
  public String image(final Location object) {
    return "obj16/location_obj.gif";
  }
  
  public StyledString text(final IU object) {
    StyledString _xblockexpression = null;
    {
      final StyledString ss = new StyledString();
      ss.append(object.getID());
      String _version = object.getVersion();
      boolean _tripleNotEquals = (_version != null);
      if (_tripleNotEquals) {
        String _version_1 = object.getVersion();
        String _plus = (" " + _version_1);
        ss.append(_plus, StyledString.COUNTER_STYLER);
      }
      _xblockexpression = ss;
    }
    return _xblockexpression;
  }
  
  public String image(final IU object) {
    return "obj16/iu_obj.gif";
  }
  
  public String text(final TargetPlatform object) {
    return object.getName();
  }
  
  public String image(final TargetPlatform object) {
    return "obj16/target_obj.gif";
  }
  
  public String image(final IncludeDeclaration object) {
    return "obj16/inc_obj.gif";
  }
  
  public String image(final Option object) {
    return "obj16/option_obj.gif";
  }
  
  public String text(final Options object) {
    return "Options";
  }
  
  public String image(final Options object) {
    return "obj16/option_obj.gif";
  }
  
  public String text(final Environment object) {
    return "Environment";
  }
  
  public String image(final Environment object) {
    return "obj16/env_obj.gif";
  }
}
