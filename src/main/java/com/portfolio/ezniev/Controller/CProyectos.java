package com.portfolio.ezniev.Controller;

import com.portfolio.ezniev.Dto.dtoProyectos;
import com.portfolio.ezniev.Entity.Proyectos;
import com.portfolio.ezniev.Security.Controller.Mensaje;
import com.portfolio.ezniev.Service.SProyectos;
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
@RequestMapping("/proyectos")
@CrossOrigin(origins = {"http://localhost:4200"})
public class CProyectos {
    @Autowired
    SProyectos sProyectos;

    @GetMapping("/lista")
    public ResponseEntity<List<Proyectos>> list() {
        List<Proyectos> list = sProyectos.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Proyectos> getById(@PathVariable("id") int id){
        if(!sProyectos.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Proyectos proyectos = sProyectos.getOne(id).get();
        return new ResponseEntity(proyectos, HttpStatus.OK);
    }   
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoProyectos dtopro) {
        if(StringUtils.isBlank(dtopro.getTituloP())) 
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        if(sProyectos.existsByTituloP(dtopro.getTituloP())) 
            return new ResponseEntity(new Mensaje("Ese proyecto ya está agregado"), HttpStatus.BAD_REQUEST);
        

        Proyectos proyectos = new Proyectos(dtopro.getTituloP(),
                dtopro.getDescripcionP(),
                dtopro.getUrlP(),
                dtopro.getImgP());
        sProyectos.save(proyectos);

        return new ResponseEntity(new Mensaje("Proyecto agregado correctamente."), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoProyectos dtopro) {
        //Validamos si existe el ID
        if (!sProyectos.existsById(id)) 
            return new ResponseEntity(new Mensaje("El ID no existe."), HttpStatus.BAD_REQUEST);
        
        //Compara nombre de proyecto
        if (sProyectos.existsByTituloP(dtopro.getTituloP()) && sProyectos.getByTituloP(dtopro.getTituloP()).get().getId() != id) 
            return new ResponseEntity(new Mensaje("Ese proyecto ya se agregó."), HttpStatus.BAD_REQUEST);
        
        //No puede estar vacio
        if (StringUtils.isBlank(dtopro.getTituloP())) 
            return new ResponseEntity(new Mensaje("El nombre es obligatorio."), HttpStatus.BAD_REQUEST);
        

        Proyectos proyectos = sProyectos.getOne(id).get();
        proyectos.setTituloP(dtopro.getTituloP());
        proyectos.setDescripcionP(dtopro.getDescripcionP());
        proyectos.setUrlP(dtopro.getUrlP());
        proyectos.setImgP(dtopro.getImgP());
        
        sProyectos.save(proyectos);
        return new ResponseEntity(new Mensaje("Proyectos actualizados/editados."), HttpStatus.OK);
    }
    
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        //Validamos si existe el ID
        if (!sProyectos.existsById(id)) 
            return new ResponseEntity(new Mensaje("El ID no existe."), HttpStatus.BAD_REQUEST);
            
        sProyectos.delete(id);
         
        return new ResponseEntity(new Mensaje("Experiencia eliminada."), HttpStatus.OK);
    }
}
