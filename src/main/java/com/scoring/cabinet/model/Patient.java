package com.scoring.cabinet.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="clients")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_patient;
    @Column(name = "first",length = 30, nullable = false)
    private String firstname;
    private String lastname;
    @Column(unique = true)
    private String email;
    private String phone;

    @OneToMany(mappedBy = "patient",fetch = FetchType.LAZY)
    private List<Rdv> rdvs;

    public Patient(){

    }

    public long getId() {
        return id_patient;
    }

    public void setId(long id) {
        this.id_patient = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public long getId_patient() {
        return id_patient;
    }

    public void setId_patient(long id_patient) {
        this.id_patient = id_patient;
    }

    public List<Rdv> getRdvs() {
        return rdvs;
    }

    public void setRdvs(List<Rdv> rdvs) {
        this.rdvs = rdvs;
    }
}
