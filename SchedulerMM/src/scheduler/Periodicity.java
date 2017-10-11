/**
 */
package scheduler;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Periodicity</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link scheduler.Periodicity#getPeriodType <em>Period Type</em>}</li>
 *   <li>{@link scheduler.Periodicity#getPeriod <em>Period</em>}</li>
 * </ul>
 *
 * @see scheduler.SchedulerPackage#getPeriodicity()
 * @model
 * @generated
 */
public interface Periodicity extends EObject {
	/**
	 * Returns the value of the '<em><b>Period Type</b></em>' attribute.
	 * The literals are from the enumeration {@link scheduler.PeriodicityType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Period Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Period Type</em>' attribute.
	 * @see scheduler.PeriodicityType
	 * @see #setPeriodType(PeriodicityType)
	 * @see scheduler.SchedulerPackage#getPeriodicity_PeriodType()
	 * @model required="true"
	 * @generated
	 */
	PeriodicityType getPeriodType();

	/**
	 * Sets the value of the '{@link scheduler.Periodicity#getPeriodType <em>Period Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Period Type</em>' attribute.
	 * @see scheduler.PeriodicityType
	 * @see #getPeriodType()
	 * @generated
	 */
	void setPeriodType(PeriodicityType value);

	/**
	 * Returns the value of the '<em><b>Period</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Period</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Period</em>' attribute.
	 * @see #setPeriod(int)
	 * @see scheduler.SchedulerPackage#getPeriodicity_Period()
	 * @model
	 * @generated
	 */
	int getPeriod();

	/**
	 * Sets the value of the '{@link scheduler.Periodicity#getPeriod <em>Period</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Period</em>' attribute.
	 * @see #getPeriod()
	 * @generated
	 */
	void setPeriod(int value);

} // Periodicity
