package de.eiswind.vaadin.spring;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@SpringBootApplication
@ComponentScan(basePackages = {"de.eiswind.vaadin","org.vaadin.spring.config"})
@Configuration
public class VaadinApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(VaadinApplication.class, args);
    }

    @Bean
    @Qualifier("master")
    @ConfigurationProperties(prefix="spring.datasource")
    public DataSource getMasterDataSource(){
        return  DataSourceBuilder.create().build();
    }
}