package com.example.appwebuc9;


import com.example.appwebuc9.controller.Controller;
import com.example.appwebuc9.model.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PersonControllerTestOperation {

    @Autowired
    Controller personController;

    @Test
    public void testSaveCompletePerson(){
            Person p = personController.addPerson("Gabriel", "m");
            Assertions.assertEquals(1, p.getId());
            Assertions.assertEquals("Gabriel", p.getName());
            Assertions.assertEquals("m", p.getSexo());

    }
}
