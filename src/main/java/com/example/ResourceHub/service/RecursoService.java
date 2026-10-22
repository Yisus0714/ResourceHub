package com.example.ResourceHub.service;

import com.example.ResourceHub.model.Recurso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.ResourceHub.Repository.RecursoRepository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class RecursoService {
    @Autowired
    private RecursoRepository recursoRepository;
    public List<Recurso> obtenerTodos(){
        return recursoRepository.findAll();
    }

    public Optional<Recurso> obtenerPorId(Long id){
        return recursoRepository.findById(id);
    }

    public Recurso crear(Recurso recurso){
        return recursoRepository.save(recurso);
    }

    public Optional<Recurso> actualizar(Long id, Recurso recurso){
        return recursoRepository.findById(id).map(recursoexist -> {
            recursoexist.setTitulo(recurso.getTitulo());
            recursoexist.setCategoria(recurso.getUrl());
            recursoexist.setTipo(recurso.getTipo());
            recursoexist.setCategoria(recurso.getCategoria());
            return recursoRepository.save(recursoexist);
        });
    }
    public Optional<Recurso> actualizarParcialmente(Long id, Recurso recurso){
        return recursoRepository.findById(id).map(recursoexist -> {
            if(recurso.getTitulo() != null)recursoexist.setTitulo(recurso.getTitulo());
            if(recurso.getUrl() != null)  recursoexist.setUrl(recurso.getUrl());
            if(recurso.getTipo() != null) recursoexist.setTipo(recurso.getTipo());
            if(recurso.getCategoria() != null) recursoexist.setCategoria(recurso.getCategoria());
            return recursoRepository.save(recursoexist);
        });
    }
    public boolean eliminarRecurso(Long id){
        return recursoRepository.deleteById(id);
    }
}
