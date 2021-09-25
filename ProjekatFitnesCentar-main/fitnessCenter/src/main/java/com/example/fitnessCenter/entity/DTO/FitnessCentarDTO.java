package com.example.fitnessCenter.entity.DTO;

import com.example.fitnessCenter.entity.ListaTreninga;
import com.example.fitnessCenter.entity.Sala;
import com.example.fitnessCenter.entity.Trener;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class FitnessCentarDTO implements Serializable {
    private Long id;
    private String nazivCentra;
    private String adresaCentra;
    private String brojTelefonaCentrale;
    private String emailCentra;
    private Long idSale;


    public FitnessCentarDTO() {
    }

    public FitnessCentarDTO(Long id, String nazivCentra, String adresaCentra, String brojTelefonaCentrale, String emailCentra) {
        this.id = id;
        this.nazivCentra = nazivCentra;
        this.adresaCentra = adresaCentra;
        this.brojTelefonaCentrale = brojTelefonaCentrale;
        this.emailCentra = emailCentra;
    }

    public FitnessCentarDTO(Long id, String nazivCentra, String adresaCentra, String brojTelefonaCentrale, String emailCentra, Long sala) {
        this.id = id;
        this.nazivCentra = nazivCentra;
        this.adresaCentra = adresaCentra;
        this.brojTelefonaCentrale = brojTelefonaCentrale;
        this.emailCentra = emailCentra;
        this.idSale = sala;
    }
}
