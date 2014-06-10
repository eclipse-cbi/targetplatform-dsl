/**
 */
package fr.obeo.releng.targetplatform;

import java.util.Locale;

import org.eclipse.jdt.launching.environments.IExecutionEnvironment;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Environment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.obeo.releng.targetplatform.Environment#getOperatingSystem <em>Operating System</em>}</li>
 *   <li>{@link fr.obeo.releng.targetplatform.Environment#getWindowingSystem <em>Windowing System</em>}</li>
 *   <li>{@link fr.obeo.releng.targetplatform.Environment#getArchitecture <em>Architecture</em>}</li>
 *   <li>{@link fr.obeo.releng.targetplatform.Environment#getLocalization <em>Localization</em>}</li>
 *   <li>{@link fr.obeo.releng.targetplatform.Environment#getExecutionEnvironment <em>Execution Environment</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.obeo.releng.targetplatform.TargetPlatformPackage#getEnvironment()
 * @model
 * @generated
 */
public interface Environment extends TargetContent
{
  /**
   * Returns the value of the '<em><b>Operating System</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Operating System</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Operating System</em>' attribute.
   * @see #setOperatingSystem(String)
   * @see fr.obeo.releng.targetplatform.TargetPlatformPackage#getEnvironment_OperatingSystem()
   * @model unique="false"
   * @generated
   */
  String getOperatingSystem();

  /**
   * Sets the value of the '{@link fr.obeo.releng.targetplatform.Environment#getOperatingSystem <em>Operating System</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Operating System</em>' attribute.
   * @see #getOperatingSystem()
   * @generated
   */
  void setOperatingSystem(String value);

  /**
   * Returns the value of the '<em><b>Windowing System</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Windowing System</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Windowing System</em>' attribute.
   * @see #setWindowingSystem(String)
   * @see fr.obeo.releng.targetplatform.TargetPlatformPackage#getEnvironment_WindowingSystem()
   * @model unique="false"
   * @generated
   */
  String getWindowingSystem();

  /**
   * Sets the value of the '{@link fr.obeo.releng.targetplatform.Environment#getWindowingSystem <em>Windowing System</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Windowing System</em>' attribute.
   * @see #getWindowingSystem()
   * @generated
   */
  void setWindowingSystem(String value);

  /**
   * Returns the value of the '<em><b>Architecture</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Architecture</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Architecture</em>' attribute.
   * @see #setArchitecture(String)
   * @see fr.obeo.releng.targetplatform.TargetPlatformPackage#getEnvironment_Architecture()
   * @model unique="false"
   * @generated
   */
  String getArchitecture();

  /**
   * Sets the value of the '{@link fr.obeo.releng.targetplatform.Environment#getArchitecture <em>Architecture</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Architecture</em>' attribute.
   * @see #getArchitecture()
   * @generated
   */
  void setArchitecture(String value);

  /**
   * Returns the value of the '<em><b>Localization</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Localization</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Localization</em>' attribute.
   * @see #setLocalization(Locale)
   * @see fr.obeo.releng.targetplatform.TargetPlatformPackage#getEnvironment_Localization()
   * @model unique="false" dataType="fr.obeo.releng.targetplatform.Locale"
   * @generated
   */
  Locale getLocalization();

  /**
   * Sets the value of the '{@link fr.obeo.releng.targetplatform.Environment#getLocalization <em>Localization</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Localization</em>' attribute.
   * @see #getLocalization()
   * @generated
   */
  void setLocalization(Locale value);

  /**
   * Returns the value of the '<em><b>Execution Environment</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Execution Environment</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Execution Environment</em>' attribute.
   * @see #setExecutionEnvironment(IExecutionEnvironment)
   * @see fr.obeo.releng.targetplatform.TargetPlatformPackage#getEnvironment_ExecutionEnvironment()
   * @model unique="false" dataType="fr.obeo.releng.targetplatform.ExecutionEnvironment"
   * @generated
   */
  IExecutionEnvironment getExecutionEnvironment();

  /**
   * Sets the value of the '{@link fr.obeo.releng.targetplatform.Environment#getExecutionEnvironment <em>Execution Environment</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Execution Environment</em>' attribute.
   * @see #getExecutionEnvironment()
   * @generated
   */
  void setExecutionEnvironment(IExecutionEnvironment value);

} // Environment
