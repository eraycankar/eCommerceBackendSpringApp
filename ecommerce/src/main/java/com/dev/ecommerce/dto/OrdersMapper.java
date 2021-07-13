package com.dev.ecommerce.dto;

import com.dev.ecommerce.model.Orders;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import java.util.List;

@Mapper(componentModel  = "spring")
public interface OrdersMapper {

    OrdersMapper INSTANCE = Mappers.getMapper(OrdersMapper.class);
    Orders convertOrders(OrdersDto ordersDto);
    List<OrdersDto> toListOrdersDto(List<Orders> orders);
    OrdersDto convertOrdersDto(Orders orders);
}
