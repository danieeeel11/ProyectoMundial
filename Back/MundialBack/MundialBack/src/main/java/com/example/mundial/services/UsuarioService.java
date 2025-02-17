/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.mundial.services;

import com.example.mundial.models.ConteoFicha;
import com.example.mundial.models.Existe;
import com.example.mundial.models.Usuario;
import com.example.mundial.repositories.UsuarioRepositorio;
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
public class UsuarioService {

    @Autowired
    private UsuarioRepositorio usuarioRepo;

    public List<Usuario> obtenerUsuarios() {
        return usuarioRepo.obtenerUsuarios();
    }

    public Optional<Usuario> obtenerUsuario(int id) {
        return usuarioRepo.obtenerUsuario(id);
    }

    public Usuario crear(Usuario c) {
        List<Usuario> users = usuarioRepo.obtenerUsuarios();
        if(!users.isEmpty()){
            Integer mayor = users.get(0).getId();
            for (Usuario u : users) {
                if (u.getId() > mayor) {
                    mayor = u.getId();
                }
            }
            c.setId(mayor + 1);
            return usuarioRepo.guardar(c);
        }
        c.setId(0);
        return usuarioRepo.guardar(c);

    }
    
    public Existe login(String correo, String pass){
        Optional<Usuario> us= usuarioRepo.obtenerUsuarioCorreo(correo);
        if(us.isPresent()){
            Usuario obtenido = us.get();
            if(obtenido.getPassword().equals(pass)){
                return new Existe(true, obtenido);
            }
        }
        return new Existe(false, null);
    }

    public ConteoFicha ganarFicha(Integer idUser, ObjectId ficha) {
        Optional<Usuario> us = usuarioRepo.obtenerUsuario(idUser);
        if (us.isPresent()) {
            Usuario user = us.get();
            List<ConteoFicha> fichas = user.getFichas();
            for (ConteoFicha fl : fichas) {
                
                if (fl.getFicha().equals(ficha)) {
                    System.out.println("Entre es ficha repetida");
                    fl.setCantidad(fl.getCantidad() + 1);
                    usuarioRepo.actualizar(user);
                    return fl;
                }
            }
            ConteoFicha nueva = new ConteoFicha(ficha, 1);
            user.nuevaFicha(nueva);
            usuarioRepo.actualizar(user);
            return nueva;
        }
        return null;
    }
    
    public List<ConteoFicha> pegarFicha(Integer idUser, ObjectId ficha) {
        Optional<Usuario> us = usuarioRepo.obtenerUsuario(idUser);
        if (us.isPresent()) {
            Usuario user = us.get();
            List<ConteoFicha> fichas = user.getFichas();
            for (ConteoFicha fl : fichas) {
                if (fl.getFicha().equals(ficha)) {
                    fl.setPegado(true);
                    usuarioRepo.actualizar(user);
                    Optional<Usuario> user2 = usuarioRepo.obtenerUsuario(idUser);
                            if (user2.isPresent()) {
                                Usuario obtenido = user2.get();
                                return obtenido.getFichas();
                }
                }
            }
        }
        return usuarioRepo.obtenerUsuario(idUser).get().getFichas();
    }

    public Optional<Usuario> eliminarFicha(Integer idUser, ObjectId ficha) {
        Optional<Usuario> us = usuarioRepo.obtenerUsuario(idUser);
        if (us.isPresent()) {
            Usuario user = us.get();
            List<ConteoFicha> fichas = user.getFichas();
            for (ConteoFicha fl : fichas) {
                if (fl.getFicha().compareTo(ficha) >= 0) {
                    if (fl.getCantidad() > 1) {
                        fl.setCantidad(fl.getCantidad() - 1);
                    } else {
                        user.eliminarFicha(fl);
                    }
                    usuarioRepo.actualizar(user);
                    return usuarioRepo.obtenerUsuario(idUser);
                }
            }
        }
        return usuarioRepo.obtenerUsuario(idUser);
    }

    public Usuario actualizar(Usuario c) {
        if (c.getId() != null) {
            Optional<Usuario> cab = usuarioRepo.obtenerUsuario(c.getId());
            if (cab.isPresent()) {
                usuarioRepo.guardar(c);
            }
        }
        return c;
    }

    public List<ConteoFicha> obtenerFichasUser(Integer id) {
        Optional<Usuario> user = usuarioRepo.obtenerUsuario(id);
        if (user.isPresent()) {
            Usuario obtenido = user.get();
            return obtenido.getFichas();
        }
        return new ArrayList<ConteoFicha>();
    }

    public boolean eliminar(int id) {
        Optional<Usuario> cab = usuarioRepo.obtenerUsuario(id);
        if (cab.isPresent()) {
            usuarioRepo.eliminar(cab.get());
            return true;
        }
        return false;
    }

    public void eliminarTodo() {
        usuarioRepo.eliminarTodos();
    }

    public List<ConteoFicha> obtenerRepetidos(Integer id) {
        Optional<Usuario> user = usuarioRepo.obtenerUsuario(id);
        if (user.isPresent()) {
            Usuario obtenido = user.get();
            List<ConteoFicha> repetidas = new ArrayList<>();
            List<ConteoFicha> fichas = obtenido.getFichas();
            for (ConteoFicha ficha : fichas) {
                if (ficha.getCantidad() > 1) {
                    repetidas.add(ficha);
                }
            }
            return repetidas;
        }
        return new ArrayList<>();
    }

}
