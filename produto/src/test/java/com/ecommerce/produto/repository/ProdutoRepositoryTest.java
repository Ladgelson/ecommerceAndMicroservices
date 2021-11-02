package com.ecommerce.produto.repository;

import com.ecommerce.produto.model.Produto;
import com.ecommerce.produto.util.ProdutoFactory;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

@DataJpaTest
@DisplayName("Testes do repository do produto")
class ProdutoRepositoryTest {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private MarcaRepository marcaRepository;

    @BeforeEach
    void setUp() {
    }

    @Test
    @DisplayName("save: persiste um produto quando sucesso")
    void save_persisteProduto_QuandoSucesso() {
        Produto produto = ProdutoFactory.criaProdutoParaSalvar();
        marcaRepository.save(produto.getMarca());

        Produto produtoSalvo = produtoRepository.save(produto);

        Assertions.assertThat(produtoSalvo)
                .isNotNull();

        Assertions.assertThat(produtoSalvo.getId())
                .isNotNull();

        Assertions.assertThat(produtoSalvo.getNome())
                .isEqualTo(produto.getNome());
    }

    @Test
    @DisplayName("findById: recupera um produto pelo id")
    void findById_recuperaProdutoPeloId_QuandoSucesso() {
        Produto produtoRecuperado = produtoRepository.getById(10L);

        Assertions.assertThat(produtoRecuperado)
                .isNotNull();

        Assertions.assertThat(produtoRecuperado.getId())
                .isEqualTo(10L);
    }

    @Test
    @DisplayName("save: atualiza um produto quando sucesso")
    void save_atualizaProduto_QuandoSucesso(){
        Produto produto = ProdutoFactory.criaProdutoParaSalvar();
        marcaRepository.save(produto.getMarca());

        produto = produtoRepository.save(produto);

        produto.setNome("Overflow");
        produto = produtoRepository.save(produto);

        Assertions.assertThat(produto)
                .isNotNull();

        Assertions.assertThat(produto.getNome())
                .isEqualTo("Overflow");
    }

    @Test
    @DisplayName("delete: deleta um produto quando sucesso")
    void delete_deletaProduto_QuandoSucesso(){
        Produto produto = ProdutoFactory.criaProdutoParaSalvar();
        marcaRepository.save(produto.getMarca());

        produto = produtoRepository.save(produto);

        produtoRepository.delete(produto);

        Optional<Produto> p = produtoRepository.findById(produto.getId());

        Assertions.assertThat(p.isEmpty()).isTrue();
    }
}