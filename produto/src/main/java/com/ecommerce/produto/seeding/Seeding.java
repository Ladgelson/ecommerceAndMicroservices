package com.ecommerce.produto.seeding;

import com.ecommerce.produto.model.enums.StatusPedido;
import com.ecommerce.produto.model.*;
import com.ecommerce.produto.repository.*;
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

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    @Override
    public void run(String... args) throws Exception {
//        produtoRepository.deleteAll();
//        categoriaRepository.deleteAll();
//        marcaRepository.deleteAll();
//        pedidoRepository.deleteAll();
//        itemPedidoRepository.deleteAll();
//
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
//        caderno.setQuantidadeEstoque(10);
//        Produto caneta = new Produto(null, "Caneta", new BigDecimal(1.50),  bic, "Azul");
//        caneta.setCreatedAt(Date.from(Instant.now()));
//        caneta.setQuantidadeEstoque(100);
//        Produto corretivo = new Produto(null, "Corretivo", new BigDecimal(2.70),  bic, "Verde");
//        corretivo.setCreatedAt(Date.from(Instant.now()));
//        corretivo.setQuantidadeEstoque(30);
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
//
//        Pedido pedido1 = new Pedido(null, Instant.now(), StatusPedido.WAITING_PAYMANT);
//
//        pedido1 = pedidoRepository.save(pedido1);
//
//        ItemPedido itemPedido1 = new ItemPedido(pedido1, caderno, 2, caderno.getPreco());
//
//        itemPedidoRepository.save(itemPedido1);

    }
}
