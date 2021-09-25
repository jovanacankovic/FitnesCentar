package com.example.fitnessCenter.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Trener extends Korisnik {

    @Column
    private double prosecnaOcena;

    @JsonIgnore
    @OneToMany(mappedBy = "trener", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Trening> listaTreninga = new HashSet<Trening>();

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    private FitnessCentar fitnessCentar;

    public Trener() {
    }

    public Trener(String korisnickoIme, String lozinka, String ime, String prezime, String telefon, String email, Date datumRodjenja, Uloga uloga, Boolean aktivan) {
        super(korisnickoIme, lozinka, ime, prezime, telefon, email, datumRodjenja, uloga, aktivan);
    }

    public Trener(String korisnickoIme, String lozinka, String ime, String prezime, String telefon, String email, Date datumRodjenja) {
        super(korisnickoIme, lozinka, ime, prezime, telefon, email, datumRodjenja);
    }

    public Trener(String korisnickoIme, String lozinka, String ime, String prezime, String telefon, String email, Date datumRodjenja, Uloga uloga) {
        super(korisnickoIme, lozinka, ime, prezime, telefon, email, datumRodjenja, uloga);
    }
    public Trener(String korisnickoIme, String lozinka, String ime, String prezime, String telefon, String email, Date datumRodjenja, Uloga uloga, boolean aktivan,boolean daLiJeRegistrovan) {
        super(korisnickoIme, lozinka, ime, prezime, telefon, email, datumRodjenja, uloga, aktivan, daLiJeRegistrovan);
    }

    public Trener(Long id, String korisnickoIme, String lozinka, String ime, String prezime, String telefon, String email, Date datumRodjenja, Uloga uloga, Boolean aktivan, boolean daLiJeRegistrovan) {
        super(id, korisnickoIme, lozinka, ime, prezime, telefon, email, datumRodjenja, uloga, aktivan, daLiJeRegistrovan);
    }

    public Trener(String korisnickoIme, String lozinka, String ime, String prezime, String telefon, String email, Date datumRodjenja, Uloga uloga, Boolean aktivan, double prosecnaOcena, Set<Trening> listaTreninga, FitnessCentar fitnessCentar) {
        super(korisnickoIme, lozinka, ime, prezime, telefon, email, datumRodjenja, uloga, aktivan);
        this.prosecnaOcena = prosecnaOcena;
        this.listaTreninga = listaTreninga;
        this.fitnessCentar = fitnessCentar;
    }

    public double getProsecnaOcena() {
        return prosecnaOcena;
    }

    public void setProsecnaOcena(double prosecnaOcena) {
        this.prosecnaOcena = prosecnaOcena;
    }

    public Set<Trening> getListaTreninga() {
        return listaTreninga;
    }

    public void setListaTreninga(Set<Trening> listaTreninga) {
        this.listaTreninga = listaTreninga;
    }

    public FitnessCentar getFitnessCentar() {
        return fitnessCentar;
    }

    public void setFitnessCentar(FitnessCentar fitnessCentar) {
        this.fitnessCentar = fitnessCentar;
    }
}
