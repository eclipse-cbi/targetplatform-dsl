/**
 */
package fr.obeo.releng.targetplatform.targetplatform;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Include Declaration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.obeo.releng.targetplatform.targetplatform.IncludeDeclaration#getImportURI <em>Import URI</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.obeo.releng.targetplatform.targetplatform.TargetplatformPackage#getIncludeDeclaration()
 * @model
 * @generated
 */
public interface IncludeDeclaration extends EObject
{
  /**
   * Returns the value of the '<em><b>Import URI</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Import URI</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Import URI</em>' attribute.
   * @see #setImportURI(String)
   * @see fr.obeo.releng.targetplatform.targetplatform.TargetplatformPackage#getIncludeDeclaration_ImportURI()
   * @model
   * @generated
   */
  String getImportURI();

  /**
   * Sets the value of the '{@link fr.obeo.releng.targetplatform.targetplatform.IncludeDeclaration#getImportURI <em>Import URI</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Import URI</em>' attribute.
   * @see #getImportURI()
   * @generated
   */
  void setImportURI(String value);

} // IncludeDeclaration
