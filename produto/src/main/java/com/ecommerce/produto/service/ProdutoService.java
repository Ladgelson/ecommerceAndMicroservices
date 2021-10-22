package com.ecommerce.produto.service;

import com.ecommerce.produto.dto.ProdutoDto;
import com.ecommerce.produto.mapper.ProdutoMapper;
import com.ecommerce.produto.model.Produto;
import com.ecommerce.produto.repository.ProdutoRepository;
import com.ecommerce.produto.service.exception.ResourceNotFoundException;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    public Page<Produto> findAll(Pageable pageable, String nome, BigDecimal precoMaiorque, BigDecimal precoMenorque) {
        if(nome != null && precoMaiorque != null) {
            return repository.findByNomeIgnoreCaseAndPrecoGreaterThanEqual(pageable, nome, precoMaiorque);
        } else if(nome != null && precoMenorque != null) {
            return repository.findByNomeIgnoreCaseAndPrecoLessThanEqual(pageable, nome, precoMenorque);
        } else if(nome != null) {
            return repository.findByNomeIgnoreCase(pageable, nome);
        } else if(precoMaiorque != null) {
            return repository.findByPrecoGreaterThanEqual(pageable, precoMaiorque);
        } else if(precoMenorque != null) {
            return repository.findByPrecoLessThanEqual(pageable, precoMenorque);
        } else
            return repository.findAll(pageable);
    }

    public Produto findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Produto save(Produto produto) {
        return repository.save(produto);
    }

    public Produto update(Produto produto) {
        findById(produto.getId());
        return repository.save(produto);
    }

    public void delete(Long id) {
        repository.delete(findById(id));
    }
}
