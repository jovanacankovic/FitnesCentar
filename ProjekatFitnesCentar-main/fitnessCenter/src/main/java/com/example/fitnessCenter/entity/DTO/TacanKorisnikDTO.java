package com.example.fitnessCenter.entity.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TacanKorisnikDTO {

    private Long idKorisnika;
    private Long idTermina;
    private double ocena;

    public TacanKorisnikDTO() {
    }

    public TacanKorisnikDTO(Long idKorisnika, Long idTermina, double ocena) {
        this.idKorisnika = idKorisnika;
        this.idTermina = idTermina;
        this.ocena = ocena;
    }
}
