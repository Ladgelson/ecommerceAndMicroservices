package com.ecommerce.produto.controller;

import com.ecommerce.produto.dto.ProdutoDto;
import com.ecommerce.produto.mapper.ProdutoMapper;
import com.ecommerce.produto.model.Produto;
import com.ecommerce.produto.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.net.URI;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @GetMapping
    public ResponseEntity<Page<Produto>> findAll(Pageable pageable,
                                                 @RequestParam(required = false) String nome,
                                                 @RequestParam(required = false) BigDecimal precoMaiorque,
                                                 @RequestParam(required = false) BigDecimal precoMenorque) {
        Page<Produto> produtos = service.findAll(pageable, nome, precoMaiorque, precoMenorque);
        if(produtos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(produtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody @Valid ProdutoDto produtoDto) {
        Produto produto = service.save(ProdutoMapper.INSTANCE.produtoDtoToProduto(produtoDto));
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(produto.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> update(@PathVariable Long id, @RequestBody @Valid ProdutoDto produtoDto) {
        Produto produto = ProdutoMapper.INSTANCE.produtoDtoToProduto(produtoDto);
        produto.setId(id);
        return ResponseEntity.ok(service.update(produto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.accepted().build();
    }
}
