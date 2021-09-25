package com.example.fitnessCenter.service;

import com.example.fitnessCenter.entity.OcenaTreninga;

import java.util.List;

public interface OcenaTreningaService {

    OcenaTreninga findOne(Long id);
    List<OcenaTreninga> findAll();

    List<OcenaTreninga> getByTreningId(Long id);
    OcenaTreninga save(OcenaTreninga trening) throws Exception;
    OcenaTreninga update(OcenaTreninga trening) throws Exception;
    void delete(Long id);
}
