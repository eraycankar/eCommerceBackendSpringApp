package com.dev.ecommerce.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Orders {
    @Id
    @Column(name = "ordersId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    LocalDate creationDate;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "customerId")
    Customer customer;
    //val totalAmount: Double? = 0.0


    public Orders() {
    }

    public Orders(Long id, LocalDate creationDate, Customer customer) {
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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

}
