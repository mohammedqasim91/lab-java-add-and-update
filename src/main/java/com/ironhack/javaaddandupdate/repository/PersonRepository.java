package com.ironhack.javaaddandupdate.repository;
import com.ironhack.javaaddandupdate.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
    Person findByName(String name);
}



