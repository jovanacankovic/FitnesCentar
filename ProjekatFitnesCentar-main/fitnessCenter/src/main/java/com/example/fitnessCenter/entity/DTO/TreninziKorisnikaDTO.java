package com.example.fitnessCenter.entity.DTO;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class TreninziKorisnikaDTO {

    private Long idKorisnika;

    public TreninziKorisnikaDTO() {
    }

    public TreninziKorisnikaDTO(Long idKorisnika) {
        this.idKorisnika = idKorisnika;
    }


}
