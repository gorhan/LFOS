/**
 */
package platformMM.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import platformMM.PlatformMMFactory;
import platformMM.ResourceType;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Resource Type</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class ResourceTypeTest extends TestCase {

	/**
	 * The fixture for this Resource Type test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ResourceType fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(ResourceTypeTest.class);
	}

	/**
	 * Constructs a new Resource Type test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceTypeTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Resource Type test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(ResourceType fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Resource Type test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ResourceType getFixture() {
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
		setFixture(PlatformMMFactory.eINSTANCE.createResourceType());
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

} //ResourceTypeTest
