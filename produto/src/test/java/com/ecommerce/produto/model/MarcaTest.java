package com.ecommerce.produto.model;

import com.ecommerce.produto.model.Produto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;
import java.util.Optional;

class MarcaTest {

    private Marca marca;

    @BeforeEach
    void setUp() {
        marca = createMarca();
    }

    @Test
    void setId() {
        Long idTest = 1L;
        marca.setId(idTest);
        Assertions.assertEquals(Optional.of(idTest), Optional.ofNullable(marca.getId()));
    }

    @Test
    void setNome() {
        String nomeTest = "test";
        marca.setNome(nomeTest);
        Assertions.assertEquals(Optional.of(nomeTest), Optional.ofNullable(marca.getNome()));
    }

    @Test
    void setProdutos() {
        List<Produto> produtosTest = List.of();
        marca.setProdutos(produtosTest);
        Assertions.assertEquals(Optional.of(produtosTest), Optional.ofNullable(marca.getProdutos()));
    }

    @Test
    void setCreatedAt() {
        Date createdAtTest = new Date();
        marca.setCreatedAt(createdAtTest);
        Assertions.assertEquals(Optional.of(createdAtTest), Optional.ofNullable(marca.getCreatedAt()));
    }

    @Test
    void setUpdatedAt() {
        Date updatedAtTest = new Date();
        marca.setUpdatedAt(updatedAtTest);
        Assertions.assertEquals(Optional.of(updatedAtTest), Optional.ofNullable(marca.getUpdatedAt()));
    }

    @Test
    void getId() {
        Assertions.assertNotNull(marca.getId());
    }

    @Test
    void getNome() {
        Assertions.assertNotNull(marca.getNome());
    }

    @Test
    void getProdutos() {
        Assertions.assertNotNull(marca.getProdutos());
    }

    @Test
    void getCreatedAt() {
        Assertions.assertNotNull(marca.getCreatedAt());
    }

    @Test
    void getUpdatedAt() {
        Assertions.assertNotNull(marca.getUpdatedAt());
    }

    private Marca createMarca() {
        Marca marca = new Marca();
        marca.setId(1L);
        marca.setNome("test");
        marca.setProdutos(List.of());
        marca.setCreatedAt(new Date());
        marca.setUpdatedAt(new Date());
        return marca;
    }

}
