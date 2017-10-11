/**
 */
package scheduler;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Objective Criteria</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see scheduler.SchedulerPackage#getObjectiveCriteria()
 * @model
 * @generated
 */
public enum ObjectiveCriteria implements Enumerator {
	/**
	 * The '<em><b>POWER CONSUMPTION</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #POWER_CONSUMPTION_VALUE
	 * @generated
	 * @ordered
	 */
	POWER_CONSUMPTION(0, "POWER_CONSUMPTION", "POWER_CONSUMPTION"),

	/**
	 * The '<em><b>LATENESS</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LATENESS_VALUE
	 * @generated
	 * @ordered
	 */
	LATENESS(1, "LATENESS", "LATENESS"),

	/**
	 * The '<em><b>EARLINESS</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EARLINESS_VALUE
	 * @generated
	 * @ordered
	 */
	EARLINESS(2, "EARLINESS", "EARLINESS"),

	/**
	 * The '<em><b>TARDINESS</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TARDINESS_VALUE
	 * @generated
	 * @ordered
	 */
	TARDINESS(3, "TARDINESS", "TARDINESS"),

	/**
	 * The '<em><b>CENTERING</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CENTERING_VALUE
	 * @generated
	 * @ordered
	 */
	CENTERING(4, "CENTERING", "CENTERING"),

	/**
	 * The '<em><b>MAKESPAN</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MAKESPAN_VALUE
	 * @generated
	 * @ordered
	 */
	MAKESPAN(5, "MAKESPAN", "MAKESPAN"),

	/**
	 * The '<em><b>MAX LATENESS</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MAX_LATENESS_VALUE
	 * @generated
	 * @ordered
	 */
	MAX_LATENESS(6, "MAX_LATENESS", "MAX_LATENESS"),

	/**
	 * The '<em><b>USER DEFINED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #USER_DEFINED_VALUE
	 * @generated
	 * @ordered
	 */
	USER_DEFINED(7, "USER_DEFINED", "USER_DEFINED");

	/**
	 * The '<em><b>POWER CONSUMPTION</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>POWER CONSUMPTION</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #POWER_CONSUMPTION
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int POWER_CONSUMPTION_VALUE = 0;

	/**
	 * The '<em><b>LATENESS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>LATENESS</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LATENESS
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int LATENESS_VALUE = 1;

	/**
	 * The '<em><b>EARLINESS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>EARLINESS</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #EARLINESS
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int EARLINESS_VALUE = 2;

	/**
	 * The '<em><b>TARDINESS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TARDINESS</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TARDINESS
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TARDINESS_VALUE = 3;

	/**
	 * The '<em><b>CENTERING</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CENTERING</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CENTERING
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CENTERING_VALUE = 4;

	/**
	 * The '<em><b>MAKESPAN</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MAKESPAN</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MAKESPAN
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int MAKESPAN_VALUE = 5;

	/**
	 * The '<em><b>MAX LATENESS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MAX LATENESS</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MAX_LATENESS
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int MAX_LATENESS_VALUE = 6;

	/**
	 * The '<em><b>USER DEFINED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>USER DEFINED</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #USER_DEFINED
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int USER_DEFINED_VALUE = 7;

	/**
	 * An array of all the '<em><b>Objective Criteria</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final ObjectiveCriteria[] VALUES_ARRAY =
		new ObjectiveCriteria[] {
			POWER_CONSUMPTION,
			LATENESS,
			EARLINESS,
			TARDINESS,
			CENTERING,
			MAKESPAN,
			MAX_LATENESS,
			USER_DEFINED,
		};

	/**
	 * A public read-only list of all the '<em><b>Objective Criteria</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<ObjectiveCriteria> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Objective Criteria</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static ObjectiveCriteria get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ObjectiveCriteria result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Objective Criteria</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static ObjectiveCriteria getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ObjectiveCriteria result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Objective Criteria</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static ObjectiveCriteria get(int value) {
		switch (value) {
			case POWER_CONSUMPTION_VALUE: return POWER_CONSUMPTION;
			case LATENESS_VALUE: return LATENESS;
			case EARLINESS_VALUE: return EARLINESS;
			case TARDINESS_VALUE: return TARDINESS;
			case CENTERING_VALUE: return CENTERING;
			case MAKESPAN_VALUE: return MAKESPAN;
			case MAX_LATENESS_VALUE: return MAX_LATENESS;
			case USER_DEFINED_VALUE: return USER_DEFINED;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private ObjectiveCriteria(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
	  return value;
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
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
} //ObjectiveCriteria
