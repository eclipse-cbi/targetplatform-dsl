/**
 */
package fr.obeo.releng.targetplatform.targetplatform.impl;

import fr.obeo.releng.targetplatform.targetplatform.IU;
import fr.obeo.releng.targetplatform.targetplatform.Location;
import fr.obeo.releng.targetplatform.targetplatform.Option;
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
 * An implementation of the model object '<em><b>Location</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.obeo.releng.targetplatform.targetplatform.impl.LocationImpl#getID <em>ID</em>}</li>
 *   <li>{@link fr.obeo.releng.targetplatform.targetplatform.impl.LocationImpl#getUri <em>Uri</em>}</li>
 *   <li>{@link fr.obeo.releng.targetplatform.targetplatform.impl.LocationImpl#getOptions <em>Options</em>}</li>
 *   <li>{@link fr.obeo.releng.targetplatform.targetplatform.impl.LocationImpl#getIus <em>Ius</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LocationImpl extends MinimalEObjectImpl.Container implements Location
{
  /**
   * The default value of the '{@link #getID() <em>ID</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getID()
   * @generated
   * @ordered
   */
  protected static final String ID_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getID() <em>ID</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getID()
   * @generated
   * @ordered
   */
  protected String id = ID_EDEFAULT;

  /**
   * The default value of the '{@link #getUri() <em>Uri</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUri()
   * @generated
   * @ordered
   */
  protected static final String URI_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getUri() <em>Uri</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUri()
   * @generated
   * @ordered
   */
  protected String uri = URI_EDEFAULT;

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
   * The cached value of the '{@link #getIus() <em>Ius</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIus()
   * @generated
   * @ordered
   */
  protected EList<IU> ius;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected LocationImpl()
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
    return TargetplatformPackage.Literals.LOCATION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getID()
  {
    return id;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setID(String newID)
  {
    String oldID = id;
    id = newID;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TargetplatformPackage.LOCATION__ID, oldID, id));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getUri()
  {
    return uri;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setUri(String newUri)
  {
    String oldUri = uri;
    uri = newUri;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TargetplatformPackage.LOCATION__URI, oldUri, uri));
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
      options = new EDataTypeEList<Option>(Option.class, this, TargetplatformPackage.LOCATION__OPTIONS);
    }
    return options;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<IU> getIus()
  {
    if (ius == null)
    {
      ius = new EObjectContainmentEList<IU>(IU.class, this, TargetplatformPackage.LOCATION__IUS);
    }
    return ius;
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
      case TargetplatformPackage.LOCATION__IUS:
        return ((InternalEList<?>)getIus()).basicRemove(otherEnd, msgs);
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
      case TargetplatformPackage.LOCATION__ID:
        return getID();
      case TargetplatformPackage.LOCATION__URI:
        return getUri();
      case TargetplatformPackage.LOCATION__OPTIONS:
        return getOptions();
      case TargetplatformPackage.LOCATION__IUS:
        return getIus();
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
      case TargetplatformPackage.LOCATION__ID:
        setID((String)newValue);
        return;
      case TargetplatformPackage.LOCATION__URI:
        setUri((String)newValue);
        return;
      case TargetplatformPackage.LOCATION__OPTIONS:
        getOptions().clear();
        getOptions().addAll((Collection<? extends Option>)newValue);
        return;
      case TargetplatformPackage.LOCATION__IUS:
        getIus().clear();
        getIus().addAll((Collection<? extends IU>)newValue);
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
      case TargetplatformPackage.LOCATION__ID:
        setID(ID_EDEFAULT);
        return;
      case TargetplatformPackage.LOCATION__URI:
        setUri(URI_EDEFAULT);
        return;
      case TargetplatformPackage.LOCATION__OPTIONS:
        getOptions().clear();
        return;
      case TargetplatformPackage.LOCATION__IUS:
        getIus().clear();
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
      case TargetplatformPackage.LOCATION__ID:
        return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
      case TargetplatformPackage.LOCATION__URI:
        return URI_EDEFAULT == null ? uri != null : !URI_EDEFAULT.equals(uri);
      case TargetplatformPackage.LOCATION__OPTIONS:
        return options != null && !options.isEmpty();
      case TargetplatformPackage.LOCATION__IUS:
        return ius != null && !ius.isEmpty();
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
    result.append(" (ID: ");
    result.append(id);
    result.append(", uri: ");
    result.append(uri);
    result.append(", options: ");
    result.append(options);
    result.append(')');
    return result.toString();
  }

} //LocationImpl
