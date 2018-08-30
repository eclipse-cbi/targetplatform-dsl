/**
 */
package org.eclipse.cbi.targetplatform;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Options</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.cbi.targetplatform.Options#getOptions <em>Options</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.cbi.targetplatform.TargetPlatformPackage#getOptions()
 * @model
 * @generated
 */
public interface Options extends TargetContent {
	/**
	 * Returns the value of the '<em><b>Options</b></em>' attribute list.
	 * The list contents are of type {@link org.eclipse.cbi.targetplatform.Option}.
	 * The literals are from the enumeration {@link org.eclipse.cbi.targetplatform.Option}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Options</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Options</em>' attribute list.
	 * @see org.eclipse.cbi.targetplatform.Option
	 * @see org.eclipse.cbi.targetplatform.TargetPlatformPackage#getOptions_Options()
	 * @model unique="false"
	 * @generated
	 */
	EList<Option> getOptions();

} // Options
