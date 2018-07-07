/**
 */
package platformMM;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
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
 * @see platformMM.PlatformMMFactory
 * @model kind="package"
 * @generated
 */
public interface PlatformMMPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "platformMM";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.example.org/platformMM";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "platformMM";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	PlatformMMPackage eINSTANCE = platformMM.impl.PlatformMMPackageImpl.init();

	/**
	 * The meta object id for the '{@link platformMM.impl.ResourceImpl <em>Resource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see platformMM.impl.ResourceImpl
	 * @see platformMM.impl.PlatformMMPackageImpl#getResource()
	 * @generated
	 */
	int RESOURCE = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Exclusive Resources</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__EXCLUSIVE_RESOURCES = 1;

	/**
	 * The feature id for the '<em><b>Belongs</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__BELONGS = 2;

	/**
	 * The number of structural features of the '<em>Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link platformMM.impl.TerminalResourceImpl <em>Terminal Resource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see platformMM.impl.TerminalResourceImpl
	 * @see platformMM.impl.PlatformMMPackageImpl#getTerminalResource()
	 * @generated
	 */
	int TERMINAL_RESOURCE = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINAL_RESOURCE__NAME = RESOURCE__NAME;

	/**
	 * The feature id for the '<em><b>Exclusive Resources</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINAL_RESOURCE__EXCLUSIVE_RESOURCES = RESOURCE__EXCLUSIVE_RESOURCES;

	/**
	 * The feature id for the '<em><b>Belongs</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINAL_RESOURCE__BELONGS = RESOURCE__BELONGS;

	/**
	 * The feature id for the '<em><b>Capacity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINAL_RESOURCE__CAPACITY = RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>States</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINAL_RESOURCE__STATES = RESOURCE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Terminal Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINAL_RESOURCE_FEATURE_COUNT = RESOURCE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Terminal Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINAL_RESOURCE_OPERATION_COUNT = RESOURCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link platformMM.impl.CompositeResourceImpl <em>Composite Resource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see platformMM.impl.CompositeResourceImpl
	 * @see platformMM.impl.PlatformMMPackageImpl#getCompositeResource()
	 * @generated
	 */
	int COMPOSITE_RESOURCE = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_RESOURCE__NAME = RESOURCE__NAME;

	/**
	 * The feature id for the '<em><b>Exclusive Resources</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_RESOURCE__EXCLUSIVE_RESOURCES = RESOURCE__EXCLUSIVE_RESOURCES;

	/**
	 * The feature id for the '<em><b>Belongs</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_RESOURCE__BELONGS = RESOURCE__BELONGS;

	/**
	 * The feature id for the '<em><b>Childs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_RESOURCE__CHILDS = RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Composite Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_RESOURCE_FEATURE_COUNT = RESOURCE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Composite Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_RESOURCE_OPERATION_COUNT = RESOURCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link platformMM.impl.StateDVSImpl <em>State DVS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see platformMM.impl.StateDVSImpl
	 * @see platformMM.impl.PlatformMMPackageImpl#getStateDVS()
	 * @generated
	 */
	int STATE_DVS = 3;

	/**
	 * The feature id for the '<em><b>Scale</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_DVS__SCALE = 0;

	/**
	 * The feature id for the '<em><b>Energy</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_DVS__ENERGY = 1;

	/**
	 * The number of structural features of the '<em>State DVS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_DVS_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>State DVS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_DVS_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link platformMM.impl.ResourceTypeImpl <em>Resource Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see platformMM.impl.ResourceTypeImpl
	 * @see platformMM.impl.PlatformMMPackageImpl#getResourceType()
	 * @generated
	 */
	int RESOURCE_TYPE = 4;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_TYPE__IDENTIFIER = 0;

	/**
	 * The feature id for the '<em><b>Abstraction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_TYPE__ABSTRACTION = 1;

	/**
	 * The number of structural features of the '<em>Resource Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_TYPE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Resource Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_TYPE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link platformMM.impl.PlatformDiagramImpl <em>Platform Diagram</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see platformMM.impl.PlatformDiagramImpl
	 * @see platformMM.impl.PlatformMMPackageImpl#getPlatformDiagram()
	 * @generated
	 */
	int PLATFORM_DIAGRAM = 5;

	/**
	 * The feature id for the '<em><b>System</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLATFORM_DIAGRAM__SYSTEM = 0;

	/**
	 * The feature id for the '<em><b>Resource Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLATFORM_DIAGRAM__RESOURCE_TYPES = 1;

	/**
	 * The number of structural features of the '<em>Platform Diagram</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLATFORM_DIAGRAM_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Platform Diagram</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLATFORM_DIAGRAM_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link platformMM.ResourceAbstraction <em>Resource Abstraction</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see platformMM.ResourceAbstraction
	 * @see platformMM.impl.PlatformMMPackageImpl#getResourceAbstraction()
	 * @generated
	 */
	int RESOURCE_ABSTRACTION = 6;


	/**
	 * Returns the meta object for class '{@link platformMM.Resource <em>Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resource</em>'.
	 * @see platformMM.Resource
	 * @generated
	 */
	EClass getResource();

	/**
	 * Returns the meta object for the attribute '{@link platformMM.Resource#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see platformMM.Resource#getName()
	 * @see #getResource()
	 * @generated
	 */
	EAttribute getResource_Name();

	/**
	 * Returns the meta object for the reference list '{@link platformMM.Resource#getExclusiveResources <em>Exclusive Resources</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Exclusive Resources</em>'.
	 * @see platformMM.Resource#getExclusiveResources()
	 * @see #getResource()
	 * @generated
	 */
	EReference getResource_ExclusiveResources();

	/**
	 * Returns the meta object for the reference '{@link platformMM.Resource#getBelongs <em>Belongs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Belongs</em>'.
	 * @see platformMM.Resource#getBelongs()
	 * @see #getResource()
	 * @generated
	 */
	EReference getResource_Belongs();

	/**
	 * Returns the meta object for class '{@link platformMM.TerminalResource <em>Terminal Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Terminal Resource</em>'.
	 * @see platformMM.TerminalResource
	 * @generated
	 */
	EClass getTerminalResource();

	/**
	 * Returns the meta object for the attribute '{@link platformMM.TerminalResource#getCapacity <em>Capacity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Capacity</em>'.
	 * @see platformMM.TerminalResource#getCapacity()
	 * @see #getTerminalResource()
	 * @generated
	 */
	EAttribute getTerminalResource_Capacity();

	/**
	 * Returns the meta object for the containment reference list '{@link platformMM.TerminalResource#getStates <em>States</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>States</em>'.
	 * @see platformMM.TerminalResource#getStates()
	 * @see #getTerminalResource()
	 * @generated
	 */
	EReference getTerminalResource_States();

	/**
	 * Returns the meta object for class '{@link platformMM.CompositeResource <em>Composite Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Composite Resource</em>'.
	 * @see platformMM.CompositeResource
	 * @generated
	 */
	EClass getCompositeResource();

	/**
	 * Returns the meta object for the containment reference list '{@link platformMM.CompositeResource#getChilds <em>Childs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Childs</em>'.
	 * @see platformMM.CompositeResource#getChilds()
	 * @see #getCompositeResource()
	 * @generated
	 */
	EReference getCompositeResource_Childs();

	/**
	 * Returns the meta object for class '{@link platformMM.StateDVS <em>State DVS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>State DVS</em>'.
	 * @see platformMM.StateDVS
	 * @generated
	 */
	EClass getStateDVS();

	/**
	 * Returns the meta object for the attribute '{@link platformMM.StateDVS#getScale <em>Scale</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Scale</em>'.
	 * @see platformMM.StateDVS#getScale()
	 * @see #getStateDVS()
	 * @generated
	 */
	EAttribute getStateDVS_Scale();

	/**
	 * Returns the meta object for the attribute '{@link platformMM.StateDVS#getEnergy <em>Energy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Energy</em>'.
	 * @see platformMM.StateDVS#getEnergy()
	 * @see #getStateDVS()
	 * @generated
	 */
	EAttribute getStateDVS_Energy();

	/**
	 * Returns the meta object for class '{@link platformMM.ResourceType <em>Resource Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resource Type</em>'.
	 * @see platformMM.ResourceType
	 * @generated
	 */
	EClass getResourceType();

	/**
	 * Returns the meta object for the attribute '{@link platformMM.ResourceType#getIdentifier <em>Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Identifier</em>'.
	 * @see platformMM.ResourceType#getIdentifier()
	 * @see #getResourceType()
	 * @generated
	 */
	EAttribute getResourceType_Identifier();

	/**
	 * Returns the meta object for the attribute '{@link platformMM.ResourceType#getAbstraction <em>Abstraction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Abstraction</em>'.
	 * @see platformMM.ResourceType#getAbstraction()
	 * @see #getResourceType()
	 * @generated
	 */
	EAttribute getResourceType_Abstraction();

	/**
	 * Returns the meta object for class '{@link platformMM.PlatformDiagram <em>Platform Diagram</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Platform Diagram</em>'.
	 * @see platformMM.PlatformDiagram
	 * @generated
	 */
	EClass getPlatformDiagram();

	/**
	 * Returns the meta object for the containment reference '{@link platformMM.PlatformDiagram#getSystem <em>System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>System</em>'.
	 * @see platformMM.PlatformDiagram#getSystem()
	 * @see #getPlatformDiagram()
	 * @generated
	 */
	EReference getPlatformDiagram_System();

	/**
	 * Returns the meta object for the containment reference list '{@link platformMM.PlatformDiagram#getResourceTypes <em>Resource Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Resource Types</em>'.
	 * @see platformMM.PlatformDiagram#getResourceTypes()
	 * @see #getPlatformDiagram()
	 * @generated
	 */
	EReference getPlatformDiagram_ResourceTypes();

	/**
	 * Returns the meta object for enum '{@link platformMM.ResourceAbstraction <em>Resource Abstraction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Resource Abstraction</em>'.
	 * @see platformMM.ResourceAbstraction
	 * @generated
	 */
	EEnum getResourceAbstraction();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	PlatformMMFactory getPlatformMMFactory();

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
		 * The meta object literal for the '{@link platformMM.impl.ResourceImpl <em>Resource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see platformMM.impl.ResourceImpl
		 * @see platformMM.impl.PlatformMMPackageImpl#getResource()
		 * @generated
		 */
		EClass RESOURCE = eINSTANCE.getResource();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESOURCE__NAME = eINSTANCE.getResource_Name();

		/**
		 * The meta object literal for the '<em><b>Exclusive Resources</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOURCE__EXCLUSIVE_RESOURCES = eINSTANCE.getResource_ExclusiveResources();

		/**
		 * The meta object literal for the '<em><b>Belongs</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOURCE__BELONGS = eINSTANCE.getResource_Belongs();

		/**
		 * The meta object literal for the '{@link platformMM.impl.TerminalResourceImpl <em>Terminal Resource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see platformMM.impl.TerminalResourceImpl
		 * @see platformMM.impl.PlatformMMPackageImpl#getTerminalResource()
		 * @generated
		 */
		EClass TERMINAL_RESOURCE = eINSTANCE.getTerminalResource();

		/**
		 * The meta object literal for the '<em><b>Capacity</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TERMINAL_RESOURCE__CAPACITY = eINSTANCE.getTerminalResource_Capacity();

		/**
		 * The meta object literal for the '<em><b>States</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TERMINAL_RESOURCE__STATES = eINSTANCE.getTerminalResource_States();

		/**
		 * The meta object literal for the '{@link platformMM.impl.CompositeResourceImpl <em>Composite Resource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see platformMM.impl.CompositeResourceImpl
		 * @see platformMM.impl.PlatformMMPackageImpl#getCompositeResource()
		 * @generated
		 */
		EClass COMPOSITE_RESOURCE = eINSTANCE.getCompositeResource();

		/**
		 * The meta object literal for the '<em><b>Childs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOSITE_RESOURCE__CHILDS = eINSTANCE.getCompositeResource_Childs();

		/**
		 * The meta object literal for the '{@link platformMM.impl.StateDVSImpl <em>State DVS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see platformMM.impl.StateDVSImpl
		 * @see platformMM.impl.PlatformMMPackageImpl#getStateDVS()
		 * @generated
		 */
		EClass STATE_DVS = eINSTANCE.getStateDVS();

		/**
		 * The meta object literal for the '<em><b>Scale</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STATE_DVS__SCALE = eINSTANCE.getStateDVS_Scale();

		/**
		 * The meta object literal for the '<em><b>Energy</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STATE_DVS__ENERGY = eINSTANCE.getStateDVS_Energy();

		/**
		 * The meta object literal for the '{@link platformMM.impl.ResourceTypeImpl <em>Resource Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see platformMM.impl.ResourceTypeImpl
		 * @see platformMM.impl.PlatformMMPackageImpl#getResourceType()
		 * @generated
		 */
		EClass RESOURCE_TYPE = eINSTANCE.getResourceType();

		/**
		 * The meta object literal for the '<em><b>Identifier</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESOURCE_TYPE__IDENTIFIER = eINSTANCE.getResourceType_Identifier();

		/**
		 * The meta object literal for the '<em><b>Abstraction</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESOURCE_TYPE__ABSTRACTION = eINSTANCE.getResourceType_Abstraction();

		/**
		 * The meta object literal for the '{@link platformMM.impl.PlatformDiagramImpl <em>Platform Diagram</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see platformMM.impl.PlatformDiagramImpl
		 * @see platformMM.impl.PlatformMMPackageImpl#getPlatformDiagram()
		 * @generated
		 */
		EClass PLATFORM_DIAGRAM = eINSTANCE.getPlatformDiagram();

		/**
		 * The meta object literal for the '<em><b>System</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PLATFORM_DIAGRAM__SYSTEM = eINSTANCE.getPlatformDiagram_System();

		/**
		 * The meta object literal for the '<em><b>Resource Types</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PLATFORM_DIAGRAM__RESOURCE_TYPES = eINSTANCE.getPlatformDiagram_ResourceTypes();

		/**
		 * The meta object literal for the '{@link platformMM.ResourceAbstraction <em>Resource Abstraction</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see platformMM.ResourceAbstraction
		 * @see platformMM.impl.PlatformMMPackageImpl#getResourceAbstraction()
		 * @generated
		 */
		EEnum RESOURCE_ABSTRACTION = eINSTANCE.getResourceAbstraction();

	}

} //PlatformMMPackage
