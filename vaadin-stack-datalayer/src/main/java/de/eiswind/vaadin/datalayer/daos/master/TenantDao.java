package de.eiswind.vaadin.datalayer.daos.master;

import de.eiswind.vaadin.datalayer.tables.interfaces.ITenant;
import de.eiswind.vaadin.datalayer.tables.records.TenantRecord;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.Optional;

import static de.eiswind.vaadin.datalayer.Tables.TENANT;

/**
 * Created by thomas on 16.05.15.
 */
@Component
public class TenantDao {

    @Autowired
    @Qualifier("master")
    private DataSource masterDataSource;

    public Optional<ITenant> findbyName(String name){
        DSLContext dsl = DSL.using(masterDataSource, SQLDialect.POSTGRES_9_4);
        TenantRecord tenantRecord= dsl.selectFrom(TENANT)
                .where(TENANT.TENANT_NAME.eq(name))
                .fetchOne();
       return Optional.ofNullable(tenantRecord);


    }

}
