package com.ecommerce.produto.service;

import com.ecommerce.produto.model.Marca;
import com.ecommerce.produto.model.Produto;
import com.ecommerce.produto.repository.MarcaRepository;
import com.ecommerce.produto.service.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MarcaService {

    @Autowired
    private MarcaRepository repository;

    public Marca findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
    }

}
