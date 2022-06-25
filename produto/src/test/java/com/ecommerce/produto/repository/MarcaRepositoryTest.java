package com.ecommerce.produto.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class MarcaRepositoryTest {

    @Autowired
    private MarcaRepository marcaRepository;

    @BeforeEach
    void setUp() {
    }

    @Test
    void findAll() {

        assertNotNull(marcaRepository.findAll());
    }
}