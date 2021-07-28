package com.dev.ecommerce.dto;

import com.dev.ecommerce.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AddProductMapper {

    AddProductMapper INSTANCE = Mappers.getMapper(AddProductMapper.class);
    AddProduct convertProductDto(ProductDto productDto);
    AddProduct convertProduct(Product product);

}
