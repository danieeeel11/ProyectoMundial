/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.mundial.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import org.springframework.data.mongodb.core.mapping.Field;


/**
 *
 * @author gab
 */
@Document("usuario")
public class Usuario {
    @Id
    //@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Integer id;
    @Indexed(unique=true)
    @NotNull
    String correo;
    @NotNull
    String password;
    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "usuario")
    List<ConteoFicha> fichas;
    @DBRef
    @ReadOnlyProperty
    @DocumentReference(lookup="{'persona1':?#{#self.id} }")
    List<Amistad> amigos;

    public Integer getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    

    public List<ConteoFicha> getFichas() {
        return fichas;
    }

    public void setFichas(List<ConteoFicha> fichas) {
        this.fichas = fichas;
    }

    public List<Amistad> getAmigos() {
        return amigos;
    }

    public void setAmigos(List<Amistad> amigos) {
        this.amigos = amigos;
    }

    

    
    
    public void nuevaFicha(ConteoFicha ficha) {
        this.fichas.add(ficha);
    }
    
    public void eliminarFicha(ConteoFicha ficha) {
        this.fichas.remove(ficha);
    }
    
    
    
    
}
