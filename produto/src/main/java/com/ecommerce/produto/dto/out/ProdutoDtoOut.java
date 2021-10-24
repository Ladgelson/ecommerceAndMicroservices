package com.ecommerce.produto.dto.out;

import com.ecommerce.produto.model.Categoria;
import com.ecommerce.produto.model.Marca;
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
public class ProdutoDtoOut {
    private String nome;
    private BigDecimal preco;
    private String cor;
    private Marca marca;
    private Set<Categoria> categorias = new HashSet<>();
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date createdAt;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date updatedAt;
}