/**
 */
package platformMM.tests;

import junit.textui.TestRunner;

import platformMM.CompositeResource;
import platformMM.PlatformMMFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Composite Resource</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class CompositeResourceTest extends ResourceTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(CompositeResourceTest.class);
	}

	/**
	 * Constructs a new Composite Resource test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompositeResourceTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Composite Resource test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected CompositeResource getFixture() {
		return (CompositeResource)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(PlatformMMFactory.eINSTANCE.createCompositeResource());
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

} //CompositeResourceTest
