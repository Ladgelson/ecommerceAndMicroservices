package com.ecommerce.produto.model.dto.out;

import com.ecommerce.produto.model.Categoria;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoriaDtoOut {
    private Long id;
    private String nome;

    public CategoriaDtoOut(Categoria categoria) {
        this.id = categoria.getId();
        this.nome = categoria.getNome();
    }
}