/**
 */
package fr.obeo.releng.targetplatform;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>IU</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.obeo.releng.targetplatform.IU#getID <em>ID</em>}</li>
 *   <li>{@link fr.obeo.releng.targetplatform.IU#getVersion <em>Version</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.obeo.releng.targetplatform.TargetPlatformPackage#getIU()
 * @model
 * @generated
 */
public interface IU extends EObject
{
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
   * @see fr.obeo.releng.targetplatform.TargetPlatformPackage#getIU_ID()
   * @model unique="false"
   * @generated
   */
  String getID();

  /**
   * Sets the value of the '{@link fr.obeo.releng.targetplatform.IU#getID <em>ID</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>ID</em>' attribute.
   * @see #getID()
   * @generated
   */
  void setID(String value);

  /**
   * Returns the value of the '<em><b>Version</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Version</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Version</em>' attribute.
   * @see #setVersion(String)
   * @see fr.obeo.releng.targetplatform.TargetPlatformPackage#getIU_Version()
   * @model unique="false"
   * @generated
   */
  String getVersion();

  /**
   * Sets the value of the '{@link fr.obeo.releng.targetplatform.IU#getVersion <em>Version</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Version</em>' attribute.
   * @see #getVersion()
   * @generated
   */
  void setVersion(String value);

} // IU
