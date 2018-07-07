/**
 */
package fr.obeo.releng.targetplatform.impl;

import fr.obeo.releng.targetplatform.CompositeString;
import fr.obeo.releng.targetplatform.TargetPlatformFactory;
import fr.obeo.releng.targetplatform.TargetPlatformPackage;
import fr.obeo.releng.targetplatform.VarCall;
import fr.obeo.releng.targetplatform.VarDefinition;

import java.lang.reflect.InvocationTargetException;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

import org.eclipse.xtext.xbase.lib.CollectionLiterals;

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
 *   <li>{@link fr.obeo.releng.targetplatform.impl.VarCallImpl#getOriginalVarName <em>Original Var Name</em>}</li>
 *   <li>{@link fr.obeo.releng.targetplatform.impl.VarCallImpl#isVariableDefinitionCycleDetected <em>Variable Definition Cycle Detected</em>}</li>
 *   <li>{@link fr.obeo.releng.targetplatform.impl.VarCallImpl#getVarDefCycle <em>Var Def Cycle</em>}</li>
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
	 * The cached value of the '{@link #getOriginalVarName() <em>Original Var Name</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOriginalVarName()
	 * @generated
	 * @ordered
	 */
	protected VarDefinition originalVarName;

	/**
	 * The default value of the '{@link #isVariableDefinitionCycleDetected() <em>Variable Definition Cycle Detected</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isVariableDefinitionCycleDetected()
	 * @generated
	 * @ordered
	 */
	protected static final boolean VARIABLE_DEFINITION_CYCLE_DETECTED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isVariableDefinitionCycleDetected() <em>Variable Definition Cycle Detected</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isVariableDefinitionCycleDetected()
	 * @generated
	 * @ordered
	 */
	protected boolean variableDefinitionCycleDetected = VARIABLE_DEFINITION_CYCLE_DETECTED_EDEFAULT;

	/**
	 * The cached value of the '{@link #getVarDefCycle() <em>Var Def Cycle</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVarDefCycle()
	 * @generated
	 * @ordered
	 */
	protected List<VarDefinition> varDefCycle;

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
	public VarDefinition getOriginalVarName() {
		if (originalVarName != null && originalVarName.eIsProxy()) {
			InternalEObject oldOriginalVarName = (InternalEObject)originalVarName;
			originalVarName = (VarDefinition)eResolveProxy(oldOriginalVarName);
			if (originalVarName != oldOriginalVarName) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TargetPlatformPackage.VAR_CALL__ORIGINAL_VAR_NAME, oldOriginalVarName, originalVarName));
			}
		}
		return originalVarName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VarDefinition basicGetOriginalVarName() {
		return originalVarName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOriginalVarName(VarDefinition newOriginalVarName) {
		VarDefinition oldOriginalVarName = originalVarName;
		originalVarName = newOriginalVarName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TargetPlatformPackage.VAR_CALL__ORIGINAL_VAR_NAME, oldOriginalVarName, originalVarName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isVariableDefinitionCycleDetected() {
		return variableDefinitionCycleDetected;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVariableDefinitionCycleDetected(boolean newVariableDefinitionCycleDetected) {
		boolean oldVariableDefinitionCycleDetected = variableDefinitionCycleDetected;
		variableDefinitionCycleDetected = newVariableDefinitionCycleDetected;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TargetPlatformPackage.VAR_CALL__VARIABLE_DEFINITION_CYCLE_DETECTED, oldVariableDefinitionCycleDetected, variableDefinitionCycleDetected));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<VarDefinition> getVarDefCycle() {
		return varDefCycle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVarDefCycle(List<VarDefinition> newVarDefCycle) {
		List<VarDefinition> oldVarDefCycle = varDefCycle;
		varDefCycle = newVarDefCycle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TargetPlatformPackage.VAR_CALL__VAR_DEF_CYCLE, oldVarDefCycle, varDefCycle));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getActualString() {
		final ArrayList<VarDefinition> alreadyCalledVariable = CollectionLiterals.<VarDefinition>newArrayList();
		return this.getActualString(alreadyCalledVariable);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getActualString(final List<VarDefinition> alreadyCalledVariable) {
		this.setVariableDefinitionCycleDetected(false);
		CompositeString _value = this.getVarName().getValue();
		boolean _tripleNotEquals = (_value != null);
		if (_tripleNotEquals) {
			boolean _contains = alreadyCalledVariable.contains(this.getVarName());
			if (_contains) {
				this.setVariableDefinitionCycleDetected(true);
			}
			alreadyCalledVariable.add(this.getVarName());
			boolean _isVariableDefinitionCycleDetected = this.isVariableDefinitionCycleDetected();
			if (_isVariableDefinitionCycleDetected) {
				this.setVarDefCycle(CollectionLiterals.<VarDefinition>newArrayList(((VarDefinition[])org.eclipse.xtext.xbase.lib.Conversions.unwrapArray(alreadyCalledVariable, VarDefinition.class))));
				return "";
			}
		}
		boolean _isEmpty = this.getVarName().getOverrideValue().isEmpty();
		if (_isEmpty) {
			CompositeString _value_1 = this.getVarName().getValue();
			boolean _tripleNotEquals_1 = (_value_1 != null);
			if (_tripleNotEquals_1) {
				final String stringOutput = this.getVarName().getValue().computeActualString(alreadyCalledVariable);
				this.setVariableDefinitionCycleDetected(this.getVarName().getValue().isVariableDefinitionCycleDetected());
				boolean _isVariableDefinitionCycleDetected_1 = this.isVariableDefinitionCycleDetected();
				if (_isVariableDefinitionCycleDetected_1) {
					this.setVarDefCycle(CollectionLiterals.<VarDefinition>newArrayList(((VarDefinition[])org.eclipse.xtext.xbase.lib.Conversions.unwrapArray(this.getVarName().getValue().getVarDefCycle(), VarDefinition.class))));
					return "";
				}
				return stringOutput;
			}
			return "";
		}
		return this.getVarName().getOverrideValue();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VarCall getCopy() {
		final VarCall output = TargetPlatformFactory.eINSTANCE.createVarCall();
		output.setVarName(this.getVarName());
		return output;
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
			case TargetPlatformPackage.VAR_CALL__ORIGINAL_VAR_NAME:
				if (resolve) return getOriginalVarName();
				return basicGetOriginalVarName();
			case TargetPlatformPackage.VAR_CALL__VARIABLE_DEFINITION_CYCLE_DETECTED:
				return isVariableDefinitionCycleDetected();
			case TargetPlatformPackage.VAR_CALL__VAR_DEF_CYCLE:
				return getVarDefCycle();
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
			case TargetPlatformPackage.VAR_CALL__COMPOSITE_STRING:
				setCompositeString((CompositeString)newValue);
				return;
			case TargetPlatformPackage.VAR_CALL__VAR_NAME:
				setVarName((VarDefinition)newValue);
				return;
			case TargetPlatformPackage.VAR_CALL__ORIGINAL_VAR_NAME:
				setOriginalVarName((VarDefinition)newValue);
				return;
			case TargetPlatformPackage.VAR_CALL__VARIABLE_DEFINITION_CYCLE_DETECTED:
				setVariableDefinitionCycleDetected((Boolean)newValue);
				return;
			case TargetPlatformPackage.VAR_CALL__VAR_DEF_CYCLE:
				setVarDefCycle((List<VarDefinition>)newValue);
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
			case TargetPlatformPackage.VAR_CALL__ORIGINAL_VAR_NAME:
				setOriginalVarName((VarDefinition)null);
				return;
			case TargetPlatformPackage.VAR_CALL__VARIABLE_DEFINITION_CYCLE_DETECTED:
				setVariableDefinitionCycleDetected(VARIABLE_DEFINITION_CYCLE_DETECTED_EDEFAULT);
				return;
			case TargetPlatformPackage.VAR_CALL__VAR_DEF_CYCLE:
				setVarDefCycle((List<VarDefinition>)null);
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
			case TargetPlatformPackage.VAR_CALL__ORIGINAL_VAR_NAME:
				return originalVarName != null;
			case TargetPlatformPackage.VAR_CALL__VARIABLE_DEFINITION_CYCLE_DETECTED:
				return variableDefinitionCycleDetected != VARIABLE_DEFINITION_CYCLE_DETECTED_EDEFAULT;
			case TargetPlatformPackage.VAR_CALL__VAR_DEF_CYCLE:
				return varDefCycle != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	@SuppressWarnings("unchecked")
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case TargetPlatformPackage.VAR_CALL___GET_ACTUAL_STRING:
				return getActualString();
			case TargetPlatformPackage.VAR_CALL___GET_ACTUAL_STRING__LIST:
				return getActualString((List<VarDefinition>)arguments.get(0));
			case TargetPlatformPackage.VAR_CALL___GET_COPY:
				return getCopy();
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
		result.append(" (variableDefinitionCycleDetected: ");
		result.append(variableDefinitionCycleDetected);
		result.append(", varDefCycle: ");
		result.append(varDefCycle);
		result.append(')');
		return result.toString();
	}

} //VarCallImpl
