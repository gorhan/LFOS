/**
 */
package scheduler;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Scheduling Strategy</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link scheduler.SchedulingStrategy#getOutput <em>Output</em>}</li>
 *   <li>{@link scheduler.SchedulingStrategy#getSolvers <em>Solvers</em>}</li>
 * </ul>
 *
 * @see scheduler.SchedulerPackage#getSchedulingStrategy()
 * @model
 * @generated
 */
public interface SchedulingStrategy extends EObject {
	/**
	 * Returns the value of the '<em><b>Output</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output</em>' containment reference.
	 * @see #setOutput(Output)
	 * @see scheduler.SchedulerPackage#getSchedulingStrategy_Output()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Output getOutput();

	/**
	 * Sets the value of the '{@link scheduler.SchedulingStrategy#getOutput <em>Output</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Output</em>' containment reference.
	 * @see #getOutput()
	 * @generated
	 */
	void setOutput(Output value);

	/**
	 * Returns the value of the '<em><b>Solvers</b></em>' containment reference list.
	 * The list contents are of type {@link scheduler.Solver}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Solvers</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Solvers</em>' containment reference list.
	 * @see scheduler.SchedulerPackage#getSchedulingStrategy_Solvers()
	 * @model containment="true"
	 * @generated
	 */
	EList<Solver> getSolvers();

} // SchedulingStrategy
