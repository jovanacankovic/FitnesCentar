package com.example.fitnessCenter.entity.DTO;

import com.example.fitnessCenter.entity.Uloga;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
public class RezervacijaDTO {

    private Long idKorisnika;
    private Long idTermina;

    public RezervacijaDTO() {
    }

    public RezervacijaDTO(Long idKorisnika, Long idTermina) {
        this.idKorisnika = idKorisnika;
        this.idTermina = idTermina;
    }
}
