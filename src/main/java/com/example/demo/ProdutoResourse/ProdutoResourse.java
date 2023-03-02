package com.example.demo.ProdutoResourse;

import com.example.demo.entidades.Produtos;
import com.example.demo.repositorio.ProdutosRepositorio;
import com.example.demo.service.ProdutosService;
import org.aspectj.weaver.ast.Var;
import org.hibernate.sql.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "api/produtos")//@RequestMapping(value = "api/produtos")
class ProdutoResourse {

    @Autowired
    private ProdutosService service;
    @Autowired
    private ProdutosRepositorio produtosRepositorio;


    @GetMapping                                     //responde a requisição do HTPP end poit
    public ResponseEntity<List<Produtos>> findAll() {
        List<Produtos> list = service.findAll();
//        return ResponseEntity.ok().body(list);
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);

    }

    @GetMapping(value = "produtos/{id}")
    public ResponseEntity<Produtos> findById(@PathVariable Long id) {
        Produtos obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping//inserir no banco de dados
    public ResponseEntity<Produtos> createProduct(@RequestBody Produtos obj) {
        obj = service.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }


//    @PutMapping(value = "produtos/{id}") // atualiza dados
//    public ResponseEntity<Produtos> UPDATE(@PathVariable Long id, @RequestBody Produtos obj) {
//        obj = service.update(id, obj);
//        return ResponseEntity.ok().body(obj);
//
//    }
//
//    @DeleteMapping(value = "produtos/{id}")//deleta dados
//    public ResponseEntity<Object> Delete(@PathVariable(value = "id") Long id) {
//        Optional<Produtos> produtos = produtosRepositorio.findById(id);
//
//        if (produtos.isPresent()) {
//            produtosRepositorio.delete(produtos.get());
//            return new ResponseEntity<>(id, HttpStatus.OK);
//        } else
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }


}





