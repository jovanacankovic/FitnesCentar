package com.example.fitnessCenter.entity.DTO;


import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class TerminIzmenaDTO {
    private double cena;
    private Date DatumPocetka;

    public TerminIzmenaDTO() {
    }

    public TerminIzmenaDTO(double cena, Date datumPocetka) {
        this.cena = cena;
        DatumPocetka = datumPocetka;
    }
}
