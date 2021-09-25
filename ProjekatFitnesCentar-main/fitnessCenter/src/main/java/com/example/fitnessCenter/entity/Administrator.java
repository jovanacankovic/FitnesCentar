package com.example.fitnessCenter.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import java.util.Date;

@Entity
@Getter
@Setter
public class Administrator extends Korisnik{
    public Administrator() {
    }

    public Administrator(String korisnickoIme, String lozinka, String ime, String prezime, String telefon, String email, Date datumRodjenja, Uloga uloga, Boolean aktivan) {
        super(korisnickoIme, lozinka, ime, prezime, telefon, email, datumRodjenja, uloga, aktivan);
    }

    public Administrator(Long id, String korisnickoIme, String lozinka, String ime, String prezime, String telefon, String email, Date datumRodjenja, Uloga uloga, Boolean aktivan, boolean daLiJeRegistrovan) {
        super(id, korisnickoIme, lozinka, ime, prezime, telefon, email, datumRodjenja, uloga, aktivan, daLiJeRegistrovan);
    }

}
