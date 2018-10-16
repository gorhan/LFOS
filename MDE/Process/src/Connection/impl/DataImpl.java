/**
 */
package Connection.impl;

import Connection.Data;
import Connection.ProcessPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Data</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link Connection.impl.DataImpl#getNo_available <em>No available</em>}</li>
 *   <li>{@link Connection.impl.DataImpl#getAlias <em>Alias</em>}</li>
 *   <li>{@link Connection.impl.DataImpl#getProducedBy <em>Produced By</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DataImpl extends MinimalEObjectImpl.Container implements Data {
	/**
	 * The default value of the '{@link #getNo_available() <em>No available</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNo_available()
	 * @generated
	 * @ordered
	 */
	protected static final int NO_AVAILABLE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getNo_available() <em>No available</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNo_available()
	 * @generated
	 * @ordered
	 */
	protected int no_available = NO_AVAILABLE_EDEFAULT;

	/**
	 * The default value of the '{@link #getAlias() <em>Alias</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAlias()
	 * @generated
	 * @ordered
	 */
	protected static final String ALIAS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAlias() <em>Alias</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAlias()
	 * @generated
	 * @ordered
	 */
	protected String alias = ALIAS_EDEFAULT;

	/**
	 * The cached value of the '{@link #getProducedBy() <em>Produced By</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProducedBy()
	 * @generated
	 * @ordered
	 */
	protected Connection.Process producedBy;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DataImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ProcessPackage.Literals.DATA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getNo_available() {
		return no_available;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNo_available(int newNo_available) {
		int oldNo_available = no_available;
		no_available = newNo_available;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.DATA__NO_AVAILABLE, oldNo_available, no_available));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAlias() {
		return alias;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAlias(String newAlias) {
		String oldAlias = alias;
		alias = newAlias;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.DATA__ALIAS, oldAlias, alias));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Connection.Process getProducedBy() {
		if (producedBy != null && producedBy.eIsProxy()) {
			InternalEObject oldProducedBy = (InternalEObject)producedBy;
			producedBy = (Connection.Process)eResolveProxy(oldProducedBy);
			if (producedBy != oldProducedBy) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ProcessPackage.DATA__PRODUCED_BY, oldProducedBy, producedBy));
			}
		}
		return producedBy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Connection.Process basicGetProducedBy() {
		return producedBy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProducedBy(Connection.Process newProducedBy) {
		Connection.Process oldProducedBy = producedBy;
		producedBy = newProducedBy;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.DATA__PRODUCED_BY, oldProducedBy, producedBy));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ProcessPackage.DATA__NO_AVAILABLE:
				return getNo_available();
			case ProcessPackage.DATA__ALIAS:
				return getAlias();
			case ProcessPackage.DATA__PRODUCED_BY:
				if (resolve) return getProducedBy();
				return basicGetProducedBy();
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
			case ProcessPackage.DATA__NO_AVAILABLE:
				setNo_available((Integer)newValue);
				return;
			case ProcessPackage.DATA__ALIAS:
				setAlias((String)newValue);
				return;
			case ProcessPackage.DATA__PRODUCED_BY:
				setProducedBy((Connection.Process)newValue);
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
			case ProcessPackage.DATA__NO_AVAILABLE:
				setNo_available(NO_AVAILABLE_EDEFAULT);
				return;
			case ProcessPackage.DATA__ALIAS:
				setAlias(ALIAS_EDEFAULT);
				return;
			case ProcessPackage.DATA__PRODUCED_BY:
				setProducedBy((Connection.Process)null);
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
			case ProcessPackage.DATA__NO_AVAILABLE:
				return no_available != NO_AVAILABLE_EDEFAULT;
			case ProcessPackage.DATA__ALIAS:
				return ALIAS_EDEFAULT == null ? alias != null : !ALIAS_EDEFAULT.equals(alias);
			case ProcessPackage.DATA__PRODUCED_BY:
				return producedBy != null;
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
		result.append(" (no_available: ");
		result.append(no_available);
		result.append(", alias: ");
		result.append(alias);
		result.append(')');
		return result.toString();
	}

} //DataImpl
