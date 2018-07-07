/**
 */
package platformMM.tests;

import junit.textui.TestRunner;

import platformMM.PlatformMMFactory;
import platformMM.TerminalResource;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Terminal Resource</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class TerminalResourceTest extends ResourceTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(TerminalResourceTest.class);
	}

	/**
	 * Constructs a new Terminal Resource test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TerminalResourceTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Terminal Resource test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected TerminalResource getFixture() {
		return (TerminalResource)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(PlatformMMFactory.eINSTANCE.createTerminalResource());
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

} //TerminalResourceTest
