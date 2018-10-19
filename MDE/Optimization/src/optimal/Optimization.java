/**
 */
package optimal;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Optimization</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link optimal.Optimization#getCriteria <em>Criteria</em>}</li>
 * </ul>
 *
 * @see optimal.OptimalPackage#getOptimization()
 * @model
 * @generated
 */
public interface Optimization extends EObject {
	/**
	 * Returns the value of the '<em><b>Criteria</b></em>' containment reference list.
	 * The list contents are of type {@link optimal.Criteria}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Criteria</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Criteria</em>' containment reference list.
	 * @see optimal.OptimalPackage#getOptimization_Criteria()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Criteria> getCriteria();

} // Optimization
