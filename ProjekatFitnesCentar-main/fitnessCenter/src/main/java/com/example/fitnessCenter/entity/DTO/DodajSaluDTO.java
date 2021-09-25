package com.example.fitnessCenter.entity.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DodajSaluDTO {
    private Long id;
    private String naziv;
    private int kapacitet;
    private Long idCentra;

    public DodajSaluDTO() {
    }

    public DodajSaluDTO(Long id, String naziv, int kapacitet,Long idCentra) {
        this.id = id;
        this.naziv = naziv;
        this.kapacitet = kapacitet;
        this.idCentra = idCentra;
    }
}
