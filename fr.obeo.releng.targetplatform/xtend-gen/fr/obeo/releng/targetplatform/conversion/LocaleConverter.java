package fr.obeo.releng.targetplatform.conversion;

import com.google.common.base.Splitter;
import java.util.Iterator;
import java.util.Locale;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.conversion.impl.AbstractNullSafeConverter;
import org.eclipse.xtext.nodemodel.INode;

@SuppressWarnings("all")
public class LocaleConverter extends AbstractNullSafeConverter<Locale> {
  protected Locale internalToValue(final String string, final INode node) throws ValueConverterException {
    String language = "";
    String country = "";
    String variant = "";
    Splitter _on = Splitter.on("_");
    Splitter _trimResults = _on.trimResults();
    Iterable<String> _split = _trimResults.split(string);
    final Iterator<String> tokens = _split.iterator();
    boolean _hasNext = tokens.hasNext();
    if (_hasNext) {
      String _next = tokens.next();
      language = _next;
    }
    boolean _hasNext_1 = tokens.hasNext();
    if (_hasNext_1) {
      String _next_1 = tokens.next();
      country = _next_1;
    }
    boolean _hasNext_2 = tokens.hasNext();
    if (_hasNext_2) {
      String _next_2 = tokens.next();
      variant = _next_2;
    }
    return new Locale(language, country, variant);
  }
  
  protected String internalToString(final Locale value) {
    return value.toString();
  }
}
