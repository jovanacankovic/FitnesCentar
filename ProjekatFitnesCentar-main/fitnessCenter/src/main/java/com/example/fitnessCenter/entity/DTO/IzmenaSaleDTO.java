package com.example.fitnessCenter.entity.DTO;


import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class IzmenaSaleDTO {

    private Long idKorisnika;
    private Long idTermina;
    private String oznaka;
    private int kapacitet;

    public IzmenaSaleDTO() {
    }

    public IzmenaSaleDTO(Long idKorisnika, Long idTermina, String oznaka, int kapacitet) {
        this.idKorisnika = idKorisnika;
        this.idTermina = idTermina;
        this.oznaka = oznaka;
        this.kapacitet = kapacitet;
    }
}
