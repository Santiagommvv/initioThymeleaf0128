package com.initioSpring.web;

import com.initioSpring.domain.Persona;
import com.initioSpring.service.PersonaService;
import java.util.Iterator;
import java.util.ArrayList;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class ControladorInicio {
    @Autowired
    private PersonaService personaService ;
    
    @GetMapping("/")
    public String inicio(Model model, @AuthenticationPrincipal User user){
        
        log.info("Autorizado >>>> >>>> >>>>\n "+user);
        
        Iterable<Persona> personas = personaService.listarPersonas();
        model.addAttribute("personas", personas);
        
        Iterator<Persona> iteraPersonas  = personas.iterator();
        Double saldoTotal = 0D;
        Integer totalClientes = 0;
        
        
        //al no tener var.size() en Iterator/Iterable en esta versión de Java, aumento desde acá el totalClientes
        for(Persona p : personas){
            saldoTotal += p.getSaldo();
            totalClientes++;
        }
        
        model.addAttribute("saldoTotal", saldoTotal);
        model.addAttribute("totalClientes", totalClientes);
        
        log.info("saldoTotal >>>> |||| >>>>\n "+saldoTotal);
        log.info("totalClientes >>>> |||| >>>>\n "+totalClientes);
        
        return "index";
    }
    
    @GetMapping("/agregar")
    public String agregar(Persona persona){
        return "modificar";
    }
    
    @PostMapping("/guardar")
    public String guardar(@Valid Persona persona, Errors errores){
        if(errores.hasErrors()){
            return "modificar";
        }
        personaService.guardar(persona);
        return "redirect:/";
    }
    
    // persona = idPersona automáticamente, sin new ni setter
    @GetMapping("/editar/{idPersona}") 
    public String editar(Persona persona, Model model){
        persona = personaService.encontrarPersona(persona);
        model.addAttribute("persona",persona);
        return "modificar";
    }
    
    @GetMapping("/eliminar/{idPersona}") 
    public String eliminar(Persona persona){
        personaService.eliminar(persona);
        return "redirect:/";
    }
}
