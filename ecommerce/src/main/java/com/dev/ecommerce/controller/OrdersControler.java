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
    private final OrdersRepository ordersRepository;
    private final CustomerRepository customerRepository;
    private final OrdersMapper ordersMapper;

    public OrdersControler(OrdersService ordersService, OrdersRepository ordersRepository, CustomerRepository customerRepository, OrdersMapper ordersMapper) {
        this.ordersService = ordersService;
        this.ordersRepository = ordersRepository;
        this.customerRepository = customerRepository;
        this.ordersMapper = ordersMapper;
    }

   /* @PostMapping
    public ResponseEntity<OrdersDto> createOrder(@RequestBody OrdersDto ordersDto){
        ordersService.createOrder(ordersDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(ordersDto);
    }*/
    @GetMapping("/api/orders")
    public List<OrdersDto> getOrders(){
        return ordersService.getAllOrders();
    }

    @GetMapping("/api/customers/{customerId}/orders")
    public List<Orders> getOrdersByCustomerId(@PathVariable(value = "customerId")Long customerId){
        return ordersRepository.findByCustomerId(customerId);
    }

    @GetMapping("api/orders/{from}/{to}")
    public List<GetOrdersFromDateRange> getOrdersFromDateRange(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate from, @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate to){
        return ordersRepository.findByCreationDateBetween(from,to);
    }

    @PostMapping("/api/customers/{customerId}/orders")
    public OrdersDto createOrder(@PathVariable(value = "customerId")Long customerId, @RequestBody Orders orderRequest){
        return  ordersService.createOrder(customerId,orderRequest);
    }
}
