/**
 */
package scheduler;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Dependency Item</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link scheduler.DependencyItem#getNumTokens <em>Num Tokens</em>}</li>
 *   <li>{@link scheduler.DependencyItem#getToken <em>Token</em>}</li>
 *   <li>{@link scheduler.DependencyItem#getSetupTime <em>Setup Time</em>}</li>
 * </ul>
 *
 * @see scheduler.SchedulerPackage#getDependencyItem()
 * @model
 * @generated
 */
public interface DependencyItem extends EObject {
	/**
	 * Returns the value of the '<em><b>Num Tokens</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Num Tokens</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Num Tokens</em>' attribute.
	 * @see #setNumTokens(int)
	 * @see scheduler.SchedulerPackage#getDependencyItem_NumTokens()
	 * @model
	 * @generated
	 */
	int getNumTokens();

	/**
	 * Sets the value of the '{@link scheduler.DependencyItem#getNumTokens <em>Num Tokens</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Num Tokens</em>' attribute.
	 * @see #getNumTokens()
	 * @generated
	 */
	void setNumTokens(int value);

	/**
	 * Returns the value of the '<em><b>Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Token</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Token</em>' attribute.
	 * @see #setToken(String)
	 * @see scheduler.SchedulerPackage#getDependencyItem_Token()
	 * @model
	 * @generated
	 */
	String getToken();

	/**
	 * Sets the value of the '{@link scheduler.DependencyItem#getToken <em>Token</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Token</em>' attribute.
	 * @see #getToken()
	 * @generated
	 */
	void setToken(String value);

	/**
	 * Returns the value of the '<em><b>Setup Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Setup Time</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Setup Time</em>' attribute.
	 * @see #setSetupTime(int)
	 * @see scheduler.SchedulerPackage#getDependencyItem_SetupTime()
	 * @model
	 * @generated
	 */
	int getSetupTime();

	/**
	 * Sets the value of the '{@link scheduler.DependencyItem#getSetupTime <em>Setup Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Setup Time</em>' attribute.
	 * @see #getSetupTime()
	 * @generated
	 */
	void setSetupTime(int value);

} // DependencyItem
