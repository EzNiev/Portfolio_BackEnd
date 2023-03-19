package com.portfolio.ezniev.Controller;

import com.portfolio.ezniev.Dto.dtoEducacion;
import com.portfolio.ezniev.Entity.Educacion;
import com.portfolio.ezniev.Security.Controller.Mensaje;
import com.portfolio.ezniev.Service.SEducacion;
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
@RequestMapping("/educacion")
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "https://portfolio-ezniev.web.app")
public class CEducacion {
    @Autowired
    SEducacion sEducacion;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Educacion>> list() {
        List<Educacion> list = sEducacion.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Educacion> getById(@PathVariable("id") int id){
        if(!sEducacion.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Educacion educacion = sEducacion.getOne(id).get();
        return new ResponseEntity(educacion, HttpStatus.OK);
    }   
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoEducacion dtoedu) {
        if(StringUtils.isBlank(dtoedu.getTituloEd())) 
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        if(sEducacion.existsByTituloE(dtoedu.getTituloEd())) 
            return new ResponseEntity(new Mensaje("Esa educacion existe"), HttpStatus.BAD_REQUEST);
        

        Educacion educacion = new Educacion(dtoedu.getTituloEd(),
                dtoedu.getSubtituloEd(),
                dtoedu.getPeriodoEd(),
                dtoedu.getDescripcionEd(),
                dtoedu.getImgEd());
        sEducacion.save(educacion);

        return new ResponseEntity(new Mensaje("Educacion agregada correctamente."), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoEducacion dtoedu) {
        //Validamos si existe el ID
        if (!sEducacion.existsById(id)) 
            return new ResponseEntity(new Mensaje("El ID no existe."), HttpStatus.BAD_REQUEST);
        
        //Compara nombre de experiencia
        if (sEducacion.existsByTituloE(dtoedu.getTituloEd()) && sEducacion.getByTituloEd(dtoedu.getTituloEd()).get().getId() != id) 
            return new ResponseEntity(new Mensaje("Esa educacion ya existe."), HttpStatus.BAD_REQUEST);
        
        //No puede estar vacio
        if (StringUtils.isBlank(dtoedu.getTituloEd())) 
            return new ResponseEntity(new Mensaje("El nombre es obligatorio."), HttpStatus.BAD_REQUEST);
        

        Educacion educacion = sEducacion.getOne(id).get();
        educacion.setTituloEd(dtoedu.getTituloEd());
        educacion.setSubtituloEd(dtoedu.getSubtituloEd());
        educacion.setPeriodoEd(dtoedu.getPeriodoEd());
        educacion.setDescripcionEd(dtoedu.getDescripcionEd());
        educacion.setImgEd(dtoedu.getImgEd());
        
        sEducacion.save(educacion);
        return new ResponseEntity(new Mensaje("Experiencia actualizada/editada."), HttpStatus.OK);
    }
    
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        //Validamos si existe el ID
        if (!sEducacion.existsById(id)) 
            return new ResponseEntity(new Mensaje("El ID no existe."), HttpStatus.BAD_REQUEST);
            
        sEducacion.delete(id);
         
        return new ResponseEntity(new Mensaje("Educacion eliminada."), HttpStatus.OK);
    }
}
