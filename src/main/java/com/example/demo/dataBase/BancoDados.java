package com.example.demo.dataBase;

import com.example.demo.entidades.Produtos;
import com.example.demo.repositorio.ProdutosRepositorio;
import com.example.demo.service.ProdutosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;


@Configuration
public class BancoDados implements CommandLineRunner {

    @Autowired
    private ProdutosRepositorio produtosRepositorio;
    @Autowired
    private ProdutosService produtosService;

    @Override
    public void run(String... args) throws Exception {


        Produtos celular = new Produtos(null , "Samsung", 1.600);
        Produtos carros = new Produtos(null , "Palio", 518.00);
        Produtos eletrodomesticos = new Produtos(null , "eletrodomesticos", 11.300);
        Produtos caneta = new Produtos(null , "caneta", 1.600);
        Produtos algodao = new Produtos(null , "algodao", 518.00);
        Produtos roupa = new Produtos(null , "roupa", 11.300);
        Produtos moto = new Produtos(null , "moto", 1.600);
        Produtos bike = new Produtos(null , "bike", 518.00);
        Produtos panela = new Produtos(null , "panela", 11.300);
        Produtos sofa = new Produtos(null , "sofa", 1.600);
        Produtos geladeira = new Produtos(null , "geladeira", 518.00);
        Produtos cachorro = new Produtos(null , "cachorro", 11.300);




        produtosRepositorio.saveAll(Arrays.asList(celular, carros, eletrodomesticos,caneta,algodao,roupa, moto,bike,panela,sofa, geladeira, cachorro));
    produtosRepositorio.getById(produtosRepositorio.count());


    }
 }
