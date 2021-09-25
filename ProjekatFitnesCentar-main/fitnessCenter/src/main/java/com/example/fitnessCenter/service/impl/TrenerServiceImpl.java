package com.example.fitnessCenter.service.impl;

import com.example.fitnessCenter.entity.Trener;
import com.example.fitnessCenter.entity.Trening;
import com.example.fitnessCenter.repository.TrenerRepository;
import com.example.fitnessCenter.service.TrenerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrenerServiceImpl implements TrenerService {
    private final TrenerRepository trenerRepository;

    @Autowired
    public TrenerServiceImpl(TrenerRepository trenerRepository) {this.trenerRepository = trenerRepository; }

    @Override
    public Trener save(Trener trener) throws Exception {
        if(trener.getId() != null){
            throw new Exception("ID mora biti jedinstven");
        }
        Trener noviTrener = trenerRepository.save(trener);
        return  noviTrener;
    }

    @Override
    public void delete(Long id) {
            trenerRepository.deleteById(id);
    }

    @Override
    public Trener getByKorisnickoImeAndLozinka(String korisnicko, String lozinka) {
        Trener trener = this.trenerRepository.findByKorisnickoImeAndLozinka(korisnicko,lozinka);
        return  trener;
    }

    @Override
    public Trener findOne(Long id){
        Trener korisnik = this.trenerRepository.findById(id).get();
        return korisnik;
    }

    @Override
    public List<Trener> findAll(){
        List<Trener> korisnici = this.trenerRepository.findAll();
        return korisnici;
    }


    @Override
    public Trener update(Trener korisnik) throws Exception {
        Trener korisnikZaIzmenu = this.trenerRepository.findById(korisnik.getId()).get();
        if(korisnik.getId() == null) {
            throw new Exception("User doesn't exist!");
        }
        korisnikZaIzmenu.setIme(korisnik.getIme());
        korisnikZaIzmenu.setPrezime(korisnik.getPrezime());
        korisnikZaIzmenu.setDatumRodjenja(korisnik.getDatumRodjenja());
        korisnikZaIzmenu.setEmail(korisnik.getEmail());
        korisnikZaIzmenu.setTelefon(korisnik.getTelefon());
        Trener izmenjenKorisnik = trenerRepository.save(korisnikZaIzmenu);
        return izmenjenKorisnik;
    }

}
