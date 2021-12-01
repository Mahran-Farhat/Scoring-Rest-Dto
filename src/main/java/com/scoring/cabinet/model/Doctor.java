package com.scoring.cabinet.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "doctors")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotEmpty(message = "Nom est obligatoire")
    @Size(min = 3, max = 10, message = "taille de nom doit être entre 3 et 10 caractères")
    @Pattern(regexp = "[a-zA-Z]+", message = "le nom doit contenir que des caratères")
    private String firstname;
    @NotEmpty(message = "prenom est obligatoire")
    @Size(min = 3, max = 10, message = "taille de prenom doit être entre 3 et 10 caractères")
    @Pattern(regexp = "[a-zA-Z]+", message = "le prenom doit contenir que des caratères")
    private String lastname;
    @NotEmpty(message = "Specialité est obligatoire")
    private String speciality;

    @OneToMany(mappedBy = "doctor",fetch = FetchType.LAZY)
    private List<Rdv> rdvs;

    public Doctor(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public List<Rdv> getRdvs() {
        return rdvs;
    }

    public void setRdvs(List<Rdv> rdvs) {
        this.rdvs = rdvs;
    }
}
