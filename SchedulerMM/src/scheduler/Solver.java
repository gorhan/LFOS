/**
 */
package scheduler;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Solver</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link scheduler.Solver#getTimeCutoff <em>Time Cutoff</em>}</li>
 *   <li>{@link scheduler.Solver#getVerboseLevel <em>Verbose Level</em>}</li>
 * </ul>
 *
 * @see scheduler.SchedulerPackage#getSolver()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface Solver extends EObject {
	/**
	 * Returns the value of the '<em><b>Time Cutoff</b></em>' attribute.
	 * The default value is <code>"10"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Time Cutoff</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Time Cutoff</em>' attribute.
	 * @see #setTimeCutoff(int)
	 * @see scheduler.SchedulerPackage#getSolver_TimeCutoff()
	 * @model default="10"
	 * @generated
	 */
	int getTimeCutoff();

	/**
	 * Sets the value of the '{@link scheduler.Solver#getTimeCutoff <em>Time Cutoff</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Time Cutoff</em>' attribute.
	 * @see #getTimeCutoff()
	 * @generated
	 */
	void setTimeCutoff(int value);

	/**
	 * Returns the value of the '<em><b>Verbose Level</b></em>' attribute.
	 * The default value is <code>"10"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Verbose Level</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Verbose Level</em>' attribute.
	 * @see #setVerboseLevel(int)
	 * @see scheduler.SchedulerPackage#getSolver_VerboseLevel()
	 * @model default="10"
	 * @generated
	 */
	int getVerboseLevel();

	/**
	 * Sets the value of the '{@link scheduler.Solver#getVerboseLevel <em>Verbose Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Verbose Level</em>' attribute.
	 * @see #getVerboseLevel()
	 * @generated
	 */
	void setVerboseLevel(int value);

} // Solver
