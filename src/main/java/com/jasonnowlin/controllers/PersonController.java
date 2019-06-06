package com.jasonnowlin.controllers;

import com.jasonnowlin.domain.Person;
import com.jasonnowlin.exceptions.CustomExceptionDetails;
import com.jasonnowlin.exceptions.PersonNotFoundException;
import com.jasonnowlin.services.PersonService;
import java.time.Instant;
import java.util.Date;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
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

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        personService.delete(id);
    }

    @ExceptionHandler(PersonNotFoundException.class)
    public final ResponseEntity<CustomExceptionDetails> handlePersonNotFoundException() {
        CustomExceptionDetails customExceptionDetails = new CustomExceptionDetails(Date.from(Instant.now()), HttpStatus.BAD_REQUEST.value(), "Bad request", "Person not found", "/people/{id}");
        return new ResponseEntity<>(customExceptionDetails, HttpStatus.BAD_REQUEST);
    }
}
