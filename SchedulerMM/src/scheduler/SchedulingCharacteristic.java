/**
 */
package scheduler;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Scheduling Characteristic</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link scheduler.SchedulingCharacteristic#getSchedType <em>Sched Type</em>}</li>
 *   <li>{@link scheduler.SchedulingCharacteristic#isPreemptive <em>Preemptive</em>}</li>
 *   <li>{@link scheduler.SchedulingCharacteristic#getMigration <em>Migration</em>}</li>
 *   <li>{@link scheduler.SchedulingCharacteristic#getPriorityAssignment <em>Priority Assignment</em>}</li>
 *   <li>{@link scheduler.SchedulingCharacteristic#getObjectives <em>Objectives</em>}</li>
 * </ul>
 *
 * @see scheduler.SchedulerPackage#getSchedulingCharacteristic()
 * @model
 * @generated
 */
public interface SchedulingCharacteristic extends SchedulingWindow, SchedulingPolicy {
	/**
	 * Returns the value of the '<em><b>Sched Type</b></em>' attribute.
	 * The literals are from the enumeration {@link scheduler.SchedulingType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sched Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sched Type</em>' attribute.
	 * @see scheduler.SchedulingType
	 * @see #setSchedType(SchedulingType)
	 * @see scheduler.SchedulerPackage#getSchedulingCharacteristic_SchedType()
	 * @model required="true"
	 * @generated
	 */
	SchedulingType getSchedType();

	/**
	 * Sets the value of the '{@link scheduler.SchedulingCharacteristic#getSchedType <em>Sched Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sched Type</em>' attribute.
	 * @see scheduler.SchedulingType
	 * @see #getSchedType()
	 * @generated
	 */
	void setSchedType(SchedulingType value);

	/**
	 * Returns the value of the '<em><b>Preemptive</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Preemptive</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Preemptive</em>' attribute.
	 * @see #setPreemptive(boolean)
	 * @see scheduler.SchedulerPackage#getSchedulingCharacteristic_Preemptive()
	 * @model default="true" required="true"
	 * @generated
	 */
	boolean isPreemptive();

	/**
	 * Sets the value of the '{@link scheduler.SchedulingCharacteristic#isPreemptive <em>Preemptive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Preemptive</em>' attribute.
	 * @see #isPreemptive()
	 * @generated
	 */
	void setPreemptive(boolean value);

	/**
	 * Returns the value of the '<em><b>Migration</b></em>' attribute.
	 * The literals are from the enumeration {@link scheduler.MigrationType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Migration</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Migration</em>' attribute.
	 * @see scheduler.MigrationType
	 * @see #setMigration(MigrationType)
	 * @see scheduler.SchedulerPackage#getSchedulingCharacteristic_Migration()
	 * @model required="true"
	 * @generated
	 */
	MigrationType getMigration();

	/**
	 * Sets the value of the '{@link scheduler.SchedulingCharacteristic#getMigration <em>Migration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Migration</em>' attribute.
	 * @see scheduler.MigrationType
	 * @see #getMigration()
	 * @generated
	 */
	void setMigration(MigrationType value);

	/**
	 * Returns the value of the '<em><b>Priority Assignment</b></em>' attribute.
	 * The literals are from the enumeration {@link scheduler.PriorityAssignmentType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Priority Assignment</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Priority Assignment</em>' attribute.
	 * @see scheduler.PriorityAssignmentType
	 * @see #setPriorityAssignment(PriorityAssignmentType)
	 * @see scheduler.SchedulerPackage#getSchedulingCharacteristic_PriorityAssignment()
	 * @model required="true"
	 * @generated
	 */
	PriorityAssignmentType getPriorityAssignment();

	/**
	 * Sets the value of the '{@link scheduler.SchedulingCharacteristic#getPriorityAssignment <em>Priority Assignment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Priority Assignment</em>' attribute.
	 * @see scheduler.PriorityAssignmentType
	 * @see #getPriorityAssignment()
	 * @generated
	 */
	void setPriorityAssignment(PriorityAssignmentType value);

	/**
	 * Returns the value of the '<em><b>Objectives</b></em>' containment reference list.
	 * The list contents are of type {@link scheduler.Objective}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Objectives</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Objectives</em>' containment reference list.
	 * @see scheduler.SchedulerPackage#getSchedulingCharacteristic_Objectives()
	 * @model containment="true"
	 * @generated
	 */
	EList<Objective> getObjectives();

} // SchedulingCharacteristic
