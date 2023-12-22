package com.ironhack.javaaddandupdate.repository;
import com.ironhack.javaaddandupdate.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    Optional<Patient> findByName(String name);
}

