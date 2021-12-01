package com.scoring.cabinet.controller;

import com.scoring.cabinet.exception.ResourceNotFound;
import com.scoring.cabinet.exception.ResponseMessage;
import com.scoring.cabinet.model.Doctor;
import com.scoring.cabinet.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.print.Doc;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/")
public class DoctorRest {

    @Autowired
    DoctorService agent;

    @PostMapping("/doctors")
    public Doctor add_Doctor( @Valid @RequestBody Doctor doctor){
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

    @PutMapping("/doctors/{id}")
    public Doctor update_doctor(@PathVariable("id") long id, @Valid @RequestBody Doctor doctor) throws ResourceNotFound{
        Doctor d = this.agent.find_doctor(id).orElseThrow(
                ()-> new ResourceNotFound("Doctor not found for id : "+id)
        );

        d.setFirstname(doctor.getFirstname());
        d.setLastname(doctor.getLastname());
        d.setSpeciality(doctor.getSpeciality());
        return agent.saveorupdate(d);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {

        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage()));

        return errors;
    }

}
