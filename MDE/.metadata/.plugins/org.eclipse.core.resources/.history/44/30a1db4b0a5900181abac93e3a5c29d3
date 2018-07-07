/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.variantmodel.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.variantmodel.VariantModel;
import org.eclipse.variantmodel.VariantModelPackage;
import org.eclipse.variantmodel.VariantSelection;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Variant Selection</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.variantmodel.impl.VariantSelectionImpl#isBound <em>Bound</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class VariantSelectionImpl extends FeatureSelectionImpl implements
    VariantSelection {
  /**
   * The default value of the '{@link #isBound() <em>Bound</em>}' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see #isBound()
   * @generated
   * @ordered
   */
  protected static final boolean BOUND_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isBound() <em>Bound</em>}' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see #isBound()
   * @generated
   * @ordered
   */
  protected boolean bound = BOUND_EDEFAULT;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  protected VariantSelectionImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return VariantModelPackage.Literals.VARIANT_SELECTION;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public boolean isBound() {
    return bound;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public void setBound(boolean newBound) {
    boolean oldBound = bound;
    bound = newBound;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET,
          VariantModelPackage.VARIANT_SELECTION__BOUND, oldBound, bound));
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  public VariantModel getModel() {
    VariantModel model = null;
    EObject container = eContainer();
    if (container instanceof VariantModel) {
      model = (VariantModel) container;
    }
    return model;
    // Ensure that you remove @generated or mark it @generated NOT
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case VariantModelPackage.VARIANT_SELECTION__BOUND:
      return isBound() ? Boolean.TRUE : Boolean.FALSE;
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case VariantModelPackage.VARIANT_SELECTION__BOUND:
      setBound(((Boolean) newValue).booleanValue());
      return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public void eUnset(int featureID) {
    switch (featureID) {
    case VariantModelPackage.VARIANT_SELECTION__BOUND:
      setBound(BOUND_EDEFAULT);
      return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case VariantModelPackage.VARIANT_SELECTION__BOUND:
      return bound != BOUND_EDEFAULT;
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public String toString() {
    if (eIsProxy())
      return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (bound: ");
    result.append(bound);
    result.append(')');
    return result.toString();
  }

} // VariantSelectionImpl
