package com.dev.ecommerce.dto;

import java.time.LocalDate;
import java.util.Objects;

public class OrdersDto {

    Long id;
    LocalDate creationDate;
    CustomerDto customer;

    public OrdersDto() {
    }

    public OrdersDto(Long id, LocalDate creationDate, CustomerDto customer) {
        this.id = id;
        this.creationDate = creationDate;
        this.customer = customer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public CustomerDto getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDto customer) {
        this.customer = customer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrdersDto ordersDto = (OrdersDto) o;
        return Objects.equals(id, ordersDto.id) && Objects.equals(creationDate, ordersDto.creationDate) && Objects.equals(customer, ordersDto.customer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, creationDate, customer);
    }
}
