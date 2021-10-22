package com.ecommerce.produto.controller;

import com.ecommerce.produto.dto.CategoriaDto;
import com.ecommerce.produto.model.Categoria;
import com.ecommerce.produto.model.Produto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {
    @GetMapping
    public ResponseEntity<Page<Categoria>> findAll(Pageable pageable) {
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> findById(@PathVariable Long id) {
        return null;
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody @Valid CategoriaDto dto) {
        return null;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Categoria> update(@PathVariable Long id, @RequestBody CategoriaDto dto) {
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return null;
    }
}
