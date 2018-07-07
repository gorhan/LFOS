/**
 */
package Connection;

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
 * @see Connection.ProcessFactory
 * @model kind="package"
 * @generated
 */
public interface ProcessPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "Connection";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.example.org/process";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "process";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ProcessPackage eINSTANCE = Connection.impl.ProcessPackageImpl.init();

	/**
	 * The meta object id for the '{@link Connection.impl.ProcessNodeImpl <em>Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Connection.impl.ProcessNodeImpl
	 * @see Connection.impl.ProcessPackageImpl#getProcessNode()
	 * @generated
	 */
	int PROCESS_NODE = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_NODE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Requires</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_NODE__REQUIRES = 1;

	/**
	 * The feature id for the '<em><b>Guard</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_NODE__GUARD = 2;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_NODE__NAMESPACE = 3;

	/**
	 * The number of structural features of the '<em>Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_NODE_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_NODE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link Connection.impl.RequirementImpl <em>Requirement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Connection.impl.RequirementImpl
	 * @see Connection.impl.ProcessPackageImpl#getRequirement()
	 * @generated
	 */
	int REQUIREMENT = 1;

	/**
	 * The feature id for the '<em><b>Resource Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__RESOURCE_NAME = 0;

	/**
	 * The feature id for the '<em><b>Required Capacity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__REQUIRED_CAPACITY = 1;

	/**
	 * The number of structural features of the '<em>Requirement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Requirement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link Connection.impl.ActiveResourceRequirementImpl <em>Active Resource Requirement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Connection.impl.ActiveResourceRequirementImpl
	 * @see Connection.impl.ProcessPackageImpl#getActiveResourceRequirement()
	 * @generated
	 */
	int ACTIVE_RESOURCE_REQUIREMENT = 2;

	/**
	 * The feature id for the '<em><b>Resource Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVE_RESOURCE_REQUIREMENT__RESOURCE_NAME = REQUIREMENT__RESOURCE_NAME;

	/**
	 * The feature id for the '<em><b>Required Capacity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVE_RESOURCE_REQUIREMENT__REQUIRED_CAPACITY = REQUIREMENT__REQUIRED_CAPACITY;

	/**
	 * The feature id for the '<em><b>WCET</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVE_RESOURCE_REQUIREMENT__WCET = REQUIREMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Active Resource Requirement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVE_RESOURCE_REQUIREMENT_FEATURE_COUNT = REQUIREMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Active Resource Requirement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVE_RESOURCE_REQUIREMENT_OPERATION_COUNT = REQUIREMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link Connection.impl.PassiveResourceRequirementImpl <em>Passive Resource Requirement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Connection.impl.PassiveResourceRequirementImpl
	 * @see Connection.impl.ProcessPackageImpl#getPassiveResourceRequirement()
	 * @generated
	 */
	int PASSIVE_RESOURCE_REQUIREMENT = 3;

	/**
	 * The feature id for the '<em><b>Resource Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PASSIVE_RESOURCE_REQUIREMENT__RESOURCE_NAME = REQUIREMENT__RESOURCE_NAME;

	/**
	 * The feature id for the '<em><b>Required Capacity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PASSIVE_RESOURCE_REQUIREMENT__REQUIRED_CAPACITY = REQUIREMENT__REQUIRED_CAPACITY;

	/**
	 * The number of structural features of the '<em>Passive Resource Requirement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PASSIVE_RESOURCE_REQUIREMENT_FEATURE_COUNT = REQUIREMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Passive Resource Requirement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PASSIVE_RESOURCE_REQUIREMENT_OPERATION_COUNT = REQUIREMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link Connection.impl.ProcessImpl <em>Process</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Connection.impl.ProcessImpl
	 * @see Connection.impl.ProcessPackageImpl#getProcess()
	 * @generated
	 */
	int PROCESS = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS__NAME = PROCESS_NODE__NAME;

	/**
	 * The feature id for the '<em><b>Requires</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS__REQUIRES = PROCESS_NODE__REQUIRES;

	/**
	 * The feature id for the '<em><b>Guard</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS__GUARD = PROCESS_NODE__GUARD;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS__NAMESPACE = PROCESS_NODE__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Period</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS__PERIOD = PROCESS_NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Output</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS__OUTPUT = PROCESS_NODE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Input</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS__INPUT = PROCESS_NODE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Process</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_FEATURE_COUNT = PROCESS_NODE_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Process</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_OPERATION_COUNT = PROCESS_NODE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link Connection.impl.ProcessDiagramImpl <em>Diagram</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Connection.impl.ProcessDiagramImpl
	 * @see Connection.impl.ProcessPackageImpl#getProcessDiagram()
	 * @generated
	 */
	int PROCESS_DIAGRAM = 5;

	/**
	 * The feature id for the '<em><b>Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_DIAGRAM__NODES = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_DIAGRAM__NAME = 1;

	/**
	 * The number of structural features of the '<em>Diagram</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_DIAGRAM_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Diagram</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_DIAGRAM_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link Connection.impl.InputImpl <em>Input</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Connection.impl.InputImpl
	 * @see Connection.impl.ProcessPackageImpl#getInput()
	 * @generated
	 */
	int INPUT = 6;

	/**
	 * The feature id for the '<em><b>Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT__DATA = 0;

	/**
	 * The feature id for the '<em><b>Operation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT__OPERATION = 1;

	/**
	 * The number of structural features of the '<em>Input</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Input</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link Connection.impl.DataImpl <em>Data</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Connection.impl.DataImpl
	 * @see Connection.impl.ProcessPackageImpl#getData()
	 * @generated
	 */
	int DATA = 7;

	/**
	 * The feature id for the '<em><b>Amount</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA__AMOUNT = 0;

	/**
	 * The feature id for the '<em><b>Produced By</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA__PRODUCED_BY = 1;

	/**
	 * The number of structural features of the '<em>Data</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Data</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link Connection.impl.OutputImpl <em>Output</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Connection.impl.OutputImpl
	 * @see Connection.impl.ProcessPackageImpl#getOutput()
	 * @generated
	 */
	int OUTPUT = 8;

	/**
	 * The feature id for the '<em><b>Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT__DATA = 0;

	/**
	 * The number of structural features of the '<em>Output</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Output</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link Connection.LogicalOperation <em>Logical Operation</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Connection.LogicalOperation
	 * @see Connection.impl.ProcessPackageImpl#getLogicalOperation()
	 * @generated
	 */
	int LOGICAL_OPERATION = 9;


	/**
	 * Returns the meta object for class '{@link Connection.ProcessNode <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Node</em>'.
	 * @see Connection.ProcessNode
	 * @generated
	 */
	EClass getProcessNode();

	/**
	 * Returns the meta object for the attribute '{@link Connection.ProcessNode#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see Connection.ProcessNode#getName()
	 * @see #getProcessNode()
	 * @generated
	 */
	EAttribute getProcessNode_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link Connection.ProcessNode#getRequires <em>Requires</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Requires</em>'.
	 * @see Connection.ProcessNode#getRequires()
	 * @see #getProcessNode()
	 * @generated
	 */
	EReference getProcessNode_Requires();

	/**
	 * Returns the meta object for the attribute '{@link Connection.ProcessNode#getGuard <em>Guard</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Guard</em>'.
	 * @see Connection.ProcessNode#getGuard()
	 * @see #getProcessNode()
	 * @generated
	 */
	EAttribute getProcessNode_Guard();

	/**
	 * Returns the meta object for the attribute '{@link Connection.ProcessNode#getNamespace <em>Namespace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Namespace</em>'.
	 * @see Connection.ProcessNode#getNamespace()
	 * @see #getProcessNode()
	 * @generated
	 */
	EAttribute getProcessNode_Namespace();

	/**
	 * Returns the meta object for class '{@link Connection.Requirement <em>Requirement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Requirement</em>'.
	 * @see Connection.Requirement
	 * @generated
	 */
	EClass getRequirement();

	/**
	 * Returns the meta object for the attribute '{@link Connection.Requirement#getResourceName <em>Resource Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Resource Name</em>'.
	 * @see Connection.Requirement#getResourceName()
	 * @see #getRequirement()
	 * @generated
	 */
	EAttribute getRequirement_ResourceName();

	/**
	 * Returns the meta object for the attribute '{@link Connection.Requirement#getRequiredCapacity <em>Required Capacity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Required Capacity</em>'.
	 * @see Connection.Requirement#getRequiredCapacity()
	 * @see #getRequirement()
	 * @generated
	 */
	EAttribute getRequirement_RequiredCapacity();

	/**
	 * Returns the meta object for class '{@link Connection.ActiveResourceRequirement <em>Active Resource Requirement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Active Resource Requirement</em>'.
	 * @see Connection.ActiveResourceRequirement
	 * @generated
	 */
	EClass getActiveResourceRequirement();

	/**
	 * Returns the meta object for the attribute '{@link Connection.ActiveResourceRequirement#getWCET <em>WCET</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>WCET</em>'.
	 * @see Connection.ActiveResourceRequirement#getWCET()
	 * @see #getActiveResourceRequirement()
	 * @generated
	 */
	EAttribute getActiveResourceRequirement_WCET();

	/**
	 * Returns the meta object for class '{@link Connection.PassiveResourceRequirement <em>Passive Resource Requirement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Passive Resource Requirement</em>'.
	 * @see Connection.PassiveResourceRequirement
	 * @generated
	 */
	EClass getPassiveResourceRequirement();

	/**
	 * Returns the meta object for class '{@link Connection.Process <em>Process</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Process</em>'.
	 * @see Connection.Process
	 * @generated
	 */
	EClass getProcess();

	/**
	 * Returns the meta object for the attribute '{@link Connection.Process#getPeriod <em>Period</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Period</em>'.
	 * @see Connection.Process#getPeriod()
	 * @see #getProcess()
	 * @generated
	 */
	EAttribute getProcess_Period();

	/**
	 * Returns the meta object for the containment reference '{@link Connection.Process#getOutput <em>Output</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Output</em>'.
	 * @see Connection.Process#getOutput()
	 * @see #getProcess()
	 * @generated
	 */
	EReference getProcess_Output();

	/**
	 * Returns the meta object for the containment reference '{@link Connection.Process#getInput <em>Input</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Input</em>'.
	 * @see Connection.Process#getInput()
	 * @see #getProcess()
	 * @generated
	 */
	EReference getProcess_Input();

	/**
	 * Returns the meta object for class '{@link Connection.ProcessDiagram <em>Diagram</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Diagram</em>'.
	 * @see Connection.ProcessDiagram
	 * @generated
	 */
	EClass getProcessDiagram();

	/**
	 * Returns the meta object for the containment reference list '{@link Connection.ProcessDiagram#getNodes <em>Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Nodes</em>'.
	 * @see Connection.ProcessDiagram#getNodes()
	 * @see #getProcessDiagram()
	 * @generated
	 */
	EReference getProcessDiagram_Nodes();

	/**
	 * Returns the meta object for the attribute '{@link Connection.ProcessDiagram#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see Connection.ProcessDiagram#getName()
	 * @see #getProcessDiagram()
	 * @generated
	 */
	EAttribute getProcessDiagram_Name();

	/**
	 * Returns the meta object for class '{@link Connection.Input <em>Input</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Input</em>'.
	 * @see Connection.Input
	 * @generated
	 */
	EClass getInput();

	/**
	 * Returns the meta object for the containment reference list '{@link Connection.Input#getData <em>Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Data</em>'.
	 * @see Connection.Input#getData()
	 * @see #getInput()
	 * @generated
	 */
	EReference getInput_Data();

	/**
	 * Returns the meta object for the attribute '{@link Connection.Input#getOperation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operation</em>'.
	 * @see Connection.Input#getOperation()
	 * @see #getInput()
	 * @generated
	 */
	EAttribute getInput_Operation();

	/**
	 * Returns the meta object for class '{@link Connection.Data <em>Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data</em>'.
	 * @see Connection.Data
	 * @generated
	 */
	EClass getData();

	/**
	 * Returns the meta object for the attribute '{@link Connection.Data#getAmount <em>Amount</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Amount</em>'.
	 * @see Connection.Data#getAmount()
	 * @see #getData()
	 * @generated
	 */
	EAttribute getData_Amount();

	/**
	 * Returns the meta object for the reference '{@link Connection.Data#getProducedBy <em>Produced By</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Produced By</em>'.
	 * @see Connection.Data#getProducedBy()
	 * @see #getData()
	 * @generated
	 */
	EReference getData_ProducedBy();

	/**
	 * Returns the meta object for class '{@link Connection.Output <em>Output</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Output</em>'.
	 * @see Connection.Output
	 * @generated
	 */
	EClass getOutput();

	/**
	 * Returns the meta object for the containment reference list '{@link Connection.Output#getData <em>Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Data</em>'.
	 * @see Connection.Output#getData()
	 * @see #getOutput()
	 * @generated
	 */
	EReference getOutput_Data();

	/**
	 * Returns the meta object for enum '{@link Connection.LogicalOperation <em>Logical Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Logical Operation</em>'.
	 * @see Connection.LogicalOperation
	 * @generated
	 */
	EEnum getLogicalOperation();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ProcessFactory getProcessFactory();

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
		 * The meta object literal for the '{@link Connection.impl.ProcessNodeImpl <em>Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Connection.impl.ProcessNodeImpl
		 * @see Connection.impl.ProcessPackageImpl#getProcessNode()
		 * @generated
		 */
		EClass PROCESS_NODE = eINSTANCE.getProcessNode();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROCESS_NODE__NAME = eINSTANCE.getProcessNode_Name();

		/**
		 * The meta object literal for the '<em><b>Requires</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROCESS_NODE__REQUIRES = eINSTANCE.getProcessNode_Requires();

		/**
		 * The meta object literal for the '<em><b>Guard</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROCESS_NODE__GUARD = eINSTANCE.getProcessNode_Guard();

		/**
		 * The meta object literal for the '<em><b>Namespace</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROCESS_NODE__NAMESPACE = eINSTANCE.getProcessNode_Namespace();

		/**
		 * The meta object literal for the '{@link Connection.impl.RequirementImpl <em>Requirement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Connection.impl.RequirementImpl
		 * @see Connection.impl.ProcessPackageImpl#getRequirement()
		 * @generated
		 */
		EClass REQUIREMENT = eINSTANCE.getRequirement();

		/**
		 * The meta object literal for the '<em><b>Resource Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REQUIREMENT__RESOURCE_NAME = eINSTANCE.getRequirement_ResourceName();

		/**
		 * The meta object literal for the '<em><b>Required Capacity</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REQUIREMENT__REQUIRED_CAPACITY = eINSTANCE.getRequirement_RequiredCapacity();

		/**
		 * The meta object literal for the '{@link Connection.impl.ActiveResourceRequirementImpl <em>Active Resource Requirement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Connection.impl.ActiveResourceRequirementImpl
		 * @see Connection.impl.ProcessPackageImpl#getActiveResourceRequirement()
		 * @generated
		 */
		EClass ACTIVE_RESOURCE_REQUIREMENT = eINSTANCE.getActiveResourceRequirement();

		/**
		 * The meta object literal for the '<em><b>WCET</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTIVE_RESOURCE_REQUIREMENT__WCET = eINSTANCE.getActiveResourceRequirement_WCET();

		/**
		 * The meta object literal for the '{@link Connection.impl.PassiveResourceRequirementImpl <em>Passive Resource Requirement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Connection.impl.PassiveResourceRequirementImpl
		 * @see Connection.impl.ProcessPackageImpl#getPassiveResourceRequirement()
		 * @generated
		 */
		EClass PASSIVE_RESOURCE_REQUIREMENT = eINSTANCE.getPassiveResourceRequirement();

		/**
		 * The meta object literal for the '{@link Connection.impl.ProcessImpl <em>Process</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Connection.impl.ProcessImpl
		 * @see Connection.impl.ProcessPackageImpl#getProcess()
		 * @generated
		 */
		EClass PROCESS = eINSTANCE.getProcess();

		/**
		 * The meta object literal for the '<em><b>Period</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROCESS__PERIOD = eINSTANCE.getProcess_Period();

		/**
		 * The meta object literal for the '<em><b>Output</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROCESS__OUTPUT = eINSTANCE.getProcess_Output();

		/**
		 * The meta object literal for the '<em><b>Input</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROCESS__INPUT = eINSTANCE.getProcess_Input();

		/**
		 * The meta object literal for the '{@link Connection.impl.ProcessDiagramImpl <em>Diagram</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Connection.impl.ProcessDiagramImpl
		 * @see Connection.impl.ProcessPackageImpl#getProcessDiagram()
		 * @generated
		 */
		EClass PROCESS_DIAGRAM = eINSTANCE.getProcessDiagram();

		/**
		 * The meta object literal for the '<em><b>Nodes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROCESS_DIAGRAM__NODES = eINSTANCE.getProcessDiagram_Nodes();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROCESS_DIAGRAM__NAME = eINSTANCE.getProcessDiagram_Name();

		/**
		 * The meta object literal for the '{@link Connection.impl.InputImpl <em>Input</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Connection.impl.InputImpl
		 * @see Connection.impl.ProcessPackageImpl#getInput()
		 * @generated
		 */
		EClass INPUT = eINSTANCE.getInput();

		/**
		 * The meta object literal for the '<em><b>Data</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INPUT__DATA = eINSTANCE.getInput_Data();

		/**
		 * The meta object literal for the '<em><b>Operation</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INPUT__OPERATION = eINSTANCE.getInput_Operation();

		/**
		 * The meta object literal for the '{@link Connection.impl.DataImpl <em>Data</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Connection.impl.DataImpl
		 * @see Connection.impl.ProcessPackageImpl#getData()
		 * @generated
		 */
		EClass DATA = eINSTANCE.getData();

		/**
		 * The meta object literal for the '<em><b>Amount</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATA__AMOUNT = eINSTANCE.getData_Amount();

		/**
		 * The meta object literal for the '<em><b>Produced By</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA__PRODUCED_BY = eINSTANCE.getData_ProducedBy();

		/**
		 * The meta object literal for the '{@link Connection.impl.OutputImpl <em>Output</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Connection.impl.OutputImpl
		 * @see Connection.impl.ProcessPackageImpl#getOutput()
		 * @generated
		 */
		EClass OUTPUT = eINSTANCE.getOutput();

		/**
		 * The meta object literal for the '<em><b>Data</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OUTPUT__DATA = eINSTANCE.getOutput_Data();

		/**
		 * The meta object literal for the '{@link Connection.LogicalOperation <em>Logical Operation</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Connection.LogicalOperation
		 * @see Connection.impl.ProcessPackageImpl#getLogicalOperation()
		 * @generated
		 */
		EEnum LOGICAL_OPERATION = eINSTANCE.getLogicalOperation();

	}

} //ProcessPackage
