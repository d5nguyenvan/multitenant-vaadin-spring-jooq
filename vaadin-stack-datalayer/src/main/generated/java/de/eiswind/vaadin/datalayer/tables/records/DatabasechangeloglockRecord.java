/**
 * This class is generated by jOOQ
 */
package de.eiswind.vaadin.datalayer.tables.records;


import de.eiswind.vaadin.datalayer.tables.Databasechangeloglock;
import de.eiswind.vaadin.datalayer.tables.interfaces.IDatabasechangeloglock;

import java.sql.Timestamp;

import javax.annotation.Generated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record4;
import org.jooq.Row;
import org.jooq.Row4;
import org.jooq.impl.UpdatableRecordImpl;


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
public class DatabasechangeloglockRecord extends UpdatableRecordImpl<DatabasechangeloglockRecord> implements Record4<Integer, Boolean, Timestamp, String>, IDatabasechangeloglock {

	private static final long serialVersionUID = 695714493;

	/**
	 * Setter for <code>public.DATABASECHANGELOGLOCK.ID</code>.
	 */
	@Override
	public void setId(Integer value) {
		setValue(0, value);
	}

	/**
	 * Getter for <code>public.DATABASECHANGELOGLOCK.ID</code>.
	 */
	@NotNull
	@Override
	public Integer getId() {
		return (Integer) getValue(0);
	}

	/**
	 * Setter for <code>public.DATABASECHANGELOGLOCK.LOCKED</code>.
	 */
	@Override
	public void setLocked(Boolean value) {
		setValue(1, value);
	}

	/**
	 * Getter for <code>public.DATABASECHANGELOGLOCK.LOCKED</code>.
	 */
	@NotNull
	@Override
	public Boolean getLocked() {
		return (Boolean) getValue(1);
	}

	/**
	 * Setter for <code>public.DATABASECHANGELOGLOCK.LOCKGRANTED</code>.
	 */
	@Override
	public void setLockgranted(Timestamp value) {
		setValue(2, value);
	}

	/**
	 * Getter for <code>public.DATABASECHANGELOGLOCK.LOCKGRANTED</code>.
	 */
	@Override
	public Timestamp getLockgranted() {
		return (Timestamp) getValue(2);
	}

	/**
	 * Setter for <code>public.DATABASECHANGELOGLOCK.LOCKEDBY</code>.
	 */
	@Override
	public void setLockedby(String value) {
		setValue(3, value);
	}

	/**
	 * Getter for <code>public.DATABASECHANGELOGLOCK.LOCKEDBY</code>.
	 */
	@Size(max = 255)
	@Override
	public String getLockedby() {
		return (String) getValue(3);
	}

	// -------------------------------------------------------------------------
	// Primary key information
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Record1<Integer> key() {
		return (Record1) super.key();
	}

	// -------------------------------------------------------------------------
	// Record4 type implementation
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Row4<Integer, Boolean, Timestamp, String> fieldsRow() {
		return (Row4) super.fieldsRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Row4<Integer, Boolean, Timestamp, String> valuesRow() {
		return (Row4) super.valuesRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Integer> field1() {
		return Databasechangeloglock.DATABASECHANGELOGLOCK.ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Boolean> field2() {
		return Databasechangeloglock.DATABASECHANGELOGLOCK.LOCKED;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Timestamp> field3() {
		return Databasechangeloglock.DATABASECHANGELOGLOCK.LOCKGRANTED;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field4() {
		return Databasechangeloglock.DATABASECHANGELOGLOCK.LOCKEDBY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer value1() {
		return getId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Boolean value2() {
		return getLocked();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Timestamp value3() {
		return getLockgranted();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String value4() {
		return getLockedby();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public DatabasechangeloglockRecord value1(Integer value) {
		setId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public DatabasechangeloglockRecord value2(Boolean value) {
		setLocked(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public DatabasechangeloglockRecord value3(Timestamp value) {
		setLockgranted(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public DatabasechangeloglockRecord value4(String value) {
		setLockedby(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public DatabasechangeloglockRecord values(Integer value1, Boolean value2, Timestamp value3, String value4) {
		value1(value1);
		value2(value2);
		value3(value3);
		value4(value4);
		return this;
	}

	// -------------------------------------------------------------------------
	// FROM and INTO
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void from(IDatabasechangeloglock from) {
		setId(from.getId());
		setLocked(from.getLocked());
		setLockgranted(from.getLockgranted());
		setLockedby(from.getLockedby());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public <E extends IDatabasechangeloglock> E into(E into) {
		into.from(this);
		return into;
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Create a detached DatabasechangeloglockRecord
	 */
	public DatabasechangeloglockRecord() {
		super(Databasechangeloglock.DATABASECHANGELOGLOCK);
	}

	/**
	 * Create a detached, initialised DatabasechangeloglockRecord
	 */
	public DatabasechangeloglockRecord(Integer id, Boolean locked, Timestamp lockgranted, String lockedby) {
		super(Databasechangeloglock.DATABASECHANGELOGLOCK);

		setValue(0, id);
		setValue(1, locked);
		setValue(2, lockgranted);
		setValue(3, lockedby);
	}
}