package com.example.fitnessCenter.entity.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IzmenaFCDTO {

    private Long idKorisnika;
    private Long idTermina;
    private String nazivCentra;
    private String adresaCentra;
    private String brojTelefonaCentrale;
    private String emailCentra;


    public IzmenaFCDTO() {
    }

    public IzmenaFCDTO(Long idKorisnika, Long idTermina, String nazivCentra, String adresaCentra, String brojTelefonaCentrale, String emailCentra) {
        this.idKorisnika = idKorisnika;
        this.idTermina = idTermina;
        this.nazivCentra = nazivCentra;
        this.adresaCentra = adresaCentra;
        this.brojTelefonaCentrale = brojTelefonaCentrale;
        this.emailCentra = emailCentra;
    }
}
