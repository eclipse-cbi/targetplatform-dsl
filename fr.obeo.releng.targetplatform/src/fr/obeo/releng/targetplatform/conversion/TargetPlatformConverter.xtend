package fr.obeo.releng.targetplatform.conversion

import com.google.inject.Singleton
import org.eclipse.xtext.Assignment
import org.eclipse.xtext.RuleCall
import org.eclipse.xtext.common.services.DefaultTerminalConverters
import org.eclipse.xtext.conversion.IValueConverter
import org.eclipse.xtext.conversion.ValueConverter
import org.eclipse.xtext.conversion.ValueConverterException
import org.eclipse.xtext.conversion.impl.AbstractLexerBasedConverter
import org.eclipse.xtext.conversion.impl.STRINGValueConverter
import org.eclipse.xtext.nodemodel.INode
import org.eclipse.xtext.util.Strings
import org.osgi.framework.VersionRange

@Singleton
class TargetPlatformConverter extends DefaultTerminalConverters {
	
	IValueConverter<String> versionRangeValueConverter = new VersionRangeConverter()
	
	@ValueConverter(rule = "VersionRange")
	def IValueConverter<String> getMyRuleNameConverter() {
		return versionRangeValueConverter
	}
	
	IValueConverter<String> stringValueConverter = new TargetPlatformSTRINGValueConverter()
	
	@ValueConverter(rule = "STRING")
	def IValueConverter<String> getStringValueConverter() {
		return stringValueConverter;
	}
	
	static def parseVersionRange(String string, INode node) {
		if (Strings.isEmpty(string))
			throw new ValueConverterException("Couldn't convert empty string to a VersionRange value.", node, null);
		if (!"lazy".equalsIgnoreCase(string)) {
			try {
				val value = new VersionRange(string);
				return value.toString;
			} catch (IllegalArgumentException e) {
				throw new ValueConverterException("Couldn't convert '" + string + "' to a VersionRange value.", node, e);
			}
		} else {
			return string;
		}
	}
}

class VersionRangeConverter extends AbstractLexerBasedConverter<String> {	
	override toValue(String string, INode node) throws ValueConverterException {
		if (string == null) {
			return null;
		}
		return TargetPlatformConverter::parseVersionRange(string, node)
	}
}

class TargetPlatformSTRINGValueConverter extends STRINGValueConverter {
	
	override toValue(String string, INode node) {
		if (string == null) {
			return null;
		}
		val ge = node.grammarElement as RuleCall
		val container = ge.eContainer as Assignment
		val value = Strings.convertFromJavaString(string.substring(1, string.length() - 1), true)
		if (value != null && container != null && "version".equals(container.feature)) {
			return TargetPlatformConverter::parseVersionRange(value, node)
		} else {
			return value
		}
	}
}
