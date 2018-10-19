/**
 */
package optimal.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import optimal.OptimalFactory;
import optimal.Optimization;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Optimization</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class OptimizationTest extends TestCase {

	/**
	 * The fixture for this Optimization test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Optimization fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(OptimizationTest.class);
	}

	/**
	 * Constructs a new Optimization test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OptimizationTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Optimization test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(Optimization fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Optimization test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Optimization getFixture() {
		return fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(OptimalFactory.eINSTANCE.createOptimization());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}

} //OptimizationTest
