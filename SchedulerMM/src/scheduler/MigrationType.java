/**
 */
package scheduler;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Migration Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see scheduler.SchedulerPackage#getMigrationType()
 * @model
 * @generated
 */
public enum MigrationType implements Enumerator {
	/**
	 * The '<em><b>JOB LEVEL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #JOB_LEVEL_VALUE
	 * @generated
	 * @ordered
	 */
	JOB_LEVEL(0, "JOB_LEVEL", "JOB_LEVEL"),

	/**
	 * The '<em><b>TASK LEVEL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TASK_LEVEL_VALUE
	 * @generated
	 * @ordered
	 */
	TASK_LEVEL(1, "TASK_LEVEL", "TASK_LEVEL"),

	/**
	 * The '<em><b>NON MIGRATION</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NON_MIGRATION_VALUE
	 * @generated
	 * @ordered
	 */
	NON_MIGRATION(2, "NON_MIGRATION", "NON_MIGRATION");

	/**
	 * The '<em><b>JOB LEVEL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>JOB LEVEL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #JOB_LEVEL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int JOB_LEVEL_VALUE = 0;

	/**
	 * The '<em><b>TASK LEVEL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TASK LEVEL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TASK_LEVEL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TASK_LEVEL_VALUE = 1;

	/**
	 * The '<em><b>NON MIGRATION</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>NON MIGRATION</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NON_MIGRATION
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int NON_MIGRATION_VALUE = 2;

	/**
	 * An array of all the '<em><b>Migration Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final MigrationType[] VALUES_ARRAY =
		new MigrationType[] {
			JOB_LEVEL,
			TASK_LEVEL,
			NON_MIGRATION,
		};

	/**
	 * A public read-only list of all the '<em><b>Migration Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<MigrationType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Migration Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static MigrationType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			MigrationType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Migration Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static MigrationType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			MigrationType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Migration Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static MigrationType get(int value) {
		switch (value) {
			case JOB_LEVEL_VALUE: return JOB_LEVEL;
			case TASK_LEVEL_VALUE: return TASK_LEVEL;
			case NON_MIGRATION_VALUE: return NON_MIGRATION;
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
	private MigrationType(int value, String name, String literal) {
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
	
} //MigrationType
