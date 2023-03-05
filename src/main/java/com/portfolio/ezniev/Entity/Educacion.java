package com.portfolio.ezniev.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Educacion{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String tituloEd;
    private String subtituloEd;
    private String periodoEd;
    private String descripcionEd;
    private String imgEd;

    public Educacion() {
    }

    public Educacion(String tituloEd, String subtituloEd, String periodoEd, String descripcionEd, String imgEd) {
        this.tituloEd = tituloEd;
        this.subtituloEd = subtituloEd;
        this.periodoEd = periodoEd;
        this.descripcionEd = descripcionEd;
        this.imgEd = imgEd;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTituloEd() {
        return tituloEd;
    }

    public void setTituloEd(String tituloEd) {
        this.tituloEd = tituloEd;
    }

    public String getSubtituloEd() {
        return subtituloEd;
    }

    public void setSubtituloEd(String subtituloEd) {
        this.subtituloEd = subtituloEd;
    }

    public String getPeriodoEd() {
        return periodoEd;
    }

    public void setPeriodoEd(String periodoEd) {
        this.periodoEd = periodoEd;
    }

    public String getDescripcionEd() {
        return descripcionEd;
    }

    public void setDescripcionEd(String descripcionEd) {
        this.descripcionEd = descripcionEd;
    }

    public String getImgEd() {
        return imgEd;
    }

    public void setImgEd(String imgEd) {
        this.imgEd = imgEd;
    }
    
    
    
}
