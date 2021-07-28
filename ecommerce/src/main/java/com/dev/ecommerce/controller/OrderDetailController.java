package com.dev.ecommerce.controller;

import com.dev.ecommerce.dto.AddProductToOrderDetailMapper;
import com.dev.ecommerce.dto.OrderDetailDto;
import com.dev.ecommerce.dto.OrderDetailMapper;
import com.dev.ecommerce.model.OrderDetail;
import com.dev.ecommerce.service.OrderDetailService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderDetailController {

    private final OrderDetailMapper orderDetailMapper;
    private final OrderDetailService orderDetailService;


    public OrderDetailController(OrderDetailMapper orderDetailMapper, OrderDetailService orderDetailService, AddProductToOrderDetailMapper addProductToOrderDetailMapper) {
        this.orderDetailMapper = orderDetailMapper;
        this.orderDetailService = orderDetailService;
    }

    @GetMapping("/api/orderDetails")
    public List<OrderDetailDto> getAllOrderDetails(){
        return orderDetailMapper.toListOrderDetailDto(orderDetailService.getAllOrderDetails());
    }

    @GetMapping("/api/orders/{ordersId}/orderDetails")
    public List<OrderDetailDto> getOrderDetailsByOrderId(@PathVariable(value = "ordersId")Long ordersId){
        return orderDetailMapper.toListOrderDetailDto(orderDetailService.getOrderDetailsById(ordersId));
    }

    @PostMapping("/api/orders/{ordersId}/orderDetails")
    public OrderDetailDto createOrderDetail(@PathVariable(value ="ordersId")Long ordersId, @RequestBody OrderDetail orderDetail){
        return  orderDetailMapper.convertOrderDetailDto(orderDetailService.createOrderDetail(ordersId, orderDetail));
    }

}
