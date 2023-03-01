package com.example.demo.ProdutoResourse;

import com.example.demo.entidades.Produtos;
import com.example.demo.service.ProdutosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "api/produtos")
class ProdutoResourse {

    @Autowired
    private ProdutosService service;

    @GetMapping                                       //responde a requisição do HTPP end poit
    public ResponseEntity<List<Produtos>>findAll(){
        List<Produtos> list = service.findAll();
//        return ResponseEntity.ok().body(list);
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);

    }

    @GetMapping(value = "produtos/{id}")
    public ResponseEntity<Produtos> findAll(@PathVariable Long id){
        Produtos obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

}
