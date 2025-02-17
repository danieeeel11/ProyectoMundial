
package com.example.mundial.controllers;

import com.example.mundial.models.Amistad;
import com.example.mundial.models.Usuario;
import com.example.mundial.services.AmistadService;
import com.example.mundial.services.UsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/*
arreglar los jugadores (11), ruta para obtener todos los usuarios 
1 cargar los paises y que al presionar uno cargue el album en la pagina de ese pais (Gabriela)
2 hacer ventana para ganar ficha random obtener un ficha random (Gabriela y MIguel )
3 hacer ventana que muestra las fichas repetidas santidago y daniel
4 hacer login y registro santidago y daniel
5 el usuario puede ver cuales son sus fichas (brayan)
6 el usuario pega la ficha en el front aparece simbolo en donde pueda pegar fichas (Carla) 
*/
@RestController
//@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/amistad")
public class AmistadControlador {
    @Autowired
    private AmistadService amistadService;
    
    @GetMapping("/obtener")
    public List<Amistad> getAll(){
        return amistadService.obtenerAmistades();
    }
    
    @CrossOrigin(origins = "*")
    @PostMapping("/guardar")
    @ResponseStatus(HttpStatus.CREATED)
    public Amistad save(@RequestBody Amistad c){
        return amistadService.crear(c);
    }
    
}
