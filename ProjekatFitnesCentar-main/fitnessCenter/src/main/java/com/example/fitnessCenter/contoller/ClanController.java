package com.example.fitnessCenter.contoller;

import com.example.fitnessCenter.entity.Clan;
import com.example.fitnessCenter.entity.DTO.*;
import com.example.fitnessCenter.entity.Korisnik;
import com.example.fitnessCenter.entity.Sala;
import com.example.fitnessCenter.repository.ClanRepository;
import com.example.fitnessCenter.service.ClanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/clanovi")
public class ClanController {
    private final ClanService clanService;

    @Autowired
    public ClanController(ClanService clanService) {this.clanService = clanService;}


    @Autowired
    public ClanRepository clanRepository;

    //prikaz svih clanova
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<KorisnikDTO>> getUsers(){
        List<Clan> clanList = this.clanService.findAll();
        List<KorisnikDTO> trazeniKorisnici = new ArrayList<KorisnikDTO>();
        for(Clan c : clanList){
            KorisnikDTO korisnik = new KorisnikDTO(c.getId(),c.getIme(),c.getPrezime(),c.getTelefon(),c.getEmail(),c.getDatumRodjenja(),c.getUloga());
            trazeniKorisnici.add(korisnik);
        }
        return new ResponseEntity<>(trazeniKorisnici, HttpStatus.OK);
    }



    //kreiranje novog clana
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<KreiranjeKorisnikaDTO>createUser(@RequestBody KreiranjeKorisnikaDTO kreiranjeKorisnikaDTO) throws Exception{
       Clan clan = new Clan(kreiranjeKorisnikaDTO.getKorisnickoIme(),kreiranjeKorisnikaDTO.getLozinka(),kreiranjeKorisnikaDTO.getIme(),
               kreiranjeKorisnikaDTO.getPrezime(),kreiranjeKorisnikaDTO.getTelefon(),kreiranjeKorisnikaDTO.getEmail(),
               kreiranjeKorisnikaDTO.getDatumRodjenja(),kreiranjeKorisnikaDTO.getUloga());
       Clan noviClan = this.clanService.save(clan);
       KreiranjeKorisnikaDTO kreiranjeDTO = new KreiranjeKorisnikaDTO(noviClan.getId(),noviClan.getKorisnickoIme(),
               noviClan.getLozinka(),noviClan.getIme(),noviClan.getPrezime(),noviClan.getDatumRodjenja(),noviClan.getEmail(),
               noviClan.getTelefon(), noviClan.getUloga());
       return new ResponseEntity<>(kreiranjeDTO,HttpStatus.CREATED);
    }


    //brisanje clana
    @DeleteMapping(value = "{/id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        this.clanService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }











}
