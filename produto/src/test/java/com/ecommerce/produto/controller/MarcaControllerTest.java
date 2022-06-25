package com.ecommerce.produto.controller;

import com.ecommerce.produto.model.Marca;
import com.ecommerce.produto.service.MarcaService;
import com.ecommerce.produto.service.exception.ResourceNotFoundException;
import com.ecommerce.produto.util.MarcaFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.springframework.data.domain.PageImpl;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.hamcrest.Matchers.hasSize;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
class MarcaControllerTest {
    @MockBean
    private MarcaService marcaServiceMocked;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    private Marca marcaValida;

    private Marca marcaASerSalva;

    private Marca marcaAtualizada;

    @BeforeEach
    void setUp() {

        marcaValida = MarcaFactory.retornaMarcaValida();
        marcaASerSalva = MarcaFactory.criaMarcaParaSalvar();
        marcaAtualizada = MarcaFactory.retornaMarcaValida();
        marcaAtualizada.setNome("Faber Castel");

        when(marcaServiceMocked.findAll(ArgumentMatchers.any()))
                .thenReturn(new PageImpl<>(MarcaFactory.criaListaValidaCom3Marcas()));

        when(marcaServiceMocked.findById(1L))
                .thenReturn(marcaValida);

        when(marcaServiceMocked.findById(2L))
                .thenThrow(new ResourceNotFoundException(2L));

        when(marcaServiceMocked.save(marcaASerSalva))
                .thenReturn(marcaValida);

        when(marcaServiceMocked.update(marcaAtualizada, marcaAtualizada.getId()))
                .thenReturn(marcaAtualizada);

        doNothing().when(marcaServiceMocked)
                        .delete(marcaValida.getId());
    }

    @Test
    void findAll() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/marcas")
                .contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.content").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.content", hasSize(3)))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void findById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/marcas/{id}", 1)
                .contentType("application/json"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.nome").value("BIC"));
    }

    @Test
    @DisplayName("findById: retorna 404 not found quando id não é encontrado")
    void findByIdNotFound() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/marcas/{id}", 2)
                        .contentType("application/json"))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    void save() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/marcas")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(MarcaFactory.criaMarcaParaSalvar())))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    void update() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.put("/api/marcas/{id}",
                                marcaAtualizada.getId())
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(marcaAtualizada)))
                .andExpect(MockMvcResultMatchers.status().isAccepted());
    }

    @Test
    void delete() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/marcas/{id}",
                                marcaAtualizada.getId())
                        .contentType("application/json"))
                .andExpect(MockMvcResultMatchers.status().isAccepted());
    }
}