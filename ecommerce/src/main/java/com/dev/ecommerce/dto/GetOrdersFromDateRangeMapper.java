package com.dev.ecommerce.dto;

import com.dev.ecommerce.model.Orders;
import org.hibernate.criterion.Order;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel  = "spring")
public interface GetOrdersFromDateRangeMapper {
    GetOrdersFromDateRangeMapper INSTANCE = Mappers.getMapper(GetOrdersFromDateRangeMapper.class);
    GetOrdersFromDateRange convertDto(Orders orders);
    List<GetOrdersFromDateRange> toListGetOrdersFromDateRange(List<Orders> orders);
    List<Orders> toListGetOrdersFromDateRange2(List<GetOrdersFromDateRange> orders);
}
