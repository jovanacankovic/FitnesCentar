package com.example.fitnessCenter.service.impl;

import com.example.fitnessCenter.entity.TipTreninga;
import com.example.fitnessCenter.entity.Trening;
import com.example.fitnessCenter.repository.TreningRepository;
import com.example.fitnessCenter.service.TreningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TreningServiceImpl implements TreningService {
    private final TreningRepository treningRepository;

    @Autowired
    public TreningServiceImpl(TreningRepository treningRepository) {this.treningRepository = treningRepository;}




    //sortirano po nazivu
    @Override
    public List<Trening>findAllByNazivOrderByNaziv(String naziv){
        return treningRepository.findByNazivOrderByNaziv(naziv);
    }

    //jedan trening
    @Override
    public Trening findOne(Long id){
        Trening trening = this.treningRepository.findById(id).get();
        return trening;
        //return treningRepository.getOne(id);
    }


    //svi treninzi
    @Override
    public List<Trening> findAll(){
        List<Trening> treninzi = this.treningRepository.findAll();
        return treninzi;
    }


    //kreiranje novog treninga
    @Override
    public Trening save(Trening trening) throws Exception{
        if(trening.getId() != null){
            throw new Exception("ID mora biti jedinstven");
        }
        Trening noviTrening = treningRepository.save(trening);
        return  noviTrening;
    }

    //brisanje postojeceg treninga preko id-a
    @Override
    public void delete(Long id){
        treningRepository.deleteById(id);
    }


    //sortiranje po nazivu
    @Override
    public List<Trening>sortNaziv(){
        return treningRepository.findAllByOrderByNaziv();
    }

    @Override
    //sortiranje po vrsti treninga
    public List<Trening>sortTipTreninga(){
        return treningRepository.findAllByOrderByTipTreninga();
    }

    //dobavljanje po tipu
    @Override
    public List<Trening> findAllByTipTreninga(String tip){
        return treningRepository.findAllByTipTreninga(tip);
    }

    @Override
    public List<Trening> findByNaziv(String naziv){
        List<Trening> treningList = this.treningRepository.findByNaziv(naziv);
        return treningList;
    }


    @Override
    public List<Trening> sortTrajanje(){
        return treningRepository.findAllByOrderByTrajanje();
    }

    @Override
    public Trening update(Trening trening) throws Exception {
        Trening treningZaIzmenu = this.treningRepository.findById(trening.getId()).get();
        if(trening.getId() == null) {
            throw new Exception("Trening ne postoji");
        }
        treningZaIzmenu.setNaziv(trening.getNaziv());
        treningZaIzmenu.setOpis(trening.getOpis());
        treningZaIzmenu.setTrener(trening.getTrener());
        treningZaIzmenu.setTipTreninga(trening.getTipTreninga());
        treningZaIzmenu.setTrajanje(trening.getTrajanje());

        Trening izmenjenTrening = this.treningRepository.save(treningZaIzmenu);
        return izmenjenTrening;
    }





}
