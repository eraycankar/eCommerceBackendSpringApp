package com.dev.ecommerce.controller;

import com.dev.ecommerce.dto.GetOrdersFromDateRange;
import com.dev.ecommerce.dto.OrdersDto;
import com.dev.ecommerce.dto.OrdersMapper;
import com.dev.ecommerce.model.Orders;
import com.dev.ecommerce.repository.CustomerRepository;
import com.dev.ecommerce.repository.OrdersRepository;
import com.dev.ecommerce.service.OrdersService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

import java.util.List;

@RestController
public class OrdersControler {

    private final OrdersService ordersService;
    private final OrdersMapper ordersMapper;

    public OrdersControler(OrdersService ordersService, OrdersMapper ordersMapper) {
        this.ordersService = ordersService;
        this.ordersMapper = ordersMapper;
    }

    @GetMapping("/api/orders")
    public List<OrdersDto> getOrders(){
        return ordersService.getAllOrders();
    }

    @GetMapping("/api/customers/{customerId}/orders")
    public List<OrdersDto> getOrdersByCustomerId(@PathVariable(value = "customerId")Long customerId){
        return ordersService.getOrdersById(customerId);
    }

    @GetMapping("api/orders/{from}/{to}")
    public List<GetOrdersFromDateRange> getOrdersFromDateRange(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate from, @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate to){
        return ordersService.getOrdersFromCreationDate(from, to);
    }

    @PostMapping("/api/customers/{customerId}/orders")
    public OrdersDto createOrder(@PathVariable(value = "customerId")Long customerId, @RequestBody Orders orderRequest){
        return  ordersService.createOrder(customerId,orderRequest);
    }
}
