/**
 */
package scheduler;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Preemption</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link scheduler.Preemption#getPmtnType <em>Pmtn Type</em>}</li>
 *   <li>{@link scheduler.Preemption#getNInterruptableDuration <em>NInterruptable Duration</em>}</li>
 * </ul>
 *
 * @see scheduler.SchedulerPackage#getPreemption()
 * @model
 * @generated
 */
public interface Preemption extends EObject {
	/**
	 * Returns the value of the '<em><b>Pmtn Type</b></em>' attribute.
	 * The literals are from the enumeration {@link scheduler.PreemptionType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pmtn Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pmtn Type</em>' attribute.
	 * @see scheduler.PreemptionType
	 * @see #setPmtnType(PreemptionType)
	 * @see scheduler.SchedulerPackage#getPreemption_PmtnType()
	 * @model required="true"
	 * @generated
	 */
	PreemptionType getPmtnType();

	/**
	 * Sets the value of the '{@link scheduler.Preemption#getPmtnType <em>Pmtn Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pmtn Type</em>' attribute.
	 * @see scheduler.PreemptionType
	 * @see #getPmtnType()
	 * @generated
	 */
	void setPmtnType(PreemptionType value);

	/**
	 * Returns the value of the '<em><b>NInterruptable Duration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>NInterruptable Duration</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>NInterruptable Duration</em>' attribute.
	 * @see #setNInterruptableDuration(int)
	 * @see scheduler.SchedulerPackage#getPreemption_NInterruptableDuration()
	 * @model
	 * @generated
	 */
	int getNInterruptableDuration();

	/**
	 * Sets the value of the '{@link scheduler.Preemption#getNInterruptableDuration <em>NInterruptable Duration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>NInterruptable Duration</em>' attribute.
	 * @see #getNInterruptableDuration()
	 * @generated
	 */
	void setNInterruptableDuration(int value);

} // Preemption
