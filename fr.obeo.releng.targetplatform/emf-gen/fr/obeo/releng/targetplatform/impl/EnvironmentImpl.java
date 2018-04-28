/**
 */
package fr.obeo.releng.targetplatform.impl;

import com.google.common.base.Splitter;

import com.google.common.collect.Iterables;

import fr.obeo.releng.targetplatform.Environment;
import fr.obeo.releng.targetplatform.TargetPlatform;
import fr.obeo.releng.targetplatform.TargetPlatformPackage;

import java.lang.Iterable;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import org.eclipse.core.runtime.Platform;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.util.EcoreUtil;

import org.eclipse.jdt.launching.JavaRuntime;

import org.eclipse.jdt.launching.environments.IExecutionEnvironment;
import org.eclipse.jdt.launching.environments.IExecutionEnvironmentsManager;

import org.eclipse.xtext.xbase.lib.Functions.Function1;

import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Environment</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link fr.obeo.releng.targetplatform.impl.EnvironmentImpl#getTargetPlatform <em>Target Platform</em>}</li>
 *   <li>{@link fr.obeo.releng.targetplatform.impl.EnvironmentImpl#getEnv <em>Env</em>}</li>
 *   <li>{@link fr.obeo.releng.targetplatform.impl.EnvironmentImpl#getOperatingSystem <em>Operating System</em>}</li>
 *   <li>{@link fr.obeo.releng.targetplatform.impl.EnvironmentImpl#getWindowingSystem <em>Windowing System</em>}</li>
 *   <li>{@link fr.obeo.releng.targetplatform.impl.EnvironmentImpl#getArchitecture <em>Architecture</em>}</li>
 *   <li>{@link fr.obeo.releng.targetplatform.impl.EnvironmentImpl#getLocalization <em>Localization</em>}</li>
 *   <li>{@link fr.obeo.releng.targetplatform.impl.EnvironmentImpl#getExecutionEnvironment <em>Execution Environment</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EnvironmentImpl extends MinimalEObjectImpl.Container implements Environment {
	/**
	 * The cached value of the '{@link #getEnv() <em>Env</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnv()
	 * @generated
	 * @ordered
	 */
	protected EList<String> env;

	/**
	 * The default value of the '{@link #getOperatingSystem() <em>Operating System</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperatingSystem()
	 * @generated
	 * @ordered
	 */
	protected static final String OPERATING_SYSTEM_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getWindowingSystem() <em>Windowing System</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWindowingSystem()
	 * @generated
	 * @ordered
	 */
	protected static final String WINDOWING_SYSTEM_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getArchitecture() <em>Architecture</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArchitecture()
	 * @generated
	 * @ordered
	 */
	protected static final String ARCHITECTURE_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getLocalization() <em>Localization</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocalization()
	 * @generated
	 * @ordered
	 */
	protected static final Locale LOCALIZATION_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getExecutionEnvironment() <em>Execution Environment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExecutionEnvironment()
	 * @generated
	 * @ordered
	 */
	protected static final IExecutionEnvironment EXECUTION_ENVIRONMENT_EDEFAULT = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EnvironmentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TargetPlatformPackage.Literals.ENVIRONMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TargetPlatform getTargetPlatform() {
		if (eContainerFeatureID() != TargetPlatformPackage.ENVIRONMENT__TARGET_PLATFORM) return null;
		return (TargetPlatform)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TargetPlatform basicGetTargetPlatform() {
		if (eContainerFeatureID() != TargetPlatformPackage.ENVIRONMENT__TARGET_PLATFORM) return null;
		return (TargetPlatform)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTargetPlatform(TargetPlatform newTargetPlatform, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newTargetPlatform, TargetPlatformPackage.ENVIRONMENT__TARGET_PLATFORM, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetPlatform(TargetPlatform newTargetPlatform) {
		if (newTargetPlatform != eInternalContainer() || (eContainerFeatureID() != TargetPlatformPackage.ENVIRONMENT__TARGET_PLATFORM && newTargetPlatform != null)) {
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
			eNotify(new ENotificationImpl(this, Notification.SET, TargetPlatformPackage.ENVIRONMENT__TARGET_PLATFORM, newTargetPlatform, newTargetPlatform));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getEnv() {
		if (env == null) {
			env = new EDataTypeEList<String>(String.class, this, TargetPlatformPackage.ENVIRONMENT__ENV);
		}
		return env;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOperatingSystem() {
		final Function1<Environment, EList<String>> _function = new Function1<Environment, EList<String>>() {
			public EList<String> apply(final Environment it) {
				return it.getEnv();
			}
		};
		final Function1<String, Boolean> _function_1 = new Function1<String, Boolean>() {
			public Boolean apply(final String it) {
				boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(it);
				return Boolean.valueOf((!_isNullOrEmpty));
			}
		};
		final Function1<String, String> _function_2 = new Function1<String, String>() {
			public String apply(final String it) {
				return it.toUpperCase();
			}
		};
		final List<String> envToUpper = IterableExtensions.<String>toList(IterableExtensions.<String, String>map(IterableExtensions.<String>filter(Iterables.<String>concat(IterableExtensions.<Environment, EList<String>>map(Iterables.<Environment>filter(this.getTargetPlatform().getContents(), Environment.class), _function)), _function_1), _function_2));
		final Function1<String, Boolean> _function_3 = new Function1<String, Boolean>() {
			public Boolean apply(final String it) {
				return Boolean.valueOf(envToUpper.contains(it.toUpperCase()));
			}
		};
		return IterableExtensions.<String>findFirst(((Iterable<String>)org.eclipse.xtext.xbase.lib.Conversions.doWrapArray(Platform.knownOSValues())), _function_3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getWindowingSystem() {
		final Function1<Environment, EList<String>> _function = new Function1<Environment, EList<String>>() {
			public EList<String> apply(final Environment it) {
				return it.getEnv();
			}
		};
		final Function1<String, Boolean> _function_1 = new Function1<String, Boolean>() {
			public Boolean apply(final String it) {
				boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(it);
				return Boolean.valueOf((!_isNullOrEmpty));
			}
		};
		final Function1<String, String> _function_2 = new Function1<String, String>() {
			public String apply(final String it) {
				return it.toUpperCase();
			}
		};
		final List<String> envToUpper = IterableExtensions.<String>toList(IterableExtensions.<String, String>map(IterableExtensions.<String>filter(Iterables.<String>concat(IterableExtensions.<Environment, EList<String>>map(Iterables.<Environment>filter(this.getTargetPlatform().getContents(), Environment.class), _function)), _function_1), _function_2));
		final Function1<String, String> _function_3 = new Function1<String, String>() {
			public String apply(final String it) {
				return it.toUpperCase();
			}
		};
		final List<String> knownWSUpperValues = ListExtensions.<String, String>map(((List<String>)org.eclipse.xtext.xbase.lib.Conversions.doWrapArray(Platform.knownWSValues())), _function_3);
		final Function1<String, Boolean> _function_4 = new Function1<String, Boolean>() {
			public Boolean apply(final String it) {
				return Boolean.valueOf(knownWSUpperValues.contains(it));
			}
		};
		final List<String> allWS = IterableExtensions.<String>toList(IterableExtensions.<String>filter(envToUpper, _function_4));
		boolean _and = false;
		int _size = allWS.size();
		boolean _lessEqualsThan = (_size <= 1);
		if (!_lessEqualsThan) {
			_and = false;
		} else {
			String _operatingSystem = this.getOperatingSystem();
			String _upperCase = null;
			if (_operatingSystem!=null) {
				_upperCase=_operatingSystem.toUpperCase();
			}
			boolean _contains = allWS.contains(_upperCase);
			_and = _contains;
		}
		if (_and) {
			return null;
		}
		else {
			final Function1<String, Boolean> _function_5 = new Function1<String, Boolean>() {
				public Boolean apply(final String it) {
					return Boolean.valueOf(envToUpper.contains(it.toUpperCase()));
				}
			};
			return IterableExtensions.<String>findFirst(((Iterable<String>)org.eclipse.xtext.xbase.lib.Conversions.doWrapArray(Platform.knownWSValues())), _function_5);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getArchitecture() {
		final Function1<Environment, EList<String>> _function = new Function1<Environment, EList<String>>() {
			public EList<String> apply(final Environment it) {
				return it.getEnv();
			}
		};
		final Function1<String, Boolean> _function_1 = new Function1<String, Boolean>() {
			public Boolean apply(final String it) {
				boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(it);
				return Boolean.valueOf((!_isNullOrEmpty));
			}
		};
		final Function1<String, String> _function_2 = new Function1<String, String>() {
			public String apply(final String it) {
				return it.toUpperCase();
			}
		};
		final List<String> envToUpper = IterableExtensions.<String>toList(IterableExtensions.<String, String>map(IterableExtensions.<String>filter(Iterables.<String>concat(IterableExtensions.<Environment, EList<String>>map(Iterables.<Environment>filter(this.getTargetPlatform().getContents(), Environment.class), _function)), _function_1), _function_2));
		final Function1<String, Boolean> _function_3 = new Function1<String, Boolean>() {
			public Boolean apply(final String it) {
				return Boolean.valueOf(envToUpper.contains(it.toUpperCase()));
			}
		};
		return IterableExtensions.<String>findFirst(((Iterable<String>)org.eclipse.xtext.xbase.lib.Conversions.doWrapArray(Platform.knownOSArchValues())), _function_3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Locale getLocalization() {
		final Function1<Environment, EList<String>> _function = new Function1<Environment, EList<String>>() {
			public EList<String> apply(final Environment it) {
				return it.getEnv();
			}
		};
		final Function1<String, Boolean> _function_1 = new Function1<String, Boolean>() {
			public Boolean apply(final String it) {
				boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(it);
				return Boolean.valueOf((!_isNullOrEmpty));
			}
		};
		final Function1<String, String> _function_2 = new Function1<String, String>() {
			public String apply(final String it) {
				return it.toUpperCase();
			}
		};
		final List<String> envToUpper = IterableExtensions.<String>toList(IterableExtensions.<String, String>map(IterableExtensions.<String>filter(Iterables.<String>concat(IterableExtensions.<Environment, EList<String>>map(Iterables.<Environment>filter(this.getTargetPlatform().getContents(), Environment.class), _function)), _function_1), _function_2));
		final Function1<Locale, String> _function_3 = new Function1<Locale, String>() {
			public String apply(final Locale it) {
				return it.toString();
			}
		};
		final Function1<String, Boolean> _function_4 = new Function1<String, Boolean>() {
			public Boolean apply(final String it) {
				return Boolean.valueOf(envToUpper.contains(it.toUpperCase()));
			}
		};
		final String locale = IterableExtensions.<String>findFirst(ListExtensions.<Locale, String>map(((List<Locale>)org.eclipse.xtext.xbase.lib.Conversions.doWrapArray(Locale.getAvailableLocales())), _function_3), _function_4);
		boolean _tripleNotEquals = (locale != null);
		if (_tripleNotEquals) {
			String language = "";
			String country = "";
			String variant = "";
			final Iterator<String> tokens = Splitter.on("_").trimResults().split(locale).iterator();
			boolean _hasNext = tokens.hasNext();
			if (_hasNext) {
				language = tokens.next();
			}
			boolean _hasNext_1 = tokens.hasNext();
			if (_hasNext_1) {
				country = tokens.next();
			}
			boolean _hasNext_2 = tokens.hasNext();
			if (_hasNext_2) {
				variant = tokens.next();
			}
			return new Locale(language, country, variant);
		}
		else {
			return null;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IExecutionEnvironment getExecutionEnvironment() {
		final IExecutionEnvironmentsManager eeManager = JavaRuntime.getExecutionEnvironmentsManager();
		boolean _tripleNotEquals = (eeManager != null);
		if (_tripleNotEquals) {
			final Function1<Environment, EList<String>> _function = new Function1<Environment, EList<String>>() {
				public EList<String> apply(final Environment it) {
					return it.getEnv();
				}
			};
			final Function1<String, Boolean> _function_1 = new Function1<String, Boolean>() {
				public Boolean apply(final String it) {
					boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(it);
					return Boolean.valueOf((!_isNullOrEmpty));
				}
			};
			final Function1<String, String> _function_2 = new Function1<String, String>() {
				public String apply(final String it) {
					return it.toUpperCase();
				}
			};
			final List<String> envToUpper = IterableExtensions.<String>toList(IterableExtensions.<String, String>map(IterableExtensions.<String>filter(Iterables.<String>concat(IterableExtensions.<Environment, EList<String>>map(Iterables.<Environment>filter(this.getTargetPlatform().getContents(), Environment.class), _function)), _function_1), _function_2));
			for (final String env : envToUpper) {
				{
					final Function1<IExecutionEnvironment, Boolean> _function_3 = new Function1<IExecutionEnvironment, Boolean>() {
						public Boolean apply(final IExecutionEnvironment it) {
							return Boolean.valueOf(it.getId().toUpperCase().equals(env));
						}
					};
					final IExecutionEnvironment ee = IterableExtensions.<IExecutionEnvironment>findFirst(((Iterable<IExecutionEnvironment>)org.eclipse.xtext.xbase.lib.Conversions.doWrapArray(eeManager.getExecutionEnvironments())), _function_3);
					boolean _tripleNotEquals_1 = (ee != null);
					if (_tripleNotEquals_1) {
						return ee;
					}
				}
			}
			return null;
		}
		else {
			return null;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TargetPlatformPackage.ENVIRONMENT__TARGET_PLATFORM:
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
			case TargetPlatformPackage.ENVIRONMENT__TARGET_PLATFORM:
				return basicSetTargetPlatform(null, msgs);
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
			case TargetPlatformPackage.ENVIRONMENT__TARGET_PLATFORM:
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
			case TargetPlatformPackage.ENVIRONMENT__TARGET_PLATFORM:
				if (resolve) return getTargetPlatform();
				return basicGetTargetPlatform();
			case TargetPlatformPackage.ENVIRONMENT__ENV:
				return getEnv();
			case TargetPlatformPackage.ENVIRONMENT__OPERATING_SYSTEM:
				return getOperatingSystem();
			case TargetPlatformPackage.ENVIRONMENT__WINDOWING_SYSTEM:
				return getWindowingSystem();
			case TargetPlatformPackage.ENVIRONMENT__ARCHITECTURE:
				return getArchitecture();
			case TargetPlatformPackage.ENVIRONMENT__LOCALIZATION:
				return getLocalization();
			case TargetPlatformPackage.ENVIRONMENT__EXECUTION_ENVIRONMENT:
				return getExecutionEnvironment();
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
			case TargetPlatformPackage.ENVIRONMENT__TARGET_PLATFORM:
				setTargetPlatform((TargetPlatform)newValue);
				return;
			case TargetPlatformPackage.ENVIRONMENT__ENV:
				getEnv().clear();
				getEnv().addAll((Collection<? extends String>)newValue);
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
			case TargetPlatformPackage.ENVIRONMENT__TARGET_PLATFORM:
				setTargetPlatform((TargetPlatform)null);
				return;
			case TargetPlatformPackage.ENVIRONMENT__ENV:
				getEnv().clear();
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
			case TargetPlatformPackage.ENVIRONMENT__TARGET_PLATFORM:
				return basicGetTargetPlatform() != null;
			case TargetPlatformPackage.ENVIRONMENT__ENV:
				return env != null && !env.isEmpty();
			case TargetPlatformPackage.ENVIRONMENT__OPERATING_SYSTEM:
				return OPERATING_SYSTEM_EDEFAULT == null ? getOperatingSystem() != null : !OPERATING_SYSTEM_EDEFAULT.equals(getOperatingSystem());
			case TargetPlatformPackage.ENVIRONMENT__WINDOWING_SYSTEM:
				return WINDOWING_SYSTEM_EDEFAULT == null ? getWindowingSystem() != null : !WINDOWING_SYSTEM_EDEFAULT.equals(getWindowingSystem());
			case TargetPlatformPackage.ENVIRONMENT__ARCHITECTURE:
				return ARCHITECTURE_EDEFAULT == null ? getArchitecture() != null : !ARCHITECTURE_EDEFAULT.equals(getArchitecture());
			case TargetPlatformPackage.ENVIRONMENT__LOCALIZATION:
				return LOCALIZATION_EDEFAULT == null ? getLocalization() != null : !LOCALIZATION_EDEFAULT.equals(getLocalization());
			case TargetPlatformPackage.ENVIRONMENT__EXECUTION_ENVIRONMENT:
				return EXECUTION_ENVIRONMENT_EDEFAULT == null ? getExecutionEnvironment() != null : !EXECUTION_ENVIRONMENT_EDEFAULT.equals(getExecutionEnvironment());
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
		result.append(" (env: ");
		result.append(env);
		result.append(')');
		return result.toString();
	}

} //EnvironmentImpl
