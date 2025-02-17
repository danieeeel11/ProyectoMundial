/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.mundial.repositories;

import com.example.mundial.models.Equipo;
import com.example.mundial.models.Ficha;
import java.util.List;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 *
 * @author gab
 */
public interface FichaCrudRepo extends MongoRepository<Ficha, ObjectId>{
    
    @Query("{_id: { $in: ?0 } })")
    List<Ficha> findByIds(List<ObjectId> ids);
    
    List<Ficha> findByEquipo(String e);
}
