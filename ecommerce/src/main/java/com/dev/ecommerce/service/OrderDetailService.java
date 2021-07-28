package com.dev.ecommerce.service;

import com.dev.ecommerce.exception.OrderDetailNotCreatedException;
import com.dev.ecommerce.exception.ProductNotFoundException;
import com.dev.ecommerce.model.OrderDetail;
import com.dev.ecommerce.repository.OrderDetailRepository;
import com.dev.ecommerce.repository.OrdersRepository;
import com.dev.ecommerce.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailService {

    private final OrderDetailRepository orderDetailRepository;
    private final OrdersRepository ordersRepository;
    private final ProductRepository productRepository;



    public OrderDetailService(OrderDetailRepository orderDetailRepository, OrdersRepository ordersRepository, ProductRepository productRepository) {
        this.orderDetailRepository = orderDetailRepository;
        this.ordersRepository = ordersRepository;
        this.productRepository = productRepository;
    }

    public List<OrderDetail> getAllOrderDetails(){return orderDetailRepository.findAll();}

    public List<OrderDetail> getOrderDetailsById(Long id){return orderDetailRepository.findByOrdersId(id);}

    public OrderDetail createOrderDetail(Long id, OrderDetail orderDetail){
        return ordersRepository.findById(id).map(orders -> {
            productRepository.findById(orderDetail.getProduct().getId()).orElseThrow( () -> new ProductNotFoundException("Product couldn't find by id"));
                orderDetail.setOrders(orders);

            return orderDetailRepository.save(orderDetail);
        }).orElseThrow( () -> new OrderDetailNotCreatedException("OrderDetail could not be created"));
    }

}
