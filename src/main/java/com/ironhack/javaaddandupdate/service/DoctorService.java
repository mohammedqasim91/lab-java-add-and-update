package com.ironhack.javaaddandupdate.service;
import com.ironhack.javaaddandupdate.model.Doctor;
import com.ironhack.javaaddandupdate.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.NoSuchElementException;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    public Doctor addDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    public Doctor updateDoctorStatus(Long id, String status) {
        Doctor doctor = doctorRepository.findById(id).orElseThrow(NoSuchElementException::new);
        doctor.setStatus(status);
        return doctorRepository.save(doctor);
    }

    public Doctor updateDoctorDepartment(Long id, String department) {
        Doctor doctor = doctorRepository.findById(id).orElseThrow(NoSuchElementException::new);
        doctor.setDepartment(department);
        return doctorRepository.save(doctor);
    }

    public Doctor findById(Long id) {
        return doctorRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    public void writeDoctorToFile(Doctor doctor) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("doctor_" + doctor.getEmployeeId() + ".txt"))) {
            writer.write(doctor.toString());
        }
    }
}

