package fr.obeo.releng.targetplatform.conversion;

import com.google.common.base.Objects;
import fr.obeo.releng.targetplatform.conversion.TargetPlatformConverter;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.conversion.impl.AbstractLexerBasedConverter;
import org.eclipse.xtext.nodemodel.INode;

@SuppressWarnings("all")
public class VersionRangeConverter extends AbstractLexerBasedConverter<String> {
  public String toValue(final String string, final INode node) throws ValueConverterException {
    boolean _equals = Objects.equal(string, null);
    if (_equals) {
      return null;
    }
    return TargetPlatformConverter.parseVersionRange(string, node);
  }
}
