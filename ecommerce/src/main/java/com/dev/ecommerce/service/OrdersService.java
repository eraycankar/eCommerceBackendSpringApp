package com.dev.ecommerce.service;

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



    public OrdersService(OrdersRepository ordersRepository, CustomerRepository customerRepository) {
        this.ordersRepository = ordersRepository;
        this.customerRepository = customerRepository;
    }

    public List<Orders> getAllOrders(){return ordersRepository.findAll();}

    public List<Orders> getOrdersById(Long id){return ordersRepository.findByCustomerId(id);}

    public List<Orders> getOrdersFromCreationDate(LocalDate from, LocalDate to){
        return ordersRepository.findByCreationDateBetween(from,to);
    }

    public Orders createOrder(Long id, Orders orders){

        orders.setCreationDate(LocalDate.now());

        return customerRepository.findById(id).map(customer -> {
            orders.setCustomer(customer);
            return ordersRepository.save(orders);
        }).orElseThrow( () -> new OrderNotCreatedException("Order could not be created"));
    }
}
