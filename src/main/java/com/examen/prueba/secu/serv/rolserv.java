package com.examen.prueba.secu.serv;

import com.examen.prueba.secu.ent.rol;
import com.examen.prueba.secu.enums.rolnom;
import com.examen.prueba.secu.repo.rolrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class rolserv {
    @Autowired
    rolrepo rolRepository;

    public Optional<rol> getByRolNombre(rolnom rolNombre){
        return rolRepository.findByRolNombre(rolNombre);
    }

    public void save(rol rol){
        rolRepository.save(rol);
    }
}
