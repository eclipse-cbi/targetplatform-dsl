package fr.obeo.releng.targetplatform.conversion;

import com.google.common.base.Objects;
import fr.obeo.releng.targetplatform.conversion.TargetPlatformConverter;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.conversion.impl.STRINGValueConverter;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.util.Strings;

@SuppressWarnings("all")
public class TargetPlatformSTRINGValueConverter extends STRINGValueConverter {
  public String toValue(final String string, final INode node) {
    boolean _equals = Objects.equal(string, null);
    if (_equals) {
      return null;
    }
    EObject _grammarElement = node.getGrammarElement();
    final RuleCall ge = ((RuleCall) _grammarElement);
    EObject _eContainer = ge.eContainer();
    final Assignment container = ((Assignment) _eContainer);
    int _length = string.length();
    int _minus = (_length - 1);
    String _substring = string.substring(1, _minus);
    final String value = Strings.convertFromJavaString(_substring, true);
    boolean _and = false;
    boolean _and_1 = false;
    boolean _notEquals = (!Objects.equal(value, null));
    if (!_notEquals) {
      _and_1 = false;
    } else {
      boolean _notEquals_1 = (!Objects.equal(container, null));
      _and_1 = _notEquals_1;
    }
    if (!_and_1) {
      _and = false;
    } else {
      String _feature = container.getFeature();
      boolean _equals_1 = "version".equals(_feature);
      _and = _equals_1;
    }
    if (_and) {
      return TargetPlatformConverter.parseVersionRange(value, node);
    } else {
      return value;
    }
  }
}
