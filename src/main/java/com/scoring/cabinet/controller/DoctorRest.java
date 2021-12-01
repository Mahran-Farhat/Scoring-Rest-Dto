package com.scoring.cabinet.controller;

import com.scoring.cabinet.exception.ResourceNotFound;
import com.scoring.cabinet.exception.ResponseMessage;
import com.scoring.cabinet.model.Doctor;
import com.scoring.cabinet.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class DoctorRest {

    @Autowired
    DoctorService agent;

    @PostMapping("/doctors")
    public Doctor add_Doctor(@RequestBody Doctor doctor){
        return this.agent.saveorupdate(doctor);
    }

    @GetMapping("/doctors")
    public List<Doctor> consulte_doctor(){
        return this.agent.consulte();
    }

    @GetMapping("/doctors/{id}")
    public Doctor get_doctor(@PathVariable("id") long id) throws ResourceNotFound{
        Doctor doctor =  this.agent.find_doctor(id).orElseThrow(
                ()-> new ResourceNotFound("Doctor not found for id : "+id)
        );
        return doctor;
    }

    @DeleteMapping("/doctors/{id}")
    public ResponseEntity<?> delete_doctor(@PathVariable("id") long id) throws ResourceNotFound{
        Doctor doctor = this.agent.find_doctor(id).orElseThrow(
                ()-> new ResourceNotFound("Doctor not found for id : "+id)
        );
        this.agent.delete_Doctor(id);
        return ResponseEntity.ok().body(new ResponseMessage("deleted : True"));
    }

}
