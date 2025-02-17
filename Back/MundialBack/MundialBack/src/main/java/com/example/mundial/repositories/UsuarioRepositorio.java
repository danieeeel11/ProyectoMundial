/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.mundial.repositories;

import com.example.mundial.models.ConteoFicha;
import com.example.mundial.models.Usuario;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author gab
 */
@Repository
public class UsuarioRepositorio {
    @Autowired
    UsuarioCrudRepo repo;
    
    public List<Usuario> obtenerUsuarios(){
        return (List<Usuario>) repo.findAll();
    }
    
    
    public Optional<Usuario> obtenerUsuario(int id){
        return repo.findById(id);
    }
    
    public Optional<Usuario> obtenerUsuarioCorreo(String correo){
        return repo.findByCorreo(correo);
    }
    
    public Usuario guardar(Usuario c){
        return repo.save(c);
    }
    
    
    public void eliminar(Usuario c){
        repo.delete(c);
    }
    
    public void eliminarTodos(){
        repo.deleteAll();
    }
    
    public Usuario actualizar(Usuario c){
        return repo.save(c);
    }
    
    public List<ConteoFicha> obtenerRepetidos(Integer id, Integer cantidad){
        System.out.println("me ll=amana repe");
        return repo.findByIdAndCantidadGreaterThan(id, cantidad);
    }
    /*
    public void agregarFicha(){
        repo.
    }*/

}
