package fr.obeo.releng.targetplatform.conversion;

import org.eclipse.xtext.conversion.impl.IDValueConverter;
import org.eclipse.xtext.nodemodel.INode;

public class TargetPlatformIDValueConverter extends IDValueConverter {

	@Override
	public String toValue(String string, INode node) {
		if (string == null)
			return null;
		return (string.startsWith("^") ? string.substring(1) : string).replaceAll("\\^", "");
	}
}
