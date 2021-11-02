package com.ecommerce.produto.model.dto.out;

import com.ecommerce.produto.model.Marca;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MarcaDtoOut {
    private Long id;
    private String nome;

    public MarcaDtoOut(Marca marca) {
        this.id = marca.getId();
        this.nome = marca.getNome();
    }
}
