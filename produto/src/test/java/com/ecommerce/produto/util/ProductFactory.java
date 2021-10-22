package com.ecommerce.produto.util;

import com.ecommerce.produto.model.Produto;
import org.springframework.data.domain.PageImpl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductFactory {
    public static List<Produto> criaListaValida() {
        List<Produto> produtos =
                new ArrayList<>(Arrays.asList(
                        new Produto(1L, "Caderno", new BigDecimal(25.99)),
                        new Produto(2L, "Caneta", new BigDecimal(1.50)),
                        new Produto(3L, "Corretivo", new BigDecimal(2.70))));
        return produtos;
    }
}
