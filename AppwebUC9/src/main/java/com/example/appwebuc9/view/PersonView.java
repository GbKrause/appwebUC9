package com.example.appwebuc9.view;

import com.example.appwebuc9.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.appwebuc9.controller.PersonController;

import java.util.List;

@RestController
public class PersonView {

    @Autowired
    private PersonService personService;

    @GetMapping("/person")
    public Person findPerson(@RequestParam("name") String name) {
        return personService.findPerson(name);
    }

    @DeleteMapping("/person")
    public String deletePerson(@RequestParam("name") String name) {
        boolean removed = personService.removePerson(name);
        if (removed) {
            return "Pessoa com o nome de " + name + " foi removida.";
        } else {
            return "Pessoa com o nome de " + name + " não encontrada.";
        }
    }

    @PostMapping("/person")
    public Person addPerson(@RequestParam("name") String name, @RequestParam("sexo") String sexo) {
        return personService.addPerson(name, sexo);
    }

    @PutMapping("/person/{id}")
    public Person updatePerson(@PathVariable("id") int id, @RequestParam("name") String name, @RequestParam("sexo") String sexo) {
        return personService.editPerson(id, name, sexo);
    }

    @GetMapping("/home")
    public String helloWorld() {
        return "Hello World";
    }
}