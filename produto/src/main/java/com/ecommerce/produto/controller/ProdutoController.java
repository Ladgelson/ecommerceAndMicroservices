package com.ecommerce.produto.controller;

import com.ecommerce.produto.dto.in.ProdutoDtoIn;
import com.ecommerce.produto.dto.out.ProdutoDtoOut;
import com.ecommerce.produto.mapper.ProdutoMapper;
import com.ecommerce.produto.model.Categoria;
import com.ecommerce.produto.model.Produto;
import com.ecommerce.produto.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @GetMapping
    public ResponseEntity<Page<ProdutoDtoOut>> findAll(Pageable pageable,
                                                 @RequestParam(required = false) String nome,
                                                 @RequestParam(required = false) BigDecimal precoMaiorque,
                                                 @RequestParam(required = false) BigDecimal precoMenorque) {
        Page<Produto> produtos = service.findAll(pageable, nome, precoMaiorque, precoMenorque);
        if(produtos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(new PageImpl<>(produtos.stream().map(p -> new ProdutoDtoOut(p)).collect(Collectors.toList())));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody @Valid ProdutoDtoIn produtoDto) {
        Produto produto = service.save(produtoDto);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(produto.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> update(@PathVariable Long id, @RequestBody @Valid ProdutoDtoIn produtoDto) {
        return ResponseEntity.ok(service.update(produtoDto, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.accepted().build();
    }

    @PostMapping("/{produtoId}/categorias/{categoriaId}/associa")
    public ResponseEntity<Void> associaCategoria(@PathVariable Long produtoId, @PathVariable Long categoriaId) {
        service.associaProduto(produtoId, categoriaId);
        return ResponseEntity.accepted().build();
    }

    @PostMapping("/{produtoId}/categorias/{categoriaId}/desassocia")
    public ResponseEntity<Void> desassociaCategoria(@PathVariable Long produtoId, @PathVariable Long categoriaId) {
        service.desassociaProduto(produtoId, categoriaId);
        return ResponseEntity.accepted().build();
    }

    @GetMapping("/{produtoId}/categorias")
    public ResponseEntity<Page<Categoria>> findCategoriaByProduto(@PathVariable Long produtoId, Pageable pageable) {
        Page<Categoria> categorias = service.findCategoriasByProduto(produtoId, pageable);
        if(categorias.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(categorias);
    }

    @PostMapping("/{produtoId}/estoque/{quantidade}")
    public ResponseEntity<Void> setaEstoque(@PathVariable Long produtoId, @PathVariable Integer quantidade) {
        Produto p = service.findById(produtoId);
        p.setQuantidadeEstoque(quantidade);
        service.update(new ProdutoDtoIn(p), produtoId);
        return ResponseEntity.accepted().build();
    }
}
