package com.dev.ecommerce.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Product {
    @Id
    @Column(name = "productId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String name;
    Double unitPrice= 0.0;

    public Product() {
    }

    public Product(Long id, String name, Double unitPrice) {
        this.id = id;
        this.name = name;
        this.unitPrice = unitPrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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


}
