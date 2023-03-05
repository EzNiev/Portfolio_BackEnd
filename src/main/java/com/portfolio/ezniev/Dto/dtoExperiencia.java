package com.portfolio.ezniev.Dto;

import javax.validation.constraints.NotBlank;

public class dtoExperiencia {
    @NotBlank
    private String tituloE;
    @NotBlank
    private String modalidadE;
    @NotBlank
    private String empresaE;
    @NotBlank
    private String periodoE;
    @NotBlank
    private String ubicacionE;
    @NotBlank
    private String descripcionE;
    @NotBlank
    private String imgE;

    public dtoExperiencia() {
    }

    public dtoExperiencia(String tituloE, String modalidadE, String empresaE, String periodoE, String ubicacionE, String descripcionE, String imgE) {
        this.tituloE = tituloE;
        this.modalidadE = modalidadE;
        this.empresaE = empresaE;
        this.periodoE = periodoE;
        this.ubicacionE = ubicacionE;
        this.descripcionE = descripcionE;
        this.imgE = imgE;
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