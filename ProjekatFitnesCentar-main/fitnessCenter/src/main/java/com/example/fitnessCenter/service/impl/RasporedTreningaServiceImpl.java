package com.example.fitnessCenter.service.impl;

import com.example.fitnessCenter.entity.ListaTreninga;
import com.example.fitnessCenter.entity.RasporedTreninga;
import com.example.fitnessCenter.repository.RasporedRepository;
import com.example.fitnessCenter.service.RasporedTreningaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RasporedTreningaServiceImpl implements RasporedTreningaService {

    private final RasporedRepository rasporedRepository;

    @Autowired
    public RasporedTreningaServiceImpl(RasporedRepository rasporedRepository){this.rasporedRepository = rasporedRepository;}



    @Override
    public ListaTreninga save(ListaTreninga termin) throws Exception {
        if(termin.getId() != null) {
            throw new Exception("ID must be null!");
       }
        ListaTreninga noviTermin = this.rasporedRepository.save(termin);
        return noviTermin;
    }
    @Override
    public ListaTreninga azuriranje(ListaTreninga termin)  {

        ListaTreninga noviTermin = this.rasporedRepository.save(termin);
        return noviTermin;
    }


    @Override
    public ListaTreninga findOne(Long id){
        ListaTreninga termin = this.rasporedRepository.findById(id).get();
        return termin;
    }

    @Override
    public List<ListaTreninga> findAll() {
        List<ListaTreninga> termini = this.rasporedRepository.findAll();
        return termini;
    }

    @Override
    public ListaTreninga update(ListaTreninga termin) throws Exception {
        ListaTreninga TerminZaIzmenu = this.rasporedRepository.findById(termin.getId()).get();
        if(termin.getId() == null) {
            throw new Exception("Termin ne postoji!");
        }
        TerminZaIzmenu.setBrojPrijavljenih(termin.getBrojPrijavljenih());
        TerminZaIzmenu.setCena(termin.getCena());
        TerminZaIzmenu.setDatumKrajaTreninga(termin.getDatumKrajaTreninga());
        TerminZaIzmenu.setDatumPocetkaTreninga(termin.getDatumPocetkaTreninga());
        TerminZaIzmenu.setFitnessCentar(termin.getFitnessCentar());
        TerminZaIzmenu.setSala(termin.getSala());
        TerminZaIzmenu.setTrening(termin.getTrening());
        ListaTreninga izmenjenTermin = rasporedRepository.save(TerminZaIzmenu);
        return izmenjenTermin;
    }

    @Override
    public void delete(Long id) {
        this.rasporedRepository.deleteById(id);
    }
}
