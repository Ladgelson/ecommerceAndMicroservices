package com.ecommerce.produto.service;

import com.ecommerce.produto.model.Categoria;
import com.ecommerce.produto.repository.CategoriaRepository;
import com.ecommerce.produto.service.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository repository;

    public Page<Categoria> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Categoria findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Categoria save(Categoria categoria) {
        return repository.save(categoria);
    }

    public Categoria update(Categoria categoria) {
        findById(categoria.getId());
        return repository.save(categoria);
    }

    public void delete(Long id) {
        repository.delete(findById(id));
    }

    public Page<Categoria> findCategoriaByProdutoId(Long id, Pageable pageable) {
        return repository.findCategoriasByProdutoId(id, pageable);
    }
}
