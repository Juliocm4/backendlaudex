package com.examen.prueba.cont;

import com.examen.prueba.dto.msn;
import com.examen.prueba.dto.proddto;
import com.examen.prueba.ent.prod;
import com.examen.prueba.serv.prodserv;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prod")
@CrossOrigin(origins = "http://localhost:4200/")
public class prodcont {

    @Autowired
    prodserv prodserv;

    @GetMapping("/lista")
    public ResponseEntity<List<prod>> list(){
        List<prod> list = prodserv.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<prod> getById(@PathVariable("id") int id){
        if(!prodserv.existsById(id))
            return new ResponseEntity(new msn("no existe"), HttpStatus.NOT_FOUND);
        prod producto = prodserv.getOne(id).get();
        return new ResponseEntity(producto, HttpStatus.OK);
    }

    @GetMapping("/detailname/{nombre}")
    public ResponseEntity<prod> getByNom(@PathVariable("nombre") String nom){
        if(!prodserv.existsByNom(nom))
            return new ResponseEntity(new msn("no existe"), HttpStatus.NOT_FOUND);
        prod producto = prodserv.getByNom(nom).get();
        return new ResponseEntity(producto, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody proddto p){
        if(prodserv.existsByNom(p.getNom()))
            return new ResponseEntity(new msn("ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        prod monito = new prod(p.getNom(),p.getApp(),p.getApm(),p.getFechanac(),p.getSexo(),p.getGrado(),p.getEmail(),p.getTel());
        prodserv.save(monito);
        return new ResponseEntity(new msn("Alumno dado de alta"), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")int id){
        if(!prodserv.existsById(id))
            return new ResponseEntity(new msn("no existe"), HttpStatus.NOT_FOUND);
        prodserv.delete(id);
        return new ResponseEntity(new msn("Alumno eliminado"), HttpStatus.OK);
    }
}
