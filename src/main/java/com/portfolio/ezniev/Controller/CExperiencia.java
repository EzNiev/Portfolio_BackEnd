package com.portfolio.ezniev.Controller;

import com.portfolio.ezniev.Dto.dtoExperiencia;
import com.portfolio.ezniev.Entity.Experiencia;
import com.portfolio.ezniev.Security.Controller.Mensaje;
import com.portfolio.ezniev.Service.SExperiencia;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/experiencia")
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "https://portfolio-ezniev.web.app")
public class CExperiencia {
    @Autowired
    SExperiencia sExperiencia;

    @GetMapping("/lista")
    public ResponseEntity<List<Experiencia>> list() {
        List<Experiencia> list = sExperiencia.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Experiencia> getById(@PathVariable("id") int id){
        if(!sExperiencia.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Experiencia experiencia = sExperiencia.getOne(id).get();
        return new ResponseEntity(experiencia, HttpStatus.OK);
    }   
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoExperiencia dtoexp) {
        if(StringUtils.isBlank(dtoexp.getTituloE())) 
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        if(sExperiencia.existsByTituloE(dtoexp.getTituloE())) 
            return new ResponseEntity(new Mensaje("Esa experiencia existe"), HttpStatus.BAD_REQUEST);
        

        Experiencia experiencia = new Experiencia(dtoexp.getTituloE(),
                dtoexp.getModalidadE(),
                dtoexp.getEmpresaE(),
                dtoexp.getPeriodoE(),
                dtoexp.getUbicacionE(),
                dtoexp.getDescripcionE(),
                dtoexp.getImgE());
        sExperiencia.save(experiencia);

        return new ResponseEntity(new Mensaje("Experiencia agregada correctamente."), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoExperiencia dtoexp) {
        //Validamos si existe el ID
        if (!sExperiencia.existsById(id)) 
            return new ResponseEntity(new Mensaje("El ID no existe."), HttpStatus.BAD_REQUEST);
        
        //Compara nombre de experiencia
        if (sExperiencia.existsByTituloE(dtoexp.getTituloE()) && sExperiencia.getByTituloE(dtoexp.getTituloE()).get().getId() != id) 
            return new ResponseEntity(new Mensaje("Esa experiencia ya existe."), HttpStatus.BAD_REQUEST);
        
        //No puede estar vacio
        if (StringUtils.isBlank(dtoexp.getTituloE())) 
            return new ResponseEntity(new Mensaje("El nombre es obligatorio."), HttpStatus.BAD_REQUEST);
        

        Experiencia experiencia = sExperiencia.getOne(id).get();
        experiencia.setTituloE(dtoexp.getTituloE());
        experiencia.setModalidadE(dtoexp.getModalidadE());
        experiencia.setEmpresaE(dtoexp.getEmpresaE());
        experiencia.setPeriodoE(dtoexp.getPeriodoE());
        experiencia.setUbicacionE(dtoexp.getUbicacionE());
        experiencia.setDescripcionE(dtoexp.getDescripcionE());
        experiencia.setImgE(dtoexp.getImgE());
        
        sExperiencia.save(experiencia);
        return new ResponseEntity(new Mensaje("Experiencia actualizada/editada."), HttpStatus.OK);
    }
    
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        //Validamos si existe el ID
        if (!sExperiencia.existsById(id)) 
            return new ResponseEntity(new Mensaje("El ID no existe."), HttpStatus.BAD_REQUEST);
            
        sExperiencia.delete(id);
         
        return new ResponseEntity(new Mensaje("Experiencia eliminada."), HttpStatus.OK);
    }
}