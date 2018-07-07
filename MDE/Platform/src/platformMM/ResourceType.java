/**
 */
package platformMM;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Resource Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link platformMM.ResourceType#getIdentifier <em>Identifier</em>}</li>
 *   <li>{@link platformMM.ResourceType#getAbstraction <em>Abstraction</em>}</li>
 * </ul>
 *
 * @see platformMM.PlatformMMPackage#getResourceType()
 * @model
 * @generated
 */
public interface ResourceType extends EObject {
	/**
	 * Returns the value of the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Identifier</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Identifier</em>' attribute.
	 * @see #setIdentifier(String)
	 * @see platformMM.PlatformMMPackage#getResourceType_Identifier()
	 * @model
	 * @generated
	 */
	String getIdentifier();

	/**
	 * Sets the value of the '{@link platformMM.ResourceType#getIdentifier <em>Identifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Identifier</em>' attribute.
	 * @see #getIdentifier()
	 * @generated
	 */
	void setIdentifier(String value);

	/**
	 * Returns the value of the '<em><b>Abstraction</b></em>' attribute.
	 * The literals are from the enumeration {@link platformMM.ResourceAbstraction}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Abstraction</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Abstraction</em>' attribute.
	 * @see platformMM.ResourceAbstraction
	 * @see #setAbstraction(ResourceAbstraction)
	 * @see platformMM.PlatformMMPackage#getResourceType_Abstraction()
	 * @model
	 * @generated
	 */
	ResourceAbstraction getAbstraction();

	/**
	 * Sets the value of the '{@link platformMM.ResourceType#getAbstraction <em>Abstraction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Abstraction</em>' attribute.
	 * @see platformMM.ResourceAbstraction
	 * @see #getAbstraction()
	 * @generated
	 */
	void setAbstraction(ResourceAbstraction value);

} // ResourceType
