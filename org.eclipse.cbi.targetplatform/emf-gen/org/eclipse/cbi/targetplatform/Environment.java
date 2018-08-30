/**
 */
package org.eclipse.cbi.targetplatform;

import java.util.Locale;

import org.eclipse.emf.common.util.EList;

import org.eclipse.jdt.launching.environments.IExecutionEnvironment;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Environment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.cbi.targetplatform.Environment#getEnv <em>Env</em>}</li>
 *   <li>{@link org.eclipse.cbi.targetplatform.Environment#getOperatingSystem <em>Operating System</em>}</li>
 *   <li>{@link org.eclipse.cbi.targetplatform.Environment#getWindowingSystem <em>Windowing System</em>}</li>
 *   <li>{@link org.eclipse.cbi.targetplatform.Environment#getArchitecture <em>Architecture</em>}</li>
 *   <li>{@link org.eclipse.cbi.targetplatform.Environment#getLocalization <em>Localization</em>}</li>
 *   <li>{@link org.eclipse.cbi.targetplatform.Environment#getExecutionEnvironment <em>Execution Environment</em>}</li>
 * </ul>
 *
 * @see org.eclipse.cbi.targetplatform.TargetPlatformPackage#getEnvironment()
 * @model
 * @generated
 */
public interface Environment extends TargetContent {
	/**
	 * Returns the value of the '<em><b>Env</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Env</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Env</em>' attribute list.
	 * @see org.eclipse.cbi.targetplatform.TargetPlatformPackage#getEnvironment_Env()
	 * @model unique="false"
	 * @generated
	 */
	EList<String> getEnv();

	/**
	 * Returns the value of the '<em><b>Operating System</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operating System</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operating System</em>' attribute.
	 * @see org.eclipse.cbi.targetplatform.TargetPlatformPackage#getEnvironment_OperatingSystem()
	 * @model unique="false" transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='final <%org.eclipse.xtext.xbase.lib.Functions.Function1%><<%org.eclipse.cbi.targetplatform.Environment%>, <%org.eclipse.emf.common.util.EList%><<%java.lang.String%>>> _function = new <%org.eclipse.xtext.xbase.lib.Functions.Function1%><<%org.eclipse.cbi.targetplatform.Environment%>, <%org.eclipse.emf.common.util.EList%><<%java.lang.String%>>>()\n{\n\tpublic <%org.eclipse.emf.common.util.EList%><<%java.lang.String%>> apply(final <%org.eclipse.cbi.targetplatform.Environment%> it)\n\t{\n\t\treturn it.getEnv();\n\t}\n};\nfinal <%org.eclipse.xtext.xbase.lib.Functions.Function1%><<%java.lang.String%>, <%java.lang.Boolean%>> _function_1 = new <%org.eclipse.xtext.xbase.lib.Functions.Function1%><<%java.lang.String%>, <%java.lang.Boolean%>>()\n{\n\tpublic <%java.lang.Boolean%> apply(final <%java.lang.String%> it)\n\t{\n\t\tboolean _isNullOrEmpty = <%org.eclipse.xtext.xbase.lib.StringExtensions%>.isNullOrEmpty(it);\n\t\treturn <%java.lang.Boolean%>.valueOf((!_isNullOrEmpty));\n\t}\n};\nfinal <%org.eclipse.xtext.xbase.lib.Functions.Function1%><<%java.lang.String%>, <%java.lang.String%>> _function_2 = new <%org.eclipse.xtext.xbase.lib.Functions.Function1%><<%java.lang.String%>, <%java.lang.String%>>()\n{\n\tpublic <%java.lang.String%> apply(final <%java.lang.String%> it)\n\t{\n\t\treturn it.toUpperCase();\n\t}\n};\nfinal <%java.util.List%><<%java.lang.String%>> envToUpper = <%org.eclipse.xtext.xbase.lib.IterableExtensions%>.<<%java.lang.String%>>toList(<%org.eclipse.xtext.xbase.lib.IterableExtensions%>.<<%java.lang.String%>, <%java.lang.String%>>map(<%org.eclipse.xtext.xbase.lib.IterableExtensions%>.<<%java.lang.String%>>filter(<%com.google.common.collect.Iterables%>.<<%java.lang.String%>>concat(<%org.eclipse.xtext.xbase.lib.IterableExtensions%>.<<%org.eclipse.cbi.targetplatform.Environment%>, <%org.eclipse.emf.common.util.EList%><<%java.lang.String%>>>map(<%com.google.common.collect.Iterables%>.<<%org.eclipse.cbi.targetplatform.Environment%>>filter(this.getTargetPlatform().getContents(), <%org.eclipse.cbi.targetplatform.Environment%>.class), _function)), _function_1), _function_2));\nfinal <%org.eclipse.xtext.xbase.lib.Functions.Function1%><<%java.lang.String%>, <%java.lang.Boolean%>> _function_3 = new <%org.eclipse.xtext.xbase.lib.Functions.Function1%><<%java.lang.String%>, <%java.lang.Boolean%>>()\n{\n\tpublic <%java.lang.Boolean%> apply(final <%java.lang.String%> it)\n\t{\n\t\treturn <%java.lang.Boolean%>.valueOf(envToUpper.contains(it.toUpperCase()));\n\t}\n};\nreturn <%org.eclipse.xtext.xbase.lib.IterableExtensions%>.<<%java.lang.String%>>findFirst(((<%java.lang.Iterable%><<%java.lang.String%>>)org.eclipse.xtext.xbase.lib.Conversions.doWrapArray(<%org.eclipse.core.runtime.Platform%>.knownOSValues())), _function_3);'"
	 * @generated
	 */
	String getOperatingSystem();

	/**
	 * Returns the value of the '<em><b>Windowing System</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Windowing System</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Windowing System</em>' attribute.
	 * @see org.eclipse.cbi.targetplatform.TargetPlatformPackage#getEnvironment_WindowingSystem()
	 * @model unique="false" transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='final <%org.eclipse.xtext.xbase.lib.Functions.Function1%><<%org.eclipse.cbi.targetplatform.Environment%>, <%org.eclipse.emf.common.util.EList%><<%java.lang.String%>>> _function = new <%org.eclipse.xtext.xbase.lib.Functions.Function1%><<%org.eclipse.cbi.targetplatform.Environment%>, <%org.eclipse.emf.common.util.EList%><<%java.lang.String%>>>()\n{\n\tpublic <%org.eclipse.emf.common.util.EList%><<%java.lang.String%>> apply(final <%org.eclipse.cbi.targetplatform.Environment%> it)\n\t{\n\t\treturn it.getEnv();\n\t}\n};\nfinal <%org.eclipse.xtext.xbase.lib.Functions.Function1%><<%java.lang.String%>, <%java.lang.Boolean%>> _function_1 = new <%org.eclipse.xtext.xbase.lib.Functions.Function1%><<%java.lang.String%>, <%java.lang.Boolean%>>()\n{\n\tpublic <%java.lang.Boolean%> apply(final <%java.lang.String%> it)\n\t{\n\t\tboolean _isNullOrEmpty = <%org.eclipse.xtext.xbase.lib.StringExtensions%>.isNullOrEmpty(it);\n\t\treturn <%java.lang.Boolean%>.valueOf((!_isNullOrEmpty));\n\t}\n};\nfinal <%org.eclipse.xtext.xbase.lib.Functions.Function1%><<%java.lang.String%>, <%java.lang.String%>> _function_2 = new <%org.eclipse.xtext.xbase.lib.Functions.Function1%><<%java.lang.String%>, <%java.lang.String%>>()\n{\n\tpublic <%java.lang.String%> apply(final <%java.lang.String%> it)\n\t{\n\t\treturn it.toUpperCase();\n\t}\n};\nfinal <%java.util.List%><<%java.lang.String%>> envToUpper = <%org.eclipse.xtext.xbase.lib.IterableExtensions%>.<<%java.lang.String%>>toList(<%org.eclipse.xtext.xbase.lib.IterableExtensions%>.<<%java.lang.String%>, <%java.lang.String%>>map(<%org.eclipse.xtext.xbase.lib.IterableExtensions%>.<<%java.lang.String%>>filter(<%com.google.common.collect.Iterables%>.<<%java.lang.String%>>concat(<%org.eclipse.xtext.xbase.lib.IterableExtensions%>.<<%org.eclipse.cbi.targetplatform.Environment%>, <%org.eclipse.emf.common.util.EList%><<%java.lang.String%>>>map(<%com.google.common.collect.Iterables%>.<<%org.eclipse.cbi.targetplatform.Environment%>>filter(this.getTargetPlatform().getContents(), <%org.eclipse.cbi.targetplatform.Environment%>.class), _function)), _function_1), _function_2));\nfinal <%org.eclipse.xtext.xbase.lib.Functions.Function1%><<%java.lang.String%>, <%java.lang.String%>> _function_3 = new <%org.eclipse.xtext.xbase.lib.Functions.Function1%><<%java.lang.String%>, <%java.lang.String%>>()\n{\n\tpublic <%java.lang.String%> apply(final <%java.lang.String%> it)\n\t{\n\t\treturn it.toUpperCase();\n\t}\n};\nfinal <%java.util.List%><<%java.lang.String%>> knownWSUpperValues = <%org.eclipse.xtext.xbase.lib.ListExtensions%>.<<%java.lang.String%>, <%java.lang.String%>>map(((<%java.util.List%><<%java.lang.String%>>)org.eclipse.xtext.xbase.lib.Conversions.doWrapArray(<%org.eclipse.core.runtime.Platform%>.knownWSValues())), _function_3);\nfinal <%org.eclipse.xtext.xbase.lib.Functions.Function1%><<%java.lang.String%>, <%java.lang.Boolean%>> _function_4 = new <%org.eclipse.xtext.xbase.lib.Functions.Function1%><<%java.lang.String%>, <%java.lang.Boolean%>>()\n{\n\tpublic <%java.lang.Boolean%> apply(final <%java.lang.String%> it)\n\t{\n\t\treturn <%java.lang.Boolean%>.valueOf(knownWSUpperValues.contains(it));\n\t}\n};\nfinal <%java.util.List%><<%java.lang.String%>> allWS = <%org.eclipse.xtext.xbase.lib.IterableExtensions%>.<<%java.lang.String%>>toList(<%org.eclipse.xtext.xbase.lib.IterableExtensions%>.<<%java.lang.String%>>filter(envToUpper, _function_4));\nboolean _and = false;\nint _size = allWS.size();\nboolean _lessEqualsThan = (_size <= 1);\nif (!_lessEqualsThan)\n{\n\t_and = false;\n} else\n{\n\t<%java.lang.String%> _operatingSystem = this.getOperatingSystem();\n\t<%java.lang.String%> _upperCase = null;\n\tif (_operatingSystem!=null)\n\t{\n\t\t_upperCase=_operatingSystem.toUpperCase();\n\t}\n\tboolean _contains = allWS.contains(_upperCase);\n\t_and = _contains;\n}\nif (_and)\n{\n\treturn null;\n}\nelse\n{\n\tfinal <%org.eclipse.xtext.xbase.lib.Functions.Function1%><<%java.lang.String%>, <%java.lang.Boolean%>> _function_5 = new <%org.eclipse.xtext.xbase.lib.Functions.Function1%><<%java.lang.String%>, <%java.lang.Boolean%>>()\n\t{\n\t\tpublic <%java.lang.Boolean%> apply(final <%java.lang.String%> it)\n\t\t{\n\t\t\treturn <%java.lang.Boolean%>.valueOf(envToUpper.contains(it.toUpperCase()));\n\t\t}\n\t};\n\treturn <%org.eclipse.xtext.xbase.lib.IterableExtensions%>.<<%java.lang.String%>>findFirst(((<%java.lang.Iterable%><<%java.lang.String%>>)org.eclipse.xtext.xbase.lib.Conversions.doWrapArray(<%org.eclipse.core.runtime.Platform%>.knownWSValues())), _function_5);\n}'"
	 * @generated
	 */
	String getWindowingSystem();

	/**
	 * Returns the value of the '<em><b>Architecture</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Architecture</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Architecture</em>' attribute.
	 * @see org.eclipse.cbi.targetplatform.TargetPlatformPackage#getEnvironment_Architecture()
	 * @model unique="false" transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='final <%org.eclipse.xtext.xbase.lib.Functions.Function1%><<%org.eclipse.cbi.targetplatform.Environment%>, <%org.eclipse.emf.common.util.EList%><<%java.lang.String%>>> _function = new <%org.eclipse.xtext.xbase.lib.Functions.Function1%><<%org.eclipse.cbi.targetplatform.Environment%>, <%org.eclipse.emf.common.util.EList%><<%java.lang.String%>>>()\n{\n\tpublic <%org.eclipse.emf.common.util.EList%><<%java.lang.String%>> apply(final <%org.eclipse.cbi.targetplatform.Environment%> it)\n\t{\n\t\treturn it.getEnv();\n\t}\n};\nfinal <%org.eclipse.xtext.xbase.lib.Functions.Function1%><<%java.lang.String%>, <%java.lang.Boolean%>> _function_1 = new <%org.eclipse.xtext.xbase.lib.Functions.Function1%><<%java.lang.String%>, <%java.lang.Boolean%>>()\n{\n\tpublic <%java.lang.Boolean%> apply(final <%java.lang.String%> it)\n\t{\n\t\tboolean _isNullOrEmpty = <%org.eclipse.xtext.xbase.lib.StringExtensions%>.isNullOrEmpty(it);\n\t\treturn <%java.lang.Boolean%>.valueOf((!_isNullOrEmpty));\n\t}\n};\nfinal <%org.eclipse.xtext.xbase.lib.Functions.Function1%><<%java.lang.String%>, <%java.lang.String%>> _function_2 = new <%org.eclipse.xtext.xbase.lib.Functions.Function1%><<%java.lang.String%>, <%java.lang.String%>>()\n{\n\tpublic <%java.lang.String%> apply(final <%java.lang.String%> it)\n\t{\n\t\treturn it.toUpperCase();\n\t}\n};\nfinal <%java.util.List%><<%java.lang.String%>> envToUpper = <%org.eclipse.xtext.xbase.lib.IterableExtensions%>.<<%java.lang.String%>>toList(<%org.eclipse.xtext.xbase.lib.IterableExtensions%>.<<%java.lang.String%>, <%java.lang.String%>>map(<%org.eclipse.xtext.xbase.lib.IterableExtensions%>.<<%java.lang.String%>>filter(<%com.google.common.collect.Iterables%>.<<%java.lang.String%>>concat(<%org.eclipse.xtext.xbase.lib.IterableExtensions%>.<<%org.eclipse.cbi.targetplatform.Environment%>, <%org.eclipse.emf.common.util.EList%><<%java.lang.String%>>>map(<%com.google.common.collect.Iterables%>.<<%org.eclipse.cbi.targetplatform.Environment%>>filter(this.getTargetPlatform().getContents(), <%org.eclipse.cbi.targetplatform.Environment%>.class), _function)), _function_1), _function_2));\nfinal <%org.eclipse.xtext.xbase.lib.Functions.Function1%><<%java.lang.String%>, <%java.lang.Boolean%>> _function_3 = new <%org.eclipse.xtext.xbase.lib.Functions.Function1%><<%java.lang.String%>, <%java.lang.Boolean%>>()\n{\n\tpublic <%java.lang.Boolean%> apply(final <%java.lang.String%> it)\n\t{\n\t\treturn <%java.lang.Boolean%>.valueOf(envToUpper.contains(it.toUpperCase()));\n\t}\n};\nreturn <%org.eclipse.xtext.xbase.lib.IterableExtensions%>.<<%java.lang.String%>>findFirst(((<%java.lang.Iterable%><<%java.lang.String%>>)org.eclipse.xtext.xbase.lib.Conversions.doWrapArray(<%org.eclipse.core.runtime.Platform%>.knownOSArchValues())), _function_3);'"
	 * @generated
	 */
	String getArchitecture();

	/**
	 * Returns the value of the '<em><b>Localization</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Localization</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Localization</em>' attribute.
	 * @see org.eclipse.cbi.targetplatform.TargetPlatformPackage#getEnvironment_Localization()
	 * @model unique="false" dataType="org.eclipse.cbi.targetplatform.Locale" transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='final <%org.eclipse.xtext.xbase.lib.Functions.Function1%><<%org.eclipse.cbi.targetplatform.Environment%>, <%org.eclipse.emf.common.util.EList%><<%java.lang.String%>>> _function = new <%org.eclipse.xtext.xbase.lib.Functions.Function1%><<%org.eclipse.cbi.targetplatform.Environment%>, <%org.eclipse.emf.common.util.EList%><<%java.lang.String%>>>()\n{\n\tpublic <%org.eclipse.emf.common.util.EList%><<%java.lang.String%>> apply(final <%org.eclipse.cbi.targetplatform.Environment%> it)\n\t{\n\t\treturn it.getEnv();\n\t}\n};\nfinal <%org.eclipse.xtext.xbase.lib.Functions.Function1%><<%java.lang.String%>, <%java.lang.Boolean%>> _function_1 = new <%org.eclipse.xtext.xbase.lib.Functions.Function1%><<%java.lang.String%>, <%java.lang.Boolean%>>()\n{\n\tpublic <%java.lang.Boolean%> apply(final <%java.lang.String%> it)\n\t{\n\t\tboolean _isNullOrEmpty = <%org.eclipse.xtext.xbase.lib.StringExtensions%>.isNullOrEmpty(it);\n\t\treturn <%java.lang.Boolean%>.valueOf((!_isNullOrEmpty));\n\t}\n};\nfinal <%org.eclipse.xtext.xbase.lib.Functions.Function1%><<%java.lang.String%>, <%java.lang.String%>> _function_2 = new <%org.eclipse.xtext.xbase.lib.Functions.Function1%><<%java.lang.String%>, <%java.lang.String%>>()\n{\n\tpublic <%java.lang.String%> apply(final <%java.lang.String%> it)\n\t{\n\t\treturn it.toUpperCase();\n\t}\n};\nfinal <%java.util.List%><<%java.lang.String%>> envToUpper = <%org.eclipse.xtext.xbase.lib.IterableExtensions%>.<<%java.lang.String%>>toList(<%org.eclipse.xtext.xbase.lib.IterableExtensions%>.<<%java.lang.String%>, <%java.lang.String%>>map(<%org.eclipse.xtext.xbase.lib.IterableExtensions%>.<<%java.lang.String%>>filter(<%com.google.common.collect.Iterables%>.<<%java.lang.String%>>concat(<%org.eclipse.xtext.xbase.lib.IterableExtensions%>.<<%org.eclipse.cbi.targetplatform.Environment%>, <%org.eclipse.emf.common.util.EList%><<%java.lang.String%>>>map(<%com.google.common.collect.Iterables%>.<<%org.eclipse.cbi.targetplatform.Environment%>>filter(this.getTargetPlatform().getContents(), <%org.eclipse.cbi.targetplatform.Environment%>.class), _function)), _function_1), _function_2));\nfinal <%org.eclipse.xtext.xbase.lib.Functions.Function1%><<%java.util.Locale%>, <%java.lang.String%>> _function_3 = new <%org.eclipse.xtext.xbase.lib.Functions.Function1%><<%java.util.Locale%>, <%java.lang.String%>>()\n{\n\tpublic <%java.lang.String%> apply(final <%java.util.Locale%> it)\n\t{\n\t\treturn it.toString();\n\t}\n};\nfinal <%org.eclipse.xtext.xbase.lib.Functions.Function1%><<%java.lang.String%>, <%java.lang.Boolean%>> _function_4 = new <%org.eclipse.xtext.xbase.lib.Functions.Function1%><<%java.lang.String%>, <%java.lang.Boolean%>>()\n{\n\tpublic <%java.lang.Boolean%> apply(final <%java.lang.String%> it)\n\t{\n\t\treturn <%java.lang.Boolean%>.valueOf(envToUpper.contains(it.toUpperCase()));\n\t}\n};\nfinal <%java.lang.String%> locale = <%org.eclipse.xtext.xbase.lib.IterableExtensions%>.<<%java.lang.String%>>findFirst(<%org.eclipse.xtext.xbase.lib.ListExtensions%>.<<%java.util.Locale%>, <%java.lang.String%>>map(((<%java.util.List%><<%java.util.Locale%>>)org.eclipse.xtext.xbase.lib.Conversions.doWrapArray(<%java.util.Locale%>.getAvailableLocales())), _function_3), _function_4);\nboolean _notEquals = (!<%com.google.common.base.Objects%>.equal(locale, null));\nif (_notEquals)\n{\n\t<%java.lang.String%> language = \"\";\n\t<%java.lang.String%> country = \"\";\n\t<%java.lang.String%> variant = \"\";\n\tfinal <%java.util.Iterator%><<%java.lang.String%>> tokens = <%com.google.common.base.Splitter%>.on(\"_\").trimResults().split(locale).iterator();\n\tboolean _hasNext = tokens.hasNext();\n\tif (_hasNext)\n\t{\n\t\tlanguage = tokens.next();\n\t}\n\tboolean _hasNext_1 = tokens.hasNext();\n\tif (_hasNext_1)\n\t{\n\t\tcountry = tokens.next();\n\t}\n\tboolean _hasNext_2 = tokens.hasNext();\n\tif (_hasNext_2)\n\t{\n\t\tvariant = tokens.next();\n\t}\n\treturn new <%java.util.Locale%>(language, country, variant);\n}\nelse\n{\n\treturn null;\n}'"
	 * @generated
	 */
	Locale getLocalization();

	/**
	 * Returns the value of the '<em><b>Execution Environment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Execution Environment</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Execution Environment</em>' attribute.
	 * @see org.eclipse.cbi.targetplatform.TargetPlatformPackage#getEnvironment_ExecutionEnvironment()
	 * @model unique="false" dataType="org.eclipse.cbi.targetplatform.ExecutionEnvironment" transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='final <%org.eclipse.jdt.launching.environments.IExecutionEnvironmentsManager%> eeManager = <%org.eclipse.jdt.launching.JavaRuntime%>.getExecutionEnvironmentsManager();\nboolean _notEquals = (!<%com.google.common.base.Objects%>.equal(eeManager, null));\nif (_notEquals)\n{\n\tfinal <%org.eclipse.xtext.xbase.lib.Functions.Function1%><<%org.eclipse.cbi.targetplatform.Environment%>, <%org.eclipse.emf.common.util.EList%><<%java.lang.String%>>> _function = new <%org.eclipse.xtext.xbase.lib.Functions.Function1%><<%org.eclipse.cbi.targetplatform.Environment%>, <%org.eclipse.emf.common.util.EList%><<%java.lang.String%>>>()\n\t{\n\t\tpublic <%org.eclipse.emf.common.util.EList%><<%java.lang.String%>> apply(final <%org.eclipse.cbi.targetplatform.Environment%> it)\n\t\t{\n\t\t\treturn it.getEnv();\n\t\t}\n\t};\n\tfinal <%org.eclipse.xtext.xbase.lib.Functions.Function1%><<%java.lang.String%>, <%java.lang.Boolean%>> _function_1 = new <%org.eclipse.xtext.xbase.lib.Functions.Function1%><<%java.lang.String%>, <%java.lang.Boolean%>>()\n\t{\n\t\tpublic <%java.lang.Boolean%> apply(final <%java.lang.String%> it)\n\t\t{\n\t\t\tboolean _isNullOrEmpty = <%org.eclipse.xtext.xbase.lib.StringExtensions%>.isNullOrEmpty(it);\n\t\t\treturn <%java.lang.Boolean%>.valueOf((!_isNullOrEmpty));\n\t\t}\n\t};\n\tfinal <%org.eclipse.xtext.xbase.lib.Functions.Function1%><<%java.lang.String%>, <%java.lang.String%>> _function_2 = new <%org.eclipse.xtext.xbase.lib.Functions.Function1%><<%java.lang.String%>, <%java.lang.String%>>()\n\t{\n\t\tpublic <%java.lang.String%> apply(final <%java.lang.String%> it)\n\t\t{\n\t\t\treturn it.toUpperCase();\n\t\t}\n\t};\n\tfinal <%java.util.List%><<%java.lang.String%>> envToUpper = <%org.eclipse.xtext.xbase.lib.IterableExtensions%>.<<%java.lang.String%>>toList(<%org.eclipse.xtext.xbase.lib.IterableExtensions%>.<<%java.lang.String%>, <%java.lang.String%>>map(<%org.eclipse.xtext.xbase.lib.IterableExtensions%>.<<%java.lang.String%>>filter(<%com.google.common.collect.Iterables%>.<<%java.lang.String%>>concat(<%org.eclipse.xtext.xbase.lib.IterableExtensions%>.<<%org.eclipse.cbi.targetplatform.Environment%>, <%org.eclipse.emf.common.util.EList%><<%java.lang.String%>>>map(<%com.google.common.collect.Iterables%>.<<%org.eclipse.cbi.targetplatform.Environment%>>filter(this.getTargetPlatform().getContents(), <%org.eclipse.cbi.targetplatform.Environment%>.class), _function)), _function_1), _function_2));\n\tfor (final <%java.lang.String%> env : envToUpper)\n\t{\n\t\t{\n\t\t\tfinal <%org.eclipse.xtext.xbase.lib.Functions.Function1%><<%org.eclipse.jdt.launching.environments.IExecutionEnvironment%>, <%java.lang.Boolean%>> _function_3 = new <%org.eclipse.xtext.xbase.lib.Functions.Function1%><<%org.eclipse.jdt.launching.environments.IExecutionEnvironment%>, <%java.lang.Boolean%>>()\n\t\t\t{\n\t\t\t\tpublic <%java.lang.Boolean%> apply(final <%org.eclipse.jdt.launching.environments.IExecutionEnvironment%> it)\n\t\t\t\t{\n\t\t\t\t\treturn <%java.lang.Boolean%>.valueOf(it.getId().toUpperCase().equals(env));\n\t\t\t\t}\n\t\t\t};\n\t\t\tfinal <%org.eclipse.jdt.launching.environments.IExecutionEnvironment%> ee = <%org.eclipse.xtext.xbase.lib.IterableExtensions%>.<<%org.eclipse.jdt.launching.environments.IExecutionEnvironment%>>findFirst(((<%java.lang.Iterable%><<%org.eclipse.jdt.launching.environments.IExecutionEnvironment%>>)org.eclipse.xtext.xbase.lib.Conversions.doWrapArray(eeManager.getExecutionEnvironments())), _function_3);\n\t\t\tboolean _notEquals_1 = (!<%com.google.common.base.Objects%>.equal(ee, null));\n\t\t\tif (_notEquals_1)\n\t\t\t{\n\t\t\t\treturn ee;\n\t\t\t}\n\t\t}\n\t}\n\treturn null;\n}\nelse\n{\n\treturn null;\n}'"
	 * @generated
	 */
	IExecutionEnvironment getExecutionEnvironment();

} // Environment
