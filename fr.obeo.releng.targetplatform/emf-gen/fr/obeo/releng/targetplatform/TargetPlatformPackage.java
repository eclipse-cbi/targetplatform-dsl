/**
 */
package fr.obeo.releng.targetplatform;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see fr.obeo.releng.targetplatform.TargetPlatformFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/GenModel prefix='TargetPlatform' modelName='TargetPlatform' basePackage='fr.obeo.releng'"
 * @generated
 */
public interface TargetPlatformPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "targetplatform";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "fr.obeo.releng.targetplatform";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "targetplatform";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TargetPlatformPackage eINSTANCE = fr.obeo.releng.targetplatform.impl.TargetPlatformPackageImpl.init();

	/**
	 * The meta object id for the '{@link fr.obeo.releng.targetplatform.impl.TargetPlatformImpl <em>Target Platform</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.obeo.releng.targetplatform.impl.TargetPlatformImpl
	 * @see fr.obeo.releng.targetplatform.impl.TargetPlatformPackageImpl#getTargetPlatform()
	 * @generated
	 */
	int TARGET_PLATFORM = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_PLATFORM__NAME = 0;

	/**
	 * The feature id for the '<em><b>Contents</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_PLATFORM__CONTENTS = 1;

	/**
	 * The feature id for the '<em><b>Includes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_PLATFORM__INCLUDES = 2;

	/**
	 * The feature id for the '<em><b>Options</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_PLATFORM__OPTIONS = 3;

	/**
	 * The feature id for the '<em><b>Locations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_PLATFORM__LOCATIONS = 4;

	/**
	 * The feature id for the '<em><b>Environment</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_PLATFORM__ENVIRONMENT = 5;

	/**
	 * The number of structural features of the '<em>Target Platform</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_PLATFORM_FEATURE_COUNT = 6;

	/**
	 * The number of operations of the '<em>Target Platform</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_PLATFORM_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link fr.obeo.releng.targetplatform.TargetContent <em>Target Content</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.obeo.releng.targetplatform.TargetContent
	 * @see fr.obeo.releng.targetplatform.impl.TargetPlatformPackageImpl#getTargetContent()
	 * @generated
	 */
	int TARGET_CONTENT = 1;

	/**
	 * The feature id for the '<em><b>Target Platform</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_CONTENT__TARGET_PLATFORM = 0;

	/**
	 * The number of structural features of the '<em>Target Content</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_CONTENT_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Target Content</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_CONTENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link fr.obeo.releng.targetplatform.impl.OptionsImpl <em>Options</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.obeo.releng.targetplatform.impl.OptionsImpl
	 * @see fr.obeo.releng.targetplatform.impl.TargetPlatformPackageImpl#getOptions()
	 * @generated
	 */
	int OPTIONS = 2;

	/**
	 * The feature id for the '<em><b>Target Platform</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTIONS__TARGET_PLATFORM = TARGET_CONTENT__TARGET_PLATFORM;

	/**
	 * The feature id for the '<em><b>Options</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTIONS__OPTIONS = TARGET_CONTENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Options</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTIONS_FEATURE_COUNT = TARGET_CONTENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Options</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTIONS_OPERATION_COUNT = TARGET_CONTENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link fr.obeo.releng.targetplatform.impl.EnvironmentImpl <em>Environment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.obeo.releng.targetplatform.impl.EnvironmentImpl
	 * @see fr.obeo.releng.targetplatform.impl.TargetPlatformPackageImpl#getEnvironment()
	 * @generated
	 */
	int ENVIRONMENT = 3;

	/**
	 * The feature id for the '<em><b>Target Platform</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENVIRONMENT__TARGET_PLATFORM = TARGET_CONTENT__TARGET_PLATFORM;

	/**
	 * The feature id for the '<em><b>Env</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENVIRONMENT__ENV = TARGET_CONTENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Operating System</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENVIRONMENT__OPERATING_SYSTEM = TARGET_CONTENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Windowing System</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENVIRONMENT__WINDOWING_SYSTEM = TARGET_CONTENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Architecture</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENVIRONMENT__ARCHITECTURE = TARGET_CONTENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Localization</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENVIRONMENT__LOCALIZATION = TARGET_CONTENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Execution Environment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENVIRONMENT__EXECUTION_ENVIRONMENT = TARGET_CONTENT_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Environment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENVIRONMENT_FEATURE_COUNT = TARGET_CONTENT_FEATURE_COUNT + 6;

	/**
	 * The number of operations of the '<em>Environment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENVIRONMENT_OPERATION_COUNT = TARGET_CONTENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link fr.obeo.releng.targetplatform.impl.VarDefinitionImpl <em>Var Definition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.obeo.releng.targetplatform.impl.VarDefinitionImpl
	 * @see fr.obeo.releng.targetplatform.impl.TargetPlatformPackageImpl#getVarDefinition()
	 * @generated
	 */
	int VAR_DEFINITION = 4;

	/**
	 * The feature id for the '<em><b>Target Platform</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VAR_DEFINITION__TARGET_PLATFORM = TARGET_CONTENT__TARGET_PLATFORM;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VAR_DEFINITION__NAME = TARGET_CONTENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VAR_DEFINITION__VALUE = TARGET_CONTENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Var Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VAR_DEFINITION_FEATURE_COUNT = TARGET_CONTENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Var Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VAR_DEFINITION_OPERATION_COUNT = TARGET_CONTENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link fr.obeo.releng.targetplatform.impl.CompositeStringImpl <em>Composite String</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.obeo.releng.targetplatform.impl.CompositeStringImpl
	 * @see fr.obeo.releng.targetplatform.impl.TargetPlatformPackageImpl#getCompositeString()
	 * @generated
	 */
	int COMPOSITE_STRING = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_STRING__NAME = 0;

	/**
	 * The feature id for the '<em><b>String Parts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_STRING__STRING_PARTS = 1;

	/**
	 * The number of structural features of the '<em>Composite String</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_STRING_FEATURE_COUNT = 2;

	/**
	 * The operation id for the '<em>Compute Actual String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_STRING___COMPUTE_ACTUAL_STRING = 0;

	/**
	 * The number of operations of the '<em>Composite String</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_STRING_OPERATION_COUNT = 1;

	/**
	 * The meta object id for the '{@link fr.obeo.releng.targetplatform.CompositeStringPart <em>Composite String Part</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.obeo.releng.targetplatform.CompositeStringPart
	 * @see fr.obeo.releng.targetplatform.impl.TargetPlatformPackageImpl#getCompositeStringPart()
	 * @generated
	 */
	int COMPOSITE_STRING_PART = 6;

	/**
	 * The feature id for the '<em><b>Composite String</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_STRING_PART__COMPOSITE_STRING = 0;

	/**
	 * The number of structural features of the '<em>Composite String Part</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_STRING_PART_FEATURE_COUNT = 1;

	/**
	 * The operation id for the '<em>Get Actual String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_STRING_PART___GET_ACTUAL_STRING = 0;

	/**
	 * The number of operations of the '<em>Composite String Part</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_STRING_PART_OPERATION_COUNT = 1;

	/**
	 * The meta object id for the '{@link fr.obeo.releng.targetplatform.impl.VarCallImpl <em>Var Call</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.obeo.releng.targetplatform.impl.VarCallImpl
	 * @see fr.obeo.releng.targetplatform.impl.TargetPlatformPackageImpl#getVarCall()
	 * @generated
	 */
	int VAR_CALL = 7;

	/**
	 * The feature id for the '<em><b>Composite String</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VAR_CALL__COMPOSITE_STRING = COMPOSITE_STRING_PART__COMPOSITE_STRING;

	/**
	 * The feature id for the '<em><b>Var Name</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VAR_CALL__VAR_NAME = COMPOSITE_STRING_PART_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Var Call</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VAR_CALL_FEATURE_COUNT = COMPOSITE_STRING_PART_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Actual String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VAR_CALL___GET_ACTUAL_STRING = COMPOSITE_STRING_PART_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Var Call</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VAR_CALL_OPERATION_COUNT = COMPOSITE_STRING_PART_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link fr.obeo.releng.targetplatform.impl.StaticStringImpl <em>Static String</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.obeo.releng.targetplatform.impl.StaticStringImpl
	 * @see fr.obeo.releng.targetplatform.impl.TargetPlatformPackageImpl#getStaticString()
	 * @generated
	 */
	int STATIC_STRING = 8;

	/**
	 * The feature id for the '<em><b>Composite String</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIC_STRING__COMPOSITE_STRING = COMPOSITE_STRING_PART__COMPOSITE_STRING;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIC_STRING__VALUE = COMPOSITE_STRING_PART_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Static String</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIC_STRING_FEATURE_COUNT = COMPOSITE_STRING_PART_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Actual String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIC_STRING___GET_ACTUAL_STRING = COMPOSITE_STRING_PART_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Static String</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIC_STRING_OPERATION_COUNT = COMPOSITE_STRING_PART_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link fr.obeo.releng.targetplatform.impl.LocationImpl <em>Location</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.obeo.releng.targetplatform.impl.LocationImpl
	 * @see fr.obeo.releng.targetplatform.impl.TargetPlatformPackageImpl#getLocation()
	 * @generated
	 */
	int LOCATION = 9;

	/**
	 * The feature id for the '<em><b>Target Platform</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCATION__TARGET_PLATFORM = TARGET_CONTENT__TARGET_PLATFORM;

	/**
	 * The feature id for the '<em><b>ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCATION__ID = TARGET_CONTENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCATION__URI = TARGET_CONTENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Options</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCATION__OPTIONS = TARGET_CONTENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Ius</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCATION__IUS = TARGET_CONTENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Location</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCATION_FEATURE_COUNT = TARGET_CONTENT_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Location</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCATION_OPERATION_COUNT = TARGET_CONTENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link fr.obeo.releng.targetplatform.impl.IncludeDeclarationImpl <em>Include Declaration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.obeo.releng.targetplatform.impl.IncludeDeclarationImpl
	 * @see fr.obeo.releng.targetplatform.impl.TargetPlatformPackageImpl#getIncludeDeclaration()
	 * @generated
	 */
	int INCLUDE_DECLARATION = 10;

	/**
	 * The feature id for the '<em><b>Target Platform</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCLUDE_DECLARATION__TARGET_PLATFORM = TARGET_CONTENT__TARGET_PLATFORM;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCLUDE_DECLARATION__NAME = TARGET_CONTENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Composite Import URI</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCLUDE_DECLARATION__COMPOSITE_IMPORT_URI = TARGET_CONTENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Import URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCLUDE_DECLARATION__IMPORT_URI = TARGET_CONTENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Include Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCLUDE_DECLARATION_FEATURE_COUNT = TARGET_CONTENT_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>Generate Import URI</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCLUDE_DECLARATION___GENERATE_IMPORT_URI = TARGET_CONTENT_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Include Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCLUDE_DECLARATION_OPERATION_COUNT = TARGET_CONTENT_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link fr.obeo.releng.targetplatform.impl.IUImpl <em>IU</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.obeo.releng.targetplatform.impl.IUImpl
	 * @see fr.obeo.releng.targetplatform.impl.TargetPlatformPackageImpl#getIU()
	 * @generated
	 */
	int IU = 11;

	/**
	 * The feature id for the '<em><b>ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IU__ID = 0;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IU__VERSION = 1;

	/**
	 * The feature id for the '<em><b>Location</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IU__LOCATION = 2;

	/**
	 * The number of structural features of the '<em>IU</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IU_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>IU</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IU_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link fr.obeo.releng.targetplatform.Option <em>Option</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.obeo.releng.targetplatform.Option
	 * @see fr.obeo.releng.targetplatform.impl.TargetPlatformPackageImpl#getOption()
	 * @generated
	 */
	int OPTION = 12;

	/**
	 * The meta object id for the '<em>Locale</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.util.Locale
	 * @see fr.obeo.releng.targetplatform.impl.TargetPlatformPackageImpl#getLocale()
	 * @generated
	 */
	int LOCALE = 13;

	/**
	 * The meta object id for the '<em>Execution Environment</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.jdt.launching.environments.IExecutionEnvironment
	 * @see fr.obeo.releng.targetplatform.impl.TargetPlatformPackageImpl#getExecutionEnvironment()
	 * @generated
	 */
	int EXECUTION_ENVIRONMENT = 14;


	/**
	 * Returns the meta object for class '{@link fr.obeo.releng.targetplatform.TargetPlatform <em>Target Platform</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Target Platform</em>'.
	 * @see fr.obeo.releng.targetplatform.TargetPlatform
	 * @generated
	 */
	EClass getTargetPlatform();

	/**
	 * Returns the meta object for the attribute '{@link fr.obeo.releng.targetplatform.TargetPlatform#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see fr.obeo.releng.targetplatform.TargetPlatform#getName()
	 * @see #getTargetPlatform()
	 * @generated
	 */
	EAttribute getTargetPlatform_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link fr.obeo.releng.targetplatform.TargetPlatform#getContents <em>Contents</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Contents</em>'.
	 * @see fr.obeo.releng.targetplatform.TargetPlatform#getContents()
	 * @see #getTargetPlatform()
	 * @generated
	 */
	EReference getTargetPlatform_Contents();

	/**
	 * Returns the meta object for the reference list '{@link fr.obeo.releng.targetplatform.TargetPlatform#getIncludes <em>Includes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Includes</em>'.
	 * @see fr.obeo.releng.targetplatform.TargetPlatform#getIncludes()
	 * @see #getTargetPlatform()
	 * @generated
	 */
	EReference getTargetPlatform_Includes();

	/**
	 * Returns the meta object for the attribute list '{@link fr.obeo.releng.targetplatform.TargetPlatform#getOptions <em>Options</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Options</em>'.
	 * @see fr.obeo.releng.targetplatform.TargetPlatform#getOptions()
	 * @see #getTargetPlatform()
	 * @generated
	 */
	EAttribute getTargetPlatform_Options();

	/**
	 * Returns the meta object for the reference list '{@link fr.obeo.releng.targetplatform.TargetPlatform#getLocations <em>Locations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Locations</em>'.
	 * @see fr.obeo.releng.targetplatform.TargetPlatform#getLocations()
	 * @see #getTargetPlatform()
	 * @generated
	 */
	EReference getTargetPlatform_Locations();

	/**
	 * Returns the meta object for the reference '{@link fr.obeo.releng.targetplatform.TargetPlatform#getEnvironment <em>Environment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Environment</em>'.
	 * @see fr.obeo.releng.targetplatform.TargetPlatform#getEnvironment()
	 * @see #getTargetPlatform()
	 * @generated
	 */
	EReference getTargetPlatform_Environment();

	/**
	 * Returns the meta object for class '{@link fr.obeo.releng.targetplatform.TargetContent <em>Target Content</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Target Content</em>'.
	 * @see fr.obeo.releng.targetplatform.TargetContent
	 * @generated
	 */
	EClass getTargetContent();

	/**
	 * Returns the meta object for the container reference '{@link fr.obeo.releng.targetplatform.TargetContent#getTargetPlatform <em>Target Platform</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Target Platform</em>'.
	 * @see fr.obeo.releng.targetplatform.TargetContent#getTargetPlatform()
	 * @see #getTargetContent()
	 * @generated
	 */
	EReference getTargetContent_TargetPlatform();

	/**
	 * Returns the meta object for class '{@link fr.obeo.releng.targetplatform.Options <em>Options</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Options</em>'.
	 * @see fr.obeo.releng.targetplatform.Options
	 * @generated
	 */
	EClass getOptions();

	/**
	 * Returns the meta object for the attribute list '{@link fr.obeo.releng.targetplatform.Options#getOptions <em>Options</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Options</em>'.
	 * @see fr.obeo.releng.targetplatform.Options#getOptions()
	 * @see #getOptions()
	 * @generated
	 */
	EAttribute getOptions_Options();

	/**
	 * Returns the meta object for class '{@link fr.obeo.releng.targetplatform.Environment <em>Environment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Environment</em>'.
	 * @see fr.obeo.releng.targetplatform.Environment
	 * @generated
	 */
	EClass getEnvironment();

	/**
	 * Returns the meta object for the attribute list '{@link fr.obeo.releng.targetplatform.Environment#getEnv <em>Env</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Env</em>'.
	 * @see fr.obeo.releng.targetplatform.Environment#getEnv()
	 * @see #getEnvironment()
	 * @generated
	 */
	EAttribute getEnvironment_Env();

	/**
	 * Returns the meta object for the attribute '{@link fr.obeo.releng.targetplatform.Environment#getOperatingSystem <em>Operating System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operating System</em>'.
	 * @see fr.obeo.releng.targetplatform.Environment#getOperatingSystem()
	 * @see #getEnvironment()
	 * @generated
	 */
	EAttribute getEnvironment_OperatingSystem();

	/**
	 * Returns the meta object for the attribute '{@link fr.obeo.releng.targetplatform.Environment#getWindowingSystem <em>Windowing System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Windowing System</em>'.
	 * @see fr.obeo.releng.targetplatform.Environment#getWindowingSystem()
	 * @see #getEnvironment()
	 * @generated
	 */
	EAttribute getEnvironment_WindowingSystem();

	/**
	 * Returns the meta object for the attribute '{@link fr.obeo.releng.targetplatform.Environment#getArchitecture <em>Architecture</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Architecture</em>'.
	 * @see fr.obeo.releng.targetplatform.Environment#getArchitecture()
	 * @see #getEnvironment()
	 * @generated
	 */
	EAttribute getEnvironment_Architecture();

	/**
	 * Returns the meta object for the attribute '{@link fr.obeo.releng.targetplatform.Environment#getLocalization <em>Localization</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Localization</em>'.
	 * @see fr.obeo.releng.targetplatform.Environment#getLocalization()
	 * @see #getEnvironment()
	 * @generated
	 */
	EAttribute getEnvironment_Localization();

	/**
	 * Returns the meta object for the attribute '{@link fr.obeo.releng.targetplatform.Environment#getExecutionEnvironment <em>Execution Environment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Execution Environment</em>'.
	 * @see fr.obeo.releng.targetplatform.Environment#getExecutionEnvironment()
	 * @see #getEnvironment()
	 * @generated
	 */
	EAttribute getEnvironment_ExecutionEnvironment();

	/**
	 * Returns the meta object for class '{@link fr.obeo.releng.targetplatform.VarDefinition <em>Var Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Var Definition</em>'.
	 * @see fr.obeo.releng.targetplatform.VarDefinition
	 * @generated
	 */
	EClass getVarDefinition();

	/**
	 * Returns the meta object for the attribute '{@link fr.obeo.releng.targetplatform.VarDefinition#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see fr.obeo.releng.targetplatform.VarDefinition#getName()
	 * @see #getVarDefinition()
	 * @generated
	 */
	EAttribute getVarDefinition_Name();

	/**
	 * Returns the meta object for the attribute '{@link fr.obeo.releng.targetplatform.VarDefinition#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see fr.obeo.releng.targetplatform.VarDefinition#getValue()
	 * @see #getVarDefinition()
	 * @generated
	 */
	EAttribute getVarDefinition_Value();

	/**
	 * Returns the meta object for class '{@link fr.obeo.releng.targetplatform.CompositeString <em>Composite String</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Composite String</em>'.
	 * @see fr.obeo.releng.targetplatform.CompositeString
	 * @generated
	 */
	EClass getCompositeString();

	/**
	 * Returns the meta object for the attribute '{@link fr.obeo.releng.targetplatform.CompositeString#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see fr.obeo.releng.targetplatform.CompositeString#getName()
	 * @see #getCompositeString()
	 * @generated
	 */
	EAttribute getCompositeString_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link fr.obeo.releng.targetplatform.CompositeString#getStringParts <em>String Parts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>String Parts</em>'.
	 * @see fr.obeo.releng.targetplatform.CompositeString#getStringParts()
	 * @see #getCompositeString()
	 * @generated
	 */
	EReference getCompositeString_StringParts();

	/**
	 * Returns the meta object for the '{@link fr.obeo.releng.targetplatform.CompositeString#computeActualString() <em>Compute Actual String</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Compute Actual String</em>' operation.
	 * @see fr.obeo.releng.targetplatform.CompositeString#computeActualString()
	 * @generated
	 */
	EOperation getCompositeString__ComputeActualString();

	/**
	 * Returns the meta object for class '{@link fr.obeo.releng.targetplatform.CompositeStringPart <em>Composite String Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Composite String Part</em>'.
	 * @see fr.obeo.releng.targetplatform.CompositeStringPart
	 * @generated
	 */
	EClass getCompositeStringPart();

	/**
	 * Returns the meta object for the container reference '{@link fr.obeo.releng.targetplatform.CompositeStringPart#getCompositeString <em>Composite String</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Composite String</em>'.
	 * @see fr.obeo.releng.targetplatform.CompositeStringPart#getCompositeString()
	 * @see #getCompositeStringPart()
	 * @generated
	 */
	EReference getCompositeStringPart_CompositeString();

	/**
	 * Returns the meta object for the '{@link fr.obeo.releng.targetplatform.CompositeStringPart#getActualString() <em>Get Actual String</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Actual String</em>' operation.
	 * @see fr.obeo.releng.targetplatform.CompositeStringPart#getActualString()
	 * @generated
	 */
	EOperation getCompositeStringPart__GetActualString();

	/**
	 * Returns the meta object for class '{@link fr.obeo.releng.targetplatform.VarCall <em>Var Call</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Var Call</em>'.
	 * @see fr.obeo.releng.targetplatform.VarCall
	 * @generated
	 */
	EClass getVarCall();

	/**
	 * Returns the meta object for the reference '{@link fr.obeo.releng.targetplatform.VarCall#getVarName <em>Var Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Var Name</em>'.
	 * @see fr.obeo.releng.targetplatform.VarCall#getVarName()
	 * @see #getVarCall()
	 * @generated
	 */
	EReference getVarCall_VarName();

	/**
	 * Returns the meta object for the '{@link fr.obeo.releng.targetplatform.VarCall#getActualString() <em>Get Actual String</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Actual String</em>' operation.
	 * @see fr.obeo.releng.targetplatform.VarCall#getActualString()
	 * @generated
	 */
	EOperation getVarCall__GetActualString();

	/**
	 * Returns the meta object for class '{@link fr.obeo.releng.targetplatform.StaticString <em>Static String</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Static String</em>'.
	 * @see fr.obeo.releng.targetplatform.StaticString
	 * @generated
	 */
	EClass getStaticString();

	/**
	 * Returns the meta object for the attribute '{@link fr.obeo.releng.targetplatform.StaticString#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see fr.obeo.releng.targetplatform.StaticString#getValue()
	 * @see #getStaticString()
	 * @generated
	 */
	EAttribute getStaticString_Value();

	/**
	 * Returns the meta object for the '{@link fr.obeo.releng.targetplatform.StaticString#getActualString() <em>Get Actual String</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Actual String</em>' operation.
	 * @see fr.obeo.releng.targetplatform.StaticString#getActualString()
	 * @generated
	 */
	EOperation getStaticString__GetActualString();

	/**
	 * Returns the meta object for class '{@link fr.obeo.releng.targetplatform.Location <em>Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Location</em>'.
	 * @see fr.obeo.releng.targetplatform.Location
	 * @generated
	 */
	EClass getLocation();

	/**
	 * Returns the meta object for the attribute '{@link fr.obeo.releng.targetplatform.Location#getID <em>ID</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>ID</em>'.
	 * @see fr.obeo.releng.targetplatform.Location#getID()
	 * @see #getLocation()
	 * @generated
	 */
	EAttribute getLocation_ID();

	/**
	 * Returns the meta object for the attribute '{@link fr.obeo.releng.targetplatform.Location#getUri <em>Uri</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Uri</em>'.
	 * @see fr.obeo.releng.targetplatform.Location#getUri()
	 * @see #getLocation()
	 * @generated
	 */
	EAttribute getLocation_Uri();

	/**
	 * Returns the meta object for the attribute list '{@link fr.obeo.releng.targetplatform.Location#getOptions <em>Options</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Options</em>'.
	 * @see fr.obeo.releng.targetplatform.Location#getOptions()
	 * @see #getLocation()
	 * @generated
	 */
	EAttribute getLocation_Options();

	/**
	 * Returns the meta object for the containment reference list '{@link fr.obeo.releng.targetplatform.Location#getIus <em>Ius</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Ius</em>'.
	 * @see fr.obeo.releng.targetplatform.Location#getIus()
	 * @see #getLocation()
	 * @generated
	 */
	EReference getLocation_Ius();

	/**
	 * Returns the meta object for class '{@link fr.obeo.releng.targetplatform.IncludeDeclaration <em>Include Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Include Declaration</em>'.
	 * @see fr.obeo.releng.targetplatform.IncludeDeclaration
	 * @generated
	 */
	EClass getIncludeDeclaration();

	/**
	 * Returns the meta object for the attribute '{@link fr.obeo.releng.targetplatform.IncludeDeclaration#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see fr.obeo.releng.targetplatform.IncludeDeclaration#getName()
	 * @see #getIncludeDeclaration()
	 * @generated
	 */
	EAttribute getIncludeDeclaration_Name();

	/**
	 * Returns the meta object for the containment reference '{@link fr.obeo.releng.targetplatform.IncludeDeclaration#getCompositeImportURI <em>Composite Import URI</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Composite Import URI</em>'.
	 * @see fr.obeo.releng.targetplatform.IncludeDeclaration#getCompositeImportURI()
	 * @see #getIncludeDeclaration()
	 * @generated
	 */
	EReference getIncludeDeclaration_CompositeImportURI();

	/**
	 * Returns the meta object for the attribute '{@link fr.obeo.releng.targetplatform.IncludeDeclaration#getImportURI <em>Import URI</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Import URI</em>'.
	 * @see fr.obeo.releng.targetplatform.IncludeDeclaration#getImportURI()
	 * @see #getIncludeDeclaration()
	 * @generated
	 */
	EAttribute getIncludeDeclaration_ImportURI();

	/**
	 * Returns the meta object for the '{@link fr.obeo.releng.targetplatform.IncludeDeclaration#generateImportURI() <em>Generate Import URI</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Generate Import URI</em>' operation.
	 * @see fr.obeo.releng.targetplatform.IncludeDeclaration#generateImportURI()
	 * @generated
	 */
	EOperation getIncludeDeclaration__GenerateImportURI();

	/**
	 * Returns the meta object for class '{@link fr.obeo.releng.targetplatform.IU <em>IU</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IU</em>'.
	 * @see fr.obeo.releng.targetplatform.IU
	 * @generated
	 */
	EClass getIU();

	/**
	 * Returns the meta object for the attribute '{@link fr.obeo.releng.targetplatform.IU#getID <em>ID</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>ID</em>'.
	 * @see fr.obeo.releng.targetplatform.IU#getID()
	 * @see #getIU()
	 * @generated
	 */
	EAttribute getIU_ID();

	/**
	 * Returns the meta object for the attribute '{@link fr.obeo.releng.targetplatform.IU#getVersion <em>Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Version</em>'.
	 * @see fr.obeo.releng.targetplatform.IU#getVersion()
	 * @see #getIU()
	 * @generated
	 */
	EAttribute getIU_Version();

	/**
	 * Returns the meta object for the container reference '{@link fr.obeo.releng.targetplatform.IU#getLocation <em>Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Location</em>'.
	 * @see fr.obeo.releng.targetplatform.IU#getLocation()
	 * @see #getIU()
	 * @generated
	 */
	EReference getIU_Location();

	/**
	 * Returns the meta object for enum '{@link fr.obeo.releng.targetplatform.Option <em>Option</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Option</em>'.
	 * @see fr.obeo.releng.targetplatform.Option
	 * @generated
	 */
	EEnum getOption();

	/**
	 * Returns the meta object for data type '{@link java.util.Locale <em>Locale</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Locale</em>'.
	 * @see java.util.Locale
	 * @model instanceClass="java.util.Locale"
	 * @generated
	 */
	EDataType getLocale();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.jdt.launching.environments.IExecutionEnvironment <em>Execution Environment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Execution Environment</em>'.
	 * @see org.eclipse.jdt.launching.environments.IExecutionEnvironment
	 * @model instanceClass="org.eclipse.jdt.launching.environments.IExecutionEnvironment"
	 * @generated
	 */
	EDataType getExecutionEnvironment();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	TargetPlatformFactory getTargetPlatformFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link fr.obeo.releng.targetplatform.impl.TargetPlatformImpl <em>Target Platform</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.obeo.releng.targetplatform.impl.TargetPlatformImpl
		 * @see fr.obeo.releng.targetplatform.impl.TargetPlatformPackageImpl#getTargetPlatform()
		 * @generated
		 */
		EClass TARGET_PLATFORM = eINSTANCE.getTargetPlatform();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TARGET_PLATFORM__NAME = eINSTANCE.getTargetPlatform_Name();

		/**
		 * The meta object literal for the '<em><b>Contents</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TARGET_PLATFORM__CONTENTS = eINSTANCE.getTargetPlatform_Contents();

		/**
		 * The meta object literal for the '<em><b>Includes</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TARGET_PLATFORM__INCLUDES = eINSTANCE.getTargetPlatform_Includes();

		/**
		 * The meta object literal for the '<em><b>Options</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TARGET_PLATFORM__OPTIONS = eINSTANCE.getTargetPlatform_Options();

		/**
		 * The meta object literal for the '<em><b>Locations</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TARGET_PLATFORM__LOCATIONS = eINSTANCE.getTargetPlatform_Locations();

		/**
		 * The meta object literal for the '<em><b>Environment</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TARGET_PLATFORM__ENVIRONMENT = eINSTANCE.getTargetPlatform_Environment();

		/**
		 * The meta object literal for the '{@link fr.obeo.releng.targetplatform.TargetContent <em>Target Content</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.obeo.releng.targetplatform.TargetContent
		 * @see fr.obeo.releng.targetplatform.impl.TargetPlatformPackageImpl#getTargetContent()
		 * @generated
		 */
		EClass TARGET_CONTENT = eINSTANCE.getTargetContent();

		/**
		 * The meta object literal for the '<em><b>Target Platform</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TARGET_CONTENT__TARGET_PLATFORM = eINSTANCE.getTargetContent_TargetPlatform();

		/**
		 * The meta object literal for the '{@link fr.obeo.releng.targetplatform.impl.OptionsImpl <em>Options</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.obeo.releng.targetplatform.impl.OptionsImpl
		 * @see fr.obeo.releng.targetplatform.impl.TargetPlatformPackageImpl#getOptions()
		 * @generated
		 */
		EClass OPTIONS = eINSTANCE.getOptions();

		/**
		 * The meta object literal for the '<em><b>Options</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPTIONS__OPTIONS = eINSTANCE.getOptions_Options();

		/**
		 * The meta object literal for the '{@link fr.obeo.releng.targetplatform.impl.EnvironmentImpl <em>Environment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.obeo.releng.targetplatform.impl.EnvironmentImpl
		 * @see fr.obeo.releng.targetplatform.impl.TargetPlatformPackageImpl#getEnvironment()
		 * @generated
		 */
		EClass ENVIRONMENT = eINSTANCE.getEnvironment();

		/**
		 * The meta object literal for the '<em><b>Env</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENVIRONMENT__ENV = eINSTANCE.getEnvironment_Env();

		/**
		 * The meta object literal for the '<em><b>Operating System</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENVIRONMENT__OPERATING_SYSTEM = eINSTANCE.getEnvironment_OperatingSystem();

		/**
		 * The meta object literal for the '<em><b>Windowing System</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENVIRONMENT__WINDOWING_SYSTEM = eINSTANCE.getEnvironment_WindowingSystem();

		/**
		 * The meta object literal for the '<em><b>Architecture</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENVIRONMENT__ARCHITECTURE = eINSTANCE.getEnvironment_Architecture();

		/**
		 * The meta object literal for the '<em><b>Localization</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENVIRONMENT__LOCALIZATION = eINSTANCE.getEnvironment_Localization();

		/**
		 * The meta object literal for the '<em><b>Execution Environment</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENVIRONMENT__EXECUTION_ENVIRONMENT = eINSTANCE.getEnvironment_ExecutionEnvironment();

		/**
		 * The meta object literal for the '{@link fr.obeo.releng.targetplatform.impl.VarDefinitionImpl <em>Var Definition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.obeo.releng.targetplatform.impl.VarDefinitionImpl
		 * @see fr.obeo.releng.targetplatform.impl.TargetPlatformPackageImpl#getVarDefinition()
		 * @generated
		 */
		EClass VAR_DEFINITION = eINSTANCE.getVarDefinition();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VAR_DEFINITION__NAME = eINSTANCE.getVarDefinition_Name();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VAR_DEFINITION__VALUE = eINSTANCE.getVarDefinition_Value();

		/**
		 * The meta object literal for the '{@link fr.obeo.releng.targetplatform.impl.CompositeStringImpl <em>Composite String</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.obeo.releng.targetplatform.impl.CompositeStringImpl
		 * @see fr.obeo.releng.targetplatform.impl.TargetPlatformPackageImpl#getCompositeString()
		 * @generated
		 */
		EClass COMPOSITE_STRING = eINSTANCE.getCompositeString();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPOSITE_STRING__NAME = eINSTANCE.getCompositeString_Name();

		/**
		 * The meta object literal for the '<em><b>String Parts</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOSITE_STRING__STRING_PARTS = eINSTANCE.getCompositeString_StringParts();

		/**
		 * The meta object literal for the '<em><b>Compute Actual String</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation COMPOSITE_STRING___COMPUTE_ACTUAL_STRING = eINSTANCE.getCompositeString__ComputeActualString();

		/**
		 * The meta object literal for the '{@link fr.obeo.releng.targetplatform.CompositeStringPart <em>Composite String Part</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.obeo.releng.targetplatform.CompositeStringPart
		 * @see fr.obeo.releng.targetplatform.impl.TargetPlatformPackageImpl#getCompositeStringPart()
		 * @generated
		 */
		EClass COMPOSITE_STRING_PART = eINSTANCE.getCompositeStringPart();

		/**
		 * The meta object literal for the '<em><b>Composite String</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOSITE_STRING_PART__COMPOSITE_STRING = eINSTANCE.getCompositeStringPart_CompositeString();

		/**
		 * The meta object literal for the '<em><b>Get Actual String</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation COMPOSITE_STRING_PART___GET_ACTUAL_STRING = eINSTANCE.getCompositeStringPart__GetActualString();

		/**
		 * The meta object literal for the '{@link fr.obeo.releng.targetplatform.impl.VarCallImpl <em>Var Call</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.obeo.releng.targetplatform.impl.VarCallImpl
		 * @see fr.obeo.releng.targetplatform.impl.TargetPlatformPackageImpl#getVarCall()
		 * @generated
		 */
		EClass VAR_CALL = eINSTANCE.getVarCall();

		/**
		 * The meta object literal for the '<em><b>Var Name</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VAR_CALL__VAR_NAME = eINSTANCE.getVarCall_VarName();

		/**
		 * The meta object literal for the '<em><b>Get Actual String</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation VAR_CALL___GET_ACTUAL_STRING = eINSTANCE.getVarCall__GetActualString();

		/**
		 * The meta object literal for the '{@link fr.obeo.releng.targetplatform.impl.StaticStringImpl <em>Static String</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.obeo.releng.targetplatform.impl.StaticStringImpl
		 * @see fr.obeo.releng.targetplatform.impl.TargetPlatformPackageImpl#getStaticString()
		 * @generated
		 */
		EClass STATIC_STRING = eINSTANCE.getStaticString();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STATIC_STRING__VALUE = eINSTANCE.getStaticString_Value();

		/**
		 * The meta object literal for the '<em><b>Get Actual String</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation STATIC_STRING___GET_ACTUAL_STRING = eINSTANCE.getStaticString__GetActualString();

		/**
		 * The meta object literal for the '{@link fr.obeo.releng.targetplatform.impl.LocationImpl <em>Location</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.obeo.releng.targetplatform.impl.LocationImpl
		 * @see fr.obeo.releng.targetplatform.impl.TargetPlatformPackageImpl#getLocation()
		 * @generated
		 */
		EClass LOCATION = eINSTANCE.getLocation();

		/**
		 * The meta object literal for the '<em><b>ID</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOCATION__ID = eINSTANCE.getLocation_ID();

		/**
		 * The meta object literal for the '<em><b>Uri</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOCATION__URI = eINSTANCE.getLocation_Uri();

		/**
		 * The meta object literal for the '<em><b>Options</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOCATION__OPTIONS = eINSTANCE.getLocation_Options();

		/**
		 * The meta object literal for the '<em><b>Ius</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOCATION__IUS = eINSTANCE.getLocation_Ius();

		/**
		 * The meta object literal for the '{@link fr.obeo.releng.targetplatform.impl.IncludeDeclarationImpl <em>Include Declaration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.obeo.releng.targetplatform.impl.IncludeDeclarationImpl
		 * @see fr.obeo.releng.targetplatform.impl.TargetPlatformPackageImpl#getIncludeDeclaration()
		 * @generated
		 */
		EClass INCLUDE_DECLARATION = eINSTANCE.getIncludeDeclaration();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INCLUDE_DECLARATION__NAME = eINSTANCE.getIncludeDeclaration_Name();

		/**
		 * The meta object literal for the '<em><b>Composite Import URI</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INCLUDE_DECLARATION__COMPOSITE_IMPORT_URI = eINSTANCE.getIncludeDeclaration_CompositeImportURI();

		/**
		 * The meta object literal for the '<em><b>Import URI</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INCLUDE_DECLARATION__IMPORT_URI = eINSTANCE.getIncludeDeclaration_ImportURI();

		/**
		 * The meta object literal for the '<em><b>Generate Import URI</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation INCLUDE_DECLARATION___GENERATE_IMPORT_URI = eINSTANCE.getIncludeDeclaration__GenerateImportURI();

		/**
		 * The meta object literal for the '{@link fr.obeo.releng.targetplatform.impl.IUImpl <em>IU</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.obeo.releng.targetplatform.impl.IUImpl
		 * @see fr.obeo.releng.targetplatform.impl.TargetPlatformPackageImpl#getIU()
		 * @generated
		 */
		EClass IU = eINSTANCE.getIU();

		/**
		 * The meta object literal for the '<em><b>ID</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IU__ID = eINSTANCE.getIU_ID();

		/**
		 * The meta object literal for the '<em><b>Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IU__VERSION = eINSTANCE.getIU_Version();

		/**
		 * The meta object literal for the '<em><b>Location</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IU__LOCATION = eINSTANCE.getIU_Location();

		/**
		 * The meta object literal for the '{@link fr.obeo.releng.targetplatform.Option <em>Option</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.obeo.releng.targetplatform.Option
		 * @see fr.obeo.releng.targetplatform.impl.TargetPlatformPackageImpl#getOption()
		 * @generated
		 */
		EEnum OPTION = eINSTANCE.getOption();

		/**
		 * The meta object literal for the '<em>Locale</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.util.Locale
		 * @see fr.obeo.releng.targetplatform.impl.TargetPlatformPackageImpl#getLocale()
		 * @generated
		 */
		EDataType LOCALE = eINSTANCE.getLocale();

		/**
		 * The meta object literal for the '<em>Execution Environment</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.jdt.launching.environments.IExecutionEnvironment
		 * @see fr.obeo.releng.targetplatform.impl.TargetPlatformPackageImpl#getExecutionEnvironment()
		 * @generated
		 */
		EDataType EXECUTION_ENVIRONMENT = eINSTANCE.getExecutionEnvironment();

	}

} //TargetPlatformPackage
