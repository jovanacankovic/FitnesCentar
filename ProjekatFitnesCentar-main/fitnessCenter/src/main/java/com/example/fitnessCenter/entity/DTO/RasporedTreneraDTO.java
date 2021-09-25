package com.example.fitnessCenter.entity.DTO;


import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class RasporedTreneraDTO {

    private Long id;
    private double cena;
    private Date datumPocetka;
    private String nazivTreninga;


    public RasporedTreneraDTO() {
    }

    public RasporedTreneraDTO(Long id, double cena, Date datumPocetka, String nazivTreninga) {
        this.id = id;
        this.cena = cena;
        this.datumPocetka = datumPocetka;
        this.nazivTreninga = nazivTreninga;
    }
}
