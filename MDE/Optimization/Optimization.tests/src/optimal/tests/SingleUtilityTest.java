/**
 */
package optimal.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import optimal.OptimalFactory;
import optimal.SingleUtility;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Single Utility</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class SingleUtilityTest extends TestCase {

	/**
	 * The fixture for this Single Utility test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SingleUtility fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(SingleUtilityTest.class);
	}

	/**
	 * Constructs a new Single Utility test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SingleUtilityTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Single Utility test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(SingleUtility fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Single Utility test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SingleUtility getFixture() {
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
		setFixture(OptimalFactory.eINSTANCE.createSingleUtility());
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

} //SingleUtilityTest
