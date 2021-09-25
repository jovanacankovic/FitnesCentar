package com.example.fitnessCenter.entity.DTO;


import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class FCIzmenaDTO {

    private String nazivCentra;
    private String adresaCentra;
    private String brojTelefonaCentrale;
    private String emailCentra;

    public FCIzmenaDTO() {
    }

    public FCIzmenaDTO(String nazivCentra, String adresaCentra, String brojTelefonaCentrale, String emailCentra) {
        this.nazivCentra = nazivCentra;
        this.adresaCentra = adresaCentra;
        this.brojTelefonaCentrale = brojTelefonaCentrale;
        this.emailCentra = emailCentra;
    }
}
