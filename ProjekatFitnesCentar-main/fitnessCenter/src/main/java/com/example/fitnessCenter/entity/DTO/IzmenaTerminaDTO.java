package com.example.fitnessCenter.entity.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class IzmenaTerminaDTO {

    private Long idKorisnika;
    private Long idTermina;
    private double cena;
    private Date datumPocetka;

    public IzmenaTerminaDTO() {
    }

    public IzmenaTerminaDTO(Long idKorisnika, Long idTermina, double cena, Date datumPocetka) {
        this.idKorisnika = idKorisnika;
        this.idTermina = idTermina;
        this.cena = cena;
        this.datumPocetka = datumPocetka;
    }
}
