package com.examen.prueba.serv;


import com.examen.prueba.ent.prod;
import com.examen.prueba.repo.prodrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class prodserv {
    @Autowired
    prodrepo prodrepo;
    public List<prod> list(){
        return prodrepo.findAll();
    }

    public Optional<prod> getOne(int id){
        return prodrepo.findById(id);
    }

    public Optional<prod> getByNom(String nom){
        return prodrepo.findByNom(nom);
    }

    public void  save(prod prod){
        prodrepo.save(prod);
    }

    public void delete(int id){
        prodrepo.deleteById(id);
    }

    public boolean existsById(int id){
        return prodrepo.existsById(id);
    }

    public boolean existsByNom(String nom) {
        return prodrepo.existsByNom(nom);
    }
}
