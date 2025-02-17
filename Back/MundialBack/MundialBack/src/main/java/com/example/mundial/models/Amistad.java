/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.mundial.models;

import javax.persistence.Id;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 *
 * @author gab
 */

@Document("amistad")
public class Amistad {
    @Id
    //@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Field(name = "_id")
    private Integer id;
    @DocumentReference(lazy=true)
    Usuario persona1;
    @DocumentReference(lazy=true)
    Usuario persona2;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Usuario getPersona1() {
        return persona1;
    }

    public void setPersona1(Usuario persona1) {
        this.persona1 = persona1;
    }

    public Usuario getPersona2() {
        return persona2;
    }

    public void setPersona2(Usuario persona2) {
        this.persona2 = persona2;
    }
    
    
    
}
