/**
 */
package fr.obeo.releng.targetplatform;

import java.util.List;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Static String</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link fr.obeo.releng.targetplatform.StaticString#getValue <em>Value</em>}</li>
 *   <li>{@link fr.obeo.releng.targetplatform.StaticString#isVariableDefinitionCycleDetected <em>Variable Definition Cycle Detected</em>}</li>
 *   <li>{@link fr.obeo.releng.targetplatform.StaticString#getVarDefCycle <em>Var Def Cycle</em>}</li>
 * </ul>
 *
 * @see fr.obeo.releng.targetplatform.TargetPlatformPackage#getStaticString()
 * @model
 * @generated
 */
public interface StaticString extends CompositeStringPart {
	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(String)
	 * @see fr.obeo.releng.targetplatform.TargetPlatformPackage#getStaticString_Value()
	 * @model unique="false"
	 * @generated
	 */
	String getValue();

	/**
	 * Sets the value of the '{@link fr.obeo.releng.targetplatform.StaticString#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(String value);

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
	 * @see fr.obeo.releng.targetplatform.TargetPlatformPackage#getStaticString_VariableDefinitionCycleDetected()
	 * @model default="false" unique="false"
	 * @generated
	 */
	boolean isVariableDefinitionCycleDetected();

	/**
	 * Sets the value of the '{@link fr.obeo.releng.targetplatform.StaticString#isVariableDefinitionCycleDetected <em>Variable Definition Cycle Detected</em>}' attribute.
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
	 * @see fr.obeo.releng.targetplatform.TargetPlatformPackage#getStaticString_VarDefCycle()
	 * @model unique="false" dataType="fr.obeo.releng.targetplatform.VarDefList"
	 * @generated
	 */
	List<VarDefinition> getVarDefCycle();

	/**
	 * Sets the value of the '{@link fr.obeo.releng.targetplatform.StaticString#getVarDefCycle <em>Var Def Cycle</em>}' attribute.
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
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='this.setVarDefCycle(&lt;%org.eclipse.xtext.xbase.lib.CollectionLiterals%&gt;.&lt;&lt;%fr.obeo.releng.targetplatform.VarDefinition%&gt;&gt;newArrayList());\nreturn this.getValue();'"
	 * @generated
	 */
	String getActualString();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" alreadyCalledVariableDataType="fr.obeo.releng.targetplatform.VarDefList" alreadyCalledVariableUnique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return this.getActualString();'"
	 * @generated
	 */
	String getActualString(List<VarDefinition> alreadyCalledVariable);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='final &lt;%fr.obeo.releng.targetplatform.StaticString%&gt; output = &lt;%fr.obeo.releng.targetplatform.TargetPlatformFactory%&gt;.eINSTANCE.createStaticString();\noutput.setValue(this.getValue());\nreturn output;'"
	 * @generated
	 */
	StaticString getCopy();

} // StaticString
