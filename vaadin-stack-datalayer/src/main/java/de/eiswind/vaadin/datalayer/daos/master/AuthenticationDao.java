package de.eiswind.vaadin.datalayer.daos.master;

import de.eiswind.vaadin.datalayer.tables.interfaces.IVUser;
import de.eiswind.vaadin.datalayer.tables.records.VUserRecord;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.Optional;

import static de.eiswind.vaadin.datalayer.tables.VUser.V_USER;

/**
 * Created by thomas on 16.05.15.
 */
@Component
public class AuthenticationDao {

    @Autowired
    @Qualifier("master")
    private DataSource masterDataSource;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public Optional<? extends IVUser> findVUserByAuthentication(String tenant, String userName, String password){
        DSLContext dsl = DSL.using(masterDataSource, SQLDialect.POSTGRES_9_4);

        VUserRecord userRecord =dsl.selectFrom(V_USER)
                .where(V_USER.TENANT.eq(tenant))
                .and(V_USER.USER_NAME.eq(userName)).fetchOne();
        return Optional.ofNullable(userRecord).filter( user -> passwordEncoder.matches(password, user.getPasswordHash()));

    }
}
