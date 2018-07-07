/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.variantmodel.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.featuremodel.Feature;
import org.eclipse.variantmodel.FeatureSelection;
import org.eclipse.variantmodel.SelectionState;
import org.eclipse.variantmodel.VariantModelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Feature Selection</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.variantmodel.impl.FeatureSelectionImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipse.variantmodel.impl.FeatureSelectionImpl#getState <em>State</em>}</li>
 *   <li>{@link org.eclipse.variantmodel.impl.FeatureSelectionImpl#getFeature <em>Feature</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FeatureSelectionImpl extends EObjectImpl implements FeatureSelection {
  /**
   * The default value of the '{@link #getId() <em>Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getId()
   * @generated
   * @ordered
   */
  protected static final String ID_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getId()
   * @generated
   * @ordered
   */
  protected String id = ID_EDEFAULT;

  /**
   * The default value of the '{@link #getState() <em>State</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getState()
   * @generated
   * @ordered
   */
  protected static final SelectionState STATE_EDEFAULT = SelectionState.UNSELECTED;

  /**
   * The cached value of the '{@link #getState() <em>State</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getState()
   * @generated
   * @ordered
   */
  protected SelectionState state = STATE_EDEFAULT;

  /**
   * The cached value of the '{@link #getFeature() <em>Feature</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFeature()
   * @generated
   * @ordered
   */
  protected Feature feature;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected FeatureSelectionImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return VariantModelPackage.Literals.FEATURE_SELECTION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getId() {
    return id;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setId(String newId) {
    String oldId = id;
    id = newId;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, VariantModelPackage.FEATURE_SELECTION__ID, oldId, id));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SelectionState getState() {
    return state;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setState(SelectionState newState) {
    SelectionState oldState = state;
    state = newState == null ? STATE_EDEFAULT : newState;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, VariantModelPackage.FEATURE_SELECTION__STATE, oldState, state));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Feature getFeature() {
    if (feature != null && feature.eIsProxy()) {
      InternalEObject oldFeature = (InternalEObject)feature;
      feature = (Feature)eResolveProxy(oldFeature);
      if (feature != oldFeature) {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, VariantModelPackage.FEATURE_SELECTION__FEATURE, oldFeature, feature));
      }
    }
    return feature;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Feature basicGetFeature() {
    return feature;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFeature(Feature newFeature) {
    Feature oldFeature = feature;
    feature = newFeature;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, VariantModelPackage.FEATURE_SELECTION__FEATURE, oldFeature, feature));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
      case VariantModelPackage.FEATURE_SELECTION__ID:
        return getId();
      case VariantModelPackage.FEATURE_SELECTION__STATE:
        return getState();
      case VariantModelPackage.FEATURE_SELECTION__FEATURE:
        if (resolve) return getFeature();
        return basicGetFeature();
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
      case VariantModelPackage.FEATURE_SELECTION__ID:
        setId((String)newValue);
        return;
      case VariantModelPackage.FEATURE_SELECTION__STATE:
        setState((SelectionState)newValue);
        return;
      case VariantModelPackage.FEATURE_SELECTION__FEATURE:
        setFeature((Feature)newValue);
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
      case VariantModelPackage.FEATURE_SELECTION__ID:
        setId(ID_EDEFAULT);
        return;
      case VariantModelPackage.FEATURE_SELECTION__STATE:
        setState(STATE_EDEFAULT);
        return;
      case VariantModelPackage.FEATURE_SELECTION__FEATURE:
        setFeature((Feature)null);
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
      case VariantModelPackage.FEATURE_SELECTION__ID:
        return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
      case VariantModelPackage.FEATURE_SELECTION__STATE:
        return state != STATE_EDEFAULT;
      case VariantModelPackage.FEATURE_SELECTION__FEATURE:
        return feature != null;
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
    result.append(" (id: ");
    result.append(id);
    result.append(", state: ");
    result.append(state);
    result.append(')');
    return result.toString();
  }

} //FeatureSelectionImpl
