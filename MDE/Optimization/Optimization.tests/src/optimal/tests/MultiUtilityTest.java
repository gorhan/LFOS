/**
 */
package optimal.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import optimal.MultiUtility;
import optimal.OptimalFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Multi Utility</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class MultiUtilityTest extends TestCase {

	/**
	 * The fixture for this Multi Utility test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MultiUtility fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(MultiUtilityTest.class);
	}

	/**
	 * Constructs a new Multi Utility test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MultiUtilityTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Multi Utility test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(MultiUtility fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Multi Utility test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MultiUtility getFixture() {
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
		setFixture(OptimalFactory.eINSTANCE.createMultiUtility());
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

} //MultiUtilityTest
