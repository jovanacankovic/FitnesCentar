package com.example.fitnessCenter.entity.DTO;

import com.example.fitnessCenter.entity.Uloga;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class PrijavljenKorisnikDTO {
    private String korisnickoIme;
    private String lozinka;

    public PrijavljenKorisnikDTO() {
    }

    public PrijavljenKorisnikDTO(String korisnickoIme, String lozinka) {
        this.korisnickoIme = korisnickoIme;
        this.lozinka = lozinka;
    }
}
