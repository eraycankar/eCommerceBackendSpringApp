package com.dev.ecommerce.dto;

import com.dev.ecommerce.model.OrderDetail;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel  = "spring")
public interface OrderDetailMapper {

    OrderDetailMapper INSTANCE = Mappers.getMapper(OrderDetailMapper.class);
    OrderDetailDto convertOrderDetailDto(OrderDetail orderDetail);
    OrderDetail convertOrderDetail(OrderDetailDto orderDetailDto);
    List<OrderDetailDto> toListOrderDetailDto(List<OrderDetail> orderDetails);
}
