/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.featuremodel.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;

import org.eclipse.featuremodel.Attribute;
import org.eclipse.featuremodel.FeatureModelFactory;
import org.eclipse.featuremodel.FeatureModelPackage;

/**
 * This is the item provider adapter for a {@link org.eclipse.featuremodel.Attribute} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class AttributeItemProvider
  extends ItemProviderAdapter
  implements	
    IEditingDomainItemProvider,	
    IStructuredItemContentProvider,	
    ITreeItemContentProvider,	
    IItemLabelProvider,	
    IItemPropertySource {
  /**
   * This constructs an instance from a factory and a notifier.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AttributeItemProvider(AdapterFactory adapterFactory) {
    super(adapterFactory);
  }

  /**
   * This returns the property descriptors for the adapted class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
    if (itemPropertyDescriptors == null) {
      super.getPropertyDescriptors(object);

      addIdPropertyDescriptor(object);
      addNamePropertyDescriptor(object);
      addSetablePropertyDescriptor(object);
    }
    return itemPropertyDescriptors;
  }

  /**
   * This adds a property descriptor for the Id feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addIdPropertyDescriptor(Object object) {
    itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_Attribute_id_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_Attribute_id_feature", "_UI_Attribute_type"),
         FeatureModelPackage.Literals.ATTRIBUTE__ID,
         true,
         false,
         false,
         ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
         null,
         null));
  }

  /**
   * This adds a property descriptor for the Name feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addNamePropertyDescriptor(Object object) {
    itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_Attribute_name_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_Attribute_name_feature", "_UI_Attribute_type"),
         FeatureModelPackage.Literals.ATTRIBUTE__NAME,
         true,
         false,
         false,
         ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
         null,
         null));
  }

  /**
   * This adds a property descriptor for the Setable feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addSetablePropertyDescriptor(Object object) {
    itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_Attribute_setable_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_Attribute_setable_feature", "_UI_Attribute_type"),
         FeatureModelPackage.Literals.ATTRIBUTE__SETABLE,
         true,
         false,
         false,
         ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
         null,
         null));
  }

  /**
   * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
   * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
   * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
    if (childrenFeatures == null) {
      super.getChildrenFeatures(object);
      childrenFeatures.add(FeatureModelPackage.Literals.ATTRIBUTE__DESCRIPTION);
      childrenFeatures.add(FeatureModelPackage.Literals.ATTRIBUTE__DEFAULT_VALUE);
      childrenFeatures.add(FeatureModelPackage.Literals.ATTRIBUTE__TYPE);
    }
    return childrenFeatures;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EStructuralFeature getChildFeature(Object object, Object child) {
    // Check the type of the specified child object and return the proper feature to use for
    // adding (see {@link AddCommand}) it as a child.

    return super.getChildFeature(object, child);
  }

  /**
   * This returns Attribute.gif.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object getImage(Object object) {
    return overlayImage(object, getResourceLocator().getImage("full/obj16/Attribute"));
  }

  /**
   * This returns the label text for the adapted class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getText(Object object) {
    String label = ((Attribute)object).getName();
    return label == null || label.length() == 0 ?
      getString("_UI_Attribute_type") :
      getString("_UI_Attribute_type") + " " + label;
  }

  /**
   * This handles model notifications by calling {@link #updateChildren} to update any cached
   * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void notifyChanged(Notification notification) {
    updateChildren(notification);

    switch (notification.getFeatureID(Attribute.class)) {
      case FeatureModelPackage.ATTRIBUTE__ID:
      case FeatureModelPackage.ATTRIBUTE__NAME:
      case FeatureModelPackage.ATTRIBUTE__SETABLE:
        fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
        return;
      case FeatureModelPackage.ATTRIBUTE__DESCRIPTION:
      case FeatureModelPackage.ATTRIBUTE__DEFAULT_VALUE:
      case FeatureModelPackage.ATTRIBUTE__TYPE:
        fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
        return;
    }
    super.notifyChanged(notification);
  }

  /**
   * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
   * that can be created under this object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
    super.collectNewChildDescriptors(newChildDescriptors, object);

    newChildDescriptors.add
      (createChildParameter
        (FeatureModelPackage.Literals.ATTRIBUTE__DESCRIPTION,
         FeatureModelFactory.eINSTANCE.createDescription()));

    newChildDescriptors.add
      (createChildParameter
        (FeatureModelPackage.Literals.ATTRIBUTE__DEFAULT_VALUE,
         FeatureModelFactory.eINSTANCE.createAttributeValueInt()));

    newChildDescriptors.add
      (createChildParameter
        (FeatureModelPackage.Literals.ATTRIBUTE__DEFAULT_VALUE,
         FeatureModelFactory.eINSTANCE.createAttributeValueString()));

    newChildDescriptors.add
      (createChildParameter
        (FeatureModelPackage.Literals.ATTRIBUTE__DEFAULT_VALUE,
         FeatureModelFactory.eINSTANCE.createAttributeValueBoolean()));

    newChildDescriptors.add
      (createChildParameter
        (FeatureModelPackage.Literals.ATTRIBUTE__DEFAULT_VALUE,
         FeatureModelFactory.eINSTANCE.createAttributeValueEObject()));

    newChildDescriptors.add
      (createChildParameter
        (FeatureModelPackage.Literals.ATTRIBUTE__TYPE,
         FeatureModelFactory.eINSTANCE.createAttributeTypeInt()));

    newChildDescriptors.add
      (createChildParameter
        (FeatureModelPackage.Literals.ATTRIBUTE__TYPE,
         FeatureModelFactory.eINSTANCE.createAttributeTypeString()));

    newChildDescriptors.add
      (createChildParameter
        (FeatureModelPackage.Literals.ATTRIBUTE__TYPE,
         FeatureModelFactory.eINSTANCE.createAttributeTypeBoolean()));

    newChildDescriptors.add
      (createChildParameter
        (FeatureModelPackage.Literals.ATTRIBUTE__TYPE,
         FeatureModelFactory.eINSTANCE.createAttributeTypeEObject()));
  }

  /**
   * Return the resource locator for this item provider's resources.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ResourceLocator getResourceLocator() {
    return FeatureModelEditPlugin.INSTANCE;
  }

}
