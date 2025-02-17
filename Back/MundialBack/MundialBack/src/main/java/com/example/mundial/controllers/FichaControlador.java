/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.mundial.controllers;

import com.example.mundial.models.ConteoFicha;
import com.example.mundial.models.Equipo;
import com.example.mundial.models.Ficha;
import com.example.mundial.models.General;
import com.example.mundial.models.Resumen;
import com.example.mundial.services.FichaService;
import java.util.List;
import java.util.Optional;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
@RequestMapping("/api/fichas")
public class FichaControlador {
    @Autowired
    public FichaService fichaService;
    
    @GetMapping("/obtener")
    public List<Ficha> getAll(){
        return fichaService.obtenerJugadores();
    }
    
    @GetMapping("/filtrar/{equipo}")
    public List<Ficha> obtenerJugadoresPorEquipo(@PathVariable("equipo") String equipo) {
        System.out.println(equipo);
        return fichaService.obtenerJugadoresPorEquipo(equipo);
    }
    
    @PostMapping("/obtener_con_jugadores")
    public List<General> todosConJugadores(@RequestBody List<Equipo> equipos){
        return fichaService.obtenerEquiposCompletos(equipos);
    }
    
    @PutMapping("/fichas_user")
    public List<Resumen> obtenerFichasEnLista(@RequestBody List<ConteoFicha> lista) {
        System.out.println(lista);
        return fichaService.obtenerJugadoresEnLista(lista);
    }
    

    @CrossOrigin(origins = "*")
    @GetMapping("/{id}")
    public Optional<Ficha> getFicha(@PathVariable("id") String id) {
        System.out.println(id);
        ObjectId ids= new ObjectId(id);
        return fichaService.obtenerFichaId(ids);
    }
    
    @CrossOrigin(origins = "*")
    @GetMapping("/random")
    public Ficha getFichaRandom() {
        return fichaService.obtenerFichaRandom();
    }
    
}
