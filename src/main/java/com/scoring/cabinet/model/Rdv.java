package com.scoring.cabinet.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="rdvs")
public class Rdv {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private LocalDateTime time;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_patient",referencedColumnName = "id_patient")
    // Foreign key(id_patient) references patient(id_patient)
    private Patient patient;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_doctor",referencedColumnName = "id")
    // Foreign key(id_doctor) references doctors(id)
    private Doctor doctor;

    public Rdv(){
        this.patient = new Patient();
        this.doctor = new Doctor();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
}
