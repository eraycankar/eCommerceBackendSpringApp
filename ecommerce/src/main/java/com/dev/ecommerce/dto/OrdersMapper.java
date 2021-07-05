package com.dev.ecommerce.dto;

import com.dev.ecommerce.model.Orders;


import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper(componentModel  = "spring")
public interface OrdersMapper {

    OrdersMapper INSTANCE = Mappers.getMapper(OrdersMapper.class);

    @InheritInverseConfiguration
    OrdersDto convertDto(Orders orders);
}
