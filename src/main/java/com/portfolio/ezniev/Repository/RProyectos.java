package com.portfolio.ezniev.Repository;

import com.portfolio.ezniev.Entity.Proyectos;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RProyectos extends JpaRepository<Proyectos, Integer> {
    public Optional<Proyectos> findByTituloP(String tituloP);
    public boolean existsByTituloP(String tituloP);
}
