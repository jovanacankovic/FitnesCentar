package com.example.fitnessCenter.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@MappedSuperclass
public class Korisnik implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY) //inkrementalno generisanje kljuceva prilikom cuvanja u bazi
    private Long id;
    @Column(name = "KORISNICKOIME",unique = true)
    private String korisnickoIme;
    @Column //(nullable = false)
    private String lozinka;
    @Column
    private String ime;
    @Column
    private String prezime;
    @Column
    private String telefon;
    @Column
    private String email;
    @Column (name = "DATUMRODJENJA")
    private Date datumRodjenja;
    @Column//(nullable = false)
    private Uloga uloga;
    @Column//(nullable = false)
    private boolean aktivan;
    @Column
    private boolean daLiJeRegistrovan;

    public Korisnik() {
    }



    public Korisnik(String korisnickoIme, String lozinka, String ime, String prezime, String telefon, String email, Date datumRodjenja, Uloga uloga) {
        this.korisnickoIme = korisnickoIme;
        this.lozinka = lozinka;
        this.ime = ime;
        this.prezime = prezime;
        this.telefon = telefon;
        this.email = email;
        this.datumRodjenja = datumRodjenja;
        this.uloga = uloga;
    }


    public Korisnik(String korisnickoIme, String lozinka, String ime, String prezime, String telefon, String email, Date datumRodjenja) {
        this.korisnickoIme = korisnickoIme;
        this.lozinka = lozinka;
        this.ime = ime;
        this.prezime = prezime;
        this.telefon = telefon;
        this.email = email;
        this.datumRodjenja = datumRodjenja;
    }

    public Korisnik(String korisnickoIme, String lozinka, String ime, String prezime, String telefon, String email, Date datumRodjenja, Uloga uloga, Boolean aktivan) {
        this.korisnickoIme = korisnickoIme;
        this.lozinka = lozinka;
        this.ime = ime;
        this.prezime = prezime;
        this.telefon = telefon;
        this.email = email;
        this.datumRodjenja = datumRodjenja;
        this.uloga = uloga;
        this.aktivan = aktivan;
    }

    public Korisnik(String korisnickoIme, String lozinka, String ime, String prezime, String telefon, String email, Date datumRodjenja, Uloga uloga, boolean aktivan,boolean daLiJeRegistrovan) {
        this.korisnickoIme = korisnickoIme;
        this.lozinka = lozinka;
        this.ime = ime;
        this.prezime = prezime;
        this.telefon = telefon;
        this.email = email;
        this.datumRodjenja = datumRodjenja;
        this.uloga = uloga;
        this.aktivan = aktivan;
        this.daLiJeRegistrovan = daLiJeRegistrovan;
    }

    public Korisnik(Long id, String korisnickoIme, String lozinka, String ime, String prezime, String telefon, String email, Date datumRodjenja, Uloga uloga, Boolean aktivan, boolean daLiJeRegistrovan) {
        this.id = id;
        this.korisnickoIme = korisnickoIme;
        this.lozinka = lozinka;
        this.ime = ime;
        this.prezime = prezime;
        this.telefon = telefon;
        this.email = email;
        this.datumRodjenja = datumRodjenja;
        this.uloga = uloga;
        this.aktivan = aktivan;
        this.daLiJeRegistrovan = daLiJeRegistrovan;
    }

    /*public boolean getDaLiJeRegistrovan() {
        return daLiJeRegistrovan;
    }

    public void setDaLiJeRegistrovan(boolean daLiJeRegistrovan) {
        this.daLiJeRegistrovan = daLiJeRegistrovan;
    } */
}
