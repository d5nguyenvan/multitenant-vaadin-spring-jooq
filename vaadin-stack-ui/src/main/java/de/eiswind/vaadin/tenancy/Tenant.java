package de.eiswind.vaadin.tenancy;

import com.zaxxer.hikari.HikariConfig;

import java.util.Properties;

/**
 * Created by thomas on 09.05.15.
 */
public class Tenant {

    String tenant;

    String host;

    int port;

    String database;

    String user;

    String password;

    int minConnections;

    int maxConnections;

    public String getTenant() {
        return tenant;
    }

    public void setTenant(String tenant) {
        this.tenant = tenant;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getMinConnections() {
        return minConnections;
    }

    public void setMinConnections(int minConnections) {
        this.minConnections = minConnections;
    }

    public int getMaxConnections() {
        return maxConnections;
    }

    public void setMaxConnections(int maxConnections) {
        this.maxConnections = maxConnections;
    }

    protected HikariConfig toHikariConfig(){
        Properties props = new Properties();

        props.setProperty("user", user);
        props.setProperty("password", password);
        props.setProperty("databaseName",database);
        props.setProperty("serverName", host);
        props.setProperty("portNumber", new Integer(port).toString());
        HikariConfig cfg = new HikariConfig();
        cfg.setDataSourceClassName("org.postgresql.ds.PGSimpleDataSource");
        cfg.setDataSourceProperties(props);
        cfg.setPoolName("Pool for "+tenant);
        cfg.setMinimumIdle(minConnections);
        cfg.setMaximumPoolSize(maxConnections);
        cfg.setAutoCommit(false);
        return cfg;
    }
}
