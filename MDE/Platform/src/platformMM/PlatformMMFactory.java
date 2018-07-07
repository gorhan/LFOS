/**
 */
package platformMM;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see platformMM.PlatformMMPackage
 * @generated
 */
public interface PlatformMMFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	PlatformMMFactory eINSTANCE = platformMM.impl.PlatformMMFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Terminal Resource</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Terminal Resource</em>'.
	 * @generated
	 */
	TerminalResource createTerminalResource();

	/**
	 * Returns a new object of class '<em>Composite Resource</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Composite Resource</em>'.
	 * @generated
	 */
	CompositeResource createCompositeResource();

	/**
	 * Returns a new object of class '<em>State DVS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>State DVS</em>'.
	 * @generated
	 */
	StateDVS createStateDVS();

	/**
	 * Returns a new object of class '<em>Resource Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Resource Type</em>'.
	 * @generated
	 */
	ResourceType createResourceType();

	/**
	 * Returns a new object of class '<em>Platform Diagram</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Platform Diagram</em>'.
	 * @generated
	 */
	PlatformDiagram createPlatformDiagram();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	PlatformMMPackage getPlatformMMPackage();

} //PlatformMMFactory
