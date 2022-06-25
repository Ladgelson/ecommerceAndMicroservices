package com.ecommerce.produto.service;

import com.ecommerce.produto.model.Marca;
import com.ecommerce.produto.repository.MarcaRepository;
import com.ecommerce.produto.util.MarcaFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class MarcaServiceTest {

    @InjectMocks
    private MarcaService marcaService;

    @Mock
    private MarcaRepository marcaRepository;

    private Marca marcaValida;

    private Marca marcaParaSerSalva;

    private Marca marcaAtualizada;

    @BeforeEach
    void setup() {
        marcaValida = MarcaFactory.retornaMarcaValida();
        marcaParaSerSalva = MarcaFactory.criaMarcaParaSalvar();
        marcaAtualizada = MarcaFactory.retornaMarcaValida();
        marcaAtualizada.setNome("Faber Castel");

        Page<Marca> marcasPaginadas = new PageImpl<>(MarcaFactory.criaListaValidaCom3Marcas());

        when(marcaRepository.findAll(ArgumentMatchers.any(Pageable.class)))
                .thenReturn(marcasPaginadas);

        when(marcaRepository.findById(marcaValida.getId()))
                .thenReturn(Optional.of(marcaValida));

        when(marcaRepository.save(marcaParaSerSalva))
                .thenReturn(marcaValida);

        doNothing().when(marcaRepository).delete(marcaValida);
    }

    @Test
    void findAll() {
        Pageable pageable = PageRequest.of(0, 8);
        assertEquals(new PageImpl<>(MarcaFactory.criaListaValidaCom3Marcas()), marcaService.findAll(pageable));
    }

    @Test
    void findById() {
        assertEquals(Optional.of(marcaValida).get(), marcaService.findById(marcaValida.getId()));
    }

    @Test
    void save() {
        assertEquals(marcaValida.getId(), marcaService.save(marcaParaSerSalva).getId());
        assertEquals(marcaValida.getNome(), marcaService.save(marcaParaSerSalva).getNome());
    }

    @Test
    void update() {
        when(marcaRepository.save(ArgumentMatchers.any()))
                .thenReturn(marcaAtualizada);
        assertEquals(marcaAtualizada.getNome(), marcaService.update(marcaAtualizada, marcaAtualizada.getId()).getNome());
    }

    @Test
    void delete() {
        assertDoesNotThrow(() -> marcaService.delete(marcaValida.getId()));
    }
}