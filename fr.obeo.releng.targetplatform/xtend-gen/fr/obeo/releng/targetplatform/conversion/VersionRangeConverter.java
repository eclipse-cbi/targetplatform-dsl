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
package fr.obeo.releng.targetplatform.conversion;

import fr.obeo.releng.targetplatform.conversion.TargetPlatformConverter;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.conversion.impl.AbstractNullSafeConverter;
import org.eclipse.xtext.nodemodel.INode;

@SuppressWarnings("all")
public class VersionRangeConverter extends AbstractNullSafeConverter<String> {
  @Override
  protected String internalToValue(final String string, final INode node) throws ValueConverterException {
    return TargetPlatformConverter.parseVersionRange(string, node);
  }
  
  @Override
  protected String internalToString(final String value) {
    return value;
  }
}
