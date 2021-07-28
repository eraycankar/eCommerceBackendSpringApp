package com.dev.ecommerce.service;

import com.dev.ecommerce.model.Customer;
import com.dev.ecommerce.model.OrderDetail;
import com.dev.ecommerce.model.Orders;
import com.dev.ecommerce.model.Product;
import com.dev.ecommerce.repository.OrderDetailRepository;
import com.dev.ecommerce.repository.OrdersRepository;
import com.dev.ecommerce.repository.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class OrderDetailServiceTest {

    private OrderDetailService orderDetailService;
    private OrderDetailRepository orderDetailRepository;
    private OrdersRepository ordersRepository;
    private ProductRepository productRepository;

    Customer customer = new Customer((long) 1, "ali","ali@gmail.com","23423432");
    Orders orders = new Orders((long)1, LocalDate.now(),customer);
    Product product = new Product((long)1,"Orange",5.5);
    Product product2 = new Product((long)2,"Banana",12.0);
    OrderDetail orderDetail = new OrderDetail((long)1, orders, product);

    @BeforeEach
    public void setUp() {
        orderDetailRepository = Mockito.mock(OrderDetailRepository.class);
        ordersRepository = Mockito.mock(OrdersRepository.class);
        productRepository = Mockito.mock(ProductRepository.class);
        orderDetailService = new OrderDetailService(orderDetailRepository, ordersRepository, productRepository);
    }

    @Test
    public void testGetAllOrders_shouldReturnListOfOrderDetails(){
        List<OrderDetail> newOrderDetails = new ArrayList<>();

        OrderDetail orderDetail1 = new OrderDetail((long)1, orders, product);
        OrderDetail orderDetail2 = new OrderDetail((long)2, orders, product2);
        OrderDetail orderDetail3 = new OrderDetail((long)3, orders, product);

        newOrderDetails.add(orderDetail1);
        newOrderDetails.add(orderDetail2);
        newOrderDetails.add(orderDetail3);

        Mockito.when(orderDetailService.getAllOrderDetails()).thenReturn(newOrderDetails);

        List<OrderDetail> orderDetailList = orderDetailRepository.findAll();

        Assertions.assertEquals(orderDetailList,newOrderDetails);
    }

    @Test
    public void testGetOrderDetailsById_whenGetOrderDetailCalledWithExistId_shouldReturnListOfOrderDetail(){
        List<OrderDetail> newOrderDetails = new ArrayList<>();
        OrderDetail orderDetail1 = new OrderDetail((long)1, orders, product);
        newOrderDetails.add(orderDetail1);

        Mockito.when(orderDetailRepository.findByOrdersId((long)1)).thenReturn(newOrderDetails);

        List<OrderDetail> result = orderDetailService.getOrderDetailsById((long)1);

        Assertions.assertEquals(newOrderDetails, result);
    }

    @Test
    public void testCreateOrderDetail_whenCreateOrderDetailCalledWithValidRequest_itShouldReturnValidOrderDetail(){
        Mockito.when(ordersRepository.findById((long)1)).thenReturn(Optional.of(orders));
        Mockito.when(productRepository.findById((long)1)).thenReturn(Optional.of(product));
        Mockito.when(orderDetailRepository.save(orderDetail)).thenReturn(orderDetail);

        OrderDetail result = orderDetailService.createOrderDetail((long)1, orderDetail);

        Assertions.assertEquals(orderDetail, result);
    }
}