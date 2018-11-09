/**
 */
package optimal;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see optimal.OptimalFactory
 * @model kind="package"
 * @generated
 */
public interface OptimalPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "optimal";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.example.org/optimal";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "optimal";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	OptimalPackage eINSTANCE = optimal.impl.OptimalPackageImpl.init();

	/**
	 * The meta object id for the '{@link optimal.impl.OptimizationImpl <em>Optimization</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see optimal.impl.OptimizationImpl
	 * @see optimal.impl.OptimalPackageImpl#getOptimization()
	 * @generated
	 */
	int OPTIMIZATION = 0;

	/**
	 * The feature id for the '<em><b>Criteria</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTIMIZATION__CRITERIA = 0;

	/**
	 * The feature id for the '<em><b>Features</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTIMIZATION__FEATURES = 1;

	/**
	 * The number of structural features of the '<em>Optimization</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTIMIZATION_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Optimization</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTIMIZATION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link optimal.impl.CriteriaImpl <em>Criteria</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see optimal.impl.CriteriaImpl
	 * @see optimal.impl.OptimalPackageImpl#getCriteria()
	 * @generated
	 */
	int CRITERIA = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CRITERIA__NAME = 0;

	/**
	 * The feature id for the '<em><b>Purpose</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CRITERIA__PURPOSE = 1;

	/**
	 * The feature id for the '<em><b>Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CRITERIA__DEFAULT = 2;

	/**
	 * The feature id for the '<em><b>Multiutility</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CRITERIA__MULTIUTILITY = 3;

	/**
	 * The feature id for the '<em><b>Singleutility</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CRITERIA__SINGLEUTILITY = 4;

	/**
	 * The feature id for the '<em><b>Percentage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CRITERIA__PERCENTAGE = 5;

	/**
	 * The number of structural features of the '<em>Criteria</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CRITERIA_FEATURE_COUNT = 6;

	/**
	 * The number of operations of the '<em>Criteria</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CRITERIA_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link optimal.impl.FeatureImpl <em>Feature</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see optimal.impl.FeatureImpl
	 * @see optimal.impl.OptimalPackageImpl#getFeature()
	 * @generated
	 */
	int FEATURE = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__NAME = 0;

	/**
	 * The number of structural features of the '<em>Feature</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Feature</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link optimal.impl.MultiUtilityImpl <em>Multi Utility</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see optimal.impl.MultiUtilityImpl
	 * @see optimal.impl.OptimalPackageImpl#getMultiUtility()
	 * @generated
	 */
	int MULTI_UTILITY = 3;

	/**
	 * The feature id for the '<em><b>Features</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_UTILITY__FEATURES = 0;

	/**
	 * The feature id for the '<em><b>Contribution</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_UTILITY__CONTRIBUTION = 1;

	/**
	 * The number of structural features of the '<em>Multi Utility</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_UTILITY_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Multi Utility</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_UTILITY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link optimal.impl.SingleUtilityImpl <em>Single Utility</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see optimal.impl.SingleUtilityImpl
	 * @see optimal.impl.OptimalPackageImpl#getSingleUtility()
	 * @generated
	 */
	int SINGLE_UTILITY = 4;

	/**
	 * The feature id for the '<em><b>Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLE_UTILITY__BOUND = 0;

	/**
	 * The feature id for the '<em><b>Points</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLE_UTILITY__POINTS = 1;

	/**
	 * The feature id for the '<em><b>Unbound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLE_UTILITY__UNBOUND = 2;

	/**
	 * The number of structural features of the '<em>Single Utility</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLE_UTILITY_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Single Utility</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLE_UTILITY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link optimal.Purpose <em>Purpose</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see optimal.Purpose
	 * @see optimal.impl.OptimalPackageImpl#getPurpose()
	 * @generated
	 */
	int PURPOSE = 5;


	/**
	 * Returns the meta object for class '{@link optimal.Optimization <em>Optimization</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Optimization</em>'.
	 * @see optimal.Optimization
	 * @generated
	 */
	EClass getOptimization();

	/**
	 * Returns the meta object for the containment reference list '{@link optimal.Optimization#getCriteria <em>Criteria</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Criteria</em>'.
	 * @see optimal.Optimization#getCriteria()
	 * @see #getOptimization()
	 * @generated
	 */
	EReference getOptimization_Criteria();

	/**
	 * Returns the meta object for the containment reference list '{@link optimal.Optimization#getFeatures <em>Features</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Features</em>'.
	 * @see optimal.Optimization#getFeatures()
	 * @see #getOptimization()
	 * @generated
	 */
	EReference getOptimization_Features();

	/**
	 * Returns the meta object for class '{@link optimal.Criteria <em>Criteria</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Criteria</em>'.
	 * @see optimal.Criteria
	 * @generated
	 */
	EClass getCriteria();

	/**
	 * Returns the meta object for the attribute '{@link optimal.Criteria#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see optimal.Criteria#getName()
	 * @see #getCriteria()
	 * @generated
	 */
	EAttribute getCriteria_Name();

	/**
	 * Returns the meta object for the attribute '{@link optimal.Criteria#getPurpose <em>Purpose</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Purpose</em>'.
	 * @see optimal.Criteria#getPurpose()
	 * @see #getCriteria()
	 * @generated
	 */
	EAttribute getCriteria_Purpose();

	/**
	 * Returns the meta object for the attribute '{@link optimal.Criteria#getDefault <em>Default</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Default</em>'.
	 * @see optimal.Criteria#getDefault()
	 * @see #getCriteria()
	 * @generated
	 */
	EAttribute getCriteria_Default();

	/**
	 * Returns the meta object for the containment reference list '{@link optimal.Criteria#getMultiutility <em>Multiutility</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Multiutility</em>'.
	 * @see optimal.Criteria#getMultiutility()
	 * @see #getCriteria()
	 * @generated
	 */
	EReference getCriteria_Multiutility();

	/**
	 * Returns the meta object for the containment reference list '{@link optimal.Criteria#getSingleutility <em>Singleutility</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Singleutility</em>'.
	 * @see optimal.Criteria#getSingleutility()
	 * @see #getCriteria()
	 * @generated
	 */
	EReference getCriteria_Singleutility();

	/**
	 * Returns the meta object for the attribute '{@link optimal.Criteria#getPercentage <em>Percentage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Percentage</em>'.
	 * @see optimal.Criteria#getPercentage()
	 * @see #getCriteria()
	 * @generated
	 */
	EAttribute getCriteria_Percentage();

	/**
	 * Returns the meta object for class '{@link optimal.Feature <em>Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Feature</em>'.
	 * @see optimal.Feature
	 * @generated
	 */
	EClass getFeature();

	/**
	 * Returns the meta object for the attribute '{@link optimal.Feature#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see optimal.Feature#getName()
	 * @see #getFeature()
	 * @generated
	 */
	EAttribute getFeature_Name();

	/**
	 * Returns the meta object for class '{@link optimal.MultiUtility <em>Multi Utility</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Multi Utility</em>'.
	 * @see optimal.MultiUtility
	 * @generated
	 */
	EClass getMultiUtility();

	/**
	 * Returns the meta object for the reference list '{@link optimal.MultiUtility#getFeatures <em>Features</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Features</em>'.
	 * @see optimal.MultiUtility#getFeatures()
	 * @see #getMultiUtility()
	 * @generated
	 */
	EReference getMultiUtility_Features();

	/**
	 * Returns the meta object for the attribute '{@link optimal.MultiUtility#getContribution <em>Contribution</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Contribution</em>'.
	 * @see optimal.MultiUtility#getContribution()
	 * @see #getMultiUtility()
	 * @generated
	 */
	EAttribute getMultiUtility_Contribution();

	/**
	 * Returns the meta object for class '{@link optimal.SingleUtility <em>Single Utility</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Single Utility</em>'.
	 * @see optimal.SingleUtility
	 * @generated
	 */
	EClass getSingleUtility();

	/**
	 * Returns the meta object for the attribute '{@link optimal.SingleUtility#getBound <em>Bound</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Bound</em>'.
	 * @see optimal.SingleUtility#getBound()
	 * @see #getSingleUtility()
	 * @generated
	 */
	EAttribute getSingleUtility_Bound();

	/**
	 * Returns the meta object for the reference '{@link optimal.SingleUtility#getPoints <em>Points</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Points</em>'.
	 * @see optimal.SingleUtility#getPoints()
	 * @see #getSingleUtility()
	 * @generated
	 */
	EReference getSingleUtility_Points();

	/**
	 * Returns the meta object for the attribute '{@link optimal.SingleUtility#getUnbound <em>Unbound</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Unbound</em>'.
	 * @see optimal.SingleUtility#getUnbound()
	 * @see #getSingleUtility()
	 * @generated
	 */
	EAttribute getSingleUtility_Unbound();

	/**
	 * Returns the meta object for enum '{@link optimal.Purpose <em>Purpose</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Purpose</em>'.
	 * @see optimal.Purpose
	 * @generated
	 */
	EEnum getPurpose();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	OptimalFactory getOptimalFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link optimal.impl.OptimizationImpl <em>Optimization</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see optimal.impl.OptimizationImpl
		 * @see optimal.impl.OptimalPackageImpl#getOptimization()
		 * @generated
		 */
		EClass OPTIMIZATION = eINSTANCE.getOptimization();

		/**
		 * The meta object literal for the '<em><b>Criteria</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPTIMIZATION__CRITERIA = eINSTANCE.getOptimization_Criteria();

		/**
		 * The meta object literal for the '<em><b>Features</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPTIMIZATION__FEATURES = eINSTANCE.getOptimization_Features();

		/**
		 * The meta object literal for the '{@link optimal.impl.CriteriaImpl <em>Criteria</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see optimal.impl.CriteriaImpl
		 * @see optimal.impl.OptimalPackageImpl#getCriteria()
		 * @generated
		 */
		EClass CRITERIA = eINSTANCE.getCriteria();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CRITERIA__NAME = eINSTANCE.getCriteria_Name();

		/**
		 * The meta object literal for the '<em><b>Purpose</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CRITERIA__PURPOSE = eINSTANCE.getCriteria_Purpose();

		/**
		 * The meta object literal for the '<em><b>Default</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CRITERIA__DEFAULT = eINSTANCE.getCriteria_Default();

		/**
		 * The meta object literal for the '<em><b>Multiutility</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CRITERIA__MULTIUTILITY = eINSTANCE.getCriteria_Multiutility();

		/**
		 * The meta object literal for the '<em><b>Singleutility</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CRITERIA__SINGLEUTILITY = eINSTANCE.getCriteria_Singleutility();

		/**
		 * The meta object literal for the '<em><b>Percentage</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CRITERIA__PERCENTAGE = eINSTANCE.getCriteria_Percentage();

		/**
		 * The meta object literal for the '{@link optimal.impl.FeatureImpl <em>Feature</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see optimal.impl.FeatureImpl
		 * @see optimal.impl.OptimalPackageImpl#getFeature()
		 * @generated
		 */
		EClass FEATURE = eINSTANCE.getFeature();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FEATURE__NAME = eINSTANCE.getFeature_Name();

		/**
		 * The meta object literal for the '{@link optimal.impl.MultiUtilityImpl <em>Multi Utility</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see optimal.impl.MultiUtilityImpl
		 * @see optimal.impl.OptimalPackageImpl#getMultiUtility()
		 * @generated
		 */
		EClass MULTI_UTILITY = eINSTANCE.getMultiUtility();

		/**
		 * The meta object literal for the '<em><b>Features</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MULTI_UTILITY__FEATURES = eINSTANCE.getMultiUtility_Features();

		/**
		 * The meta object literal for the '<em><b>Contribution</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MULTI_UTILITY__CONTRIBUTION = eINSTANCE.getMultiUtility_Contribution();

		/**
		 * The meta object literal for the '{@link optimal.impl.SingleUtilityImpl <em>Single Utility</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see optimal.impl.SingleUtilityImpl
		 * @see optimal.impl.OptimalPackageImpl#getSingleUtility()
		 * @generated
		 */
		EClass SINGLE_UTILITY = eINSTANCE.getSingleUtility();

		/**
		 * The meta object literal for the '<em><b>Bound</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SINGLE_UTILITY__BOUND = eINSTANCE.getSingleUtility_Bound();

		/**
		 * The meta object literal for the '<em><b>Points</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SINGLE_UTILITY__POINTS = eINSTANCE.getSingleUtility_Points();

		/**
		 * The meta object literal for the '<em><b>Unbound</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SINGLE_UTILITY__UNBOUND = eINSTANCE.getSingleUtility_Unbound();

		/**
		 * The meta object literal for the '{@link optimal.Purpose <em>Purpose</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see optimal.Purpose
		 * @see optimal.impl.OptimalPackageImpl#getPurpose()
		 * @generated
		 */
		EEnum PURPOSE = eINSTANCE.getPurpose();

	}

} //OptimalPackage
