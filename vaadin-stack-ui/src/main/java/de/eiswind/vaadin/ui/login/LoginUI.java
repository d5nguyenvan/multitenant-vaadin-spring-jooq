package de.eiswind.vaadin.ui.login;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.navigator.SpringViewProvider;
import com.vaadin.ui.UI;
import org.springframework.beans.factory.annotation.Autowired;


@SpringUI(path = "/login")
@Title("Vaadin Spring-Security Sample")
@Theme("valo")
public class LoginUI extends UI {

    private static final long serialVersionUID = 5310014981075920878L;
    
    @Autowired
    private SpringViewProvider ViewProvider;
    
    @Override
    protected void init(VaadinRequest request) {
        
        Navigator navigator = new Navigator(this, this);
        navigator.addProvider(ViewProvider);
        setNavigator(navigator);
    }

}