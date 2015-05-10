package de.eiswind.vaadin.tenancy;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import de.eiswind.vaadin.datalayer.public_.tables.records.TenantRecord;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import static de.eiswind.vaadin.datalayer.public_.Tables.TENANT;

/**
 * Created by thomas on 09.05.15.
 */

@Component
@Primary
public class MultiTenantDataSource implements DataSource {

    @Autowired
    @Qualifier("master")
    private DataSource tenantMasterDataSource;

    @Autowired
    private TenantHelper tenantHelper;



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
            DSLContext dsl = DSL.using(tenantMasterDataSource, SQLDialect.POSTGRES_9_4);
            TenantRecord tenantRecord= dsl.select().from(TENANT).where(TENANT.TENANT_NAME.eq(tenant)).fetchOne().into(TenantRecord.class);
            HikariConfig config = tenantHelper.toHikariConfig(tenantRecord);
            ds = new HikariDataSource(config);
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
