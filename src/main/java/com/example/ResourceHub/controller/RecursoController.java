package com.example.ResourceHub.controller;

import com.example.ResourceHub.model.Recurso;
import com.example.ResourceHub.service.RecursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//Diferencia entre RestController y controller es que en controller regresabamos vistas aqui regresamos el recurso/objetos
@RestController
@RequestMapping("/api/recursos")
public class RecursoController {

    @Autowired
    private RecursoService recursoService;

    @GetMapping
    public List<Recurso> listar(){
        return recursoService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Recurso listarPorId(@PathVariable Long id){
        return recursoService.obtenerPorId(id).orElse(null);
    }
    //En los restFull no es necesario especificar la ruta en los get y post
    @PostMapping
    public Recurso crear(@RequestBody Recurso recurso){
        return recursoService.crear(recurso);
    }

    @PutMapping("/{id}")
    public Recurso actualizar(@RequestBody Recurso recurso, @PathVariable Long id){
        return recursoService.actualizar(id,recurso).orElse(null);
    }

    @PatchMapping("/{id}")
    public Recurso actualizarParcialmente(@RequestBody Recurso recurso, @PathVariable Long id){
        return recursoService.actualizar(id,recurso).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id){
        recursoService.eliminarRecurso(id);
    }


}
