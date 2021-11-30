package com.scoring.cabinet.model;

import javax.persistence.*;

@Entity
@Table(name="voiture")
public class Voiture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idv;
    private String marque;
    private String modele;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_personne",referencedColumnName = "cin")
    private  Personne personne;

    public Voiture(){}

    public long getIdv() {
        return idv;
    }

    public void setIdv(long idv) {
        this.idv = idv;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public Personne getPersonne() {
        return personne;
    }

    public void setPersonne(Personne personne) {
        this.personne = personne;
    }
}
