package com.example.appwebuc9.view;

import com.example.appwebuc9.controller.Controller;
import com.example.appwebuc9.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;
@RestController
public class PersonView {

    @Autowired
    Controller controller;
    @GetMapping("/person")
    public Person findPerson(@PathParam("name") String name){
        return controller.findPerson(name);
    }

    @DeleteMapping("/person")
    public String deletePerson(@RequestParam("name") String name) {
        boolean removed = controller.removePerson(name);
        if (removed) {
            return "Pessoa com o nome de " + name + " foi deletada";
        } else {
            return "Pessoa com o nome de " + name + "não encontrada";
        }
    }

    @PostMapping("/person")
    public Person addperson(@PathParam("name") String name, @PathParam("sexo") String sexo){
        return controller.addPerson(name, sexo);
    }

    @PutMapping("/person")
    public Person updatePerson(@PathParam("id") int id, @PathParam("name") String name, @PathParam("sexo") String sexo){
       return controller.editPerson(id, name, sexo);
    }

    @GetMapping("/home")
    public String helloWorld(){
        return "Hello World";
    }
}
