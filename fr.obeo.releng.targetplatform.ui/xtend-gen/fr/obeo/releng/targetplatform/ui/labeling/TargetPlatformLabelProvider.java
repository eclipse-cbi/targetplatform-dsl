/**
 * Copyright (c) 2012-2014 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Mikael Barbero (Obeo) - initial API and implementation
 */
package fr.obeo.releng.targetplatform.ui.labeling;

import com.google.inject.Inject;
import fr.obeo.releng.targetplatform.Environment;
import fr.obeo.releng.targetplatform.IU;
import fr.obeo.releng.targetplatform.IncludeDeclaration;
import fr.obeo.releng.targetplatform.Location;
import fr.obeo.releng.targetplatform.Option;
import fr.obeo.releng.targetplatform.Options;
import fr.obeo.releng.targetplatform.TargetPlatform;
import fr.obeo.releng.targetplatform.VarDefinition;
import fr.obeo.releng.targetplatform.util.CompositeElementResolver;
import org.eclipse.emf.ecore.EObject;
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
  private CompositeElementResolver compositeElementResolver;
  
  @Inject
  public TargetPlatformLabelProvider(final AdapterFactoryLabelProvider delegate) {
    super(delegate);
  }
  
  public StyledString text(final Location object) {
    StyledString _xblockexpression = null;
    {
      final StyledString ss = new StyledString();
      String _uri = object.getUri();
      boolean _tripleEquals = (_uri == null);
      if (_tripleEquals) {
        EObject _eContainer = object.eContainer();
        this.compositeElementResolver.resolveCompositeElements(((TargetPlatform) _eContainer));
      }
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
    String _xblockexpression = null;
    {
      boolean _isCompositeElementsResolved = object.isCompositeElementsResolved();
      boolean _not = (!_isCompositeElementsResolved);
      if (_not) {
        this.compositeElementResolver.resolveCompositeElements(object);
      }
      _xblockexpression = object.getName();
    }
    return _xblockexpression;
  }
  
  public String image(final TargetPlatform object) {
    return "obj16/target_obj.gif";
  }
  
  public StyledString text(final IncludeDeclaration object) {
    StyledString _xblockexpression = null;
    {
      final StyledString ss = new StyledString();
      String _importURI = object.getImportURI();
      boolean _tripleEquals = (_importURI == null);
      if (_tripleEquals) {
        EObject _eContainer = object.eContainer();
        this.compositeElementResolver.resolveCompositeElements(((TargetPlatform) _eContainer));
      }
      ss.append(object.getImportURI());
      _xblockexpression = ss;
    }
    return _xblockexpression;
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
  
  public String image(final VarDefinition object) {
    String _xifexpression = null;
    boolean _isImported = object.isImported();
    if (_isImported) {
      String _xifexpression_1 = null;
      boolean _isDiamondInherit = object.isDiamondInherit();
      if (_isDiamondInherit) {
        _xifexpression_1 = "obj16/varImportDiamond_obj.gif";
      } else {
        _xifexpression_1 = "obj16/varImport_obj.gif";
      }
      _xifexpression = _xifexpression_1;
    } else {
      _xifexpression = "obj16/var_obj.gif";
    }
    return _xifexpression;
  }
}
