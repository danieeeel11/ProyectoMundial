/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.mundial.controllers;

import com.example.mundial.models.ConteoFicha;
import com.example.mundial.models.Equipo;
import com.example.mundial.services.EquipoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author gab
 */
@RestController
//@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/equipos")
public class EquipoControlador {
    @Autowired
    private EquipoService productoService;
    
    @GetMapping("/obtener")
    public List<Equipo> getAll(){
        return productoService.obtenerProductos();
    }
    
    
}
