package com.example.fitnessCenter.entity.DTO;


import com.example.fitnessCenter.entity.FitnessCentar;
import com.example.fitnessCenter.entity.Sala;
import com.example.fitnessCenter.entity.Trening;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ListaTreningaDTO {
    private Long id;
    private double cena;
    private Date datumPocetka;
    private Date datumKraja;
    private int brojClanova;
    private Trening trening;
    private Sala sala;
    private FitnessCentar fitnessCentar;

    public ListaTreningaDTO() {
    }

    public ListaTreningaDTO(Long id, double cena, Date datumPocetka, Date datumKraja, int brojClanova, Trening trening, Sala sala, FitnessCentar fitnessCentar) {
        this.id = id;
        this.cena = cena;
        this.datumPocetka = datumPocetka;
        this.datumKraja = datumKraja;
        this.brojClanova = brojClanova;
        this.trening = trening;
        this.sala = sala;
        this.fitnessCentar = fitnessCentar;
    }
}
