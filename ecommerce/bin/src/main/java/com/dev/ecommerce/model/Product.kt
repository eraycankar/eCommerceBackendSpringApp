
package com.dev.ecommerce.model

import javax.persistence.*

@Entity
data class Product (
    @Id
    @Column(name = "productId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long?,
    val name: String?,
    val unitPrice: Double? = 0.0,

    @ManyToOne
    @JoinColumn(name = "ordersId")
    val orderDetail: OrderDetail?
)
