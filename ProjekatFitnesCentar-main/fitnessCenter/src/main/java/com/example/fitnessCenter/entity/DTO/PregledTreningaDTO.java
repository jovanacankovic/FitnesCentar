package com.example.fitnessCenter.entity.DTO;


import com.example.fitnessCenter.entity.Trener;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class PregledTreningaDTO {

    private Long id;
    private String naziv;
    private String opis;
    private String tip;
    private int trajanje;
    private Trener trener;
    private Date pocetak;
    private String sala;

    public PregledTreningaDTO() {
    }

    public PregledTreningaDTO(Long id, String naziv, String opis, String tip, int trajanje, Trener trener, Date pocetak, String sala) {
        this.id = id;
        this.naziv = naziv;
        this.opis = opis;
        this.tip = tip;
        this.trajanje = trajanje;
        this.trener = trener;
        this.pocetak = pocetak;
        this.sala = sala;
    }
}
