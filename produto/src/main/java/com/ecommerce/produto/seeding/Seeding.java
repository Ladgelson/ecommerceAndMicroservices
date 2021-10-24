package com.ecommerce.produto.seeding;

import com.ecommerce.produto.model.Categoria;
import com.ecommerce.produto.model.Marca;
import com.ecommerce.produto.model.Produto;
import com.ecommerce.produto.repository.CategoriaRepository;
import com.ecommerce.produto.repository.MarcaRepository;
import com.ecommerce.produto.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Arrays;
import java.util.Date;

@Configuration
public class Seeding implements CommandLineRunner {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private MarcaRepository marcaRepository;

    @Override
    public void run(String... args) throws Exception {
//        produtoRepository.deleteAll();
//        categoriaRepository.deleteAll();
//        marcaRepository.deleteAll();
//        // marcas
//        Marca bic = new Marca(null, "BIC");
//        bic.setCreatedAt(Date.from(Instant.now()));
//
//        Marca amanco = new Marca(null, "Amanco");
//        amanco.setCreatedAt(Date.from(Instant.now()));
//
//        marcaRepository.saveAll(Arrays.asList(bic, amanco));
//
//        // produtos
//        Produto caderno = new Produto(null, "Caderno", new BigDecimal(25.99), bic, "Azul");
//        caderno.setCreatedAt(Date.from(Instant.now()));
//        Produto caneta = new Produto(null, "Caneta", new BigDecimal(1.50),  bic, "Azul");
//        caneta.setCreatedAt(Date.from(Instant.now()));
//        Produto corretivo = new Produto(null, "Corretivo", new BigDecimal(2.70),  bic, "Verde");
//        corretivo.setCreatedAt(Date.from(Instant.now()));
//
//        Produto pa = new Produto(null, "Pá", new BigDecimal(60.99), bic, "Marron");
//        pa.setCreatedAt(Date.from(Instant.now()));
//        Produto colher = new Produto(null, "Colher de pedreiro", new BigDecimal(49.99), bic, "Cinza");
//        colher.setCreatedAt(Date.from(Instant.now()));
//
//        produtoRepository.saveAll(Arrays.asList(caderno, caneta, corretivo, pa, colher));
//
//        // categorias
//        Categoria escolar = new Categoria(null, "Escolar");
//        escolar.setCreatedAt(Date.from(Instant.now()));
//        Categoria construcao = new Categoria(null, "Construcao");
//        construcao.setCreatedAt(Date.from(Instant.now()));
//
//        categoriaRepository.saveAll(Arrays.asList(escolar, construcao));
//
//        // associa escolar
//        caderno.getCategorias().add(escolar);
//        caneta.getCategorias().add(escolar);
//        corretivo.getCategorias().add(escolar);
//
//        // associa construção
//        pa.getCategorias().add(construcao);
//        colher.getCategorias().add(construcao);
//
//        produtoRepository.saveAll(Arrays.asList(caderno, caneta, corretivo, pa, colher));

    }
}
