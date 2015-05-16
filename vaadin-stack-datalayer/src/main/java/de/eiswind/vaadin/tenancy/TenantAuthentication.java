package de.eiswind.vaadin.tenancy;

import org.springframework.security.core.Authentication;

/**
 * Created by thomas on 16.05.15.
 */
public interface TenantAuthentication extends Authentication {

    String getTenant();
}
