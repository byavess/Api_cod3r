package com.example.demo.repositorio;

import com.example.demo.entidades.Produtos;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProdutosRepositorio extends JpaRepository<Produtos, Long> {



}
