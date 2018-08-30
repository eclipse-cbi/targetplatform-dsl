/**
 */
package org.eclipse.cbi.targetplatform;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Target Platform</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.cbi.targetplatform.TargetPlatform#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.cbi.targetplatform.TargetPlatform#getContents <em>Contents</em>}</li>
 *   <li>{@link org.eclipse.cbi.targetplatform.TargetPlatform#getIncludes <em>Includes</em>}</li>
 *   <li>{@link org.eclipse.cbi.targetplatform.TargetPlatform#getOptions <em>Options</em>}</li>
 *   <li>{@link org.eclipse.cbi.targetplatform.TargetPlatform#getLocations <em>Locations</em>}</li>
 *   <li>{@link org.eclipse.cbi.targetplatform.TargetPlatform#getEnvironment <em>Environment</em>}</li>
 * </ul>
 *
 * @see org.eclipse.cbi.targetplatform.TargetPlatformPackage#getTargetPlatform()
 * @model
 * @generated
 */
public interface TargetPlatform extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipse.cbi.targetplatform.TargetPlatformPackage#getTargetPlatform_Name()
	 * @model unique="false"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.cbi.targetplatform.TargetPlatform#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Contents</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.cbi.targetplatform.TargetContent}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.cbi.targetplatform.TargetContent#getTargetPlatform <em>Target Platform</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Contents</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Contents</em>' containment reference list.
	 * @see org.eclipse.cbi.targetplatform.TargetPlatformPackage#getTargetPlatform_Contents()
	 * @see org.eclipse.cbi.targetplatform.TargetContent#getTargetPlatform
	 * @model opposite="targetPlatform" containment="true"
	 * @generated
	 */
	EList<TargetContent> getContents();

	/**
	 * Returns the value of the '<em><b>Includes</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.cbi.targetplatform.IncludeDeclaration}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Includes</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Includes</em>' reference list.
	 * @see org.eclipse.cbi.targetplatform.TargetPlatformPackage#getTargetPlatform_Includes()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='<%java.util.List%><<%org.eclipse.cbi.targetplatform.IncludeDeclaration%>> _list = <%org.eclipse.xtext.xbase.lib.IterableExtensions%>.<<%org.eclipse.cbi.targetplatform.IncludeDeclaration%>>toList(<%com.google.common.collect.Iterables%>.<<%org.eclipse.cbi.targetplatform.IncludeDeclaration%>>filter(this.getContents(), <%org.eclipse.cbi.targetplatform.IncludeDeclaration%>.class));\nreturn new <%org.eclipse.emf.common.util.DelegatingEList.UnmodifiableEList%><<%org.eclipse.cbi.targetplatform.IncludeDeclaration%>>(_list);'"
	 * @generated
	 */
	EList<IncludeDeclaration> getIncludes();

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
	 * @see org.eclipse.cbi.targetplatform.TargetPlatformPackage#getTargetPlatform_Options()
	 * @model unique="false" transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='final <%org.eclipse.xtext.xbase.lib.Functions.Function1%><<%org.eclipse.cbi.targetplatform.Options%>, <%org.eclipse.emf.common.util.EList%><<%org.eclipse.cbi.targetplatform.Option%>>> _function = new <%org.eclipse.xtext.xbase.lib.Functions.Function1%><<%org.eclipse.cbi.targetplatform.Options%>, <%org.eclipse.emf.common.util.EList%><<%org.eclipse.cbi.targetplatform.Option%>>>()\n{\n\tpublic <%org.eclipse.emf.common.util.EList%><<%org.eclipse.cbi.targetplatform.Option%>> apply(final <%org.eclipse.cbi.targetplatform.Options%> it)\n\t{\n\t\treturn it.getOptions();\n\t}\n};\n<%java.util.List%><<%org.eclipse.cbi.targetplatform.Option%>> _list = <%org.eclipse.xtext.xbase.lib.IterableExtensions%>.<<%org.eclipse.cbi.targetplatform.Option%>>toList(<%com.google.common.collect.Iterables%>.<<%org.eclipse.cbi.targetplatform.Option%>>concat(<%org.eclipse.xtext.xbase.lib.IterableExtensions%>.<<%org.eclipse.cbi.targetplatform.Options%>, <%org.eclipse.emf.common.util.EList%><<%org.eclipse.cbi.targetplatform.Option%>>>map(<%com.google.common.collect.Iterables%>.<<%org.eclipse.cbi.targetplatform.Options%>>filter(this.getContents(), <%org.eclipse.cbi.targetplatform.Options%>.class), _function)));\nreturn new <%org.eclipse.emf.common.util.DelegatingEList.UnmodifiableEList%><<%org.eclipse.cbi.targetplatform.Option%>>(_list);'"
	 * @generated
	 */
	EList<Option> getOptions();

	/**
	 * Returns the value of the '<em><b>Locations</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.cbi.targetplatform.Location}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Locations</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Locations</em>' reference list.
	 * @see org.eclipse.cbi.targetplatform.TargetPlatformPackage#getTargetPlatform_Locations()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='<%java.util.List%><<%org.eclipse.cbi.targetplatform.Location%>> _list = <%org.eclipse.xtext.xbase.lib.IterableExtensions%>.<<%org.eclipse.cbi.targetplatform.Location%>>toList(<%com.google.common.collect.Iterables%>.<<%org.eclipse.cbi.targetplatform.Location%>>filter(this.getContents(), <%org.eclipse.cbi.targetplatform.Location%>.class));\nreturn new <%org.eclipse.emf.common.util.DelegatingEList.UnmodifiableEList%><<%org.eclipse.cbi.targetplatform.Location%>>(_list);'"
	 * @generated
	 */
	EList<Location> getLocations();

	/**
	 * Returns the value of the '<em><b>Environment</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Environment</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Environment</em>' reference.
	 * @see org.eclipse.cbi.targetplatform.TargetPlatformPackage#getTargetPlatform_Environment()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='return <%org.eclipse.xtext.xbase.lib.IterableExtensions%>.<<%org.eclipse.cbi.targetplatform.Environment%>>head(<%com.google.common.collect.Iterables%>.<<%org.eclipse.cbi.targetplatform.Environment%>>filter(this.getContents(), <%org.eclipse.cbi.targetplatform.Environment%>.class));'"
	 * @generated
	 */
	Environment getEnvironment();

} // TargetPlatform
