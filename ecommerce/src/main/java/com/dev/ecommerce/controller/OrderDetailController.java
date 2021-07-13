package com.dev.ecommerce.controller;

import com.dev.ecommerce.dto.OrderDetailDto;
import com.dev.ecommerce.dto.OrderDetailMapper;
import com.dev.ecommerce.model.OrderDetail;
import com.dev.ecommerce.repository.OrderDetailRepository;
import com.dev.ecommerce.service.OrderDetailService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderDetailController {

    private final OrderDetailMapper orderDetailMapper;
    private final OrderDetailRepository orderDetailRepository;
    private final OrderDetailService orderDetailService;

    public OrderDetailController(OrderDetailMapper orderDetailMapper, OrderDetailRepository orderDetailRepository, OrderDetailService orderDetailService) {
        this.orderDetailMapper = orderDetailMapper;
        this.orderDetailRepository = orderDetailRepository;
        this.orderDetailService = orderDetailService;
    }

    @GetMapping("/api/orderDetails")
    public List<OrderDetailDto> getOrderDetails(){
        return orderDetailService.getAllOrderDetails();
    }
    @GetMapping("/api/orders/{ordersId}/orderDetails")
        public List<OrderDetail> getOrderDetailsByOrderId(@PathVariable(value = "ordersId")Long ordersId){
            return orderDetailRepository.findByOrdersId(ordersId);
        }

    @PostMapping("/api/orders/{ordersId}/orderDetails")
    public OrderDetailDto createOrderDetail(@PathVariable(value ="ordersId")Long ordersId, @RequestBody OrderDetail orderDetail){
        return  orderDetailService.createOrderDetail(ordersId,orderDetail);
    }
}
