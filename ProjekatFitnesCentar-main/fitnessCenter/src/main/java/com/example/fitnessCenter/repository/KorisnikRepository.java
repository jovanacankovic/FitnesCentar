package com.example.fitnessCenter.repository;

import com.example.fitnessCenter.entity.Korisnik;
import com.example.fitnessCenter.entity.Uloga;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KorisnikRepository extends JpaRepository<Korisnik,Long> {

/*
    Korisnik findByKorisnickoIme(String korisnicko);
    Korisnik findByKorisnickoImeAndLozinka(String korisnicko, String lozinka);
    List<Korisnik> findAllByUloga(Uloga uloga);
*/
}
