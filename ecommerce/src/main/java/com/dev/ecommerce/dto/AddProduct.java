package com.dev.ecommerce.dto;

public class AddProduct {
    Long id;

    public AddProduct() {
    }

    public AddProduct(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
