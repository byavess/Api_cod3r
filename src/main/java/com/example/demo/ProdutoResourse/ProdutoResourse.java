package com.example.demo.ProdutoResourse;

import com.example.demo.entidades.Produtos;
import com.example.demo.service.ProdutosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/produtos")
class ProdutoResourse {

    @Autowired                           // o UserResourse depende do UserService
    private ProdutosService service;

    @GetMapping                                         //responde a requisição do HTPP end poit
    public ResponseEntity<List<Produtos>> findAll(){
        List<Produtos> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value =  "/{id}")
    public ResponseEntity<Produtos> findById(@PathVariable Long id){
        Produtos obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

}
