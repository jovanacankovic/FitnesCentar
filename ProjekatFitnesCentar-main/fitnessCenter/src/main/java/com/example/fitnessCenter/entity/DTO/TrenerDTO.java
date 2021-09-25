package com.example.fitnessCenter.entity.DTO;

import com.example.fitnessCenter.entity.FitnessCentar;
import com.example.fitnessCenter.entity.Trening;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class TrenerDTO implements Serializable{
    private double ocena;
    private Set<Trening> treninziKojeDrzi = new HashSet<>();
    private FitnessCentar fitnessCentar;

    public TrenerDTO(double ocena, Set<Trening> treninziKojeDrzi, FitnessCentar fitnessCentar) {
        this.ocena = ocena;
        this.treninziKojeDrzi = treninziKojeDrzi;
        this.fitnessCentar = fitnessCentar;
    }

    public TrenerDTO() {
    }

    public double getOcena() {
        return ocena;
    }

    public void setOcena(double ocena) {
        this.ocena = ocena;
    }

    public Set<Trening> getTreninziKojeDrzi() {
        return treninziKojeDrzi;
    }

    public void setTreninziKojeDrzi(Set<Trening> treninziKojeDrzi) {
        this.treninziKojeDrzi = treninziKojeDrzi;
    }

    public FitnessCentar getFitnessCentar() {
        return fitnessCentar;
    }

    public void setFitnessCentar(FitnessCentar fitnessCentar) {
        this.fitnessCentar = fitnessCentar;
    }
}
