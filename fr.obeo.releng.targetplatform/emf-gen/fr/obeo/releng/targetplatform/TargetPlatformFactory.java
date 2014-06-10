/**
 */
package fr.obeo.releng.targetplatform;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see fr.obeo.releng.targetplatform.TargetPlatformPackage
 * @generated
 */
public interface TargetPlatformFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  TargetPlatformFactory eINSTANCE = fr.obeo.releng.targetplatform.impl.TargetPlatformFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Target Platform</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Target Platform</em>'.
   * @generated
   */
  TargetPlatform createTargetPlatform();

  /**
   * Returns a new object of class '<em>Options</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Options</em>'.
   * @generated
   */
  Options createOptions();

  /**
   * Returns a new object of class '<em>Environment</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Environment</em>'.
   * @generated
   */
  Environment createEnvironment();

  /**
   * Returns a new object of class '<em>Location</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Location</em>'.
   * @generated
   */
  Location createLocation();

  /**
   * Returns a new object of class '<em>Include Declaration</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Include Declaration</em>'.
   * @generated
   */
  IncludeDeclaration createIncludeDeclaration();

  /**
   * Returns a new object of class '<em>IU</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>IU</em>'.
   * @generated
   */
  IU createIU();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  TargetPlatformPackage getTargetPlatformPackage();

} //TargetPlatformFactory
