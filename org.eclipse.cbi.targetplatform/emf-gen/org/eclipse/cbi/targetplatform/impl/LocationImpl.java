/**
 */
package org.eclipse.cbi.targetplatform.impl;

import java.util.Collection;

import org.eclipse.cbi.targetplatform.IU;
import org.eclipse.cbi.targetplatform.Location;
import org.eclipse.cbi.targetplatform.Option;
import org.eclipse.cbi.targetplatform.TargetPlatform;
import org.eclipse.cbi.targetplatform.TargetPlatformPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Location</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.cbi.targetplatform.impl.LocationImpl#getTargetPlatform <em>Target Platform</em>}</li>
 *   <li>{@link org.eclipse.cbi.targetplatform.impl.LocationImpl#getID <em>ID</em>}</li>
 *   <li>{@link org.eclipse.cbi.targetplatform.impl.LocationImpl#getUri <em>Uri</em>}</li>
 *   <li>{@link org.eclipse.cbi.targetplatform.impl.LocationImpl#getOptions <em>Options</em>}</li>
 *   <li>{@link org.eclipse.cbi.targetplatform.impl.LocationImpl#getIus <em>Ius</em>}</li>
 * </ul>
 *
 * @generated
 */
public class LocationImpl extends MinimalEObjectImpl.Container implements Location {
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
	protected LocationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TargetPlatformPackage.Literals.LOCATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TargetPlatform getTargetPlatform() {
		if (eContainerFeatureID() != TargetPlatformPackage.LOCATION__TARGET_PLATFORM) return null;
		return (TargetPlatform)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TargetPlatform basicGetTargetPlatform() {
		if (eContainerFeatureID() != TargetPlatformPackage.LOCATION__TARGET_PLATFORM) return null;
		return (TargetPlatform)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTargetPlatform(TargetPlatform newTargetPlatform, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newTargetPlatform, TargetPlatformPackage.LOCATION__TARGET_PLATFORM, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetPlatform(TargetPlatform newTargetPlatform) {
		if (newTargetPlatform != eInternalContainer() || (eContainerFeatureID() != TargetPlatformPackage.LOCATION__TARGET_PLATFORM && newTargetPlatform != null)) {
			if (EcoreUtil.isAncestor(this, newTargetPlatform))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newTargetPlatform != null)
				msgs = ((InternalEObject)newTargetPlatform).eInverseAdd(this, TargetPlatformPackage.TARGET_PLATFORM__CONTENTS, TargetPlatform.class, msgs);
			msgs = basicSetTargetPlatform(newTargetPlatform, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TargetPlatformPackage.LOCATION__TARGET_PLATFORM, newTargetPlatform, newTargetPlatform));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getID() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setID(String newID) {
		String oldID = id;
		id = newID;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TargetPlatformPackage.LOCATION__ID, oldID, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUri() {
		return uri;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUri(String newUri) {
		String oldUri = uri;
		uri = newUri;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TargetPlatformPackage.LOCATION__URI, oldUri, uri));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Option> getOptions() {
		if (options == null) {
			options = new EDataTypeEList<Option>(Option.class, this, TargetPlatformPackage.LOCATION__OPTIONS);
		}
		return options;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IU> getIus() {
		if (ius == null) {
			ius = new EObjectContainmentWithInverseEList<IU>(IU.class, this, TargetPlatformPackage.LOCATION__IUS, TargetPlatformPackage.IU__LOCATION);
		}
		return ius;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TargetPlatformPackage.LOCATION__TARGET_PLATFORM:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetTargetPlatform((TargetPlatform)otherEnd, msgs);
			case TargetPlatformPackage.LOCATION__IUS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getIus()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TargetPlatformPackage.LOCATION__TARGET_PLATFORM:
				return basicSetTargetPlatform(null, msgs);
			case TargetPlatformPackage.LOCATION__IUS:
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
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case TargetPlatformPackage.LOCATION__TARGET_PLATFORM:
				return eInternalContainer().eInverseRemove(this, TargetPlatformPackage.TARGET_PLATFORM__CONTENTS, TargetPlatform.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TargetPlatformPackage.LOCATION__TARGET_PLATFORM:
				if (resolve) return getTargetPlatform();
				return basicGetTargetPlatform();
			case TargetPlatformPackage.LOCATION__ID:
				return getID();
			case TargetPlatformPackage.LOCATION__URI:
				return getUri();
			case TargetPlatformPackage.LOCATION__OPTIONS:
				return getOptions();
			case TargetPlatformPackage.LOCATION__IUS:
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
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case TargetPlatformPackage.LOCATION__TARGET_PLATFORM:
				setTargetPlatform((TargetPlatform)newValue);
				return;
			case TargetPlatformPackage.LOCATION__ID:
				setID((String)newValue);
				return;
			case TargetPlatformPackage.LOCATION__URI:
				setUri((String)newValue);
				return;
			case TargetPlatformPackage.LOCATION__OPTIONS:
				getOptions().clear();
				getOptions().addAll((Collection<? extends Option>)newValue);
				return;
			case TargetPlatformPackage.LOCATION__IUS:
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
	public void eUnset(int featureID) {
		switch (featureID) {
			case TargetPlatformPackage.LOCATION__TARGET_PLATFORM:
				setTargetPlatform((TargetPlatform)null);
				return;
			case TargetPlatformPackage.LOCATION__ID:
				setID(ID_EDEFAULT);
				return;
			case TargetPlatformPackage.LOCATION__URI:
				setUri(URI_EDEFAULT);
				return;
			case TargetPlatformPackage.LOCATION__OPTIONS:
				getOptions().clear();
				return;
			case TargetPlatformPackage.LOCATION__IUS:
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
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case TargetPlatformPackage.LOCATION__TARGET_PLATFORM:
				return basicGetTargetPlatform() != null;
			case TargetPlatformPackage.LOCATION__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case TargetPlatformPackage.LOCATION__URI:
				return URI_EDEFAULT == null ? uri != null : !URI_EDEFAULT.equals(uri);
			case TargetPlatformPackage.LOCATION__OPTIONS:
				return options != null && !options.isEmpty();
			case TargetPlatformPackage.LOCATION__IUS:
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
	public String toString() {
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
