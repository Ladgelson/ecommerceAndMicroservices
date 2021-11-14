package com.ecommerce.produto.model;

import com.ecommerce.produto.model.Categoria;
import com.ecommerce.produto.model.ItemPedido;
import com.ecommerce.produto.model.Marca;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

class ProdutoTest {

    private Produto produto;

    @BeforeEach
    void setUp() {
        produto = createProduto();
    }

    @Test
    void setId() {
        Long idTest = 1L;
        produto.setId(idTest);
        Assertions.assertEquals(Optional.of(idTest), Optional.ofNullable(produto.getId()));
    }

    @Test
    void setNome() {
        String nomeTest = "test";
        produto.setNome(nomeTest);
        Assertions.assertEquals(Optional.of(nomeTest), Optional.ofNullable(produto.getNome()));
    }

    @Test
    void setPreco() {
        BigDecimal precoTest = new BigDecimal(1);
        produto.setPreco(precoTest);
        Assertions.assertEquals(Optional.of(precoTest), Optional.ofNullable(produto.getPreco()));
    }

    @Test
    void setCor() {
        String corTest = "test";
        produto.setCor(corTest);
        Assertions.assertEquals(Optional.of(corTest), Optional.ofNullable(produto.getCor()));
    }

    @Test
    void setMarca() {
        Marca marcaTest = new Marca();
        produto.setMarca(marcaTest);
        Assertions.assertEquals(Optional.of(marcaTest), Optional.ofNullable(produto.getMarca()));
    }

    @Test
    void setCreatedAt() {
        Date createdAtTest = new Date();
        produto.setCreatedAt(createdAtTest);
        Assertions.assertEquals(Optional.of(createdAtTest), Optional.ofNullable(produto.getCreatedAt()));
    }

    @Test
    void setUpdatedAt() {
        Date updatedAtTest = new Date();
        produto.setUpdatedAt(updatedAtTest);
        Assertions.assertEquals(Optional.of(updatedAtTest), Optional.ofNullable(produto.getUpdatedAt()));
    }

    @Test
    void setQuantidadeEstoque() {
        Integer quantidadeEstoqueTest = 1;
        produto.setQuantidadeEstoque(quantidadeEstoqueTest);
        Assertions.assertEquals(Optional.of(quantidadeEstoqueTest), Optional.ofNullable(produto.getQuantidadeEstoque()));
    }

    @Test
    void setCategorias() {
        List<Categoria> categoriasTest = List.of();
        produto.setCategorias(categoriasTest);
        Assertions.assertEquals(Optional.of(categoriasTest), Optional.ofNullable(produto.getCategorias()));
    }

    @Test
    void setItems() {
        Set<ItemPedido> itemsTest = Set.of();
        produto.setItems(itemsTest);
        Assertions.assertEquals(Optional.of(itemsTest), Optional.ofNullable(produto.getItems()));
    }

    @Test
    void getId() {
        Assertions.assertNotNull(produto.getId());
    }

    @Test
    void getNome() {
        Assertions.assertNotNull(produto.getNome());
    }

    @Test
    void getPreco() {
        Assertions.assertNotNull(produto.getPreco());
    }

    @Test
    void getCor() {
        Assertions.assertNotNull(produto.getCor());
    }

    @Test
    void getMarca() {
        Assertions.assertNotNull(produto.getMarca());
    }

    @Test
    void getCreatedAt() {
        Assertions.assertNotNull(produto.getCreatedAt());
    }

    @Test
    void getUpdatedAt() {
        Assertions.assertNotNull(produto.getUpdatedAt());
    }

    @Test
    void getQuantidadeEstoque() {
        Assertions.assertNotNull(produto.getQuantidadeEstoque());
    }

    @Test
    void getCategorias() {
        Assertions.assertNotNull(produto.getCategorias());
    }

    @Test
    void getItems() {
        Assertions.assertNotNull(produto.getItems());
    }

    private Produto createProduto() {
        Produto produto = new Produto();
        produto.setId(1L);
        produto.setNome("test");
        produto.setPreco(new BigDecimal(1));
        produto.setCor("test");
        produto.setMarca(new Marca());
        produto.setCreatedAt(new Date());
        produto.setUpdatedAt(new Date());
        produto.setQuantidadeEstoque(1);
        produto.setCategorias(List.of());
        produto.setItems(Set.of());
        return produto;
    }

}
