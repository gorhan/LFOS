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
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import scheduler.Output;
import scheduler.SchedulerPackage;
import scheduler.SchedulingStrategy;
import scheduler.Solver;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Scheduling Strategy</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link scheduler.impl.SchedulingStrategyImpl#getOutput <em>Output</em>}</li>
 *   <li>{@link scheduler.impl.SchedulingStrategyImpl#getSolvers <em>Solvers</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SchedulingStrategyImpl extends MinimalEObjectImpl.Container implements SchedulingStrategy {
	/**
	 * The cached value of the '{@link #getOutput() <em>Output</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutput()
	 * @generated
	 * @ordered
	 */
	protected Output output;

	/**
	 * The cached value of the '{@link #getSolvers() <em>Solvers</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSolvers()
	 * @generated
	 * @ordered
	 */
	protected EList<Solver> solvers;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SchedulingStrategyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SchedulerPackage.Literals.SCHEDULING_STRATEGY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Output getOutput() {
		return output;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOutput(Output newOutput, NotificationChain msgs) {
		Output oldOutput = output;
		output = newOutput;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SchedulerPackage.SCHEDULING_STRATEGY__OUTPUT, oldOutput, newOutput);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOutput(Output newOutput) {
		if (newOutput != output) {
			NotificationChain msgs = null;
			if (output != null)
				msgs = ((InternalEObject)output).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SchedulerPackage.SCHEDULING_STRATEGY__OUTPUT, null, msgs);
			if (newOutput != null)
				msgs = ((InternalEObject)newOutput).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SchedulerPackage.SCHEDULING_STRATEGY__OUTPUT, null, msgs);
			msgs = basicSetOutput(newOutput, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SchedulerPackage.SCHEDULING_STRATEGY__OUTPUT, newOutput, newOutput));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Solver> getSolvers() {
		if (solvers == null) {
			solvers = new EObjectContainmentEList<Solver>(Solver.class, this, SchedulerPackage.SCHEDULING_STRATEGY__SOLVERS);
		}
		return solvers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SchedulerPackage.SCHEDULING_STRATEGY__OUTPUT:
				return basicSetOutput(null, msgs);
			case SchedulerPackage.SCHEDULING_STRATEGY__SOLVERS:
				return ((InternalEList<?>)getSolvers()).basicRemove(otherEnd, msgs);
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
			case SchedulerPackage.SCHEDULING_STRATEGY__OUTPUT:
				return getOutput();
			case SchedulerPackage.SCHEDULING_STRATEGY__SOLVERS:
				return getSolvers();
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
			case SchedulerPackage.SCHEDULING_STRATEGY__OUTPUT:
				setOutput((Output)newValue);
				return;
			case SchedulerPackage.SCHEDULING_STRATEGY__SOLVERS:
				getSolvers().clear();
				getSolvers().addAll((Collection<? extends Solver>)newValue);
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
			case SchedulerPackage.SCHEDULING_STRATEGY__OUTPUT:
				setOutput((Output)null);
				return;
			case SchedulerPackage.SCHEDULING_STRATEGY__SOLVERS:
				getSolvers().clear();
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
			case SchedulerPackage.SCHEDULING_STRATEGY__OUTPUT:
				return output != null;
			case SchedulerPackage.SCHEDULING_STRATEGY__SOLVERS:
				return solvers != null && !solvers.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //SchedulingStrategyImpl
