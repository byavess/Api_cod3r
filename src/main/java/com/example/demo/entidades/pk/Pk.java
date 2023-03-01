//package com.example.demo.entidades.pk;
//
//import com.example.demo.entidades.Produtos;
//import jakarta.persistence.Embeddable;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;
//
//import java.io.Serializable;
//import java.util.Objects;
//
//@Embeddable
//public class Pk implements Serializable {
//    private static final long serialVersionUID = 1L;
//    @ManyToOne
//    @JoinColumn(name = "produtos_id")
//    private Produtos produtos;
//
//    public Produtos getProdutos() {
//        return produtos;
//    }
//
//    public void setProdutos(Produtos produtos) {
//        this.produtos = produtos;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Pk pk = (Pk) o;
//        return Objects.equals(produtos, pk.produtos);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(produtos);
//    }
//}
