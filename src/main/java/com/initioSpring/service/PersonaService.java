package com.initioSpring.service;

import java.util.*;
import com.initioSpring.domain.Persona;

public interface PersonaService {
    
    public Iterable<Persona> listarPersonas();
    public void guardar(Persona persona);
    public void eliminar(Persona persona);
    public Persona encontrarPersona(Persona persona);
    
}
