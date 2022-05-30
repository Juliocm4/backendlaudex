package com.examen.prueba.repo;

import com.examen.prueba.ent.prod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface prodrepo extends JpaRepository<prod,Integer> {
    Optional<prod> findByNom(String nom);
    boolean existsByNom(String nom);
}
