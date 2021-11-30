package com.scoring.cabinet.model;


import javax.persistence.*;

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
}
