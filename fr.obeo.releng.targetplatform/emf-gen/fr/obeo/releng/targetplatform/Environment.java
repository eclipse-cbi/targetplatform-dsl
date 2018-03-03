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
 * </p>
 * <ul>
 *   <li>{@link fr.obeo.releng.targetplatform.Environment#getEnv <em>Env</em>}</li>
 *   <li>{@link fr.obeo.releng.targetplatform.Environment#getOperatingSystem <em>Operating System</em>}</li>
 *   <li>{@link fr.obeo.releng.targetplatform.Environment#getWindowingSystem <em>Windowing System</em>}</li>
 *   <li>{@link fr.obeo.releng.targetplatform.Environment#getArchitecture <em>Architecture</em>}</li>
 *   <li>{@link fr.obeo.releng.targetplatform.Environment#getLocalization <em>Localization</em>}</li>
 *   <li>{@link fr.obeo.releng.targetplatform.Environment#getExecutionEnvironment <em>Execution Environment</em>}</li>
 * </ul>
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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='final &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%fr.obeo.releng.targetplatform.Environment%&gt;, &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%java.lang.String%&gt;&gt;&gt; _function = new &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%fr.obeo.releng.targetplatform.Environment%&gt;, &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%java.lang.String%&gt;&gt;&gt;()\n{\n\tpublic &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%java.lang.String%&gt;&gt; apply(final &lt;%fr.obeo.releng.targetplatform.Environment%&gt; it)\n\t{\n\t\treturn it.getEnv();\n\t}\n};\nfinal &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.Boolean%&gt;&gt; _function_1 = new &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.Boolean%&gt;&gt;()\n{\n\tpublic &lt;%java.lang.Boolean%&gt; apply(final &lt;%java.lang.String%&gt; it)\n\t{\n\t\tboolean _isNullOrEmpty = &lt;%org.eclipse.xtext.xbase.lib.StringExtensions%&gt;.isNullOrEmpty(it);\n\t\treturn &lt;%java.lang.Boolean%&gt;.valueOf((!_isNullOrEmpty));\n\t}\n};\nfinal &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.String%&gt;&gt; _function_2 = new &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.String%&gt;&gt;()\n{\n\tpublic &lt;%java.lang.String%&gt; apply(final &lt;%java.lang.String%&gt; it)\n\t{\n\t\treturn it.toUpperCase();\n\t}\n};\nfinal &lt;%java.util.List%&gt;&lt;&lt;%java.lang.String%&gt;&gt; envToUpper = &lt;%org.eclipse.xtext.xbase.lib.IterableExtensions%&gt;.&lt;&lt;%java.lang.String%&gt;&gt;toList(&lt;%org.eclipse.xtext.xbase.lib.IterableExtensions%&gt;.&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.String%&gt;&gt;map(&lt;%org.eclipse.xtext.xbase.lib.IterableExtensions%&gt;.&lt;&lt;%java.lang.String%&gt;&gt;filter(&lt;%com.google.common.collect.Iterables%&gt;.&lt;&lt;%java.lang.String%&gt;&gt;concat(&lt;%org.eclipse.xtext.xbase.lib.IterableExtensions%&gt;.&lt;&lt;%fr.obeo.releng.targetplatform.Environment%&gt;, &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%java.lang.String%&gt;&gt;&gt;map(&lt;%com.google.common.collect.Iterables%&gt;.&lt;&lt;%fr.obeo.releng.targetplatform.Environment%&gt;&gt;filter(this.getTargetPlatform().getContents(), &lt;%fr.obeo.releng.targetplatform.Environment%&gt;.class), _function)), _function_1), _function_2));\nfinal &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.Boolean%&gt;&gt; _function_3 = new &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.Boolean%&gt;&gt;()\n{\n\tpublic &lt;%java.lang.Boolean%&gt; apply(final &lt;%java.lang.String%&gt; it)\n\t{\n\t\treturn &lt;%java.lang.Boolean%&gt;.valueOf(envToUpper.contains(it.toUpperCase()));\n\t}\n};\nreturn &lt;%org.eclipse.xtext.xbase.lib.IterableExtensions%&gt;.&lt;&lt;%java.lang.String%&gt;&gt;findFirst(((&lt;%java.lang.Iterable%&gt;&lt;&lt;%java.lang.String%&gt;&gt;)org.eclipse.xtext.xbase.lib.Conversions.doWrapArray(&lt;%org.eclipse.core.runtime.Platform%&gt;.knownOSValues())), _function_3);'"
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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='final &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%fr.obeo.releng.targetplatform.Environment%&gt;, &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%java.lang.String%&gt;&gt;&gt; _function = new &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%fr.obeo.releng.targetplatform.Environment%&gt;, &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%java.lang.String%&gt;&gt;&gt;()\n{\n\tpublic &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%java.lang.String%&gt;&gt; apply(final &lt;%fr.obeo.releng.targetplatform.Environment%&gt; it)\n\t{\n\t\treturn it.getEnv();\n\t}\n};\nfinal &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.Boolean%&gt;&gt; _function_1 = new &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.Boolean%&gt;&gt;()\n{\n\tpublic &lt;%java.lang.Boolean%&gt; apply(final &lt;%java.lang.String%&gt; it)\n\t{\n\t\tboolean _isNullOrEmpty = &lt;%org.eclipse.xtext.xbase.lib.StringExtensions%&gt;.isNullOrEmpty(it);\n\t\treturn &lt;%java.lang.Boolean%&gt;.valueOf((!_isNullOrEmpty));\n\t}\n};\nfinal &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.String%&gt;&gt; _function_2 = new &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.String%&gt;&gt;()\n{\n\tpublic &lt;%java.lang.String%&gt; apply(final &lt;%java.lang.String%&gt; it)\n\t{\n\t\treturn it.toUpperCase();\n\t}\n};\nfinal &lt;%java.util.List%&gt;&lt;&lt;%java.lang.String%&gt;&gt; envToUpper = &lt;%org.eclipse.xtext.xbase.lib.IterableExtensions%&gt;.&lt;&lt;%java.lang.String%&gt;&gt;toList(&lt;%org.eclipse.xtext.xbase.lib.IterableExtensions%&gt;.&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.String%&gt;&gt;map(&lt;%org.eclipse.xtext.xbase.lib.IterableExtensions%&gt;.&lt;&lt;%java.lang.String%&gt;&gt;filter(&lt;%com.google.common.collect.Iterables%&gt;.&lt;&lt;%java.lang.String%&gt;&gt;concat(&lt;%org.eclipse.xtext.xbase.lib.IterableExtensions%&gt;.&lt;&lt;%fr.obeo.releng.targetplatform.Environment%&gt;, &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%java.lang.String%&gt;&gt;&gt;map(&lt;%com.google.common.collect.Iterables%&gt;.&lt;&lt;%fr.obeo.releng.targetplatform.Environment%&gt;&gt;filter(this.getTargetPlatform().getContents(), &lt;%fr.obeo.releng.targetplatform.Environment%&gt;.class), _function)), _function_1), _function_2));\nfinal &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.String%&gt;&gt; _function_3 = new &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.String%&gt;&gt;()\n{\n\tpublic &lt;%java.lang.String%&gt; apply(final &lt;%java.lang.String%&gt; it)\n\t{\n\t\treturn it.toUpperCase();\n\t}\n};\nfinal &lt;%java.util.List%&gt;&lt;&lt;%java.lang.String%&gt;&gt; knownWSUpperValues = &lt;%org.eclipse.xtext.xbase.lib.ListExtensions%&gt;.&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.String%&gt;&gt;map(((&lt;%java.util.List%&gt;&lt;&lt;%java.lang.String%&gt;&gt;)org.eclipse.xtext.xbase.lib.Conversions.doWrapArray(&lt;%org.eclipse.core.runtime.Platform%&gt;.knownWSValues())), _function_3);\nfinal &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.Boolean%&gt;&gt; _function_4 = new &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.Boolean%&gt;&gt;()\n{\n\tpublic &lt;%java.lang.Boolean%&gt; apply(final &lt;%java.lang.String%&gt; it)\n\t{\n\t\treturn &lt;%java.lang.Boolean%&gt;.valueOf(knownWSUpperValues.contains(it));\n\t}\n};\nfinal &lt;%java.util.List%&gt;&lt;&lt;%java.lang.String%&gt;&gt; allWS = &lt;%org.eclipse.xtext.xbase.lib.IterableExtensions%&gt;.&lt;&lt;%java.lang.String%&gt;&gt;toList(&lt;%org.eclipse.xtext.xbase.lib.IterableExtensions%&gt;.&lt;&lt;%java.lang.String%&gt;&gt;filter(envToUpper, _function_4));\nboolean _and = false;\nint _size = allWS.size();\nboolean _lessEqualsThan = (_size &lt;= 1);\nif (!_lessEqualsThan)\n{\n\t_and = false;\n} else\n{\n\t&lt;%java.lang.String%&gt; _operatingSystem = this.getOperatingSystem();\n\t&lt;%java.lang.String%&gt; _upperCase = null;\n\tif (_operatingSystem!=null)\n\t{\n\t\t_upperCase=_operatingSystem.toUpperCase();\n\t}\n\tboolean _contains = allWS.contains(_upperCase);\n\t_and = _contains;\n}\nif (_and)\n{\n\treturn null;\n}\nelse\n{\n\tfinal &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.Boolean%&gt;&gt; _function_5 = new &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.Boolean%&gt;&gt;()\n\t{\n\t\tpublic &lt;%java.lang.Boolean%&gt; apply(final &lt;%java.lang.String%&gt; it)\n\t\t{\n\t\t\treturn &lt;%java.lang.Boolean%&gt;.valueOf(envToUpper.contains(it.toUpperCase()));\n\t\t}\n\t};\n\treturn &lt;%org.eclipse.xtext.xbase.lib.IterableExtensions%&gt;.&lt;&lt;%java.lang.String%&gt;&gt;findFirst(((&lt;%java.lang.Iterable%&gt;&lt;&lt;%java.lang.String%&gt;&gt;)org.eclipse.xtext.xbase.lib.Conversions.doWrapArray(&lt;%org.eclipse.core.runtime.Platform%&gt;.knownWSValues())), _function_5);\n}'"
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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='final &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%fr.obeo.releng.targetplatform.Environment%&gt;, &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%java.lang.String%&gt;&gt;&gt; _function = new &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%fr.obeo.releng.targetplatform.Environment%&gt;, &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%java.lang.String%&gt;&gt;&gt;()\n{\n\tpublic &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%java.lang.String%&gt;&gt; apply(final &lt;%fr.obeo.releng.targetplatform.Environment%&gt; it)\n\t{\n\t\treturn it.getEnv();\n\t}\n};\nfinal &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.Boolean%&gt;&gt; _function_1 = new &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.Boolean%&gt;&gt;()\n{\n\tpublic &lt;%java.lang.Boolean%&gt; apply(final &lt;%java.lang.String%&gt; it)\n\t{\n\t\tboolean _isNullOrEmpty = &lt;%org.eclipse.xtext.xbase.lib.StringExtensions%&gt;.isNullOrEmpty(it);\n\t\treturn &lt;%java.lang.Boolean%&gt;.valueOf((!_isNullOrEmpty));\n\t}\n};\nfinal &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.String%&gt;&gt; _function_2 = new &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.String%&gt;&gt;()\n{\n\tpublic &lt;%java.lang.String%&gt; apply(final &lt;%java.lang.String%&gt; it)\n\t{\n\t\treturn it.toUpperCase();\n\t}\n};\nfinal &lt;%java.util.List%&gt;&lt;&lt;%java.lang.String%&gt;&gt; envToUpper = &lt;%org.eclipse.xtext.xbase.lib.IterableExtensions%&gt;.&lt;&lt;%java.lang.String%&gt;&gt;toList(&lt;%org.eclipse.xtext.xbase.lib.IterableExtensions%&gt;.&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.String%&gt;&gt;map(&lt;%org.eclipse.xtext.xbase.lib.IterableExtensions%&gt;.&lt;&lt;%java.lang.String%&gt;&gt;filter(&lt;%com.google.common.collect.Iterables%&gt;.&lt;&lt;%java.lang.String%&gt;&gt;concat(&lt;%org.eclipse.xtext.xbase.lib.IterableExtensions%&gt;.&lt;&lt;%fr.obeo.releng.targetplatform.Environment%&gt;, &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%java.lang.String%&gt;&gt;&gt;map(&lt;%com.google.common.collect.Iterables%&gt;.&lt;&lt;%fr.obeo.releng.targetplatform.Environment%&gt;&gt;filter(this.getTargetPlatform().getContents(), &lt;%fr.obeo.releng.targetplatform.Environment%&gt;.class), _function)), _function_1), _function_2));\nfinal &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.Boolean%&gt;&gt; _function_3 = new &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.Boolean%&gt;&gt;()\n{\n\tpublic &lt;%java.lang.Boolean%&gt; apply(final &lt;%java.lang.String%&gt; it)\n\t{\n\t\treturn &lt;%java.lang.Boolean%&gt;.valueOf(envToUpper.contains(it.toUpperCase()));\n\t}\n};\nreturn &lt;%org.eclipse.xtext.xbase.lib.IterableExtensions%&gt;.&lt;&lt;%java.lang.String%&gt;&gt;findFirst(((&lt;%java.lang.Iterable%&gt;&lt;&lt;%java.lang.String%&gt;&gt;)org.eclipse.xtext.xbase.lib.Conversions.doWrapArray(&lt;%org.eclipse.core.runtime.Platform%&gt;.knownOSArchValues())), _function_3);'"
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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='final &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%fr.obeo.releng.targetplatform.Environment%&gt;, &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%java.lang.String%&gt;&gt;&gt; _function = new &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%fr.obeo.releng.targetplatform.Environment%&gt;, &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%java.lang.String%&gt;&gt;&gt;()\n{\n\tpublic &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%java.lang.String%&gt;&gt; apply(final &lt;%fr.obeo.releng.targetplatform.Environment%&gt; it)\n\t{\n\t\treturn it.getEnv();\n\t}\n};\nfinal &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.Boolean%&gt;&gt; _function_1 = new &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.Boolean%&gt;&gt;()\n{\n\tpublic &lt;%java.lang.Boolean%&gt; apply(final &lt;%java.lang.String%&gt; it)\n\t{\n\t\tboolean _isNullOrEmpty = &lt;%org.eclipse.xtext.xbase.lib.StringExtensions%&gt;.isNullOrEmpty(it);\n\t\treturn &lt;%java.lang.Boolean%&gt;.valueOf((!_isNullOrEmpty));\n\t}\n};\nfinal &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.String%&gt;&gt; _function_2 = new &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.String%&gt;&gt;()\n{\n\tpublic &lt;%java.lang.String%&gt; apply(final &lt;%java.lang.String%&gt; it)\n\t{\n\t\treturn it.toUpperCase();\n\t}\n};\nfinal &lt;%java.util.List%&gt;&lt;&lt;%java.lang.String%&gt;&gt; envToUpper = &lt;%org.eclipse.xtext.xbase.lib.IterableExtensions%&gt;.&lt;&lt;%java.lang.String%&gt;&gt;toList(&lt;%org.eclipse.xtext.xbase.lib.IterableExtensions%&gt;.&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.String%&gt;&gt;map(&lt;%org.eclipse.xtext.xbase.lib.IterableExtensions%&gt;.&lt;&lt;%java.lang.String%&gt;&gt;filter(&lt;%com.google.common.collect.Iterables%&gt;.&lt;&lt;%java.lang.String%&gt;&gt;concat(&lt;%org.eclipse.xtext.xbase.lib.IterableExtensions%&gt;.&lt;&lt;%fr.obeo.releng.targetplatform.Environment%&gt;, &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%java.lang.String%&gt;&gt;&gt;map(&lt;%com.google.common.collect.Iterables%&gt;.&lt;&lt;%fr.obeo.releng.targetplatform.Environment%&gt;&gt;filter(this.getTargetPlatform().getContents(), &lt;%fr.obeo.releng.targetplatform.Environment%&gt;.class), _function)), _function_1), _function_2));\nfinal &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%java.util.Locale%&gt;, &lt;%java.lang.String%&gt;&gt; _function_3 = new &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%java.util.Locale%&gt;, &lt;%java.lang.String%&gt;&gt;()\n{\n\tpublic &lt;%java.lang.String%&gt; apply(final &lt;%java.util.Locale%&gt; it)\n\t{\n\t\treturn it.toString();\n\t}\n};\nfinal &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.Boolean%&gt;&gt; _function_4 = new &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.Boolean%&gt;&gt;()\n{\n\tpublic &lt;%java.lang.Boolean%&gt; apply(final &lt;%java.lang.String%&gt; it)\n\t{\n\t\treturn &lt;%java.lang.Boolean%&gt;.valueOf(envToUpper.contains(it.toUpperCase()));\n\t}\n};\nfinal &lt;%java.lang.String%&gt; locale = &lt;%org.eclipse.xtext.xbase.lib.IterableExtensions%&gt;.&lt;&lt;%java.lang.String%&gt;&gt;findFirst(&lt;%org.eclipse.xtext.xbase.lib.ListExtensions%&gt;.&lt;&lt;%java.util.Locale%&gt;, &lt;%java.lang.String%&gt;&gt;map(((&lt;%java.util.List%&gt;&lt;&lt;%java.util.Locale%&gt;&gt;)org.eclipse.xtext.xbase.lib.Conversions.doWrapArray(&lt;%java.util.Locale%&gt;.getAvailableLocales())), _function_3), _function_4);\nboolean _notEquals = (!&lt;%com.google.common.base.Objects%&gt;.equal(locale, null));\nif (_notEquals)\n{\n\t&lt;%java.lang.String%&gt; language = \"\";\n\t&lt;%java.lang.String%&gt; country = \"\";\n\t&lt;%java.lang.String%&gt; variant = \"\";\n\tfinal &lt;%java.util.Iterator%&gt;&lt;&lt;%java.lang.String%&gt;&gt; tokens = &lt;%com.google.common.base.Splitter%&gt;.on(\"_\").trimResults().split(locale).iterator();\n\tboolean _hasNext = tokens.hasNext();\n\tif (_hasNext)\n\t{\n\t\tlanguage = tokens.next();\n\t}\n\tboolean _hasNext_1 = tokens.hasNext();\n\tif (_hasNext_1)\n\t{\n\t\tcountry = tokens.next();\n\t}\n\tboolean _hasNext_2 = tokens.hasNext();\n\tif (_hasNext_2)\n\t{\n\t\tvariant = tokens.next();\n\t}\n\treturn new &lt;%java.util.Locale%&gt;(language, country, variant);\n}\nelse\n{\n\treturn null;\n}'"
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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='final &lt;%org.eclipse.jdt.launching.environments.IExecutionEnvironmentsManager%&gt; eeManager = &lt;%org.eclipse.jdt.launching.JavaRuntime%&gt;.getExecutionEnvironmentsManager();\nboolean _notEquals = (!&lt;%com.google.common.base.Objects%&gt;.equal(eeManager, null));\nif (_notEquals)\n{\n\tfinal &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%fr.obeo.releng.targetplatform.Environment%&gt;, &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%java.lang.String%&gt;&gt;&gt; _function = new &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%fr.obeo.releng.targetplatform.Environment%&gt;, &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%java.lang.String%&gt;&gt;&gt;()\n\t{\n\t\tpublic &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%java.lang.String%&gt;&gt; apply(final &lt;%fr.obeo.releng.targetplatform.Environment%&gt; it)\n\t\t{\n\t\t\treturn it.getEnv();\n\t\t}\n\t};\n\tfinal &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.Boolean%&gt;&gt; _function_1 = new &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.Boolean%&gt;&gt;()\n\t{\n\t\tpublic &lt;%java.lang.Boolean%&gt; apply(final &lt;%java.lang.String%&gt; it)\n\t\t{\n\t\t\tboolean _isNullOrEmpty = &lt;%org.eclipse.xtext.xbase.lib.StringExtensions%&gt;.isNullOrEmpty(it);\n\t\t\treturn &lt;%java.lang.Boolean%&gt;.valueOf((!_isNullOrEmpty));\n\t\t}\n\t};\n\tfinal &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.String%&gt;&gt; _function_2 = new &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.String%&gt;&gt;()\n\t{\n\t\tpublic &lt;%java.lang.String%&gt; apply(final &lt;%java.lang.String%&gt; it)\n\t\t{\n\t\t\treturn it.toUpperCase();\n\t\t}\n\t};\n\tfinal &lt;%java.util.List%&gt;&lt;&lt;%java.lang.String%&gt;&gt; envToUpper = &lt;%org.eclipse.xtext.xbase.lib.IterableExtensions%&gt;.&lt;&lt;%java.lang.String%&gt;&gt;toList(&lt;%org.eclipse.xtext.xbase.lib.IterableExtensions%&gt;.&lt;&lt;%java.lang.String%&gt;, &lt;%java.lang.String%&gt;&gt;map(&lt;%org.eclipse.xtext.xbase.lib.IterableExtensions%&gt;.&lt;&lt;%java.lang.String%&gt;&gt;filter(&lt;%com.google.common.collect.Iterables%&gt;.&lt;&lt;%java.lang.String%&gt;&gt;concat(&lt;%org.eclipse.xtext.xbase.lib.IterableExtensions%&gt;.&lt;&lt;%fr.obeo.releng.targetplatform.Environment%&gt;, &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%java.lang.String%&gt;&gt;&gt;map(&lt;%com.google.common.collect.Iterables%&gt;.&lt;&lt;%fr.obeo.releng.targetplatform.Environment%&gt;&gt;filter(this.getTargetPlatform().getContents(), &lt;%fr.obeo.releng.targetplatform.Environment%&gt;.class), _function)), _function_1), _function_2));\n\tfor (final &lt;%java.lang.String%&gt; env : envToUpper)\n\t{\n\t\t{\n\t\t\tfinal &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%org.eclipse.jdt.launching.environments.IExecutionEnvironment%&gt;, &lt;%java.lang.Boolean%&gt;&gt; _function_3 = new &lt;%org.eclipse.xtext.xbase.lib.Functions.Function1%&gt;&lt;&lt;%org.eclipse.jdt.launching.environments.IExecutionEnvironment%&gt;, &lt;%java.lang.Boolean%&gt;&gt;()\n\t\t\t{\n\t\t\t\tpublic &lt;%java.lang.Boolean%&gt; apply(final &lt;%org.eclipse.jdt.launching.environments.IExecutionEnvironment%&gt; it)\n\t\t\t\t{\n\t\t\t\t\treturn &lt;%java.lang.Boolean%&gt;.valueOf(it.getId().toUpperCase().equals(env));\n\t\t\t\t}\n\t\t\t};\n\t\t\tfinal &lt;%org.eclipse.jdt.launching.environments.IExecutionEnvironment%&gt; ee = &lt;%org.eclipse.xtext.xbase.lib.IterableExtensions%&gt;.&lt;&lt;%org.eclipse.jdt.launching.environments.IExecutionEnvironment%&gt;&gt;findFirst(((&lt;%java.lang.Iterable%&gt;&lt;&lt;%org.eclipse.jdt.launching.environments.IExecutionEnvironment%&gt;&gt;)org.eclipse.xtext.xbase.lib.Conversions.doWrapArray(eeManager.getExecutionEnvironments())), _function_3);\n\t\t\tboolean _notEquals_1 = (!&lt;%com.google.common.base.Objects%&gt;.equal(ee, null));\n\t\t\tif (_notEquals_1)\n\t\t\t{\n\t\t\t\treturn ee;\n\t\t\t}\n\t\t}\n\t}\n\treturn null;\n}\nelse\n{\n\treturn null;\n}'"
	 * @generated
	 */
	IExecutionEnvironment getExecutionEnvironment();

} // Environment
