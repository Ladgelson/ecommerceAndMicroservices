package com.ecommerce.produto.model;

import com.ecommerce.produto.model.Produto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;
import java.util.Optional;

class CategoriaTest {

    private Categoria categoria;

    @BeforeEach
    void setUp() {
        categoria = createCategoria();
    }

    @Test
    void setId() {
        Long idTest = 1L;
        categoria.setId(idTest);
        Assertions.assertEquals(Optional.of(idTest), Optional.ofNullable(categoria.getId()));
    }

    @Test
    void setNome() {
        String nomeTest = "test";
        categoria.setNome(nomeTest);
        Assertions.assertEquals(Optional.of(nomeTest), Optional.ofNullable(categoria.getNome()));
    }

    @Test
    void setProdutos() {
        List<Produto> produtosTest = List.of();
        categoria.setProdutos(produtosTest);
        Assertions.assertEquals(Optional.of(produtosTest), Optional.ofNullable(categoria.getProdutos()));
    }

    @Test
    void setCreatedAt() {
        Date createdAtTest = new Date();
        categoria.setCreatedAt(createdAtTest);
        Assertions.assertEquals(Optional.of(createdAtTest), Optional.ofNullable(categoria.getCreatedAt()));
    }

    @Test
    void setUpdatedAt() {
        Date updatedAtTest = new Date();
        categoria.setUpdatedAt(updatedAtTest);
        Assertions.assertEquals(Optional.of(updatedAtTest), Optional.ofNullable(categoria.getUpdatedAt()));
    }

    @Test
    void getId() {
        Assertions.assertNotNull(categoria.getId());
    }

    @Test
    void getNome() {
        Assertions.assertNotNull(categoria.getNome());
    }

    @Test
    void getProdutos() {
        Assertions.assertNotNull(categoria.getProdutos());
    }

    @Test
    void getCreatedAt() {
        Assertions.assertNotNull(categoria.getCreatedAt());
    }

    @Test
    void getUpdatedAt() {
        Assertions.assertNotNull(categoria.getUpdatedAt());
    }

    private Categoria createCategoria() {
        Categoria categoria = new Categoria();
        categoria.setId(1L);
        categoria.setNome("test");
        categoria.setProdutos(List.of());
        categoria.setCreatedAt(new Date());
        categoria.setUpdatedAt(new Date());
        return categoria;
    }

}
