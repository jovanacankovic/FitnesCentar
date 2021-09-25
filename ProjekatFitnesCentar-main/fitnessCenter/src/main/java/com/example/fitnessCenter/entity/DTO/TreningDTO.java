package com.example.fitnessCenter.entity.DTO;

import com.example.fitnessCenter.entity.TipTreninga;
import com.example.fitnessCenter.entity.Trener;

import java.io.Serializable;

public class TreningDTO implements Serializable {
    private Long id;
    private String naziv;
    private String opis;
    private String tip;
    private int trajanje;
    private Trener trener;


    public TreningDTO(Long id, String naziv, String opis, String tip, int trajanje) {
        this.id = id;
        this.naziv = naziv;
        this.opis = opis;
        this.tip = tip;
        this.trajanje = trajanje;
    }

    public TreningDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public int getTrajanje() {
        return trajanje;
    }

    public void setTrajanje(int trajanje) {
        this.trajanje = trajanje;
    }

    public Trener getTrener() {
        return trener;
    }

    public void setTrener(Trener trener) {
        this.trener = trener;
    }

    public TreningDTO(String naziv, String opis, String tip, int trajanje) {
        this.naziv = naziv;
        this.opis = opis;
        this.tip = tip;
        this.trajanje = trajanje;
    }

    public TreningDTO(Long id, String naziv, String opis, String tip, int trajanje, Trener trener) {
        this.id = id;
        this.naziv = naziv;
        this.opis = opis;
        this.tip = tip;
        this.trajanje = trajanje;
        this.trener = trener;
    }
}
