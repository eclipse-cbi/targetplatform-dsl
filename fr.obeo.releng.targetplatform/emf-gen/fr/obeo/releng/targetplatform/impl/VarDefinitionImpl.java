/**
 */
package fr.obeo.releng.targetplatform.impl;

import fr.obeo.releng.targetplatform.CompositeString;
import fr.obeo.releng.targetplatform.TargetPlatform;
import fr.obeo.releng.targetplatform.TargetPlatformPackage;
import fr.obeo.releng.targetplatform.VarDefinition;

import java.lang.reflect.InvocationTargetException;

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
 * An implementation of the model object '<em><b>Var Definition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link fr.obeo.releng.targetplatform.impl.VarDefinitionImpl#getTargetPlatform <em>Target Platform</em>}</li>
 *   <li>{@link fr.obeo.releng.targetplatform.impl.VarDefinitionImpl#getName <em>Name</em>}</li>
 *   <li>{@link fr.obeo.releng.targetplatform.impl.VarDefinitionImpl#getValue <em>Value</em>}</li>
 *   <li>{@link fr.obeo.releng.targetplatform.impl.VarDefinitionImpl#getOverrideValue <em>Override Value</em>}</li>
 *   <li>{@link fr.obeo.releng.targetplatform.impl.VarDefinitionImpl#isVariableDefinitionCycleDetected <em>Variable Definition Cycle Detected</em>}</li>
 *   <li>{@link fr.obeo.releng.targetplatform.impl.VarDefinitionImpl#getVarDefCycle <em>Var Def Cycle</em>}</li>
 *   <li>{@link fr.obeo.releng.targetplatform.impl.VarDefinitionImpl#isImported <em>Imported</em>}</li>
 * </ul>
 *
 * @generated
 */
public class VarDefinitionImpl extends MinimalEObjectImpl.Container implements VarDefinition {
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
	 * The cached value of the '{@link #getValue() <em>Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected CompositeString value;

	/**
	 * The default value of the '{@link #getOverrideValue() <em>Override Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOverrideValue()
	 * @generated
	 * @ordered
	 */
	protected static final String OVERRIDE_VALUE_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getOverrideValue() <em>Override Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOverrideValue()
	 * @generated
	 * @ordered
	 */
	protected String overrideValue = OVERRIDE_VALUE_EDEFAULT;

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
	 * The default value of the '{@link #isImported() <em>Imported</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isImported()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IMPORTED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isImported() <em>Imported</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isImported()
	 * @generated
	 * @ordered
	 */
	protected boolean imported = IMPORTED_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VarDefinitionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TargetPlatformPackage.Literals.VAR_DEFINITION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TargetPlatform getTargetPlatform() {
		if (eContainerFeatureID() != TargetPlatformPackage.VAR_DEFINITION__TARGET_PLATFORM) return null;
		return (TargetPlatform)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TargetPlatform basicGetTargetPlatform() {
		if (eContainerFeatureID() != TargetPlatformPackage.VAR_DEFINITION__TARGET_PLATFORM) return null;
		return (TargetPlatform)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTargetPlatform(TargetPlatform newTargetPlatform, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newTargetPlatform, TargetPlatformPackage.VAR_DEFINITION__TARGET_PLATFORM, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetPlatform(TargetPlatform newTargetPlatform) {
		if (newTargetPlatform != eInternalContainer() || (eContainerFeatureID() != TargetPlatformPackage.VAR_DEFINITION__TARGET_PLATFORM && newTargetPlatform != null)) {
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
			eNotify(new ENotificationImpl(this, Notification.SET, TargetPlatformPackage.VAR_DEFINITION__TARGET_PLATFORM, newTargetPlatform, newTargetPlatform));
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
			eNotify(new ENotificationImpl(this, Notification.SET, TargetPlatformPackage.VAR_DEFINITION__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompositeString getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetValue(CompositeString newValue, NotificationChain msgs) {
		CompositeString oldValue = value;
		value = newValue;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TargetPlatformPackage.VAR_DEFINITION__VALUE, oldValue, newValue);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValue(CompositeString newValue) {
		if (newValue != value) {
			NotificationChain msgs = null;
			if (value != null)
				msgs = ((InternalEObject)value).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TargetPlatformPackage.VAR_DEFINITION__VALUE, null, msgs);
			if (newValue != null)
				msgs = ((InternalEObject)newValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TargetPlatformPackage.VAR_DEFINITION__VALUE, null, msgs);
			msgs = basicSetValue(newValue, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TargetPlatformPackage.VAR_DEFINITION__VALUE, newValue, newValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOverrideValue() {
		return overrideValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOverrideValue(String newOverrideValue) {
		String oldOverrideValue = overrideValue;
		overrideValue = newOverrideValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TargetPlatformPackage.VAR_DEFINITION__OVERRIDE_VALUE, oldOverrideValue, overrideValue));
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
			eNotify(new ENotificationImpl(this, Notification.SET, TargetPlatformPackage.VAR_DEFINITION__VARIABLE_DEFINITION_CYCLE_DETECTED, oldVariableDefinitionCycleDetected, variableDefinitionCycleDetected));
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
			eNotify(new ENotificationImpl(this, Notification.SET, TargetPlatformPackage.VAR_DEFINITION__VAR_DEF_CYCLE, oldVarDefCycle, varDefCycle));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isImported() {
		return imported;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setImported(boolean newImported) {
		boolean oldImported = imported;
		imported = newImported;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TargetPlatformPackage.VAR_DEFINITION__IMPORTED, oldImported, imported));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void checkVarCycle() {
		this.setVariableDefinitionCycleDetected(false);
		this.setVarDefCycle(CollectionLiterals.<VarDefinition>newArrayList());
		this.getVarDefCycle().add(this);
		this.getValue().computeActualString(this.getVarDefCycle());
		this.setVariableDefinitionCycleDetected(this.getValue().isVariableDefinitionCycleDetected());
		boolean _isVariableDefinitionCycleDetected = this.isVariableDefinitionCycleDetected();
		if (_isVariableDefinitionCycleDetected) {
			this.setVarDefCycle(CollectionLiterals.<VarDefinition>newArrayList(((VarDefinition[])org.eclipse.xtext.xbase.lib.Conversions.unwrapArray(this.getValue().getVarDefCycle(), VarDefinition.class))));
		}
		else {
			this.setVarDefCycle(CollectionLiterals.<VarDefinition>newArrayList());
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void reset() {
		boolean _isImported = this.isImported();
		boolean _not = (!_isImported);
		if (_not) {
			this.getValue().reset();
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String toString() {
		this.checkVarCycle();
		String _string = super.toString();
		StringBuffer result = new StringBuffer(_string);
		result.append(" (name: ");
		result.append(this.getName());
		result.append(", overrideValue: ");
		result.append(this.getOverrideValue());
		result.append(", variableDefinitionCycleDetected: ");
		result.append(this.isVariableDefinitionCycleDetected());
		result.append(", varDefCycle: ");
		boolean _isVariableDefinitionCycleDetected = this.isVariableDefinitionCycleDetected();
		boolean _not = (!_isVariableDefinitionCycleDetected);
		if (_not) {
			result.append(this.getVarDefCycle());
		}
		else {
			result.append("erroneous cyclic definition");
		}
		result.append(")");
		return result.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TargetPlatformPackage.VAR_DEFINITION__TARGET_PLATFORM:
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
			case TargetPlatformPackage.VAR_DEFINITION__TARGET_PLATFORM:
				return basicSetTargetPlatform(null, msgs);
			case TargetPlatformPackage.VAR_DEFINITION__VALUE:
				return basicSetValue(null, msgs);
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
			case TargetPlatformPackage.VAR_DEFINITION__TARGET_PLATFORM:
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
			case TargetPlatformPackage.VAR_DEFINITION__TARGET_PLATFORM:
				if (resolve) return getTargetPlatform();
				return basicGetTargetPlatform();
			case TargetPlatformPackage.VAR_DEFINITION__NAME:
				return getName();
			case TargetPlatformPackage.VAR_DEFINITION__VALUE:
				return getValue();
			case TargetPlatformPackage.VAR_DEFINITION__OVERRIDE_VALUE:
				return getOverrideValue();
			case TargetPlatformPackage.VAR_DEFINITION__VARIABLE_DEFINITION_CYCLE_DETECTED:
				return isVariableDefinitionCycleDetected();
			case TargetPlatformPackage.VAR_DEFINITION__VAR_DEF_CYCLE:
				return getVarDefCycle();
			case TargetPlatformPackage.VAR_DEFINITION__IMPORTED:
				return isImported();
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
			case TargetPlatformPackage.VAR_DEFINITION__TARGET_PLATFORM:
				setTargetPlatform((TargetPlatform)newValue);
				return;
			case TargetPlatformPackage.VAR_DEFINITION__NAME:
				setName((String)newValue);
				return;
			case TargetPlatformPackage.VAR_DEFINITION__VALUE:
				setValue((CompositeString)newValue);
				return;
			case TargetPlatformPackage.VAR_DEFINITION__OVERRIDE_VALUE:
				setOverrideValue((String)newValue);
				return;
			case TargetPlatformPackage.VAR_DEFINITION__VARIABLE_DEFINITION_CYCLE_DETECTED:
				setVariableDefinitionCycleDetected((Boolean)newValue);
				return;
			case TargetPlatformPackage.VAR_DEFINITION__VAR_DEF_CYCLE:
				setVarDefCycle((List<VarDefinition>)newValue);
				return;
			case TargetPlatformPackage.VAR_DEFINITION__IMPORTED:
				setImported((Boolean)newValue);
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
			case TargetPlatformPackage.VAR_DEFINITION__TARGET_PLATFORM:
				setTargetPlatform((TargetPlatform)null);
				return;
			case TargetPlatformPackage.VAR_DEFINITION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case TargetPlatformPackage.VAR_DEFINITION__VALUE:
				setValue((CompositeString)null);
				return;
			case TargetPlatformPackage.VAR_DEFINITION__OVERRIDE_VALUE:
				setOverrideValue(OVERRIDE_VALUE_EDEFAULT);
				return;
			case TargetPlatformPackage.VAR_DEFINITION__VARIABLE_DEFINITION_CYCLE_DETECTED:
				setVariableDefinitionCycleDetected(VARIABLE_DEFINITION_CYCLE_DETECTED_EDEFAULT);
				return;
			case TargetPlatformPackage.VAR_DEFINITION__VAR_DEF_CYCLE:
				setVarDefCycle((List<VarDefinition>)null);
				return;
			case TargetPlatformPackage.VAR_DEFINITION__IMPORTED:
				setImported(IMPORTED_EDEFAULT);
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
			case TargetPlatformPackage.VAR_DEFINITION__TARGET_PLATFORM:
				return basicGetTargetPlatform() != null;
			case TargetPlatformPackage.VAR_DEFINITION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case TargetPlatformPackage.VAR_DEFINITION__VALUE:
				return value != null;
			case TargetPlatformPackage.VAR_DEFINITION__OVERRIDE_VALUE:
				return OVERRIDE_VALUE_EDEFAULT == null ? overrideValue != null : !OVERRIDE_VALUE_EDEFAULT.equals(overrideValue);
			case TargetPlatformPackage.VAR_DEFINITION__VARIABLE_DEFINITION_CYCLE_DETECTED:
				return variableDefinitionCycleDetected != VARIABLE_DEFINITION_CYCLE_DETECTED_EDEFAULT;
			case TargetPlatformPackage.VAR_DEFINITION__VAR_DEF_CYCLE:
				return varDefCycle != null;
			case TargetPlatformPackage.VAR_DEFINITION__IMPORTED:
				return imported != IMPORTED_EDEFAULT;
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
			case TargetPlatformPackage.VAR_DEFINITION___CHECK_VAR_CYCLE:
				checkVarCycle();
				return null;
			case TargetPlatformPackage.VAR_DEFINITION___RESET:
				reset();
				return null;
			case TargetPlatformPackage.VAR_DEFINITION___TO_STRING:
				return toString();
		}
		return super.eInvoke(operationID, arguments);
	}

} //VarDefinitionImpl
