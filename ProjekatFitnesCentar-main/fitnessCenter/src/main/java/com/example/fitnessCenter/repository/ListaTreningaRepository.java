package com.example.fitnessCenter.repository;

import com.example.fitnessCenter.entity.FitnessCentar;
import com.example.fitnessCenter.entity.ListaTreninga;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ListaTreningaRepository extends JpaRepository<ListaTreninga,Long> {


}
