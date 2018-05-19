/**
 */
package fr.obeo.releng.targetplatform;

import java.util.List;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Var Call</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link fr.obeo.releng.targetplatform.VarCall#getVarName <em>Var Name</em>}</li>
 *   <li>{@link fr.obeo.releng.targetplatform.VarCall#getOriginalVarName <em>Original Var Name</em>}</li>
 *   <li>{@link fr.obeo.releng.targetplatform.VarCall#isUpdated <em>Updated</em>}</li>
 *   <li>{@link fr.obeo.releng.targetplatform.VarCall#isVariableDefinitionCycleDetected <em>Variable Definition Cycle Detected</em>}</li>
 *   <li>{@link fr.obeo.releng.targetplatform.VarCall#getVarDefCycle <em>Var Def Cycle</em>}</li>
 * </ul>
 *
 * @see fr.obeo.releng.targetplatform.TargetPlatformPackage#getVarCall()
 * @model
 * @generated
 */
public interface VarCall extends CompositeStringPart {
	/**
	 * Returns the value of the '<em><b>Var Name</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Var Name</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Var Name</em>' reference.
	 * @see #setVarName(VarDefinition)
	 * @see fr.obeo.releng.targetplatform.TargetPlatformPackage#getVarCall_VarName()
	 * @model
	 * @generated
	 */
	VarDefinition getVarName();

	/**
	 * Sets the value of the '{@link fr.obeo.releng.targetplatform.VarCall#getVarName <em>Var Name</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Var Name</em>' reference.
	 * @see #getVarName()
	 * @generated
	 */
	void setVarName(VarDefinition value);

	/**
	 * Returns the value of the '<em><b>Original Var Name</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Original Var Name</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Original Var Name</em>' reference.
	 * @see #setOriginalVarName(VarDefinition)
	 * @see fr.obeo.releng.targetplatform.TargetPlatformPackage#getVarCall_OriginalVarName()
	 * @model
	 * @generated
	 */
	VarDefinition getOriginalVarName();

	/**
	 * Sets the value of the '{@link fr.obeo.releng.targetplatform.VarCall#getOriginalVarName <em>Original Var Name</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Original Var Name</em>' reference.
	 * @see #getOriginalVarName()
	 * @generated
	 */
	void setOriginalVarName(VarDefinition value);

	/**
	 * Returns the value of the '<em><b>Updated</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Updated</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Updated</em>' attribute.
	 * @see #setUpdated(boolean)
	 * @see fr.obeo.releng.targetplatform.TargetPlatformPackage#getVarCall_Updated()
	 * @model default="false" unique="false"
	 * @generated
	 */
	boolean isUpdated();

	/**
	 * Sets the value of the '{@link fr.obeo.releng.targetplatform.VarCall#isUpdated <em>Updated</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Updated</em>' attribute.
	 * @see #isUpdated()
	 * @generated
	 */
	void setUpdated(boolean value);

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
	 * @see fr.obeo.releng.targetplatform.TargetPlatformPackage#getVarCall_VariableDefinitionCycleDetected()
	 * @model default="false" unique="false"
	 * @generated
	 */
	boolean isVariableDefinitionCycleDetected();

	/**
	 * Sets the value of the '{@link fr.obeo.releng.targetplatform.VarCall#isVariableDefinitionCycleDetected <em>Variable Definition Cycle Detected</em>}' attribute.
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
	 * @see fr.obeo.releng.targetplatform.TargetPlatformPackage#getVarCall_VarDefCycle()
	 * @model unique="false" dataType="fr.obeo.releng.targetplatform.VarDefList"
	 * @generated
	 */
	List<VarDefinition> getVarDefCycle();

	/**
	 * Sets the value of the '{@link fr.obeo.releng.targetplatform.VarCall#getVarDefCycle <em>Var Def Cycle</em>}' attribute.
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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='final &lt;%java.util.ArrayList%&gt;&lt;&lt;%fr.obeo.releng.targetplatform.VarDefinition%&gt;&gt; alreadyCalledVariable = &lt;%org.eclipse.xtext.xbase.lib.CollectionLiterals%&gt;.&lt;&lt;%fr.obeo.releng.targetplatform.VarDefinition%&gt;&gt;newArrayList();\nreturn this.getActualString(alreadyCalledVariable);'"
	 * @generated
	 */
	String getActualString();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" alreadyCalledVariableDataType="fr.obeo.releng.targetplatform.VarDefList" alreadyCalledVariableUnique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='this.setVariableDefinitionCycleDetected(false);\n&lt;%fr.obeo.releng.targetplatform.CompositeString%&gt; _value = this.getVarName().getValue();\nboolean _tripleNotEquals = (_value != null);\nif (_tripleNotEquals)\n{\n\tboolean _contains = alreadyCalledVariable.contains(this.getVarName());\n\tif (_contains)\n\t{\n\t\tthis.setVariableDefinitionCycleDetected(true);\n\t}\n\talreadyCalledVariable.add(this.getVarName());\n\tboolean _isVariableDefinitionCycleDetected = this.isVariableDefinitionCycleDetected();\n\tif (_isVariableDefinitionCycleDetected)\n\t{\n\t\tthis.setVarDefCycle(&lt;%org.eclipse.xtext.xbase.lib.CollectionLiterals%&gt;.&lt;&lt;%fr.obeo.releng.targetplatform.VarDefinition%&gt;&gt;newArrayList(((&lt;%fr.obeo.releng.targetplatform.VarDefinition%&gt;[])org.eclipse.xtext.xbase.lib.Conversions.unwrapArray(alreadyCalledVariable, &lt;%fr.obeo.releng.targetplatform.VarDefinition%&gt;.class))));\n\t\treturn \"\";\n\t}\n}\nboolean _isEmpty = this.getVarName().getOverrideValue().isEmpty();\nif (_isEmpty)\n{\n\t&lt;%fr.obeo.releng.targetplatform.CompositeString%&gt; _value_1 = this.getVarName().getValue();\n\tboolean _tripleNotEquals_1 = (_value_1 != null);\n\tif (_tripleNotEquals_1)\n\t{\n\t\tfinal &lt;%java.lang.String%&gt; stringOutput = this.getVarName().getValue().computeActualString(alreadyCalledVariable);\n\t\tthis.setVariableDefinitionCycleDetected(this.getVarName().getValue().isVariableDefinitionCycleDetected());\n\t\tboolean _isVariableDefinitionCycleDetected_1 = this.isVariableDefinitionCycleDetected();\n\t\tif (_isVariableDefinitionCycleDetected_1)\n\t\t{\n\t\t\tthis.setVarDefCycle(&lt;%org.eclipse.xtext.xbase.lib.CollectionLiterals%&gt;.&lt;&lt;%fr.obeo.releng.targetplatform.VarDefinition%&gt;&gt;newArrayList(((&lt;%fr.obeo.releng.targetplatform.VarDefinition%&gt;[])org.eclipse.xtext.xbase.lib.Conversions.unwrapArray(this.getVarName().getValue().getVarDefCycle(), &lt;%fr.obeo.releng.targetplatform.VarDefinition%&gt;.class))));\n\t\t\treturn \"\";\n\t\t}\n\t\treturn stringOutput;\n\t}\n\treturn \"\";\n}\nreturn this.getVarName().getOverrideValue();'"
	 * @generated
	 */
	String getActualString(List<VarDefinition> alreadyCalledVariable);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='final &lt;%fr.obeo.releng.targetplatform.VarCall%&gt; output = &lt;%fr.obeo.releng.targetplatform.TargetPlatformFactory%&gt;.eINSTANCE.createVarCall();\noutput.setVarName(this.getVarName());\nreturn output;'"
	 * @generated
	 */
	VarCall getCopy();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='boolean _isUpdated = this.isUpdated();\nif (_isUpdated)\n{\n\tthis.setVarName(this.getOriginalVarName());\n\tthis.setUpdated(false);\n}'"
	 * @generated
	 */
	void reset();

} // VarCall
