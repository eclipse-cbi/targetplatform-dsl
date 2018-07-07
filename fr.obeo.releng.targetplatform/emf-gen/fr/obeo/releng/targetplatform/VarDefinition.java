/**
 */
package fr.obeo.releng.targetplatform;

import java.util.List;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Var Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link fr.obeo.releng.targetplatform.VarDefinition#getName <em>Name</em>}</li>
 *   <li>{@link fr.obeo.releng.targetplatform.VarDefinition#getValue <em>Value</em>}</li>
 *   <li>{@link fr.obeo.releng.targetplatform.VarDefinition#getOverrideValue <em>Override Value</em>}</li>
 *   <li>{@link fr.obeo.releng.targetplatform.VarDefinition#isVariableDefinitionCycleDetected <em>Variable Definition Cycle Detected</em>}</li>
 *   <li>{@link fr.obeo.releng.targetplatform.VarDefinition#getVarDefCycle <em>Var Def Cycle</em>}</li>
 *   <li>{@link fr.obeo.releng.targetplatform.VarDefinition#isImported <em>Imported</em>}</li>
 * </ul>
 *
 * @see fr.obeo.releng.targetplatform.TargetPlatformPackage#getVarDefinition()
 * @model
 * @generated
 */
public interface VarDefinition extends TargetContent {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see fr.obeo.releng.targetplatform.TargetPlatformPackage#getVarDefinition_Name()
	 * @model unique="false"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link fr.obeo.releng.targetplatform.VarDefinition#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' containment reference.
	 * @see #setValue(CompositeString)
	 * @see fr.obeo.releng.targetplatform.TargetPlatformPackage#getVarDefinition_Value()
	 * @model containment="true"
	 * @generated
	 */
	CompositeString getValue();

	/**
	 * Sets the value of the '{@link fr.obeo.releng.targetplatform.VarDefinition#getValue <em>Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' containment reference.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(CompositeString value);

	/**
	 * Returns the value of the '<em><b>Override Value</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Override Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Override Value</em>' attribute.
	 * @see #setOverrideValue(String)
	 * @see fr.obeo.releng.targetplatform.TargetPlatformPackage#getVarDefinition_OverrideValue()
	 * @model default="" unique="false"
	 * @generated
	 */
	String getOverrideValue();

	/**
	 * Sets the value of the '{@link fr.obeo.releng.targetplatform.VarDefinition#getOverrideValue <em>Override Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Override Value</em>' attribute.
	 * @see #getOverrideValue()
	 * @generated
	 */
	void setOverrideValue(String value);

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
	 * @see fr.obeo.releng.targetplatform.TargetPlatformPackage#getVarDefinition_VariableDefinitionCycleDetected()
	 * @model default="false" unique="false"
	 * @generated
	 */
	boolean isVariableDefinitionCycleDetected();

	/**
	 * Sets the value of the '{@link fr.obeo.releng.targetplatform.VarDefinition#isVariableDefinitionCycleDetected <em>Variable Definition Cycle Detected</em>}' attribute.
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
	 * @see fr.obeo.releng.targetplatform.TargetPlatformPackage#getVarDefinition_VarDefCycle()
	 * @model unique="false" dataType="fr.obeo.releng.targetplatform.VarDefList"
	 * @generated
	 */
	List<VarDefinition> getVarDefCycle();

	/**
	 * Sets the value of the '{@link fr.obeo.releng.targetplatform.VarDefinition#getVarDefCycle <em>Var Def Cycle</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Var Def Cycle</em>' attribute.
	 * @see #getVarDefCycle()
	 * @generated
	 */
	void setVarDefCycle(List<VarDefinition> value);

	/**
	 * Returns the value of the '<em><b>Imported</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Imported</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Imported</em>' attribute.
	 * @see #setImported(boolean)
	 * @see fr.obeo.releng.targetplatform.TargetPlatformPackage#getVarDefinition_Imported()
	 * @model default="false" unique="false"
	 * @generated
	 */
	boolean isImported();

	/**
	 * Sets the value of the '{@link fr.obeo.releng.targetplatform.VarDefinition#isImported <em>Imported</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Imported</em>' attribute.
	 * @see #isImported()
	 * @generated
	 */
	void setImported(boolean value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='this.setVariableDefinitionCycleDetected(false);\nthis.setVarDefCycle(&lt;%org.eclipse.xtext.xbase.lib.CollectionLiterals%&gt;.&lt;&lt;%fr.obeo.releng.targetplatform.VarDefinition%&gt;&gt;newArrayList());\nthis.getVarDefCycle().add(this);\nthis.getValue().computeActualString(this.getVarDefCycle());\nthis.setVariableDefinitionCycleDetected(this.getValue().isVariableDefinitionCycleDetected());\nboolean _isVariableDefinitionCycleDetected = this.isVariableDefinitionCycleDetected();\nif (_isVariableDefinitionCycleDetected)\n{\n\tthis.setVarDefCycle(&lt;%org.eclipse.xtext.xbase.lib.CollectionLiterals%&gt;.&lt;&lt;%fr.obeo.releng.targetplatform.VarDefinition%&gt;&gt;newArrayList(((&lt;%fr.obeo.releng.targetplatform.VarDefinition%&gt;[])org.eclipse.xtext.xbase.lib.Conversions.unwrapArray(this.getValue().getVarDefCycle(), &lt;%fr.obeo.releng.targetplatform.VarDefinition%&gt;.class))));\n}\nelse\n{\n\tthis.setVarDefCycle(&lt;%org.eclipse.xtext.xbase.lib.CollectionLiterals%&gt;.&lt;&lt;%fr.obeo.releng.targetplatform.VarDefinition%&gt;&gt;newArrayList());\n}'"
	 * @generated
	 */
	void checkVarCycle();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 *  Recreate "toString" generated by xcore but avoid infinite loop if the
	 * define variable has a self recursive definition.
	 * <!-- end-model-doc -->
	 * @model unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='this.checkVarCycle();\n&lt;%java.lang.String%&gt; _string = super.toString();\n&lt;%java.lang.StringBuffer%&gt; result = new &lt;%java.lang.StringBuffer%&gt;(_string);\nresult.append(\" (name: \");\nresult.append(this.getName());\nresult.append(\", overrideValue: \");\nresult.append(this.getOverrideValue());\nresult.append(\", variableDefinitionCycleDetected: \");\nresult.append(this.isVariableDefinitionCycleDetected());\nresult.append(\", varDefCycle: \");\nboolean _isVariableDefinitionCycleDetected = this.isVariableDefinitionCycleDetected();\nboolean _not = (!_isVariableDefinitionCycleDetected);\nif (_not)\n{\n\tresult.append(this.getVarDefCycle());\n}\nelse\n{\n\tresult.append(\"erroneous cyclic definition\");\n}\nresult.append(\")\");\nreturn result.toString();'"
	 * @generated
	 */
	String toString();

} // VarDefinition
