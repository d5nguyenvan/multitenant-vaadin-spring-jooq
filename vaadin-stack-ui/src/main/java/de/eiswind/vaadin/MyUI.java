package de.eiswind.vaadin;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import de.eiswind.vaadin.datalayer.daos.tenant.UserDao;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 */
@Theme("valo")
@SpringUI
public class MyUI extends UI {

    @Autowired
    private UserDao userDao;

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        VerticalLayout verticalLayout = new VerticalLayout();
        userDao.findAll().forEach( user -> {
            Label l = new Label(user.getUserName());
            verticalLayout.addComponent(l);
        });

        setContent(verticalLayout);
    }
}
