package com.example.demo.service;

import com.example.demo.entidades.Produtos;
import com.example.demo.repositorio.ProdutosRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
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
        Optional<Produtos> obj = repositorio.findById(id);
        return obj.get();
    }
}
