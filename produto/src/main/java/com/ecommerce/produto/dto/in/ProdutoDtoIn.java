package com.ecommerce.produto.dto.in;

import com.ecommerce.produto.model.Categoria;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoDtoIn {
    private String nome;
    private BigDecimal preco;
    private String cor;
    private Long marcaId;
}