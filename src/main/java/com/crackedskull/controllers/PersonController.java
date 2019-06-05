package com.crackedskull.controllers;

import com.crackedskull.domain.Person;
import com.crackedskull.exceptions.PersonNotFoundException;
import com.crackedskull.services.PersonService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/people")
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public Person create(@RequestBody Person person) {
        return personService.save(person);
    }

    @GetMapping
    public Iterable<Person> find() {
        return personService.findAll();
    }

    @PutMapping("/{id}")
    public Person update(@PathVariable Long id, @RequestBody Person person) {
        person.setId(id);
        return personService.save(person);
    }

    @PatchMapping("/{id}")
    public Person partialUpdate(@PathVariable Long id, @RequestBody Map<String, String> patch) throws PersonNotFoundException {
        return personService.partialSave(id, patch);
    }
}
