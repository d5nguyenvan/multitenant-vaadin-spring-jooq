package de.eiswind.vaadin.tenancy;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

/**
 * Created by thomas on 16.05.15.
 */
public class TenantAuthenticationToken extends UsernamePasswordAuthenticationToken implements TenantAuthentication{

    private final String tenant;

    public TenantAuthenticationToken(String tenant, Object principal, Object credentials) {
        super(principal, credentials);
        this.tenant = tenant;
    }

    public TenantAuthenticationToken(String tenant, Object principal, Object credentials, List<GrantedAuthority> authorities) {
        super(principal, credentials, authorities);
        this.tenant = tenant;
    }

    public String getTenant() {
        return tenant;
    }

    public static void main(String[] args) {
        System.out.println(new BCryptPasswordEncoder().encode("admin"));
    }

}
