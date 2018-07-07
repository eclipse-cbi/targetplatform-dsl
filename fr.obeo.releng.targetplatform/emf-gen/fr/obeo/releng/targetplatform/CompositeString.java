/**
 */
package fr.obeo.releng.targetplatform;

import java.util.List;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Composite String</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link fr.obeo.releng.targetplatform.CompositeString#getName <em>Name</em>}</li>
 *   <li>{@link fr.obeo.releng.targetplatform.CompositeString#getStringParts <em>String Parts</em>}</li>
 *   <li>{@link fr.obeo.releng.targetplatform.CompositeString#isVariableDefinitionCycleDetected <em>Variable Definition Cycle Detected</em>}</li>
 *   <li>{@link fr.obeo.releng.targetplatform.CompositeString#getVarDefCycle <em>Var Def Cycle</em>}</li>
 * </ul>
 *
 * @see fr.obeo.releng.targetplatform.TargetPlatformPackage#getCompositeString()
 * @model
 * @generated
 */
public interface CompositeString extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * The default value is <code>"composite string"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see fr.obeo.releng.targetplatform.TargetPlatformPackage#getCompositeString_Name()
	 * @model default="composite string" unique="false"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link fr.obeo.releng.targetplatform.CompositeString#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>String Parts</b></em>' containment reference list.
	 * The list contents are of type {@link fr.obeo.releng.targetplatform.CompositeStringPart}.
	 * It is bidirectional and its opposite is '{@link fr.obeo.releng.targetplatform.CompositeStringPart#getCompositeString <em>Composite String</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>String Parts</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>String Parts</em>' containment reference list.
	 * @see fr.obeo.releng.targetplatform.TargetPlatformPackage#getCompositeString_StringParts()
	 * @see fr.obeo.releng.targetplatform.CompositeStringPart#getCompositeString
	 * @model opposite="compositeString" containment="true"
	 * @generated
	 */
	EList<CompositeStringPart> getStringParts();

	/**
	 * Returns the value of the '<em><b>Variable Definition Cycle Detected</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variable Definition Cycle Detected</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variable Definition Cycle Detected</em>' attribute.
	 * @see #setVariableDefinitionCycleDetected(boolean)
	 * @see fr.obeo.releng.targetplatform.TargetPlatformPackage#getCompositeString_VariableDefinitionCycleDetected()
	 * @model default="false" unique="false"
	 * @generated
	 */
	boolean isVariableDefinitionCycleDetected();

	/**
	 * Sets the value of the '{@link fr.obeo.releng.targetplatform.CompositeString#isVariableDefinitionCycleDetected <em>Variable Definition Cycle Detected</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variable Definition Cycle Detected</em>' attribute.
	 * @see #isVariableDefinitionCycleDetected()
	 * @generated
	 */
	void setVariableDefinitionCycleDetected(boolean value);

	/**
	 * Returns the value of the '<em><b>Var Def Cycle</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Var Def Cycle</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Var Def Cycle</em>' attribute.
	 * @see #setVarDefCycle(List)
	 * @see fr.obeo.releng.targetplatform.TargetPlatformPackage#getCompositeString_VarDefCycle()
	 * @model unique="false" dataType="fr.obeo.releng.targetplatform.VarDefList"
	 * @generated
	 */
	List<VarDefinition> getVarDefCycle();

	/**
	 * Sets the value of the '{@link fr.obeo.releng.targetplatform.CompositeString#getVarDefCycle <em>Var Def Cycle</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Var Def Cycle</em>' attribute.
	 * @see #getVarDefCycle()
	 * @generated
	 */
	void setVarDefCycle(List<VarDefinition> value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='final &lt;%java.util.List%&gt;&lt;&lt;%fr.obeo.releng.targetplatform.VarDefinition%&gt;&gt; alreadyCalledVariable = &lt;%org.eclipse.xtext.xbase.lib.CollectionLiterals%&gt;.&lt;&lt;%fr.obeo.releng.targetplatform.VarDefinition%&gt;&gt;newArrayList();\nreturn this.computeActualString(alreadyCalledVariable);'"
	 * @generated
	 */
	String computeActualString();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" alreadyCalledVariableDataType="fr.obeo.releng.targetplatform.VarDefList" alreadyCalledVariableUnique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='this.setVariableDefinitionCycleDetected(false);\n&lt;%java.lang.String%&gt; result = new &lt;%java.lang.String%&gt;();\n&lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%fr.obeo.releng.targetplatform.CompositeStringPart%&gt;&gt; _stringParts = this.getStringParts();\nfor (final &lt;%fr.obeo.releng.targetplatform.CompositeStringPart%&gt; stringPart : _stringParts)\n{\n\t{\n\t\tfinal &lt;%java.util.List%&gt;&lt;&lt;%fr.obeo.releng.targetplatform.VarDefinition%&gt;&gt; newAlreadyCalledVariable = &lt;%org.eclipse.xtext.xbase.lib.CollectionLiterals%&gt;.&lt;&lt;%fr.obeo.releng.targetplatform.VarDefinition%&gt;&gt;newArrayList(((&lt;%fr.obeo.releng.targetplatform.VarDefinition%&gt;[])org.eclipse.xtext.xbase.lib.Conversions.unwrapArray(alreadyCalledVariable, &lt;%fr.obeo.releng.targetplatform.VarDefinition%&gt;.class)));\n\t\t&lt;%java.lang.String%&gt; _result = result;\n\t\t&lt;%java.lang.String%&gt; _actualString = stringPart.getActualString(newAlreadyCalledVariable);\n\t\tresult = (_result + _actualString);\n\t\tboolean _isVariableDefinitionCycleDetected = stringPart.isVariableDefinitionCycleDetected();\n\t\tif (_isVariableDefinitionCycleDetected)\n\t\t{\n\t\t\tthis.setVariableDefinitionCycleDetected(stringPart.isVariableDefinitionCycleDetected());\n\t\t\tthis.setVarDefCycle(&lt;%org.eclipse.xtext.xbase.lib.CollectionLiterals%&gt;.&lt;&lt;%fr.obeo.releng.targetplatform.VarDefinition%&gt;&gt;newArrayList(((&lt;%fr.obeo.releng.targetplatform.VarDefinition%&gt;[])org.eclipse.xtext.xbase.lib.Conversions.unwrapArray(stringPart.getVarDefCycle(), &lt;%fr.obeo.releng.targetplatform.VarDefinition%&gt;.class))));\n\t\t\treturn \"\";\n\t\t}\n\t}\n}\nreturn result;'"
	 * @generated
	 */
	String computeActualString(List<VarDefinition> alreadyCalledVariable);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='&lt;%fr.obeo.releng.targetplatform.CompositeString%&gt; output = &lt;%fr.obeo.releng.targetplatform.TargetPlatformFactory%&gt;.eINSTANCE.createCompositeString();\nfinal &lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%fr.obeo.releng.targetplatform.CompositeStringPart%&gt;&gt; stringPartsCopy = output.getStringParts();\nfinal &lt;%java.util.function.Consumer%&gt;&lt;&lt;%fr.obeo.releng.targetplatform.CompositeStringPart%&gt;&gt; _function = new &lt;%java.util.function.Consumer%&gt;&lt;&lt;%fr.obeo.releng.targetplatform.CompositeStringPart%&gt;&gt;()\n{\n\tpublic void accept(final &lt;%fr.obeo.releng.targetplatform.CompositeStringPart%&gt; it)\n\t{\n\t\tstringPartsCopy.add(it.getCopy());\n\t}\n};\nthis.getStringParts().forEach(_function);\nreturn output;'"
	 * @generated
	 */
	CompositeString getCopy();

} // CompositeString
