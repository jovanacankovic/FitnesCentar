package com.example.fitnessCenter.entity.DTO;


import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter

public class OcenjeniTreninziDTO {

    private Long idt;
    private String naziv;
    private double cena;
    private int trajanje;
    private Date datumPocetka;
    private String imeTrenera;
    private String tipTreninga;
    private float prosecnaOcena;
    private String nazivFitnesCentra;
    private String nazivSale;
    private boolean odgovara;
    private double ocenaKorisnika;

    public OcenjeniTreninziDTO() {
    }


    public OcenjeniTreninziDTO(Long idt, String naziv, double cena, int trajanje, Date datumPocetka, String imeTrenera, String tipTreninga, float prosecnaOcena, String nazivFitnesCentra, String nazivSale, boolean odgovara, double ocenaKorisnika) {
        this.idt = idt;
        this.naziv = naziv;
        this.cena = cena;
        this.trajanje = trajanje;
        this.datumPocetka = datumPocetka;
        this.imeTrenera = imeTrenera;
        this.tipTreninga = tipTreninga;
        this.prosecnaOcena = prosecnaOcena;
        this.nazivFitnesCentra = nazivFitnesCentra;
        this.nazivSale = nazivSale;
        this.odgovara = odgovara;
        this.ocenaKorisnika = ocenaKorisnika;
    }
}
