/**
 */
package fr.obeo.releng.targetplatform.impl;

import fr.obeo.releng.targetplatform.CompositeString;
import fr.obeo.releng.targetplatform.TargetPlatformPackage;
import fr.obeo.releng.targetplatform.VarCall;
import fr.obeo.releng.targetplatform.VarDefinition;

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
 * An implementation of the model object '<em><b>Var Call</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link fr.obeo.releng.targetplatform.impl.VarCallImpl#getCompositeString <em>Composite String</em>}</li>
 *   <li>{@link fr.obeo.releng.targetplatform.impl.VarCallImpl#getVarName <em>Var Name</em>}</li>
 * </ul>
 *
 * @generated
 */
public class VarCallImpl extends MinimalEObjectImpl.Container implements VarCall {
	/**
	 * The cached value of the '{@link #getVarName() <em>Var Name</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVarName()
	 * @generated
	 * @ordered
	 */
	protected VarDefinition varName;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VarCallImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TargetPlatformPackage.Literals.VAR_CALL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompositeString getCompositeString() {
		if (eContainerFeatureID() != TargetPlatformPackage.VAR_CALL__COMPOSITE_STRING) return null;
		return (CompositeString)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompositeString basicGetCompositeString() {
		if (eContainerFeatureID() != TargetPlatformPackage.VAR_CALL__COMPOSITE_STRING) return null;
		return (CompositeString)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCompositeString(CompositeString newCompositeString, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newCompositeString, TargetPlatformPackage.VAR_CALL__COMPOSITE_STRING, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCompositeString(CompositeString newCompositeString) {
		if (newCompositeString != eInternalContainer() || (eContainerFeatureID() != TargetPlatformPackage.VAR_CALL__COMPOSITE_STRING && newCompositeString != null)) {
			if (EcoreUtil.isAncestor(this, newCompositeString))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newCompositeString != null)
				msgs = ((InternalEObject)newCompositeString).eInverseAdd(this, TargetPlatformPackage.COMPOSITE_STRING__STRING_PARTS, CompositeString.class, msgs);
			msgs = basicSetCompositeString(newCompositeString, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TargetPlatformPackage.VAR_CALL__COMPOSITE_STRING, newCompositeString, newCompositeString));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VarDefinition getVarName() {
		if (varName != null && varName.eIsProxy()) {
			InternalEObject oldVarName = (InternalEObject)varName;
			varName = (VarDefinition)eResolveProxy(oldVarName);
			if (varName != oldVarName) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TargetPlatformPackage.VAR_CALL__VAR_NAME, oldVarName, varName));
			}
		}
		return varName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VarDefinition basicGetVarName() {
		return varName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVarName(VarDefinition newVarName) {
		VarDefinition oldVarName = varName;
		varName = newVarName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TargetPlatformPackage.VAR_CALL__VAR_NAME, oldVarName, varName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getActualString() {
		return this.getVarName().getValue();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TargetPlatformPackage.VAR_CALL__COMPOSITE_STRING:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetCompositeString((CompositeString)otherEnd, msgs);
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
			case TargetPlatformPackage.VAR_CALL__COMPOSITE_STRING:
				return basicSetCompositeString(null, msgs);
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
			case TargetPlatformPackage.VAR_CALL__COMPOSITE_STRING:
				return eInternalContainer().eInverseRemove(this, TargetPlatformPackage.COMPOSITE_STRING__STRING_PARTS, CompositeString.class, msgs);
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
			case TargetPlatformPackage.VAR_CALL__COMPOSITE_STRING:
				if (resolve) return getCompositeString();
				return basicGetCompositeString();
			case TargetPlatformPackage.VAR_CALL__VAR_NAME:
				if (resolve) return getVarName();
				return basicGetVarName();
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
			case TargetPlatformPackage.VAR_CALL__COMPOSITE_STRING:
				setCompositeString((CompositeString)newValue);
				return;
			case TargetPlatformPackage.VAR_CALL__VAR_NAME:
				setVarName((VarDefinition)newValue);
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
			case TargetPlatformPackage.VAR_CALL__COMPOSITE_STRING:
				setCompositeString((CompositeString)null);
				return;
			case TargetPlatformPackage.VAR_CALL__VAR_NAME:
				setVarName((VarDefinition)null);
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
			case TargetPlatformPackage.VAR_CALL__COMPOSITE_STRING:
				return basicGetCompositeString() != null;
			case TargetPlatformPackage.VAR_CALL__VAR_NAME:
				return varName != null;
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
			case TargetPlatformPackage.VAR_CALL___GET_ACTUAL_STRING:
				return getActualString();
		}
		return super.eInvoke(operationID, arguments);
	}

} //VarCallImpl
