package com.dev.ecommerce.service;

import com.dev.ecommerce.dto.*;
import com.dev.ecommerce.exception.OrderNotCreatedException;
import com.dev.ecommerce.model.Orders;
import com.dev.ecommerce.repository.CustomerRepository;
import com.dev.ecommerce.repository.OrdersRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class OrdersService {

    private final OrdersRepository ordersRepository;
    private final CustomerRepository customerRepository;
    private final OrdersMapper ordersMapper;


    public OrdersService(OrdersRepository ordersRepository, OrdersMapper ordersMapper, CustomerRepository customerRepository) {
        this.ordersRepository = ordersRepository;
        this.ordersMapper = ordersMapper;
        this.customerRepository = customerRepository;
    }

    public List<OrdersDto> getAllOrders(){return ordersMapper.toListOrdersDto(ordersRepository.findAll());}

    public OrdersDto createOrder(Long id, Orders orders){

        orders.setCreationDate(LocalDate.now());

        return  ordersMapper.convertOrdersDto(customerRepository.findById(id).map(customer -> {
            orders.setCustomer(customer);
            return ordersRepository.save(orders);
        }).orElseThrow( () -> new OrderNotCreatedException("Order could not be created")));
    }
}
