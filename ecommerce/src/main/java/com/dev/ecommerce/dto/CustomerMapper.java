package com.dev.ecommerce.dto;

import com.dev.ecommerce.model.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel  = "spring")
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);
    CustomerDto convertDto(Customer customer);

}
