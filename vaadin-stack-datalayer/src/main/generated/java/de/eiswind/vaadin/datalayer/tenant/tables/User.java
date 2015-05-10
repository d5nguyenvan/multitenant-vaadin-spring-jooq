/**
 * This class is generated by jOOQ
 */
package de.eiswind.vaadin.datalayer.tenant.tables;


import de.eiswind.vaadin.datalayer.tenant.Keys;
import de.eiswind.vaadin.datalayer.tenant.Tenant;
import de.eiswind.vaadin.datalayer.tenant.tables.records.UserRecord;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Identity;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.TableImpl;


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
public class User extends TableImpl<UserRecord> {

	private static final long serialVersionUID = 1282154697;

	/**
	 * The reference instance of <code>tenant.user</code>
	 */
	public static final User USER = new User();

	/**
	 * The class holding records for this type
	 */
	@Override
	public Class<UserRecord> getRecordType() {
		return UserRecord.class;
	}

	/**
	 * The column <code>tenant.user.id</code>.
	 */
	public final TableField<UserRecord, Long> ID = createField("id", org.jooq.impl.SQLDataType.BIGINT.nullable(false).defaulted(true), this, "");

	/**
	 * The column <code>tenant.user.user_name</code>.
	 */
	public final TableField<UserRecord, String> USER_NAME = createField("user_name", org.jooq.impl.SQLDataType.VARCHAR.length(255).nullable(false), this, "");

	/**
	 * Create a <code>tenant.user</code> table reference
	 */
	public User() {
		this("user", null);
	}

	/**
	 * Create an aliased <code>tenant.user</code> table reference
	 */
	public User(String alias) {
		this(alias, USER);
	}

	private User(String alias, Table<UserRecord> aliased) {
		this(alias, aliased, null);
	}

	private User(String alias, Table<UserRecord> aliased, Field<?>[] parameters) {
		super(alias, Tenant.TENANT, aliased, parameters, "");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Identity<UserRecord, Long> getIdentity() {
		return Keys.IDENTITY_USER;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UniqueKey<UserRecord> getPrimaryKey() {
		return Keys.PK_USER;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<UniqueKey<UserRecord>> getKeys() {
		return Arrays.<UniqueKey<UserRecord>>asList(Keys.PK_USER, Keys.UK_USER_USER_NAME);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public User as(String alias) {
		return new User(alias, this);
	}

	/**
	 * Rename this table
	 */
	public User rename(String name) {
		return new User(name, null);
	}
}
