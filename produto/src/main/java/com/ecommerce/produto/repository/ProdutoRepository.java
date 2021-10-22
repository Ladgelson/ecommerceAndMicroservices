package com.ecommerce.produto.repository;

import com.ecommerce.produto.model.Produto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    Page<Produto> findByNomeIgnoreCase(Pageable pageable, String name);
    Page<Produto> findByPrecoLessThanEqual(Pageable pageable, BigDecimal preco);
    Page<Produto> findByPrecoGreaterThanEqual(Pageable pageable, BigDecimal preco);
    Page<Produto> findByNomeIgnoreCaseAndPrecoLessThanEqual(Pageable pageable, String nome, BigDecimal preco);
    Page<Produto> findByNomeIgnoreCaseAndPrecoGreaterThanEqual(Pageable pageable, String nome, BigDecimal preco);
}
