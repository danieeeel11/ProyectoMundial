/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.mundial.controllers;

import com.example.mundial.models.ConteoFicha;
import com.example.mundial.models.Existe;
import com.example.mundial.models.Ficha;
import com.example.mundial.models.Usuario;
import com.example.mundial.services.UsuarioService;
import java.util.List;
import java.util.Optional;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/usuario")
public class UsuarioControlador {
    @Autowired
    private UsuarioService usuarioService;
    
    @GetMapping("/obtener")
    public List<Usuario> getAll(){
        return usuarioService.obtenerUsuarios();
    }
    
    @CrossOrigin(origins = "*")
    @PostMapping("/login")
    public Existe login(@RequestBody Usuario c){
        return usuarioService.login(c.getCorreo(), c.getPassword());
    }
    
    @CrossOrigin(origins = "*")
    @PostMapping("/guardar")
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario save(@RequestBody Usuario c){
        return usuarioService.crear(c);
    }
    
    @GetMapping("/{id}")
    public Optional<Usuario> getUsuario(@PathVariable("id") int id) {
        return usuarioService.obtenerUsuario(id);
    }
    
    
    @CrossOrigin(origins = "*")
    @PutMapping("/actualizar")
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario update(@RequestBody Usuario category) {
        return usuarioService.actualizar(category);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)     
    public boolean delete(@PathVariable("id") int id) {
        return usuarioService.eliminar(id);
    }
    
    @CrossOrigin(origins = "*")
    @PutMapping("/agregar_ficha/{user}/{ficha}")
    @ResponseStatus(HttpStatus.CREATED)
    public ConteoFicha agregarFicha(@PathVariable("user") Integer idUser, @PathVariable("ficha") String idFicha) {
        ObjectId ficha= new ObjectId(idFicha);
        return usuarioService.ganarFicha(idUser, ficha);
    }
    
    @CrossOrigin(origins = "*")
    @PutMapping("/pegar_ficha/{user}/{ficha}")
    @ResponseStatus(HttpStatus.CREATED)
    public List<ConteoFicha> pegarFicha(@PathVariable("user") Integer idUser, @PathVariable("ficha") String idFicha) {
        ObjectId ficha= new ObjectId(idFicha);
        return usuarioService.pegarFicha(idUser, ficha);
    }
    
    @CrossOrigin(origins = "*")
    @GetMapping("/obtener_fichas/{user}")
    public List<ConteoFicha> obtenerFichaUsuario(@PathVariable("user") Integer idUser) {
        //ObjectId ficha= new ObjectId(idFicha);
        return usuarioService.obtenerFichasUser(idUser);
    }
    
    @CrossOrigin(origins = "*")
    @GetMapping("/obtener_repetidos/{user}")
    public List<ConteoFicha> obtenerFichaRepetidas(@PathVariable("user") Integer idUser) {
        //ObjectId ficha= new ObjectId(idFicha);
        return usuarioService.obtenerRepetidos(idUser);
    }
    
    @CrossOrigin(origins = "*")
    @DeleteMapping("/remover_ficha/{user}/{ficha}")
    public Optional<Usuario> obtenerFichaRepetidas(@PathVariable("user") Integer idUser, @PathVariable("ficha") String idFicha) {
        ObjectId ficha= new ObjectId(idFicha);
        return usuarioService.eliminarFicha(idUser, ficha);
    }
    
}
