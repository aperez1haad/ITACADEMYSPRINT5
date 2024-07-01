package com.cat.itacademy.barcelonactiva.PerezBraveso.Alejandro.s05.t01.n02.Model.DTO;

import java.util.Arrays;
import java.util.List;

public class FlorEntityDTO {
    private int pk_FlorID;
    private String nomFlor;
    private String paisFlor;

    private String tipusFlor;
    private static final List<String> paises = Arrays.asList("Alemania", "Austria", "Bélgica", "Bulgaria",
            "Chipre", "Croacia", "Dinamarca", "Eslovaquia", "Eslovenia", "España", "Estonia", "Finlandia", "Francia",
            "Grecia", "Hungría", "Irlanda", "Italia", "Letonia", "Lituania", "Luxemburgo", "Malta", "Países Bajos",
            "Polonia", "Portugal", "República Checa", "Rumanía", "Suecia");

    public FlorEntityDTO(){}

    public FlorEntityDTO(int pk_FlorID, String nomFlor, String paisFlor) {
        this.pk_FlorID = pk_FlorID;
        this.nomFlor = nomFlor;
        this.paisFlor = paisFlor;
        this.tipusFlor = paises.contains(paisFlor) ? "Dentro UE" : "Fuera UE";
    }

    public int getPk_FlorID() {
        return pk_FlorID;
    }
    public void setPk_FlorID(int pk_FlorID) {
        this.pk_FlorID = pk_FlorID;
    }
    public String getNomFlor() {
        return nomFlor;
    }
    public void setNomFlor(String nomFlor) {
        this.nomFlor = nomFlor;
    }
    public String getPaisFlor() {
        return paisFlor;
    }
    public void setPaisFlor(String paisFlor) {
        this.paisFlor = paisFlor;
    }
    public String getTipusFlor() {
        return tipusFlor;
    }
    public void setTipusFlor(String tipusFlor) {
        this.tipusFlor = tipusFlor;
    }
}
