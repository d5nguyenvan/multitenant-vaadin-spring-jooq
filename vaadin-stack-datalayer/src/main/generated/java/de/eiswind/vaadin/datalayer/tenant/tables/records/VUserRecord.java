/**
 * This class is generated by jOOQ
 */
package de.eiswind.vaadin.datalayer.tenant.tables.records;


import de.eiswind.vaadin.datalayer.tenant.tables.VUser;

import javax.annotation.Generated;
import javax.validation.constraints.Size;

import org.jooq.Field;
import org.jooq.Record2;
import org.jooq.Row;
import org.jooq.Row2;
import org.jooq.impl.TableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
	value = {
		"http://www.jooq.org",
		"jOOQ version:3.6.1"
	},
	comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class VUserRecord extends TableRecordImpl<VUserRecord> implements Record2<String, String> {

	private static final long serialVersionUID = -116038953;

	/**
	 * Setter for <code>tenant.v_user.user_name</code>.
	 */
	public void setUserName(String value) {
		setValue(0, value);
	}

	/**
	 * Getter for <code>tenant.v_user.user_name</code>.
	 */
	@Size(max = 255)
	public String getUserName() {
		return (String) getValue(0);
	}

	/**
	 * Setter for <code>tenant.v_user.password_hash</code>.
	 */
	public void setPasswordHash(String value) {
		setValue(1, value);
	}

	/**
	 * Getter for <code>tenant.v_user.password_hash</code>.
	 */
	@Size(max = 2048)
	public String getPasswordHash() {
		return (String) getValue(1);
	}

	// -------------------------------------------------------------------------
	// Record2 type implementation
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Row2<String, String> fieldsRow() {
		return (Row2) super.fieldsRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Row2<String, String> valuesRow() {
		return (Row2) super.valuesRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field1() {
		return VUser.V_USER.USER_NAME;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field2() {
		return VUser.V_USER.PASSWORD_HASH;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String value1() {
		return getUserName();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String value2() {
		return getPasswordHash();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public VUserRecord value1(String value) {
		setUserName(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public VUserRecord value2(String value) {
		setPasswordHash(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public VUserRecord values(String value1, String value2) {
		value1(value1);
		value2(value2);
		return this;
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Create a detached VUserRecord
	 */
	public VUserRecord() {
		super(VUser.V_USER);
	}

	/**
	 * Create a detached, initialised VUserRecord
	 */
	public VUserRecord(String userName, String passwordHash) {
		super(VUser.V_USER);

		setValue(0, userName);
		setValue(1, passwordHash);
	}
}
