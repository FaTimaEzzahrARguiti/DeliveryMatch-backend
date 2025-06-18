package com.example.deliverymatch.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor

public class Annonce {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String depart;
    private String heure;
    private LocalDate dateDepart;
    private String arret;
    private String capacite;
    private String typeColier;
    private Double poids;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDepart() {
        return depart;
    }

    public void setDepart(String depart) {
        this.depart = depart;
    }

    public String getHeure() {
        return heure;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }

    public LocalDate getDateDepart() {
        return dateDepart;
    }

    public void setDateDepart(LocalDate dateDepart) {
        this.dateDepart = dateDepart;
    }

    public String getArret() {
        return arret;
    }

    public void setArret(String arret) {
        this.arret = arret;
    }

    public String getCapacite() {
        return capacite;
    }

    public void setCapacite(String capacite) {
        this.capacite = capacite;
    }

    public String getTypeColier() {
        return typeColier;
    }

    public void setTypeColier(String typeColier) {
        this.typeColier = typeColier;
    }

    public Double getPoids() {
        return poids;
    }

    public void setPoids(Double poids) {
        this.poids = poids;
    }
}
