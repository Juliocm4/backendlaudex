package com.examen.prueba.secu.repo;

import com.examen.prueba.secu.ent.usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface usurepo extends JpaRepository<usuario,Integer> {
    Optional<usuario> findByNombreUsuario(String nombreUsuario);
    boolean existsByNombreUsuario(String nombreUsuario);
}
