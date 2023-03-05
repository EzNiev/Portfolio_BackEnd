package com.portfolio.ezniev.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Experiencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String tituloE;
    private String modalidadE;
    private String empresaE;
    private String periodoE;
    private String ubicacionE;
    private String descripcionE;
    private String imgE;

    public Experiencia() {
    }

    public Experiencia(String tituloE, String modalidadE, String empresaE, String periodoE, String ubicacionE, String descripcionE, String imgE) {
        this.tituloE = tituloE;
        this.modalidadE = modalidadE;
        this.empresaE = empresaE;
        this.periodoE = periodoE;
        this.ubicacionE = ubicacionE;
        this.descripcionE = descripcionE;
        this.imgE = imgE;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTituloE() {
        return tituloE;
    }

    public void setTituloE(String tituloE) {
        this.tituloE = tituloE;
    }

    public String getModalidadE() {
        return modalidadE;
    }

    public void setModalidadE(String modalidadE) {
        this.modalidadE = modalidadE;
    }

    public String getEmpresaE() {
        return empresaE;
    }

    public void setEmpresaE(String empresaE) {
        this.empresaE = empresaE;
    }

    public String getPeriodoE() {
        return periodoE;
    }

    public void setPeriodoE(String periodoE) {
        this.periodoE = periodoE;
    }

    public String getUbicacionE() {
        return ubicacionE;
    }

    public void setUbicacionE(String ubicacionE) {
        this.ubicacionE = ubicacionE;
    }

    public String getDescripcionE() {
        return descripcionE;
    }

    public void setDescripcionE(String descripcionE) {
        this.descripcionE = descripcionE;
    }

    public String getImgE() {
        return imgE;
    }

    public void setImgE(String imgE) {
        this.imgE = imgE;
    }
    
    

}
