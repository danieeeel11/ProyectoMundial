/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.mundial.models;


public class Resumen {
    Ficha ficha;
    Integer cantidad;
    boolean pegado;

    public Resumen(Ficha ficha, Integer cantidad, boolean pegado) {
        this.ficha = ficha;
        this.cantidad = cantidad;
        this.pegado = pegado;
    }

    public Ficha getFicha() {
        return ficha;
    }

    public void setFicha(Ficha ficha) {
        this.ficha = ficha;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public boolean isPegado() {
        return pegado;
    }

    public void setPegado(boolean pegado) {
        this.pegado = pegado;
    }
    
    
    
}
