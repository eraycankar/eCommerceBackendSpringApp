package com.dev.ecommerce.dto;

import com.dev.ecommerce.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel  = "spring")
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);
    ProductDto toProduct(Product product);
    Product toProductDto(ProductDto productDto);
    List<ProductDto> toListProductsDto(List<Product> products);
}
