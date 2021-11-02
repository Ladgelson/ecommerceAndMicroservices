package com.ecommerce.produto.model;

import com.ecommerce.produto.model.enums.StatusPedido;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Instant data;
    private Integer statusPedido;

    @OneToMany(mappedBy = "id.pedido")
    private Set<ItemPedido> items = new HashSet<>();

    public Pedido(Long id, Instant data, StatusPedido statusPedido) {
        this.id = id;
        this.data = data;
        setStatusPedido(statusPedido);
    }

    public StatusPedido getStatusPedido() {
        return StatusPedido.valueOf(statusPedido);
    }

    public void setStatusPedido(StatusPedido statusPedido) {
        if(statusPedido != null) {
            this.statusPedido = statusPedido.getCode();
        }
    }

}
