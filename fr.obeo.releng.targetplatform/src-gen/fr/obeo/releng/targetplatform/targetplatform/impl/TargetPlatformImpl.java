/**
 */
package fr.obeo.releng.targetplatform.targetplatform.impl;

import fr.obeo.releng.targetplatform.targetplatform.IncludeDeclaration;
import fr.obeo.releng.targetplatform.targetplatform.Location;
import fr.obeo.releng.targetplatform.targetplatform.Option;
import fr.obeo.releng.targetplatform.targetplatform.TargetPlatform;
import fr.obeo.releng.targetplatform.targetplatform.TargetplatformPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Target Platform</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.obeo.releng.targetplatform.targetplatform.impl.TargetPlatformImpl#getName <em>Name</em>}</li>
 *   <li>{@link fr.obeo.releng.targetplatform.targetplatform.impl.TargetPlatformImpl#getOptions <em>Options</em>}</li>
 *   <li>{@link fr.obeo.releng.targetplatform.targetplatform.impl.TargetPlatformImpl#getImports <em>Imports</em>}</li>
 *   <li>{@link fr.obeo.releng.targetplatform.targetplatform.impl.TargetPlatformImpl#getLocations <em>Locations</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TargetPlatformImpl extends MinimalEObjectImpl.Container implements TargetPlatform
{
  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_EDEFAULT;

  /**
   * The cached value of the '{@link #getOptions() <em>Options</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOptions()
   * @generated
   * @ordered
   */
  protected EList<Option> options;

  /**
   * The cached value of the '{@link #getImports() <em>Imports</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getImports()
   * @generated
   * @ordered
   */
  protected EList<IncludeDeclaration> imports;

  /**
   * The cached value of the '{@link #getLocations() <em>Locations</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLocations()
   * @generated
   * @ordered
   */
  protected EList<Location> locations;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TargetPlatformImpl()
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
    return TargetplatformPackage.Literals.TARGET_PLATFORM;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName(String newName)
  {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TargetplatformPackage.TARGET_PLATFORM__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Option> getOptions()
  {
    if (options == null)
    {
      options = new EDataTypeEList<Option>(Option.class, this, TargetplatformPackage.TARGET_PLATFORM__OPTIONS);
    }
    return options;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<IncludeDeclaration> getImports()
  {
    if (imports == null)
    {
      imports = new EObjectContainmentEList<IncludeDeclaration>(IncludeDeclaration.class, this, TargetplatformPackage.TARGET_PLATFORM__IMPORTS);
    }
    return imports;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Location> getLocations()
  {
    if (locations == null)
    {
      locations = new EObjectContainmentEList<Location>(Location.class, this, TargetplatformPackage.TARGET_PLATFORM__LOCATIONS);
    }
    return locations;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case TargetplatformPackage.TARGET_PLATFORM__IMPORTS:
        return ((InternalEList<?>)getImports()).basicRemove(otherEnd, msgs);
      case TargetplatformPackage.TARGET_PLATFORM__LOCATIONS:
        return ((InternalEList<?>)getLocations()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
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
      case TargetplatformPackage.TARGET_PLATFORM__NAME:
        return getName();
      case TargetplatformPackage.TARGET_PLATFORM__OPTIONS:
        return getOptions();
      case TargetplatformPackage.TARGET_PLATFORM__IMPORTS:
        return getImports();
      case TargetplatformPackage.TARGET_PLATFORM__LOCATIONS:
        return getLocations();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case TargetplatformPackage.TARGET_PLATFORM__NAME:
        setName((String)newValue);
        return;
      case TargetplatformPackage.TARGET_PLATFORM__OPTIONS:
        getOptions().clear();
        getOptions().addAll((Collection<? extends Option>)newValue);
        return;
      case TargetplatformPackage.TARGET_PLATFORM__IMPORTS:
        getImports().clear();
        getImports().addAll((Collection<? extends IncludeDeclaration>)newValue);
        return;
      case TargetplatformPackage.TARGET_PLATFORM__LOCATIONS:
        getLocations().clear();
        getLocations().addAll((Collection<? extends Location>)newValue);
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
      case TargetplatformPackage.TARGET_PLATFORM__NAME:
        setName(NAME_EDEFAULT);
        return;
      case TargetplatformPackage.TARGET_PLATFORM__OPTIONS:
        getOptions().clear();
        return;
      case TargetplatformPackage.TARGET_PLATFORM__IMPORTS:
        getImports().clear();
        return;
      case TargetplatformPackage.TARGET_PLATFORM__LOCATIONS:
        getLocations().clear();
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
      case TargetplatformPackage.TARGET_PLATFORM__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case TargetplatformPackage.TARGET_PLATFORM__OPTIONS:
        return options != null && !options.isEmpty();
      case TargetplatformPackage.TARGET_PLATFORM__IMPORTS:
        return imports != null && !imports.isEmpty();
      case TargetplatformPackage.TARGET_PLATFORM__LOCATIONS:
        return locations != null && !locations.isEmpty();
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
    result.append(" (name: ");
    result.append(name);
    result.append(", options: ");
    result.append(options);
    result.append(')');
    return result.toString();
  }

} //TargetPlatformImpl
