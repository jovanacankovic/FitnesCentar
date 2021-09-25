package com.example.fitnessCenter.contoller;

import com.example.fitnessCenter.entity.DTO.*;
import com.example.fitnessCenter.entity.FitnessCentar;
import com.example.fitnessCenter.entity.ListaTreninga;
import com.example.fitnessCenter.entity.Sala;
import com.example.fitnessCenter.service.SalaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(value = "/api/sale")
public class SalaController {

    private final SalaService salaService;

    @Autowired
    public SalaController(SalaService salaService){
        this.salaService = salaService;
    }


    //sve sale
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<SalaDTO>> getSale(){
        List<Sala> salaList = this.salaService.findAll();
        List<SalaDTO> salaDTOS = new ArrayList<>();
        for(Sala fc : salaList){
            SalaDTO salaDTO = new SalaDTO(fc.getId(),fc.getOznaka(),fc.getKapacitet(), fc.getFitnessCentar());
            salaDTOS.add(salaDTO);
        }
        return new ResponseEntity<>(salaDTOS, HttpStatus.OK);
    }

    @PostMapping(value = "/brisanje",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> brisanje(@RequestBody IDKorisnikaDTO id) {
        Sala sala = this.salaService.findOne(id.getIdKorisnika());
        FitnessCentar fc = sala.getFitnessCentar();
        Set<ListaTreninga> listaTreninga = sala.getListaTreninga();
        fc.getSale().remove(sala);

        for(ListaTreninga lt : listaTreninga){
            if(lt.getSala() == sala){
                listaTreninga.remove(lt);
            }
        }

        this.salaService.delete(id.getIdKorisnika());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @PostMapping(value = ("/izmena"),
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SalaIzmenaDTO> izmena(@RequestBody IzmenaSaleDTO kDTO) throws Exception {
        Sala sala = salaService.findOne(kDTO.getIdTermina());
        sala.setOznaka(kDTO.getOznaka());
        sala.setKapacitet(kDTO.getKapacitet());
        salaService.azuriranje(sala);
        SalaIzmenaDTO tDTO = new SalaIzmenaDTO(sala.getOznaka(), sala.getKapacitet());

        return new ResponseEntity<>(tDTO,HttpStatus.OK);

    }


}
