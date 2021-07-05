package com.dev.ecommerce.controller;

import com.dev.ecommerce.dto.CreateOrderRequest;
import com.dev.ecommerce.dto.OrdersDto;
import com.dev.ecommerce.service.OrdersService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orders")
public class OrdersControler {

    private final OrdersService ordersService;

    public OrdersControler(OrdersService ordersService) {
        this.ordersService = ordersService;
    }

    @PostMapping
    public ResponseEntity<OrdersDto> createOrder(@RequestBody CreateOrderRequest request){
        return ResponseEntity.ok(ordersService.createOrder(request));
    }
}
