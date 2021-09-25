package com.example.fitnessCenter.entity.DTO;


import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class SalaIzmenaDTO {
    private String oznaka;
    private int kapacitet;

    public SalaIzmenaDTO() {
    }

    public SalaIzmenaDTO(String oznaka, int kapacitet) {
        this.oznaka = oznaka;
        this.kapacitet = kapacitet;
    }
}
