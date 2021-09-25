package com.example.fitnessCenter.service;

import com.example.fitnessCenter.entity.ListaTreninga;
import com.example.fitnessCenter.entity.RasporedTreninga;

import java.util.List;

public interface RasporedTreningaService {

    ListaTreninga save(ListaTreninga trening) throws Exception;

    ListaTreninga azuriranje(ListaTreninga trening);
    ListaTreninga update(ListaTreninga trening) throws Exception;
    void delete(Long id);
    ListaTreninga findOne(Long id);
    List<ListaTreninga> findAll();
}
