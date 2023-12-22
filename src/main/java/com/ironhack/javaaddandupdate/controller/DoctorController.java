package com.ironhack.javaaddandupdate.controller;
import com.ironhack.javaaddandupdate.model.Doctor;
import com.ironhack.javaaddandupdate.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    @Autowired
    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @PostMapping
    public ResponseEntity<Doctor> addDoctor(@RequestBody Doctor doctor) {
        Doctor createdDoctor = doctorService.addDoctor(doctor);
        return new ResponseEntity<>(createdDoctor, HttpStatus.CREATED);
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<Doctor> updateDoctorStatus(@PathVariable Long id, @RequestBody String status) {
        Doctor updatedDoctor = doctorService.updateDoctorStatus(id, status);
        if (updatedDoctor == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updatedDoctor, HttpStatus.OK);
    }

    @PatchMapping("/{id}/department")
    public ResponseEntity<Doctor> updateDoctorDepartment(@PathVariable Long id, @RequestBody String department) {
        Doctor updatedDoctor = doctorService.updateDoctorDepartment(id, department);
        if (updatedDoctor == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updatedDoctor, HttpStatus.OK);
    }
}
