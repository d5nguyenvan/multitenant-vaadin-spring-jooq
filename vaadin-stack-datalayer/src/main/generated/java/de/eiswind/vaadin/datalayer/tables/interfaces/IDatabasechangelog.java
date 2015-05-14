/**
 * This class is generated by jOOQ
 */
package de.eiswind.vaadin.datalayer.tables.interfaces;


import java.io.Serializable;
import java.sql.Timestamp;

import javax.annotation.Generated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


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
public interface IDatabasechangelog extends Serializable {

	/**
	 * Setter for <code>public.DATABASECHANGELOG.ID</code>.
	 */
	public void setId(String value);

	/**
	 * Getter for <code>public.DATABASECHANGELOG.ID</code>.
	 */
	@NotNull
	@Size(max = 255)
	public String getId();

	/**
	 * Setter for <code>public.DATABASECHANGELOG.AUTHOR</code>.
	 */
	public void setAuthor(String value);

	/**
	 * Getter for <code>public.DATABASECHANGELOG.AUTHOR</code>.
	 */
	@NotNull
	@Size(max = 255)
	public String getAuthor();

	/**
	 * Setter for <code>public.DATABASECHANGELOG.FILENAME</code>.
	 */
	public void setFilename(String value);

	/**
	 * Getter for <code>public.DATABASECHANGELOG.FILENAME</code>.
	 */
	@NotNull
	@Size(max = 255)
	public String getFilename();

	/**
	 * Setter for <code>public.DATABASECHANGELOG.DATEEXECUTED</code>.
	 */
	public void setDateexecuted(Timestamp value);

	/**
	 * Getter for <code>public.DATABASECHANGELOG.DATEEXECUTED</code>.
	 */
	@NotNull
	public Timestamp getDateexecuted();

	/**
	 * Setter for <code>public.DATABASECHANGELOG.ORDEREXECUTED</code>.
	 */
	public void setOrderexecuted(Integer value);

	/**
	 * Getter for <code>public.DATABASECHANGELOG.ORDEREXECUTED</code>.
	 */
	@NotNull
	public Integer getOrderexecuted();

	/**
	 * Setter for <code>public.DATABASECHANGELOG.EXECTYPE</code>.
	 */
	public void setExectype(String value);

	/**
	 * Getter for <code>public.DATABASECHANGELOG.EXECTYPE</code>.
	 */
	@NotNull
	@Size(max = 10)
	public String getExectype();

	/**
	 * Setter for <code>public.DATABASECHANGELOG.MD5SUM</code>.
	 */
	public void setMd5sum(String value);

	/**
	 * Getter for <code>public.DATABASECHANGELOG.MD5SUM</code>.
	 */
	@Size(max = 35)
	public String getMd5sum();

	/**
	 * Setter for <code>public.DATABASECHANGELOG.DESCRIPTION</code>.
	 */
	public void setDescription(String value);

	/**
	 * Getter for <code>public.DATABASECHANGELOG.DESCRIPTION</code>.
	 */
	@Size(max = 255)
	public String getDescription();

	/**
	 * Setter for <code>public.DATABASECHANGELOG.COMMENTS</code>.
	 */
	public void setComments(String value);

	/**
	 * Getter for <code>public.DATABASECHANGELOG.COMMENTS</code>.
	 */
	@Size(max = 255)
	public String getComments();

	/**
	 * Setter for <code>public.DATABASECHANGELOG.TAG</code>.
	 */
	public void setTag(String value);

	/**
	 * Getter for <code>public.DATABASECHANGELOG.TAG</code>.
	 */
	@Size(max = 255)
	public String getTag();

	/**
	 * Setter for <code>public.DATABASECHANGELOG.LIQUIBASE</code>.
	 */
	public void setLiquibase(String value);

	/**
	 * Getter for <code>public.DATABASECHANGELOG.LIQUIBASE</code>.
	 */
	@Size(max = 20)
	public String getLiquibase();

	// -------------------------------------------------------------------------
	// FROM and INTO
	// -------------------------------------------------------------------------

	/**
	 * Load data from another generated Record/POJO implementing the common interface IDatabasechangelog
	 */
	public void from(de.eiswind.vaadin.datalayer.tables.interfaces.IDatabasechangelog from);

	/**
	 * Copy data into another generated Record/POJO implementing the common interface IDatabasechangelog
	 */
	public <E extends de.eiswind.vaadin.datalayer.tables.interfaces.IDatabasechangelog> E into(E into);
}