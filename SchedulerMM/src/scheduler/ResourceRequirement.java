/**
 */
package scheduler;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Resource Requirement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link scheduler.ResourceRequirement#getResourceRequirementItems <em>Resource Requirement Items</em>}</li>
 * </ul>
 *
 * @see scheduler.SchedulerPackage#getResourceRequirement()
 * @model
 * @generated
 */
public interface ResourceRequirement extends EObject {
	/**
	 * Returns the value of the '<em><b>Resource Requirement Items</b></em>' containment reference list.
	 * The list contents are of type {@link scheduler.ResourceRequirementItem}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resource Requirement Items</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resource Requirement Items</em>' containment reference list.
	 * @see scheduler.SchedulerPackage#getResourceRequirement_ResourceRequirementItems()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<ResourceRequirementItem> getResourceRequirementItems();

} // ResourceRequirement
