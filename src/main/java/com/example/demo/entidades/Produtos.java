package com.example.demo.entidades;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_Produtos")
public class Produtos implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id         //PK primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "preco")
    private Double preco;


    public Produtos() {
    }

    public Produtos(Integer id, String name, Double preco) {
        this.id = id;
        this.name = name;
        this.preco = preco;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Produtos produtos)) return false;
        return Objects.equals(getId(), produtos.getId()) && Objects.equals(getName(), produtos.getName()) && Objects.equals(getPreco(), produtos.getPreco());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getPreco());
    }
}
