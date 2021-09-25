package com.example.fitnessCenter.contoller;

import com.example.fitnessCenter.entity.DTO.KorisnikDTO;
import com.example.fitnessCenter.entity.DTO.RasporedTreneraDTO;
import com.example.fitnessCenter.entity.DTO.TreninziKorisnikaDTO;
import com.example.fitnessCenter.entity.DTO.TreninziTreneraDTO;
import com.example.fitnessCenter.entity.ListaTreninga;
import com.example.fitnessCenter.entity.Trener;
import com.example.fitnessCenter.entity.Trening;
import com.example.fitnessCenter.service.AdministratorService;
import com.example.fitnessCenter.service.TrenerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/trener")
public class TrenerController {
    private final TrenerService trenerService;
    private final AdministratorService administratorService;

    @Autowired
    public TrenerController(TrenerService trenerService, AdministratorService administratorService) {
        this.trenerService = trenerService;
        this.administratorService = administratorService;
    }


    @PostMapping(value = ("/treninziTrenera"),
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TreninziTreneraDTO>> treninziTrenera(@RequestBody TreninziKorisnikaDTO kDTO) throws Exception {
        Trener trener = trenerService.findOne(kDTO.getIdKorisnika());
        List<TreninziTreneraDTO> treninzi = new ArrayList<>();
        for(Trening t : trener.getListaTreninga()) {
            TreninziTreneraDTO trening = new TreninziTreneraDTO();
            trening.setId(t.getId());
            trening.setNaziv(t.getNaziv());
            trening.setOpis(t.getOpis());
            trening.setTrajanje(t.getTrajanje());
            trening.setTipTreninga(t.getTipTreninga());
            treninzi.add(trening);
        }
        return new ResponseEntity<>(treninzi, HttpStatus.OK);
    }



    @PostMapping(value = ("/terminiTrenera"),
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<RasporedTreneraDTO>> terminiTrenera(@RequestBody TreninziKorisnikaDTO kDTO) throws Exception {
        Trener trener = trenerService.findOne(kDTO.getIdKorisnika());
        List<RasporedTreneraDTO> treninzi = new ArrayList<>();
        for(Trening t : trener.getListaTreninga()) {
            for(ListaTreninga ter : t.getTerminiTreninga()) {
                RasporedTreneraDTO trening = new RasporedTreneraDTO();
                trening.setId(ter.getId());
                trening.setCena(ter.getCena());
                trening.setDatumPocetka(ter.getDatumPocetkaTreninga());
                trening.setNazivTreninga(ter.getTrening().getNaziv());
                treninzi.add(trening);
            }


        }
        return new ResponseEntity<>(treninzi, HttpStatus.OK);
    }


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<KorisnikDTO>> getUsers() {
        List<Trener> korisnici = this.trenerService.findAll();

        List<KorisnikDTO> trazeniKorisnici = new ArrayList<KorisnikDTO>();

        for(Trener k : korisnici) {
            KorisnikDTO korisnik = new KorisnikDTO(k.getId(),k.getIme(),k.getPrezime(),k.getTelefon(),
                    k.getEmail(),k.getDatumRodjenja(),k.getUloga());
            trazeniKorisnici.add(korisnik);
        }
        return new ResponseEntity<>(trazeniKorisnici, HttpStatus.OK);
    }

    @PostMapping(value = "/brisanje",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> brisanje(@RequestBody TreninziKorisnikaDTO id) throws Exception{

            this.trenerService.delete(id.getIdKorisnika());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }


}
