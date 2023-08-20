package com.initioSpring.dao;

import com.initioSpring.domain.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaDao extends JpaRepository<Persona, Long>{
    //si necesito métodos personalizados
}
