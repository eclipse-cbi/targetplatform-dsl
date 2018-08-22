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

import com.google.inject.Singleton;
import fr.obeo.releng.targetplatform.conversion.FQNConverter;
import fr.obeo.releng.targetplatform.conversion.TargetPlatformSTRINGValueConverter;
import fr.obeo.releng.targetplatform.conversion.VersionRangeConverter;
import org.eclipse.equinox.p2.metadata.VersionRange;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.common.services.DefaultTerminalConverters;
import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.conversion.ValueConverter;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xbase.lib.Exceptions;

@Singleton
@SuppressWarnings("all")
public class TargetPlatformConverter extends DefaultTerminalConverters {
  private final IValueConverter<String> versionRangeValueConverter = new VersionRangeConverter();
  
  @ValueConverter(rule = "VersionRange")
  public IValueConverter<String> getVersionRangeConverter() {
    return this.versionRangeValueConverter;
  }
  
  private final IValueConverter<String> stringValueConverter = new TargetPlatformSTRINGValueConverter();
  
  @ValueConverter(rule = "STRING")
  public IValueConverter<String> getStringValueConverter() {
    return this.stringValueConverter;
  }
  
  public static String parseVersionRange(final String string, final INode node) {
    boolean _isEmpty = Strings.isEmpty(string);
    if (_isEmpty) {
      throw new ValueConverterException("Couldn\'t convert empty string to a VersionRange value.", node, null);
    }
    boolean _equalsIgnoreCase = "lazy".equalsIgnoreCase(string);
    boolean _not = (!_equalsIgnoreCase);
    if (_not) {
      try {
        final VersionRange value = new VersionRange(string);
        return value.toString();
      } catch (final Throwable _t) {
        if (_t instanceof IllegalArgumentException) {
          final IllegalArgumentException e = (IllegalArgumentException)_t;
          throw new ValueConverterException((("Couldn\'t convert \'" + string) + "\' to a VersionRange value."), node, e);
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
    } else {
      return string;
    }
  }
  
  private IValueConverter<String> qualifiedNameValueConverter;
  
  @ValueConverter(rule = "QualifiedName")
  public IValueConverter<String> getQualifiedNameConverter() {
    boolean _tripleEquals = (this.qualifiedNameValueConverter == null);
    if (_tripleEquals) {
      Grammar _grammar = this.getGrammar();
      FQNConverter _fQNConverter = new FQNConverter(_grammar);
      this.qualifiedNameValueConverter = _fQNConverter;
    }
    return this.qualifiedNameValueConverter;
  }
}
