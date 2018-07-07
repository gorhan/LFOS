/**
 */
package platformMM;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Resource</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link platformMM.Resource#getName <em>Name</em>}</li>
 *   <li>{@link platformMM.Resource#getExclusiveResources <em>Exclusive Resources</em>}</li>
 *   <li>{@link platformMM.Resource#getBelongs <em>Belongs</em>}</li>
 * </ul>
 *
 * @see platformMM.PlatformMMPackage#getResource()
 * @model abstract="true"
 * @generated
 */
public interface Resource extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see platformMM.PlatformMMPackage#getResource_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link platformMM.Resource#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Exclusive Resources</b></em>' reference list.
	 * The list contents are of type {@link platformMM.Resource}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Exclusive Resources</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Exclusive Resources</em>' reference list.
	 * @see platformMM.PlatformMMPackage#getResource_ExclusiveResources()
	 * @model
	 * @generated
	 */
	EList<Resource> getExclusiveResources();

	/**
	 * Returns the value of the '<em><b>Belongs</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Belongs</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Belongs</em>' reference.
	 * @see #setBelongs(ResourceType)
	 * @see platformMM.PlatformMMPackage#getResource_Belongs()
	 * @model required="true"
	 * @generated
	 */
	ResourceType getBelongs();

	/**
	 * Sets the value of the '{@link platformMM.Resource#getBelongs <em>Belongs</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Belongs</em>' reference.
	 * @see #getBelongs()
	 * @generated
	 */
	void setBelongs(ResourceType value);

} // Resource
