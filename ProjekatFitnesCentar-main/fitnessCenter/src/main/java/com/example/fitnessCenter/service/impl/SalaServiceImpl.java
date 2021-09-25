package com.example.fitnessCenter.service.impl;

import com.example.fitnessCenter.entity.FitnessCentar;
import com.example.fitnessCenter.entity.ListaTreninga;
import com.example.fitnessCenter.entity.OcenaTreninga;
import com.example.fitnessCenter.entity.Sala;
import com.example.fitnessCenter.repository.RasporedRepository;
import com.example.fitnessCenter.repository.SalaRepository;
import com.example.fitnessCenter.service.SalaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalaServiceImpl implements SalaService {
    private final SalaRepository salaRepository;
    @Autowired
    public SalaServiceImpl(SalaRepository salaRepository){this.salaRepository = salaRepository;}

    @Override
    public Sala findOne(Long id){
        Sala sala = this.salaRepository.findById(id).get();
        return sala;
    }


    @Override
    public Sala save(Sala sala) throws Exception {
        if(sala.getId() != null) {
            throw new Exception("ID must be null!");
        }
        Sala novaSala = this.salaRepository.save(sala);
        return novaSala;
    }

    @Override
    public List<Sala> findAll() {
        List<Sala> sale = this.salaRepository.findAll();
        return sale;
    }
    @Override
    public void delete(Long id) {
        salaRepository.deleteById(id);
    }

    @Override
    public Sala azuriranje(Sala sala)  {

        Sala novaSala = this.salaRepository.save(sala);
        return novaSala;
    }


}
