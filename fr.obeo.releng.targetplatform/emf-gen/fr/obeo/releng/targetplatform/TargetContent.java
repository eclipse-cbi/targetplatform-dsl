/**
 */
package fr.obeo.releng.targetplatform;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Target Content</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.obeo.releng.targetplatform.TargetContent#getTargetPlatform <em>Target Platform</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.obeo.releng.targetplatform.TargetPlatformPackage#getTargetContent()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface TargetContent extends EObject {
	/**
	 * Returns the value of the '<em><b>Target Platform</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link fr.obeo.releng.targetplatform.TargetPlatform#getContents <em>Contents</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Platform</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Platform</em>' container reference.
	 * @see #setTargetPlatform(TargetPlatform)
	 * @see fr.obeo.releng.targetplatform.TargetPlatformPackage#getTargetContent_TargetPlatform()
	 * @see fr.obeo.releng.targetplatform.TargetPlatform#getContents
	 * @model opposite="contents" transient="false"
	 * @generated
	 */
	TargetPlatform getTargetPlatform();

	/**
	 * Sets the value of the '{@link fr.obeo.releng.targetplatform.TargetContent#getTargetPlatform <em>Target Platform</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Platform</em>' container reference.
	 * @see #getTargetPlatform()
	 * @generated
	 */
	void setTargetPlatform(TargetPlatform value);

} // TargetContent
