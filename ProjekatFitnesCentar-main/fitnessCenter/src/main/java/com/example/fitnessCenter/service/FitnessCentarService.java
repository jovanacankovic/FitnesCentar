package com.example.fitnessCenter.service;

import com.example.fitnessCenter.entity.FitnessCentar;

import java.util.List;

public interface FitnessCentarService {
    List<FitnessCentar> findByNazivCentra(String naziv);
    void delete(Long id);
    FitnessCentar save(FitnessCentar fitnessCentar) throws Exception;

    FitnessCentar azuriranje(FitnessCentar fitnessCentar);
    FitnessCentar findOne(Long id);
    List<FitnessCentar> findAll();
}
