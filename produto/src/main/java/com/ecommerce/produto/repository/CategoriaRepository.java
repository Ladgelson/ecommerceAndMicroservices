package com.ecommerce.produto.repository;

import com.ecommerce.produto.model.Categoria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    @Query("SELECT DISTINCT c FROM Categoria c JOIN c.produtos p WHERE p.id = :id")
    public Page<Categoria> findCategoriasByProdutoId(@PathVariable Long id, Pageable pageable);
}
