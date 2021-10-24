package com.ecommerce.produto.controller;

import com.ecommerce.produto.dto.out.CategoriaDtoOut;
import com.ecommerce.produto.mapper.CategoriaMapper;
import com.ecommerce.produto.model.Categoria;
import com.ecommerce.produto.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {
    @Autowired
    private CategoriaService service;

    @GetMapping
    public ResponseEntity<Page<Categoria>> findAll(Pageable pageable) {
        Page<Categoria> categorias = service.findAll(pageable);
        if(categorias.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(categorias);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody @Valid CategoriaDtoOut dto) {
        Categoria c = CategoriaMapper.INSTANCE.categoriaDtoToCategoria(dto);
        Categoria categoria = service.save(c);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(categoria.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Categoria> update(@PathVariable Long id, @RequestBody CategoriaDtoOut dto) {
        Categoria categoria = CategoriaMapper.INSTANCE.categoriaDtoToCategoria(dto);
        categoria.setId(id);
        return ResponseEntity.ok(service.update(categoria));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.accepted().build();
    }
}
