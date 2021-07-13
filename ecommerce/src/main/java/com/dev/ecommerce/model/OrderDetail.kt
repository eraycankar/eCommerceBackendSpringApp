
package com.dev.ecommerce.model


import javax.persistence.*

@Entity
data class OrderDetail (
    @Id
    @Column(name = "orderDetailId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long?,

    @ManyToOne
    @JoinColumn(name = "ordersId")
    var orders: Orders?,

    @ManyToOne
    @JoinColumn(name = "productId")
    var product: Product?,

    //val quantity: Int = 0,
    //val subtotal: Double = 0.0
)
