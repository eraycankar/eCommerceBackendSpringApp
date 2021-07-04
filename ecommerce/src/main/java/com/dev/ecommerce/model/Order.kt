package com.dev.ecommerce.model

import javax.persistence.*

@Entity
data class Order (
    @Id
    @Column(name = "orderId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long?,

   @ManyToMany(mappedBy = "order")
    val customer: Set<Customer>?,
    val totalAmount: Double? = 0.0
)
