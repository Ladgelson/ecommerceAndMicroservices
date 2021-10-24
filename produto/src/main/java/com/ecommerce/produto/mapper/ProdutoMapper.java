package com.ecommerce.produto.mapper;

import com.ecommerce.produto.dto.in.ProdutoDtoIn;
import com.ecommerce.produto.dto.out.ProdutoDtoOut;
import com.ecommerce.produto.model.Produto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProdutoMapper {
    ProdutoMapper INSTANCE = Mappers.getMapper(ProdutoMapper.class);

    Produto produtoDtoOutToProduto(ProdutoDtoOut dto);
}
