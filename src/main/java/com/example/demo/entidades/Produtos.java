package com.example.demo.entidades;



import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.springframework.format.annotation.NumberFormat;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


@Entity
@Table(name = "produtos")
public class Produtos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id         //PK primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Double price;

    @Column(name = "action")
    private String action;

    public Produtos() {
    }

    public Produtos(Integer id, String name, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
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

      public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }


    @Override
    public int hashCode() {
//        return Objects.hash(getId(), getName(), getPreco());
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;

    }
    @Override
    public boolean equals(Object obj) {
//        if (this == o) return true;
//        if (!(o instanceof Produtos produtos)) return false;
//        return Objects.equals(getId(), produtos.getId()) && Objects.equals(getName(), produtos.getName()) && Objects.equals(getPreco(), produtos.getPreco());
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Produtos other = (Produtos) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }


}
