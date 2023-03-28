package com.example.demo.ProdutoResourse;

import com.example.demo.entidades.Produtos;
import com.example.demo.repositorio.ProdutosRepositorio;
import com.example.demo.service.ProdutosService;
import org.aspectj.weaver.ast.Var;
import org.hibernate.sql.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
@RequestMapping(value = "api/produtos")//@RequestMapping(value = "api/produtos")
public class ProdutoResourse {

    @Autowired
    private ProdutosService service;
    @Autowired
    private ProdutosRepositorio produtosRepositorio;


    @GetMapping                                     //responde a requisição do HTPP end poit
    public ResponseEntity<List<Produtos>> find(Produtos filtro) {
        ExampleMatcher matcher = ExampleMatcher // permite fazer algumas configurações pra encontrar clientes
                .matching()
                .withIgnoreCase()
                .withStringMatcher(
                        ExampleMatcher.StringMatcher.CONTAINING//aqui faz o filtro e retorna
                );

        Example example = Example.of(filtro, matcher); // pega o filtro pega o que ta poupulada e cria o example
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }
//        List<Produtos> list = service.findAll();
    //return ResponseEntity.ok().body(list);
//       return new ResponseEntity<>(service.findAll(), HttpStatus.OK);


    @GetMapping(value = "/{id}")
    public Produtos getById(@PathVariable Long id) {
        return produtosRepositorio.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não econtrado"));
//    public ResponseEntity<Produtos> findById(@PathVariable Long id) {
//        Produtos obj = service.findById(id);
//        return ResponseEntity.ok().body(obj);
    }

    @PostMapping//inserir no banco de dados
    @ResponseStatus(CREATED)
    public ResponseEntity<Produtos> createProduct(@RequestBody Produtos obj) {
        obj = service.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(new Produtos());
    }

    @PutMapping(value = "/{id}") // atualiza dados
    @ResponseStatus(NO_CONTENT)
    public ResponseEntity<Produtos> update(@PathVariable(value = "id") Long idProd, @RequestBody Produtos produtoId) throws ResponseStatusException{
        Produtos produtos =
                produtosRepositorio
                .findById(idProd)
                .map(p -> {
                    produtoId.setId(p.getId());
                    produtosRepositorio.save(produtoId);
                    return produtoId;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "produto não encontrado"));

        final Produtos update = produtosRepositorio.save(produtos);


        return ResponseEntity.ok(produtoId);
    }

    @DeleteMapping(value = "/{id}")//deleta dados
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Produtos> delete(@PathVariable Long id) {
        Optional<Produtos> produtos = produtosRepositorio.findById(id);

        if (produtos.isPresent()) {
            produtosRepositorio.delete(produtos.get());
            return new ResponseEntity<Produtos>(HttpStatus.OK);
        } else
            return new ResponseEntity<Produtos>(HttpStatus.NOT_FOUND);
    }


}




