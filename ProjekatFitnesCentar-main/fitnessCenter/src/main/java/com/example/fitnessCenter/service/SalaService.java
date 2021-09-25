package com.example.fitnessCenter.service;

import com.example.fitnessCenter.entity.FitnessCentar;
import com.example.fitnessCenter.entity.ListaTreninga;
import com.example.fitnessCenter.entity.OcenaTreninga;
import com.example.fitnessCenter.entity.Sala;

import java.util.List;

public interface SalaService {
    Sala findOne(Long id);

    Sala save(Sala sala) throws Exception;
    List<Sala> findAll();
    void delete(Long id);

    Sala azuriranje(Sala sala);
}
