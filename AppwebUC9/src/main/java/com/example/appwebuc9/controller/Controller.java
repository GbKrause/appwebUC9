package com.example.appwebuc9.controller;

import com.example.appwebuc9.model.Person;
import com.example.appwebsenai.controller.PersonRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@Service
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    public Person findPerson(String name) {
        return personRepository.findByName(name);
    }

    public Person addPerson(String name, String sexo) {
        Person person = new Person();
        person.setName(name);
        person.setSexo(sexo);
        return personRepository.save(person);
    }

    public boolean removePerson(String name) {
        Person person = personRepository.findByName(name);
        if (person != null) {
            personRepository.delete(person);
            return true;
        }
        return false;
    }

    public Person editPerson(int id, String name, String sexo) {
        Optional<Person> optionalPerson = personRepository.findById(id);
        if (optionalPerson.isPresent()) {
            Person person = optionalPerson.get();
            person.setName(name);
            person.setSexo(sexo);
            return personRepository.save(person);
        }
        return null;
    }

    public List<Person> listAll() {
        return (List<Person>) personRepository.findAll();
    }
}