package com.ironhack.javaaddandupdate.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@Table(name = "patient")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long patientId;

    @NonNull
    private String name;

    @NonNull
    private LocalDate dateOfBirth;

    @NonNull
    private Long admittedBy;

    public Patient(String name, LocalDate dateOfBirth, Long admittedBy) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.admittedBy = admittedBy;
    }

    public Patient() {

    }
}
