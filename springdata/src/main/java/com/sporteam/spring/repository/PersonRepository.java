package com.sporteam.spring.repository;

import com.sporteam.spring.model.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PersonRepository<P> extends CrudRepository<Person, Long> {

    List<Person> findByFirstName(String firstName);

}
