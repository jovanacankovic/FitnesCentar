package com.example.fitnessCenter.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class FitnessCentar implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY) //inkrementalno generisanje kljuceva prilikom cuvanja u bazi
    private Long id;
    @Column(nullable = false)
    private String nazivCentra;
    @Column(nullable = false)
    private String adresaCentra;
    @Column
    private String brojTelefonaCentrale;
    @Column
    private String emailCentra;

    @JsonIgnore
    @OneToMany(mappedBy = "fitnessCentar",fetch = FetchType.EAGER,cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<Trener> treneri = new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "fitnessCentar",fetch = FetchType.EAGER,orphanRemoval = true)
    private Set<Sala> sale = new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "fitnessCentar",fetch = FetchType.EAGER,cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<ListaTreninga> rasporediTreninga = new HashSet<>();

    public FitnessCentar() {
    }

    public FitnessCentar(Long id, String nazivCentra, String adresaCentra, String brojTelefonaCentrale, String emailCentra) {
        this.id = id;
        this.nazivCentra = nazivCentra;
        this.adresaCentra = adresaCentra;
        this.brojTelefonaCentrale = brojTelefonaCentrale;
        this.emailCentra = emailCentra;
    }

    public FitnessCentar(String nazivCentra, String adresaCentra, String brojTelefonaCentrale, String emailCentra) {
        this.nazivCentra = nazivCentra;
        this.adresaCentra = adresaCentra;
        this.brojTelefonaCentrale = brojTelefonaCentrale;
        this.emailCentra = emailCentra;
    }
    public FitnessCentar(String nazivCentra, String adresaCentra, String brojTelefonaCentrale, String emailCentra,Set<Sala> sala) {
        this.nazivCentra = nazivCentra;
        this.adresaCentra = adresaCentra;
        this.brojTelefonaCentrale = brojTelefonaCentrale;
        this.emailCentra = emailCentra;
        this.sale = sala;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNazivCentra() {
        return nazivCentra;
    }

    public void setNazivCentra(String nazivCentra) {
        this.nazivCentra = nazivCentra;
    }

    public String getAdresaCentra() {
        return adresaCentra;
    }

    public void setAdresaCentra(String adresaCentra) {
        this.adresaCentra = adresaCentra;
    }

    public String getBrojTelefonaCentrale() {
        return brojTelefonaCentrale;
    }

    public void setBrojTelefonaCentrale(String brojTelefonaCentrale) {
        this.brojTelefonaCentrale = brojTelefonaCentrale;
    }

    public String getEmailCentra() {
        return emailCentra;
    }

    public void setEmailCentra(String emailCentra) {
        this.emailCentra = emailCentra;
    }

    public Set<Trener> getTreneri() {
        return treneri;
    }

    public void setTreneri(Set<Trener> treneri) {
        this.treneri = treneri;
    }

    public Set<Sala> getSale() {
        return sale;
    }

    public void setSale(Set<Sala> sale) {
        this.sale = sale;
    }

    public Set<ListaTreninga> getRasporediTreninga() {
        return rasporediTreninga;
    }

    public void setRasporediTreninga(Set<ListaTreninga> rasporediTreninga) {
        this.rasporediTreninga = rasporediTreninga;
    }
}
