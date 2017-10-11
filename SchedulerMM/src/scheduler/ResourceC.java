/**
 */
package scheduler;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Resource C</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link scheduler.ResourceC#getSubResources <em>Sub Resources</em>}</li>
 * </ul>
 *
 * @see scheduler.SchedulerPackage#getResourceC()
 * @model
 * @generated
 */
public interface ResourceC extends AbstractResource {
	/**
	 * Returns the value of the '<em><b>Sub Resources</b></em>' containment reference list.
	 * The list contents are of type {@link scheduler.AbstractResource}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sub Resources</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sub Resources</em>' containment reference list.
	 * @see scheduler.SchedulerPackage#getResourceC_SubResources()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<AbstractResource> getSubResources();

} // ResourceC
