package com.example.appwebuc9.controller;


import com.example.appwebsenai.model.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Integer > {
}