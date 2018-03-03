/**
 */
package fr.obeo.releng.targetplatform;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Composite String Part</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link fr.obeo.releng.targetplatform.CompositeStringPart#getCompositeString <em>Composite String</em>}</li>
 * </ul>
 *
 * @see fr.obeo.releng.targetplatform.TargetPlatformPackage#getCompositeStringPart()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface CompositeStringPart extends EObject {
	/**
	 * Returns the value of the '<em><b>Composite String</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link fr.obeo.releng.targetplatform.CompositeString#getStringParts <em>String Parts</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Composite String</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Composite String</em>' container reference.
	 * @see #setCompositeString(CompositeString)
	 * @see fr.obeo.releng.targetplatform.TargetPlatformPackage#getCompositeStringPart_CompositeString()
	 * @see fr.obeo.releng.targetplatform.CompositeString#getStringParts
	 * @model opposite="stringParts" transient="false"
	 * @generated
	 */
	CompositeString getCompositeString();

	/**
	 * Sets the value of the '{@link fr.obeo.releng.targetplatform.CompositeStringPart#getCompositeString <em>Composite String</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Composite String</em>' container reference.
	 * @see #getCompositeString()
	 * @generated
	 */
	void setCompositeString(CompositeString value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 * @generated
	 */
	String getActualString();

} // CompositeStringPart
