package com.example.fitnessCenter.service.impl;

import com.example.fitnessCenter.entity.OcenaTreninga;
import com.example.fitnessCenter.repository.OcenaRepository;
import com.example.fitnessCenter.service.OcenaTreningaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OcenaTreningaServiceImpl implements OcenaTreningaService {
    private final OcenaRepository ocenaRepository;

    @Autowired
    public OcenaTreningaServiceImpl(OcenaRepository ocenaRepository) {this.ocenaRepository = ocenaRepository;}


    @Override
    public OcenaTreninga save(OcenaTreninga trening) throws Exception {
        if(trening.getId() != null) {
            throw new Exception("ID must be null!");
        }
        OcenaTreninga noviTrening = this.ocenaRepository.save(trening);
        return noviTrening;
    }

    @Override
    public List<OcenaTreninga> findAll() {
        List<OcenaTreninga> OcenaTreninga = this.ocenaRepository.findAll();
        return OcenaTreninga;
    }

    @Override
    public OcenaTreninga findOne(Long id){
        OcenaTreninga OcenaTreninga = this.ocenaRepository.findById(id).get();
        return OcenaTreninga;
    }


    @Override
    public OcenaTreninga update(OcenaTreninga trening) throws Exception {
        OcenaTreninga updated = this.ocenaRepository.findById(trening.getId()).get();
        if(trening.getId() == null) {
            throw new Exception("Trening doesn't exist!");
        }
        updated.setTermin(trening.getTermin());
        updated.setClan(trening.getClan());
        updated.setOcena(trening.getOcena());

        OcenaTreninga promenjen = this.ocenaRepository.save(updated);
        return promenjen;
    }

    @Override
    public void delete(Long id) {
        this.ocenaRepository.deleteById(id);
    }

    @Override
    public List<OcenaTreninga> getByTreningId(Long id) {
        List<OcenaTreninga> ret = new ArrayList<>();


        for(OcenaTreninga ocena : this.ocenaRepository.findAll()) {
            if(ocena.getTermin().getTrening().getId() == id) {
                ret.add(ocena);
            }
        }
        return ret;

    }




}
