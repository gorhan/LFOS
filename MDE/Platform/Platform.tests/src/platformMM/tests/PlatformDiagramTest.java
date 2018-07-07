/**
 */
package platformMM.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import platformMM.PlatformDiagram;
import platformMM.PlatformMMFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Platform Diagram</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class PlatformDiagramTest extends TestCase {

	/**
	 * The fixture for this Platform Diagram test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PlatformDiagram fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(PlatformDiagramTest.class);
	}

	/**
	 * Constructs a new Platform Diagram test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PlatformDiagramTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Platform Diagram test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(PlatformDiagram fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Platform Diagram test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PlatformDiagram getFixture() {
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
		setFixture(PlatformMMFactory.eINSTANCE.createPlatformDiagram());
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

} //PlatformDiagramTest
