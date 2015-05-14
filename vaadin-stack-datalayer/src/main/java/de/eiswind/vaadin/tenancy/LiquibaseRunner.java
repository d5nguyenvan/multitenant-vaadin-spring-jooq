package de.eiswind.vaadin.tenancy;

import de.eiswind.vaadin.datalayer.tables.records.TenantRecord;
import liquibase.Liquibase;
import liquibase.database.jvm.JdbcConnection;
import liquibase.exception.LiquibaseException;
import liquibase.resource.ClassLoaderResourceAccessor;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

import static de.eiswind.vaadin.datalayer.Tables.TENANT;

/**
 * Created by thomas on 14.05.15.
 */

@Component
@DependsOn("liquibase")
public class LiquibaseRunner {

    private static Logger LOG = LoggerFactory.getLogger(LiquibaseRunner.class);

    @Autowired
    private DataSource masterDataSource;

    @PostConstruct
    public void init() {

        DSLContext dsl = DSL.using(masterDataSource, SQLDialect.POSTGRES_9_4);
        List<TenantRecord> tenantRecords = dsl.select().from(TENANT).fetch().into(TenantRecord.class);
        tenantRecords.forEach(tenant -> {
            try {
                LOG.info("Migrating schema for tenant " + tenant.getTenantName());
                Liquibase migrator = new Liquibase("/changelog/master/tenant/changelog-tenant-master.xml", new ClassLoaderResourceAccessor(), new JdbcConnection(masterDataSource.getConnection()));
                migrator.setChangeLogParameter("db.schema", tenant.getTenantName());

                migrator.update("tenant");
            } catch (SQLException | LiquibaseException e) {
                LOG.error("Liquibase FAILED !!", e);

            }

        });

    }
}