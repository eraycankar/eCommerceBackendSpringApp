package com.dev.ecommerce.service;

import com.dev.ecommerce.exception.OrderNotCreatedException;
import com.dev.ecommerce.exception.OrderNotFoundException;
import com.dev.ecommerce.model.Customer;
import com.dev.ecommerce.model.Orders;
import com.dev.ecommerce.repository.CustomerRepository;
import com.dev.ecommerce.repository.OrdersRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalLong;


class OrdersServiceTest {

    private OrdersService ordersService;
    private OrdersRepository ordersRepository;
    private CustomerRepository customerRepository;

    Customer customer = new Customer((long) 1, "ali","ali@gmail.com","23423432");
    Orders orders = new Orders((long)2,LocalDate.now(),customer);

    @BeforeEach
    public void setUp() {

        ordersRepository = Mockito.mock(OrdersRepository.class);
        customerRepository = Mockito.mock(CustomerRepository.class);
        ordersService = new OrdersService(ordersRepository,customerRepository);
    }

    @Test
    public void testGetOrdersById_whenOrderIdExists_shouldReturnOrder(){
        List<Orders> newOrders = new ArrayList<>();
        newOrders.add(orders);

        Mockito.when(ordersService.getOrdersById((long)2)).thenReturn(newOrders);

        List<Orders> result = ordersRepository.findByCustomerId((long) 2);

        Assertions.assertEquals(newOrders, result);
    }

    /*@Test
    public void testGetOrdersById_whenOrderIdNotExists_shouldReturnOrderNotFoundException(){
        Mockito.when(ordersRepository.findById((long)1)).thenReturn(Optional.empty());

        Assertions.assertThrows(OrderNotFoundException.class, () -> ordersService.getOrdersById((long)3));
    }*/

    @Test
    public void testGetAllOrders_shouldReturnListOfOrders(){
        List<Orders> newOrders = new ArrayList<>();

        Orders order1 = new Orders((long)2,LocalDate.now(),customer);
        Orders order2 = new Orders((long)3,LocalDate.now(),customer);
        Orders order3 = new Orders((long)4,LocalDate.now(),customer);

        newOrders.add(order1);
        newOrders.add(order2);
        newOrders.add(order3);

        Mockito.when(ordersService.getAllOrders()).thenReturn(newOrders);

        List<Orders> ordersList = ordersRepository.findAll();

        Assertions.assertEquals(ordersList, newOrders);
    }

    @Test
    public void testGetOrdersFromCreationDate_shouldReturnListOfOrders(){
        LocalDate firstDate = LocalDate.of(2021, 7, 20);
        LocalDate lastDate = LocalDate.of(2021, 7, 23);
        LocalDate orderDate = LocalDate.of(2021, 7, 21);

        List<Orders> newOrders = new ArrayList<>();

        Orders order1 = new Orders((long)2,firstDate,customer);
        Orders order2 = new Orders((long)3,lastDate,customer);
        Orders order3 = new Orders((long)4,orderDate,customer);

        newOrders.add(order1);
        newOrders.add(order2);
        newOrders.add(order3);

        Mockito.when(ordersService.getOrdersFromCreationDate(firstDate,lastDate)).thenReturn(newOrders);

        List<Orders> ordersList = ordersRepository.findByCreationDateBetween(firstDate,lastDate);

        Assertions.assertEquals(ordersList, newOrders);
    }

    @Test
    public void testCreateOrder_whenCreateOrderCalledWithValidRequest_itShouldReturnValidOrder(){
        Mockito.when(customerRepository.findById((long)1)).thenReturn(Optional.of(customer));
        Mockito.when(ordersRepository.save(orders)).thenReturn(orders);

        Orders result = ordersService.createOrder((long)1,orders);

        Assertions.assertEquals(result,orders);
    }

    @Test
    public void testCreateOrder_whenCreateOrderCalledWithValidRequest_itShouldReturnOrderNotCreatedException(){
        Mockito.when(customerRepository.findById((long)1)).thenReturn(Optional.empty());

        Assertions.assertThrows(OrderNotCreatedException.class, () -> ordersService.createOrder((long)2,orders));
    }



}