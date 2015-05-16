package de.eiswind.vaadin.datalayer.daos.tenant;

import de.eiswind.vaadin.datalayer.tables.interfaces.IUser;
import de.eiswind.vaadin.datalayer.tables.pojos.User;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static de.eiswind.vaadin.datalayer.Tables.USER;

/**
 * Created by thomas on 16.05.15.
 */
@Component
public class UserDao {

    /**
     * the dsl context.
     *
     * the context we inject here is actually a proxy bound to the current tenant schema
     * backed by a datasource that has only access to this tenant schema
     */
    @Autowired
    DSLContext dsl;

    public List<IUser> findAll() {
        return dsl.selectFrom(USER).fetchInto(User.class);
    }
}
