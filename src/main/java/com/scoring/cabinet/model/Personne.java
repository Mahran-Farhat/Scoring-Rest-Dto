package com.scoring.cabinet.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="personnes")
public class Personne {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cin;
    private String firstname;
    private String lastname;

    @OneToMany(mappedBy = "personne",fetch = FetchType.LAZY)
    private List<Voiture> voitureList;

    @ManyToMany
    @JoinTable(name="personne_taches",
            joinColumns = @JoinColumn(name = "personne_id"),
            inverseJoinColumns = @JoinColumn(name = "tache_id"))
    private List<Tache> taches;

    public Personne(){ }

    public long getCin() {
        return cin;
    }

    public void setCin(long cin) {
        this.cin = cin;
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

    public List<Voiture> getVoitureList() {
        return voitureList;
    }

    public void setVoitureList(List<Voiture> voitureList) {
        this.voitureList = voitureList;
    }
}
