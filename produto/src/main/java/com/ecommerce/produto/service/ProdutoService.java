package com.ecommerce.produto.service;

import com.ecommerce.produto.model.dto.in.ProdutoDtoIn;
import com.ecommerce.produto.model.Categoria;
import com.ecommerce.produto.model.Marca;
import com.ecommerce.produto.model.Produto;
import com.ecommerce.produto.repository.ProdutoRepository;
import com.ecommerce.produto.service.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import javax.persistence.criteria.Predicate;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.Date;
import java.util.Objects;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    @Autowired
    private MarcaService marcaService;

    @Autowired
    private CategoriaService categoriaService;

    public Page<Produto> findAll(Pageable pageable, String nome, BigDecimal precoMaiorque, BigDecimal precoMenorque) {
        return repository.findAll((Specification<Produto>) (root, query, criteriaBuilder) -> {
            Predicate p = criteriaBuilder.conjunction();
            if(nome != null) {
                p = criteriaBuilder.and(p, criteriaBuilder.like(root.get("nome"), "%"+nome+"%"));
            }
            if(Objects.nonNull(precoMaiorque)) {
                p = criteriaBuilder.and(p, criteriaBuilder.greaterThanOrEqualTo(root.get("preco"), precoMaiorque));
            }
            if(Objects.nonNull(precoMenorque)) {
                p = criteriaBuilder.and(p, criteriaBuilder.lessThanOrEqualTo(root.get("preco"), precoMenorque));
            }
            return p;
        }, pageable);
    }

    public Produto findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Produto save(ProdutoDtoIn produtoDtoIn) {
        Marca marca = marcaService.findById(produtoDtoIn.getMarcaId());
        Produto produto = new Produto(null, produtoDtoIn.getNome(), produtoDtoIn.getPreco(), marca, produtoDtoIn.getCor());
        produto.setCreatedAt(Date.from(Instant.now()));
        return repository.save(produto);
    }

    public Produto update(ProdutoDtoIn produto, Long id) {
        Marca marca = marcaService.findById(produto.getMarcaId());
        Produto p = findById(id);
        p.setNome(produto.getNome());
        p.setCor(produto.getCor());
        p.setMarca(marca);
        p.setQuantidadeEstoque(produto.getQuantidadeEstoque());
        p.setUpdatedAt(Date.from(Instant.now()));
        return repository.save(p);
    }

    public void delete(Long id) {
        repository.delete(findById(id));
    }

    public Produto associaCategoria(Long produtoId, Long categoriaId) {
        Produto produto = findById(produtoId);
        Categoria categoria = categoriaService.findById(categoriaId);
        produto.getCategorias().add(categoria);
        produto.setUpdatedAt(Date.from(Instant.now()));
        return repository.save(produto);
    }

    public Produto desassociaCategoria(Long produtoId, Long categoriaId) {
        Produto produto = findById(produtoId);
        Categoria categoria = categoriaService.findById(categoriaId);
        produto.getCategorias().remove(categoria);
        produto.setUpdatedAt(Date.from(Instant.now()));
        return repository.save(produto);
    }

    public Page<Categoria> findCategoriasByProduto(Long produtoId, Pageable pageable) {
        return categoriaService.findCategoriaByProdutoId(produtoId, pageable);
    }

    public Produto setaEstoque(Long produtoId, Integer estoque) {
        Produto produto = findById(produtoId);
        produto.setQuantidadeEstoque(estoque);
        produto.setUpdatedAt(Date.from(Instant.now()));
        return repository.save(produto);
    }
}
