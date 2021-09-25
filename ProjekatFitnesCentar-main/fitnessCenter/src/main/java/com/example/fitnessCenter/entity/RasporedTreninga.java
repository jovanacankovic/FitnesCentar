package com.example.fitnessCenter.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class RasporedTreninga implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY) //inkrementalno generisanje kljuceva prilikom cuvanja u bazi
    private Long id;
    @Column(nullable = false)
    private double cena;
    @Column(nullable = false)
    private Date datumPocetkaTreninga;
    @Column
    private Date datumKrajaTreninga;
    @Column
    private int brojClanova;

    @ManyToMany
    @JoinTable(name = "treninzi",
                joinColumns = @JoinColumn(name = "raspored_treninga_id",referencedColumnName = "id"),
                inverseJoinColumns = @JoinColumn(name = "trening_id",referencedColumnName = "id")
    )
    private Set<Trening> trening = new HashSet<>();



    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    private FitnessCentar fitnessCentar;


}
