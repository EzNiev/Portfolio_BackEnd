package com.portfolio.ezniev.Dto;

import javax.validation.constraints.NotBlank;



public class dtoProyectos {
    @NotBlank
    private String tituloP;
    @NotBlank
    private String descripcionP;
    @NotBlank
    private String urlP;
    @NotBlank
    private String imgP;

    public dtoProyectos() {
    }

    public dtoProyectos(String tituloP, String descripcionP, String urlP, String imgP) {
        this.tituloP = tituloP;
        this.descripcionP = descripcionP;
        this.urlP = urlP;
        this.imgP = imgP;
    }

    public String getTituloP() {
        return tituloP;
    }

    public void setTituloP(String tituloP) {
        this.tituloP = tituloP;
    }

    public String getDescripcionP() {
        return descripcionP;
    }

    public void setDescripcionP(String descripcionP) {
        this.descripcionP = descripcionP;
    }

    public String getUrlP() {
        return urlP;
    }

    public void setUrlP(String urlP) {
        this.urlP = urlP;
    }

    public String getImgP() {
        return imgP;
    }

    public void setImgP(String imgP) {
        this.imgP = imgP;
    }
    
    
}
