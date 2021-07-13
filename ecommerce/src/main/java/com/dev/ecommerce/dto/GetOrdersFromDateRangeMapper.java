package com.dev.ecommerce.dto;

import com.dev.ecommerce.model.Orders;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel  = "spring")
public interface GetOrdersFromDateRangeMapper {
    GetOrdersFromDateRangeMapper INSTANCE = Mappers.getMapper(GetOrdersFromDateRangeMapper.class);
    GetOrdersFromDateRange convertDto(Orders orders);
}
