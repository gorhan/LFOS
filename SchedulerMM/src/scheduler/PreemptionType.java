/**
 */
package scheduler;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Preemption Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see scheduler.SchedulerPackage#getPreemptionType()
 * @model
 * @generated
 */
public enum PreemptionType implements Enumerator {
	/**
	 * The '<em><b>NOT PPREEMPTABLE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NOT_PPREEMPTABLE_VALUE
	 * @generated
	 * @ordered
	 */
	NOT_PPREEMPTABLE(0, "NOT_PPREEMPTABLE", "NOT_PPREEMPTABLE"),

	/**
	 * The '<em><b>FULLY PREEMPTABLE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FULLY_PREEMPTABLE_VALUE
	 * @generated
	 * @ordered
	 */
	FULLY_PREEMPTABLE(1, "FULLY_PREEMPTABLE", "FULLY_PREEMPTABLE"),

	/**
	 * The '<em><b>COOPERATIVELY PREEMPTABLE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #COOPERATIVELY_PREEMPTABLE_VALUE
	 * @generated
	 * @ordered
	 */
	COOPERATIVELY_PREEMPTABLE(2, "COOPERATIVELY_PREEMPTABLE", "COOPERATIVELY_PREEMPTABLE");

	/**
	 * The '<em><b>NOT PPREEMPTABLE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>NOT PPREEMPTABLE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NOT_PPREEMPTABLE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int NOT_PPREEMPTABLE_VALUE = 0;

	/**
	 * The '<em><b>FULLY PREEMPTABLE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>FULLY PREEMPTABLE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FULLY_PREEMPTABLE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int FULLY_PREEMPTABLE_VALUE = 1;

	/**
	 * The '<em><b>COOPERATIVELY PREEMPTABLE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>COOPERATIVELY PREEMPTABLE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #COOPERATIVELY_PREEMPTABLE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int COOPERATIVELY_PREEMPTABLE_VALUE = 2;

	/**
	 * An array of all the '<em><b>Preemption Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final PreemptionType[] VALUES_ARRAY =
		new PreemptionType[] {
			NOT_PPREEMPTABLE,
			FULLY_PREEMPTABLE,
			COOPERATIVELY_PREEMPTABLE,
		};

	/**
	 * A public read-only list of all the '<em><b>Preemption Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<PreemptionType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Preemption Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static PreemptionType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			PreemptionType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Preemption Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static PreemptionType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			PreemptionType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Preemption Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static PreemptionType get(int value) {
		switch (value) {
			case NOT_PPREEMPTABLE_VALUE: return NOT_PPREEMPTABLE;
			case FULLY_PREEMPTABLE_VALUE: return FULLY_PREEMPTABLE;
			case COOPERATIVELY_PREEMPTABLE_VALUE: return COOPERATIVELY_PREEMPTABLE;
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
	private PreemptionType(int value, String name, String literal) {
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
	
} //PreemptionType
