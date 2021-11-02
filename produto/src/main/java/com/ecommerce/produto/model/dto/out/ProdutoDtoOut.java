package com.ecommerce.produto.model.dto.out;

import com.ecommerce.produto.model.Produto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoDtoOut {
    private Long id;
    private String nome;
    private BigDecimal preco;
    private String cor;
    private MarcaDtoOut marca;
    private List<CategoriaDtoOut> categorias = new ArrayList<>();

    public ProdutoDtoOut(Produto p) {
        this.id = p.getId();
        this.nome = p.getNome();
        this.preco = p.getPreco();
        this.cor = p.getCor();
        this.marca = new MarcaDtoOut(p.getMarca());
        this.categorias = p.getCategorias()
                .stream()
                .map(item -> new CategoriaDtoOut(item))
                .collect(Collectors.toList());
    }
}