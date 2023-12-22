package com.ironhack.javaaddandupdate.service;
import com.ironhack.javaaddandupdate.model.Patient;
import com.ironhack.javaaddandupdate.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.NoSuchElementException;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public Patient addPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public Patient updatePatient(Long id, Patient patientDetails) {
        Patient patient = patientRepository.findById(id).orElseThrow(NoSuchElementException::new);
        patient.setName(patientDetails.getName());
        patient.setDateOfBirth(patientDetails.getDateOfBirth());
        patient.setAdmittedBy(patientDetails.getAdmittedBy());
        return patientRepository.save(patient);
    }

    public Patient findByName(String name) {
        return patientRepository.findByName(name).orElseThrow(NoSuchElementException::new);
    }

    public void writePatientToFile(Patient patient) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("patient_" + patient.getPatientId() + ".txt"))) {
            writer.write(patient.toString());
        }
    }
}

