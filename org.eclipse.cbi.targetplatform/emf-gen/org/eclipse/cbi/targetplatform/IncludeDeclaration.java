/**
 */
package org.eclipse.cbi.targetplatform;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Include Declaration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.cbi.targetplatform.IncludeDeclaration#getImportURI <em>Import URI</em>}</li>
 * </ul>
 *
 * @see org.eclipse.cbi.targetplatform.TargetPlatformPackage#getIncludeDeclaration()
 * @model
 * @generated
 */
public interface IncludeDeclaration extends TargetContent {
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
	 * @see org.eclipse.cbi.targetplatform.TargetPlatformPackage#getIncludeDeclaration_ImportURI()
	 * @model unique="false"
	 * @generated
	 */
	String getImportURI();

	/**
	 * Sets the value of the '{@link org.eclipse.cbi.targetplatform.IncludeDeclaration#getImportURI <em>Import URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Import URI</em>' attribute.
	 * @see #getImportURI()
	 * @generated
	 */
	void setImportURI(String value);

} // IncludeDeclaration
