package com.portfolio.ezniev.Repository;

import com.portfolio.ezniev.Entity.Educacion;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface REducacion extends JpaRepository<Educacion, Integer>{
    public Optional<Educacion> findByTituloEd(String tituloEd);
    public boolean existsByTituloEd(String tituloEd);
}