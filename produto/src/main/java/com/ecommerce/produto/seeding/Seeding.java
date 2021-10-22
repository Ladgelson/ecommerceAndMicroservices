package com.ecommerce.produto.seeding;

import com.ecommerce.produto.model.Produto;
import com.ecommerce.produto.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.util.Arrays;

@Configuration
public class Seeding implements CommandLineRunner {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Override
    public void run(String... args) throws Exception {
        produtoRepository.deleteAll();

        Produto caderno = new Produto(null, "Caderno", new BigDecimal(25.99));
        Produto caneta = new Produto(null, "Caneta", new BigDecimal(1.50));
        Produto corretivo = new Produto(null, "Corretivo", new BigDecimal(2.70));

        produtoRepository.saveAll(Arrays.asList(caderno, caneta, corretivo));
    }
}
