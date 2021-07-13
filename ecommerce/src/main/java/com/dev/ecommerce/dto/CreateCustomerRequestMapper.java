package com.dev.ecommerce.dto;

import com.dev.ecommerce.model.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CreateCustomerRequestMapper {

    CreateCustomerRequestMapper INSTANCE = Mappers.getMapper(CreateCustomerRequestMapper.class);
    CreateCustomerRequest convertToCreateCustomerRequest (Customer customer);
    Customer convertToCustomer (CreateCustomerRequest createCustomerRequest);
}
