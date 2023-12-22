package com.ironhack.javaaddandupdate.repository;
import com.ironhack.javaaddandupdate.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {

}
