package com.ironhack.javaaddandupdate.controller;
import com.ironhack.javaaddandupdate.model.Person;
import com.ironhack.javaaddandupdate.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/persons")
public class PersonController {

    @Autowired
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public ResponseEntity<Person> addPerson(@Validated @RequestBody Person person) {
        Person createdPerson = personService.addPerson(person);
        return new ResponseEntity<>(createdPerson, HttpStatus.CREATED);
    }

    @PostMapping("/clone")
    public ResponseEntity<Person> clonePerson(@RequestBody Person person) {
        Person clonedPerson = personService.clonePerson(person);
        return new ResponseEntity<>(clonedPerson, HttpStatus.CREATED);
    }

    @PostMapping("/writeToFile")
    public ResponseEntity<String> writePersonToFile(@RequestBody Person person) {
        personService.writePersonToFile(person);
        return new ResponseEntity<>("Person information written to file successfully.", HttpStatus.OK);
    }
}
