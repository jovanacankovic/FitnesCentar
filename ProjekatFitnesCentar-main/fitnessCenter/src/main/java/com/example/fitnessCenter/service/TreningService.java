package com.example.fitnessCenter.service;

import com.example.fitnessCenter.entity.TipTreninga;
import com.example.fitnessCenter.entity.Trener;
import com.example.fitnessCenter.entity.Trening;
import org.springframework.stereotype.Service;

import java.util.List;
public interface TreningService {
    List<Trening> findByNaziv(String naziv);
    List<Trening> findAllByNazivOrderByNaziv(String naziv);
    Trening findOne(Long id);
    List<Trening> findAll();
    Trening save(Trening trening) throws Exception;
    void delete(Long id);
    List<Trening> sortNaziv();
    List<Trening> sortTipTreninga();
    List<Trening> findAllByTipTreninga(String tip);
    List<Trening> sortTrajanje();

    Trening update(Trening trening) throws Exception;

}
