/**
 */
package scheduler;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Task C</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link scheduler.TaskC#getSubTasks <em>Sub Tasks</em>}</li>
 * </ul>
 *
 * @see scheduler.SchedulerPackage#getTaskC()
 * @model
 * @generated
 */
public interface TaskC extends AbstractTask {
	/**
	 * Returns the value of the '<em><b>Sub Tasks</b></em>' containment reference list.
	 * The list contents are of type {@link scheduler.AbstractTask}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sub Tasks</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sub Tasks</em>' containment reference list.
	 * @see scheduler.SchedulerPackage#getTaskC_SubTasks()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<AbstractTask> getSubTasks();

} // TaskC
