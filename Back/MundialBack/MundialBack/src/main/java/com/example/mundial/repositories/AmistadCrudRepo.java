/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.mundial.repositories;

import com.example.mundial.models.Amistad;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author gab
 */
public interface AmistadCrudRepo extends MongoRepository<Amistad, Integer>{
    
}
