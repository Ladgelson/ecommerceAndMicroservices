package com.ecommerce.produto.model;

import com.ecommerce.produto.model.enums.StatusPedido;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.Instant;
import java.util.Optional;
import java.util.Set;

class PedidoTest {

    private Pedido pedido;

    @BeforeEach
    void setUp() {
        pedido = createPedido();
    }

    @Test
    void setId() {
        Long idTest = 1L;
        pedido.setId(idTest);
        Assertions.assertEquals(Optional.of(idTest), Optional.ofNullable(pedido.getId()));
    }

    @Test
    void setData() {
        Instant dataTest = Instant.now();
        pedido.setData(dataTest);
        Assertions.assertEquals(Optional.of(dataTest), Optional.ofNullable(pedido.getData()));
    }

    @Test
    void setStatusPedido() {
        StatusPedido statusPedidoTest = StatusPedido.WAITING_PAYMANT;
        pedido.setStatusPedido(statusPedidoTest);
        Assertions.assertEquals(Optional.of(statusPedidoTest), Optional.ofNullable(pedido.getStatusPedido()));
    }

    @Test
    void setItems() {
        Set<ItemPedido> itemsTest = Set.of();
        pedido.setItems(itemsTest);
        Assertions.assertEquals(Optional.of(itemsTest), Optional.ofNullable(pedido.getItems()));
    }

    @Test
    void getId() {
        Assertions.assertNotNull(pedido.getId());
    }

    @Test
    void getData() {
        Assertions.assertNotNull(pedido.getData());
    }

    @Test
    void getStatusPedido() {
        Assertions.assertNotNull(pedido.getStatusPedido());
    }

    @Test
    void getItems() {
        Assertions.assertNotNull(pedido.getItems());
    }

    private Pedido createPedido() {
        Pedido pedido = new Pedido();
        pedido.setId(1L);
        pedido.setData(Instant.now());
        pedido.setStatusPedido(StatusPedido.WAITING_PAYMANT);
        pedido.setItems(Set.of());
        return pedido;
    }

}
