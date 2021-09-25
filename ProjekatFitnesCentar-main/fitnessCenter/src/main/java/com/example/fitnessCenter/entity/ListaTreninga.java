package com.example.fitnessCenter.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
public class ListaTreninga implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY) //inkrementalno generisanje kljuceva prilikom cuvanja u bazi
    private Long id;

    @Column
    private int brojPrijavljenih;
    @Column(nullable = false)
    private double cena;
    @Column(nullable = false)
    private Date datumPocetkaTreninga;
    @Column
    private Date datumKrajaTreninga;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    private Sala sala;

    @JsonIgnore
    @OneToMany(mappedBy = "termin" ,fetch = FetchType.EAGER,cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<OcenaTreninga> ocenaTreningas = new HashSet<>();

    @ManyToMany(mappedBy = "prijavljeniTreninzi")
    private Set<Clan> prijavljeniClanovi = new HashSet<>();

    @ManyToMany(mappedBy = "odradjeniTreninzi")
    private Set<Clan> clanoviOdradiliTrening = new HashSet<>();




   /* @ManyToMany
    @JoinTable(name = "treninzi",
            joinColumns = @JoinColumn(name = "raspored_treninga_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "trening_id",referencedColumnName = "id")
    )
    private Set<Trening> trening = new HashSet<>(); */

    public ListaTreninga() {
    }

    @ManyToOne(fetch = FetchType.EAGER)
    private FitnessCentar fitnessCentar;

    @ManyToOne(fetch = FetchType.EAGER)
    private Trening trening2;






    public ListaTreninga(Long id, int brojPrijavljenih, double cena, Date datumPocetkaTreninga, Date datumKrajaTreninga, Sala sala, Trening trening, FitnessCentar fitnessCentar) {
        this.id = id;
        this.brojPrijavljenih = brojPrijavljenih;
        this.cena = cena;
        this.datumPocetkaTreninga = datumPocetkaTreninga;
        this.datumKrajaTreninga = datumKrajaTreninga;
        this.sala = sala;
        this.trening2 = trening;
        this.fitnessCentar = fitnessCentar;
    }

    public ListaTreninga(String naziv,double cena, Date datumPocetkaTreninga,Trening trening) {
        trening2.setNaziv(naziv);
        this.cena = cena;
        this.datumPocetkaTreninga = datumPocetkaTreninga;
        //this.sala = sala;
        this.trening2 = trening;
    }

    public ListaTreninga(String naziv,double cena, Date datumPocetkaTreninga) {
        this.trening2.setNaziv(naziv);
        this.cena = cena;
        this.datumPocetkaTreninga = datumPocetkaTreninga;

    }
    public ListaTreninga(double cena, Date datumPocetkaTreninga,Trening trening, FitnessCentar fitnessCentar) {

        this.cena = cena;
        this.datumPocetkaTreninga = datumPocetkaTreninga;

        this.trening2 = trening;
        this.fitnessCentar = fitnessCentar;
    }

    public ListaTreninga(Long id, int brojPrijavljenih, double cena, Date datumPocetkaTreninga, Date datumKrajaTreninga) {
        this.id = id;
        this.brojPrijavljenih = brojPrijavljenih;
        this.cena = cena;
        this.datumPocetkaTreninga = datumPocetkaTreninga;
        this.datumKrajaTreninga = datumKrajaTreninga;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getBrojPrijavljenih() {
        return brojPrijavljenih;
    }

    public void setBrojPrijavljenih(int brojPrijavljenih) {
        this.brojPrijavljenih = brojPrijavljenih;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public Date getDatumPocetkaTreninga() {
        return datumPocetkaTreninga;
    }

    public void setDatumPocetkaTreninga(Date datumPocetkaTreninga) {
        this.datumPocetkaTreninga = datumPocetkaTreninga;
    }

    public Date getDatumKrajaTreninga() {
        return datumKrajaTreninga;
    }

    public void setDatumKrajaTreninga(Date datumKrajaTreninga) {
        this.datumKrajaTreninga = datumKrajaTreninga;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public Trening getTrening() {
        return trening2;
    }

    public void setTrening(Trening trening2) {
        this.trening2 = trening2;
    }

    public FitnessCentar getFitnessCentar() {
        return fitnessCentar;
    }

    public void setFitnessCentar(FitnessCentar fitnessCentar) {
        this.fitnessCentar = fitnessCentar;
    }
}
