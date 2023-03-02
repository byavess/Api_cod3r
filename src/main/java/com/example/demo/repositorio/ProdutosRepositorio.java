package com.example.demo.repositorio;

import com.example.demo.entidades.Produtos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Optional;


public interface ProdutosRepositorio extends JpaRepository<Produtos, Long> {



}
