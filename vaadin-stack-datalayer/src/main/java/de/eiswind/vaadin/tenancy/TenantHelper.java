package de.eiswind.vaadin.tenancy;

import com.zaxxer.hikari.HikariConfig;
import de.eiswind.vaadin.datalayer.public_.tables.records.TenantRecord;

import java.util.Properties;

/**
 * Created by thomas on 09.05.15.
 */
public class TenantHelper {



    protected static HikariConfig toHikariConfig(TenantRecord tenant) {
        Properties props = new Properties();

        props.setProperty("user", tenant.getUser());
        props.setProperty("password", tenant.getPassword());
        props.setProperty("databaseName", tenant.getDatabase());
        props.setProperty("serverName", tenant.getHost());
        props.setProperty("portNumber", tenant.getPort().toString());
        HikariConfig cfg = new HikariConfig();
        cfg.setDataSourceClassName("org.postgresql.ds.PGSimpleDataSource");
        cfg.setDataSourceProperties(props);
        cfg.setPoolName("Pool for " + tenant);
        cfg.setMinimumIdle(tenant.getMinIdle());
        cfg.setMaximumPoolSize(tenant.getMaxConnections());
        cfg.setAutoCommit(false);
        return cfg;
    }
}
