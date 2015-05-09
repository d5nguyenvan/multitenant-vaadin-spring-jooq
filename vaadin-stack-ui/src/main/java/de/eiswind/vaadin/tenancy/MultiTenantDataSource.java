package de.eiswind.vaadin.tenancy;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 * Created by thomas on 09.05.15.
 */

@Component
@Primary
public class MultiTenantDataSource implements DataSource {

    @Autowired
    @Qualifier("master")
    private DataSource tenantMasterDataSource;




//    @Autowired
//    private CurrentTenantIdentifierResolver tenantIdentifierResolver;

    private Map<String, DataSource> dataSourceMap = new HashMap<>();

    @Override
    public Connection getConnection() throws SQLException {
        DataSource ds = getDataSource();
        return ds.getConnection();
    }

    private DataSource getDataSource() {
//        String tenant = tenantIdentifierResolver.resolveCurrentTenantIdentifier();
        String tenant = "default";
        DataSource ds = dataSourceMap.get(tenant);
        if (ds != null) {
            return ds;
        }
        synchronized (this) {
            JdbcTemplate template = new JdbcTemplate(tenantMasterDataSource);
            String sql = "SELECT * from tenant WHERE tenant = ?";
            Tenant t = template.queryForObject(sql, new Object[]{tenant}, new BeanPropertyRowMapper<>(Tenant.class));
            ds = new HikariDataSource(t.toHikariConfig());
            dataSourceMap.put(tenant, ds);
        }
        return ds;
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
