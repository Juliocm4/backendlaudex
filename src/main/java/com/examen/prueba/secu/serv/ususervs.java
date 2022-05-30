package com.examen.prueba.secu.serv;

import com.examen.prueba.secu.ent.usuario;
import com.examen.prueba.secu.repo.usurepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

@Service
@Transactional
public class ususervs {
    @Autowired
    usurepo usurepo;

    public Optional<usuario> getByNombreUsuario(String nombreUsuario){
        return usurepo.findByNombreUsuario(nombreUsuario);
    }

    public boolean existsByNombreUsuario(String nombreUsuario){
        return usurepo.existsByNombreUsuario(nombreUsuario);
    }

    public void save(usuario usuario){
        usurepo.save(usuario);
    }
}
