package com.example.fitnessCenter.repository;


import com.example.fitnessCenter.entity.ListaTreninga;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.fitnessCenter.entity.RasporedTreninga;

import java.util.Date;
import java.util.List;

public interface RasporedRepository extends JpaRepository<ListaTreninga,Long>{


    List<ListaTreninga> findByDatumPocetkaTreninga(Date pocetak);
    List<ListaTreninga> findByDatumKrajaTreninga(Date kraj);
    List<ListaTreninga> findByCena(double cena);

}
