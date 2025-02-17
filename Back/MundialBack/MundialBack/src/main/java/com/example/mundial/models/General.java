/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.mundial.models;

import java.util.List;

public class General {
    String pais;
    String imagen;
    List<Ficha> jugadores;

    public General(String pais, String imagen, List<Ficha> jugadores) {
        this.pais = pais;
        this.imagen = imagen;
        this.jugadores = jugadores;
    }
    
    

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    

    public List<Ficha> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<Ficha> jugadores) {
        this.jugadores = jugadores;
    }
    
    
    
}
