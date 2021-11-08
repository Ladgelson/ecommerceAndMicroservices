package com.ecommerce.produto.service;

import com.ecommerce.produto.model.Marca;
import com.ecommerce.produto.repository.MarcaRepository;
import com.ecommerce.produto.service.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.Instant;

@Service
public class MarcaService {

    @Autowired
    private MarcaRepository repository;

    public Page<Marca> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Marca findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Marca save(Marca marca) {
        marca.setCreatedAt(Date.from(Instant.now()));
        return repository.save(marca);
    }

    public Marca update(Marca marca, Long id) {
        Marca foundMarca = findById(id);
        foundMarca.setNome(marca.getNome());
        foundMarca.setUpdatedAt(Date.from(Instant.now()));
        return repository.save(foundMarca);
    }

    public void delete(Long id) {
        Marca marca = findById(id);
        repository.delete(marca);
    }

}
