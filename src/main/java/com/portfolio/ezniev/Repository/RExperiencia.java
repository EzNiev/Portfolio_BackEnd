package com.portfolio.ezniev.Repository;

import com.portfolio.ezniev.Entity.Experiencia;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RExperiencia extends JpaRepository<Experiencia, Integer>{
    public Optional<Experiencia> findByTituloE(String tituloE);
    public boolean existsByTituloE(String tituloE);
}