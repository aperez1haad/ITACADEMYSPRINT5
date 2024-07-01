package com.cat.itacademy.barcelonactiva.PerezBraveso.Alejandro.s05.t01.n02.Model.Domain;
import jakarta.persistence.*;

@Entity
@Table(name="Flores")
public class FlorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int pk_FlorID;

    @Column(name="NOM")
    private String nomFlor;
    @Column(name="PAIS")
    private String paisflor;

    public FlorEntity(int pk_FlorID, String nomFlor, String paisflor){
        this.pk_FlorID = pk_FlorID;
        this.nomFlor = nomFlor;
        this.paisflor = paisflor;
    }
    public FlorEntity(String nomFlor, String paisflor){
        this.nomFlor = nomFlor;
        this.paisflor = paisflor;
    }
    public FlorEntity(){}



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

    public String getPaisflor() {
        return paisflor;
    }
    public void setPaisflor(String paisflor) {
        this.paisflor = paisflor;
    }
}
