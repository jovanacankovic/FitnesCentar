package com.example.fitnessCenter.entity.DTO;


import com.example.fitnessCenter.entity.Sala;
import com.example.fitnessCenter.entity.Trening;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class NoviTreningDTO {
    private String nazivTreninga;
    private Date datumPocetkaTreninga;
    private double cena;
   // private Long korisnik;
    private Long idTreninga;

    public NoviTreningDTO() {
    }

    public NoviTreningDTO(String nazivTreninga, Date datumPocetkaTreninga, double cena, Long idTreninga) {
        this.nazivTreninga = nazivTreninga;
        this.datumPocetkaTreninga = datumPocetkaTreninga;
        this.cena = cena;
        this.idTreninga = idTreninga;
    }
}
