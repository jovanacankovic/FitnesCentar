package com.example.fitnessCenter.entity.DTO;

import com.example.fitnessCenter.entity.Uloga;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class KorisnikDTO implements Serializable {


    private Long id;
    private String ime;
    private String prezime;
    private String telefon;
    private String email;
    private Date datumRodjenja;
    private Uloga uloga;


    public KorisnikDTO() {
    }

    public KorisnikDTO(Long id, String ime, String prezime, String telefon, String email, Date datumRodjenja, Uloga uloga) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.telefon = telefon;
        this.email = email;
        this.datumRodjenja = datumRodjenja;
        this.uloga = uloga;
    }
}
