/**
 */
package optimal;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Criteria</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link optimal.Criteria#getName <em>Name</em>}</li>
 *   <li>{@link optimal.Criteria#getPurpose <em>Purpose</em>}</li>
 *   <li>{@link optimal.Criteria#getDefault <em>Default</em>}</li>
 *   <li>{@link optimal.Criteria#getMultiutility <em>Multiutility</em>}</li>
 *   <li>{@link optimal.Criteria#getSingleutility <em>Singleutility</em>}</li>
 *   <li>{@link optimal.Criteria#getPercentage <em>Percentage</em>}</li>
 * </ul>
 *
 * @see optimal.OptimalPackage#getCriteria()
 * @model
 * @generated
 */
public interface Criteria extends EObject {
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
	 * @see optimal.OptimalPackage#getCriteria_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link optimal.Criteria#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Purpose</b></em>' attribute.
	 * The literals are from the enumeration {@link optimal.Purpose}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Purpose</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Purpose</em>' attribute.
	 * @see optimal.Purpose
	 * @see #setPurpose(Purpose)
	 * @see optimal.OptimalPackage#getCriteria_Purpose()
	 * @model required="true"
	 * @generated
	 */
	Purpose getPurpose();

	/**
	 * Sets the value of the '{@link optimal.Criteria#getPurpose <em>Purpose</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Purpose</em>' attribute.
	 * @see optimal.Purpose
	 * @see #getPurpose()
	 * @generated
	 */
	void setPurpose(Purpose value);

	/**
	 * Returns the value of the '<em><b>Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default</em>' attribute.
	 * @see #setDefault(float)
	 * @see optimal.OptimalPackage#getCriteria_Default()
	 * @model required="true"
	 * @generated
	 */
	float getDefault();

	/**
	 * Sets the value of the '{@link optimal.Criteria#getDefault <em>Default</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default</em>' attribute.
	 * @see #getDefault()
	 * @generated
	 */
	void setDefault(float value);

	/**
	 * Returns the value of the '<em><b>Multiutility</b></em>' containment reference list.
	 * The list contents are of type {@link optimal.MultiUtility}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Multiutility</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Multiutility</em>' containment reference list.
	 * @see optimal.OptimalPackage#getCriteria_Multiutility()
	 * @model containment="true"
	 * @generated
	 */
	EList<MultiUtility> getMultiutility();

	/**
	 * Returns the value of the '<em><b>Singleutility</b></em>' containment reference list.
	 * The list contents are of type {@link optimal.SingleUtility}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Singleutility</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Singleutility</em>' containment reference list.
	 * @see optimal.OptimalPackage#getCriteria_Singleutility()
	 * @model containment="true"
	 * @generated
	 */
	EList<SingleUtility> getSingleutility();

	/**
	 * Returns the value of the '<em><b>Percentage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Percentage</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Percentage</em>' attribute.
	 * @see #setPercentage(float)
	 * @see optimal.OptimalPackage#getCriteria_Percentage()
	 * @model required="true"
	 * @generated
	 */
	float getPercentage();

	/**
	 * Sets the value of the '{@link optimal.Criteria#getPercentage <em>Percentage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Percentage</em>' attribute.
	 * @see #getPercentage()
	 * @generated
	 */
	void setPercentage(float value);

} // Criteria
