package com.dev.ecommerce.dto;

import com.dev.ecommerce.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel  = "spring")
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);
    ProductDto convertDto(Product product);
}
