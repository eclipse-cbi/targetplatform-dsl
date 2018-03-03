/**
 */
package fr.obeo.releng.targetplatform;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Location</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link fr.obeo.releng.targetplatform.Location#getID <em>ID</em>}</li>
 *   <li>{@link fr.obeo.releng.targetplatform.Location#getUri <em>Uri</em>}</li>
 *   <li>{@link fr.obeo.releng.targetplatform.Location#getOptions <em>Options</em>}</li>
 *   <li>{@link fr.obeo.releng.targetplatform.Location#getIus <em>Ius</em>}</li>
 * </ul>
 *
 * @see fr.obeo.releng.targetplatform.TargetPlatformPackage#getLocation()
 * @model
 * @generated
 */
public interface Location extends TargetContent {
	/**
	 * Returns the value of the '<em><b>ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>ID</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>ID</em>' attribute.
	 * @see #setID(String)
	 * @see fr.obeo.releng.targetplatform.TargetPlatformPackage#getLocation_ID()
	 * @model unique="false"
	 * @generated
	 */
	String getID();

	/**
	 * Sets the value of the '{@link fr.obeo.releng.targetplatform.Location#getID <em>ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>ID</em>' attribute.
	 * @see #getID()
	 * @generated
	 */
	void setID(String value);

	/**
	 * Returns the value of the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Uri</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Uri</em>' attribute.
	 * @see #setUri(String)
	 * @see fr.obeo.releng.targetplatform.TargetPlatformPackage#getLocation_Uri()
	 * @model unique="false"
	 * @generated
	 */
	String getUri();

	/**
	 * Sets the value of the '{@link fr.obeo.releng.targetplatform.Location#getUri <em>Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Uri</em>' attribute.
	 * @see #getUri()
	 * @generated
	 */
	void setUri(String value);

	/**
	 * Returns the value of the '<em><b>Options</b></em>' attribute list.
	 * The list contents are of type {@link fr.obeo.releng.targetplatform.Option}.
	 * The literals are from the enumeration {@link fr.obeo.releng.targetplatform.Option}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Options</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Options</em>' attribute list.
	 * @see fr.obeo.releng.targetplatform.Option
	 * @see fr.obeo.releng.targetplatform.TargetPlatformPackage#getLocation_Options()
	 * @model unique="false"
	 * @generated
	 */
	EList<Option> getOptions();

	/**
	 * Returns the value of the '<em><b>Ius</b></em>' containment reference list.
	 * The list contents are of type {@link fr.obeo.releng.targetplatform.IU}.
	 * It is bidirectional and its opposite is '{@link fr.obeo.releng.targetplatform.IU#getLocation <em>Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ius</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ius</em>' containment reference list.
	 * @see fr.obeo.releng.targetplatform.TargetPlatformPackage#getLocation_Ius()
	 * @see fr.obeo.releng.targetplatform.IU#getLocation
	 * @model opposite="location" containment="true"
	 * @generated
	 */
	EList<IU> getIus();

} // Location
