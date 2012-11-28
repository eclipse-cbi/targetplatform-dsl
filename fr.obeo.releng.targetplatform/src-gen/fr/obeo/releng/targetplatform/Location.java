/**
 */
package fr.obeo.releng.targetplatform;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Location</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.obeo.releng.targetplatform.Location#getUri <em>Uri</em>}</li>
 *   <li>{@link fr.obeo.releng.targetplatform.Location#getOptions <em>Options</em>}</li>
 *   <li>{@link fr.obeo.releng.targetplatform.Location#getIus <em>Ius</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.obeo.releng.targetplatform.TargetplatformPackage#getLocation()
 * @model
 * @generated
 */
public interface Location extends EObject
{
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
   * @see fr.obeo.releng.targetplatform.TargetplatformPackage#getLocation_Uri()
   * @model
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
   * @see fr.obeo.releng.targetplatform.TargetplatformPackage#getLocation_Options()
   * @model unique="false"
   * @generated
   */
  EList<Option> getOptions();

  /**
   * Returns the value of the '<em><b>Ius</b></em>' containment reference list.
   * The list contents are of type {@link fr.obeo.releng.targetplatform.IU}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Ius</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ius</em>' containment reference list.
   * @see fr.obeo.releng.targetplatform.TargetplatformPackage#getLocation_Ius()
   * @model containment="true"
   * @generated
   */
  EList<IU> getIus();

} // Location
