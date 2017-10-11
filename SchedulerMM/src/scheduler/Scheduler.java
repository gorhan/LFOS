/**
 */
package scheduler;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Scheduler</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link scheduler.Scheduler#getTaskset <em>Taskset</em>}</li>
 *   <li>{@link scheduler.Scheduler#getSystem <em>System</em>}</li>
 *   <li>{@link scheduler.Scheduler#getName <em>Name</em>}</li>
 *   <li>{@link scheduler.Scheduler#getResourceTypes <em>Resource Types</em>}</li>
 *   <li>{@link scheduler.Scheduler#getTokenPool <em>Token Pool</em>}</li>
 * </ul>
 *
 * @see scheduler.SchedulerPackage#getScheduler()
 * @model
 * @generated
 */
public interface Scheduler extends SchedulingCharacteristic, SchedulingStrategy {
	/**
	 * Returns the value of the '<em><b>Taskset</b></em>' containment reference list.
	 * The list contents are of type {@link scheduler.AbstractTask}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Taskset</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Taskset</em>' containment reference list.
	 * @see scheduler.SchedulerPackage#getScheduler_Taskset()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<AbstractTask> getTaskset();

	/**
	 * Returns the value of the '<em><b>System</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>System</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>System</em>' containment reference.
	 * @see #setSystem(ResourceC)
	 * @see scheduler.SchedulerPackage#getScheduler_System()
	 * @model containment="true" required="true"
	 * @generated
	 */
	ResourceC getSystem();

	/**
	 * Sets the value of the '{@link scheduler.Scheduler#getSystem <em>System</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>System</em>' containment reference.
	 * @see #getSystem()
	 * @generated
	 */
	void setSystem(ResourceC value);

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
	 * @see scheduler.SchedulerPackage#getScheduler_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link scheduler.Scheduler#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Resource Types</b></em>' containment reference list.
	 * The list contents are of type {@link scheduler.ResourceType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resource Types</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resource Types</em>' containment reference list.
	 * @see scheduler.SchedulerPackage#getScheduler_ResourceTypes()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<ResourceType> getResourceTypes();

	/**
	 * Returns the value of the '<em><b>Token Pool</b></em>' containment reference list.
	 * The list contents are of type {@link scheduler.Token}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Token Pool</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Token Pool</em>' containment reference list.
	 * @see scheduler.SchedulerPackage#getScheduler_TokenPool()
	 * @model containment="true"
	 * @generated
	 */
	EList<Token> getTokenPool();

} // Scheduler
