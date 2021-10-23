package com.ecommerce.produto.service;

import com.ecommerce.produto.model.Categoria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CategoriaService {
    Page<Categoria> findAll(Pageable pageable);
    Categoria findById(Long id);
    Categoria save(Categoria categoria);
    Categoria update(Categoria categoria);
    void delete(Long id);
}
