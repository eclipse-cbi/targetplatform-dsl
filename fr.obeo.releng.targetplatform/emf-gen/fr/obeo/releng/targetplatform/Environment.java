/**
 */
package fr.obeo.releng.targetplatform;

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
 * <ul>
 *   <li>{@link fr.obeo.releng.targetplatform.Environment#getEnv <em>Env</em>}</li>
 *   <li>{@link fr.obeo.releng.targetplatform.Environment#getOperatingSystem <em>Operating System</em>}</li>
 *   <li>{@link fr.obeo.releng.targetplatform.Environment#getWindowingSystem <em>Windowing System</em>}</li>
 *   <li>{@link fr.obeo.releng.targetplatform.Environment#getArchitecture <em>Architecture</em>}</li>
 *   <li>{@link fr.obeo.releng.targetplatform.Environment#getLocalization <em>Localization</em>}</li>
 *   <li>{@link fr.obeo.releng.targetplatform.Environment#getExecutionEnvironment <em>Execution Environment</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.obeo.releng.targetplatform.TargetPlatformPackage#getEnvironment()
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
	 * @see fr.obeo.releng.targetplatform.TargetPlatformPackage#getEnvironment_Env()
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
	 * @see fr.obeo.releng.targetplatform.TargetPlatformPackage#getEnvironment_OperatingSystem()
	 * @model unique="false" transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='<%org.eclipse.emf.common.util.EList%><<%java.lang.String%>> _env = this.getEnv();\nfinal <%org.eclipse.xtext.xbase.lib.Functions.Function1%><<%java.lang.String%>, <%java.lang.String%>> _function = new <%org.eclipse.xtext.xbase.lib.Functions.Function1%><<%java.lang.String%>, <%java.lang.String%>>()\n{\n\tpublic <%java.lang.String%> apply(final <%java.lang.String%> it)\n\t{\n\t\treturn it.toUpperCase();\n\t}\n};\nfinal <%org.eclipse.emf.common.util.EList%><<%java.lang.String%>> envToUpper = <%org.eclipse.emf.ecore.xcore.lib.XcoreEListExtensions%>.<<%java.lang.String%>, <%java.lang.String%>>map(_env, _function);\n<%java.lang.String%>[] _knownOSValues = <%org.eclipse.core.runtime.Platform%>.knownOSValues();\nfinal <%org.eclipse.xtext.xbase.lib.Functions.Function1%><<%java.lang.String%>, <%java.lang.Boolean%>> _function_1 = new <%org.eclipse.xtext.xbase.lib.Functions.Function1%><<%java.lang.String%>, <%java.lang.Boolean%>>()\n{\n\tpublic <%java.lang.Boolean%> apply(final <%java.lang.String%> it)\n\t{\n\t\t<%java.lang.String%> _upperCase = it.toUpperCase();\n\t\treturn <%java.lang.Boolean%>.valueOf(envToUpper.contains(_upperCase));\n\t}\n};\nreturn <%org.eclipse.xtext.xbase.lib.IterableExtensions%>.<<%java.lang.String%>>findFirst(((<%java.lang.Iterable%><<%java.lang.String%>>)org.eclipse.xtext.xbase.lib.Conversions.doWrapArray(_knownOSValues)), _function_1);'"
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
	 * @see fr.obeo.releng.targetplatform.TargetPlatformPackage#getEnvironment_WindowingSystem()
	 * @model unique="false" transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='<%org.eclipse.emf.common.util.EList%><<%java.lang.String%>> _env = this.getEnv();\nfinal <%org.eclipse.xtext.xbase.lib.Functions.Function1%><<%java.lang.String%>, <%java.lang.String%>> _function = new <%org.eclipse.xtext.xbase.lib.Functions.Function1%><<%java.lang.String%>, <%java.lang.String%>>()\n{\n\tpublic <%java.lang.String%> apply(final <%java.lang.String%> it)\n\t{\n\t\treturn it.toUpperCase();\n\t}\n};\nfinal <%org.eclipse.emf.common.util.EList%><<%java.lang.String%>> envToUpper = <%org.eclipse.emf.ecore.xcore.lib.XcoreEListExtensions%>.<<%java.lang.String%>, <%java.lang.String%>>map(_env, _function);\n<%java.lang.String%>[] _knownWSValues = <%org.eclipse.core.runtime.Platform%>.knownWSValues();\nfinal <%org.eclipse.xtext.xbase.lib.Functions.Function1%><<%java.lang.String%>, <%java.lang.Boolean%>> _function_1 = new <%org.eclipse.xtext.xbase.lib.Functions.Function1%><<%java.lang.String%>, <%java.lang.Boolean%>>()\n{\n\tpublic <%java.lang.Boolean%> apply(final <%java.lang.String%> it)\n\t{\n\t\t<%java.lang.String%> _upperCase = it.toUpperCase();\n\t\treturn <%java.lang.Boolean%>.valueOf(envToUpper.contains(_upperCase));\n\t}\n};\nfinal <%java.lang.String%> mathchingWS = <%org.eclipse.xtext.xbase.lib.IterableExtensions%>.<<%java.lang.String%>>findFirst(((<%java.lang.Iterable%><<%java.lang.String%>>)org.eclipse.xtext.xbase.lib.Conversions.doWrapArray(_knownWSValues)), _function_1);\n<%java.lang.String%>[] _knownWSValues_1 = <%org.eclipse.core.runtime.Platform%>.knownWSValues();\nfinal <%org.eclipse.xtext.xbase.lib.Functions.Function1%><<%java.lang.String%>, <%java.lang.String%>> _function_2 = new <%org.eclipse.xtext.xbase.lib.Functions.Function1%><<%java.lang.String%>, <%java.lang.String%>>()\n{\n\tpublic <%java.lang.String%> apply(final <%java.lang.String%> it)\n\t{\n\t\treturn it.toUpperCase();\n\t}\n};\nfinal <%java.util.List%><<%java.lang.String%>> knownWSUpperValues = <%org.eclipse.xtext.xbase.lib.ListExtensions%>.<<%java.lang.String%>, <%java.lang.String%>>map(((<%java.util.List%><<%java.lang.String%>>)org.eclipse.xtext.xbase.lib.Conversions.doWrapArray(_knownWSValues_1)), _function_2);\n<%org.eclipse.emf.common.util.EList%><<%java.lang.String%>> _env_1 = this.getEnv();\nfinal <%org.eclipse.xtext.xbase.lib.Functions.Function1%><<%java.lang.String%>, <%java.lang.Boolean%>> _function_3 = new <%org.eclipse.xtext.xbase.lib.Functions.Function1%><<%java.lang.String%>, <%java.lang.Boolean%>>()\n{\n\tpublic <%java.lang.Boolean%> apply(final <%java.lang.String%> it)\n\t{\n\t\t<%java.lang.String%> _upperCase = it.toUpperCase();\n\t\treturn <%java.lang.Boolean%>.valueOf(knownWSUpperValues.contains(_upperCase));\n\t}\n};\nfinal <%java.lang.Iterable%><<%java.lang.String%>> allWS = <%org.eclipse.xtext.xbase.lib.IterableExtensions%>.<<%java.lang.String%>>filter(_env_1, _function_3);\nboolean _and = false;\nint _size = <%org.eclipse.xtext.xbase.lib.IterableExtensions%>.size(allWS);\nboolean _lessEqualsThan = (_size <= 1);\nif (!_lessEqualsThan)\n{\n\t_and = false;\n} else\n{\n\tboolean _or = false;\n\t<%java.lang.String%> _head = <%org.eclipse.xtext.xbase.lib.IterableExtensions%>.<<%java.lang.String%>>head(allWS);\n\tboolean _equals = <%com.google.common.base.Objects%>.equal(_head, null);\n\tif (_equals)\n\t{\n\t\t_or = true;\n\t} else\n\t{\n\t\t<%java.lang.String%> _head_1 = <%org.eclipse.xtext.xbase.lib.IterableExtensions%>.<<%java.lang.String%>>head(allWS);\n\t\t<%java.lang.String%> _operatingSystem = this.getOperatingSystem();\n\t\tboolean _equalsIgnoreCase = _head_1.equalsIgnoreCase(_operatingSystem);\n\t\t_or = _equalsIgnoreCase;\n\t}\n\t_and = _or;\n}\nif (_and)\n{\n\treturn null;\n}\nelse\n{\n\treturn mathchingWS;\n}'"
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
	 * @see fr.obeo.releng.targetplatform.TargetPlatformPackage#getEnvironment_Architecture()
	 * @model unique="false" transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='<%org.eclipse.emf.common.util.EList%><<%java.lang.String%>> _env = this.getEnv();\nfinal <%org.eclipse.xtext.xbase.lib.Functions.Function1%><<%java.lang.String%>, <%java.lang.String%>> _function = new <%org.eclipse.xtext.xbase.lib.Functions.Function1%><<%java.lang.String%>, <%java.lang.String%>>()\n{\n\tpublic <%java.lang.String%> apply(final <%java.lang.String%> it)\n\t{\n\t\treturn it.toUpperCase();\n\t}\n};\nfinal <%org.eclipse.emf.common.util.EList%><<%java.lang.String%>> envToUpper = <%org.eclipse.emf.ecore.xcore.lib.XcoreEListExtensions%>.<<%java.lang.String%>, <%java.lang.String%>>map(_env, _function);\n<%java.lang.String%>[] _knownOSArchValues = <%org.eclipse.core.runtime.Platform%>.knownOSArchValues();\nfinal <%org.eclipse.xtext.xbase.lib.Functions.Function1%><<%java.lang.String%>, <%java.lang.Boolean%>> _function_1 = new <%org.eclipse.xtext.xbase.lib.Functions.Function1%><<%java.lang.String%>, <%java.lang.Boolean%>>()\n{\n\tpublic <%java.lang.Boolean%> apply(final <%java.lang.String%> it)\n\t{\n\t\t<%java.lang.String%> _upperCase = it.toUpperCase();\n\t\treturn <%java.lang.Boolean%>.valueOf(envToUpper.contains(_upperCase));\n\t}\n};\nreturn <%org.eclipse.xtext.xbase.lib.IterableExtensions%>.<<%java.lang.String%>>findFirst(((<%java.lang.Iterable%><<%java.lang.String%>>)org.eclipse.xtext.xbase.lib.Conversions.doWrapArray(_knownOSArchValues)), _function_1);'"
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
	 * @see fr.obeo.releng.targetplatform.TargetPlatformPackage#getEnvironment_Localization()
	 * @model unique="false" dataType="fr.obeo.releng.targetplatform.Locale" transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='<%java.util.Locale%>[] _availableLocales = <%java.util.Locale%>.getAvailableLocales();\nfinal <%org.eclipse.xtext.xbase.lib.Functions.Function1%><<%java.util.Locale%>, <%java.lang.String%>> _function = new <%org.eclipse.xtext.xbase.lib.Functions.Function1%><<%java.util.Locale%>, <%java.lang.String%>>()\n{\n\tpublic <%java.lang.String%> apply(final <%java.util.Locale%> it)\n\t{\n\t\treturn it.toString();\n\t}\n};\n<%java.util.List%><<%java.lang.String%>> _map = <%org.eclipse.xtext.xbase.lib.ListExtensions%>.<<%java.util.Locale%>, <%java.lang.String%>>map(((<%java.util.List%><<%java.util.Locale%>>)org.eclipse.xtext.xbase.lib.Conversions.doWrapArray(_availableLocales)), _function);\nfinal <%org.eclipse.xtext.xbase.lib.Functions.Function1%><<%java.lang.String%>, <%java.lang.String%>> _function_1 = new <%org.eclipse.xtext.xbase.lib.Functions.Function1%><<%java.lang.String%>, <%java.lang.String%>>()\n{\n\tpublic <%java.lang.String%> apply(final <%java.lang.String%> it)\n\t{\n\t\treturn it.toUpperCase();\n\t}\n};\nfinal <%java.util.List%><<%java.lang.String%>> availableLocales = <%org.eclipse.xtext.xbase.lib.ListExtensions%>.<<%java.lang.String%>, <%java.lang.String%>>map(_map, _function_1);\n<%org.eclipse.emf.common.util.EList%><<%java.lang.String%>> _env = this.getEnv();\nfinal <%org.eclipse.xtext.xbase.lib.Functions.Function1%><<%java.lang.String%>, <%java.lang.Boolean%>> _function_2 = new <%org.eclipse.xtext.xbase.lib.Functions.Function1%><<%java.lang.String%>, <%java.lang.Boolean%>>()\n{\n\tpublic <%java.lang.Boolean%> apply(final <%java.lang.String%> it)\n\t{\n\t\t<%java.lang.String%> _upperCase = it.toUpperCase();\n\t\treturn <%java.lang.Boolean%>.valueOf(availableLocales.contains(_upperCase));\n\t}\n};\nfinal <%java.lang.String%> locale = <%org.eclipse.xtext.xbase.lib.IterableExtensions%>.<<%java.lang.String%>>findFirst(_env, _function_2);\nboolean _notEquals = (!<%com.google.common.base.Objects%>.equal(locale, null));\nif (_notEquals)\n{\n\t<%java.lang.String%> language = \"\";\n\t<%java.lang.String%> country = \"\";\n\t<%java.lang.String%> variant = \"\";\n\t<%com.google.common.base.Splitter%> _on = <%com.google.common.base.Splitter%>.on(\"_\");\n\t<%com.google.common.base.Splitter%> _trimResults = _on.trimResults();\n\t<%java.lang.Iterable%><<%java.lang.String%>> _split = _trimResults.split(locale);\n\tfinal <%java.util.Iterator%><<%java.lang.String%>> tokens = _split.iterator();\n\tboolean _hasNext = tokens.hasNext();\n\tif (_hasNext)\n\t{\n\t\t<%java.lang.String%> _next = tokens.next();\n\t\tlanguage = _next;\n\t}\n\tboolean _hasNext_1 = tokens.hasNext();\n\tif (_hasNext_1)\n\t{\n\t\t<%java.lang.String%> _next_1 = tokens.next();\n\t\tcountry = _next_1;\n\t}\n\tboolean _hasNext_2 = tokens.hasNext();\n\tif (_hasNext_2)\n\t{\n\t\t<%java.lang.String%> _next_2 = tokens.next();\n\t\tvariant = _next_2;\n\t}\n\treturn new <%java.util.Locale%>(language, country, variant);\n}\nelse\n{\n\treturn null;\n}'"
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
	 * @see fr.obeo.releng.targetplatform.TargetPlatformPackage#getEnvironment_ExecutionEnvironment()
	 * @model unique="false" dataType="fr.obeo.releng.targetplatform.ExecutionEnvironment" transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='final <%org.eclipse.jdt.launching.environments.IExecutionEnvironmentsManager%> eeManager = <%org.eclipse.jdt.launching.JavaRuntime%>.getExecutionEnvironmentsManager();\nboolean _notEquals = (!<%com.google.common.base.Objects%>.equal(eeManager, null));\nif (_notEquals)\n{\n\t<%org.eclipse.emf.common.util.EList%><<%java.lang.String%>> _env = this.getEnv();\n\tfinal <%org.eclipse.xtext.xbase.lib.Functions.Function1%><<%java.lang.String%>, <%java.lang.Boolean%>> _function = new <%org.eclipse.xtext.xbase.lib.Functions.Function1%><<%java.lang.String%>, <%java.lang.Boolean%>>()\n\t{\n\t\tpublic <%java.lang.Boolean%> apply(final <%java.lang.String%> it)\n\t\t{\n\t\t\t<%org.eclipse.jdt.launching.environments.IExecutionEnvironment%> _environment = eeManager.getEnvironment(it);\n\t\t\treturn <%java.lang.Boolean%>.valueOf((!<%com.google.common.base.Objects%>.equal(_environment, null)));\n\t\t}\n\t};\n\tfinal <%java.lang.String%> ee = <%org.eclipse.xtext.xbase.lib.IterableExtensions%>.<<%java.lang.String%>>findFirst(_env, _function);\n\tboolean _notEquals_1 = (!<%com.google.common.base.Objects%>.equal(ee, null));\n\tif (_notEquals_1)\n\t{\n\t\treturn eeManager.getEnvironment(ee);\n\t}\n\telse\n\t{\n\t\treturn null;\n\t}\n}\nelse\n{\n\treturn null;\n}'"
	 * @generated
	 */
	IExecutionEnvironment getExecutionEnvironment();

} // Environment
