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
 *   <li>{@link optimal.Criteria#getContribution <em>Contribution</em>}</li>
 *   <li>{@link optimal.Criteria#getFeatures <em>Features</em>}</li>
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
	 * Returns the value of the '<em><b>Contribution</b></em>' attribute.
	 * The default value is <code>"1.0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Contribution</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Contribution</em>' attribute.
	 * @see #setContribution(float)
	 * @see optimal.OptimalPackage#getCriteria_Contribution()
	 * @model default="1.0" required="true"
	 * @generated
	 */
	float getContribution();

	/**
	 * Sets the value of the '{@link optimal.Criteria#getContribution <em>Contribution</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Contribution</em>' attribute.
	 * @see #getContribution()
	 * @generated
	 */
	void setContribution(float value);

	/**
	 * Returns the value of the '<em><b>Features</b></em>' containment reference list.
	 * The list contents are of type {@link optimal.Feature}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Features</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Features</em>' containment reference list.
	 * @see optimal.OptimalPackage#getCriteria_Features()
	 * @model containment="true"
	 * @generated
	 */
	EList<Feature> getFeatures();

} // Criteria
