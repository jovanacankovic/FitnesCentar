package com.example.fitnessCenter.entity;


import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor


@Entity
public class OcenaTreninga implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY) //inkrementalno generisanje kljuceva prilikom cuvanja u bazi
    private Long id;
    @Column
    private double ocena;


    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    private ListaTreninga trening;

    /*@ManyToMany(mappedBy = "ocene")
    private Set<Clan> clanovi = new HashSet<>(); */

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    private ListaTreninga termin;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    private Clan clan;

    public OcenaTreninga() {
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

    public ListaTreninga getTrening() {
        return trening;
    }

    public void setTrening(ListaTreninga trening) {
        this.trening = trening;
    }

    public Clan getClan() {
        return clan;
    }

    public void setClan(Clan clan) {
        this.clan = clan;
    }
}
