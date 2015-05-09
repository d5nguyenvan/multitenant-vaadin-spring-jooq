package de.eiswind.vaadin.datalayer;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by thomas on 09.05.15.
 */

@Entity
public class User {

    @Id
    private Long id;

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
