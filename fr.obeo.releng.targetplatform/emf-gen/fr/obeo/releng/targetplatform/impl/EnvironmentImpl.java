/**
 */
package fr.obeo.releng.targetplatform.impl;

import fr.obeo.releng.targetplatform.Environment;
import fr.obeo.releng.targetplatform.TargetPlatformPackage;

import java.util.Locale;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.jdt.launching.environments.IExecutionEnvironment;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Environment</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.obeo.releng.targetplatform.impl.EnvironmentImpl#getOperatingSystem <em>Operating System</em>}</li>
 *   <li>{@link fr.obeo.releng.targetplatform.impl.EnvironmentImpl#getWindowingSystem <em>Windowing System</em>}</li>
 *   <li>{@link fr.obeo.releng.targetplatform.impl.EnvironmentImpl#getArchitecture <em>Architecture</em>}</li>
 *   <li>{@link fr.obeo.releng.targetplatform.impl.EnvironmentImpl#getLocalization <em>Localization</em>}</li>
 *   <li>{@link fr.obeo.releng.targetplatform.impl.EnvironmentImpl#getExecutionEnvironment <em>Execution Environment</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EnvironmentImpl extends MinimalEObjectImpl.Container implements Environment
{
  /**
   * The default value of the '{@link #getOperatingSystem() <em>Operating System</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOperatingSystem()
   * @generated
   * @ordered
   */
  protected static final String OPERATING_SYSTEM_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getOperatingSystem() <em>Operating System</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOperatingSystem()
   * @generated
   * @ordered
   */
  protected String operatingSystem = OPERATING_SYSTEM_EDEFAULT;

  /**
   * The default value of the '{@link #getWindowingSystem() <em>Windowing System</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getWindowingSystem()
   * @generated
   * @ordered
   */
  protected static final String WINDOWING_SYSTEM_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getWindowingSystem() <em>Windowing System</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getWindowingSystem()
   * @generated
   * @ordered
   */
  protected String windowingSystem = WINDOWING_SYSTEM_EDEFAULT;

  /**
   * The default value of the '{@link #getArchitecture() <em>Architecture</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getArchitecture()
   * @generated
   * @ordered
   */
  protected static final String ARCHITECTURE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getArchitecture() <em>Architecture</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getArchitecture()
   * @generated
   * @ordered
   */
  protected String architecture = ARCHITECTURE_EDEFAULT;

  /**
   * The default value of the '{@link #getLocalization() <em>Localization</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLocalization()
   * @generated
   * @ordered
   */
  protected static final Locale LOCALIZATION_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getLocalization() <em>Localization</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLocalization()
   * @generated
   * @ordered
   */
  protected Locale localization = LOCALIZATION_EDEFAULT;

  /**
   * The default value of the '{@link #getExecutionEnvironment() <em>Execution Environment</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExecutionEnvironment()
   * @generated
   * @ordered
   */
  protected static final IExecutionEnvironment EXECUTION_ENVIRONMENT_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getExecutionEnvironment() <em>Execution Environment</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExecutionEnvironment()
   * @generated
   * @ordered
   */
  protected IExecutionEnvironment executionEnvironment = EXECUTION_ENVIRONMENT_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected EnvironmentImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return TargetPlatformPackage.Literals.ENVIRONMENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getOperatingSystem()
  {
    return operatingSystem;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setOperatingSystem(String newOperatingSystem)
  {
    String oldOperatingSystem = operatingSystem;
    operatingSystem = newOperatingSystem;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TargetPlatformPackage.ENVIRONMENT__OPERATING_SYSTEM, oldOperatingSystem, operatingSystem));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getWindowingSystem()
  {
    return windowingSystem;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setWindowingSystem(String newWindowingSystem)
  {
    String oldWindowingSystem = windowingSystem;
    windowingSystem = newWindowingSystem;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TargetPlatformPackage.ENVIRONMENT__WINDOWING_SYSTEM, oldWindowingSystem, windowingSystem));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getArchitecture()
  {
    return architecture;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setArchitecture(String newArchitecture)
  {
    String oldArchitecture = architecture;
    architecture = newArchitecture;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TargetPlatformPackage.ENVIRONMENT__ARCHITECTURE, oldArchitecture, architecture));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Locale getLocalization()
  {
    return localization;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLocalization(Locale newLocalization)
  {
    Locale oldLocalization = localization;
    localization = newLocalization;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TargetPlatformPackage.ENVIRONMENT__LOCALIZATION, oldLocalization, localization));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IExecutionEnvironment getExecutionEnvironment()
  {
    return executionEnvironment;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setExecutionEnvironment(IExecutionEnvironment newExecutionEnvironment)
  {
    IExecutionEnvironment oldExecutionEnvironment = executionEnvironment;
    executionEnvironment = newExecutionEnvironment;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TargetPlatformPackage.ENVIRONMENT__EXECUTION_ENVIRONMENT, oldExecutionEnvironment, executionEnvironment));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case TargetPlatformPackage.ENVIRONMENT__OPERATING_SYSTEM:
        return getOperatingSystem();
      case TargetPlatformPackage.ENVIRONMENT__WINDOWING_SYSTEM:
        return getWindowingSystem();
      case TargetPlatformPackage.ENVIRONMENT__ARCHITECTURE:
        return getArchitecture();
      case TargetPlatformPackage.ENVIRONMENT__LOCALIZATION:
        return getLocalization();
      case TargetPlatformPackage.ENVIRONMENT__EXECUTION_ENVIRONMENT:
        return getExecutionEnvironment();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case TargetPlatformPackage.ENVIRONMENT__OPERATING_SYSTEM:
        setOperatingSystem((String)newValue);
        return;
      case TargetPlatformPackage.ENVIRONMENT__WINDOWING_SYSTEM:
        setWindowingSystem((String)newValue);
        return;
      case TargetPlatformPackage.ENVIRONMENT__ARCHITECTURE:
        setArchitecture((String)newValue);
        return;
      case TargetPlatformPackage.ENVIRONMENT__LOCALIZATION:
        setLocalization((Locale)newValue);
        return;
      case TargetPlatformPackage.ENVIRONMENT__EXECUTION_ENVIRONMENT:
        setExecutionEnvironment((IExecutionEnvironment)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case TargetPlatformPackage.ENVIRONMENT__OPERATING_SYSTEM:
        setOperatingSystem(OPERATING_SYSTEM_EDEFAULT);
        return;
      case TargetPlatformPackage.ENVIRONMENT__WINDOWING_SYSTEM:
        setWindowingSystem(WINDOWING_SYSTEM_EDEFAULT);
        return;
      case TargetPlatformPackage.ENVIRONMENT__ARCHITECTURE:
        setArchitecture(ARCHITECTURE_EDEFAULT);
        return;
      case TargetPlatformPackage.ENVIRONMENT__LOCALIZATION:
        setLocalization(LOCALIZATION_EDEFAULT);
        return;
      case TargetPlatformPackage.ENVIRONMENT__EXECUTION_ENVIRONMENT:
        setExecutionEnvironment(EXECUTION_ENVIRONMENT_EDEFAULT);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case TargetPlatformPackage.ENVIRONMENT__OPERATING_SYSTEM:
        return OPERATING_SYSTEM_EDEFAULT == null ? operatingSystem != null : !OPERATING_SYSTEM_EDEFAULT.equals(operatingSystem);
      case TargetPlatformPackage.ENVIRONMENT__WINDOWING_SYSTEM:
        return WINDOWING_SYSTEM_EDEFAULT == null ? windowingSystem != null : !WINDOWING_SYSTEM_EDEFAULT.equals(windowingSystem);
      case TargetPlatformPackage.ENVIRONMENT__ARCHITECTURE:
        return ARCHITECTURE_EDEFAULT == null ? architecture != null : !ARCHITECTURE_EDEFAULT.equals(architecture);
      case TargetPlatformPackage.ENVIRONMENT__LOCALIZATION:
        return LOCALIZATION_EDEFAULT == null ? localization != null : !LOCALIZATION_EDEFAULT.equals(localization);
      case TargetPlatformPackage.ENVIRONMENT__EXECUTION_ENVIRONMENT:
        return EXECUTION_ENVIRONMENT_EDEFAULT == null ? executionEnvironment != null : !EXECUTION_ENVIRONMENT_EDEFAULT.equals(executionEnvironment);
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (operatingSystem: ");
    result.append(operatingSystem);
    result.append(", windowingSystem: ");
    result.append(windowingSystem);
    result.append(", architecture: ");
    result.append(architecture);
    result.append(", localization: ");
    result.append(localization);
    result.append(", executionEnvironment: ");
    result.append(executionEnvironment);
    result.append(')');
    return result.toString();
  }

} //EnvironmentImpl
