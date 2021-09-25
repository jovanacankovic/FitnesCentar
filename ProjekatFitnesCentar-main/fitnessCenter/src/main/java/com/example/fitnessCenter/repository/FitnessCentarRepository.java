package com.example.fitnessCenter.repository;

import com.example.fitnessCenter.entity.FitnessCentar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FitnessCentarRepository extends JpaRepository<FitnessCentar,Long> {

    List<FitnessCentar> findByNazivCentra(String naziv);
    List<FitnessCentar> findByAdresaCentra(String adresa);
    List<FitnessCentar> findByBrojTelefonaCentrale(String broj);
    List<FitnessCentar> findByEmailCentra(String mail);




}
