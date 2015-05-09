package de.eiswind.vaadin.spring;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.sql.DataSource;

@SpringBootApplication
@ComponentScan(basePackages = "de.eiswind.vaadin")
@EnableJpaRepositories(basePackages = "repository")
@EntityScan(basePackages = "de.eiswind.vaadin.datalayer")
@Configuration
public class VaadinApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(VaadinApplication.class, args);
    }

    @Bean
    @Qualifier("master")
    @ConfigurationProperties(prefix="spring.datasource-master")
    public DataSource getMasterDataSource(){
        return  DataSourceBuilder.create().build();
    }
}