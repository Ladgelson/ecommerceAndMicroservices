package com.ecommerce.produto.util;

import com.ecommerce.produto.model.Marca;
import com.ecommerce.produto.model.Produto;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class MarcaFactory {
    public static List<Marca> criaListaValidaCom3Marcas() {
        List<Marca> marcas =
                new ArrayList<>(Arrays.asList(
                        new Marca(1L, "FIAT"),
                        new Marca(2L, "Mercedes"),
                        new Marca(3L, "Toyota")));
        return marcas;
    }

    public static Marca criaMarcaParaSalvar() {
        return new Marca(null, "BIC");
    }

    public static Marca retornaMarcaValida() {
        return new Marca(1L, "BIC");
    }
}
