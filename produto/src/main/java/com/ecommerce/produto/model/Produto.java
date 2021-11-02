package com.ecommerce.produto.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.*;

@Entity
@Data
@NoArgsConstructor
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Nome não pode ser nulo")
    @NotEmpty(message = "Nome não pode ser vazio")
    private String nome;

    @NotNull(message = "Preco não pode ser nulo")
    private BigDecimal preco;

    @NotNull(message = "Cor não pode ser nula")
    private String cor;

    @ManyToOne
    @JoinColumn(name="marca_id", nullable=false)
    private Marca marca;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date createdAt;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date updatedAt;

    private Integer quantidadeEstoque;

    @ManyToMany
    @JoinTable(
            name = "produto_categoria",
            joinColumns = @JoinColumn(name = "produto_id"),
            inverseJoinColumns = @JoinColumn(name = "categoria_id")
    )
    private List<Categoria> categorias = new ArrayList<>();

    @OneToMany(mappedBy = "id.produto")
    private Set<ItemPedido> items = new HashSet<>();

    public Produto(Long id, String nome, BigDecimal preco, Marca marca, String cor) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.marca = marca;
        this.cor = cor;
    }
}
