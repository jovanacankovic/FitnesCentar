package com.example.fitnessCenter.service.impl;

import com.example.fitnessCenter.entity.Administrator;
import com.example.fitnessCenter.entity.Clan;
import com.example.fitnessCenter.entity.Trening;
import com.example.fitnessCenter.repository.ClanRepository;
import com.example.fitnessCenter.service.ClanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClanServiceImpl implements ClanService {
    private  final ClanRepository clanRepository;

    @Autowired
    public ClanServiceImpl(ClanRepository clanRepository){
        this.clanRepository = clanRepository;
    }

    @Override
    public Clan findByKorisnickoIme(String korisnickoIme) {
        return clanRepository.findByKorisnickoIme(korisnickoIme);
    }

    @Override
    public Clan getByKorisnickoImeAndLozinka(String korisnicko, String lozinka) {
        Clan clan = this.clanRepository.findByKorisnickoImeAndLozinka(korisnicko,lozinka);
        return clan;
    }

    @Override
    public Clan findByKorisnickoImeAndLozinkaAndAktivan(String korisnickoIme, String lozinka, boolean aktivan) {
        return this.clanRepository.findByKorisnickoImeAndLozinkaAndAktivan(korisnickoIme,lozinka,aktivan);
    }

    @Override
    public Clan save (Clan clan) throws Exception{
        if(clan.getId() != null){
            throw new Exception("ID mora biti jedinstven");
        }
        Clan novi = clanRepository.save(clan);
        return  novi;
    }

    @Override
    public void delete(Long id){
        this.clanRepository.deleteById(id);
    }

    @Override
    public List<Clan> findAll(){

        List<Clan> clanovi = this.clanRepository.findAll();
        return clanovi;
    }
    @Override
    public Clan findOne(Long id) {

        Clan clan = this.clanRepository.findById(id).get();
        return clan;
    }
    @Override
    public Clan update (Clan admin) throws Exception{
        Clan updated = this.clanRepository.findById(admin.getId()).get();
        if(admin.getId() == null){
            throw  new Exception("Greska! Nepostojeci korisnik!");
        }
        updated.setDatumRodjenja(admin.getDatumRodjenja());
        updated.setEmail(admin.getEmail());
        updated.setIme(admin.getIme());
        updated.setTelefon(admin.getTelefon());
        updated.setPrezime(admin.getPrezime());
        Clan promenjen = clanRepository.save(updated);
        return promenjen;
    }

    @Override
    public Clan azuriranje(Clan clan)  {

        Clan noviClan = this.clanRepository.save(clan);
        return noviClan;
    }



}
