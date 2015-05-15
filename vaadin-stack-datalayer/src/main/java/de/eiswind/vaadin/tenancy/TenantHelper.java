package de.eiswind.vaadin.tenancy;

import com.zaxxer.hikari.HikariConfig;
import de.eiswind.vaadin.datalayer.tables.interfaces.ITenant;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Properties;



/**
 * Created by thomas on 09.05.15.
 */
@Component
/* package */ class TenantHelper {


    @Value("${tenant.tenant-datasource.database}")
    private String database;

    @Value("${tenant.tenant-datasource.host}")
    private String host;

    @Value("${tenant.tenant-datasource.port}")
    private String port;



    /* package*/ HikariConfig toHikariConfig(ITenant tenant) {
        Properties props = new Properties();

        props.setProperty("user", tenant.getTenantName());
        props.setProperty("password", tenant.getPassword());
        props.setProperty("databaseName", database);
        props.setProperty("serverName", host);
        props.setProperty("portNumber", port);
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
