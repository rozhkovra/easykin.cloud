package ru.rrozhkov.easykin.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
public class PersonRest {
    @Autowired
    private PersonRepository personRepository;

    @GetMapping("/")
    public Iterable<PersonEntity> persons() {
        return personRepository.findAll();
    }

    @GetMapping("/{id}")
    public PersonEntity person(@PathVariable Long id) {
        return personRepository.findById(id).orElse(null);
    }
}
