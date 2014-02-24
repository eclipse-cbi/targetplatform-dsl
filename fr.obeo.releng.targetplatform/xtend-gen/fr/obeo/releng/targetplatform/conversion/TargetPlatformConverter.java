package fr.obeo.releng.targetplatform.conversion;

import fr.obeo.releng.targetplatform.conversion.VersionRangeConverter;
import org.eclipse.xtext.common.services.DefaultTerminalConverters;
import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.conversion.ValueConverter;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.osgi.framework.VersionRange;

@SuppressWarnings("all")
public class TargetPlatformConverter extends DefaultTerminalConverters {
  private IValueConverter<String> versionRangeValueConverter = new VersionRangeConverter();
  
  @ValueConverter(rule = "VersionRange")
  public IValueConverter<String> getMyRuleNameConverter() {
    return this.versionRangeValueConverter;
  }
  
  private IValueConverter<String> stringValueConverter = new VersionRangeConverter();
  
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
}
