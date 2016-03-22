package de.eiswind.vaadin.ui.login;

import com.vaadin.event.ShortcutAction.KeyCode;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.Responsive;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import de.eiswind.vaadin.tenancy.TenantAuthenticationToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.vaadin.spring.security.VaadinSecurity;

@SpringView(name = LoginView.NAME, ui = LoginUI.class)
@UIScope
public class LoginView extends VerticalLayout implements View {

    private static final long serialVersionUID = -4430276235082912377L;

    public static final String NAME = "";

    @Autowired
    private VaadinSecurity security;


    private TextField username;
    private TextField tenant;
    private PasswordField password;
    private CheckBox rememberMe = new CheckBox("Remember me", true);

    public LoginView() {
        setSizeFull();

        Component loginForm = buildLoginForm();
        addComponent(loginForm);
        setComponentAlignment(loginForm, Alignment.MIDDLE_CENTER);

    }


    @Override
    public void enter(ViewChangeEvent event) {
        username.focus();
    }

    private Component buildLoginForm() {
        final VerticalLayout loginPanel = new VerticalLayout();
        loginPanel.setSizeUndefined();
        loginPanel.setSpacing(true);
        Responsive.makeResponsive(loginPanel);
        loginPanel.addStyleName("login-panel");

        loginPanel.addComponent(buildLabels());
        loginPanel.addComponent(buildFields());
        loginPanel.addComponent(rememberMe);
        return loginPanel;
    }

    private Component buildFields() {
        VerticalLayout fields = new VerticalLayout();
        fields.setSpacing(true);
        fields.addStyleName("fields");

        tenant = new TextField("Customer");
        tenant.setId("customer");
        tenant.setIcon(FontAwesome.CLOUD);
        tenant.addStyleName(ValoTheme.TEXTFIELD_INLINE_ICON);

        username = new TextField("Username");
        username.setId("username");
        username.setIcon(FontAwesome.USER);
        username.addStyleName(ValoTheme.TEXTFIELD_INLINE_ICON);

        password = new PasswordField("Password");
        password.setId("password");
        password.setIcon(FontAwesome.LOCK);
        password.addStyleName(ValoTheme.TEXTFIELD_INLINE_ICON);

        final Button signin = new Button("Sign In");
        signin.setId("signInButton");
        signin.addStyleName(ValoTheme.BUTTON_PRIMARY);
        signin.setClickShortcut(KeyCode.ENTER);
        signin.focus();

        fields.addComponents(tenant, username, password, signin);
        fields.setComponentAlignment(signin, Alignment.BOTTOM_LEFT);

        signin.addClickListener(event -> {

            try {
                TenantAuthenticationToken token = new TenantAuthenticationToken(tenant.getValue(),username.getValue(),password.getValue());
                security.login(token);

            } catch (AuthenticationException e) {
               Notification.show("Login failed", Notification.Type.ERROR_MESSAGE);
            } catch (Exception e) {
                e.printStackTrace();
            }
            // TODO Register Remember me Token
                
                /*
                 * Redirect is handled by the VaadinRedirectStrategy
                 * User is redirected to either always the default
                 * or the URL the user request before authentication
                 * 
                 * Strategy is configured within SecurityConfiguration
                 * Defaults to User request URL.
                 */
        });


        return fields;
    }

    private Component buildLabels() {
        CssLayout labels = new CssLayout();
        labels.addStyleName("labels");

        Label welcome = new Label("Welcome");
        welcome.setSizeUndefined();
        welcome.addStyleName(ValoTheme.LABEL_H4);
        welcome.addStyleName(ValoTheme.LABEL_COLORED);
        labels.addComponent(welcome);

        Label title = new Label("Vaadin-Stack");
        title.setSizeUndefined();
        title.addStyleName(ValoTheme.LABEL_H3);
        title.addStyleName(ValoTheme.LABEL_LIGHT);
        labels.addComponent(title);
        return labels;
    }

}