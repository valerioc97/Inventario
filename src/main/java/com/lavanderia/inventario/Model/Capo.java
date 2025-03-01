package com.lavanderia.inventario.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "Capi")
public class Capo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String idCapo;
    private String nomeCapo;
    private String descrizione;

    public String getIdCapo() {
        return idCapo;
    }

    public void setIdCapo(String idCapo) {
        this.idCapo = idCapo;
    }

    public String getNomeCapo() {
        return nomeCapo;
    }

    public void setNomeCapo(String nomeCapo) {
        this.nomeCapo = nomeCapo;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }
}
