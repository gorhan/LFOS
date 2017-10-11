/**
 */
package scheduler.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import scheduler.AbstractTask;
import scheduler.NumberJack;
import scheduler.Output;
import scheduler.ResourceC;
import scheduler.ResourceType;
import scheduler.Scheduler;
import scheduler.SchedulerPackage;
import scheduler.SchedulingStrategy;
import scheduler.SolverAdapter;
import scheduler.Token;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Scheduler</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link scheduler.impl.SchedulerImpl#getSolvers <em>Solvers</em>}</li>
 *   <li>{@link scheduler.impl.SchedulerImpl#getTaskset <em>Taskset</em>}</li>
 *   <li>{@link scheduler.impl.SchedulerImpl#getSystem <em>System</em>}</li>
 *   <li>{@link scheduler.impl.SchedulerImpl#getName <em>Name</em>}</li>
 *   <li>{@link scheduler.impl.SchedulerImpl#getResourceTypes <em>Resource Types</em>}</li>
 *   <li>{@link scheduler.impl.SchedulerImpl#getTokenPool <em>Token Pool</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SchedulerImpl extends SchedulingCharacteristicImpl implements Scheduler {
	/**
	 * The cached value of the '{@link #getSolvers() <em>Solvers</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSolvers()
	 * @generated
	 * @ordered
	 */
	protected EList<NumberJack> solvers;

	/**
	 * The cached value of the '{@link #getTaskset() <em>Taskset</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTaskset()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractTask> taskset;

	/**
	 * The cached value of the '{@link #getSystem() <em>System</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSystem()
	 * @generated
	 * @ordered
	 */
	protected ResourceC system;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getResourceTypes() <em>Resource Types</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResourceTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<ResourceType> resourceTypes;

	/**
	 * The cached value of the '{@link #getTokenPool() <em>Token Pool</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTokenPool()
	 * @generated
	 * @ordered
	 */
	protected EList<Token> tokenPool;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SchedulerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SchedulerPackage.Literals.SCHEDULER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NumberJack> getSolvers() {
		if (solvers == null) {
			solvers = new EObjectContainmentEList<NumberJack>(NumberJack.class, this, SchedulerPackage.SCHEDULER__SOLVERS);
		}
		return solvers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AbstractTask> getTaskset() {
		if (taskset == null) {
			taskset = new EObjectContainmentEList<AbstractTask>(AbstractTask.class, this, SchedulerPackage.SCHEDULER__TASKSET);
		}
		return taskset;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceC getSystem() {
		return system;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSystem(ResourceC newSystem, NotificationChain msgs) {
		ResourceC oldSystem = system;
		system = newSystem;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SchedulerPackage.SCHEDULER__SYSTEM, oldSystem, newSystem);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSystem(ResourceC newSystem) {
		if (newSystem != system) {
			NotificationChain msgs = null;
			if (system != null)
				msgs = ((InternalEObject)system).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SchedulerPackage.SCHEDULER__SYSTEM, null, msgs);
			if (newSystem != null)
				msgs = ((InternalEObject)newSystem).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SchedulerPackage.SCHEDULER__SYSTEM, null, msgs);
			msgs = basicSetSystem(newSystem, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SchedulerPackage.SCHEDULER__SYSTEM, newSystem, newSystem));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SchedulerPackage.SCHEDULER__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ResourceType> getResourceTypes() {
		if (resourceTypes == null) {
			resourceTypes = new EObjectContainmentEList<ResourceType>(ResourceType.class, this, SchedulerPackage.SCHEDULER__RESOURCE_TYPES);
		}
		return resourceTypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Token> getTokenPool() {
		if (tokenPool == null) {
			tokenPool = new EObjectContainmentEList<Token>(Token.class, this, SchedulerPackage.SCHEDULER__TOKEN_POOL);
		}
		return tokenPool;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SchedulerPackage.SCHEDULER__SOLVERS:
				return ((InternalEList<?>)getSolvers()).basicRemove(otherEnd, msgs);
			case SchedulerPackage.SCHEDULER__TASKSET:
				return ((InternalEList<?>)getTaskset()).basicRemove(otherEnd, msgs);
			case SchedulerPackage.SCHEDULER__SYSTEM:
				return basicSetSystem(null, msgs);
			case SchedulerPackage.SCHEDULER__RESOURCE_TYPES:
				return ((InternalEList<?>)getResourceTypes()).basicRemove(otherEnd, msgs);
			case SchedulerPackage.SCHEDULER__TOKEN_POOL:
				return ((InternalEList<?>)getTokenPool()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SchedulerPackage.SCHEDULER__SOLVERS:
				return getSolvers();
			case SchedulerPackage.SCHEDULER__TASKSET:
				return getTaskset();
			case SchedulerPackage.SCHEDULER__SYSTEM:
				return getSystem();
			case SchedulerPackage.SCHEDULER__NAME:
				return getName();
			case SchedulerPackage.SCHEDULER__RESOURCE_TYPES:
				return getResourceTypes();
			case SchedulerPackage.SCHEDULER__TOKEN_POOL:
				return getTokenPool();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case SchedulerPackage.SCHEDULER__SOLVERS:
				getSolvers().clear();
				getSolvers().addAll((Collection<? extends NumberJack>)newValue);
				return;
			case SchedulerPackage.SCHEDULER__TASKSET:
				getTaskset().clear();
				getTaskset().addAll((Collection<? extends AbstractTask>)newValue);
				return;
			case SchedulerPackage.SCHEDULER__SYSTEM:
				setSystem((ResourceC)newValue);
				return;
			case SchedulerPackage.SCHEDULER__NAME:
				setName((String)newValue);
				return;
			case SchedulerPackage.SCHEDULER__RESOURCE_TYPES:
				getResourceTypes().clear();
				getResourceTypes().addAll((Collection<? extends ResourceType>)newValue);
				return;
			case SchedulerPackage.SCHEDULER__TOKEN_POOL:
				getTokenPool().clear();
				getTokenPool().addAll((Collection<? extends Token>)newValue);
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
			case SchedulerPackage.SCHEDULER__SOLVERS:
				getSolvers().clear();
				return;
			case SchedulerPackage.SCHEDULER__TASKSET:
				getTaskset().clear();
				return;
			case SchedulerPackage.SCHEDULER__SYSTEM:
				setSystem((ResourceC)null);
				return;
			case SchedulerPackage.SCHEDULER__NAME:
				setName(NAME_EDEFAULT);
				return;
			case SchedulerPackage.SCHEDULER__RESOURCE_TYPES:
				getResourceTypes().clear();
				return;
			case SchedulerPackage.SCHEDULER__TOKEN_POOL:
				getTokenPool().clear();
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
			case SchedulerPackage.SCHEDULER__SOLVERS:
				return solvers != null && !solvers.isEmpty();
			case SchedulerPackage.SCHEDULER__TASKSET:
				return taskset != null && !taskset.isEmpty();
			case SchedulerPackage.SCHEDULER__SYSTEM:
				return system != null;
			case SchedulerPackage.SCHEDULER__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case SchedulerPackage.SCHEDULER__RESOURCE_TYPES:
				return resourceTypes != null && !resourceTypes.isEmpty();
			case SchedulerPackage.SCHEDULER__TOKEN_POOL:
				return tokenPool != null && !tokenPool.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == SolverAdapter.class) {
			switch (derivedFeatureID) {
				case SchedulerPackage.SCHEDULER__SOLVERS: return SchedulerPackage.SOLVER_ADAPTER__SOLVERS;
				default: return -1;
			}
		}
		if (baseClass == Output.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == SchedulingStrategy.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == SolverAdapter.class) {
			switch (baseFeatureID) {
				case SchedulerPackage.SOLVER_ADAPTER__SOLVERS: return SchedulerPackage.SCHEDULER__SOLVERS;
				default: return -1;
			}
		}
		if (baseClass == Output.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == SchedulingStrategy.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //SchedulerImpl
