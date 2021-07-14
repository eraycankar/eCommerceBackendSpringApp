package com.dev.ecommerce.service;

import com.dev.ecommerce.dto.OrderDetailDto;
import com.dev.ecommerce.dto.OrderDetailMapper;
import com.dev.ecommerce.exception.OrderDetailNotCreatedException;
import com.dev.ecommerce.model.OrderDetail;
import com.dev.ecommerce.repository.OrderDetailRepository;
import com.dev.ecommerce.repository.OrdersRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailService {

    private final OrderDetailRepository orderDetailRepository;
    private final OrdersRepository ordersRepository;
    private final OrderDetailMapper orderDetailMapper;


    public OrderDetailService(OrderDetailRepository orderDetailRepository, OrdersRepository ordersRepository, OrderDetailMapper orderDetailMapper) {
        this.orderDetailRepository = orderDetailRepository;
        this.ordersRepository = ordersRepository;
        this.orderDetailMapper = orderDetailMapper;
    }

    public List<OrderDetailDto> getAllOrderDetails(){return  orderDetailMapper.toListOrderDetailDto(orderDetailRepository.findAll());}

    public List<OrderDetailDto> getOrderDetailsById(Long id){return orderDetailMapper.toListOrderDetailDto(orderDetailRepository.findByOrdersId(id));}

    public OrderDetailDto createOrderDetail(Long id, OrderDetail orderDetail){
        return orderDetailMapper.convertOrderDetailDto(ordersRepository.findById(id).map(orders -> {
            orderDetail.setOrders(orders);
            return orderDetailRepository.save(orderDetail);
        }).orElseThrow( () -> new OrderDetailNotCreatedException("OrderDetail could not be created")));
    }
}
