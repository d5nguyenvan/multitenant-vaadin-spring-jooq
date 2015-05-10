/**
 * This class is generated by jOOQ
 */
package de.eiswind.vaadin.datalayer.public_.tables.records;


import de.eiswind.vaadin.datalayer.public_.tables.Tenant;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record10;
import org.jooq.Row;
import org.jooq.Row10;
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
public class TenantRecord extends UpdatableRecordImpl<TenantRecord> implements Record10<Long, String, String, Integer, String, String, String, String, Integer, Integer> {

	private static final long serialVersionUID = 296227331;

	/**
	 * Setter for <code>public.tenant.id</code>.
	 */
	public void setId(Long value) {
		setValue(0, value);
	}

	/**
	 * Getter for <code>public.tenant.id</code>.
	 */
	public Long getId() {
		return (Long) getValue(0);
	}

	/**
	 * Setter for <code>public.tenant.tenant_name</code>.
	 */
	public void setTenantName(String value) {
		setValue(1, value);
	}

	/**
	 * Getter for <code>public.tenant.tenant_name</code>.
	 */
	public String getTenantName() {
		return (String) getValue(1);
	}

	/**
	 * Setter for <code>public.tenant.host</code>.
	 */
	public void setHost(String value) {
		setValue(2, value);
	}

	/**
	 * Getter for <code>public.tenant.host</code>.
	 */
	public String getHost() {
		return (String) getValue(2);
	}

	/**
	 * Setter for <code>public.tenant.port</code>.
	 */
	public void setPort(Integer value) {
		setValue(3, value);
	}

	/**
	 * Getter for <code>public.tenant.port</code>.
	 */
	public Integer getPort() {
		return (Integer) getValue(3);
	}

	/**
	 * Setter for <code>public.tenant.database</code>.
	 */
	public void setDatabase(String value) {
		setValue(4, value);
	}

	/**
	 * Getter for <code>public.tenant.database</code>.
	 */
	public String getDatabase() {
		return (String) getValue(4);
	}

	/**
	 * Setter for <code>public.tenant.schema</code>.
	 */
	public void setSchema(String value) {
		setValue(5, value);
	}

	/**
	 * Getter for <code>public.tenant.schema</code>.
	 */
	public String getSchema() {
		return (String) getValue(5);
	}

	/**
	 * Setter for <code>public.tenant.user</code>.
	 */
	public void setUser(String value) {
		setValue(6, value);
	}

	/**
	 * Getter for <code>public.tenant.user</code>.
	 */
	public String getUser() {
		return (String) getValue(6);
	}

	/**
	 * Setter for <code>public.tenant.password</code>.
	 */
	public void setPassword(String value) {
		setValue(7, value);
	}

	/**
	 * Getter for <code>public.tenant.password</code>.
	 */
	public String getPassword() {
		return (String) getValue(7);
	}

	/**
	 * Setter for <code>public.tenant.min_idle</code>.
	 */
	public void setMinIdle(Integer value) {
		setValue(8, value);
	}

	/**
	 * Getter for <code>public.tenant.min_idle</code>.
	 */
	public Integer getMinIdle() {
		return (Integer) getValue(8);
	}

	/**
	 * Setter for <code>public.tenant.max_connections</code>.
	 */
	public void setMaxConnections(Integer value) {
		setValue(9, value);
	}

	/**
	 * Getter for <code>public.tenant.max_connections</code>.
	 */
	public Integer getMaxConnections() {
		return (Integer) getValue(9);
	}

	// -------------------------------------------------------------------------
	// Primary key information
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Record1<Long> key() {
		return (Record1) super.key();
	}

	// -------------------------------------------------------------------------
	// Record10 type implementation
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Row10<Long, String, String, Integer, String, String, String, String, Integer, Integer> fieldsRow() {
		return (Row10) super.fieldsRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Row10<Long, String, String, Integer, String, String, String, String, Integer, Integer> valuesRow() {
		return (Row10) super.valuesRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Long> field1() {
		return Tenant.TENANT.ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field2() {
		return Tenant.TENANT.TENANT_NAME;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field3() {
		return Tenant.TENANT.HOST;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Integer> field4() {
		return Tenant.TENANT.PORT;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field5() {
		return Tenant.TENANT.DATABASE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field6() {
		return Tenant.TENANT.SCHEMA;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field7() {
		return Tenant.TENANT.USER;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field8() {
		return Tenant.TENANT.PASSWORD;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Integer> field9() {
		return Tenant.TENANT.MIN_IDLE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Integer> field10() {
		return Tenant.TENANT.MAX_CONNECTIONS;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Long value1() {
		return getId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String value2() {
		return getTenantName();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String value3() {
		return getHost();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer value4() {
		return getPort();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String value5() {
		return getDatabase();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String value6() {
		return getSchema();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String value7() {
		return getUser();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String value8() {
		return getPassword();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer value9() {
		return getMinIdle();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer value10() {
		return getMaxConnections();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public TenantRecord value1(Long value) {
		setId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public TenantRecord value2(String value) {
		setTenantName(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public TenantRecord value3(String value) {
		setHost(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public TenantRecord value4(Integer value) {
		setPort(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public TenantRecord value5(String value) {
		setDatabase(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public TenantRecord value6(String value) {
		setSchema(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public TenantRecord value7(String value) {
		setUser(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public TenantRecord value8(String value) {
		setPassword(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public TenantRecord value9(Integer value) {
		setMinIdle(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public TenantRecord value10(Integer value) {
		setMaxConnections(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public TenantRecord values(Long value1, String value2, String value3, Integer value4, String value5, String value6, String value7, String value8, Integer value9, Integer value10) {
		value1(value1);
		value2(value2);
		value3(value3);
		value4(value4);
		value5(value5);
		value6(value6);
		value7(value7);
		value8(value8);
		value9(value9);
		value10(value10);
		return this;
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Create a detached TenantRecord
	 */
	public TenantRecord() {
		super(Tenant.TENANT);
	}

	/**
	 * Create a detached, initialised TenantRecord
	 */
	public TenantRecord(Long id, String tenantName, String host, Integer port, String database, String schema, String user, String password, Integer minIdle, Integer maxConnections) {
		super(Tenant.TENANT);

		setValue(0, id);
		setValue(1, tenantName);
		setValue(2, host);
		setValue(3, port);
		setValue(4, database);
		setValue(5, schema);
		setValue(6, user);
		setValue(7, password);
		setValue(8, minIdle);
		setValue(9, maxConnections);
	}
}
