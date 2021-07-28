package com.dev.ecommerce.dto;

public class AddProductToOrderDetail {
    ProductDto product;

    public AddProductToOrderDetail() {
    }

    public AddProductToOrderDetail(ProductDto product) {
        this.product = product;
    }

    public ProductDto getProduct() {
        return product;
    }

    public void setProduct(ProductDto product) {
        this.product = product;
    }
}
