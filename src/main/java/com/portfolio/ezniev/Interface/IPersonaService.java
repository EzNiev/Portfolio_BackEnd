package com.portfolio.ezniev.Interface;

import com.portfolio.ezniev.Entity.Persona;
import java.util.List;

public interface IPersonaService {
    //Traer una persona
    public List<Persona> getPersona();
    
    //Guardar un objeto de tipo persona
    public void savePersona(Persona persona);
    
    //Eliminar un usuario pero se busca por ID
    public void deletePersona(Long id);
    
    //Buscar persona por ID
    public Persona findPersona(Long id);
}
