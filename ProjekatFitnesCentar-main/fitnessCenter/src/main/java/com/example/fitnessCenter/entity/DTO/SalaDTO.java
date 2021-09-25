package com.example.fitnessCenter.entity.DTO;

import com.example.fitnessCenter.entity.FitnessCentar;
import com.example.fitnessCenter.entity.ListaTreninga;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class SalaDTO implements Serializable {
    private Long id;
    private String oznaka;
    private int kapacitet;
   // private Set<ListaTreninga> listaTreningaTerminska = new HashSet<>();
    private FitnessCentar fitnessCentar;

    public SalaDTO(Long id, String oznaka, int kapacitet,  FitnessCentar fitnessCentar) {
        this.id = id;
        this.oznaka = oznaka;
        this.kapacitet = kapacitet;
        this.fitnessCentar = fitnessCentar;
    }

    public SalaDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOznaka() {
        return oznaka;
    }

    public void setOznaka(String oznaka) {
        this.oznaka = oznaka;
    }

    public int getKapacitet() {
        return kapacitet;
    }

    public void setKapacitet(int kapacitet) {
        this.kapacitet = kapacitet;
    }



    public FitnessCentar getFitnessCentar() {
        return fitnessCentar;
    }

    public void setFitnessCentar(FitnessCentar fitnessCentar) {
        this.fitnessCentar = fitnessCentar;
    }
}
