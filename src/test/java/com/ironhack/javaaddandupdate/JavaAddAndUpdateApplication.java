package com.ironhack.javaaddandupdate;

import com.ironhack.javaaddandupdate.model.Person;
import com.ironhack.javaaddandupdate.repository.PersonRepository;
import com.ironhack.javaaddandupdate.service.PersonService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

@SuppressWarnings("ALL")
@SpringBootTest
class JavaAddAndUpdateApplicationTests {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PersonService personService;

    @Test
    void contextLoads() {
    }

    @Test
    void testAddPerson() {
        Person person = new Person(null, "John Doe", 30, "Engineer");
        Person savedPerson = personService.addPerson(person);
        assertNotNull(savedPerson.getId());
        assertEquals("John Doe", savedPerson.getName());
    }

    @Test
    void testUpdatePersonAge() {
        Person person = new Person(null, "Jane Doe", 25, "Doctor");
        Person savedPerson = personService.addPerson(person);
        personService.updatePersonAge(savedPerson.getId(), 26);
        Person updatedPerson = personRepository.findById(savedPerson.getId()).orElse(null);
        assertNotNull(updatedPerson);
        assertEquals(26, updatedPerson.getAge());
    }

    @Test
    void testFindByName() {
        Person person = new Person(null, "Alice Smith", 40, "Nurse");
        personService.addPerson(person);
        Person foundPerson = personService.findByName("Alice Smith");
        assertNotNull(foundPerson);
        assertEquals("Alice Smith", foundPerson.getName());
    }

    @Test
    void testClonePerson() {
        Person person = new Person(null, "Bob Johnson", 50, "Manager");
        Person savedPerson = personService.addPerson(person);
        Person clonedPerson = personService.clonePerson(savedPerson);
        assertNotNull(clonedPerson.getId());
        assertNotEquals(savedPerson.getId(), clonedPerson.getId());
        assertEquals(savedPerson.getName(), clonedPerson.getName());
    }

    @Test
    void testWritePersonToFile() throws IOException {
        Person person = new Person(null, "Charlie Brown", 35, "Technician");
        Person savedPerson = personService.addPerson(person);
        personService.writePersonToFile(savedPerson);
        File file = new File("person_" + savedPerson.getId() + ".txt");
        assertTrue(file.exists());
        file.delete(); // Clean up after test
    }
}


