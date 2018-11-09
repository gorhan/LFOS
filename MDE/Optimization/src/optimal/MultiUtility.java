/**
 */
package optimal;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Multi Utility</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link optimal.MultiUtility#getFeatures <em>Features</em>}</li>
 *   <li>{@link optimal.MultiUtility#getContribution <em>Contribution</em>}</li>
 * </ul>
 *
 * @see optimal.OptimalPackage#getMultiUtility()
 * @model
 * @generated
 */
public interface MultiUtility extends EObject {
	/**
	 * Returns the value of the '<em><b>Features</b></em>' reference list.
	 * The list contents are of type {@link optimal.Feature}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Features</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Features</em>' reference list.
	 * @see optimal.OptimalPackage#getMultiUtility_Features()
	 * @model lower="2"
	 * @generated
	 */
	EList<Feature> getFeatures();

	/**
	 * Returns the value of the '<em><b>Contribution</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Contribution</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Contribution</em>' attribute.
	 * @see #setContribution(float)
	 * @see optimal.OptimalPackage#getMultiUtility_Contribution()
	 * @model required="true"
	 * @generated
	 */
	float getContribution();

	/**
	 * Sets the value of the '{@link optimal.MultiUtility#getContribution <em>Contribution</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Contribution</em>' attribute.
	 * @see #getContribution()
	 * @generated
	 */
	void setContribution(float value);

} // MultiUtility
