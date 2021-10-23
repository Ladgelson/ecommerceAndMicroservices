package com.ecommerce.produto.mapper;

import com.ecommerce.produto.dto.CategoriaDto;
import com.ecommerce.produto.model.Categoria;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CategoriaMapper {
    CategoriaMapper INSTANCE = Mappers.getMapper(CategoriaMapper.class);

    Categoria categoriaDtoToCategoria(CategoriaDto dto);
}
