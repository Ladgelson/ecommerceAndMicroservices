package com.ecommerce.produto.model.dto.in;

import com.ecommerce.produto.model.Produto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoDtoIn {
    private String nome;
    private BigDecimal preco;
    private String cor;
    private Long marcaId;
    private Integer quantidadeEstoque;

    public ProdutoDtoIn(Produto produto) {
        this.nome = produto.getNome();
        this.preco = produto.getPreco();
        this.cor = produto.getCor();
        this.marcaId = produto.getMarca().getId();
        this.quantidadeEstoque = produto.getQuantidadeEstoque();
    }
}