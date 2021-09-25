package com.example.fitnessCenter.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
public class Clan extends Korisnik{

    @ManyToMany
    @JoinTable(name = "odradjeniTreninzi",
                joinColumns = @JoinColumn(name="clan_id",referencedColumnName = "id"),
                inverseJoinColumns = @JoinColumn(name = "trening_id",referencedColumnName = "id")
    )
    private Set<ListaTreninga> odradjeniTreninzi = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "prijavljeniTreninzi",
            joinColumns = @JoinColumn(name="clan_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "trening_id",referencedColumnName = "id")
    )
    private Set<ListaTreninga> prijavljeniTreninzi = new HashSet<>();

   /* @ManyToMany
    @JoinTable(name = "ocenjeniTreninzi",
            joinColumns = @JoinColumn(name="clan_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "ocena_treninga_id",referencedColumnName = "id")
    ) */

    @OneToMany(mappedBy = "clan",fetch = FetchType.EAGER,cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<OcenaTreninga> ocenaTreninga = new HashSet<>();



    public Set<ListaTreninga> getPrijavljeniTreninzi() {
        return prijavljeniTreninzi;
    }

    public void setPrijavljeniTreninzi(Set<ListaTreninga> prijavljeniTreninzi) {
        this.prijavljeniTreninzi = prijavljeniTreninzi;
    }

    public Set<OcenaTreninga> getOcene() {
        return ocenaTreninga;
    }

    public void setOcene(Set<OcenaTreninga> ocene) {
        this.ocenaTreninga = ocene;
    }


    public Clan() {

    }
    public Clan(String korisnickoIme, String lozinka, String ime, String prezime, String telefon, String email, Date datumRodjenja, Uloga uloga, Boolean aktivan,Boolean daLiJeRegistrovan){
        super(korisnickoIme, lozinka, ime, prezime, telefon, email, datumRodjenja, uloga, aktivan,daLiJeRegistrovan);
    }

    public Clan(String korisnickoIme, String lozinka, String ime, String prezime, String telefon, String email, Date datumRodjenja, Uloga uloga, Boolean aktivan) {
        super(korisnickoIme, lozinka, ime, prezime, telefon, email, datumRodjenja, uloga, aktivan);
    }

    public Clan(Long id, String korisnickoIme, String lozinka, String ime, String prezime, String telefon, String email, Date datumRodjenja, Uloga uloga, Boolean aktivan, boolean daLiJeRegistrovan) {
        super(id, korisnickoIme, lozinka, ime, prezime, telefon, email, datumRodjenja, uloga, aktivan, daLiJeRegistrovan);
    }

    public Clan(String korisnickoIme, String lozinka, String ime, String prezime, String telefon, String email, Date datumRodjenja, Uloga uloga) {
        super(korisnickoIme, lozinka, ime, prezime, telefon, email, datumRodjenja, uloga);
    }
}
