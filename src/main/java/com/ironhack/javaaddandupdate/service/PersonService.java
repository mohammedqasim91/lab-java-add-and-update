package com.ironhack.javaaddandupdate.service;
import com.ironhack.javaaddandupdate.model.Person;
import com.ironhack.javaaddandupdate.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public Person updatePersonAge(Long id, int age) {
        Optional<Person> optionalPerson = personRepository.findById(id);
        if (optionalPerson.isPresent()) {
            Person person = optionalPerson.get();
            person.setAge(age);
            return personRepository.save(person);
        }
        return null;
    }

    public Person addPerson(Person person) {
        return personRepository.save(person);
    }

    public Person clonePerson(Person person) {
        Person clonedPerson = new Person();
        clonedPerson.setName(person.getName());
        clonedPerson.setAge(person.getAge());
        clonedPerson.setOccupation(person.getOccupation());
        return personRepository.save(clonedPerson);
    }

    public void writePersonToFile(Person person) {
        String filename = "person_" + person.getId() + ".txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write(person.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Person findByName(String name) {
        return personRepository.findByName(name);
    }
}



