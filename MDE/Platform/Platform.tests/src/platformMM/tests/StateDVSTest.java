/**
 */
package platformMM.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import platformMM.PlatformMMFactory;
import platformMM.StateDVS;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>State DVS</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class StateDVSTest extends TestCase {

	/**
	 * The fixture for this State DVS test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StateDVS fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(StateDVSTest.class);
	}

	/**
	 * Constructs a new State DVS test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StateDVSTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this State DVS test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(StateDVS fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this State DVS test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StateDVS getFixture() {
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
		setFixture(PlatformMMFactory.eINSTANCE.createStateDVS());
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

} //StateDVSTest
