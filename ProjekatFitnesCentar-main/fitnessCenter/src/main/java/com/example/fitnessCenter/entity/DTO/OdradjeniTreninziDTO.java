package com.example.fitnessCenter.entity.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class OdradjeniTreninziDTO {


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

    public OdradjeniTreninziDTO() {
    }

    public OdradjeniTreninziDTO(Long idt, String naziv, double cena, int trajanje, Date datumPocetka, String imeTrenera, String tipTreninga, float prosecnaOcena, String nazivFitnesCentra, String nazivSale, boolean odgovara) {
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
    }

    public void zameni(FiltriraniTreninziDTO dto) {
        this.setNaziv(dto.getNaziv());
        this.setCena(dto.getCena());
        this.setTrajanje(dto.getTrajanje());
        this.setDatumPocetka(dto.getDatumPocetka());
        this.setImeTrenera(dto.getImeTrenera());
        this.setTipTreninga(dto.getTipTreninga());
        this.setProsecnaOcena(dto.getProsecnaOcena());
        this.setNazivFitnesCentra(dto.getNazivFitnesCentra());
        this.setNazivSale(dto.getNazivSale());
        this.setOdgovara(dto.isOdgovara());
        this.setIdt(dto.getIdt());

    }
}
