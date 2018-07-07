/**
 */
package fr.obeo.releng.targetplatform.impl;

import fr.obeo.releng.targetplatform.CompositeString;
import fr.obeo.releng.targetplatform.CompositeStringPart;
import fr.obeo.releng.targetplatform.TargetPlatformFactory;
import fr.obeo.releng.targetplatform.TargetPlatformPackage;
import fr.obeo.releng.targetplatform.VarDefinition;

import java.lang.reflect.InvocationTargetException;

import java.util.Collection;
import java.util.List;

import java.util.function.Consumer;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.xtext.xbase.lib.CollectionLiterals;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Composite String</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link fr.obeo.releng.targetplatform.impl.CompositeStringImpl#getName <em>Name</em>}</li>
 *   <li>{@link fr.obeo.releng.targetplatform.impl.CompositeStringImpl#getStringParts <em>String Parts</em>}</li>
 *   <li>{@link fr.obeo.releng.targetplatform.impl.CompositeStringImpl#isVariableDefinitionCycleDetected <em>Variable Definition Cycle Detected</em>}</li>
 *   <li>{@link fr.obeo.releng.targetplatform.impl.CompositeStringImpl#getVarDefCycle <em>Var Def Cycle</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CompositeStringImpl extends MinimalEObjectImpl.Container implements CompositeString {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = "composite string";

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
	 * The cached value of the '{@link #getStringParts() <em>String Parts</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStringParts()
	 * @generated
	 * @ordered
	 */
	protected EList<CompositeStringPart> stringParts;

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
	protected CompositeStringImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TargetPlatformPackage.Literals.COMPOSITE_STRING;
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
			eNotify(new ENotificationImpl(this, Notification.SET, TargetPlatformPackage.COMPOSITE_STRING__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CompositeStringPart> getStringParts() {
		if (stringParts == null) {
			stringParts = new EObjectContainmentWithInverseEList<CompositeStringPart>(CompositeStringPart.class, this, TargetPlatformPackage.COMPOSITE_STRING__STRING_PARTS, TargetPlatformPackage.COMPOSITE_STRING_PART__COMPOSITE_STRING);
		}
		return stringParts;
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
			eNotify(new ENotificationImpl(this, Notification.SET, TargetPlatformPackage.COMPOSITE_STRING__VARIABLE_DEFINITION_CYCLE_DETECTED, oldVariableDefinitionCycleDetected, variableDefinitionCycleDetected));
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
			eNotify(new ENotificationImpl(this, Notification.SET, TargetPlatformPackage.COMPOSITE_STRING__VAR_DEF_CYCLE, oldVarDefCycle, varDefCycle));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String computeActualString() {
		final List<VarDefinition> alreadyCalledVariable = CollectionLiterals.<VarDefinition>newArrayList();
		return this.computeActualString(alreadyCalledVariable);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String computeActualString(final List<VarDefinition> alreadyCalledVariable) {
		this.setVariableDefinitionCycleDetected(false);
		String result = new String();
		EList<CompositeStringPart> _stringParts = this.getStringParts();
		for (final CompositeStringPart stringPart : _stringParts) {
			{
				final List<VarDefinition> newAlreadyCalledVariable = CollectionLiterals.<VarDefinition>newArrayList(((VarDefinition[])org.eclipse.xtext.xbase.lib.Conversions.unwrapArray(alreadyCalledVariable, VarDefinition.class)));
				String _result = result;
				String _actualString = stringPart.getActualString(newAlreadyCalledVariable);
				result = (_result + _actualString);
				boolean _isVariableDefinitionCycleDetected = stringPart.isVariableDefinitionCycleDetected();
				if (_isVariableDefinitionCycleDetected) {
					this.setVariableDefinitionCycleDetected(stringPart.isVariableDefinitionCycleDetected());
					this.setVarDefCycle(CollectionLiterals.<VarDefinition>newArrayList(((VarDefinition[])org.eclipse.xtext.xbase.lib.Conversions.unwrapArray(stringPart.getVarDefCycle(), VarDefinition.class))));
					return "";
				}
			}
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompositeString getCopy() {
		CompositeString output = TargetPlatformFactory.eINSTANCE.createCompositeString();
		final EList<CompositeStringPart> stringPartsCopy = output.getStringParts();
		final Consumer<CompositeStringPart> _function = new Consumer<CompositeStringPart>() {
			public void accept(final CompositeStringPart it) {
				stringPartsCopy.add(it.getCopy());
			}
		};
		this.getStringParts().forEach(_function);
		return output;
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
			case TargetPlatformPackage.COMPOSITE_STRING__STRING_PARTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getStringParts()).basicAdd(otherEnd, msgs);
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
			case TargetPlatformPackage.COMPOSITE_STRING__STRING_PARTS:
				return ((InternalEList<?>)getStringParts()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TargetPlatformPackage.COMPOSITE_STRING__NAME:
				return getName();
			case TargetPlatformPackage.COMPOSITE_STRING__STRING_PARTS:
				return getStringParts();
			case TargetPlatformPackage.COMPOSITE_STRING__VARIABLE_DEFINITION_CYCLE_DETECTED:
				return isVariableDefinitionCycleDetected();
			case TargetPlatformPackage.COMPOSITE_STRING__VAR_DEF_CYCLE:
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
			case TargetPlatformPackage.COMPOSITE_STRING__NAME:
				setName((String)newValue);
				return;
			case TargetPlatformPackage.COMPOSITE_STRING__STRING_PARTS:
				getStringParts().clear();
				getStringParts().addAll((Collection<? extends CompositeStringPart>)newValue);
				return;
			case TargetPlatformPackage.COMPOSITE_STRING__VARIABLE_DEFINITION_CYCLE_DETECTED:
				setVariableDefinitionCycleDetected((Boolean)newValue);
				return;
			case TargetPlatformPackage.COMPOSITE_STRING__VAR_DEF_CYCLE:
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
			case TargetPlatformPackage.COMPOSITE_STRING__NAME:
				setName(NAME_EDEFAULT);
				return;
			case TargetPlatformPackage.COMPOSITE_STRING__STRING_PARTS:
				getStringParts().clear();
				return;
			case TargetPlatformPackage.COMPOSITE_STRING__VARIABLE_DEFINITION_CYCLE_DETECTED:
				setVariableDefinitionCycleDetected(VARIABLE_DEFINITION_CYCLE_DETECTED_EDEFAULT);
				return;
			case TargetPlatformPackage.COMPOSITE_STRING__VAR_DEF_CYCLE:
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
			case TargetPlatformPackage.COMPOSITE_STRING__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case TargetPlatformPackage.COMPOSITE_STRING__STRING_PARTS:
				return stringParts != null && !stringParts.isEmpty();
			case TargetPlatformPackage.COMPOSITE_STRING__VARIABLE_DEFINITION_CYCLE_DETECTED:
				return variableDefinitionCycleDetected != VARIABLE_DEFINITION_CYCLE_DETECTED_EDEFAULT;
			case TargetPlatformPackage.COMPOSITE_STRING__VAR_DEF_CYCLE:
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
			case TargetPlatformPackage.COMPOSITE_STRING___COMPUTE_ACTUAL_STRING:
				return computeActualString();
			case TargetPlatformPackage.COMPOSITE_STRING___COMPUTE_ACTUAL_STRING__LIST:
				return computeActualString((List<VarDefinition>)arguments.get(0));
			case TargetPlatformPackage.COMPOSITE_STRING___GET_COPY:
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
		result.append(" (name: ");
		result.append(name);
		result.append(", variableDefinitionCycleDetected: ");
		result.append(variableDefinitionCycleDetected);
		result.append(", varDefCycle: ");
		result.append(varDefCycle);
		result.append(')');
		return result.toString();
	}

} //CompositeStringImpl
