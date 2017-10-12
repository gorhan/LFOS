/**
 */
package scheduler.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import scheduler.DependencyItem;
import scheduler.SchedulerPackage;
import scheduler.Token;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Dependency Item</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link scheduler.impl.DependencyItemImpl#getNumTokens <em>Num Tokens</em>}</li>
 *   <li>{@link scheduler.impl.DependencyItemImpl#getSetupTime <em>Setup Time</em>}</li>
 *   <li>{@link scheduler.impl.DependencyItemImpl#getToken <em>Token</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DependencyItemImpl extends MinimalEObjectImpl.Container implements DependencyItem {
	/**
	 * The default value of the '{@link #getNumTokens() <em>Num Tokens</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumTokens()
	 * @generated
	 * @ordered
	 */
	protected static final int NUM_TOKENS_EDEFAULT = 1;

	/**
	 * The cached value of the '{@link #getNumTokens() <em>Num Tokens</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumTokens()
	 * @generated
	 * @ordered
	 */
	protected int numTokens = NUM_TOKENS_EDEFAULT;

	/**
	 * The default value of the '{@link #getSetupTime() <em>Setup Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSetupTime()
	 * @generated
	 * @ordered
	 */
	protected static final int SETUP_TIME_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getSetupTime() <em>Setup Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSetupTime()
	 * @generated
	 * @ordered
	 */
	protected int setupTime = SETUP_TIME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getToken() <em>Token</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getToken()
	 * @generated
	 * @ordered
	 */
	protected Token token;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DependencyItemImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SchedulerPackage.Literals.DEPENDENCY_ITEM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getNumTokens() {
		return numTokens;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNumTokens(int newNumTokens) {
		int oldNumTokens = numTokens;
		numTokens = newNumTokens;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SchedulerPackage.DEPENDENCY_ITEM__NUM_TOKENS, oldNumTokens, numTokens));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getSetupTime() {
		return setupTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSetupTime(int newSetupTime) {
		int oldSetupTime = setupTime;
		setupTime = newSetupTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SchedulerPackage.DEPENDENCY_ITEM__SETUP_TIME, oldSetupTime, setupTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Token getToken() {
		if (token != null && token.eIsProxy()) {
			InternalEObject oldToken = (InternalEObject)token;
			token = (Token)eResolveProxy(oldToken);
			if (token != oldToken) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SchedulerPackage.DEPENDENCY_ITEM__TOKEN, oldToken, token));
			}
		}
		return token;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Token basicGetToken() {
		return token;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setToken(Token newToken) {
		Token oldToken = token;
		token = newToken;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SchedulerPackage.DEPENDENCY_ITEM__TOKEN, oldToken, token));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SchedulerPackage.DEPENDENCY_ITEM__NUM_TOKENS:
				return getNumTokens();
			case SchedulerPackage.DEPENDENCY_ITEM__SETUP_TIME:
				return getSetupTime();
			case SchedulerPackage.DEPENDENCY_ITEM__TOKEN:
				if (resolve) return getToken();
				return basicGetToken();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case SchedulerPackage.DEPENDENCY_ITEM__NUM_TOKENS:
				setNumTokens((Integer)newValue);
				return;
			case SchedulerPackage.DEPENDENCY_ITEM__SETUP_TIME:
				setSetupTime((Integer)newValue);
				return;
			case SchedulerPackage.DEPENDENCY_ITEM__TOKEN:
				setToken((Token)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case SchedulerPackage.DEPENDENCY_ITEM__NUM_TOKENS:
				setNumTokens(NUM_TOKENS_EDEFAULT);
				return;
			case SchedulerPackage.DEPENDENCY_ITEM__SETUP_TIME:
				setSetupTime(SETUP_TIME_EDEFAULT);
				return;
			case SchedulerPackage.DEPENDENCY_ITEM__TOKEN:
				setToken((Token)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case SchedulerPackage.DEPENDENCY_ITEM__NUM_TOKENS:
				return numTokens != NUM_TOKENS_EDEFAULT;
			case SchedulerPackage.DEPENDENCY_ITEM__SETUP_TIME:
				return setupTime != SETUP_TIME_EDEFAULT;
			case SchedulerPackage.DEPENDENCY_ITEM__TOKEN:
				return token != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (numTokens: ");
		result.append(numTokens);
		result.append(", setupTime: ");
		result.append(setupTime);
		result.append(')');
		return result.toString();
	}

} //DependencyItemImpl
