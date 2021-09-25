package com.example.fitnessCenter.entity.DTO;


import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class PretragaDTO {

    private String naziv;
    private double cena;
    private int trajanje;
    private Date datumPocetka;
    private int tipSortiranja;

    public PretragaDTO() {
    }

    public PretragaDTO(String naziv, double cena, int trajanje, Date datumPocetka, int tipSortiranja) {
        this.naziv = naziv;
        this.cena = cena;
        this.trajanje = trajanje;
        this.datumPocetka = datumPocetka;
        this.tipSortiranja = tipSortiranja;
    }
}
