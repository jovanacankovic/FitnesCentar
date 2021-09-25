package com.example.fitnessCenter.entity.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class FiltriraniTreninziDTO {

    private Long idt;
    private String naziv;
    private double cena;
    private int trajanje;
    private Date datumPocetka;
    private Date datumKraja;
    private int preostalaMesta;
    private String imeTrenera;
    private String tipTreninga;
    private float prosecnaOcena;
    private String nazivFitnesCentra;
    private String nazivSale;
    private boolean odgovara;


    public FiltriraniTreninziDTO(){}


    public FiltriraniTreninziDTO(Long idt, String naziv, double cena, int trajanje, Date datumPocetka, Date datumKraja, int preostalaMesta, String imeTrenera, String tipTreninga, float prosecnaOcena, String nazivFitnesCentra, String nazivSale, boolean odgovara) {
        this.idt = idt;
        this.naziv = naziv;
        this.cena = cena;
        this.trajanje = trajanje;
        this.datumPocetka = datumPocetka;
        this.datumKraja = datumKraja;
        this.preostalaMesta = preostalaMesta;
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
        this.setDatumKraja(dto.getDatumKraja());
        this.setPreostalaMesta(dto.getPreostalaMesta());
        this.setImeTrenera(dto.getImeTrenera());
        this.setTipTreninga(dto.getTipTreninga());
        this.setProsecnaOcena(dto.getProsecnaOcena());
        this.setNazivFitnesCentra(dto.getNazivFitnesCentra());
        this.setNazivSale(dto.getNazivSale());
        this.setOdgovara(dto.isOdgovara());
        this.setIdt(dto.getIdt());

    }


    @Override
    public String toString() {
        return "FiltriraniTreninziDTO{" +
                "idt=" + idt +
                ", naziv='" + naziv + '\'' +
                ", cena=" + cena +
                ", trajanje=" + trajanje +
                ", datumPocetka=" + datumPocetka +
                ", datumKraja=" + datumKraja +
                ", preostalaMesta=" + preostalaMesta +
                ", imeTrenera='" + imeTrenera + '\'' +
                ", tipTreninga='" + tipTreninga + '\'' +
                ", prosecnaOcena=" + prosecnaOcena +
                ", nazivFitnesCentra='" + nazivFitnesCentra + '\'' +
                ", nazivSale='" + nazivSale + '\'' +
                ", odgovara=" + odgovara +
                '}';
    }


}
