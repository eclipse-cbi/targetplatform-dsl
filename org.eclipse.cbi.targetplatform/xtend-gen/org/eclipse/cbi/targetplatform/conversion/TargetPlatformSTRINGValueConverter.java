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
package org.eclipse.cbi.targetplatform.conversion;

import org.eclipse.cbi.targetplatform.conversion.TargetPlatformConverter;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.conversion.impl.STRINGValueConverter;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.util.Strings;

@SuppressWarnings("all")
public class TargetPlatformSTRINGValueConverter extends STRINGValueConverter {
  @Override
  public String toValue(final String string, final INode node) {
    boolean _tripleEquals = (string == null);
    if (_tripleEquals) {
      return null;
    }
    EObject _grammarElement = node.getGrammarElement();
    final RuleCall ge = ((RuleCall) _grammarElement);
    EObject _eContainer = ge.eContainer();
    final Assignment container = ((Assignment) _eContainer);
    int _length = string.length();
    int _minus = (_length - 1);
    final String value = Strings.convertFromJavaString(string.substring(1, _minus), true);
    if ((((value != null) && (container != null)) && "version".equals(container.getFeature()))) {
      return TargetPlatformConverter.parseVersionRange(value, node);
    } else {
      return value;
    }
  }
}
