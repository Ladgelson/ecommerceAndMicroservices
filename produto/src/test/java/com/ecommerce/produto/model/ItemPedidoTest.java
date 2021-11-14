package com.ecommerce.produto.model;

import com.ecommerce.produto.model.enums.StatusPedido;
import com.ecommerce.produto.model.pk.PedidoProdutoPK;
import com.ecommerce.produto.util.ProdutoFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Optional;

class ItemPedidoTest {

    private ItemPedido itemPedido;

    @BeforeEach
    void setUp() {
        itemPedido = createItemPedido();
    }

    @Test
    void setId() {
        Pedido pedido = new Pedido(1L, Instant.now(), StatusPedido.WAITING_PAYMANT);
        Produto produto = ProdutoFactory.retornaProdutoValido();
        PedidoProdutoPK idTest = new PedidoProdutoPK(pedido, produto);
        itemPedido = new ItemPedido(pedido, produto, 10, new BigDecimal("10.35"));
        Assertions.assertEquals(Optional.of(idTest), Optional.ofNullable(itemPedido.getId()));
    }

    @Test
    void setQuantidade() {
        Integer quantidadeTest = 1;
        itemPedido.setQuantidade(quantidadeTest);
        Assertions.assertEquals(Optional.of(quantidadeTest), Optional.ofNullable(itemPedido.getQuantidade()));
    }

    @Test
    void setPreco() {
        BigDecimal precoTest = new BigDecimal(1);
        itemPedido.setPreco(precoTest);
        Assertions.assertEquals(Optional.of(precoTest), Optional.ofNullable(itemPedido.getPreco()));
    }

    @Test
    void getId() {
        Assertions.assertNotNull(itemPedido.getId());
    }

    @Test
    void getQuantidade() {
        Assertions.assertNotNull(itemPedido.getQuantidade());
    }

    @Test
    void getPreco() {
        Assertions.assertNotNull(itemPedido.getPreco());
    }

    private ItemPedido createItemPedido() {
        ItemPedido itemPedido = new ItemPedido();
        itemPedido.setId(new PedidoProdutoPK());
        itemPedido.setQuantidade(1);
        itemPedido.setPreco(new BigDecimal("1"));
        return itemPedido;
    }

}
