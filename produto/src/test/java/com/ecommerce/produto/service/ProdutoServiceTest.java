package com.ecommerce.produto.service;

import com.ecommerce.produto.model.Categoria;
import com.ecommerce.produto.model.Marca;
import com.ecommerce.produto.model.Produto;
import com.ecommerce.produto.model.dto.in.ProdutoDtoIn;
import com.ecommerce.produto.repository.ProdutoRepository;
import com.ecommerce.produto.util.ProdutoFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.springframework.data.domain.PageImpl;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
class ProdutoServiceTest {

    @InjectMocks
    private ProdutoService produtoService;

    @Mock
    private ProdutoRepository produtoRepositoryMocked;

    @Mock
    private MarcaService marcaServiceMock;

    @Mock
    private CategoriaService categoriaServiceMock;

    private Produto produtoMock;

    private Marca marcaMock;

    private Categoria categoriaMock;

    @BeforeEach
    void setUp() {
       produtoMock = ProdutoFactory.retornaProdutoValido();
       Optional<Produto> p = Optional.of(produtoMock);

       marcaMock = new Marca(1L, "Renaut");

       categoriaMock = new Categoria(1L, "Automotivo");

       // ProdutoRepository Mock
       when(produtoRepositoryMocked.findById(produtoMock.getId()))
               .thenReturn(p);

       when(produtoRepositoryMocked.save(ArgumentMatchers.any()))
               .thenReturn(produtoMock);

       doNothing().when(produtoRepositoryMocked)
                       .delete(produtoMock);

       // MarcaService mock
       when(marcaServiceMock.findById(ArgumentMatchers.anyLong()))
               .thenReturn(marcaMock);

       // CategoriaService mock
       when(categoriaServiceMock.findById(ArgumentMatchers.anyLong()))
               .thenReturn(categoriaMock);

       when(categoriaServiceMock.findCategoriaByProdutoId(ArgumentMatchers.anyLong(), ArgumentMatchers.any()))
               .thenReturn(new PageImpl<>(List.of(categoriaMock)));
    }

    @Test
    void findById() {
        assertEquals(produtoService.findById(1L).getId(), produtoMock.getId());
    }

    @Test
    void save() {
        assertEquals(produtoService.save(new ProdutoDtoIn(produtoMock)).getId(), produtoMock.getId());
    }

    @Test
    void update() {
        assertEquals(produtoService.update(new ProdutoDtoIn(produtoMock), marcaMock.getId()).getId(), produtoMock.getId());
    }

    @Test
    void delete() {
        assertDoesNotThrow(() -> produtoService.delete(produtoMock.getId()));
    }

    @Test
    void associaCategoria() {
        when(produtoRepositoryMocked.save(ArgumentMatchers.any()))
                .thenReturn(produtoMock);
        assertEquals(produtoService.associaCategoria(produtoMock.getId(), categoriaMock.getId()).getCategorias().get(0), produtoMock.getCategorias().get(0));
    }

    @Test
    void desassociaCategoria() {
        when(produtoRepositoryMocked.save(ArgumentMatchers.any()))
                .thenReturn(produtoMock);
        assertEquals(produtoService.desassociaCategoria(produtoMock.getId(), categoriaMock.getId()), produtoMock);
    }

    @Test
    void findCategoriasByProduto() {
        produtoMock.getCategorias().add(categoriaMock);
        assertEquals(produtoService.findCategoriasByProduto(produtoMock.getId(), null), new PageImpl<>(produtoMock.getCategorias()));
    }

    @Test
    void setaEstoque() {
        produtoMock.setQuantidadeEstoque(10);
        assertEquals(produtoService.setaEstoque(produtoMock.getId(), 10).getQuantidadeEstoque(), produtoMock.getQuantidadeEstoque());
    }
}