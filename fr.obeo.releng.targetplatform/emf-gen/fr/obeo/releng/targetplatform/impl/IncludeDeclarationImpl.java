/**
 */
package fr.obeo.releng.targetplatform.impl;

import fr.obeo.releng.targetplatform.CompositeString;
import fr.obeo.releng.targetplatform.IncludeDeclaration;
import fr.obeo.releng.targetplatform.TargetPlatform;
import fr.obeo.releng.targetplatform.TargetPlatformPackage;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Include Declaration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link fr.obeo.releng.targetplatform.impl.IncludeDeclarationImpl#getTargetPlatform <em>Target Platform</em>}</li>
 *   <li>{@link fr.obeo.releng.targetplatform.impl.IncludeDeclarationImpl#getName <em>Name</em>}</li>
 *   <li>{@link fr.obeo.releng.targetplatform.impl.IncludeDeclarationImpl#getCompositeImportURI <em>Composite Import URI</em>}</li>
 *   <li>{@link fr.obeo.releng.targetplatform.impl.IncludeDeclarationImpl#getImportURI <em>Import URI</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IncludeDeclarationImpl extends MinimalEObjectImpl.Container implements IncludeDeclaration {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = "include declaration";

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
	 * The cached value of the '{@link #getCompositeImportURI() <em>Composite Import URI</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCompositeImportURI()
	 * @generated
	 * @ordered
	 */
	protected CompositeString compositeImportURI;

	/**
	 * The default value of the '{@link #getImportURI() <em>Import URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImportURI()
	 * @generated
	 * @ordered
	 */
	protected static final String IMPORT_URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getImportURI() <em>Import URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImportURI()
	 * @generated
	 * @ordered
	 */
	protected String importURI = IMPORT_URI_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IncludeDeclarationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TargetPlatformPackage.Literals.INCLUDE_DECLARATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TargetPlatform getTargetPlatform() {
		if (eContainerFeatureID() != TargetPlatformPackage.INCLUDE_DECLARATION__TARGET_PLATFORM) return null;
		return (TargetPlatform)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TargetPlatform basicGetTargetPlatform() {
		if (eContainerFeatureID() != TargetPlatformPackage.INCLUDE_DECLARATION__TARGET_PLATFORM) return null;
		return (TargetPlatform)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTargetPlatform(TargetPlatform newTargetPlatform, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newTargetPlatform, TargetPlatformPackage.INCLUDE_DECLARATION__TARGET_PLATFORM, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetPlatform(TargetPlatform newTargetPlatform) {
		if (newTargetPlatform != eInternalContainer() || (eContainerFeatureID() != TargetPlatformPackage.INCLUDE_DECLARATION__TARGET_PLATFORM && newTargetPlatform != null)) {
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
			eNotify(new ENotificationImpl(this, Notification.SET, TargetPlatformPackage.INCLUDE_DECLARATION__TARGET_PLATFORM, newTargetPlatform, newTargetPlatform));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TargetPlatformPackage.INCLUDE_DECLARATION__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompositeString getCompositeImportURI() {
		return compositeImportURI;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCompositeImportURI(CompositeString newCompositeImportURI, NotificationChain msgs) {
		CompositeString oldCompositeImportURI = compositeImportURI;
		compositeImportURI = newCompositeImportURI;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TargetPlatformPackage.INCLUDE_DECLARATION__COMPOSITE_IMPORT_URI, oldCompositeImportURI, newCompositeImportURI);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCompositeImportURI(CompositeString newCompositeImportURI) {
		if (newCompositeImportURI != compositeImportURI) {
			NotificationChain msgs = null;
			if (compositeImportURI != null)
				msgs = ((InternalEObject)compositeImportURI).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TargetPlatformPackage.INCLUDE_DECLARATION__COMPOSITE_IMPORT_URI, null, msgs);
			if (newCompositeImportURI != null)
				msgs = ((InternalEObject)newCompositeImportURI).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TargetPlatformPackage.INCLUDE_DECLARATION__COMPOSITE_IMPORT_URI, null, msgs);
			msgs = basicSetCompositeImportURI(newCompositeImportURI, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TargetPlatformPackage.INCLUDE_DECLARATION__COMPOSITE_IMPORT_URI, newCompositeImportURI, newCompositeImportURI));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getImportURI() {
		return importURI;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setImportURI(String newImportURI) {
		String oldImportURI = importURI;
		importURI = newImportURI;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TargetPlatformPackage.INCLUDE_DECLARATION__IMPORT_URI, oldImportURI, importURI));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void generateImportURI() {
		this.setImportURI(this.getCompositeImportURI().computeActualString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TargetPlatformPackage.INCLUDE_DECLARATION__TARGET_PLATFORM:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetTargetPlatform((TargetPlatform)otherEnd, msgs);
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
			case TargetPlatformPackage.INCLUDE_DECLARATION__TARGET_PLATFORM:
				return basicSetTargetPlatform(null, msgs);
			case TargetPlatformPackage.INCLUDE_DECLARATION__COMPOSITE_IMPORT_URI:
				return basicSetCompositeImportURI(null, msgs);
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
			case TargetPlatformPackage.INCLUDE_DECLARATION__TARGET_PLATFORM:
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
			case TargetPlatformPackage.INCLUDE_DECLARATION__TARGET_PLATFORM:
				if (resolve) return getTargetPlatform();
				return basicGetTargetPlatform();
			case TargetPlatformPackage.INCLUDE_DECLARATION__NAME:
				return getName();
			case TargetPlatformPackage.INCLUDE_DECLARATION__COMPOSITE_IMPORT_URI:
				return getCompositeImportURI();
			case TargetPlatformPackage.INCLUDE_DECLARATION__IMPORT_URI:
				return getImportURI();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case TargetPlatformPackage.INCLUDE_DECLARATION__TARGET_PLATFORM:
				setTargetPlatform((TargetPlatform)newValue);
				return;
			case TargetPlatformPackage.INCLUDE_DECLARATION__NAME:
				setName((String)newValue);
				return;
			case TargetPlatformPackage.INCLUDE_DECLARATION__COMPOSITE_IMPORT_URI:
				setCompositeImportURI((CompositeString)newValue);
				return;
			case TargetPlatformPackage.INCLUDE_DECLARATION__IMPORT_URI:
				setImportURI((String)newValue);
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
			case TargetPlatformPackage.INCLUDE_DECLARATION__TARGET_PLATFORM:
				setTargetPlatform((TargetPlatform)null);
				return;
			case TargetPlatformPackage.INCLUDE_DECLARATION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case TargetPlatformPackage.INCLUDE_DECLARATION__COMPOSITE_IMPORT_URI:
				setCompositeImportURI((CompositeString)null);
				return;
			case TargetPlatformPackage.INCLUDE_DECLARATION__IMPORT_URI:
				setImportURI(IMPORT_URI_EDEFAULT);
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
			case TargetPlatformPackage.INCLUDE_DECLARATION__TARGET_PLATFORM:
				return basicGetTargetPlatform() != null;
			case TargetPlatformPackage.INCLUDE_DECLARATION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case TargetPlatformPackage.INCLUDE_DECLARATION__COMPOSITE_IMPORT_URI:
				return compositeImportURI != null;
			case TargetPlatformPackage.INCLUDE_DECLARATION__IMPORT_URI:
				return IMPORT_URI_EDEFAULT == null ? importURI != null : !IMPORT_URI_EDEFAULT.equals(importURI);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case TargetPlatformPackage.INCLUDE_DECLARATION___GENERATE_IMPORT_URI:
				generateImportURI();
				return null;
		}
		return super.eInvoke(operationID, arguments);
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
		result.append(" (name: ");
		result.append(name);
		result.append(", importURI: ");
		result.append(importURI);
		result.append(')');
		return result.toString();
	}

} //IncludeDeclarationImpl
