package com.dev.ecommerce.dto;

import com.dev.ecommerce.model.Customer;
import com.dev.ecommerce.model.OrderDetail;
import com.dev.ecommerce.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AddProductToOrderDetailMapper {
    AddProductToOrderDetailMapper INSTANCE = Mappers.getMapper(AddProductToOrderDetailMapper.class);
    AddProductToOrderDetail convertToAddProduct (OrderDetail orderDetail);
}
