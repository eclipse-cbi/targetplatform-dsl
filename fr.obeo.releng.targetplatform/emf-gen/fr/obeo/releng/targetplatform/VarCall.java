/**
 */
package fr.obeo.releng.targetplatform;


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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return this.getVarName().getValue();'"
	 * @generated
	 */
	String getActualString();

} // VarCall
