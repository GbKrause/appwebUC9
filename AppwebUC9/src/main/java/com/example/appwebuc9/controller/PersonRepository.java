package com.example.appwebsenai.controller;

import com.example.appwebsenai.model.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository<Person> extends CrudRepository<Person, Integer> {
    Person findByName(String name);
}