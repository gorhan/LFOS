/**
 */
package scheduler;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Scheduling Window</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link scheduler.SchedulingWindow#getSchedBegin <em>Sched Begin</em>}</li>
 *   <li>{@link scheduler.SchedulingWindow#getSchedDuration <em>Sched Duration</em>}</li>
 * </ul>
 *
 * @see scheduler.SchedulerPackage#getSchedulingWindow()
 * @model
 * @generated
 */
public interface SchedulingWindow extends EObject {
	/**
	 * Returns the value of the '<em><b>Sched Begin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sched Begin</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sched Begin</em>' attribute.
	 * @see #setSchedBegin(int)
	 * @see scheduler.SchedulerPackage#getSchedulingWindow_SchedBegin()
	 * @model
	 * @generated
	 */
	int getSchedBegin();

	/**
	 * Sets the value of the '{@link scheduler.SchedulingWindow#getSchedBegin <em>Sched Begin</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sched Begin</em>' attribute.
	 * @see #getSchedBegin()
	 * @generated
	 */
	void setSchedBegin(int value);

	/**
	 * Returns the value of the '<em><b>Sched Duration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sched Duration</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sched Duration</em>' attribute.
	 * @see #setSchedDuration(int)
	 * @see scheduler.SchedulerPackage#getSchedulingWindow_SchedDuration()
	 * @model
	 * @generated
	 */
	int getSchedDuration();

	/**
	 * Sets the value of the '{@link scheduler.SchedulingWindow#getSchedDuration <em>Sched Duration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sched Duration</em>' attribute.
	 * @see #getSchedDuration()
	 * @generated
	 */
	void setSchedDuration(int value);

} // SchedulingWindow
