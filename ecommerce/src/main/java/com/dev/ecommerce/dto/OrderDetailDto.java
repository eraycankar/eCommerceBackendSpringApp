package com.dev.ecommerce.dto;

import java.util.Objects;

public class OrderDetailDto {
    Long id;
    OrdersDto orders;
    ProductDto product;

    public OrderDetailDto() {
    }

    public OrderDetailDto(Long id, OrdersDto orders, ProductDto product) {
        this.id = id;
        this.orders = orders;
        this.product = product;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OrdersDto getOrders() {
        return orders;
    }

    public void setOrders(OrdersDto orders) {
        this.orders = orders;
    }

    public ProductDto getProduct() {
        return product;
    }

    public void setProduct(ProductDto product) {
        this.product = product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDetailDto that = (OrderDetailDto) o;
        return Objects.equals(id, that.id) && Objects.equals(orders, that.orders) && Objects.equals(product, that.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, orders, product);
    }
}
