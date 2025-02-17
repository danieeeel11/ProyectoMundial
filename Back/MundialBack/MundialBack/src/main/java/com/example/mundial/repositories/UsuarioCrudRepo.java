/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.mundial.repositories;


import com.example.mundial.models.ConteoFicha;
import com.example.mundial.models.Ficha;
import com.example.mundial.models.Usuario;
import java.util.List;
import java.util.Optional;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 *
 * @author gab
 */
public interface UsuarioCrudRepo extends MongoRepository<Usuario, Integer>{
    @Query("{_id: { $in: ?0 }, fichas.cantidad: { $gt: ?0 } })")
    List<ConteoFicha> findByIdAndCantidadGreaterThan(Integer id, Integer cantidad);
    Optional<Usuario> findByCorreo(String e);
}
