package com.example.fitnessCenter.entity.DTO;

import com.example.fitnessCenter.entity.Uloga;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class PrijavaKorisnikaDTO implements Serializable {

    private Long id;
    private String korisnickoIme;
    private String ime;
    private String prezime;
    private String lozinka;
    private String telefon;
    private String email;
    private Date datumRodjenja;
    private boolean aktivan;
    private Uloga uloga;

    public PrijavaKorisnikaDTO() {
    }

    public PrijavaKorisnikaDTO(Long id, String korisnickoIme, String ime, String prezime, String lozinka, String telefon, String email, Date datumRodjenja, boolean aktivan, Uloga uloga) {
        this.id = id;
        this.korisnickoIme = korisnickoIme;
        this.ime = ime;
        this.prezime = prezime;
        this.lozinka = lozinka;
        this.telefon = telefon;
        this.email = email;
        this.datumRodjenja = datumRodjenja;
        this.aktivan = aktivan;
        this.uloga = uloga;
    }
}
