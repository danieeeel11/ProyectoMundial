/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.mundial.repositories;

import com.example.mundial.models.Amistad;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author gab
 */
@Repository
public class AmistadRepositorio {
    @Autowired
    AmistadCrudRepo repo;
    
    
    public List<Amistad> obtenerAmistades(){
        return (List<Amistad>) repo.findAll();
    }
    
    public Amistad guardar(Amistad c){
        return repo.save(c);
    }
    
    public Optional<Amistad> obtenerAmistad(int id){
        return repo.findById(id);
    }
    
    public void eliminarTodos(){
        repo.deleteAll();
    }
    
}
