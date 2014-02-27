/**
 */
package fr.obeo.releng.targetplatform.targetplatform.impl;

import fr.obeo.releng.targetplatform.targetplatform.IncludeDeclaration;
import fr.obeo.releng.targetplatform.targetplatform.Location;
import fr.obeo.releng.targetplatform.targetplatform.Option;
import fr.obeo.releng.targetplatform.targetplatform.TargetPlatform;
import fr.obeo.releng.targetplatform.targetplatform.TargetplatformFactory;
import fr.obeo.releng.targetplatform.targetplatform.TargetplatformPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TargetplatformPackageImpl extends EPackageImpl implements TargetplatformPackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass targetPlatformEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass includeDeclarationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass locationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass iuEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum optionEEnum = null;

  /**
   * Creates an instance of the model <b>Package</b>, registered with
   * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
   * package URI value.
   * <p>Note: the correct way to create the package is via the static
   * factory method {@link #init init()}, which also performs
   * initialization of the package, or returns the registered package,
   * if one already exists.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.ecore.EPackage.Registry
   * @see fr.obeo.releng.targetplatform.targetplatform.TargetplatformPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private TargetplatformPackageImpl()
  {
    super(eNS_URI, TargetplatformFactory.eINSTANCE);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static boolean isInited = false;

  /**
   * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
   * 
   * <p>This method is used to initialize {@link TargetplatformPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static TargetplatformPackage init()
  {
    if (isInited) return (TargetplatformPackage)EPackage.Registry.INSTANCE.getEPackage(TargetplatformPackage.eNS_URI);

    // Obtain or create and register package
    TargetplatformPackageImpl theTargetplatformPackage = (TargetplatformPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof TargetplatformPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new TargetplatformPackageImpl());

    isInited = true;

    // Create package meta-data objects
    theTargetplatformPackage.createPackageContents();

    // Initialize created meta-data
    theTargetplatformPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theTargetplatformPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(TargetplatformPackage.eNS_URI, theTargetplatformPackage);
    return theTargetplatformPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTargetPlatform()
  {
    return targetPlatformEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTargetPlatform_Name()
  {
    return (EAttribute)targetPlatformEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTargetPlatform_Includes()
  {
    return (EReference)targetPlatformEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTargetPlatform_Options()
  {
    return (EAttribute)targetPlatformEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTargetPlatform_Locations()
  {
    return (EReference)targetPlatformEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getIncludeDeclaration()
  {
    return includeDeclarationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getIncludeDeclaration_ImportURI()
  {
    return (EAttribute)includeDeclarationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getLocation()
  {
    return locationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getLocation_ID()
  {
    return (EAttribute)locationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getLocation_Uri()
  {
    return (EAttribute)locationEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getLocation_Options()
  {
    return (EAttribute)locationEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLocation_Ius()
  {
    return (EReference)locationEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getIU()
  {
    return iuEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getIU_ID()
  {
    return (EAttribute)iuEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getIU_Version()
  {
    return (EAttribute)iuEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getOption()
  {
    return optionEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TargetplatformFactory getTargetplatformFactory()
  {
    return (TargetplatformFactory)getEFactoryInstance();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isCreated = false;

  /**
   * Creates the meta-model objects for the package.  This method is
   * guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void createPackageContents()
  {
    if (isCreated) return;
    isCreated = true;

    // Create classes and their features
    targetPlatformEClass = createEClass(TARGET_PLATFORM);
    createEAttribute(targetPlatformEClass, TARGET_PLATFORM__NAME);
    createEReference(targetPlatformEClass, TARGET_PLATFORM__INCLUDES);
    createEAttribute(targetPlatformEClass, TARGET_PLATFORM__OPTIONS);
    createEReference(targetPlatformEClass, TARGET_PLATFORM__LOCATIONS);

    includeDeclarationEClass = createEClass(INCLUDE_DECLARATION);
    createEAttribute(includeDeclarationEClass, INCLUDE_DECLARATION__IMPORT_URI);

    locationEClass = createEClass(LOCATION);
    createEAttribute(locationEClass, LOCATION__ID);
    createEAttribute(locationEClass, LOCATION__URI);
    createEAttribute(locationEClass, LOCATION__OPTIONS);
    createEReference(locationEClass, LOCATION__IUS);

    iuEClass = createEClass(IU);
    createEAttribute(iuEClass, IU__ID);
    createEAttribute(iuEClass, IU__VERSION);

    // Create enums
    optionEEnum = createEEnum(OPTION);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isInitialized = false;

  /**
   * Complete the initialization of the package and its meta-model.  This
   * method is guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void initializePackageContents()
  {
    if (isInitialized) return;
    isInitialized = true;

    // Initialize package
    setName(eNAME);
    setNsPrefix(eNS_PREFIX);
    setNsURI(eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes

    // Initialize classes and features; add operations and parameters
    initEClass(targetPlatformEClass, TargetPlatform.class, "TargetPlatform", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getTargetPlatform_Name(), ecorePackage.getEString(), "name", null, 0, 1, TargetPlatform.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTargetPlatform_Includes(), this.getIncludeDeclaration(), null, "includes", null, 0, -1, TargetPlatform.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTargetPlatform_Options(), this.getOption(), "options", null, 0, -1, TargetPlatform.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTargetPlatform_Locations(), this.getLocation(), null, "locations", null, 0, -1, TargetPlatform.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(includeDeclarationEClass, IncludeDeclaration.class, "IncludeDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getIncludeDeclaration_ImportURI(), ecorePackage.getEString(), "importURI", null, 0, 1, IncludeDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(locationEClass, Location.class, "Location", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getLocation_ID(), ecorePackage.getEString(), "ID", null, 0, 1, Location.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getLocation_Uri(), ecorePackage.getEString(), "uri", null, 0, 1, Location.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getLocation_Options(), this.getOption(), "options", null, 0, -1, Location.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getLocation_Ius(), this.getIU(), null, "ius", null, 0, -1, Location.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(iuEClass, fr.obeo.releng.targetplatform.targetplatform.IU.class, "IU", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getIU_ID(), ecorePackage.getEString(), "ID", null, 0, 1, fr.obeo.releng.targetplatform.targetplatform.IU.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getIU_Version(), ecorePackage.getEString(), "version", null, 0, 1, fr.obeo.releng.targetplatform.targetplatform.IU.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Initialize enums and add enum literals
    initEEnum(optionEEnum, Option.class, "Option");
    addEEnumLiteral(optionEEnum, Option.INCLUDE_REQUIRED);
    addEEnumLiteral(optionEEnum, Option.INCLUDE_ALL_ENVIRONMENTS);
    addEEnumLiteral(optionEEnum, Option.INCLUDE_SOURCE);
    addEEnumLiteral(optionEEnum, Option.INCLUDE_CONFIGURE_PHASE);

    // Create resource
    createResource(eNS_URI);
  }

} //TargetplatformPackageImpl
