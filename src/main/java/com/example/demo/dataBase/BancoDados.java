package com.example.demo.dataBase;

import com.example.demo.entidades.Produtos;
import com.example.demo.repositorio.ProdutosRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;


@Configuration
@Profile("test")
public class BancoDados implements CommandLineRunner {
    Locale localeBR = new Locale("pt","BR");
    @Autowired
    private ProdutosRepositorio produtosRepositorio;

    @Override
    public void run(String... args) throws Exception {
        NumberFormat price = new DecimalFormat("#0.000");

        Produtos celular = new Produtos(null , "Samsung", 1.600);
        Produtos carros = new Produtos(null , "Palio", 518.00);
        Produtos eletrodomesticos = new Produtos(3 , "Geladeira", 11.300);


        produtosRepositorio.saveAll(Arrays.asList(celular, carros, eletrodomesticos));
    }
 }
