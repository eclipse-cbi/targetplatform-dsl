/**
 */
package fr.obeo.releng.targetplatform.impl;

import fr.obeo.releng.targetplatform.CompositeString;
import fr.obeo.releng.targetplatform.StaticString;
import fr.obeo.releng.targetplatform.TargetPlatformFactory;
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
 * An implementation of the model object '<em><b>Static String</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link fr.obeo.releng.targetplatform.impl.StaticStringImpl#getCompositeString <em>Composite String</em>}</li>
 *   <li>{@link fr.obeo.releng.targetplatform.impl.StaticStringImpl#getValue <em>Value</em>}</li>
 *   <li>{@link fr.obeo.releng.targetplatform.impl.StaticStringImpl#isVariableDefinitionCycleDetected <em>Variable Definition Cycle Detected</em>}</li>
 *   <li>{@link fr.obeo.releng.targetplatform.impl.StaticStringImpl#getVarDefCycle <em>Var Def Cycle</em>}</li>
 * </ul>
 *
 * @generated
 */
public class StaticStringImpl extends MinimalEObjectImpl.Container implements StaticString {
	/**
	 * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected static final String VALUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected String value = VALUE_EDEFAULT;

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
	protected StaticStringImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TargetPlatformPackage.Literals.STATIC_STRING;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompositeString getCompositeString() {
		if (eContainerFeatureID() != TargetPlatformPackage.STATIC_STRING__COMPOSITE_STRING) return null;
		return (CompositeString)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompositeString basicGetCompositeString() {
		if (eContainerFeatureID() != TargetPlatformPackage.STATIC_STRING__COMPOSITE_STRING) return null;
		return (CompositeString)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCompositeString(CompositeString newCompositeString, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newCompositeString, TargetPlatformPackage.STATIC_STRING__COMPOSITE_STRING, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCompositeString(CompositeString newCompositeString) {
		if (newCompositeString != eInternalContainer() || (eContainerFeatureID() != TargetPlatformPackage.STATIC_STRING__COMPOSITE_STRING && newCompositeString != null)) {
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
			eNotify(new ENotificationImpl(this, Notification.SET, TargetPlatformPackage.STATIC_STRING__COMPOSITE_STRING, newCompositeString, newCompositeString));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValue(String newValue) {
		String oldValue = value;
		value = newValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TargetPlatformPackage.STATIC_STRING__VALUE, oldValue, value));
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
			eNotify(new ENotificationImpl(this, Notification.SET, TargetPlatformPackage.STATIC_STRING__VARIABLE_DEFINITION_CYCLE_DETECTED, oldVariableDefinitionCycleDetected, variableDefinitionCycleDetected));
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
			eNotify(new ENotificationImpl(this, Notification.SET, TargetPlatformPackage.STATIC_STRING__VAR_DEF_CYCLE, oldVarDefCycle, varDefCycle));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getActualString() {
		this.setVarDefCycle(CollectionLiterals.<VarDefinition>newArrayList());
		return this.getValue();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getActualString(final List<VarDefinition> alreadyCalledVariable) {
		return this.getActualString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StaticString getCopy() {
		final StaticString output = TargetPlatformFactory.eINSTANCE.createStaticString();
		output.setValue(this.getValue());
		return output;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void reset() {
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TargetPlatformPackage.STATIC_STRING__COMPOSITE_STRING:
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
			case TargetPlatformPackage.STATIC_STRING__COMPOSITE_STRING:
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
			case TargetPlatformPackage.STATIC_STRING__COMPOSITE_STRING:
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
			case TargetPlatformPackage.STATIC_STRING__COMPOSITE_STRING:
				if (resolve) return getCompositeString();
				return basicGetCompositeString();
			case TargetPlatformPackage.STATIC_STRING__VALUE:
				return getValue();
			case TargetPlatformPackage.STATIC_STRING__VARIABLE_DEFINITION_CYCLE_DETECTED:
				return isVariableDefinitionCycleDetected();
			case TargetPlatformPackage.STATIC_STRING__VAR_DEF_CYCLE:
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
			case TargetPlatformPackage.STATIC_STRING__COMPOSITE_STRING:
				setCompositeString((CompositeString)newValue);
				return;
			case TargetPlatformPackage.STATIC_STRING__VALUE:
				setValue((String)newValue);
				return;
			case TargetPlatformPackage.STATIC_STRING__VARIABLE_DEFINITION_CYCLE_DETECTED:
				setVariableDefinitionCycleDetected((Boolean)newValue);
				return;
			case TargetPlatformPackage.STATIC_STRING__VAR_DEF_CYCLE:
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
			case TargetPlatformPackage.STATIC_STRING__COMPOSITE_STRING:
				setCompositeString((CompositeString)null);
				return;
			case TargetPlatformPackage.STATIC_STRING__VALUE:
				setValue(VALUE_EDEFAULT);
				return;
			case TargetPlatformPackage.STATIC_STRING__VARIABLE_DEFINITION_CYCLE_DETECTED:
				setVariableDefinitionCycleDetected(VARIABLE_DEFINITION_CYCLE_DETECTED_EDEFAULT);
				return;
			case TargetPlatformPackage.STATIC_STRING__VAR_DEF_CYCLE:
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
			case TargetPlatformPackage.STATIC_STRING__COMPOSITE_STRING:
				return basicGetCompositeString() != null;
			case TargetPlatformPackage.STATIC_STRING__VALUE:
				return VALUE_EDEFAULT == null ? value != null : !VALUE_EDEFAULT.equals(value);
			case TargetPlatformPackage.STATIC_STRING__VARIABLE_DEFINITION_CYCLE_DETECTED:
				return variableDefinitionCycleDetected != VARIABLE_DEFINITION_CYCLE_DETECTED_EDEFAULT;
			case TargetPlatformPackage.STATIC_STRING__VAR_DEF_CYCLE:
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
			case TargetPlatformPackage.STATIC_STRING___GET_ACTUAL_STRING:
				return getActualString();
			case TargetPlatformPackage.STATIC_STRING___GET_ACTUAL_STRING__LIST:
				return getActualString((List<VarDefinition>)arguments.get(0));
			case TargetPlatformPackage.STATIC_STRING___GET_COPY:
				return getCopy();
			case TargetPlatformPackage.STATIC_STRING___RESET:
				reset();
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
		result.append(" (value: ");
		result.append(value);
		result.append(", variableDefinitionCycleDetected: ");
		result.append(variableDefinitionCycleDetected);
		result.append(", varDefCycle: ");
		result.append(varDefCycle);
		result.append(')');
		return result.toString();
	}

} //StaticStringImpl
