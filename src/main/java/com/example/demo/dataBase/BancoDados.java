package com.example.demo.dataBase;

import com.example.demo.entidades.Produtos;
import com.example.demo.repositorio.ProdutosRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Arrays;
import java.util.List;


@Configuration
@Profile("test")
public class BancoDados implements CommandLineRunner {
    @Autowired
    private ProdutosRepositorio produtosRepositorio;

    @Override
    public void run(String... args) throws Exception {

        Produtos celular = new Produtos(1 , "Samsung", 1.600);

        Produtos carros = new Produtos(2 , "Palio", 51.800);
        Produtos eletrodomesticos = new Produtos(3 , "Geladeira", 11.300);


        produtosRepositorio.saveAll(Arrays.asList(celular, carros, eletrodomesticos));
    }
 }
