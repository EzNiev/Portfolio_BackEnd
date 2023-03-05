package com.portfolio.ezniev.Service;

import com.portfolio.ezniev.Entity.Educacion;
import com.portfolio.ezniev.Repository.REducacion;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SEducacion {
    @Autowired
    REducacion rEducacion;
    
    public List<Educacion> list(){
        return rEducacion.findAll();
    }
    
    public Optional<Educacion> getOne(int id){
        return rEducacion.findById(id);
    }
    
    public Optional<Educacion> getByTituloEd(String TituloEd){
        return rEducacion.findByTituloEd(TituloEd);
    }
    
    public void save(Educacion expe){
        rEducacion.save(expe);
    }
    
    public void delete(int id){
        rEducacion.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rEducacion.existsById(id);
    }
    
    public boolean existsByTituloE(String TituloE){
        return rEducacion.existsByTituloEd(TituloE);
    }
}
