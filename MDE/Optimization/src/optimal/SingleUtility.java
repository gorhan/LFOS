/**
 */
package optimal;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Single Utility</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link optimal.SingleUtility#getBound <em>Bound</em>}</li>
 *   <li>{@link optimal.SingleUtility#getPoints <em>Points</em>}</li>
 *   <li>{@link optimal.SingleUtility#getUnbound <em>Unbound</em>}</li>
 * </ul>
 *
 * @see optimal.OptimalPackage#getSingleUtility()
 * @model
 * @generated
 */
public interface SingleUtility extends EObject {
	/**
	 * Returns the value of the '<em><b>Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bound</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bound</em>' attribute.
	 * @see #setBound(float)
	 * @see optimal.OptimalPackage#getSingleUtility_Bound()
	 * @model
	 * @generated
	 */
	float getBound();

	/**
	 * Sets the value of the '{@link optimal.SingleUtility#getBound <em>Bound</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bound</em>' attribute.
	 * @see #getBound()
	 * @generated
	 */
	void setBound(float value);

	/**
	 * Returns the value of the '<em><b>Points</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Points</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Points</em>' reference.
	 * @see #setPoints(Feature)
	 * @see optimal.OptimalPackage#getSingleUtility_Points()
	 * @model required="true"
	 * @generated
	 */
	Feature getPoints();

	/**
	 * Sets the value of the '{@link optimal.SingleUtility#getPoints <em>Points</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Points</em>' reference.
	 * @see #getPoints()
	 * @generated
	 */
	void setPoints(Feature value);

	/**
	 * Returns the value of the '<em><b>Unbound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unbound</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unbound</em>' attribute.
	 * @see #setUnbound(float)
	 * @see optimal.OptimalPackage#getSingleUtility_Unbound()
	 * @model
	 * @generated
	 */
	float getUnbound();

	/**
	 * Sets the value of the '{@link optimal.SingleUtility#getUnbound <em>Unbound</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unbound</em>' attribute.
	 * @see #getUnbound()
	 * @generated
	 */
	void setUnbound(float value);

} // SingleUtility
