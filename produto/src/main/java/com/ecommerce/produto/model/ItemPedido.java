package com.ecommerce.produto.model;

import com.ecommerce.produto.model.pk.PedidoProdutoPK;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
@NoArgsConstructor
@Data
public class ItemPedido  {
    @EmbeddedId
    private PedidoProdutoPK id = new PedidoProdutoPK();

    private Integer quantidade;
    private BigDecimal preco;

    public ItemPedido(Pedido pedido, Produto produto, Integer quantidade, BigDecimal preco) {
        id.setPedido(pedido);
        id.setProduto(produto);
        this.quantidade = quantidade;
        this.preco = preco;
    }
}
