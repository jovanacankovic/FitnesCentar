package com.example.fitnessCenter.entity.DTO;


import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class OdobrenaRegistracijaDTO {

    private String korisnickoIme;
    private String lozinka;
    private String ime;
    private String prezime;
    private String email;
    private String telefon;
    private Date datumRodjenja;

    public OdobrenaRegistracijaDTO() {
    }

    public OdobrenaRegistracijaDTO(String korisnickoIme, String lozinka, String ime, String prezime, String email, String telefon,  Date datumRodjenja) {
        this.korisnickoIme = korisnickoIme;
        this.lozinka = lozinka;
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
        this.telefon = telefon;

        this.datumRodjenja = datumRodjenja;
    }
}
