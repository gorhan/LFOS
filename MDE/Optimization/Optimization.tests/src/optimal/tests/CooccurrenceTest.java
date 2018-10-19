/**
 */
package optimal.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import optimal.Cooccurrence;
import optimal.OptimalFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Cooccurrence</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class CooccurrenceTest extends TestCase {

	/**
	 * The fixture for this Cooccurrence test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Cooccurrence fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(CooccurrenceTest.class);
	}

	/**
	 * Constructs a new Cooccurrence test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CooccurrenceTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Cooccurrence test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(Cooccurrence fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Cooccurrence test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Cooccurrence getFixture() {
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
		setFixture(OptimalFactory.eINSTANCE.createCooccurrence());
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

} //CooccurrenceTest
