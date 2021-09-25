package com.example.fitnessCenter.entity.DTO;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OdobriRegistracijuDTO {
    private String ime;
    private String prezime;
    private String email;
    private String telefon;
    private boolean aktivan;
    private boolean da_li_je_registrovan;

    public OdobriRegistracijuDTO() {
    }

    public OdobriRegistracijuDTO(String ime, String prezime, String email, String telefon, boolean aktivan,boolean dr) {
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
        this.telefon = telefon;
        this.aktivan = aktivan;
        this.da_li_je_registrovan = dr;
    }
}
