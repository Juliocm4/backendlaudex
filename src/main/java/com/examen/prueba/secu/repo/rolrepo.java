package com.examen.prueba.secu.repo;
import com.examen.prueba.secu.ent.rol;
import com.examen.prueba.secu.enums.rolnom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface rolrepo extends JpaRepository<rol,Integer>{
    Optional<rol> findByRolNombre(rolnom rolNombre);
}
