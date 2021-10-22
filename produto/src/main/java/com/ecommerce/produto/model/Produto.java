package com.ecommerce.produto.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Nome não pode ser nulo")
    @NotEmpty(message = "Nome não pode ser vazio")
    private String nome;

    @NotNull(message = "Preco não pode ser nulo")
    private BigDecimal preco;

//    @OneToMany(mappedBy = "produto")
//    Set<Categoria> categoria;
}
