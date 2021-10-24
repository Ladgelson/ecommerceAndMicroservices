package com.ecommerce.produto.repository;

import com.ecommerce.produto.model.Marca;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarcaRepository extends JpaRepository<Marca, Long> {
}
