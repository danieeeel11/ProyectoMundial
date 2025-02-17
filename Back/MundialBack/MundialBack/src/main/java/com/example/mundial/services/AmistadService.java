/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.mundial.services;

import com.example.mundial.models.Amistad;
import com.example.mundial.repositories.AmistadRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author gab
 */
@Service
public class AmistadService {
    @Autowired
    private AmistadRepositorio amistadRepo;
    
    public List<Amistad> obtenerAmistades(){
        return amistadRepo.obtenerAmistades();
    }
    
    public Optional<Amistad> obtenerAmistad(int id){
        return amistadRepo.obtenerAmistad(id);
    }
    
    public Amistad crear(Amistad c){
        if(c.getId()== null){
            return amistadRepo.guardar(c);
        }else{
            Optional<Amistad> cab= amistadRepo.obtenerAmistad(c.getId());
            if(cab.isPresent()){
                return c;
            }else{
                return amistadRepo.guardar(c);
            }
        }
    }
}
