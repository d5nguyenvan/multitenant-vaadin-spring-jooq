package de.eiswind.vaadin.spring.security;

import de.eiswind.vaadin.datalayer.daos.master.AuthenticationDao;
import de.eiswind.vaadin.datalayer.tables.interfaces.IVUser;
import de.eiswind.vaadin.tenancy.TenantAuthenticationToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Optional;

/**
 * Created by thomas on 16.05.15.
 */
@Component
public class TenantAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private AuthenticationDao authenticationDao;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        TenantAuthenticationToken token = (TenantAuthenticationToken) authentication;
        Optional<? extends IVUser> ivUser = authenticationDao.findVUserByAuthentication(token.getTenant(), token.getName(), (String) token.getCredentials());
        return ivUser.map(user -> {
            // TODO fill in granted authorities here
            return new TenantAuthenticationToken(token.getTenant(), token.getName(),  token.getCredentials(), new ArrayList<>());
        }).orElseThrow(() -> new BadCredentialsException("Login failed", new RuntimeException()));
    }


    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(TenantAuthenticationToken.class);
    }
}