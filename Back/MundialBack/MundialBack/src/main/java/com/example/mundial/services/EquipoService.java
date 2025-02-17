/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.mundial.services;

import com.example.mundial.models.Equipo;
import com.example.mundial.repositories.EquipoRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author gab
 */
@Service
public class EquipoService {
     @Autowired
    private EquipoRepositorio productoRepo;
    
    public List<Equipo> obtenerProductos(){
        return productoRepo.obtenerEquipos();
    }
    
}
