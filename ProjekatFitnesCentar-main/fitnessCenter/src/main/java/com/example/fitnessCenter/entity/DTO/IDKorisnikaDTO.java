package com.example.fitnessCenter.entity.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IDKorisnikaDTO {

    private Long idKorisnika;

    public IDKorisnikaDTO() {
    }

    public IDKorisnikaDTO(Long idKorisnika) {
        this.idKorisnika = idKorisnika;
    }
}
