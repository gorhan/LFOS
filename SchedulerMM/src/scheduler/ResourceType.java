/**
 */
package scheduler;

import org.eclipse.emf.common.util.EList;

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
 *   <li>{@link scheduler.ResourceType#getHas <em>Has</em>}</li>
 *   <li>{@link scheduler.ResourceType#getIdentifier <em>Identifier</em>}</li>
 *   <li>{@link scheduler.ResourceType#getAbstraction <em>Abstraction</em>}</li>
 * </ul>
 *
 * @see scheduler.SchedulerPackage#getResourceType()
 * @model
 * @generated
 */
public interface ResourceType extends EObject {
	/**
	 * Returns the value of the '<em><b>Has</b></em>' reference list.
	 * The list contents are of type {@link scheduler.AbstractResource}.
	 * It is bidirectional and its opposite is '{@link scheduler.AbstractResource#getBelongs <em>Belongs</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Has</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Has</em>' reference list.
	 * @see scheduler.SchedulerPackage#getResourceType_Has()
	 * @see scheduler.AbstractResource#getBelongs
	 * @model opposite="belongs" required="true"
	 * @generated
	 */
	EList<AbstractResource> getHas();

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
	 * @see scheduler.SchedulerPackage#getResourceType_Identifier()
	 * @model
	 * @generated
	 */
	String getIdentifier();

	/**
	 * Sets the value of the '{@link scheduler.ResourceType#getIdentifier <em>Identifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Identifier</em>' attribute.
	 * @see #getIdentifier()
	 * @generated
	 */
	void setIdentifier(String value);

	/**
	 * Returns the value of the '<em><b>Abstraction</b></em>' attribute.
	 * The literals are from the enumeration {@link scheduler.ResourceAbstraction}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Abstraction</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Abstraction</em>' attribute.
	 * @see scheduler.ResourceAbstraction
	 * @see #setAbstraction(ResourceAbstraction)
	 * @see scheduler.SchedulerPackage#getResourceType_Abstraction()
	 * @model
	 * @generated
	 */
	ResourceAbstraction getAbstraction();

	/**
	 * Sets the value of the '{@link scheduler.ResourceType#getAbstraction <em>Abstraction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Abstraction</em>' attribute.
	 * @see scheduler.ResourceAbstraction
	 * @see #getAbstraction()
	 * @generated
	 */
	void setAbstraction(ResourceAbstraction value);

} // ResourceType
