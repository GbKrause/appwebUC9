package com.example.appwebuc9.controller;

import com.example.appwebuc9.model.Person;
import org.springframework.stereotype.Service;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

@Service
public class Controller {

    private List<Person> persons = new ArrayList<>();
    private int id = 0;

    public Person findPerson (String name){
        for(Person p : persons){
            if(p.getName().equals(name)){
                return p;
            }
        }
        return null;
    }

    public Person addPerson (String name, String sexo){
        Person person = new Person();
        person.setName(name);
        person.setSexo(sexo);
        id++;
        person.setId(id);
        persons.add(person);
        return person;
    }

    public boolean removePerson(String name){
        Person personRemove = null;
        for(Person p : persons){
            if(p.getName().equals(name)){
                personRemove = p;
                break;
            }
        }
        if(personRemove != null){
            persons.remove(personRemove);
            return true;
        }
        return false;
    }


    public Person editPerson(int id, String name, String sexo) {

        Person personUpdate = null;
        for (Person person : persons) {
            if (person.getId() == id) {
                person.setName(name);
                person.setSexo(sexo);
                personUpdate = person;
                break;
            }
        }
        return personUpdate;
    }


}
