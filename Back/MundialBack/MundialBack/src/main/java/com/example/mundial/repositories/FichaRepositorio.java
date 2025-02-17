/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.mundial.repositories;

import com.example.mundial.models.Ficha;
import java.util.List;
import java.util.Optional;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author gab
 */
@Repository
public class FichaRepositorio {
    @Autowired
    FichaCrudRepo repo;
    
    public List<Ficha> obtenerJugadores(){
        return (List<Ficha>) repo.findAll();
    }
    
    public List<Ficha> obtenerJugadoresPorEquipo(String equipo){
        return (List<Ficha>) repo.findByEquipo(equipo);
    }
    
    public List<Ficha> obtenerJugadoresEnLista(List<ObjectId> lista){
        System.out.println("llego "+lista);
        return (List<Ficha>) repo.findByIds(lista);
    }
    
    public Optional<Ficha> obtenerFicha(ObjectId id){
        return repo.findById(id);
    }
    
    public void eliminarTodos(){
        repo.deleteAll();
    }
    
}
