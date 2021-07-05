package com.dev.ecommerce.dto;

import com.dev.ecommerce.model.OrderDetail;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel  = "spring")
public interface OrderDetailMapper {

    OrderDetailMapper INSTANCE = Mappers.getMapper(OrderDetailMapper.class);
    OrderDetailDto convertDto(OrderDetail orderDetail);
}
