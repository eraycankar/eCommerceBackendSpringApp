package com.dev.ecommerce.service;

import com.dev.ecommerce.dto.CreateOrderRequest;
import com.dev.ecommerce.dto.OrdersDto;
import com.dev.ecommerce.dto.OrdersMapper;
import com.dev.ecommerce.model.Customer;
import com.dev.ecommerce.model.Orders;
import com.dev.ecommerce.repository.OrdersRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class OrdersService {

    private final OrdersRepository ordersRepository;
    private final CustomerService customerService ;
    private final OrdersMapper ordersMapper;


    public OrdersService(OrdersRepository ordersRepository, CustomerService customerService, OrdersMapper ordersMapper) {
        this.ordersRepository = ordersRepository;
        this.customerService = customerService;
        this.ordersMapper = ordersMapper;
    }


   public OrdersDto createOrder(CreateOrderRequest createOrderRequest) {

        Customer customers = customerService.findCustomerById(createOrderRequest.getCustomerId());
        Orders orders = new Orders(createOrderRequest.getCustomerId(),LocalDateTime.now(),customers);

        return ordersMapper.convertDto(ordersRepository.save(orders));
    }

}
