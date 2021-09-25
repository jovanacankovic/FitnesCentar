package com.example.fitnessCenter.contoller;

import com.example.fitnessCenter.entity.*;
import com.example.fitnessCenter.entity.DTO.*;
import com.example.fitnessCenter.service.AdministratorService;
import com.example.fitnessCenter.service.ClanService;
import com.example.fitnessCenter.service.KorisnikService;
import com.example.fitnessCenter.service.TrenerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/korisnik")
public class KorisnikController {
    private final ClanService clanService;
    private final TrenerService trenerService;
    private final AdministratorService administratorService;

    @Autowired
    public KorisnikController(ClanService clanService, TrenerService trenerService, AdministratorService administratorService) {this.clanService = clanService;
        this.trenerService = trenerService;
        this.administratorService = administratorService; }



    @GetMapping(value="/zahteviZaRegistracijuTrenera", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ZahteviZaRegistracijuDTO>> getRegistracijaTrenera() {
        List<Trener> treneri = this.trenerService.findAll();

        List<ZahteviZaRegistracijuDTO> trazeniTreneri = new ArrayList<ZahteviZaRegistracijuDTO>();

        for(Trener t : treneri) {
            if(t.isDaLiJeRegistrovan() == false) {
                ZahteviZaRegistracijuDTO trener = new ZahteviZaRegistracijuDTO( t.getKorisnickoIme(), t.getIme(), t.getPrezime(), t.getLozinka(),
                        t.getTelefon(), t.getEmail(), t.getDatumRodjenja(), t.getUloga());
                trazeniTreneri.add(trener);
            }

        }
        return new ResponseEntity<>(trazeniTreneri, HttpStatus.OK);
    }

    @PostMapping(
            value =("/login"),
    consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PrijavaKorisnikaDTO> KorisnikLogin(@RequestBody PrijavljenKorisnikDTO korisnikLoginDTO) throws Exception{
        Administrator admin = this.administratorService.getByKorisnickoImeAndLozinka(korisnikLoginDTO.getKorisnickoIme(), korisnikLoginDTO.getLozinka());
        Clan clan = this.clanService.getByKorisnickoImeAndLozinka(korisnikLoginDTO.getKorisnickoIme(), korisnikLoginDTO.getLozinka());
        Trener trener = this.trenerService.getByKorisnickoImeAndLozinka(korisnikLoginDTO.getKorisnickoIme(), korisnikLoginDTO.getLozinka());
        PrijavaKorisnikaDTO korisnikDTO = new PrijavaKorisnikaDTO();
        if(admin != null) {
            if(admin.isAktivan() == false || admin.isDaLiJeRegistrovan()== false) {

                throw new Exception("Nalog nije aktiviran");
            }
            else {
                korisnikDTO = new PrijavaKorisnikaDTO(admin.getId(), admin.getKorisnickoIme(), admin.getIme(), admin.getPrezime(),
                        "ne prenosim sifru", admin.getTelefon(), admin.getEmail(), admin.getDatumRodjenja(), admin.isAktivan(), admin.getUloga());
                return new ResponseEntity<>(korisnikDTO,HttpStatus.OK);
            }


        }
        else if(clan != null) {
            if(clan.isAktivan() == false || clan.isDaLiJeRegistrovan() == false) {
                throw new Exception("Nalog nije aktiviran");
            }
            else{
                korisnikDTO = new PrijavaKorisnikaDTO(clan.getId(), clan.getKorisnickoIme(), clan.getIme(), clan.getPrezime(),
                        "ne prenosim sifru", clan.getTelefon(), clan.getEmail(), clan.getDatumRodjenja(), clan.isAktivan(), clan.getUloga());
                return new ResponseEntity<>(korisnikDTO,HttpStatus.OK);

            }


        }
        else if(trener != null) {
            if(trener.isAktivan() == false || trener.isDaLiJeRegistrovan() == false) {
                throw new Exception("Nalog nije aktiviran");
            }
            else{
                korisnikDTO = new PrijavaKorisnikaDTO(trener.getId(), trener.getKorisnickoIme(), trener.getIme(), trener.getPrezime(),
                        "ne prenosim sifru", trener.getTelefon(), trener.getEmail(), trener.getDatumRodjenja(), trener.isAktivan(), trener.getUloga());
                return new ResponseEntity<>(korisnikDTO,HttpStatus.OK);
            }

        }
        else
            throw new Exception("Kredincijali nisu tacni");

    }

    @GetMapping(value = "/clanovi/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<KorisnikDTO> getClan(@PathVariable("id") Long id)
    {
        Clan korisnik = this.clanService.findOne(id);
        KorisnikDTO trazeniKorisnik = new KorisnikDTO();
        trazeniKorisnik.setId(korisnik.getId());
        trazeniKorisnik.setIme(korisnik.getIme());
        trazeniKorisnik.setPrezime(korisnik.getPrezime());
        trazeniKorisnik.setDatumRodjenja(korisnik.getDatumRodjenja());
        trazeniKorisnik.setEmail(korisnik.getEmail());
        trazeniKorisnik.setTelefon(korisnik.getTelefon());
        trazeniKorisnik.setUloga(korisnik.getUloga());

        return new ResponseEntity<>(trazeniKorisnik, HttpStatus.OK);
    }

    @GetMapping(value="/clanovi", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<KorisnikDTO>> getClanovi() {
        List<Clan> korisnici = this.clanService.findAll();

        List<KorisnikDTO> trazeniKorisnici = new ArrayList<KorisnikDTO>();

        for(Clan k : korisnici) {
            KorisnikDTO korisnik = new KorisnikDTO(k.getId(),k.getIme(),k.getPrezime(),k.getTelefon(),
                    k.getEmail(),k.getDatumRodjenja(),k.getUloga());
            trazeniKorisnici.add(korisnik);
        }
        return new ResponseEntity<>(trazeniKorisnici, HttpStatus.OK);
    }



    @PostMapping(value="/registrujClana" ,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RegistrujKorisnikaDTO> createClan(@RequestBody RegistrujKorisnikaDTO DTO) throws Exception {
       Clan postojeciClan = this.clanService.getByKorisnickoImeAndLozinka(DTO.getKorisnickoIme(),DTO.getLozinka());
       //ako vec postoji clan
       if(postojeciClan != null){
           return new ResponseEntity<>(HttpStatus.CONFLICT);
       }
       //u suprotnom
        Clan clan = new Clan(DTO.getKorisnickoIme(), DTO.getLozinka(), DTO.getIme(), DTO.getPrezime(),
               DTO.getTelefon(), DTO.getEmail(), DTO.getDatumRodjenja(),DTO.getUloga(),true,true);
        clan.setKorisnickoIme(DTO.getKorisnickoIme());


       Clan noviClan =this.clanService.save(clan);

       RegistrujKorisnikaDTO korisnikDTO = new RegistrujKorisnikaDTO(noviClan.getKorisnickoIme(),noviClan.getLozinka(),
               noviClan.getIme(), noviClan.getPrezime(), noviClan.getDatumRodjenja(), noviClan.getEmail(), noviClan.getTelefon(), noviClan.getUloga(),true,true);
       return new ResponseEntity<>(korisnikDTO,HttpStatus.OK);
    }

    @PostMapping(value="/registrujTrenera",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<KreiranjeKorisnikaDTO> createTrener(@RequestBody ZahteviZaRegistracijuDTO DTO) throws Exception {
        Trener korisnik = new Trener(
                DTO.getKorisnickoIme(),DTO.getLozinka(),DTO.getIme(),DTO.getPrezime(),
                DTO.getTelefon(),DTO.getEmail(),DTO.getDatumRodjenja(),DTO.getUloga(),true,false
        );

        Trener noviKorisnik = this.trenerService.save(korisnik);
        KreiranjeKorisnikaDTO korisnikDTO = new KreiranjeKorisnikaDTO(noviKorisnik.getId(), noviKorisnik.getKorisnickoIme(),
                noviKorisnik.getLozinka(), noviKorisnik.getIme(), noviKorisnik.getPrezime(),noviKorisnik.getDatumRodjenja(),
                noviKorisnik.getEmail(), noviKorisnik.getTelefon(), noviKorisnik.getUloga());
        return new ResponseEntity<>(korisnikDTO, HttpStatus.CREATED);

    }



    @DeleteMapping(value = "/clanovi/{id}")
    public ResponseEntity<Void> deleteClan(@PathVariable Long id) {
        this.clanService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }




    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value="/treneri")
    public ResponseEntity<List<KorisnikDTO>> getTreneri() {
        List<Trener> korisnici = this.trenerService.findAll();

        List<KorisnikDTO> trazeniKorisnici = new ArrayList<KorisnikDTO>();

        for(Trener k : korisnici) {
            KorisnikDTO korisnik = new KorisnikDTO(k.getId(),k.getIme(),k.getPrezime(),k.getTelefon(),
                    k.getEmail(),k.getDatumRodjenja(),k.getUloga());
            trazeniKorisnici.add(korisnik);
        }
        return new ResponseEntity<>(trazeniKorisnici, HttpStatus.OK);
    }






    @DeleteMapping(value = "/treneri/{id}")
    public ResponseEntity<Void> deleteTrener(@PathVariable Long id) {
        this.trenerService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



    @PostMapping(value = ("/odobriRegistraciju"),
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OdobriRegistracijuDTO> odobri(@RequestBody OdobrenaRegistracijaDTO kDTO) throws Exception {
        Trener trener = new Trener(kDTO.getKorisnickoIme(), kDTO.getLozinka(), kDTO.getIme(), kDTO.getPrezime(), kDTO.getTelefon(), kDTO.getEmail(),kDTO.getDatumRodjenja());
        System.out.println(kDTO.getIme());
        trener.setUloga(Uloga.TRENER);
        trener.setAktivan(true);
        trener.setDaLiJeRegistrovan(true);
        Trener noviTrener = this.trenerService.save(trener);

        OdobriRegistracijuDTO tDTO = new OdobriRegistracijuDTO(noviTrener.getIme(),noviTrener.getPrezime(),noviTrener.getEmail(),noviTrener.getTelefon(),true,true);

        return new ResponseEntity<>(tDTO,HttpStatus.OK);

    }

    @PostMapping(value="/registracijaTreneraAdmin" ,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RegistrujTreneraAdminDTO> registrujTreneraAdmin(@RequestBody RegistrujTreneraAdminDTO DTO) throws Exception {
        Trener postojeciTrener = this.trenerService.getByKorisnickoImeAndLozinka(DTO.getKorisnickoIme(),DTO.getLozinka());
        //ako vec postoji clan
        if(postojeciTrener != null){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        //u suprotnom
        Trener trener = new Trener(DTO.getKorisnickoIme(), DTO.getLozinka(), DTO.getIme(), DTO.getPrezime(),
                DTO.getTelefon(), DTO.getEmail(), DTO.getDatumRodjenja(),DTO.getUloga(),true,true);
        trenerService.save(trener);
        RegistrujTreneraAdminDTO korisnikDTO = new RegistrujTreneraAdminDTO(trener.getId(),trener.getKorisnickoIme(),trener.getLozinka(),
                trener.getIme(), trener.getPrezime(), trener.getDatumRodjenja(), trener.getEmail(), trener.getTelefon(), trener.getUloga(),true,true,0);
        return new ResponseEntity<>(korisnikDTO,HttpStatus.OK);
    }




}
