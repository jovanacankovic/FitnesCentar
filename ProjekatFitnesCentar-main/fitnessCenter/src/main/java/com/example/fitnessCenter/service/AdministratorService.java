package com.example.fitnessCenter.service;

import com.example.fitnessCenter.entity.Administrator;

import java.util.List;

public interface AdministratorService {
    Administrator save(Administrator admin) throws Exception;
    Administrator update(Administrator admin) throws Exception;
    void delete(Long id);
    Administrator getByKorisnickoImeAndLozinka(String korisnicko,String lozinka);
    Administrator findOne(Long id);
    List<Administrator> findAll();
}
