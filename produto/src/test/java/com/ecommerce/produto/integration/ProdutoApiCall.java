package com.ecommerce.produto.integration;

import com.ecommerce.produto.model.Produto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "http://localhost:8080/api/produtos", name = "produto")
public interface ProdutoApiCall {
    @GetMapping("/{id}")
    Produto getProduto(@PathVariable Long id);
}
