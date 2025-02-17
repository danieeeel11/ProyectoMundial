/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.mundial.models;

/**
 *
 * @author gab
 */
public class Existe {
    boolean existe;
    Usuario us; 

    public Existe(boolean existe, Usuario us) {
        this.existe = existe;
        this.us = us;
    }

    
    

    public boolean isExiste() {
        return existe;
    }

    public void setExiste(boolean existe) {
        this.existe = existe;
    }

    public Usuario getUs() {
        return us;
    }

    public void setUs(Usuario us) {
        this.us = us;
    }
    
    
    
}
