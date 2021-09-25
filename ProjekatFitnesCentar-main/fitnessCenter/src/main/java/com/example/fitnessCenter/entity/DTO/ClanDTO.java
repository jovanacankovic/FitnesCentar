package com.example.fitnessCenter.entity.DTO;

import com.example.fitnessCenter.entity.OcenaTreninga;
import com.example.fitnessCenter.entity.Trening;
import com.example.fitnessCenter.entity.Uloga;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class ClanDTO implements Serializable {

    private Long id;
    private String korisnickoIme;
    private String lozinka;
    private String ime;
    private String prezime;
    private String telefon;
    private String email;
    private Date datumRodjenja;
    private Uloga uloga;
    private Boolean aktivan;

    private Set<Trening> treninzi = new HashSet<>();
    private Set<Trening> prijavljeniTreninzi = new HashSet<>();
    private Set<OcenaTreninga> ocene = new HashSet<>();

    public ClanDTO(Set<Trening> treninzi, Set<Trening> prijavljeniTreninzi, Set<OcenaTreninga> ocene) {
        this.treninzi = treninzi;
        this.prijavljeniTreninzi = prijavljeniTreninzi;
        this.ocene = ocene;
    }

    public ClanDTO() {
    }

    public Set<Trening> getTreninzi() {
        return treninzi;
    }

    public void setTreninzi(Set<Trening> treninzi) {
        this.treninzi = treninzi;
    }

    public Set<Trening> getPrijavljeniTreninzi() {
        return prijavljeniTreninzi;
    }

    public void setPrijavljeniTreninzi(Set<Trening> prijavljeniTreninzi) {
        this.prijavljeniTreninzi = prijavljeniTreninzi;
    }

    public Set<OcenaTreninga> getOcene() {
        return ocene;
    }

    public void setOcene(Set<OcenaTreninga> ocene) {
        this.ocene = ocene;
    }

    public ClanDTO(Long id, String korisnickoIme, String lozinka, String ime, String prezime, String telefon, String email, Date datumRodjenja, Uloga uloga, Boolean aktivan) {
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
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDatumRodjenja() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(Date datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }

    public Uloga getUloga() {
        return uloga;
    }

    public void setUloga(Uloga uloga) {
        this.uloga = uloga;
    }

    public Boolean getAktivan() {
        return aktivan;
    }

    public void setAktivan(Boolean aktivan) {
        this.aktivan = aktivan;
    }
}
