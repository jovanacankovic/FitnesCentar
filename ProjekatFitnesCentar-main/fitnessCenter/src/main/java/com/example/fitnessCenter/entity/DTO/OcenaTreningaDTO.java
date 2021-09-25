package com.example.fitnessCenter.entity.DTO;

import com.example.fitnessCenter.entity.Clan;
import com.example.fitnessCenter.entity.ListaTreninga;
import com.example.fitnessCenter.entity.Trening;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
@Getter
@Setter
public class OcenaTreningaDTO implements Serializable {
    private Long id;
    private double ocena;
    private Trening trening;
    private Set<Clan> clanovi = new HashSet<>();
    private Clan clan;
    private ListaTreninga termin;

    public OcenaTreningaDTO(Long id, double ocena, Trening trening, Set<Clan> clanovi) {
        this.id = id;
        this.ocena = ocena;
        this.trening = trening;
        this.clanovi = clanovi;
    }

    public OcenaTreningaDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getOcena() {
        return ocena;
    }

    public void setOcena(double ocena) {
        this.ocena = ocena;
    }

    public Trening getTrening() {
        return trening;
    }

    public void setTrening(Trening trening) {
        this.trening = trening;
    }

    public Set<Clan> getClanovi() {
        return clanovi;
    }

    public void setClanovi(Set<Clan> clanovi) {
        this.clanovi = clanovi;
    }
}
