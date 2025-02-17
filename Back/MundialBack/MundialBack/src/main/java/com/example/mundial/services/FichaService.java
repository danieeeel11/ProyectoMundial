/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.mundial.services;

import com.example.mundial.models.ConteoFicha;
import com.example.mundial.models.Equipo;
import com.example.mundial.models.Ficha;
import com.example.mundial.models.General;
import com.example.mundial.models.Resumen;
import com.example.mundial.repositories.FichaRepositorio;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author gab
 */
@Service
public class FichaService {
    @Autowired
    private FichaRepositorio fichaRepo;
    
    public List<Ficha> obtenerJugadores(){
        return fichaRepo.obtenerJugadores();
    }

    public List<Ficha> obtenerJugadoresPorEquipo(String equipo){
        return fichaRepo.obtenerJugadoresPorEquipo(equipo);
    }
    
    public List<General> obtenerEquiposCompletos(List<Equipo> equipos){
        List<General> salidas = new ArrayList<>();
        for(Equipo eq: equipos){
            List<Ficha> jugadores = fichaRepo.obtenerJugadoresPorEquipo(eq.getPais());
            General g = new General(eq.getPais(),eq.getImagen(), jugadores);
            salidas.add(g);
        }
        return salidas;
    }
    
    public List<Resumen> obtenerJugadoresEnLista(List<ConteoFicha> fichas){
        List<ObjectId> objects = new ArrayList<>();
      //  List<ObjectId> lista =  obtenido.getFichas();
        for(ConteoFicha f: fichas){
            objects.add(f.getFicha());
            
        }
        List<Ficha> fichas2 = fichaRepo.obtenerJugadoresEnLista(objects);
        List<Resumen> resumen = new ArrayList<>();
        for(int i =0; i < fichas2.size(); i++){
            for(int j =0; j < fichas.size(); j++){
                if(fichas.get(j).getFicha().equals(fichas2.get(i).getId())){
                    Resumen r = new Resumen(fichas2.get(i), fichas.get(j).getCantidad(), fichas.get(j).getPegado());
                    resumen.add(r);
                }
            }
        }
        return resumen;
    }
    
    public Optional<Ficha> obtenerFichaId(ObjectId id){
        return fichaRepo.obtenerFicha(id);
    }
    
    public Ficha obtenerFichaRandom(){
        List<Ficha> fichas = fichaRepo.obtenerJugadores();
        int indice = (int)(Math.random()*fichas.size()+0);
        return fichas.get(indice);
    }
    
    public void eliminarTodo(){
        fichaRepo.eliminarTodos();
    }
}
