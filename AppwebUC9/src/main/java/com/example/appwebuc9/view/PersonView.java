package com.example.appwebuc9.view;

import com.example.appwebuc9.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
public class PersonView {

    @Autowired
    Controller controller;

    @GetMapping("/person")
    public Person findPerson(@RequestParam("name") String name) {
        return controller.findPerson(name);
    }

    @DeleteMapping("/person")
    public String deletePerson(@PathParam("name") String name) {
        controller.removePerson(name);

        return "Pessoa com o nome de " + name + "foi removida.";
    }

    @PostMapping("/person")
    public Person addPerson(@PathParam("name") String name, @PathParam("sexo") String sexo) {
        return controller.addPerson(name, sexo);
    }

    @PutMapping("/person/{id}")
    public Person updatePerson(@PathParam("name") String name, @PathParam("sexo") String sexo) {
        return controller.editPerson(name, sexo);
    }

    @GetMapping("/all")
    public List<Person> listAll() {return controller.listAll();}

    @GetMapping("/home")
    public String helloWorld() {
        return "Hello World";
    }
}