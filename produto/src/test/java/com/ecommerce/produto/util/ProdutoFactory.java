package com.ecommerce.produto.util;

import com.ecommerce.produto.model.Marca;
import com.ecommerce.produto.model.Produto;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class ProdutoFactory {
    public static List<Produto> criaListaValida() {
        Marca bic = new Marca(null, "BIC");
        bic.setCreatedAt(Date.from(Instant.now()));
        List<Produto> produtos =
                new ArrayList<>(Arrays.asList(
                        new Produto(null, "Caderno", new BigDecimal(25.99), bic, "Azul"),
                        new Produto(null, "Caneta", new BigDecimal(25.99), bic, "Azul"),
                        new Produto(null, "Corretivo", new BigDecimal(0.99), bic, "Verde")));
        return produtos;
    }

    public static Produto criaProdutoParaSalvar() {
        Marca bic = new Marca(null, "BIC");
        bic.setCreatedAt(Date.from(Instant.now()));
        Produto produto = new Produto(null, "Caderno", new BigDecimal(25.99), bic, "Azul");
        return produto;
    }

    public static Produto retornaProdutoValido() {
        Marca bic = new Marca(1L, "BIC");
        bic.setCreatedAt(Date.from(Instant.now()));
        return new Produto(1L, "Caderno", new BigDecimal(25.99), bic, "Azul");
    }
}
