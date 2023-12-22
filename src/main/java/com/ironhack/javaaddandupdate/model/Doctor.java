package com.ironhack.javaaddandupdate.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@Entity
@Data
@AllArgsConstructor
@Table(name = "doctor")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;

    @NonNull
    private String department;

    @NonNull
    private String name;

    @NonNull
    private String status;

    public Doctor(String department, String name, String status) {
        this.department = department;
        this.name = name;
        this.status = status;
    }

    public Doctor() {
    }
}
