package com.dev.ecommerce.dto;

import java.util.Objects;

public class CreateProductDto {
    String name;
    Double unitPrice = 0.0;

    public CreateProductDto() {
    }

    public CreateProductDto(String name, Double unitPrice) {
        this.name = name;
        this.unitPrice = unitPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreateProductDto that = (CreateProductDto) o;
        return Objects.equals(name, that.name) && Objects.equals(unitPrice, that.unitPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, unitPrice);
    }
}
