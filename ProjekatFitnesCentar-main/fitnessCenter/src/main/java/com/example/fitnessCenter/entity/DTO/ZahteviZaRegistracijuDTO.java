package com.example.fitnessCenter.entity.DTO;

import com.example.fitnessCenter.entity.Uloga;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter

public class ZahteviZaRegistracijuDTO {

    private String korisnickoIme;
    private String ime;
    private String prezime;
    private String lozinka;
    private String telefon;
    private String email;
    private Date datumRodjenja;

    private Uloga uloga;

    public ZahteviZaRegistracijuDTO() {
    }

    public ZahteviZaRegistracijuDTO(String korisnickoIme, String ime, String prezime, String lozinka, String telefon, String email, Date datumRodjenja, Uloga uloga) {
        this.korisnickoIme = korisnickoIme;
        this.ime = ime;
        this.prezime = prezime;
        this.lozinka = lozinka;
        this.telefon = telefon;
        this.email = email;
        this.datumRodjenja = datumRodjenja;
        this.uloga = uloga;
    }
}
