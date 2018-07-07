/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.variantmodel.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.featuremodel.FeatureModelPackage;

import org.eclipse.featuremodel.impl.FeatureModelPackageImpl;

import org.eclipse.variantmodel.FeatureSelection;
import org.eclipse.variantmodel.SelectionState;
import org.eclipse.variantmodel.VariantModel;
import org.eclipse.variantmodel.VariantModelFactory;
import org.eclipse.variantmodel.VariantModelPackage;
import org.eclipse.variantmodel.VariantSelection;
import org.eclipse.variantmodel.VariantValue;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class VariantModelPackageImpl extends EPackageImpl implements VariantModelPackage {
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass variantSelectionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass variantValueEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass variantModelEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass featureSelectionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum selectionStateEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EDataType idEDataType = null;

  /**
   * Creates an instance of the model <b>Package</b>, registered with
   * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
   * package URI value.
   * <p>Note: the correct way to create the package is via the static
   * factory method {@link #init init()}, which also performs
   * initialization of the package, or returns the registered package,
   * if one already exists.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.ecore.EPackage.Registry
   * @see org.eclipse.variantmodel.VariantModelPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private VariantModelPackageImpl() {
    super(eNS_URI, VariantModelFactory.eINSTANCE);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static boolean isInited = false;

  /**
   * Creates, registers, and initializes the <b>Package</b> for this
   * model, and for any others upon which it depends.  Simple
   * dependencies are satisfied by calling this method on all
   * dependent packages before doing anything else.  This method drives
   * initialization for interdependent packages directly, in parallel
   * with this package, itself.
   * <p>Of this package and its interdependencies, all packages which
   * have not yet been registered by their URI values are first created
   * and registered.  The packages are then initialized in two steps:
   * meta-model objects for all of the packages are created before any
   * are initialized, since one package's meta-model objects may refer to
   * those of another.
   * <p>Invocation of this method will not affect any packages that have
   * already been initialized.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static VariantModelPackage init() {
    if (isInited) return (VariantModelPackage)EPackage.Registry.INSTANCE.getEPackage(VariantModelPackage.eNS_URI);

    // Obtain or create and register package
    VariantModelPackageImpl theVariantModelPackage = (VariantModelPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof VariantModelPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new VariantModelPackageImpl());

    isInited = true;

    // Initialize simple dependencies
    EcorePackage.eINSTANCE.eClass();

    // Obtain or create and register interdependencies
    FeatureModelPackageImpl theFeatureModelPackage = (FeatureModelPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(FeatureModelPackage.eNS_URI) instanceof FeatureModelPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(FeatureModelPackage.eNS_URI) : FeatureModelPackage.eINSTANCE);

    // Create package meta-data objects
    theVariantModelPackage.createPackageContents();
    theFeatureModelPackage.createPackageContents();

    // Initialize created meta-data
    theVariantModelPackage.initializePackageContents();
    theFeatureModelPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theVariantModelPackage.freeze();

    return theVariantModelPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getVariantSelection() {
    return variantSelectionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getVariantSelection_Bound() {
    return (EAttribute)variantSelectionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getVariantValue() {
    return variantValueEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getVariantValue_Id() {
    return (EAttribute)variantValueEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getVariantValue_Attribute() {
    return (EReference)variantValueEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getVariantValue_Value() {
    return (EReference)variantValueEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getVariantModel() {
    return variantModelEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getVariantModel_Id() {
    return (EAttribute)variantModelEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getVariantModel_Version() {
    return (EAttribute)variantModelEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getVariantModel_Attributes() {
    return (EReference)variantModelEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getVariantModel_FeatureModel() {
    return (EReference)variantModelEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getVariantModel_Selections() {
    return (EReference)variantModelEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getVariantModel_Values() {
    return (EReference)variantModelEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFeatureSelection() {
    return featureSelectionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getFeatureSelection_Id() {
    return (EAttribute)featureSelectionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getFeatureSelection_State() {
    return (EAttribute)featureSelectionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFeatureSelection_Feature() {
    return (EReference)featureSelectionEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getSelectionState() {
    return selectionStateEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EDataType getID() {
    return idEDataType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VariantModelFactory getVariantModelFactory() {
    return (VariantModelFactory)getEFactoryInstance();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isCreated = false;

  /**
   * Creates the meta-model objects for the package.  This method is
   * guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void createPackageContents() {
    if (isCreated) return;
    isCreated = true;

    // Create classes and their features
    featureSelectionEClass = createEClass(FEATURE_SELECTION);
    createEAttribute(featureSelectionEClass, FEATURE_SELECTION__ID);
    createEAttribute(featureSelectionEClass, FEATURE_SELECTION__STATE);
    createEReference(featureSelectionEClass, FEATURE_SELECTION__FEATURE);

    variantModelEClass = createEClass(VARIANT_MODEL);
    createEAttribute(variantModelEClass, VARIANT_MODEL__ID);
    createEAttribute(variantModelEClass, VARIANT_MODEL__VERSION);
    createEReference(variantModelEClass, VARIANT_MODEL__ATTRIBUTES);
    createEReference(variantModelEClass, VARIANT_MODEL__FEATURE_MODEL);
    createEReference(variantModelEClass, VARIANT_MODEL__SELECTIONS);
    createEReference(variantModelEClass, VARIANT_MODEL__VALUES);

    variantSelectionEClass = createEClass(VARIANT_SELECTION);
    createEAttribute(variantSelectionEClass, VARIANT_SELECTION__BOUND);

    variantValueEClass = createEClass(VARIANT_VALUE);
    createEAttribute(variantValueEClass, VARIANT_VALUE__ID);
    createEReference(variantValueEClass, VARIANT_VALUE__ATTRIBUTE);
    createEReference(variantValueEClass, VARIANT_VALUE__VALUE);

    // Create enums
    selectionStateEEnum = createEEnum(SELECTION_STATE);

    // Create data types
    idEDataType = createEDataType(ID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isInitialized = false;

  /**
   * Complete the initialization of the package and its meta-model.  This
   * method is guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void initializePackageContents() {
    if (isInitialized) return;
    isInitialized = true;

    // Initialize package
    setName(eNAME);
    setNsPrefix(eNS_PREFIX);
    setNsURI(eNS_URI);

    // Obtain other dependent packages
    FeatureModelPackage theFeatureModelPackage = (FeatureModelPackage)EPackage.Registry.INSTANCE.getEPackage(FeatureModelPackage.eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    variantSelectionEClass.getESuperTypes().add(this.getFeatureSelection());

    // Initialize classes and features; add operations and parameters
    initEClass(featureSelectionEClass, FeatureSelection.class, "FeatureSelection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getFeatureSelection_Id(), this.getID(), "id", null, 1, 1, FeatureSelection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getFeatureSelection_State(), this.getSelectionState(), "state", null, 1, 1, FeatureSelection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getFeatureSelection_Feature(), theFeatureModelPackage.getFeature(), null, "feature", null, 1, 1, FeatureSelection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(variantModelEClass, VariantModel.class, "VariantModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getVariantModel_Id(), this.getID(), "id", null, 1, 1, VariantModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getVariantModel_Version(), ecorePackage.getEString(), "version", null, 1, 1, VariantModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getVariantModel_Attributes(), theFeatureModelPackage.getAttribute(), null, "attributes", null, 0, -1, VariantModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getVariantModel_FeatureModel(), theFeatureModelPackage.getFeatureModel(), null, "featureModel", null, 1, 1, VariantModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getVariantModel_Selections(), this.getVariantSelection(), null, "selections", null, 0, -1, VariantModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getVariantModel_Values(), this.getVariantValue(), null, "values", null, 0, -1, VariantModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(variantSelectionEClass, VariantSelection.class, "VariantSelection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getVariantSelection_Bound(), ecorePackage.getEBoolean(), "bound", null, 0, 1, VariantSelection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    addEOperation(variantSelectionEClass, this.getVariantModel(), "getModel", 1, 1, IS_UNIQUE, IS_ORDERED);

    initEClass(variantValueEClass, VariantValue.class, "VariantValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getVariantValue_Id(), this.getID(), "id", null, 1, 1, VariantValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getVariantValue_Attribute(), theFeatureModelPackage.getAttribute(), null, "attribute", null, 1, 1, VariantValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getVariantValue_Value(), theFeatureModelPackage.getAttributeValue(), null, "value", null, 1, 1, VariantValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Initialize enums and add enum literals
    initEEnum(selectionStateEEnum, SelectionState.class, "SelectionState");
    addEEnumLiteral(selectionStateEEnum, SelectionState.UNSELECTED);
    addEEnumLiteral(selectionStateEEnum, SelectionState.SELECTED);
    addEEnumLiteral(selectionStateEEnum, SelectionState.EXCLUDED);

    // Initialize data types
    initEDataType(idEDataType, String.class, "ID", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

    // Create resource
    createResource(eNS_URI);
  }

} //VariantModelPackageImpl
