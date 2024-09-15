package com.example.demo.Controller;

import com.example.demo.entity.Person;
import com.example.demo.service.PersonService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personas")
public class PersonController {
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    @CrossOrigin()
    public List<Person> getAllPersons() {
        return personService.getAllPersons();
    }
}