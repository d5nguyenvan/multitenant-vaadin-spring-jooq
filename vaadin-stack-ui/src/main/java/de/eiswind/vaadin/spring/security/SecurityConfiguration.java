package de.eiswind.vaadin.spring.security;

import de.eiswind.vaadin.tenancy.TenantAuthentication;
import de.eiswind.vaadin.tenancy.TenantAuthenticationToken;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.security.web.authentication.RememberMeServices;
import org.springframework.security.web.authentication.rememberme.TokenBasedRememberMeServices;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;
import org.springframework.security.web.authentication.session.SessionFixationProtectionStrategy;
import org.vaadin.spring.http.HttpService;
import org.vaadin.spring.security.VaadinSecurityContext;
import org.vaadin.spring.security.annotation.EnableVaadinSharedSecurity;
import org.vaadin.spring.security.config.VaadinSharedSecurityConfiguration;
import org.vaadin.spring.security.shared.VaadinAuthenticationSuccessHandler;
import org.vaadin.spring.security.shared.VaadinSessionClosingLogoutHandler;
import org.vaadin.spring.security.shared.VaadinUrlAuthenticationSuccessHandler;
import org.vaadin.spring.security.web.VaadinRedirectStrategy;


@Configuration
@ComponentScan
@EnableWebSecurity
public class SecurityConfiguration {


    @Bean(name = "currentToken")
    TenantAuthentication currentToken() {

        return ProxyFactory.getProxy(TenantAuthentication.class, new MethodInterceptor() {

            @Override
            public Object invoke(MethodInvocation invocation) throws Throwable {
                SecurityContext securityContext = SecurityContextHolder.getContext();
                TenantAuthenticationToken authentication = (TenantAuthenticationToken) securityContext.getAuthentication();
                if (authentication == null) {
                    throw new AuthenticationCredentialsNotFoundException("No authentication found in current security context");
                }
                return invocation.getMethod().invoke(authentication, invocation.getArguments());
            }

        });

    }

    // TODO Spring-Boot-Actuator

    @Configuration
    @EnableVaadinSharedSecurity
    public static class WebSecurityConfig extends WebSecurityConfigurerAdapter {

        @Autowired
        private TenantAuthenticationProvider tenantAuthenticationProvider;

        @Autowired
        private VaadinSecurityContext vaadinSecurityContext;


        @Bean(name = "authenticationManager")
        @Override
        public AuthenticationManager authenticationManagerBean() throws Exception {
            return super.authenticationManagerBean();
        }


        @Bean
        public RememberMeServices rememberMeServices() {
            return new TokenBasedRememberMeServices("myAppKey", userDetailsService());
        }

        @Bean
        public SessionAuthenticationStrategy sessionAuthenticationStrategy() {
            return new SessionFixationProtectionStrategy();
        }

        @Bean(name = VaadinSharedSecurityConfiguration.VAADIN_AUTHENTICATION_SUCCESS_HANDLER_BEAN)
        VaadinAuthenticationSuccessHandler vaadinAuthenticationSuccessHandler(HttpService httpService,
                                                                              VaadinRedirectStrategy vaadinRedirectStrategy) {
            return new VaadinUrlAuthenticationSuccessHandler(httpService, vaadinRedirectStrategy, "/");
        }


        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth.authenticationProvider(tenantAuthenticationProvider);
        }


        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.csrf().disable(); // Use Vaadin's built-in CSRF protection instead
            http.authorizeRequests()
                    .antMatchers("/login/**").anonymous()
                    .antMatchers("/vaadinServlet/UIDL/**").permitAll()
                    .antMatchers("/vaadinServlet/HEARTBEAT/**").permitAll()
                    .anyRequest().authenticated();
            http.httpBasic().disable();
            http.formLogin().disable();
            // Remember to add the VaadinSessionClosingLogoutHandler
            http.logout().addLogoutHandler(new VaadinSessionClosingLogoutHandler()).logoutUrl("/logout")
                    .logoutSuccessUrl("/login?logout").permitAll();
            http.exceptionHandling().authenticationEntryPoint(new LoginUrlAuthenticationEntryPoint("/login"));
            // Instruct Spring Security to use the same RememberMeServices as Vaadin4Spring. Also remember the key.
            http.rememberMe().rememberMeServices(rememberMeServices()).key("myAppKey");
            // Instruct Spring Security to use the same authentication strategy as Vaadin4Spring
            http.sessionManagement().sessionAuthenticationStrategy(sessionAuthenticationStrategy());
        }

        @Override
        public void configure(WebSecurity web) throws Exception {
            web.ignoring().antMatchers("/VAADIN/**");
        }


    }

}