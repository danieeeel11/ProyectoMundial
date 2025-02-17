/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.mundial.models;

import org.bson.types.ObjectId;

/**
 *
 * @author gab
 */
public class ConteoFicha {
    ObjectId ficha;
    Integer cantidad =0;
    Boolean pegado = false;

    public ConteoFicha(ObjectId ficha, Integer cantidad) {
        this.ficha = ficha;
        this.cantidad = cantidad;
    }

    public Boolean getPegado() {
        return pegado;
    }

    public void setPegado(Boolean pegado) {
        this.pegado = pegado;
    }
    
    

    public ObjectId getFicha() {
        return ficha;
    }

    public void setFicha(ObjectId ficha) {
        this.ficha = ficha;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
    
    
}
