/*******************************************************************************
 * Copyright (c) 2012-2014 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Mikael Barbero (Obeo) - initial API and implementation
 *******************************************************************************/
package fr.obeo.releng.targetplatform.conversion

import com.google.common.collect.ImmutableSet
import com.google.inject.Singleton
import java.util.Set
import org.eclipse.equinox.p2.metadata.VersionRange
import org.eclipse.xtext.Assignment
import org.eclipse.xtext.Grammar
import org.eclipse.xtext.GrammarUtil
import org.eclipse.xtext.RuleCall
import org.eclipse.xtext.common.services.DefaultTerminalConverters
import org.eclipse.xtext.conversion.IValueConverter
import org.eclipse.xtext.conversion.ValueConverter
import org.eclipse.xtext.conversion.ValueConverterException
import org.eclipse.xtext.conversion.impl.AbstractNullSafeConverter
import org.eclipse.xtext.conversion.impl.STRINGValueConverter
import org.eclipse.xtext.nodemodel.INode
import org.eclipse.xtext.util.Strings

@Singleton
class TargetPlatformConverter extends DefaultTerminalConverters {
	
	val IValueConverter<String> versionRangeValueConverter = new VersionRangeConverter()
	
	@ValueConverter(rule = "VersionRange")
	def IValueConverter<String> getVersionRangeConverter() {
		return versionRangeValueConverter
	}
	
	val IValueConverter<String> stringValueConverter = new TargetPlatformSTRINGValueConverter()
	
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
	
	IValueConverter<String> qualifiedNameValueConverter
	
	@ValueConverter(rule = "QualifiedName")
	def IValueConverter<String> getQualifiedNameConverter() {
		if (qualifiedNameValueConverter === null) {
			qualifiedNameValueConverter = new FQNConverter(grammar)
		}
		return qualifiedNameValueConverter
	}
}

class VersionRangeConverter extends AbstractNullSafeConverter<String> {
	
	override protected internalToValue(String string, INode node) throws ValueConverterException {
		return TargetPlatformConverter::parseVersionRange(string, node)
	}
	
	override protected internalToString(String value) {
		return value;
	}
}

class TargetPlatformSTRINGValueConverter extends STRINGValueConverter {
	
	override toValue(String string, INode node) {
		if (string === null) {
			return null;
		}
		val ge = node.grammarElement as RuleCall
		val container = ge.eContainer as Assignment
		val value = Strings.convertFromJavaString(string.substring(1, string.length() - 1), true)
		if (value !== null && container !== null && "version".equals(container.feature)) {
			return TargetPlatformConverter::parseVersionRange(value, node)
		} else {
			return value
		}
	}
}

/*******************************************************************************
 * Copyright (c) 2008,2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
 /**
 * Copy/paste from Mwe2ValueConverters
 */
class FQNConverter extends AbstractNullSafeConverter<String> {
		
	val Set<String> allKeywords
	
	new(Grammar grammar) {
		allKeywords = ImmutableSet.copyOf(GrammarUtil.getAllKeywords(grammar));
	}
		
	override internalToValue(String string, INode node) {
		return string.replaceAll("[\\^\\s]", "");
	}

	override internalToString(String value) {
		val segments = value.split("\\.");
		val builder = new StringBuilder(value.length());
		var first = true;
		for(String segment: segments) {
			if (!first)
				builder.append('.');
			if (allKeywords.contains(segment)) {
				builder.append("^");
			}
			builder.append(segment);
			first = false;
		}
		return builder.toString();
	}
}