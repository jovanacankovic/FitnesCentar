package com.example.fitnessCenter.entity.DTO;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TreninziTreneraDTO {


    private Long id;
    private String naziv;
    private String opis;
    private String tipTreninga;
    private int trajanje;

    public TreninziTreneraDTO() {
    }

    public TreninziTreneraDTO(Long id, String naziv, String opis, String tipTreninga, int trajanje) {
        this.id = id;
        this.naziv = naziv;
        this.opis = opis;
        this.tipTreninga = tipTreninga;
        this.trajanje = trajanje;
    }
}
