package com.portfolio.ezniev.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    @Size(min = 2, max = 50, message= "Dato fuera de rango (1 a 50 caracteres)")
    private String nombre;
    
    @NotNull
    @Size(min = 2, max = 50, message= "Dato fuera de rango (1 a 50 caracteres)")
    private String apellido;
   
    @Size(min = 2, max = 50, message= "Dato fuera de rango (1 a 50 caracteres)")
    private String img;
    
    @Size(min = 2, max = 50, message= "Dato fuera de rango (1 a 50 caracteres)")
    private String profesion;
    
    @Size(min = 2, max = 1000, message= "Dato fuera de rango (1 a 1000 caracteres)")
    private String descripcion;
    
    @Size(min = 2, max = 50, message= "Dato fuera de rango (1 a 50 caracteres)")
    private String rutacv;
    
    
    
    
}

