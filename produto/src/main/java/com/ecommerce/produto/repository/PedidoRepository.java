package com.ecommerce.produto.repository;

import com.ecommerce.produto.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
