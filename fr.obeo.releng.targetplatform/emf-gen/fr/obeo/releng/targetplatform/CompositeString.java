/**
 */
package fr.obeo.releng.targetplatform;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Composite String</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link fr.obeo.releng.targetplatform.CompositeString#getName <em>Name</em>}</li>
 *   <li>{@link fr.obeo.releng.targetplatform.CompositeString#getStringParts <em>String Parts</em>}</li>
 * </ul>
 *
 * @see fr.obeo.releng.targetplatform.TargetPlatformPackage#getCompositeString()
 * @model
 * @generated
 */
public interface CompositeString extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * The default value is <code>"composite string"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see fr.obeo.releng.targetplatform.TargetPlatformPackage#getCompositeString_Name()
	 * @model default="composite string" unique="false"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link fr.obeo.releng.targetplatform.CompositeString#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>String Parts</b></em>' containment reference list.
	 * The list contents are of type {@link fr.obeo.releng.targetplatform.CompositeStringPart}.
	 * It is bidirectional and its opposite is '{@link fr.obeo.releng.targetplatform.CompositeStringPart#getCompositeString <em>Composite String</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>String Parts</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>String Parts</em>' containment reference list.
	 * @see fr.obeo.releng.targetplatform.TargetPlatformPackage#getCompositeString_StringParts()
	 * @see fr.obeo.releng.targetplatform.CompositeStringPart#getCompositeString
	 * @model opposite="compositeString" containment="true"
	 * @generated
	 */
	EList<CompositeStringPart> getStringParts();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='&lt;%java.lang.String%&gt; result = new &lt;%java.lang.String%&gt;();\n&lt;%org.eclipse.emf.common.util.EList%&gt;&lt;&lt;%fr.obeo.releng.targetplatform.CompositeStringPart%&gt;&gt; _stringParts = this.getStringParts();\nfor (final &lt;%fr.obeo.releng.targetplatform.CompositeStringPart%&gt; stringPart : _stringParts)\n{\n\t&lt;%java.lang.String%&gt; _result = result;\n\t&lt;%java.lang.String%&gt; _actualString = stringPart.getActualString();\n\tresult = (_result + _actualString);\n}\nreturn result;'"
	 * @generated
	 */
	String computeActualString();

} // CompositeString
