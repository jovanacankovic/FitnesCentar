package com.example.fitnessCenter.service.impl;

import com.example.fitnessCenter.entity.Clan;
import com.example.fitnessCenter.entity.FitnessCentar;
import com.example.fitnessCenter.entity.Sala;
import com.example.fitnessCenter.repository.FitnessCentarRepository;
import com.example.fitnessCenter.service.FitnessCentarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FitnessCentarServiceImpl implements FitnessCentarService {
    private final FitnessCentarRepository fitnessCentarRepository;
    @Autowired
    private FitnessCentarServiceImpl(FitnessCentarRepository fitnessCentarRepository){
        this.fitnessCentarRepository = fitnessCentarRepository;
    }

    @Override
    public List<FitnessCentar> findByNazivCentra(String naziv) {
        return fitnessCentarRepository.findByNazivCentra(naziv);
    }

    @Override
    public void delete(Long id) {
        fitnessCentarRepository.deleteById(id);
    }

    @Override
    public FitnessCentar save(FitnessCentar fitnessCentar) throws Exception {
        if(fitnessCentar.getId() != null){
            throw new Exception("ID mora biti jedinstven");
        }
        FitnessCentar novi = this.fitnessCentarRepository.save(fitnessCentar);
        return  novi;

    }

    @Override
    public FitnessCentar findOne(Long id) {
        FitnessCentar fitnessCentar = this.fitnessCentarRepository.findById(id).get();
        return fitnessCentar;
    }

    @Override
    public List<FitnessCentar> findAll() {


        List<FitnessCentar> fitnessCentri = this.fitnessCentarRepository.findAll();
        return fitnessCentri;
    }

    @Override
    public FitnessCentar azuriranje(FitnessCentar fitnessCentar)  {

        FitnessCentar noviFC = this.fitnessCentarRepository.save(fitnessCentar);
        return noviFC;
    }
}
