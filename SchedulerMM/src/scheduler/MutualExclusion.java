/**
 */
package scheduler;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mutual Exclusion</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link scheduler.MutualExclusion#getMutexTask <em>Mutex Task</em>}</li>
 * </ul>
 *
 * @see scheduler.SchedulerPackage#getMutualExclusion()
 * @model
 * @generated
 */
public interface MutualExclusion extends EObject {
	/**
	 * Returns the value of the '<em><b>Mutex Task</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mutex Task</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mutex Task</em>' reference.
	 * @see #setMutexTask(AbstractTask)
	 * @see scheduler.SchedulerPackage#getMutualExclusion_MutexTask()
	 * @model required="true"
	 * @generated
	 */
	AbstractTask getMutexTask();

	/**
	 * Sets the value of the '{@link scheduler.MutualExclusion#getMutexTask <em>Mutex Task</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mutex Task</em>' reference.
	 * @see #getMutexTask()
	 * @generated
	 */
	void setMutexTask(AbstractTask value);

} // MutualExclusion
