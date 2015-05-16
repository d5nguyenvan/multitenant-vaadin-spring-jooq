package de.eiswind.vaadin.spring.jooq;

import de.eiswind.vaadin.tenancy.MultiTenantDataSource;
import de.eiswind.vaadin.tenancy.TenantAuthentication;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.jooq.ConnectionProvider;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.conf.MappedSchema;
import org.jooq.conf.RenderMapping;
import org.jooq.conf.Settings;
import org.jooq.impl.DataSourceConnectionProvider;
import org.jooq.impl.DefaultConfiguration;
import org.jooq.impl.DefaultDSLContext;
import org.jooq.impl.DefaultExecuteListenerProvider;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by thomas on 16.05.15.
 */
@Configuration
public class DslConfiguration {

    @Autowired
    private MultiTenantDataSource multiTenantDataSource;

    @Autowired
    private TenantAuthentication authentication;

    @Bean
    public DataSourceTransactionManager transactionManager(){
        DataSourceTransactionManager transactionManager= new DataSourceTransactionManager();
        transactionManager.setDataSource(multiTenantDataSource);
        return transactionManager;
    }

    @Bean
    @Primary
    public TransactionAwareDataSourceProxy transactionAwareDataSource(){
        return new TransactionAwareDataSourceProxy(multiTenantDataSource);
    }

    @Bean
    public DSLContext dsl(){

        return ProxyFactory.getProxy(DSLContext.class, new MethodInterceptor() {

            Map<String, DSLContext> contextMap = new ConcurrentHashMap<>();
            @Override
            public Object invoke(MethodInvocation invocation) throws Throwable {
                String tenant = authentication.getTenant(); // will throw if not authenticated
                DSLContext ctx = contextMap.computeIfAbsent(tenant, (key) ->{

                    Settings settings = new Settings()
                            .withRenderMapping(new RenderMapping().withSchemata(new MappedSchema().withInput("master").withOutput(key)));
                    DefaultConfiguration configuration = new DefaultConfiguration();
                    configuration.setSQLDialect(SQLDialect.POSTGRES_9_4);
                    configuration.setSettings(settings);
                    configuration.setConnectionProvider(connectionProvider());
                    configuration.setExecuteListenerProvider(new DefaultExecuteListenerProvider(new ExceptionTranslator()));
                    return new DefaultDSLContext(configuration);
                });
                return invocation.getMethod().invoke(ctx, invocation.getArguments());
            }
        });
    }


    private ConnectionProvider connectionProvider() {
        return new DataSourceConnectionProvider(transactionAwareDataSource());
    }


}
