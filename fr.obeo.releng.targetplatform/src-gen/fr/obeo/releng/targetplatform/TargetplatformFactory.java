/**
 * <copyright>
 * </copyright>
 *
 */
package fr.obeo.releng.targetplatform;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see fr.obeo.releng.targetplatform.TargetplatformPackage
 * @generated
 */
public interface TargetplatformFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  TargetplatformFactory eINSTANCE = fr.obeo.releng.targetplatform.impl.TargetplatformFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Target Platform</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Target Platform</em>'.
   * @generated
   */
  TargetPlatform createTargetPlatform();

  /**
   * Returns a new object of class '<em>Location</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Location</em>'.
   * @generated
   */
  Location createLocation();

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
  TargetplatformPackage getTargetplatformPackage();

} //TargetplatformFactory
