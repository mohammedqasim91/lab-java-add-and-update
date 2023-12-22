package com.ironhack.javaaddandupdate.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@Entity
@Data
@AllArgsConstructor
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String name;

    @NonNull
    private int age;

    @NonNull
    private String occupation;

    public Person() {}

    @Override
    public String toString() {
        return "Person{id=" + id + ", name='" + name + "', age=" + age + ", occupation='" + occupation + "'}";
    }
}


