package com.ecommerce.produto.controller;

import com.ecommerce.produto.model.Marca;
import com.ecommerce.produto.model.dto.in.ProdutoDtoIn;
import com.ecommerce.produto.model.dto.out.ProdutoDtoOut;
import com.ecommerce.produto.util.ProdutoFactory;
import com.ecommerce.produto.model.Produto;
import com.ecommerce.produto.service.ProdutoService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@ExtendWith(SpringExtension.class)
class ProdutoControllerTest {
    @InjectMocks
    private ProdutoController controller;

    @Mock
    private ProdutoService serviceMocked;

    @BeforeEach
    void setup()  {

        Marca marca = new Marca(1L, "Tesla");

        Produto produto = new Produto(1L, "Caderno", new BigDecimal(25.99), marca, "Preto");

        BDDMockito.when(serviceMocked.findById(ArgumentMatchers.any()))
                .thenReturn(produto);

        BDDMockito.when(serviceMocked.save(ArgumentMatchers.any()))
                .thenReturn(produto);

    }

    @Test
    @DisplayName("findAll: retorna uma lista paginada quando existem produtos")
    void findAll_retornaListaPaginada_quandoExistemProdutos() {
        Marca marca = new Marca(1L, "Tesla");

        Produto produto = new Produto(1L, "Caderno", new BigDecimal(25.99), marca, "Preto");
        PageImpl<Produto> produtos =
                new PageImpl<>(Arrays.asList(produto));

        BDDMockito.when(serviceMocked.findAll(ArgumentMatchers.any(), ArgumentMatchers.any(),
                        ArgumentMatchers.any(), ArgumentMatchers.any()))
                .thenReturn(produtos);

        ResponseEntity<Page<ProdutoDtoOut>> retorno = controller.findAll(null, null, null, null);
        // garante o status code
        Assertions.assertThat(retorno.getStatusCode()).isEqualTo(HttpStatus.OK);

        Assertions.assertThat(retorno.getBody().toList())
                .isNotNull()
                .hasSize(1);
    }

    @Test
    @DisplayName("findAll: retorna 204 quando não existem produto")
    void findAll_retorna204_quandoNaoExistemProdutos() {
        BDDMockito.when(serviceMocked.findAll(ArgumentMatchers.any(), ArgumentMatchers.any(),
                        ArgumentMatchers.any(), ArgumentMatchers.any()))
                .thenReturn(new PageImpl<Produto>(Arrays.asList()));

        ResponseEntity<Page<ProdutoDtoOut>> retorno = controller.findAll(null, null, null, null);

        Assertions.assertThat(retorno.getStatusCode())
                .isEqualTo(HttpStatus.NO_CONTENT);
    }

    @Test
    @DisplayName("findAll: retorna lista de produtos filtrado pelo nome")
    void findAll_retornaListaDeProdutosFiltradosPorNome_QuandoSucesso() {
        BDDMockito.when(serviceMocked.findAll(ArgumentMatchers.any(), ArgumentMatchers.any(),
                        ArgumentMatchers.any(), ArgumentMatchers.any()))
                .thenReturn(new PageImpl<>(ProdutoFactory.criaListaValida()
                        .stream()
                        .filter(produto -> produto.getNome().equals("Caderno"))
                        .collect(Collectors.toList())));

        ResponseEntity<Page<ProdutoDtoOut>> retorno = controller.findAll(null, null, null, null);

        List<ProdutoDtoOut> produtosFiltrados = retorno.getBody().toList();

        Assertions.assertThat(produtosFiltrados)
                .hasSize(1);

        Assertions.assertThat(produtosFiltrados.get(0).getNome())
                .isEqualToIgnoringCase("caderno");
    }

    @Test
    @DisplayName("findAll: retorna lista de produtos filtrado com o valor maior que x")
    void findAll_retornaListaDeProdutosFiltradosPorValorMaiorQue_QuandoSucesso() {
        BDDMockito.when(serviceMocked.findAll(ArgumentMatchers.any(), ArgumentMatchers.any(),
                        ArgumentMatchers.any(), ArgumentMatchers.any()))
                .thenReturn(new PageImpl<>(ProdutoFactory.criaListaValida()
                        .stream()
                        .filter(produto -> produto.getPreco().compareTo(new BigDecimal(2)) > 0)
                        .collect(Collectors.toList())));

        ResponseEntity<Page<ProdutoDtoOut>> retorno = controller.findAll(null, null, null, null);

        List<ProdutoDtoOut> produtosFiltrados = retorno.getBody().toList();

        Assertions.assertThat(produtosFiltrados)
                .hasSize(2);
    }

    @Test
    @DisplayName("findAll: retorna lista de produtos filtrado com o valor menor que x")
    void findAll_retornaListaDeProdutosFiltradosPorValorMenorQue_QuandoSucesso() {
        BDDMockito.when(serviceMocked.findAll(ArgumentMatchers.any(), ArgumentMatchers.any(),
                        ArgumentMatchers.any(), ArgumentMatchers.any()))
                .thenReturn(new PageImpl<>(ProdutoFactory.criaListaValida()
                        .stream()
                        .filter(produto -> produto.getPreco().compareTo(new BigDecimal(2)) < 0)
                        .collect(Collectors.toList())));

        ResponseEntity<Page<ProdutoDtoOut>> retorno = controller.findAll(null, null, null, null);

        List<ProdutoDtoOut> produtosFiltrados = retorno.getBody().toList();

        Assertions.assertThat(produtosFiltrados)
                .hasSize(1);
    }

    @Test
    @DisplayName("findById: retorna produto buscando pelo ID")
    void findById_retornaProdutoBuscandoPeloId_QuandoSucesso() {
        ResponseEntity<Produto> retorno = controller.findById(null);

        Produto produto = retorno.getBody();

        Assertions.assertThat(produto).isNotNull();

        Assertions.assertThat(produto.getId())
                .isEqualTo(1L);
    }

    @Test
    void save() {
        ResponseEntity<Void> retorno = controller.save(null);

        Assertions.assertThat(retorno.getStatusCode())
                .isEqualTo(HttpStatus.CREATED);
    }

    @Test
    void updateProdutoSeForEncontrado() {
        Produto produtoEncontrado = serviceMocked.findById(null);
        Produto produtoAtualizado = serviceMocked.findById(null);
        produtoAtualizado.setNome("Sacola");

        BDDMockito.when(serviceMocked.update(ArgumentMatchers.any(), ArgumentMatchers.any()))
                        .thenReturn(produtoAtualizado);

        Produto p = serviceMocked.update(new ProdutoDtoIn(produtoEncontrado), 1L);

        Assertions.assertThat(p.getId())
                .isEqualTo(produtoEncontrado.getId());

        Assertions.assertThat(p.getNome())
                .isEqualTo("Sacola");
    }

    @Test
    void delete() {
    }

    @Test
    void associaCategoria() {
    }

    @Test
    void desassociaCategoria() {
    }

    @Test
    void findCategoriaByProduto() {
    }

    @Test
    void setaEstoque() {
    }
}
