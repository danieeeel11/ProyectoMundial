/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.mundial.models;

import java.io.Serializable;
import javax.persistence.Id;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 *
 * @author gab
 */
@Document("jugadores")
public class Ficha implements Serializable{
    @Id
    //@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private ObjectId id;
    @Field(name = "Jugador")
    String jugador;
    @Field(name = "Rol")
    String rol;
    @Field(name = "Imagen")
    String imagen;
    @Field(name = "Equipo")
    String equipo;
    @Field(name = "num_ficha")
    Integer num_ficha;

    public Integer getNum_ficha() {
        return num_ficha;
    }

    public void setNum_ficha(Integer num_ficha) {
        this.num_ficha = num_ficha;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getJugador() {
        return jugador;
    }

    public void setJugador(String jugador) {
        this.jugador = jugador;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    
    
    
    
    
}
