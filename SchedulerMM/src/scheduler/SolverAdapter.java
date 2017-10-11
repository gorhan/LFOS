/**
 */
package scheduler;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Solver Adapter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link scheduler.SolverAdapter#getSolvers <em>Solvers</em>}</li>
 * </ul>
 *
 * @see scheduler.SchedulerPackage#getSolverAdapter()
 * @model
 * @generated
 */
public interface SolverAdapter extends EObject {
	/**
	 * Returns the value of the '<em><b>Solvers</b></em>' containment reference list.
	 * The list contents are of type {@link scheduler.NumberJack}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Solvers</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Solvers</em>' containment reference list.
	 * @see scheduler.SchedulerPackage#getSolverAdapter_Solvers()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<NumberJack> getSolvers();

} // SolverAdapter
