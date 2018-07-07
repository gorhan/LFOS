/**
 */
package platformMM;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Platform Diagram</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link platformMM.PlatformDiagram#getSystem <em>System</em>}</li>
 *   <li>{@link platformMM.PlatformDiagram#getResourceTypes <em>Resource Types</em>}</li>
 * </ul>
 *
 * @see platformMM.PlatformMMPackage#getPlatformDiagram()
 * @model
 * @generated
 */
public interface PlatformDiagram extends EObject {
	/**
	 * Returns the value of the '<em><b>System</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>System</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>System</em>' containment reference.
	 * @see #setSystem(CompositeResource)
	 * @see platformMM.PlatformMMPackage#getPlatformDiagram_System()
	 * @model containment="true" required="true"
	 * @generated
	 */
	CompositeResource getSystem();

	/**
	 * Sets the value of the '{@link platformMM.PlatformDiagram#getSystem <em>System</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>System</em>' containment reference.
	 * @see #getSystem()
	 * @generated
	 */
	void setSystem(CompositeResource value);

	/**
	 * Returns the value of the '<em><b>Resource Types</b></em>' containment reference list.
	 * The list contents are of type {@link platformMM.ResourceType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resource Types</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resource Types</em>' containment reference list.
	 * @see platformMM.PlatformMMPackage#getPlatformDiagram_ResourceTypes()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<ResourceType> getResourceTypes();

} // PlatformDiagram
