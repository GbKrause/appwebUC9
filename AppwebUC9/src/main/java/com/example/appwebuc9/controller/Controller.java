package com.example.appwebuc9.controller;

import com.example.appwebuc9.model.Person;
import com.example.appwebsenai.controller.PersonRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.ArrayList;

@Service
public class Controller {

    @Autowired
    private PersonRepository personRepository;

    private List<Person> persons = new ArrayList<>();
    private int id = 0;

    public Person findPerson(String name){
        List<Person> persons = (List<Person>) personRepository.findAll();
        for(Person person : persons){
            if(person.getName().equals(name)){
                return person;
            }
        }
        return null;
    }

    public Person addPerson(String name, String sexo) {
        Person person = new Person();
        person.setName(name);
        person.setSexo(sexo);
        id++;
        person.SetId(id);
        personRepository.save(person);
        return person;
    }

    public void removePerson(String name) {
       Person person = findPerson(name);
       personRepository.delete(person);
    }

    public Person editPerson(String name, String sexo) {
       Person person = findPerson(name);
       person.SetSexo(sexo);
       personRepository.save(person);
       return person;
    }

    public List<Person> listAll() {
        return (List<Person>) personRepository.findAll();
    }
}