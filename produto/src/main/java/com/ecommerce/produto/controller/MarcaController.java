package com.ecommerce.produto.controller;

import com.ecommerce.produto.model.dto.out.MarcaDtoOut;
import com.ecommerce.produto.model.Marca;
import com.ecommerce.produto.service.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/marcas")
public class MarcaController {

    @Autowired
    private MarcaService service;

    @GetMapping
    public ResponseEntity<Page<MarcaDtoOut>> findAll(Pageable pageable) {
        Page<Marca> marcas = service.findAll(pageable);
        if(marcas.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(new PageImpl<>(marcas.stream().map(m -> new MarcaDtoOut(m)).collect(Collectors.toList())));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MarcaDtoOut> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(new MarcaDtoOut(service.findById(id)));
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody Marca marca) {
        Marca m = service.save(marca);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(m.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<MarcaDtoOut> update(@RequestBody Marca marca, @PathVariable Long id) {
        return ResponseEntity.accepted().body(new MarcaDtoOut(service.update(marca, id)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.accepted().build();
    }
}
