/**
 */
package org.eclipse.cbi.targetplatform.impl;

import com.google.common.collect.Iterables;

import org.eclipse.cbi.targetplatform.Environment;
import org.eclipse.cbi.targetplatform.IncludeDeclaration;
import org.eclipse.cbi.targetplatform.Location;
import org.eclipse.cbi.targetplatform.Option;
import org.eclipse.cbi.targetplatform.Options;
import org.eclipse.cbi.targetplatform.TargetContent;
import org.eclipse.cbi.targetplatform.TargetPlatform;
import org.eclipse.cbi.targetplatform.TargetPlatformPackage;

import java.lang.Iterable;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.DelegatingEList.UnmodifiableEList;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.xtext.xbase.lib.Functions.Function1;

import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Target Platform</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.cbi.targetplatform.impl.TargetPlatformImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.cbi.targetplatform.impl.TargetPlatformImpl#getContents <em>Contents</em>}</li>
 *   <li>{@link org.eclipse.cbi.targetplatform.impl.TargetPlatformImpl#getIncludes <em>Includes</em>}</li>
 *   <li>{@link org.eclipse.cbi.targetplatform.impl.TargetPlatformImpl#getOptions <em>Options</em>}</li>
 *   <li>{@link org.eclipse.cbi.targetplatform.impl.TargetPlatformImpl#getLocations <em>Locations</em>}</li>
 *   <li>{@link org.eclipse.cbi.targetplatform.impl.TargetPlatformImpl#getEnvironment <em>Environment</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TargetPlatformImpl extends MinimalEObjectImpl.Container implements TargetPlatform {
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
	 * The cached value of the '{@link #getContents() <em>Contents</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContents()
	 * @generated
	 * @ordered
	 */
	protected EList<TargetContent> contents;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TargetPlatformImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TargetPlatformPackage.Literals.TARGET_PLATFORM;
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
			eNotify(new ENotificationImpl(this, Notification.SET, TargetPlatformPackage.TARGET_PLATFORM__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TargetContent> getContents() {
		if (contents == null) {
			contents = new EObjectContainmentWithInverseEList<TargetContent>(TargetContent.class, this, TargetPlatformPackage.TARGET_PLATFORM__CONTENTS, TargetPlatformPackage.TARGET_CONTENT__TARGET_PLATFORM);
		}
		return contents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IncludeDeclaration> getIncludes() {
		EList<TargetContent> _contents = this.getContents();
		Iterable<IncludeDeclaration> _filter = Iterables.<IncludeDeclaration>filter(_contents, IncludeDeclaration.class);
		List<IncludeDeclaration> _list = IterableExtensions.<IncludeDeclaration>toList(_filter);
		return new UnmodifiableEList<IncludeDeclaration>(_list);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Option> getOptions() {
		EList<TargetContent> _contents = this.getContents();
		Iterable<Options> _filter = Iterables.<Options>filter(_contents, Options.class);
		final Function1<Options, EList<Option>> _function = new Function1<Options, EList<Option>>() {
			public EList<Option> apply(final Options it) {
				return it.getOptions();
			}
		};
		Iterable<EList<Option>> _map = IterableExtensions.<Options, EList<Option>>map(_filter, _function);
		Iterable<Option> _flatten = Iterables.<Option>concat(_map);
		List<Option> _list = IterableExtensions.<Option>toList(_flatten);
		return new UnmodifiableEList<Option>(_list);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Location> getLocations() {
		EList<TargetContent> _contents = this.getContents();
		Iterable<Location> _filter = Iterables.<Location>filter(_contents, Location.class);
		List<Location> _list = IterableExtensions.<Location>toList(_filter);
		return new UnmodifiableEList<Location>(_list);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Environment getEnvironment() {
		Environment environment = basicGetEnvironment();
		return environment != null && environment.eIsProxy() ? (Environment)eResolveProxy((InternalEObject)environment) : environment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Environment basicGetEnvironment() {
		EList<TargetContent> _contents = this.getContents();
		Iterable<Environment> _filter = Iterables.<Environment>filter(_contents, Environment.class);
		return IterableExtensions.<Environment>head(_filter);
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
			case TargetPlatformPackage.TARGET_PLATFORM__CONTENTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getContents()).basicAdd(otherEnd, msgs);
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
			case TargetPlatformPackage.TARGET_PLATFORM__CONTENTS:
				return ((InternalEList<?>)getContents()).basicRemove(otherEnd, msgs);
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
			case TargetPlatformPackage.TARGET_PLATFORM__NAME:
				return getName();
			case TargetPlatformPackage.TARGET_PLATFORM__CONTENTS:
				return getContents();
			case TargetPlatformPackage.TARGET_PLATFORM__INCLUDES:
				return getIncludes();
			case TargetPlatformPackage.TARGET_PLATFORM__OPTIONS:
				return getOptions();
			case TargetPlatformPackage.TARGET_PLATFORM__LOCATIONS:
				return getLocations();
			case TargetPlatformPackage.TARGET_PLATFORM__ENVIRONMENT:
				if (resolve) return getEnvironment();
				return basicGetEnvironment();
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
			case TargetPlatformPackage.TARGET_PLATFORM__NAME:
				setName((String)newValue);
				return;
			case TargetPlatformPackage.TARGET_PLATFORM__CONTENTS:
				getContents().clear();
				getContents().addAll((Collection<? extends TargetContent>)newValue);
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
			case TargetPlatformPackage.TARGET_PLATFORM__NAME:
				setName(NAME_EDEFAULT);
				return;
			case TargetPlatformPackage.TARGET_PLATFORM__CONTENTS:
				getContents().clear();
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
			case TargetPlatformPackage.TARGET_PLATFORM__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case TargetPlatformPackage.TARGET_PLATFORM__CONTENTS:
				return contents != null && !contents.isEmpty();
			case TargetPlatformPackage.TARGET_PLATFORM__INCLUDES:
				return !getIncludes().isEmpty();
			case TargetPlatformPackage.TARGET_PLATFORM__OPTIONS:
				return !getOptions().isEmpty();
			case TargetPlatformPackage.TARGET_PLATFORM__LOCATIONS:
				return !getLocations().isEmpty();
			case TargetPlatformPackage.TARGET_PLATFORM__ENVIRONMENT:
				return basicGetEnvironment() != null;
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
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //TargetPlatformImpl
