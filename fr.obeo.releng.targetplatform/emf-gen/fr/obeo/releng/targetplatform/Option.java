/**
 */
package fr.obeo.releng.targetplatform;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Option</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see fr.obeo.releng.targetplatform.TargetPlatformPackage#getOption()
 * @model
 * @generated
 */
public enum Option implements Enumerator
{
  /**
   * The '<em><b>INCLUDE REQUIRED</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #INCLUDE_REQUIRED_VALUE
   * @generated
   * @ordered
   */
  INCLUDE_REQUIRED(0, "INCLUDE_REQUIRED", "requirements"),

  /**
   * The '<em><b>INCLUDE ALL ENVIRONMENTS</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #INCLUDE_ALL_ENVIRONMENTS_VALUE
   * @generated
   * @ordered
   */
  INCLUDE_ALL_ENVIRONMENTS(1, "INCLUDE_ALL_ENVIRONMENTS", "allEnvironments"),

  /**
   * The '<em><b>INCLUDE SOURCE</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #INCLUDE_SOURCE_VALUE
   * @generated
   * @ordered
   */
  INCLUDE_SOURCE(2, "INCLUDE_SOURCE", "source"),

  /**
   * The '<em><b>INCLUDE CONFIGURE PHASE</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #INCLUDE_CONFIGURE_PHASE_VALUE
   * @generated
   * @ordered
   */
  INCLUDE_CONFIGURE_PHASE(3, "INCLUDE_CONFIGURE_PHASE", "configurePhase");

  /**
   * The '<em><b>INCLUDE REQUIRED</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>INCLUDE REQUIRED</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #INCLUDE_REQUIRED
   * @model literal="requirements"
   * @generated
   * @ordered
   */
  public static final int INCLUDE_REQUIRED_VALUE = 0;

  /**
   * The '<em><b>INCLUDE ALL ENVIRONMENTS</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>INCLUDE ALL ENVIRONMENTS</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #INCLUDE_ALL_ENVIRONMENTS
   * @model literal="allEnvironments"
   * @generated
   * @ordered
   */
  public static final int INCLUDE_ALL_ENVIRONMENTS_VALUE = 1;

  /**
   * The '<em><b>INCLUDE SOURCE</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>INCLUDE SOURCE</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #INCLUDE_SOURCE
   * @model literal="source"
   * @generated
   * @ordered
   */
  public static final int INCLUDE_SOURCE_VALUE = 2;

  /**
   * The '<em><b>INCLUDE CONFIGURE PHASE</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>INCLUDE CONFIGURE PHASE</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #INCLUDE_CONFIGURE_PHASE
   * @model literal="configurePhase"
   * @generated
   * @ordered
   */
  public static final int INCLUDE_CONFIGURE_PHASE_VALUE = 3;

  /**
   * An array of all the '<em><b>Option</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static final Option[] VALUES_ARRAY =
    new Option[]
    {
      INCLUDE_REQUIRED,
      INCLUDE_ALL_ENVIRONMENTS,
      INCLUDE_SOURCE,
      INCLUDE_CONFIGURE_PHASE,
    };

  /**
   * A public read-only list of all the '<em><b>Option</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final List<Option> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
   * Returns the '<em><b>Option</b></em>' literal with the specified literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static Option get(String literal)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      Option result = VALUES_ARRAY[i];
      if (result.toString().equals(literal))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Option</b></em>' literal with the specified name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static Option getByName(String name)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      Option result = VALUES_ARRAY[i];
      if (result.getName().equals(name))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Option</b></em>' literal with the specified integer value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static Option get(int value)
  {
    switch (value)
    {
      case INCLUDE_REQUIRED_VALUE: return INCLUDE_REQUIRED;
      case INCLUDE_ALL_ENVIRONMENTS_VALUE: return INCLUDE_ALL_ENVIRONMENTS;
      case INCLUDE_SOURCE_VALUE: return INCLUDE_SOURCE;
      case INCLUDE_CONFIGURE_PHASE_VALUE: return INCLUDE_CONFIGURE_PHASE;
    }
    return null;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private final int value;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private final String name;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private final String literal;

  /**
   * Only this class can construct instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private Option(int value, String name, String literal)
  {
    this.value = value;
    this.name = name;
    this.literal = literal;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getValue()
  {
    return value;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getLiteral()
  {
    return literal;
  }

  /**
   * Returns the literal value of the enumerator, which is its string representation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    return literal;
  }
  
} //Option
