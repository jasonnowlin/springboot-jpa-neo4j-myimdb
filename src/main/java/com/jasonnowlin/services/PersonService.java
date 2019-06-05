package com.jasonnowlin.services;

import com.jasonnowlin.domain.Person;
import com.jasonnowlin.exceptions.PersonNotFoundException;
import com.jasonnowlin.repositories.PersonRepository;
import java.util.Map;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private final PersonRepository personRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public PersonService(PersonRepository personRepository, ModelMapper modelMapper) {
        this.personRepository = personRepository;
        this.modelMapper = modelMapper;
    }

    public Person save(Person person) {
        return personRepository.save(person);
    }

    public Person partialSave(Long id, Map<String, String> patch) throws PersonNotFoundException {
        Optional<Person> person = personRepository.findById(id);
        if (person.isPresent()) {
            modelMapper.map(patch, person.get());
            return personRepository.save(person.get());
        } else {
            throw new PersonNotFoundException();
        }
    }

    public Iterable<Person> findAll() {
        return personRepository.findAll();
    }

}
