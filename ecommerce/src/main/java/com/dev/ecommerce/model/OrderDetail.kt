
package com.dev.ecommerce.model


import javax.persistence.*

@Entity
data class OrderDetail (
    @Id
    @Column(name = "orderDetailId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long?,

    @ManyToOne
    @JoinColumn(name = "ordersId")
    val orders: Orders?,

    @ManyToOne
    @JoinColumn(name = "productId")
    val product: Product?,

    //val quantity: Int = 0,
    //val subtotal: Double = 0.0
)
