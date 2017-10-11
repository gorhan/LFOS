/**
 */
package scheduler;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Resource Requirement Item</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link scheduler.ResourceRequirementItem#getRequiredCapacity <em>Required Capacity</em>}</li>
 *   <li>{@link scheduler.ResourceRequirementItem#getEligibleResourceItem <em>Eligible Resource Item</em>}</li>
 *   <li>{@link scheduler.ResourceRequirementItem#getRequiredResourceType <em>Required Resource Type</em>}</li>
 * </ul>
 *
 * @see scheduler.SchedulerPackage#getResourceRequirementItem()
 * @model
 * @generated
 */
public interface ResourceRequirementItem extends EObject {
	/**
	 * Returns the value of the '<em><b>Required Capacity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Required Capacity</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Required Capacity</em>' attribute.
	 * @see #setRequiredCapacity(int)
	 * @see scheduler.SchedulerPackage#getResourceRequirementItem_RequiredCapacity()
	 * @model
	 * @generated
	 */
	int getRequiredCapacity();

	/**
	 * Sets the value of the '{@link scheduler.ResourceRequirementItem#getRequiredCapacity <em>Required Capacity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Required Capacity</em>' attribute.
	 * @see #getRequiredCapacity()
	 * @generated
	 */
	void setRequiredCapacity(int value);

	/**
	 * Returns the value of the '<em><b>Eligible Resource Item</b></em>' containment reference list.
	 * The list contents are of type {@link scheduler.EligibleResource}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Eligible Resource Item</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Eligible Resource Item</em>' containment reference list.
	 * @see scheduler.SchedulerPackage#getResourceRequirementItem_EligibleResourceItem()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<EligibleResource> getEligibleResourceItem();

	/**
	 * Returns the value of the '<em><b>Required Resource Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Required Resource Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Required Resource Type</em>' reference.
	 * @see #setRequiredResourceType(ResourceType)
	 * @see scheduler.SchedulerPackage#getResourceRequirementItem_RequiredResourceType()
	 * @model required="true"
	 * @generated
	 */
	ResourceType getRequiredResourceType();

	/**
	 * Sets the value of the '{@link scheduler.ResourceRequirementItem#getRequiredResourceType <em>Required Resource Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Required Resource Type</em>' reference.
	 * @see #getRequiredResourceType()
	 * @generated
	 */
	void setRequiredResourceType(ResourceType value);

} // ResourceRequirementItem
