package com.example.fitnessCenter.repository;

import com.example.fitnessCenter.entity.Administrator;
import com.example.fitnessCenter.entity.Uloga;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AministratorRepository extends JpaRepository<Administrator,Long> {
    Administrator findByKorisnickoImeAndLozinka(String korisnicko,String lozinka);
    List<Administrator> findAllByUloga(Uloga uloga);
}
