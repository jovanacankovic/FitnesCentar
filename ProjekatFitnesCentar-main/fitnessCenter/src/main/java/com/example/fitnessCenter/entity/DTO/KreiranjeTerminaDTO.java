package com.example.fitnessCenter.entity.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class KreiranjeTerminaDTO {


    private Long korisnik;
    private Long trening;
    private Date datumPocetka;
    private double cena;

    public KreiranjeTerminaDTO() {
    }

    public KreiranjeTerminaDTO(Long korisnik, Long trening, Date datumPocetka, double cena) {
        this.korisnik = korisnik;
        this.trening = trening;
        this.datumPocetka = datumPocetka;
        this.cena = cena;
    }
}
