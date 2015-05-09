package de.eiswind.vaadin.repository;

import de.eiswind.vaadin.datalayer.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

/**
 * Created by thomas on 09.05.15.
 */
public interface UserRepository extends JpaRepository<User, Long>, QueryDslPredicateExecutor<User>{
}
