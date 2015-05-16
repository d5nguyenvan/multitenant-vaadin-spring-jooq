package de.eiswind.vaadin.tenancy;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import de.eiswind.vaadin.datalayer.daos.master.TenantDao;
import de.eiswind.vaadin.datalayer.tables.interfaces.ITenant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Logger;

/**
 * Created by thomas on 09.05.15.
 */

@Component
@Qualifier("no-tx")
public class MultiTenantDataSource implements DataSource {

    @Autowired
    private TenantAuthentication authentication;

    @Autowired
    private TenantDao tenantDao;

    @Autowired
    private TenantHelper tenantHelper;


//    @Autowired
//    private CurrentTenantIdentifierResolver tenantIdentifierResolver;

    private Map<String, DataSource> dataSourceMap = new ConcurrentHashMap<>();

    @Override
    public Connection getConnection() throws SQLException {
        DataSource ds = getDataSource();
        return ds.getConnection();
    }

    private DataSource getDataSource() {

        String tenantName = authentication.getTenant(); // will throw if not authenticated
        return  dataSourceMap.computeIfAbsent(tenantName, (key)->{
            Optional<ITenant> tenantOptional = tenantDao.findbyName(tenantName);
            return tenantOptional.map(tenant -> {
                HikariConfig config = tenantHelper.toHikariConfig(tenant);
                return new HikariDataSource(config);
            }).orElseThrow(() -> new IllegalStateException("This should never happen: Unknown tenant " + tenantName));
        });

    }

    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public PrintWriter getLogWriter() throws SQLException {
        DataSource ds = getDataSource();
        return ds.getLogWriter();
    }

    @Override
    public void setLogWriter(PrintWriter out) throws SQLException {
        DataSource ds = getDataSource();
        ds.setLogWriter(out);
    }

    @Override
    public void setLoginTimeout(int seconds) throws SQLException {
        DataSource ds = getDataSource();
        ds.setLoginTimeout(seconds);
    }

    @Override
    public int getLoginTimeout() throws SQLException {
        DataSource ds = getDataSource();
        return ds.getLoginTimeout();
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        DataSource ds = getDataSource();
        return ds.getParentLogger();
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        DataSource ds = getDataSource();
        return ds.unwrap(iface);
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        DataSource ds = getDataSource();
        return ds.isWrapperFor(iface);
    }
}
