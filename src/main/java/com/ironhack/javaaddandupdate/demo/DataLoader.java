package com.ironhack.javaaddandupdate.demo;
import com.ironhack.javaaddandupdate.model.Doctor;
import com.ironhack.javaaddandupdate.model.Patient;
import com.ironhack.javaaddandupdate.repository.DoctorRepository;
import com.ironhack.javaaddandupdate.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public void run(String... args) throws Exception {
        loadDoctors();
        loadPatients();
    }

    private void loadDoctors() {
        if (doctorRepository.count() == 0) {
            createDoctor("cardiology", "Alonso Flores", "ON_CALL");
            createDoctor("immunology", "Sam Ortega", "ON");
            createDoctor("cardiology", "German Ruiz", "OFF");
            createDoctor("pulmonary", "Maria Lin", "ON");
            createDoctor("orthopaedic", "Paolo Rodriguez", "ON_CALL");
            createDoctor("psychiatric", "John Paul Armes", "OFF");
        }
    }

    private void createDoctor(String department, String name, String status) {
        Doctor doctor = new Doctor();
        doctor.setDepartment(department);
        doctor.setName(name);
        doctor.setStatus(status);
        doctorRepository.save(doctor);
    }

    private void loadPatients() {
        if (patientRepository.count() == 0) {
            createPatient("Jaime Jordan", LocalDate.of(1984, 3, 2), 564134L);
            createPatient("Marian Garcia", LocalDate.of(1972, 1, 12), 564134L);
            createPatient("Julia Dusterdieck", LocalDate.of(1954, 6, 11), 356712L);
            createPatient("Steve McDuck", LocalDate.of(1931, 11, 10), 761527L);
            createPatient("Marian Garcia", LocalDate.of(1999, 2, 15), 172456L);
        }
    }

    private void createPatient(String name, LocalDate dateOfBirth, Long admittedByDoctorId) {
        Doctor admittingDoctor = doctorRepository.findById(admittedByDoctorId).orElse(null);
        if (admittingDoctor != null) {
            Patient patient = new Patient();
            patient.setName(name);
            patient.setDateOfBirth(dateOfBirth);
            patient.setAdmittedBy(admittingDoctor.getEmployeeId());
            patientRepository.save(patient);
        }
    }
}