/**
 * This class is generated by jOOQ
 */
package de.eiswind.vaadin.datalayer.tenant;


import de.eiswind.vaadin.datalayer.tenant.Sequences;
import de.eiswind.vaadin.datalayer.tenant.tables.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Sequence;
import org.jooq.Table;
import org.jooq.impl.SchemaImpl;


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
public class Tenant extends SchemaImpl {

	private static final long serialVersionUID = 42793812;

	/**
	 * The reference instance of <code>tenant</code>
	 */
	public static final Tenant TENANT = new Tenant();

	/**
	 * No further instances allowed
	 */
	private Tenant() {
		super("tenant");
	}

	@Override
	public final List<Sequence<?>> getSequences() {
		List result = new ArrayList();
		result.addAll(getSequences0());
		return result;
	}

	private final List<Sequence<?>> getSequences0() {
		return Arrays.<Sequence<?>>asList(
			Sequences.USER_ID_SEQ);
	}

	@Override
	public final List<Table<?>> getTables() {
		List result = new ArrayList();
		result.addAll(getTables0());
		return result;
	}

	private final List<Table<?>> getTables0() {
		return Arrays.<Table<?>>asList(
			User.USER);
	}
}
