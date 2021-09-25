package com.example.fitnessCenter.contoller;


import com.example.fitnessCenter.entity.Clan;
import com.example.fitnessCenter.entity.DTO.OcenaTreningaDTO;
import com.example.fitnessCenter.entity.DTO.TacanKorisnikDTO;
import com.example.fitnessCenter.entity.ListaTreninga;
import com.example.fitnessCenter.entity.OcenaTreninga;
import com.example.fitnessCenter.entity.RasporedTreninga;
import com.example.fitnessCenter.service.ClanService;
import com.example.fitnessCenter.service.ListaTreningaService;
import com.example.fitnessCenter.service.OcenaTreningaService;
import com.example.fitnessCenter.service.RasporedTreningaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/api/ocenaTermina")
public class OcenaController {

    private final OcenaTreningaService ocenaTreningaService;
    private final ClanService clanService;
    private final RasporedTreningaService rasporedTreningaService;
    public OcenaController(OcenaTreningaService ocenaTreningaService, ClanService clanService, RasporedTreningaService rasporedTreningaService) {
        this.ocenaTreningaService = ocenaTreningaService;
        this.clanService = clanService;
        this.rasporedTreningaService = rasporedTreningaService;
    }


    @PostMapping(value = ("/ocenjivanje"),
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<OcenaTreninga> ocenjivanje(@RequestBody TacanKorisnikDTO info) throws Exception {
        Clan clan = clanService.findOne(info.getIdKorisnika());
        ListaTreninga listaTreninga = rasporedTreningaService.findOne(info.getIdTermina());
        OcenaTreninga ocena = new OcenaTreninga();
        ocena.setTermin(listaTreninga);
        ocena.setClan(clan);
        ocena.setOcena(info.getOcena());
        OcenaTreninga novaOcena = this.ocenaTreningaService.save(ocena);
        //TacanKorisnikDTO kdto = new TacanKorisnikDTO(novaOcena.getClan().getId(), novaOcena.getTermin().getId(), novaOcena.getOcena() );
        return new ResponseEntity<>(ocena, HttpStatus.OK);


    }



}
