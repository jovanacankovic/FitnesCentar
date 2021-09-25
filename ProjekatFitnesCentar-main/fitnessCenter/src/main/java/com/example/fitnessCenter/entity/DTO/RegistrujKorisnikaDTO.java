package com.example.fitnessCenter.entity.DTO;


import com.example.fitnessCenter.entity.Uloga;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class RegistrujKorisnikaDTO {


    private String korisnickoIme;
    private String lozinka;
    private String ime;
    private String prezime;
    private Date datumRodjenja;
    private String email;
    private String telefon;
    private Uloga uloga;
    private boolean aktivan;
    private boolean da_li_je_registrovan;

    public RegistrujKorisnikaDTO() {
    }

    public RegistrujKorisnikaDTO( String korisnickoIme, String lozinka, String ime, String prezime, Date datumRodjenja, String email, String telefon, Uloga uloga, boolean aktivan, boolean da_li_je_registrovan) {

        this.korisnickoIme = korisnickoIme;
        this.lozinka = lozinka;
        this.ime = ime;
        this.prezime = prezime;
        this.datumRodjenja = datumRodjenja;
        this.email = email;
        this.telefon = telefon;
        this.uloga = uloga;
        this.aktivan = aktivan;
        this.da_li_je_registrovan = da_li_je_registrovan;
    }
}
