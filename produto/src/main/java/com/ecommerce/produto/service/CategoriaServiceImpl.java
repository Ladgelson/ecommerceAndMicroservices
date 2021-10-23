package com.ecommerce.produto.service;

import com.ecommerce.produto.model.Categoria;
import com.ecommerce.produto.repository.CategoriaRepository;
import com.ecommerce.produto.service.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CategoriaServiceImpl implements CategoriaService{
    @Autowired
    private CategoriaRepository repository;

    @Override
    public Page<Categoria> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Categoria findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));
    }

    @Override
    public Categoria save(Categoria categoria) {
        return repository.save(categoria);
    }

    @Override
    public Categoria update(Categoria categoria) {
        findById(categoria.getId());
        return repository.save(categoria);
    }

    @Override
    public void delete(Long id) {
        repository.delete(findById(id));
    }
}
