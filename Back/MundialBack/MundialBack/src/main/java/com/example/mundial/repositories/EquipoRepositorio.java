/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.mundial.repositories;

import com.example.mundial.models.Equipo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author gab
 */
@Repository
public class EquipoRepositorio {
    @Autowired
    EquipoCrudRepo repo;
    
    public List<Equipo> obtenerEquipos(){
        return (List<Equipo>) repo.findAll();
    }
    
    public void eliminarTodos(){
        repo.deleteAll();
    }
    /*
    public List<Equipo> obtenerEquiposCategoria(int categoria){
        return (List<Equipo>) repo.findByCategoria(categoria);
    }
    
    public Optional<Equipo> obtenerEquipo(int id){
        return repo.findById(id);
    }
    
    public Equipo guardar(Equipo c){
        return repo.save(c);
    }
    
    public List<Equipo> guardarVarios(List<Equipo> productos){
        return repo.saveAll(productos);
    }
    
    
    public void eliminar(Equipo c){
        repo.delete(c);
    }
    
    public void eliminarTodos(){
        repo.deleteAll();
    }
    */
    
            
}
