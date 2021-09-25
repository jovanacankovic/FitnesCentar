package com.example.fitnessCenter.repository;

import com.example.fitnessCenter.entity.FitnessCentar;
import com.example.fitnessCenter.entity.Trener;
import com.example.fitnessCenter.entity.Trening;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface TrenerRepository extends JpaRepository<Trener,Long> {
    Trener findByKorisnickoImeAndLozinka(String korisnicko, String lozinka);
    Trener findByKorisnickoImeAndLozinkaAndAktivan(String korisnicko, String lozinka, boolean aktivan);
}
