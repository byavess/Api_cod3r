package com.example.demo.service;

import com.example.demo.entidades.Produtos;
import com.example.demo.exception.DatabaseException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repositorio.ProdutosRepositorio;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutosService {

    @Autowired
    private ProdutosRepositorio repositorio;

    public List<Produtos>findAll() {
        return repositorio.findAll();
    }

    public Produtos findById(Long id) {
        Optional<Produtos> obj = repositorio.findById(id);     return obj.get();

//        return obj.orElseThrow(() ->   new ResourceNotFoundException(id)); //get ou error
    }
    public Produtos create(Produtos obj){

        return repositorio.save(obj);

    }
    public Produtos update(Long id, Produtos obj) {
        try {
            Produtos entity = repositorio.getReferenceById(id);
            updateData(entity, obj);
            return repositorio.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }

    }
    private void updateData(Produtos entity, Produtos obj) {

        entity.setId(obj.getId());
        entity.setName(obj.getName());
        entity.setPrice(obj.getPrice());


    }
    public void delete(Long id, Produtos obj){
        try {
            repositorio.deleteById(id);
        }catch (EmptyResultDataAccessException e){
            throw  new ResourceNotFoundException(id);
        }catch (DataIntegrityViolationException e){
            throw  new DatabaseException(e.getMessage());
        }
    }



}
