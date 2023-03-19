package com.portfolio.ezniev.Controller;

import com.portfolio.ezniev.Dto.dtoSkills;
import com.portfolio.ezniev.Entity.Skills;
import com.portfolio.ezniev.Security.Controller.Mensaje;
import com.portfolio.ezniev.Service.SSkills;
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
@RequestMapping("/skills")
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "https://portfolio-ezniev.web.app")
public class CSkills {

    @Autowired
    SSkills sSkills;

    @GetMapping("/lista")
    public ResponseEntity<List<Skills>> list() {
        List<Skills> list = sSkills.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Skills> getById(@PathVariable("id") int id) {
        if (!sSkills.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe ese skill"), HttpStatus.NOT_FOUND);
        }
        Skills skill = sSkills.getOne(id).get();
        return new ResponseEntity(skill, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoSkills dtoskill) {
        if (StringUtils.isBlank(dtoskill.getNombreS())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        if (sSkills.existsByNombreS(dtoskill.getNombreS())) {
            return new ResponseEntity(new Mensaje("Esa skill ya existe"), HttpStatus.BAD_REQUEST);
        }

        Skills skill = new Skills(dtoskill.getNombreS(),
                dtoskill.getPorcentajeS(),
                dtoskill.getImgS());
        sSkills.save(skill);

        return new ResponseEntity(new Mensaje("Skill agregada correctamente."), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoSkills dtoskill) {
        //Validamos si existe el ID
        if (!sSkills.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe."), HttpStatus.BAD_REQUEST);
        }

        //Compara nombre de skill
        if (sSkills.existsByNombreS(dtoskill.getNombreS()) && sSkills.getByNombreS(dtoskill.getNombreS()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Esa skill ya existe."), HttpStatus.BAD_REQUEST);
        }

        //No puede estar vacio
        if (StringUtils.isBlank(dtoskill.getNombreS())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio."), HttpStatus.BAD_REQUEST);
        }

        Skills skill = sSkills.getOne(id).get();
        skill.setNombreS(dtoskill.getNombreS());
        skill.setPorcentajeS(dtoskill.getPorcentajeS());
        skill.setImgS(dtoskill.getImgS());

        sSkills.save(skill);
        return new ResponseEntity(new Mensaje("Skill actualizada/editada."), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        //Validamos si existe el ID
        if (!sSkills.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe."), HttpStatus.BAD_REQUEST);
        }

        sSkills.delete(id);

        return new ResponseEntity(new Mensaje("Skill eliminada."), HttpStatus.OK);
    }
}

