package com.example.fitnessCenter.service.impl;

import com.example.fitnessCenter.entity.Administrator;
import com.example.fitnessCenter.entity.Trener;
import com.example.fitnessCenter.repository.AministratorRepository;
import com.example.fitnessCenter.service.AdministratorService;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdministratorServiceImpl implements AdministratorService {
    private final AministratorRepository aministratorRepository;

    @Autowired
    public AdministratorServiceImpl(AministratorRepository aministratorRepository){
        this.aministratorRepository = aministratorRepository;
    }

    @Override
    public Administrator save(Administrator admin) throws Exception {
        if(admin.getId() != null){
            throw new Exception("ID mora biti jedinstven, vec postoji korisnik sa tim ID-em!");
        }
        Administrator novi = aministratorRepository.save(admin);
        return  novi;
    }



    @Override
    public void delete(Long id) {
        this.aministratorRepository.deleteById(id);
    }

    @Override
    public Administrator getByKorisnickoImeAndLozinka(String korisnicko, String lozinka) {
        Administrator admin = this.aministratorRepository.findByKorisnickoImeAndLozinka(korisnicko,lozinka);
        return admin;
    }

    @Override
    public Administrator findOne(Long id) {

        Administrator admin = this.aministratorRepository.findById(id).get();
        return admin;
    }

    @Override
    public List<Administrator> findAll() {

        List<Administrator> admini = this.aministratorRepository.findAll();
        return admini;
    }

    @Override
    public Administrator update (Administrator admin) throws Exception{
        Administrator updated = this.aministratorRepository.findById(admin.getId()).get();
        if(admin.getId() == null){
            throw  new Exception("Greska! Nepostojeci korisnik!");
        }
        updated.setDatumRodjenja(admin.getDatumRodjenja());
        updated.setEmail(admin.getEmail());
        updated.setIme(admin.getIme());
        updated.setTelefon(admin.getTelefon());
        updated.setPrezime(admin.getPrezime());
        Administrator promenjen = aministratorRepository.save(updated);
        return promenjen;
    }
}
