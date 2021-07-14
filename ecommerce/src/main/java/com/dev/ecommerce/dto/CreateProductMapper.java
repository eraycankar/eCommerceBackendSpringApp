package com.dev.ecommerce.dto;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CreateProductMapper {
    CreateProductMapper INSTANCE = Mappers.getMapper(CreateProductMapper.class);
    CreateProductDto toCreateProductDto (ProductDto productDto);
    ProductDto toProductDto (CreateProductDto createProductDto);
}
