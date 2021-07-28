package com.dev.ecommerce.model;

import javax.persistence.*;


@Entity
public class OrderDetail {

    @Id
    @Column(name = "orderDetailId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @ManyToOne
    @JoinColumn(name = "ordersId")
    Orders orders;

    @ManyToOne
    @JoinColumn(name = "productId")
    Product product;

    //val quantity: Int = 0,
    //val subtotal: Double = 0.0


    public OrderDetail() {
    }

    public OrderDetail(Long id, Orders orders, Product product) {
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

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }


}
