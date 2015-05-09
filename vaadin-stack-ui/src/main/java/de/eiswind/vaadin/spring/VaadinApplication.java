package de.eiswind.vaadin.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "de.eiswind.vaadin")
@EnableJpaRepositories(basePackages = "repository")
@EntityScan(basePackages = "de.eiswind.vaadin.datalayer")
public class VaadinApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(VaadinApplication.class, args);
    }
}